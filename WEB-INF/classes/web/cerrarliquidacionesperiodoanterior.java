package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cerrarliquidacionesperiodoanterior extends GXProcedure
{
   public cerrarliquidacionesperiodoanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cerrarliquidacionesperiodoanterior.class ), "" );
   }

   public cerrarliquidacionesperiodoanterior( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 )
   {
      cerrarliquidacionesperiodoanterior.this.AV11CliCod = aP0;
      cerrarliquidacionesperiodoanterior.this.AV8EmpCod = aP1;
      cerrarliquidacionesperiodoanterior.this.AV9LiqPeriodo = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_date1 = AV10anteriorLiqPeriodo ;
      GXv_date2[0] = GXt_date1 ;
      new web.periodoanterior(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LiqPeriodo, GXv_date2) ;
      cerrarliquidacionesperiodoanterior.this.GXt_date1 = GXv_date2[0] ;
      AV10anteriorLiqPeriodo = GXt_date1 ;
      /* Using cursor P00SI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), AV10anteriorLiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A278LiqEstado = P00SI2_A278LiqEstado[0] ;
         A283LiqPeriodo = P00SI2_A283LiqPeriodo[0] ;
         A1EmpCod = P00SI2_A1EmpCod[0] ;
         A3CliCod = P00SI2_A3CliCod[0] ;
         A31LiqNro = P00SI2_A31LiqNro[0] ;
         new web.setliqestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, (byte)(4)) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10anteriorLiqPeriodo = GXutil.nullDate() ;
      GXt_date1 = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      scmdbuf = "" ;
      P00SI2_A278LiqEstado = new byte[1] ;
      P00SI2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00SI2_A1EmpCod = new short[1] ;
      P00SI2_A3CliCod = new int[1] ;
      P00SI2_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cerrarliquidacionesperiodoanterior__default(),
         new Object[] {
             new Object[] {
            P00SI2_A278LiqEstado, P00SI2_A283LiqPeriodo, P00SI2_A1EmpCod, P00SI2_A3CliCod, P00SI2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A278LiqEstado ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private java.util.Date AV9LiqPeriodo ;
   private java.util.Date AV10anteriorLiqPeriodo ;
   private java.util.Date GXt_date1 ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date A283LiqPeriodo ;
   private IDataStoreProvider pr_default ;
   private byte[] P00SI2_A278LiqEstado ;
   private java.util.Date[] P00SI2_A283LiqPeriodo ;
   private short[] P00SI2_A1EmpCod ;
   private int[] P00SI2_A3CliCod ;
   private int[] P00SI2_A31LiqNro ;
}

final  class cerrarliquidacionesperiodoanterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SI2", "SELECT LiqEstado, LiqPeriodo, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and LiqPeriodo = ?) AND (LiqEstado <> 4 and LiqEstado <> 2) ORDER BY CliCod, EmpCod, LiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

