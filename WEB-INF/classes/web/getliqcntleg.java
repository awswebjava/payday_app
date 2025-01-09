package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqcntleg extends GXProcedure
{
   public getliqcntleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqcntleg.class ), "" );
   }

   public getliqcntleg( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getliqcntleg.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      getliqcntleg.this.AV11CliCod = aP0;
      getliqcntleg.this.AV10EmpCod = aP1;
      getliqcntleg.this.AV9LiqNro = aP2;
      getliqcntleg.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02JP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02JP2_A31LiqNro[0] ;
         A1EmpCod = P02JP2_A1EmpCod[0] ;
         A3CliCod = P02JP2_A3CliCod[0] ;
         A495LiqCntLeg = P02JP2_A495LiqCntLeg[0] ;
         AV8LiqCntLeg = A495LiqCntLeg ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqcntleg.this.AV8LiqCntLeg;
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
      P02JP2_A31LiqNro = new int[1] ;
      P02JP2_A1EmpCod = new short[1] ;
      P02JP2_A3CliCod = new int[1] ;
      P02JP2_A495LiqCntLeg = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqcntleg__default(),
         new Object[] {
             new Object[] {
            P02JP2_A31LiqNro, P02JP2_A1EmpCod, P02JP2_A3CliCod, P02JP2_A495LiqCntLeg
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8LiqCntLeg ;
   private short A1EmpCod ;
   private short A495LiqCntLeg ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02JP2_A31LiqNro ;
   private short[] P02JP2_A1EmpCod ;
   private int[] P02JP2_A3CliCod ;
   private short[] P02JP2_A495LiqCntLeg ;
}

final  class getliqcntleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JP2", "SELECT LiqNro, EmpCod, CliCod, LiqCntLeg FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

