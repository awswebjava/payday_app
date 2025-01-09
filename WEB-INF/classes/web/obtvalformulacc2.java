package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulacc2 extends GXProcedure
{
   public obtvalformulacc2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulacc2.class ), "" );
   }

   public obtvalformulacc2( int remoteHandle ,
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
                             java.util.Date aP5 ,
                             String aP6 ,
                             int aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             int aP18 ,
                             String aP19 ,
                             java.math.BigDecimal[] aP20 ,
                             boolean[] aP21 ,
                             short[] aP22 ,
                             String[] aP23 )
   {
      obtvalformulacc2.this.aP24 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24);
      return aP24[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        int aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        String aP17 ,
                        int aP18 ,
                        String aP19 ,
                        java.math.BigDecimal[] aP20 ,
                        boolean[] aP21 ,
                        short[] aP22 ,
                        String[] aP23 ,
                        String[] aP24 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             int aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             int aP18 ,
                             String aP19 ,
                             java.math.BigDecimal[] aP20 ,
                             boolean[] aP21 ,
                             short[] aP22 ,
                             String[] aP23 ,
                             String[] aP24 )
   {
      obtvalformulacc2.this.AV31CliCod = aP0;
      obtvalformulacc2.this.AV18EmpCod = aP1;
      obtvalformulacc2.this.AV25LiqNro = aP2;
      obtvalformulacc2.this.AV99LiqRelNro = aP3;
      obtvalformulacc2.this.AV51ConCodigo = aP4;
      obtvalformulacc2.this.AV64LiqPeriodo = aP5;
      obtvalformulacc2.this.AV56ProcesoLiquidacion = aP6;
      obtvalformulacc2.this.AV24LegNumero = aP7;
      obtvalformulacc2.this.AV15ConceptoPar = aP8;
      obtvalformulacc2.this.AV102TipoConCod = aP9;
      obtvalformulacc2.this.AV8TliqCod = aP10;
      obtvalformulacc2.this.AV75insertandoConceptos = aP11;
      obtvalformulacc2.this.AV40cantidadPalabra = aP12;
      obtvalformulacc2.this.AV42totalPalabra = aP13;
      obtvalformulacc2.this.AV17Devolver = aP14;
      obtvalformulacc2.this.AV27Operando = aP15;
      obtvalformulacc2.this.AV16CriterioBusqueda = aP16;
      obtvalformulacc2.this.AV11Calculo = aP17;
      obtvalformulacc2.this.AV101PeriodoNum6 = aP18;
      obtvalformulacc2.this.AV96busquedaTLiqCod = aP19;
      obtvalformulacc2.this.aP20 = aP20;
      obtvalformulacc2.this.aP21 = aP21;
      obtvalformulacc2.this.aP22 = aP22;
      obtvalformulacc2.this.aP23 = aP23;
      obtvalformulacc2.this.aP24 = aP24;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV17Devolver, AV40cantidadPalabra) == 0 )
      {
         AV97calcularCantidad = true ;
      }
      GXt_char1 = AV58parametroPalabra ;
      GXt_char2 = AV58parametroPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.metodorecalculo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      obtvalformulacc2.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV31CliCod, GXt_char2, GXv_char4) ;
      obtvalformulacc2.this.GXt_char1 = GXv_char4[0] ;
      AV58parametroPalabra = GXt_char1 ;
      AV22Importe = DecimalUtil.ZERO ;
      GXv_boolean5[0] = AV59ConceptoAplicaTipoLiq ;
      new web.conceptoaplicatipoliqyconvenio(remoteHandle, context).execute( AV31CliCod, AV18EmpCod, AV25LiqNro, AV24LegNumero, AV15ConceptoPar, "", "", GXv_boolean5) ;
      obtvalformulacc2.this.AV59ConceptoAplicaTipoLiq = GXv_boolean5[0] ;
      GXv_date6[0] = AV19FecDesde ;
      GXv_date7[0] = AV21FecHasta ;
      GXv_boolean5[0] = AV49excluirLiquidacionPropia ;
      new web.calcparpergetdesdehasta(remoteHandle, context).execute( AV31CliCod, AV18EmpCod, AV25LiqNro, AV64LiqPeriodo, AV101PeriodoNum6, AV16CriterioBusqueda, GXv_date6, GXv_date7, GXv_boolean5) ;
      obtvalformulacc2.this.AV19FecDesde = GXv_date6[0] ;
      obtvalformulacc2.this.AV21FecHasta = GXv_date7[0] ;
      obtvalformulacc2.this.AV49excluirLiquidacionPropia = GXv_boolean5[0] ;
      GXt_char2 = AV34sumaPalabra ;
      GXv_char4[0] = GXt_char2 ;
      new web.sumapalabra(remoteHandle, context).execute( AV31CliCod, GXv_char4) ;
      obtvalformulacc2.this.GXt_char2 = GXv_char4[0] ;
      AV34sumaPalabra = GXt_char2 ;
      GXt_char2 = AV35promedioPalabra ;
      GXv_char4[0] = GXt_char2 ;
      new web.palabra_promedio(remoteHandle, context).execute( AV31CliCod, GXv_char4) ;
      obtvalformulacc2.this.GXt_char2 = GXv_char4[0] ;
      AV35promedioPalabra = GXt_char2 ;
      GXt_char2 = AV36mejorPalabra ;
      GXv_char4[0] = GXt_char2 ;
      new web.palabra_mejor(remoteHandle, context).execute( AV31CliCod, GXv_char4) ;
      obtvalformulacc2.this.GXt_char2 = GXv_char4[0] ;
      AV36mejorPalabra = GXt_char2 ;
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV11Calculo)), GXutil.upper( GXutil.trim( AV35promedioPalabra))) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV11Calculo)), GXutil.upper( GXutil.trim( AV36mejorPalabra))) == 0 ) )
      {
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV16CriterioBusqueda)), GXutil.upper( GXutil.trim( AV47semestrePalabra))) == 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV11Calculo)), GXutil.upper( GXutil.trim( AV36mejorPalabra))) == 0 ) )
         {
            GXv_decimal8[0] = AV22Importe ;
            GXv_boolean5[0] = false ;
            GXv_date7[0] = AV88Date ;
            GXv_int9[0] = AV89mejorLiqDCalculado ;
            GXv_char4[0] = AV83error ;
            new web.getliqdimpcalcumejor2(remoteHandle, context).execute( AV31CliCod, AV18EmpCod, AV25LiqNro, AV99LiqRelNro, AV24LegNumero, AV15ConceptoPar, AV102TipoConCod, AV64LiqPeriodo, AV56ProcesoLiquidacion, true, AV96busquedaTLiqCod, AV97calcularCantidad, GXv_decimal8, GXv_boolean5, GXv_date7, GXv_int9, GXv_char4) ;
            obtvalformulacc2.this.AV22Importe = GXv_decimal8[0] ;
            obtvalformulacc2.this.AV88Date = GXv_date7[0] ;
            obtvalformulacc2.this.AV89mejorLiqDCalculado = GXv_int9[0] ;
            obtvalformulacc2.this.AV83error = GXv_char4[0] ;
            if ( AV89mejorLiqDCalculado == 0 )
            {
               AV39dependenciasResueltas = (boolean)((0==0)?false:true) ;
               AV84LiqDLog = AV83error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               AV39dependenciasResueltas = true ;
            }
         }
         else
         {
            if ( ( AV59ConceptoAplicaTipoLiq ) && ( GXutil.strcmp(AV51ConCodigo, AV15ConceptoPar) != 0 ) )
            {
               AV81existenciaObligada = true ;
            }
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV16CriterioBusqueda)), GXutil.upper( GXutil.trim( AV47semestrePalabra))) == 0 )
            {
               AV86semestre = true ;
            }
            else
            {
               AV86semestre = false ;
            }
            if ( GXutil.strcmp(AV15ConceptoPar, AV91sueldoBrutoSinSacConCodigo) == 0 )
            {
               GXt_char2 = AV90excluirTLiqCod ;
               GXt_char1 = AV90excluirTLiqCod ;
               GXv_char4[0] = GXt_char1 ;
               new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               obtvalformulacc2.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV31CliCod, GXt_char1, GXv_char3) ;
               obtvalformulacc2.this.GXt_char2 = GXv_char3[0] ;
               AV90excluirTLiqCod = GXt_char2 ;
            }
            else
            {
               AV90excluirTLiqCod = "" ;
            }
            GXv_decimal8[0] = AV23ImporteAux ;
            GXv_decimal10[0] = AV98LiqDCanti ;
            GXv_boolean5[0] = false ;
            GXv_int11[0] = AV12CantidadAux ;
            GXv_int9[0] = AV82promedioLiqDCalculado ;
            GXv_boolean12[0] = false ;
            GXv_char4[0] = AV83error ;
            new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV31CliCod, AV18EmpCod, AV25LiqNro, AV99LiqRelNro, AV24LegNumero, AV15ConceptoPar, AV102TipoConCod, AV19FecDesde, AV64LiqPeriodo, AV51ConCodigo, AV56ProcesoLiquidacion, AV86semestre, AV81existenciaObligada, AV90excluirTLiqCod, true, AV96busquedaTLiqCod, GXv_decimal8, GXv_decimal10, GXv_boolean5, GXv_int11, GXv_int9, GXv_boolean12, GXv_char4) ;
            obtvalformulacc2.this.AV23ImporteAux = GXv_decimal8[0] ;
            obtvalformulacc2.this.AV98LiqDCanti = GXv_decimal10[0] ;
            obtvalformulacc2.this.AV12CantidadAux = GXv_int11[0] ;
            obtvalformulacc2.this.AV82promedioLiqDCalculado = GXv_int9[0] ;
            obtvalformulacc2.this.AV83error = GXv_char4[0] ;
            if ( AV82promedioLiqDCalculado == 0 )
            {
               AV39dependenciasResueltas = false ;
               AV84LiqDLog = AV83error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               AV39dependenciasResueltas = true ;
            }
            if ( AV12CantidadAux > 0 )
            {
               if ( AV97calcularCantidad )
               {
                  AV22Importe = GXutil.roundDecimal( AV98LiqDCanti.divide(DecimalUtil.doubleToDec(AV12CantidadAux), 18, java.math.RoundingMode.DOWN), 4) ;
               }
               else
               {
                  AV22Importe = GXutil.roundDecimal( AV23ImporteAux.divide(DecimalUtil.doubleToDec(AV12CantidadAux), 18, java.math.RoundingMode.DOWN), 4) ;
               }
            }
         }
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         /* Execute user subroutine: 'RECORRELIQUIDACIONES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV22Importe = AV23ImporteAux ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "&&Importe ", "")+GXutil.trim( GXutil.str( AV22Importe, 14, 4))+httpContext.getMessage( " &Calculo ", "")+AV11Calculo+httpContext.getMessage( " suma ", "")+AV34sumaPalabra+httpContext.getMessage( " &ImporteAux ", "")+GXutil.trim( GXutil.str( AV23ImporteAux, 14, 4))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'RECORRELIQUIDACIONES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "&ConceptoPar ", "")+GXutil.trim( AV15ConceptoPar)+httpContext.getMessage( " &PeriodoNum6 ", "")+GXutil.trim( GXutil.str( AV101PeriodoNum6, 6, 0))+httpContext.getMessage( " criteriobusqueda ", "")+GXutil.trim( AV16CriterioBusqueda)+httpContext.getMessage( " recorre liquis &CliCod ", "")+GXutil.trim( GXutil.str( AV31CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV18EmpCod, 4, 0))+httpContext.getMessage( "&FecDesde ", "")+GXutil.trim( localUtil.dtoc( AV19FecDesde, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &FecHasta ", "")+GXutil.trim( localUtil.dtoc( AV21FecHasta, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV25LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV24LegNumero, 8, 0))+httpContext.getMessage( " &ConceptoPar ", "")+GXutil.trim( AV15ConceptoPar)+httpContext.getMessage( " &TliqCod ", "")+GXutil.trim( AV8TliqCod)+httpContext.getMessage( " &Calculo trimup ", "")+GXutil.upper( GXutil.trim( AV11Calculo))+httpContext.getMessage( " palabrasuma ", "")+GXutil.upper( GXutil.trim( AV34sumaPalabra))+httpContext.getMessage( " palabraPromedio ", "")+GXutil.trim( GXutil.upper( AV35promedioPalabra))+httpContext.getMessage( " &devolver ", "")+AV17Devolver+httpContext.getMessage( " concodigo ", "")+GXutil.trim( AV51ConCodigo)+httpContext.getMessage( " &busquedaTLiqCod ", "")+AV96busquedaTLiqCod) ;
      GXv_int11[0] = AV77cantidadCalculada ;
      GXv_boolean12[0] = AV39dependenciasResueltas ;
      GXv_decimal10[0] = AV23ImporteAux ;
      GXv_int13[0] = AV12CantidadAux ;
      GXv_char4[0] = AV85cc4LiqDLog ;
      new web.obtvalformulacc5(remoteHandle, context).execute( AV31CliCod, AV18EmpCod, AV25LiqNro, AV64LiqPeriodo, AV8TliqCod, AV99LiqRelNro, AV24LegNumero, AV51ConCodigo, AV15ConceptoPar, AV102TipoConCod, AV96busquedaTLiqCod, AV17Devolver, AV19FecDesde, AV21FecHasta, AV56ProcesoLiquidacion, AV40cantidadPalabra, AV49excluirLiquidacionPropia, GXv_int11, GXv_boolean12, GXv_decimal10, GXv_int13, GXv_char4) ;
      obtvalformulacc2.this.AV77cantidadCalculada = GXv_int11[0] ;
      obtvalformulacc2.this.AV39dependenciasResueltas = GXv_boolean12[0] ;
      obtvalformulacc2.this.AV23ImporteAux = GXv_decimal10[0] ;
      obtvalformulacc2.this.AV12CantidadAux = GXv_int13[0] ;
      obtvalformulacc2.this.AV85cc4LiqDLog = GXv_char4[0] ;
      AV84LiqDLog += AV85cc4LiqDLog ;
   }

   protected void cleanup( )
   {
      this.aP20[0] = obtvalformulacc2.this.AV22Importe;
      this.aP21[0] = obtvalformulacc2.this.AV39dependenciasResueltas;
      this.aP22[0] = obtvalformulacc2.this.AV77cantidadCalculada;
      this.aP23[0] = obtvalformulacc2.this.AV83error;
      this.aP24[0] = obtvalformulacc2.this.AV84LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22Importe = DecimalUtil.ZERO ;
      AV83error = "" ;
      AV84LiqDLog = "" ;
      AV58parametroPalabra = "" ;
      AV19FecDesde = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV21FecHasta = GXutil.nullDate() ;
      AV34sumaPalabra = "" ;
      AV35promedioPalabra = "" ;
      AV36mejorPalabra = "" ;
      AV47semestrePalabra = "" ;
      AV88Date = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV91sueldoBrutoSinSacConCodigo = "" ;
      AV90excluirTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV23ImporteAux = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV98LiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean5 = new boolean[1] ;
      GXv_int9 = new byte[1] ;
      AV105Pgmname = "" ;
      GXv_int11 = new short[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_int13 = new short[1] ;
      AV85cc4LiqDLog = "" ;
      GXv_char4 = new String[1] ;
      AV105Pgmname = "ObtValFormulaCC2" ;
      /* GeneXus formulas. */
      AV105Pgmname = "ObtValFormulaCC2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV89mejorLiqDCalculado ;
   private byte AV82promedioLiqDCalculado ;
   private byte GXv_int9[] ;
   private short AV18EmpCod ;
   private short AV77cantidadCalculada ;
   private short AV12CantidadAux ;
   private short GXv_int11[] ;
   private short GXv_int13[] ;
   private short Gx_err ;
   private int AV31CliCod ;
   private int AV25LiqNro ;
   private int AV99LiqRelNro ;
   private int AV24LegNumero ;
   private int AV101PeriodoNum6 ;
   private java.math.BigDecimal AV22Importe ;
   private java.math.BigDecimal AV23ImporteAux ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal AV98LiqDCanti ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private String AV51ConCodigo ;
   private String AV56ProcesoLiquidacion ;
   private String AV15ConceptoPar ;
   private String AV102TipoConCod ;
   private String AV8TliqCod ;
   private String AV40cantidadPalabra ;
   private String AV42totalPalabra ;
   private String AV17Devolver ;
   private String AV16CriterioBusqueda ;
   private String AV11Calculo ;
   private String AV96busquedaTLiqCod ;
   private String AV58parametroPalabra ;
   private String AV34sumaPalabra ;
   private String AV35promedioPalabra ;
   private String AV36mejorPalabra ;
   private String AV47semestrePalabra ;
   private String AV91sueldoBrutoSinSacConCodigo ;
   private String AV90excluirTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV105Pgmname ;
   private String GXv_char4[] ;
   private java.util.Date AV64LiqPeriodo ;
   private java.util.Date AV19FecDesde ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date AV21FecHasta ;
   private java.util.Date AV88Date ;
   private java.util.Date GXv_date7[] ;
   private boolean AV75insertandoConceptos ;
   private boolean AV39dependenciasResueltas ;
   private boolean AV97calcularCantidad ;
   private boolean AV59ConceptoAplicaTipoLiq ;
   private boolean AV49excluirLiquidacionPropia ;
   private boolean returnInSub ;
   private boolean AV81existenciaObligada ;
   private boolean AV86semestre ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean12[] ;
   private String AV84LiqDLog ;
   private String AV85cc4LiqDLog ;
   private String AV27Operando ;
   private String AV83error ;
   private String[] aP24 ;
   private java.math.BigDecimal[] aP20 ;
   private boolean[] aP21 ;
   private short[] aP22 ;
   private String[] aP23 ;
}

