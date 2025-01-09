package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliquidacion2 extends GXProcedure
{
   public procliquidacion2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliquidacion2.class ), "" );
   }

   public procliquidacion2( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              byte aP4 ,
                              String aP5 ,
                              boolean aP6 ,
                              String aP7 )
   {
      procliquidacion2.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             boolean[] aP8 )
   {
      procliquidacion2.this.AV15CliCod = aP0;
      procliquidacion2.this.AV8EmpCod = aP1;
      procliquidacion2.this.AV40LiqNro = aP2;
      procliquidacion2.this.AV110parmLegNumero = aP3;
      procliquidacion2.this.AV112LiqDLote = aP4;
      procliquidacion2.this.AV111programa = aP5;
      procliquidacion2.this.AV115todosInsertados = aP6;
      procliquidacion2.this.AV123criterioPalabra = aP7;
      procliquidacion2.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV120calculos_TipoConCod = "CAL_ARG" ;
      GXt_char1 = AV121baseImpSubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char2) ;
      procliquidacion2.this.GXt_char1 = GXv_char2[0] ;
      AV121baseImpSubTipoConCod1 = GXt_char1 ;
      GXt_char1 = AV122contribucionesSubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipocontribucion(remoteHandle, context).execute( GXv_char2) ;
      procliquidacion2.this.GXt_char1 = GXv_char2[0] ;
      AV122contribucionesSubTipoConCod1 = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "proceso pendientes por ", "")+AV111programa) ;
      GXt_char1 = AV98loguearFallidosPalabra ;
      GXt_char3 = AV98loguearFallidosPalabra ;
      GXv_char2[0] = GXt_char3 ;
      new web.logfallidos_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      procliquidacion2.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char3, GXv_char4) ;
      procliquidacion2.this.GXt_char1 = GXv_char4[0] ;
      AV98loguearFallidosPalabra = GXt_char1 ;
      AV99loguearFallidos = GXutil.boolval( AV98loguearFallidosPalabra) ;
      GXt_char3 = AV74alcanzaGananciasConCodigo ;
      GXt_char1 = AV74alcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procliquidacion2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char2) ;
      procliquidacion2.this.GXt_char3 = GXv_char2[0] ;
      AV74alcanzaGananciasConCodigo = GXt_char3 ;
      GXt_dtime5 = AV67UnoAhora ;
      GXv_dtime6[0] = GXt_dtime5 ;
      new web.getahora(remoteHandle, context).execute( AV15CliCod, GXv_dtime6) ;
      procliquidacion2.this.GXt_dtime5 = GXv_dtime6[0] ;
      AV67UnoAhora = GXt_dtime5 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, "1 "+GXutil.trim( localUtil.ttoc( AV67UnoAhora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV40LiqNro, 8, 0))) ;
      AV32i = (short)(1) ;
      GXt_char3 = AV79TLiqCod ;
      GXv_char4[0] = GXt_char3 ;
      new web.gettipoliq(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, GXv_char4) ;
      procliquidacion2.this.GXt_char3 = GXv_char4[0] ;
      AV79TLiqCod = GXt_char3 ;
      GXt_char3 = AV11bonosExentosConCodigo ;
      GXt_char1 = AV11bonosExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procliquidacion2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char2) ;
      procliquidacion2.this.GXt_char3 = GXv_char2[0] ;
      AV11bonosExentosConCodigo = GXt_char3 ;
      GXt_char3 = AV84fallosCajaExentosConCodigo ;
      GXt_char1 = AV84fallosCajaExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_falloscajaexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procliquidacion2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char2) ;
      procliquidacion2.this.GXt_char3 = GXv_char2[0] ;
      AV84fallosCajaExentosConCodigo = GXt_char3 ;
      GXt_char3 = AV83simNatExentosConCodigo ;
      GXt_char1 = AV83simNatExentosConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_simnatexenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procliquidacion2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char2) ;
      procliquidacion2.this.GXt_char3 = GXv_char2[0] ;
      AV83simNatExentosConCodigo = GXt_char3 ;
      GXt_date7 = AV41LiqPeriodo ;
      GXv_date8[0] = GXt_date7 ;
      new web.getperiodoliquidacion(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, GXv_date8) ;
      procliquidacion2.this.GXt_date7 = GXv_date8[0] ;
      AV41LiqPeriodo = GXt_date7 ;
      AV50primerLegajo = true ;
      /* Using cursor P01AR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV40LiqNro), Integer.valueOf(AV110parmLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxt1AR2 = (byte)(0) ;
         A6LegNumero = P01AR2_A6LegNumero[0] ;
         A31LiqNro = P01AR2_A31LiqNro[0] ;
         A1EmpCod = P01AR2_A1EmpCod[0] ;
         A3CliCod = P01AR2_A3CliCod[0] ;
         A883LIqLegIteraciones = P01AR2_A883LIqLegIteraciones[0] ;
         A2268LiqLegProcesado = P01AR2_A2268LiqLegProcesado[0] ;
         AV33LegNumero = A6LegNumero ;
         AV25errores = "" ;
         /* Execute user subroutine: 'CALCULAR CONCEPTOS' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV50primerLegajo = false ;
         A883LIqLegIteraciones = AV22d ;
         A2268LiqLegProcesado = (byte)(1) ;
         if ( ! new web.espostgres(remoteHandle, context).executeUdp( AV15CliCod) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            gxt1AR2 = (byte)(1) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "LIqLegIteraciones ", "")+GXutil.trim( GXutil.str( A883LIqLegIteraciones, 4, 0))+httpContext.getMessage( " &d ", "")+GXutil.trim( GXutil.str( AV22d, 4, 0))) ;
         /* Using cursor P01AR3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A883LIqLegIteraciones), Byte.valueOf(A2268LiqLegProcesado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         if ( gxt1AR2 == 1 )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "procliquidacion2");
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV49ciclicoErrorHay )
      {
         GXv_boolean9[0] = true ;
         new web.setearerrornocalculado(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV110parmLegNumero, true, GXv_boolean9) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "terminó", "")) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'CALCULAR CONCEPTOS' Routine */
      returnInSub = false ;
      GXv_char4[0] = AV103saldoProrrateoBonosPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV15CliCod, "[cuotas_prorrateo]", false, false, GXv_char4) ;
      procliquidacion2.this.AV103saldoProrrateoBonosPalabra = GXv_char4[0] ;
      GXv_boolean9[0] = AV78calcularSAC ;
      new web.calcularsac(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV33LegNumero, AV79TLiqCod, AV41LiqPeriodo, "", AV105ProcesoLiquidacion, GXv_boolean9) ;
      procliquidacion2.this.AV78calcularSAC = GXv_boolean9[0] ;
      AV22d = (short)(0) ;
      AV55seguir = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV33LegNumero, 8, 0))+httpContext.getMessage( " cerea &d ", "")) ;
      while ( AV55seguir )
      {
         AV12cantPendientes = (short)(0) ;
         AV76pendientes_ConCodigo.clear();
         AV114salidaForzada = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV33LegNumero, 8, 0))+httpContext.getMessage( " ini vuelta ", "")+GXutil.trim( GXutil.str( AV22d, 4, 0))+httpContext.getMessage( " seguir ", "")+GXutil.trim( GXutil.booltostr( AV55seguir))+httpContext.getMessage( " primer legajo ", "")+GXutil.trim( GXutil.booltostr( AV50primerLegajo))) ;
         AV128GXLvl71 = (byte)(0) ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              AV123criterioPalabra ,
                                              A468DSubTipoConCod1 ,
                                              AV121baseImpSubTipoConCod1 ,
                                              AV122contribucionesSubTipoConCod1 ,
                                              Byte.valueOf(A507LiqDCalculado) ,
                                              Integer.valueOf(AV15CliCod) ,
                                              Short.valueOf(AV8EmpCod) ,
                                              Integer.valueOf(AV40LiqNro) ,
                                              Integer.valueOf(AV33LegNumero) ,
                                              AV120calculos_TipoConCod ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              A464DTipoConCod } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING
                                              }
         });
         /* Using cursor P01AR4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV40LiqNro), Integer.valueOf(AV33LegNumero), AV120calculos_TipoConCod, AV121baseImpSubTipoConCod1, AV122contribucionesSubTipoConCod1, AV121baseImpSubTipoConCod1, AV121baseImpSubTipoConCod1});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A468DSubTipoConCod1 = P01AR4_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P01AR4_n468DSubTipoConCod1[0] ;
            A464DTipoConCod = P01AR4_A464DTipoConCod[0] ;
            A507LiqDCalculado = P01AR4_A507LiqDCalculado[0] ;
            A6LegNumero = P01AR4_A6LegNumero[0] ;
            A31LiqNro = P01AR4_A31LiqNro[0] ;
            A1EmpCod = P01AR4_A1EmpCod[0] ;
            A3CliCod = P01AR4_A3CliCod[0] ;
            A394DConCodigo = P01AR4_A394DConCodigo[0] ;
            A1070LiqDLog = P01AR4_A1070LiqDLog[0] ;
            A1072LiqDLogRecal = P01AR4_A1072LiqDLogRecal[0] ;
            A504LiqDForOrig = P01AR4_A504LiqDForOrig[0] ;
            A1122DAplIIGG = P01AR4_A1122DAplIIGG[0] ;
            n1122DAplIIGG = P01AR4_n1122DAplIIGG[0] ;
            A1125LiqDProrr = P01AR4_A1125LiqDProrr[0] ;
            A274LiqDFormula = P01AR4_A274LiqDFormula[0] ;
            n274LiqDFormula = P01AR4_n274LiqDFormula[0] ;
            A508LiqDFormulaHTML = P01AR4_A508LiqDFormulaHTML[0] ;
            n508LiqDFormulaHTML = P01AR4_n508LiqDFormulaHTML[0] ;
            A400DTLiqCod = P01AR4_A400DTLiqCod[0] ;
            A397DLiqPeriodo = P01AR4_A397DLiqPeriodo[0] ;
            A269LiqDCanti = P01AR4_A269LiqDCanti[0] ;
            n269LiqDCanti = P01AR4_n269LiqDCanti[0] ;
            A1760DAgeFecDes = P01AR4_A1760DAgeFecDes[0] ;
            n1760DAgeFecDes = P01AR4_n1760DAgeFecDes[0] ;
            A276LiqDImporte = P01AR4_A276LiqDImporte[0] ;
            n276LiqDImporte = P01AR4_n276LiqDImporte[0] ;
            A277LiqDValUni = P01AR4_A277LiqDValUni[0] ;
            n277LiqDValUni = P01AR4_n277LiqDValUni[0] ;
            A270LiqDErrorDesc = P01AR4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P01AR4_n270LiqDErrorDesc[0] ;
            A1219LiqDPlus = P01AR4_A1219LiqDPlus[0] ;
            A275LiqDImpCalcu = P01AR4_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P01AR4_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P01AR4_A764LiqDImpReCalcu[0] ;
            A502LiqDMostrar = P01AR4_A502LiqDMostrar[0] ;
            A876LiqDReFormulaHTML = P01AR4_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = P01AR4_n876LiqDReFormulaHTML[0] ;
            A749LiqDFormuAux = P01AR4_A749LiqDFormuAux[0] ;
            n749LiqDFormuAux = P01AR4_n749LiqDFormuAux[0] ;
            A968LiqDUniMed = P01AR4_A968LiqDUniMed[0] ;
            A918LiqDVueltaRes = P01AR4_A918LiqDVueltaRes[0] ;
            A509LiqDOrdEjec = P01AR4_A509LiqDOrdEjec[0] ;
            A81LiqDSecuencial = P01AR4_A81LiqDSecuencial[0] ;
            AV128GXLvl71 = (byte)(1) ;
            AV35LiqDFormula = "" ;
            if ( false )
            {
               AV104LiqLog = httpContext.getMessage( "Recorre concepto pendiente de calcular ", "") + GXutil.trim( A394DConCodigo) ;
               new web.actualizalogliquidacion(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV104LiqLog) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "Recorre concepto pendiente de calcular ", "")+GXutil.trim( A394DConCodigo)) ;
            if ( ! AV99loguearFallidos )
            {
               A1070LiqDLog = "" ;
               A1072LiqDLogRecal = "" ;
            }
            AV107altaProrrateoLiqDLog = "" ;
            AV109resolverLiqDLog = "" ;
            AV94LiqDLog = GXutil.trim( A394DConCodigo) + ": " ;
            AV23dependenciasResueltas = false ;
            GXv_boolean9[0] = AV116altaCuotas ;
            GXv_char4[0] = AV118altaCuotaIdOperando ;
            new web.daraltacuota(remoteHandle, context).execute( AV15CliCod, A504LiqDForOrig, A1122DAplIIGG, A1125LiqDProrr, GXv_boolean9, GXv_char4) ;
            procliquidacion2.this.AV116altaCuotas = GXv_boolean9[0] ;
            procliquidacion2.this.AV118altaCuotaIdOperando = GXv_char4[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &altaCuotas ", "")+GXutil.trim( GXutil.booltostr( AV116altaCuotas))) ;
            if ( ! AV116altaCuotas )
            {
               AV47ok = true ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, GXutil.trim( A394DConCodigo)+httpContext.getMessage( " llama a altaRegistrosProrrateo ", "")+GXutil.trim( GXutil.str( A1122DAplIIGG, 4, 0))) ;
               if ( (0==A1122DAplIIGG) )
               {
                  AV117tipo_cuota = "FIJA" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, "___1") ;
               }
               else
               {
                  AV117tipo_cuota = A1125LiqDProrr ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "___2 LiqDProrr ", "")+GXutil.trim( A1125LiqDProrr)) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "___3 &tipo_cuota ", "")+AV117tipo_cuota) ;
               GXv_char4[0] = AV108altaProrrateoError ;
               GXv_char2[0] = AV107altaProrrateoLiqDLog ;
               GXv_int10[0] = AV106altaProrraLiqDCalculado ;
               new web.altaregistrosprorrateo(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, 0, AV33LegNumero, AV41LiqPeriodo, "", AV117tipo_cuota, A394DConCodigo, AV118altaCuotaIdOperando, "Calculo", false, GXv_char4, GXv_char2, GXv_int10) ;
               procliquidacion2.this.AV108altaProrrateoError = GXv_char4[0] ;
               procliquidacion2.this.AV107altaProrrateoLiqDLog = GXv_char2[0] ;
               procliquidacion2.this.AV106altaProrraLiqDCalculado = GXv_int10[0] ;
               if ( AV106altaProrraLiqDCalculado == 0 )
               {
                  AV47ok = false ;
                  Gx_msg = httpContext.getMessage( "Error al calcular cuota: ", "") + GXutil.trim( AV108altaProrrateoError) ;
               }
               else
               {
                  AV47ok = true ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "&altaProrrateoLiqDLog ", "")+GXutil.trim( AV107altaProrrateoLiqDLog)+httpContext.getMessage( " &altaProrraLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV106altaProrraLiqDCalculado, 1, 0))+httpContext.getMessage( " &ok ", "")+GXutil.trim( GXutil.booltostr( AV47ok))) ;
            }
            AV80ConOpeEsCant = DecimalUtil.doubleToDec(0) ;
            GXt_dtime5 = AV69UnoDosAhora ;
            GXv_dtime6[0] = GXt_dtime5 ;
            new web.getahora(remoteHandle, context).execute( AV15CliCod, GXv_dtime6) ;
            procliquidacion2.this.GXt_dtime5 = GXv_dtime6[0] ;
            AV69UnoDosAhora = GXt_dtime5 ;
            GXv_char4[0] = "" ;
            GXv_char2[0] = "NRE_ARG" ;
            GXv_char11[0] = AV20ConFormula ;
            GXv_boolean9[0] = false ;
            GXv_boolean12[0] = false ;
            GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char14[0] = "" ;
            GXv_char15[0] = "" ;
            GXv_char16[0] = "" ;
            GXv_char17[0] = "" ;
            GXv_int18[0] = 0 ;
            GXv_int19[0] = 0 ;
            GXv_char20[0] = "" ;
            GXv_int10[0] = AV90ConVigencia ;
            GXv_boolean21[0] = AV91ConMostrarPos ;
            GXv_boolean22[0] = false ;
            new web.getdatosconcepto(remoteHandle, context).execute( A3CliCod, A394DConCodigo, GXv_char4, GXv_char2, GXv_char11, GXv_boolean9, GXv_boolean12, GXv_decimal13, GXv_char14, GXv_char15, GXv_char16, GXv_char17, GXv_int18, GXv_int19, GXv_char20, GXv_int10, GXv_boolean21, GXv_boolean22) ;
            procliquidacion2.this.AV20ConFormula = GXv_char11[0] ;
            procliquidacion2.this.AV90ConVigencia = GXv_int10[0] ;
            procliquidacion2.this.AV91ConMostrarPos = GXv_boolean21[0] ;
            if ( ! (GXutil.strcmp("", AV20ConFormula)==0) )
            {
               GXt_dtime5 = AV9ahora ;
               GXv_dtime6[0] = GXt_dtime5 ;
               new web.getahora(remoteHandle, context).execute( AV15CliCod, GXv_dtime6) ;
               procliquidacion2.this.GXt_dtime5 = GXv_dtime6[0] ;
               AV9ahora = GXt_dtime5 ;
               if ( AV47ok )
               {
                  GXv_boolean22[0] = AV47ok ;
                  GXv_char20[0] = Gx_msg ;
                  GXv_char17[0] = AV35LiqDFormula ;
                  GXv_char16[0] = AV36LiqDFormulaHTML ;
                  GXv_char15[0] = "" ;
                  GXv_decimal13[0] = AV52Resultado ;
                  GXv_boolean21[0] = AV23dependenciasResueltas ;
                  GXv_decimal23[0] = AV80ConOpeEsCant ;
                  GXv_boolean12[0] = AV86OpeCliAliEs ;
                  GXv_decimal24[0] = AV85cantidadCalculada ;
                  GXv_decimal25[0] = AV92baseImportes ;
                  GXv_boolean9[0] = false ;
                  GXv_char14[0] = AV109resolverLiqDLog ;
                  GXv_decimal26[0] = AV113LiqDPlus ;
                  GXv_boolean27[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( A3CliCod, A394DConCodigo, A274LiqDFormula, A508LiqDFormulaHTML, AV8EmpCod, AV40LiqNro, 0, AV40LiqNro, A6LegNumero, A400DTLiqCod, A397DLiqPeriodo, AV126Pgmname, "Calculo", false, A269LiqDCanti, A1760DAgeFecDes, A276LiqDImporte, A277LiqDValUni, GXv_boolean22, GXv_char20, GXv_char17, GXv_char16, GXv_char15, GXv_decimal13, GXv_boolean21, GXv_decimal23, GXv_boolean12, GXv_decimal24, GXv_decimal25, GXv_boolean9, GXv_char14, GXv_decimal26, GXv_boolean27) ;
                  procliquidacion2.this.AV47ok = GXv_boolean22[0] ;
                  procliquidacion2.this.Gx_msg = GXv_char20[0] ;
                  procliquidacion2.this.AV35LiqDFormula = GXv_char17[0] ;
                  procliquidacion2.this.AV36LiqDFormulaHTML = GXv_char16[0] ;
                  procliquidacion2.this.AV52Resultado = GXv_decimal13[0] ;
                  procliquidacion2.this.AV23dependenciasResueltas = GXv_boolean21[0] ;
                  procliquidacion2.this.AV80ConOpeEsCant = GXv_decimal23[0] ;
                  procliquidacion2.this.AV86OpeCliAliEs = GXv_boolean12[0] ;
                  procliquidacion2.this.AV85cantidadCalculada = GXv_decimal24[0] ;
                  procliquidacion2.this.AV92baseImportes = GXv_decimal25[0] ;
                  procliquidacion2.this.AV109resolverLiqDLog = GXv_char14[0] ;
                  procliquidacion2.this.AV113LiqDPlus = GXv_decimal26[0] ;
               }
               AV94LiqDLog = GXutil.trim( AV107altaProrrateoLiqDLog) + " " + AV109resolverLiqDLog ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV80ConOpeEsCant, 14, 2))) ;
               if ( ! (GXutil.strcmp("", A274LiqDFormula)==0) )
               {
                  A1070LiqDLog += GXutil.trim( AV94LiqDLog) ;
                  A1072LiqDLogRecal += GXutil.trim( AV94LiqDLog) ;
                  if ( ! AV47ok )
                  {
                     if ( false )
                     {
                        AV104LiqLog = httpContext.getMessage( "No lo resuelve!", "") ;
                        new web.actualizalogliquidacion(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV104LiqLog) ;
                     }
                     A270LiqDErrorDesc = Gx_msg ;
                     n270LiqDErrorDesc = false ;
                     if ( AV23dependenciasResueltas )
                     {
                        AV25errores = GXutil.trim( Gx_msg) ;
                        new web.msgdebug7(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "error formula ", "")+AV25errores) ;
                     }
                     else
                     {
                        new web.msgdebug8(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "todavia no estan resueltas las dependencias", "")) ;
                     }
                     if ( AV99loguearFallidos )
                     {
                        AV95dmas2 = (short)(AV22d+2) ;
                        if ( AV95dmas2 > 1 )
                        {
                           AV97dmas1 = (short)(AV22d+1) ;
                           AV96noSePudoResolverMensaje = ". " + GXutil.trim( Gx_msg) + httpContext.getMessage( " (vuelta ", "") + GXutil.trim( GXutil.str( AV97dmas1, 4, 0)) + ") " ;
                           A1070LiqDLog = GXutil.strReplace( A1070LiqDLog, AV96noSePudoResolverMensaje, "") ;
                           A1072LiqDLogRecal = GXutil.strReplace( A1072LiqDLogRecal, AV96noSePudoResolverMensaje, "") ;
                        }
                        AV96noSePudoResolverMensaje = ". " + GXutil.trim( Gx_msg) + httpContext.getMessage( " (vuelta ", "") + GXutil.trim( GXutil.str( AV95dmas2, 4, 0)) + ") " ;
                        A1070LiqDLog += AV96noSePudoResolverMensaje ;
                        A1072LiqDLogRecal += AV96noSePudoResolverMensaje ;
                     }
                  }
                  else
                  {
                     A1219LiqDPlus = AV113LiqDPlus ;
                     A275LiqDImpCalcu = GXutil.roundDecimal( AV52Resultado, 2) ;
                     n275LiqDImpCalcu = false ;
                     A764LiqDImpReCalcu = GXutil.roundDecimal( AV52Resultado, 2) ;
                     GXt_boolean28 = AV28EsConceptoImprimible ;
                     GXv_boolean27[0] = GXt_boolean28 ;
                     new web.esconceptoimprimible(remoteHandle, context).execute( A464DTipoConCod, GXv_boolean27) ;
                     procliquidacion2.this.GXt_boolean28 = GXv_boolean27[0] ;
                     AV28EsConceptoImprimible = GXt_boolean28 ;
                     if ( ( AV28EsConceptoImprimible ) && ( ( ( A275LiqDImpCalcu.doubleValue() > 0 ) && ( AV91ConMostrarPos ) ) || ( ( A275LiqDImpCalcu.doubleValue() != 0 ) && ! AV91ConMostrarPos ) ) )
                     {
                        A502LiqDMostrar = (byte)(3) ;
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
                     new web.msgdebug(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "ASIGNA ", "")+GXutil.trim( GXutil.str( AV52Resultado, 14, 2))+httpContext.getMessage( " a ", "")+GXutil.trim( A394DConCodigo)) ;
                  }
               }
               else
               {
                  A270LiqDErrorDesc = httpContext.getMessage( "Error: Formula vacia", "") ;
                  n270LiqDErrorDesc = false ;
                  AV25errores = httpContext.getMessage( "Error: Formula vacia", "") ;
               }
               if ( ! (GXutil.strcmp("", AV35LiqDFormula)==0) )
               {
                  A274LiqDFormula = GXutil.trim( AV35LiqDFormula) ;
                  n274LiqDFormula = false ;
                  A508LiqDFormulaHTML = GXutil.trim( AV36LiqDFormulaHTML) ;
                  n508LiqDFormulaHTML = false ;
                  A876LiqDReFormulaHTML = GXutil.trim( AV36LiqDFormulaHTML) ;
                  n876LiqDReFormulaHTML = false ;
                  A749LiqDFormuAux = GXutil.trim( AV35LiqDFormula) ;
                  n749LiqDFormuAux = false ;
               }
            }
            else
            {
               if ( ( AV90ConVigencia == 1 ) || new web.esredondeoosobregiro(remoteHandle, context).executeUdp( AV15CliCod, A394DConCodigo) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV23dependenciasResueltas = true ;
                  AV94LiqDLog += httpContext.getMessage( ". Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "") ;
               }
            }
            if ( AV23dependenciasResueltas )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))) ;
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV80ConOpeEsCant, 14, 2))) ;
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80ConOpeEsCant)==0) )
                  {
                     A269LiqDCanti = AV80ConOpeEsCant ;
                     n269LiqDCanti = false ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "le one ", "")+GXutil.trim( GXutil.str( AV80ConOpeEsCant, 14, 2))) ;
                     if ( AV86OpeCliAliEs )
                     {
                        A968LiqDUniMed = "%" ;
                     }
                  }
                  else
                  {
                     if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85cantidadCalculada)==0) )
                     {
                        A269LiqDCanti = AV85cantidadCalculada ;
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
                  if ( AV90ConVigencia == 1 )
                  {
                     GXv_decimal26[0] = A275LiqDImpCalcu ;
                     GXv_decimal25[0] = A764LiqDImpReCalcu ;
                     GXv_boolean27[0] = false ;
                     GXv_char20[0] = "" ;
                     new web.calculomultiporcantimplicito(remoteHandle, context).execute( AV15CliCod, A504LiqDForOrig, AV90ConVigencia, A269LiqDCanti, AV89LiqDImporte, GXv_decimal26, GXv_decimal25, GXv_boolean27, GXv_char20) ;
                     procliquidacion2.this.A275LiqDImpCalcu = GXv_decimal26[0] ;
                     n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
                     procliquidacion2.this.A764LiqDImpReCalcu = GXv_decimal25[0] ;
                  }
               }
               A507LiqDCalculado = (byte)(1) ;
               if ( false )
               {
                  AV104LiqLog = httpContext.getMessage( "Lo resuelve", "") ;
                  new web.actualizalogliquidacion(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV104LiqLog) ;
               }
               if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL046", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDCalculado = 1", "")) ;
               }
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) )
               {
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92baseImportes)==0) )
                  {
                     AV92baseImportes = A275LiqDImpCalcu ;
                     if ( A269LiqDCanti.doubleValue() > 0 )
                     {
                        AV92baseImportes = AV92baseImportes.divide(A269LiqDCanti, 18, java.math.RoundingMode.DOWN) ;
                        if ( GXutil.strcmp(A968LiqDUniMed, "%") == 0 )
                        {
                           AV92baseImportes = AV92baseImportes.multiply(DecimalUtil.doubleToDec(100)) ;
                        }
                     }
                  }
                  A277LiqDValUni = AV92baseImportes ;
                  n277LiqDValUni = false ;
               }
               A270LiqDErrorDesc = "" ;
               n270LiqDErrorDesc = false ;
               A918LiqDVueltaRes = (byte)(AV22d+1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "LiqDVueltaRes ", "")+GXutil.trim( GXutil.str( A918LiqDVueltaRes, 2, 0))+httpContext.getMessage( " &d ", "")+GXutil.trim( GXutil.str( AV22d, 4, 0))) ;
               if ( (GXutil.strcmp("", A1070LiqDLog)==0) )
               {
                  A1070LiqDLog = GXutil.trim( A508LiqDFormulaHTML) ;
               }
               if ( (GXutil.strcmp("", A1072LiqDLogRecal)==0) )
               {
                  A1072LiqDLogRecal = GXutil.trim( A876LiqDReFormulaHTML) ;
               }
               if ( ( GXutil.strcmp(A394DConCodigo, AV74alcanzaGananciasConCodigo) == 0 ) && ( AV115todosInsertados ) && ( A764LiqDImpReCalcu.doubleValue() == 1 ) )
               {
                  AV55seguir = false ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "poner flag para cortar", "")) ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  /* Using cursor P01AR5 */
                  pr_default.execute(3, new Object[] {Byte.valueOf(A507LiqDCalculado), A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1219LiqDPlus, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, A968LiqDUniMed, Byte.valueOf(A918LiqDVueltaRes), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
                  if (true) break;
               }
            }
            else
            {
               if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL046", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDCalculado = 0", "")) ;
               }
               A507LiqDCalculado = (byte)(0) ;
               AV12cantPendientes = (short)(AV12cantPendientes+1) ;
               AV76pendientes_ConCodigo.add(A394DConCodigo, 0);
               new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "LiqDCalculado = 0", "")) ;
               if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "REM010", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "acá NO resolvió a maternidad", "")) ;
               }
               if ( false )
               {
                  AV104LiqLog = httpContext.getMessage( "NO Lo resuelve", "") ;
                  new web.actualizalogliquidacion(remoteHandle, context).execute( AV15CliCod, AV8EmpCod, AV40LiqNro, AV104LiqLog) ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "dDConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &alcanzaGananciasConCodigo ", "")+GXutil.trim( AV74alcanzaGananciasConCodigo)+httpContext.getMessage( " todosinsertados ", "")+GXutil.trim( GXutil.booltostr( AV115todosInsertados))) ;
            if ( ( GXutil.strSearch( GXutil.upper( A504LiqDForOrig), GXutil.upper( GXutil.trim( AV103saldoProrrateoBonosPalabra)), 1) != 0 ) && ( AV47ok ) )
            {
               AV114salidaForzada = true ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               /* Using cursor P01AR6 */
               pr_default.execute(4, new Object[] {Byte.valueOf(A507LiqDCalculado), A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1219LiqDPlus, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, A968LiqDUniMed, Byte.valueOf(A918LiqDVueltaRes), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
               if (true) break;
            }
            /* Using cursor P01AR7 */
            pr_default.execute(5, new Object[] {Byte.valueOf(A507LiqDCalculado), A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1219LiqDPlus, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, A968LiqDUniMed, Byte.valueOf(A918LiqDVueltaRes), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV128GXLvl71 == 0 )
         {
            AV55seguir = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "corta. Total vueltas: ", "")+GXutil.trim( GXutil.str( AV22d, 4, 0))) ;
         }
         if ( ! AV114salidaForzada )
         {
            AV22d = (short)(AV22d+1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV33LegNumero, 8, 0))+httpContext.getMessage( " suma &d ", "")+GXutil.str( AV22d, 4, 0)+httpContext.getMessage( " &cantPendientes ", "")+GXutil.trim( GXutil.str( AV12cantPendientes, 4, 0))+httpContext.getMessage( " ultimo ", "")+GXutil.trim( GXutil.str( AV13cantPendientesUltimo, 4, 0))) ;
            if ( AV12cantPendientes == AV13cantPendientesUltimo )
            {
               if ( AV12cantPendientes > 0 )
               {
                  AV49ciclicoErrorHay = true ;
                  AV55seguir = false ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV126Pgmname, httpContext.getMessage( "LOOPEO &cantPendientes ", "")+GXutil.str( AV12cantPendientes, 4, 0)) ;
               }
            }
            AV13cantPendientesUltimo = AV12cantPendientes ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = procliquidacion2.this.AV49ciclicoErrorHay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV120calculos_TipoConCod = "" ;
      AV121baseImpSubTipoConCod1 = "" ;
      AV122contribucionesSubTipoConCod1 = "" ;
      AV126Pgmname = "" ;
      AV98loguearFallidosPalabra = "" ;
      AV74alcanzaGananciasConCodigo = "" ;
      AV67UnoAhora = GXutil.resetTime( GXutil.nullDate() );
      AV79TLiqCod = "" ;
      AV11bonosExentosConCodigo = "" ;
      AV84fallosCajaExentosConCodigo = "" ;
      AV83simNatExentosConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      AV41LiqPeriodo = GXutil.nullDate() ;
      GXt_date7 = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      scmdbuf = "" ;
      P01AR2_A6LegNumero = new int[1] ;
      P01AR2_A31LiqNro = new int[1] ;
      P01AR2_A1EmpCod = new short[1] ;
      P01AR2_A3CliCod = new int[1] ;
      P01AR2_A883LIqLegIteraciones = new short[1] ;
      P01AR2_A2268LiqLegProcesado = new byte[1] ;
      AV25errores = "" ;
      A394DConCodigo = "" ;
      A1070LiqDLog = "" ;
      A1072LiqDLogRecal = "" ;
      A504LiqDForOrig = "" ;
      A1125LiqDProrr = "" ;
      A274LiqDFormula = "" ;
      A508LiqDFormulaHTML = "" ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A1760DAgeFecDes = GXutil.nullDate() ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A968LiqDUniMed = "" ;
      A270LiqDErrorDesc = "" ;
      A876LiqDReFormulaHTML = "" ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      A749LiqDFormuAux = "" ;
      AV103saldoProrrateoBonosPalabra = "" ;
      AV105ProcesoLiquidacion = "" ;
      AV76pendientes_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      A468DSubTipoConCod1 = "" ;
      P01AR4_A468DSubTipoConCod1 = new String[] {""} ;
      P01AR4_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01AR4_A464DTipoConCod = new String[] {""} ;
      P01AR4_A507LiqDCalculado = new byte[1] ;
      P01AR4_A6LegNumero = new int[1] ;
      P01AR4_A31LiqNro = new int[1] ;
      P01AR4_A1EmpCod = new short[1] ;
      P01AR4_A3CliCod = new int[1] ;
      P01AR4_A394DConCodigo = new String[] {""} ;
      P01AR4_A1070LiqDLog = new String[] {""} ;
      P01AR4_A1072LiqDLogRecal = new String[] {""} ;
      P01AR4_A504LiqDForOrig = new String[] {""} ;
      P01AR4_A1122DAplIIGG = new short[1] ;
      P01AR4_n1122DAplIIGG = new boolean[] {false} ;
      P01AR4_A1125LiqDProrr = new String[] {""} ;
      P01AR4_A274LiqDFormula = new String[] {""} ;
      P01AR4_n274LiqDFormula = new boolean[] {false} ;
      P01AR4_A508LiqDFormulaHTML = new String[] {""} ;
      P01AR4_n508LiqDFormulaHTML = new boolean[] {false} ;
      P01AR4_A400DTLiqCod = new String[] {""} ;
      P01AR4_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01AR4_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_n269LiqDCanti = new boolean[] {false} ;
      P01AR4_A1760DAgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01AR4_n1760DAgeFecDes = new boolean[] {false} ;
      P01AR4_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_n276LiqDImporte = new boolean[] {false} ;
      P01AR4_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_n277LiqDValUni = new boolean[] {false} ;
      P01AR4_A270LiqDErrorDesc = new String[] {""} ;
      P01AR4_n270LiqDErrorDesc = new boolean[] {false} ;
      P01AR4_A1219LiqDPlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_n275LiqDImpCalcu = new boolean[] {false} ;
      P01AR4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01AR4_A502LiqDMostrar = new byte[1] ;
      P01AR4_A876LiqDReFormulaHTML = new String[] {""} ;
      P01AR4_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P01AR4_A749LiqDFormuAux = new String[] {""} ;
      P01AR4_n749LiqDFormuAux = new boolean[] {false} ;
      P01AR4_A968LiqDUniMed = new String[] {""} ;
      P01AR4_A918LiqDVueltaRes = new byte[1] ;
      P01AR4_A509LiqDOrdEjec = new long[1] ;
      P01AR4_A81LiqDSecuencial = new int[1] ;
      AV35LiqDFormula = "" ;
      AV104LiqLog = "" ;
      AV107altaProrrateoLiqDLog = "" ;
      AV109resolverLiqDLog = "" ;
      AV94LiqDLog = "" ;
      AV118altaCuotaIdOperando = "" ;
      AV117tipo_cuota = "" ;
      AV108altaProrrateoError = "" ;
      Gx_msg = "" ;
      AV80ConOpeEsCant = DecimalUtil.ZERO ;
      AV69UnoDosAhora = GXutil.resetTime( GXutil.nullDate() );
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV20ConFormula = "" ;
      GXv_char11 = new String[1] ;
      GXv_int18 = new int[1] ;
      GXv_int19 = new long[1] ;
      GXv_int10 = new byte[1] ;
      AV9ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime5 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime6 = new java.util.Date[1] ;
      GXv_boolean22 = new boolean[1] ;
      GXv_char17 = new String[1] ;
      AV36LiqDFormulaHTML = "" ;
      GXv_char16 = new String[1] ;
      GXv_char15 = new String[1] ;
      AV52Resultado = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_boolean21 = new boolean[1] ;
      GXv_decimal23 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      AV85cantidadCalculada = DecimalUtil.ZERO ;
      GXv_decimal24 = new java.math.BigDecimal[1] ;
      AV92baseImportes = DecimalUtil.ZERO ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char14 = new String[1] ;
      AV113LiqDPlus = DecimalUtil.ZERO ;
      AV96noSePudoResolverMensaje = "" ;
      AV89LiqDImporte = DecimalUtil.ZERO ;
      GXv_decimal26 = new java.math.BigDecimal[1] ;
      GXv_decimal25 = new java.math.BigDecimal[1] ;
      GXv_boolean27 = new boolean[1] ;
      GXv_char20 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procliquidacion2__default(),
         new Object[] {
             new Object[] {
            P01AR2_A6LegNumero, P01AR2_A31LiqNro, P01AR2_A1EmpCod, P01AR2_A3CliCod, P01AR2_A883LIqLegIteraciones, P01AR2_A2268LiqLegProcesado
            }
            , new Object[] {
            }
            , new Object[] {
            P01AR4_A468DSubTipoConCod1, P01AR4_n468DSubTipoConCod1, P01AR4_A464DTipoConCod, P01AR4_A507LiqDCalculado, P01AR4_A6LegNumero, P01AR4_A31LiqNro, P01AR4_A1EmpCod, P01AR4_A3CliCod, P01AR4_A394DConCodigo, P01AR4_A1070LiqDLog,
            P01AR4_A1072LiqDLogRecal, P01AR4_A504LiqDForOrig, P01AR4_A1122DAplIIGG, P01AR4_n1122DAplIIGG, P01AR4_A1125LiqDProrr, P01AR4_A274LiqDFormula, P01AR4_n274LiqDFormula, P01AR4_A508LiqDFormulaHTML, P01AR4_n508LiqDFormulaHTML, P01AR4_A400DTLiqCod,
            P01AR4_A397DLiqPeriodo, P01AR4_A269LiqDCanti, P01AR4_n269LiqDCanti, P01AR4_A1760DAgeFecDes, P01AR4_n1760DAgeFecDes, P01AR4_A276LiqDImporte, P01AR4_n276LiqDImporte, P01AR4_A277LiqDValUni, P01AR4_n277LiqDValUni, P01AR4_A270LiqDErrorDesc,
            P01AR4_n270LiqDErrorDesc, P01AR4_A1219LiqDPlus, P01AR4_A275LiqDImpCalcu, P01AR4_n275LiqDImpCalcu, P01AR4_A764LiqDImpReCalcu, P01AR4_A502LiqDMostrar, P01AR4_A876LiqDReFormulaHTML, P01AR4_n876LiqDReFormulaHTML, P01AR4_A749LiqDFormuAux, P01AR4_n749LiqDFormuAux,
            P01AR4_A968LiqDUniMed, P01AR4_A918LiqDVueltaRes, P01AR4_A509LiqDOrdEjec, P01AR4_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV126Pgmname = "ProcLiquidacion2" ;
      /* GeneXus formulas. */
      AV126Pgmname = "ProcLiquidacion2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV112LiqDLote ;
   private byte gxt1AR2 ;
   private byte A2268LiqLegProcesado ;
   private byte A502LiqDMostrar ;
   private byte A918LiqDVueltaRes ;
   private byte A507LiqDCalculado ;
   private byte AV128GXLvl71 ;
   private byte AV106altaProrraLiqDCalculado ;
   private byte AV90ConVigencia ;
   private byte GXv_int10[] ;
   private short AV8EmpCod ;
   private short AV32i ;
   private short A1EmpCod ;
   private short A883LIqLegIteraciones ;
   private short AV22d ;
   private short A1122DAplIIGG ;
   private short AV12cantPendientes ;
   private short AV95dmas2 ;
   private short AV97dmas1 ;
   private short AV13cantPendientesUltimo ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV40LiqNro ;
   private int AV110parmLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int AV33LegNumero ;
   private int A81LiqDSecuencial ;
   private int GXv_int18[] ;
   private long A509LiqDOrdEjec ;
   private long GXv_int19[] ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private java.math.BigDecimal AV80ConOpeEsCant ;
   private java.math.BigDecimal AV52Resultado ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal23[] ;
   private java.math.BigDecimal AV85cantidadCalculada ;
   private java.math.BigDecimal GXv_decimal24[] ;
   private java.math.BigDecimal AV92baseImportes ;
   private java.math.BigDecimal AV113LiqDPlus ;
   private java.math.BigDecimal AV89LiqDImporte ;
   private java.math.BigDecimal GXv_decimal26[] ;
   private java.math.BigDecimal GXv_decimal25[] ;
   private String AV123criterioPalabra ;
   private String AV120calculos_TipoConCod ;
   private String AV121baseImpSubTipoConCod1 ;
   private String AV122contribucionesSubTipoConCod1 ;
   private String AV126Pgmname ;
   private String AV98loguearFallidosPalabra ;
   private String AV74alcanzaGananciasConCodigo ;
   private String AV79TLiqCod ;
   private String AV11bonosExentosConCodigo ;
   private String AV84fallosCajaExentosConCodigo ;
   private String AV83simNatExentosConCodigo ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A1125LiqDProrr ;
   private String A400DTLiqCod ;
   private String A464DTipoConCod ;
   private String A968LiqDUniMed ;
   private String AV103saldoProrrateoBonosPalabra ;
   private String AV105ProcesoLiquidacion ;
   private String A468DSubTipoConCod1 ;
   private String AV118altaCuotaIdOperando ;
   private String AV117tipo_cuota ;
   private String Gx_msg ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private String GXv_char11[] ;
   private String GXv_char17[] ;
   private String GXv_char16[] ;
   private String GXv_char15[] ;
   private String GXv_char14[] ;
   private String GXv_char20[] ;
   private java.util.Date AV67UnoAhora ;
   private java.util.Date AV69UnoDosAhora ;
   private java.util.Date AV9ahora ;
   private java.util.Date GXt_dtime5 ;
   private java.util.Date GXv_dtime6[] ;
   private java.util.Date AV41LiqPeriodo ;
   private java.util.Date GXt_date7 ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date A1760DAgeFecDes ;
   private boolean AV115todosInsertados ;
   private boolean AV49ciclicoErrorHay ;
   private boolean AV99loguearFallidos ;
   private boolean AV50primerLegajo ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV78calcularSAC ;
   private boolean AV55seguir ;
   private boolean AV114salidaForzada ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n1122DAplIIGG ;
   private boolean n274LiqDFormula ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n269LiqDCanti ;
   private boolean n1760DAgeFecDes ;
   private boolean n276LiqDImporte ;
   private boolean n277LiqDValUni ;
   private boolean n270LiqDErrorDesc ;
   private boolean n275LiqDImpCalcu ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n749LiqDFormuAux ;
   private boolean AV23dependenciasResueltas ;
   private boolean AV116altaCuotas ;
   private boolean AV47ok ;
   private boolean AV91ConMostrarPos ;
   private boolean GXv_boolean22[] ;
   private boolean GXv_boolean21[] ;
   private boolean AV86OpeCliAliEs ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean9[] ;
   private boolean AV28EsConceptoImprimible ;
   private boolean GXt_boolean28 ;
   private boolean GXv_boolean27[] ;
   private String A1070LiqDLog ;
   private String A1072LiqDLogRecal ;
   private String A504LiqDForOrig ;
   private String A274LiqDFormula ;
   private String A508LiqDFormulaHTML ;
   private String A876LiqDReFormulaHTML ;
   private String AV35LiqDFormula ;
   private String AV104LiqLog ;
   private String AV107altaProrrateoLiqDLog ;
   private String AV109resolverLiqDLog ;
   private String AV94LiqDLog ;
   private String AV20ConFormula ;
   private String AV36LiqDFormulaHTML ;
   private String AV111programa ;
   private String AV25errores ;
   private String A270LiqDErrorDesc ;
   private String A749LiqDFormuAux ;
   private String AV108altaProrrateoError ;
   private String AV96noSePudoResolverMensaje ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01AR2_A6LegNumero ;
   private int[] P01AR2_A31LiqNro ;
   private short[] P01AR2_A1EmpCod ;
   private int[] P01AR2_A3CliCod ;
   private short[] P01AR2_A883LIqLegIteraciones ;
   private byte[] P01AR2_A2268LiqLegProcesado ;
   private String[] P01AR4_A468DSubTipoConCod1 ;
   private boolean[] P01AR4_n468DSubTipoConCod1 ;
   private String[] P01AR4_A464DTipoConCod ;
   private byte[] P01AR4_A507LiqDCalculado ;
   private int[] P01AR4_A6LegNumero ;
   private int[] P01AR4_A31LiqNro ;
   private short[] P01AR4_A1EmpCod ;
   private int[] P01AR4_A3CliCod ;
   private String[] P01AR4_A394DConCodigo ;
   private String[] P01AR4_A1070LiqDLog ;
   private String[] P01AR4_A1072LiqDLogRecal ;
   private String[] P01AR4_A504LiqDForOrig ;
   private short[] P01AR4_A1122DAplIIGG ;
   private boolean[] P01AR4_n1122DAplIIGG ;
   private String[] P01AR4_A1125LiqDProrr ;
   private String[] P01AR4_A274LiqDFormula ;
   private boolean[] P01AR4_n274LiqDFormula ;
   private String[] P01AR4_A508LiqDFormulaHTML ;
   private boolean[] P01AR4_n508LiqDFormulaHTML ;
   private String[] P01AR4_A400DTLiqCod ;
   private java.util.Date[] P01AR4_A397DLiqPeriodo ;
   private java.math.BigDecimal[] P01AR4_A269LiqDCanti ;
   private boolean[] P01AR4_n269LiqDCanti ;
   private java.util.Date[] P01AR4_A1760DAgeFecDes ;
   private boolean[] P01AR4_n1760DAgeFecDes ;
   private java.math.BigDecimal[] P01AR4_A276LiqDImporte ;
   private boolean[] P01AR4_n276LiqDImporte ;
   private java.math.BigDecimal[] P01AR4_A277LiqDValUni ;
   private boolean[] P01AR4_n277LiqDValUni ;
   private String[] P01AR4_A270LiqDErrorDesc ;
   private boolean[] P01AR4_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01AR4_A1219LiqDPlus ;
   private java.math.BigDecimal[] P01AR4_A275LiqDImpCalcu ;
   private boolean[] P01AR4_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01AR4_A764LiqDImpReCalcu ;
   private byte[] P01AR4_A502LiqDMostrar ;
   private String[] P01AR4_A876LiqDReFormulaHTML ;
   private boolean[] P01AR4_n876LiqDReFormulaHTML ;
   private String[] P01AR4_A749LiqDFormuAux ;
   private boolean[] P01AR4_n749LiqDFormuAux ;
   private String[] P01AR4_A968LiqDUniMed ;
   private byte[] P01AR4_A918LiqDVueltaRes ;
   private long[] P01AR4_A509LiqDOrdEjec ;
   private int[] P01AR4_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV76pendientes_ConCodigo ;
}

final  class procliquidacion2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01AR4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV123criterioPalabra ,
                                          String A468DSubTipoConCod1 ,
                                          String AV121baseImpSubTipoConCod1 ,
                                          String AV122contribucionesSubTipoConCod1 ,
                                          byte A507LiqDCalculado ,
                                          int AV15CliCod ,
                                          short AV8EmpCod ,
                                          int AV40LiqNro ,
                                          int AV33LegNumero ,
                                          String AV120calculos_TipoConCod ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          String A464DTipoConCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[9];
      Object[] GXv_Object30 = new Object[2];
      scmdbuf = "SELECT DSubTipoConCod1, DTipoConCod, LiqDCalculado, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDLog, LiqDLogRecal, LiqDForOrig, DAplIIGG, LiqDProrr, LiqDFormula," ;
      scmdbuf += " LiqDFormulaHTML, DTLiqCod, DLiqPeriodo, LiqDCanti, DAgeFecDes, LiqDImporte, LiqDValUni, LiqDErrorDesc, LiqDPlus, LiqDImpCalcu, LiqDImpReCalcu, LiqDMostrar, LiqDReFormulaHTML," ;
      scmdbuf += " LiqDFormuAux, LiqDUniMed, LiqDVueltaRes, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?))");
      addWhere(sWhereString, "(LiqDCalculado = 0)");
      if ( GXutil.strcmp(AV123criterioPalabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV123criterioPalabra, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV123criterioPalabra, httpContext.getMessage( "OTROS", "")) == 0 )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 <> ( ?) and DSubTipoConCod1 <> ( ?))");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
         GXv_int29[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod, LiqDOrdEjec" ;
      scmdbuf += " FOR UPDATE OF LiquidacionDetalle" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_P01AR4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AR2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LIqLegIteraciones, LiqLegProcesado FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01AR3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LIqLegIteraciones=?, LiqLegProcesado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01AR4", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01AR5", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDLog=?, LiqDLogRecal=?, LiqDFormula=?, LiqDFormulaHTML=?, LiqDCanti=?, LiqDValUni=?, LiqDErrorDesc=?, LiqDPlus=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDMostrar=?, LiqDReFormulaHTML=?, LiqDFormuAux=?, LiqDUniMed=?, LiqDVueltaRes=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01AR6", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDLog=?, LiqDLogRecal=?, LiqDFormula=?, LiqDFormulaHTML=?, LiqDCanti=?, LiqDValUni=?, LiqDErrorDesc=?, LiqDPlus=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDMostrar=?, LiqDReFormulaHTML=?, LiqDFormuAux=?, LiqDUniMed=?, LiqDVueltaRes=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01AR7", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDLog=?, LiqDLogRecal=?, LiqDFormula=?, LiqDFormulaHTML=?, LiqDCanti=?, LiqDValUni=?, LiqDErrorDesc=?, LiqDPlus=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDMostrar=?, LiqDReFormulaHTML=?, LiqDFormuAux=?, LiqDUniMed=?, LiqDVueltaRes=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 10);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(16, 20);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,2);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(19);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[31])[0] = rslt.getBigDecimal(23,4);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(24,2);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(25,2);
               ((byte[]) buf[35])[0] = rslt.getByte(26);
               ((String[]) buf[36])[0] = rslt.getLongVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getString(29, 20);
               ((byte[]) buf[41])[0] = rslt.getByte(30);
               ((long[]) buf[42])[0] = rslt.getLong(31);
               ((int[]) buf[43])[0] = rslt.getInt(32);
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[4]);
               }
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
               stmt.setInt(17, ((Number) parms[24]).intValue());
               stmt.setShort(18, ((Number) parms[25]).shortValue());
               stmt.setInt(19, ((Number) parms[26]).intValue());
               stmt.setInt(20, ((Number) parms[27]).intValue());
               stmt.setInt(21, ((Number) parms[28]).intValue());
               return;
            case 4 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[4]);
               }
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
               stmt.setInt(17, ((Number) parms[24]).intValue());
               stmt.setShort(18, ((Number) parms[25]).shortValue());
               stmt.setInt(19, ((Number) parms[26]).intValue());
               stmt.setInt(20, ((Number) parms[27]).intValue());
               stmt.setInt(21, ((Number) parms[28]).intValue());
               return;
            case 5 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[4]);
               }
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
               stmt.setInt(17, ((Number) parms[24]).intValue());
               stmt.setShort(18, ((Number) parms[25]).shortValue());
               stmt.setInt(19, ((Number) parms[26]).intValue());
               stmt.setInt(20, ((Number) parms[27]).intValue());
               stmt.setInt(21, ((Number) parms[28]).intValue());
               return;
      }
   }

}

