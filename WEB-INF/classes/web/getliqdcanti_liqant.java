package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdcanti_liqant extends GXProcedure
{
   public getliqdcanti_liqant( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdcanti_liqant.class ), "" );
   }

   public getliqdcanti_liqant( int remoteHandle ,
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
                                           String aP5 )
   {
      getliqdcanti_liqant.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      getliqdcanti_liqant.this.AV13CliCod = aP0;
      getliqdcanti_liqant.this.AV8EmpCod = aP1;
      getliqdcanti_liqant.this.AV9LiqNro = aP2;
      getliqdcanti_liqant.this.AV10LegNumero = aP3;
      getliqdcanti_liqant.this.AV18LiqPeriodo = aP4;
      getliqdcanti_liqant.this.AV11ConCodigo = aP5;
      getliqdcanti_liqant.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P014M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, Integer.valueOf(AV9LiqNro)});
      c269LiqDCanti = P014M2_A269LiqDCanti[0] ;
      n269LiqDCanti = P014M2_n269LiqDCanti[0] ;
      pr_default.close(0);
      AV19LiqDCanti = AV19LiqDCanti.add(c269LiqDCanti) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getliqdcanti_liqant.this.AV19LiqDCanti;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19LiqDCanti = DecimalUtil.ZERO ;
      c269LiqDCanti = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P014M2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014M2_n269LiqDCanti = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdcanti_liqant__default(),
         new Object[] {
             new Object[] {
            P014M2_A269LiqDCanti, P014M2_n269LiqDCanti
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV19LiqDCanti ;
   private java.math.BigDecimal c269LiqDCanti ;
   private String AV11ConCodigo ;
   private String scmdbuf ;
   private java.util.Date AV18LiqPeriodo ;
   private boolean n269LiqDCanti ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P014M2_A269LiqDCanti ;
   private boolean[] P014M2_n269LiqDCanti ;
}

final  class getliqdcanti_liqant__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014M2", "SELECT SUM(LiqDCanti) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (LiqNro <= ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               return;
      }
   }

}

