package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocarauploadfile2 extends GXProcedure
{
   public invocarauploadfile2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocarauploadfile2.class ), "" );
   }

   public invocarauploadfile2( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 )
   {
      invocarauploadfile2.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String[] aP10 )
   {
      invocarauploadfile2.this.AV13CliCod = aP0;
      invocarauploadfile2.this.AV17EmpCod = aP1;
      invocarauploadfile2.this.AV15definitivoEmpCod = aP2;
      invocarauploadfile2.this.AV21LegNumero = aP3;
      invocarauploadfile2.this.AV16definitivoLegNumero = aP4;
      invocarauploadfile2.this.AV10base64String = aP5;
      invocarauploadfile2.this.AV23NombreArchivo = aP6;
      invocarauploadfile2.this.AV14contentTypePalabra = aP7;
      invocarauploadfile2.this.AV12bucket_name = aP8;
      invocarauploadfile2.this.AV31que = aP9;
      invocarauploadfile2.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, "1!") ;
      GXv_char1[0] = AV37ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.s3gxes_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      invocarauploadfile2.this.AV37ParmValue = GXv_char1[0] ;
      AV38s3_Gx_Es = GXutil.boolval( AV37ParmValue) ;
      if ( AV38s3_Gx_Es )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         /* Execute user subroutine: 'ALMACENA EN SERVER LOCAL' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char2 = AV24nombreCarpetaParaRecibosEnNode ;
         GXv_char1[0] = GXt_char2 ;
         new web.getnombrecarpetaennode(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV21LegNumero, GXv_char1) ;
         invocarauploadfile2.this.GXt_char2 = GXv_char1[0] ;
         AV24nombreCarpetaParaRecibosEnNode = httpContext.getMessage( "img/", "") + GXt_char2 ;
         AV39Storage = (com.genexus.util.GXStorageProvider)new com.genexus.util.GXStorageProvider();
         AV34File.setSource( AV19filePath );
         AV35FileFullPath = AV34File.getAbsoluteName() ;
         AV40StorageObjectFullName = GXutil.trim( AV24nombreCarpetaParaRecibosEnNode) + "/" + AV23NombreArchivo ;
         if ( AV39Storage.upload(AV35FileFullPath, AV40StorageObjectFullName, AV42UploadedFile, AV36Messages) )
         {
            AV33URL = AV42UploadedFile.getURI() ;
         }
         else
         {
            AV50GXV1 = 1 ;
            while ( AV50GXV1 <= AV36Messages.size() )
            {
               AV32Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV36Messages.elementAt(-1+AV50GXV1));
               System.out.println( AV32Message.getgxTv_SdtMessages_Message_Description() );
               AV18error += AV32Message.getgxTv_SdtMessages_Message_Description() ;
               AV50GXV1 = (int)(AV50GXV1+1) ;
            }
         }
         if ( (GXutil.strcmp("", AV18error)==0) )
         {
            AV45nombreEnS3 = AV23NombreArchivo ;
            /* Execute user subroutine: 'ACTUALIZAR FOTOS NOMBRES' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         GXv_char1[0] = AV43sqs_uploadFilesS3URL ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.url_sqs_uploadfiless3_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         invocarauploadfile2.this.AV43sqs_uploadFilesS3URL = GXv_char1[0] ;
         if ( ! (GXutil.strcmp("", AV43sqs_uploadFilesS3URL)==0) )
         {
            GXt_char2 = AV24nombreCarpetaParaRecibosEnNode ;
            GXv_char1[0] = GXt_char2 ;
            new web.getnombrecarpetaennode(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV21LegNumero, GXv_char1) ;
            invocarauploadfile2.this.GXt_char2 = GXv_char1[0] ;
            AV24nombreCarpetaParaRecibosEnNode = GXt_char2 ;
            GXt_char2 = AV44regionPalabra ;
            GXt_char3 = AV44regionPalabra ;
            GXv_char1[0] = GXt_char3 ;
            new web.s3awsregion_codigoparam(remoteHandle, context).execute( GXv_char1) ;
            invocarauploadfile2.this.GXt_char3 = GXv_char1[0] ;
            GXv_char4[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char3, GXv_char4) ;
            invocarauploadfile2.this.GXt_char2 = GXv_char4[0] ;
            AV44regionPalabra = GXt_char2 ;
            GXv_char4[0] = AV11body ;
            new web.armabodyuploadlambda(remoteHandle, context).execute( AV10base64String, "", AV23NombreArchivo, AV12bucket_name, AV24nombreCarpetaParaRecibosEnNode, AV44regionPalabra, httpContext.getMessage( "application/octet-stream", ""), 0, (short)(0), 0, 0, "", GXv_char4) ;
            invocarauploadfile2.this.AV11body = GXv_char4[0] ;
            GXv_char4[0] = AV18error ;
            new web.msgsqs(remoteHandle, context).execute( AV13CliCod, AV11body, AV43sqs_uploadFilesS3URL, httpContext.getMessage( "Upload_Images", ""), GXv_char4) ;
            invocarauploadfile2.this.AV18error = GXv_char4[0] ;
         }
         else
         {
            /* Execute user subroutine: 'ALMACENA EN SERVER LOCAL' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXv_char4[0] = AV8a3lutilitiesHost ;
            GXv_int5[0] = AV22nodePort ;
            GXv_char1[0] = AV29urlBase ;
            GXv_char6[0] = AV24nombreCarpetaParaRecibosEnNode ;
            GXv_objcol_Sdthttp_headers_http_headersItem7[0] = AV20http_headers ;
            GXv_int8[0] = AV46timeOut ;
            new web.getnodedatos(remoteHandle, context).execute( AV13CliCod, AV15definitivoEmpCod, AV16definitivoLegNumero, new web.uploadfile2_apipalabra(remoteHandle, context).executeUdp( ), "", true, false, httpContext.getMessage( "node_lambda_uploadFiles", ""), GXv_char4, GXv_int5, GXv_char1, GXv_char6, GXv_objcol_Sdthttp_headers_http_headersItem7, GXv_int8) ;
            invocarauploadfile2.this.AV8a3lutilitiesHost = GXv_char4[0] ;
            invocarauploadfile2.this.AV22nodePort = GXv_int5[0] ;
            invocarauploadfile2.this.AV29urlBase = GXv_char1[0] ;
            invocarauploadfile2.this.AV24nombreCarpetaParaRecibosEnNode = GXv_char6[0] ;
            AV20http_headers = GXv_objcol_Sdthttp_headers_http_headersItem7[0] ;
            invocarauploadfile2.this.AV46timeOut = GXv_int8[0] ;
            GXv_SdtuploadS3_body9[0] = AV28uploadS3_body;
            new web.armasdtuploads3(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, 0, AV21LegNumero, AV16definitivoLegNumero, AV12bucket_name, AV24nombreCarpetaParaRecibosEnNode, AV14contentTypePalabra, AV23NombreArchivo, "", "", GXv_SdtuploadS3_body9) ;
            AV28uploadS3_body = GXv_SdtuploadS3_body9[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "envío ", "")+AV28uploadS3_body.toJSonString(false, true)) ;
            GXv_char6[0] = AV25respuesta ;
            GXv_int5[0] = AV27statusCode ;
            new web.restexecute2(remoteHandle, context).execute( AV8a3lutilitiesHost, AV22nodePort, (short)(0), AV29urlBase, AV20http_headers, httpContext.getMessage( "POST", ""), "", AV19filePath, AV46timeOut, GXv_char6, GXv_int5) ;
            invocarauploadfile2.this.AV25respuesta = GXv_char6[0] ;
            invocarauploadfile2.this.AV27statusCode = GXv_int5[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "respuesta ", "")+AV25respuesta) ;
            AV30fileUploadResponse.fromJSonString(AV25respuesta, null);
            if ( ( AV27statusCode != 200 ) && ( AV30fileUploadResponse.getgxTv_SdtfileUploadResponse_Status().doubleValue() != 200 ) )
            {
               AV18error = httpContext.getMessage( "Hubo un error al subir el archivo a servidor", "") ;
            }
            if ( (GXutil.strcmp("", AV18error)==0) )
            {
               GXv_char6[0] = AV18error ;
               new web.invocarauploads3(remoteHandle, context).execute( AV13CliCod, AV15definitivoEmpCod, AV15definitivoEmpCod, AV16definitivoLegNumero, AV16definitivoLegNumero, AV30fileUploadResponse.getgxTv_SdtfileUploadResponse_Name(), httpContext.getMessage( "image/jpeg", ""), AV12bucket_name, httpContext.getMessage( "node_lambda_uploadFiles", ""), GXv_char6) ;
               invocarauploadfile2.this.AV18error = GXv_char6[0] ;
               AV45nombreEnS3 = AV30fileUploadResponse.getgxTv_SdtfileUploadResponse_Name() ;
               /* Execute user subroutine: 'ACTUALIZAR FOTOS NOMBRES' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV17EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&&definitivoEmpCod: ", "")+GXutil.trim( GXutil.str( AV15definitivoEmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV21LegNumero, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&a3lutilitiesHost: ", "")+GXutil.trim( AV8a3lutilitiesHost)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&nodePort: ", "")+GXutil.trim( GXutil.str( AV22nodePort, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&urlBase: ", "")+GXutil.trim( AV29urlBase)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&nombreCarpetaParaRecibosEnNode: ", "")+GXutil.trim( AV24nombreCarpetaParaRecibosEnNode)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&uploadS3_body.bucket_name: ", "")+GXutil.trim( AV28uploadS3_body.getgxTv_SdtuploadS3_body_Bucket_name())) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&uploadS3_body.file_path: ", "")+GXutil.trim( AV28uploadS3_body.getgxTv_SdtuploadS3_body_File_path())) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&uploadS3_body.s3_path: ", "")+GXutil.trim( AV28uploadS3_body.getgxTv_SdtuploadS3_body_S3_path())) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&uploadS3_body.file_name: ", "")+GXutil.trim( AV28uploadS3_body.getgxTv_SdtuploadS3_body_File_name())) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&statusCode: ", "")+GXutil.trim( GXutil.str( AV27statusCode, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, httpContext.getMessage( "&error: ", "")+GXutil.trim( AV18error)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZAR FOTOS NOMBRES' Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV18error)==0) )
      {
         if ( ! (0==AV16definitivoLegNumero) )
         {
            new web.legupdatefotonom(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV16definitivoLegNumero, AV45nombreEnS3) ;
         }
         else
         {
            if ( ! (0==AV15definitivoEmpCod) )
            {
               new web.empupdatefotonom(remoteHandle, context).execute( AV13CliCod, AV15definitivoEmpCod, AV31que, AV45nombreEnS3) ;
            }
         }
      }
   }

   public void S121( )
   {
      /* 'ALMACENA EN SERVER LOCAL' Routine */
      returnInSub = false ;
      GXv_char6[0] = AV19filePath ;
      GXv_char4[0] = AV9auxError ;
      new web.almacenaarchivobase64(remoteHandle, context).execute( AV10base64String, AV23NombreArchivo, GXv_char6, GXv_char4) ;
      invocarauploadfile2.this.AV19filePath = GXv_char6[0] ;
      invocarauploadfile2.this.AV9auxError = GXv_char4[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV49Pgmname, "2") ;
      if ( ! (GXutil.strcmp("", AV9auxError)==0) )
      {
         AV18error = GXutil.trim( AV9auxError) ;
         returnInSub = true;
         if (true) return;
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = invocarauploadfile2.this.AV18error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18error = "" ;
      AV49Pgmname = "" ;
      AV37ParmValue = "" ;
      AV24nombreCarpetaParaRecibosEnNode = "" ;
      AV39Storage = new com.genexus.util.GXStorageProvider();
      AV34File = new com.genexus.util.GXFile();
      AV19filePath = "" ;
      AV35FileFullPath = "" ;
      AV40StorageObjectFullName = "" ;
      AV42UploadedFile = new com.genexus.util.GXFile();
      AV36Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV33URL = "" ;
      AV32Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV45nombreEnS3 = "" ;
      AV43sqs_uploadFilesS3URL = "" ;
      AV44regionPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      AV11body = "" ;
      AV8a3lutilitiesHost = "" ;
      AV29urlBase = "" ;
      GXv_char1 = new String[1] ;
      AV20http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem7 = new GXBaseCollection[1] ;
      GXv_int8 = new short[1] ;
      AV28uploadS3_body = new web.SdtuploadS3_body(remoteHandle, context);
      GXv_SdtuploadS3_body9 = new web.SdtuploadS3_body[1] ;
      AV25respuesta = "" ;
      GXv_int5 = new int[1] ;
      AV30fileUploadResponse = new web.SdtfileUploadResponse(remoteHandle, context);
      GXv_char6 = new String[1] ;
      AV9auxError = "" ;
      GXv_char4 = new String[1] ;
      AV49Pgmname = "invocarAUploadFile2" ;
      /* GeneXus formulas. */
      AV49Pgmname = "invocarAUploadFile2" ;
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short AV15definitivoEmpCod ;
   private short AV46timeOut ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV21LegNumero ;
   private int AV16definitivoLegNumero ;
   private int AV50GXV1 ;
   private int AV22nodePort ;
   private int AV27statusCode ;
   private int GXv_int5[] ;
   private String AV14contentTypePalabra ;
   private String AV31que ;
   private String AV49Pgmname ;
   private String AV44regionPalabra ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String GXv_char1[] ;
   private String GXv_char6[] ;
   private String GXv_char4[] ;
   private boolean AV38s3_Gx_Es ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV10base64String ;
   private String AV37ParmValue ;
   private String AV11body ;
   private String AV23NombreArchivo ;
   private String AV12bucket_name ;
   private String AV18error ;
   private String AV24nombreCarpetaParaRecibosEnNode ;
   private String AV19filePath ;
   private String AV35FileFullPath ;
   private String AV40StorageObjectFullName ;
   private String AV33URL ;
   private String AV45nombreEnS3 ;
   private String AV43sqs_uploadFilesS3URL ;
   private String AV8a3lutilitiesHost ;
   private String AV29urlBase ;
   private String AV25respuesta ;
   private String AV9auxError ;
   private com.genexus.util.GXFile AV34File ;
   private String[] aP10 ;
   private com.genexus.util.GXStorageProvider AV39Storage ;
   private com.genexus.util.GXFile AV42UploadedFile ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV36Messages ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV20http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem7[] ;
   private com.genexus.SdtMessages_Message AV32Message ;
   private web.SdtfileUploadResponse AV30fileUploadResponse ;
   private web.SdtuploadS3_body AV28uploadS3_body ;
   private web.SdtuploadS3_body GXv_SdtuploadS3_body9[] ;
}

