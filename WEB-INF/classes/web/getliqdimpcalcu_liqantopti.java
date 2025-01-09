package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcu_liqantopti extends GXProcedure
{
   public getliqdimpcalcu_liqantopti( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcu_liqantopti.class ), "" );
   }

   public getliqdimpcalcu_liqantopti( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           java.util.Date aP5 ,
                                           String aP6 )
   {
      getliqdimpcalcu_liqantopti.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      getliqdimpcalcu_liqantopti.this.AV8CliCod = aP0;
      getliqdimpcalcu_liqantopti.this.AV10EmpCod = aP1;
      getliqdimpcalcu_liqantopti.this.AV14LiqNro = aP2;
      getliqdimpcalcu_liqantopti.this.AV12LegNumero = aP3;
      getliqdimpcalcu_liqantopti.this.AV16desdeFecha = aP4;
      getliqdimpcalcu_liqantopti.this.AV17hastaFecha = aP5;
      getliqdimpcalcu_liqantopti.this.AV9ConCodigo = aP6;
      getliqdimpcalcu_liqantopti.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P028T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV12LegNumero), AV9ConCodigo, AV16desdeFecha, Integer.valueOf(AV14LiqNro), AV17hastaFecha});
      c764LiqDImpReCalcu = P028T2_A764LiqDImpReCalcu[0] ;
      pr_default.close(0);
      AV13LiqDImpCalcu = AV13LiqDImpCalcu.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getliqdimpcalcu_liqantopti.this.AV13LiqDImpCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LiqDImpCalcu = DecimalUtil.ZERO ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P028T2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcu_liqantopti__default(),
         new Object[] {
             new Object[] {
            P028T2_A764LiqDImpReCalcu
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14LiqNro ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV13LiqDImpCalcu ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private java.util.Date AV16desdeFecha ;
   private java.util.Date AV17hastaFecha ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P028T2_A764LiqDImpReCalcu ;
}

final  class getliqdimpcalcu_liqantopti__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028T2", "SELECT SUM(T1.LiqDImpReCalcu) FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL) AND (T1.LiqNro < ?) AND (T1.DLiqPeriodo <= ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

