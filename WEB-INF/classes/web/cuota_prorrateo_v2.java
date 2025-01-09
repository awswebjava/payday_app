package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cuota_prorrateo_v2 extends GXProcedure
{
   public cuota_prorrateo_v2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cuota_prorrateo_v2.class ), "" );
   }

   public cuota_prorrateo_v2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              boolean aP5 ,
                              java.math.BigDecimal aP6 ,
                              String aP7 ,
                              boolean aP8 ,
                              java.math.BigDecimal[] aP9 ,
                              String[] aP10 )
   {
      cuota_prorrateo_v2.this.aP11 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        java.math.BigDecimal aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        boolean[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             java.math.BigDecimal aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             boolean[] aP11 )
   {
      cuota_prorrateo_v2.this.AV10CliCod = aP0;
      cuota_prorrateo_v2.this.AV11EmpCod = aP1;
      cuota_prorrateo_v2.this.AV12LiqNro = aP2;
      cuota_prorrateo_v2.this.AV18LegNumero = aP3;
      cuota_prorrateo_v2.this.AV15LiqPeriodo = aP4;
      cuota_prorrateo_v2.this.AV32LiqLegEsPrrGan = aP5;
      cuota_prorrateo_v2.this.AV34cuotaImportes = aP6;
      cuota_prorrateo_v2.this.AV29ProcesoLiquidacion = aP7;
      cuota_prorrateo_v2.this.AV30insertandoConceptos = aP8;
      cuota_prorrateo_v2.this.aP9 = aP9;
      cuota_prorrateo_v2.this.aP10 = aP10;
      cuota_prorrateo_v2.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9TLiqCod ;
      GXv_char2[0] = GXt_char1 ;
      new web.gettipoliq(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, GXv_char2) ;
      cuota_prorrateo_v2.this.GXt_char1 = GXv_char2[0] ;
      AV9TLiqCod = GXt_char1 ;
      GXt_char1 = AV13egresoTLiqCod ;
      GXt_char3 = AV13egresoTLiqCod ;
      GXv_char2[0] = GXt_char3 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      cuota_prorrateo_v2.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char3, GXv_char4) ;
      cuota_prorrateo_v2.this.GXt_char1 = GXv_char4[0] ;
      AV13egresoTLiqCod = GXt_char1 ;
      GXt_char3 = AV14mensualTLiqCod ;
      GXt_char1 = AV14mensualTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      cuota_prorrateo_v2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char2) ;
      cuota_prorrateo_v2.this.GXt_char3 = GXv_char2[0] ;
      AV14mensualTLiqCod = GXt_char3 ;
      AV17LiqLegConAnio = (short)(GXutil.year( AV15LiqPeriodo)) ;
      GXv_int5[0] = AV23anteriorLiqNro ;
      new web.cuentaobtieneliquidacionanterior(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV17LiqLegConAnio, AV18LegNumero, AV12LiqNro, AV32LiqLegEsPrrGan, GXv_int5) ;
      cuota_prorrateo_v2.this.AV23anteriorLiqNro = GXv_int5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "1 ") ;
      /* Using cursor P017G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Short.valueOf(AV17LiqLegConAnio), Integer.valueOf(AV18LegNumero), Integer.valueOf(AV23anteriorLiqNro), Boolean.valueOf(AV32LiqLegEsPrrGan)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1778LiqLegEsPrrGan = P017G2_A1778LiqLegEsPrrGan[0] ;
         A1098LiqNuevaNro = P017G2_A1098LiqNuevaNro[0] ;
         A6LegNumero = P017G2_A6LegNumero[0] ;
         A869LiqLegConAnio = P017G2_A869LiqLegConAnio[0] ;
         A1EmpCod = P017G2_A1EmpCod[0] ;
         A3CliCod = P017G2_A3CliCod[0] ;
         A26ConCodigo = P017G2_A26ConCodigo[0] ;
         A1097LiqAltaNro = P017G2_A1097LiqAltaNro[0] ;
         A888LiqLegCodigo = P017G2_A888LiqLegCodigo[0] ;
         n888LiqLegCodigo = P017G2_n888LiqLegCodigo[0] ;
         GXv_decimal6[0] = AV28LiqLegConSaldo ;
         GXv_char4[0] = AV27calculoLiqDLog ;
         new web.calcularsaldoinicialprorrateo(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, A869LiqLegConAnio, AV18LegNumero, A26ConCodigo, A1097LiqAltaNro, A1098LiqNuevaNro, A1778LiqLegEsPrrGan, GXv_decimal6, GXv_char4) ;
         cuota_prorrateo_v2.this.AV28LiqLegConSaldo = GXv_decimal6[0] ;
         cuota_prorrateo_v2.this.AV27calculoLiqDLog = GXv_char4[0] ;
         AV20LiqDLog += httpContext.getMessage( ". Saldo inicial: ", "") + GXutil.trim( GXutil.str( AV28LiqLegConSaldo, 14, 2)) + " (" + GXutil.trim( AV27calculoLiqDLog) + ")" ;
         if ( GXutil.strcmp(GXutil.trim( AV9TLiqCod), GXutil.trim( AV13egresoTLiqCod)) == 0 )
         {
            AV26LiqLegCuota = AV28LiqLegConSaldo ;
            AV28LiqLegConSaldo = DecimalUtil.doubleToDec(0) ;
            AV20LiqDLog += httpContext.getMessage( ". Por ser liquidación de egreso se asigna el saldo al valor de la cuota", "") ;
         }
         else
         {
            if ( AV32LiqLegEsPrrGan )
            {
               AV33tipo_cuota = "FIJA" ;
            }
            else
            {
               AV33tipo_cuota = "VAR" ;
            }
            GXv_decimal6[0] = AV24nuevo_LiqLegConSaldo ;
            GXv_char4[0] = AV25nuevoLiqDLog ;
            GXv_decimal7[0] = AV26LiqLegCuota ;
            new web.calcularprorrateo(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV18LegNumero, AV15LiqPeriodo, AV28LiqLegConSaldo, A26ConCodigo, AV33tipo_cuota, AV34cuotaImportes, GXv_decimal6, GXv_char4, GXv_decimal7) ;
            cuota_prorrateo_v2.this.AV24nuevo_LiqLegConSaldo = GXv_decimal6[0] ;
            cuota_prorrateo_v2.this.AV25nuevoLiqDLog = GXv_char4[0] ;
            cuota_prorrateo_v2.this.AV26LiqLegCuota = GXv_decimal7[0] ;
         }
         GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
         new web.newcuentaliqleg(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV17LiqLegConAnio, A1097LiqAltaNro, AV12LiqNro, AV18LegNumero, A26ConCodigo, A888LiqLegCodigo, AV24nuevo_LiqLegConSaldo, AV26LiqLegCuota, AV15LiqPeriodo, false, A1778LiqLegEsPrrGan, AV29ProcesoLiquidacion, GXv_decimal7) ;
         AV20LiqDLog += httpContext.getMessage( ". Crea registro de nueva cuota ", "") + GXutil.trim( GXutil.str( AV26LiqLegCuota, 14, 2)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&LiqDLog  ", "")+AV20LiqDLog) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = cuota_prorrateo_v2.this.AV16Importes;
      this.aP10[0] = cuota_prorrateo_v2.this.AV20LiqDLog;
      this.aP11[0] = cuota_prorrateo_v2.this.AV31tiene_cuotas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Importes = DecimalUtil.ZERO ;
      AV20LiqDLog = "" ;
      AV9TLiqCod = "" ;
      AV13egresoTLiqCod = "" ;
      AV14mensualTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_int5 = new int[1] ;
      AV37Pgmname = "" ;
      scmdbuf = "" ;
      P017G2_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P017G2_A1098LiqNuevaNro = new int[1] ;
      P017G2_A6LegNumero = new int[1] ;
      P017G2_A869LiqLegConAnio = new short[1] ;
      P017G2_A1EmpCod = new short[1] ;
      P017G2_A3CliCod = new int[1] ;
      P017G2_A26ConCodigo = new String[] {""} ;
      P017G2_A1097LiqAltaNro = new int[1] ;
      P017G2_A888LiqLegCodigo = new short[1] ;
      P017G2_n888LiqLegCodigo = new boolean[] {false} ;
      A26ConCodigo = "" ;
      AV28LiqLegConSaldo = DecimalUtil.ZERO ;
      AV27calculoLiqDLog = "" ;
      AV26LiqLegCuota = DecimalUtil.ZERO ;
      AV33tipo_cuota = "" ;
      AV24nuevo_LiqLegConSaldo = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV25nuevoLiqDLog = "" ;
      GXv_char4 = new String[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cuota_prorrateo_v2__default(),
         new Object[] {
             new Object[] {
            P017G2_A1778LiqLegEsPrrGan, P017G2_A1098LiqNuevaNro, P017G2_A6LegNumero, P017G2_A869LiqLegConAnio, P017G2_A1EmpCod, P017G2_A3CliCod, P017G2_A26ConCodigo, P017G2_A1097LiqAltaNro, P017G2_A888LiqLegCodigo, P017G2_n888LiqLegCodigo
            }
         }
      );
      AV37Pgmname = "cuota_prorrateo_v2" ;
      /* GeneXus formulas. */
      AV37Pgmname = "cuota_prorrateo_v2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private short AV11EmpCod ;
   private short AV17LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short A888LiqLegCodigo ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV18LegNumero ;
   private int AV23anteriorLiqNro ;
   private int GXv_int5[] ;
   private int A1098LiqNuevaNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private java.math.BigDecimal AV34cuotaImportes ;
   private java.math.BigDecimal AV16Importes ;
   private java.math.BigDecimal AV28LiqLegConSaldo ;
   private java.math.BigDecimal AV26LiqLegCuota ;
   private java.math.BigDecimal AV24nuevo_LiqLegConSaldo ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV29ProcesoLiquidacion ;
   private String AV9TLiqCod ;
   private String AV13egresoTLiqCod ;
   private String AV14mensualTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV37Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV33tipo_cuota ;
   private String GXv_char4[] ;
   private java.util.Date AV15LiqPeriodo ;
   private boolean AV32LiqLegEsPrrGan ;
   private boolean AV30insertandoConceptos ;
   private boolean AV31tiene_cuotas ;
   private boolean A1778LiqLegEsPrrGan ;
   private boolean n888LiqLegCodigo ;
   private String AV20LiqDLog ;
   private String AV27calculoLiqDLog ;
   private String AV25nuevoLiqDLog ;
   private boolean[] aP11 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P017G2_A1778LiqLegEsPrrGan ;
   private int[] P017G2_A1098LiqNuevaNro ;
   private int[] P017G2_A6LegNumero ;
   private short[] P017G2_A869LiqLegConAnio ;
   private short[] P017G2_A1EmpCod ;
   private int[] P017G2_A3CliCod ;
   private String[] P017G2_A26ConCodigo ;
   private int[] P017G2_A1097LiqAltaNro ;
   private short[] P017G2_A888LiqLegCodigo ;
   private boolean[] P017G2_n888LiqLegCodigo ;
}

final  class cuota_prorrateo_v2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017G2", "SELECT LiqLegEsPrrGan, LiqNuevaNro, LegNumero, LiqLegConAnio, EmpCod, CliCod, ConCodigo, LiqAltaNro, LiqLegCodigo FROM LiqLegConceptoCuenta WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ?) AND (LiqNuevaNro = ?) AND (LiqLegEsPrrGan = ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
      }
   }

}

