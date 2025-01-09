package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procrecalculo extends GXProcedure
{
   public procrecalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procrecalculo.class ), "" );
   }

   public procrecalculo( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 )
   {
      procrecalculo.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String[] aP5 )
   {
      procrecalculo.this.AV24CliCod = aP0;
      procrecalculo.this.AV8EmpCod = aP1;
      procrecalculo.this.AV9LiqNro = aP2;
      procrecalculo.this.AV80ActualLiqNro = aP3;
      procrecalculo.this.AV50LegNumero = aP4;
      procrecalculo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV92loguearFallidosPalabra ;
      GXt_char2 = AV92loguearFallidosPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.logfallidos_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      procrecalculo.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char2, GXv_char4) ;
      procrecalculo.this.GXt_char1 = GXv_char4[0] ;
      AV92loguearFallidosPalabra = GXt_char1 ;
      AV93loguearFallidos = GXutil.boolval( AV92loguearFallidosPalabra) ;
      AV34UnoAhora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1 "+GXutil.trim( localUtil.ttoc( AV34UnoAhora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))) ;
      AV49i = (short)(1) ;
      GXt_char2 = AV86alcanzaGananciasConCodigo ;
      GXt_char1 = AV86alcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procrecalculo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char1, GXv_char3) ;
      procrecalculo.this.GXt_char2 = GXv_char3[0] ;
      AV86alcanzaGananciasConCodigo = GXt_char2 ;
      /* Using cursor P00SO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV24CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV50LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00SO2_A3CliCod[0] ;
         A1EmpCod = P00SO2_A1EmpCod[0] ;
         A31LiqNro = P00SO2_A31LiqNro[0] ;
         A6LegNumero = P00SO2_A6LegNumero[0] ;
         A763LiqDRecalculado = P00SO2_A763LiqDRecalculado[0] ;
         A394DConCodigo = P00SO2_A394DConCodigo[0] ;
         A765LiqdFormuRecalc = P00SO2_A765LiqdFormuRecalc[0] ;
         n765LiqdFormuRecalc = P00SO2_n765LiqdFormuRecalc[0] ;
         A876LiqDReFormulaHTML = P00SO2_A876LiqDReFormulaHTML[0] ;
         n876LiqDReFormulaHTML = P00SO2_n876LiqDReFormulaHTML[0] ;
         A764LiqDImpReCalcu = P00SO2_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P00SO2_A1072LiqDLogRecal[0] ;
         A509LiqDOrdEjec = P00SO2_A509LiqDOrdEjec[0] ;
         A81LiqDSecuencial = P00SO2_A81LiqDSecuencial[0] ;
         A763LiqDRecalculado = (short)(0) ;
         GXt_char2 = A765LiqdFormuRecalc ;
         GXv_char4[0] = GXt_char2 ;
         new web.getformulaconcepto(remoteHandle, context).execute( AV24CliCod, A394DConCodigo, GXv_char4) ;
         procrecalculo.this.GXt_char2 = GXv_char4[0] ;
         A765LiqdFormuRecalc = GXt_char2 ;
         n765LiqdFormuRecalc = false ;
         A876LiqDReFormulaHTML = A765LiqdFormuRecalc ;
         n876LiqDReFormulaHTML = false ;
         if ( GXutil.strcmp(A394DConCodigo, AV86alcanzaGananciasConCodigo) == 0 )
         {
            AV81viejo_AlcanzaGanancias = (short)(DecimalUtil.decToDouble(A764LiqDImpReCalcu)) ;
         }
         A1072LiqDLogRecal += httpContext.getMessage( " (resetea...)", "") ;
         /* Using cursor P00SO3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A763LiqDRecalculado), Boolean.valueOf(n765LiqdFormuRecalc), A765LiqdFormuRecalc, Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, A1072LiqDLogRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      GXt_char2 = AV76pagoACuentaConCodigo ;
      GXt_char1 = AV76pagoACuentaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      procrecalculo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char1, GXv_char3) ;
      procrecalculo.this.GXt_char2 = GXv_char3[0] ;
      AV76pagoACuentaConCodigo = GXt_char2 ;
      AV52d = (short)(0) ;
      AV53seguir = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV50LegNumero, 8, 0))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV24CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))) ;
      GXv_char4[0] = AV94saldoProrrateoBonosPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV24CliCod, "[cuotas_prorrateo]", false, false, GXv_char4) ;
      procrecalculo.this.AV94saldoProrrateoBonosPalabra = GXv_char4[0] ;
      if ( false )
      {
         AV99LiqLog = httpContext.getMessage( "----------------	RECALCULO -----------------------------", "") ;
         new web.actualizalogliquidacion(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, AV99LiqLog) ;
      }
      while ( AV53seguir )
      {
         AV68cantPendientes = (short)(0) ;
         AV85pendientesConCodigo.clear();
         AV107GXLvl49 = (byte)(0) ;
         /* Using cursor P00SO4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV24CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV50LegNumero)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A3CliCod = P00SO4_A3CliCod[0] ;
            A1EmpCod = P00SO4_A1EmpCod[0] ;
            A31LiqNro = P00SO4_A31LiqNro[0] ;
            A6LegNumero = P00SO4_A6LegNumero[0] ;
            A763LiqDRecalculado = P00SO4_A763LiqDRecalculado[0] ;
            A270LiqDErrorDesc = P00SO4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P00SO4_n270LiqDErrorDesc[0] ;
            A394DConCodigo = P00SO4_A394DConCodigo[0] ;
            A1072LiqDLogRecal = P00SO4_A1072LiqDLogRecal[0] ;
            A393DConDescrip = P00SO4_A393DConDescrip[0] ;
            A504LiqDForOrig = P00SO4_A504LiqDForOrig[0] ;
            A1122DAplIIGG = P00SO4_A1122DAplIIGG[0] ;
            n1122DAplIIGG = P00SO4_n1122DAplIIGG[0] ;
            A1125LiqDProrr = P00SO4_A1125LiqDProrr[0] ;
            A397DLiqPeriodo = P00SO4_A397DLiqPeriodo[0] ;
            A765LiqdFormuRecalc = P00SO4_A765LiqdFormuRecalc[0] ;
            n765LiqdFormuRecalc = P00SO4_n765LiqdFormuRecalc[0] ;
            A876LiqDReFormulaHTML = P00SO4_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = P00SO4_n876LiqDReFormulaHTML[0] ;
            A400DTLiqCod = P00SO4_A400DTLiqCod[0] ;
            A269LiqDCanti = P00SO4_A269LiqDCanti[0] ;
            n269LiqDCanti = P00SO4_n269LiqDCanti[0] ;
            A1760DAgeFecDes = P00SO4_A1760DAgeFecDes[0] ;
            n1760DAgeFecDes = P00SO4_n1760DAgeFecDes[0] ;
            A276LiqDImporte = P00SO4_A276LiqDImporte[0] ;
            n276LiqDImporte = P00SO4_n276LiqDImporte[0] ;
            A277LiqDValUni = P00SO4_A277LiqDValUni[0] ;
            n277LiqDValUni = P00SO4_n277LiqDValUni[0] ;
            A274LiqDFormula = P00SO4_A274LiqDFormula[0] ;
            n274LiqDFormula = P00SO4_n274LiqDFormula[0] ;
            A764LiqDImpReCalcu = P00SO4_A764LiqDImpReCalcu[0] ;
            A509LiqDOrdEjec = P00SO4_A509LiqDOrdEjec[0] ;
            A81LiqDSecuencial = P00SO4_A81LiqDSecuencial[0] ;
            AV107GXLvl49 = (byte)(1) ;
            AV10LiqDFormula = "" ;
            A270LiqDErrorDesc = "" ;
            n270LiqDErrorDesc = false ;
            AV41UnoDosAhora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
            if ( false )
            {
               AV99LiqLog = httpContext.getMessage( "Recorre concepto pendiente de re-calcular ", "") + GXutil.trim( A394DConCodigo) ;
               new web.actualizalogliquidacion(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, AV99LiqLog) ;
            }
            A1072LiqDLogRecal += httpContext.getMessage( " (recalculando...)", "") ;
            GXv_char4[0] = AV25ConFormula ;
            new web.getformulaconcepto(remoteHandle, context).execute( A3CliCod, A394DConCodigo, GXv_char4) ;
            procrecalculo.this.AV25ConFormula = GXv_char4[0] ;
            if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL054", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "Recalcula ", "")+GXutil.trim( A393DConDescrip)+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
            }
            AV96altaProrrateoLiqDLog = "" ;
            AV98resolverLiqDLog = "" ;
            AV51dependenciasResueltas = false ;
            GXv_boolean5[0] = AV100altaCuotas ;
            GXv_char4[0] = AV102altaCuotaIdOperando ;
            new web.daraltacuota(remoteHandle, context).execute( AV24CliCod, A504LiqDForOrig, A1122DAplIIGG, A1125LiqDProrr, GXv_boolean5, GXv_char4) ;
            procrecalculo.this.AV100altaCuotas = GXv_boolean5[0] ;
            procrecalculo.this.AV102altaCuotaIdOperando = GXv_char4[0] ;
            if ( ! AV100altaCuotas )
            {
               AV20ok = true ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, GXutil.trim( A394DConCodigo)+httpContext.getMessage( " llama a altaRegistrosProrrateo ", "")+GXutil.trim( GXutil.str( A1122DAplIIGG, 4, 0))) ;
               if ( (0==A1122DAplIIGG) )
               {
                  AV101tipo_cuota = "FIJA" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "___1") ;
               }
               else
               {
                  AV101tipo_cuota = A1125LiqDProrr ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "___2 LiqDProrr ", "")+GXutil.trim( A1125LiqDProrr)) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "___3 &tipo_cuota ", "")+AV101tipo_cuota) ;
               GXv_char4[0] = AV97altaProrrateoError ;
               GXv_char3[0] = AV96altaProrrateoLiqDLog ;
               GXv_int6[0] = AV95altaProrraLiqDCalculado ;
               new web.altaregistrosprorrateo(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, A31LiqNro, 0, AV50LegNumero, A397DLiqPeriodo, "", AV101tipo_cuota, A394DConCodigo, AV102altaCuotaIdOperando, "Recalculo", false, GXv_char4, GXv_char3, GXv_int6) ;
               procrecalculo.this.AV97altaProrrateoError = GXv_char4[0] ;
               procrecalculo.this.AV96altaProrrateoLiqDLog = GXv_char3[0] ;
               procrecalculo.this.AV95altaProrraLiqDCalculado = GXv_int6[0] ;
               if ( AV95altaProrraLiqDCalculado == 0 )
               {
                  AV20ok = false ;
                  Gx_msg = httpContext.getMessage( "Error al calcular cuota: ", "") + GXutil.trim( AV97altaProrrateoError) ;
               }
               else
               {
                  AV20ok = true ;
               }
            }
            AV91LiqDLog = "" ;
            A1072LiqDLogRecal += httpContext.getMessage( " (rereeeeeeeeeeeeeeeecalculando...) ", "") + GXutil.trim( GXutil.booltostr( AV51dependenciasResueltas)) + httpContext.getMessage( " ok ", "") + GXutil.trim( GXutil.booltostr( AV20ok)) ;
            if ( ! (GXutil.strcmp("", AV25ConFormula)==0) )
            {
               AV33ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
               if ( AV20ok )
               {
                  GXv_boolean5[0] = AV20ok ;
                  GXv_char4[0] = Gx_msg ;
                  GXv_char3[0] = AV10LiqDFormula ;
                  GXv_char7[0] = AV55LiqDFormulaHTML ;
                  GXv_char8[0] = "" ;
                  GXv_decimal9[0] = AV16Resultado ;
                  GXv_boolean10[0] = AV51dependenciasResueltas ;
                  GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean12[0] = false ;
                  GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean15[0] = false ;
                  GXv_char16[0] = AV98resolverLiqDLog ;
                  GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean18[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( A3CliCod, A394DConCodigo, A765LiqdFormuRecalc, A876LiqDReFormulaHTML, AV8EmpCod, AV9LiqNro, 0, AV80ActualLiqNro, A6LegNumero, A400DTLiqCod, A397DLiqPeriodo, AV105Pgmname, "Recalculo", false, A269LiqDCanti, A1760DAgeFecDes, A276LiqDImporte, A277LiqDValUni, GXv_boolean5, GXv_char4, GXv_char3, GXv_char7, GXv_char8, GXv_decimal9, GXv_boolean10, GXv_decimal11, GXv_boolean12, GXv_decimal13, GXv_decimal14, GXv_boolean15, GXv_char16, GXv_decimal17, GXv_boolean18) ;
                  procrecalculo.this.AV20ok = GXv_boolean5[0] ;
                  procrecalculo.this.Gx_msg = GXv_char4[0] ;
                  procrecalculo.this.AV10LiqDFormula = GXv_char3[0] ;
                  procrecalculo.this.AV55LiqDFormulaHTML = GXv_char7[0] ;
                  procrecalculo.this.AV16Resultado = GXv_decimal9[0] ;
                  procrecalculo.this.AV51dependenciasResueltas = GXv_boolean10[0] ;
                  procrecalculo.this.AV98resolverLiqDLog = GXv_char16[0] ;
               }
               AV91LiqDLog += "////////" + GXutil.trim( AV96altaProrrateoLiqDLog) + " " + AV98resolverLiqDLog ;
               if ( ! (GXutil.strcmp("", A274LiqDFormula)==0) )
               {
                  A1072LiqDLogRecal += GXutil.trim( AV91LiqDLog) ;
                  if ( ! AV20ok )
                  {
                     if ( false )
                     {
                        AV99LiqLog = httpContext.getMessage( "No lo resuelve!", "") ;
                        new web.actualizalogliquidacion(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, AV99LiqLog) ;
                     }
                     if ( AV51dependenciasResueltas )
                     {
                        A270LiqDErrorDesc = httpContext.getMessage( "Error en recálculo: ", "") + GXutil.trim( Gx_msg) ;
                        n270LiqDErrorDesc = false ;
                        AV32errores = GXutil.trim( Gx_msg) + httpContext.getMessage( " (concepto ", "") + GXutil.trim( A394DConCodigo) + httpContext.getMessage( ") &LiqDFormula ", "") + GXutil.trim( AV10LiqDFormula) ;
                        new web.msgdebug7(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "error formula ", "")+AV32errores) ;
                     }
                     else
                     {
                        new web.msgdebug8(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "todavia no estan resueltas las dependencias", "")) ;
                        A270LiqDErrorDesc = httpContext.getMessage( "Error en recálculo: por dependencia no resuelta: ", "") + GXutil.trim( Gx_msg) ;
                        n270LiqDErrorDesc = false ;
                     }
                     if ( AV93loguearFallidos )
                     {
                        AV90dmas2 = (short)(AV52d+2) ;
                        A1072LiqDLogRecal += ". " + GXutil.trim( Gx_msg) + httpContext.getMessage( " (vuelta ", "") + GXutil.trim( GXutil.str( AV90dmas2, 4, 0)) + ") " ;
                     }
                  }
                  else
                  {
                     A764LiqDImpReCalcu = AV16Resultado ;
                  }
               }
               if ( ! (GXutil.strcmp("", AV10LiqDFormula)==0) )
               {
                  A765LiqdFormuRecalc = GXutil.trim( AV10LiqDFormula) ;
                  n765LiqdFormuRecalc = false ;
                  A876LiqDReFormulaHTML = GXutil.trim( AV55LiqDFormulaHTML) ;
                  n876LiqDReFormulaHTML = false ;
               }
            }
            else
            {
               GXv_int6[0] = AV89ConVigencia ;
               new web.getconceptovigencia(remoteHandle, context).execute( AV24CliCod, A394DConCodigo, GXv_int6) ;
               procrecalculo.this.AV89ConVigencia = GXv_int6[0] ;
               if ( ( AV89ConVigencia == 1 ) || new web.esredondeoosobregiro(remoteHandle, context).executeUdp( AV24CliCod, A394DConCodigo) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV51dependenciasResueltas = true ;
                  AV91LiqDLog += httpContext.getMessage( ". Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "") ;
               }
               else
               {
                  AV91LiqDLog += httpContext.getMessage( ". NO Fuerza como resuelto al ser de vigencia automatica &dependenciasResueltas ", "") + GXutil.trim( GXutil.booltostr( AV51dependenciasResueltas)) ;
               }
            }
            if ( AV51dependenciasResueltas )
            {
               if ( false )
               {
                  AV99LiqLog = httpContext.getMessage( "Lo resuelve", "") ;
                  new web.actualizalogliquidacion(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, AV99LiqLog) ;
               }
               A763LiqDRecalculado = (short)(1) ;
               if ( GXutil.strcmp(A394DConCodigo, AV86alcanzaGananciasConCodigo) == 0 )
               {
                  AV82nuevo_AlcanzaGanancias = (short)(DecimalUtil.decToDouble(A764LiqDImpReCalcu)) ;
               }
               if ( ! (GXutil.strcmp("", AV91LiqDLog)==0) )
               {
                  if ( AV93loguearFallidos )
                  {
                     A1072LiqDLogRecal += httpContext.getMessage( " . Recalculo: ", "") + AV91LiqDLog + " ...." ;
                  }
                  else
                  {
                     A1072LiqDLogRecal = httpContext.getMessage( "Recalculo: ", "") + AV91LiqDLog + " .._.." ;
                  }
               }
               else
               {
                  if ( AV93loguearFallidos )
                  {
                     A1072LiqDLogRecal += httpContext.getMessage( " . Recalculo: ", "") + GXutil.trim( A876LiqDReFormulaHTML) + " .-.-.-.-." ;
                  }
                  else
                  {
                     A1072LiqDLogRecal = httpContext.getMessage( "Recalculo: ", "") + GXutil.trim( A876LiqDReFormulaHTML) + " .-.-____-.-." ;
                  }
               }
            }
            else
            {
               if ( false )
               {
                  AV99LiqLog = httpContext.getMessage( "NO Lo resuelve", "") ;
                  new web.actualizalogliquidacion(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, AV99LiqLog) ;
               }
               A763LiqDRecalculado = (short)(0) ;
               AV68cantPendientes = (short)(AV68cantPendientes+1) ;
               AV85pendientesConCodigo.add(GXutil.trim( A394DConCodigo), 0);
            }
            if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL054", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "&d ", "")+GXutil.trim( GXutil.str( AV52d, 4, 0))+httpContext.getMessage( " LiqDRecalculado ", "")+GXutil.trim( GXutil.str( A763LiqDRecalculado, 4, 0))+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV51dependenciasResueltas))+httpContext.getMessage( " LiqDOrdEjec ", "")+GXutil.trim( GXutil.str( A509LiqDOrdEjec, 12, 0))) ;
            }
            /* Using cursor P00SO5 */
            pr_default.execute(3, new Object[] {Short.valueOf(A763LiqDRecalculado), Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1072LiqDLogRecal, Boolean.valueOf(n765LiqdFormuRecalc), A765LiqdFormuRecalc, Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, A764LiqDImpReCalcu, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV107GXLvl49 == 0 )
         {
            AV53seguir = false ;
         }
         AV52d = (short)(AV52d+1) ;
         if ( ( AV68cantPendientes > 0 ) && ( AV68cantPendientes == AV67cantPendientesUltimo ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "LOOPEO &cantPendientes ", "")+GXutil.str( AV68cantPendientes, 4, 0)) ;
            AV53seguir = false ;
            GXt_char2 = AV83LegNomApe ;
            GXv_char16[0] = GXt_char2 ;
            new web.getlegnomape(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV50LegNumero, GXv_char16) ;
            procrecalculo.this.GXt_char2 = GXv_char16[0] ;
            AV83LegNomApe = GXt_char2 ;
            GXt_char2 = AV84LiqDescrip ;
            GXv_char16[0] = GXt_char2 ;
            new web.getliqnombre(remoteHandle, context).execute( AV24CliCod, AV8EmpCod, AV9LiqNro, GXv_char16) ;
            procrecalculo.this.GXt_char2 = GXv_char16[0] ;
            AV84LiqDescrip = GXt_char2 ;
            if ( (GXutil.strcmp("", AV84LiqDescrip)==0) )
            {
               AV84LiqDescrip = GXutil.trim( GXutil.str( AV9LiqNro, 8, 0)) ;
            }
            AV32errores = httpContext.getMessage( "No se pudieron recalcular los conceptos retroactivos para ganancias de liquidación ", "") + GXutil.trim( AV83LegNomApe) + "/" + GXutil.trim( AV84LiqDescrip) + httpContext.getMessage( ". Posible referencia cíclica. Conceptos: ", "") + GXutil.trim( AV85pendientesConCodigo.toJSonString(false)) ;
         }
         AV67cantPendientesUltimo = AV68cantPendientes ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "&viejo_AlcanzaGanancias ", "")+GXutil.trim( GXutil.str( AV81viejo_AlcanzaGanancias, 4, 0))+httpContext.getMessage( " &nuevo_AlcanzaGanancias ", "")+GXutil.trim( GXutil.str( AV82nuevo_AlcanzaGanancias, 4, 0))+httpContext.getMessage( " &yaCreoConceptosGanancias ", "")+GXutil.trim( GXutil.booltostr( AV87yaCreoConceptosGanancias))) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = procrecalculo.this.AV32errores;
      Application.commitDataStores(context, remoteHandle, pr_default, "procrecalculo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32errores = "" ;
      AV92loguearFallidosPalabra = "" ;
      AV34UnoAhora = GXutil.resetTime( GXutil.nullDate() );
      AV105Pgmname = "" ;
      AV86alcanzaGananciasConCodigo = "" ;
      scmdbuf = "" ;
      P00SO2_A3CliCod = new int[1] ;
      P00SO2_A1EmpCod = new short[1] ;
      P00SO2_A31LiqNro = new int[1] ;
      P00SO2_A6LegNumero = new int[1] ;
      P00SO2_A763LiqDRecalculado = new short[1] ;
      P00SO2_A394DConCodigo = new String[] {""} ;
      P00SO2_A765LiqdFormuRecalc = new String[] {""} ;
      P00SO2_n765LiqdFormuRecalc = new boolean[] {false} ;
      P00SO2_A876LiqDReFormulaHTML = new String[] {""} ;
      P00SO2_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P00SO2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SO2_A1072LiqDLogRecal = new String[] {""} ;
      P00SO2_A509LiqDOrdEjec = new long[1] ;
      P00SO2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A765LiqdFormuRecalc = "" ;
      A876LiqDReFormulaHTML = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A1072LiqDLogRecal = "" ;
      AV76pagoACuentaConCodigo = "" ;
      GXt_char1 = "" ;
      AV94saldoProrrateoBonosPalabra = "" ;
      AV99LiqLog = "" ;
      AV85pendientesConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      P00SO4_A3CliCod = new int[1] ;
      P00SO4_A1EmpCod = new short[1] ;
      P00SO4_A31LiqNro = new int[1] ;
      P00SO4_A6LegNumero = new int[1] ;
      P00SO4_A763LiqDRecalculado = new short[1] ;
      P00SO4_A270LiqDErrorDesc = new String[] {""} ;
      P00SO4_n270LiqDErrorDesc = new boolean[] {false} ;
      P00SO4_A394DConCodigo = new String[] {""} ;
      P00SO4_A1072LiqDLogRecal = new String[] {""} ;
      P00SO4_A393DConDescrip = new String[] {""} ;
      P00SO4_A504LiqDForOrig = new String[] {""} ;
      P00SO4_A1122DAplIIGG = new short[1] ;
      P00SO4_n1122DAplIIGG = new boolean[] {false} ;
      P00SO4_A1125LiqDProrr = new String[] {""} ;
      P00SO4_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00SO4_A765LiqdFormuRecalc = new String[] {""} ;
      P00SO4_n765LiqdFormuRecalc = new boolean[] {false} ;
      P00SO4_A876LiqDReFormulaHTML = new String[] {""} ;
      P00SO4_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P00SO4_A400DTLiqCod = new String[] {""} ;
      P00SO4_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SO4_n269LiqDCanti = new boolean[] {false} ;
      P00SO4_A1760DAgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P00SO4_n1760DAgeFecDes = new boolean[] {false} ;
      P00SO4_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SO4_n276LiqDImporte = new boolean[] {false} ;
      P00SO4_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SO4_n277LiqDValUni = new boolean[] {false} ;
      P00SO4_A274LiqDFormula = new String[] {""} ;
      P00SO4_n274LiqDFormula = new boolean[] {false} ;
      P00SO4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SO4_A509LiqDOrdEjec = new long[1] ;
      P00SO4_A81LiqDSecuencial = new int[1] ;
      A270LiqDErrorDesc = "" ;
      A393DConDescrip = "" ;
      A504LiqDForOrig = "" ;
      A1125LiqDProrr = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A400DTLiqCod = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A1760DAgeFecDes = GXutil.nullDate() ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A274LiqDFormula = "" ;
      AV10LiqDFormula = "" ;
      AV41UnoDosAhora = GXutil.resetTime( GXutil.nullDate() );
      AV25ConFormula = "" ;
      AV96altaProrrateoLiqDLog = "" ;
      AV98resolverLiqDLog = "" ;
      AV102altaCuotaIdOperando = "" ;
      AV101tipo_cuota = "" ;
      AV97altaProrrateoError = "" ;
      Gx_msg = "" ;
      AV91LiqDLog = "" ;
      AV33ahora = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean5 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV55LiqDFormulaHTML = "" ;
      GXv_char7 = new String[1] ;
      GXv_char8 = new String[1] ;
      AV16Resultado = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_boolean15 = new boolean[1] ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_boolean18 = new boolean[1] ;
      GXv_int6 = new byte[1] ;
      AV83LegNomApe = "" ;
      AV84LiqDescrip = "" ;
      GXt_char2 = "" ;
      GXv_char16 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procrecalculo__default(),
         new Object[] {
             new Object[] {
            P00SO2_A3CliCod, P00SO2_A1EmpCod, P00SO2_A31LiqNro, P00SO2_A6LegNumero, P00SO2_A763LiqDRecalculado, P00SO2_A394DConCodigo, P00SO2_A765LiqdFormuRecalc, P00SO2_n765LiqdFormuRecalc, P00SO2_A876LiqDReFormulaHTML, P00SO2_n876LiqDReFormulaHTML,
            P00SO2_A764LiqDImpReCalcu, P00SO2_A1072LiqDLogRecal, P00SO2_A509LiqDOrdEjec, P00SO2_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            P00SO4_A3CliCod, P00SO4_A1EmpCod, P00SO4_A31LiqNro, P00SO4_A6LegNumero, P00SO4_A763LiqDRecalculado, P00SO4_A270LiqDErrorDesc, P00SO4_n270LiqDErrorDesc, P00SO4_A394DConCodigo, P00SO4_A1072LiqDLogRecal, P00SO4_A393DConDescrip,
            P00SO4_A504LiqDForOrig, P00SO4_A1122DAplIIGG, P00SO4_n1122DAplIIGG, P00SO4_A1125LiqDProrr, P00SO4_A397DLiqPeriodo, P00SO4_A765LiqdFormuRecalc, P00SO4_n765LiqdFormuRecalc, P00SO4_A876LiqDReFormulaHTML, P00SO4_n876LiqDReFormulaHTML, P00SO4_A400DTLiqCod,
            P00SO4_A269LiqDCanti, P00SO4_n269LiqDCanti, P00SO4_A1760DAgeFecDes, P00SO4_n1760DAgeFecDes, P00SO4_A276LiqDImporte, P00SO4_n276LiqDImporte, P00SO4_A277LiqDValUni, P00SO4_n277LiqDValUni, P00SO4_A274LiqDFormula, P00SO4_n274LiqDFormula,
            P00SO4_A764LiqDImpReCalcu, P00SO4_A509LiqDOrdEjec, P00SO4_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      AV105Pgmname = "ProcRecalculo" ;
      /* GeneXus formulas. */
      AV105Pgmname = "ProcRecalculo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV107GXLvl49 ;
   private byte AV95altaProrraLiqDCalculado ;
   private byte AV89ConVigencia ;
   private byte GXv_int6[] ;
   private short AV8EmpCod ;
   private short AV49i ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV81viejo_AlcanzaGanancias ;
   private short AV52d ;
   private short AV68cantPendientes ;
   private short A1122DAplIIGG ;
   private short AV90dmas2 ;
   private short AV82nuevo_AlcanzaGanancias ;
   private short AV67cantPendientesUltimo ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV9LiqNro ;
   private int AV80ActualLiqNro ;
   private int AV50LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private long A509LiqDOrdEjec ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal AV16Resultado ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private String AV92loguearFallidosPalabra ;
   private String AV105Pgmname ;
   private String AV86alcanzaGananciasConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV76pagoACuentaConCodigo ;
   private String GXt_char1 ;
   private String AV94saldoProrrateoBonosPalabra ;
   private String A1125LiqDProrr ;
   private String A400DTLiqCod ;
   private String AV102altaCuotaIdOperando ;
   private String AV101tipo_cuota ;
   private String Gx_msg ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXt_char2 ;
   private String GXv_char16[] ;
   private java.util.Date AV34UnoAhora ;
   private java.util.Date AV41UnoDosAhora ;
   private java.util.Date AV33ahora ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date A1760DAgeFecDes ;
   private boolean AV93loguearFallidos ;
   private boolean n765LiqdFormuRecalc ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean AV53seguir ;
   private boolean n270LiqDErrorDesc ;
   private boolean n1122DAplIIGG ;
   private boolean n269LiqDCanti ;
   private boolean n1760DAgeFecDes ;
   private boolean n276LiqDImporte ;
   private boolean n277LiqDValUni ;
   private boolean n274LiqDFormula ;
   private boolean AV51dependenciasResueltas ;
   private boolean AV100altaCuotas ;
   private boolean AV20ok ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean18[] ;
   private boolean Cond_result ;
   private boolean AV87yaCreoConceptosGanancias ;
   private String A765LiqdFormuRecalc ;
   private String A876LiqDReFormulaHTML ;
   private String A1072LiqDLogRecal ;
   private String AV99LiqLog ;
   private String A504LiqDForOrig ;
   private String A274LiqDFormula ;
   private String AV10LiqDFormula ;
   private String AV25ConFormula ;
   private String AV96altaProrrateoLiqDLog ;
   private String AV98resolverLiqDLog ;
   private String AV91LiqDLog ;
   private String AV55LiqDFormulaHTML ;
   private String AV32errores ;
   private String A270LiqDErrorDesc ;
   private String A393DConDescrip ;
   private String AV97altaProrrateoError ;
   private String AV83LegNomApe ;
   private String AV84LiqDescrip ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00SO2_A3CliCod ;
   private short[] P00SO2_A1EmpCod ;
   private int[] P00SO2_A31LiqNro ;
   private int[] P00SO2_A6LegNumero ;
   private short[] P00SO2_A763LiqDRecalculado ;
   private String[] P00SO2_A394DConCodigo ;
   private String[] P00SO2_A765LiqdFormuRecalc ;
   private boolean[] P00SO2_n765LiqdFormuRecalc ;
   private String[] P00SO2_A876LiqDReFormulaHTML ;
   private boolean[] P00SO2_n876LiqDReFormulaHTML ;
   private java.math.BigDecimal[] P00SO2_A764LiqDImpReCalcu ;
   private String[] P00SO2_A1072LiqDLogRecal ;
   private long[] P00SO2_A509LiqDOrdEjec ;
   private int[] P00SO2_A81LiqDSecuencial ;
   private int[] P00SO4_A3CliCod ;
   private short[] P00SO4_A1EmpCod ;
   private int[] P00SO4_A31LiqNro ;
   private int[] P00SO4_A6LegNumero ;
   private short[] P00SO4_A763LiqDRecalculado ;
   private String[] P00SO4_A270LiqDErrorDesc ;
   private boolean[] P00SO4_n270LiqDErrorDesc ;
   private String[] P00SO4_A394DConCodigo ;
   private String[] P00SO4_A1072LiqDLogRecal ;
   private String[] P00SO4_A393DConDescrip ;
   private String[] P00SO4_A504LiqDForOrig ;
   private short[] P00SO4_A1122DAplIIGG ;
   private boolean[] P00SO4_n1122DAplIIGG ;
   private String[] P00SO4_A1125LiqDProrr ;
   private java.util.Date[] P00SO4_A397DLiqPeriodo ;
   private String[] P00SO4_A765LiqdFormuRecalc ;
   private boolean[] P00SO4_n765LiqdFormuRecalc ;
   private String[] P00SO4_A876LiqDReFormulaHTML ;
   private boolean[] P00SO4_n876LiqDReFormulaHTML ;
   private String[] P00SO4_A400DTLiqCod ;
   private java.math.BigDecimal[] P00SO4_A269LiqDCanti ;
   private boolean[] P00SO4_n269LiqDCanti ;
   private java.util.Date[] P00SO4_A1760DAgeFecDes ;
   private boolean[] P00SO4_n1760DAgeFecDes ;
   private java.math.BigDecimal[] P00SO4_A276LiqDImporte ;
   private boolean[] P00SO4_n276LiqDImporte ;
   private java.math.BigDecimal[] P00SO4_A277LiqDValUni ;
   private boolean[] P00SO4_n277LiqDValUni ;
   private String[] P00SO4_A274LiqDFormula ;
   private boolean[] P00SO4_n274LiqDFormula ;
   private java.math.BigDecimal[] P00SO4_A764LiqDImpReCalcu ;
   private long[] P00SO4_A509LiqDOrdEjec ;
   private int[] P00SO4_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV85pendientesConCodigo ;
}

final  class procrecalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SO2", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDRecalculado, DConCodigo, LiqdFormuRecalc, LiqDReFormulaHTML, LiqDImpReCalcu, LiqDLogRecal, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDRecalculado = 1 ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDRecalculado, LiqDOrdEjec  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00SO3", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDRecalculado=?, LiqdFormuRecalc=?, LiqDReFormulaHTML=?, LiqDLogRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00SO4", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDRecalculado, LiqDErrorDesc, DConCodigo, LiqDLogRecal, DConDescrip, LiqDForOrig, DAplIIGG, LiqDProrr, DLiqPeriodo, LiqdFormuRecalc, LiqDReFormulaHTML, DTLiqCod, LiqDCanti, DAgeFecDes, LiqDImporte, LiqDValUni, LiqDFormula, LiqDImpReCalcu, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDRecalculado = 0 ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDRecalculado, LiqDOrdEjec  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00SO5", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDRecalculado=?, LiqDErrorDesc=?, LiqDLogRecal=?, LiqdFormuRecalc=?, LiqDReFormulaHTML=?, LiqDImpReCalcu=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(10);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(13);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(16, 20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(17,2);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[30])[0] = rslt.getBigDecimal(22,2);
               ((long[]) buf[31])[0] = rslt.getLong(23);
               ((int[]) buf[32])[0] = rslt.getInt(24);
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(2, (String)parms[2]);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[4]);
               }
               stmt.setNLongVarchar(4, (String)parms[5], false);
               stmt.setInt(5, ((Number) parms[6]).intValue());
               stmt.setShort(6, ((Number) parms[7]).shortValue());
               stmt.setInt(7, ((Number) parms[8]).intValue());
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setInt(9, ((Number) parms[10]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 400);
               }
               stmt.setNLongVarchar(3, (String)parms[3], false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[7]);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[8], 2);
               stmt.setInt(7, ((Number) parms[9]).intValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setInt(11, ((Number) parms[13]).intValue());
               return;
      }
   }

}

