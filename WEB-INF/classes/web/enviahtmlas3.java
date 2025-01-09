package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class enviahtmlas3 extends GXProcedure
{
   public enviahtmlas3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( enviahtmlas3.class ), "" );
   }

   public enviahtmlas3( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             String[] aP10 )
   {
      enviahtmlas3.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      enviahtmlas3.this.AV9CliCod = aP0;
      enviahtmlas3.this.AV10EmpCod = aP1;
      enviahtmlas3.this.AV26liqnro = aP2;
      enviahtmlas3.this.AV14LegNumero = aP3;
      enviahtmlas3.this.AV16NombreArchivo = aP4;
      enviahtmlas3.this.AV44parmValor = aP5;
      enviahtmlas3.this.AV24tipoRecibo = aP6;
      enviahtmlas3.this.AV32metodoPdfPalabra = aP7;
      enviahtmlas3.this.AV39imprimirLiqLeg = aP8;
      enviahtmlas3.this.AV51liquidando = aP9;
      enviahtmlas3.this.aP10 = aP10;
      enviahtmlas3.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV43ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.grabarhtmlrecibodb_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      enviahtmlas3.this.AV43ParmValue = GXv_char1[0] ;
      AV42grabarHtmlDB = GXutil.boolval( AV43ParmValue) ;
      if ( AV42grabarHtmlDB )
      {
         new web.grabaliqleghtml(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV26liqnro, AV14LegNumero, AV44parmValor) ;
         AV21valor = "" ;
      }
      else
      {
         AV21valor = AV44parmValor ;
      }
      GXt_char2 = AV47liqPDFModoPalabra ;
      GXt_char3 = AV47liqPDFModoPalabra ;
      GXv_char1[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char1) ;
      enviahtmlas3.this.GXt_char3 = GXv_char1[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char4) ;
      enviahtmlas3.this.GXt_char2 = GXv_char4[0] ;
      AV47liqPDFModoPalabra = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV55Pgmname, httpContext.getMessage( "liquidando ", "")+GXutil.trim( GXutil.booltostr( AV51liquidando))) ;
      if ( AV51liquidando )
      {
         if ( GXutil.strcmp(AV47liqPDFModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
         {
            GXv_char4[0] = AV50LiqLegDaemonUUID ;
            new web.getliqlegdaemon(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV26liqnro, AV14LegNumero, GXv_char4) ;
            enviahtmlas3.this.AV50LiqLegDaemonUUID = GXv_char4[0] ;
            if ( ! (GXutil.strcmp("", AV50LiqLegDaemonUUID)==0) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      GXt_char3 = AV22bucket_name ;
      GXt_char2 = AV22bucket_name ;
      GXv_char4[0] = GXt_char2 ;
      new web.bucketnamepdf_codigo(remoteHandle, context).execute( GXv_char4) ;
      enviahtmlas3.this.GXt_char2 = GXv_char4[0] ;
      GXv_char1[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
      enviahtmlas3.this.GXt_char3 = GXv_char1[0] ;
      AV22bucket_name = GXt_char3 ;
      GXv_char4[0] = AV48uploadFileSqsURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_uploadfiless3_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      enviahtmlas3.this.AV48uploadFileSqsURL = GXv_char4[0] ;
      GXv_char4[0] = AV49generarPDFSqsURL ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.url_sqs_generarpdf_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      enviahtmlas3.this.AV49generarPDFSqsURL = GXv_char4[0] ;
      AV36tipoReciboPalabra = AV24tipoRecibo ;
      GXt_char3 = AV45liqRecibosModoPalabra ;
      GXt_char2 = AV45liqRecibosModoPalabra ;
      GXv_char4[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char4) ;
      enviahtmlas3.this.GXt_char2 = GXv_char4[0] ;
      GXv_char1[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
      enviahtmlas3.this.GXt_char3 = GXv_char1[0] ;
      AV45liqRecibosModoPalabra = GXt_char3 ;
      GXt_char3 = AV46liqUploadModoPalabra ;
      GXt_char2 = AV46liqUploadModoPalabra ;
      GXv_char4[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_upload_html", GXv_char4) ;
      enviahtmlas3.this.GXt_char2 = GXv_char4[0] ;
      GXv_char1[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
      enviahtmlas3.this.GXt_char3 = GXv_char1[0] ;
      AV46liqUploadModoPalabra = GXt_char3 ;
      if ( ( ( GXutil.strcmp(AV46liqUploadModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( GXutil.strcmp(AV32metodoPdfPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 ) ) || ( ( GXutil.strcmp(AV47liqPDFModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( GXutil.strcmp(AV32metodoPdfPalabra, httpContext.getMessage( "TRIGGER", "")) != 0 ) ) )
      {
         GXt_char3 = AV17nombreCarpetaParaRecibosEnNode ;
         GXv_char4[0] = GXt_char3 ;
         new web.getnombrecarpetaennode(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV14LegNumero, GXv_char4) ;
         enviahtmlas3.this.GXt_char3 = GXv_char4[0] ;
         AV17nombreCarpetaParaRecibosEnNode = GXt_char3 ;
         GXt_char3 = AV33regionPalabra ;
         GXt_char2 = AV33regionPalabra ;
         GXv_char4[0] = GXt_char2 ;
         new web.s3awsregion_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         enviahtmlas3.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
         enviahtmlas3.this.GXt_char3 = GXv_char1[0] ;
         AV33regionPalabra = GXt_char3 ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV55Pgmname, httpContext.getMessage( "valor antes ", "")+AV21valor) ;
         GXv_char4[0] = AV37valorEscapado ;
         new web.escaparhtml(remoteHandle, context).execute( AV21valor, GXv_char4) ;
         enviahtmlas3.this.AV37valorEscapado = GXv_char4[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV55Pgmname, httpContext.getMessage( "valor despues ", "")+AV37valorEscapado) ;
         GXv_char4[0] = AV27body ;
         new web.armabodyuploadlambda(remoteHandle, context).execute( "", AV37valorEscapado, AV16NombreArchivo, AV22bucket_name, AV17nombreCarpetaParaRecibosEnNode, AV33regionPalabra, httpContext.getMessage( "text/html", ""), AV9CliCod, AV10EmpCod, AV26liqnro, AV14LegNumero, AV36tipoReciboPalabra, GXv_char4) ;
         enviahtmlas3.this.AV27body = GXv_char4[0] ;
         AV28groupIdPalabra = httpContext.getMessage( "uploadHtmlAS3_", "") + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV26liqnro, 8, 0)) + "_" ;
         if ( ( GXutil.strcmp(AV45liqRecibosModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( GXutil.strcmp(AV46liqUploadModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) )
         {
            new web.invocarlambdadirecto(remoteHandle, context).execute( AV9CliCod, "", AV27body) ;
         }
         else
         {
            if ( GXutil.strcmp(AV32metodoPdfPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 )
            {
               AV35sqsURL = AV48uploadFileSqsURL ;
            }
            else
            {
               AV35sqsURL = AV49generarPDFSqsURL ;
            }
            GXv_char4[0] = AV11error ;
            new web.msgsqs(remoteHandle, context).execute( AV9CliCod, AV27body, AV35sqsURL, AV28groupIdPalabra, GXv_char4) ;
            enviahtmlas3.this.AV11error = GXv_char4[0] ;
         }
      }
      else
      {
         GXv_char4[0] = AV8a3lutilitiesHost ;
         GXv_int5[0] = AV15nodePort ;
         GXv_char1[0] = AV20urlBase ;
         GXv_char6[0] = AV17nombreCarpetaParaRecibosEnNode ;
         GXv_objcol_Sdthttp_headers_http_headersItem7[0] = AV12http_headers ;
         GXv_int8[0] = AV52timeOut ;
         new web.getnodedatos(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV14LegNumero, GXutil.trim( new web.uploadhtmlas3(remoteHandle, context).executeUdp( AV9CliCod, AV32metodoPdfPalabra, AV39imprimirLiqLeg, AV42grabarHtmlDB)), "", false, true, "", GXv_char4, GXv_int5, GXv_char1, GXv_char6, GXv_objcol_Sdthttp_headers_http_headersItem7, GXv_int8) ;
         enviahtmlas3.this.AV8a3lutilitiesHost = GXv_char4[0] ;
         enviahtmlas3.this.AV15nodePort = (short)((short)(GXv_int5[0])) ;
         enviahtmlas3.this.AV20urlBase = GXv_char1[0] ;
         enviahtmlas3.this.AV17nombreCarpetaParaRecibosEnNode = GXv_char6[0] ;
         AV12http_headers = GXv_objcol_Sdthttp_headers_http_headersItem7[0] ;
         enviahtmlas3.this.AV52timeOut = GXv_int8[0] ;
         GXv_SdtuploadS3_body9[0] = AV23uploadS3_body;
         new web.armasdtuploads3(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV26liqnro, AV14LegNumero, AV14LegNumero, AV22bucket_name, AV17nombreCarpetaParaRecibosEnNode, httpContext.getMessage( "text/html", ""), AV16NombreArchivo, AV21valor, AV36tipoReciboPalabra, GXv_SdtuploadS3_body9) ;
         AV23uploadS3_body = GXv_SdtuploadS3_body9[0] ;
         GXv_char6[0] = AV18response_raw ;
         GXv_int5[0] = AV19statusCode ;
         new web.restexecute(remoteHandle, context).execute( AV8a3lutilitiesHost, AV15nodePort, (short)(0), AV20urlBase, AV12http_headers, httpContext.getMessage( "POST", ""), AV23uploadS3_body.toJSonString(false, true), AV52timeOut, GXv_char6, GXv_int5) ;
         enviahtmlas3.this.AV18response_raw = GXv_char6[0] ;
         enviahtmlas3.this.AV19statusCode = (short)((short)(GXv_int5[0])) ;
         if ( AV19statusCode != 200 )
         {
            AV11error = GXutil.trim( AV18response_raw) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV55Pgmname, httpContext.getMessage( "mandé a asíncrono el ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
            if ( ( GXutil.strcmp(AV32metodoPdfPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(AV39imprimirLiqLeg, httpContext.getMessage( "MASIVO", "")) != 0 ) )
            {
               AV40NodeHtmlAPdf.fromJSonString(AV18response_raw, null);
               AV41nombreArchivoGenerado = AV40NodeHtmlAPdf.getgxTv_SdtNodeHtmlAPdf_Nombrearchivo() ;
            }
            if ( GXutil.strcmp(AV32metodoPdfPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 )
            {
               GXv_char6[0] = AV25LiqLinkS3Html ;
               GXv_boolean10[0] = false ;
               new web.geturlbases3_segunambiente(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "HTML", ""), GXv_char6, GXv_boolean10) ;
               enviahtmlas3.this.AV25LiqLinkS3Html = GXv_char6[0] ;
               AV25LiqLinkS3Html += "/" + GXutil.trim( AV16NombreArchivo) ;
               new web.grabalinks3recibo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV26liqnro, AV14LegNumero, AV24tipoRecibo, AV25LiqLinkS3Html) ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = enviahtmlas3.this.AV11error;
      this.aP11[0] = enviahtmlas3.this.AV41nombreArchivoGenerado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11error = "" ;
      AV41nombreArchivoGenerado = "" ;
      AV43ParmValue = "" ;
      AV21valor = "" ;
      AV47liqPDFModoPalabra = "" ;
      AV55Pgmname = "" ;
      AV50LiqLegDaemonUUID = "" ;
      AV22bucket_name = "" ;
      AV48uploadFileSqsURL = "" ;
      AV49generarPDFSqsURL = "" ;
      AV36tipoReciboPalabra = "" ;
      AV45liqRecibosModoPalabra = "" ;
      AV46liqUploadModoPalabra = "" ;
      AV17nombreCarpetaParaRecibosEnNode = "" ;
      AV33regionPalabra = "" ;
      GXt_char3 = "" ;
      GXt_char2 = "" ;
      AV37valorEscapado = "" ;
      AV27body = "" ;
      AV28groupIdPalabra = "" ;
      AV35sqsURL = "" ;
      AV8a3lutilitiesHost = "" ;
      GXv_char4 = new String[1] ;
      AV20urlBase = "" ;
      GXv_char1 = new String[1] ;
      AV12http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem7 = new GXBaseCollection[1] ;
      GXv_int8 = new short[1] ;
      AV23uploadS3_body = new web.SdtuploadS3_body(remoteHandle, context);
      GXv_SdtuploadS3_body9 = new web.SdtuploadS3_body[1] ;
      AV18response_raw = "" ;
      GXv_int5 = new int[1] ;
      AV40NodeHtmlAPdf = new web.SdtNodeHtmlAPdf(remoteHandle, context);
      AV25LiqLinkS3Html = "" ;
      GXv_char6 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV55Pgmname = "enviaHtmlAS3" ;
      /* GeneXus formulas. */
      AV55Pgmname = "enviaHtmlAS3" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV15nodePort ;
   private short AV52timeOut ;
   private short GXv_int8[] ;
   private short AV19statusCode ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV26liqnro ;
   private int AV14LegNumero ;
   private int GXv_int5[] ;
   private String AV24tipoRecibo ;
   private String AV32metodoPdfPalabra ;
   private String AV39imprimirLiqLeg ;
   private String AV47liqPDFModoPalabra ;
   private String AV55Pgmname ;
   private String AV50LiqLegDaemonUUID ;
   private String AV36tipoReciboPalabra ;
   private String AV45liqRecibosModoPalabra ;
   private String AV46liqUploadModoPalabra ;
   private String AV33regionPalabra ;
   private String GXt_char3 ;
   private String GXt_char2 ;
   private String AV28groupIdPalabra ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private String GXv_char6[] ;
   private boolean AV51liquidando ;
   private boolean AV42grabarHtmlDB ;
   private boolean returnInSub ;
   private boolean GXv_boolean10[] ;
   private String AV44parmValor ;
   private String AV43ParmValue ;
   private String AV21valor ;
   private String AV37valorEscapado ;
   private String AV27body ;
   private String AV16NombreArchivo ;
   private String AV11error ;
   private String AV41nombreArchivoGenerado ;
   private String AV22bucket_name ;
   private String AV48uploadFileSqsURL ;
   private String AV49generarPDFSqsURL ;
   private String AV17nombreCarpetaParaRecibosEnNode ;
   private String AV35sqsURL ;
   private String AV8a3lutilitiesHost ;
   private String AV20urlBase ;
   private String AV18response_raw ;
   private String AV25LiqLinkS3Html ;
   private String[] aP11 ;
   private String[] aP10 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV12http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem7[] ;
   private web.SdtuploadS3_body AV23uploadS3_body ;
   private web.SdtuploadS3_body GXv_SdtuploadS3_body9[] ;
   private web.SdtNodeHtmlAPdf AV40NodeHtmlAPdf ;
}

