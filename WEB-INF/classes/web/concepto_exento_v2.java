package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class concepto_exento_v2 extends GXProcedure
{
   public concepto_exento_v2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( concepto_exento_v2.class ), "" );
   }

   public concepto_exento_v2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              int aP4 ,
                              java.util.Date aP5 ,
                              String aP6 ,
                              String aP7 ,
                              short aP8 ,
                              String aP9 ,
                              boolean aP10 ,
                              String aP11 ,
                              java.math.BigDecimal aP12 ,
                              java.math.BigDecimal[] aP13 ,
                              java.math.BigDecimal[] aP14 ,
                              String[] aP15 ,
                              byte[] aP16 ,
                              String[] aP17 )
   {
      concepto_exento_v2.this.aP18 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        short aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        java.math.BigDecimal aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        String[] aP15 ,
                        byte[] aP16 ,
                        String[] aP17 ,
                        boolean[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             short aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             java.math.BigDecimal aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             String[] aP15 ,
                             byte[] aP16 ,
                             String[] aP17 ,
                             boolean[] aP18 )
   {
      concepto_exento_v2.this.AV19CliCod = aP0;
      concepto_exento_v2.this.AV22EmpCod = aP1;
      concepto_exento_v2.this.AV28LiqNro = aP2;
      concepto_exento_v2.this.AV69LiqRelNro = aP3;
      concepto_exento_v2.this.AV25LegNumero = aP4;
      concepto_exento_v2.this.AV29LiqPeriodo = aP5;
      concepto_exento_v2.this.AV56principalConCodigo = aP6;
      concepto_exento_v2.this.AV57exentoConCodigo = aP7;
      concepto_exento_v2.this.AV55parm_AplIIGG = aP8;
      concepto_exento_v2.this.AV34procesoLiquidacion = aP9;
      concepto_exento_v2.this.AV8insertandoConceptos = aP10;
      concepto_exento_v2.this.AV52idOperando = aP11;
      concepto_exento_v2.this.AV53LiqDImpCalcu = aP12;
      concepto_exento_v2.this.aP13 = aP13;
      concepto_exento_v2.this.aP14 = aP14;
      concepto_exento_v2.this.aP15 = aP15;
      concepto_exento_v2.this.aP16 = aP16;
      concepto_exento_v2.this.aP17 = aP17;
      concepto_exento_v2.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&principalConCodigo ", "")+GXutil.trim( AV56principalConCodigo)+httpContext.getMessage( " &idOperando ", "")+GXutil.trim( AV52idOperando)) ;
      if ( (0==AV55parm_AplIIGG) )
      {
         GXv_int1[0] = AV47AplIIGG ;
         new web.getconceptoapliigg(remoteHandle, context).execute( AV19CliCod, AV56principalConCodigo, GXv_int1) ;
         concepto_exento_v2.this.AV47AplIIGG = GXv_int1[0] ;
      }
      else
      {
         AV47AplIIGG = AV55parm_AplIIGG ;
      }
      GXt_char2 = AV51AplIIGGNom ;
      GXv_char3[0] = GXt_char2 ;
      new web.getapliiggnom(remoteHandle, context).execute( AV19CliCod, AV47AplIIGG, GXv_char3) ;
      concepto_exento_v2.this.GXt_char2 = GXv_char3[0] ;
      AV51AplIIGGNom = GXt_char2 ;
      AV40conceptoPalabra = AV51AplIIGGNom ;
      GXt_char2 = AV48CondExenIIGG ;
      GXv_char3[0] = GXt_char2 ;
      new web.getapliiggapliiggcondicion(remoteHandle, context).execute( AV19CliCod, AV47AplIIGG, GXv_char3) ;
      concepto_exento_v2.this.GXt_char2 = GXv_char3[0] ;
      AV48CondExenIIGG = GXt_char2 ;
      if ( ! (GXutil.strcmp("", AV48CondExenIIGG)==0) )
      {
         GXv_char3[0] = AV49brutoCondExenIIGG ;
         new web.getcondiiggbonos(remoteHandle, context).execute( AV19CliCod, GXv_char3) ;
         concepto_exento_v2.this.AV49brutoCondExenIIGG = GXv_char3[0] ;
         if ( GXutil.strcmp(AV48CondExenIIGG, AV49brutoCondExenIIGG) == 0 )
         {
            GXv_decimal4[0] = AV36sueldo_bruto_promedio ;
            GXv_int5[0] = AV18brutoPromLiqDCalculado ;
            GXv_char3[0] = AV42brutoPromError ;
            new web.sueldo_bruto_promedio(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV69LiqRelNro, AV25LegNumero, AV29LiqPeriodo, AV60date, AV60date, AV56principalConCodigo, AV34procesoLiquidacion, GXv_decimal4, GXv_int5, GXv_char3) ;
            concepto_exento_v2.this.AV36sueldo_bruto_promedio = GXv_decimal4[0] ;
            concepto_exento_v2.this.AV18brutoPromLiqDCalculado = GXv_int5[0] ;
            concepto_exento_v2.this.AV42brutoPromError = GXv_char3[0] ;
            if ( AV18brutoPromLiqDCalculado == 0 )
            {
               AV26LiqDCalculado = (byte)(0) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "no calcul1", "")) ;
               AV23error = httpContext.getMessage( "No se pudo calcular sueldo bruto promedio", "") ;
               if ( ! (GXutil.strcmp("", AV42brutoPromError)==0) )
               {
                  AV23error += " (" + GXutil.trim( AV42brutoPromError) + ")" ;
               }
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV32OpeCliId = "[tope_bonos]" ;
            GXv_char3[0] = AV33OpeCliValor ;
            GXv_char6[0] = AV70auxError ;
            new web.getopeclivalor(remoteHandle, context).execute( AV19CliCod, AV32OpeCliId, AV29LiqPeriodo, AV34procesoLiquidacion, GXv_char3, GXv_char6) ;
            concepto_exento_v2.this.AV33OpeCliValor = GXv_char3[0] ;
            concepto_exento_v2.this.AV70auxError = GXv_char6[0] ;
            if ( ! (GXutil.strcmp("", AV70auxError)==0) )
            {
               AV26LiqDCalculado = (byte)(0) ;
               AV23error = AV70auxError ;
               AV27LiqDLog = AV23error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV37tope_bonosImportes = CommonUtil.decimalVal( AV33OpeCliValor, ".") ;
            GXv_char6[0] = "" ;
            GXv_char3[0] = "" ;
            GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char7[0] = AV73CondExenIIGGOpe ;
            new web.getcondexencioniigg(remoteHandle, context).execute( AV19CliCod, AV48CondExenIIGG, GXv_char6, GXv_char3, GXv_decimal4, GXv_char7) ;
            concepto_exento_v2.this.AV73CondExenIIGGOpe = GXv_char7[0] ;
            GXv_boolean8[0] = AV72condicionEvaluada ;
            new web.evaluarcomparacion(remoteHandle, context).execute( AV73CondExenIIGGOpe, AV36sueldo_bruto_promedio, AV37tope_bonosImportes, GXv_boolean8) ;
            concepto_exento_v2.this.AV72condicionEvaluada = GXv_boolean8[0] ;
            /* Execute user subroutine: 'RESPUESTA A CONDICION' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            GXv_char7[0] = AV74CondExenIIGGCon ;
            GXv_char6[0] = AV75CondExenIIGGVar ;
            GXv_decimal4[0] = AV76CondExenIIGGVFi ;
            GXv_char3[0] = AV73CondExenIIGGOpe ;
            new web.getcondexencioniigg(remoteHandle, context).execute( AV19CliCod, AV48CondExenIIGG, GXv_char7, GXv_char6, GXv_decimal4, GXv_char3) ;
            concepto_exento_v2.this.AV74CondExenIIGGCon = GXv_char7[0] ;
            concepto_exento_v2.this.AV75CondExenIIGGVar = GXv_char6[0] ;
            concepto_exento_v2.this.AV76CondExenIIGGVFi = GXv_decimal4[0] ;
            concepto_exento_v2.this.AV73CondExenIIGGOpe = GXv_char3[0] ;
            if ( ! (GXutil.strcmp("", AV75CondExenIIGGVar)==0) )
            {
            }
            else
            {
               GXv_decimal4[0] = AV77auxLiqDImpCalcu ;
               GXv_boolean8[0] = false ;
               GXv_int5[0] = AV78auxLiqDCalculado ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV25LegNumero, AV74CondExenIIGGCon, AV34procesoLiquidacion, false, GXv_decimal4, GXv_boolean8, GXv_int5) ;
               concepto_exento_v2.this.AV77auxLiqDImpCalcu = GXv_decimal4[0] ;
               concepto_exento_v2.this.AV78auxLiqDCalculado = GXv_int5[0] ;
               if ( AV78auxLiqDCalculado == 0 )
               {
                  AV26LiqDCalculado = (byte)(0) ;
                  AV23error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV74CondExenIIGGCon) ;
                  AV27LiqDLog = GXutil.trim( AV23error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               GXv_boolean8[0] = AV72condicionEvaluada ;
               new web.evaluarcomparacion(remoteHandle, context).execute( AV73CondExenIIGGOpe, AV77auxLiqDImpCalcu, AV76CondExenIIGGVFi, GXv_boolean8) ;
               concepto_exento_v2.this.AV72condicionEvaluada = GXv_boolean8[0] ;
               /* Execute user subroutine: 'RESPUESTA A CONDICION' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
      }
      if ( GXutil.strcmp(AV52idOperando, "[deduccion]") == 0 )
      {
         GXv_boolean8[0] = AV61existe ;
         GXv_decimal4[0] = AV11concepto_actual ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV25LegNumero, AV52idOperando, AV29LiqPeriodo, AV56principalConCodigo, false, (byte)(0), "", false, GXv_boolean8, GXv_decimal4) ;
         concepto_exento_v2.this.AV61existe = GXv_boolean8[0] ;
         concepto_exento_v2.this.AV11concepto_actual = GXv_decimal4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&concepto_actual ", "")+GXutil.trim( GXutil.str( AV11concepto_actual, 14, 2))+httpContext.getMessage( " &existe1 ", "")+GXutil.trim( GXutil.booltostr( AV61existe))) ;
      }
      else
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53LiqDImpCalcu)==0) )
         {
            AV11concepto_actual = AV53LiqDImpCalcu ;
            AV61existe = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "existe 2", "")) ;
         }
         else
         {
            GXv_decimal4[0] = AV11concepto_actual ;
            GXv_boolean8[0] = AV61existe ;
            GXv_int5[0] = AV54actualLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV25LegNumero, AV56principalConCodigo, AV34procesoLiquidacion, AV8insertandoConceptos, GXv_decimal4, GXv_boolean8, GXv_int5) ;
            concepto_exento_v2.this.AV11concepto_actual = GXv_decimal4[0] ;
            concepto_exento_v2.this.AV61existe = GXv_boolean8[0] ;
            concepto_exento_v2.this.AV54actualLiqDCalculado = GXv_int5[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "existe 3", "")) ;
            if ( ( AV54actualLiqDCalculado == 0 ) && ( AV61existe ) )
            {
               AV26LiqDCalculado = (byte)(0) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "no calcul2", "")) ;
               AV23error = httpContext.getMessage( "No se pudo calcular ", "") + GXutil.trim( AV56principalConCodigo) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      GXv_decimal4[0] = AV59auxTope ;
      GXv_decimal9[0] = AV58AplIIGGPropor ;
      GXv_int5[0] = AV62AplIIGGTopeTip ;
      GXv_char7[0] = AV63AplIIGGTopeVar ;
      GXv_char6[0] = AV67AplIIGGPrrtear ;
      GXv_char3[0] = AV66topePalabra ;
      GXv_int10[0] = AV50topeLiqDCalculado ;
      GXv_char11[0] = AV71topeError ;
      new web.getapliiggtope(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV25LegNumero, AV29LiqPeriodo, AV47AplIIGG, AV34procesoLiquidacion, AV8insertandoConceptos, GXv_decimal4, GXv_decimal9, GXv_int5, GXv_char7, GXv_char6, GXv_char3, GXv_int10, GXv_char11) ;
      concepto_exento_v2.this.AV59auxTope = GXv_decimal4[0] ;
      concepto_exento_v2.this.AV58AplIIGGPropor = GXv_decimal9[0] ;
      concepto_exento_v2.this.AV62AplIIGGTopeTip = GXv_int5[0] ;
      concepto_exento_v2.this.AV63AplIIGGTopeVar = GXv_char7[0] ;
      concepto_exento_v2.this.AV67AplIIGGPrrtear = GXv_char6[0] ;
      concepto_exento_v2.this.AV66topePalabra = GXv_char3[0] ;
      concepto_exento_v2.this.AV50topeLiqDCalculado = GXv_int10[0] ;
      concepto_exento_v2.this.AV71topeError = GXv_char11[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "llamó a getAplIIGGTope concodigo ", "")+GXutil.trim( AV20ConCodigo)+httpContext.getMessage( " &AplIIGGTopeTip ", "")+GXutil.trim( GXutil.str( AV62AplIIGGTopeTip, 1, 0))+httpContext.getMessage( " principal ", "")+AV56principalConCodigo+httpContext.getMessage( " &auxTope ", "")+GXutil.trim( GXutil.str( AV59auxTope, 14, 2))) ;
      if ( (0==AV62AplIIGGTopeTip) )
      {
         AV38Importes = AV11concepto_actual ;
         AV27LiqDLog += httpContext.getMessage( ". !Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV38Importes, 14, 2)) ;
      }
      else
      {
         if ( GXutil.strcmp(AV67AplIIGGPrrtear, "VAR") != 0 )
         {
            if ( GXutil.strcmp(AV52idOperando, "[deduccion]") == 0 )
            {
               GXv_decimal9[0] = AV30liquidacionesAnterioresImportes ;
               new web.facturas_anteriores(remoteHandle, context).execute( AV52idOperando, AV19CliCod, AV69LiqRelNro, AV22EmpCod, AV25LegNumero, AV56principalConCodigo, AV29LiqPeriodo, GXv_decimal9) ;
               concepto_exento_v2.this.AV30liquidacionesAnterioresImportes = GXv_decimal9[0] ;
            }
            else
            {
               if ( GXutil.strcmp(AV52idOperando, "{tratamiento_exencion}") == 0 )
               {
                  GXv_decimal9[0] = AV30liquidacionesAnterioresImportes ;
                  new web.getliqexencionesanteriores(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, (short)(GXutil.year( AV29LiqPeriodo)), AV28LiqNro, AV25LegNumero, AV47AplIIGG, AV56principalConCodigo, AV52idOperando, GXv_decimal9) ;
                  concepto_exento_v2.this.AV30liquidacionesAnterioresImportes = GXv_decimal9[0] ;
               }
               else
               {
                  GXv_decimal9[0] = AV30liquidacionesAnterioresImportes ;
                  new web.getvaloresanterioresactualizados(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, AV28LiqNro, AV69LiqRelNro, AV25LegNumero, AV57exentoConCodigo, AV29LiqPeriodo, GXv_decimal9) ;
                  concepto_exento_v2.this.AV30liquidacionesAnterioresImportes = GXv_decimal9[0] ;
               }
            }
         }
         else
         {
            GXv_decimal9[0] = AV68saldosAnterioresImportes ;
            GXv_boolean8[0] = false ;
            new web.cuentasaldoanterior(remoteHandle, context).execute( AV19CliCod, AV22EmpCod, (short)(GXutil.year( AV29LiqPeriodo)), AV25LegNumero, AV56principalConCodigo, AV28LiqNro, true, GXv_decimal9, GXv_boolean8) ;
            concepto_exento_v2.this.AV68saldosAnterioresImportes = GXv_decimal9[0] ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&topeLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV50topeLiqDCalculado, 1, 0))) ;
         if ( AV50topeLiqDCalculado == 0 )
         {
            AV26LiqDCalculado = (byte)(0) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "no calcul3", "")) ;
            AV23error = httpContext.getMessage( "No se pudo calcular tope para ", "") + GXutil.trim( AV51AplIIGGNom) ;
            if ( ! (GXutil.strcmp("", AV71topeError)==0) )
            {
               AV23error += ". " + GXutil.trim( AV71topeError) ;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&AplIIGGPropor ", "")+GXutil.trim( GXutil.str( AV58AplIIGGPropor, 6, 4))) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58AplIIGGPropor)==0) )
            {
               AV21tope = AV59auxTope ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "tope es &auxTope ", "")+GXutil.trim( GXutil.str( AV59auxTope, 14, 2))) ;
            }
            else
            {
               AV21tope = AV59auxTope.multiply(AV58AplIIGGPropor) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "tope es &auxTope ", "")+GXutil.trim( GXutil.str( AV59auxTope, 14, 2))+httpContext.getMessage( " por ", "")+GXutil.trim( GXutil.str( AV58AplIIGGPropor, 6, 4))) ;
            }
         }
         AV9totalConceptoExentosImportes = AV30liquidacionesAnterioresImportes.add(AV11concepto_actual).add(AV15OtrosLiqDImpCalcu).add(AV68saldosAnterioresImportes) ;
         if ( DecimalUtil.compareTo(AV9totalConceptoExentosImportes, AV21tope) <= 0 )
         {
            AV38Importes = AV11concepto_actual.add(AV15OtrosLiqDImpCalcu).add(AV68saldosAnterioresImportes) ;
            AV27LiqDLog += httpContext.getMessage( ". Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV38Importes, 14, 2)) ;
            if ( AV38Importes.doubleValue() != 0 )
            {
               /* Execute user subroutine: 'LOG IMPORTES' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            AV27LiqDLog += httpContext.getMessage( ", al ser el total exento acumulado ", "") + GXutil.trim( GXutil.str( AV9totalConceptoExentosImportes, 14, 2)) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30liquidacionesAnterioresImportes)==0) )
            {
               AV27LiqDLog += httpContext.getMessage( " (incluyendo los ", "") + GXutil.trim( GXutil.str( AV30liquidacionesAnterioresImportes, 14, 2)) + httpContext.getMessage( " de liquidaciones anteriores)", "") ;
            }
            AV65porcNum = AV58AplIIGGPropor.multiply(DecimalUtil.doubleToDec(100)) ;
            AV64porcentajePalabra = GXutil.trim( GXutil.str( AV65porcNum, 7, 2)) + "%" ;
            AV27LiqDLog += httpContext.getMessage( " menor o igual al tope del ", "") + GXutil.trim( AV64porcentajePalabra) + httpContext.getMessage( " del ", "") + GXutil.trim( AV66topePalabra) + " " + GXutil.trim( GXutil.str( AV21tope, 14, 2)) ;
         }
         else
         {
            AV38Importes = AV21tope ;
            AV27LiqDLog += httpContext.getMessage( ". Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV38Importes, 14, 2)) + httpContext.getMessage( " correspondientes al \"", "") + GXutil.trim( AV51AplIIGGNom) + "\" " ;
            /* Execute user subroutine: 'LOG IMPORTES' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV27LiqDLog += httpContext.getMessage( " por ser el total ", "") + GXutil.trim( GXutil.str( AV9totalConceptoExentosImportes, 14, 2)) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30liquidacionesAnterioresImportes)==0) )
            {
               AV27LiqDLog += httpContext.getMessage( " (incluyendo los ", "") + GXutil.trim( GXutil.str( AV30liquidacionesAnterioresImportes, 14, 2)) + httpContext.getMessage( " de liquidaciones anteriores)", "") ;
            }
            AV27LiqDLog += httpContext.getMessage( " mayor al tope", "") ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&principalConCodigo ", "")+GXutil.trim( AV56principalConCodigo)+httpContext.getMessage( " apliigg ", "")+GXutil.trim( GXutil.str( AV47AplIIGG, 4, 0))+httpContext.getMessage( " log ", "")+GXutil.trim( AV27LiqDLog)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOG IMPORTES' Routine */
      returnInSub = false ;
      if ( DecimalUtil.compareTo(AV11concepto_actual, AV9totalConceptoExentosImportes) != 0 )
      {
         AV27LiqDLog += httpContext.getMessage( ", que es la suma de los ", "") + GXutil.trim( AV40conceptoPalabra) + " " + GXutil.trim( GXutil.str( AV11concepto_actual, 14, 2)) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15OtrosLiqDImpCalcu)==0) )
         {
            AV27LiqDLog += httpContext.getMessage( " más ", "") + GXutil.trim( GXutil.str( AV15OtrosLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de otros empleos", "") ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68saldosAnterioresImportes)==0) )
         {
            AV27LiqDLog += httpContext.getMessage( " más ", "") + GXutil.trim( GXutil.str( AV68saldosAnterioresImportes, 14, 2)) + httpContext.getMessage( " de saldos anteriores", "") ;
         }
      }
   }

   public void S121( )
   {
      /* 'RESPUESTA A CONDICION' Routine */
      returnInSub = false ;
      if ( AV72condicionEvaluada )
      {
         AV27LiqDLog = httpContext.getMessage( "Calculo condición OK", "") ;
      }
      else
      {
         AV27LiqDLog = httpContext.getMessage( "Se grava totalmente el concepto porque el sueldo bruto promedio ", "") + GXutil.trim( GXutil.str( AV36sueldo_bruto_promedio, 14, 2)) + httpContext.getMessage( " es mayor al tope para exención de bonos ", "") + GXutil.trim( GXutil.str( AV37tope_bonosImportes, 14, 2)) ;
         AV61existe = true ;
         returnInSub = true;
         if (true) return;
      }
   }

   protected void cleanup( )
   {
      this.aP13[0] = concepto_exento_v2.this.AV38Importes;
      this.aP14[0] = concepto_exento_v2.this.AV11concepto_actual;
      this.aP15[0] = concepto_exento_v2.this.AV23error;
      this.aP16[0] = concepto_exento_v2.this.AV26LiqDCalculado;
      this.aP17[0] = concepto_exento_v2.this.AV27LiqDLog;
      this.aP18[0] = concepto_exento_v2.this.AV61existe;
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
      AV11concepto_actual = DecimalUtil.ZERO ;
      AV23error = "" ;
      AV27LiqDLog = "" ;
      AV81Pgmname = "" ;
      GXv_int1 = new short[1] ;
      AV51AplIIGGNom = "" ;
      AV40conceptoPalabra = "" ;
      AV48CondExenIIGG = "" ;
      GXt_char2 = "" ;
      AV49brutoCondExenIIGG = "" ;
      AV60date = GXutil.nullDate() ;
      AV36sueldo_bruto_promedio = DecimalUtil.ZERO ;
      AV42brutoPromError = "" ;
      AV32OpeCliId = "" ;
      AV33OpeCliValor = "" ;
      AV70auxError = "" ;
      AV37tope_bonosImportes = DecimalUtil.ZERO ;
      AV73CondExenIIGGOpe = "" ;
      AV74CondExenIIGGCon = "" ;
      AV75CondExenIIGGVar = "" ;
      AV76CondExenIIGGVFi = DecimalUtil.ZERO ;
      AV77auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV59auxTope = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV58AplIIGGPropor = DecimalUtil.ZERO ;
      GXv_int5 = new byte[1] ;
      AV63AplIIGGTopeVar = "" ;
      GXv_char7 = new String[1] ;
      AV67AplIIGGPrrtear = "" ;
      GXv_char6 = new String[1] ;
      AV66topePalabra = "" ;
      GXv_char3 = new String[1] ;
      GXv_int10 = new byte[1] ;
      AV71topeError = "" ;
      GXv_char11 = new String[1] ;
      AV20ConCodigo = "" ;
      AV30liquidacionesAnterioresImportes = DecimalUtil.ZERO ;
      AV68saldosAnterioresImportes = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_boolean8 = new boolean[1] ;
      AV21tope = DecimalUtil.ZERO ;
      AV9totalConceptoExentosImportes = DecimalUtil.ZERO ;
      AV15OtrosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV65porcNum = DecimalUtil.ZERO ;
      AV64porcentajePalabra = "" ;
      AV81Pgmname = "concepto_exento_v2" ;
      /* GeneXus formulas. */
      AV81Pgmname = "concepto_exento_v2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV26LiqDCalculado ;
   private byte AV18brutoPromLiqDCalculado ;
   private byte AV78auxLiqDCalculado ;
   private byte AV54actualLiqDCalculado ;
   private byte AV62AplIIGGTopeTip ;
   private byte GXv_int5[] ;
   private byte AV50topeLiqDCalculado ;
   private byte GXv_int10[] ;
   private short AV22EmpCod ;
   private short AV55parm_AplIIGG ;
   private short AV47AplIIGG ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV28LiqNro ;
   private int AV69LiqRelNro ;
   private int AV25LegNumero ;
   private java.math.BigDecimal AV53LiqDImpCalcu ;
   private java.math.BigDecimal AV38Importes ;
   private java.math.BigDecimal AV11concepto_actual ;
   private java.math.BigDecimal AV36sueldo_bruto_promedio ;
   private java.math.BigDecimal AV37tope_bonosImportes ;
   private java.math.BigDecimal AV76CondExenIIGGVFi ;
   private java.math.BigDecimal AV77auxLiqDImpCalcu ;
   private java.math.BigDecimal AV59auxTope ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal AV58AplIIGGPropor ;
   private java.math.BigDecimal AV30liquidacionesAnterioresImportes ;
   private java.math.BigDecimal AV68saldosAnterioresImportes ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal AV21tope ;
   private java.math.BigDecimal AV9totalConceptoExentosImportes ;
   private java.math.BigDecimal AV15OtrosLiqDImpCalcu ;
   private java.math.BigDecimal AV65porcNum ;
   private String AV56principalConCodigo ;
   private String AV57exentoConCodigo ;
   private String AV34procesoLiquidacion ;
   private String AV52idOperando ;
   private String AV81Pgmname ;
   private String AV40conceptoPalabra ;
   private String AV48CondExenIIGG ;
   private String GXt_char2 ;
   private String AV49brutoCondExenIIGG ;
   private String AV32OpeCliId ;
   private String AV73CondExenIIGGOpe ;
   private String AV74CondExenIIGGCon ;
   private String AV75CondExenIIGGVar ;
   private String AV63AplIIGGTopeVar ;
   private String GXv_char7[] ;
   private String AV67AplIIGGPrrtear ;
   private String GXv_char6[] ;
   private String AV66topePalabra ;
   private String GXv_char3[] ;
   private String GXv_char11[] ;
   private String AV20ConCodigo ;
   private String AV64porcentajePalabra ;
   private java.util.Date AV29LiqPeriodo ;
   private java.util.Date AV60date ;
   private boolean AV8insertandoConceptos ;
   private boolean AV61existe ;
   private boolean returnInSub ;
   private boolean AV72condicionEvaluada ;
   private boolean GXv_boolean8[] ;
   private String AV27LiqDLog ;
   private String AV33OpeCliValor ;
   private String AV23error ;
   private String AV51AplIIGGNom ;
   private String AV42brutoPromError ;
   private String AV70auxError ;
   private String AV71topeError ;
   private boolean[] aP18 ;
   private java.math.BigDecimal[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private String[] aP15 ;
   private byte[] aP16 ;
   private String[] aP17 ;
}

