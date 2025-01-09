package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getremuneracionactuallicencia2 extends GXProcedure
{
   public getremuneracionactuallicencia2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getremuneracionactuallicencia2.class ), "" );
   }

   public getremuneracionactuallicencia2( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             java.util.Date aP13 ,
                             boolean aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 ,
                             byte[] aP20 )
   {
      getremuneracionactuallicencia2.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String aP12 ,
                        java.util.Date aP13 ,
                        boolean aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        String[] aP19 ,
                        byte[] aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             java.util.Date aP13 ,
                             boolean aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 ,
                             byte[] aP20 ,
                             String[] aP21 )
   {
      getremuneracionactuallicencia2.this.AV9CliCod = aP0;
      getremuneracionactuallicencia2.this.AV10EmpCod = aP1;
      getremuneracionactuallicencia2.this.AV36LiqNro = aP2;
      getremuneracionactuallicencia2.this.AV74LiqRelNro = aP3;
      getremuneracionactuallicencia2.this.AV70TLiqCod = aP4;
      getremuneracionactuallicencia2.this.AV11LegNumero = aP5;
      getremuneracionactuallicencia2.this.AV48LiqPeriodo = aP6;
      getremuneracionactuallicencia2.this.AV37ProcesoLiquidacion = aP7;
      getremuneracionactuallicencia2.this.AV72llamador = aP8;
      getremuneracionactuallicencia2.this.AV77tipo_tarifa = aP9;
      getremuneracionactuallicencia2.this.AV21EmpBaseTipo = aP10;
      getremuneracionactuallicencia2.this.AV23EmpBaseCod1 = aP11;
      getremuneracionactuallicencia2.this.AV22EmpBaseCod2 = aP12;
      getremuneracionactuallicencia2.this.AV14Fecha = aP13;
      getremuneracionactuallicencia2.this.AV52buscaDiaAnterior = aP14;
      getremuneracionactuallicencia2.this.aP15 = aP15;
      getremuneracionactuallicencia2.this.aP16 = aP16;
      getremuneracionactuallicencia2.this.aP17 = aP17;
      getremuneracionactuallicencia2.this.aP18 = aP18;
      getremuneracionactuallicencia2.this.aP19 = aP19;
      getremuneracionactuallicencia2.this.aP20 = aP20;
      getremuneracionactuallicencia2.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16liqdcalculado = (byte)(1) ;
      if ( ( GXutil.strcmp(AV77tipo_tarifa, "H") == 0 ) && ( AV52buscaDiaAnterior ) )
      {
         AV18LiqDLog = httpContext.getMessage( ". Calculos de remuneraciones del día anterior: ", "") ;
      }
      else
      {
         AV18LiqDLog = httpContext.getMessage( ". Calculos de remuneraciones actuales: ", "") ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( " &Fecha ", "")+GXutil.trim( localUtil.dtoc( AV14Fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " empbasetipo ", "")+GXutil.trim( AV21EmpBaseTipo)+httpContext.getMessage( " &tipo_tarifa ", "")+GXutil.trim( AV77tipo_tarifa)+httpContext.getMessage( " &EmpBaseCod1 ", "")+AV23EmpBaseCod1+httpContext.getMessage( " &EmpBaseCod2 ", "")+AV22EmpBaseCod2) ;
      AV44desde_LiqPeriodo = localUtil.ymdtod( GXutil.year( AV48LiqPeriodo), 1, 1) ;
      GXv_char1[0] = AV49ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      getremuneracionactuallicencia2.this.AV49ParmValue = GXv_char1[0] ;
      AV46proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV49ParmValue, ".") ;
      AV56desdeTipoConCod = "NRE_ARG" ;
      AV57hastaTipoConCod = "REM_ARG" ;
      GXv_char1[0] = AV61sueldoMensualConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      getremuneracionactuallicencia2.this.AV61sueldoMensualConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV34horasNormalesConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      getremuneracionactuallicencia2.this.AV34horasNormalesConCodigo = GXv_char1[0] ;
      if ( GXutil.strcmp(AV21EmpBaseTipo, "licencia") == 0 )
      {
         GXt_boolean2 = AV75SitLicCuentaTrab ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.getlicesremunerada(remoteHandle, context).execute( AV23EmpBaseCod1, GXv_boolean3) ;
         getremuneracionactuallicencia2.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV75SitLicCuentaTrab = GXt_boolean2 ;
         if ( AV75SitLicCuentaTrab )
         {
            AV69que = httpContext.getMessage( "LICENCIA", "") ;
         }
         else
         {
            AV69que = httpContext.getMessage( "AUSENCIA", "") ;
         }
      }
      else
      {
         AV69que = httpContext.getMessage( "FERIADO", "") ;
      }
      if ( ! (0==AV36LiqNro) )
      {
         GXt_char4 = AV71vacTLiqCod ;
         GXt_char5 = AV71vacTLiqCod ;
         GXv_char1[0] = GXt_char5 ;
         new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char1) ;
         getremuneracionactuallicencia2.this.GXt_char5 = GXv_char1[0] ;
         GXv_char6[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char5, GXv_char6) ;
         getremuneracionactuallicencia2.this.GXt_char4 = GXv_char6[0] ;
         AV71vacTLiqCod = GXt_char4 ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV36LiqNro, 8, 0))+httpContext.getMessage( " &TLiqCod ", "")+AV70TLiqCod+httpContext.getMessage( " &vacTLiqCod ", "")+AV71vacTLiqCod) ;
      if ( ! (0==AV36LiqNro) && ( GXutil.strcmp(AV70TLiqCod, AV71vacTLiqCod) != 0 ) )
      {
         GXv_decimal7[0] = AV28Importes ;
         GXv_decimal8[0] = AV54horasNormalesTotales ;
         GXv_int9[0] = AV38auxLiqDCalculado ;
         GXv_char6[0] = AV53auxError ;
         GXv_char1[0] = AV50auxLiqDLog ;
         new web.base_calculo_pres_ant(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV36LiqNro, AV74LiqRelNro, AV11LegNumero, AV48LiqPeriodo, AV77tipo_tarifa, AV69que, AV72llamador, AV44desde_LiqPeriodo, AV46proporcionHabitualPorUnaje, AV37ProcesoLiquidacion, GXv_decimal7, GXv_decimal8, GXv_int9, GXv_char6, GXv_char1) ;
         getremuneracionactuallicencia2.this.AV28Importes = GXv_decimal7[0] ;
         getremuneracionactuallicencia2.this.AV54horasNormalesTotales = GXv_decimal8[0] ;
         getremuneracionactuallicencia2.this.AV38auxLiqDCalculado = GXv_int9[0] ;
         getremuneracionactuallicencia2.this.AV53auxError = GXv_char6[0] ;
         getremuneracionactuallicencia2.this.AV50auxLiqDLog = GXv_char1[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "&Importes ", "")+GXutil.trim( GXutil.str( AV28Importes, 14, 2))) ;
         if ( AV38auxLiqDCalculado == 0 )
         {
            AV16liqdcalculado = (byte)(0) ;
            AV17error = AV53auxError ;
            AV18LiqDLog = AV17error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV18LiqDLog += AV50auxLiqDLog ;
      }
      else
      {
         AV81GXLvl61 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV69que ,
                                              Byte.valueOf(A1620ConBaseLic) ,
                                              Byte.valueOf(A1621ConBaseFer) ,
                                              Byte.valueOf(A2191ConBaseAus) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01NM2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2191ConBaseAus = P01NM2_A2191ConBaseAus[0] ;
            A1621ConBaseFer = P01NM2_A1621ConBaseFer[0] ;
            A1620ConBaseLic = P01NM2_A1620ConBaseLic[0] ;
            A3CliCod = P01NM2_A3CliCod[0] ;
            A26ConCodigo = P01NM2_A26ConCodigo[0] ;
            AV81GXLvl61 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "concodigo ", "")+A26ConCodigo+httpContext.getMessage( " ConBaseLic ", "")+GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))) ;
            GXv_int9[0] = AV68es_base ;
            GXv_boolean3[0] = AV41agregar ;
            new web.calcular_es_base(remoteHandle, context).execute( AV9CliCod, A26ConCodigo, AV69que, GXv_int9, GXv_boolean3) ;
            getremuneracionactuallicencia2.this.AV68es_base = GXv_int9[0] ;
            getremuneracionactuallicencia2.this.AV41agregar = GXv_boolean3[0] ;
            if ( AV41agregar )
            {
               GXv_boolean3[0] = AV41agregar ;
               GXv_boolean10[0] = AV51descartoPorHabitual ;
               new web.validar_concepto_base(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, A26ConCodigo, AV44desde_LiqPeriodo, AV48LiqPeriodo, AV46proporcionHabitualPorUnaje, AV68es_base, AV77tipo_tarifa, GXv_boolean3, GXv_boolean10) ;
               getremuneracionactuallicencia2.this.AV41agregar = GXv_boolean3[0] ;
               getremuneracionactuallicencia2.this.AV51descartoPorHabitual = GXv_boolean10[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "&agregar ", "")+GXutil.trim( GXutil.booltostr( AV41agregar))) ;
               if ( AV41agregar )
               {
                  AV39ConCodigo = A26ConCodigo ;
                  /* Execute user subroutine: 'PROCESAR CONCEPTO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV81GXLvl61 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      if ( ( GXutil.strcmp(AV77tipo_tarifa, "H") == 0 ) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43diaCantHorasNormalesDia)==0) )
      {
         GXv_decimal8[0] = AV43diaCantHorasNormalesDia ;
         new web.gethorasdiaparavacacionesjornal(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, AV54horasNormalesTotales, GXv_decimal8) ;
         getremuneracionactuallicencia2.this.AV43diaCantHorasNormalesDia = GXv_decimal8[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'PROCESAR CONCEPTO' Routine */
      returnInSub = false ;
      AV50auxLiqDLog = "" ;
      GXv_decimal8[0] = AV28Importes ;
      GXv_char6[0] = AV50auxLiqDLog ;
      GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char1[0] = AV53auxError ;
      GXv_int9[0] = AV38auxLiqDCalculado ;
      GXv_decimal11[0] = AV43diaCantHorasNormalesDia ;
      GXv_decimal12[0] = AV55auxhorasNormalesTotales ;
      new web.previsualizarconceptopararemulicferhor(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV36LiqNro, AV11LegNumero, AV39ConCodigo, AV14Fecha, AV77tipo_tarifa, AV37ProcesoLiquidacion, false, GXv_decimal8, GXv_char6, GXv_decimal7, GXv_char1, GXv_int9, GXv_decimal11, GXv_decimal12) ;
      getremuneracionactuallicencia2.this.AV28Importes = GXv_decimal8[0] ;
      getremuneracionactuallicencia2.this.AV50auxLiqDLog = GXv_char6[0] ;
      getremuneracionactuallicencia2.this.AV53auxError = GXv_char1[0] ;
      getremuneracionactuallicencia2.this.AV38auxLiqDCalculado = GXv_int9[0] ;
      getremuneracionactuallicencia2.this.AV43diaCantHorasNormalesDia = GXv_decimal11[0] ;
      getremuneracionactuallicencia2.this.AV55auxhorasNormalesTotales = GXv_decimal12[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV80Pgmname, httpContext.getMessage( "&auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV38auxLiqDCalculado, 1, 0))+httpContext.getMessage( " &&horasNormalesTotales ", "")+GXutil.trim( GXutil.str( AV54horasNormalesTotales, 9, 2))) ;
      if ( AV38auxLiqDCalculado == 0 )
      {
         AV16liqdcalculado = (byte)(0) ;
         AV17error = AV53auxError ;
         AV18LiqDLog = AV17error ;
         returnInSub = true;
         if (true) return;
      }
      AV18LiqDLog += GXutil.trim( AV50auxLiqDLog) ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54horasNormalesTotales)==0) )
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55auxhorasNormalesTotales)==0) )
         {
            AV54horasNormalesTotales = AV55auxhorasNormalesTotales ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP15[0] = getremuneracionactuallicencia2.this.AV28Importes;
      this.aP16[0] = getremuneracionactuallicencia2.this.AV43diaCantHorasNormalesDia;
      this.aP17[0] = getremuneracionactuallicencia2.this.AV54horasNormalesTotales;
      this.aP18[0] = getremuneracionactuallicencia2.this.AV8diaAnteriorValorHoraImportes;
      this.aP19[0] = getremuneracionactuallicencia2.this.AV17error;
      this.aP20[0] = getremuneracionactuallicencia2.this.AV16liqdcalculado;
      this.aP21[0] = getremuneracionactuallicencia2.this.AV18LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28Importes = DecimalUtil.ZERO ;
      AV43diaCantHorasNormalesDia = DecimalUtil.ZERO ;
      AV54horasNormalesTotales = DecimalUtil.ZERO ;
      AV8diaAnteriorValorHoraImportes = DecimalUtil.ZERO ;
      AV17error = "" ;
      AV18LiqDLog = "" ;
      AV80Pgmname = "" ;
      AV44desde_LiqPeriodo = GXutil.nullDate() ;
      AV49ParmValue = "" ;
      AV46proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      AV56desdeTipoConCod = "" ;
      AV57hastaTipoConCod = "" ;
      AV61sueldoMensualConCodigo = "" ;
      AV34horasNormalesConCodigo = "" ;
      AV69que = "" ;
      AV71vacTLiqCod = "" ;
      GXt_char4 = "" ;
      GXt_char5 = "" ;
      AV53auxError = "" ;
      AV50auxLiqDLog = "" ;
      scmdbuf = "" ;
      P01NM2_A2191ConBaseAus = new byte[1] ;
      P01NM2_A1621ConBaseFer = new byte[1] ;
      P01NM2_A1620ConBaseLic = new byte[1] ;
      P01NM2_A3CliCod = new int[1] ;
      P01NM2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV39ConCodigo = "" ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_char6 = new String[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_char1 = new String[1] ;
      GXv_int9 = new byte[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      AV55auxhorasNormalesTotales = DecimalUtil.ZERO ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getremuneracionactuallicencia2__default(),
         new Object[] {
             new Object[] {
            P01NM2_A2191ConBaseAus, P01NM2_A1621ConBaseFer, P01NM2_A1620ConBaseLic, P01NM2_A3CliCod, P01NM2_A26ConCodigo
            }
         }
      );
      AV80Pgmname = "getRemuneracionActualLicencia2" ;
      /* GeneXus formulas. */
      AV80Pgmname = "getRemuneracionActualLicencia2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16liqdcalculado ;
   private byte AV38auxLiqDCalculado ;
   private byte AV81GXLvl61 ;
   private byte A1620ConBaseLic ;
   private byte A1621ConBaseFer ;
   private byte A2191ConBaseAus ;
   private byte AV68es_base ;
   private byte GXv_int9[] ;
   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV36LiqNro ;
   private int AV74LiqRelNro ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV28Importes ;
   private java.math.BigDecimal AV43diaCantHorasNormalesDia ;
   private java.math.BigDecimal AV54horasNormalesTotales ;
   private java.math.BigDecimal AV8diaAnteriorValorHoraImportes ;
   private java.math.BigDecimal AV46proporcionHabitualPorUnaje ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal AV55auxhorasNormalesTotales ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private String AV70TLiqCod ;
   private String AV37ProcesoLiquidacion ;
   private String AV72llamador ;
   private String AV77tipo_tarifa ;
   private String AV21EmpBaseTipo ;
   private String AV23EmpBaseCod1 ;
   private String AV22EmpBaseCod2 ;
   private String AV80Pgmname ;
   private String AV56desdeTipoConCod ;
   private String AV57hastaTipoConCod ;
   private String AV61sueldoMensualConCodigo ;
   private String AV34horasNormalesConCodigo ;
   private String AV69que ;
   private String AV71vacTLiqCod ;
   private String GXt_char4 ;
   private String GXt_char5 ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV39ConCodigo ;
   private String GXv_char6[] ;
   private String GXv_char1[] ;
   private java.util.Date AV48LiqPeriodo ;
   private java.util.Date AV14Fecha ;
   private java.util.Date AV44desde_LiqPeriodo ;
   private boolean AV52buscaDiaAnterior ;
   private boolean AV75SitLicCuentaTrab ;
   private boolean GXt_boolean2 ;
   private boolean returnInSub ;
   private boolean AV41agregar ;
   private boolean GXv_boolean3[] ;
   private boolean AV51descartoPorHabitual ;
   private boolean GXv_boolean10[] ;
   private String AV18LiqDLog ;
   private String AV49ParmValue ;
   private String AV50auxLiqDLog ;
   private String AV17error ;
   private String AV53auxError ;
   private String[] aP21 ;
   private java.math.BigDecimal[] aP15 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private java.math.BigDecimal[] aP18 ;
   private String[] aP19 ;
   private byte[] aP20 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01NM2_A2191ConBaseAus ;
   private byte[] P01NM2_A1621ConBaseFer ;
   private byte[] P01NM2_A1620ConBaseLic ;
   private int[] P01NM2_A3CliCod ;
   private String[] P01NM2_A26ConCodigo ;
}

final  class getremuneracionactuallicencia2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01NM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV69que ,
                                          byte A1620ConBaseLic ,
                                          byte A1621ConBaseFer ,
                                          byte A2191ConBaseAus ,
                                          int AV9CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[1];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT ConBaseAus, ConBaseFer, ConBaseLic, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( GXutil.strcmp(AV69que, httpContext.getMessage( "LICENCIA", "")) == 0 )
      {
         addWhere(sWhereString, "(ConBaseLic > 0)");
      }
      if ( GXutil.strcmp(AV69que, httpContext.getMessage( "FERIADO", "")) == 0 )
      {
         addWhere(sWhereString, "(ConBaseFer > 0)");
      }
      if ( GXutil.strcmp(AV69que, httpContext.getMessage( "AUSENCIA", "")) == 0 )
      {
         addWhere(sWhereString, "(ConBaseAus > 0)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01NM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).byteValue() , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

