package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resolverformula extends GXProcedure
{
   public resolverformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resolverformula.class ), "" );
   }

   public resolverformula( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 ,
                              short aP4 ,
                              int aP5 ,
                              int aP6 ,
                              int aP7 ,
                              int aP8 ,
                              String aP9 ,
                              java.util.Date aP10 ,
                              String aP11 ,
                              String aP12 ,
                              boolean aP13 ,
                              java.math.BigDecimal aP14 ,
                              java.util.Date aP15 ,
                              java.math.BigDecimal aP16 ,
                              java.math.BigDecimal aP17 ,
                              boolean[] aP18 ,
                              String[] aP19 ,
                              String[] aP20 ,
                              String[] aP21 ,
                              String[] aP22 ,
                              java.math.BigDecimal[] aP23 ,
                              boolean[] aP24 ,
                              java.math.BigDecimal[] aP25 ,
                              boolean[] aP26 ,
                              java.math.BigDecimal[] aP27 ,
                              java.math.BigDecimal[] aP28 ,
                              boolean[] aP29 ,
                              String[] aP30 ,
                              java.math.BigDecimal[] aP31 )
   {
      resolverformula.this.aP32 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32);
      return aP32[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        int aP5 ,
                        int aP6 ,
                        int aP7 ,
                        int aP8 ,
                        String aP9 ,
                        java.util.Date aP10 ,
                        String aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        java.math.BigDecimal aP14 ,
                        java.util.Date aP15 ,
                        java.math.BigDecimal aP16 ,
                        java.math.BigDecimal aP17 ,
                        boolean[] aP18 ,
                        String[] aP19 ,
                        String[] aP20 ,
                        String[] aP21 ,
                        String[] aP22 ,
                        java.math.BigDecimal[] aP23 ,
                        boolean[] aP24 ,
                        java.math.BigDecimal[] aP25 ,
                        boolean[] aP26 ,
                        java.math.BigDecimal[] aP27 ,
                        java.math.BigDecimal[] aP28 ,
                        boolean[] aP29 ,
                        String[] aP30 ,
                        java.math.BigDecimal[] aP31 ,
                        boolean[] aP32 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             int aP5 ,
                             int aP6 ,
                             int aP7 ,
                             int aP8 ,
                             String aP9 ,
                             java.util.Date aP10 ,
                             String aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             java.math.BigDecimal aP14 ,
                             java.util.Date aP15 ,
                             java.math.BigDecimal aP16 ,
                             java.math.BigDecimal aP17 ,
                             boolean[] aP18 ,
                             String[] aP19 ,
                             String[] aP20 ,
                             String[] aP21 ,
                             String[] aP22 ,
                             java.math.BigDecimal[] aP23 ,
                             boolean[] aP24 ,
                             java.math.BigDecimal[] aP25 ,
                             boolean[] aP26 ,
                             java.math.BigDecimal[] aP27 ,
                             java.math.BigDecimal[] aP28 ,
                             boolean[] aP29 ,
                             String[] aP30 ,
                             java.math.BigDecimal[] aP31 ,
                             boolean[] aP32 )
   {
      resolverformula.this.AV10clicod = aP0;
      resolverformula.this.AV11ConCodigo = aP1;
      resolverformula.this.AV17Formula = aP2;
      resolverformula.this.AV20htmlFormula = aP3;
      resolverformula.this.AV13EmpCod = aP4;
      resolverformula.this.AV25LiqNro = aP5;
      resolverformula.this.AV69LiqRelNro = aP6;
      resolverformula.this.AV39ActualLiqNro = aP7;
      resolverformula.this.AV24LegNumero = aP8;
      resolverformula.this.AV59parmTLiqCod = aP9;
      resolverformula.this.AV57LiqPeriodo = aP10;
      resolverformula.this.AV26llamador = aP11;
      resolverformula.this.AV36ProcesoLiquidacion = aP12;
      resolverformula.this.AV49simulacionEs = aP13;
      resolverformula.this.AV43LiqDCanti = aP14;
      resolverformula.this.AV66DAgeFecDes = aP15;
      resolverformula.this.AV44LiqDImporte = aP16;
      resolverformula.this.AV45LiqDValUni = aP17;
      resolverformula.this.aP18 = aP18;
      resolverformula.this.aP19 = aP19;
      resolverformula.this.aP20 = aP20;
      resolverformula.this.aP21 = aP21;
      resolverformula.this.aP22 = aP22;
      resolverformula.this.aP23 = aP23;
      resolverformula.this.aP24 = aP24;
      resolverformula.this.aP25 = aP25;
      resolverformula.this.aP26 = aP26;
      resolverformula.this.aP27 = aP27;
      resolverformula.this.aP28 = aP28;
      resolverformula.this.aP29 = aP29;
      resolverformula.this.aP30 = aP30;
      resolverformula.this.aP31 = aP31;
      resolverformula.this.aP32 = aP32;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16FormOK = false ;
      AV18FormulaAux = AV17Formula ;
      AV21htmlFormulaAux = AV20htmlFormula ;
      AV38formulaConDescripciones = AV20htmlFormula ;
      GXv_char1[0] = AV21htmlFormulaAux ;
      new web.htmlreemplazartags(remoteHandle, context).execute( GXv_char1) ;
      resolverformula.this.AV21htmlFormulaAux = GXv_char1[0] ;
      GXv_char1[0] = AV51msgError ;
      new web.validarultimooperador(remoteHandle, context).execute( AV10clicod, AV11ConCodigo, AV18FormulaAux, GXv_char1) ;
      resolverformula.this.AV51msgError = GXv_char1[0] ;
      if ( ! (GXutil.strcmp("", AV51msgError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( (GXutil.strcmp("", AV58TLiqCod)==0) )
      {
         GXv_char1[0] = AV58TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV10clicod, AV13EmpCod, AV25LiqNro, GXv_char1) ;
         resolverformula.this.AV58TLiqCod = GXv_char1[0] ;
      }
      else
      {
         AV58TLiqCod = AV59parmTLiqCod ;
      }
      GXt_objcol_SdtSDTOperandosFormula2 = AV30SDTOperandos ;
      GXv_objcol_SdtSDTOperandosFormula3[0] = GXt_objcol_SdtSDTOperandosFormula2 ;
      new web.obtoperandosformula(remoteHandle, context).execute( AV10clicod, AV11ConCodigo, AV18FormulaAux, AV43LiqDCanti, AV44LiqDImporte, AV45LiqDValUni, GXv_objcol_SdtSDTOperandosFormula3) ;
      GXt_objcol_SdtSDTOperandosFormula2 = GXv_objcol_SdtSDTOperandosFormula3[0] ;
      AV30SDTOperandos = GXt_objcol_SdtSDTOperandosFormula2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV11ConCodigo)+httpContext.getMessage( " &SDTOperandos ", "")+AV30SDTOperandos.toJSonString(false)+httpContext.getMessage( " &FormulaAux ", "")+GXutil.trim( AV18FormulaAux)+httpContext.getMessage( " &formula ", "")+GXutil.trim( AV17Formula)) ;
      if ( AV30SDTOperandos.size() == 1 )
      {
         AV55solo1Es = true ;
      }
      if ( ( GXutil.strSearch( AV26llamador, httpContext.getMessage( "NewLiquidacionDetalle", ""), 1) != 0 ) || ( GXutil.strcmp(AV26llamador, httpContext.getMessage( "PrevisualizacionNovedad", "")) == 0 ) )
      {
         AV37insertandoConceptos = true ;
      }
      else
      {
         AV37insertandoConceptos = false ;
      }
      if ( AV30SDTOperandos.size() > 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV57LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         GXv_objcol_SdtSDTOperandosFormula3[0] = AV30SDTOperandos ;
         GXv_boolean4[0] = AV12dependenciasResueltas ;
         GXv_char1[0] = AV14error ;
         GXv_decimal5[0] = AV46ConOpeEsCant ;
         GXv_boolean6[0] = AV65alicuotaEs ;
         GXv_decimal7[0] = AV47cantidadCalculada ;
         GXv_decimal8[0] = AV50baseImportes ;
         GXv_boolean9[0] = AV56alMenos1CalculoHay ;
         GXv_char10[0] = AV52LiqDLog ;
         GXv_decimal11[0] = AV60LiqDPlus ;
         GXv_boolean12[0] = AV67dependenciaConceptoEs ;
         new web.resuelveoperandos2(remoteHandle, context).execute( AV10clicod, AV13EmpCod, AV25LiqNro, AV69LiqRelNro, AV24LegNumero, AV58TLiqCod, AV57LiqPeriodo, AV39ActualLiqNro, AV11ConCodigo, AV36ProcesoLiquidacion, AV26llamador, AV37insertandoConceptos, AV49simulacionEs, AV43LiqDCanti, AV66DAgeFecDes, GXv_objcol_SdtSDTOperandosFormula3, GXv_boolean4, GXv_char1, GXv_decimal5, GXv_boolean6, GXv_decimal7, GXv_decimal8, GXv_boolean9, GXv_char10, GXv_decimal11, GXv_boolean12) ;
         AV30SDTOperandos = GXv_objcol_SdtSDTOperandosFormula3[0] ;
         resolverformula.this.AV12dependenciasResueltas = GXv_boolean4[0] ;
         resolverformula.this.AV14error = GXv_char1[0] ;
         resolverformula.this.AV46ConOpeEsCant = GXv_decimal5[0] ;
         resolverformula.this.AV65alicuotaEs = GXv_boolean6[0] ;
         resolverformula.this.AV47cantidadCalculada = GXv_decimal7[0] ;
         resolverformula.this.AV50baseImportes = GXv_decimal8[0] ;
         resolverformula.this.AV56alMenos1CalculoHay = GXv_boolean9[0] ;
         resolverformula.this.AV52LiqDLog = GXv_char10[0] ;
         resolverformula.this.AV60LiqDPlus = GXv_decimal11[0] ;
         resolverformula.this.AV67dependenciaConceptoEs = GXv_boolean12[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "alicuotaes ", "")+GXutil.trim( GXutil.booltostr( AV65alicuotaEs))) ;
      }
      else
      {
         AV12dependenciasResueltas = true ;
      }
      if ( AV55solo1Es )
      {
         AV54soloUnCalculoEs = AV56alMenos1CalculoHay ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "CONCODIGO ", "")+GXutil.trim( AV11ConCodigo)+httpContext.getMessage( " resuoper devuelve &error ", "")+GXutil.trim( AV14error)+httpContext.getMessage( " msg ", "")+AV51msgError+httpContext.getMessage( " &SDTOperandos ", "")+AV30SDTOperandos.toJSonString(false)+httpContext.getMessage( " dependencias resueltas ", "")+GXutil.trim( GXutil.booltostr( AV12dependenciasResueltas))+httpContext.getMessage( " conopeescant ", "")+GXutil.trim( GXutil.str( AV46ConOpeEsCant, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "1 msg ", "")+AV51msgError) ;
      if ( GXutil.strcmp(GXutil.trim( AV18FormulaAux), "1") != 0 )
      {
         GXv_char10[0] = AV18FormulaAux ;
         GXv_char1[0] = AV38formulaConDescripciones ;
         GXv_char13[0] = AV21htmlFormulaAux ;
         GXv_objcol_SdtSDTOperandosFormula3[0] = AV30SDTOperandos ;
         GXv_boolean12[0] = false ;
         GXv_char14[0] = AV53reemplazaLiqDLog ;
         new web.formulareemplazarvalores(remoteHandle, context).execute( AV25LiqNro, GXv_char10, GXv_char1, GXv_char13, GXv_objcol_SdtSDTOperandosFormula3, GXv_boolean12, GXv_char14) ;
         resolverformula.this.AV18FormulaAux = GXv_char10[0] ;
         resolverformula.this.AV38formulaConDescripciones = GXv_char1[0] ;
         resolverformula.this.AV21htmlFormulaAux = GXv_char13[0] ;
         AV30SDTOperandos = GXv_objcol_SdtSDTOperandosFormula3[0] ;
         resolverformula.this.AV53reemplazaLiqDLog = GXv_char14[0] ;
      }
      if ( ! (GXutil.strcmp("", AV14error)==0) )
      {
         AV51msgError = GXutil.trim( AV14error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "2 msg ", "")+AV51msgError+httpContext.getMessage( " &FormulaAux ", "")+AV18FormulaAux) ;
      if ( GXutil.strcmp(GXutil.trim( AV18FormulaAux), "1") == 0 )
      {
         AV29Resultado = DecimalUtil.doubleToDec(1) ;
         AV16FormOK = true ;
         AV51msgError = "" ;
      }
      else
      {
         GXv_char14[0] = AV51msgError ;
         GXv_decimal11[0] = AV29Resultado ;
         GXv_boolean12[0] = AV16FormOK ;
         new web.formulaevaluarexpresion(remoteHandle, context).execute( AV18FormulaAux, AV26llamador, AV12dependenciasResueltas, GXv_char14, GXv_decimal11, GXv_boolean12) ;
         resolverformula.this.AV51msgError = GXv_char14[0] ;
         resolverformula.this.AV29Resultado = GXv_decimal11[0] ;
         resolverformula.this.AV16FormOK = GXv_boolean12[0] ;
      }
      if ( ( AV12dependenciasResueltas ) && ! (0==AV25LiqNro) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "3 msg ", "")+AV51msgError) ;
         GXt_char15 = AV41pagosACuentaConCodigo ;
         GXt_char16 = AV41pagosACuentaConCodigo ;
         GXv_char14[0] = GXt_char16 ;
         new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char14) ;
         resolverformula.this.GXt_char16 = GXv_char14[0] ;
         GXv_char13[0] = GXt_char15 ;
         new web.getparametro(remoteHandle, context).execute( AV10clicod, GXt_char16, GXv_char13) ;
         resolverformula.this.GXt_char15 = GXv_char13[0] ;
         AV41pagosACuentaConCodigo = GXt_char15 ;
         if ( ( GXutil.strcmp(AV11ConCodigo, AV41pagosACuentaConCodigo) == 0 ) && ( new web.viejopagosacuenta(remoteHandle, context).executeUdp( ) ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            GXv_date17[0] = AV42lLiqPeriodo ;
            new web.getperiodoliquidacion(remoteHandle, context).execute( AV10clicod, AV13EmpCod, AV25LiqNro, GXv_date17) ;
            resolverformula.this.AV42lLiqPeriodo = GXv_date17[0] ;
            new web.restarcuenta(remoteHandle, context).execute( AV10clicod, AV13EmpCod, (short)(GXutil.year( AV42lLiqPeriodo)), AV24LegNumero, AV11ConCodigo, AV29Resultado) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10clicod, AV72Pgmname, httpContext.getMessage( "4 msg ", "")+AV51msgError) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP18[0] = resolverformula.this.AV16FormOK;
      this.aP19[0] = resolverformula.this.AV51msgError;
      this.aP20[0] = resolverformula.this.AV18FormulaAux;
      this.aP21[0] = resolverformula.this.AV21htmlFormulaAux;
      this.aP22[0] = resolverformula.this.AV38formulaConDescripciones;
      this.aP23[0] = resolverformula.this.AV29Resultado;
      this.aP24[0] = resolverformula.this.AV12dependenciasResueltas;
      this.aP25[0] = resolverformula.this.AV46ConOpeEsCant;
      this.aP26[0] = resolverformula.this.AV65alicuotaEs;
      this.aP27[0] = resolverformula.this.AV47cantidadCalculada;
      this.aP28[0] = resolverformula.this.AV50baseImportes;
      this.aP29[0] = resolverformula.this.AV54soloUnCalculoEs;
      this.aP30[0] = resolverformula.this.AV52LiqDLog;
      this.aP31[0] = resolverformula.this.AV60LiqDPlus;
      this.aP32[0] = resolverformula.this.AV67dependenciaConceptoEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV51msgError = "" ;
      AV18FormulaAux = "" ;
      AV21htmlFormulaAux = "" ;
      AV38formulaConDescripciones = "" ;
      AV29Resultado = DecimalUtil.ZERO ;
      AV46ConOpeEsCant = DecimalUtil.ZERO ;
      AV47cantidadCalculada = DecimalUtil.ZERO ;
      AV50baseImportes = DecimalUtil.ZERO ;
      AV52LiqDLog = "" ;
      AV60LiqDPlus = DecimalUtil.ZERO ;
      AV58TLiqCod = "" ;
      AV30SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXt_objcol_SdtSDTOperandosFormula2 = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      AV72Pgmname = "" ;
      GXv_boolean4 = new boolean[1] ;
      AV14error = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char10 = new String[1] ;
      GXv_char1 = new String[1] ;
      GXv_objcol_SdtSDTOperandosFormula3 = new GXBaseCollection[1] ;
      AV53reemplazaLiqDLog = "" ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      AV41pagosACuentaConCodigo = "" ;
      GXt_char15 = "" ;
      GXt_char16 = "" ;
      GXv_char14 = new String[1] ;
      GXv_char13 = new String[1] ;
      AV42lLiqPeriodo = GXutil.nullDate() ;
      GXv_date17 = new java.util.Date[1] ;
      AV72Pgmname = "resolverFormula" ;
      /* GeneXus formulas. */
      AV72Pgmname = "resolverFormula" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV25LiqNro ;
   private int AV69LiqRelNro ;
   private int AV39ActualLiqNro ;
   private int AV24LegNumero ;
   private java.math.BigDecimal AV43LiqDCanti ;
   private java.math.BigDecimal AV44LiqDImporte ;
   private java.math.BigDecimal AV45LiqDValUni ;
   private java.math.BigDecimal AV29Resultado ;
   private java.math.BigDecimal AV46ConOpeEsCant ;
   private java.math.BigDecimal AV47cantidadCalculada ;
   private java.math.BigDecimal AV50baseImportes ;
   private java.math.BigDecimal AV60LiqDPlus ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private String AV11ConCodigo ;
   private String AV59parmTLiqCod ;
   private String AV26llamador ;
   private String AV36ProcesoLiquidacion ;
   private String AV58TLiqCod ;
   private String AV72Pgmname ;
   private String GXv_char10[] ;
   private String GXv_char1[] ;
   private String AV41pagosACuentaConCodigo ;
   private String GXt_char15 ;
   private String GXt_char16 ;
   private String GXv_char14[] ;
   private String GXv_char13[] ;
   private java.util.Date AV57LiqPeriodo ;
   private java.util.Date AV66DAgeFecDes ;
   private java.util.Date AV42lLiqPeriodo ;
   private java.util.Date GXv_date17[] ;
   private boolean AV49simulacionEs ;
   private boolean AV16FormOK ;
   private boolean AV12dependenciasResueltas ;
   private boolean AV65alicuotaEs ;
   private boolean AV54soloUnCalculoEs ;
   private boolean AV67dependenciaConceptoEs ;
   private boolean returnInSub ;
   private boolean AV55solo1Es ;
   private boolean AV37insertandoConceptos ;
   private boolean GXv_boolean4[] ;
   private boolean GXv_boolean6[] ;
   private boolean AV56alMenos1CalculoHay ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean12[] ;
   private boolean Cond_result ;
   private String AV17Formula ;
   private String AV20htmlFormula ;
   private String AV18FormulaAux ;
   private String AV21htmlFormulaAux ;
   private String AV38formulaConDescripciones ;
   private String AV52LiqDLog ;
   private String AV53reemplazaLiqDLog ;
   private String AV51msgError ;
   private String AV14error ;
   private boolean[] aP32 ;
   private boolean[] aP18 ;
   private String[] aP19 ;
   private String[] aP20 ;
   private String[] aP21 ;
   private String[] aP22 ;
   private java.math.BigDecimal[] aP23 ;
   private boolean[] aP24 ;
   private java.math.BigDecimal[] aP25 ;
   private boolean[] aP26 ;
   private java.math.BigDecimal[] aP27 ;
   private java.math.BigDecimal[] aP28 ;
   private boolean[] aP29 ;
   private String[] aP30 ;
   private java.math.BigDecimal[] aP31 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV30SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXt_objcol_SdtSDTOperandosFormula2 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula3[] ;
}

