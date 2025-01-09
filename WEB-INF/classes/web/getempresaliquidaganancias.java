package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresaliquidaganancias extends GXProcedure
{
   public getempresaliquidaganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresaliquidaganancias.class ), "" );
   }

   public getempresaliquidaganancias( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 )
   {
      getempresaliquidaganancias.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             boolean[] aP2 )
   {
      getempresaliquidaganancias.this.AV10CliCod = aP0;
      getempresaliquidaganancias.this.AV9EmpCod = aP1;
      getempresaliquidaganancias.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01MQ2_A1EmpCod[0] ;
         A3CliCod = P01MQ2_A3CliCod[0] ;
         A1787EmpLiqGan = P01MQ2_A1787EmpLiqGan[0] ;
         AV8EmpLiqGan = A1787EmpLiqGan ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresaliquidaganancias.this.AV8EmpLiqGan;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01MQ2_A1EmpCod = new short[1] ;
      P01MQ2_A3CliCod = new int[1] ;
      P01MQ2_A1787EmpLiqGan = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresaliquidaganancias__default(),
         new Object[] {
             new Object[] {
            P01MQ2_A1EmpCod, P01MQ2_A3CliCod, P01MQ2_A1787EmpLiqGan
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8EmpLiqGan ;
   private boolean A1787EmpLiqGan ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01MQ2_A1EmpCod ;
   private int[] P01MQ2_A3CliCod ;
   private boolean[] P01MQ2_A1787EmpLiqGan ;
}

final  class getempresaliquidaganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MQ2", "SELECT EmpCod, CliCod, EmpLiqGan FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

