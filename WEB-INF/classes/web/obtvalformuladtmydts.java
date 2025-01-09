package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformuladtmydts extends GXProcedure
{
   public obtvalformuladtmydts( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformuladtmydts.class ), "" );
   }

   public obtvalformuladtmydts( int remoteHandle ,
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
                             String aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             int[] aP12 ,
                             byte[] aP13 ,
                             String[] aP14 )
   {
      obtvalformuladtmydts.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        boolean aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        int[] aP12 ,
                        byte[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             int[] aP12 ,
                             byte[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 )
   {
      obtvalformuladtmydts.this.AV20CliCod = aP0;
      obtvalformuladtmydts.this.AV14EmpCod = aP1;
      obtvalformuladtmydts.this.AV27LiqNro = aP2;
      obtvalformuladtmydts.this.AV98LiqRelNro = aP3;
      obtvalformuladtmydts.this.AV13LegNumero = aP4;
      obtvalformuladtmydts.this.AV9Param = aP5;
      obtvalformuladtmydts.this.AV29LiqPeriodo = aP6;
      obtvalformuladtmydts.this.AV39restarLicencias = aP7;
      obtvalformuladtmydts.this.AV46restarFeriados = aP8;
      obtvalformuladtmydts.this.AV89sumarAdelantoDeVacaciones = aP9;
      obtvalformuladtmydts.this.AV91ProcesoLiquidacion = aP10;
      obtvalformuladtmydts.this.AV90insertandoConceptos = aP11;
      obtvalformuladtmydts.this.aP12 = aP12;
      obtvalformuladtmydts.this.aP13 = aP13;
      obtvalformuladtmydts.this.aP14 = aP14;
      obtvalformuladtmydts.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV36LiqDCalculado = (byte)(1) ;
      AV8Cantidad = 0 ;
      /* Using cursor P007E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV13LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P007E2_A6LegNumero[0] ;
         A1EmpCod = P007E2_A1EmpCod[0] ;
         A3CliCod = P007E2_A3CliCod[0] ;
         A245LegFecIngreso = P007E2_A245LegFecIngreso[0] ;
         A1583LegMegCodigo = P007E2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P007E2_n1583LegMegCodigo[0] ;
         A244LegFecEgreso = P007E2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P007E2_n244LegFecEgreso[0] ;
         AV15LegFecIngreso = A245LegFecIngreso ;
         AV31MegCodigo = A1583LegMegCodigo ;
         AV30LegFecEgreso = A244LegFecEgreso ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV21diasTrabajadosMes = "[dias_trabajados_mes]" ;
      AV22diasTrabajadosSemestre = "[dias_remunerados_semestre]" ;
      GXt_char1 = AV41parmValue ;
      GXt_char2 = AV41parmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char2, GXv_char4) ;
      obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
      AV41parmValue = GXt_char1 ;
      AV38todosLosMeses30 = GXutil.boolval( AV41parmValue) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&parmValue ", "")+AV41parmValue+httpContext.getMessage( " boolean ", "")+GXutil.trim( GXutil.booltostr( AV38todosLosMeses30))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&Param ", "")+AV9Param+httpContext.getMessage( " &diasTrabajadosMes ", "")+AV21diasTrabajadosMes) ;
      GXv_int5[0] = AV42LegClase ;
      GXv_char4[0] = AV100legModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV13LegNumero, GXv_int5, GXv_char4) ;
      obtvalformuladtmydts.this.AV42LegClase = GXv_int5[0] ;
      obtvalformuladtmydts.this.AV100legModTra = GXv_char4[0] ;
      AV43horasDia = (short)(1) ;
      if ( GXutil.strcmp(AV9Param, AV21diasTrabajadosMes) == 0 )
      {
         GXv_int6[0] = (short)(AV8Cantidad) ;
         GXv_int5[0] = AV36LiqDCalculado ;
         GXv_char4[0] = AV53error ;
         GXv_char3[0] = AV60LiqDLog ;
         new web.dias_trabajados_mes(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV13LegNumero, AV29LiqPeriodo, AV30LegFecEgreso, AV42LegClase, AV100legModTra, AV38todosLosMeses30, AV15LegFecIngreso, AV39restarLicencias, AV46restarFeriados, AV91ProcesoLiquidacion, AV90insertandoConceptos, GXv_int6, GXv_int5, GXv_char4, GXv_char3) ;
         obtvalformuladtmydts.this.AV8Cantidad = GXv_int6[0] ;
         obtvalformuladtmydts.this.AV36LiqDCalculado = GXv_int5[0] ;
         obtvalformuladtmydts.this.AV53error = GXv_char4[0] ;
         obtvalformuladtmydts.this.AV60LiqDLog = GXv_char3[0] ;
      }
      else if ( GXutil.strcmp(AV9Param, AV22diasTrabajadosSemestre) == 0 )
      {
         GXt_char2 = AV96diasSacConCodigo ;
         GXt_char1 = AV96diasSacConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_diasproporsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
         obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
         AV96diasSacConCodigo = GXt_char2 ;
         GXv_decimal7[0] = DecimalUtil.doubleToDec(AV8Cantidad) ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean9[0] = false ;
         GXv_int6[0] = (short)(0) ;
         GXv_int5[0] = AV86diasTopeLiqDCalculado ;
         GXv_boolean10[0] = false ;
         GXv_char4[0] = AV53error ;
         GXv_char3[0] = AV88topeLiqDLog ;
         new web.getliqdimpcalcuacumulado2(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV98LiqRelNro, AV13LegNumero, AV96diasSacConCodigo, AV29LiqPeriodo, "Calculo", true, true, GXv_decimal7, GXv_decimal8, GXv_boolean9, GXv_int6, GXv_int5, GXv_boolean10, GXv_char4, GXv_char3) ;
         obtvalformuladtmydts.this.AV8Cantidad = (int)(DecimalUtil.decToDouble(GXv_decimal7[0])) ;
         obtvalformuladtmydts.this.AV86diasTopeLiqDCalculado = GXv_int5[0] ;
         obtvalformuladtmydts.this.AV53error = GXv_char4[0] ;
         obtvalformuladtmydts.this.AV88topeLiqDLog = GXv_char3[0] ;
         if ( AV86diasTopeLiqDCalculado == 0 )
         {
            AV36LiqDCalculado = (byte)(0) ;
            AV60LiqDLog += httpContext.getMessage( "_error1_", "") + GXutil.trim( AV53error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV60LiqDLog = httpContext.getMessage( "Inicializa cantidad en ", "") + GXutil.trim( GXutil.str( AV8Cantidad, 6, 0)) + httpContext.getMessage( " resultado de la acumulación de los valores del concepto ", "") + GXutil.trim( AV96diasSacConCodigo) + httpContext.getMessage( " de todos los periodos ", "") ;
         if ( true )
         {
            if ( AV89sumarAdelantoDeVacaciones )
            {
               GXt_char2 = AV84adelVacMesProxConCodigo ;
               GXt_char1 = AV84adelVacMesProxConCodigo ;
               GXv_char4[0] = GXt_char1 ;
               new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
               obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
               AV84adelVacMesProxConCodigo = GXt_char2 ;
               GXt_char2 = AV68adelanVacTLiqCod ;
               GXt_char1 = AV68adelanVacTLiqCod ;
               GXv_char4[0] = GXt_char1 ;
               new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
               obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
               AV68adelanVacTLiqCod = GXt_char2 ;
               GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal7[0] = AV85adelVacMesProxLiqDCanti ;
               GXv_boolean10[0] = false ;
               GXv_int6[0] = (short)(0) ;
               GXv_int5[0] = AV87adelVacMesProxLiqDCalculado ;
               GXv_boolean9[0] = false ;
               GXv_char4[0] = AV92adelVacMesProxError ;
               new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV98LiqRelNro, AV13LegNumero, AV84adelVacMesProxConCodigo, AV97ConceptoTipo, AV11Fecha, AV29LiqPeriodo, "", AV91ProcesoLiquidacion, true, false, AV68adelanVacTLiqCod, true, "", GXv_decimal8, GXv_decimal7, GXv_boolean10, GXv_int6, GXv_int5, GXv_boolean9, GXv_char4) ;
               obtvalformuladtmydts.this.AV85adelVacMesProxLiqDCanti = GXv_decimal7[0] ;
               obtvalformuladtmydts.this.AV87adelVacMesProxLiqDCalculado = GXv_int5[0] ;
               obtvalformuladtmydts.this.AV92adelVacMesProxError = GXv_char4[0] ;
               if ( AV87adelVacMesProxLiqDCalculado == 0 )
               {
                  AV36LiqDCalculado = (byte)(0) ;
                  AV53error = GXutil.trim( AV92adelVacMesProxError) ;
                  AV60LiqDLog += ". " + GXutil.trim( AV53error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85adelVacMesProxLiqDCanti)==0) )
               {
                  AV60LiqDLog += httpContext.getMessage( "Le agrega ", "") + GXutil.trim( GXutil.str( AV85adelVacMesProxLiqDCanti, 14, 2)) + httpContext.getMessage( " días por adelanto de vacaciones de mes próximo", "") ;
                  AV8Cantidad = (int)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV8Cantidad).add(AV85adelVacMesProxLiqDCanti))) ;
               }
               GXt_char2 = AV94adelVacMesActualConCodigo ;
               GXt_char1 = AV94adelVacMesActualConCodigo ;
               GXv_char4[0] = GXt_char1 ;
               new web.concepto_adelantovacamesactual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
               obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
               AV94adelVacMesActualConCodigo = GXt_char2 ;
               GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal7[0] = AV85adelVacMesProxLiqDCanti ;
               GXv_boolean10[0] = false ;
               GXv_int6[0] = (short)(0) ;
               GXv_int5[0] = AV87adelVacMesProxLiqDCalculado ;
               GXv_boolean9[0] = false ;
               GXv_char4[0] = AV92adelVacMesProxError ;
               new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV98LiqRelNro, AV13LegNumero, AV94adelVacMesActualConCodigo, AV97ConceptoTipo, AV11Fecha, AV29LiqPeriodo, "", AV91ProcesoLiquidacion, true, false, AV68adelanVacTLiqCod, true, "", GXv_decimal8, GXv_decimal7, GXv_boolean10, GXv_int6, GXv_int5, GXv_boolean9, GXv_char4) ;
               obtvalformuladtmydts.this.AV85adelVacMesProxLiqDCanti = GXv_decimal7[0] ;
               obtvalformuladtmydts.this.AV87adelVacMesProxLiqDCalculado = GXv_int5[0] ;
               obtvalformuladtmydts.this.AV92adelVacMesProxError = GXv_char4[0] ;
               if ( AV87adelVacMesProxLiqDCalculado == 0 )
               {
                  AV36LiqDCalculado = (byte)(0) ;
                  AV53error = GXutil.trim( AV92adelVacMesProxError) ;
                  AV60LiqDLog += ". " + GXutil.trim( AV53error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85adelVacMesProxLiqDCanti)==0) )
               {
                  AV60LiqDLog += httpContext.getMessage( "Le agrega ", "") + GXutil.trim( GXutil.str( AV85adelVacMesProxLiqDCanti, 14, 2)) + httpContext.getMessage( " días por adelanto de vacaciones", "") ;
                  AV8Cantidad = (int)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV8Cantidad).add(AV85adelVacMesProxLiqDCanti))) ;
               }
            }
         }
         GXv_char4[0] = AV67TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, GXv_char4) ;
         obtvalformuladtmydts.this.AV67TLiqCod = GXv_char4[0] ;
         GXt_char2 = AV73sacTLiqCod ;
         GXt_char1 = AV73sacTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
         obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
         AV73sacTLiqCod = GXt_char2 ;
         if ( GXutil.strcmp(AV67TLiqCod, AV73sacTLiqCod) == 0 )
         {
            AV83palabra = "[dias_semestre]" ;
            GXv_int11[0] = AV23diasSemestre ;
            new web.obtvalformulacdmycds(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV13LegNumero, AV29LiqPeriodo, AV83palabra, AV29LiqPeriodo, false, GXv_int11) ;
            obtvalformuladtmydts.this.AV23diasSemestre = (short)((short)(GXv_int11[0])) ;
            if ( AV8Cantidad < AV23diasSemestre )
            {
               GXt_char2 = AV99mensualTLiqCod ;
               GXt_char1 = AV99mensualTLiqCod ;
               GXv_char4[0] = GXt_char1 ;
               new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               obtvalformuladtmydts.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV20CliCod, GXt_char1, GXv_char3) ;
               obtvalformuladtmydts.this.GXt_char2 = GXv_char3[0] ;
               AV99mensualTLiqCod = GXt_char2 ;
               GXv_boolean10[0] = AV26tieneLiquidacionEnPeriodo ;
               new web.tieneliquidacionenperiodo(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV13LegNumero, AV29LiqPeriodo, AV99mensualTLiqCod, GXv_boolean10) ;
               obtvalformuladtmydts.this.AV26tieneLiquidacionEnPeriodo = GXv_boolean10[0] ;
               if ( ! AV26tieneLiquidacionEnPeriodo )
               {
                  AV83palabra = "[dias_mes]" ;
                  GXv_int11[0] = AV81dias_mes ;
                  new web.obtvalformulacdmycds(remoteHandle, context).execute( AV20CliCod, AV14EmpCod, AV27LiqNro, AV13LegNumero, AV29LiqPeriodo, AV83palabra, AV29LiqPeriodo, false, GXv_int11) ;
                  obtvalformuladtmydts.this.AV81dias_mes = (short)((short)(GXv_int11[0])) ;
                  AV60LiqDLog += httpContext.getMessage( "Le agrega ", "") + GXutil.trim( GXutil.str( AV81dias_mes, 4, 0)) + httpContext.getMessage( " días por ser liquidación de adelanto de aguinaldo", "") ;
                  AV8Cantidad = (int)(AV8Cantidad+AV81dias_mes) ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = obtvalformuladtmydts.this.AV8Cantidad;
      this.aP13[0] = obtvalformuladtmydts.this.AV36LiqDCalculado;
      this.aP14[0] = obtvalformuladtmydts.this.AV53error;
      this.aP15[0] = obtvalformuladtmydts.this.AV60LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV53error = "" ;
      AV60LiqDLog = "" ;
      scmdbuf = "" ;
      P007E2_A6LegNumero = new int[1] ;
      P007E2_A1EmpCod = new short[1] ;
      P007E2_A3CliCod = new int[1] ;
      P007E2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P007E2_A1583LegMegCodigo = new String[] {""} ;
      P007E2_n1583LegMegCodigo = new boolean[] {false} ;
      P007E2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P007E2_n244LegFecEgreso = new boolean[] {false} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      AV15LegFecIngreso = GXutil.nullDate() ;
      AV31MegCodigo = "" ;
      AV30LegFecEgreso = GXutil.nullDate() ;
      AV21diasTrabajadosMes = "" ;
      AV22diasTrabajadosSemestre = "" ;
      AV41parmValue = "" ;
      AV104Pgmname = "" ;
      AV100legModTra = "" ;
      AV96diasSacConCodigo = "" ;
      AV88topeLiqDLog = "" ;
      AV84adelVacMesProxConCodigo = "" ;
      AV68adelanVacTLiqCod = "" ;
      AV97ConceptoTipo = "" ;
      AV11Fecha = GXutil.nullDate() ;
      AV85adelVacMesProxLiqDCanti = DecimalUtil.ZERO ;
      AV92adelVacMesProxError = "" ;
      AV94adelVacMesActualConCodigo = "" ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_int6 = new short[1] ;
      GXv_int5 = new byte[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV67TLiqCod = "" ;
      AV73sacTLiqCod = "" ;
      AV83palabra = "" ;
      AV99mensualTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_int11 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtvalformuladtmydts__default(),
         new Object[] {
             new Object[] {
            P007E2_A6LegNumero, P007E2_A1EmpCod, P007E2_A3CliCod, P007E2_A245LegFecIngreso, P007E2_A1583LegMegCodigo, P007E2_n1583LegMegCodigo, P007E2_A244LegFecEgreso, P007E2_n244LegFecEgreso
            }
         }
      );
      AV104Pgmname = "ObtValFormulaDTMyDTS" ;
      /* GeneXus formulas. */
      AV104Pgmname = "ObtValFormulaDTMyDTS" ;
      Gx_err = (short)(0) ;
   }

   private byte AV36LiqDCalculado ;
   private byte AV42LegClase ;
   private byte AV86diasTopeLiqDCalculado ;
   private byte AV87adelVacMesProxLiqDCalculado ;
   private byte GXv_int5[] ;
   private short AV14EmpCod ;
   private short A1EmpCod ;
   private short AV43horasDia ;
   private short GXv_int6[] ;
   private short AV23diasSemestre ;
   private short AV81dias_mes ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV27LiqNro ;
   private int AV98LiqRelNro ;
   private int AV13LegNumero ;
   private int AV8Cantidad ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int GXv_int11[] ;
   private java.math.BigDecimal AV85adelVacMesProxLiqDCanti ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV9Param ;
   private String AV91ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A1583LegMegCodigo ;
   private String AV31MegCodigo ;
   private String AV21diasTrabajadosMes ;
   private String AV22diasTrabajadosSemestre ;
   private String AV104Pgmname ;
   private String AV100legModTra ;
   private String AV96diasSacConCodigo ;
   private String AV84adelVacMesProxConCodigo ;
   private String AV68adelanVacTLiqCod ;
   private String AV97ConceptoTipo ;
   private String AV94adelVacMesActualConCodigo ;
   private String AV67TLiqCod ;
   private String AV73sacTLiqCod ;
   private String AV83palabra ;
   private String AV99mensualTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV29LiqPeriodo ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date AV15LegFecIngreso ;
   private java.util.Date AV30LegFecEgreso ;
   private java.util.Date AV11Fecha ;
   private boolean AV39restarLicencias ;
   private boolean AV46restarFeriados ;
   private boolean AV89sumarAdelantoDeVacaciones ;
   private boolean AV90insertandoConceptos ;
   private boolean n1583LegMegCodigo ;
   private boolean n244LegFecEgreso ;
   private boolean AV38todosLosMeses30 ;
   private boolean returnInSub ;
   private boolean GXv_boolean9[] ;
   private boolean AV26tieneLiquidacionEnPeriodo ;
   private boolean GXv_boolean10[] ;
   private String AV60LiqDLog ;
   private String AV41parmValue ;
   private String AV88topeLiqDLog ;
   private String AV53error ;
   private String AV92adelVacMesProxError ;
   private String[] aP15 ;
   private int[] aP12 ;
   private byte[] aP13 ;
   private String[] aP14 ;
   private IDataStoreProvider pr_default ;
   private int[] P007E2_A6LegNumero ;
   private short[] P007E2_A1EmpCod ;
   private int[] P007E2_A3CliCod ;
   private java.util.Date[] P007E2_A245LegFecIngreso ;
   private String[] P007E2_A1583LegMegCodigo ;
   private boolean[] P007E2_n1583LegMegCodigo ;
   private java.util.Date[] P007E2_A244LegFecEgreso ;
   private boolean[] P007E2_n244LegFecEgreso ;
}

final  class obtvalformuladtmydts__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007E2", "SELECT LegNumero, EmpCod, CliCod, LegFecIngreso, LegMegCodigo, LegFecEgreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               return;
      }
   }

}

