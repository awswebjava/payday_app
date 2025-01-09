package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoultliq extends GXProcedure
{
   public getperiodoultliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoultliq.class ), "" );
   }

   public getperiodoultliq( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short[] aP2 )
   {
      getperiodoultliq.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      getperiodoultliq.this.AV10CliCod = aP0;
      getperiodoultliq.this.AV11EmpCod = aP1;
      getperiodoultliq.this.aP2 = aP2;
      getperiodoultliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P005M2_A1EmpCod[0] ;
         A3CliCod = P005M2_A3CliCod[0] ;
         A283LiqPeriodo = P005M2_A283LiqPeriodo[0] ;
         A31LiqNro = P005M2_A31LiqNro[0] ;
         AV8Anio = (short)(GXutil.year( A283LiqPeriodo)) ;
         AV9Mes = (short)(GXutil.month( A283LiqPeriodo)) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getperiodoultliq.this.AV8Anio;
      this.aP3[0] = getperiodoultliq.this.AV9Mes;
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
      P005M2_A1EmpCod = new short[1] ;
      P005M2_A3CliCod = new int[1] ;
      P005M2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P005M2_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoultliq__default(),
         new Object[] {
             new Object[] {
            P005M2_A1EmpCod, P005M2_A3CliCod, P005M2_A283LiqPeriodo, P005M2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV8Anio ;
   private short AV9Mes ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private java.util.Date A283LiqPeriodo ;
   private short[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P005M2_A1EmpCod ;
   private int[] P005M2_A3CliCod ;
   private java.util.Date[] P005M2_A283LiqPeriodo ;
   private int[] P005M2_A31LiqNro ;
}

final  class getperiodoultliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005M2", "SELECT EmpCod, CliCod, LiqPeriodo, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LiqPeriodo DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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

