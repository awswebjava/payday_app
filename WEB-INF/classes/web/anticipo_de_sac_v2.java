package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class anticipo_de_sac_v2 extends GXProcedure
{
   public anticipo_de_sac_v2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( anticipo_de_sac_v2.class ), "" );
   }

   public anticipo_de_sac_v2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      anticipo_de_sac_v2.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      anticipo_de_sac_v2.this.AV13CliCod = aP0;
      anticipo_de_sac_v2.this.AV12EmpCod = aP1;
      anticipo_de_sac_v2.this.AV17LiqNro = aP2;
      anticipo_de_sac_v2.this.AV51LiqRelNro = aP3;
      anticipo_de_sac_v2.this.AV11LegNumero = aP4;
      anticipo_de_sac_v2.this.AV10LiqPeriodo = aP5;
      anticipo_de_sac_v2.this.AV39ConCodigo = aP6;
      anticipo_de_sac_v2.this.AV14ProcesoLiquidacion = aP7;
      anticipo_de_sac_v2.this.AV49insertandoConceptos = aP8;
      anticipo_de_sac_v2.this.aP9 = aP9;
      anticipo_de_sac_v2.this.aP10 = aP10;
      anticipo_de_sac_v2.this.aP11 = aP11;
      anticipo_de_sac_v2.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21LiqDCalculado = (byte)(1) ;
      GXv_decimal1[0] = AV9piso_ganancias_SAC_real ;
      GXv_char2[0] = AV52auxError ;
      new web.pisogananciassacreal(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, AV10LiqPeriodo, AV37ActualLiqPeriodo, AV14ProcesoLiquidacion, GXv_decimal1, GXv_char2) ;
      anticipo_de_sac_v2.this.AV9piso_ganancias_SAC_real = GXv_decimal1[0] ;
      anticipo_de_sac_v2.this.AV52auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV52auxError)==0) )
      {
         AV21LiqDCalculado = (byte)(0) ;
         AV22error = AV52auxError ;
         AV23LiqDLog = AV22error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char3 = AV18calcuSacProxEstimaConCodigo ;
      GXt_char4 = AV18calcuSacProxEstimaConCodigo ;
      GXv_char2[0] = GXt_char4 ;
      new web.concepto_sacproximo_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      anticipo_de_sac_v2.this.GXt_char4 = GXv_char2[0] ;
      GXv_char5[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char4, GXv_char5) ;
      anticipo_de_sac_v2.this.GXt_char3 = GXv_char5[0] ;
      AV18calcuSacProxEstimaConCodigo = GXt_char3 ;
      GXv_decimal1[0] = AV16calculoSacProxEstimaLiqDImpCalcu ;
      GXv_boolean6[0] = AV19existe ;
      GXv_int7[0] = AV20proxSacLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV17LiqNro, AV11LegNumero, AV18calcuSacProxEstimaConCodigo, AV14ProcesoLiquidacion, AV49insertandoConceptos, GXv_decimal1, GXv_boolean6, GXv_int7) ;
      anticipo_de_sac_v2.this.AV16calculoSacProxEstimaLiqDImpCalcu = GXv_decimal1[0] ;
      anticipo_de_sac_v2.this.AV19existe = GXv_boolean6[0] ;
      anticipo_de_sac_v2.this.AV20proxSacLiqDCalculado = GXv_int7[0] ;
      if ( ( AV20proxSacLiqDCalculado == 0 ) && ( AV19existe ) )
      {
         AV21LiqDCalculado = (byte)(0) ;
         AV22error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV18calcuSacProxEstimaConCodigo) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char4 = AV33brutoSinSacConCodigo ;
      GXt_char3 = AV33brutoSinSacConCodigo ;
      GXv_char5[0] = GXt_char3 ;
      new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      anticipo_de_sac_v2.this.GXt_char3 = GXv_char5[0] ;
      GXv_char2[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char3, GXv_char2) ;
      anticipo_de_sac_v2.this.GXt_char4 = GXv_char2[0] ;
      AV33brutoSinSacConCodigo = GXt_char4 ;
      GXv_decimal1[0] = AV8promedioDeBrutoSinSacSemestre ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_boolean6[0] = false ;
      GXv_int9[0] = AV36cantidadPeriodos ;
      GXv_int7[0] = AV34promedioLiqDCalculado ;
      GXv_boolean10[0] = false ;
      GXv_char5[0] = AV35promedioError ;
      new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV17LiqNro, AV51LiqRelNro, AV11LegNumero, AV33brutoSinSacConCodigo, AV50ConceptoTipo, AV38Date, AV10LiqPeriodo, AV39ConCodigo, AV14ProcesoLiquidacion, true, true, "", true, "", GXv_decimal1, GXv_decimal8, GXv_boolean6, GXv_int9, GXv_int7, GXv_boolean10, GXv_char5) ;
      anticipo_de_sac_v2.this.AV8promedioDeBrutoSinSacSemestre = GXv_decimal1[0] ;
      anticipo_de_sac_v2.this.AV36cantidadPeriodos = GXv_int9[0] ;
      anticipo_de_sac_v2.this.AV34promedioLiqDCalculado = GXv_int7[0] ;
      anticipo_de_sac_v2.this.AV35promedioError = GXv_char5[0] ;
      if ( AV34promedioLiqDCalculado == 0 )
      {
         AV21LiqDCalculado = (byte)(0) ;
         AV22error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV33brutoSinSacConCodigo) ;
         if ( ! (GXutil.strcmp("", AV35promedioError)==0) )
         {
            AV22error += " (" + GXutil.trim( AV35promedioError) + ")" ;
         }
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8promedioDeBrutoSinSacSemestre = AV8promedioDeBrutoSinSacSemestre.divide(DecimalUtil.doubleToDec(AV36cantidadPeriodos), 18, java.math.RoundingMode.DOWN) ;
      if ( DecimalUtil.compareTo(AV8promedioDeBrutoSinSacSemestre, AV9piso_ganancias_SAC_real) > 0 )
      {
         AV15Importes = AV16calculoSacProxEstimaLiqDImpCalcu ;
         AV23LiqDLog = httpContext.getMessage( "Inicializa valor con el cálculo de la estimación del próximo SAC ", "") + GXutil.trim( GXutil.str( AV16calculoSacProxEstimaLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " (concepto ", "") + GXutil.trim( AV18calcuSacProxEstimaConCodigo) + httpContext.getMessage( ") por ser el promedio de las remuneraciones brutas sin SAC", "") ;
         if ( AV36cantidadPeriodos > 1 )
         {
            AV23LiqDLog += httpContext.getMessage( " de los ", "") + GXutil.trim( GXutil.str( AV36cantidadPeriodos, 4, 0)) + httpContext.getMessage( " meses ", "") ;
         }
         AV23LiqDLog += " " + GXutil.trim( GXutil.str( AV8promedioDeBrutoSinSacSemestre, 14, 2)) + httpContext.getMessage( " mayor al piso de ganancias para SAC ", "") + GXutil.trim( GXutil.str( AV9piso_ganancias_SAC_real, 14, 2)) ;
      }
      else
      {
         AV24mitadPisoGanancias = (AV9piso_ganancias_SAC_real.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN)) ;
         if ( DecimalUtil.compareTo(AV16calculoSacProxEstimaLiqDImpCalcu, AV24mitadPisoGanancias) > 0 )
         {
            AV15Importes = AV16calculoSacProxEstimaLiqDImpCalcu.subtract(AV24mitadPisoGanancias) ;
            AV23LiqDLog = httpContext.getMessage( "Anticipo de SAC parcialmente exento. Inicializa valor con la diferencia entre el cálculo de la estimación del próximo SAC ", "") + GXutil.trim( GXutil.str( AV16calculoSacProxEstimaLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " (concepto ", "") + GXutil.trim( AV18calcuSacProxEstimaConCodigo) + httpContext.getMessage( ") y la mitad del piso de ganancias para SAC ", "") + GXutil.trim( GXutil.str( AV24mitadPisoGanancias, 14, 2)) + httpContext.getMessage( ") por ser el promedio de las remuneraciones brutas sin SAC de los ", "") + GXutil.trim( GXutil.str( AV36cantidadPeriodos, 4, 0)) + httpContext.getMessage( " meses ", "") + GXutil.trim( GXutil.str( AV8promedioDeBrutoSinSacSemestre, 14, 2)) + httpContext.getMessage( " menor o igual al piso de ganancias para SAC ", "") + GXutil.trim( GXutil.str( AV9piso_ganancias_SAC_real, 14, 2)) + httpContext.getMessage( " y la estimación del SAC mayor a la mitad del piso de ganancias para SAC ", "") + GXutil.trim( GXutil.str( AV24mitadPisoGanancias, 14, 2)) ;
         }
         else
         {
            AV23LiqDLog = httpContext.getMessage( "Anticipo de SAC totalmente exento por ser la estimación del próximo SAC ", "") + GXutil.trim( GXutil.str( AV16calculoSacProxEstimaLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " (concepto ", "") + GXutil.trim( AV18calcuSacProxEstimaConCodigo) + httpContext.getMessage( ") menor o igual a la mitad del piso de ganancias para SAC ", "") + GXutil.trim( GXutil.str( AV24mitadPisoGanancias, 14, 2)) ;
         }
      }
      AV48proximoEstimadoImportes = AV15Importes ;
      if ( AV15Importes.doubleValue() > 0 )
      {
         GXt_char4 = AV25sacLiquidadoPeriodoConCOdigo ;
         GXt_char3 = AV25sacLiquidadoPeriodoConCOdigo ;
         GXv_char5[0] = GXt_char3 ;
         new web.concepto_sacliquidadoperiodo_codigoparam(remoteHandle, context).execute( GXv_char5) ;
         anticipo_de_sac_v2.this.GXt_char3 = GXv_char5[0] ;
         GXv_char2[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char3, GXv_char2) ;
         anticipo_de_sac_v2.this.GXt_char4 = GXv_char2[0] ;
         AV25sacLiquidadoPeriodoConCOdigo = GXt_char4 ;
         GXv_decimal8[0] = AV26sacLiqPerLiqDImpCalcu ;
         GXv_boolean10[0] = AV19existe ;
         GXv_int7[0] = AV27sacLiqPerLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV17LiqNro, AV11LegNumero, AV25sacLiquidadoPeriodoConCOdigo, AV14ProcesoLiquidacion, AV49insertandoConceptos, GXv_decimal8, GXv_boolean10, GXv_int7) ;
         anticipo_de_sac_v2.this.AV26sacLiqPerLiqDImpCalcu = GXv_decimal8[0] ;
         anticipo_de_sac_v2.this.AV19existe = GXv_boolean10[0] ;
         anticipo_de_sac_v2.this.AV27sacLiqPerLiqDCalculado = GXv_int7[0] ;
         if ( ( AV27sacLiqPerLiqDCalculado == 0 ) && ( AV19existe ) )
         {
            AV21LiqDCalculado = (byte)(0) ;
            AV22error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV25sacLiquidadoPeriodoConCOdigo) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV32anticipoSacConCodigo ;
         GXt_char3 = AV32anticipoSacConCodigo ;
         GXv_char5[0] = GXt_char3 ;
         new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
         anticipo_de_sac_v2.this.GXt_char3 = GXv_char5[0] ;
         GXv_char2[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char3, GXv_char2) ;
         anticipo_de_sac_v2.this.GXt_char4 = GXv_char2[0] ;
         AV32anticipoSacConCodigo = GXt_char4 ;
         GXv_decimal8[0] = AV31anterioresLiqDImpCalcu ;
         GXv_decimal1[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean10[0] = false ;
         GXv_int9[0] = (short)(0) ;
         GXv_int7[0] = (byte)(0) ;
         GXv_boolean6[0] = false ;
         GXv_char5[0] = "" ;
         new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV17LiqNro, AV51LiqRelNro, AV11LegNumero, AV32anticipoSacConCodigo, AV50ConceptoTipo, AV38Date, AV10LiqPeriodo, AV39ConCodigo, AV14ProcesoLiquidacion, true, false, "", false, "", GXv_decimal8, GXv_decimal1, GXv_boolean10, GXv_int9, GXv_int7, GXv_boolean6, GXv_char5) ;
         anticipo_de_sac_v2.this.AV31anterioresLiqDImpCalcu = GXv_decimal8[0] ;
         if ( AV31anterioresLiqDImpCalcu.doubleValue() > 0 )
         {
            AV15Importes = AV15Importes.subtract(AV31anterioresLiqDImpCalcu) ;
            AV23LiqDLog += httpContext.getMessage( ". Le resta los anticipos de SAC anteriores acumulados del semestre ", "") + GXutil.trim( GXutil.str( AV31anterioresLiqDImpCalcu, 14, 2)) ;
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26sacLiqPerLiqDImpCalcu)==0) )
         {
            if ( GXutil.month( AV10LiqPeriodo) <= 6 )
            {
               AV47tantosMeses = (short)(6-GXutil.month( AV10LiqPeriodo)) ;
            }
            else
            {
               AV47tantosMeses = (short)(12-GXutil.month( AV10LiqPeriodo)) ;
            }
            AV46faltaTeoricoImportes = AV48proximoEstimadoImportes.divide(DecimalUtil.doubleToDec(6), 18, java.math.RoundingMode.DOWN) ;
            AV46faltaTeoricoImportes = AV46faltaTeoricoImportes.multiply(DecimalUtil.doubleToDec(AV47tantosMeses)) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46faltaTeoricoImportes)==0) )
            {
               AV15Importes = AV15Importes.subtract(AV46faltaTeoricoImportes) ;
               AV23LiqDLog += httpContext.getMessage( ". Le resta ", "") + GXutil.trim( GXutil.str( AV46faltaTeoricoImportes, 14, 2)) + httpContext.getMessage( " de los ", "") + GXutil.trim( GXutil.str( AV47tantosMeses, 4, 0)) + httpContext.getMessage( " que faltan para la liquidación de aguinaldo", "") ;
            }
         }
         GXv_int7[0] = AV45LegClase ;
         new web.getlegajoclase(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV11LegNumero, GXv_int7) ;
         anticipo_de_sac_v2.this.AV45LegClase = GXv_int7[0] ;
         GXv_int7[0] = AV43primeraEs ;
         new web.esprimeraquincena(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV17LiqNro, AV11LegNumero, AV10LiqPeriodo, AV45LegClase, GXv_int7) ;
         anticipo_de_sac_v2.this.AV43primeraEs = GXv_int7[0] ;
         if ( AV43primeraEs == 1 )
         {
            AV15Importes = AV15Importes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
            AV23LiqDLog += httpContext.getMessage( ". Por ser primera primera quincena lo divide entre 2", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = anticipo_de_sac_v2.this.AV15Importes;
      this.aP10[0] = anticipo_de_sac_v2.this.AV21LiqDCalculado;
      this.aP11[0] = anticipo_de_sac_v2.this.AV22error;
      this.aP12[0] = anticipo_de_sac_v2.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Importes = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV23LiqDLog = "" ;
      AV37ActualLiqPeriodo = GXutil.nullDate() ;
      AV9piso_ganancias_SAC_real = DecimalUtil.ZERO ;
      AV52auxError = "" ;
      AV18calcuSacProxEstimaConCodigo = "" ;
      AV16calculoSacProxEstimaLiqDImpCalcu = DecimalUtil.ZERO ;
      AV33brutoSinSacConCodigo = "" ;
      AV50ConceptoTipo = "" ;
      AV38Date = GXutil.nullDate() ;
      AV8promedioDeBrutoSinSacSemestre = DecimalUtil.ZERO ;
      AV35promedioError = "" ;
      AV24mitadPisoGanancias = DecimalUtil.ZERO ;
      AV48proximoEstimadoImportes = DecimalUtil.ZERO ;
      AV25sacLiquidadoPeriodoConCOdigo = "" ;
      AV26sacLiqPerLiqDImpCalcu = DecimalUtil.ZERO ;
      AV32anticipoSacConCodigo = "" ;
      GXt_char4 = "" ;
      GXt_char3 = "" ;
      GXv_char2 = new String[1] ;
      AV31anterioresLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_int9 = new short[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_char5 = new String[1] ;
      AV46faltaTeoricoImportes = DecimalUtil.ZERO ;
      GXv_int7 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21LiqDCalculado ;
   private byte AV20proxSacLiqDCalculado ;
   private byte AV34promedioLiqDCalculado ;
   private byte AV27sacLiqPerLiqDCalculado ;
   private byte AV45LegClase ;
   private byte AV43primeraEs ;
   private byte GXv_int7[] ;
   private short AV12EmpCod ;
   private short AV36cantidadPeriodos ;
   private short GXv_int9[] ;
   private short AV47tantosMeses ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV17LiqNro ;
   private int AV51LiqRelNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV15Importes ;
   private java.math.BigDecimal AV9piso_ganancias_SAC_real ;
   private java.math.BigDecimal AV16calculoSacProxEstimaLiqDImpCalcu ;
   private java.math.BigDecimal AV8promedioDeBrutoSinSacSemestre ;
   private java.math.BigDecimal AV24mitadPisoGanancias ;
   private java.math.BigDecimal AV48proximoEstimadoImportes ;
   private java.math.BigDecimal AV26sacLiqPerLiqDImpCalcu ;
   private java.math.BigDecimal AV31anterioresLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV46faltaTeoricoImportes ;
   private String AV39ConCodigo ;
   private String AV14ProcesoLiquidacion ;
   private String AV18calcuSacProxEstimaConCodigo ;
   private String AV33brutoSinSacConCodigo ;
   private String AV50ConceptoTipo ;
   private String AV25sacLiquidadoPeriodoConCOdigo ;
   private String AV32anticipoSacConCodigo ;
   private String GXt_char4 ;
   private String GXt_char3 ;
   private String GXv_char2[] ;
   private String GXv_char5[] ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date AV37ActualLiqPeriodo ;
   private java.util.Date AV38Date ;
   private boolean AV49insertandoConceptos ;
   private boolean returnInSub ;
   private boolean AV19existe ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean6[] ;
   private String AV23LiqDLog ;
   private String AV22error ;
   private String AV52auxError ;
   private String AV35promedioError ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private byte[] aP10 ;
   private String[] aP11 ;
}

