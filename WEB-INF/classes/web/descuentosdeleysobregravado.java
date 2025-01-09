package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuentosdeleysobregravado extends GXProcedure
{
   public descuentosdeleysobregravado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuentosdeleysobregravado.class ), "" );
   }

   public descuentosdeleysobregravado( int remoteHandle ,
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
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 )
   {
      descuentosdeleysobregravado.this.aP13 = new String[] {""};
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
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        byte[] aP11 ,
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
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      descuentosdeleysobregravado.this.AV9CliCod = aP0;
      descuentosdeleysobregravado.this.AV10EmpCod = aP1;
      descuentosdeleysobregravado.this.AV11LiqNro = aP2;
      descuentosdeleysobregravado.this.AV93LiqRelNro = aP3;
      descuentosdeleysobregravado.this.AV12LegNumero = aP4;
      descuentosdeleysobregravado.this.AV35LiqPeriodo = aP5;
      descuentosdeleysobregravado.this.AV81ConCodigo = aP6;
      descuentosdeleysobregravado.this.AV50contemplarAnticipoDeSac = aP7;
      descuentosdeleysobregravado.this.AV79ProcesoLiquidacion = aP8;
      descuentosdeleysobregravado.this.AV13insertandoConceptos = aP9;
      descuentosdeleysobregravado.this.aP10 = aP10;
      descuentosdeleysobregravado.this.aP11 = aP11;
      descuentosdeleysobregravado.this.aP12 = aP12;
      descuentosdeleysobregravado.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV45finalEs ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.esliquidacionfinal(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV35LiqPeriodo, GXv_boolean2) ;
      descuentosdeleysobregravado.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV45finalEs = GXt_boolean1 ;
      GXt_char3 = AV51liquidaSACConCodigo ;
      GXt_char4 = AV51liquidaSACConCodigo ;
      GXv_char5[0] = GXt_char4 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
      GXv_char6[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char4, GXv_char6) ;
      descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
      AV51liquidaSACConCodigo = GXt_char3 ;
      AV8LiqDCalculado = (byte)(1) ;
      GXv_decimal7[0] = AV52liquidaSacLiqDImpCalcu ;
      GXv_boolean2[0] = AV58existe ;
      GXv_int8[0] = AV75auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV51liquidaSACConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal7, GXv_boolean2, GXv_int8) ;
      descuentosdeleysobregravado.this.AV52liquidaSacLiqDImpCalcu = GXv_decimal7[0] ;
      descuentosdeleysobregravado.this.AV58existe = GXv_boolean2[0] ;
      descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
      if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
      {
         AV8LiqDCalculado = (byte)(0) ;
         GXt_char4 = AV49dependenciasNoResueltasTxt ;
         GXv_char6[0] = GXt_char4 ;
         new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
         AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV51liquidaSACConCodigo) ;
         AV71LiqDLog += GXutil.trim( AV49dependenciasNoResueltasTxt) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV12LegNumero, 8, 0))+httpContext.getMessage( " &contemplarAnticipoDeSac ", "")+GXutil.trim( GXutil.booltostr( AV50contemplarAnticipoDeSac))+httpContext.getMessage( " final es ", "")+GXutil.trim( GXutil.booltostr( AV45finalEs))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))) ;
      if ( ( ( AV45finalEs ) || ( GXutil.month( AV35LiqPeriodo) == 6 ) ) && ( AV50contemplarAnticipoDeSac ) )
      {
         GXt_char4 = AV55descuentosSobreGravadConCodigo ;
         GXt_char3 = AV55descuentosSobreGravadConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_descuentossobregravados_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV55descuentosSobreGravadConCodigo = GXt_char4 ;
         GXv_decimal7[0] = AV40descuentosSobreGravadoLiqDImpCalcu ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean2[0] = false ;
         GXv_int10[0] = (short)(0) ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         GXv_boolean11[0] = false ;
         GXv_char6[0] = "" ;
         new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV93LiqRelNro, AV12LegNumero, AV55descuentosSobreGravadConCodigo, AV92ConceptoTipo, AV76Date, AV35LiqPeriodo, AV81ConCodigo, "Calculo", false, true, "", true, "", GXv_decimal7, GXv_decimal9, GXv_boolean2, GXv_int10, GXv_int8, GXv_boolean11, GXv_char6) ;
         descuentosdeleysobregravado.this.AV40descuentosSobreGravadoLiqDImpCalcu = GXv_decimal7[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         AV71LiqDLog = httpContext.getMessage( "Inicializa con valor ", "") + GXutil.trim( GXutil.str( AV40descuentosSobreGravadoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " con el acumulado del concepto ", "") + GXutil.trim( AV55descuentosSobreGravadConCodigo) ;
         if ( AV75auxLiqDCalculado == 0 )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV55descuentosSobreGravadConCodigo) ;
            AV71LiqDLog += GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo ;
         GXt_char3 = AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_descuentosleymasdescsobreanticiposac_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV57LiqDImpReCalcu ;
         new web.getvaloresanterioresactualizados(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV93LiqRelNro, AV12LegNumero, AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo, AV35LiqPeriodo, GXv_decimal9) ;
         descuentosdeleysobregravado.this.AV57LiqDImpReCalcu = GXv_decimal9[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "final &descuentosSobreGravadoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV40descuentosSobreGravadoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " ... contemplando ", "")+GXutil.trim( GXutil.str( AV57LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV35LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV40descuentosSobreGravadoLiqDImpCalcu = AV40descuentosSobreGravadoLiqDImpCalcu.subtract(AV57LiqDImpReCalcu) ;
         AV71LiqDLog += httpContext.getMessage( ". Le resta ", "") + GXutil.trim( GXutil.str( AV57LiqDImpReCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a la acumulación de periodos anteriores del concepto ", "") + GXutil.trim( AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "queda ", "")+GXutil.trim( GXutil.str( AV40descuentosSobreGravadoLiqDImpCalcu, 14, 2))) ;
      }
      else
      {
         AV8LiqDCalculado = (byte)(1) ;
         GXt_char4 = AV63basicoJornalConCodigo ;
         GXt_char3 = AV63basicoJornalConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV63basicoJornalConCodigo = GXt_char4 ;
         GXt_char4 = AV78basicoMensualConCodigo ;
         GXt_char3 = AV78basicoMensualConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV78basicoMensualConCodigo = GXt_char4 ;
         GXv_int10[0] = AV77totalmenteExentoDAplIIGG ;
         new web.getapliigg_totalmenteexenta(remoteHandle, context).execute( AV9CliCod, GXv_int10) ;
         descuentosdeleysobregravado.this.AV77totalmenteExentoDAplIIGG = GXv_int10[0] ;
         AV100GXLvl59 = (byte)(0) ;
         /* Using cursor P00YP2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV12LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A464DTipoConCod = P00YP2_A464DTipoConCod[0] ;
            A6LegNumero = P00YP2_A6LegNumero[0] ;
            A31LiqNro = P00YP2_A31LiqNro[0] ;
            A1EmpCod = P00YP2_A1EmpCod[0] ;
            A3CliCod = P00YP2_A3CliCod[0] ;
            A764LiqDImpReCalcu = P00YP2_A764LiqDImpReCalcu[0] ;
            A1122DAplIIGG = P00YP2_A1122DAplIIGG[0] ;
            n1122DAplIIGG = P00YP2_n1122DAplIIGG[0] ;
            A394DConCodigo = P00YP2_A394DConCodigo[0] ;
            A393DConDescrip = P00YP2_A393DConDescrip[0] ;
            A507LiqDCalculado = P00YP2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P00YP2_A763LiqDRecalculado[0] ;
            A81LiqDSecuencial = P00YP2_A81LiqDSecuencial[0] ;
            AV100GXLvl59 = (byte)(1) ;
            AV21sumar = "0" ;
            if ( GXutil.strcmp(A464DTipoConCod, "REM_ARG") == 0 )
            {
               AV21sumar = "1" ;
               AV14remu_LiqDImpCalcu = AV14remu_LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
               if ( A1122DAplIIGG == AV77totalmenteExentoDAplIIGG )
               {
                  AV20totalmenteExentoLiqDImpCalcu = AV20totalmenteExentoLiqDImpCalcu.add(A764LiqDImpReCalcu) ;
               }
               else
               {
                  if ( ( GXutil.strcmp(A394DConCodigo, AV63basicoJornalConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV78basicoMensualConCodigo) == 0 ) )
                  {
                     AV62basicoImportes = AV62basicoImportes.add(A764LiqDImpReCalcu) ;
                  }
               }
            }
            else
            {
               GXv_char6[0] = AV21sumar ;
               new web.conceptoafipgettildeaposipa(remoteHandle, context).execute( A3CliCod, A394DConCodigo, GXv_char6) ;
               descuentosdeleysobregravado.this.AV21sumar = GXv_char6[0] ;
               if ( GXutil.strcmp(AV21sumar, "1") == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, "2") ;
                  AV15noRemuApoSIPALiqDImpCalcu = AV15noRemuApoSIPALiqDImpCalcu.add(A764LiqDImpReCalcu) ;
                  if ( A1122DAplIIGG == AV77totalmenteExentoDAplIIGG )
                  {
                     AV20totalmenteExentoLiqDImpCalcu = AV20totalmenteExentoLiqDImpCalcu.add(A764LiqDImpReCalcu) ;
                  }
               }
            }
            if ( GXutil.strcmp(AV21sumar, "1") == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV99Pgmname, httpContext.getMessage( "1 DConDescrip ", "")+GXutil.trim( A393DConDescrip)) ;
               GXv_int8[0] = AV75auxLiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV9CliCod, A394DConCodigo, AV79ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int8) ;
               descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
               if ( AV75auxLiqDCalculado == 0 )
               {
                  AV8LiqDCalculado = (byte)(0) ;
                  GXt_char4 = AV49dependenciasNoResueltasTxt ;
                  GXv_char6[0] = GXt_char4 ;
                  new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
                  descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
                  AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( A393DConDescrip) ;
                  AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV99Pgmname, httpContext.getMessage( "return 2 DConCodigo ", "")+GXutil.trim( A394DConCodigo)) ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV100GXLvl59 == 0 )
         {
            if ( AV13insertandoConceptos )
            {
               AV8LiqDCalculado = (byte)(0) ;
            }
         }
         if ( AV8LiqDCalculado == 0 )
         {
            AV49dependenciasNoResueltasTxt = httpContext.getMessage( "No hay ningún concepto remunerativo o no remunerativo", "") ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 3", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV18brutoImportes = AV14remu_LiqDImpCalcu.add(AV15noRemuApoSIPALiqDImpCalcu) ;
         AV44OpeCliId = "[base_imp_min]" ;
         GXv_char6[0] = AV43OpeCliValor ;
         GXv_char5[0] = AV94auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV44OpeCliId, AV35LiqPeriodo, AV79ProcesoLiquidacion, GXv_char6, GXv_char5) ;
         descuentosdeleysobregravado.this.AV43OpeCliValor = GXv_char6[0] ;
         descuentosdeleysobregravado.this.AV94auxError = GXv_char5[0] ;
         if ( ! (GXutil.strcmp("", AV94auxError)==0) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV71LiqDLog = AV94auxError ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV70baseImponibleMinima = CommonUtil.decimalVal( AV43OpeCliValor, ".") ;
         if ( DecimalUtil.compareTo(AV18brutoImportes, AV70baseImponibleMinima) < 0 )
         {
            AV18brutoImportes = AV70baseImponibleMinima ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV81ConCodigo)+httpContext.getMessage( " &contemplarAnticipoDeSac ", "")+GXutil.trim( GXutil.booltostr( AV50contemplarAnticipoDeSac))+httpContext.getMessage( " &brutoImportes ", "")+GXutil.trim( GXutil.str( AV18brutoImportes, 14, 2))+httpContext.getMessage( " &remu_LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV14remu_LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &noRemuApoSIPALiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV15noRemuApoSIPALiqDImpCalcu, 14, 2))+httpContext.getMessage( " &baseDifLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV17baseDifLiqDImpCalcu, 14, 2))) ;
         if ( AV50contemplarAnticipoDeSac )
         {
            GXt_char4 = AV54anticipoDeSacConCodigo ;
            GXt_char3 = AV54anticipoDeSacConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV54anticipoDeSacConCodigo = GXt_char4 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&liquidaSacLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV52liquidaSacLiqDImpCalcu, 14, 2))+httpContext.getMessage( " grabosesion", "")) ;
            new web.dependenciasesion(remoteHandle, context).execute( AV54anticipoDeSacConCodigo) ;
            if ( AV52liquidaSacLiqDImpCalcu.doubleValue() == 0 )
            {
               GXv_decimal9[0] = AV53anticipoDeSacLiqDImpCalcu ;
               GXv_boolean11[0] = false ;
               GXv_int8[0] = AV75auxLiqDCalculado ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV54anticipoDeSacConCodigo, AV79ProcesoLiquidacion, false, GXv_decimal9, GXv_boolean11, GXv_int8) ;
               descuentosdeleysobregravado.this.AV53anticipoDeSacLiqDImpCalcu = GXv_decimal9[0] ;
               descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
               if ( AV75auxLiqDCalculado == 0 )
               {
                  AV8LiqDCalculado = (byte)(0) ;
                  GXt_char4 = AV49dependenciasNoResueltasTxt ;
                  GXv_char6[0] = GXt_char4 ;
                  new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
                  descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
                  AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV54anticipoDeSacConCodigo) ;
                  AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "suma &anticipoDeSacLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV53anticipoDeSacLiqDImpCalcu, 14, 2))) ;
               AV18brutoImportes = AV18brutoImportes.add(AV53anticipoDeSacLiqDImpCalcu) ;
            }
            else
            {
               GXv_decimal9[0] = AV53anticipoDeSacLiqDImpCalcu ;
               new web.getvaloresanterioresactualizados(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV93LiqRelNro, AV12LegNumero, AV54anticipoDeSacConCodigo, AV35LiqPeriodo, GXv_decimal9) ;
               descuentosdeleysobregravado.this.AV53anticipoDeSacLiqDImpCalcu = GXv_decimal9[0] ;
               AV18brutoImportes = AV18brutoImportes.subtract(AV53anticipoDeSacLiqDImpCalcu) ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&brutoImportes ", "")+GXutil.trim( GXutil.str( AV18brutoImportes, 14, 2))) ;
         GXt_char4 = AV24horasExtrasExentasConCodigo ;
         GXt_char3 = AV24horasExtrasExentasConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_horasextrasexentas_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV24horasExtrasExentasConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV23horasExtrasExentasLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV24horasExtrasExentasConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV23horasExtrasExentasLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV24horasExtrasExentasConCodigo) + httpContext.getMessage( " &EXISTE ", "") + GXutil.trim( GXutil.booltostr( AV58existe)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 5 &existe ", "")+GXutil.trim( GXutil.booltostr( AV58existe))) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV26BonosExentosConCodigo ;
         GXt_char3 = AV26BonosExentosConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV26BonosExentosConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV25bonosExentosLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV26BonosExentosConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV25bonosExentosLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV26BonosExentosConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 6", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV66fallosCajaExentosConCodigo ;
         GXt_char3 = AV66fallosCajaExentosConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_falloscajaexentos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV66fallosCajaExentosConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV67fallosCajaLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV66fallosCajaExentosConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV67fallosCajaLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV66fallosCajaExentosConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 6 b", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV68simNatExentosConCodigo ;
         GXt_char3 = AV68simNatExentosConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_simnatexenta_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV68simNatExentosConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV69simNatExentosLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV68simNatExentosConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV69simNatExentosLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV68simNatExentosConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 6 c", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV29movilidadYViaticosConCodigo ;
         GXt_char3 = AV29movilidadYViaticosConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_movvia_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV29movilidadYViaticosConCodigo = GXt_char4 ;
         GXv_char6[0] = AV21sumar ;
         new web.conceptoafipgettildeaposipa(remoteHandle, context).execute( AV9CliCod, AV29movilidadYViaticosConCodigo, GXv_char6) ;
         descuentosdeleysobregravado.this.AV21sumar = GXv_char6[0] ;
         if ( GXutil.strcmp(AV21sumar, "1") == 0 )
         {
            AV30movilidad_aporta_SIPA = true ;
         }
         else
         {
            AV30movilidad_aporta_SIPA = false ;
         }
         if ( AV30movilidad_aporta_SIPA )
         {
            GXt_char4 = AV28MovilidadExentosConCodigo ;
            GXt_char3 = AV28MovilidadExentosConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.concepto_movviaexentos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV28MovilidadExentosConCodigo = GXt_char4 ;
            GXv_decimal9[0] = AV27movilidadExentosLiqDImpCalcu ;
            GXv_boolean11[0] = AV58existe ;
            GXv_int8[0] = AV75auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV28MovilidadExentosConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
            descuentosdeleysobregravado.this.AV27movilidadExentosLiqDImpCalcu = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
            descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
            if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
            {
               AV8LiqDCalculado = (byte)(0) ;
               GXt_char4 = AV49dependenciasNoResueltasTxt ;
               GXv_char6[0] = GXt_char4 ;
               new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
               descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
               AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV28MovilidadExentosConCodigo) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 7", "")) ;
               AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         GXt_char4 = AV33docentesConCodigo ;
         GXt_char3 = AV33docentesConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_docentemat_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV33docentesConCodigo = GXt_char4 ;
         GXv_char6[0] = AV21sumar ;
         new web.conceptoafipgettildeaposipa(remoteHandle, context).execute( AV9CliCod, AV33docentesConCodigo, GXv_char6) ;
         descuentosdeleysobregravado.this.AV21sumar = GXv_char6[0] ;
         if ( GXutil.strcmp(AV21sumar, "1") == 0 )
         {
            GXt_char4 = AV34dOCENTESExentosConCodigo ;
            GXt_char3 = AV34dOCENTESExentosConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.concepto_perdocmatexentos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV34dOCENTESExentosConCodigo = GXt_char4 ;
            GXv_decimal9[0] = AV32docentesExentosLiqDImpCalcu ;
            GXv_boolean11[0] = AV58existe ;
            GXv_int8[0] = AV75auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV34dOCENTESExentosConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
            descuentosdeleysobregravado.this.AV32docentesExentosLiqDImpCalcu = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
            descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
            if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
            {
               AV8LiqDCalculado = (byte)(0) ;
               GXt_char4 = AV49dependenciasNoResueltasTxt ;
               GXv_char6[0] = GXt_char4 ;
               new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
               descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
               AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV34dOCENTESExentosConCodigo) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 8", "")) ;
               AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         GXt_char4 = AV48SacExentoConCodigo ;
         GXt_char3 = AV48SacExentoConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.concepto_sacexento_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV48SacExentoConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV46sacExentoLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV48SacExentoConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV46sacExentoLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV48SacExentoConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV59exentosImportes = AV20totalmenteExentoLiqDImpCalcu.add(AV23horasExtrasExentasLiqDImpCalcu).add(AV25bonosExentosLiqDImpCalcu).add(AV67fallosCajaLiqDImpCalcu).add(AV69simNatExentosLiqDImpCalcu).add(AV27movilidadExentosLiqDImpCalcu).add(AV32docentesExentosLiqDImpCalcu).add(AV46sacExentoLiqDImpCalcu) ;
         AV22BrutoMenosExento = AV18brutoImportes.subtract(AV59exentosImportes) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&BrutoMenosExento ", "")+GXutil.trim( GXutil.str( AV22BrutoMenosExento, 14, 2))+httpContext.getMessage( " &exentosImportes ", "")+GXutil.trim( GXutil.str( AV59exentosImportes, 14, 2))+httpContext.getMessage( " &sacExentoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV46sacExentoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &totalmenteExentoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV20totalmenteExentoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &docentesExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV32docentesExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &movilidadExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV27movilidadExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &bonosExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV25bonosExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " fallos ", "")+GXutil.trim( GXutil.str( AV67fallosCajaLiqDImpCalcu, 14, 2))+httpContext.getMessage( " simnat ", "")+GXutil.trim( GXutil.str( AV69simNatExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &horasExtrasExentasLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV23horasExtrasExentasLiqDImpCalcu, 14, 2))) ;
         GXt_char4 = AV37parametroPalabra ;
         GXt_char3 = AV37parametroPalabra ;
         GXv_char6[0] = GXt_char3 ;
         new web.metodorecalculo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV37parametroPalabra = GXt_char4 ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal7[0] = AV39descuentos ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         GXv_char6[0] = AV96alicuotasLiqDLog ;
         new web.descuentosobteneralicuotas(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV12LegNumero, AV11LiqNro, false, AV37parametroPalabra, GXv_decimal9, GXv_decimal7, GXv_int8, GXv_char6) ;
         descuentosdeleysobregravado.this.AV39descuentos = GXv_decimal7[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         descuentosdeleysobregravado.this.AV96alicuotasLiqDLog = GXv_char6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&descuentos ", "")+GXutil.trim( GXutil.str( AV39descuentos, 6, 4))) ;
         if ( AV75auxLiqDCalculado == 0 )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV49dependenciasNoResueltasTxt = httpContext.getMessage( "Dependencia no resuelta: Descuentos de ley", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 10", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char4 = AV65baseImponible1ConCodigo ;
         GXt_char3 = AV65baseImponible1ConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV65baseImponible1ConCodigo = GXt_char4 ;
         GXv_decimal9[0] = AV42baseImpMaxLiqDImpCalcu ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV65baseImponible1ConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV42baseImpMaxLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV65baseImponible1ConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9b", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal9[0] = AV40descuentosSobreGravadoLiqDImpCalcu ;
         GXv_char6[0] = AV72descuSobreImpLiqDLog ;
         new web.descuentosobreimponible(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV35LiqPeriodo, AV12LegNumero, AV50contemplarAnticipoDeSac, AV52liquidaSacLiqDImpCalcu, AV22BrutoMenosExento, AV42baseImpMaxLiqDImpCalcu, DecimalUtil.doubleToDec(0), AV39descuentos, AV96alicuotasLiqDLog, GXv_decimal9, GXv_char6) ;
         descuentosdeleysobregravado.this.AV40descuentosSobreGravadoLiqDImpCalcu = GXv_decimal9[0] ;
         descuentosdeleysobregravado.this.AV72descuSobreImpLiqDLog = GXv_char6[0] ;
         AV71LiqDLog += ". " + GXutil.trim( AV72descuSobreImpLiqDLog) ;
         GXt_char4 = AV84brutoOtrEmplConCodigo ;
         GXt_char3 = AV84brutoOtrEmplConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
         descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
         AV84brutoOtrEmplConCodigo = GXt_char4 ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(AV85brutoOtriqDImpCalcu) ;
         GXv_boolean11[0] = AV58existe ;
         GXv_int8[0] = AV75auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV84brutoOtrEmplConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
         descuentosdeleysobregravado.this.AV85brutoOtriqDImpCalcu = (short)(DecimalUtil.decToDouble(GXv_decimal9[0])) ;
         descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
         descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
         if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            GXt_char4 = AV49dependenciasNoResueltasTxt ;
            GXv_char6[0] = GXt_char4 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
            AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV84brutoOtrEmplConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9bb", "")) ;
            AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV85brutoOtriqDImpCalcu > 0 )
         {
            GXt_char4 = AV86exenOtrEmplConCodigo ;
            GXt_char3 = AV86exenOtrEmplConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.otroemplremuexenta_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV86exenOtrEmplConCodigo = GXt_char4 ;
            GXv_decimal9[0] = AV83exentosOtrosEmpleos ;
            GXv_boolean11[0] = AV58existe ;
            GXv_int8[0] = AV75auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV86exenOtrEmplConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
            descuentosdeleysobregravado.this.AV83exentosOtrosEmpleos = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
            descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
            if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
            {
               AV8LiqDCalculado = (byte)(0) ;
               GXt_char4 = AV49dependenciasNoResueltasTxt ;
               GXv_char6[0] = GXt_char4 ;
               new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
               descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
               AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV86exenOtrEmplConCodigo) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9bbc", "")) ;
               AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV87otrosBrutoMenosExento = DecimalUtil.doubleToDec(AV85brutoOtriqDImpCalcu).subtract(AV83exentosOtrosEmpleos) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "otros &BrutoMenosExento ", "")+GXutil.trim( GXutil.str( AV22BrutoMenosExento, 14, 2))+httpContext.getMessage( " &exentosImportes ", "")+GXutil.trim( GXutil.str( AV59exentosImportes, 14, 2))+httpContext.getMessage( " &sacExentoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV46sacExentoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &totalmenteExentoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV20totalmenteExentoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &docentesExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV32docentesExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &movilidadExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV27movilidadExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &bonosExentosLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV25bonosExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " fallos ", "")+GXutil.trim( GXutil.str( AV67fallosCajaLiqDImpCalcu, 14, 2))+httpContext.getMessage( " simnat ", "")+GXutil.trim( GXutil.str( AV69simNatExentosLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &horasExtrasExentasLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV23horasExtrasExentasLiqDImpCalcu, 14, 2))) ;
            GXt_char4 = AV37parametroPalabra ;
            GXt_char3 = AV37parametroPalabra ;
            GXv_char6[0] = GXt_char3 ;
            new web.metodorecalculo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV37parametroPalabra = GXt_char4 ;
            AV39descuentos = DecimalUtil.stringToDec("0.03") ;
            AV96alicuotasLiqDLog = httpContext.getMessage( "0.03 de Obra social de otros empleos", "") ;
            GXt_char4 = AV88OtrEmplConCodigo ;
            GXt_char3 = AV88OtrEmplConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.otroemplsegsoc_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV88OtrEmplConCodigo = GXt_char4 ;
            GXv_decimal9[0] = AV90OtrosEmpleosOSLiqDImpCalcu ;
            GXv_boolean11[0] = AV58existe ;
            GXv_int8[0] = AV75auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV88OtrEmplConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
            descuentosdeleysobregravado.this.AV90OtrosEmpleosOSLiqDImpCalcu = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
            descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
            if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
            {
               AV8LiqDCalculado = (byte)(0) ;
               GXt_char4 = AV49dependenciasNoResueltasTxt ;
               GXv_char6[0] = GXt_char4 ;
               new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
               descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
               AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV88OtrEmplConCodigo) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9bbc2", "")) ;
               AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV89OtrosEmpleosLiqDImpCalcu)==0) )
            {
               AV39descuentos = AV39descuentos.add(DecimalUtil.stringToDec("0.14")) ;
               AV96alicuotasLiqDLog += httpContext.getMessage( ", 0.14 de Jubilación y PAMI de otros empleos", "") ;
            }
            GXt_char4 = AV88OtrEmplConCodigo ;
            GXt_char3 = AV88OtrEmplConCodigo ;
            GXv_char6[0] = GXt_char3 ;
            new web.otroemplsindicato_codigoparam(remoteHandle, context).execute( GXv_char6) ;
            descuentosdeleysobregravado.this.GXt_char3 = GXv_char6[0] ;
            GXv_char5[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
            descuentosdeleysobregravado.this.GXt_char4 = GXv_char5[0] ;
            AV88OtrEmplConCodigo = GXt_char4 ;
            GXv_decimal9[0] = AV89OtrosEmpleosLiqDImpCalcu ;
            GXv_boolean11[0] = AV58existe ;
            GXv_int8[0] = AV75auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV88OtrEmplConCodigo, AV79ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal9, GXv_boolean11, GXv_int8) ;
            descuentosdeleysobregravado.this.AV89OtrosEmpleosLiqDImpCalcu = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV58existe = GXv_boolean11[0] ;
            descuentosdeleysobregravado.this.AV75auxLiqDCalculado = GXv_int8[0] ;
            if ( ( AV75auxLiqDCalculado == 0 ) && ( AV58existe ) )
            {
               AV8LiqDCalculado = (byte)(0) ;
               GXt_char4 = AV49dependenciasNoResueltasTxt ;
               GXv_char6[0] = GXt_char4 ;
               new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char6) ;
               descuentosdeleysobregravado.this.GXt_char4 = GXv_char6[0] ;
               AV49dependenciasNoResueltasTxt = GXt_char4 + GXutil.trim( AV88OtrEmplConCodigo) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "return 9bbc22", "")) ;
               AV71LiqDLog += ". " + GXutil.trim( AV49dependenciasNoResueltasTxt) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV89OtrosEmpleosLiqDImpCalcu)==0) )
            {
               AV39descuentos = AV39descuentos.add(DecimalUtil.stringToDec("0.05")) ;
               AV96alicuotasLiqDLog += httpContext.getMessage( ", 0.05 de Cuota sindical de otros empleos", "") ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&descuentos ", "")+GXutil.trim( GXutil.str( AV39descuentos, 6, 4))) ;
            AV42baseImpMaxLiqDImpCalcu = AV90OtrosEmpleosOSLiqDImpCalcu.divide(DecimalUtil.stringToDec("0.03"), 18, java.math.RoundingMode.DOWN) ;
            GXv_decimal9[0] = AV91otrosdescuentosSobreGravadoLiqDImpCalcu ;
            GXv_char6[0] = AV72descuSobreImpLiqDLog ;
            new web.descuentosobreimponible(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV35LiqPeriodo, AV12LegNumero, AV50contemplarAnticipoDeSac, AV52liquidaSacLiqDImpCalcu, AV87otrosBrutoMenosExento, AV42baseImpMaxLiqDImpCalcu, DecimalUtil.doubleToDec(0), AV39descuentos, AV96alicuotasLiqDLog, GXv_decimal9, GXv_char6) ;
            descuentosdeleysobregravado.this.AV91otrosdescuentosSobreGravadoLiqDImpCalcu = GXv_decimal9[0] ;
            descuentosdeleysobregravado.this.AV72descuSobreImpLiqDLog = GXv_char6[0] ;
            AV71LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV91otrosdescuentosSobreGravadoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a otros empleos", "") ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&descuentosSobreGravadoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV40descuentosSobreGravadoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &minimoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV41minimoLiqDImpCalcu, 14, 2))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV99Pgmname, httpContext.getMessage( "&baseImpMaxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV42baseImpMaxLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV35LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &OpeCliValor ", "")+AV43OpeCliValor) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = descuentosdeleysobregravado.this.AV40descuentosSobreGravadoLiqDImpCalcu;
      this.aP11[0] = descuentosdeleysobregravado.this.AV8LiqDCalculado;
      this.aP12[0] = descuentosdeleysobregravado.this.AV49dependenciasNoResueltasTxt;
      this.aP13[0] = descuentosdeleysobregravado.this.AV71LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40descuentosSobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV49dependenciasNoResueltasTxt = "" ;
      AV71LiqDLog = "" ;
      AV51liquidaSACConCodigo = "" ;
      AV52liquidaSacLiqDImpCalcu = DecimalUtil.ZERO ;
      AV99Pgmname = "" ;
      AV55descuentosSobreGravadConCodigo = "" ;
      AV92ConceptoTipo = "" ;
      AV76Date = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo = "" ;
      AV57LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV63basicoJornalConCodigo = "" ;
      AV78basicoMensualConCodigo = "" ;
      GXv_int10 = new short[1] ;
      scmdbuf = "" ;
      P00YP2_A464DTipoConCod = new String[] {""} ;
      P00YP2_A6LegNumero = new int[1] ;
      P00YP2_A31LiqNro = new int[1] ;
      P00YP2_A1EmpCod = new short[1] ;
      P00YP2_A3CliCod = new int[1] ;
      P00YP2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00YP2_A1122DAplIIGG = new short[1] ;
      P00YP2_n1122DAplIIGG = new boolean[] {false} ;
      P00YP2_A394DConCodigo = new String[] {""} ;
      P00YP2_A393DConDescrip = new String[] {""} ;
      P00YP2_A507LiqDCalculado = new byte[1] ;
      P00YP2_A763LiqDRecalculado = new short[1] ;
      P00YP2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV21sumar = "" ;
      AV14remu_LiqDImpCalcu = DecimalUtil.ZERO ;
      AV20totalmenteExentoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV62basicoImportes = DecimalUtil.ZERO ;
      AV15noRemuApoSIPALiqDImpCalcu = DecimalUtil.ZERO ;
      AV18brutoImportes = DecimalUtil.ZERO ;
      AV44OpeCliId = "" ;
      AV43OpeCliValor = "" ;
      AV94auxError = "" ;
      AV70baseImponibleMinima = DecimalUtil.ZERO ;
      AV17baseDifLiqDImpCalcu = DecimalUtil.ZERO ;
      AV54anticipoDeSacConCodigo = "" ;
      AV53anticipoDeSacLiqDImpCalcu = DecimalUtil.ZERO ;
      AV24horasExtrasExentasConCodigo = "" ;
      AV23horasExtrasExentasLiqDImpCalcu = DecimalUtil.ZERO ;
      AV26BonosExentosConCodigo = "" ;
      AV25bonosExentosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV66fallosCajaExentosConCodigo = "" ;
      AV67fallosCajaLiqDImpCalcu = DecimalUtil.ZERO ;
      AV68simNatExentosConCodigo = "" ;
      AV69simNatExentosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV29movilidadYViaticosConCodigo = "" ;
      AV28MovilidadExentosConCodigo = "" ;
      AV27movilidadExentosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV33docentesConCodigo = "" ;
      AV34dOCENTESExentosConCodigo = "" ;
      AV32docentesExentosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV48SacExentoConCodigo = "" ;
      AV46sacExentoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV59exentosImportes = DecimalUtil.ZERO ;
      AV22BrutoMenosExento = DecimalUtil.ZERO ;
      AV37parametroPalabra = "" ;
      AV39descuentos = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV96alicuotasLiqDLog = "" ;
      AV65baseImponible1ConCodigo = "" ;
      AV42baseImpMaxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV72descuSobreImpLiqDLog = "" ;
      AV84brutoOtrEmplConCodigo = "" ;
      AV86exenOtrEmplConCodigo = "" ;
      AV83exentosOtrosEmpleos = DecimalUtil.ZERO ;
      AV87otrosBrutoMenosExento = DecimalUtil.ZERO ;
      AV88OtrEmplConCodigo = "" ;
      AV90OtrosEmpleosOSLiqDImpCalcu = DecimalUtil.ZERO ;
      AV89OtrosEmpleosLiqDImpCalcu = DecimalUtil.ZERO ;
      GXt_char3 = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_int8 = new byte[1] ;
      GXt_char4 = "" ;
      AV91otrosdescuentosSobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_char6 = new String[1] ;
      AV41minimoLiqDImpCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.descuentosdeleysobregravado__default(),
         new Object[] {
             new Object[] {
            P00YP2_A464DTipoConCod, P00YP2_A6LegNumero, P00YP2_A31LiqNro, P00YP2_A1EmpCod, P00YP2_A3CliCod, P00YP2_A764LiqDImpReCalcu, P00YP2_A1122DAplIIGG, P00YP2_n1122DAplIIGG, P00YP2_A394DConCodigo, P00YP2_A393DConDescrip,
            P00YP2_A507LiqDCalculado, P00YP2_A763LiqDRecalculado, P00YP2_A81LiqDSecuencial
            }
         }
      );
      AV99Pgmname = "DescuentosDeLeySobreGravado" ;
      /* GeneXus formulas. */
      AV99Pgmname = "DescuentosDeLeySobreGravado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV75auxLiqDCalculado ;
   private byte AV100GXLvl59 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int8[] ;
   private short AV10EmpCod ;
   private short AV77totalmenteExentoDAplIIGG ;
   private short GXv_int10[] ;
   private short A1EmpCod ;
   private short A1122DAplIIGG ;
   private short A763LiqDRecalculado ;
   private short AV85brutoOtriqDImpCalcu ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV93LiqRelNro ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV40descuentosSobreGravadoLiqDImpCalcu ;
   private java.math.BigDecimal AV52liquidaSacLiqDImpCalcu ;
   private java.math.BigDecimal AV57LiqDImpReCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV14remu_LiqDImpCalcu ;
   private java.math.BigDecimal AV20totalmenteExentoLiqDImpCalcu ;
   private java.math.BigDecimal AV62basicoImportes ;
   private java.math.BigDecimal AV15noRemuApoSIPALiqDImpCalcu ;
   private java.math.BigDecimal AV18brutoImportes ;
   private java.math.BigDecimal AV70baseImponibleMinima ;
   private java.math.BigDecimal AV17baseDifLiqDImpCalcu ;
   private java.math.BigDecimal AV53anticipoDeSacLiqDImpCalcu ;
   private java.math.BigDecimal AV23horasExtrasExentasLiqDImpCalcu ;
   private java.math.BigDecimal AV25bonosExentosLiqDImpCalcu ;
   private java.math.BigDecimal AV67fallosCajaLiqDImpCalcu ;
   private java.math.BigDecimal AV69simNatExentosLiqDImpCalcu ;
   private java.math.BigDecimal AV27movilidadExentosLiqDImpCalcu ;
   private java.math.BigDecimal AV32docentesExentosLiqDImpCalcu ;
   private java.math.BigDecimal AV46sacExentoLiqDImpCalcu ;
   private java.math.BigDecimal AV59exentosImportes ;
   private java.math.BigDecimal AV22BrutoMenosExento ;
   private java.math.BigDecimal AV39descuentos ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal AV42baseImpMaxLiqDImpCalcu ;
   private java.math.BigDecimal AV83exentosOtrosEmpleos ;
   private java.math.BigDecimal AV87otrosBrutoMenosExento ;
   private java.math.BigDecimal AV90OtrosEmpleosOSLiqDImpCalcu ;
   private java.math.BigDecimal AV89OtrosEmpleosLiqDImpCalcu ;
   private java.math.BigDecimal AV91otrosdescuentosSobreGravadoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal AV41minimoLiqDImpCalcu ;
   private String AV81ConCodigo ;
   private String AV79ProcesoLiquidacion ;
   private String AV51liquidaSACConCodigo ;
   private String AV99Pgmname ;
   private String AV55descuentosSobreGravadConCodigo ;
   private String AV92ConceptoTipo ;
   private String AV56descuentosDeLeyMasSobreAnticipoDeSacConCodigo ;
   private String AV63basicoJornalConCodigo ;
   private String AV78basicoMensualConCodigo ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String AV21sumar ;
   private String AV44OpeCliId ;
   private String AV54anticipoDeSacConCodigo ;
   private String AV24horasExtrasExentasConCodigo ;
   private String AV26BonosExentosConCodigo ;
   private String AV66fallosCajaExentosConCodigo ;
   private String AV68simNatExentosConCodigo ;
   private String AV29movilidadYViaticosConCodigo ;
   private String AV28MovilidadExentosConCodigo ;
   private String AV33docentesConCodigo ;
   private String AV34dOCENTESExentosConCodigo ;
   private String AV48SacExentoConCodigo ;
   private String AV37parametroPalabra ;
   private String AV65baseImponible1ConCodigo ;
   private String AV84brutoOtrEmplConCodigo ;
   private String AV86exenOtrEmplConCodigo ;
   private String AV88OtrEmplConCodigo ;
   private String GXt_char3 ;
   private String GXv_char5[] ;
   private String GXt_char4 ;
   private String GXv_char6[] ;
   private java.util.Date AV35LiqPeriodo ;
   private java.util.Date AV76Date ;
   private boolean AV50contemplarAnticipoDeSac ;
   private boolean AV13insertandoConceptos ;
   private boolean AV45finalEs ;
   private boolean GXt_boolean1 ;
   private boolean AV58existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean2[] ;
   private boolean n1122DAplIIGG ;
   private boolean AV30movilidad_aporta_SIPA ;
   private boolean GXv_boolean11[] ;
   private String AV71LiqDLog ;
   private String AV43OpeCliValor ;
   private String AV96alicuotasLiqDLog ;
   private String AV72descuSobreImpLiqDLog ;
   private String AV49dependenciasNoResueltasTxt ;
   private String A393DConDescrip ;
   private String AV94auxError ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP10 ;
   private byte[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private String[] P00YP2_A464DTipoConCod ;
   private int[] P00YP2_A6LegNumero ;
   private int[] P00YP2_A31LiqNro ;
   private short[] P00YP2_A1EmpCod ;
   private int[] P00YP2_A3CliCod ;
   private java.math.BigDecimal[] P00YP2_A764LiqDImpReCalcu ;
   private short[] P00YP2_A1122DAplIIGG ;
   private boolean[] P00YP2_n1122DAplIIGG ;
   private String[] P00YP2_A394DConCodigo ;
   private String[] P00YP2_A393DConDescrip ;
   private byte[] P00YP2_A507LiqDCalculado ;
   private short[] P00YP2_A763LiqDRecalculado ;
   private int[] P00YP2_A81LiqDSecuencial ;
}

final  class descuentosdeleysobregravado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YP2", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, DAplIIGG, DConCodigo, DConDescrip, LiqDCalculado, LiqDRecalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DTipoConCod >= ( 'NRE_ARG')) AND (DTipoConCod <= ( 'REM_ARG')) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 10);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
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
               return;
      }
   }

}

