package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ejecutarrecibo extends GXProcedure
{
   public ejecutarrecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ejecutarrecibo.class ), "" );
   }

   public ejecutarrecibo( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             GXSimpleCollection<Short> aP12 ,
                             String aP13 ,
                             String aP14 ,
                             short aP15 ,
                             String aP16 ,
                             boolean aP17 )
   {
      ejecutarrecibo.this.aP18 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        GXSimpleCollection<Short> aP12 ,
                        String aP13 ,
                        String aP14 ,
                        short aP15 ,
                        String aP16 ,
                        boolean aP17 ,
                        String[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             GXSimpleCollection<Short> aP12 ,
                             String aP13 ,
                             String aP14 ,
                             short aP15 ,
                             String aP16 ,
                             boolean aP17 ,
                             String[] aP18 )
   {
      ejecutarrecibo.this.AV10CliCod = aP0;
      ejecutarrecibo.this.AV11EmpCod = aP1;
      ejecutarrecibo.this.AV12LiqNro = aP2;
      ejecutarrecibo.this.AV35parmLegNumero = aP3;
      ejecutarrecibo.this.AV36unicoLegNumero = aP4;
      ejecutarrecibo.this.AV14LiqBatchCod = aP5;
      ejecutarrecibo.this.AV15ClientId = aP6;
      ejecutarrecibo.this.AV21microservicio = aP7;
      ejecutarrecibo.this.AV8liqRecibosModoPalabra = aP8;
      ejecutarrecibo.this.AV28parmsqsGenPdfsURL = aP9;
      ejecutarrecibo.this.AV27GenRecRestLocId = aP10;
      ejecutarrecibo.this.AV29parmGenRec_RestLocHab = aP11;
      ejecutarrecibo.this.AV32parmGenRec_replicas = aP12;
      ejecutarrecibo.this.AV30parmdesgloceEs = aP13;
      ejecutarrecibo.this.AV33ParmflujoGenRecPalabra = aP14;
      ejecutarrecibo.this.AV25iGenRec = aP15;
      ejecutarrecibo.this.AV38daemonUUID = aP16;
      ejecutarrecibo.this.AV42grabarLote = aP17;
      ejecutarrecibo.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV36unicoLegNumero) )
      {
         AV13LegNumero.fromJSonString(AV35parmLegNumero.toJSonString(false), null);
      }
      else
      {
         AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
         AV13LegNumero.add((int)(AV36unicoLegNumero), 0);
      }
      if ( (GXutil.strcmp("", AV28parmsqsGenPdfsURL)==0) )
      {
         GXt_char1 = AV9sqsGenPdfsURL ;
         GXt_char2 = AV9sqsGenPdfsURL ;
         GXv_char3[0] = GXt_char2 ;
         new web.url_sqs_generarpdf_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         ejecutarrecibo.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
         ejecutarrecibo.this.GXt_char1 = GXv_char4[0] ;
         AV9sqsGenPdfsURL = GXt_char1 ;
      }
      else
      {
         AV9sqsGenPdfsURL = AV28parmsqsGenPdfsURL ;
      }
      if ( (GXutil.strcmp("", AV30parmdesgloceEs)==0) )
      {
         GXv_char4[0] = AV31ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXv_char4) ;
         ejecutarrecibo.this.AV31ParmValue = GXv_char4[0] ;
         AV19desgloceEs = GXutil.boolval( AV31ParmValue) ;
      }
      else
      {
         AV19desgloceEs = GXutil.boolval( AV30parmdesgloceEs) ;
      }
      if ( (GXutil.strcmp("", AV29parmGenRec_RestLocHab)==0) )
      {
         GXv_boolean5[0] = AV18GenRec_RestLocHab ;
         GXv_objcol_int6[0] = AV23GenRec_replicas ;
         new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV10CliCod, AV27GenRecRestLocId, GXv_boolean5, GXv_objcol_int6) ;
         ejecutarrecibo.this.AV18GenRec_RestLocHab = GXv_boolean5[0] ;
         AV23GenRec_replicas = GXv_objcol_int6[0] ;
      }
      else
      {
         AV18GenRec_RestLocHab = GXutil.boolval( AV29parmGenRec_RestLocHab) ;
         AV23GenRec_replicas = AV32parmGenRec_replicas ;
      }
      if ( (GXutil.strcmp("", AV33ParmflujoGenRecPalabra)==0) )
      {
         GXt_char2 = AV20flujoGenRecPalabra ;
         GXt_char1 = AV20flujoGenRecPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.flujo_gen_rec_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         ejecutarrecibo.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
         ejecutarrecibo.this.GXt_char2 = GXv_char3[0] ;
         AV20flujoGenRecPalabra = GXt_char2 ;
      }
      else
      {
         AV20flujoGenRecPalabra = AV33ParmflujoGenRecPalabra ;
      }
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqRecibosModoPalabra)), httpContext.getMessage( "LAMBDA", "")) == 0 ) && ! (GXutil.strcmp("", AV9sqsGenPdfsURL)==0) )
      {
         GXt_char2 = AV37principalesModoPalabra ;
         GXt_char1 = AV37principalesModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char4) ;
         ejecutarrecibo.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
         ejecutarrecibo.this.GXt_char2 = GXv_char3[0] ;
         AV37principalesModoPalabra = GXt_char2 ;
         if ( ( GXutil.strcmp(AV37principalesModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( GXutil.strcmp(AV20flujoGenRecPalabra, "3") == 0 ) )
         {
            new web.invocarlambdadirecto(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "CrearPDF", ""), httpContext.getMessage( "body", "")) ;
         }
         else
         {
            AV40modoPalabra = httpContext.getMessage( "LAMBDA", "") ;
            if ( AV42grabarLote )
            {
               /* Execute user subroutine: 'GRABA LOTE' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            GXv_Sdtsdt_datos_sec7[0] = AV16sdt_datos_sec;
            new web.armarsdtdatossec(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV14LiqBatchCod, AV15ClientId, httpContext.getMessage( "GENERACION_PDFS", ""), GXv_Sdtsdt_datos_sec7) ;
            AV16sdt_datos_sec = GXv_Sdtsdt_datos_sec7[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "llama a sqs de pdf", "")) ;
            GXv_char4[0] = AV17error ;
            new web.msgsqs(remoteHandle, context).execute( AV10CliCod, AV16sdt_datos_sec.toJSonString(false, true), AV9sqsGenPdfsURL, "", GXv_char4) ;
            ejecutarrecibo.this.AV17error = GXv_char4[0] ;
            if ( false )
            {
            }
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "ejecutar recibo &&GenRec_RestLocHab ", "")+GXutil.trim( GXutil.booltostr( AV18GenRec_RestLocHab))+httpContext.getMessage( " &liqRecibosModoPalabra ", "")+AV8liqRecibosModoPalabra+httpContext.getMessage( " &desgloceEs ", "")+GXutil.trim( GXutil.booltostr( AV19desgloceEs))+httpContext.getMessage( " &flujoGenRecPalabra ", "")+AV20flujoGenRecPalabra) ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqRecibosModoPalabra)), httpContext.getMessage( "DOCKER", "")) == 0 ) && ( AV18GenRec_RestLocHab ) && ( AV19desgloceEs ) )
         {
            AV21microservicio = "" ;
            AV22replicas = AV23GenRec_replicas ;
            AV24iReplica = AV25iGenRec ;
            AV26RestLocId = AV27GenRecRestLocId ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "ejecu", "")) ;
            /* Execute user subroutine: 'INVOCAR REST' */
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
            AV39falloDaemon = false ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqRecibosModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 )
            {
               GXt_boolean8 = AV39falloDaemon ;
               GXv_boolean5[0] = GXt_boolean8 ;
               new web.daemonvalido(remoteHandle, context).execute( AV38daemonUUID, true, GXv_boolean5) ;
               ejecutarrecibo.this.GXt_boolean8 = GXv_boolean5[0] ;
               AV39falloDaemon = (boolean)(!GXt_boolean8) ;
            }
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqRecibosModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 ) && ! AV39falloDaemon )
            {
               /* Execute user subroutine: 'ARMA SDT' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV40modoPalabra = AV38daemonUUID ;
               if ( AV42grabarLote )
               {
                  /* Execute user subroutine: 'GRABA LOTE' */
                  S131 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               new web.newcola(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, (byte)(0), "GENERACION_PDFS", AV16sdt_datos_sec.toJSonString(false, true), AV38daemonUUID) ;
            }
            else
            {
               if ( ( AV39falloDaemon ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqRecibosModoPalabra)), httpContext.getMessage( "MONOLITICO", "")) == 0 ) )
               {
                  AV40modoPalabra = httpContext.getMessage( "LOCAL", "") ;
                  if ( AV39falloDaemon )
                  {
                     AV40modoPalabra += httpContext.getMessage( " (falló DAEMON)", "") ;
                  }
                  if ( AV42grabarLote )
                  {
                     /* Execute user subroutine: 'GRABA LOTE' */
                     S131 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  new web.pdfssubmit(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV15ClientId, AV14LiqBatchCod, false, AV40modoPalabra) ;
               }
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'INVOCAR REST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ARMA SDT' */
      S121 ();
      if (returnInSub) return;
      GXv_int9[0] = AV24iReplica ;
      GXv_int10[0] = AV34replicaNro ;
      new web.getnextreplicanro(remoteHandle, context).execute( AV22replicas, GXv_int9, GXv_int10) ;
      ejecutarrecibo.this.AV24iReplica = GXv_int9[0] ;
      ejecutarrecibo.this.AV34replicaNro = GXv_int10[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "ejecu &sdt_datos_sec ", "")+AV16sdt_datos_sec.toJSonString(false, true)) ;
      GXv_boolean5[0] = false ;
      GXv_char4[0] = AV17error ;
      new web.invocar_rest_conreplica(remoteHandle, context).execute( AV10CliCod, AV26RestLocId, AV34replicaNro, AV16sdt_datos_sec.toJSonString(false, true), GXv_boolean5, GXv_char4) ;
      ejecutarrecibo.this.AV17error = GXv_char4[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "&error ", "")+GXutil.trim( AV17error)) ;
      if ( ! (GXutil.strcmp("", AV17error)==0) )
      {
         System.out.println( httpContext.getMessage( "No se pudo ejecutar el microservicio http de generación de html de recibo, se ejecuta en modo local (", "")+GXutil.trim( AV17error)+httpContext.getMessage( "), req: ", "")+GXutil.trim( AV16sdt_datos_sec.toJSonString(false, true)) );
         AV17error = "" ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV45Pgmname, httpContext.getMessage( "blanquea error", "")) ;
         AV40modoPalabra = httpContext.getMessage( "LOCAL (falló HTTP)", "") ;
         if ( AV42grabarLote )
         {
            /* Execute user subroutine: 'GRABA LOTE' */
            S131 ();
            if (returnInSub) return;
         }
         new web.pdfssubmit(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV15ClientId, AV14LiqBatchCod, false, AV40modoPalabra) ;
      }
      else
      {
         AV40modoPalabra = httpContext.getMessage( "HTTP", "") ;
         if ( AV42grabarLote )
         {
            /* Execute user subroutine: 'GRABA LOTE' */
            S131 ();
            if (returnInSub) return;
         }
      }
   }

   public void S121( )
   {
      /* 'ARMA SDT' Routine */
      returnInSub = false ;
      GXv_Sdtsdt_datos_sec7[0] = AV16sdt_datos_sec;
      new web.armarsdtdatossec(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV14LiqBatchCod, AV15ClientId, AV21microservicio, GXv_Sdtsdt_datos_sec7) ;
      AV16sdt_datos_sec = GXv_Sdtsdt_datos_sec7[0] ;
   }

   public void S131( )
   {
      /* 'GRABA LOTE' Routine */
      returnInSub = false ;
      new web.grabaliquidacionlote(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV14LiqBatchCod, httpContext.getMessage( "GENERACION_PDFS", ""), (short)(1), "", AV13LegNumero, AV40modoPalabra) ;
   }

   protected void cleanup( )
   {
      this.aP18[0] = ejecutarrecibo.this.AV17error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17error = "" ;
      AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV9sqsGenPdfsURL = "" ;
      AV31ParmValue = "" ;
      AV23GenRec_replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int6 = new GXSimpleCollection[1] ;
      AV20flujoGenRecPalabra = "" ;
      AV37principalesModoPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV40modoPalabra = "" ;
      AV16sdt_datos_sec = new web.Sdtsdt_datos_sec(remoteHandle, context);
      AV45Pgmname = "" ;
      AV22replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV26RestLocId = "" ;
      GXv_int9 = new short[1] ;
      GXv_int10 = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_Sdtsdt_datos_sec7 = new web.Sdtsdt_datos_sec[1] ;
      AV45Pgmname = "ejecutarRecibo" ;
      /* GeneXus formulas. */
      AV45Pgmname = "ejecutarRecibo" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV25iGenRec ;
   private short AV24iReplica ;
   private short GXv_int9[] ;
   private short AV34replicaNro ;
   private short GXv_int10[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV36unicoLegNumero ;
   private String AV21microservicio ;
   private String AV8liqRecibosModoPalabra ;
   private String AV27GenRecRestLocId ;
   private String AV29parmGenRec_RestLocHab ;
   private String AV30parmdesgloceEs ;
   private String AV33ParmflujoGenRecPalabra ;
   private String AV38daemonUUID ;
   private String AV20flujoGenRecPalabra ;
   private String AV37principalesModoPalabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV40modoPalabra ;
   private String AV45Pgmname ;
   private String AV26RestLocId ;
   private String GXv_char4[] ;
   private boolean AV42grabarLote ;
   private boolean AV19desgloceEs ;
   private boolean AV18GenRec_RestLocHab ;
   private boolean returnInSub ;
   private boolean AV39falloDaemon ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean5[] ;
   private String AV31ParmValue ;
   private String AV14LiqBatchCod ;
   private String AV15ClientId ;
   private String AV28parmsqsGenPdfsURL ;
   private String AV17error ;
   private String AV9sqsGenPdfsURL ;
   private GXSimpleCollection<Short> AV32parmGenRec_replicas ;
   private GXSimpleCollection<Short> AV23GenRec_replicas ;
   private GXSimpleCollection<Short> GXv_objcol_int6[] ;
   private GXSimpleCollection<Short> AV22replicas ;
   private GXSimpleCollection<Integer> AV35parmLegNumero ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private String[] aP18 ;
   private web.Sdtsdt_datos_sec AV16sdt_datos_sec ;
   private web.Sdtsdt_datos_sec GXv_Sdtsdt_datos_sec7[] ;
}

