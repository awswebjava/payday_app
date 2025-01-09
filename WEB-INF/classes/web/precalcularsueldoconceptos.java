package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class precalcularsueldoconceptos extends GXProcedure
{
   public precalcularsueldoconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( precalcularsueldoconceptos.class ), "" );
   }

   public precalcularsueldoconceptos( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 ,
                                           short aP4 ,
                                           java.math.BigDecimal aP5 ,
                                           java.math.BigDecimal aP6 ,
                                           java.math.BigDecimal aP7 ,
                                           boolean aP8 ,
                                           boolean aP9 ,
                                           String aP10 ,
                                           String[] aP11 ,
                                           String[] aP12 )
   {
      precalcularsueldoconceptos.this.aP13 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        short aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        java.math.BigDecimal[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             short aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             java.math.BigDecimal[] aP13 )
   {
      precalcularsueldoconceptos.this.AV8CliCod = aP0;
      precalcularsueldoconceptos.this.AV28EmpCod = aP1;
      precalcularsueldoconceptos.this.AV15LegNumero = aP2;
      precalcularsueldoconceptos.this.AV9LegSuelFecha = aP3;
      precalcularsueldoconceptos.this.AV37LegSuelSec = aP4;
      precalcularsueldoconceptos.this.AV23parmImportes = aP5;
      precalcularsueldoconceptos.this.AV12base_imp_min = aP6;
      precalcularsueldoconceptos.this.AV11base_imp_max = aP7;
      precalcularsueldoconceptos.this.AV32parmLegLiqApo = aP8;
      precalcularsueldoconceptos.this.AV33parmLegJubilado = aP9;
      precalcularsueldoconceptos.this.AV34parmSinCod = aP10;
      precalcularsueldoconceptos.this.aP11 = aP11;
      precalcularsueldoconceptos.this.aP12 = aP12;
      precalcularsueldoconceptos.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV15LegNumero) )
      {
         AV16LegClase = (byte)(1) ;
         AV64LegModTra = "E" ;
      }
      else
      {
         GXv_int1[0] = AV16LegClase ;
         GXv_char2[0] = AV64LegModTra ;
         new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, GXv_int1, GXv_char2) ;
         precalcularsueldoconceptos.this.AV16LegClase = GXv_int1[0] ;
         precalcularsueldoconceptos.this.AV64LegModTra = GXv_char2[0] ;
      }
      AV38i = (short)(1) ;
      GXv_char2[0] = AV48sueldoConCodigo ;
      new web.concepto_basico_segunclase(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, GXv_char2) ;
      precalcularsueldoconceptos.this.AV48sueldoConCodigo = GXv_char2[0] ;
      GXv_int1[0] = AV62EmpTipoExp ;
      new web.getemptipoexp(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, GXv_int1) ;
      precalcularsueldoconceptos.this.AV62EmpTipoExp = GXv_int1[0] ;
      GXt_int3 = AV10mesDias ;
      GXv_int4[0] = GXt_int3 ;
      new web.diasmes(remoteHandle, context).execute( AV8CliCod, AV9LegSuelFecha, GXv_int4) ;
      precalcularsueldoconceptos.this.GXt_int3 = GXv_int4[0] ;
      AV10mesDias = GXt_int3 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "&LegSuelSec ", "")+GXutil.trim( GXutil.str( AV37LegSuelSec, 4, 0))+httpContext.getMessage( " &parmSueldoImportes ", "")+GXutil.trim( GXutil.str( AV57parmSueldoImportes, 14, 2))) ;
      if ( ! (0==AV37LegSuelSec) )
      {
         new web.setearlegsuelcalcom(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec, false) ;
         new web.deletelegajosueldoconceptos(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec) ;
         GXt_char5 = AV49sueldoConDescrip ;
         GXv_char2[0] = GXt_char5 ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV48sueldoConCodigo, GXv_char2) ;
         precalcularsueldoconceptos.this.GXt_char5 = GXv_char2[0] ;
         AV49sueldoConDescrip = GXt_char5 ;
         GXt_char5 = AV50suelConFormula ;
         GXv_char2[0] = GXt_char5 ;
         new web.getformulaconcepto(remoteHandle, context).execute( AV8CliCod, AV48sueldoConCodigo, GXv_char2) ;
         precalcularsueldoconceptos.this.GXt_char5 = GXv_char2[0] ;
         AV50suelConFormula = GXt_char5 ;
         GXt_char5 = AV52mensualTLiqCod ;
         GXt_char6 = AV52mensualTLiqCod ;
         GXv_char2[0] = GXt_char6 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char2) ;
         precalcularsueldoconceptos.this.GXt_char6 = GXv_char2[0] ;
         GXv_char7[0] = GXt_char5 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char6, GXv_char7) ;
         precalcularsueldoconceptos.this.GXt_char5 = GXv_char7[0] ;
         AV52mensualTLiqCod = GXt_char5 ;
         GXv_decimal8[0] = AV53sueldoImportes ;
         GXv_decimal9[0] = AV54baseImportes ;
         GXv_int4[0] = (short)(0) ;
         GXv_char7[0] = AV26auxError ;
         GXv_char2[0] = AV25auxLiqDLog ;
         GXv_int1[0] = (byte)(0) ;
         new web.sueldo_basico(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, 0, 0, AV9LegSuelFecha, AV23parmImportes, AV48sueldoConCodigo, AV52mensualTLiqCod, httpContext.getMessage( "TOTAL", ""), false, false, DecimalUtil.doubleToDec(AV10mesDias), false, "Calculo", false, false, true, GXv_decimal8, GXv_decimal9, GXv_int4, GXv_char7, GXv_char2, GXv_int1) ;
         precalcularsueldoconceptos.this.AV53sueldoImportes = GXv_decimal8[0] ;
         precalcularsueldoconceptos.this.AV54baseImportes = GXv_decimal9[0] ;
         precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
         precalcularsueldoconceptos.this.AV25auxLiqDLog = GXv_char2[0] ;
         if ( ! (GXutil.strcmp("", AV26auxError)==0) )
         {
            AV14error = GXutil.trim( AV26auxError) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV56diferencia = AV23parmImportes.subtract(AV53sueldoImportes) ;
         if ( AV56diferencia.doubleValue() < 0 )
         {
            AV56diferencia = AV56diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
         }
         if ( AV56diferencia.doubleValue() > 1 )
         {
            AV14error = httpContext.getMessage( "Error al calcular sueldo básico, el importe ingresado ", "") + GXutil.trim( GXutil.str( AV23parmImportes, 14, 2)) + httpContext.getMessage( " difiere del importe recuperado ", "") + GXutil.trim( GXutil.str( AV53sueldoImportes, 14, 2)) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_char7[0] = AV26auxError ;
         new web.new_legajo_sueldo_conceptos(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec, AV48sueldoConCodigo, AV48sueldoConCodigo, AV62EmpTipoExp, AV49sueldoConDescrip, AV38i, DecimalUtil.doubleToDec(AV10mesDias), AV54baseImportes, AV53sueldoImportes, AV50suelConFormula, 0, AV25auxLiqDLog, GXv_char7) ;
         precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
         /* Execute user subroutine: 'DEVOLVER ERROR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( DecimalUtil.compareTo(AV23parmImportes, AV11base_imp_max) > 0 )
      {
         AV17LiqDLog = httpContext.getMessage( "Base imponible máxima: ", "") + GXutil.trim( GXutil.str( AV11base_imp_max, 14, 2)) ;
      }
      else
      {
         if ( DecimalUtil.compareTo(AV23parmImportes, AV12base_imp_min) < 0 )
         {
            AV17LiqDLog = httpContext.getMessage( "Base imponible mínima: ", "") + GXutil.trim( GXutil.str( AV12base_imp_min, 14, 2)) ;
         }
         else
         {
            AV17LiqDLog = httpContext.getMessage( "Sueldo: ", "") + GXutil.trim( GXutil.str( AV23parmImportes, 14, 2)) ;
         }
      }
      /* Using cursor P02D42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P02D42_A37TipoConCod[0] ;
         A150ConHabilitado = P02D42_A150ConHabilitado[0] ;
         A740SubTDescuLey = P02D42_A740SubTDescuLey[0] ;
         A3CliCod = P02D42_A3CliCod[0] ;
         A26ConCodigo = P02D42_A26ConCodigo[0] ;
         A38SubTipoConCod1 = P02D42_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P02D42_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = P02D42_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P02D42_n39SubTipoConCod2[0] ;
         A148ConFormula = P02D42_A148ConFormula[0] ;
         n148ConFormula = P02D42_n148ConFormula[0] ;
         A41ConDescrip = P02D42_A41ConDescrip[0] ;
         A510ConOrdEjec = P02D42_A510ConOrdEjec[0] ;
         A740SubTDescuLey = P02D42_A740SubTDescuLey[0] ;
         AV51validarLiqDLog = "" ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "Recorre descuento de ley ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV15LegNumero, 8, 0))) ;
         if ( (0==AV15LegNumero) )
         {
            GXv_char7[0] = AV51validarLiqDLog ;
            GXv_int4[0] = (short)((byte)((AV18entra)?1:0)) ;
            new web.validarcondicionesdesculey(remoteHandle, context).execute( AV8CliCod, A26ConCodigo, AV32parmLegLiqApo, AV33parmLegJubilado, AV34parmSinCod, GXv_char7, GXv_int4) ;
            precalcularsueldoconceptos.this.AV51validarLiqDLog = GXv_char7[0] ;
            precalcularsueldoconceptos.this.AV18entra = (boolean)((GXv_int4[0]==0)?false:true) ;
         }
         else
         {
            GXv_boolean10[0] = AV18entra ;
            GXv_boolean11[0] = false ;
            GXv_char7[0] = AV30ConCondicion ;
            GXv_char2[0] = AV51validarLiqDLog ;
            new web.validarconcepto2(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, 0, AV15LegNumero, AV9LegSuelFecha, false, A38SubTipoConCod1, A39SubTipoConCod2, false, A26ConCodigo, false, A148ConFormula, A41ConDescrip, "", "", "", false, "Calculo", false, GXv_boolean10, GXv_boolean11, GXv_char7, GXv_char2) ;
            precalcularsueldoconceptos.this.AV18entra = GXv_boolean10[0] ;
            precalcularsueldoconceptos.this.AV30ConCondicion = GXv_char7[0] ;
            precalcularsueldoconceptos.this.AV51validarLiqDLog = GXv_char2[0] ;
         }
         if ( AV18entra )
         {
            if ( ! (GXutil.strcmp("", AV17LiqDLog)==0) )
            {
               AV17LiqDLog += ". " ;
            }
            GXv_char7[0] = AV19idOperando ;
            GXv_char2[0] = "" ;
            GXv_boolean11[0] = AV20resolverDeUna ;
            new web.formulaaidcalculo(remoteHandle, context).execute( AV8CliCod, A148ConFormula, GXv_char7, GXv_char2, GXv_boolean11) ;
            precalcularsueldoconceptos.this.AV19idOperando = GXv_char7[0] ;
            precalcularsueldoconceptos.this.AV20resolverDeUna = GXv_boolean11[0] ;
            if ( AV20resolverDeUna )
            {
               if ( ( GXutil.strcmp(AV19idOperando, "[jubilacion]") == 0 ) || ( GXutil.strcmp(AV19idOperando, "[obra_social]") == 0 ) || ( GXutil.strcmp(AV19idOperando, "[ley_19032]") == 0 ) || ( GXutil.strcmp(AV19idOperando, "[cuota_sindical]") == 0 ) )
               {
                  GXv_char7[0] = "" ;
                  GXv_char2[0] = AV21auxOpeCliId ;
                  GXv_boolean11[0] = AV22cuotaSindicalEs ;
                  new web.getdesculeydatos(remoteHandle, context).execute( AV8CliCod, AV19idOperando, GXv_char7, GXv_char2, GXv_boolean11) ;
                  precalcularsueldoconceptos.this.AV21auxOpeCliId = GXv_char2[0] ;
                  precalcularsueldoconceptos.this.AV22cuotaSindicalEs = GXv_boolean11[0] ;
                  AV17LiqDLog += GXutil.trim( A41ConDescrip) ;
                  GXv_decimal9[0] = AV27LiqDImpCalcu ;
                  GXv_decimal8[0] = AV40LegSuelConValU ;
                  GXv_char7[0] = AV26auxError ;
                  GXv_char2[0] = AV25auxLiqDLog ;
                  GXv_int1[0] = AV24auxLiqDCalculado ;
                  GXv_decimal12[0] = AV39LegSuelConCnt ;
                  new web.descuento_de_ley(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, 0, AV15LegNumero, AV16LegClase, AV64LegModTra, AV34parmSinCod, A26ConCodigo, AV9LegSuelFecha, "Calculo", false, "", AV21auxOpeCliId, AV22cuotaSindicalEs, AV23parmImportes, AV10mesDias, AV10mesDias, AV11base_imp_max, AV12base_imp_min, (byte)(AV10mesDias), GXv_decimal9, GXv_decimal8, GXv_char7, GXv_char2, GXv_int1, GXv_decimal12) ;
                  precalcularsueldoconceptos.this.AV27LiqDImpCalcu = GXv_decimal9[0] ;
                  precalcularsueldoconceptos.this.AV40LegSuelConValU = GXv_decimal8[0] ;
                  precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
                  precalcularsueldoconceptos.this.AV25auxLiqDLog = GXv_char2[0] ;
                  precalcularsueldoconceptos.this.AV24auxLiqDCalculado = GXv_int1[0] ;
                  precalcularsueldoconceptos.this.AV39LegSuelConCnt = GXv_decimal12[0] ;
                  /* Execute user subroutine: 'DEVOLVER ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "&descuentoImportes ", "")+GXutil.trim( GXutil.str( AV29descuentoImportes, 14, 3))+httpContext.getMessage( " suma &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV27LiqDImpCalcu, 14, 2))+httpContext.getMessage( " log ", "")+AV25auxLiqDLog) ;
                  AV29descuentoImportes = GXutil.roundDecimal( AV29descuentoImportes.add(AV27LiqDImpCalcu), 2) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "!!!queda &descuentoImportes ", "")+GXutil.trim( GXutil.str( AV29descuentoImportes, 14, 3))) ;
                  AV17LiqDLog += ":  " + GXutil.trim( GXutil.str( AV27LiqDImpCalcu, 14, 2)) ;
                  if ( ! (0==AV37LegSuelSec) )
                  {
                     AV38i = (short)(AV38i+1) ;
                     GXv_char7[0] = AV26auxError ;
                     new web.new_legajo_sueldo_conceptos(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec, A26ConCodigo, AV48sueldoConCodigo, AV62EmpTipoExp, A41ConDescrip, AV38i, AV39LegSuelConCnt, AV40LegSuelConValU, AV27LiqDImpCalcu, A148ConFormula, A510ConOrdEjec, AV25auxLiqDLog, GXv_char7) ;
                     precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
                     /* Execute user subroutine: 'DEVOLVER ERROR' */
                     S111 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV55ConOrdEjec = A510ConOrdEjec ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV19idOperando, "[obra_social_adherentes]") == 0 )
                  {
                  }
                  else
                  {
                  }
               }
            }
            else
            {
            }
            if ( false )
            {
               if ( ! (GXutil.strcmp("", AV51validarLiqDLog)==0) )
               {
                  AV17LiqDLog += " (" + GXutil.trim( AV51validarLiqDLog) + ")" ;
               }
            }
         }
         else
         {
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ! (0==AV37LegSuelSec) )
      {
         GXt_char6 = AV42redondeoConCodigo ;
         GXt_char5 = AV42redondeoConCodigo ;
         GXv_char7[0] = GXt_char5 ;
         new web.concepto_redondeo_codigoparam(remoteHandle, context).execute( GXv_char7) ;
         precalcularsueldoconceptos.this.GXt_char5 = GXv_char7[0] ;
         GXv_char2[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char5, GXv_char2) ;
         precalcularsueldoconceptos.this.GXt_char6 = GXv_char2[0] ;
         AV42redondeoConCodigo = GXt_char6 ;
         GXv_char7[0] = AV43SubTipoConCod1 ;
         GXv_char2[0] = AV44SubTipoConCod2 ;
         new web.conceptogetsubtipos(remoteHandle, context).execute( AV8CliCod, AV42redondeoConCodigo, GXv_char7, GXv_char2) ;
         precalcularsueldoconceptos.this.AV43SubTipoConCod1 = GXv_char7[0] ;
         precalcularsueldoconceptos.this.AV44SubTipoConCod2 = GXv_char2[0] ;
         GXt_char6 = AV45redondeoConFormula ;
         GXv_char7[0] = GXt_char6 ;
         new web.getformulaconcepto(remoteHandle, context).execute( AV8CliCod, AV42redondeoConCodigo, GXv_char7) ;
         precalcularsueldoconceptos.this.GXt_char6 = GXv_char7[0] ;
         AV45redondeoConFormula = GXt_char6 ;
         GXt_char6 = AV46redondeoConDescrip ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV42redondeoConCodigo, GXv_char7) ;
         precalcularsueldoconceptos.this.GXt_char6 = GXv_char7[0] ;
         AV46redondeoConDescrip = GXt_char6 ;
         GXv_boolean11[0] = AV18entra ;
         GXv_boolean10[0] = false ;
         GXv_char7[0] = AV30ConCondicion ;
         GXv_char2[0] = AV51validarLiqDLog ;
         new web.validarconcepto2(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, 0, AV15LegNumero, AV9LegSuelFecha, false, AV43SubTipoConCod1, AV44SubTipoConCod2, false, AV42redondeoConCodigo, false, AV45redondeoConFormula, AV46redondeoConDescrip, "", "", "", false, "Calculo", false, GXv_boolean11, GXv_boolean10, GXv_char7, GXv_char2) ;
         precalcularsueldoconceptos.this.AV18entra = GXv_boolean11[0] ;
         precalcularsueldoconceptos.this.AV30ConCondicion = GXv_char7[0] ;
         precalcularsueldoconceptos.this.AV51validarLiqDLog = GXv_char2[0] ;
         if ( AV18entra )
         {
            AV41netoImportes = AV23parmImportes ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "antes ", "")+GXutil.trim( GXutil.str( AV41netoImportes, 14, 2))) ;
            AV41netoImportes = AV41netoImportes.subtract(AV29descuentoImportes) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "&descuentoPreCalc ", "")+GXutil.trim( GXutil.str( AV58descuentoPreCalc, 14, 2))+httpContext.getMessage( " &descuentoImportes ", "")+GXutil.trim( GXutil.str( AV29descuentoImportes, 14, 3))+httpContext.getMessage( " &netoImportes ", "")+GXutil.trim( GXutil.str( AV41netoImportes, 14, 2))) ;
            GXv_decimal12[0] = AV27LiqDImpCalcu ;
            GXv_char7[0] = AV26auxError ;
            GXv_char2[0] = AV25auxLiqDLog ;
            GXv_int1[0] = AV24auxLiqDCalculado ;
            new web.redondeo(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, 0, AV15LegNumero, AV42redondeoConCodigo, "Calculo", AV41netoImportes, GXv_decimal12, GXv_char7, GXv_char2, GXv_int1) ;
            precalcularsueldoconceptos.this.AV27LiqDImpCalcu = GXv_decimal12[0] ;
            precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
            precalcularsueldoconceptos.this.AV25auxLiqDLog = GXv_char2[0] ;
            precalcularsueldoconceptos.this.AV24auxLiqDCalculado = GXv_int1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "redondeo error", "")+GXutil.trim( AV26auxError)) ;
            /* Execute user subroutine: 'DEVOLVER ERROR' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV55ConOrdEjec = (long)(AV55ConOrdEjec+1) ;
            AV47redondeoConOrdEjec = AV55ConOrdEjec ;
            AV38i = (short)(AV38i+1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "da de alta redondeo", "")) ;
            GXv_char7[0] = AV26auxError ;
            new web.new_legajo_sueldo_conceptos(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec, AV42redondeoConCodigo, AV48sueldoConCodigo, AV62EmpTipoExp, AV46redondeoConDescrip, AV38i, DecimalUtil.doubleToDec(1), AV41netoImportes, AV27LiqDImpCalcu, AV45redondeoConFormula, AV47redondeoConOrdEjec, AV25auxLiqDLog, GXv_char7) ;
            precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
            /* Execute user subroutine: 'DEVOLVER ERROR' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "dió de alta redondeo", "")) ;
            AV29descuentoImportes = AV29descuentoImportes.subtract(AV27LiqDImpCalcu) ;
         }
         else
         {
            AV17LiqDLog += httpContext.getMessage( ". No calcula redondeo (", "") + GXutil.trim( AV51validarLiqDLog) + ")" ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "No calcula redondeo (", "")+GXutil.trim( AV51validarLiqDLog)+")") ;
         }
         new web.setearlegsuelcalcom(remoteHandle, context).execute( AV8CliCod, AV28EmpCod, AV15LegNumero, AV37LegSuelSec, true) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'DEVOLVER ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV26auxError)==0) )
      {
         AV14error = GXutil.trim( AV26auxError) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV67Pgmname, httpContext.getMessage( "devuelve error ", "")+AV14error) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'CONFIGURACION CERO' Routine */
      returnInSub = false ;
      GXv_boolean11[0] = AV59ConMostrarPos ;
      GXv_boolean10[0] = AV60ConErrorSiCero ;
      new web.getdatosconceptocero(remoteHandle, context).execute( AV8CliCod, AV61auxConCodigo, GXv_boolean11, GXv_boolean10) ;
      precalcularsueldoconceptos.this.AV59ConMostrarPos = GXv_boolean11[0] ;
      precalcularsueldoconceptos.this.AV60ConErrorSiCero = GXv_boolean10[0] ;
      GXv_char7[0] = AV26auxError ;
      GXv_boolean11[0] = false ;
      GXv_boolean10[0] = false ;
      GXv_int1[0] = AV63MostrarConcepto ;
      new web.logicaerrorymostrarsicero(remoteHandle, context).execute( AV27LiqDImpCalcu, AV59ConMostrarPos, AV60ConErrorSiCero, AV61auxConCodigo, AV48sueldoConCodigo, AV62EmpTipoExp, DecimalUtil.doubleToDec(1), GXv_char7, GXv_boolean11, GXv_boolean10, GXv_int1) ;
      precalcularsueldoconceptos.this.AV26auxError = GXv_char7[0] ;
      precalcularsueldoconceptos.this.AV63MostrarConcepto = GXv_int1[0] ;
      /* Execute user subroutine: 'DEVOLVER ERROR' */
      S111 ();
      if (returnInSub) return;
   }

   protected void cleanup( )
   {
      this.aP11[0] = precalcularsueldoconceptos.this.AV14error;
      this.aP12[0] = precalcularsueldoconceptos.this.AV17LiqDLog;
      this.aP13[0] = precalcularsueldoconceptos.this.AV29descuentoImportes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      AV17LiqDLog = "" ;
      AV29descuentoImportes = DecimalUtil.ZERO ;
      AV64LegModTra = "" ;
      AV48sueldoConCodigo = "" ;
      AV67Pgmname = "" ;
      AV57parmSueldoImportes = DecimalUtil.ZERO ;
      AV49sueldoConDescrip = "" ;
      AV50suelConFormula = "" ;
      AV52mensualTLiqCod = "" ;
      AV53sueldoImportes = DecimalUtil.ZERO ;
      AV54baseImportes = DecimalUtil.ZERO ;
      AV26auxError = "" ;
      AV25auxLiqDLog = "" ;
      AV56diferencia = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02D42_A37TipoConCod = new String[] {""} ;
      P02D42_A150ConHabilitado = new boolean[] {false} ;
      P02D42_A740SubTDescuLey = new boolean[] {false} ;
      P02D42_A3CliCod = new int[1] ;
      P02D42_A26ConCodigo = new String[] {""} ;
      P02D42_A38SubTipoConCod1 = new String[] {""} ;
      P02D42_n38SubTipoConCod1 = new boolean[] {false} ;
      P02D42_A39SubTipoConCod2 = new String[] {""} ;
      P02D42_n39SubTipoConCod2 = new boolean[] {false} ;
      P02D42_A148ConFormula = new String[] {""} ;
      P02D42_n148ConFormula = new boolean[] {false} ;
      P02D42_A41ConDescrip = new String[] {""} ;
      P02D42_A510ConOrdEjec = new long[1] ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      AV51validarLiqDLog = "" ;
      GXv_int4 = new short[1] ;
      AV30ConCondicion = "" ;
      AV19idOperando = "" ;
      AV21auxOpeCliId = "" ;
      AV27LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      AV40LegSuelConValU = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV39LegSuelConCnt = DecimalUtil.ZERO ;
      AV42redondeoConCodigo = "" ;
      GXt_char5 = "" ;
      AV43SubTipoConCod1 = "" ;
      AV44SubTipoConCod2 = "" ;
      AV45redondeoConFormula = "" ;
      AV46redondeoConDescrip = "" ;
      GXt_char6 = "" ;
      AV41netoImportes = DecimalUtil.ZERO ;
      AV58descuentoPreCalc = DecimalUtil.ZERO ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      AV61auxConCodigo = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_int1 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.precalcularsueldoconceptos__default(),
         new Object[] {
             new Object[] {
            P02D42_A37TipoConCod, P02D42_A150ConHabilitado, P02D42_A740SubTDescuLey, P02D42_A3CliCod, P02D42_A26ConCodigo, P02D42_A38SubTipoConCod1, P02D42_n38SubTipoConCod1, P02D42_A39SubTipoConCod2, P02D42_n39SubTipoConCod2, P02D42_A148ConFormula,
            P02D42_n148ConFormula, P02D42_A41ConDescrip, P02D42_A510ConOrdEjec
            }
         }
      );
      AV67Pgmname = "preCalcularSueldoConceptos" ;
      /* GeneXus formulas. */
      AV67Pgmname = "preCalcularSueldoConceptos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16LegClase ;
   private byte AV62EmpTipoExp ;
   private byte AV24auxLiqDCalculado ;
   private byte AV63MostrarConcepto ;
   private byte GXv_int1[] ;
   private short AV28EmpCod ;
   private short AV37LegSuelSec ;
   private short AV38i ;
   private short AV10mesDias ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LegNumero ;
   private int A3CliCod ;
   private long A510ConOrdEjec ;
   private long AV55ConOrdEjec ;
   private long AV47redondeoConOrdEjec ;
   private java.math.BigDecimal AV23parmImportes ;
   private java.math.BigDecimal AV12base_imp_min ;
   private java.math.BigDecimal AV11base_imp_max ;
   private java.math.BigDecimal AV29descuentoImportes ;
   private java.math.BigDecimal AV57parmSueldoImportes ;
   private java.math.BigDecimal AV53sueldoImportes ;
   private java.math.BigDecimal AV54baseImportes ;
   private java.math.BigDecimal AV56diferencia ;
   private java.math.BigDecimal AV27LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal AV40LegSuelConValU ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal AV39LegSuelConCnt ;
   private java.math.BigDecimal AV41netoImportes ;
   private java.math.BigDecimal AV58descuentoPreCalc ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private String AV34parmSinCod ;
   private String AV64LegModTra ;
   private String AV48sueldoConCodigo ;
   private String AV67Pgmname ;
   private String AV52mensualTLiqCod ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String AV30ConCondicion ;
   private String AV19idOperando ;
   private String AV21auxOpeCliId ;
   private String AV42redondeoConCodigo ;
   private String GXt_char5 ;
   private String AV43SubTipoConCod1 ;
   private String AV44SubTipoConCod2 ;
   private String GXt_char6 ;
   private String GXv_char2[] ;
   private String AV61auxConCodigo ;
   private String GXv_char7[] ;
   private java.util.Date AV9LegSuelFecha ;
   private boolean AV32parmLegLiqApo ;
   private boolean AV33parmLegJubilado ;
   private boolean returnInSub ;
   private boolean A150ConHabilitado ;
   private boolean A740SubTDescuLey ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n148ConFormula ;
   private boolean AV18entra ;
   private boolean AV20resolverDeUna ;
   private boolean AV22cuotaSindicalEs ;
   private boolean AV59ConMostrarPos ;
   private boolean AV60ConErrorSiCero ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean10[] ;
   private String AV17LiqDLog ;
   private String AV50suelConFormula ;
   private String AV25auxLiqDLog ;
   private String A148ConFormula ;
   private String AV51validarLiqDLog ;
   private String AV45redondeoConFormula ;
   private String AV14error ;
   private String AV49sueldoConDescrip ;
   private String AV26auxError ;
   private String A41ConDescrip ;
   private String AV46redondeoConDescrip ;
   private java.math.BigDecimal[] aP13 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private String[] P02D42_A37TipoConCod ;
   private boolean[] P02D42_A150ConHabilitado ;
   private boolean[] P02D42_A740SubTDescuLey ;
   private int[] P02D42_A3CliCod ;
   private String[] P02D42_A26ConCodigo ;
   private String[] P02D42_A38SubTipoConCod1 ;
   private boolean[] P02D42_n38SubTipoConCod1 ;
   private String[] P02D42_A39SubTipoConCod2 ;
   private boolean[] P02D42_n39SubTipoConCod2 ;
   private String[] P02D42_A148ConFormula ;
   private boolean[] P02D42_n148ConFormula ;
   private String[] P02D42_A41ConDescrip ;
   private long[] P02D42_A510ConOrdEjec ;
}

final  class precalcularsueldoconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02D42", "SELECT T1.TipoConCod, T1.ConHabilitado, T2.SubTDescuLey, T1.CliCod, T1.ConCodigo, T1.SubTipoConCod1, T1.SubTipoConCod2, T1.ConFormula, T1.ConDescrip, T1.ConOrdEjec FROM (Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) WHERE (T1.CliCod = ?) AND (T2.SubTDescuLey = TRUE) AND (T1.ConHabilitado = TRUE) ORDER BY T1.CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((long[]) buf[12])[0] = rslt.getLong(10);
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
               return;
      }
   }

}

