package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sueldo_basico extends GXProcedure
{
   public sueldo_basico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sueldo_basico.class ), "" );
   }

   public sueldo_basico( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           int aP4 ,
                           java.util.Date aP5 ,
                           java.math.BigDecimal aP6 ,
                           String aP7 ,
                           String aP8 ,
                           String aP9 ,
                           boolean aP10 ,
                           boolean aP11 ,
                           java.math.BigDecimal aP12 ,
                           boolean aP13 ,
                           String aP14 ,
                           boolean aP15 ,
                           boolean aP16 ,
                           boolean aP17 ,
                           java.math.BigDecimal[] aP18 ,
                           java.math.BigDecimal[] aP19 ,
                           short[] aP20 ,
                           String[] aP21 ,
                           String[] aP22 )
   {
      sueldo_basico.this.aP23 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23);
      return aP23[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        java.math.BigDecimal aP12 ,
                        boolean aP13 ,
                        String aP14 ,
                        boolean aP15 ,
                        boolean aP16 ,
                        boolean aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        java.math.BigDecimal[] aP19 ,
                        short[] aP20 ,
                        String[] aP21 ,
                        String[] aP22 ,
                        byte[] aP23 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal aP12 ,
                             boolean aP13 ,
                             String aP14 ,
                             boolean aP15 ,
                             boolean aP16 ,
                             boolean aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             short[] aP20 ,
                             String[] aP21 ,
                             String[] aP22 ,
                             byte[] aP23 )
   {
      sueldo_basico.this.AV14CliCod = aP0;
      sueldo_basico.this.AV15EmpCod = aP1;
      sueldo_basico.this.AV16LegNumero = aP2;
      sueldo_basico.this.AV17LiqNro = aP3;
      sueldo_basico.this.AV54LiqRelNro = aP4;
      sueldo_basico.this.AV22LiqPeriodo = aP5;
      sueldo_basico.this.AV58parmSueldoImportes = aP6;
      sueldo_basico.this.AV52ConCodigo = aP7;
      sueldo_basico.this.AV49TLiqCod = aP8;
      sueldo_basico.this.AV43que = aP9;
      sueldo_basico.this.AV44restarLicencias = aP10;
      sueldo_basico.this.AV45restarFeriados = aP11;
      sueldo_basico.this.AV31LiqDCanti = aP12;
      sueldo_basico.this.AV35calcularPorDia = aP13;
      sueldo_basico.this.AV38ProcesoLiquidacion = aP14;
      sueldo_basico.this.AV39insertandoConceptos = aP15;
      sueldo_basico.this.AV41cambiarSigno = aP16;
      sueldo_basico.this.AV53simulacionEs = aP17;
      sueldo_basico.this.aP18 = aP18;
      sueldo_basico.this.aP19 = aP19;
      sueldo_basico.this.aP20 = aP20;
      sueldo_basico.this.aP21 = aP21;
      sueldo_basico.this.aP22 = aP22;
      sueldo_basico.this.aP23 = aP23;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV8LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, GXv_int1) ;
      sueldo_basico.this.AV8LegClase = GXv_int1[0] ;
      GXv_char2[0] = AV61tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV16LegNumero, (short)(0), "", "", GXv_char2) ;
      sueldo_basico.this.AV61tipo_tarifa = GXv_char2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "&LegClase ", "")+GXutil.trim( GXutil.str( AV8LegClase, 1, 0))+httpContext.getMessage( " &calcularPorDia ", "")+GXutil.trim( GXutil.booltostr( AV35calcularPorDia))) ;
      if ( ( GXutil.strcmp(AV61tipo_tarifa, "P") == 0 ) || ( AV35calcularPorDia ) )
      {
         AV11LiqDLog = httpContext.getMessage( "Sueldo ", "") ;
         AV11LiqDLog += httpContext.getMessage( "fuera de convenio ", "") ;
         GXv_char2[0] = AV59auxError ;
         GXv_decimal3[0] = AV12basico_mensual ;
         GXv_char4[0] = AV56LegSuelTipo ;
         GXv_char5[0] = AV40basicoLiqDLog ;
         new web.obtsueldobasicomensual(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, AV17LiqNro, AV22LiqPeriodo, AV58parmSueldoImportes, AV43que, GXv_char2, GXv_decimal3, GXv_char4, GXv_char5) ;
         sueldo_basico.this.AV59auxError = GXv_char2[0] ;
         sueldo_basico.this.AV12basico_mensual = GXv_decimal3[0] ;
         sueldo_basico.this.AV56LegSuelTipo = GXv_char4[0] ;
         sueldo_basico.this.AV40basicoLiqDLog = GXv_char5[0] ;
         AV11LiqDLog = AV40basicoLiqDLog ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "&basicoLiqDLog ", "")+GXutil.trim( AV40basicoLiqDLog)) ;
         if ( ! (GXutil.strcmp("", AV59auxError)==0) )
         {
            GXv_char5[0] = AV18error ;
            new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
            sueldo_basico.this.AV18error = GXv_char5[0] ;
            AV18error += AV59auxError ;
            AV10LiqDCalculado = (byte)(0) ;
            AV11LiqDLog = GXutil.trim( AV18error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, "1") ;
            if ( ( GXutil.strcmp(AV61tipo_tarifa, "P") == 0 ) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV12basico_mensual)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, "2") ;
               AV10LiqDCalculado = (byte)(0) ;
               GXv_char5[0] = AV57LegIdNomApe ;
               new web.getlegidnomape(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, GXv_char5) ;
               sueldo_basico.this.AV57LegIdNomApe = GXv_char5[0] ;
               GXv_char5[0] = AV18error ;
               new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
               sueldo_basico.this.AV18error = GXv_char5[0] ;
               AV18error += httpContext.getMessage( "No se pudo determinar sueldo básico a la fecha de ", "") + GXutil.trim( localUtil.dtoc( AV22LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el legajo ", "") + GXutil.trim( AV57LegIdNomApe) ;
               AV11LiqDLog += GXutil.trim( AV18error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV13Importes = AV12basico_mensual ;
         GXv_int1[0] = AV55EmpTipoExp ;
         new web.getemptipoexp(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, GXv_int1) ;
         sueldo_basico.this.AV55EmpTipoExp = GXv_int1[0] ;
         if ( ! (0==AV17LiqNro) || ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31LiqDCanti)==0) )
         {
            AV20palabra = "[dias_mes]" ;
            GXv_int6[0] = AV23dias_mes ;
            new web.obtvalformulacdmycds(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV16LegNumero, AV22LiqPeriodo, AV20palabra, AV22LiqPeriodo, false, GXv_int6) ;
            sueldo_basico.this.AV23dias_mes = (short)((short)(GXv_int6[0])) ;
            if ( (0==AV23dias_mes) )
            {
               GXv_char5[0] = AV18error ;
               new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
               sueldo_basico.this.AV18error = GXv_char5[0] ;
               AV18error += httpContext.getMessage( "No se pudo recuperar días del mes", "") ;
               AV10LiqDCalculado = (byte)(0) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV55EmpTipoExp == 2 )
            {
               AV29cantidadCalculada = AV23dias_mes ;
               AV28baseImportes = AV12basico_mensual ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, "3") ;
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31LiqDCanti)==0) )
               {
                  AV20palabra = "[dias_trabajados_mes]" ;
                  GXv_int6[0] = (int)(DecimalUtil.decToDouble(AV25diasTrabajadosMesLiqDImpCalcu)) ;
                  GXv_int1[0] = AV32dtmLiqDCalculado ;
                  GXv_char5[0] = AV33dtmError ;
                  GXv_char4[0] = AV37dtmLiqDLog ;
                  new web.obtvalformuladtmydts(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV54LiqRelNro, AV16LegNumero, AV20palabra, AV22LiqPeriodo, AV44restarLicencias, AV45restarFeriados, true, AV38ProcesoLiquidacion, AV39insertandoConceptos, GXv_int6, GXv_int1, GXv_char5, GXv_char4) ;
                  sueldo_basico.this.AV25diasTrabajadosMesLiqDImpCalcu = DecimalUtil.doubleToDec(GXv_int6[0]) ;
                  sueldo_basico.this.AV32dtmLiqDCalculado = GXv_int1[0] ;
                  sueldo_basico.this.AV33dtmError = GXv_char5[0] ;
                  sueldo_basico.this.AV37dtmLiqDLog = GXv_char4[0] ;
                  if ( AV32dtmLiqDCalculado == 0 )
                  {
                     AV10LiqDCalculado = (byte)(0) ;
                     GXv_char5[0] = AV18error ;
                     new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
                     sueldo_basico.this.AV18error = GXv_char5[0] ;
                     AV18error += AV33dtmError ;
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  AV25diasTrabajadosMesLiqDImpCalcu = AV31LiqDCanti ;
               }
               GXv_char5[0] = AV36diasTrabajadosMesVarchar ;
               new web.armatooltip(remoteHandle, context).execute( AV14CliCod, AV25diasTrabajadosMesLiqDImpCalcu, AV37dtmLiqDLog, true, GXv_char5) ;
               sueldo_basico.this.AV36diasTrabajadosMesVarchar = GXv_char5[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, "4") ;
               AV27valorPorDiaImportes = AV12basico_mensual.divide(DecimalUtil.doubleToDec(AV23dias_mes), 18, java.math.RoundingMode.DOWN) ;
               AV28baseImportes = AV27valorPorDiaImportes ;
               AV29cantidadCalculada = (short)(DecimalUtil.decToDouble(AV25diasTrabajadosMesLiqDImpCalcu)) ;
               AV13Importes = AV27valorPorDiaImportes.multiply(AV25diasTrabajadosMesLiqDImpCalcu) ;
               if ( AV41cambiarSigno )
               {
                  AV42calidadPalabra = httpContext.getMessage( "sin goce de sueldo", "") ;
               }
               else
               {
                  AV42calidadPalabra = httpContext.getMessage( "trabajados", "") ;
               }
               AV11LiqDLog += httpContext.getMessage( ". El valor por día es ", "") + GXutil.trim( GXutil.str( AV27valorPorDiaImportes, 14, 2)) + httpContext.getMessage( ", multiplicado por ", "") + GXutil.trim( AV36diasTrabajadosMesVarchar) + httpContext.getMessage( " días ", "") + GXutil.trim( AV42calidadPalabra) ;
            }
         }
      }
      else
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31LiqDCanti)==0) )
         {
            if ( ! AV53simulacionEs )
            {
               GXv_decimal3[0] = AV47auxLiqDCanti ;
               GXv_boolean7[0] = false ;
               GXv_int1[0] = AV48auxLiqDCalculado ;
               new web.getliqdcantidad(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV16LegNumero, AV52ConCodigo, GXv_decimal3, GXv_boolean7, GXv_int1) ;
               sueldo_basico.this.AV47auxLiqDCanti = GXv_decimal3[0] ;
               sueldo_basico.this.AV48auxLiqDCalculado = GXv_int1[0] ;
               if ( AV48auxLiqDCalculado == 0 )
               {
                  AV10LiqDCalculado = (byte)(0) ;
                  GXv_char5[0] = AV18error ;
                  new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
                  sueldo_basico.this.AV18error = GXv_char5[0] ;
                  AV18error += httpContext.getMessage( "Falta calcular ", "") + AV52ConCodigo ;
                  AV11LiqDLog = AV18error ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               AV47auxLiqDCanti = DecimalUtil.doubleToDec(1) ;
            }
         }
         else
         {
            AV47auxLiqDCanti = AV31LiqDCanti ;
         }
         GXv_date8[0] = AV50primerDiaPeriodo ;
         GXv_date9[0] = AV51date ;
         new web.getrangoperiodos(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV16LegNumero, AV49TLiqCod, AV8LegClase, AV22LiqPeriodo, false, GXv_date8, GXv_date9) ;
         sueldo_basico.this.AV50primerDiaPeriodo = GXv_date8[0] ;
         sueldo_basico.this.AV51date = GXv_date9[0] ;
         GXv_char5[0] = AV59auxError ;
         GXv_decimal3[0] = AV30valor_hora ;
         new web.obtbasicovalorhora(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LiqNro, AV16LegNumero, AV50primerDiaPeriodo, AV43que, GXv_char5, GXv_decimal3) ;
         sueldo_basico.this.AV59auxError = GXv_char5[0] ;
         sueldo_basico.this.AV30valor_hora = GXv_decimal3[0] ;
         if ( ! (GXutil.strcmp("", AV59auxError)==0) )
         {
            GXv_char5[0] = AV18error ;
            new web.getcoderrprin(remoteHandle, context).execute( GXv_char5) ;
            sueldo_basico.this.AV18error = GXv_char5[0] ;
            AV18error += AV59auxError ;
            AV10LiqDCalculado = (byte)(0) ;
            AV11LiqDLog = GXutil.trim( AV18error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13Importes = AV30valor_hora.multiply(AV47auxLiqDCanti) ;
         AV11LiqDLog = httpContext.getMessage( "Valor hora ", "") + GXutil.trim( GXutil.str( AV30valor_hora, 14, 2)) + httpContext.getMessage( ", multiplicado por ", "") + GXutil.trim( GXutil.str( GXutil.roundDecimal( AV47auxLiqDCanti, 0), 10, 0)) + httpContext.getMessage( " horas trabajadas", "") ;
         AV28baseImportes = AV30valor_hora ;
         AV29cantidadCalculada = (short)(DecimalUtil.decToDouble(AV47auxLiqDCanti)) ;
      }
      if ( AV41cambiarSigno )
      {
         AV13Importes = AV13Importes.multiply(DecimalUtil.doubleToDec(-1)) ;
         AV11LiqDLog += httpContext.getMessage( ". Se cambia el signo", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP18[0] = sueldo_basico.this.AV13Importes;
      this.aP19[0] = sueldo_basico.this.AV28baseImportes;
      this.aP20[0] = sueldo_basico.this.AV29cantidadCalculada;
      this.aP21[0] = sueldo_basico.this.AV18error;
      this.aP22[0] = sueldo_basico.this.AV11LiqDLog;
      this.aP23[0] = sueldo_basico.this.AV10LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Importes = DecimalUtil.ZERO ;
      AV28baseImportes = DecimalUtil.ZERO ;
      AV18error = "" ;
      AV11LiqDLog = "" ;
      AV61tipo_tarifa = "" ;
      AV65Pgmname = "" ;
      AV59auxError = "" ;
      GXv_char2 = new String[1] ;
      AV12basico_mensual = DecimalUtil.ZERO ;
      AV56LegSuelTipo = "" ;
      AV40basicoLiqDLog = "" ;
      AV57LegIdNomApe = "" ;
      AV20palabra = "" ;
      AV25diasTrabajadosMesLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_int6 = new int[1] ;
      AV33dtmError = "" ;
      AV37dtmLiqDLog = "" ;
      GXv_char4 = new String[1] ;
      AV36diasTrabajadosMesVarchar = "" ;
      AV27valorPorDiaImportes = DecimalUtil.ZERO ;
      AV42calidadPalabra = "" ;
      AV47auxLiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean7 = new boolean[1] ;
      GXv_int1 = new byte[1] ;
      AV50primerDiaPeriodo = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      AV51date = GXutil.nullDate() ;
      GXv_date9 = new java.util.Date[1] ;
      AV30valor_hora = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_char5 = new String[1] ;
      AV65Pgmname = "sueldo_basico" ;
      /* GeneXus formulas. */
      AV65Pgmname = "sueldo_basico" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqDCalculado ;
   private byte AV8LegClase ;
   private byte AV55EmpTipoExp ;
   private byte AV32dtmLiqDCalculado ;
   private byte AV48auxLiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV15EmpCod ;
   private short AV29cantidadCalculada ;
   private short AV23dias_mes ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LegNumero ;
   private int AV17LiqNro ;
   private int AV54LiqRelNro ;
   private int GXv_int6[] ;
   private java.math.BigDecimal AV58parmSueldoImportes ;
   private java.math.BigDecimal AV31LiqDCanti ;
   private java.math.BigDecimal AV13Importes ;
   private java.math.BigDecimal AV28baseImportes ;
   private java.math.BigDecimal AV12basico_mensual ;
   private java.math.BigDecimal AV25diasTrabajadosMesLiqDImpCalcu ;
   private java.math.BigDecimal AV27valorPorDiaImportes ;
   private java.math.BigDecimal AV47auxLiqDCanti ;
   private java.math.BigDecimal AV30valor_hora ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV52ConCodigo ;
   private String AV49TLiqCod ;
   private String AV43que ;
   private String AV38ProcesoLiquidacion ;
   private String AV61tipo_tarifa ;
   private String AV65Pgmname ;
   private String GXv_char2[] ;
   private String AV56LegSuelTipo ;
   private String AV20palabra ;
   private String GXv_char4[] ;
   private String AV42calidadPalabra ;
   private String GXv_char5[] ;
   private java.util.Date AV22LiqPeriodo ;
   private java.util.Date AV50primerDiaPeriodo ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date AV51date ;
   private java.util.Date GXv_date9[] ;
   private boolean AV44restarLicencias ;
   private boolean AV45restarFeriados ;
   private boolean AV35calcularPorDia ;
   private boolean AV39insertandoConceptos ;
   private boolean AV41cambiarSigno ;
   private boolean AV53simulacionEs ;
   private boolean returnInSub ;
   private boolean GXv_boolean7[] ;
   private String AV11LiqDLog ;
   private String AV40basicoLiqDLog ;
   private String AV37dtmLiqDLog ;
   private String AV18error ;
   private String AV59auxError ;
   private String AV57LegIdNomApe ;
   private String AV33dtmError ;
   private String AV36diasTrabajadosMesVarchar ;
   private byte[] aP23 ;
   private java.math.BigDecimal[] aP18 ;
   private java.math.BigDecimal[] aP19 ;
   private short[] aP20 ;
   private String[] aP21 ;
   private String[] aP22 ;
}

