package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class orquestaliquidacion extends GXProcedure
{
   public orquestaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( orquestaliquidacion.class ), "" );
   }

   public orquestaliquidacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      orquestaliquidacion.this.AV9CliCod = aP0;
      orquestaliquidacion.this.AV11EmpCod = aP1;
      orquestaliquidacion.this.AV19LiqNro = aP2;
      orquestaliquidacion.this.AV8cantidadPorLote = aP3;
      orquestaliquidacion.this.AV28cantidadDeLotes = aP4;
      orquestaliquidacion.this.AV25clientId = aP5;
      orquestaliquidacion.this.AV152daemonUUID = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV159liqPDFModoPalabra ;
      GXt_char2 = AV159liqPDFModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      AV159liqPDFModoPalabra = GXt_char1 ;
      GXv_char4[0] = AV106flujoGenRecPalabra ;
      new web.getparametroflujogenrec(remoteHandle, context).execute( AV9CliCod, GXv_char4) ;
      orquestaliquidacion.this.AV106flujoGenRecPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV113ImprimirLiqLeg ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV113ImprimirLiqLeg = GXv_char4[0] ;
      AV111iDepLsd = (short)(-1) ;
      AV112iGenRec = (short)(-1) ;
      AV110iContr = (short)(-1) ;
      AV114iOtros = (short)(-1) ;
      if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV113ImprimirLiqLeg)), httpContext.getMessage( "NO", "")) != 0 )
      {
         AV46PDFmanualEs = false ;
      }
      else
      {
         AV46PDFmanualEs = true ;
      }
      GXv_boolean5[0] = AV95calcPrin_RestLocHab ;
      GXv_char4[0] = "" ;
      GXv_int6[0] = (byte)(0) ;
      GXv_char3[0] = "" ;
      GXv_int7[0] = 0 ;
      GXv_int8[0] = (short)(0) ;
      GXv_int9[0] = (byte)(0) ;
      new web.getrest_location(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "GuardaLiquidacion_rest", ""), (short)(0), GXv_boolean5, GXv_char4, GXv_int6, GXv_char3, GXv_int7, GXv_int8, GXv_int9) ;
      orquestaliquidacion.this.AV95calcPrin_RestLocHab = GXv_boolean5[0] ;
      AV104depLsdRestLocId = httpContext.getMessage( "CalcDepLSD", "") ;
      GXv_boolean5[0] = AV103DepLSD_RestLocHab ;
      GXv_objcol_int10[0] = AV102DepLsd_replicas ;
      new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV9CliCod, AV104depLsdRestLocId, GXv_boolean5, GXv_objcol_int10) ;
      orquestaliquidacion.this.AV103DepLSD_RestLocHab = GXv_boolean5[0] ;
      AV102DepLsd_replicas = GXv_objcol_int10[0] ;
      AV109GenRecRestLocId = httpContext.getMessage( "GenRecibos", "") ;
      GXv_boolean5[0] = AV108GenRec_RestLocHab ;
      GXv_objcol_int10[0] = AV107GenRec_replicas ;
      new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV9CliCod, AV109GenRecRestLocId, GXv_boolean5, GXv_objcol_int10) ;
      orquestaliquidacion.this.AV108GenRec_RestLocHab = GXv_boolean5[0] ;
      AV107GenRec_replicas = GXv_objcol_int10[0] ;
      AV101ContrRestLocId = httpContext.getMessage( "CalcContr", "") ;
      GXv_boolean5[0] = AV93CalcContr_RestLocHab ;
      GXv_objcol_int10[0] = AV92CalcContr_replicas ;
      new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV9CliCod, AV101ContrRestLocId, GXv_boolean5, GXv_objcol_int10) ;
      orquestaliquidacion.this.AV93CalcContr_RestLocHab = GXv_boolean5[0] ;
      AV92CalcContr_replicas = GXv_objcol_int10[0] ;
      AV136OtrosRestLocId = httpContext.getMessage( "CalcOtros", "") ;
      GXv_boolean5[0] = AV94CalcOtros_RestLocHab ;
      GXv_objcol_int10[0] = AV134Otros_replicas ;
      new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV9CliCod, AV136OtrosRestLocId, GXv_boolean5, GXv_objcol_int10) ;
      orquestaliquidacion.this.AV94CalcOtros_RestLocHab = GXv_boolean5[0] ;
      AV134Otros_replicas = GXv_objcol_int10[0] ;
      GXv_char4[0] = AV87invocacionPDFMetodoPalabra ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.metodoinvocapdf_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV87invocacionPDFMetodoPalabra = GXv_char4[0] ;
      GXt_char2 = AV47ParmValue ;
      GXt_char1 = AV47ParmValue ;
      GXv_char4[0] = GXt_char1 ;
      new web.liquidarauxparalelos_param(remoteHandle, context).execute( GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV47ParmValue = GXt_char2 ;
      AV51liquidarAuxParalelos = GXutil.boolval( AV47ParmValue) ;
      GXv_char4[0] = AV68sqsPrinURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_calcliqtodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV68sqsPrinURL = GXv_char4[0] ;
      GXv_char4[0] = AV47ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV47ParmValue = GXv_char4[0] ;
      AV69desgloceEs = GXutil.boolval( AV47ParmValue) ;
      GXv_char4[0] = AV70sqsDepLsdURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_deplsd_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV70sqsDepLsdURL = GXv_char4[0] ;
      GXv_char4[0] = AV75sqsGenPdfsURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_generarrecibos_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV75sqsGenPdfsURL = GXv_char4[0] ;
      GXv_char4[0] = AV73sqsContrURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_contr_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV73sqsContrURL = GXv_char4[0] ;
      GXv_char4[0] = AV74sqsOtrURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_otr_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV74sqsOtrURL = GXv_char4[0] ;
      AV49preEsperaPorLeg = DecimalUtil.stringToDec("0.1") ;
      AV48preEsperaSegundos = (short)(1) ;
      AV24s = GXutil.sleep( AV48preEsperaSegundos) ;
      GXt_char2 = AV122liqPrinModoPalabra ;
      GXt_char1 = AV122liqPrinModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV122liqPrinModoPalabra = GXt_char2 ;
      GXt_char2 = AV121liqLSDModoPalabra ;
      GXt_char1 = AV121liqLSDModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV121liqLSDModoPalabra = GXt_char2 ;
      GXt_char2 = AV88liqContrModoPalabra ;
      GXt_char1 = AV88liqContrModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_contr", GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV88liqContrModoPalabra = GXt_char2 ;
      GXt_char2 = AV89liqOtrosModoPalabra ;
      GXt_char1 = AV89liqOtrosModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_otros", GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV89liqOtrosModoPalabra = GXt_char2 ;
      GXt_char2 = AV90liqRecibosModoPalabra ;
      GXt_char1 = AV90liqRecibosModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char4) ;
      orquestaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      orquestaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV90liqRecibosModoPalabra = GXt_char2 ;
      if ( ( AV69desgloceEs ) && ( ( ( GXutil.strcmp(AV121liqLSDModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV103DepLSD_RestLocHab ) || ( ( GXutil.strcmp(AV90liqRecibosModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV108GenRec_RestLocHab ) || ( ( GXutil.strcmp(AV88liqContrModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV93CalcContr_RestLocHab ) || ( ( GXutil.strcmp(AV89liqOtrosModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV94CalcOtros_RestLocHab ) ) )
      {
         AV31seguir = false ;
         if ( ( GXutil.strcmp(AV121liqLSDModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV103DepLSD_RestLocHab )
         {
            AV12errorTexto = httpContext.getMessage( "Está configurado para liquidar con microservicio de cálculo de conceptos de LSD y no está configurado el endpoint", "") ;
         }
         else if ( ( GXutil.strcmp(AV90liqRecibosModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV108GenRec_RestLocHab )
         {
            AV12errorTexto = httpContext.getMessage( "Está configurado para liquidar con microservicio de generación de recibo html y no está configurado el endpoint", "") ;
         }
         else if ( ( GXutil.strcmp(AV88liqContrModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) && ! AV93CalcContr_RestLocHab )
         {
            AV12errorTexto = httpContext.getMessage( "Está configurado para liquidar con microservicio de cálculo de contribuciones y no está configurado el endpoint", "") ;
         }
         else
         {
            AV12errorTexto = httpContext.getMessage( "Está configurado para liquidar con microservicio de cálculo de conceptos auxiliares para liquidaciones futuras y no está configurado el endpoint", "") ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, AV12errorTexto) ;
         /* Execute user subroutine: 'ERROR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         if ( ! AV69desgloceEs && ( ( GXutil.strcmp(AV122liqPrinModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 ) || ( GXutil.strcmp(AV122liqPrinModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 ) ) && ! AV95calcPrin_RestLocHab )
         {
            AV31seguir = false ;
            AV12errorTexto = httpContext.getMessage( "Está configurado para liquidar con microservicio docker y el endpoint no está configurado", "") ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, AV12errorTexto) ;
            /* Execute user subroutine: 'ERROR' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            AV31seguir = true ;
         }
      }
      GXv_char4[0] = AV47ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.segundosesperaporlegajo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      orquestaliquidacion.this.AV47ParmValue = GXv_char4[0] ;
      AV54segEspPorLegajo = (short)(GXutil.lval( AV47ParmValue)) ;
      if ( (0==AV54segEspPorLegajo) )
      {
         AV54segEspPorLegajo = (short)(120) ;
      }
      AV53segundosEspera = (short)(AV8cantidadPorLote*AV54segEspPorLegajo*AV28cantidadDeLotes) ;
      GXt_int11 = AV97cantLeg ;
      GXv_int8[0] = GXt_int11 ;
      new web.getliqcntleg(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_int8) ;
      orquestaliquidacion.this.GXt_int11 = GXv_int8[0] ;
      AV97cantLeg = GXt_int11 ;
      if ( (0==AV97cantLeg) )
      {
         AV97cantLeg = (short)(1) ;
      }
      GXv_int9[0] = AV164LiqFrecPag ;
      GXv_char4[0] = AV163LiqModTra ;
      new web.getliqfrecpagmodtraytarifa(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_int9, GXv_char4, AV165LiqTipoTarifa) ;
      orquestaliquidacion.this.AV164LiqFrecPag = GXv_int9[0] ;
      orquestaliquidacion.this.AV163LiqModTra = GXv_char4[0] ;
      if ( GXutil.strcmp(AV163LiqModTra, "E") != 0 )
      {
         AV10ContrListo = true ;
         AV35DepLSDListo = true ;
         AV30OtrosListo = true ;
      }
      GXv_char4[0] = AV139PrinConCodigo ;
      new web.getconceptobasicoporclase(remoteHandle, context).execute( AV9CliCod, AV165LiqTipoTarifa, GXv_char4) ;
      orquestaliquidacion.this.AV139PrinConCodigo = GXv_char4[0] ;
      AV129LSDConCodigo = httpContext.getMessage( "CAL029", "") ;
      AV100ContrConCodigo = httpContext.getMessage( "CAL004", "") ;
      AV135OtrosConCodigo = httpContext.getMessage( "CAL013", "") ;
      while ( AV31seguir )
      {
         AV132notificaciones.clear();
         AV29i = (short)(AV29i+1) ;
         if ( ! AV23PrinListo )
         {
            /* Execute user subroutine: 'CHEQUEAR PRINCIPALES' */
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
            if ( ! AV35DepLSDListo && ( AV51liquidarAuxParalelos ) )
            {
               AV65LiqBatchSeccion = httpContext.getMessage( "DEPENDENCIAS_LSD", "") ;
               AV67notificacionPalabra = httpContext.getMessage( "DEPENDENCIAS_LSD", "") ;
               /* Execute user subroutine: 'CHEQUEAR SECUNDARIOS' */
               S201 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               if ( ! AV10ContrListo && ( AV51liquidarAuxParalelos ) )
               {
                  AV65LiqBatchSeccion = httpContext.getMessage( "CONTRIBUCIONES", "") ;
                  AV67notificacionPalabra = httpContext.getMessage( "CONTRIBUCIONES", "") ;
                  /* Execute user subroutine: 'CHEQUEAR SECUNDARIOS' */
                  S201 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  if ( ! AV30OtrosListo && ( AV51liquidarAuxParalelos ) )
                  {
                     AV65LiqBatchSeccion = httpContext.getMessage( "OTROS", "") ;
                     AV67notificacionPalabra = httpContext.getMessage( "OTROS", "") ;
                     /* Execute user subroutine: 'CHEQUEAR SECUNDARIOS' */
                     S201 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
               }
            }
            if ( ! AV42PDFListo && ( AV51liquidarAuxParalelos ) )
            {
               AV65LiqBatchSeccion = httpContext.getMessage( "GENERACION_PDFS", "") ;
               AV67notificacionPalabra = httpContext.getMessage( "GENERACION_PDFS", "") ;
               /* Execute user subroutine: 'CHEQUEAR SECUNDARIOS' */
               S201 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         /* Execute user subroutine: 'NOTIFICACIONES' */
         S261 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ( AV23PrinListo ) && ( ! AV51liquidarAuxParalelos || ( ( AV35DepLSDListo ) && ( AV10ContrListo ) && ( AV30OtrosListo ) && ( AV42PDFListo ) ) ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "exit 1", "")) ;
            if (true) break;
         }
         AV24s = GXutil.sleep( 1) ;
         if ( AV29i == AV53segundosEspera )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "exit 2 &i ", "")+GXutil.trim( GXutil.str( AV29i, 4, 0))) ;
            AV52timeout = true ;
            if (true) break;
         }
         /* Using cursor P02BE2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31LiqNro = P02BE2_A31LiqNro[0] ;
            A1EmpCod = P02BE2_A1EmpCod[0] ;
            A3CliCod = P02BE2_A3CliCod[0] ;
            A2298LiqCancel = P02BE2_A2298LiqCancel[0] ;
            if ( A2298LiqCancel )
            {
               AV31seguir = false ;
               AV12errorTexto = httpContext.getMessage( "La liquidación fué cancelada", "") ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, AV12errorTexto) ;
               /* Execute user subroutine: 'ERROR' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      if ( AV23PrinListo )
      {
         GXv_char4[0] = AV50TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_char4) ;
         orquestaliquidacion.this.AV50TLiqCod = GXv_char4[0] ;
         new web.bajalegajossiegreso(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV50TLiqCod) ;
         GXv_date12[0] = AV20LiqPeriodo ;
         new web.getperiodoliquidacion(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_date12) ;
         orquestaliquidacion.this.AV20LiqPeriodo = GXv_date12[0] ;
         new web.cerrarliquidacionesperiodoanterior(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV20LiqPeriodo) ;
      }
      if ( AV52timeout )
      {
         AV12errorTexto = httpContext.getMessage( "Se superó el tiempo de espera", "") ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, AV12errorTexto) ;
         /* Execute user subroutine: 'ERROR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ERROR' Routine */
      returnInSub = false ;
      new web.liqseterror(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV23PrinListo, AV35DepLSDListo, AV10ContrListo, AV30OtrosListo, AV42PDFListo, AV12errorTexto) ;
      new web.notificacionerrorliquidacion(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV25clientId) ;
      AV132notificaciones.add(httpContext.getMessage( "ERROR GuardaLiquidacion ", "")+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)), 0);
   }

   public void S121( )
   {
      /* 'CHEQUEAR PRINCIPALES' Routine */
      returnInSub = false ;
      AV63LiqBatchEtapa = (short)(0) ;
      AV64LiqBatchErrN = (short)(0) ;
      AV66LiqBatchError = "" ;
      AV65LiqBatchSeccion = httpContext.getMessage( "PRINCIPALES", "") ;
      AV67notificacionPalabra = httpContext.getMessage( "GuardaLiquidacion", "") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "chequea principales 1", "")) ;
      AV170GXLvl269 = (byte)(0) ;
      /* Using cursor P02BE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro), AV65LiqBatchSeccion});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2373LiqBatchSeccion = P02BE3_A2373LiqBatchSeccion[0] ;
         A2371LiqBatchLiqNro = P02BE3_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P02BE3_A1EmpCod[0] ;
         A3CliCod = P02BE3_A3CliCod[0] ;
         A2374LiqBatchEtapa = P02BE3_A2374LiqBatchEtapa[0] ;
         A2376LiqBatchErrN = P02BE3_A2376LiqBatchErrN[0] ;
         A2372LiqBatchCod = P02BE3_A2372LiqBatchCod[0] ;
         A2378LiqBatchLegajos = P02BE3_A2378LiqBatchLegajos[0] ;
         AV170GXLvl269 = (byte)(1) ;
         AV63LiqBatchEtapa = (short)(AV63LiqBatchEtapa+A2374LiqBatchEtapa) ;
         AV64LiqBatchErrN = (short)(AV64LiqBatchErrN+A2376LiqBatchErrN) ;
         AV83auxLiqBatchCod = A2372LiqBatchCod ;
         AV84auxLiqBatchSeccion = A2373LiqBatchSeccion ;
         AV79LiqBatchCod = A2372LiqBatchCod ;
         /* Execute user subroutine: 'LOTE PROCESADO' */
         S133 ();
         if ( returnInSub )
         {
            pr_default.close(1);
            returnInSub = true;
            if (true) return;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "chequea principales LiqBatchEtapa ", "")+GXutil.trim( GXutil.str( A2374LiqBatchEtapa, 4, 0))+httpContext.getMessage( " &loteProcesado ", "")+GXutil.trim( GXutil.booltostr( AV80loteProcesado))) ;
         if ( ( A2374LiqBatchEtapa == 2 ) && ! AV80loteProcesado )
         {
            AV44LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
            AV44LegNumero.fromJSonString(A2378LiqBatchLegajos, null);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "chequea principales ejecutar dependencias lsd", "")) ;
            if ( GXutil.strcmp(AV163LiqModTra, "E") == 0 )
            {
               /* Execute user subroutine: 'EJECUTAR DEPENDENCIAS LSD' */
               S143 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  if (true) return;
               }
            }
            if ( GXutil.strcmp(AV106flujoGenRecPalabra, "1") == 0 )
            {
               /* Execute user subroutine: 'EJECUTAR RECIBO' */
               S153 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  if (true) return;
               }
            }
            new web.procliquidacionsegundaparteasync(remoteHandle, context).execute( A3CliCod, A1EmpCod, A2371LiqBatchLiqNro, AV44LegNumero) ;
            /* Execute user subroutine: 'AGREGAR LOTE PROCESADO' */
            S163 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               returnInSub = true;
               if (true) return;
            }
            AV127lotePrinNro = (short)(AV127lotePrinNro+1) ;
            if ( AV127lotePrinNro > 1 )
            {
               /* Execute user subroutine: 'NOTIFICAR PARCIAL' */
               S173 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  if (true) return;
               }
            }
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV170GXLvl269 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "none princesa", "")) ;
         /* Execute user subroutine: 'CHEQUEAR EXISTENCIA LIQUIDACIÓN' */
         S181 ();
         if (returnInSub) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "helllllo &LiqBatchEtapa ", "")+GXutil.trim( GXutil.str( AV63LiqBatchEtapa, 4, 0))+httpContext.getMessage( " &cantidadDeLotes ", "")+GXutil.trim( GXutil.str( AV28cantidadDeLotes, 4, 0))) ;
      if ( AV63LiqBatchEtapa == ( AV28cantidadDeLotes * 2 ) )
      {
         if ( AV64LiqBatchErrN > 0 )
         {
            /* Using cursor P02BE4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro), AV65LiqBatchSeccion});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A2373LiqBatchSeccion = P02BE4_A2373LiqBatchSeccion[0] ;
               A2371LiqBatchLiqNro = P02BE4_A2371LiqBatchLiqNro[0] ;
               A1EmpCod = P02BE4_A1EmpCod[0] ;
               A3CliCod = P02BE4_A3CliCod[0] ;
               A2375LiqBatchError = P02BE4_A2375LiqBatchError[0] ;
               A2372LiqBatchCod = P02BE4_A2372LiqBatchCod[0] ;
               if ( GXutil.strSearch( AV66LiqBatchError, A2375LiqBatchError, 1) == 0 )
               {
                  if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
                  {
                     AV66LiqBatchError += ". " ;
                  }
                  AV66LiqBatchError += GXutil.trim( A2375LiqBatchError) ;
               }
               pr_default.readNext(2);
            }
            pr_default.close(2);
         }
         AV23PrinListo = true ;
         if ( (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            GXv_date12[0] = AV20LiqPeriodo ;
            GXv_boolean5[0] = AV22ok ;
            new web.setestadoliqok(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_date12, GXv_boolean5) ;
            orquestaliquidacion.this.AV20LiqPeriodo = GXv_date12[0] ;
            orquestaliquidacion.this.AV22ok = GXv_boolean5[0] ;
            Application.commitDataStores(context, remoteHandle, pr_default, "orquestaliquidacion");
            if ( AV22ok )
            {
               AV132notificaciones.add(httpContext.getMessage( "OK ", "")+GXutil.trim( AV67notificacionPalabra)+" "+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)), 0);
            }
            else
            {
               AV12errorTexto = httpContext.getMessage( "Algo salió mal con la liquidación al finalizar", "") ;
               /* Execute user subroutine: 'ERROR' */
               S111 ();
               if (returnInSub) return;
               AV31seguir = false ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "setguir false 2", "")) ;
            }
         }
         else
         {
            AV12errorTexto = AV66LiqBatchError ;
            /* Execute user subroutine: 'ERROR' */
            S111 ();
            if (returnInSub) return;
            AV31seguir = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "setguir false 3", "")) ;
         }
      }
      else
      {
         AV99ConCodigo = AV139PrinConCodigo ;
         AV140ProgresoLiqBatchSeccion = AV65LiqBatchSeccion ;
         /* Execute user subroutine: 'MOSTRAR PROGRESO' */
         S191 ();
         if (returnInSub) return;
         if ( ( GXutil.strcmp(AV87invocacionPDFMetodoPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 ) || ( GXutil.strcmp(AV87invocacionPDFMetodoPalabra, httpContext.getMessage( "ASINCRONA", "")) == 0 ) )
         {
            AV140ProgresoLiqBatchSeccion = httpContext.getMessage( "GENERACION_PDFS", "") ;
            /* Execute user subroutine: 'MOSTRAR PROGRESO' */
            S191 ();
            if (returnInSub) return;
            AV140ProgresoLiqBatchSeccion = httpContext.getMessage( "DEPENDENCIAS_LSD", "") ;
            /* Execute user subroutine: 'MOSTRAR PROGRESO' */
            S191 ();
            if (returnInSub) return;
         }
      }
   }

   public void S201( )
   {
      /* 'CHEQUEAR SECUNDARIOS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "chequear secundarios &LiqBatchSeccion \"", "")+AV65LiqBatchSeccion+"\"") ;
      AV66LiqBatchError = "" ;
      AV63LiqBatchEtapa = (short)(0) ;
      AV64LiqBatchErrN = (short)(0) ;
      AV172GXLvl434 = (byte)(0) ;
      /* Using cursor P02BE5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro), AV65LiqBatchSeccion});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A2373LiqBatchSeccion = P02BE5_A2373LiqBatchSeccion[0] ;
         A2371LiqBatchLiqNro = P02BE5_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P02BE5_A1EmpCod[0] ;
         A3CliCod = P02BE5_A3CliCod[0] ;
         A2374LiqBatchEtapa = P02BE5_A2374LiqBatchEtapa[0] ;
         A2376LiqBatchErrN = P02BE5_A2376LiqBatchErrN[0] ;
         A2372LiqBatchCod = P02BE5_A2372LiqBatchCod[0] ;
         A2378LiqBatchLegajos = P02BE5_A2378LiqBatchLegajos[0] ;
         AV172GXLvl434 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "Lote", "")) ;
         AV63LiqBatchEtapa = (short)(AV63LiqBatchEtapa+A2374LiqBatchEtapa) ;
         AV64LiqBatchErrN = (short)(AV64LiqBatchErrN+A2376LiqBatchErrN) ;
         AV83auxLiqBatchCod = A2372LiqBatchCod ;
         AV84auxLiqBatchSeccion = A2373LiqBatchSeccion ;
         AV79LiqBatchCod = A2372LiqBatchCod ;
         /* Execute user subroutine: 'LOTE PROCESADO' */
         S133 ();
         if ( returnInSub )
         {
            pr_default.close(3);
            returnInSub = true;
            if (true) return;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "LiqBatchEtapa ", "")+GXutil.trim( GXutil.str( A2374LiqBatchEtapa, 4, 0))+httpContext.getMessage( " LiqBatchCod ", "")+GXutil.trim( A2372LiqBatchCod)+httpContext.getMessage( " LiqBatchSeccion ", "")+GXutil.trim( A2373LiqBatchSeccion)+httpContext.getMessage( " &loteProcesado ", "")+GXutil.trim( GXutil.booltostr( AV80loteProcesado))) ;
         if ( ( A2374LiqBatchEtapa == 2 ) && ! AV80loteProcesado )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "Terminé el lote ", "")+GXutil.trim( AV83auxLiqBatchCod)+httpContext.getMessage( " de ", "")+GXutil.trim( AV65LiqBatchSeccion)) ;
            AV158LiqBatchLegajos = A2378LiqBatchLegajos ;
            /* Execute user subroutine: 'EJECUTAR SIGUIENTE' */
            S215 ();
            if ( returnInSub )
            {
               pr_default.close(3);
               returnInSub = true;
               if (true) return;
            }
         }
         else
         {
            if ( ! AV80loteProcesado )
            {
               if ( ( ( GXutil.strcmp(AV87invocacionPDFMetodoPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 ) || ( GXutil.strcmp(AV87invocacionPDFMetodoPalabra, httpContext.getMessage( "ASINCRONA", "")) == 0 ) ) && ( A2374LiqBatchEtapa == 1 ) && ( ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 ) || ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 ) ) )
               {
                  AV160verificarFin = true ;
               }
               else
               {
                  if ( ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 ) && ( GXutil.strcmp(AV87invocacionPDFMetodoPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(AV159liqPDFModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 ) )
                  {
                     AV160verificarFin = true ;
                  }
                  else
                  {
                     AV160verificarFin = false ;
                  }
               }
            }
            else
            {
               AV160verificarFin = false ;
            }
            if ( AV160verificarFin )
            {
               AV44LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
               AV44LegNumero.fromJSonString(A2378LiqBatchLegajos, null);
               if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 )
               {
                  GXv_boolean5[0] = AV157falta ;
                  new web.faltanpdfs(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, AV113ImprimirLiqLeg, GXv_boolean5) ;
                  orquestaliquidacion.this.AV157falta = GXv_boolean5[0] ;
               }
               else
               {
                  GXv_boolean5[0] = AV157falta ;
                  new web.faltanlsds(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, GXv_boolean5) ;
                  orquestaliquidacion.this.AV157falta = GXv_boolean5[0] ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "faltan ", "")+GXutil.trim( AV65LiqBatchSeccion)+" "+GXutil.trim( GXutil.booltostr( AV157falta))) ;
               if ( ! AV157falta )
               {
                  AV63LiqBatchEtapa = (short)(AV63LiqBatchEtapa+1) ;
                  new web.grabaliquidacionlote(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, A2372LiqBatchCod, AV65LiqBatchSeccion, (short)(2), "", AV44LegNumero, "") ;
                  AV158LiqBatchLegajos = A2378LiqBatchLegajos ;
                  /* Execute user subroutine: 'EJECUTAR SIGUIENTE' */
                  S215 ();
                  if ( returnInSub )
                  {
                     pr_default.close(3);
                     returnInSub = true;
                     if (true) return;
                  }
               }
            }
         }
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV172GXLvl434 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "none secundarios", "")) ;
         /* Execute user subroutine: 'CHEQUEAR EXISTENCIA LIQUIDACIÓN' */
         S181 ();
         if (returnInSub) return;
      }
      if ( AV63LiqBatchEtapa == ( AV28cantidadDeLotes * 2 ) )
      {
         if ( ! (0==AV64LiqBatchErrN) )
         {
            /* Using cursor P02BE6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro), AV65LiqBatchSeccion});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A2373LiqBatchSeccion = P02BE6_A2373LiqBatchSeccion[0] ;
               A2371LiqBatchLiqNro = P02BE6_A2371LiqBatchLiqNro[0] ;
               A1EmpCod = P02BE6_A1EmpCod[0] ;
               A3CliCod = P02BE6_A3CliCod[0] ;
               A2375LiqBatchError = P02BE6_A2375LiqBatchError[0] ;
               A2372LiqBatchCod = P02BE6_A2372LiqBatchCod[0] ;
               AV66LiqBatchError += A2375LiqBatchError ;
               pr_default.readNext(4);
            }
            pr_default.close(4);
         }
         if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
         {
            AV35DepLSDListo = true ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
         {
            AV10ContrListo = true ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "OTROS", "")) == 0 )
         {
            AV30OtrosListo = true ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 )
         {
            AV42PDFListo = true ;
         }
         if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            /* Execute user subroutine: 'SETEAR FLAGS ERROR SECUNDARIOS' */
            S221 ();
            if (returnInSub) return;
         }
         else
         {
            if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) != 0 )
            {
               AV14LiqAuxEstado = (byte)(3) ;
               AV21NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "OK ", "")+GXutil.trim( AV67notificacionPalabra)+" "+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)) );
            }
            else
            {
               if ( ! AV46PDFmanualEs )
               {
                  AV43LiqPDFEstado = "Completo" ;
                  AV21NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "OK GENERACION_PDFS ", "")+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)) );
               }
               else
               {
                  AV43LiqPDFEstado = "Manual" ;
                  AV21NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "MANUAL GENERACION_PDFS ", "")+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)) );
               }
            }
         }
         /* Execute user subroutine: 'SETEAR ESTADOS SECUNDARIOS' */
         S231 ();
         if (returnInSub) return;
         Application.commitDataStores(context, remoteHandle, pr_default, "orquestaliquidacion");
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "invoca para \"completo\"", "")) ;
         AV132notificaciones.add(AV21NotificationInfo.getgxTv_SdtNotificationInfo_Id(), 0);
      }
      else
      {
         if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
         {
            AV99ConCodigo = AV129LSDConCodigo ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
         {
            AV99ConCodigo = AV100ContrConCodigo ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "OTROS", "")) == 0 )
         {
            AV99ConCodigo = AV135OtrosConCodigo ;
         }
         AV140ProgresoLiqBatchSeccion = AV65LiqBatchSeccion ;
         /* Execute user subroutine: 'MOSTRAR PROGRESO' */
         S191 ();
         if (returnInSub) return;
      }
   }

   public void S133( )
   {
      /* 'LOTE PROCESADO' Routine */
      returnInSub = false ;
      AV80loteProcesado = false ;
      AV174GXV1 = 1 ;
      while ( AV174GXV1 <= AV81batch_seccion_lote.size() )
      {
         AV82item = (web.Sdtbatch_seccion_lote_batch_seccion_loteItem)((web.Sdtbatch_seccion_lote_batch_seccion_loteItem)AV81batch_seccion_lote.elementAt(-1+AV174GXV1));
         if ( ( GXutil.strcmp(AV82item.getgxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod(), AV83auxLiqBatchCod) == 0 ) && ( GXutil.strcmp(AV82item.getgxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion(), AV84auxLiqBatchSeccion) == 0 ) )
         {
            AV80loteProcesado = true ;
            if (true) break;
         }
         AV174GXV1 = (int)(AV174GXV1+1) ;
      }
   }

   public void S163( )
   {
      /* 'AGREGAR LOTE PROCESADO' Routine */
      returnInSub = false ;
      AV82item = (web.Sdtbatch_seccion_lote_batch_seccion_loteItem)new web.Sdtbatch_seccion_lote_batch_seccion_loteItem(remoteHandle, context);
      AV82item.setgxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod( AV83auxLiqBatchCod );
      AV82item.setgxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion( AV84auxLiqBatchSeccion );
      AV81batch_seccion_lote.add(AV82item, 0);
   }

   public void S173( )
   {
      /* 'NOTIFICAR PARCIAL' Routine */
      returnInSub = false ;
      AV132notificaciones.add(httpContext.getMessage( "PARCIAL ", "")+GXutil.trim( AV67notificacionPalabra)+" "+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)), 0);
   }

   public void S241( )
   {
      /* 'INVOCAR REST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ARMA SDT' */
      S251 ();
      if (returnInSub) return;
      GXv_int8[0] = AV115iReplica ;
      GXv_int13[0] = AV142replicaNro ;
      new web.getnextreplicanro(remoteHandle, context).execute( AV143replicas, GXv_int8, GXv_int13) ;
      orquestaliquidacion.this.AV115iReplica = GXv_int8[0] ;
      orquestaliquidacion.this.AV142replicaNro = GXv_int13[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "ejecu &sdt_datos_sec ", "")+AV57sdt_datos_sec.toJSonString(false, true)) ;
      GXv_boolean5[0] = false ;
      GXv_char4[0] = AV12errorTexto ;
      new web.invocar_rest_conreplica(remoteHandle, context).execute( AV9CliCod, AV145RestLocId, AV142replicaNro, AV57sdt_datos_sec.toJSonString(false, true), GXv_boolean5, GXv_char4) ;
      orquestaliquidacion.this.AV12errorTexto = GXv_char4[0] ;
   }

   public void S181( )
   {
      /* 'CHEQUEAR EXISTENCIA LIQUIDACIÓN' Routine */
      returnInSub = false ;
      AV175GXLvl621 = (byte)(0) ;
      /* Using cursor P02BE7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19LiqNro)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A31LiqNro = P02BE7_A31LiqNro[0] ;
         A1EmpCod = P02BE7_A1EmpCod[0] ;
         A3CliCod = P02BE7_A3CliCod[0] ;
         A874LiqNombre = P02BE7_A874LiqNombre[0] ;
         AV175GXLvl621 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(5);
      if ( AV175GXLvl621 == 0 )
      {
         AV31seguir = false ;
         AV12errorTexto = httpContext.getMessage( "La liquidación fué eliminada", "") ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, AV12errorTexto) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S153( )
   {
      /* 'EJECUTAR RECIBO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "ejecutar recibo &&liqRecibosModoPalabra ", "")+AV90liqRecibosModoPalabra) ;
      if ( GXutil.strcmp(AV90liqRecibosModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
      {
         GXt_char2 = AV155recibodaemonUUID ;
         GXv_char4[0] = GXt_char2 ;
         new web.daemondisponible(remoteHandle, context).execute( AV9CliCod, "GENERACION_PDFS", GXv_char4) ;
         orquestaliquidacion.this.GXt_char2 = GXv_char4[0] ;
         AV155recibodaemonUUID = GXt_char2 ;
         if ( (GXutil.strcmp("", AV155recibodaemonUUID)==0) )
         {
            AV155recibodaemonUUID = httpContext.getMessage( "LOCAL (falló DAEMON)", "") ;
         }
      }
      else
      {
         AV155recibodaemonUUID = httpContext.getMessage( "LOCAL", "") ;
      }
      GXv_char4[0] = AV12errorTexto ;
      new web.ejecutarrecibo(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, 0, AV79LiqBatchCod, AV25clientId, AV130micorservicio, AV90liqRecibosModoPalabra, AV75sqsGenPdfsURL, AV109GenRecRestLocId, GXutil.booltostr( AV108GenRec_RestLocHab), AV107GenRec_replicas, GXutil.booltostr( AV69desgloceEs), AV106flujoGenRecPalabra, AV112iGenRec, AV155recibodaemonUUID, true, GXv_char4) ;
      orquestaliquidacion.this.AV12errorTexto = GXv_char4[0] ;
      if ( ! (GXutil.strcmp("", AV12errorTexto)==0) )
      {
         /* Execute user subroutine: 'ERROR' */
         S111 ();
         if (returnInSub) return;
         AV31seguir = false ;
      }
   }

   public void S143( )
   {
      /* 'EJECUTAR DEPENDENCIAS LSD' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "ejecutar dependencias lsd 1", "")) ;
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV121liqLSDModoPalabra)), httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( AV69desgloceEs ) && ! (GXutil.strcmp("", AV70sqsDepLsdURL)==0) )
      {
         GXv_Sdtsdt_datos_sec14[0] = AV57sdt_datos_sec;
         new web.armarsdtdatossec(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, AV79LiqBatchCod, AV25clientId, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), GXv_Sdtsdt_datos_sec14) ;
         AV57sdt_datos_sec = GXv_Sdtsdt_datos_sec14[0] ;
         GXv_char4[0] = AV12errorTexto ;
         new web.msgsqs(remoteHandle, context).execute( AV9CliCod, AV57sdt_datos_sec.toJSonString(false, true), AV70sqsDepLsdURL, "", GXv_char4) ;
         orquestaliquidacion.this.AV12errorTexto = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV12errorTexto)==0) )
         {
            /* Execute user subroutine: 'ERROR' */
            S111 ();
            if (returnInSub) return;
            AV31seguir = false ;
         }
      }
      else
      {
         AV130micorservicio = httpContext.getMessage( "DEPENDENCIAS_LSD", "") ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV121liqLSDModoPalabra)), httpContext.getMessage( "DOCKER", "")) == 0 ) && ( AV103DepLSD_RestLocHab ) && ( AV69desgloceEs ) )
         {
            AV143replicas = AV102DepLsd_replicas ;
            AV115iReplica = AV111iDepLsd ;
            AV145RestLocId = AV104depLsdRestLocId ;
            /* Execute user subroutine: 'INVOCAR REST' */
            S241 ();
            if (returnInSub) return;
            if ( ! (GXutil.strcmp("", AV12errorTexto)==0) )
            {
               System.out.println( httpContext.getMessage( "No se pudo ejecutar el microservicio http de dependencias lsd, se ejecuta en modo local (", "")+GXutil.trim( AV12errorTexto)+httpContext.getMessage( "), req: ", "")+GXutil.trim( AV57sdt_datos_sec.toJSonString(false, true)) );
               AV12errorTexto = "" ;
               AV161modoPalabra = httpContext.getMessage( "LOCAL (falló HTTP)", "") ;
               new web.procesossecundarios(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, 0, AV25clientId, AV79LiqBatchCod, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), false, AV161modoPalabra) ;
            }
         }
         else
         {
            AV156falloDaemon = false ;
            if ( GXutil.strcmp(AV121liqLSDModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
            {
               GXv_char4[0] = AV154lsddaemonUUID ;
               new web.daemondisponible(remoteHandle, context).execute( AV9CliCod, "DEPENDENCIAS_LSD", GXv_char4) ;
               orquestaliquidacion.this.AV154lsddaemonUUID = GXv_char4[0] ;
               GXt_boolean15 = AV156falloDaemon ;
               GXv_boolean5[0] = GXt_boolean15 ;
               new web.daemonvalido(remoteHandle, context).execute( AV154lsddaemonUUID, true, GXv_boolean5) ;
               orquestaliquidacion.this.GXt_boolean15 = GXv_boolean5[0] ;
               AV156falloDaemon = (boolean)(!GXt_boolean15) ;
            }
            if ( ( GXutil.strcmp(AV121liqLSDModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 ) && ! AV156falloDaemon )
            {
               /* Execute user subroutine: 'ARMA SDT' */
               S251 ();
               if (returnInSub) return;
               new web.newcola(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, (byte)(0), "DEPENDENCIAS_LSD", AV57sdt_datos_sec.toJSonString(false, true), AV154lsddaemonUUID) ;
            }
            else
            {
               if ( ( ( AV156falloDaemon ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV121liqLSDModoPalabra)), httpContext.getMessage( "MONOLITICO", "")) == 0 ) ) && ( GXutil.strcmp(AV122liqPrinModoPalabra, httpContext.getMessage( "MONOLITICO", "")) != 0 ) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "ejecutar dependencias lsd 2", "")) ;
                  AV161modoPalabra = httpContext.getMessage( "LOCAL", "") ;
                  if ( AV156falloDaemon )
                  {
                     AV161modoPalabra += httpContext.getMessage( " (falló DAEMON)", "") ;
                  }
                  new web.procesossecundarios(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, 0, AV25clientId, AV79LiqBatchCod, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), false, AV161modoPalabra) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "ejecutar dependencias lsd 3", "")) ;
               }
            }
         }
      }
   }

   public void S191( )
   {
      /* 'MOSTRAR PROGRESO' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV140ProgresoLiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) != 0 )
      {
         GXv_int13[0] = AV96cantDet ;
         new web.getcantdetcalculado(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV99ConCodigo, GXv_int13) ;
         orquestaliquidacion.this.AV96cantDet = GXv_int13[0] ;
      }
      else
      {
         GXv_int13[0] = AV96cantDet ;
         new web.contarpdfs(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, GXv_int13) ;
         orquestaliquidacion.this.AV96cantDet = GXv_int13[0] ;
      }
      AV138porcentaje = (short)((AV96cantDet*100)/ (double) (AV97cantLeg)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "helllllo &cantDet ", "")+GXutil.trim( GXutil.str( AV96cantDet, 4, 0))+httpContext.getMessage( " &cantLeg ", "")+GXutil.trim( GXutil.str( AV97cantLeg, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "helllllo &&PrinConCodigo ", "")+GXutil.trim( AV139PrinConCodigo)+httpContext.getMessage( " &porcentaje ", "")+GXutil.trim( GXutil.str( AV138porcentaje, 3, 0))) ;
      if ( GXutil.strcmp(AV140ProgresoLiqBatchSeccion, httpContext.getMessage( "PRINCIPALES", "")) == 0 )
      {
         AV141progresoNotificacionPalabra = httpContext.getMessage( "GuardaLiquidacion", "") ;
      }
      else
      {
         AV141progresoNotificacionPalabra = AV140ProgresoLiqBatchSeccion ;
      }
      AV132notificaciones.add(httpContext.getMessage( "PROGRESO_", "")+GXutil.trim( GXutil.str( AV138porcentaje, 3, 0))+" "+GXutil.trim( AV141progresoNotificacionPalabra)+" "+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)), 0);
   }

   public void S261( )
   {
      /* 'NOTIFICACIONES' Routine */
      returnInSub = false ;
      if ( AV132notificaciones.size() > 0 )
      {
         GXv_char4[0] = "" ;
         new web.invocarnotificacion(remoteHandle, context).execute( AV9CliCod, AV132notificaciones.toJSonString(false), "", AV25clientId, GXv_char4) ;
      }
   }

   public void S221( )
   {
      /* 'SETEAR FLAGS ERROR SECUNDARIOS' Routine */
      returnInSub = false ;
      AV14LiqAuxEstado = (byte)(2) ;
      AV43LiqPDFEstado = "Error" ;
      AV21NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "ERROR ", "")+GXutil.trim( AV67notificacionPalabra)+" "+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)) );
      if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) != 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "seguir false x1", "")) ;
      }
      else
      {
      }
      AV31seguir = false ;
   }

   public void S231( )
   {
      /* 'SETEAR ESTADOS SECUNDARIOS' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
      {
         new web.setliqestdeplsd(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
         if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            new web.setliqestcontr(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
            new web.setliqestadoaux(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
            new web.setliqestpdf(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV43LiqPDFEstado) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "setea ... &LiqPDFEstado ", "")+AV43LiqPDFEstado) ;
         }
      }
      else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
      {
         new web.setliqestcontr(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
         if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            new web.setliqestadoaux(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
            new web.setliqestpdf(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV43LiqPDFEstado) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "setea err &LiqPDFEstado ", "")+AV43LiqPDFEstado) ;
         }
      }
      else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "OTROS", "")) == 0 )
      {
         new web.setliqestadoaux(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
         if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            new web.setliqestpdf(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV43LiqPDFEstado) ;
         }
      }
      else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 )
      {
         new web.setliqestpdf(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV43LiqPDFEstado) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "setea ??? &LiqPDFEstado ", "")+AV43LiqPDFEstado) ;
         if ( ! (GXutil.strcmp("", AV66LiqBatchError)==0) )
         {
            new web.setliqestdeplsd(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
            new web.setliqestcontr(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
            new web.setliqestadoaux(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV14LiqAuxEstado) ;
         }
      }
   }

   public void S251( )
   {
      /* 'ARMA SDT' Routine */
      returnInSub = false ;
      GXv_Sdtsdt_datos_sec14[0] = AV57sdt_datos_sec;
      new web.armarsdtdatossec(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, AV79LiqBatchCod, AV25clientId, AV130micorservicio, GXv_Sdtsdt_datos_sec14) ;
      AV57sdt_datos_sec = GXv_Sdtsdt_datos_sec14[0] ;
   }

   public void S215( )
   {
      /* 'EJECUTAR SIGUIENTE' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) != 0 ) && ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "OTROS", "")) != 0 ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "como no es pdf ni otros...", "")) ;
         if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
         {
            AV72siguienteEjecutarSolo = httpContext.getMessage( "CONTRIBUCIONES", "") ;
            AV147siguienteMicroservicio = "CONTRIBUCIONES" ;
            AV146siguiente_replicas = AV92CalcContr_replicas ;
            AV150siguientesI = AV110iContr ;
            AV149siguienteRestLocId = AV101ContrRestLocId ;
            AV148siguienteRestLocHab = AV93CalcContr_RestLocHab ;
            AV71sqsSecdURL = AV73sqsContrURL ;
            AV85liqModoPalabra = AV88liqContrModoPalabra ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "seteo siguiente de contribuciones", "")) ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
         {
            AV72siguienteEjecutarSolo = httpContext.getMessage( "OTROS", "") ;
            AV147siguienteMicroservicio = "OTROS" ;
            AV146siguiente_replicas = AV134Otros_replicas ;
            AV150siguientesI = AV114iOtros ;
            AV149siguienteRestLocId = AV136OtrosRestLocId ;
            AV148siguienteRestLocHab = AV94CalcOtros_RestLocHab ;
            AV71sqsSecdURL = AV74sqsOtrURL ;
            AV85liqModoPalabra = AV89liqOtrosModoPalabra ;
         }
         AV77siguienteMessageGroup = GXutil.trim( AV72siguienteEjecutarSolo) + "_" + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV11EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV19LiqNro, 8, 0)) ;
         AV44LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
         AV44LegNumero.fromJSonString(AV158LiqBatchLegajos, null);
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV85liqModoPalabra)), httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( AV69desgloceEs ) && ! (GXutil.strcmp("", AV71sqsSecdURL)==0) )
         {
            GXv_Sdtsdt_datos_sec14[0] = AV57sdt_datos_sec;
            new web.armarsdtdatossec(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, AV79LiqBatchCod, AV25clientId, AV72siguienteEjecutarSolo, GXv_Sdtsdt_datos_sec14) ;
            AV57sdt_datos_sec = GXv_Sdtsdt_datos_sec14[0] ;
            GXv_char4[0] = AV12errorTexto ;
            new web.msgsqs(remoteHandle, context).execute( AV9CliCod, AV57sdt_datos_sec.toJSonString(false, true), AV71sqsSecdURL, AV77siguienteMessageGroup, GXv_char4) ;
            orquestaliquidacion.this.AV12errorTexto = GXv_char4[0] ;
            if ( ! (GXutil.strcmp("", AV12errorTexto)==0) )
            {
               /* Execute user subroutine: 'ERROR' */
               S111 ();
               if (returnInSub) return;
               AV31seguir = false ;
            }
            if ( false )
            {
            }
         }
         else
         {
            AV130micorservicio = AV72siguienteEjecutarSolo ;
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV85liqModoPalabra)), httpContext.getMessage( "DOCKER", "")) == 0 ) && ( AV148siguienteRestLocHab ) && ( AV69desgloceEs ) )
            {
               AV143replicas = AV146siguiente_replicas ;
               AV115iReplica = AV150siguientesI ;
               AV145RestLocId = AV149siguienteRestLocId ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "como es docker con microservicio, llamo a ", "")+AV130micorservicio) ;
               /* Execute user subroutine: 'INVOCAR REST' */
               S241 ();
               if (returnInSub) return;
               if ( ! (GXutil.strcmp("", AV12errorTexto)==0) )
               {
                  System.out.println( httpContext.getMessage( "No se pudo ejecutar el microservicio http de ", "")+GXutil.trim( AV72siguienteEjecutarSolo)+httpContext.getMessage( " se ejecuta en modo local (", "")+GXutil.trim( AV12errorTexto)+httpContext.getMessage( "), req: ", "")+GXutil.trim( AV57sdt_datos_sec.toJSonString(false, true)) );
                  AV12errorTexto = "" ;
                  AV161modoPalabra = httpContext.getMessage( "LOCAL (falló HTTP)", "") ;
                  new web.procesossecundarios(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, 0, AV25clientId, AV79LiqBatchCod, AV72siguienteEjecutarSolo, false, AV161modoPalabra) ;
               }
            }
            else
            {
               AV156falloDaemon = false ;
               if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV85liqModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 )
               {
                  GXt_char2 = AV153siguientedaemonUUID ;
                  GXv_char4[0] = GXt_char2 ;
                  new web.daemondisponible(remoteHandle, context).execute( AV9CliCod, AV147siguienteMicroservicio, GXv_char4) ;
                  orquestaliquidacion.this.GXt_char2 = GXv_char4[0] ;
                  AV153siguientedaemonUUID = GXt_char2 ;
                  GXt_boolean15 = AV156falloDaemon ;
                  GXv_boolean5[0] = GXt_boolean15 ;
                  new web.daemonvalido(remoteHandle, context).execute( AV153siguientedaemonUUID, true, GXv_boolean5) ;
                  orquestaliquidacion.this.GXt_boolean15 = GXv_boolean5[0] ;
                  AV156falloDaemon = (boolean)(!GXt_boolean15) ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "&liqModoPalabra ", "")+GXutil.trim( AV85liqModoPalabra)+httpContext.getMessage( " &falloDaemon ", "")+GXutil.trim( GXutil.booltostr( AV156falloDaemon))) ;
               if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV85liqModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 ) && ! AV156falloDaemon )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV168Pgmname, httpContext.getMessage( "nueva cola &siguientedaemonUUID ", "")+GXutil.trim( AV153siguientedaemonUUID)) ;
                  /* Execute user subroutine: 'ARMA SDT' */
                  S251 ();
                  if (returnInSub) return;
                  new web.newcola(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, (byte)(0), AV147siguienteMicroservicio, AV57sdt_datos_sec.toJSonString(false, true), AV153siguientedaemonUUID) ;
               }
               else
               {
                  if ( ( AV156falloDaemon ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV85liqModoPalabra)), httpContext.getMessage( "MONOLITICO", "")) == 0 ) )
                  {
                     AV161modoPalabra = httpContext.getMessage( "LOCAL", "") ;
                     if ( AV156falloDaemon )
                     {
                        AV162modo += httpContext.getMessage( " (falló DAEMON)", "") ;
                     }
                     new web.procesossecundarios(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV19LiqNro, AV44LegNumero, 0, AV25clientId, AV79LiqBatchCod, AV72siguienteEjecutarSolo, false, AV161modoPalabra) ;
                  }
               }
            }
         }
      }
      /* Execute user subroutine: 'AGREGAR LOTE PROCESADO' */
      S163 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "GENERACION_PDFS", "")) != 0 )
      {
         if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
         {
            AV125loteLSDNro = (short)(AV125loteLSDNro+1) ;
            AV128loteSecNro = AV125loteLSDNro ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
         {
            AV123loteContrNro = (short)(AV123loteContrNro+1) ;
            AV128loteSecNro = AV123loteContrNro ;
         }
         else if ( GXutil.strcmp(AV65LiqBatchSeccion, httpContext.getMessage( "OTROS", "")) == 0 )
         {
            AV126loteOtrosNro = (short)(AV126loteOtrosNro+1) ;
            AV128loteSecNro = AV126loteOtrosNro ;
         }
         if ( AV128loteSecNro > 1 )
         {
            /* Execute user subroutine: 'NOTIFICAR PARCIAL' */
            S173 ();
            if (returnInSub) return;
         }
      }
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV159liqPDFModoPalabra = "" ;
      AV106flujoGenRecPalabra = "" ;
      AV113ImprimirLiqLeg = "" ;
      GXv_int6 = new byte[1] ;
      GXv_int7 = new int[1] ;
      AV104depLsdRestLocId = "" ;
      AV102DepLsd_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV109GenRecRestLocId = "" ;
      AV107GenRec_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV101ContrRestLocId = "" ;
      AV92CalcContr_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV136OtrosRestLocId = "" ;
      AV134Otros_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int10 = new GXSimpleCollection[1] ;
      AV87invocacionPDFMetodoPalabra = "" ;
      AV47ParmValue = "" ;
      AV68sqsPrinURL = "" ;
      AV70sqsDepLsdURL = "" ;
      AV75sqsGenPdfsURL = "" ;
      AV73sqsContrURL = "" ;
      AV74sqsOtrURL = "" ;
      AV49preEsperaPorLeg = DecimalUtil.ZERO ;
      AV122liqPrinModoPalabra = "" ;
      AV121liqLSDModoPalabra = "" ;
      AV88liqContrModoPalabra = "" ;
      AV89liqOtrosModoPalabra = "" ;
      AV90liqRecibosModoPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV12errorTexto = "" ;
      AV168Pgmname = "" ;
      GXv_int9 = new byte[1] ;
      AV163LiqModTra = "" ;
      AV165LiqTipoTarifa = "" ;
      AV139PrinConCodigo = "" ;
      AV129LSDConCodigo = "" ;
      AV100ContrConCodigo = "" ;
      AV135OtrosConCodigo = "" ;
      AV132notificaciones = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65LiqBatchSeccion = "" ;
      AV67notificacionPalabra = "" ;
      scmdbuf = "" ;
      P02BE2_A31LiqNro = new int[1] ;
      P02BE2_A1EmpCod = new short[1] ;
      P02BE2_A3CliCod = new int[1] ;
      P02BE2_A2298LiqCancel = new boolean[] {false} ;
      AV50TLiqCod = "" ;
      AV20LiqPeriodo = GXutil.nullDate() ;
      A2372LiqBatchCod = "" ;
      A2373LiqBatchSeccion = "" ;
      A2378LiqBatchLegajos = "" ;
      AV66LiqBatchError = "" ;
      P02BE3_A2373LiqBatchSeccion = new String[] {""} ;
      P02BE3_A2371LiqBatchLiqNro = new int[1] ;
      P02BE3_A1EmpCod = new short[1] ;
      P02BE3_A3CliCod = new int[1] ;
      P02BE3_A2374LiqBatchEtapa = new short[1] ;
      P02BE3_A2376LiqBatchErrN = new short[1] ;
      P02BE3_A2372LiqBatchCod = new String[] {""} ;
      P02BE3_A2378LiqBatchLegajos = new String[] {""} ;
      AV83auxLiqBatchCod = "" ;
      AV84auxLiqBatchSeccion = "" ;
      AV79LiqBatchCod = "" ;
      AV44LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      P02BE4_A2373LiqBatchSeccion = new String[] {""} ;
      P02BE4_A2371LiqBatchLiqNro = new int[1] ;
      P02BE4_A1EmpCod = new short[1] ;
      P02BE4_A3CliCod = new int[1] ;
      P02BE4_A2375LiqBatchError = new String[] {""} ;
      P02BE4_A2372LiqBatchCod = new String[] {""} ;
      A2375LiqBatchError = "" ;
      GXv_date12 = new java.util.Date[1] ;
      AV99ConCodigo = "" ;
      AV140ProgresoLiqBatchSeccion = "" ;
      P02BE5_A2373LiqBatchSeccion = new String[] {""} ;
      P02BE5_A2371LiqBatchLiqNro = new int[1] ;
      P02BE5_A1EmpCod = new short[1] ;
      P02BE5_A3CliCod = new int[1] ;
      P02BE5_A2374LiqBatchEtapa = new short[1] ;
      P02BE5_A2376LiqBatchErrN = new short[1] ;
      P02BE5_A2372LiqBatchCod = new String[] {""} ;
      P02BE5_A2378LiqBatchLegajos = new String[] {""} ;
      AV158LiqBatchLegajos = "" ;
      P02BE6_A2373LiqBatchSeccion = new String[] {""} ;
      P02BE6_A2371LiqBatchLiqNro = new int[1] ;
      P02BE6_A1EmpCod = new short[1] ;
      P02BE6_A3CliCod = new int[1] ;
      P02BE6_A2375LiqBatchError = new String[] {""} ;
      P02BE6_A2372LiqBatchCod = new String[] {""} ;
      AV21NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV43LiqPDFEstado = "" ;
      AV81batch_seccion_lote = new GXBaseCollection<web.Sdtbatch_seccion_lote_batch_seccion_loteItem>(web.Sdtbatch_seccion_lote_batch_seccion_loteItem.class, "batch_seccion_loteItem", "PayDay", remoteHandle);
      AV82item = new web.Sdtbatch_seccion_lote_batch_seccion_loteItem(remoteHandle, context);
      AV143replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_int8 = new short[1] ;
      AV57sdt_datos_sec = new web.Sdtsdt_datos_sec(remoteHandle, context);
      AV145RestLocId = "" ;
      P02BE7_A31LiqNro = new int[1] ;
      P02BE7_A1EmpCod = new short[1] ;
      P02BE7_A3CliCod = new int[1] ;
      P02BE7_A874LiqNombre = new String[] {""} ;
      A874LiqNombre = "" ;
      AV155recibodaemonUUID = "" ;
      AV130micorservicio = "" ;
      AV161modoPalabra = "" ;
      AV154lsddaemonUUID = "" ;
      GXv_int13 = new short[1] ;
      AV141progresoNotificacionPalabra = "" ;
      AV72siguienteEjecutarSolo = "" ;
      AV147siguienteMicroservicio = "" ;
      AV146siguiente_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV149siguienteRestLocId = "" ;
      AV71sqsSecdURL = "" ;
      AV85liqModoPalabra = "" ;
      AV77siguienteMessageGroup = "" ;
      GXv_Sdtsdt_datos_sec14 = new web.Sdtsdt_datos_sec[1] ;
      AV153siguientedaemonUUID = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV162modo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.orquestaliquidacion__default(),
         new Object[] {
             new Object[] {
            P02BE2_A31LiqNro, P02BE2_A1EmpCod, P02BE2_A3CliCod, P02BE2_A2298LiqCancel
            }
            , new Object[] {
            P02BE3_A2373LiqBatchSeccion, P02BE3_A2371LiqBatchLiqNro, P02BE3_A1EmpCod, P02BE3_A3CliCod, P02BE3_A2374LiqBatchEtapa, P02BE3_A2376LiqBatchErrN, P02BE3_A2372LiqBatchCod, P02BE3_A2378LiqBatchLegajos
            }
            , new Object[] {
            P02BE4_A2373LiqBatchSeccion, P02BE4_A2371LiqBatchLiqNro, P02BE4_A1EmpCod, P02BE4_A3CliCod, P02BE4_A2375LiqBatchError, P02BE4_A2372LiqBatchCod
            }
            , new Object[] {
            P02BE5_A2373LiqBatchSeccion, P02BE5_A2371LiqBatchLiqNro, P02BE5_A1EmpCod, P02BE5_A3CliCod, P02BE5_A2374LiqBatchEtapa, P02BE5_A2376LiqBatchErrN, P02BE5_A2372LiqBatchCod, P02BE5_A2378LiqBatchLegajos
            }
            , new Object[] {
            P02BE6_A2373LiqBatchSeccion, P02BE6_A2371LiqBatchLiqNro, P02BE6_A1EmpCod, P02BE6_A3CliCod, P02BE6_A2375LiqBatchError, P02BE6_A2372LiqBatchCod
            }
            , new Object[] {
            P02BE7_A31LiqNro, P02BE7_A1EmpCod, P02BE7_A3CliCod, P02BE7_A874LiqNombre
            }
         }
      );
      AV168Pgmname = "OrquestaLiquidacion" ;
      /* GeneXus formulas. */
      AV168Pgmname = "OrquestaLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private byte GXv_int6[] ;
   private byte AV164LiqFrecPag ;
   private byte GXv_int9[] ;
   private byte AV170GXLvl269 ;
   private byte AV172GXLvl434 ;
   private byte AV14LiqAuxEstado ;
   private byte AV175GXLvl621 ;
   private short AV11EmpCod ;
   private short AV8cantidadPorLote ;
   private short AV28cantidadDeLotes ;
   private short AV111iDepLsd ;
   private short AV112iGenRec ;
   private short AV110iContr ;
   private short AV114iOtros ;
   private short AV48preEsperaSegundos ;
   private short AV24s ;
   private short AV54segEspPorLegajo ;
   private short AV53segundosEspera ;
   private short AV97cantLeg ;
   private short GXt_int11 ;
   private short AV29i ;
   private short A1EmpCod ;
   private short A2374LiqBatchEtapa ;
   private short A2376LiqBatchErrN ;
   private short AV63LiqBatchEtapa ;
   private short AV64LiqBatchErrN ;
   private short AV127lotePrinNro ;
   private short AV115iReplica ;
   private short GXv_int8[] ;
   private short AV142replicaNro ;
   private short AV96cantDet ;
   private short GXv_int13[] ;
   private short AV138porcentaje ;
   private short AV150siguientesI ;
   private short AV125loteLSDNro ;
   private short AV128loteSecNro ;
   private short AV123loteContrNro ;
   private short AV126loteOtrosNro ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV19LiqNro ;
   private int GXv_int7[] ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A2371LiqBatchLiqNro ;
   private int AV174GXV1 ;
   private java.math.BigDecimal AV49preEsperaPorLeg ;
   private String AV152daemonUUID ;
   private String AV159liqPDFModoPalabra ;
   private String AV106flujoGenRecPalabra ;
   private String AV113ImprimirLiqLeg ;
   private String AV104depLsdRestLocId ;
   private String AV109GenRecRestLocId ;
   private String AV101ContrRestLocId ;
   private String AV136OtrosRestLocId ;
   private String AV87invocacionPDFMetodoPalabra ;
   private String AV122liqPrinModoPalabra ;
   private String AV121liqLSDModoPalabra ;
   private String AV88liqContrModoPalabra ;
   private String AV89liqOtrosModoPalabra ;
   private String AV90liqRecibosModoPalabra ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV168Pgmname ;
   private String AV163LiqModTra ;
   private String AV165LiqTipoTarifa ;
   private String AV139PrinConCodigo ;
   private String AV129LSDConCodigo ;
   private String AV100ContrConCodigo ;
   private String AV135OtrosConCodigo ;
   private String AV65LiqBatchSeccion ;
   private String AV67notificacionPalabra ;
   private String scmdbuf ;
   private String AV50TLiqCod ;
   private String A2373LiqBatchSeccion ;
   private String AV84auxLiqBatchSeccion ;
   private String AV99ConCodigo ;
   private String AV140ProgresoLiqBatchSeccion ;
   private String AV43LiqPDFEstado ;
   private String AV145RestLocId ;
   private String AV155recibodaemonUUID ;
   private String AV130micorservicio ;
   private String AV161modoPalabra ;
   private String AV154lsddaemonUUID ;
   private String AV141progresoNotificacionPalabra ;
   private String AV72siguienteEjecutarSolo ;
   private String AV147siguienteMicroservicio ;
   private String AV149siguienteRestLocId ;
   private String AV85liqModoPalabra ;
   private String AV77siguienteMessageGroup ;
   private String AV153siguientedaemonUUID ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String AV162modo ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date GXv_date12[] ;
   private boolean AV46PDFmanualEs ;
   private boolean AV95calcPrin_RestLocHab ;
   private boolean AV103DepLSD_RestLocHab ;
   private boolean AV108GenRec_RestLocHab ;
   private boolean AV93CalcContr_RestLocHab ;
   private boolean AV94CalcOtros_RestLocHab ;
   private boolean AV51liquidarAuxParalelos ;
   private boolean AV69desgloceEs ;
   private boolean AV31seguir ;
   private boolean returnInSub ;
   private boolean AV10ContrListo ;
   private boolean AV35DepLSDListo ;
   private boolean AV30OtrosListo ;
   private boolean AV23PrinListo ;
   private boolean AV42PDFListo ;
   private boolean AV52timeout ;
   private boolean A2298LiqCancel ;
   private boolean AV80loteProcesado ;
   private boolean AV22ok ;
   private boolean AV160verificarFin ;
   private boolean AV157falta ;
   private boolean AV156falloDaemon ;
   private boolean AV148siguienteRestLocHab ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean5[] ;
   private String AV47ParmValue ;
   private String AV25clientId ;
   private String AV68sqsPrinURL ;
   private String AV70sqsDepLsdURL ;
   private String AV75sqsGenPdfsURL ;
   private String AV73sqsContrURL ;
   private String AV74sqsOtrURL ;
   private String AV12errorTexto ;
   private String A2372LiqBatchCod ;
   private String A2378LiqBatchLegajos ;
   private String AV66LiqBatchError ;
   private String AV83auxLiqBatchCod ;
   private String AV79LiqBatchCod ;
   private String A2375LiqBatchError ;
   private String AV158LiqBatchLegajos ;
   private String A874LiqNombre ;
   private String AV71sqsSecdURL ;
   private GXSimpleCollection<Short> AV102DepLsd_replicas ;
   private GXSimpleCollection<Short> AV107GenRec_replicas ;
   private GXSimpleCollection<Short> AV92CalcContr_replicas ;
   private GXSimpleCollection<Short> AV134Otros_replicas ;
   private GXSimpleCollection<Short> GXv_objcol_int10[] ;
   private GXSimpleCollection<Short> AV143replicas ;
   private GXSimpleCollection<Short> AV146siguiente_replicas ;
   private GXSimpleCollection<Integer> AV44LegNumero ;
   private GXBaseCollection<web.Sdtbatch_seccion_lote_batch_seccion_loteItem> AV81batch_seccion_lote ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV21NotificationInfo ;
   private web.Sdtsdt_datos_sec AV57sdt_datos_sec ;
   private IDataStoreProvider pr_default ;
   private int[] P02BE2_A31LiqNro ;
   private short[] P02BE2_A1EmpCod ;
   private int[] P02BE2_A3CliCod ;
   private boolean[] P02BE2_A2298LiqCancel ;
   private String[] P02BE3_A2373LiqBatchSeccion ;
   private int[] P02BE3_A2371LiqBatchLiqNro ;
   private short[] P02BE3_A1EmpCod ;
   private int[] P02BE3_A3CliCod ;
   private short[] P02BE3_A2374LiqBatchEtapa ;
   private short[] P02BE3_A2376LiqBatchErrN ;
   private String[] P02BE3_A2372LiqBatchCod ;
   private String[] P02BE3_A2378LiqBatchLegajos ;
   private String[] P02BE4_A2373LiqBatchSeccion ;
   private int[] P02BE4_A2371LiqBatchLiqNro ;
   private short[] P02BE4_A1EmpCod ;
   private int[] P02BE4_A3CliCod ;
   private String[] P02BE4_A2375LiqBatchError ;
   private String[] P02BE4_A2372LiqBatchCod ;
   private String[] P02BE5_A2373LiqBatchSeccion ;
   private int[] P02BE5_A2371LiqBatchLiqNro ;
   private short[] P02BE5_A1EmpCod ;
   private int[] P02BE5_A3CliCod ;
   private short[] P02BE5_A2374LiqBatchEtapa ;
   private short[] P02BE5_A2376LiqBatchErrN ;
   private String[] P02BE5_A2372LiqBatchCod ;
   private String[] P02BE5_A2378LiqBatchLegajos ;
   private String[] P02BE6_A2373LiqBatchSeccion ;
   private int[] P02BE6_A2371LiqBatchLiqNro ;
   private short[] P02BE6_A1EmpCod ;
   private int[] P02BE6_A3CliCod ;
   private String[] P02BE6_A2375LiqBatchError ;
   private String[] P02BE6_A2372LiqBatchCod ;
   private int[] P02BE7_A31LiqNro ;
   private short[] P02BE7_A1EmpCod ;
   private int[] P02BE7_A3CliCod ;
   private String[] P02BE7_A874LiqNombre ;
   private GXSimpleCollection<String> AV132notificaciones ;
   private web.Sdtbatch_seccion_lote_batch_seccion_loteItem AV82item ;
   private web.Sdtsdt_datos_sec GXv_Sdtsdt_datos_sec14[] ;
}

final  class orquestaliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BE2", "SELECT LiqNro, EmpCod, CliCod, LiqCancel FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02BE3", "SELECT LiqBatchSeccion, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchEtapa, LiqBatchErrN, LiqBatchCod, LiqBatchLegajos FROM LiquidacionLotes3 WHERE (CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ?) AND (LiqBatchSeccion = ( ?)) ORDER BY CliCod, EmpCod, LiqBatchLiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BE4", "SELECT LiqBatchSeccion, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchError, LiqBatchCod FROM LiquidacionLotes3 WHERE (CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ?) AND (LiqBatchSeccion = ( ?)) ORDER BY CliCod, EmpCod, LiqBatchLiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BE5", "SELECT LiqBatchSeccion, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchEtapa, LiqBatchErrN, LiqBatchCod, LiqBatchLegajos FROM LiquidacionLotes3 WHERE (CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ?) AND (LiqBatchSeccion = ( ?)) ORDER BY CliCod, EmpCod, LiqBatchLiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BE6", "SELECT LiqBatchSeccion, LiqBatchLiqNro, EmpCod, CliCod, LiqBatchError, LiqBatchCod FROM LiquidacionLotes3 WHERE (CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ?) AND (LiqBatchSeccion = ( ?)) ORDER BY CliCod, EmpCod, LiqBatchLiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BE7", "SELECT LiqNro, EmpCod, CliCod, LiqNombre FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

