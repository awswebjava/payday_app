package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliquidacionsimple extends GXProcedure
{
   public procliquidacionsimple( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliquidacionsimple.class ), "" );
   }

   public procliquidacionsimple( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             java.math.BigDecimal aP15 ,
                             java.math.BigDecimal aP16 ,
                             byte aP17 ,
                             boolean[] aP18 ,
                             boolean[] aP19 )
   {
      procliquidacionsimple.this.aP20 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
      return aP20[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        int aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        java.math.BigDecimal aP15 ,
                        java.math.BigDecimal aP16 ,
                        byte aP17 ,
                        boolean[] aP18 ,
                        boolean[] aP19 ,
                        String[] aP20 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             java.math.BigDecimal aP15 ,
                             java.math.BigDecimal aP16 ,
                             byte aP17 ,
                             boolean[] aP18 ,
                             boolean[] aP19 ,
                             String[] aP20 )
   {
      procliquidacionsimple.this.AV36CliCod = aP0;
      procliquidacionsimple.this.AV10EmpCod = aP1;
      procliquidacionsimple.this.AV87LiqNro = aP2;
      procliquidacionsimple.this.AV175LiqRelNro = aP3;
      procliquidacionsimple.this.AV88LiqPeriodo = aP4;
      procliquidacionsimple.this.AV131TLiqCod = aP5;
      procliquidacionsimple.this.AV107parmLegNumero = aP6;
      procliquidacionsimple.this.AV80LiqDLote = aP7;
      procliquidacionsimple.this.AV111programa = aP8;
      procliquidacionsimple.this.AV132todosInsertados = aP9;
      procliquidacionsimple.this.AV9ConveCodigo = aP10;
      procliquidacionsimple.this.AV178redondeoHay = aP11;
      procliquidacionsimple.this.AV183remuTipoConCod = aP12;
      procliquidacionsimple.this.AV184noRemuTipoConCod = aP13;
      procliquidacionsimple.this.AV185descuTipoConCod = aP14;
      procliquidacionsimple.this.AV188base_imp_min = aP15;
      procliquidacionsimple.this.AV189base_imp_max = aP16;
      procliquidacionsimple.this.AV187cantDiasMes = aP17;
      procliquidacionsimple.this.aP18 = aP18;
      procliquidacionsimple.this.aP19 = aP19;
      procliquidacionsimple.this.aP20 = aP20;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV74LegNumero = AV107parmLegNumero ;
      GXv_int1[0] = AV152EmpTipoExp ;
      new web.getemptipoexp(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, GXv_int1) ;
      procliquidacionsimple.this.AV152EmpTipoExp = GXv_int1[0] ;
      GXv_int1[0] = AV170LegClase ;
      GXv_char2[0] = AV192LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, AV74LegNumero, GXv_int1, GXv_char2) ;
      procliquidacionsimple.this.AV170LegClase = GXv_int1[0] ;
      procliquidacionsimple.this.AV192LegModTra = GXv_char2[0] ;
      GXt_char3 = AV151sueldoConCodigo ;
      GXt_char4 = AV151sueldoConCodigo ;
      GXv_char2[0] = GXt_char4 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      procliquidacionsimple.this.GXt_char4 = GXv_char2[0] ;
      GXv_char5[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV36CliCod, GXt_char4, GXv_char5) ;
      procliquidacionsimple.this.GXt_char3 = GXv_char5[0] ;
      AV151sueldoConCodigo = GXt_char3 ;
      GXt_char4 = AV92loguearFallidosPalabra ;
      GXt_char3 = AV92loguearFallidosPalabra ;
      GXv_char5[0] = GXt_char3 ;
      new web.logfallidos_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      procliquidacionsimple.this.GXt_char3 = GXv_char5[0] ;
      GXv_char2[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV36CliCod, GXt_char3, GXv_char2) ;
      procliquidacionsimple.this.GXt_char4 = GXv_char2[0] ;
      AV92loguearFallidosPalabra = GXt_char4 ;
      AV91loguearFallidos = GXutil.boolval( AV92loguearFallidosPalabra) ;
      GXv_char5[0] = AV177redondeoConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV36CliCod, new web.concepto_redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
      procliquidacionsimple.this.AV177redondeoConCodigo = GXv_char5[0] ;
      AV162desdeTipoConCod = AV184noRemuTipoConCod ;
      AV163hastaTipoConCod = AV183remuTipoConCod ;
      AV164LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV181LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV182LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV165LiqLegCntRemu = (byte)(0) ;
      AV166LiqLegCntTra = (byte)(0) ;
      /* Execute user subroutine: 'SUMAR PRECALCULADOS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV49d = (short)(0) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "ini &d ", "")+GXutil.trim( GXutil.str( AV49d, 4, 0))) ;
      /* Execute user subroutine: 'CALCULAR CONCEPTOS' */
      S121 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV162desdeTipoConCod = AV185descuTipoConCod ;
      AV163hastaTipoConCod = AV185descuTipoConCod ;
      AV171d2 = (short)(0) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "va a calculaar los descuentos", "")) ;
      /* Execute user subroutine: 'CALCULAR CONCEPTOS' */
      S121 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "&redondeoHay ", "")+GXutil.trim( GXutil.booltostr( AV178redondeoHay))) ;
      if ( AV178redondeoHay )
      {
         AV179calcularRedondeo = true ;
         AV162desdeTipoConCod = AV184noRemuTipoConCod ;
         AV163hastaTipoConCod = AV184noRemuTipoConCod ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "va a calcular redodneo ", "")+GXutil.trim( GXutil.str( AV49d, 4, 0))) ;
         /* Execute user subroutine: 'CALCULAR CONCEPTOS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ! AV156procesoAlgo )
      {
         AV149errorComunHay = true ;
      }
      if ( ( AV34ciclicoErrorHay ) || ( AV149errorComunHay ) )
      {
         GXv_boolean6[0] = true ;
         new web.setearerrornocalculado(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, AV87LiqNro, AV107parmLegNumero, AV34ciclicoErrorHay, GXv_boolean6) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "terminó", "")) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'SUMAR PRECALCULADOS' Routine */
      returnInSub = false ;
      /* Optimized group. */
      /* Using cursor P01RX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV87LiqNro), Integer.valueOf(AV74LegNumero), AV184noRemuTipoConCod, AV177redondeoConCodigo, Boolean.valueOf(AV179calcularRedondeo)});
      c275LiqDImpCalcu = P01RX2_A275LiqDImpCalcu[0] ;
      n275LiqDImpCalcu = P01RX2_n275LiqDImpCalcu[0] ;
      pr_default.close(0);
      AV181LiqLegImpTotNoRemu = AV181LiqLegImpTotNoRemu.add(c275LiqDImpCalcu) ;
      /* End optimized group. */
      /* Optimized group. */
      /* Using cursor P01RX3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV87LiqNro), Integer.valueOf(AV74LegNumero), AV183remuTipoConCod});
      c275LiqDImpCalcu = P01RX3_A275LiqDImpCalcu[0] ;
      n275LiqDImpCalcu = P01RX3_n275LiqDImpCalcu[0] ;
      cV165LiqLegCntRemu = P01RX3_AV165LiqLegCntRemu[0] ;
      pr_default.close(1);
      AV164LiqLegImpTotRemu = AV164LiqLegImpTotRemu.add(c275LiqDImpCalcu) ;
      AV165LiqLegCntRemu = (byte)(AV165LiqLegCntRemu+cV165LiqLegCntRemu*1) ;
      /* End optimized group. */
   }

   public void S121( )
   {
      /* 'CALCULAR CONCEPTOS' Routine */
      returnInSub = false ;
      AV120seguir = true ;
      while ( AV120seguir )
      {
         AV31cantPendientes = (short)(0) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "legnumerop ", "")+GXutil.trim( GXutil.str( AV74LegNumero, 8, 0))+httpContext.getMessage( " ini vuelta ", "")+GXutil.trim( GXutil.str( AV49d, 4, 0))+httpContext.getMessage( " seguir ", "")+GXutil.trim( GXutil.booltostr( AV120seguir))+httpContext.getMessage( " primer legajo ", "")+GXutil.trim( GXutil.booltostr( AV109primerLegajo))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "&redondeoConCodigo ", "")+AV177redondeoConCodigo+httpContext.getMessage( " &calcularRedondeo ", "")+GXutil.trim( GXutil.booltostr( AV179calcularRedondeo))+httpContext.getMessage( " &desdeTipoConCod", "")+GXutil.trim( AV162desdeTipoConCod)+httpContext.getMessage( " &hastaTipoConCod ", "")+GXutil.trim( AV163hastaTipoConCod)) ;
         AV129tienePendientes = false ;
         AV198GXLvl109 = (byte)(0) ;
         /* Using cursor P01RX4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV87LiqNro), Integer.valueOf(AV74LegNumero), AV162desdeTipoConCod, AV177redondeoConCodigo, Boolean.valueOf(AV179calcularRedondeo), AV163hastaTipoConCod});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A394DConCodigo = P01RX4_A394DConCodigo[0] ;
            A464DTipoConCod = P01RX4_A464DTipoConCod[0] ;
            A507LiqDCalculado = P01RX4_A507LiqDCalculado[0] ;
            A6LegNumero = P01RX4_A6LegNumero[0] ;
            A31LiqNro = P01RX4_A31LiqNro[0] ;
            A1EmpCod = P01RX4_A1EmpCod[0] ;
            A3CliCod = P01RX4_A3CliCod[0] ;
            A1070LiqDLog = P01RX4_A1070LiqDLog[0] ;
            A1072LiqDLogRecal = P01RX4_A1072LiqDLogRecal[0] ;
            A274LiqDFormula = P01RX4_A274LiqDFormula[0] ;
            n274LiqDFormula = P01RX4_n274LiqDFormula[0] ;
            A508LiqDFormulaHTML = P01RX4_A508LiqDFormulaHTML[0] ;
            n508LiqDFormulaHTML = P01RX4_n508LiqDFormulaHTML[0] ;
            A400DTLiqCod = P01RX4_A400DTLiqCod[0] ;
            A397DLiqPeriodo = P01RX4_A397DLiqPeriodo[0] ;
            A269LiqDCanti = P01RX4_A269LiqDCanti[0] ;
            n269LiqDCanti = P01RX4_n269LiqDCanti[0] ;
            A1760DAgeFecDes = P01RX4_A1760DAgeFecDes[0] ;
            n1760DAgeFecDes = P01RX4_n1760DAgeFecDes[0] ;
            A276LiqDImporte = P01RX4_A276LiqDImporte[0] ;
            n276LiqDImporte = P01RX4_n276LiqDImporte[0] ;
            A277LiqDValUni = P01RX4_A277LiqDValUni[0] ;
            n277LiqDValUni = P01RX4_n277LiqDValUni[0] ;
            A270LiqDErrorDesc = P01RX4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P01RX4_n270LiqDErrorDesc[0] ;
            A1219LiqDPlus = P01RX4_A1219LiqDPlus[0] ;
            A275LiqDImpCalcu = P01RX4_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P01RX4_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P01RX4_A764LiqDImpReCalcu[0] ;
            A502LiqDMostrar = P01RX4_A502LiqDMostrar[0] ;
            A876LiqDReFormulaHTML = P01RX4_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = P01RX4_n876LiqDReFormulaHTML[0] ;
            A749LiqDFormuAux = P01RX4_A749LiqDFormuAux[0] ;
            n749LiqDFormuAux = P01RX4_n749LiqDFormuAux[0] ;
            A968LiqDUniMed = P01RX4_A968LiqDUniMed[0] ;
            A504LiqDForOrig = P01RX4_A504LiqDForOrig[0] ;
            A1487DConCondicion = P01RX4_A1487DConCondicion[0] ;
            A468DSubTipoConCod1 = P01RX4_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P01RX4_n468DSubTipoConCod1[0] ;
            A393DConDescrip = P01RX4_A393DConDescrip[0] ;
            A918LiqDVueltaRes = P01RX4_A918LiqDVueltaRes[0] ;
            A1469LiqDSeg = P01RX4_A1469LiqDSeg[0] ;
            A509LiqDOrdEjec = P01RX4_A509LiqDOrdEjec[0] ;
            A81LiqDSecuencial = P01RX4_A81LiqDSecuencial[0] ;
            AV198GXLvl109 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( "&concred ", "")+GXutil.trim( AV177redondeoConCodigo)+httpContext.getMessage( " calc ", "")+GXutil.trim( GXutil.booltostr( AV179calcularRedondeo))) ;
            GXt_dtime7 = AV38comienzo ;
            GXv_dtime8[0] = GXt_dtime7 ;
            new web.getahora(remoteHandle, context).execute( AV36CliCod, GXv_dtime8) ;
            procliquidacionsimple.this.GXt_dtime7 = GXv_dtime8[0] ;
            AV38comienzo = GXt_dtime7 ;
            AV156procesoAlgo = true ;
            AV129tienePendientes = true ;
            AV76LiqDFormula = "" ;
            AV148calculoCero = false ;
            AV8ConCodigo = A394DConCodigo ;
            AV115Resultado = DecimalUtil.ZERO ;
            AV25baseImportes = DecimalUtil.ZERO ;
            AV30cantidadCalculada = DecimalUtil.ZERO ;
            if ( ! AV91loguearFallidos )
            {
               A1070LiqDLog = "" ;
               A1072LiqDLogRecal = "" ;
            }
            AV45ConOpeEsCant = DecimalUtil.doubleToDec(0) ;
            GXt_dtime7 = AV137UnoDosAhora ;
            GXv_dtime8[0] = GXt_dtime7 ;
            new web.getahora(remoteHandle, context).execute( AV36CliCod, GXv_dtime8) ;
            procliquidacionsimple.this.GXt_dtime7 = GXv_dtime8[0] ;
            AV137UnoDosAhora = GXt_dtime7 ;
            GXv_char5[0] = AV43ConFormula ;
            GXv_int1[0] = AV47ConVigencia ;
            GXv_boolean6[0] = AV44ConMostrarPos ;
            GXv_boolean9[0] = AV154ConErrorSiCero ;
            new web.getdatosconcepto5(remoteHandle, context).execute( AV36CliCod, AV8ConCodigo, GXv_char5, GXv_int1, GXv_boolean6, GXv_boolean9) ;
            procliquidacionsimple.this.AV43ConFormula = GXv_char5[0] ;
            procliquidacionsimple.this.AV47ConVigencia = GXv_int1[0] ;
            procliquidacionsimple.this.AV44ConMostrarPos = GXv_boolean6[0] ;
            procliquidacionsimple.this.AV154ConErrorSiCero = GXv_boolean9[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "&ConFormula ", "")+AV43ConFormula) ;
            if ( ! (GXutil.strcmp("", AV43ConFormula)==0) )
            {
               GXv_char5[0] = AV158idOperando ;
               GXv_char2[0] = AV157primeraPalabra ;
               GXv_boolean9[0] = AV173resolverDeUna ;
               new web.formulaaidcalculo(remoteHandle, context).execute( AV36CliCod, AV43ConFormula, GXv_char5, GXv_char2, GXv_boolean9) ;
               procliquidacionsimple.this.AV158idOperando = GXv_char5[0] ;
               procliquidacionsimple.this.AV157primeraPalabra = GXv_char2[0] ;
               procliquidacionsimple.this.AV173resolverDeUna = GXv_boolean9[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "idoperando ", "")+GXutil.trim( AV158idOperando)+httpContext.getMessage( " resolverdeuna ", "")+GXutil.trim( GXutil.booltostr( AV173resolverDeUna))) ;
               if ( ! AV173resolverDeUna )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "llama a resolver formula LiqDFormula ", "")+GXutil.trim( A274LiqDFormula)) ;
                  GXv_boolean9[0] = AV103ok ;
                  GXv_char5[0] = Gx_msg ;
                  GXv_char2[0] = AV76LiqDFormula ;
                  GXv_char10[0] = AV77LiqDFormulaHTML ;
                  GXv_char11[0] = "" ;
                  GXv_decimal12[0] = AV115Resultado ;
                  GXv_boolean6[0] = AV52dependenciasResueltas ;
                  GXv_decimal13[0] = AV45ConOpeEsCant ;
                  GXv_boolean14[0] = AV16alicuotaEs ;
                  GXv_decimal15[0] = AV30cantidadCalculada ;
                  GXv_decimal16[0] = AV25baseImportes ;
                  GXv_boolean17[0] = false ;
                  GXv_char18[0] = AV113resolverLiqDLog ;
                  GXv_decimal19[0] = AV82LiqDPlus ;
                  GXv_boolean20[0] = AV153dependenciaConceptoEs ;
                  new web.resolverformula(remoteHandle, context).execute( A3CliCod, A394DConCodigo, A274LiqDFormula, A508LiqDFormulaHTML, AV10EmpCod, AV87LiqNro, AV175LiqRelNro, AV87LiqNro, A6LegNumero, A400DTLiqCod, A397DLiqPeriodo, AV195Pgmname, "Calculo", false, A269LiqDCanti, A1760DAgeFecDes, A276LiqDImporte, A277LiqDValUni, GXv_boolean9, GXv_char5, GXv_char2, GXv_char10, GXv_char11, GXv_decimal12, GXv_boolean6, GXv_decimal13, GXv_boolean14, GXv_decimal15, GXv_decimal16, GXv_boolean17, GXv_char18, GXv_decimal19, GXv_boolean20) ;
                  procliquidacionsimple.this.AV103ok = GXv_boolean9[0] ;
                  procliquidacionsimple.this.Gx_msg = GXv_char5[0] ;
                  procliquidacionsimple.this.AV76LiqDFormula = GXv_char2[0] ;
                  procliquidacionsimple.this.AV77LiqDFormulaHTML = GXv_char10[0] ;
                  procliquidacionsimple.this.AV115Resultado = GXv_decimal12[0] ;
                  procliquidacionsimple.this.AV52dependenciasResueltas = GXv_boolean6[0] ;
                  procliquidacionsimple.this.AV45ConOpeEsCant = GXv_decimal13[0] ;
                  procliquidacionsimple.this.AV16alicuotaEs = GXv_boolean14[0] ;
                  procliquidacionsimple.this.AV30cantidadCalculada = GXv_decimal15[0] ;
                  procliquidacionsimple.this.AV25baseImportes = GXv_decimal16[0] ;
                  procliquidacionsimple.this.AV113resolverLiqDLog = GXv_char18[0] ;
                  procliquidacionsimple.this.AV82LiqDPlus = GXv_decimal19[0] ;
                  procliquidacionsimple.this.AV153dependenciaConceptoEs = GXv_boolean20[0] ;
               }
               else
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "resuelve de una", "")) ;
                  AV119SDTOperandosItem = (web.SdtSDTOperandosFormula)new web.SdtSDTOperandosFormula(remoteHandle, context);
                  AV119SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandooriginal( GXutil.trim( AV43ConFormula) );
                  if ( ( GXutil.strcmp(AV162desdeTipoConCod, AV185descuTipoConCod) == 0 ) && ( ( GXutil.strcmp(AV158idOperando, "[jubilacion]") == 0 ) || ( GXutil.strcmp(AV158idOperando, "[obra_social]") == 0 ) || ( GXutil.strcmp(AV158idOperando, "[ley_19032]") == 0 ) || ( GXutil.strcmp(AV158idOperando, "[cuota_sindical]") == 0 ) ) )
                  {
                     GXv_char18[0] = AV167baseConCodigo ;
                     GXv_char11[0] = AV168auxOpeCliId ;
                     GXv_boolean20[0] = AV169cuotaSindicalEs ;
                     new web.getdesculeydatos(remoteHandle, context).execute( AV36CliCod, AV158idOperando, GXv_char18, GXv_char11, GXv_boolean20) ;
                     procliquidacionsimple.this.AV167baseConCodigo = GXv_char18[0] ;
                     procliquidacionsimple.this.AV168auxOpeCliId = GXv_char11[0] ;
                     procliquidacionsimple.this.AV169cuotaSindicalEs = GXv_boolean20[0] ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "le manda &LiqLegCntTra ", "")+GXutil.trim( GXutil.str( AV166LiqLegCntTra, 2, 0))) ;
                     GXv_decimal19[0] = AV115Resultado ;
                     GXv_decimal16[0] = AV25baseImportes ;
                     GXv_char18[0] = Gx_msg ;
                     GXv_char11[0] = AV113resolverLiqDLog ;
                     GXv_int1[0] = (byte)((byte)((AV52dependenciasResueltas)?1:0)) ;
                     GXv_decimal15[0] = AV30cantidadCalculada ;
                     new web.descuento_de_ley(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, AV87LiqNro, AV74LegNumero, AV170LegClase, AV192LegModTra, "", A394DConCodigo, AV88LiqPeriodo, AV110ProcesoLiquidacion, false, AV167baseConCodigo, AV168auxOpeCliId, AV169cuotaSindicalEs, AV164LiqLegImpTotRemu, AV165LiqLegCntRemu, AV166LiqLegCntTra, AV189base_imp_max, AV188base_imp_min, AV187cantDiasMes, GXv_decimal19, GXv_decimal16, GXv_char18, GXv_char11, GXv_int1, GXv_decimal15) ;
                     procliquidacionsimple.this.AV115Resultado = GXv_decimal19[0] ;
                     procliquidacionsimple.this.AV25baseImportes = GXv_decimal16[0] ;
                     procliquidacionsimple.this.Gx_msg = GXv_char18[0] ;
                     procliquidacionsimple.this.AV113resolverLiqDLog = GXv_char11[0] ;
                     procliquidacionsimple.this.AV52dependenciasResueltas = (boolean)((GXv_int1[0]==0)?false:true) ;
                     procliquidacionsimple.this.AV30cantidadCalculada = GXv_decimal15[0] ;
                     AV119SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV115Resultado, 14, 2)) );
                  }
                  else
                  {
                     if ( AV179calcularRedondeo )
                     {
                        AV180netoImportes = AV164LiqLegImpTotRemu ;
                        AV180netoImportes = AV180netoImportes.add(AV181LiqLegImpTotNoRemu) ;
                        AV180netoImportes = AV180netoImportes.subtract(AV182LiqLegImpTotDescu) ;
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "!&netoImportes ", "")+GXutil.trim( GXutil.str( AV180netoImportes, 14, 2))+httpContext.getMessage( " &LiqLegImpTotRemu ", "")+GXutil.trim( GXutil.str( AV164LiqLegImpTotRemu, 14, 2))+httpContext.getMessage( " &LiqLegImpTotNoRemu ", "")+GXutil.trim( GXutil.str( AV181LiqLegImpTotNoRemu, 14, 2))+httpContext.getMessage( " &LiqLegImpTotDescu ", "")+GXutil.trim( GXutil.str( AV182LiqLegImpTotDescu, 14, 2))) ;
                        GXv_decimal19[0] = AV115Resultado ;
                        GXv_char18[0] = Gx_msg ;
                        GXv_char11[0] = AV113resolverLiqDLog ;
                        GXv_int1[0] = (byte)((byte)((AV52dependenciasResueltas)?1:0)) ;
                        new web.redondeo(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, AV87LiqNro, AV74LegNumero, A394DConCodigo, AV110ProcesoLiquidacion, AV180netoImportes, GXv_decimal19, GXv_char18, GXv_char11, GXv_int1) ;
                        procliquidacionsimple.this.AV115Resultado = GXv_decimal19[0] ;
                        procliquidacionsimple.this.Gx_msg = GXv_char18[0] ;
                        procliquidacionsimple.this.AV113resolverLiqDLog = GXv_char11[0] ;
                        procliquidacionsimple.this.AV52dependenciasResueltas = (boolean)((GXv_int1[0]==0)?false:true) ;
                        AV119SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV115Resultado, 14, 2)) );
                     }
                     else
                     {
                        GXv_SdtSDTOperandosFormula21[0] = AV119SDTOperandosItem;
                        GXv_boolean20[0] = AV52dependenciasResueltas ;
                        GXv_char18[0] = Gx_msg ;
                        GXv_decimal19[0] = AV45ConOpeEsCant ;
                        GXv_boolean17[0] = AV16alicuotaEs ;
                        GXv_decimal16[0] = AV30cantidadCalculada ;
                        GXv_decimal15[0] = AV25baseImportes ;
                        GXv_boolean14[0] = false ;
                        GXv_char11[0] = AV113resolverLiqDLog ;
                        GXv_decimal13[0] = AV82LiqDPlus ;
                        GXv_boolean9[0] = AV153dependenciaConceptoEs ;
                        new web.resuelveoperando(remoteHandle, context).execute( AV36CliCod, AV10EmpCod, AV87LiqNro, AV175LiqRelNro, AV74LegNumero, AV131TLiqCod, AV87LiqNro, AV8ConCodigo, AV159Operando, AV157primeraPalabra, AV110ProcesoLiquidacion, AV195Pgmname, false, false, GXv_SdtSDTOperandosFormula21, AV88LiqPeriodo, AV88LiqPeriodo, A269LiqDCanti, A1760DAgeFecDes, GXv_boolean20, GXv_char18, GXv_decimal19, GXv_boolean17, GXv_decimal16, GXv_decimal15, GXv_boolean14, GXv_char11, GXv_decimal13, GXv_boolean9) ;
                        AV119SDTOperandosItem = GXv_SdtSDTOperandosFormula21[0] ;
                        procliquidacionsimple.this.AV52dependenciasResueltas = GXv_boolean20[0] ;
                        procliquidacionsimple.this.Gx_msg = GXv_char18[0] ;
                        procliquidacionsimple.this.AV45ConOpeEsCant = GXv_decimal19[0] ;
                        procliquidacionsimple.this.AV16alicuotaEs = GXv_boolean17[0] ;
                        procliquidacionsimple.this.AV30cantidadCalculada = GXv_decimal16[0] ;
                        procliquidacionsimple.this.AV25baseImportes = GXv_decimal15[0] ;
                        procliquidacionsimple.this.AV113resolverLiqDLog = GXv_char11[0] ;
                        procliquidacionsimple.this.AV82LiqDPlus = GXv_decimal13[0] ;
                        procliquidacionsimple.this.AV153dependenciaConceptoEs = GXv_boolean9[0] ;
                        AV115Resultado = CommonUtil.decimalVal( AV119SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandocambiado(), ".") ;
                     }
                  }
                  if ( (GXutil.strcmp("", Gx_msg)==0) && ( AV52dependenciasResueltas ) )
                  {
                     AV103ok = true ;
                  }
                  else
                  {
                     AV103ok = false ;
                  }
                  AV76LiqDFormula = GXutil.trim( AV43ConFormula) ;
                  AV77LiqDFormulaHTML = GXutil.trim( AV43ConFormula) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "antes &LiqDFormula ", "")+GXutil.trim( AV76LiqDFormula)) ;
                  AV118SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle) ;
                  AV118SDTOperandos.add(AV119SDTOperandosItem, 0);
                  GXv_char18[0] = AV76LiqDFormula ;
                  GXv_char11[0] = "" ;
                  GXv_char10[0] = AV77LiqDFormulaHTML ;
                  GXv_objcol_SdtSDTOperandosFormula22[0] = AV118SDTOperandos ;
                  GXv_boolean20[0] = false ;
                  GXv_char5[0] = "" ;
                  new web.formulareemplazarvalores(remoteHandle, context).execute( AV87LiqNro, GXv_char18, GXv_char11, GXv_char10, GXv_objcol_SdtSDTOperandosFormula22, GXv_boolean20, GXv_char5) ;
                  procliquidacionsimple.this.AV76LiqDFormula = GXv_char18[0] ;
                  procliquidacionsimple.this.AV77LiqDFormulaHTML = GXv_char10[0] ;
                  AV118SDTOperandos = GXv_objcol_SdtSDTOperandosFormula22[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "despues &LiqDFormula ", "")+GXutil.trim( AV76LiqDFormula)+httpContext.getMessage( " &LiqDFormulaHTML ", "")+AV77LiqDFormulaHTML) ;
               }
               AV79LiqDLog = AV113resolverLiqDLog ;
               if ( ! (GXutil.strcmp("", A274LiqDFormula)==0) )
               {
                  A1070LiqDLog += GXutil.trim( AV79LiqDLog) ;
                  A1072LiqDLogRecal += GXutil.trim( AV79LiqDLog) ;
                  if ( ! AV103ok )
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "NOT ok &msg ", "")+Gx_msg) ;
                     GXv_char18[0] = Gx_msg ;
                     GXv_char11[0] = AV190principalError ;
                     new web.parsearerrorprincipal(remoteHandle, context).execute( GXv_char18, GXv_char11) ;
                     procliquidacionsimple.this.Gx_msg = GXv_char18[0] ;
                     procliquidacionsimple.this.AV190principalError = GXv_char11[0] ;
                     A270LiqDErrorDesc = Gx_msg ;
                     n270LiqDErrorDesc = false ;
                     if ( AV52dependenciasResueltas )
                     {
                        AV52dependenciasResueltas = false ;
                     }
                     else
                     {
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "todavia no estan resueltas las dependencias", "")) ;
                     }
                  }
                  else
                  {
                     A1219LiqDPlus = AV82LiqDPlus ;
                     A275LiqDImpCalcu = GXutil.roundDecimal( AV115Resultado, 2) ;
                     n275LiqDImpCalcu = false ;
                     A764LiqDImpReCalcu = GXutil.roundDecimal( AV115Resultado, 2) ;
                     GXv_char18[0] = AV191LiqDErrorDesc ;
                     GXv_boolean20[0] = AV148calculoCero ;
                     GXv_boolean17[0] = AV149errorComunHay ;
                     GXv_int1[0] = AV81LiqDMostrar ;
                     new web.logicaerrorymostrarsicero(remoteHandle, context).execute( A275LiqDImpCalcu, AV44ConMostrarPos, AV154ConErrorSiCero, A394DConCodigo, AV151sueldoConCodigo, AV152EmpTipoExp, AV30cantidadCalculada, GXv_char18, GXv_boolean20, GXv_boolean17, GXv_int1) ;
                     procliquidacionsimple.this.AV191LiqDErrorDesc = GXv_char18[0] ;
                     procliquidacionsimple.this.AV148calculoCero = GXv_boolean20[0] ;
                     procliquidacionsimple.this.AV149errorComunHay = GXv_boolean17[0] ;
                     procliquidacionsimple.this.AV81LiqDMostrar = GXv_int1[0] ;
                     if ( ! (GXutil.strcmp("", AV191LiqDErrorDesc)==0) )
                     {
                        A270LiqDErrorDesc = GXutil.trim( AV191LiqDErrorDesc) ;
                        n270LiqDErrorDesc = false ;
                     }
                     A502LiqDMostrar = AV81LiqDMostrar ;
                     new web.msgdebug(remoteHandle, context).execute( AV195Pgmname, httpContext.getMessage( "ASIGNA ", "")+GXutil.trim( GXutil.str( AV115Resultado, 14, 2))+httpContext.getMessage( " a ", "")+GXutil.trim( A394DConCodigo)) ;
                  }
               }
               else
               {
                  A270LiqDErrorDesc = httpContext.getMessage( "Error: Formula vacia", "") ;
                  n270LiqDErrorDesc = false ;
                  AV60errores = httpContext.getMessage( "Error: Formula vacia", "") ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "mas despues &LiqDFormula ", "")+AV76LiqDFormula) ;
               if ( ! (GXutil.strcmp("", AV76LiqDFormula)==0) )
               {
                  A274LiqDFormula = GXutil.trim( AV76LiqDFormula) ;
                  n274LiqDFormula = false ;
                  A508LiqDFormulaHTML = GXutil.trim( AV77LiqDFormulaHTML) ;
                  n508LiqDFormulaHTML = false ;
                  A876LiqDReFormulaHTML = GXutil.trim( AV77LiqDFormulaHTML) ;
                  n876LiqDReFormulaHTML = false ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "actualiza co &LiqDFormulaHTML ", "")+AV77LiqDFormulaHTML) ;
                  A749LiqDFormuAux = GXutil.trim( AV76LiqDFormula) ;
                  n749LiqDFormuAux = false ;
               }
            }
            else
            {
               if ( ( AV47ConVigencia == 1 ) || new web.esredondeoosobregiro(remoteHandle, context).executeUdp( AV36CliCod, A394DConCodigo) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV52dependenciasResueltas = true ;
                  AV79LiqDLog += httpContext.getMessage( ". Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "") ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "")) ;
               }
            }
            if ( AV52dependenciasResueltas )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " &alicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV16alicuotaEs))) ;
               if ( AV16alicuotaEs )
               {
                  A968LiqDUniMed = "%" ;
               }
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV45ConOpeEsCant, 14, 2))) ;
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45ConOpeEsCant)==0) )
                  {
                     A269LiqDCanti = AV45ConOpeEsCant ;
                     n269LiqDCanti = false ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "le one ", "")+GXutil.trim( GXutil.str( AV45ConOpeEsCant, 14, 2))) ;
                  }
                  else
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "&cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV30cantidadCalculada, 14, 2))) ;
                     if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30cantidadCalculada)==0) )
                     {
                        A269LiqDCanti = AV30cantidadCalculada ;
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
                  if ( AV47ConVigencia == 1 )
                  {
                     GXv_decimal19[0] = A275LiqDImpCalcu ;
                     GXv_decimal16[0] = A764LiqDImpReCalcu ;
                     GXv_boolean20[0] = false ;
                     GXv_char18[0] = AV71impliLiqDLog ;
                     new web.calculomultiporcantimplicito(remoteHandle, context).execute( AV36CliCod, A504LiqDForOrig, AV47ConVigencia, A269LiqDCanti, AV11LiqDImporte, GXv_decimal19, GXv_decimal16, GXv_boolean20, GXv_char18) ;
                     procliquidacionsimple.this.A275LiqDImpCalcu = GXv_decimal19[0] ;
                     n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
                     procliquidacionsimple.this.A764LiqDImpReCalcu = GXv_decimal16[0] ;
                     procliquidacionsimple.this.AV71impliLiqDLog = GXv_char18[0] ;
                  }
               }
               A507LiqDCalculado = (byte)(1) ;
               if ( GXutil.strcmp(A464DTipoConCod, AV183remuTipoConCod) == 0 )
               {
                  AV164LiqLegImpTotRemu = AV164LiqLegImpTotRemu.add(A275LiqDImpCalcu) ;
                  AV165LiqLegCntRemu = (byte)(AV165LiqLegCntRemu+1) ;
                  if ( A275LiqDImpCalcu.doubleValue() > 0 )
                  {
                     AV166LiqLegCntTra = (byte)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV166LiqLegCntTra).add(A269LiqDCanti))) ;
                  }
                  else
                  {
                     GXv_boolean20[0] = AV186restar ;
                     new web.restardiaseguncondicionytipo(remoteHandle, context).execute( A1487DConCondicion, A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean20) ;
                     procliquidacionsimple.this.AV186restar = GXv_boolean20[0] ;
                     if ( AV186restar )
                     {
                        AV166LiqLegCntTra = (byte)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV166LiqLegCntTra).subtract(A269LiqDCanti))) ;
                     }
                  }
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "suma LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " de ", "")+GXutil.trim( A393DConDescrip)+httpContext.getMessage( ", queda ", "")+GXutil.trim( GXutil.str( AV166LiqLegCntTra, 2, 0))) ;
               }
               else
               {
                  if ( GXutil.strcmp(A464DTipoConCod, AV184noRemuTipoConCod) == 0 )
                  {
                     AV181LiqLegImpTotNoRemu = AV181LiqLegImpTotNoRemu.add(A275LiqDImpCalcu) ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(A464DTipoConCod, AV185descuTipoConCod) == 0 )
                     {
                        AV182LiqLegImpTotDescu = AV182LiqLegImpTotDescu.add(A275LiqDImpCalcu) ;
                     }
                  }
               }
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) )
               {
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25baseImportes)==0) )
                  {
                     AV25baseImportes = A275LiqDImpCalcu ;
                     if ( A269LiqDCanti.doubleValue() > 0 )
                     {
                        AV25baseImportes = AV25baseImportes.divide(A269LiqDCanti, 18, java.math.RoundingMode.DOWN) ;
                        if ( GXutil.strcmp(A968LiqDUniMed, "%") == 0 )
                        {
                           AV25baseImportes = AV25baseImportes.multiply(DecimalUtil.doubleToDec(100)) ;
                        }
                     }
                  }
                  A277LiqDValUni = AV25baseImportes ;
                  n277LiqDValUni = false ;
               }
               if ( ! AV148calculoCero && ( AV103ok ) )
               {
                  A270LiqDErrorDesc = "" ;
                  n270LiqDErrorDesc = false ;
               }
               if ( ! AV179calcularRedondeo )
               {
                  if ( GXutil.strcmp(AV162desdeTipoConCod, AV163hastaTipoConCod) != 0 )
                  {
                     A918LiqDVueltaRes = (byte)(AV49d+1) ;
                  }
                  else
                  {
                     A918LiqDVueltaRes = (byte)(AV171d2+1) ;
                  }
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "LiqDVueltaRes ", "")+GXutil.trim( GXutil.str( A918LiqDVueltaRes, 2, 0))+httpContext.getMessage( " &d ", "")+GXutil.trim( GXutil.str( AV49d, 4, 0))) ;
               if ( (GXutil.strcmp("", A1070LiqDLog)==0) )
               {
                  A1070LiqDLog = GXutil.trim( A508LiqDFormulaHTML) ;
               }
               if ( (GXutil.strcmp("", A1072LiqDLogRecal)==0) )
               {
                  A1072LiqDLogRecal = GXutil.trim( A876LiqDReFormulaHTML) ;
               }
               A1070LiqDLog += AV71impliLiqDLog ;
               A1072LiqDLogRecal += AV71impliLiqDLog ;
            }
            else
            {
               if ( GXutil.strcmp(A394DConCodigo, httpContext.getMessage( "CAL046", "")) == 0 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDCalculado = 0", "")) ;
               }
               A507LiqDCalculado = (byte)(0) ;
               AV31cantPendientes = (short)(AV31cantPendientes+1) ;
               AV108pendientes_ConCodigo.add(A394DConCodigo, 0);
               new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "LiqDCalculado = 0", "")) ;
            }
            GXt_dtime7 = AV13ahora ;
            GXv_dtime8[0] = GXt_dtime7 ;
            new web.getahora(remoteHandle, context).execute( AV36CliCod, GXv_dtime8) ;
            procliquidacionsimple.this.GXt_dtime7 = GXv_dtime8[0] ;
            AV13ahora = GXt_dtime7 ;
            AV121segundos = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV13ahora, AV38comienzo)) ;
            A1469LiqDSeg = AV121segundos ;
            /* Using cursor P01RX5 */
            pr_default.execute(3, new Object[] {Byte.valueOf(A507LiqDCalculado), A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1219LiqDPlus, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, A968LiqDUniMed, Byte.valueOf(A918LiqDVueltaRes), A1469LiqDSeg, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV198GXLvl109 == 0 )
         {
            AV120seguir = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "corta. Total vueltas: ", "")+GXutil.trim( GXutil.str( AV49d, 4, 0))) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "se fue de foreach ", "")) ;
         if ( AV129tienePendientes )
         {
            if ( ! AV179calcularRedondeo )
            {
               if ( GXutil.strcmp(AV162desdeTipoConCod, AV163hastaTipoConCod) != 0 )
               {
                  AV49d = (short)(AV49d+1) ;
               }
               else
               {
                  AV171d2 = (short)(AV171d2+1) ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV74LegNumero, 8, 0))+httpContext.getMessage( " suma &d ", "")+GXutil.str( AV49d, 4, 0)+httpContext.getMessage( " &cantPendientes ", "")+GXutil.trim( GXutil.str( AV31cantPendientes, 4, 0))+httpContext.getMessage( " ultimo ", "")+GXutil.trim( GXutil.str( AV32cantPendientesUltimo, 4, 0))) ;
            if ( AV31cantPendientes == AV32cantPendientesUltimo )
            {
               if ( AV31cantPendientes > 0 )
               {
                  if ( AV153dependenciaConceptoEs )
                  {
                     AV34ciclicoErrorHay = true ;
                  }
                  else
                  {
                     AV149errorComunHay = true ;
                  }
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV36CliCod, AV195Pgmname, httpContext.getMessage( "LOOPEO &cantPendientes ", "")+GXutil.str( AV31cantPendientes, 4, 0)+httpContext.getMessage( " &yaHizoInsertsAdicionales ", "")+GXutil.trim( GXutil.str( AV141yaHizoInsertsAdicionales, 4, 0))) ;
                  AV120seguir = false ;
               }
            }
            AV32cantPendientesUltimo = AV31cantPendientes ;
         }
         else
         {
         }
         if ( AV31cantPendientes == 0 )
         {
            if (true) break;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP18[0] = procliquidacionsimple.this.AV34ciclicoErrorHay;
      this.aP19[0] = procliquidacionsimple.this.AV149errorComunHay;
      this.aP20[0] = procliquidacionsimple.this.AV190principalError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV190principalError = "" ;
      AV192LegModTra = "" ;
      AV151sueldoConCodigo = "" ;
      AV92loguearFallidosPalabra = "" ;
      GXt_char4 = "" ;
      GXt_char3 = "" ;
      AV177redondeoConCodigo = "" ;
      AV162desdeTipoConCod = "" ;
      AV163hastaTipoConCod = "" ;
      AV164LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV181LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV182LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV195Pgmname = "" ;
      c275LiqDImpCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01RX2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX2_n275LiqDImpCalcu = new boolean[] {false} ;
      P01RX3_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX3_n275LiqDImpCalcu = new boolean[] {false} ;
      P01RX3_AV165LiqLegCntRemu = new byte[1] ;
      A394DConCodigo = "" ;
      A1070LiqDLog = "" ;
      A1072LiqDLogRecal = "" ;
      A274LiqDFormula = "" ;
      A508LiqDFormulaHTML = "" ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A1760DAgeFecDes = GXutil.nullDate() ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A504LiqDForOrig = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      A1487DConCondicion = "" ;
      A468DSubTipoConCod1 = "" ;
      A393DConDescrip = "" ;
      A968LiqDUniMed = "" ;
      A270LiqDErrorDesc = "" ;
      A876LiqDReFormulaHTML = "" ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      A749LiqDFormuAux = "" ;
      A1469LiqDSeg = DecimalUtil.ZERO ;
      P01RX4_A394DConCodigo = new String[] {""} ;
      P01RX4_A464DTipoConCod = new String[] {""} ;
      P01RX4_A507LiqDCalculado = new byte[1] ;
      P01RX4_A6LegNumero = new int[1] ;
      P01RX4_A31LiqNro = new int[1] ;
      P01RX4_A1EmpCod = new short[1] ;
      P01RX4_A3CliCod = new int[1] ;
      P01RX4_A1070LiqDLog = new String[] {""} ;
      P01RX4_A1072LiqDLogRecal = new String[] {""} ;
      P01RX4_A274LiqDFormula = new String[] {""} ;
      P01RX4_n274LiqDFormula = new boolean[] {false} ;
      P01RX4_A508LiqDFormulaHTML = new String[] {""} ;
      P01RX4_n508LiqDFormulaHTML = new boolean[] {false} ;
      P01RX4_A400DTLiqCod = new String[] {""} ;
      P01RX4_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01RX4_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_n269LiqDCanti = new boolean[] {false} ;
      P01RX4_A1760DAgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01RX4_n1760DAgeFecDes = new boolean[] {false} ;
      P01RX4_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_n276LiqDImporte = new boolean[] {false} ;
      P01RX4_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_n277LiqDValUni = new boolean[] {false} ;
      P01RX4_A270LiqDErrorDesc = new String[] {""} ;
      P01RX4_n270LiqDErrorDesc = new boolean[] {false} ;
      P01RX4_A1219LiqDPlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_n275LiqDImpCalcu = new boolean[] {false} ;
      P01RX4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_A502LiqDMostrar = new byte[1] ;
      P01RX4_A876LiqDReFormulaHTML = new String[] {""} ;
      P01RX4_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P01RX4_A749LiqDFormuAux = new String[] {""} ;
      P01RX4_n749LiqDFormuAux = new boolean[] {false} ;
      P01RX4_A968LiqDUniMed = new String[] {""} ;
      P01RX4_A504LiqDForOrig = new String[] {""} ;
      P01RX4_A1487DConCondicion = new String[] {""} ;
      P01RX4_A468DSubTipoConCod1 = new String[] {""} ;
      P01RX4_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01RX4_A393DConDescrip = new String[] {""} ;
      P01RX4_A918LiqDVueltaRes = new byte[1] ;
      P01RX4_A1469LiqDSeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RX4_A509LiqDOrdEjec = new long[1] ;
      P01RX4_A81LiqDSecuencial = new int[1] ;
      AV38comienzo = GXutil.resetTime( GXutil.nullDate() );
      AV76LiqDFormula = "" ;
      AV8ConCodigo = "" ;
      AV115Resultado = DecimalUtil.ZERO ;
      AV25baseImportes = DecimalUtil.ZERO ;
      AV30cantidadCalculada = DecimalUtil.ZERO ;
      AV45ConOpeEsCant = DecimalUtil.ZERO ;
      AV137UnoDosAhora = GXutil.resetTime( GXutil.nullDate() );
      AV43ConFormula = "" ;
      AV158idOperando = "" ;
      AV157primeraPalabra = "" ;
      Gx_msg = "" ;
      GXv_char2 = new String[1] ;
      AV77LiqDFormulaHTML = "" ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV113resolverLiqDLog = "" ;
      AV82LiqDPlus = DecimalUtil.ZERO ;
      AV119SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV167baseConCodigo = "" ;
      AV168auxOpeCliId = "" ;
      AV110ProcesoLiquidacion = "" ;
      AV180netoImportes = DecimalUtil.ZERO ;
      AV159Operando = "" ;
      GXv_SdtSDTOperandosFormula21 = new web.SdtSDTOperandosFormula[1] ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_boolean14 = new boolean[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV118SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_char10 = new String[1] ;
      GXv_objcol_SdtSDTOperandosFormula22 = new GXBaseCollection[1] ;
      GXv_char5 = new String[1] ;
      AV79LiqDLog = "" ;
      GXv_char11 = new String[1] ;
      AV191LiqDErrorDesc = "" ;
      GXv_boolean17 = new boolean[1] ;
      GXv_int1 = new byte[1] ;
      AV60errores = "" ;
      AV11LiqDImporte = DecimalUtil.ZERO ;
      GXv_decimal19 = new java.math.BigDecimal[1] ;
      GXv_decimal16 = new java.math.BigDecimal[1] ;
      AV71impliLiqDLog = "" ;
      GXv_char18 = new String[1] ;
      GXv_boolean20 = new boolean[1] ;
      AV108pendientes_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime7 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime8 = new java.util.Date[1] ;
      AV121segundos = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procliquidacionsimple__default(),
         new Object[] {
             new Object[] {
            P01RX2_A275LiqDImpCalcu, P01RX2_n275LiqDImpCalcu
            }
            , new Object[] {
            P01RX3_A275LiqDImpCalcu, P01RX3_n275LiqDImpCalcu, P01RX3_AV165LiqLegCntRemu
            }
            , new Object[] {
            P01RX4_A394DConCodigo, P01RX4_A464DTipoConCod, P01RX4_A507LiqDCalculado, P01RX4_A6LegNumero, P01RX4_A31LiqNro, P01RX4_A1EmpCod, P01RX4_A3CliCod, P01RX4_A1070LiqDLog, P01RX4_A1072LiqDLogRecal, P01RX4_A274LiqDFormula,
            P01RX4_n274LiqDFormula, P01RX4_A508LiqDFormulaHTML, P01RX4_n508LiqDFormulaHTML, P01RX4_A400DTLiqCod, P01RX4_A397DLiqPeriodo, P01RX4_A269LiqDCanti, P01RX4_n269LiqDCanti, P01RX4_A1760DAgeFecDes, P01RX4_n1760DAgeFecDes, P01RX4_A276LiqDImporte,
            P01RX4_n276LiqDImporte, P01RX4_A277LiqDValUni, P01RX4_n277LiqDValUni, P01RX4_A270LiqDErrorDesc, P01RX4_n270LiqDErrorDesc, P01RX4_A1219LiqDPlus, P01RX4_A275LiqDImpCalcu, P01RX4_n275LiqDImpCalcu, P01RX4_A764LiqDImpReCalcu, P01RX4_A502LiqDMostrar,
            P01RX4_A876LiqDReFormulaHTML, P01RX4_n876LiqDReFormulaHTML, P01RX4_A749LiqDFormuAux, P01RX4_n749LiqDFormuAux, P01RX4_A968LiqDUniMed, P01RX4_A504LiqDForOrig, P01RX4_A1487DConCondicion, P01RX4_A468DSubTipoConCod1, P01RX4_n468DSubTipoConCod1, P01RX4_A393DConDescrip,
            P01RX4_A918LiqDVueltaRes, P01RX4_A1469LiqDSeg, P01RX4_A509LiqDOrdEjec, P01RX4_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      AV195Pgmname = "ProcLiquidacionSimple" ;
      /* GeneXus formulas. */
      AV195Pgmname = "ProcLiquidacionSimple" ;
      Gx_err = (short)(0) ;
   }

   private byte AV80LiqDLote ;
   private byte AV187cantDiasMes ;
   private byte AV152EmpTipoExp ;
   private byte AV170LegClase ;
   private byte AV165LiqLegCntRemu ;
   private byte AV166LiqLegCntTra ;
   private byte cV165LiqLegCntRemu ;
   private byte A918LiqDVueltaRes ;
   private byte A502LiqDMostrar ;
   private byte A507LiqDCalculado ;
   private byte AV198GXLvl109 ;
   private byte AV47ConVigencia ;
   private byte AV81LiqDMostrar ;
   private byte GXv_int1[] ;
   private short AV10EmpCod ;
   private short AV49d ;
   private short AV171d2 ;
   private short AV31cantPendientes ;
   private short A1EmpCod ;
   private short AV32cantPendientesUltimo ;
   private short AV141yaHizoInsertsAdicionales ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int AV87LiqNro ;
   private int AV175LiqRelNro ;
   private int AV107parmLegNumero ;
   private int AV74LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private long A509LiqDOrdEjec ;
   private java.math.BigDecimal AV188base_imp_min ;
   private java.math.BigDecimal AV189base_imp_max ;
   private java.math.BigDecimal AV164LiqLegImpTotRemu ;
   private java.math.BigDecimal AV181LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV182LiqLegImpTotDescu ;
   private java.math.BigDecimal c275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private java.math.BigDecimal A1469LiqDSeg ;
   private java.math.BigDecimal AV115Resultado ;
   private java.math.BigDecimal AV25baseImportes ;
   private java.math.BigDecimal AV30cantidadCalculada ;
   private java.math.BigDecimal AV45ConOpeEsCant ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal AV82LiqDPlus ;
   private java.math.BigDecimal AV180netoImportes ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal AV11LiqDImporte ;
   private java.math.BigDecimal GXv_decimal19[] ;
   private java.math.BigDecimal GXv_decimal16[] ;
   private java.math.BigDecimal AV121segundos ;
   private String AV131TLiqCod ;
   private String AV9ConveCodigo ;
   private String AV183remuTipoConCod ;
   private String AV184noRemuTipoConCod ;
   private String AV185descuTipoConCod ;
   private String AV192LegModTra ;
   private String AV151sueldoConCodigo ;
   private String AV92loguearFallidosPalabra ;
   private String GXt_char4 ;
   private String GXt_char3 ;
   private String AV177redondeoConCodigo ;
   private String AV162desdeTipoConCod ;
   private String AV163hastaTipoConCod ;
   private String AV195Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A400DTLiqCod ;
   private String A464DTipoConCod ;
   private String A1487DConCondicion ;
   private String A468DSubTipoConCod1 ;
   private String A968LiqDUniMed ;
   private String AV8ConCodigo ;
   private String AV158idOperando ;
   private String AV157primeraPalabra ;
   private String Gx_msg ;
   private String GXv_char2[] ;
   private String AV167baseConCodigo ;
   private String AV168auxOpeCliId ;
   private String AV110ProcesoLiquidacion ;
   private String AV159Operando ;
   private String GXv_char10[] ;
   private String GXv_char5[] ;
   private String GXv_char11[] ;
   private String GXv_char18[] ;
   private java.util.Date AV38comienzo ;
   private java.util.Date AV137UnoDosAhora ;
   private java.util.Date AV13ahora ;
   private java.util.Date GXt_dtime7 ;
   private java.util.Date GXv_dtime8[] ;
   private java.util.Date AV88LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date A1760DAgeFecDes ;
   private boolean AV132todosInsertados ;
   private boolean AV178redondeoHay ;
   private boolean AV34ciclicoErrorHay ;
   private boolean AV149errorComunHay ;
   private boolean AV91loguearFallidos ;
   private boolean returnInSub ;
   private boolean AV179calcularRedondeo ;
   private boolean AV156procesoAlgo ;
   private boolean n275LiqDImpCalcu ;
   private boolean AV120seguir ;
   private boolean AV109primerLegajo ;
   private boolean AV129tienePendientes ;
   private boolean n274LiqDFormula ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n269LiqDCanti ;
   private boolean n1760DAgeFecDes ;
   private boolean n276LiqDImporte ;
   private boolean n277LiqDValUni ;
   private boolean n270LiqDErrorDesc ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n749LiqDFormuAux ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV148calculoCero ;
   private boolean AV44ConMostrarPos ;
   private boolean AV154ConErrorSiCero ;
   private boolean AV173resolverDeUna ;
   private boolean AV103ok ;
   private boolean AV52dependenciasResueltas ;
   private boolean GXv_boolean6[] ;
   private boolean AV16alicuotaEs ;
   private boolean AV153dependenciaConceptoEs ;
   private boolean AV169cuotaSindicalEs ;
   private boolean GXv_boolean14[] ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean17[] ;
   private boolean Cond_result ;
   private boolean AV186restar ;
   private boolean GXv_boolean20[] ;
   private String A1070LiqDLog ;
   private String A1072LiqDLogRecal ;
   private String A274LiqDFormula ;
   private String A508LiqDFormulaHTML ;
   private String A504LiqDForOrig ;
   private String A876LiqDReFormulaHTML ;
   private String AV76LiqDFormula ;
   private String AV43ConFormula ;
   private String AV77LiqDFormulaHTML ;
   private String AV113resolverLiqDLog ;
   private String AV79LiqDLog ;
   private String AV71impliLiqDLog ;
   private String AV111programa ;
   private String AV190principalError ;
   private String A393DConDescrip ;
   private String A270LiqDErrorDesc ;
   private String A749LiqDFormuAux ;
   private String AV191LiqDErrorDesc ;
   private String AV60errores ;
   private String[] aP20 ;
   private boolean[] aP18 ;
   private boolean[] aP19 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01RX2_A275LiqDImpCalcu ;
   private boolean[] P01RX2_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01RX3_A275LiqDImpCalcu ;
   private boolean[] P01RX3_n275LiqDImpCalcu ;
   private byte[] P01RX3_AV165LiqLegCntRemu ;
   private String[] P01RX4_A394DConCodigo ;
   private String[] P01RX4_A464DTipoConCod ;
   private byte[] P01RX4_A507LiqDCalculado ;
   private int[] P01RX4_A6LegNumero ;
   private int[] P01RX4_A31LiqNro ;
   private short[] P01RX4_A1EmpCod ;
   private int[] P01RX4_A3CliCod ;
   private String[] P01RX4_A1070LiqDLog ;
   private String[] P01RX4_A1072LiqDLogRecal ;
   private String[] P01RX4_A274LiqDFormula ;
   private boolean[] P01RX4_n274LiqDFormula ;
   private String[] P01RX4_A508LiqDFormulaHTML ;
   private boolean[] P01RX4_n508LiqDFormulaHTML ;
   private String[] P01RX4_A400DTLiqCod ;
   private java.util.Date[] P01RX4_A397DLiqPeriodo ;
   private java.math.BigDecimal[] P01RX4_A269LiqDCanti ;
   private boolean[] P01RX4_n269LiqDCanti ;
   private java.util.Date[] P01RX4_A1760DAgeFecDes ;
   private boolean[] P01RX4_n1760DAgeFecDes ;
   private java.math.BigDecimal[] P01RX4_A276LiqDImporte ;
   private boolean[] P01RX4_n276LiqDImporte ;
   private java.math.BigDecimal[] P01RX4_A277LiqDValUni ;
   private boolean[] P01RX4_n277LiqDValUni ;
   private String[] P01RX4_A270LiqDErrorDesc ;
   private boolean[] P01RX4_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01RX4_A1219LiqDPlus ;
   private java.math.BigDecimal[] P01RX4_A275LiqDImpCalcu ;
   private boolean[] P01RX4_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01RX4_A764LiqDImpReCalcu ;
   private byte[] P01RX4_A502LiqDMostrar ;
   private String[] P01RX4_A876LiqDReFormulaHTML ;
   private boolean[] P01RX4_n876LiqDReFormulaHTML ;
   private String[] P01RX4_A749LiqDFormuAux ;
   private boolean[] P01RX4_n749LiqDFormuAux ;
   private String[] P01RX4_A968LiqDUniMed ;
   private String[] P01RX4_A504LiqDForOrig ;
   private String[] P01RX4_A1487DConCondicion ;
   private String[] P01RX4_A468DSubTipoConCod1 ;
   private boolean[] P01RX4_n468DSubTipoConCod1 ;
   private String[] P01RX4_A393DConDescrip ;
   private byte[] P01RX4_A918LiqDVueltaRes ;
   private java.math.BigDecimal[] P01RX4_A1469LiqDSeg ;
   private long[] P01RX4_A509LiqDOrdEjec ;
   private int[] P01RX4_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV108pendientes_ConCodigo ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV118SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula22[] ;
   private web.SdtSDTOperandosFormula AV119SDTOperandosItem ;
   private web.SdtSDTOperandosFormula GXv_SdtSDTOperandosFormula21[] ;
}

final  class procliquidacionsimple__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RX2", "SELECT SUM(LiqDImpCalcu) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?)) AND (DConCodigo <> ( ?) or ? = TRUE) AND (LiqDCalculado = 1) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RX3", "SELECT SUM(LiqDImpCalcu), COUNT(*) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?)) AND (LiqDCalculado = 1) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RX4", "SELECT DConCodigo, DTipoConCod, LiqDCalculado, LegNumero, LiqNro, EmpCod, CliCod, LiqDLog, LiqDLogRecal, LiqDFormula, LiqDFormulaHTML, DTLiqCod, DLiqPeriodo, LiqDCanti, DAgeFecDes, LiqDImporte, LiqDValUni, LiqDErrorDesc, LiqDPlus, LiqDImpCalcu, LiqDImpReCalcu, LiqDMostrar, LiqDReFormulaHTML, LiqDFormuAux, LiqDUniMed, LiqDForOrig, DConCondicion, DSubTipoConCod1, DConDescrip, LiqDVueltaRes, LiqDSeg, LiqDOrdEjec, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod >= ( ?)) AND (DConCodigo <> ( ?) or ? = TRUE) AND (LiqDCalculado = 0) AND (DTipoConCod <= ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod, LiqDOrdEjec  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01RX5", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?, LiqDLog=?, LiqDLogRecal=?, LiqDFormula=?, LiqDFormulaHTML=?, LiqDCanti=?, LiqDValUni=?, LiqDErrorDesc=?, LiqDPlus=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDMostrar=?, LiqDReFormulaHTML=?, LiqDFormuAux=?, LiqDUniMed=?, LiqDVueltaRes=?, LiqDSeg=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(13);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(14,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(16,2);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(17,2);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(19,4);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(21,2);
               ((byte[]) buf[29])[0] = rslt.getByte(22);
               ((String[]) buf[30])[0] = rslt.getLongVarchar(23);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getString(25, 20);
               ((String[]) buf[35])[0] = rslt.getLongVarchar(26);
               ((String[]) buf[36])[0] = rslt.getString(27, 20);
               ((String[]) buf[37])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(29);
               ((byte[]) buf[40])[0] = rslt.getByte(30);
               ((java.math.BigDecimal[]) buf[41])[0] = rslt.getBigDecimal(31,3);
               ((long[]) buf[42])[0] = rslt.getLong(32);
               ((int[]) buf[43])[0] = rslt.getInt(33);
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
               stmt.setString(6, (String)parms[5], 10);
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
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
               stmt.setString(6, (String)parms[5], 10);
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setString(8, (String)parms[7], 20);
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

