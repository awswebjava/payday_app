package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculaimportesliqlegrecibo extends GXProcedure
{
   public calculaimportesliqlegrecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculaimportesliqlegrecibo.class ), "" );
   }

   public calculaimportesliqlegrecibo( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           String aP4 ,
                                           String aP5 ,
                                           String aP6 ,
                                           java.math.BigDecimal[] aP7 ,
                                           java.math.BigDecimal[] aP8 ,
                                           java.math.BigDecimal[] aP9 )
   {
      calculaimportesliqlegrecibo.this.aP10 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 )
   {
      calculaimportesliqlegrecibo.this.AV22CliCod = aP0;
      calculaimportesliqlegrecibo.this.AV25EmpCod = aP1;
      calculaimportesliqlegrecibo.this.AV34LiqNro = aP2;
      calculaimportesliqlegrecibo.this.AV27LegNumero = aP3;
      calculaimportesliqlegrecibo.this.AV37remuTipoConCod = aP4;
      calculaimportesliqlegrecibo.this.AV35noRemuTipoConCod = aP5;
      calculaimportesliqlegrecibo.this.AV23descuTipoConCod = aP6;
      calculaimportesliqlegrecibo.this.aP7 = aP7;
      calculaimportesliqlegrecibo.this.aP8 = aP8;
      calculaimportesliqlegrecibo.this.aP9 = aP9;
      calculaimportesliqlegrecibo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02JE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV22CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV34LiqNro), Integer.valueOf(AV27LegNumero), AV23descuTipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A464DTipoConCod = P02JE2_A464DTipoConCod[0] ;
         A6LegNumero = P02JE2_A6LegNumero[0] ;
         A31LiqNro = P02JE2_A31LiqNro[0] ;
         A1EmpCod = P02JE2_A1EmpCod[0] ;
         A3CliCod = P02JE2_A3CliCod[0] ;
         A764LiqDImpReCalcu = P02JE2_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P02JE2_A81LiqDSecuencial[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV22CliCod, AV46Pgmname, httpContext.getMessage( "cerea &DetColumna1", "")) ;
         if ( A764LiqDImpReCalcu.doubleValue() < 0 )
         {
            AV42descuentosNegativos = AV42descuentosNegativos.add((A764LiqDImpReCalcu.multiply(DecimalUtil.doubleToDec(-1)))) ;
         }
         else
         {
            AV32LiqLegImpTotDescu = AV32LiqLegImpTotDescu.add(A764LiqDImpReCalcu) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Optimized group. */
      /* Using cursor P02JE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV22CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV34LiqNro), Integer.valueOf(AV27LegNumero), AV35noRemuTipoConCod});
      c764LiqDImpReCalcu = P02JE3_A764LiqDImpReCalcu[0] ;
      pr_default.close(1);
      AV33LiqLegImpTotNoRemu = AV33LiqLegImpTotNoRemu.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      /* Optimized group. */
      /* Using cursor P02JE4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV22CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV34LiqNro), Integer.valueOf(AV27LegNumero), AV37remuTipoConCod});
      c764LiqDImpReCalcu = P02JE4_A764LiqDImpReCalcu[0] ;
      pr_default.close(2);
      AV13LiqLegImpTotRemu = AV13LiqLegImpTotRemu.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = calculaimportesliqlegrecibo.this.AV42descuentosNegativos;
      this.aP8[0] = calculaimportesliqlegrecibo.this.AV13LiqLegImpTotRemu;
      this.aP9[0] = calculaimportesliqlegrecibo.this.AV33LiqLegImpTotNoRemu;
      this.aP10[0] = calculaimportesliqlegrecibo.this.AV32LiqLegImpTotDescu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV42descuentosNegativos = DecimalUtil.ZERO ;
      AV13LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV33LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV32LiqLegImpTotDescu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02JE2_A464DTipoConCod = new String[] {""} ;
      P02JE2_A6LegNumero = new int[1] ;
      P02JE2_A31LiqNro = new int[1] ;
      P02JE2_A1EmpCod = new short[1] ;
      P02JE2_A3CliCod = new int[1] ;
      P02JE2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02JE2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV46Pgmname = "" ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P02JE3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02JE4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculaimportesliqlegrecibo__default(),
         new Object[] {
             new Object[] {
            P02JE2_A464DTipoConCod, P02JE2_A6LegNumero, P02JE2_A31LiqNro, P02JE2_A1EmpCod, P02JE2_A3CliCod, P02JE2_A764LiqDImpReCalcu, P02JE2_A81LiqDSecuencial
            }
            , new Object[] {
            P02JE3_A764LiqDImpReCalcu
            }
            , new Object[] {
            P02JE4_A764LiqDImpReCalcu
            }
         }
      );
      AV46Pgmname = "CalculaImportesLiqLegRecibo" ;
      /* GeneXus formulas. */
      AV46Pgmname = "CalculaImportesLiqLegRecibo" ;
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV22CliCod ;
   private int AV34LiqNro ;
   private int AV27LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV42descuentosNegativos ;
   private java.math.BigDecimal AV13LiqLegImpTotRemu ;
   private java.math.BigDecimal AV33LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV32LiqLegImpTotDescu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private String AV37remuTipoConCod ;
   private String AV35noRemuTipoConCod ;
   private String AV23descuTipoConCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String AV46Pgmname ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P02JE2_A464DTipoConCod ;
   private int[] P02JE2_A6LegNumero ;
   private int[] P02JE2_A31LiqNro ;
   private short[] P02JE2_A1EmpCod ;
   private int[] P02JE2_A3CliCod ;
   private java.math.BigDecimal[] P02JE2_A764LiqDImpReCalcu ;
   private int[] P02JE2_A81LiqDSecuencial ;
   private java.math.BigDecimal[] P02JE3_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P02JE4_A764LiqDImpReCalcu ;
}

final  class calculaimportesliqlegrecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JE2", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02JE3", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02JE4", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 2 :
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

