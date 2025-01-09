package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class previsualizarconceptopararemulicferhor extends GXProcedure
{
   public previsualizarconceptopararemulicferhor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( previsualizarconceptopararemulicferhor.class ), "" );
   }

   public previsualizarconceptopararemulicferhor( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           String aP4 ,
                                           java.util.Date aP5 ,
                                           String aP6 ,
                                           String aP7 ,
                                           boolean aP8 ,
                                           java.math.BigDecimal[] aP9 ,
                                           String[] aP10 ,
                                           java.math.BigDecimal[] aP11 ,
                                           String[] aP12 ,
                                           byte[] aP13 ,
                                           java.math.BigDecimal[] aP14 )
   {
      previsualizarconceptopararemulicferhor.this.aP15 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        String[] aP12 ,
                        byte[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        java.math.BigDecimal[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             java.math.BigDecimal[] aP15 )
   {
      previsualizarconceptopararemulicferhor.this.AV8CliCod = aP0;
      previsualizarconceptopararemulicferhor.this.AV12EmpCod = aP1;
      previsualizarconceptopararemulicferhor.this.AV34liqnro = aP2;
      previsualizarconceptopararemulicferhor.this.AV11LegNumero = aP3;
      previsualizarconceptopararemulicferhor.this.AV9ConCodigo = aP4;
      previsualizarconceptopararemulicferhor.this.AV13fecha = aP5;
      previsualizarconceptopararemulicferhor.this.AV51tipo_tarifa = aP6;
      previsualizarconceptopararemulicferhor.this.AV26ProcesoLiquidacion = aP7;
      previsualizarconceptopararemulicferhor.this.AV30horaNormalEs = aP8;
      previsualizarconceptopararemulicferhor.this.AV18Importes = aP9[0];
      this.aP9 = aP9;
      previsualizarconceptopararemulicferhor.this.AV19LiqDLog = aP10[0];
      this.aP10 = aP10;
      previsualizarconceptopararemulicferhor.this.aP11 = aP11;
      previsualizarconceptopararemulicferhor.this.aP12 = aP12;
      previsualizarconceptopararemulicferhor.this.aP13 = aP13;
      previsualizarconceptopararemulicferhor.this.aP14 = aP14;
      previsualizarconceptopararemulicferhor.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV32LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV10ConVigencia ;
      GXv_char2[0] = AV24ConFormula ;
      GXv_char3[0] = AV48ConDescrip ;
      new web.getconceptovigenciaformulaydesc(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, GXv_int1, GXv_char2, GXv_char3) ;
      previsualizarconceptopararemulicferhor.this.AV10ConVigencia = GXv_int1[0] ;
      previsualizarconceptopararemulicferhor.this.AV24ConFormula = GXv_char2[0] ;
      previsualizarconceptopararemulicferhor.this.AV48ConDescrip = GXv_char3[0] ;
      GXv_char3[0] = AV25horasNormalesConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
      previsualizarconceptopararemulicferhor.this.AV25horasNormalesConCodigo = GXv_char3[0] ;
      GXv_char3[0] = AV39sueldoConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
      previsualizarconceptopararemulicferhor.this.AV39sueldoConCodigo = GXv_char3[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, "1 "+GXutil.trim( localUtil.dtoc( AV13fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV9ConCodigo)+" ") ;
      if ( AV10ConVigencia == 1 )
      {
         GXv_decimal4[0] = AV14AgeCanti ;
         GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal6[0] = AV16AgeImporte ;
         GXv_boolean7[0] = AV17existe ;
         GXv_date8[0] = AV35AgeFecDes ;
         GXv_date9[0] = AV36AgeFecHas ;
         new web.getagendavalorenrango2(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV11LegNumero, AV9ConCodigo, AV13fecha, AV13fecha, (short)(0), false, GXv_decimal4, GXv_decimal5, GXv_decimal6, GXv_boolean7, GXv_date8, GXv_date9) ;
         previsualizarconceptopararemulicferhor.this.AV14AgeCanti = GXv_decimal4[0] ;
         previsualizarconceptopararemulicferhor.this.AV16AgeImporte = GXv_decimal6[0] ;
         previsualizarconceptopararemulicferhor.this.AV17existe = GXv_boolean7[0] ;
         previsualizarconceptopararemulicferhor.this.AV35AgeFecDes = GXv_date8[0] ;
         previsualizarconceptopararemulicferhor.this.AV36AgeFecHas = GXv_date9[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&existe ", "")+GXutil.trim( GXutil.booltostr( AV17existe))+httpContext.getMessage( " &AgeCanti ", "")+GXutil.trim( GXutil.str( AV14AgeCanti, 9, 2))+httpContext.getMessage( " &AgeImporte ", "")+GXutil.trim( GXutil.str( AV16AgeImporte, 14, 2))) ;
         if ( AV17existe )
         {
            if ( ( GXutil.strcmp(AV9ConCodigo, AV25horasNormalesConCodigo) == 0 ) && ( GXutil.strcmp(AV51tipo_tarifa, "H") == 0 ) )
            {
               if ( GXutil.dateCompare(GXutil.resetTime(AV35AgeFecDes), GXutil.resetTime(AV36AgeFecHas)) )
               {
                  AV37horasReales1Dia = AV14AgeCanti ;
               }
               AV38horasNormalesTotales = AV14AgeCanti ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&horasNormalesTotales ", "")+GXutil.trim( GXutil.str( AV38horasNormalesTotales, 9, 2))) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, "11") ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeImporte)==0) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, "12") ;
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeImporte)==0) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, "13") ;
                  AV18Importes = AV18Importes.add(AV16AgeImporte) ;
                  AV19LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV16AgeImporte, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV48ConDescrip) + ". " ;
               }
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, "14") ;
               if ( ! (GXutil.strcmp("", AV24ConFormula)==0) )
               {
                  GXv_boolean7[0] = false ;
                  GXv_char3[0] = "" ;
                  GXv_char2[0] = "" ;
                  GXv_char10[0] = "" ;
                  GXv_char11[0] = "" ;
                  GXv_decimal6[0] = AV22LiqDImpCalcu ;
                  GXv_boolean12[0] = false ;
                  GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean13[0] = false ;
                  GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean15[0] = false ;
                  GXv_char16[0] = "" ;
                  GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean18[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, AV24ConFormula, AV24ConFormula, AV12EmpCod, 0, 0, 0, AV11LegNumero, AV23nadaTLiqCod, AV13fecha, AV54Pgmname, "Calculo", true, AV14AgeCanti, AV27date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean7, GXv_char3, GXv_char2, GXv_char10, GXv_char11, GXv_decimal6, GXv_boolean12, GXv_decimal5, GXv_boolean13, GXv_decimal4, GXv_decimal14, GXv_boolean15, GXv_char16, GXv_decimal17, GXv_boolean18) ;
                  previsualizarconceptopararemulicferhor.this.AV22LiqDImpCalcu = GXv_decimal6[0] ;
               }
               else
               {
                  AV22LiqDImpCalcu = DecimalUtil.ZERO ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV22LiqDImpCalcu, 14, 2))) ;
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22LiqDImpCalcu)==0) )
               {
                  AV18Importes = AV18Importes.add(AV22LiqDImpCalcu) ;
                  AV19LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV22LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV48ConDescrip) + ". " ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "suma ", "")) ;
               }
            }
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "2 &ConCodigo ", "")+AV9ConCodigo+httpContext.getMessage( " &horasNormalesConCodigo ", "")+AV25horasNormalesConCodigo+httpContext.getMessage( " tipotarifa ", "")+GXutil.trim( AV51tipo_tarifa)) ;
            if ( ( GXutil.strcmp(AV9ConCodigo, AV25horasNormalesConCodigo) == 0 ) && ( GXutil.strcmp(AV51tipo_tarifa, "H") == 0 ) )
            {
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV14AgeCanti)==0) )
               {
                  GXv_decimal17[0] = AV14AgeCanti ;
                  new web.gethorasdiaparavacacionesjornal(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV11LegNumero, DecimalUtil.doubleToDec(0), GXv_decimal17) ;
                  previsualizarconceptopararemulicferhor.this.AV14AgeCanti = GXv_decimal17[0] ;
               }
               AV38horasNormalesTotales = AV14AgeCanti ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "3 &fecha", "")+GXutil.trim( localUtil.dtoc( AV13fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &horasNormalesTotales ", "")+GXutil.trim( GXutil.str( AV38horasNormalesTotales, 9, 2))) ;
               if ( ! (GXutil.strcmp("", AV24ConFormula)==0) )
               {
                  GXv_boolean18[0] = false ;
                  GXv_char16[0] = "" ;
                  GXv_char11[0] = "" ;
                  GXv_char10[0] = "" ;
                  GXv_char3[0] = "" ;
                  GXv_decimal17[0] = AV22LiqDImpCalcu ;
                  GXv_boolean15[0] = false ;
                  GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean13[0] = false ;
                  GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean12[0] = false ;
                  GXv_char2[0] = AV28resolverLiqDLog ;
                  GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean7[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, AV24ConFormula, AV24ConFormula, AV12EmpCod, 0, 0, 0, AV11LegNumero, AV23nadaTLiqCod, AV13fecha, AV54Pgmname, "Calculo", true, AV14AgeCanti, AV27date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean18, GXv_char16, GXv_char11, GXv_char10, GXv_char3, GXv_decimal17, GXv_boolean15, GXv_decimal14, GXv_boolean13, GXv_decimal6, GXv_decimal5, GXv_boolean12, GXv_char2, GXv_decimal4, GXv_boolean7) ;
                  previsualizarconceptopararemulicferhor.this.AV22LiqDImpCalcu = GXv_decimal17[0] ;
                  previsualizarconceptopararemulicferhor.this.AV28resolverLiqDLog = GXv_char2[0] ;
               }
               else
               {
                  AV22LiqDImpCalcu = DecimalUtil.ZERO ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV22LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &fecha ", "")+GXutil.trim( localUtil.dtoc( AV13fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22LiqDImpCalcu)==0) )
               {
                  AV18Importes = AV18Importes.add(AV22LiqDImpCalcu) ;
                  AV19LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV22LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV48ConDescrip) + ". " ;
               }
               else
               {
                  AV19LiqDLog += httpContext.getMessage( ". Omite ", "") + GXutil.trim( AV48ConDescrip) ;
                  if ( ! (GXutil.strcmp("", AV28resolverLiqDLog)==0) )
                  {
                     AV19LiqDLog += " (" + GXutil.trim( AV28resolverLiqDLog) + ")" ;
                  }
               }
            }
         }
      }
      else
      {
         GXv_char16[0] = AV41SubTipoConCod1 ;
         GXv_char11[0] = AV42SubTipoConCod2 ;
         new web.conceptogetsubtipos(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, GXv_char16, GXv_char11) ;
         previsualizarconceptopararemulicferhor.this.AV41SubTipoConCod1 = GXv_char16[0] ;
         previsualizarconceptopararemulicferhor.this.AV42SubTipoConCod2 = GXv_char11[0] ;
         GXv_boolean18[0] = AV43validar ;
         GXv_boolean15[0] = false ;
         GXv_char16[0] = AV44concondicion ;
         GXv_char11[0] = "" ;
         new web.validarconcepto2(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV34liqnro, AV11LegNumero, AV13fecha, false, AV41SubTipoConCod1, AV42SubTipoConCod2, false, AV9ConCodigo, false, AV24ConFormula, AV9ConCodigo, "", "", "", false, AV26ProcesoLiquidacion, false, GXv_boolean18, GXv_boolean15, GXv_char16, GXv_char11) ;
         previsualizarconceptopararemulicferhor.this.AV43validar = GXv_boolean18[0] ;
         previsualizarconceptopararemulicferhor.this.AV44concondicion = GXv_char16[0] ;
         if ( ! AV43validar )
         {
            AV19LiqDLog += httpContext.getMessage( ". Descarta ", "") + GXutil.trim( AV48ConDescrip) + httpContext.getMessage( " por no cumplir condicion \" ", "") + GXutil.trim( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV44concondicion), "")) + "\"" ;
         }
         else
         {
            if ( GXutil.strcmp(AV9ConCodigo, AV39sueldoConCodigo) == 0 )
            {
               GXt_int19 = (short)(DecimalUtil.decToDouble(AV29LiqDCanti)) ;
               GXv_int20[0] = GXt_int19 ;
               new web.diasmes(remoteHandle, context).execute( AV8CliCod, AV13fecha, GXv_int20) ;
               previsualizarconceptopararemulicferhor.this.GXt_int19 = GXv_int20[0] ;
               AV29LiqDCanti = DecimalUtil.doubleToDec(GXt_int19) ;
            }
            else
            {
               AV29LiqDCanti = DecimalUtil.doubleToDec(0) ;
            }
            if ( ! (GXutil.strcmp("", AV24ConFormula)==0) )
            {
               GXv_boolean18[0] = false ;
               GXv_char16[0] = AV33error ;
               GXv_char11[0] = "" ;
               GXv_char10[0] = "" ;
               GXv_char3[0] = "" ;
               GXv_decimal17[0] = AV22LiqDImpCalcu ;
               GXv_boolean15[0] = AV31dependenciasResueltas ;
               GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean13[0] = false ;
               GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean12[0] = false ;
               GXv_char2[0] = "" ;
               GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean7[0] = false ;
               new web.resolverformula(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, AV24ConFormula, AV24ConFormula, AV12EmpCod, AV34liqnro, 0, AV34liqnro, AV11LegNumero, AV23nadaTLiqCod, AV13fecha, AV54Pgmname, AV26ProcesoLiquidacion, true, AV29LiqDCanti, AV27date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean18, GXv_char16, GXv_char11, GXv_char10, GXv_char3, GXv_decimal17, GXv_boolean15, GXv_decimal14, GXv_boolean13, GXv_decimal6, GXv_decimal5, GXv_boolean12, GXv_char2, GXv_decimal4, GXv_boolean7) ;
               previsualizarconceptopararemulicferhor.this.AV33error = GXv_char16[0] ;
               previsualizarconceptopararemulicferhor.this.AV22LiqDImpCalcu = GXv_decimal17[0] ;
               previsualizarconceptopararemulicferhor.this.AV31dependenciasResueltas = GXv_boolean15[0] ;
            }
            else
            {
               AV31dependenciasResueltas = true ;
               AV22LiqDImpCalcu = DecimalUtil.ZERO ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&concodigo ", "")+GXutil.trim( AV9ConCodigo)+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV31dependenciasResueltas))) ;
            if ( ! AV31dependenciasResueltas )
            {
               AV32LiqDCalculado = (byte)(0) ;
               AV19LiqDLog = AV33error ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV19LiqDLog) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22LiqDImpCalcu)==0) )
            {
               AV18Importes = AV18Importes.add(AV22LiqDImpCalcu) ;
               AV19LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV22LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV48ConDescrip) + ". " ;
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV54Pgmname, httpContext.getMessage( "&LiqDLog ", "")+GXutil.trim( AV19LiqDLog)+httpContext.getMessage( " &Importes ", "")+GXutil.trim( GXutil.str( AV18Importes, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = previsualizarconceptopararemulicferhor.this.AV18Importes;
      this.aP10[0] = previsualizarconceptopararemulicferhor.this.AV19LiqDLog;
      this.aP11[0] = previsualizarconceptopararemulicferhor.this.AV14AgeCanti;
      this.aP12[0] = previsualizarconceptopararemulicferhor.this.AV33error;
      this.aP13[0] = previsualizarconceptopararemulicferhor.this.AV32LiqDCalculado;
      this.aP14[0] = previsualizarconceptopararemulicferhor.this.AV37horasReales1Dia;
      this.aP15[0] = previsualizarconceptopararemulicferhor.this.AV38horasNormalesTotales;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14AgeCanti = DecimalUtil.ZERO ;
      AV33error = "" ;
      AV37horasReales1Dia = DecimalUtil.ZERO ;
      AV38horasNormalesTotales = DecimalUtil.ZERO ;
      GXv_int1 = new byte[1] ;
      AV24ConFormula = "" ;
      AV48ConDescrip = "" ;
      AV25horasNormalesConCodigo = "" ;
      AV39sueldoConCodigo = "" ;
      AV54Pgmname = "" ;
      AV16AgeImporte = DecimalUtil.ZERO ;
      AV35AgeFecDes = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      AV36AgeFecHas = GXutil.nullDate() ;
      GXv_date9 = new java.util.Date[1] ;
      AV23nadaTLiqCod = "" ;
      AV27date = GXutil.nullDate() ;
      AV22LiqDImpCalcu = DecimalUtil.ZERO ;
      AV28resolverLiqDLog = "" ;
      AV41SubTipoConCod1 = "" ;
      AV42SubTipoConCod2 = "" ;
      AV44concondicion = "" ;
      AV29LiqDCanti = DecimalUtil.ZERO ;
      GXv_int20 = new short[1] ;
      GXv_boolean18 = new boolean[1] ;
      GXv_char16 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_boolean15 = new boolean[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_char2 = new String[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV54Pgmname = "previsualizarConceptoParaRemuLicFerHor" ;
      /* GeneXus formulas. */
      AV54Pgmname = "previsualizarConceptoParaRemuLicFerHor" ;
      Gx_err = (short)(0) ;
   }

   private byte AV32LiqDCalculado ;
   private byte AV10ConVigencia ;
   private byte GXv_int1[] ;
   private short AV12EmpCod ;
   private short GXt_int19 ;
   private short GXv_int20[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV34liqnro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV14AgeCanti ;
   private java.math.BigDecimal AV37horasReales1Dia ;
   private java.math.BigDecimal AV38horasNormalesTotales ;
   private java.math.BigDecimal AV16AgeImporte ;
   private java.math.BigDecimal AV22LiqDImpCalcu ;
   private java.math.BigDecimal AV29LiqDCanti ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV9ConCodigo ;
   private String AV51tipo_tarifa ;
   private String AV26ProcesoLiquidacion ;
   private String AV25horasNormalesConCodigo ;
   private String AV39sueldoConCodigo ;
   private String AV54Pgmname ;
   private String AV23nadaTLiqCod ;
   private String AV41SubTipoConCod1 ;
   private String AV42SubTipoConCod2 ;
   private String AV44concondicion ;
   private String GXv_char16[] ;
   private String GXv_char11[] ;
   private String GXv_char10[] ;
   private String GXv_char3[] ;
   private String GXv_char2[] ;
   private java.util.Date AV13fecha ;
   private java.util.Date AV35AgeFecDes ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date AV36AgeFecHas ;
   private java.util.Date GXv_date9[] ;
   private java.util.Date AV27date ;
   private boolean AV30horaNormalEs ;
   private boolean AV17existe ;
   private boolean AV43validar ;
   private boolean GXv_boolean18[] ;
   private boolean AV31dependenciasResueltas ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private String AV19LiqDLog ;
   private String AV24ConFormula ;
   private String AV28resolverLiqDLog ;
   private String AV33error ;
   private String AV48ConDescrip ;
   private java.math.BigDecimal[] aP15 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private String[] aP12 ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
}

