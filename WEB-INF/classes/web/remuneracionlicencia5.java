package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class remuneracionlicencia5 extends GXProcedure
{
   public remuneracionlicencia5( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( remuneracionlicencia5.class ), "" );
   }

   public remuneracionlicencia5( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           java.util.Date aP5 ,
                                           String aP6 ,
                                           String aP7 ,
                                           java.math.BigDecimal aP8 ,
                                           java.util.Date aP9 ,
                                           boolean aP10 ,
                                           String aP11 ,
                                           String aP12 ,
                                           boolean aP13 ,
                                           java.math.BigDecimal[] aP14 ,
                                           java.math.BigDecimal[] aP15 ,
                                           byte[] aP16 ,
                                           String[] aP17 ,
                                           String[] aP18 ,
                                           java.math.BigDecimal[] aP19 )
   {
      remuneracionlicencia5.this.aP20 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
      return aP20[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.util.Date aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        byte[] aP16 ,
                        String[] aP17 ,
                        String[] aP18 ,
                        java.math.BigDecimal[] aP19 ,
                        java.math.BigDecimal[] aP20 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.util.Date aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             byte[] aP16 ,
                             String[] aP17 ,
                             String[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             java.math.BigDecimal[] aP20 )
   {
      remuneracionlicencia5.this.AV20CliCod = aP0;
      remuneracionlicencia5.this.AV35EmpCod = aP1;
      remuneracionlicencia5.this.AV63LiqNro = aP2;
      remuneracionlicencia5.this.AV207LiqRelNro = aP3;
      remuneracionlicencia5.this.AV60LegNumero = aP4;
      remuneracionlicencia5.this.AV65LiqPeriodo = aP5;
      remuneracionlicencia5.this.AV78operandos = aP6;
      remuneracionlicencia5.this.AV21ConCodigo = aP7;
      remuneracionlicencia5.this.AV61LiqDCanti = aP8;
      remuneracionlicencia5.this.AV183DAgeFecDes = aP9;
      remuneracionlicencia5.this.AV190descuentoEs = aP10;
      remuneracionlicencia5.this.AV106ProcesoLiquidacion = aP11;
      remuneracionlicencia5.this.AV205llamador = aP12;
      remuneracionlicencia5.this.AV52insertandoConceptos = aP13;
      remuneracionlicencia5.this.aP14 = aP14;
      remuneracionlicencia5.this.aP15 = aP15;
      remuneracionlicencia5.this.aP16 = aP16;
      remuneracionlicencia5.this.aP17 = aP17;
      remuneracionlicencia5.this.aP18 = aP18;
      remuneracionlicencia5.this.aP19 = aP19;
      remuneracionlicencia5.this.aP20 = aP20;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8liqdcalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&legnumero ", "")+GXutil.trim( GXutil.str( AV60LegNumero, 8, 0))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV65LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &operandos ", "")+AV78operandos) ;
      GXt_char1 = AV113parmValue ;
      GXt_char2 = AV113parmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      remuneracionlicencia5.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char2, GXv_char4) ;
      remuneracionlicencia5.this.GXt_char1 = GXv_char4[0] ;
      AV113parmValue = GXt_char1 ;
      AV112todosLosMeses30 = GXutil.boolval( AV113parmValue) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&todosLosMeses30 ", "")+GXutil.trim( GXutil.booltostr( AV112todosLosMeses30))) ;
      if ( ! (0==AV60LegNumero) )
      {
         GXt_char2 = AV70mensualTLiqCod ;
         GXt_char1 = AV70mensualTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         remuneracionlicencia5.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
         remuneracionlicencia5.this.GXt_char2 = GXv_char3[0] ;
         AV70mensualTLiqCod = GXt_char2 ;
         GXv_int5[0] = AV54LegClase ;
         GXv_char4[0] = AV216LegModTra ;
         new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, GXv_int5, GXv_char4) ;
         remuneracionlicencia5.this.AV54LegClase = GXv_int5[0] ;
         remuneracionlicencia5.this.AV216LegModTra = GXv_char4[0] ;
         GXv_char4[0] = AV217tipo_tarifa ;
         new web.gettipodetarifa(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV60LegNumero, (short)(0), "", "", GXv_char4) ;
         remuneracionlicencia5.this.AV217tipo_tarifa = GXv_char4[0] ;
         GXv_char4[0] = AV97TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, GXv_char4) ;
         remuneracionlicencia5.this.AV97TLiqCod = GXv_char4[0] ;
         if ( ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") != 0 ) && ( GXutil.strcmp(AV78operandos, "{vacaciones_no_gozadas_ant}") != 0 ) )
         {
            GXt_char2 = AV9adelVacMesProxConCodigo ;
            GXt_char1 = AV9adelVacMesProxConCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            remuneracionlicencia5.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
            remuneracionlicencia5.this.GXt_char2 = GXv_char3[0] ;
            AV9adelVacMesProxConCodigo = GXt_char2 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&ConCodigo ", "")+AV21ConCodigo+httpContext.getMessage( " &adelVacMesProxConCodigo ", "")+AV9adelVacMesProxConCodigo) ;
            if ( GXutil.strcmp(AV21ConCodigo, AV9adelVacMesProxConCodigo) == 0 )
            {
               GXt_char2 = AV152EmpBaseCod1 ;
               GXv_char4[0] = GXt_char2 ;
               new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV20CliCod, GXv_char4) ;
               remuneracionlicencia5.this.GXt_char2 = GXv_char4[0] ;
               AV152EmpBaseCod1 = GXt_char2 ;
               AV153EmpBaseCod2 = "" ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "setea de una ", "")+AV152EmpBaseCod1) ;
               AV168adelantoVacEs = true ;
               AV162proximoPeriodo = GXutil.addmth( AV65LiqPeriodo, (short)(1)) ;
               GXv_date6[0] = AV51iniPeriodo ;
               GXv_date7[0] = AV43finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV60LegNumero, AV97TLiqCod, AV54LegClase, AV162proximoPeriodo, true, GXv_date6, GXv_date7) ;
               remuneracionlicencia5.this.AV51iniPeriodo = GXv_date6[0] ;
               remuneracionlicencia5.this.AV43finPeriodo = GXv_date7[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&iniPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV51iniPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &finPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV43finPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               GXv_char4[0] = "" ;
               GXv_int8[0] = (short)(0) ;
               GXv_date7[0] = AV59LegLicenIni ;
               GXv_date6[0] = AV161date ;
               GXv_date9[0] = AV161date ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_char3[0] = "" ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, AV63LiqNro, false, AV51iniPeriodo, true, AV43finPeriodo, AV152EmpBaseCod1, false, false, false, GXv_char4, GXv_int8, GXv_date7, GXv_date6, GXv_date9, GXv_decimal10, GXv_boolean11, GXv_char3) ;
               remuneracionlicencia5.this.AV59LegLicenIni = GXv_date7[0] ;
               remuneracionlicencia5.this.AV161date = GXv_date6[0] ;
               remuneracionlicencia5.this.AV161date = GXv_date9[0] ;
               AV187averiguoPlus = true ;
               AV128LiqDPlus = DecimalUtil.doubleToDec(0) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV59LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            }
            else
            {
               if ( ( GXutil.strcmp(AV78operandos, "[feriados_no_trabajados]") == 0 ) || ( GXutil.strcmp(AV78operandos, "[no_laborables]") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 ) )
               {
                  if ( ( GXutil.strcmp(AV78operandos, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 ) )
                  {
                     AV59LegLicenIni = AV183DAgeFecDes ;
                  }
                  else
                  {
                     AV59LegLicenIni = AV65LiqPeriodo ;
                  }
                  if ( ( GXutil.strcmp(AV78operandos, "[feriados_no_trabajados]") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 ) )
                  {
                     GXt_char2 = AV152EmpBaseCod1 ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.palabracod1feriadoobligatorio(remoteHandle, context).execute( AV20CliCod, GXv_char4) ;
                     remuneracionlicencia5.this.GXt_char2 = GXv_char4[0] ;
                     AV152EmpBaseCod1 = GXt_char2 ;
                  }
                  else
                  {
                     GXt_char2 = AV152EmpBaseCod1 ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.palabracod1nolaborableopcional(remoteHandle, context).execute( AV20CliCod, GXv_char4) ;
                     remuneracionlicencia5.this.GXt_char2 = GXv_char4[0] ;
                     AV152EmpBaseCod1 = GXt_char2 ;
                  }
                  if ( ( GXutil.strcmp(AV78operandos, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 ) )
                  {
                     AV153EmpBaseCod2 = httpContext.getMessage( "Trabajado", "") ;
                  }
                  else
                  {
                     AV153EmpBaseCod2 = httpContext.getMessage( "No Trabajado", "") ;
                  }
               }
               else
               {
                  GXv_char4[0] = AV110CondicionLiquidacion ;
                  GXv_char3[0] = AV152EmpBaseCod1 ;
                  new web.getconceptocondicion(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_char4, GXv_char3) ;
                  remuneracionlicencia5.this.AV110CondicionLiquidacion = GXv_char4[0] ;
                  remuneracionlicencia5.this.AV152EmpBaseCod1 = GXv_char3[0] ;
                  if ( ( GXutil.strcmp(AV110CondicionLiquidacion, "AI") == 0 ) || ( GXutil.strcmp(AV110CondicionLiquidacion, "MI") == 0 ) )
                  {
                     GXt_char2 = AV152EmpBaseCod1 ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.estadoausenciasinjustificadas(remoteHandle, context).execute( AV20CliCod, GXv_char4) ;
                     remuneracionlicencia5.this.GXt_char2 = GXv_char4[0] ;
                     AV152EmpBaseCod1 = GXt_char2 ;
                  }
                  AV153EmpBaseCod2 = "" ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV21ConCodigo)+httpContext.getMessage( " sitcodigo ", "")+GXutil.trim( AV94sitCodigo)+httpContext.getMessage( " &LiqDCanti ", "")+GXutil.trim( GXutil.str( AV61LiqDCanti, 14, 2))) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61LiqDCanti)==0) )
            {
               GXt_char2 = AV93quincenaTLiqCod ;
               GXt_char1 = AV93quincenaTLiqCod ;
               GXv_char4[0] = GXt_char1 ;
               new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               remuneracionlicencia5.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
               remuneracionlicencia5.this.GXt_char2 = GXv_char3[0] ;
               AV93quincenaTLiqCod = GXt_char2 ;
               AV59LegLicenIni = AV183DAgeFecDes ;
               if ( ( GXutil.strcmp(AV97TLiqCod, AV93quincenaTLiqCod) == 0 ) && ( GXutil.strcmp(AV21ConCodigo, AV9adelVacMesProxConCodigo) == 0 ) )
               {
                  AV8liqdcalculado = (byte)(0) ;
                  AV36error = httpContext.getMessage( "Adelanto de vacaciones de mes próximo ingresado por novedad es inválido para liquidación de primera quincena", "") ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&LiqDCanti ", "")+GXutil.trim( GXutil.str( AV61LiqDCanti, 14, 2))) ;
                  AV209diasLog = httpContext.getMessage( "Cantidad ingresada por novedad", "") ;
                  AV57LegLicCntDias = (short)(DecimalUtil.decToDouble(AV61LiqDCanti)) ;
                  AV58LegLicCntDias_dosDecimales = AV61LiqDCanti ;
                  if ( ( GXutil.strcmp(AV78operandos, "[feriados_no_trabajados]") != 0 ) && ( GXutil.strcmp(AV78operandos, "[no_laborables]") != 0 ) && ( GXutil.strcmp(AV78operandos, "{feriados_trabajados}") != 0 ) && ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") != 0 ) )
                  {
                     if ( GXutil.strcmp(AV78operandos, "[remuneracion_descuento]") == 0 )
                     {
                        AV62LiqDLog = "" ;
                     }
                     else
                     {
                        AV62LiqDLog = httpContext.getMessage( "Cantidad de días ingresada por novedad ", "") + GXutil.trim( GXutil.str( AV61LiqDCanti, 14, 2)) ;
                     }
                     AV151EmpBaseTipo = "licencia" ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "obtiene !!! 	&LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV59LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &proximoPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV162proximoPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liqdplus ", "")+GXutil.trim( GXutil.str( AV128LiqDPlus, 6, 4))) ;
                     if ( AV168adelantoVacEs )
                     {
                        AV128LiqDPlus = DecimalUtil.doubleToDec(0) ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "sobreescribe liqdplus", "")) ;
                     }
                  }
                  else
                  {
                     AV151EmpBaseTipo = "feriado" ;
                  }
               }
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "1 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV65LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               AV151EmpBaseTipo = "licencia" ;
               GXv_date9[0] = AV51iniPeriodo ;
               GXv_date7[0] = AV43finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV60LegNumero, AV97TLiqCod, AV54LegClase, AV65LiqPeriodo, false, GXv_date9, GXv_date7) ;
               remuneracionlicencia5.this.AV51iniPeriodo = GXv_date9[0] ;
               remuneracionlicencia5.this.AV43finPeriodo = GXv_date7[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "antes de llamar a LegajodevuelveLicencia2 &EmpBaseCod1 ", "")+AV152EmpBaseCod1+httpContext.getMessage( " &iniPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV51iniPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &finPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV43finPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegClase ", "")+GXutil.trim( GXutil.str( AV54LegClase, 1, 0))+httpContext.getMessage( " &TLiqCod ", "")+GXutil.trim( AV97TLiqCod)) ;
               if ( (GXutil.strcmp("", AV152EmpBaseCod1)==0) )
               {
                  AV210conGoceEs = false ;
               }
               else
               {
                  AV210conGoceEs = true ;
               }
               GXv_char4[0] = "" ;
               GXv_int8[0] = AV57LegLicCntDias ;
               GXv_date9[0] = AV59LegLicenIni ;
               GXv_date7[0] = AV66logDesdeFecha ;
               GXv_date6[0] = AV67logHastaFecha ;
               GXv_decimal10[0] = AV128LiqDPlus ;
               GXv_boolean11[0] = false ;
               GXv_char3[0] = AV209diasLog ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, AV63LiqNro, false, AV51iniPeriodo, AV210conGoceEs, AV43finPeriodo, AV152EmpBaseCod1, false, false, true, GXv_char4, GXv_int8, GXv_date9, GXv_date7, GXv_date6, GXv_decimal10, GXv_boolean11, GXv_char3) ;
               remuneracionlicencia5.this.AV57LegLicCntDias = GXv_int8[0] ;
               remuneracionlicencia5.this.AV59LegLicenIni = GXv_date9[0] ;
               remuneracionlicencia5.this.AV66logDesdeFecha = GXv_date7[0] ;
               remuneracionlicencia5.this.AV67logHastaFecha = GXv_date6[0] ;
               remuneracionlicencia5.this.AV128LiqDPlus = GXv_decimal10[0] ;
               remuneracionlicencia5.this.AV209diasLog = GXv_char3[0] ;
               AV187averiguoPlus = true ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV57LegLicCntDias, 4, 0))+httpContext.getMessage( " &LiqPeriodo.EndOfMonth().Day() ", "")+GXutil.trim( GXutil.str( GXutil.day( GXutil.eomdate( AV65LiqPeriodo)), 10, 0))+httpContext.getMessage( " &LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV59LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               if ( AV57LegLicCntDias == GXutil.day( GXutil.eomdate( AV65LiqPeriodo)) )
               {
                  if ( AV112todosLosMeses30 )
                  {
                     AV57LegLicCntDias = (short)(30) ;
                     AV209diasLog += httpContext.getMessage( ". Fuerza a 30 días.", "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "setea 30 d", "")) ;
                  }
               }
               if ( AV57LegLicCntDias == 30 )
               {
                  AV62LiqDLog += httpContext.getMessage( " Periodo a lquidar todo el mes", "") ;
               }
               else
               {
                  GXv_char4[0] = AV208diasTooltip ;
                  new web.armatooltip(remoteHandle, context).execute( AV20CliCod, DecimalUtil.doubleToDec(AV57LegLicCntDias), AV209diasLog, true, GXv_char4) ;
                  remuneracionlicencia5.this.AV208diasTooltip = GXv_char4[0] ;
                  AV62LiqDLog = httpContext.getMessage( "Periodo de licencia a liquidar ", "") + GXutil.trim( AV208diasTooltip) + httpContext.getMessage( " días", "") ;
                  if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66logDesdeFecha)) )
                  {
                     AV62LiqDLog += httpContext.getMessage( " desde el ", "") + GXutil.trim( localUtil.dtoc( AV66logDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV67logHastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
                  }
               }
               AV58LegLicCntDias_dosDecimales = DecimalUtil.doubleToDec(AV57LegLicCntDias) ;
            }
         }
         else
         {
            AV116noGozadasEs = true ;
            AV151EmpBaseTipo = "licencia" ;
            GXt_char2 = AV152EmpBaseCod1 ;
            GXv_char4[0] = GXt_char2 ;
            new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV20CliCod, GXv_char4) ;
            remuneracionlicencia5.this.GXt_char2 = GXv_char4[0] ;
            AV152EmpBaseCod1 = GXt_char2 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "2 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV65LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            AV50inicioAnioLiqPeriodo = localUtil.ymdtod( GXutil.year( AV65LiqPeriodo), 1, 1) ;
            GXv_date9[0] = AV56LegFecIngreso ;
            GXv_date7[0] = AV55LegFecEgreso ;
            new web.getfecingresoyegreso(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, GXv_date9, GXv_date7) ;
            remuneracionlicencia5.this.AV56LegFecIngreso = GXv_date9[0] ;
            remuneracionlicencia5.this.AV55LegFecEgreso = GXv_date7[0] ;
            AV18caducaron = false ;
            GXv_int5[0] = AV204vacacionesmesDesdeMes ;
            GXv_int12[0] = AV203vacacionesMesHastaMes ;
            GXv_decimal10[0] = AV202EmpFracVacAnt ;
            new web.getemppervac(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, GXv_int5, GXv_int12, GXv_decimal10) ;
            remuneracionlicencia5.this.AV204vacacionesmesDesdeMes = GXv_int5[0] ;
            remuneracionlicencia5.this.AV203vacacionesMesHastaMes = GXv_int12[0] ;
            remuneracionlicencia5.this.AV202EmpFracVacAnt = GXv_decimal10[0] ;
            AV198vacacionesmesDesde = AV204vacacionesmesDesdeMes ;
            AV196vacacionesMesHasta = AV203vacacionesMesHastaMes ;
            if ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") == 0 )
            {
               AV13auxLegFecIngreso = AV56LegFecIngreso ;
               AV199auxLegFecEgreso = AV55LegFecEgreso ;
               if ( GXutil.month( AV55LegFecEgreso) < AV198vacacionesmesDesde )
               {
                  AV195tomados_LegLicCntDias = (short)(0) ;
               }
               else
               {
               }
            }
            else
            {
               if ( GXutil.year( AV56LegFecIngreso) >= GXutil.year( AV65LiqPeriodo) )
               {
                  AV62LiqDLog = httpContext.getMessage( "No se calcula porque ingresó en el ", "") + GXutil.trim( GXutil.str( GXutil.year( AV65LiqPeriodo), 10, 0)) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV199auxLegFecEgreso = localUtil.ymdtod( GXutil.year( AV65LiqPeriodo)-1, 12, 31) ;
               AV201diciembreAnioAntesAntesDate = localUtil.ymdtod( GXutil.year( AV65LiqPeriodo)-2, 12, 31) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "!!!&LegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV56LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &eneroAnioPasadoDate ", "")+GXutil.trim( localUtil.dtoc( AV200eneroAnioPasadoDate, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               if ( GXutil.resetTime(AV56LegFecIngreso).after( GXutil.resetTime( AV201diciembreAnioAntesAntesDate )) )
               {
                  AV13auxLegFecIngreso = AV201diciembreAnioAntesAntesDate ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "auc ", "")+GXutil.trim( localUtil.dtoc( AV13auxLegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               }
               else
               {
                  AV13auxLegFecIngreso = AV56LegFecIngreso ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "rea ", "")+GXutil.trim( localUtil.dtoc( AV13auxLegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&periodoVacAnalizarDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV80periodoVacAnalizarDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV59LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            GXv_int8[0] = AV195tomados_LegLicCntDias ;
            new web.getlegcuendiasgoz(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, "Vacaciones", (short)(GXutil.year( AV199auxLegFecEgreso)), GXv_int8) ;
            remuneracionlicencia5.this.AV195tomados_LegLicCntDias = GXv_int8[0] ;
            AV62LiqDLog += ". " + GXutil.trim( GXutil.str( AV195tomados_LegLicCntDias, 4, 0)) + httpContext.getMessage( " días de vacaciones gozadas en ", "") + GXutil.trim( GXutil.str( GXutil.year( AV199auxLegFecEgreso), 10, 0)) ;
            if ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") == 0 )
            {
               GXv_int8[0] = AV11aniosAntiguedad ;
               GXv_int13[0] = AV53jornadasTrabajadas ;
               GXv_int14[0] = AV194pendientes_LegLicCntDias ;
               GXv_char4[0] = AV135auxLiqDLog ;
               GXv_char3[0] = AV193jorTraLiqDLog ;
               GXv_char15[0] = "" ;
               GXv_int16[0] = (short)(0) ;
               GXv_int17[0] = (short)(0) ;
               GXv_char18[0] = AV133auxError ;
               new web.getdiasdevacacionesporantiguedad(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, AV65LiqPeriodo, AV13auxLegFecIngreso, AV199auxLegFecEgreso, AV70mensualTLiqCod, AV106ProcesoLiquidacion, AV52insertandoConceptos, true, true, GXv_int8, GXv_int13, GXv_int14, GXv_char4, GXv_char3, GXv_char15, GXv_int16, GXv_int17, GXv_char18) ;
               remuneracionlicencia5.this.AV11aniosAntiguedad = GXv_int8[0] ;
               remuneracionlicencia5.this.AV53jornadasTrabajadas = GXv_int13[0] ;
               remuneracionlicencia5.this.AV194pendientes_LegLicCntDias = GXv_int14[0] ;
               remuneracionlicencia5.this.AV135auxLiqDLog = GXv_char4[0] ;
               remuneracionlicencia5.this.AV193jorTraLiqDLog = GXv_char3[0] ;
               remuneracionlicencia5.this.AV133auxError = GXv_char18[0] ;
               if ( ! (GXutil.strcmp("", AV133auxError)==0) )
               {
                  AV8liqdcalculado = (byte)(0) ;
                  AV36error = GXutil.trim( AV133auxError) ;
                  AV62LiqDLog = GXutil.trim( AV36error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV62LiqDLog += httpContext.getMessage( ". Cálculo de días que corresponden: ", "") + GXutil.trim( AV135auxLiqDLog) ;
               AV194pendientes_LegLicCntDias = (short)(AV194pendientes_LegLicCntDias-AV195tomados_LegLicCntDias) ;
            }
            else
            {
               GXv_int17[0] = AV194pendientes_LegLicCntDias ;
               new web.licccgetsaldodisponible(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, "Vacaciones", (short)(GXutil.year( AV199auxLegFecEgreso)), GXv_int17) ;
               remuneracionlicencia5.this.AV194pendientes_LegLicCntDias = GXv_int17[0] ;
            }
            if ( AV194pendientes_LegLicCntDias < 0 )
            {
               AV194pendientes_LegLicCntDias = (short)(0) ;
            }
            if ( (0==AV194pendientes_LegLicCntDias) )
            {
               AV58LegLicCntDias_dosDecimales = DecimalUtil.ZERO ;
               if ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") == 0 )
               {
                  AV62LiqDLog += httpContext.getMessage( ". No corresponde porque ya se tomó los ", "") + GXutil.trim( GXutil.str( AV195tomados_LegLicCntDias, 4, 0)) + httpContext.getMessage( " días de vacaciones ", "") + GXutil.trim( localUtil.dtoc( AV65LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
               }
            }
            else
            {
               AV59LegLicenIni = AV55LegFecEgreso ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "xdaaa &&pendientes_LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV194pendientes_LegLicCntDias, 4, 0))) ;
               if ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") == 0 )
               {
                  if ( AV112todosLosMeses30 )
                  {
                     AV214anioCantDias = (short)(360) ;
                  }
                  else
                  {
                     AV215febreroDate = localUtil.ymdtod( GXutil.year( AV59LegLicenIni), 2, 1) ;
                     AV215febreroDate = GXutil.eomdate( AV215febreroDate) ;
                     if ( GXutil.day( AV215febreroDate) == 29 )
                     {
                        AV214anioCantDias = (short)(366) ;
                     }
                     else
                     {
                        AV214anioCantDias = (short)(365) ;
                     }
                  }
                  AV92proporcion = DecimalUtil.doubleToDec(AV53jornadasTrabajadas/ (double) (AV214anioCantDias)) ;
               }
               else
               {
                  AV92proporcion = DecimalUtil.doubleToDec(1) ;
               }
               AV58LegLicCntDias_dosDecimales = DecimalUtil.doubleToDec(AV194pendientes_LegLicCntDias).multiply(AV92proporcion) ;
               AV62LiqDLog += httpContext.getMessage( ". Se calculan los días de vacaciones no gozadas en ", "") + GXutil.trim( GXutil.str( AV58LegLicCntDias_dosDecimales, 8, 2)) ;
               if ( AV92proporcion.doubleValue() != 1 )
               {
                  GXv_char18[0] = AV192jornadadasTooltip ;
                  new web.armatooltip(remoteHandle, context).execute( AV20CliCod, DecimalUtil.doubleToDec(AV53jornadasTrabajadas), AV193jorTraLiqDLog, false, GXv_char18) ;
                  remuneracionlicencia5.this.AV192jornadadasTooltip = GXv_char18[0] ;
                  AV62LiqDLog += httpContext.getMessage( ", proporcionando los días pendientes de vacaciones ", "") + GXutil.trim( GXutil.str( AV194pendientes_LegLicCntDias, 4, 0)) + httpContext.getMessage( " por ", "") + GXutil.trim( GXutil.str( AV92proporcion, 8, 2)) + httpContext.getMessage( ", resultado de dividir los ", "") + GXutil.trim( AV192jornadadasTooltip) + httpContext.getMessage( " días activo entre ", "") + GXutil.trim( GXutil.str( AV214anioCantDias, 4, 0)) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&proporcion ", "")+GXutil.trim( GXutil.str( AV92proporcion, 8, 2))+httpContext.getMessage( " jorandastraba ", "")+GXutil.trim( GXutil.str( AV53jornadasTrabajadas, 4, 0))+httpContext.getMessage( " &LegLicCntDias_dosDecimales ", "")+GXutil.trim( GXutil.str( AV58LegLicCntDias_dosDecimales, 8, 2))+httpContext.getMessage( " &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV57LegLicCntDias, 4, 0))) ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "empbasecod1 ", "")+GXutil.trim( AV152EmpBaseCod1)+httpContext.getMessage( " &LegLicCntDias_dosDecimales  ", "")+GXutil.trim( GXutil.str( AV58LegLicCntDias_dosDecimales, 8, 2))+httpContext.getMessage( " &aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV11aniosAntiguedad, 4, 0))) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58LegLicCntDias_dosDecimales)==0) )
         {
            GXv_int17[0] = AV31diasMes ;
            new web.diasmes(remoteHandle, context).execute( AV20CliCod, AV65LiqPeriodo, GXv_int17) ;
            remuneracionlicencia5.this.AV31diasMes = (byte)((byte)(GXv_int17[0])) ;
            GXv_int17[0] = AV95CantProm1 ;
            GXv_int16[0] = AV96CantProm2 ;
            GXv_char18[0] = AV154duracionProm ;
            GXv_objcol_Sdtbase_promedio_base_promedioItem19[0] = AV167base_promedio ;
            new web.getcantmesesodiaspromediar(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV60LegNumero, AV54LegClase, AV151EmpBaseTipo, AV152EmpBaseCod1, AV153EmpBaseCod2, GXv_int17, GXv_int16, GXv_char18, GXv_objcol_Sdtbase_promedio_base_promedioItem19) ;
            remuneracionlicencia5.this.AV95CantProm1 = (byte)((byte)(GXv_int17[0])) ;
            remuneracionlicencia5.this.AV96CantProm2 = (byte)((byte)(GXv_int16[0])) ;
            remuneracionlicencia5.this.AV154duracionProm = GXv_char18[0] ;
            AV167base_promedio = GXv_objcol_Sdtbase_promedio_base_promedioItem19[0] ;
            if ( false && ( AV47ILT_Es ) )
            {
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "1 &CantProm2 ", "")+GXutil.trim( GXutil.str( AV96CantProm2, 2, 0))) ;
               if ( (0==AV96CantProm2) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "2 &CantProm1 ", "")+GXutil.trim( GXutil.str( AV95CantProm1, 2, 0))) ;
                  if ( ! (0==AV95CantProm1) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, "3") ;
                     AV82posibilidades = (short)(1) ;
                  }
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "4 &CantProm1 ", "")+GXutil.trim( GXutil.str( AV95CantProm1, 2, 0))) ;
                  if ( ! (0==AV95CantProm1) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, "5") ;
                     AV82posibilidades = (short)(2) ;
                  }
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&posibilidades ", "")+GXutil.trim( GXutil.str( AV82posibilidades, 4, 0))) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&LegClase ", "")+GXutil.trim( GXutil.str( AV54LegClase, 1, 0))) ;
               AV155fechaRemuActual = AV59LegLicenIni ;
               if ( ( GXutil.strcmp(AV78operandos, "[remuneracion_vacaciones_no_gozadas]") == 0 ) || ( GXutil.strcmp(AV78operandos, "{vacaciones_no_gozadas_ant}") == 0 ) )
               {
                  AV14AuxLiqNro = 0 ;
               }
               else
               {
                  AV14AuxLiqNro = AV63LiqNro ;
               }
               GXv_decimal10[0] = AV156remuActual ;
               GXv_decimal20[0] = AV157actualCantHorasDia ;
               GXv_decimal21[0] = AV191horasNormalesTotales ;
               GXv_decimal22[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char18[0] = AV133auxError ;
               GXv_int12[0] = AV134auxLiqDCalculado ;
               GXv_char15[0] = AV135auxLiqDLog ;
               new web.getremuneracionactuallicencia2(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV14AuxLiqNro, AV207LiqRelNro, AV97TLiqCod, AV60LegNumero, AV65LiqPeriodo, AV106ProcesoLiquidacion, AV205llamador, AV217tipo_tarifa, AV151EmpBaseTipo, AV152EmpBaseCod1, AV153EmpBaseCod2, AV155fechaRemuActual, AV189buscaDiaAnterior, GXv_decimal10, GXv_decimal20, GXv_decimal21, GXv_decimal22, GXv_char18, GXv_int12, GXv_char15) ;
               remuneracionlicencia5.this.AV156remuActual = GXv_decimal10[0] ;
               remuneracionlicencia5.this.AV157actualCantHorasDia = GXv_decimal20[0] ;
               remuneracionlicencia5.this.AV191horasNormalesTotales = GXv_decimal21[0] ;
               remuneracionlicencia5.this.AV133auxError = GXv_char18[0] ;
               remuneracionlicencia5.this.AV134auxLiqDCalculado = GXv_int12[0] ;
               remuneracionlicencia5.this.AV135auxLiqDLog = GXv_char15[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "&actualCantHorasDia ", "")+GXutil.trim( GXutil.str( AV157actualCantHorasDia, 6, 2))+httpContext.getMessage( " &auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV134auxLiqDCalculado, 1, 0))) ;
               if ( AV134auxLiqDCalculado == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "pudre", "")) ;
                  AV8liqdcalculado = (byte)(0) ;
                  AV36error = AV133auxError ;
                  AV62LiqDLog += ". " + AV133auxError ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV62LiqDLog += AV135auxLiqDLog ;
               if ( AV82posibilidades > 0 )
               {
                  if ( GXutil.strcmp(AV151EmpBaseTipo, "licencia") == 0 )
                  {
                     GXv_boolean11[0] = AV212remuneradaEs ;
                     new web.getlicesremunerada(remoteHandle, context).execute( AV152EmpBaseCod1, GXv_boolean11) ;
                     remuneracionlicencia5.this.AV212remuneradaEs = GXv_boolean11[0] ;
                  }
                  else
                  {
                     AV212remuneradaEs = true ;
                  }
                  GXv_decimal22[0] = AV182promImportes ;
                  GXv_char18[0] = AV181promLiqDLog ;
                  GXv_char15[0] = AV133auxError ;
                  new web.recorrerpromedios(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV207LiqRelNro, AV60LegNumero, AV65LiqPeriodo, AV151EmpBaseTipo, AV97TLiqCod, AV70mensualTLiqCod, AV54LegClase, AV217tipo_tarifa, AV82posibilidades, AV95CantProm1, AV96CantProm2, AV154duracionProm, AV31diasMes, AV157actualCantHorasDia, AV212remuneradaEs, GXv_decimal22, GXv_char18, GXv_char15) ;
                  remuneracionlicencia5.this.AV182promImportes = GXv_decimal22[0] ;
                  remuneracionlicencia5.this.AV181promLiqDLog = GXv_char18[0] ;
                  remuneracionlicencia5.this.AV133auxError = GXv_char15[0] ;
                  if ( ! (GXutil.strcmp("", AV133auxError)==0) )
                  {
                     AV8liqdcalculado = (byte)(0) ;
                     AV36error = GXutil.trim( AV133auxError) ;
                     AV62LiqDLog = GXutil.trim( AV36error) ;
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               if ( AV31diasMes > 0 )
               {
                  if ( ! (GXutil.strcmp("", AV62LiqDLog)==0) )
                  {
                     AV62LiqDLog += ". " ;
                  }
                  if ( GXutil.strcmp(AV217tipo_tarifa, "H") == 0 )
                  {
                     AV48Importes = AV156remuActual ;
                     if ( AV189buscaDiaAnterior )
                     {
                        AV62LiqDLog += httpContext.getMessage( "Se inicializa valor con la remuneración fija del día anterior ", "") + GXutil.trim( GXutil.str( AV156remuActual, 14, 2)) ;
                        AV62LiqDLog += httpContext.getMessage( ", correspondiente al día ", "") + GXutil.trim( localUtil.dtoc( AV155fechaRemuActual, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
                     }
                     else
                     {
                        AV62LiqDLog += httpContext.getMessage( "Se inicializa valor con la remuneración fija ", "") + GXutil.trim( GXutil.str( AV156remuActual, 14, 2)) ;
                     }
                     if ( DecimalUtil.compareTo(AV191horasNormalesTotales, AV157actualCantHorasDia) != 0 )
                     {
                        if ( AV191horasNormalesTotales.doubleValue() > 0 )
                        {
                           AV48Importes = AV48Importes.divide(AV191horasNormalesTotales, 18, java.math.RoundingMode.DOWN) ;
                           AV62LiqDLog += httpContext.getMessage( ". Se divide entre ", "") + GXutil.trim( GXutil.str( AV191horasNormalesTotales, 9, 2)) + httpContext.getMessage( " horas", "") ;
                        }
                     }
                     if ( ( DecimalUtil.compareTo(AV191horasNormalesTotales, AV157actualCantHorasDia) != 0 ) || ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 ) )
                     {
                        if ( GXutil.strcmp(AV78operandos, "{feriado_trabajado_horas}") == 0 )
                        {
                           AV48Importes = AV48Importes.multiply(AV61LiqDCanti) ;
                           AV62LiqDLog += httpContext.getMessage( ", se multiplica por ", "") + GXutil.trim( GXutil.str( AV61LiqDCanti, 14, 2)) + httpContext.getMessage( " horas ingresadas por novedad.", "") ;
                        }
                        else
                        {
                           AV48Importes = AV48Importes.multiply(AV157actualCantHorasDia) ;
                           AV62LiqDLog += httpContext.getMessage( ", se multiplica por ", "") + GXutil.trim( GXutil.str( AV157actualCantHorasDia, 6, 2)) + httpContext.getMessage( " horas de la jornada.", "") ;
                        }
                     }
                  }
                  else
                  {
                     AV139remuFijaActualDiaImportes = AV156remuActual.divide(DecimalUtil.doubleToDec(AV31diasMes), 18, java.math.RoundingMode.DOWN) ;
                     AV48Importes = AV139remuFijaActualDiaImportes ;
                     AV62LiqDLog += httpContext.getMessage( "Se inicializa con el valor proporcional a un día de la remuneración fija actual ", "") ;
                     AV62LiqDLog += GXutil.trim( GXutil.str( AV139remuFijaActualDiaImportes, 14, 2)) + httpContext.getMessage( " correspondiente a la remuneración fija del mes ", "") + GXutil.trim( localUtil.cmonth( AV155fechaRemuActual, httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( AV156remuActual, 14, 2)) ;
                     AV62LiqDLog += httpContext.getMessage( " dividido entre ", "") + GXutil.trim( GXutil.str( AV31diasMes, 2, 0)) + httpContext.getMessage( " días", "") ;
                  }
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV182promImportes)==0) )
                  {
                     AV48Importes = AV48Importes.add(AV182promImportes) ;
                     AV62LiqDLog += AV181promLiqDLog ;
                  }
                  if ( GXutil.strcmp(AV151EmpBaseTipo, "feriado") != 0 )
                  {
                     if ( AV58LegLicCntDias_dosDecimales.doubleValue() != 1 )
                     {
                        AV62LiqDLog += httpContext.getMessage( ". Valor total por día: ", "") + GXutil.trim( GXutil.str( AV48Importes, 14, 2)) ;
                        AV48Importes = AV48Importes.multiply(AV58LegLicCntDias_dosDecimales) ;
                        if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92proporcion)==0) )
                        {
                           AV62LiqDLog += httpContext.getMessage( ". Lo multiplica por ", "") + GXutil.trim( GXutil.str( GXutil.roundDecimal( AV58LegLicCntDias_dosDecimales, 0), 10, 0)) + httpContext.getMessage( " días de licencia", "") ;
                        }
                        else
                        {
                           AV62LiqDLog += httpContext.getMessage( ". Lo multiplica por ", "") + GXutil.trim( GXutil.str( AV58LegLicCntDias_dosDecimales, 8, 2)) + httpContext.getMessage( " días de licencia", "") ;
                        }
                        AV62LiqDLog += httpContext.getMessage( " quedando en ", "") + GXutil.trim( GXutil.str( AV48Importes, 14, 2)) ;
                     }
                  }
                  if ( GXutil.strcmp(AV152EmpBaseCod1, new web.codigodesituacioniltart(remoteHandle, context).executeUdp( AV20CliCod)) == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     GXv_int12[0] = AV179ConSacDeven ;
                     new web.getconceptodeveng(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_int12) ;
                     remuneracionlicencia5.this.AV179ConSacDeven = GXv_int12[0] ;
                     if ( (0==AV179ConSacDeven) )
                     {
                        AV48Importes = AV48Importes.multiply(DecimalUtil.stringToDec("1.083")) ;
                        AV62LiqDLog += httpContext.getMessage( ". Se multiplica por 1.083 para agregar el 8.3% de SAC al tener configurado el concepto en \"Tipo devengamiento\": No Aplica", "") ;
                     }
                  }
               }
               else
               {
                  AV48Importes = DecimalUtil.ZERO ;
                  AV62LiqDLog += httpContext.getMessage( ". Se inicializa valor en cero por recuperar cantidad de días del mes para el cálculo en cero", "") ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "importes ", "")+GXutil.trim( GXutil.str( AV48Importes, 14, 2))+httpContext.getMessage( " diasmes ", "")+GXutil.trim( GXutil.str( AV31diasMes, 2, 0))+httpContext.getMessage( " cantdiasliec ", "")+GXutil.trim( GXutil.str( AV58LegLicCntDias_dosDecimales, 8, 2))) ;
            }
         }
         if ( ! AV190descuentoEs )
         {
            if ( ( GXutil.strcmp(AV217tipo_tarifa, "P") == 0 ) && ( GXutil.strcmp(AV216LegModTra, "E") == 0 ) )
            {
               GXv_int12[0] = AV213ConVigencia ;
               new web.getconceptovigencia(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_int12) ;
               remuneracionlicencia5.this.AV213ConVigencia = GXv_int12[0] ;
               if ( AV213ConVigencia == 0 )
               {
                  GXv_int12[0] = AV185EmpTipoExp ;
                  new web.getemptipoexp(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, GXv_int12) ;
                  remuneracionlicencia5.this.AV185EmpTipoExp = GXv_int12[0] ;
                  if ( AV185EmpTipoExp == 2 )
                  {
                     if ( ! AV187averiguoPlus )
                     {
                        GXv_int17[0] = AV126PaiCod ;
                        new web.clientegetpais(remoteHandle, context).execute( AV20CliCod, GXv_int17) ;
                        remuneracionlicencia5.this.AV126PaiCod = GXv_int17[0] ;
                        GXv_char18[0] = AV186ConveCodigo ;
                        new web.empleadogetconvenio(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV60LegNumero, GXv_char18) ;
                        remuneracionlicencia5.this.AV186ConveCodigo = GXv_char18[0] ;
                        GXv_decimal22[0] = AV128LiqDPlus ;
                        new web.getplusdebasedecalculo(remoteHandle, context).execute( AV20CliCod, AV35EmpCod, AV63LiqNro, AV60LegNumero, AV126PaiCod, AV186ConveCodigo, AV54LegClase, AV151EmpBaseTipo, AV152EmpBaseCod1, AV153EmpBaseCod2, GXv_decimal22) ;
                        remuneracionlicencia5.this.AV128LiqDPlus = GXv_decimal22[0] ;
                     }
                     if ( AV128LiqDPlus.doubleValue() > 0 )
                     {
                        AV188auxLiqdPlus = DecimalUtil.doubleToDec(1).add(AV128LiqDPlus) ;
                        AV48Importes = AV48Importes.multiply(AV188auxLiqdPlus) ;
                        AV62LiqDLog += httpContext.getMessage( ". Lo multiplica por el plus ", "") + GXutil.trim( GXutil.str( AV188auxLiqdPlus, 6, 4)) ;
                     }
                  }
               }
            }
         }
      }
      if ( AV190descuentoEs )
      {
         AV48Importes = AV48Importes.multiply(DecimalUtil.doubleToDec(-1)) ;
         AV62LiqDLog += httpContext.getMessage( ". Se cambia el signo por ser descuento", "") ;
      }
      else
      {
         GXv_char18[0] = AV36error ;
         GXv_char15[0] = AV62LiqDLog ;
         GXv_int12[0] = AV8liqdcalculado ;
         new web.darerrormenorcero(remoteHandle, context).execute( AV48Importes, GXv_char18, GXv_char15, GXv_int12) ;
         remuneracionlicencia5.this.AV36error = GXv_char18[0] ;
         remuneracionlicencia5.this.AV62LiqDLog = GXv_char15[0] ;
         remuneracionlicencia5.this.AV8liqdcalculado = GXv_int12[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV221Pgmname, httpContext.getMessage( "liqdcalculado ", "")+GXutil.trim( GXutil.str( AV8liqdcalculado, 1, 0))+httpContext.getMessage( " &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV57LegLicCntDias, 4, 0))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'AUX PERIODO' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV97TLiqCod, AV70mensualTLiqCod) == 0 ) && ( AV54LegClase == 2 ) )
      {
         AV15AuxLiqPeriodo = localUtil.ymdtod( GXutil.year( AV65LiqPeriodo), GXutil.month( AV65LiqPeriodo), 16) ;
      }
      else
      {
         AV15AuxLiqPeriodo = AV65LiqPeriodo ;
      }
   }

   protected void cleanup( )
   {
      this.aP14[0] = remuneracionlicencia5.this.AV48Importes;
      this.aP15[0] = remuneracionlicencia5.this.AV58LegLicCntDias_dosDecimales;
      this.aP16[0] = remuneracionlicencia5.this.AV8liqdcalculado;
      this.aP17[0] = remuneracionlicencia5.this.AV36error;
      this.aP18[0] = remuneracionlicencia5.this.AV62LiqDLog;
      this.aP19[0] = remuneracionlicencia5.this.AV128LiqDPlus;
      this.aP20[0] = remuneracionlicencia5.this.AV157actualCantHorasDia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV48Importes = DecimalUtil.ZERO ;
      AV58LegLicCntDias_dosDecimales = DecimalUtil.ZERO ;
      AV36error = "" ;
      AV62LiqDLog = "" ;
      AV128LiqDPlus = DecimalUtil.ZERO ;
      AV157actualCantHorasDia = DecimalUtil.ZERO ;
      AV221Pgmname = "" ;
      AV113parmValue = "" ;
      AV70mensualTLiqCod = "" ;
      AV216LegModTra = "" ;
      AV217tipo_tarifa = "" ;
      AV97TLiqCod = "" ;
      AV9adelVacMesProxConCodigo = "" ;
      AV152EmpBaseCod1 = "" ;
      AV153EmpBaseCod2 = "" ;
      AV162proximoPeriodo = GXutil.nullDate() ;
      AV51iniPeriodo = GXutil.nullDate() ;
      AV43finPeriodo = GXutil.nullDate() ;
      AV59LegLicenIni = GXutil.nullDate() ;
      AV161date = GXutil.nullDate() ;
      AV110CondicionLiquidacion = "" ;
      AV94sitCodigo = "" ;
      AV93quincenaTLiqCod = "" ;
      GXt_char1 = "" ;
      AV209diasLog = "" ;
      AV151EmpBaseTipo = "" ;
      AV66logDesdeFecha = GXutil.nullDate() ;
      AV67logHastaFecha = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV208diasTooltip = "" ;
      GXt_char2 = "" ;
      AV50inicioAnioLiqPeriodo = GXutil.nullDate() ;
      AV56LegFecIngreso = GXutil.nullDate() ;
      GXv_date9 = new java.util.Date[1] ;
      AV55LegFecEgreso = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_int5 = new byte[1] ;
      AV202EmpFracVacAnt = DecimalUtil.ZERO ;
      AV13auxLegFecIngreso = GXutil.nullDate() ;
      AV199auxLegFecEgreso = GXutil.nullDate() ;
      AV201diciembreAnioAntesAntesDate = GXutil.nullDate() ;
      AV200eneroAnioPasadoDate = GXutil.nullDate() ;
      AV80periodoVacAnalizarDesdeFecha = GXutil.nullDate() ;
      GXv_int8 = new short[1] ;
      GXv_int13 = new short[1] ;
      GXv_int14 = new short[1] ;
      AV135auxLiqDLog = "" ;
      GXv_char4 = new String[1] ;
      AV193jorTraLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      AV133auxError = "" ;
      AV215febreroDate = GXutil.nullDate() ;
      AV92proporcion = DecimalUtil.ZERO ;
      AV192jornadadasTooltip = "" ;
      GXv_int16 = new short[1] ;
      AV154duracionProm = "" ;
      AV167base_promedio = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>(web.Sdtbase_promedio_base_promedioItem.class, "base_promedioItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtbase_promedio_base_promedioItem19 = new GXBaseCollection[1] ;
      AV155fechaRemuActual = GXutil.nullDate() ;
      AV156remuActual = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal20 = new java.math.BigDecimal[1] ;
      AV191horasNormalesTotales = DecimalUtil.ZERO ;
      GXv_decimal21 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      AV182promImportes = DecimalUtil.ZERO ;
      AV181promLiqDLog = "" ;
      AV139remuFijaActualDiaImportes = DecimalUtil.ZERO ;
      GXv_int17 = new short[1] ;
      AV186ConveCodigo = "" ;
      GXv_decimal22 = new java.math.BigDecimal[1] ;
      AV188auxLiqdPlus = DecimalUtil.ZERO ;
      GXv_char18 = new String[1] ;
      GXv_char15 = new String[1] ;
      GXv_int12 = new byte[1] ;
      AV15AuxLiqPeriodo = GXutil.nullDate() ;
      AV221Pgmname = "RemuneracionLicencia5" ;
      /* GeneXus formulas. */
      AV221Pgmname = "RemuneracionLicencia5" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8liqdcalculado ;
   private byte AV54LegClase ;
   private byte AV204vacacionesmesDesdeMes ;
   private byte GXv_int5[] ;
   private byte AV203vacacionesMesHastaMes ;
   private byte AV31diasMes ;
   private byte AV95CantProm1 ;
   private byte AV96CantProm2 ;
   private byte AV134auxLiqDCalculado ;
   private byte AV179ConSacDeven ;
   private byte AV213ConVigencia ;
   private byte AV185EmpTipoExp ;
   private byte GXv_int12[] ;
   private short AV35EmpCod ;
   private short AV57LegLicCntDias ;
   private short AV198vacacionesmesDesde ;
   private short AV196vacacionesMesHasta ;
   private short AV195tomados_LegLicCntDias ;
   private short AV11aniosAntiguedad ;
   private short GXv_int8[] ;
   private short AV53jornadasTrabajadas ;
   private short GXv_int13[] ;
   private short AV194pendientes_LegLicCntDias ;
   private short GXv_int14[] ;
   private short AV214anioCantDias ;
   private short GXv_int16[] ;
   private short AV82posibilidades ;
   private short AV126PaiCod ;
   private short GXv_int17[] ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV63LiqNro ;
   private int AV207LiqRelNro ;
   private int AV60LegNumero ;
   private int AV14AuxLiqNro ;
   private java.math.BigDecimal AV61LiqDCanti ;
   private java.math.BigDecimal AV48Importes ;
   private java.math.BigDecimal AV58LegLicCntDias_dosDecimales ;
   private java.math.BigDecimal AV128LiqDPlus ;
   private java.math.BigDecimal AV157actualCantHorasDia ;
   private java.math.BigDecimal AV202EmpFracVacAnt ;
   private java.math.BigDecimal AV92proporcion ;
   private java.math.BigDecimal AV156remuActual ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal20[] ;
   private java.math.BigDecimal AV191horasNormalesTotales ;
   private java.math.BigDecimal GXv_decimal21[] ;
   private java.math.BigDecimal AV182promImportes ;
   private java.math.BigDecimal AV139remuFijaActualDiaImportes ;
   private java.math.BigDecimal GXv_decimal22[] ;
   private java.math.BigDecimal AV188auxLiqdPlus ;
   private String AV78operandos ;
   private String AV21ConCodigo ;
   private String AV106ProcesoLiquidacion ;
   private String AV205llamador ;
   private String AV221Pgmname ;
   private String AV70mensualTLiqCod ;
   private String AV216LegModTra ;
   private String AV217tipo_tarifa ;
   private String AV97TLiqCod ;
   private String AV9adelVacMesProxConCodigo ;
   private String AV152EmpBaseCod1 ;
   private String AV153EmpBaseCod2 ;
   private String AV110CondicionLiquidacion ;
   private String AV94sitCodigo ;
   private String AV93quincenaTLiqCod ;
   private String GXt_char1 ;
   private String AV151EmpBaseTipo ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String AV154duracionProm ;
   private String AV186ConveCodigo ;
   private String GXv_char18[] ;
   private String GXv_char15[] ;
   private java.util.Date AV65LiqPeriodo ;
   private java.util.Date AV183DAgeFecDes ;
   private java.util.Date AV162proximoPeriodo ;
   private java.util.Date AV51iniPeriodo ;
   private java.util.Date AV43finPeriodo ;
   private java.util.Date AV59LegLicenIni ;
   private java.util.Date AV161date ;
   private java.util.Date AV66logDesdeFecha ;
   private java.util.Date AV67logHastaFecha ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date AV50inicioAnioLiqPeriodo ;
   private java.util.Date AV56LegFecIngreso ;
   private java.util.Date GXv_date9[] ;
   private java.util.Date AV55LegFecEgreso ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV13auxLegFecIngreso ;
   private java.util.Date AV199auxLegFecEgreso ;
   private java.util.Date AV201diciembreAnioAntesAntesDate ;
   private java.util.Date AV200eneroAnioPasadoDate ;
   private java.util.Date AV80periodoVacAnalizarDesdeFecha ;
   private java.util.Date AV215febreroDate ;
   private java.util.Date AV155fechaRemuActual ;
   private java.util.Date AV15AuxLiqPeriodo ;
   private boolean AV190descuentoEs ;
   private boolean AV52insertandoConceptos ;
   private boolean AV112todosLosMeses30 ;
   private boolean AV168adelantoVacEs ;
   private boolean AV187averiguoPlus ;
   private boolean returnInSub ;
   private boolean AV210conGoceEs ;
   private boolean AV116noGozadasEs ;
   private boolean AV18caducaron ;
   private boolean AV47ILT_Es ;
   private boolean AV189buscaDiaAnterior ;
   private boolean AV212remuneradaEs ;
   private boolean GXv_boolean11[] ;
   private boolean Cond_result ;
   private String AV62LiqDLog ;
   private String AV113parmValue ;
   private String AV135auxLiqDLog ;
   private String AV193jorTraLiqDLog ;
   private String AV181promLiqDLog ;
   private String AV36error ;
   private String AV209diasLog ;
   private String AV208diasTooltip ;
   private String AV133auxError ;
   private String AV192jornadadasTooltip ;
   private java.math.BigDecimal[] aP20 ;
   private java.math.BigDecimal[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private byte[] aP16 ;
   private String[] aP17 ;
   private String[] aP18 ;
   private java.math.BigDecimal[] aP19 ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> AV167base_promedio ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> GXv_objcol_Sdtbase_promedio_base_promedioItem19[] ;
}

