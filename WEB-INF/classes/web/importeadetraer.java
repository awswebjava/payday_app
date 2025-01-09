package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importeadetraer extends GXProcedure
{
   public importeadetraer( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importeadetraer.class ), "" );
   }

   public importeadetraer( int remoteHandle ,
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
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             short[] aP11 ,
                             String[] aP12 )
   {
      importeadetraer.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        byte[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        short[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             short[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      importeadetraer.this.AV10CliCod = aP0;
      importeadetraer.this.AV17EmpCod = aP1;
      importeadetraer.this.AV18LiqNro = aP2;
      importeadetraer.this.AV60LiqRelNro = aP3;
      importeadetraer.this.AV19LegNumero = aP4;
      importeadetraer.this.AV11LiqPeriodo = aP5;
      importeadetraer.this.AV53ProcesoLiquidacion = aP6;
      importeadetraer.this.AV54insertandoConceptos = aP7;
      importeadetraer.this.aP8 = aP8;
      importeadetraer.this.aP9 = aP9;
      importeadetraer.this.aP10 = aP10;
      importeadetraer.this.aP11 = aP11;
      importeadetraer.this.aP12 = aP12;
      importeadetraer.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20LiqDCalculado = (byte)(1) ;
      GXv_char1[0] = AV47MprCod ;
      new web.getlegajomodalidad(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV19LegNumero, GXv_char1) ;
      importeadetraer.this.AV47MprCod = GXv_char1[0] ;
      GXv_boolean2[0] = AV48MprNoDetrae ;
      new web.getmodalidadnodetrae(remoteHandle, context).execute( AV47MprCod, GXv_boolean2) ;
      importeadetraer.this.AV48MprNoDetrae = GXv_boolean2[0] ;
      if ( AV48MprNoDetrae )
      {
         AV46LiqDLog = httpContext.getMessage( "Se inicializa con valor cero al tener configurada la modalidad ", "") + AV47MprCod + httpContext.getMessage( " en \"no realizar detracción\"", "") ;
      }
      else
      {
         AV9OpeCliId = "[importe_a_detraer_default]" ;
         GXv_char1[0] = AV12OpeCliValor ;
         GXv_char3[0] = AV61auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV10CliCod, AV9OpeCliId, AV11LiqPeriodo, AV53ProcesoLiquidacion, GXv_char1, GXv_char3) ;
         importeadetraer.this.AV12OpeCliValor = GXv_char1[0] ;
         importeadetraer.this.AV61auxError = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV61auxError)==0) )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = AV61auxError ;
            AV46LiqDLog = AV23error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13totalImportes = CommonUtil.decimalVal( AV12OpeCliValor, ".") ;
         GXv_int4[0] = AV15dias_mes ;
         new web.diasmes(remoteHandle, context).execute( AV10CliCod, AV11LiqPeriodo, GXv_int4) ;
         importeadetraer.this.AV15dias_mes = GXv_int4[0] ;
         GXv_int4[0] = AV14dias_trabajados_mes ;
         GXv_char3[0] = AV56diasTrabMesError ;
         GXv_int5[0] = AV57diasTrabMesLiqDCalculado ;
         GXv_char1[0] = AV55diasTrabMesLiqDLog ;
         new web.diastrabmesparabaseimp(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV11LiqPeriodo, AV15dias_mes, AV53ProcesoLiquidacion, AV54insertandoConceptos, GXv_int4, GXv_char3, GXv_int5, GXv_char1) ;
         importeadetraer.this.AV14dias_trabajados_mes = GXv_int4[0] ;
         importeadetraer.this.AV56diasTrabMesError = GXv_char3[0] ;
         importeadetraer.this.AV57diasTrabMesLiqDCalculado = GXv_int5[0] ;
         importeadetraer.this.AV55diasTrabMesLiqDLog = GXv_char1[0] ;
         if ( AV57diasTrabMesLiqDCalculado == 0 )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = AV56diasTrabMesError ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV46LiqDLog += AV55diasTrabMesLiqDLog ;
         GXt_char6 = AV37DescuentoAdelanVacConCodigo ;
         GXt_char7 = AV37DescuentoAdelanVacConCodigo ;
         GXv_char3[0] = GXt_char7 ;
         new web.concepto_vacaciones_descu_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         importeadetraer.this.GXt_char7 = GXv_char3[0] ;
         GXv_char1[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char7, GXv_char1) ;
         importeadetraer.this.GXt_char6 = GXv_char1[0] ;
         AV37DescuentoAdelanVacConCodigo = GXt_char6 ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(AV38AdelanDesVacCanti) ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int5[0] = AV39adelanDesVac_LiqDCalculado ;
         new web.getliqdcantidad(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV37DescuentoAdelanVacConCodigo, GXv_decimal8, GXv_boolean2, GXv_int5) ;
         importeadetraer.this.AV38AdelanDesVacCanti = (short)(DecimalUtil.decToDouble(GXv_decimal8[0])) ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV39adelanDesVac_LiqDCalculado = GXv_int5[0] ;
         if ( ( AV33existe ) && ( AV39adelanDesVac_LiqDCalculado == 0 ) )
         {
            AV23error = httpContext.getMessage( "Falta calcular días de descuento de adelanto de vacaciones", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&error ", "")+GXutil.trim( AV23error)+httpContext.getMessage( " &DescuentoAdelanVacConCodigo ", "")+GXutil.trim( AV37DescuentoAdelanVacConCodigo)) ;
            AV20LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14dias_trabajados_mes = (short)(AV14dias_trabajados_mes-AV38AdelanDesVacCanti) ;
         if ( AV15dias_mes == 0 )
         {
            AV23error = httpContext.getMessage( "Días del mes en cero al calcular descuento por adelanto de vacaciones", "") ;
            AV20LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char7 = AV50BasicoConCodigo ;
         GXv_char3[0] = GXt_char7 ;
         new web.concepto_basico_segunclase(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV19LegNumero, GXv_char3) ;
         importeadetraer.this.GXt_char7 = GXv_char3[0] ;
         AV50BasicoConCodigo = GXt_char7 ;
         GXv_decimal8[0] = AV49BasicoLiqDImpCalcu ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int5[0] = AV51basicoLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV50BasicoConCodigo, AV53ProcesoLiquidacion, AV54insertandoConceptos, GXv_decimal8, GXv_boolean2, GXv_int5) ;
         importeadetraer.this.AV49BasicoLiqDImpCalcu = GXv_decimal8[0] ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV51basicoLiqDCalculado = GXv_int5[0] ;
         if ( ( AV33existe ) && ( AV51basicoLiqDCalculado == 0 ) )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = httpContext.getMessage( "Falta calcular sueldo básico", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49BasicoLiqDImpCalcu)==0) )
         {
            AV8Importes = (AV13totalImportes.divide(DecimalUtil.doubleToDec(AV15dias_mes), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV14dias_trabajados_mes)) ;
            if ( AV15dias_mes != AV14dias_trabajados_mes )
            {
               AV46LiqDLog = httpContext.getMessage( "Inicializa el valor con el importe proporcional a los días trabajados ", "") + GXutil.trim( GXutil.str( AV8Importes, 14, 2)) + ". (" + GXutil.trim( GXutil.str( AV13totalImportes, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV15dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV14dias_trabajados_mes, 4, 0)) ;
            }
            else
            {
               AV46LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV8Importes, 14, 2)) ;
            }
            AV40baseImportes = AV8Importes ;
            AV41cantidadCalculada = AV14dias_trabajados_mes ;
         }
         GXt_char7 = AV22SACConCodigo ;
         GXt_char6 = AV22SACConCodigo ;
         GXv_char3[0] = GXt_char6 ;
         new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         importeadetraer.this.GXt_char6 = GXv_char3[0] ;
         GXv_char1[0] = GXt_char7 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char6, GXv_char1) ;
         importeadetraer.this.GXt_char7 = GXv_char1[0] ;
         AV22SACConCodigo = GXt_char7 ;
         GXv_decimal8[0] = AV21SACLiqDImpCalcu ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int5[0] = AV45aux_LiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV22SACConCodigo, AV53ProcesoLiquidacion, AV54insertandoConceptos, GXv_decimal8, GXv_boolean2, GXv_int5) ;
         importeadetraer.this.AV21SACLiqDImpCalcu = GXv_decimal8[0] ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV45aux_LiqDCalculado = GXv_int5[0] ;
         if ( ( AV45aux_LiqDCalculado == 0 ) && ( AV33existe ) )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = httpContext.getMessage( "Falta calcular SAC", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV21SACLiqDImpCalcu)==0) )
         {
            AV24importeSAC = AV13totalImportes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
            AV8Importes = AV8Importes.add(AV24importeSAC) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49BasicoLiqDImpCalcu)==0) )
            {
               AV46LiqDLog += httpContext.getMessage( ". Le agrega valor ", "") + GXutil.trim( GXutil.str( AV24importeSAC, 14, 2)) + httpContext.getMessage( " por SAC. (", "") + GXutil.trim( GXutil.str( AV13totalImportes, 14, 2)) + " / 2)" ;
            }
            else
            {
               AV46LiqDLog += httpContext.getMessage( "Inicializa con valor ", "") + GXutil.trim( GXutil.str( AV24importeSAC, 14, 2)) + httpContext.getMessage( " por SAC. (", "") + GXutil.trim( GXutil.str( AV13totalImportes, 14, 2)) + " / 2)" ;
            }
            AV40baseImportes = AV40baseImportes.add(AV24importeSAC) ;
            GXt_int9 = AV41cantidadCalculada ;
            GXv_int4[0] = GXt_int9 ;
            new web.dias_semestre_default(remoteHandle, context).execute( AV10CliCod, GXv_int4) ;
            importeadetraer.this.GXt_int9 = GXv_int4[0] ;
            AV41cantidadCalculada = (short)(AV41cantidadCalculada+(GXt_int9)) ;
         }
         GXt_char7 = AV25SACProporConCodigo ;
         GXt_char6 = AV25SACProporConCodigo ;
         GXv_char3[0] = GXt_char6 ;
         new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         importeadetraer.this.GXt_char6 = GXv_char3[0] ;
         GXv_char1[0] = GXt_char7 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char6, GXv_char1) ;
         importeadetraer.this.GXt_char7 = GXv_char1[0] ;
         AV25SACProporConCodigo = GXt_char7 ;
         GXv_decimal8[0] = AV26SACProporLiqDImpCalcu ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int5[0] = AV45aux_LiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV25SACProporConCodigo, AV53ProcesoLiquidacion, AV54insertandoConceptos, GXv_decimal8, GXv_boolean2, GXv_int5) ;
         importeadetraer.this.AV26SACProporLiqDImpCalcu = GXv_decimal8[0] ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV45aux_LiqDCalculado = GXv_int5[0] ;
         if ( ( AV45aux_LiqDCalculado == 0 ) && ( AV33existe ) )
         {
            AV23error = httpContext.getMessage( "Falta calcular SAC Proporcional", "") ;
            AV20LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26SACProporLiqDImpCalcu)==0) )
         {
            AV28mitad = AV13totalImportes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
            AV16palabra = "[dias_semestre]" ;
            GXv_int10[0] = AV29dias_semestre ;
            new web.obtvalformulacdmycds(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV11LiqPeriodo, AV16palabra, AV11LiqPeriodo, false, GXv_int10) ;
            importeadetraer.this.AV29dias_semestre = (short)((short)(GXv_int10[0])) ;
            AV16palabra = "[dias_remunerados_semestre]" ;
            GXv_int10[0] = AV30dias_remunerados_semestre ;
            GXv_int5[0] = AV45aux_LiqDCalculado ;
            GXv_char3[0] = AV23error ;
            GXv_char1[0] = "" ;
            new web.obtvalformuladtmydts(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV60LiqRelNro, AV19LegNumero, AV16palabra, AV11LiqPeriodo, false, false, true, AV53ProcesoLiquidacion, AV54insertandoConceptos, GXv_int10, GXv_int5, GXv_char3, GXv_char1) ;
            importeadetraer.this.AV30dias_remunerados_semestre = (short)((short)(GXv_int10[0])) ;
            importeadetraer.this.AV45aux_LiqDCalculado = GXv_int5[0] ;
            importeadetraer.this.AV23error = GXv_char3[0] ;
            if ( AV45aux_LiqDCalculado == 0 )
            {
               AV20LiqDCalculado = (byte)(0) ;
               if ( (GXutil.strcmp("", AV23error)==0) )
               {
                  AV23error = httpContext.getMessage( "Falta calcular días remunerados en el semestre", "") ;
               }
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV29dias_semestre == 0 )
            {
               AV23error = httpContext.getMessage( "Días del semestre en cero al calcular sac proporcional", "") ;
               AV20LiqDCalculado = (byte)(0) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV27importeSACPropor = (AV28mitad.divide(DecimalUtil.doubleToDec(AV29dias_semestre), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV30dias_remunerados_semestre)) ;
            AV8Importes = AV8Importes.add(AV27importeSACPropor) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49BasicoLiqDImpCalcu)==0) )
            {
               AV46LiqDLog += httpContext.getMessage( ". Le agrega valor ", "") + GXutil.trim( GXutil.str( AV27importeSACPropor, 14, 2)) + httpContext.getMessage( " por SAC Proporcional. ", "") + "( " + GXutil.trim( GXutil.str( AV28mitad, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV29dias_semestre, 4, 0)) + " ) * " + GXutil.trim( GXutil.str( AV30dias_remunerados_semestre, 4, 0)) ;
            }
            else
            {
               AV46LiqDLog += httpContext.getMessage( "Inicializa con valor ", "") + GXutil.trim( GXutil.str( AV27importeSACPropor, 14, 2)) + httpContext.getMessage( " por SAC Proporcional. ", "") + "( " + GXutil.trim( GXutil.str( AV28mitad, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV29dias_semestre, 4, 0)) + " ) * " + GXutil.trim( GXutil.str( AV30dias_remunerados_semestre, 4, 0)) ;
            }
            AV40baseImportes = AV40baseImportes.add(AV27importeSACPropor) ;
            AV41cantidadCalculada = (short)(AV41cantidadCalculada+AV30dias_remunerados_semestre) ;
         }
         GXt_char7 = AV58SubTipoConCod1 ;
         GXv_char3[0] = GXt_char7 ;
         new web.subtipovacaciones(remoteHandle, context).execute( GXv_char3) ;
         importeadetraer.this.GXt_char7 = GXv_char3[0] ;
         AV58SubTipoConCod1 = GXt_char7 ;
         GXt_char7 = AV59SubTipoConCod2 ;
         GXv_char3[0] = GXt_char7 ;
         new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char3) ;
         importeadetraer.this.GXt_char7 = GXv_char3[0] ;
         AV59SubTipoConCod2 = GXt_char7 ;
         GXv_decimal8[0] = AV32AdelanVacLiqDImpCalcu ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(AV35dias_vacaciones) ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int4[0] = (short)(0) ;
         GXv_int5[0] = AV45aux_LiqDCalculado ;
         GXv_char3[0] = AV52adelVacError ;
         GXv_char1[0] = "" ;
         GXv_char12[0] = "" ;
         new web.getimporteycantiporclasysubclas(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV19LegNumero, AV18LiqNro, "", AV58SubTipoConCod1, AV59SubTipoConCod2, AV11LiqPeriodo, "Calculo", false, GXv_decimal8, GXv_decimal11, GXv_boolean2, GXv_int4, GXv_int5, GXv_char3, GXv_char1, GXv_char12) ;
         importeadetraer.this.AV32AdelanVacLiqDImpCalcu = GXv_decimal8[0] ;
         importeadetraer.this.AV35dias_vacaciones = (short)(DecimalUtil.decToDouble(GXv_decimal11[0])) ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV45aux_LiqDCalculado = GXv_int5[0] ;
         importeadetraer.this.AV52adelVacError = GXv_char3[0] ;
         if ( ( AV45aux_LiqDCalculado == 0 ) && ( AV33existe ) )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = httpContext.getMessage( "Falta calcular Adelanto de vacaciones", "") ;
            if ( ! (GXutil.strcmp("", AV52adelVacError)==0) )
            {
               AV23error += "(" + GXutil.trim( AV52adelVacError) + ")" ;
            }
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32AdelanVacLiqDImpCalcu)==0) )
         {
            AV34importeVacaciones = (AV13totalImportes.divide(DecimalUtil.doubleToDec(25), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV35dias_vacaciones)) ;
            AV8Importes = AV8Importes.add(AV34importeVacaciones) ;
            AV46LiqDLog += httpContext.getMessage( ". Le agrega valor ", "") + GXutil.trim( GXutil.str( AV34importeVacaciones, 14, 2)) + httpContext.getMessage( " por adelanto de vacaciones. (", "") + GXutil.trim( GXutil.str( AV13totalImportes, 14, 2)) + " / 25) * " + GXutil.trim( GXutil.str( AV35dias_vacaciones, 4, 0)) ;
            AV40baseImportes = AV40baseImportes.add(AV34importeVacaciones) ;
            AV41cantidadCalculada = (short)(AV41cantidadCalculada+AV35dias_vacaciones) ;
         }
         GXt_char7 = AV42vacNoGozadasConCodigo ;
         GXt_char6 = AV42vacNoGozadasConCodigo ;
         GXv_char12[0] = GXt_char6 ;
         new web.concepto_vacacionesnogozadas_codigoparam(remoteHandle, context).execute( GXv_char12) ;
         importeadetraer.this.GXt_char6 = GXv_char12[0] ;
         GXv_char3[0] = GXt_char7 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char6, GXv_char3) ;
         importeadetraer.this.GXt_char7 = GXv_char3[0] ;
         AV42vacNoGozadasConCodigo = GXt_char7 ;
         GXv_decimal11[0] = AV43vacNoGozLiqDImpCalcu ;
         GXv_decimal8[0] = AV44vacNoGozLiqDCanti ;
         GXv_boolean2[0] = AV33existe ;
         GXv_int5[0] = AV45aux_LiqDCalculado ;
         new web.getliqdimpcalcuycanti(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV18LiqNro, AV19LegNumero, AV42vacNoGozadasConCodigo, AV53ProcesoLiquidacion, GXv_decimal11, GXv_decimal8, GXv_boolean2, GXv_int5) ;
         importeadetraer.this.AV43vacNoGozLiqDImpCalcu = GXv_decimal11[0] ;
         importeadetraer.this.AV44vacNoGozLiqDCanti = GXv_decimal8[0] ;
         importeadetraer.this.AV33existe = GXv_boolean2[0] ;
         importeadetraer.this.AV45aux_LiqDCalculado = GXv_int5[0] ;
         if ( ( AV45aux_LiqDCalculado == 0 ) && ( AV33existe ) )
         {
            AV20LiqDCalculado = (byte)(0) ;
            AV23error = httpContext.getMessage( "Falta calcular Vacaciones no gozadas", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43vacNoGozLiqDImpCalcu)==0) )
         {
            AV34importeVacaciones = (AV13totalImportes.divide(DecimalUtil.doubleToDec(25), 18, java.math.RoundingMode.DOWN)).multiply(AV44vacNoGozLiqDCanti) ;
            AV8Importes = AV8Importes.add(AV34importeVacaciones) ;
            AV46LiqDLog += httpContext.getMessage( ". Le agrega valor ", "") + GXutil.trim( GXutil.str( AV34importeVacaciones, 14, 2)) + httpContext.getMessage( " por vacaciones no gozadas. (", "") + GXutil.trim( GXutil.str( AV13totalImportes, 14, 2)) + " / 25) * " + GXutil.trim( GXutil.str( AV44vacNoGozLiqDCanti, 14, 2)) ;
            AV40baseImportes = AV40baseImportes.add(AV34importeVacaciones) ;
            AV41cantidadCalculada = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV41cantidadCalculada).add(AV44vacNoGozLiqDCanti))) ;
         }
         AV36origIimporteADetraer = AV8Importes ;
         GXv_decimal11[0] = AV8Importes ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         new web.reducirporparcial(remoteHandle, context).execute( AV10CliCod, AV17EmpCod, AV19LegNumero, AV11LiqPeriodo, AV36origIimporteADetraer, GXv_decimal11, GXv_decimal8, GXv_decimal13) ;
         importeadetraer.this.AV8Importes = GXv_decimal11[0] ;
         if ( DecimalUtil.compareTo(AV36origIimporteADetraer, AV8Importes) != 0 )
         {
            AV46LiqDLog += httpContext.getMessage( ". Reduce valor a ", "") + GXutil.trim( GXutil.str( AV8Importes, 14, 2)) + httpContext.getMessage( " por jornada parcial.", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = importeadetraer.this.AV8Importes;
      this.aP9[0] = importeadetraer.this.AV20LiqDCalculado;
      this.aP10[0] = importeadetraer.this.AV40baseImportes;
      this.aP11[0] = importeadetraer.this.AV41cantidadCalculada;
      this.aP12[0] = importeadetraer.this.AV23error;
      this.aP13[0] = importeadetraer.this.AV46LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Importes = DecimalUtil.ZERO ;
      AV40baseImportes = DecimalUtil.ZERO ;
      AV23error = "" ;
      AV46LiqDLog = "" ;
      AV47MprCod = "" ;
      AV9OpeCliId = "" ;
      AV12OpeCliValor = "" ;
      AV61auxError = "" ;
      AV13totalImportes = DecimalUtil.ZERO ;
      AV56diasTrabMesError = "" ;
      AV55diasTrabMesLiqDLog = "" ;
      AV37DescuentoAdelanVacConCodigo = "" ;
      AV64Pgmname = "" ;
      AV50BasicoConCodigo = "" ;
      AV49BasicoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV22SACConCodigo = "" ;
      AV21SACLiqDImpCalcu = DecimalUtil.ZERO ;
      AV24importeSAC = DecimalUtil.ZERO ;
      AV25SACProporConCodigo = "" ;
      AV26SACProporLiqDImpCalcu = DecimalUtil.ZERO ;
      AV28mitad = DecimalUtil.ZERO ;
      AV16palabra = "" ;
      GXv_int10 = new int[1] ;
      AV27importeSACPropor = DecimalUtil.ZERO ;
      AV58SubTipoConCod1 = "" ;
      AV59SubTipoConCod2 = "" ;
      AV32AdelanVacLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_int4 = new short[1] ;
      AV52adelVacError = "" ;
      GXv_char1 = new String[1] ;
      AV34importeVacaciones = DecimalUtil.ZERO ;
      AV42vacNoGozadasConCodigo = "" ;
      GXt_char7 = "" ;
      GXt_char6 = "" ;
      GXv_char12 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV43vacNoGozLiqDImpCalcu = DecimalUtil.ZERO ;
      AV44vacNoGozLiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean2 = new boolean[1] ;
      GXv_int5 = new byte[1] ;
      AV36origIimporteADetraer = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      AV64Pgmname = "importeADetraer" ;
      /* GeneXus formulas. */
      AV64Pgmname = "importeADetraer" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqDCalculado ;
   private byte AV57diasTrabMesLiqDCalculado ;
   private byte AV39adelanDesVac_LiqDCalculado ;
   private byte AV51basicoLiqDCalculado ;
   private byte AV45aux_LiqDCalculado ;
   private byte GXv_int5[] ;
   private short AV17EmpCod ;
   private short AV41cantidadCalculada ;
   private short AV15dias_mes ;
   private short AV14dias_trabajados_mes ;
   private short AV38AdelanDesVacCanti ;
   private short GXt_int9 ;
   private short AV29dias_semestre ;
   private short AV30dias_remunerados_semestre ;
   private short AV35dias_vacaciones ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV18LiqNro ;
   private int AV60LiqRelNro ;
   private int AV19LegNumero ;
   private int GXv_int10[] ;
   private java.math.BigDecimal AV8Importes ;
   private java.math.BigDecimal AV40baseImportes ;
   private java.math.BigDecimal AV13totalImportes ;
   private java.math.BigDecimal AV49BasicoLiqDImpCalcu ;
   private java.math.BigDecimal AV21SACLiqDImpCalcu ;
   private java.math.BigDecimal AV24importeSAC ;
   private java.math.BigDecimal AV26SACProporLiqDImpCalcu ;
   private java.math.BigDecimal AV28mitad ;
   private java.math.BigDecimal AV27importeSACPropor ;
   private java.math.BigDecimal AV32AdelanVacLiqDImpCalcu ;
   private java.math.BigDecimal AV34importeVacaciones ;
   private java.math.BigDecimal AV43vacNoGozLiqDImpCalcu ;
   private java.math.BigDecimal AV44vacNoGozLiqDCanti ;
   private java.math.BigDecimal AV36origIimporteADetraer ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String AV53ProcesoLiquidacion ;
   private String AV47MprCod ;
   private String AV9OpeCliId ;
   private String AV37DescuentoAdelanVacConCodigo ;
   private String AV64Pgmname ;
   private String AV50BasicoConCodigo ;
   private String AV22SACConCodigo ;
   private String AV25SACProporConCodigo ;
   private String AV16palabra ;
   private String AV58SubTipoConCod1 ;
   private String AV59SubTipoConCod2 ;
   private String GXv_char1[] ;
   private String AV42vacNoGozadasConCodigo ;
   private String GXt_char7 ;
   private String GXt_char6 ;
   private String GXv_char12[] ;
   private String GXv_char3[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV54insertandoConceptos ;
   private boolean AV48MprNoDetrae ;
   private boolean returnInSub ;
   private boolean AV33existe ;
   private boolean GXv_boolean2[] ;
   private String AV46LiqDLog ;
   private String AV12OpeCliValor ;
   private String AV55diasTrabMesLiqDLog ;
   private String AV23error ;
   private String AV61auxError ;
   private String AV56diasTrabMesError ;
   private String AV52adelVacError ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP8 ;
   private byte[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private short[] aP11 ;
   private String[] aP12 ;
}

