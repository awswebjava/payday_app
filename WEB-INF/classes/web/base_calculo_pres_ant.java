package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class base_calculo_pres_ant extends GXProcedure
{
   public base_calculo_pres_ant( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( base_calculo_pres_ant.class ), "" );
   }

   public base_calculo_pres_ant( int remoteHandle ,
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
                             String aP7 ,
                             String aP8 ,
                             java.util.Date aP9 ,
                             java.math.BigDecimal aP10 ,
                             String aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 )
   {
      base_calculo_pres_ant.this.aP16 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        java.util.Date aP9 ,
                        java.math.BigDecimal aP10 ,
                        String aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        byte[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             java.util.Date aP9 ,
                             java.math.BigDecimal aP10 ,
                             String aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      base_calculo_pres_ant.this.AV11CliCod = aP0;
      base_calculo_pres_ant.this.AV12EmpCod = aP1;
      base_calculo_pres_ant.this.AV13LiqNro = aP2;
      base_calculo_pres_ant.this.AV60LiqRelNro = aP3;
      base_calculo_pres_ant.this.AV14LegNumero = aP4;
      base_calculo_pres_ant.this.AV24LiqPeriodo = aP5;
      base_calculo_pres_ant.this.AV63tipo_tarifa = aP6;
      base_calculo_pres_ant.this.AV20que = aP7;
      base_calculo_pres_ant.this.AV51llamador = aP8;
      base_calculo_pres_ant.this.AV23desde_LiqPeriodo = aP9;
      base_calculo_pres_ant.this.AV25proporcionHabitualPorUnaje = aP10;
      base_calculo_pres_ant.this.AV28ProcesoLiquidacion = aP11;
      base_calculo_pres_ant.this.aP12 = aP12;
      base_calculo_pres_ant.this.aP13 = aP13;
      base_calculo_pres_ant.this.aP14 = aP14;
      base_calculo_pres_ant.this.aP15 = aP15;
      base_calculo_pres_ant.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34LiqDCalculado = (byte)(1) ;
      AV8desdeTipoConCod = "NRE_ARG" ;
      AV9hastaTipoConCod = "REM_ARG" ;
      GXv_char1[0] = AV10sueldoMensualConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      base_calculo_pres_ant.this.AV10sueldoMensualConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV40horasNormalesConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      base_calculo_pres_ant.this.AV40horasNormalesConCodigo = GXv_char1[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "&QUE ", "")+GXutil.trim( AV20que)) ;
      AV67GXLvl14 = (byte)(0) ;
      /* Using cursor P01NP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV14LegNumero), AV8desdeTipoConCod, AV9hastaTipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A464DTipoConCod = P01NP2_A464DTipoConCod[0] ;
         A6LegNumero = P01NP2_A6LegNumero[0] ;
         A31LiqNro = P01NP2_A31LiqNro[0] ;
         A1EmpCod = P01NP2_A1EmpCod[0] ;
         A3CliCod = P01NP2_A3CliCod[0] ;
         A394DConCodigo = P01NP2_A394DConCodigo[0] ;
         A275LiqDImpCalcu = P01NP2_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01NP2_n275LiqDImpCalcu[0] ;
         A507LiqDCalculado = P01NP2_A507LiqDCalculado[0] ;
         A504LiqDForOrig = P01NP2_A504LiqDForOrig[0] ;
         A393DConDescrip = P01NP2_A393DConDescrip[0] ;
         A468DSubTipoConCod1 = P01NP2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01NP2_n468DSubTipoConCod1[0] ;
         A269LiqDCanti = P01NP2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01NP2_n269LiqDCanti[0] ;
         A764LiqDImpReCalcu = P01NP2_A764LiqDImpReCalcu[0] ;
         A1219LiqDPlus = P01NP2_A1219LiqDPlus[0] ;
         A81LiqDSecuencial = P01NP2_A81LiqDSecuencial[0] ;
         AV67GXLvl14 = (byte)(1) ;
         AV15resolver = false ;
         AV16agregar = false ;
         AV17sinPlus = false ;
         AV56propAComp = false ;
         GXv_int2[0] = AV21es_base ;
         GXv_boolean3[0] = AV16agregar ;
         new web.calcular_es_base(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, AV20que, GXv_int2, GXv_boolean3) ;
         base_calculo_pres_ant.this.AV21es_base = GXv_int2[0] ;
         base_calculo_pres_ant.this.AV16agregar = GXv_boolean3[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agregar ", "")+GXutil.trim( GXutil.booltostr( AV16agregar))+httpContext.getMessage( " es_base ", "")+GXutil.trim( GXutil.str( AV21es_base, 1, 0))+httpContext.getMessage( " dconcodigo ", "")+A394DConCodigo) ;
         if ( AV16agregar )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agrega1", "")) ;
            GXv_boolean3[0] = AV16agregar ;
            GXv_boolean4[0] = false ;
            new web.validar_concepto_base(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, A394DConCodigo, AV23desde_LiqPeriodo, AV24LiqPeriodo, AV25proporcionHabitualPorUnaje, AV21es_base, AV63tipo_tarifa, GXv_boolean3, GXv_boolean4) ;
            base_calculo_pres_ant.this.AV16agregar = GXv_boolean3[0] ;
            if ( AV16agregar )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agrega2 &llamador ", "")+AV51llamador) ;
               if ( GXutil.strcmp(A394DConCodigo, AV10sueldoMensualConCodigo) == 0 )
               {
                  if ( GXutil.strcmp(AV51llamador, httpContext.getMessage( "base_calculo_os_diferencial", "")) == 0 )
                  {
                     GXv_boolean4[0] = AV52MprEsParcial ;
                     GXv_decimal5[0] = AV54horasSemanaNormal ;
                     GXv_decimal6[0] = AV53LegHorasSem ;
                     new web.reduceporparcialdeterminado(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, GXv_boolean4, GXv_decimal5, GXv_decimal6) ;
                     base_calculo_pres_ant.this.AV52MprEsParcial = GXv_boolean4[0] ;
                     base_calculo_pres_ant.this.AV54horasSemanaNormal = GXv_decimal5[0] ;
                     base_calculo_pres_ant.this.AV53LegHorasSem = GXv_decimal6[0] ;
                     if ( ! AV52MprEsParcial )
                     {
                        AV15resolver = true ;
                     }
                  }
                  else
                  {
                     GXt_char7 = AV49vacTLiqCod ;
                     GXt_char8 = AV49vacTLiqCod ;
                     GXv_char1[0] = GXt_char8 ;
                     new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char1) ;
                     base_calculo_pres_ant.this.GXt_char8 = GXv_char1[0] ;
                     GXv_char9[0] = GXt_char7 ;
                     new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char8, GXv_char9) ;
                     base_calculo_pres_ant.this.GXt_char7 = GXv_char9[0] ;
                     AV49vacTLiqCod = GXt_char7 ;
                     GXt_char8 = AV48TLiqCod ;
                     GXv_char9[0] = GXt_char8 ;
                     new web.gettipoliq(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, GXv_char9) ;
                     base_calculo_pres_ant.this.GXt_char8 = GXv_char9[0] ;
                     AV48TLiqCod = GXt_char8 ;
                     if ( GXutil.strcmp(AV48TLiqCod, AV49vacTLiqCod) == 0 )
                     {
                        AV15resolver = true ;
                     }
                     else
                     {
                        if ( ( A507LiqDCalculado == 1 ) && ( A275LiqDImpCalcu.doubleValue() == 0 ) )
                        {
                           AV15resolver = true ;
                        }
                        else
                        {
                           GXv_int2[0] = AV26EmpTipoExp ;
                           new web.getemptipoexp(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, GXv_int2) ;
                           base_calculo_pres_ant.this.AV26EmpTipoExp = GXv_int2[0] ;
                           if ( AV26EmpTipoExp == 1 )
                           {
                              AV15resolver = true ;
                           }
                           else
                           {
                           }
                        }
                     }
                  }
               }
               if ( AV15resolver )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agrega3", "")) ;
                  GXv_int10[0] = AV47diasMes ;
                  new web.diasmes(remoteHandle, context).execute( AV11CliCod, AV24LiqPeriodo, GXv_int10) ;
                  base_calculo_pres_ant.this.AV47diasMes = (byte)((byte)(GXv_int10[0])) ;
                  GXv_boolean4[0] = false ;
                  GXv_char9[0] = AV30auxError ;
                  GXv_char1[0] = "" ;
                  GXv_char11[0] = "" ;
                  GXv_char12[0] = "" ;
                  GXv_decimal6[0] = AV31LiqDImpCalcu ;
                  GXv_boolean3[0] = AV32dependenciasResueltas ;
                  GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean13[0] = false ;
                  GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_decimal15[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean16[0] = false ;
                  GXv_char17[0] = AV33auxLiqDLog ;
                  GXv_decimal18[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean19[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, A504LiqDForOrig, A504LiqDForOrig, AV12EmpCod, AV13LiqNro, AV60LiqRelNro, AV13LiqNro, AV14LegNumero, AV27nadaTLiqCod, AV24LiqPeriodo, AV66Pgmname, AV28ProcesoLiquidacion, true, DecimalUtil.doubleToDec(AV47diasMes), AV29date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean4, GXv_char9, GXv_char1, GXv_char11, GXv_char12, GXv_decimal6, GXv_boolean3, GXv_decimal5, GXv_boolean13, GXv_decimal14, GXv_decimal15, GXv_boolean16, GXv_char17, GXv_decimal18, GXv_boolean19) ;
                  base_calculo_pres_ant.this.AV30auxError = GXv_char9[0] ;
                  base_calculo_pres_ant.this.AV31LiqDImpCalcu = GXv_decimal6[0] ;
                  base_calculo_pres_ant.this.AV32dependenciasResueltas = GXv_boolean3[0] ;
                  base_calculo_pres_ant.this.AV33auxLiqDLog = GXv_char17[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV32dependenciasResueltas))+httpContext.getMessage( " &liqdimpcalcu ", "")+GXutil.trim( GXutil.str( AV31LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &auxError ", "")+GXutil.trim( AV30auxError)) ;
                  if ( ! AV32dependenciasResueltas || ! (GXutil.strcmp("", AV30auxError)==0) )
                  {
                     AV34LiqDCalculado = (byte)(0) ;
                     AV35error = AV30auxError ;
                     AV36LiqDLog = AV35error ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV36LiqDLog) ;
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  if ( A507LiqDCalculado == 0 )
                  {
                     AV34LiqDCalculado = (byte)(0) ;
                     AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
                     AV36LiqDLog = AV35error ;
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  if ( ( GXutil.strcmp(A394DConCodigo, AV40horasNormalesConCodigo) == 0 ) || ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 ) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV39horasNormalesTotales = AV39horasNormalesTotales.add(A269LiqDCanti) ;
                     if ( GXutil.strcmp(A394DConCodigo, AV40horasNormalesConCodigo) == 0 )
                     {
                        AV44sumoHorasNormales = true ;
                     }
                  }
                  AV31LiqDImpCalcu = A764LiqDImpReCalcu ;
                  if ( A1219LiqDPlus.doubleValue() > 0 )
                  {
                     AV31LiqDImpCalcu = AV31LiqDImpCalcu.divide(A1219LiqDPlus, 18, java.math.RoundingMode.DOWN) ;
                     AV17sinPlus = true ;
                  }
                  if ( GXutil.strcmp(A394DConCodigo, AV10sueldoMensualConCodigo) == 0 )
                  {
                     if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53LegHorasSem)==0) )
                     {
                        AV55porUnaje = AV54horasSemanaNormal.divide(AV53LegHorasSem, 18, java.math.RoundingMode.DOWN) ;
                        AV31LiqDImpCalcu = AV31LiqDImpCalcu.multiply(AV55porUnaje) ;
                        AV56propAComp = true ;
                     }
                  }
               }
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31LiqDImpCalcu)==0) )
               {
                  AV38Importes = AV38Importes.add(AV31LiqDImpCalcu) ;
                  AV36LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV31LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) + ". " ;
                  if ( AV17sinPlus )
                  {
                     AV36LiqDLog += httpContext.getMessage( " (sin plus)", "") ;
                  }
                  if ( AV56propAComp )
                  {
                     AV36LiqDLog += httpContext.getMessage( " (proporcionado a jornada completa)", "") ;
                  }
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV67GXLvl14 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "none", "")) ;
      }
      if ( GXutil.strcmp(AV63tipo_tarifa, "H") == 0 )
      {
         GXv_int2[0] = AV21es_base ;
         GXv_boolean19[0] = AV16agregar ;
         new web.calcular_es_base(remoteHandle, context).execute( AV11CliCod, AV40horasNormalesConCodigo, AV20que, GXv_int2, GXv_boolean19) ;
         base_calculo_pres_ant.this.AV21es_base = GXv_int2[0] ;
         base_calculo_pres_ant.this.AV16agregar = GXv_boolean19[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agregaxxxxxxxx ", "")+GXutil.trim( GXutil.booltostr( AV16agregar))) ;
         if ( AV16agregar )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agrega1x ", "")+GXutil.trim( AV40horasNormalesConCodigo)) ;
            GXv_boolean19[0] = AV16agregar ;
            GXv_boolean16[0] = false ;
            new web.validar_concepto_base(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, AV40horasNormalesConCodigo, AV23desde_LiqPeriodo, AV24LiqPeriodo, AV25proporcionHabitualPorUnaje, AV21es_base, AV63tipo_tarifa, GXv_boolean19, GXv_boolean16) ;
            base_calculo_pres_ant.this.AV16agregar = GXv_boolean19[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "agrega1x &agregar ", "")+GXutil.trim( GXutil.booltostr( AV16agregar))+httpContext.getMessage( " esbase ", "")+GXutil.trim( GXutil.str( AV21es_base, 1, 0))) ;
            if ( AV16agregar )
            {
               GXv_char17[0] = AV45ConFormula ;
               new web.getformulaconcepto(remoteHandle, context).execute( AV11CliCod, AV40horasNormalesConCodigo, GXv_char17) ;
               base_calculo_pres_ant.this.AV45ConFormula = GXv_char17[0] ;
               GXv_decimal18[0] = AV46diaCantHorasNormalesDia ;
               new web.gethorasdiaparavacacionesjornal(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, DecimalUtil.doubleToDec(0), GXv_decimal18) ;
               base_calculo_pres_ant.this.AV46diaCantHorasNormalesDia = GXv_decimal18[0] ;
               GXv_boolean19[0] = false ;
               GXv_char17[0] = AV30auxError ;
               GXv_char12[0] = "" ;
               GXv_char11[0] = "" ;
               GXv_char9[0] = "" ;
               GXv_decimal18[0] = AV31LiqDImpCalcu ;
               GXv_boolean16[0] = AV32dependenciasResueltas ;
               GXv_decimal15[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean13[0] = false ;
               GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean4[0] = false ;
               GXv_char1[0] = AV33auxLiqDLog ;
               GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean3[0] = false ;
               new web.resolverformula(remoteHandle, context).execute( AV11CliCod, AV40horasNormalesConCodigo, AV45ConFormula, AV45ConFormula, AV12EmpCod, AV13LiqNro, AV60LiqRelNro, AV13LiqNro, AV14LegNumero, AV27nadaTLiqCod, AV24LiqPeriodo, AV66Pgmname, AV28ProcesoLiquidacion, true, AV46diaCantHorasNormalesDia, AV29date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean19, GXv_char17, GXv_char12, GXv_char11, GXv_char9, GXv_decimal18, GXv_boolean16, GXv_decimal15, GXv_boolean13, GXv_decimal14, GXv_decimal6, GXv_boolean4, GXv_char1, GXv_decimal5, GXv_boolean3) ;
               base_calculo_pres_ant.this.AV30auxError = GXv_char17[0] ;
               base_calculo_pres_ant.this.AV31LiqDImpCalcu = GXv_decimal18[0] ;
               base_calculo_pres_ant.this.AV32dependenciasResueltas = GXv_boolean16[0] ;
               base_calculo_pres_ant.this.AV33auxLiqDLog = GXv_char1[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "&horasNormalesConCodigo ", "")+GXutil.trim( AV40horasNormalesConCodigo)+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV32dependenciasResueltas))) ;
               if ( ! AV32dependenciasResueltas )
               {
                  AV34LiqDCalculado = (byte)(0) ;
                  AV35error = AV30auxError ;
                  AV36LiqDLog = AV35error ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV66Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV36LiqDLog) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV39horasNormalesTotales = AV39horasNormalesTotales.add(AV46diaCantHorasNormalesDia) ;
               AV38Importes = AV38Importes.add(AV31LiqDImpCalcu) ;
               AV36LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV31LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de cálculo de horas normales", "") + ". " ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = base_calculo_pres_ant.this.AV38Importes;
      this.aP13[0] = base_calculo_pres_ant.this.AV39horasNormalesTotales;
      this.aP14[0] = base_calculo_pres_ant.this.AV34LiqDCalculado;
      this.aP15[0] = base_calculo_pres_ant.this.AV35error;
      this.aP16[0] = base_calculo_pres_ant.this.AV36LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV38Importes = DecimalUtil.ZERO ;
      AV39horasNormalesTotales = DecimalUtil.ZERO ;
      AV35error = "" ;
      AV36LiqDLog = "" ;
      AV8desdeTipoConCod = "" ;
      AV9hastaTipoConCod = "" ;
      AV10sueldoMensualConCodigo = "" ;
      AV40horasNormalesConCodigo = "" ;
      AV66Pgmname = "" ;
      scmdbuf = "" ;
      P01NP2_A464DTipoConCod = new String[] {""} ;
      P01NP2_A6LegNumero = new int[1] ;
      P01NP2_A31LiqNro = new int[1] ;
      P01NP2_A1EmpCod = new short[1] ;
      P01NP2_A3CliCod = new int[1] ;
      P01NP2_A394DConCodigo = new String[] {""} ;
      P01NP2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NP2_n275LiqDImpCalcu = new boolean[] {false} ;
      P01NP2_A507LiqDCalculado = new byte[1] ;
      P01NP2_A504LiqDForOrig = new String[] {""} ;
      P01NP2_A393DConDescrip = new String[] {""} ;
      P01NP2_A468DSubTipoConCod1 = new String[] {""} ;
      P01NP2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01NP2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NP2_n269LiqDCanti = new boolean[] {false} ;
      P01NP2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NP2_A1219LiqDPlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NP2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A504LiqDForOrig = "" ;
      A393DConDescrip = "" ;
      A468DSubTipoConCod1 = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      AV54horasSemanaNormal = DecimalUtil.ZERO ;
      AV53LegHorasSem = DecimalUtil.ZERO ;
      AV49vacTLiqCod = "" ;
      GXt_char7 = "" ;
      AV48TLiqCod = "" ;
      GXt_char8 = "" ;
      GXv_int10 = new short[1] ;
      AV27nadaTLiqCod = "" ;
      AV29date = GXutil.nullDate() ;
      AV30auxError = "" ;
      AV31LiqDImpCalcu = DecimalUtil.ZERO ;
      AV33auxLiqDLog = "" ;
      AV55porUnaje = DecimalUtil.ZERO ;
      GXv_int2 = new byte[1] ;
      AV45ConFormula = "" ;
      AV46diaCantHorasNormalesDia = DecimalUtil.ZERO ;
      GXv_boolean19 = new boolean[1] ;
      GXv_char17 = new String[1] ;
      GXv_char12 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_char9 = new String[1] ;
      GXv_decimal18 = new java.math.BigDecimal[1] ;
      GXv_boolean16 = new boolean[1] ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_char1 = new String[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.base_calculo_pres_ant__default(),
         new Object[] {
             new Object[] {
            P01NP2_A464DTipoConCod, P01NP2_A6LegNumero, P01NP2_A31LiqNro, P01NP2_A1EmpCod, P01NP2_A3CliCod, P01NP2_A394DConCodigo, P01NP2_A275LiqDImpCalcu, P01NP2_n275LiqDImpCalcu, P01NP2_A507LiqDCalculado, P01NP2_A504LiqDForOrig,
            P01NP2_A393DConDescrip, P01NP2_A468DSubTipoConCod1, P01NP2_n468DSubTipoConCod1, P01NP2_A269LiqDCanti, P01NP2_n269LiqDCanti, P01NP2_A764LiqDImpReCalcu, P01NP2_A1219LiqDPlus, P01NP2_A81LiqDSecuencial
            }
         }
      );
      AV66Pgmname = "base_calculo_pres_ant" ;
      /* GeneXus formulas. */
      AV66Pgmname = "base_calculo_pres_ant" ;
      Gx_err = (short)(0) ;
   }

   private byte AV34LiqDCalculado ;
   private byte AV67GXLvl14 ;
   private byte A507LiqDCalculado ;
   private byte AV21es_base ;
   private byte AV26EmpTipoExp ;
   private byte AV47diasMes ;
   private byte GXv_int2[] ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short GXv_int10[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LiqNro ;
   private int AV60LiqRelNro ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV25proporcionHabitualPorUnaje ;
   private java.math.BigDecimal AV38Importes ;
   private java.math.BigDecimal AV39horasNormalesTotales ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private java.math.BigDecimal AV54horasSemanaNormal ;
   private java.math.BigDecimal AV53LegHorasSem ;
   private java.math.BigDecimal AV31LiqDImpCalcu ;
   private java.math.BigDecimal AV55porUnaje ;
   private java.math.BigDecimal AV46diaCantHorasNormalesDia ;
   private java.math.BigDecimal GXv_decimal18[] ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV63tipo_tarifa ;
   private String AV20que ;
   private String AV51llamador ;
   private String AV28ProcesoLiquidacion ;
   private String AV8desdeTipoConCod ;
   private String AV9hastaTipoConCod ;
   private String AV10sueldoMensualConCodigo ;
   private String AV40horasNormalesConCodigo ;
   private String AV66Pgmname ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String A468DSubTipoConCod1 ;
   private String AV49vacTLiqCod ;
   private String GXt_char7 ;
   private String AV48TLiqCod ;
   private String GXt_char8 ;
   private String AV27nadaTLiqCod ;
   private String GXv_char17[] ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private String GXv_char9[] ;
   private String GXv_char1[] ;
   private java.util.Date AV24LiqPeriodo ;
   private java.util.Date AV23desde_LiqPeriodo ;
   private java.util.Date AV29date ;
   private boolean n275LiqDImpCalcu ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean AV15resolver ;
   private boolean AV16agregar ;
   private boolean AV17sinPlus ;
   private boolean AV56propAComp ;
   private boolean AV52MprEsParcial ;
   private boolean AV32dependenciasResueltas ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV44sumoHorasNormales ;
   private boolean GXv_boolean19[] ;
   private boolean GXv_boolean16[] ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean4[] ;
   private boolean GXv_boolean3[] ;
   private String AV36LiqDLog ;
   private String A504LiqDForOrig ;
   private String AV33auxLiqDLog ;
   private String AV45ConFormula ;
   private String AV35error ;
   private String A393DConDescrip ;
   private String AV30auxError ;
   private String[] aP16 ;
   private java.math.BigDecimal[] aP12 ;
   private java.math.BigDecimal[] aP13 ;
   private byte[] aP14 ;
   private String[] aP15 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NP2_A464DTipoConCod ;
   private int[] P01NP2_A6LegNumero ;
   private int[] P01NP2_A31LiqNro ;
   private short[] P01NP2_A1EmpCod ;
   private int[] P01NP2_A3CliCod ;
   private String[] P01NP2_A394DConCodigo ;
   private java.math.BigDecimal[] P01NP2_A275LiqDImpCalcu ;
   private boolean[] P01NP2_n275LiqDImpCalcu ;
   private byte[] P01NP2_A507LiqDCalculado ;
   private String[] P01NP2_A504LiqDForOrig ;
   private String[] P01NP2_A393DConDescrip ;
   private String[] P01NP2_A468DSubTipoConCod1 ;
   private boolean[] P01NP2_n468DSubTipoConCod1 ;
   private java.math.BigDecimal[] P01NP2_A269LiqDCanti ;
   private boolean[] P01NP2_n269LiqDCanti ;
   private java.math.BigDecimal[] P01NP2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01NP2_A1219LiqDPlus ;
   private int[] P01NP2_A81LiqDSecuencial ;
}

final  class base_calculo_pres_ant__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NP2", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDImpCalcu, LiqDCalculado, LiqDForOrig, DConDescrip, DSubTipoConCod1, LiqDCanti, LiqDImpReCalcu, LiqDPlus, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DTipoConCod >= ( ?)) AND (DTipoConCod <= ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(14,4);
               ((int[]) buf[17])[0] = rslt.getInt(15);
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
               stmt.setString(6, (String)parms[5], 20);
               return;
      }
   }

}

