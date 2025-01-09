package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliqsinganancias extends GXProcedure
{
   public procliqsinganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliqsinganancias.class ), "" );
   }

   public procliqsinganancias( int remoteHandle ,
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
                             byte aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             boolean[] aP9 ,
                             boolean[] aP10 )
   {
      procliqsinganancias.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        byte aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        boolean[] aP9 ,
                        boolean[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             byte aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             boolean[] aP9 ,
                             boolean[] aP10 ,
                             String[] aP11 )
   {
      procliqsinganancias.this.AV42CliCod = aP0;
      procliqsinganancias.this.AV11EmpCod = aP1;
      procliqsinganancias.this.AV97LiqNro = aP2;
      procliqsinganancias.this.AV99LiqRelNro = aP3;
      procliqsinganancias.this.AV119parmLegNumero = aP4;
      procliqsinganancias.this.AV90LiqDLote = aP5;
      procliqsinganancias.this.AV124programa = aP6;
      procliqsinganancias.this.AV148todosInsertados = aP7;
      procliqsinganancias.this.AV10ConveCodigo = aP8;
      procliqsinganancias.this.aP9 = aP9;
      procliqsinganancias.this.aP10 = aP10;
      procliqsinganancias.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV84LegNumero = AV119parmLegNumero ;
      GXt_date1 = AV98LiqPeriodo ;
      GXv_date2[0] = GXt_date1 ;
      new web.getperiodoliquidacion(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, GXv_date2) ;
      procliqsinganancias.this.GXt_date1 = GXv_date2[0] ;
      AV98LiqPeriodo = GXt_date1 ;
      GXv_int3[0] = AV66EmpTipoExp ;
      new web.getemptipoexp(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, GXv_int3) ;
      procliqsinganancias.this.AV66EmpTipoExp = GXv_int3[0] ;
      GXt_char4 = AV65egresoTLiqCod ;
      GXt_char5 = AV65egresoTLiqCod ;
      GXv_char6[0] = GXt_char5 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      procliqsinganancias.this.GXt_char5 = GXv_char6[0] ;
      GXv_char7[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV42CliCod, GXt_char5, GXv_char7) ;
      procliqsinganancias.this.GXt_char4 = GXv_char7[0] ;
      AV65egresoTLiqCod = GXt_char4 ;
      GXt_char5 = AV143sueldoConCodigo ;
      GXt_char4 = AV143sueldoConCodigo ;
      GXv_char7[0] = GXt_char4 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char7) ;
      procliqsinganancias.this.GXt_char4 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char5 ;
      new web.getparametro(remoteHandle, context).execute( AV42CliCod, GXt_char4, GXv_char6) ;
      procliqsinganancias.this.GXt_char5 = GXv_char6[0] ;
      AV143sueldoConCodigo = GXt_char5 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "proceso pendientes por ", "")+AV124programa) ;
      AV80i = (short)(1) ;
      GXt_char5 = AV147TLiqCod ;
      GXv_char7[0] = GXt_char5 ;
      new web.gettipoliq(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, GXv_char7) ;
      procliqsinganancias.this.GXt_char5 = GXv_char7[0] ;
      AV147TLiqCod = GXt_char5 ;
      GXt_int8 = AV118PaiCod ;
      GXv_int9[0] = GXt_int8 ;
      new web.clientegetpais(remoteHandle, context).execute( AV42CliCod, GXv_int9) ;
      procliqsinganancias.this.GXt_int8 = GXv_int9[0] ;
      AV118PaiCod = GXt_int8 ;
      GXt_char5 = AV101liquidaSAConcodigo ;
      GXt_char4 = AV101liquidaSAConcodigo ;
      GXv_char7[0] = GXt_char4 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char7) ;
      procliqsinganancias.this.GXt_char4 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char5 ;
      new web.getparametro(remoteHandle, context).execute( AV42CliCod, GXt_char4, GXv_char6) ;
      procliqsinganancias.this.GXt_char5 = GXv_char6[0] ;
      AV101liquidaSAConcodigo = GXt_char5 ;
      AV69errores = "" ;
      /* Execute user subroutine: 'CALCULAR CONCEPTOS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Using cursor P02CM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV42CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV97LiqNro), Integer.valueOf(AV119parmLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02CM2_A6LegNumero[0] ;
         A31LiqNro = P02CM2_A31LiqNro[0] ;
         A1EmpCod = P02CM2_A1EmpCod[0] ;
         A3CliCod = P02CM2_A3CliCod[0] ;
         A883LIqLegIteraciones = P02CM2_A883LIqLegIteraciones[0] ;
         A2268LiqLegProcesado = P02CM2_A2268LiqLegProcesado[0] ;
         A883LIqLegIteraciones = AV55d ;
         A2268LiqLegProcesado = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "LIqLegIteraciones ", "")+GXutil.trim( GXutil.str( A883LIqLegIteraciones, 4, 0))+httpContext.getMessage( " &d ", "")+GXutil.trim( GXutil.str( AV55d, 4, 0))) ;
         /* Using cursor P02CM3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A883LIqLegIteraciones), Byte.valueOf(A2268LiqLegProcesado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( ! AV122procesoAlgo )
      {
         AV68errorComunHay = true ;
      }
      if ( ( AV40ciclicoErrorHay ) || ( AV68errorComunHay ) )
      {
         GXv_boolean10[0] = true ;
         new web.setearerrornocalculado(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, AV119parmLegNumero, AV40ciclicoErrorHay, GXv_boolean10) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "terminó", "")) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'CALCULAR CONCEPTOS' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV129saldoProrrateoBonosPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV42CliCod, "[cuotas_prorrateo]", false, false, GXv_char7) ;
      procliqsinganancias.this.AV129saldoProrrateoBonosPalabra = GXv_char7[0] ;
      GXv_boolean10[0] = AV33calcularSAC ;
      new web.calcularsac(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, AV84LegNumero, AV147TLiqCod, AV98LiqPeriodo, "", AV123ProcesoLiquidacion, GXv_boolean10) ;
      procliqsinganancias.this.AV33calcularSAC = GXv_boolean10[0] ;
      AV158yaHizoInsertsAdicionales = (short)((byte)((false)?1:0)) ;
      AV55d = (short)(0) ;
      AV133seguir = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV84LegNumero, 8, 0))+httpContext.getMessage( " cerea &d ", "")) ;
      while ( AV133seguir )
      {
         AV37cantPendientes = (short)(0) ;
         AV120pendientes_ConCodigo.clear();
         new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV84LegNumero, 8, 0))+httpContext.getMessage( " ini vuelta ", "")+GXutil.trim( GXutil.str( AV55d, 4, 0))+httpContext.getMessage( " seguir ", "")+GXutil.trim( GXutil.booltostr( AV133seguir))) ;
         AV144tienePendientes = false ;
         AV166GXLvl70 = (byte)(0) ;
         /* Using cursor P02CM4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV42CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV97LiqNro), Integer.valueOf(AV84LegNumero)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A3CliCod = P02CM4_A3CliCod[0] ;
            A1EmpCod = P02CM4_A1EmpCod[0] ;
            A31LiqNro = P02CM4_A31LiqNro[0] ;
            A6LegNumero = P02CM4_A6LegNumero[0] ;
            A507LiqDCalculado = P02CM4_A507LiqDCalculado[0] ;
            A274LiqDFormula = P02CM4_A274LiqDFormula[0] ;
            n274LiqDFormula = P02CM4_n274LiqDFormula[0] ;
            A394DConCodigo = P02CM4_A394DConCodigo[0] ;
            A464DTipoConCod = P02CM4_A464DTipoConCod[0] ;
            A1487DConCondicion = P02CM4_A1487DConCondicion[0] ;
            A468DSubTipoConCod1 = P02CM4_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P02CM4_n468DSubTipoConCod1[0] ;
            A732DSubTipoConCod2 = P02CM4_A732DSubTipoConCod2[0] ;
            n732DSubTipoConCod2 = P02CM4_n732DSubTipoConCod2[0] ;
            A504LiqDForOrig = P02CM4_A504LiqDForOrig[0] ;
            A393DConDescrip = P02CM4_A393DConDescrip[0] ;
            A1070LiqDLog = P02CM4_A1070LiqDLog[0] ;
            A1072LiqDLogRecal = P02CM4_A1072LiqDLogRecal[0] ;
            A397DLiqPeriodo = P02CM4_A397DLiqPeriodo[0] ;
            A508LiqDFormulaHTML = P02CM4_A508LiqDFormulaHTML[0] ;
            n508LiqDFormulaHTML = P02CM4_n508LiqDFormulaHTML[0] ;
            A400DTLiqCod = P02CM4_A400DTLiqCod[0] ;
            A269LiqDCanti = P02CM4_A269LiqDCanti[0] ;
            n269LiqDCanti = P02CM4_n269LiqDCanti[0] ;
            A1760DAgeFecDes = P02CM4_A1760DAgeFecDes[0] ;
            n1760DAgeFecDes = P02CM4_n1760DAgeFecDes[0] ;
            A276LiqDImporte = P02CM4_A276LiqDImporte[0] ;
            n276LiqDImporte = P02CM4_n276LiqDImporte[0] ;
            A277LiqDValUni = P02CM4_A277LiqDValUni[0] ;
            n277LiqDValUni = P02CM4_n277LiqDValUni[0] ;
            A270LiqDErrorDesc = P02CM4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P02CM4_n270LiqDErrorDesc[0] ;
            A1219LiqDPlus = P02CM4_A1219LiqDPlus[0] ;
            A275LiqDImpCalcu = P02CM4_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P02CM4_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P02CM4_A764LiqDImpReCalcu[0] ;
            A502LiqDMostrar = P02CM4_A502LiqDMostrar[0] ;
            A876LiqDReFormulaHTML = P02CM4_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = P02CM4_n876LiqDReFormulaHTML[0] ;
            A749LiqDFormuAux = P02CM4_A749LiqDFormuAux[0] ;
            n749LiqDFormuAux = P02CM4_n749LiqDFormuAux[0] ;
            A968LiqDUniMed = P02CM4_A968LiqDUniMed[0] ;
            A918LiqDVueltaRes = P02CM4_A918LiqDVueltaRes[0] ;
            A1469LiqDSeg = P02CM4_A1469LiqDSeg[0] ;
            A509LiqDOrdEjec = P02CM4_A509LiqDOrdEjec[0] ;
            A81LiqDSecuencial = P02CM4_A81LiqDSecuencial[0] ;
            AV166GXLvl70 = (byte)(1) ;
            AV122procesoAlgo = true ;
            AV144tienePendientes = true ;
            AV44comienzo = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
            AV81impliLiqDLog = "" ;
            AV86LiqDFormula = "" ;
            AV35calculoCero = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ini DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDFormula ", "")+GXutil.trim( A274LiqDFormula)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "&egresoTLiqCod ", "")+GXutil.trim( AV65egresoTLiqCod)+httpContext.getMessage( " tliqcod ", "")+GXutil.trim( AV147TLiqCod)) ;
            if ( GXutil.strcmp(AV147TLiqCod, AV65egresoTLiqCod) == 0 )
            {
               GXv_boolean10[0] = AV14LiqOK ;
               GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
               new web.conceptoaplicamotegr(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV84LegNumero, A394DConCodigo, GXv_boolean10, GXv_decimal11) ;
               procliqsinganancias.this.AV14LiqOK = GXv_boolean10[0] ;
            }
            else
            {
               AV14LiqOK = true ;
            }
            if ( ! AV14LiqOK )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "elimina ", "")+GXutil.trim( A394DConCodigo)) ;
               /* Using cursor P02CM5 */
               pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            }
            else
            {
               GXt_boolean12 = AV73EsConceptoImprimible ;
               GXv_boolean10[0] = GXt_boolean12 ;
               new web.esconceptoimprimible(remoteHandle, context).execute( A464DTipoConCod, GXv_boolean10) ;
               procliqsinganancias.this.GXt_boolean12 = GXv_boolean10[0] ;
               AV73EsConceptoImprimible = GXt_boolean12 ;
               if ( ! AV73EsConceptoImprimible )
               {
                  if ( GXutil.strcmp(A1487DConCondicion, "A0") == 0 )
                  {
                     AV15agregarConcepto = true ;
                  }
                  else
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "calcular conceptos2 &calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV33calcularSAC))) ;
                     GXv_boolean10[0] = AV15agregarConcepto ;
                     GXv_boolean13[0] = AV114obligatorioEs ;
                     GXv_char7[0] = AV48ConCondicion ;
                     GXv_char6[0] = AV155validacionLiqDLog ;
                     new web.validarconcepto2(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, AV84LegNumero, AV98LiqPeriodo, AV32calcularContribuciones, A468DSubTipoConCod1, A732DSubTipoConCod2, AV33calcularSAC, A394DConCodigo, false, A504LiqDForOrig, A393DConDescrip, "", AV101liquidaSAConcodigo, "", false, "Calculo", true, GXv_boolean10, GXv_boolean13, GXv_char7, GXv_char6) ;
                     procliqsinganancias.this.AV15agregarConcepto = GXv_boolean10[0] ;
                     procliqsinganancias.this.AV114obligatorioEs = GXv_boolean13[0] ;
                     procliqsinganancias.this.AV48ConCondicion = GXv_char7[0] ;
                     procliqsinganancias.this.AV155validacionLiqDLog = GXv_char6[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "calcular conceptos3 &calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV33calcularSAC))) ;
                  }
               }
               else
               {
                  AV15agregarConcepto = true ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "---3 &agregarConcepto ", "")+GXutil.trim( GXutil.booltostr( AV15agregarConcepto))) ;
               if ( ! AV15agregarConcepto )
               {
                  GXv_boolean13[0] = AV134segundoPlanoEs ;
                  new web.getconceptosegundoplano(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV84LegNumero, A394DConCodigo, AV118PaiCod, GXv_boolean13) ;
                  procliqsinganancias.this.AV134segundoPlanoEs = GXv_boolean13[0] ;
                  if ( AV134segundoPlanoEs )
                  {
                     A507LiqDCalculado = (byte)(3) ;
                  }
                  else
                  {
                     A507LiqDCalculado = (byte)(2) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "pone en 2", "")) ;
                     A1070LiqDLog += httpContext.getMessage( "-Falla validación - ", "") + GXutil.trim( AV155validacionLiqDLog) ;
                     A1072LiqDLogRecal += httpContext.getMessage( "-Falla validación - ", "") + GXutil.trim( AV155validacionLiqDLog) ;
                  }
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "Recorre concepto pendiente de calcular ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDFormula ", "")+GXutil.trim( A274LiqDFormula)) ;
                  if ( ! AV102loguearFallidos )
                  {
                     A1070LiqDLog = "" ;
                     A1072LiqDLogRecal = "" ;
                  }
                  AV126resolverLiqDLog = "" ;
                  AV89LiqDLog = GXutil.trim( A394DConCodigo) + ": " ;
                  AV59dependenciasResueltas = false ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)) ;
                  AV115ok = true ;
                  AV52ConOpeEsCant = DecimalUtil.doubleToDec(0) ;
                  AV153UnoDosAhora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
                  GXv_char7[0] = AV50ConFormula ;
                  GXv_int3[0] = AV53ConVigencia ;
                  GXv_boolean13[0] = AV51ConMostrarPos ;
                  GXv_boolean10[0] = AV49ConErrorSiCero ;
                  new web.getdatosconcepto5(remoteHandle, context).execute( A3CliCod, A394DConCodigo, GXv_char7, GXv_int3, GXv_boolean13, GXv_boolean10) ;
                  procliqsinganancias.this.AV50ConFormula = GXv_char7[0] ;
                  procliqsinganancias.this.AV53ConVigencia = GXv_int3[0] ;
                  procliqsinganancias.this.AV51ConMostrarPos = GXv_boolean13[0] ;
                  procliqsinganancias.this.AV49ConErrorSiCero = GXv_boolean10[0] ;
                  if ( ! (GXutil.strcmp("", AV50ConFormula)==0) )
                  {
                     AV16ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
                     if ( AV115ok )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "DLiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( A397DLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " LiqDFormula ", "")+GXutil.trim( A274LiqDFormula)+httpContext.getMessage( " &LIQDFORMULA ", "")+AV86LiqDFormula) ;
                        GXv_boolean13[0] = AV115ok ;
                        GXv_char7[0] = Gx_msg ;
                        GXv_char6[0] = AV86LiqDFormula ;
                        GXv_char14[0] = AV87LiqDFormulaHTML ;
                        GXv_char15[0] = "" ;
                        GXv_decimal11[0] = AV128Resultado ;
                        GXv_boolean10[0] = AV59dependenciasResueltas ;
                        GXv_decimal16[0] = AV52ConOpeEsCant ;
                        GXv_boolean17[0] = AV19alicuotaEs ;
                        GXv_decimal18[0] = AV36cantidadCalculada ;
                        GXv_decimal19[0] = AV30baseImportes ;
                        GXv_boolean20[0] = false ;
                        GXv_char21[0] = AV126resolverLiqDLog ;
                        GXv_decimal22[0] = AV92LiqDPlus ;
                        GXv_boolean23[0] = AV58dependenciaConceptoEs ;
                        new web.resolverformula(remoteHandle, context).execute( A3CliCod, A394DConCodigo, A274LiqDFormula, A508LiqDFormulaHTML, AV11EmpCod, AV97LiqNro, AV99LiqRelNro, AV97LiqNro, A6LegNumero, A400DTLiqCod, A397DLiqPeriodo, AV164Pgmname, "Calculo", false, A269LiqDCanti, A1760DAgeFecDes, A276LiqDImporte, A277LiqDValUni, GXv_boolean13, GXv_char7, GXv_char6, GXv_char14, GXv_char15, GXv_decimal11, GXv_boolean10, GXv_decimal16, GXv_boolean17, GXv_decimal18, GXv_decimal19, GXv_boolean20, GXv_char21, GXv_decimal22, GXv_boolean23) ;
                        procliqsinganancias.this.AV115ok = GXv_boolean13[0] ;
                        procliqsinganancias.this.Gx_msg = GXv_char7[0] ;
                        procliqsinganancias.this.AV86LiqDFormula = GXv_char6[0] ;
                        procliqsinganancias.this.AV87LiqDFormulaHTML = GXv_char14[0] ;
                        procliqsinganancias.this.AV128Resultado = GXv_decimal11[0] ;
                        procliqsinganancias.this.AV59dependenciasResueltas = GXv_boolean10[0] ;
                        procliqsinganancias.this.AV52ConOpeEsCant = GXv_decimal16[0] ;
                        procliqsinganancias.this.AV19alicuotaEs = GXv_boolean17[0] ;
                        procliqsinganancias.this.AV36cantidadCalculada = GXv_decimal18[0] ;
                        procliqsinganancias.this.AV30baseImportes = GXv_decimal19[0] ;
                        procliqsinganancias.this.AV126resolverLiqDLog = GXv_char21[0] ;
                        procliqsinganancias.this.AV92LiqDPlus = GXv_decimal22[0] ;
                        procliqsinganancias.this.AV58dependenciaConceptoEs = GXv_boolean23[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "cantidad calculada ", "")+GXutil.trim( GXutil.str( AV36cantidadCalculada, 14, 2))+httpContext.getMessage( " alicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV19alicuotaEs))+httpContext.getMessage( " LiqDFormula ", "")+GXutil.trim( A274LiqDFormula)+httpContext.getMessage( " &LIQDFORMULA ", "")+AV86LiqDFormula+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV59dependenciasResueltas))) ;
                     }
                     AV89LiqDLog = AV126resolverLiqDLog ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV52ConOpeEsCant, 14, 2))+httpContext.getMessage( " &LiqDFormula ", "")+GXutil.trim( AV86LiqDFormula)) ;
                     if ( ! (GXutil.strcmp("", A274LiqDFormula)==0) )
                     {
                        A1070LiqDLog += GXutil.trim( AV89LiqDLog) ;
                        A1072LiqDLogRecal += GXutil.trim( AV89LiqDLog) ;
                        if ( ! AV115ok )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "NOT ok &msg ", "")+Gx_msg) ;
                           GXv_char21[0] = Gx_msg ;
                           GXv_char15[0] = AV161principalError ;
                           new web.parsearerrorprincipal(remoteHandle, context).execute( GXv_char21, GXv_char15) ;
                           procliqsinganancias.this.Gx_msg = GXv_char21[0] ;
                           procliqsinganancias.this.AV161principalError = GXv_char15[0] ;
                           A270LiqDErrorDesc = Gx_msg ;
                           n270LiqDErrorDesc = false ;
                           if ( AV59dependenciasResueltas )
                           {
                              AV69errores = GXutil.trim( Gx_msg) ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "error formula ", "")+AV69errores) ;
                              AV59dependenciasResueltas = false ;
                           }
                           else
                           {
                              new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "todavia no estan resueltas las dependencias", "")) ;
                           }
                           if ( AV102loguearFallidos )
                           {
                              AV63dmas2 = (short)(AV55d+2) ;
                              if ( AV63dmas2 > 1 )
                              {
                                 AV62dmas1 = (short)(AV55d+1) ;
                                 AV110noSePudoResolverMensaje = ". " + GXutil.trim( Gx_msg) + httpContext.getMessage( " (vuelta ", "") + GXutil.trim( GXutil.str( AV62dmas1, 4, 0)) + ") " ;
                                 A1070LiqDLog = GXutil.strReplace( A1070LiqDLog, AV110noSePudoResolverMensaje, "") ;
                                 A1072LiqDLogRecal = GXutil.strReplace( A1072LiqDLogRecal, AV110noSePudoResolverMensaje, "") ;
                              }
                              AV110noSePudoResolverMensaje = ". " + GXutil.trim( Gx_msg) + httpContext.getMessage( " (vuelta ", "") + GXutil.trim( GXutil.str( AV63dmas2, 4, 0)) + ") " ;
                              A1070LiqDLog += AV110noSePudoResolverMensaje ;
                              A1072LiqDLogRecal += AV110noSePudoResolverMensaje ;
                           }
                        }
                        else
                        {
                           A1219LiqDPlus = AV92LiqDPlus ;
                           A275LiqDImpCalcu = GXutil.roundDecimal( AV128Resultado, 2) ;
                           n275LiqDImpCalcu = false ;
                           A764LiqDImpReCalcu = GXutil.roundDecimal( AV128Resultado, 2) ;
                           new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 1", "")) ;
                           if ( ( AV73EsConceptoImprimible ) && ( ( ( A275LiqDImpCalcu.doubleValue() > 0 ) && ( AV51ConMostrarPos ) ) || ! AV51ConMostrarPos ) )
                           {
                              new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 2", "")) ;
                              AV71errorPorCero = false ;
                              if ( AV49ConErrorSiCero )
                              {
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 3", "")) ;
                                 if ( A275LiqDImpCalcu.doubleValue() == 0 )
                                 {
                                    new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 4", "")) ;
                                    if ( GXutil.strcmp(A394DConCodigo, AV143sueldoConCodigo) != 0 )
                                    {
                                       AV71errorPorCero = true ;
                                       new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 5", "")) ;
                                    }
                                    else
                                    {
                                       if ( ( AV66EmpTipoExp == ( 0 )) )
                                       {
                                          AV71errorPorCero = true ;
                                       }
                                       else
                                       {
                                          if ( AV36cantidadCalculada.doubleValue() > 0 )
                                          {
                                             AV71errorPorCero = true ;
                                          }
                                       }
                                    }
                                 }
                              }
                              if ( AV71errorPorCero )
                              {
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 6", "")) ;
                                 A270LiqDErrorDesc = httpContext.getMessage( "Concepto calculado en cero", "") ;
                                 n270LiqDErrorDesc = false ;
                                 AV35calculoCero = true ;
                                 AV68errorComunHay = true ;
                              }
                              if ( A275LiqDImpCalcu.doubleValue() != 0 )
                              {
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ok 7", "")) ;
                                 A502LiqDMostrar = (byte)(3) ;
                              }
                              else
                              {
                                 A502LiqDMostrar = (byte)(0) ;
                              }
                           }
                           else
                           {
                              if ( A275LiqDImpCalcu.doubleValue() > 0 )
                              {
                                 A502LiqDMostrar = (byte)(2) ;
                              }
                              else
                              {
                                 A502LiqDMostrar = (byte)(0) ;
                              }
                           }
                           new web.msgdebug(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "ASIGNA ", "")+GXutil.trim( GXutil.str( AV128Resultado, 14, 2))+httpContext.getMessage( " a ", "")+GXutil.trim( A394DConCodigo)) ;
                        }
                     }
                     else
                     {
                        A270LiqDErrorDesc = httpContext.getMessage( "Error: Formula vacia", "") ;
                        n270LiqDErrorDesc = false ;
                        AV69errores = httpContext.getMessage( "Error: Formula vacia", "") ;
                     }
                     if ( ! (GXutil.strcmp("", AV86LiqDFormula)==0) )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "asigna a ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &liqdformula ", "")+GXutil.trim( AV86LiqDFormula)) ;
                        A274LiqDFormula = GXutil.trim( AV86LiqDFormula) ;
                        n274LiqDFormula = false ;
                        A508LiqDFormulaHTML = GXutil.trim( AV87LiqDFormulaHTML) ;
                        n508LiqDFormulaHTML = false ;
                        A876LiqDReFormulaHTML = GXutil.trim( AV87LiqDFormulaHTML) ;
                        n876LiqDReFormulaHTML = false ;
                        A749LiqDFormuAux = GXutil.trim( AV86LiqDFormula) ;
                        n749LiqDFormuAux = false ;
                     }
                  }
                  else
                  {
                     if ( ( AV53ConVigencia == 1 ) || new web.esredondeoosobregiro(remoteHandle, context).executeUdp( AV42CliCod, A394DConCodigo) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV59dependenciasResueltas = true ;
                        AV89LiqDLog += httpContext.getMessage( ". Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "") ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "")) ;
                     }
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV59dependenciasResueltas))) ;
                  if ( AV59dependenciasResueltas )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " &alicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV19alicuotaEs))) ;
                     if ( AV19alicuotaEs )
                     {
                        A968LiqDUniMed = "%" ;
                     }
                     if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV52ConOpeEsCant, 14, 2))) ;
                        if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52ConOpeEsCant)==0) )
                        {
                           A269LiqDCanti = AV52ConOpeEsCant ;
                           n269LiqDCanti = false ;
                           new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "le one ", "")+GXutil.trim( GXutil.str( AV52ConOpeEsCant, 14, 2))) ;
                        }
                        else
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "&cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV36cantidadCalculada, 14, 2))) ;
                           if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36cantidadCalculada)==0) )
                           {
                              A269LiqDCanti = AV36cantidadCalculada ;
                              n269LiqDCanti = false ;
                           }
                        }
                        if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) )
                        {
                           A269LiqDCanti = DecimalUtil.doubleToDec(1) ;
                           n269LiqDCanti = false ;
                        }
                     }
                     else
                     {
                        if ( AV53ConVigencia == 1 )
                        {
                           GXv_decimal22[0] = A275LiqDImpCalcu ;
                           GXv_decimal19[0] = A764LiqDImpReCalcu ;
                           GXv_boolean23[0] = false ;
                           GXv_char21[0] = AV81impliLiqDLog ;
                           new web.calculomultiporcantimplicito(remoteHandle, context).execute( AV42CliCod, A504LiqDForOrig, AV53ConVigencia, A269LiqDCanti, AV12LiqDImporte, GXv_decimal22, GXv_decimal19, GXv_boolean23, GXv_char21) ;
                           procliqsinganancias.this.A275LiqDImpCalcu = GXv_decimal22[0] ;
                           n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
                           procliqsinganancias.this.A764LiqDImpReCalcu = GXv_decimal19[0] ;
                           procliqsinganancias.this.AV81impliLiqDLog = GXv_char21[0] ;
                        }
                     }
                     A507LiqDCalculado = (byte)(1) ;
                     if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "NRE005", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDCalculado = 1", "")) ;
                     }
                     if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) )
                     {
                        if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30baseImportes)==0) )
                        {
                           AV30baseImportes = A275LiqDImpCalcu ;
                           if ( A269LiqDCanti.doubleValue() > 0 )
                           {
                              AV30baseImportes = AV30baseImportes.divide(A269LiqDCanti, 18, java.math.RoundingMode.DOWN) ;
                              if ( GXutil.strcmp(A968LiqDUniMed, "%") == 0 )
                              {
                                 AV30baseImportes = AV30baseImportes.multiply(DecimalUtil.doubleToDec(100)) ;
                              }
                           }
                        }
                        A277LiqDValUni = AV30baseImportes ;
                        n277LiqDValUni = false ;
                     }
                     if ( ! AV35calculoCero && ( AV115ok ) )
                     {
                        A270LiqDErrorDesc = "" ;
                        n270LiqDErrorDesc = false ;
                     }
                     A918LiqDVueltaRes = (byte)(AV55d+1) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "LiqDVueltaRes ", "")+GXutil.trim( GXutil.str( A918LiqDVueltaRes, 2, 0))+httpContext.getMessage( " &d ", "")+GXutil.trim( GXutil.str( AV55d, 4, 0))) ;
                     if ( (GXutil.strcmp("", A1070LiqDLog)==0) )
                     {
                        A1070LiqDLog = GXutil.trim( A508LiqDFormulaHTML) ;
                     }
                     if ( (GXutil.strcmp("", A1072LiqDLogRecal)==0) )
                     {
                        A1072LiqDLogRecal = GXutil.trim( A876LiqDReFormulaHTML) ;
                     }
                     A1070LiqDLog += AV81impliLiqDLog ;
                     A1072LiqDLogRecal += AV81impliLiqDLog ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL046", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDCalculado = 0", "")) ;
                     }
                     A507LiqDCalculado = (byte)(0) ;
                     AV37cantPendientes = (short)(AV37cantPendientes+1) ;
                     AV120pendientes_ConCodigo.add(A394DConCodigo, 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "LiqDCalculado = 0", "")) ;
                     if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "REM010", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "acá NO resolvió a maternidad", "")) ;
                     }
                     if ( false )
                     {
                        AV13LiqLog = httpContext.getMessage( "NO Lo resuelve", "") ;
                        new web.actualizalogliquidacion(remoteHandle, context).execute( AV42CliCod, AV11EmpCod, AV97LiqNro, AV13LiqLog) ;
                     }
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " todosinsertados ", "")+GXutil.trim( GXutil.booltostr( AV148todosInsertados))) ;
               }
            }
            AV9ConCodigo = A394DConCodigo ;
            AV88LiqDImpCalcu = A275LiqDImpCalcu ;
            AV16ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
            AV135segundos = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV16ahora, AV44comienzo)) ;
            A1469LiqDSeg = AV135segundos ;
            /* Using cursor P02CM6 */
            pr_default.execute(4, new Object[] {Byte.valueOf(A507LiqDCalculado), Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1219LiqDPlus, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, A968LiqDUniMed, Byte.valueOf(A918LiqDVueltaRes), A1469LiqDSeg, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV166GXLvl70 == 0 )
         {
            AV133seguir = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "corta. Total vueltas: ", "")+GXutil.trim( GXutil.str( AV55d, 4, 0))) ;
         }
         if ( AV144tienePendientes )
         {
            AV55d = (short)(AV55d+1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV84LegNumero, 8, 0))+httpContext.getMessage( " suma &d ", "")+GXutil.str( AV55d, 4, 0)+httpContext.getMessage( " &cantPendientes ", "")+GXutil.trim( GXutil.str( AV37cantPendientes, 4, 0))+httpContext.getMessage( " ultimo ", "")+GXutil.trim( GXutil.str( AV38cantPendientesUltimo, 4, 0))) ;
            if ( AV37cantPendientes == AV38cantPendientesUltimo )
            {
               if ( AV37cantPendientes > 0 )
               {
                  if ( AV58dependenciaConceptoEs )
                  {
                     AV40ciclicoErrorHay = true ;
                  }
                  else
                  {
                     AV68errorComunHay = true ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV164Pgmname, httpContext.getMessage( "LOOPEO &cantPendientes ", "")+GXutil.str( AV37cantPendientes, 4, 0)+httpContext.getMessage( " &yaHizoInsertsAdicionales ", "")+GXutil.trim( GXutil.str( AV158yaHizoInsertsAdicionales, 4, 0))) ;
                  AV133seguir = false ;
               }
            }
            AV38cantPendientesUltimo = AV37cantPendientes ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = procliqsinganancias.this.AV40ciclicoErrorHay;
      this.aP10[0] = procliqsinganancias.this.AV68errorComunHay;
      this.aP11[0] = procliqsinganancias.this.AV161principalError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV161principalError = "" ;
      AV98LiqPeriodo = GXutil.nullDate() ;
      GXt_date1 = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV65egresoTLiqCod = "" ;
      AV143sueldoConCodigo = "" ;
      AV164Pgmname = "" ;
      AV147TLiqCod = "" ;
      GXv_int9 = new short[1] ;
      AV101liquidaSAConcodigo = "" ;
      GXt_char5 = "" ;
      GXt_char4 = "" ;
      AV69errores = "" ;
      scmdbuf = "" ;
      P02CM2_A6LegNumero = new int[1] ;
      P02CM2_A31LiqNro = new int[1] ;
      P02CM2_A1EmpCod = new short[1] ;
      P02CM2_A3CliCod = new int[1] ;
      P02CM2_A883LIqLegIteraciones = new short[1] ;
      P02CM2_A2268LiqLegProcesado = new byte[1] ;
      A394DConCodigo = "" ;
      A274LiqDFormula = "" ;
      A464DTipoConCod = "" ;
      A1487DConCondicion = "" ;
      A468DSubTipoConCod1 = "" ;
      A732DSubTipoConCod2 = "" ;
      A504LiqDForOrig = "" ;
      A393DConDescrip = "" ;
      A1070LiqDLog = "" ;
      A1072LiqDLogRecal = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A508LiqDFormulaHTML = "" ;
      A400DTLiqCod = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A1760DAgeFecDes = GXutil.nullDate() ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A968LiqDUniMed = "" ;
      A270LiqDErrorDesc = "" ;
      A876LiqDReFormulaHTML = "" ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      A749LiqDFormuAux = "" ;
      A1469LiqDSeg = DecimalUtil.ZERO ;
      AV129saldoProrrateoBonosPalabra = "" ;
      AV123ProcesoLiquidacion = "" ;
      AV120pendientes_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      P02CM4_A3CliCod = new int[1] ;
      P02CM4_A1EmpCod = new short[1] ;
      P02CM4_A31LiqNro = new int[1] ;
      P02CM4_A6LegNumero = new int[1] ;
      P02CM4_A507LiqDCalculado = new byte[1] ;
      P02CM4_A274LiqDFormula = new String[] {""} ;
      P02CM4_n274LiqDFormula = new boolean[] {false} ;
      P02CM4_A394DConCodigo = new String[] {""} ;
      P02CM4_A464DTipoConCod = new String[] {""} ;
      P02CM4_A1487DConCondicion = new String[] {""} ;
      P02CM4_A468DSubTipoConCod1 = new String[] {""} ;
      P02CM4_n468DSubTipoConCod1 = new boolean[] {false} ;
      P02CM4_A732DSubTipoConCod2 = new String[] {""} ;
      P02CM4_n732DSubTipoConCod2 = new boolean[] {false} ;
      P02CM4_A504LiqDForOrig = new String[] {""} ;
      P02CM4_A393DConDescrip = new String[] {""} ;
      P02CM4_A1070LiqDLog = new String[] {""} ;
      P02CM4_A1072LiqDLogRecal = new String[] {""} ;
      P02CM4_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02CM4_A508LiqDFormulaHTML = new String[] {""} ;
      P02CM4_n508LiqDFormulaHTML = new boolean[] {false} ;
      P02CM4_A400DTLiqCod = new String[] {""} ;
      P02CM4_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_n269LiqDCanti = new boolean[] {false} ;
      P02CM4_A1760DAgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02CM4_n1760DAgeFecDes = new boolean[] {false} ;
      P02CM4_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_n276LiqDImporte = new boolean[] {false} ;
      P02CM4_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_n277LiqDValUni = new boolean[] {false} ;
      P02CM4_A270LiqDErrorDesc = new String[] {""} ;
      P02CM4_n270LiqDErrorDesc = new boolean[] {false} ;
      P02CM4_A1219LiqDPlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_n275LiqDImpCalcu = new boolean[] {false} ;
      P02CM4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_A502LiqDMostrar = new byte[1] ;
      P02CM4_A876LiqDReFormulaHTML = new String[] {""} ;
      P02CM4_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P02CM4_A749LiqDFormuAux = new String[] {""} ;
      P02CM4_n749LiqDFormuAux = new boolean[] {false} ;
      P02CM4_A968LiqDUniMed = new String[] {""} ;
      P02CM4_A918LiqDVueltaRes = new byte[1] ;
      P02CM4_A1469LiqDSeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CM4_A509LiqDOrdEjec = new long[1] ;
      P02CM4_A81LiqDSecuencial = new int[1] ;
      AV44comienzo = GXutil.resetTime( GXutil.nullDate() );
      AV81impliLiqDLog = "" ;
      AV86LiqDFormula = "" ;
      AV48ConCondicion = "" ;
      AV155validacionLiqDLog = "" ;
      AV126resolverLiqDLog = "" ;
      AV89LiqDLog = "" ;
      AV52ConOpeEsCant = DecimalUtil.ZERO ;
      AV153UnoDosAhora = GXutil.resetTime( GXutil.nullDate() );
      AV50ConFormula = "" ;
      GXv_int3 = new byte[1] ;
      AV16ahora = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean13 = new boolean[1] ;
      Gx_msg = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      AV87LiqDFormulaHTML = "" ;
      GXv_char14 = new String[1] ;
      AV128Resultado = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_decimal16 = new java.math.BigDecimal[1] ;
      GXv_boolean17 = new boolean[1] ;
      AV36cantidadCalculada = DecimalUtil.ZERO ;
      GXv_decimal18 = new java.math.BigDecimal[1] ;
      AV30baseImportes = DecimalUtil.ZERO ;
      GXv_boolean20 = new boolean[1] ;
      AV92LiqDPlus = DecimalUtil.ZERO ;
      GXv_char15 = new String[1] ;
      AV110noSePudoResolverMensaje = "" ;
      AV12LiqDImporte = DecimalUtil.ZERO ;
      GXv_decimal22 = new java.math.BigDecimal[1] ;
      GXv_decimal19 = new java.math.BigDecimal[1] ;
      GXv_boolean23 = new boolean[1] ;
      GXv_char21 = new String[1] ;
      AV13LiqLog = "" ;
      AV9ConCodigo = "" ;
      AV88LiqDImpCalcu = DecimalUtil.ZERO ;
      AV135segundos = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procliqsinganancias__default(),
         new Object[] {
             new Object[] {
            P02CM2_A6LegNumero, P02CM2_A31LiqNro, P02CM2_A1EmpCod, P02CM2_A3CliCod, P02CM2_A883LIqLegIteraciones, P02CM2_A2268LiqLegProcesado
            }
            , new Object[] {
            }
            , new Object[] {
            P02CM4_A3CliCod, P02CM4_A1EmpCod, P02CM4_A31LiqNro, P02CM4_A6LegNumero, P02CM4_A507LiqDCalculado, P02CM4_A274LiqDFormula, P02CM4_n274LiqDFormula, P02CM4_A394DConCodigo, P02CM4_A464DTipoConCod, P02CM4_A1487DConCondicion,
            P02CM4_A468DSubTipoConCod1, P02CM4_n468DSubTipoConCod1, P02CM4_A732DSubTipoConCod2, P02CM4_n732DSubTipoConCod2, P02CM4_A504LiqDForOrig, P02CM4_A393DConDescrip, P02CM4_A1070LiqDLog, P02CM4_A1072LiqDLogRecal, P02CM4_A397DLiqPeriodo, P02CM4_A508LiqDFormulaHTML,
            P02CM4_n508LiqDFormulaHTML, P02CM4_A400DTLiqCod, P02CM4_A269LiqDCanti, P02CM4_n269LiqDCanti, P02CM4_A1760DAgeFecDes, P02CM4_n1760DAgeFecDes, P02CM4_A276LiqDImporte, P02CM4_n276LiqDImporte, P02CM4_A277LiqDValUni, P02CM4_n277LiqDValUni,
            P02CM4_A270LiqDErrorDesc, P02CM4_n270LiqDErrorDesc, P02CM4_A1219LiqDPlus, P02CM4_A275LiqDImpCalcu, P02CM4_n275LiqDImpCalcu, P02CM4_A764LiqDImpReCalcu, P02CM4_A502LiqDMostrar, P02CM4_A876LiqDReFormulaHTML, P02CM4_n876LiqDReFormulaHTML, P02CM4_A749LiqDFormuAux,
            P02CM4_n749LiqDFormuAux, P02CM4_A968LiqDUniMed, P02CM4_A918LiqDVueltaRes, P02CM4_A1469LiqDSeg, P02CM4_A509LiqDOrdEjec, P02CM4_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV164Pgmname = "ProcLiqSinGanancias" ;
      /* GeneXus formulas. */
      AV164Pgmname = "ProcLiqSinGanancias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV90LiqDLote ;
   private byte AV66EmpTipoExp ;
   private byte A2268LiqLegProcesado ;
   private byte A502LiqDMostrar ;
   private byte A918LiqDVueltaRes ;
   private byte A507LiqDCalculado ;
   private byte AV166GXLvl70 ;
   private byte AV53ConVigencia ;
   private byte GXv_int3[] ;
   private short AV11EmpCod ;
   private short AV80i ;
   private short AV118PaiCod ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short A1EmpCod ;
   private short A883LIqLegIteraciones ;
   private short AV55d ;
   private short AV158yaHizoInsertsAdicionales ;
   private short AV37cantPendientes ;
   private short AV63dmas2 ;
   private short AV62dmas1 ;
   private short AV38cantPendientesUltimo ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int AV97LiqNro ;
   private int AV99LiqRelNro ;
   private int AV119parmLegNumero ;
   private int AV84LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private long A509LiqDOrdEjec ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private java.math.BigDecimal A1469LiqDSeg ;
   private java.math.BigDecimal AV52ConOpeEsCant ;
   private java.math.BigDecimal AV128Resultado ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal16[] ;
   private java.math.BigDecimal AV36cantidadCalculada ;
   private java.math.BigDecimal GXv_decimal18[] ;
   private java.math.BigDecimal AV30baseImportes ;
   private java.math.BigDecimal AV92LiqDPlus ;
   private java.math.BigDecimal AV12LiqDImporte ;
   private java.math.BigDecimal GXv_decimal22[] ;
   private java.math.BigDecimal GXv_decimal19[] ;
   private java.math.BigDecimal AV88LiqDImpCalcu ;
   private java.math.BigDecimal AV135segundos ;
   private String AV10ConveCodigo ;
   private String AV65egresoTLiqCod ;
   private String AV143sueldoConCodigo ;
   private String AV164Pgmname ;
   private String AV147TLiqCod ;
   private String AV101liquidaSAConcodigo ;
   private String GXt_char5 ;
   private String GXt_char4 ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A1487DConCondicion ;
   private String A468DSubTipoConCod1 ;
   private String A732DSubTipoConCod2 ;
   private String A400DTLiqCod ;
   private String A968LiqDUniMed ;
   private String AV129saldoProrrateoBonosPalabra ;
   private String AV123ProcesoLiquidacion ;
   private String AV48ConCondicion ;
   private String Gx_msg ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char14[] ;
   private String GXv_char15[] ;
   private String GXv_char21[] ;
   private String AV9ConCodigo ;
   private java.util.Date AV44comienzo ;
   private java.util.Date AV153UnoDosAhora ;
   private java.util.Date AV16ahora ;
   private java.util.Date AV98LiqPeriodo ;
   private java.util.Date GXt_date1 ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date A1760DAgeFecDes ;
   private boolean AV148todosInsertados ;
   private boolean AV40ciclicoErrorHay ;
   private boolean AV68errorComunHay ;
   private boolean returnInSub ;
   private boolean AV122procesoAlgo ;
   private boolean AV33calcularSAC ;
   private boolean AV133seguir ;
   private boolean AV144tienePendientes ;
   private boolean n274LiqDFormula ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n269LiqDCanti ;
   private boolean n1760DAgeFecDes ;
   private boolean n276LiqDImporte ;
   private boolean n277LiqDValUni ;
   private boolean n270LiqDErrorDesc ;
   private boolean n275LiqDImpCalcu ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n749LiqDFormuAux ;
   private boolean AV35calculoCero ;
   private boolean AV14LiqOK ;
   private boolean AV73EsConceptoImprimible ;
   private boolean GXt_boolean12 ;
   private boolean AV15agregarConcepto ;
   private boolean AV32calcularContribuciones ;
   private boolean AV114obligatorioEs ;
   private boolean AV134segundoPlanoEs ;
   private boolean AV102loguearFallidos ;
   private boolean AV59dependenciasResueltas ;
   private boolean AV115ok ;
   private boolean AV51ConMostrarPos ;
   private boolean AV49ConErrorSiCero ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean10[] ;
   private boolean AV19alicuotaEs ;
   private boolean GXv_boolean17[] ;
   private boolean GXv_boolean20[] ;
   private boolean AV58dependenciaConceptoEs ;
   private boolean AV71errorPorCero ;
   private boolean Cond_result ;
   private boolean GXv_boolean23[] ;
   private String A274LiqDFormula ;
   private String A504LiqDForOrig ;
   private String A1070LiqDLog ;
   private String A1072LiqDLogRecal ;
   private String A508LiqDFormulaHTML ;
   private String A876LiqDReFormulaHTML ;
   private String AV81impliLiqDLog ;
   private String AV86LiqDFormula ;
   private String AV155validacionLiqDLog ;
   private String AV126resolverLiqDLog ;
   private String AV89LiqDLog ;
   private String AV50ConFormula ;
   private String AV87LiqDFormulaHTML ;
   private String AV13LiqLog ;
   private String AV124programa ;
   private String AV161principalError ;
   private String AV69errores ;
   private String A393DConDescrip ;
   private String A270LiqDErrorDesc ;
   private String A749LiqDFormuAux ;
   private String AV110noSePudoResolverMensaje ;
   private String[] aP11 ;
   private boolean[] aP9 ;
   private boolean[] aP10 ;
   private IDataStoreProvider pr_default ;
   private int[] P02CM2_A6LegNumero ;
   private int[] P02CM2_A31LiqNro ;
   private short[] P02CM2_A1EmpCod ;
   private int[] P02CM2_A3CliCod ;
   private short[] P02CM2_A883LIqLegIteraciones ;
   private byte[] P02CM2_A2268LiqLegProcesado ;
   private int[] P02CM4_A3CliCod ;
   private short[] P02CM4_A1EmpCod ;
   private int[] P02CM4_A31LiqNro ;
   private int[] P02CM4_A6LegNumero ;
   private byte[] P02CM4_A507LiqDCalculado ;
   private String[] P02CM4_A274LiqDFormula ;
   private boolean[] P02CM4_n274LiqDFormula ;
   private String[] P02CM4_A394DConCodigo ;
   private String[] P02CM4_A464DTipoConCod ;
   private String[] P02CM4_A1487DConCondicion ;
   private String[] P02CM4_A468DSubTipoConCod1 ;
   private boolean[] P02CM4_n468DSubTipoConCod1 ;
   private String[] P02CM4_A732DSubTipoConCod2 ;
   private boolean[] P02CM4_n732DSubTipoConCod2 ;
   private String[] P02CM4_A504LiqDForOrig ;
   private String[] P02CM4_A393DConDescrip ;
   private String[] P02CM4_A1070LiqDLog ;
   private String[] P02CM4_A1072LiqDLogRecal ;
   private java.util.Date[] P02CM4_A397DLiqPeriodo ;
   private String[] P02CM4_A508LiqDFormulaHTML ;
   private boolean[] P02CM4_n508LiqDFormulaHTML ;
   private String[] P02CM4_A400DTLiqCod ;
   private java.math.BigDecimal[] P02CM4_A269LiqDCanti ;
   private boolean[] P02CM4_n269LiqDCanti ;
   private java.util.Date[] P02CM4_A1760DAgeFecDes ;
   private boolean[] P02CM4_n1760DAgeFecDes ;
   private java.math.BigDecimal[] P02CM4_A276LiqDImporte ;
   private boolean[] P02CM4_n276LiqDImporte ;
   private java.math.BigDecimal[] P02CM4_A277LiqDValUni ;
   private boolean[] P02CM4_n277LiqDValUni ;
   private String[] P02CM4_A270LiqDErrorDesc ;
   private boolean[] P02CM4_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P02CM4_A1219LiqDPlus ;
   private java.math.BigDecimal[] P02CM4_A275LiqDImpCalcu ;
   private boolean[] P02CM4_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P02CM4_A764LiqDImpReCalcu ;
   private byte[] P02CM4_A502LiqDMostrar ;
   private String[] P02CM4_A876LiqDReFormulaHTML ;
   private boolean[] P02CM4_n876LiqDReFormulaHTML ;
   private String[] P02CM4_A749LiqDFormuAux ;
   private boolean[] P02CM4_n749LiqDFormuAux ;
   private String[] P02CM4_A968LiqDUniMed ;
   private byte[] P02CM4_A918LiqDVueltaRes ;
   private java.math.BigDecimal[] P02CM4_A1469LiqDSeg ;
   private long[] P02CM4_A509LiqDOrdEjec ;
   private int[] P02CM4_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV120pendientes_ConCodigo ;
}

final  class procliqsinganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CM2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LIqLegIteraciones, LiqLegProcesado FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02CM3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LIqLegIteraciones=?, LiqLegProcesado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02CM4", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDCalculado, LiqDFormula, DConCodigo, DTipoConCod, DConCondicion, DSubTipoConCod1, DSubTipoConCod2, LiqDForOrig, DConDescrip, LiqDLog, LiqDLogRecal, DLiqPeriodo, LiqDFormulaHTML, DTLiqCod, LiqDCanti, DAgeFecDes, LiqDImporte, LiqDValUni, LiqDErrorDesc, LiqDPlus, LiqDImpCalcu, LiqDImpReCalcu, LiqDMostrar, LiqDReFormulaHTML, LiqDFormuAux, LiqDUniMed, LiqDVueltaRes, LiqDSeg, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDCalculado = 0 ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDCalculado, LiqDOrdEjec  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02CM5", "SAVEPOINT gxupdate;DELETE FROM LiquidacionDetalle  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02CM6", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDFormula=?, LiqDLog=?, LiqDLogRecal=?, LiqDFormulaHTML=?, LiqDCanti=?, LiqDValUni=?, LiqDErrorDesc=?, LiqDPlus=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDMostrar=?, LiqDReFormulaHTML=?, LiqDFormuAux=?, LiqDUniMed=?, LiqDVueltaRes=?, LiqDSeg=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getLongVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDate(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(22,2);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(24,4);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(25,2);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(26,2);
               ((byte[]) buf[36])[0] = rslt.getByte(27);
               ((String[]) buf[37])[0] = rslt.getLongVarchar(28);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(29);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getString(30, 20);
               ((byte[]) buf[42])[0] = rslt.getByte(31);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(32,3);
               ((long[]) buf[44])[0] = rslt.getLong(33);
               ((int[]) buf[45])[0] = rslt.getInt(34);
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
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 4 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(2, (String)parms[2]);
               }
               stmt.setNLongVarchar(3, (String)parms[3], false);
               stmt.setNLongVarchar(4, (String)parms[4], false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[6]);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(6, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(7, (java.math.BigDecimal)parms[10], 2);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[12], 400);
               }
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[13], 4);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(10, (java.math.BigDecimal)parms[15], 2);
               }
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[16], 2);
               stmt.setByte(12, ((Number) parms[17]).byteValue());
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(13, (String)parms[19]);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[21], 400);
               }
               stmt.setString(15, (String)parms[22], 20);
               stmt.setByte(16, ((Number) parms[23]).byteValue());
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[24], 3);
               stmt.setInt(18, ((Number) parms[25]).intValue());
               stmt.setShort(19, ((Number) parms[26]).shortValue());
               stmt.setInt(20, ((Number) parms[27]).intValue());
               stmt.setInt(21, ((Number) parms[28]).intValue());
               stmt.setInt(22, ((Number) parms[29]).intValue());
               return;
      }
   }

}

