package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliquidaciondetalle3 extends GXProcedure
{
   public newliquidaciondetalle3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliquidaciondetalle3.class ), "" );
   }

   public newliquidaciondetalle3( int remoteHandle ,
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
                             boolean aP6 ,
                             int aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.util.Date aP11 ,
                             java.util.Date aP12 ,
                             java.math.BigDecimal aP13 ,
                             boolean aP14 ,
                             byte aP15 ,
                             java.util.Date aP16 ,
                             String aP17 ,
                             boolean aP18 ,
                             byte aP19 ,
                             boolean aP20 ,
                             String aP21 ,
                             java.math.BigDecimal[] aP22 ,
                             boolean[] aP23 ,
                             String[] aP24 )
   {
      newliquidaciondetalle3.this.aP25 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
      return aP25[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        int aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        java.math.BigDecimal aP10 ,
                        java.util.Date aP11 ,
                        java.util.Date aP12 ,
                        java.math.BigDecimal aP13 ,
                        boolean aP14 ,
                        byte aP15 ,
                        java.util.Date aP16 ,
                        String aP17 ,
                        boolean aP18 ,
                        byte aP19 ,
                        boolean aP20 ,
                        String aP21 ,
                        java.math.BigDecimal[] aP22 ,
                        boolean[] aP23 ,
                        String[] aP24 ,
                        String[] aP25 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             int aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.util.Date aP11 ,
                             java.util.Date aP12 ,
                             java.math.BigDecimal aP13 ,
                             boolean aP14 ,
                             byte aP15 ,
                             java.util.Date aP16 ,
                             String aP17 ,
                             boolean aP18 ,
                             byte aP19 ,
                             boolean aP20 ,
                             String aP21 ,
                             java.math.BigDecimal[] aP22 ,
                             boolean[] aP23 ,
                             String[] aP24 ,
                             String[] aP25 )
   {
      newliquidaciondetalle3.this.AV12CliCod = aP0;
      newliquidaciondetalle3.this.AV19EmpCod = aP1;
      newliquidaciondetalle3.this.AV55LiqNro = aP2;
      newliquidaciondetalle3.this.AV241LiqRelNro = aP3;
      newliquidaciondetalle3.this.AV92LegNumero = aP4;
      newliquidaciondetalle3.this.AV81ConCodigo = aP5;
      newliquidaciondetalle3.this.AV189resolver = aP6;
      newliquidaciondetalle3.this.AV51LiqDSecuencial = aP7;
      newliquidaciondetalle3.this.AV99LiqDImporte = aP8;
      newliquidaciondetalle3.this.AV144parmLiqDCanti = aP9;
      newliquidaciondetalle3.this.AV101LiqDValUni = aP10;
      newliquidaciondetalle3.this.AV234DAgeFecDes = aP11;
      newliquidaciondetalle3.this.AV245DAgeFecHas = aP12;
      newliquidaciondetalle3.this.AV229parmLiqDImpCalcu = aP13;
      newliquidaciondetalle3.this.AV126forzarCero = aP14;
      newliquidaciondetalle3.this.AV50LiqDMostrar = aP15;
      newliquidaciondetalle3.this.AV56LiqPeriodo = aP16;
      newliquidaciondetalle3.this.AV75TLiqCod = aP17;
      newliquidaciondetalle3.this.AV165LiqDNovedad = aP18;
      newliquidaciondetalle3.this.AV221LiqDLote = aP19;
      newliquidaciondetalle3.this.AV228calculandoOrden = aP20;
      newliquidaciondetalle3.this.AV239importadoConDescrip = aP21;
      newliquidaciondetalle3.this.aP22 = aP22;
      newliquidaciondetalle3.this.aP23 = aP23;
      newliquidaciondetalle3.this.aP24 = aP24;
      newliquidaciondetalle3.this.aP25 = aP25;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV191comienzo = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "concodigo ", "")+AV81ConCodigo) ;
      GXv_char1[0] = AV193ConDescrip ;
      GXv_char2[0] = AV194TipoConCod ;
      GXv_char3[0] = AV82ConFormula ;
      GXv_boolean4[0] = false ;
      GXv_boolean5[0] = AV195ConVariable ;
      GXv_char6[0] = AV196SubTipoConCod1 ;
      GXv_char7[0] = "" ;
      GXv_char8[0] = AV113SubTipoConCod2 ;
      GXv_char9[0] = "" ;
      GXv_char10[0] = "" ;
      GXv_int11[0] = AV198ConOrden ;
      GXv_int12[0] = AV199ConOrdEjec ;
      GXv_char13[0] = "" ;
      GXv_int14[0] = AV84ConVigencia ;
      GXv_boolean15[0] = AV83ConRecalcular ;
      GXv_int16[0] = AV200DAplIIGG ;
      GXv_boolean17[0] = false ;
      GXv_char18[0] = AV160ConPreReq ;
      GXv_boolean19[0] = AV161ConMostrarPos ;
      GXv_int20[0] = AV169ConAdelDescu ;
      GXv_char21[0] = AV225ConCondicion ;
      GXv_int22[0] = AV230ConLiqBasica ;
      GXv_char23[0] = AV233ConveCodigo ;
      GXv_char24[0] = AV244ConClasifAux ;
      new web.getdatosconcepto2(remoteHandle, context).execute( AV12CliCod, AV81ConCodigo, GXv_char1, GXv_char2, GXv_char3, GXv_boolean4, GXv_boolean5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_int11, GXv_int12, GXv_char13, GXv_int14, GXv_boolean15, GXv_int16, GXv_boolean17, GXv_char18, GXv_boolean19, GXv_int20, GXv_char21, GXv_int22, GXv_char23, GXv_char24) ;
      newliquidaciondetalle3.this.AV193ConDescrip = GXv_char1[0] ;
      newliquidaciondetalle3.this.AV194TipoConCod = GXv_char2[0] ;
      newliquidaciondetalle3.this.AV82ConFormula = GXv_char3[0] ;
      newliquidaciondetalle3.this.AV195ConVariable = GXv_boolean5[0] ;
      newliquidaciondetalle3.this.AV196SubTipoConCod1 = GXv_char6[0] ;
      newliquidaciondetalle3.this.AV113SubTipoConCod2 = GXv_char8[0] ;
      newliquidaciondetalle3.this.AV198ConOrden = GXv_int11[0] ;
      newliquidaciondetalle3.this.AV199ConOrdEjec = GXv_int12[0] ;
      newliquidaciondetalle3.this.AV84ConVigencia = GXv_int14[0] ;
      newliquidaciondetalle3.this.AV83ConRecalcular = GXv_boolean15[0] ;
      newliquidaciondetalle3.this.AV200DAplIIGG = GXv_int16[0] ;
      newliquidaciondetalle3.this.AV160ConPreReq = GXv_char18[0] ;
      newliquidaciondetalle3.this.AV161ConMostrarPos = GXv_boolean19[0] ;
      newliquidaciondetalle3.this.AV169ConAdelDescu = GXv_int20[0] ;
      newliquidaciondetalle3.this.AV225ConCondicion = GXv_char21[0] ;
      newliquidaciondetalle3.this.AV230ConLiqBasica = GXv_int22[0] ;
      newliquidaciondetalle3.this.AV233ConveCodigo = GXv_char23[0] ;
      newliquidaciondetalle3.this.AV244ConClasifAux = GXv_char24[0] ;
      if ( ! (GXutil.strcmp("", AV239importadoConDescrip)==0) )
      {
         AV193ConDescrip = AV239importadoConDescrip ;
      }
      GXv_char24[0] = AV170AplIIGGPrrtear ;
      new web.getapliiggprrtear(remoteHandle, context).execute( AV12CliCod, AV200DAplIIGG, GXv_char24) ;
      newliquidaciondetalle3.this.AV170AplIIGGPrrtear = GXv_char24[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "_1 &TipoConCod ", "")+AV194TipoConCod+httpContext.getMessage( " &parmLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV229parmLiqDImpCalcu, 14, 2))) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV229parmLiqDImpCalcu)==0) )
      {
         AV98LiqDImpCalcu = AV229parmLiqDImpCalcu ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "calcu de paraemtro", "")) ;
      }
      else
      {
         if ( GXutil.strSearch( GXutil.trim( AV82ConFormula), " ", 1) == 0 )
         {
            AV98LiqDImpCalcu = CommonUtil.decimalVal( AV82ConFormula, ".") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "calcu paso a numerico la formula \"", "")+GXutil.trim( AV82ConFormula)+httpContext.getMessage( " y le quedó ", "")+GXutil.trim( GXutil.str( AV98LiqDImpCalcu, 14, 2))) ;
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98LiqDImpCalcu)==0) && ! AV126forzarCero )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, "#1") ;
         if ( ! (GXutil.strcmp("", AV82ConFormula)==0) )
         {
            if ( true )
            {
               AV187altaProrrateoLiqDLog = "" ;
               if ( ( AV189resolver ) && ( GXutil.strcmp(GXutil.trim( AV82ConFormula), "1") != 0 ) )
               {
                  GXv_boolean19[0] = AV235altaCuotas ;
                  GXv_char24[0] = AV238altaCuotaIdOperando ;
                  new web.daraltacuota(remoteHandle, context).execute( AV12CliCod, AV82ConFormula, AV200DAplIIGG, AV170AplIIGGPrrtear, GXv_boolean19, GXv_char24) ;
                  newliquidaciondetalle3.this.AV235altaCuotas = GXv_boolean19[0] ;
                  newliquidaciondetalle3.this.AV238altaCuotaIdOperando = GXv_char24[0] ;
                  if ( AV235altaCuotas )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, GXutil.trim( A394DConCodigo)+httpContext.getMessage( " llama a altaRegistrosProrrateo ", "")+GXutil.trim( GXutil.str( A1122DAplIIGG, 4, 0))) ;
                     if ( (0==AV200DAplIIGG) )
                     {
                        AV240tipo_cuota = "FIJA" ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, "___1") ;
                     }
                     else
                     {
                        AV240tipo_cuota = A1125LiqDProrr ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "___2 LiqDProrr ", "")+GXutil.trim( A1125LiqDProrr)) ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "___3 &tipo_cuota ", "")+AV240tipo_cuota) ;
                     GXv_char24[0] = AV185altaProrrateoError ;
                     GXv_char23[0] = AV187altaProrrateoLiqDLog ;
                     GXv_int22[0] = AV186altaProrraLiqDCalculado ;
                     new web.altaregistrosprorrateo(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV55LiqNro, AV241LiqRelNro, AV92LegNumero, AV56LiqPeriodo, "", AV240tipo_cuota, AV81ConCodigo, AV238altaCuotaIdOperando, "Calculo", true, GXv_char24, GXv_char23, GXv_int22) ;
                     newliquidaciondetalle3.this.AV185altaProrrateoError = GXv_char24[0] ;
                     newliquidaciondetalle3.this.AV187altaProrrateoLiqDLog = GXv_char23[0] ;
                     newliquidaciondetalle3.this.AV186altaProrraLiqDCalculado = GXv_int22[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&altaProrrateoLiqDLog ", "")+GXutil.trim( AV187altaProrrateoLiqDLog)) ;
                     if ( AV186altaProrraLiqDCalculado == 0 )
                     {
                        AV201ok = false ;
                        AV86dependenciasResueltas = false ;
                        AV164msgError = httpContext.getMessage( "Error al calcular cuota: ", "") + GXutil.trim( AV185altaProrrateoError) ;
                     }
                     else
                     {
                        AV201ok = true ;
                     }
                  }
                  else
                  {
                     AV201ok = true ;
                  }
               }
               else
               {
                  AV201ok = true ;
               }
               if ( ( AV201ok ) && ( AV189resolver ) && ( GXutil.strcmp(GXutil.trim( AV82ConFormula), "1") != 0 ) )
               {
                  GXv_boolean19[0] = AV201ok ;
                  GXv_char24[0] = AV164msgError ;
                  GXv_char23[0] = AV202LiqDFormula ;
                  GXv_char21[0] = AV97LiqDFormulaHTML ;
                  GXv_char18[0] = "" ;
                  GXv_decimal25[0] = AV110Resultado ;
                  GXv_boolean17[0] = AV86dependenciasResueltas ;
                  GXv_decimal26[0] = AV203ConOpeEsCant ;
                  GXv_boolean15[0] = AV139OpeCliAliEs ;
                  GXv_decimal27[0] = AV137cantidadCalculada ;
                  GXv_decimal28[0] = AV143BaseImportes ;
                  GXv_boolean5[0] = false ;
                  GXv_char13[0] = AV188resolverLiqDLog ;
                  GXv_decimal29[0] = AV224LiqDPlus ;
                  GXv_boolean4[0] = false ;
                  new web.resolverformula(remoteHandle, context).execute( AV12CliCod, AV81ConCodigo, AV82ConFormula, AV82ConFormula, AV19EmpCod, AV55LiqNro, AV241LiqRelNro, AV55LiqNro, AV92LegNumero, AV75TLiqCod, AV56LiqPeriodo, AV248Pgmname, "Calculo", false, AV144parmLiqDCanti, AV234DAgeFecDes, AV99LiqDImporte, AV101LiqDValUni, GXv_boolean19, GXv_char24, GXv_char23, GXv_char21, GXv_char18, GXv_decimal25, GXv_boolean17, GXv_decimal26, GXv_boolean15, GXv_decimal27, GXv_decimal28, GXv_boolean5, GXv_char13, GXv_decimal29, GXv_boolean4) ;
                  newliquidaciondetalle3.this.AV201ok = GXv_boolean19[0] ;
                  newliquidaciondetalle3.this.AV164msgError = GXv_char24[0] ;
                  newliquidaciondetalle3.this.AV202LiqDFormula = GXv_char23[0] ;
                  newliquidaciondetalle3.this.AV97LiqDFormulaHTML = GXv_char21[0] ;
                  newliquidaciondetalle3.this.AV110Resultado = GXv_decimal25[0] ;
                  newliquidaciondetalle3.this.AV86dependenciasResueltas = GXv_boolean17[0] ;
                  newliquidaciondetalle3.this.AV203ConOpeEsCant = GXv_decimal26[0] ;
                  newliquidaciondetalle3.this.AV139OpeCliAliEs = GXv_boolean15[0] ;
                  newliquidaciondetalle3.this.AV137cantidadCalculada = GXv_decimal27[0] ;
                  newliquidaciondetalle3.this.AV143BaseImportes = GXv_decimal28[0] ;
                  newliquidaciondetalle3.this.AV188resolverLiqDLog = GXv_char13[0] ;
                  newliquidaciondetalle3.this.AV224LiqDPlus = GXv_decimal29[0] ;
               }
               else
               {
                  if ( GXutil.strcmp(GXutil.trim( AV82ConFormula), "1") == 0 )
                  {
                     AV86dependenciasResueltas = true ;
                     AV110Resultado = DecimalUtil.doubleToDec(1) ;
                  }
                  AV202LiqDFormula = AV82ConFormula ;
                  AV97LiqDFormulaHTML = AV82ConFormula ;
                  AV100LiqDReFormulaHTML = AV82ConFormula ;
               }
               AV163LiqDLog = GXutil.trim( AV187altaProrrateoLiqDLog) + " " + AV188resolverLiqDLog ;
               if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "CAL047", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "depes ", "")+GXutil.trim( GXutil.booltostr( AV86dependenciasResueltas))+httpContext.getMessage( " ok ", "")+GXutil.trim( GXutil.booltostr( AV201ok))+httpContext.getMessage( " &LiqDFormula ", "")+GXutil.trim( AV202LiqDFormula)+httpContext.getMessage( " &msgError ", "")+AV164msgError+httpContext.getMessage( " &conformula ", "")+GXutil.trim( AV82ConFormula)) ;
               }
               if ( ! (GXutil.strcmp("", AV202LiqDFormula)==0) )
               {
                  if ( ! AV201ok )
                  {
                     AV95LiqDErrorDesc = AV164msgError ;
                     if ( AV86dependenciasResueltas )
                     {
                        new web.msgdebug7(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "error formula ", "")+AV88errores) ;
                     }
                     else
                     {
                        new web.msgdebug8(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "todavia no estan resueltas las dependencias", "")) ;
                     }
                  }
                  else
                  {
                     AV80Calculo = AV110Resultado ;
                     new web.msgdebug(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "ASIGNA ", "")+GXutil.trim( GXutil.str( AV110Resultado, 14, 2))+httpContext.getMessage( " a ", "")+GXutil.trim( AV81ConCodigo)) ;
                  }
               }
               else
               {
                  AV95LiqDErrorDesc = httpContext.getMessage( "Error: Formula vacia", "") ;
               }
            }
            else
            {
               AV202LiqDFormula = AV82ConFormula ;
               AV97LiqDFormulaHTML = AV82ConFormula ;
            }
         }
         else
         {
            if ( ( AV84ConVigencia == 1 ) || new web.esredondeoosobregiro(remoteHandle, context).executeUdp( AV12CliCod, AV81ConCodigo) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV86dependenciasResueltas = true ;
               AV163LiqDLog += httpContext.getMessage( ". Fuerza como resuelto al no tener fòrmula y ser de vigencia por novedad", "") ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "&dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV86dependenciasResueltas))) ;
         if ( AV86dependenciasResueltas )
         {
            AV93LiqDCalculado = (byte)(1) ;
         }
         else
         {
            AV93LiqDCalculado = (byte)(0) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "cerea liqdcalculado3", "")) ;
         }
         if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&&&&LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))+httpContext.getMessage( " &&dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV86dependenciasResueltas))) ;
         }
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV128parmLiqDErrorDesc)==0) )
         {
            AV95LiqDErrorDesc = AV128parmLiqDErrorDesc ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV98LiqDImpCalcu, 14, 2))) ;
         AV80Calculo = AV98LiqDImpCalcu ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "calulazo ", "")+GXutil.trim( GXutil.str( AV80Calculo, 14, 2))) ;
         AV93LiqDCalculado = (byte)(1) ;
         if ( AV126forzarCero )
         {
            AV202LiqDFormula = "0" ;
            AV83ConRecalcular = true ;
         }
         else
         {
            AV202LiqDFormula = GXutil.trim( GXutil.str( AV98LiqDImpCalcu, 14, 2)) ;
         }
         AV97LiqDFormulaHTML = AV202LiqDFormula ;
      }
      if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&parmLiqDCanti ", "")+GXutil.trim( GXutil.str( AV144parmLiqDCanti, 14, 2))+httpContext.getMessage( " &LiqDCanti ", "")+GXutil.trim( GXutil.str( AV94LiqDCanti, 14, 2))) ;
      }
      if ( ! new web.testperformancefalse(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         /*
            INSERT RECORD ON TABLE LiquidacionDetalle

         */
         A3CliCod = AV12CliCod ;
         A1EmpCod = AV19EmpCod ;
         A31LiqNro = AV55LiqNro ;
         A6LegNumero = AV92LegNumero ;
         A394DConCodigo = AV81ConCodigo ;
         AV138LiqDUniMed = "" ;
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV144parmLiqDCanti)==0) )
         {
            if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&&&&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV203ConOpeEsCant, 14, 2))+httpContext.getMessage( " &cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV137cantidadCalculada, 6, 2))) ;
            }
            GXv_decimal29[0] = AV94LiqDCanti ;
            GXv_char24[0] = AV138LiqDUniMed ;
            new web.definecantiyunimed(remoteHandle, context).execute( AV203ConOpeEsCant, AV93LiqDCalculado, AV137cantidadCalculada, GXv_decimal29, GXv_char24) ;
            newliquidaciondetalle3.this.AV94LiqDCanti = GXv_decimal29[0] ;
            newliquidaciondetalle3.this.AV138LiqDUniMed = GXv_char24[0] ;
            if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&&&LiqDCanti ", "")+GXutil.trim( GXutil.str( AV94LiqDCanti, 14, 2))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))) ;
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94LiqDCanti)==0) && ( AV93LiqDCalculado == 1 ) )
            {
               AV94LiqDCanti = DecimalUtil.doubleToDec(1) ;
            }
         }
         else
         {
            AV94LiqDCanti = AV144parmLiqDCanti ;
            GXv_decimal29[0] = AV80Calculo ;
            GXv_decimal28[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean19[0] = false ;
            GXv_char24[0] = "" ;
            new web.calculomultiporcantimplicito(remoteHandle, context).execute( AV12CliCod, AV82ConFormula, AV84ConVigencia, AV94LiqDCanti, AV99LiqDImporte, GXv_decimal29, GXv_decimal28, GXv_boolean19, GXv_char24) ;
            newliquidaciondetalle3.this.AV80Calculo = GXv_decimal29[0] ;
         }
         if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&&&graba en liqdcanti ", "")+GXutil.trim( GXutil.str( AV94LiqDCanti, 14, 2))+httpContext.getMessage( " calculo ", "")+GXutil.trim( GXutil.str( AV80Calculo, 14, 2))) ;
         }
         A269LiqDCanti = AV94LiqDCanti ;
         n269LiqDCanti = false ;
         A968LiqDUniMed = AV138LiqDUniMed ;
         A276LiqDImporte = AV99LiqDImporte ;
         n276LiqDImporte = false ;
         if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "graba &Calculo ", "")+GXutil.trim( GXutil.str( AV80Calculo, 14, 2))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))) ;
         }
         A275LiqDImpCalcu = GXutil.roundDecimal( AV80Calculo, 2) ;
         n275LiqDImpCalcu = false ;
         A764LiqDImpReCalcu = GXutil.roundDecimal( AV80Calculo, 2) ;
         A81LiqDSecuencial = AV51LiqDSecuencial ;
         A466DConVariable = AV195ConVariable ;
         if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "CAL058", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&LiqDMostrar ", "")+GXutil.trim( GXutil.str( AV50LiqDMostrar, 1, 0))+httpContext.getMessage( " LiqDMostrar ", "")+GXutil.trim( GXutil.str( A502LiqDMostrar, 1, 0))) ;
         }
         A509LiqDOrdEjec = AV199ConOrdEjec ;
         A274LiqDFormula = AV202LiqDFormula ;
         n274LiqDFormula = false ;
         A504LiqDForOrig = AV82ConFormula ;
         A508LiqDFormulaHTML = AV97LiqDFormulaHTML ;
         n508LiqDFormulaHTML = false ;
         A876LiqDReFormulaHTML = AV97LiqDFormulaHTML ;
         n876LiqDReFormulaHTML = false ;
         A471DConOrden = AV198ConOrden ;
         if ( ( GXutil.strcmp(AV196SubTipoConCod1, new web.subtiposac(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV113SubTipoConCod2, new web.subtipo2gananciassac(remoteHandle, context).executeUdp( )) == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            GXt_char30 = AV182anticipoSacConCodigo ;
            GXt_char31 = AV182anticipoSacConCodigo ;
            GXv_char24[0] = GXt_char31 ;
            new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char24) ;
            newliquidaciondetalle3.this.GXt_char31 = GXv_char24[0] ;
            GXv_char23[0] = GXt_char30 ;
            new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char31, GXv_char23) ;
            newliquidaciondetalle3.this.GXt_char30 = GXv_char23[0] ;
            AV182anticipoSacConCodigo = GXt_char30 ;
            GXt_int32 = A1134LiqDOrdVis ;
            GXv_int11[0] = GXt_int32 ;
            new web.getordenconcepto(remoteHandle, context).execute( AV12CliCod, AV182anticipoSacConCodigo, GXv_int11) ;
            newliquidaciondetalle3.this.GXt_int32 = GXv_int11[0] ;
            A1134LiqDOrdVis = (short)(GXt_int32) ;
         }
         else
         {
            A1134LiqDOrdVis = (short)(AV198ConOrden) ;
         }
         A400DTLiqCod = AV75TLiqCod ;
         A397DLiqPeriodo = AV56LiqPeriodo ;
         A468DSubTipoConCod1 = GXutil.trim( AV196SubTipoConCod1) ;
         n468DSubTipoConCod1 = false ;
         A732DSubTipoConCod2 = GXutil.trim( AV113SubTipoConCod2) ;
         n732DSubTipoConCod2 = false ;
         A393DConDescrip = AV193ConDescrip ;
         A464DTipoConCod = AV194TipoConCod ;
         A742DLiqPerAno = (short)(GXutil.year( AV56LiqPeriodo)) ;
         if ( ! AV83ConRecalcular )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            A763LiqDRecalculado = (short)(2) ;
         }
         else
         {
            A763LiqDRecalculado = (short)(1) ;
         }
         A1122DAplIIGG = AV200DAplIIGG ;
         n1122DAplIIGG = false ;
         if ( ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "CAL019", "")) == 0 ) || ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "CAL024", "")) == 0 ) || ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM060", "")) == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.msgdebug_aux(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "INSERTA DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " CON LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))) ;
         }
         if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM019", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&LiqDMostrar ", "")+GXutil.trim( GXutil.str( AV50LiqDMostrar, 1, 0))) ;
         }
         if ( ! (0==AV50LiqDMostrar) )
         {
            A502LiqDMostrar = AV50LiqDMostrar ;
         }
         else
         {
            GXt_boolean33 = AV192EsConceptoImprimible ;
            GXv_boolean19[0] = GXt_boolean33 ;
            new web.esconceptoimprimible(remoteHandle, context).execute( A464DTipoConCod, GXv_boolean19) ;
            newliquidaciondetalle3.this.GXt_boolean33 = GXv_boolean19[0] ;
            AV192EsConceptoImprimible = GXt_boolean33 ;
            if ( GXutil.strcmp(AV81ConCodigo, httpContext.getMessage( "REM011", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&EsConceptoImprimible ", "")+GXutil.trim( GXutil.booltostr( AV192EsConceptoImprimible))+httpContext.getMessage( " LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( A275LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &ConMostrarPos ", "")+GXutil.trim( GXutil.booltostr( AV161ConMostrarPos))) ;
            }
            if ( ( AV192EsConceptoImprimible ) && ( ( ( A275LiqDImpCalcu.doubleValue() > 0 ) && ( AV161ConMostrarPos ) ) || ( ( A275LiqDImpCalcu.doubleValue() != 0 ) && ! AV161ConMostrarPos ) ) )
            {
               A502LiqDMostrar = (byte)(3) ;
            }
            else
            {
               if ( AV93LiqDCalculado == 1 )
               {
                  if ( A275LiqDImpCalcu.doubleValue() > 0 )
                  {
                     A502LiqDMostrar = (byte)(2) ;
                  }
                  else
                  {
                     A502LiqDMostrar = (byte)(0) ;
                  }
               }
               else
               {
                  A502LiqDMostrar = (byte)(0) ;
               }
            }
         }
         if ( GXutil.strcmp(GXutil.trim( A393DConDescrip), httpContext.getMessage( "DESCUENTOS DE LEY SOBRE IMPUESTO GRAVADO SIN CONTEMPLAR ANTICIPO DE SAC", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "LO GRAVA CON LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))) ;
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV143BaseImportes)==0) )
         {
            GXv_decimal29[0] = AV143BaseImportes ;
            new web.definebasedecalculo(remoteHandle, context).execute( A275LiqDImpCalcu, A269LiqDCanti, AV138LiqDUniMed, GXv_decimal29) ;
            newliquidaciondetalle3.this.AV143BaseImportes = GXv_decimal29[0] ;
         }
         A277LiqDValUni = AV143BaseImportes ;
         n277LiqDValUni = false ;
         GXv_int22[0] = AV152LiqDSIPAApo ;
         GXv_int20[0] = AV151LiqDSIPACont ;
         GXv_int14[0] = AV150LiqDINSSJyPApo ;
         GXv_int34[0] = AV149LiqDINSSJyPCont ;
         GXv_int35[0] = AV148LiqDObraSocApo ;
         GXv_int36[0] = AV147LiqDObraSocCont ;
         GXv_int37[0] = AV153LiqDFonSolRedApo ;
         GXv_int38[0] = AV154LiqDFonSolRedCont ;
         GXv_int39[0] = AV155LiqDRenateaApo ;
         GXv_int40[0] = AV156LiqDRenateaCont ;
         GXv_int41[0] = AV157LiqDAsigFamCont ;
         GXv_int42[0] = AV158LiqDFonNacEmpCont ;
         GXv_int43[0] = AV146LiqDLeyRieTrabCont ;
         GXv_int44[0] = AV159LiqDRegDifApo ;
         GXv_int45[0] = AV145LiqDRegEspApo ;
         new web.conceptoafipgettildes(remoteHandle, context).execute( AV12CliCod, AV81ConCodigo, GXv_int22, GXv_int20, GXv_int14, GXv_int34, GXv_int35, GXv_int36, GXv_int37, GXv_int38, GXv_int39, GXv_int40, GXv_int41, GXv_int42, GXv_int43, GXv_int44, GXv_int45) ;
         newliquidaciondetalle3.this.AV152LiqDSIPAApo = GXv_int22[0] ;
         newliquidaciondetalle3.this.AV151LiqDSIPACont = GXv_int20[0] ;
         newliquidaciondetalle3.this.AV150LiqDINSSJyPApo = GXv_int14[0] ;
         newliquidaciondetalle3.this.AV149LiqDINSSJyPCont = GXv_int34[0] ;
         newliquidaciondetalle3.this.AV148LiqDObraSocApo = GXv_int35[0] ;
         newliquidaciondetalle3.this.AV147LiqDObraSocCont = GXv_int36[0] ;
         newliquidaciondetalle3.this.AV153LiqDFonSolRedApo = GXv_int37[0] ;
         newliquidaciondetalle3.this.AV154LiqDFonSolRedCont = GXv_int38[0] ;
         newliquidaciondetalle3.this.AV155LiqDRenateaApo = GXv_int39[0] ;
         newliquidaciondetalle3.this.AV156LiqDRenateaCont = GXv_int40[0] ;
         newliquidaciondetalle3.this.AV157LiqDAsigFamCont = GXv_int41[0] ;
         newliquidaciondetalle3.this.AV158LiqDFonNacEmpCont = GXv_int42[0] ;
         newliquidaciondetalle3.this.AV146LiqDLeyRieTrabCont = GXv_int43[0] ;
         newliquidaciondetalle3.this.AV159LiqDRegDifApo = GXv_int44[0] ;
         newliquidaciondetalle3.this.AV145LiqDRegEspApo = GXv_int45[0] ;
         A1051LiqDSIPAApo = AV152LiqDSIPAApo ;
         A1052LiqDSIPACont = AV151LiqDSIPACont ;
         A1053LiqDINSSJyPApo = AV150LiqDINSSJyPApo ;
         A1054LiqDINSSJyPCont = AV149LiqDINSSJyPCont ;
         A1055LiqDObraSocApo = AV148LiqDObraSocApo ;
         A1056LiqDObraSocCont = AV147LiqDObraSocCont ;
         A1057LiqDFonSolRedApo = AV153LiqDFonSolRedApo ;
         A1058LiqDFonSolRedCont = AV154LiqDFonSolRedCont ;
         A1059LiqDRenateaApo = AV155LiqDRenateaApo ;
         A1060LiqDRenateaCont = AV156LiqDRenateaCont ;
         A1061LiqDAsigFamCont = AV157LiqDAsigFamCont ;
         A1062LiqDFonNacEmpCont = AV158LiqDFonNacEmpCont ;
         A1063LiqDLeyRieTrabCont = AV146LiqDLeyRieTrabCont ;
         A1064LiqDRegDifApo = AV159LiqDRegDifApo ;
         A1065LiqDRegEspApo = AV145LiqDRegEspApo ;
         A1067DConPrereq = AV160ConPreReq ;
         n1067DConPrereq = false ;
         A1073LiqDNovedad = AV165LiqDNovedad ;
         A1078LiqDAdelDescu = AV169ConAdelDescu ;
         n1078LiqDAdelDescu = false ;
         A1125LiqDProrr = AV170AplIIGGPrrtear ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV248Pgmname, httpContext.getMessage( "concepto ", "")+GXutil.trim( AV81ConCodigo)+httpContext.getMessage( " le pone &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))) ;
         A507LiqDCalculado = AV93LiqDCalculado ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV81ConCodigo)+httpContext.getMessage( " &TipoConCod ", "")+AV194TipoConCod+httpContext.getMessage( " &AplIIGG ", "")+GXutil.trim( GXutil.str( AV200DAplIIGG, 4, 0))+httpContext.getMessage( " &descalculo ", "")+GXutil.trim( GXutil.booltostr( AV222descalculo))) ;
         if ( AV223descalculoRequisito )
         {
            AV86dependenciasResueltas = false ;
         }
         A270LiqDErrorDesc = AV95LiqDErrorDesc ;
         n270LiqDErrorDesc = false ;
         if ( ! (GXutil.strcmp("", AV163LiqDLog)==0) )
         {
            A1070LiqDLog = AV163LiqDLog ;
            A1072LiqDLogRecal = AV163LiqDLog ;
         }
         else
         {
            A1070LiqDLog = GXutil.trim( A508LiqDFormulaHTML) ;
            A1072LiqDLogRecal = GXutil.trim( A876LiqDReFormulaHTML) ;
         }
         AV204AHORA = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV190segundos = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV204AHORA, AV191comienzo)) ;
         if ( AV190segundos.doubleValue() > 9 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV248Pgmname, httpContext.getMessage( "&AHORA ", "")+GXutil.trim( localUtil.ttoc( AV204AHORA, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"  "+GXutil.trim( localUtil.ttoc( AV191comienzo, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+httpContext.getMessage( " &segundos ", "")+GXutil.trim( GXutil.str( AV190segundos, 8, 6))) ;
            AV190segundos = DecimalUtil.doubleToDec(9) ;
         }
         A1469LiqDSeg = AV190segundos ;
         GXt_char31 = AV168loguearFallidosPalabra ;
         GXt_char30 = AV168loguearFallidosPalabra ;
         GXv_char24[0] = GXt_char30 ;
         new web.logfallidos_codigoparam(remoteHandle, context).execute( GXv_char24) ;
         newliquidaciondetalle3.this.GXt_char30 = GXv_char24[0] ;
         GXv_char23[0] = GXt_char31 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char30, GXv_char23) ;
         newliquidaciondetalle3.this.GXt_char31 = GXv_char23[0] ;
         AV168loguearFallidosPalabra = GXt_char31 ;
         AV167loguearFallidos = GXutil.boolval( AV168loguearFallidosPalabra) ;
         if ( ! (GXutil.strcmp("", AV95LiqDErrorDesc)==0) && ( AV167loguearFallidos ) )
         {
            A1070LiqDLog += ". " + GXutil.trim( AV95LiqDErrorDesc) + httpContext.getMessage( " (vuelta 1)", "") ;
            A1072LiqDLogRecal += ". " + GXutil.trim( AV95LiqDErrorDesc) + httpContext.getMessage( " (vuelta 1)", "") ;
         }
         if ( false )
         {
            AV183LiqLog = httpContext.getMessage( "Inserta ", "") + GXutil.trim( A394DConCodigo) + httpContext.getMessage( " LiqDCalculado ", "") + GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0)) + httpContext.getMessage( " &dependenciasResueltas ", "") + GXutil.trim( GXutil.booltostr( AV86dependenciasResueltas)) ;
            new web.actualizalogliquidacion(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV55LiqNro, AV183LiqLog) ;
         }
         A1210LiqDLote = AV221LiqDLote ;
         A1219LiqDPlus = AV224LiqDPlus ;
         A1642DConLiqBasica = AV230ConLiqBasica ;
         n1642DConLiqBasica = false ;
         A2149LiqDClasifAux = AV244ConClasifAux ;
         A1753DConConveCodigo = AV233ConveCodigo ;
         A1760DAgeFecDes = AV234DAgeFecDes ;
         n1760DAgeFecDes = false ;
         A2431DAgeFecHas = AV245DAgeFecHas ;
         n2431DAgeFecHas = false ;
         A749LiqDFormuAux = "" ;
         n749LiqDFormuAux = false ;
         A765LiqdFormuRecalc = "" ;
         n765LiqdFormuRecalc = false ;
         A918LiqDVueltaRes = (byte)(0) ;
         A1487DConCondicion = AV225ConCondicion ;
         /* Using cursor P01AL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial), A394DConCodigo, A393DConDescrip, A397DLiqPeriodo, A400DTLiqCod, A464DTipoConCod, Boolean.valueOf(n468DSubTipoConCod1), A468DSubTipoConCod1, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n276LiqDImporte), A276LiqDImporte, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, Boolean.valueOf(A466DConVariable), Integer.valueOf(A471DConOrden), Byte.valueOf(A502LiqDMostrar), A504LiqDForOrig, Byte.valueOf(A507LiqDCalculado), Boolean.valueOf(n508LiqDFormulaHTML), A508LiqDFormulaHTML, Long.valueOf(A509LiqDOrdEjec), Boolean.valueOf(n732DSubTipoConCod2), A732DSubTipoConCod2, Short.valueOf(A742DLiqPerAno), Boolean.valueOf(n749LiqDFormuAux), A749LiqDFormuAux, Short.valueOf(A763LiqDRecalculado), A764LiqDImpReCalcu, Boolean.valueOf(n765LiqdFormuRecalc), A765LiqdFormuRecalc, Boolean.valueOf(n876LiqDReFormulaHTML), A876LiqDReFormulaHTML, Byte.valueOf(A918LiqDVueltaRes), A968LiqDUniMed, Byte.valueOf(A1051LiqDSIPAApo), Byte.valueOf(A1052LiqDSIPACont), Byte.valueOf(A1053LiqDINSSJyPApo), Byte.valueOf(A1054LiqDINSSJyPCont), Byte.valueOf(A1055LiqDObraSocApo), Byte.valueOf(A1056LiqDObraSocCont), Byte.valueOf(A1057LiqDFonSolRedApo), Byte.valueOf(A1058LiqDFonSolRedCont), Byte.valueOf(A1059LiqDRenateaApo), Byte.valueOf(A1060LiqDRenateaCont), Byte.valueOf(A1061LiqDAsigFamCont), Byte.valueOf(A1062LiqDFonNacEmpCont), Byte.valueOf(A1063LiqDLeyRieTrabCont), Byte.valueOf(A1064LiqDRegDifApo), Byte.valueOf(A1065LiqDRegEspApo), Boolean.valueOf(n1067DConPrereq), A1067DConPrereq, A1070LiqDLog, A1072LiqDLogRecal, Boolean.valueOf(A1073LiqDNovedad), Boolean.valueOf(n1078LiqDAdelDescu), Byte.valueOf(A1078LiqDAdelDescu), Boolean.valueOf(n1122DAplIIGG), Short.valueOf(A1122DAplIIGG), A1125LiqDProrr, Short.valueOf(A1134LiqDOrdVis), Byte.valueOf(A1210LiqDLote), A1219LiqDPlus, A1469LiqDSeg, A1487DConCondicion, Boolean.valueOf(n1642DConLiqBasica), Byte.valueOf(A1642DConLiqBasica), A1753DConConveCodigo, Boolean.valueOf(n1760DAgeFecDes), A1760DAgeFecDes, A2149LiqDClasifAux, Boolean.valueOf(n2431DAgeFecHas), A2431DAgeFecHas});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         if ( (pr_default.getStatus(0) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP22[0] = newliquidaciondetalle3.this.AV80Calculo;
      this.aP23[0] = newliquidaciondetalle3.this.AV86dependenciasResueltas;
      this.aP24[0] = newliquidaciondetalle3.this.AV82ConFormula;
      this.aP25[0] = newliquidaciondetalle3.this.AV164msgError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV80Calculo = DecimalUtil.ZERO ;
      AV82ConFormula = "" ;
      AV164msgError = "" ;
      AV191comienzo = GXutil.resetTime( GXutil.nullDate() );
      AV248Pgmname = "" ;
      AV193ConDescrip = "" ;
      GXv_char1 = new String[1] ;
      AV194TipoConCod = "" ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV196SubTipoConCod1 = "" ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      AV113SubTipoConCod2 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_int12 = new long[1] ;
      GXv_int16 = new short[1] ;
      AV160ConPreReq = "" ;
      AV225ConCondicion = "" ;
      AV233ConveCodigo = "" ;
      AV244ConClasifAux = "" ;
      AV170AplIIGGPrrtear = "" ;
      AV98LiqDImpCalcu = DecimalUtil.ZERO ;
      AV187altaProrrateoLiqDLog = "" ;
      AV238altaCuotaIdOperando = "" ;
      A394DConCodigo = "" ;
      AV240tipo_cuota = "" ;
      A1125LiqDProrr = "" ;
      AV185altaProrrateoError = "" ;
      AV202LiqDFormula = "" ;
      AV97LiqDFormulaHTML = "" ;
      GXv_char21 = new String[1] ;
      GXv_char18 = new String[1] ;
      AV110Resultado = DecimalUtil.ZERO ;
      GXv_decimal25 = new java.math.BigDecimal[1] ;
      GXv_boolean17 = new boolean[1] ;
      AV203ConOpeEsCant = DecimalUtil.ZERO ;
      GXv_decimal26 = new java.math.BigDecimal[1] ;
      GXv_boolean15 = new boolean[1] ;
      AV137cantidadCalculada = DecimalUtil.ZERO ;
      GXv_decimal27 = new java.math.BigDecimal[1] ;
      AV143BaseImportes = DecimalUtil.ZERO ;
      GXv_boolean5 = new boolean[1] ;
      AV188resolverLiqDLog = "" ;
      GXv_char13 = new String[1] ;
      AV224LiqDPlus = DecimalUtil.ZERO ;
      GXv_boolean4 = new boolean[1] ;
      AV100LiqDReFormulaHTML = "" ;
      AV163LiqDLog = "" ;
      AV95LiqDErrorDesc = "" ;
      AV88errores = "" ;
      AV128parmLiqDErrorDesc = "" ;
      AV94LiqDCanti = DecimalUtil.ZERO ;
      AV138LiqDUniMed = "" ;
      GXv_decimal28 = new java.math.BigDecimal[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A968LiqDUniMed = "" ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A274LiqDFormula = "" ;
      A504LiqDForOrig = "" ;
      A508LiqDFormulaHTML = "" ;
      A876LiqDReFormulaHTML = "" ;
      AV182anticipoSacConCodigo = "" ;
      GXv_int11 = new int[1] ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A468DSubTipoConCod1 = "" ;
      A732DSubTipoConCod2 = "" ;
      A393DConDescrip = "" ;
      A464DTipoConCod = "" ;
      GXv_boolean19 = new boolean[1] ;
      GXv_decimal29 = new java.math.BigDecimal[1] ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      GXv_int22 = new byte[1] ;
      GXv_int20 = new byte[1] ;
      GXv_int14 = new byte[1] ;
      GXv_int34 = new byte[1] ;
      GXv_int35 = new byte[1] ;
      GXv_int36 = new byte[1] ;
      GXv_int37 = new byte[1] ;
      GXv_int38 = new byte[1] ;
      GXv_int39 = new byte[1] ;
      GXv_int40 = new byte[1] ;
      GXv_int41 = new byte[1] ;
      GXv_int42 = new byte[1] ;
      GXv_int43 = new byte[1] ;
      GXv_int44 = new byte[1] ;
      GXv_int45 = new byte[1] ;
      A1067DConPrereq = "" ;
      A270LiqDErrorDesc = "" ;
      A1070LiqDLog = "" ;
      A1072LiqDLogRecal = "" ;
      AV204AHORA = GXutil.resetTime( GXutil.nullDate() );
      AV190segundos = DecimalUtil.ZERO ;
      A1469LiqDSeg = DecimalUtil.ZERO ;
      AV168loguearFallidosPalabra = "" ;
      GXt_char31 = "" ;
      GXt_char30 = "" ;
      GXv_char24 = new String[1] ;
      GXv_char23 = new String[1] ;
      AV183LiqLog = "" ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      A2149LiqDClasifAux = "" ;
      A1753DConConveCodigo = "" ;
      A1760DAgeFecDes = GXutil.nullDate() ;
      A2431DAgeFecHas = GXutil.nullDate() ;
      A749LiqDFormuAux = "" ;
      A765LiqdFormuRecalc = "" ;
      A1487DConCondicion = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newliquidaciondetalle3__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV248Pgmname = "NewLiquidacionDetalle3" ;
      /* GeneXus formulas. */
      AV248Pgmname = "NewLiquidacionDetalle3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV50LiqDMostrar ;
   private byte AV221LiqDLote ;
   private byte AV84ConVigencia ;
   private byte AV169ConAdelDescu ;
   private byte AV230ConLiqBasica ;
   private byte AV186altaProrraLiqDCalculado ;
   private byte AV93LiqDCalculado ;
   private byte A502LiqDMostrar ;
   private byte A507LiqDCalculado ;
   private byte AV152LiqDSIPAApo ;
   private byte GXv_int22[] ;
   private byte AV151LiqDSIPACont ;
   private byte GXv_int20[] ;
   private byte AV150LiqDINSSJyPApo ;
   private byte GXv_int14[] ;
   private byte AV149LiqDINSSJyPCont ;
   private byte GXv_int34[] ;
   private byte AV148LiqDObraSocApo ;
   private byte GXv_int35[] ;
   private byte AV147LiqDObraSocCont ;
   private byte GXv_int36[] ;
   private byte AV153LiqDFonSolRedApo ;
   private byte GXv_int37[] ;
   private byte AV154LiqDFonSolRedCont ;
   private byte GXv_int38[] ;
   private byte AV155LiqDRenateaApo ;
   private byte GXv_int39[] ;
   private byte AV156LiqDRenateaCont ;
   private byte GXv_int40[] ;
   private byte AV157LiqDAsigFamCont ;
   private byte GXv_int41[] ;
   private byte AV158LiqDFonNacEmpCont ;
   private byte GXv_int42[] ;
   private byte AV146LiqDLeyRieTrabCont ;
   private byte GXv_int43[] ;
   private byte AV159LiqDRegDifApo ;
   private byte GXv_int44[] ;
   private byte AV145LiqDRegEspApo ;
   private byte GXv_int45[] ;
   private byte A1051LiqDSIPAApo ;
   private byte A1052LiqDSIPACont ;
   private byte A1053LiqDINSSJyPApo ;
   private byte A1054LiqDINSSJyPCont ;
   private byte A1055LiqDObraSocApo ;
   private byte A1056LiqDObraSocCont ;
   private byte A1057LiqDFonSolRedApo ;
   private byte A1058LiqDFonSolRedCont ;
   private byte A1059LiqDRenateaApo ;
   private byte A1060LiqDRenateaCont ;
   private byte A1061LiqDAsigFamCont ;
   private byte A1062LiqDFonNacEmpCont ;
   private byte A1063LiqDLeyRieTrabCont ;
   private byte A1064LiqDRegDifApo ;
   private byte A1065LiqDRegEspApo ;
   private byte A1078LiqDAdelDescu ;
   private byte A1210LiqDLote ;
   private byte A1642DConLiqBasica ;
   private byte A918LiqDVueltaRes ;
   private short AV19EmpCod ;
   private short AV200DAplIIGG ;
   private short GXv_int16[] ;
   private short A1122DAplIIGG ;
   private short A1EmpCod ;
   private short A1134LiqDOrdVis ;
   private short A742DLiqPerAno ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV55LiqNro ;
   private int AV241LiqRelNro ;
   private int AV92LegNumero ;
   private int AV51LiqDSecuencial ;
   private int AV198ConOrden ;
   private int GX_INS26 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int A471DConOrden ;
   private int GXt_int32 ;
   private int GXv_int11[] ;
   private long AV199ConOrdEjec ;
   private long GXv_int12[] ;
   private long A509LiqDOrdEjec ;
   private java.math.BigDecimal AV99LiqDImporte ;
   private java.math.BigDecimal AV144parmLiqDCanti ;
   private java.math.BigDecimal AV101LiqDValUni ;
   private java.math.BigDecimal AV229parmLiqDImpCalcu ;
   private java.math.BigDecimal AV80Calculo ;
   private java.math.BigDecimal AV98LiqDImpCalcu ;
   private java.math.BigDecimal AV110Resultado ;
   private java.math.BigDecimal GXv_decimal25[] ;
   private java.math.BigDecimal AV203ConOpeEsCant ;
   private java.math.BigDecimal GXv_decimal26[] ;
   private java.math.BigDecimal AV137cantidadCalculada ;
   private java.math.BigDecimal GXv_decimal27[] ;
   private java.math.BigDecimal AV143BaseImportes ;
   private java.math.BigDecimal AV224LiqDPlus ;
   private java.math.BigDecimal AV94LiqDCanti ;
   private java.math.BigDecimal GXv_decimal28[] ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal GXv_decimal29[] ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal AV190segundos ;
   private java.math.BigDecimal A1469LiqDSeg ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private String AV81ConCodigo ;
   private String AV75TLiqCod ;
   private String AV248Pgmname ;
   private String GXv_char1[] ;
   private String AV194TipoConCod ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV196SubTipoConCod1 ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String AV113SubTipoConCod2 ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String AV160ConPreReq ;
   private String AV225ConCondicion ;
   private String AV233ConveCodigo ;
   private String AV170AplIIGGPrrtear ;
   private String AV238altaCuotaIdOperando ;
   private String A394DConCodigo ;
   private String AV240tipo_cuota ;
   private String A1125LiqDProrr ;
   private String GXv_char21[] ;
   private String GXv_char18[] ;
   private String GXv_char13[] ;
   private String AV138LiqDUniMed ;
   private String A968LiqDUniMed ;
   private String AV182anticipoSacConCodigo ;
   private String A400DTLiqCod ;
   private String A468DSubTipoConCod1 ;
   private String A732DSubTipoConCod2 ;
   private String A464DTipoConCod ;
   private String A1067DConPrereq ;
   private String AV168loguearFallidosPalabra ;
   private String GXt_char31 ;
   private String GXt_char30 ;
   private String GXv_char24[] ;
   private String GXv_char23[] ;
   private String A1753DConConveCodigo ;
   private String A1487DConCondicion ;
   private String Gx_emsg ;
   private java.util.Date AV191comienzo ;
   private java.util.Date AV204AHORA ;
   private java.util.Date AV234DAgeFecDes ;
   private java.util.Date AV245DAgeFecHas ;
   private java.util.Date AV56LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date A1760DAgeFecDes ;
   private java.util.Date A2431DAgeFecHas ;
   private boolean AV189resolver ;
   private boolean AV126forzarCero ;
   private boolean AV165LiqDNovedad ;
   private boolean AV228calculandoOrden ;
   private boolean AV86dependenciasResueltas ;
   private boolean AV195ConVariable ;
   private boolean AV83ConRecalcular ;
   private boolean AV161ConMostrarPos ;
   private boolean AV235altaCuotas ;
   private boolean AV201ok ;
   private boolean GXv_boolean17[] ;
   private boolean AV139OpeCliAliEs ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private boolean n269LiqDCanti ;
   private boolean n276LiqDImporte ;
   private boolean n275LiqDImpCalcu ;
   private boolean A466DConVariable ;
   private boolean n274LiqDFormula ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n1122DAplIIGG ;
   private boolean AV192EsConceptoImprimible ;
   private boolean GXt_boolean33 ;
   private boolean GXv_boolean19[] ;
   private boolean n277LiqDValUni ;
   private boolean n1067DConPrereq ;
   private boolean A1073LiqDNovedad ;
   private boolean n1078LiqDAdelDescu ;
   private boolean AV222descalculo ;
   private boolean AV223descalculoRequisito ;
   private boolean n270LiqDErrorDesc ;
   private boolean AV167loguearFallidos ;
   private boolean n1642DConLiqBasica ;
   private boolean n1760DAgeFecDes ;
   private boolean n2431DAgeFecHas ;
   private boolean n749LiqDFormuAux ;
   private boolean n765LiqdFormuRecalc ;
   private String AV82ConFormula ;
   private String AV187altaProrrateoLiqDLog ;
   private String AV202LiqDFormula ;
   private String AV97LiqDFormulaHTML ;
   private String AV188resolverLiqDLog ;
   private String AV100LiqDReFormulaHTML ;
   private String AV163LiqDLog ;
   private String A274LiqDFormula ;
   private String A504LiqDForOrig ;
   private String A508LiqDFormulaHTML ;
   private String A876LiqDReFormulaHTML ;
   private String A1070LiqDLog ;
   private String A1072LiqDLogRecal ;
   private String AV183LiqLog ;
   private String A765LiqdFormuRecalc ;
   private String AV239importadoConDescrip ;
   private String AV164msgError ;
   private String AV193ConDescrip ;
   private String AV244ConClasifAux ;
   private String AV185altaProrrateoError ;
   private String AV95LiqDErrorDesc ;
   private String AV88errores ;
   private String AV128parmLiqDErrorDesc ;
   private String A393DConDescrip ;
   private String A270LiqDErrorDesc ;
   private String A2149LiqDClasifAux ;
   private String A749LiqDFormuAux ;
   private String[] aP25 ;
   private java.math.BigDecimal[] aP22 ;
   private boolean[] aP23 ;
   private String[] aP24 ;
   private IDataStoreProvider pr_default ;
}

final  class newliquidaciondetalle3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01AL2", "SAVEPOINT gxupdate;INSERT INTO LiquidacionDetalle(CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial, DConCodigo, DConDescrip, DLiqPeriodo, DTLiqCod, DTipoConCod, DSubTipoConCod1, LiqDCanti, LiqDValUni, LiqDImporte, LiqDImpCalcu, LiqDFormula, LiqDErrorDesc, DConVariable, DConOrden, LiqDMostrar, LiqDForOrig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, DSubTipoConCod2, DLiqPerAno, LiqDFormuAux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, LiqDVueltaRes, LiqDUniMed, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont, LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, DConPrereq, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDOrdVis, LiqDLote, LiqDPlus, LiqDSeg, DConCondicion, DConLiqBasica, DConConveCodigo, DAgeFecDes, LiqDClasifAux, DAgeFecHas) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setString(10, (String)parms[9], 20);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[11], 20);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(12, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(13, (java.math.BigDecimal)parms[15], 2);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(14, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(15, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(16, (String)parms[21]);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(17, (String)parms[23], 400);
               }
               stmt.setBoolean(18, ((Boolean) parms[24]).booleanValue());
               stmt.setInt(19, ((Number) parms[25]).intValue());
               stmt.setByte(20, ((Number) parms[26]).byteValue());
               stmt.setNLongVarchar(21, (String)parms[27], false);
               stmt.setByte(22, ((Number) parms[28]).byteValue());
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(23, (String)parms[30]);
               }
               stmt.setLong(24, ((Number) parms[31]).longValue());
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(25, (String)parms[33], 20);
               }
               stmt.setShort(26, ((Number) parms[34]).shortValue());
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[36], 400);
               }
               stmt.setShort(28, ((Number) parms[37]).shortValue());
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[38], 2);
               if ( ((Boolean) parms[39]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(30, (String)parms[40]);
               }
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(31, (String)parms[42]);
               }
               stmt.setByte(32, ((Number) parms[43]).byteValue());
               stmt.setString(33, (String)parms[44], 20);
               stmt.setByte(34, ((Number) parms[45]).byteValue());
               stmt.setByte(35, ((Number) parms[46]).byteValue());
               stmt.setByte(36, ((Number) parms[47]).byteValue());
               stmt.setByte(37, ((Number) parms[48]).byteValue());
               stmt.setByte(38, ((Number) parms[49]).byteValue());
               stmt.setByte(39, ((Number) parms[50]).byteValue());
               stmt.setByte(40, ((Number) parms[51]).byteValue());
               stmt.setByte(41, ((Number) parms[52]).byteValue());
               stmt.setByte(42, ((Number) parms[53]).byteValue());
               stmt.setByte(43, ((Number) parms[54]).byteValue());
               stmt.setByte(44, ((Number) parms[55]).byteValue());
               stmt.setByte(45, ((Number) parms[56]).byteValue());
               stmt.setByte(46, ((Number) parms[57]).byteValue());
               stmt.setByte(47, ((Number) parms[58]).byteValue());
               stmt.setByte(48, ((Number) parms[59]).byteValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(49, (String)parms[61], 20);
               }
               stmt.setNLongVarchar(50, (String)parms[62], false);
               stmt.setNLongVarchar(51, (String)parms[63], false);
               stmt.setBoolean(52, ((Boolean) parms[64]).booleanValue());
               if ( ((Boolean) parms[65]).booleanValue() )
               {
                  stmt.setNull( 53 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(53, ((Number) parms[66]).byteValue());
               }
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 54 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(54, ((Number) parms[68]).shortValue());
               }
               stmt.setString(55, (String)parms[69], 20);
               stmt.setShort(56, ((Number) parms[70]).shortValue());
               stmt.setByte(57, ((Number) parms[71]).byteValue());
               stmt.setBigDecimal(58, (java.math.BigDecimal)parms[72], 4);
               stmt.setBigDecimal(59, (java.math.BigDecimal)parms[73], 3);
               stmt.setString(60, (String)parms[74], 20);
               if ( ((Boolean) parms[75]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(61, ((Number) parms[76]).byteValue());
               }
               stmt.setString(62, (String)parms[77], 20);
               if ( ((Boolean) parms[78]).booleanValue() )
               {
                  stmt.setNull( 63 , Types.DATE );
               }
               else
               {
                  stmt.setDate(63, (java.util.Date)parms[79]);
               }
               stmt.setVarchar(64, (String)parms[80], 80, false);
               if ( ((Boolean) parms[81]).booleanValue() )
               {
                  stmt.setNull( 65 , Types.DATE );
               }
               else
               {
                  stmt.setDate(65, (java.util.Date)parms[82]);
               }
               return;
      }
   }

}

