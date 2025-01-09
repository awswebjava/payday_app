package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class facturas_anteriores extends GXProcedure
{
   public facturas_anteriores( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( facturas_anteriores.class ), "" );
   }

   public facturas_anteriores( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 ,
                                           int aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           int aP4 ,
                                           String aP5 ,
                                           java.util.Date aP6 )
   {
      facturas_anteriores.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      facturas_anteriores.this.AV22Operandos = aP0;
      facturas_anteriores.this.AV13CliCod = aP1;
      facturas_anteriores.this.AV24LiqRelNro = aP2;
      facturas_anteriores.this.AV8EmpCod = aP3;
      facturas_anteriores.this.AV10LegNumero = aP4;
      facturas_anteriores.this.AV11ConCodigo = aP5;
      facturas_anteriores.this.AV21fecha = aP6;
      facturas_anteriores.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20eneroFecha = localUtil.ymdtod( GXutil.year( AV21fecha), 1, 1) ;
      /* Optimized group. */
      /* Using cursor P00SX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV20eneroFecha, Integer.valueOf(AV24LiqRelNro), AV21fecha});
      c764LiqDImpReCalcu = P00SX2_A764LiqDImpReCalcu[0] ;
      pr_default.close(0);
      AV19LiqDImpReCalcu = AV19LiqDImpReCalcu.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = facturas_anteriores.this.AV19LiqDImpReCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV20eneroFecha = GXutil.nullDate() ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00SX2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.facturas_anteriores__default(),
         new Object[] {
             new Object[] {
            P00SX2_A764LiqDImpReCalcu
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV24LiqRelNro ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV19LiqDImpReCalcu ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private String AV22Operandos ;
   private String AV11ConCodigo ;
   private String scmdbuf ;
   private java.util.Date AV21fecha ;
   private java.util.Date AV20eneroFecha ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00SX2_A764LiqDImpReCalcu ;
}

final  class facturas_anteriores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SX2", "SELECT SUM(T1.LiqDImpReCalcu) FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro = ? or T2.LiqRelNro IS NULL) AND (T1.DLiqPeriodo < ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}

