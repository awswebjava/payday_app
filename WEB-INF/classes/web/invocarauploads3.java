package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocarauploads3 extends GXProcedure
{
   public invocarauploads3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocarauploads3.class ), "" );
   }

   public invocarauploads3( int remoteHandle ,
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
                             String aP8 )
   {
      invocarauploads3.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
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
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
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
                             String[] aP9 )
   {
      invocarauploads3.this.AV10CliCod = aP0;
      invocarauploads3.this.AV11EmpCod = aP1;
      invocarauploads3.this.AV24definitivoEmpCod = aP2;
      invocarauploads3.this.AV14LegNumero = aP3;
      invocarauploads3.this.AV22definitivoLegNumero = aP4;
      invocarauploads3.this.AV16NombreArchivo = aP5;
      invocarauploads3.this.AV23contentTypePalabra = aP6;
      invocarauploads3.this.AV25bucket_name = aP7;
      invocarauploads3.this.AV26RestLocId = aP8;
      invocarauploads3.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "1") ;
      GXv_char1[0] = AV8a3lutilitiesHost ;
      GXv_int2[0] = AV15nodePort ;
      GXv_char3[0] = AV21urlBase ;
      GXv_char4[0] = AV17nombreCarpetaParaRecibosEnNode ;
      GXv_objcol_Sdthttp_headers_http_headersItem5[0] = AV13http_headers ;
      GXv_int6[0] = AV27timeOut ;
      new web.getnodedatos(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV14LegNumero, new web.uploads3node_apipalabra(remoteHandle, context).executeUdp( ), "", false, true, AV26RestLocId, GXv_char1, GXv_int2, GXv_char3, GXv_char4, GXv_objcol_Sdthttp_headers_http_headersItem5, GXv_int6) ;
      invocarauploads3.this.AV8a3lutilitiesHost = GXv_char1[0] ;
      invocarauploads3.this.AV15nodePort = GXv_int2[0] ;
      invocarauploads3.this.AV21urlBase = GXv_char3[0] ;
      invocarauploads3.this.AV17nombreCarpetaParaRecibosEnNode = GXv_char4[0] ;
      AV13http_headers = GXv_objcol_Sdthttp_headers_http_headersItem5[0] ;
      invocarauploads3.this.AV27timeOut = GXv_int6[0] ;
      GXv_SdtuploadS3_body7[0] = AV20uploadS3_body;
      new web.armasdtuploads3(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, 0, AV14LegNumero, AV22definitivoLegNumero, AV25bucket_name, AV17nombreCarpetaParaRecibosEnNode, AV23contentTypePalabra, AV16NombreArchivo, "", "", GXv_SdtuploadS3_body7) ;
      AV20uploadS3_body = GXv_SdtuploadS3_body7[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "envío ", "")+AV20uploadS3_body.toJSonString(false, true)) ;
      GXv_char4[0] = "" ;
      GXv_int2[0] = AV19statusCode ;
      new web.restexecute(remoteHandle, context).execute( AV8a3lutilitiesHost, AV15nodePort, (short)(0), AV21urlBase, AV13http_headers, httpContext.getMessage( "POST", ""), AV20uploadS3_body.toJSonString(false, true), AV27timeOut, GXv_char4, GXv_int2) ;
      invocarauploads3.this.AV19statusCode = GXv_int2[0] ;
      if ( AV19statusCode != 200 )
      {
         AV12error = httpContext.getMessage( "Hubo un error al subir el archivo a AMAZON", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&a3lutilitiesHost: ", "")+GXutil.trim( AV8a3lutilitiesHost)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&nodePort: ", "")+GXutil.trim( GXutil.str( AV15nodePort, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&urlBase: ", "")+GXutil.trim( AV21urlBase)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&nombreCarpetaParaRecibosEnNode: ", "")+GXutil.trim( AV17nombreCarpetaParaRecibosEnNode)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&uploadS3_body.bucket_name: ", "")+GXutil.trim( AV20uploadS3_body.getgxTv_SdtuploadS3_body_Bucket_name())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&uploadS3_body.file_path: ", "")+GXutil.trim( AV20uploadS3_body.getgxTv_SdtuploadS3_body_File_path())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&uploadS3_body.s3_path: ", "")+GXutil.trim( AV20uploadS3_body.getgxTv_SdtuploadS3_body_S3_path())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&uploadS3_body.file_name: ", "")+GXutil.trim( AV20uploadS3_body.getgxTv_SdtuploadS3_body_File_name())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&statusCode: ", "")+GXutil.trim( GXutil.str( AV19statusCode, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&error: ", "")+GXutil.trim( AV12error)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = invocarauploads3.this.AV12error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12error = "" ;
      AV30Pgmname = "" ;
      AV8a3lutilitiesHost = "" ;
      GXv_char1 = new String[1] ;
      AV21urlBase = "" ;
      GXv_char3 = new String[1] ;
      AV17nombreCarpetaParaRecibosEnNode = "" ;
      AV13http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem5 = new GXBaseCollection[1] ;
      GXv_int6 = new short[1] ;
      AV20uploadS3_body = new web.SdtuploadS3_body(remoteHandle, context);
      GXv_SdtuploadS3_body7 = new web.SdtuploadS3_body[1] ;
      GXv_char4 = new String[1] ;
      GXv_int2 = new int[1] ;
      AV30Pgmname = "invocarAUploadS3" ;
      /* GeneXus formulas. */
      AV30Pgmname = "invocarAUploadS3" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV24definitivoEmpCod ;
   private short AV27timeOut ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV14LegNumero ;
   private int AV22definitivoLegNumero ;
   private int AV15nodePort ;
   private int AV19statusCode ;
   private int GXv_int2[] ;
   private String AV23contentTypePalabra ;
   private String AV26RestLocId ;
   private String AV30Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV16NombreArchivo ;
   private String AV25bucket_name ;
   private String AV12error ;
   private String AV8a3lutilitiesHost ;
   private String AV21urlBase ;
   private String AV17nombreCarpetaParaRecibosEnNode ;
   private String[] aP9 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV13http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem5[] ;
   private web.SdtuploadS3_body AV20uploadS3_body ;
   private web.SdtuploadS3_body GXv_SdtuploadS3_body7[] ;
}

