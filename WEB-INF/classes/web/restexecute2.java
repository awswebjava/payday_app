package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class restexecute2 extends GXProcedure
{
   public restexecute2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( restexecute2.class ), "" );
   }

   public restexecute2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( String aP0 ,
                          int aP1 ,
                          short aP2 ,
                          String aP3 ,
                          GXBaseCollection<web.Sdthttp_headers_http_headersItem> aP4 ,
                          String aP5 ,
                          String aP6 ,
                          String aP7 ,
                          short aP8 ,
                          String[] aP9 )
   {
      restexecute2.this.aP10 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        short aP2 ,
                        String aP3 ,
                        GXBaseCollection<web.Sdthttp_headers_http_headersItem> aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        short aP8 ,
                        String[] aP9 ,
                        int[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             short aP2 ,
                             String aP3 ,
                             GXBaseCollection<web.Sdthttp_headers_http_headersItem> aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             short aP8 ,
                             String[] aP9 ,
                             int[] aP10 )
   {
      restexecute2.this.AV13Location_Host = aP0;
      restexecute2.this.AV14Location_Port = aP1;
      restexecute2.this.AV19parmLocation_Secure = aP2;
      restexecute2.this.AV12Location_BaseURL = aP3;
      restexecute2.this.AV9http_headers = aP4;
      restexecute2.this.AV17method = aP5;
      restexecute2.this.AV8body = aP6;
      restexecute2.this.AV22filePath = aP7;
      restexecute2.this.AV28timeOut = aP8;
      restexecute2.this.aP9 = aP9;
      restexecute2.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16message = httpContext.getMessage( "Location_BaseURL: ", "") + GXutil.trim( AV12Location_BaseURL) + " " + httpContext.getMessage( "Location_Host: ", "") + GXutil.trim( AV13Location_Host) + " " + httpContext.getMessage( "Location_Port: ", "") + GXutil.trim( GXutil.str( AV14Location_Port, 8, 0)) + " " + httpContext.getMessage( "parmLocation_Secure: ", "") + GXutil.trim( GXutil.str( AV19parmLocation_Secure, 4, 0)) + " " + httpContext.getMessage( "http_headers: ", "") + GXutil.trim( AV9http_headers.toJSonString(false)) + " " + httpContext.getMessage( "body length: ", "") + GXutil.trim( GXutil.str( GXutil.len( AV8body), 10, 0)) + " " + httpContext.getMessage( "method: ", "") + GXutil.trim( AV17method) + httpContext.getMessage( "filepath ", "") + GXutil.trim( AV22filePath) + httpContext.getMessage( "&body: ", "") + GXutil.trim( AV8body) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( 0, AV31Pgmname, AV16message) ;
      AV10httpclient.setHost( GXutil.trim( AV13Location_Host) );
      AV10httpclient.setPort( AV14Location_Port );
      if ( ( AV19parmLocation_Secure == ( 1 )) )
      {
         AV10httpclient.setSecure( (byte)(1) );
      }
      else
      {
         if ( AV14Location_Port == 443 )
         {
            AV10httpclient.setSecure( (byte)(1) );
         }
         else
         {
            AV10httpclient.setSecure( (byte)(0) );
         }
      }
      AV10httpclient.setBaseURL( GXutil.trim( AV12Location_BaseURL) );
      if ( ! (GXutil.strcmp("", AV22filePath)==0) )
      {
         AV23itemHttpHeader = (web.Sdthttp_headers_http_headersItem)new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
         AV23itemHttpHeader.setgxTv_Sdthttp_headers_http_headersItem_Name( httpContext.getMessage( "Content-Type", "") );
         AV23itemHttpHeader.setgxTv_Sdthttp_headers_http_headersItem_Value( httpContext.getMessage( "multipart/form-data;", "") );
         AV9http_headers.add(AV23itemHttpHeader, 0);
      }
      AV32GXV1 = 1 ;
      while ( AV32GXV1 <= AV9http_headers.size() )
      {
         AV11item = (web.Sdthttp_headers_http_headersItem)((web.Sdthttp_headers_http_headersItem)AV9http_headers.elementAt(-1+AV32GXV1));
         AV10httpclient.addHeader(GXutil.trim( AV11item.getgxTv_Sdthttp_headers_http_headersItem_Name()), GXutil.trim( AV11item.getgxTv_Sdthttp_headers_http_headersItem_Value()));
         AV32GXV1 = (int)(AV32GXV1+1) ;
      }
      if ( ! (GXutil.strcmp("", AV8body)==0) )
      {
         AV10httpclient.addString(GXutil.trim( AV8body));
      }
      if ( ! (GXutil.strcmp("", AV22filePath)==0) )
      {
         AV10httpclient.addFile(AV22filePath, httpContext.getMessage( "file", ""));
      }
      AV10httpclient.setTimeout( AV28timeOut );
      AV10httpclient.execute(GXutil.trim( AV17method), "");
      AV21statusCode = AV10httpclient.getStatusCode() ;
      if ( (GXutil.strcmp("", AV10httpclient.getErrDescription())==0) )
      {
         AV20response_raw = GXutil.trim( AV10httpclient.getString()) ;
         if ( GXutil.strSearch( AV20response_raw, httpContext.getMessage( "HTTP Status 404", ""), 1) != 0 )
         {
            new web.msgdebug(remoteHandle, context).execute( AV31Pgmname, AV20response_raw) ;
            AV20response_raw = httpContext.getMessage( "Error: El WS ", "") + GXutil.trim( AV13Location_Host) + " " + GXutil.trim( AV12Location_BaseURL) + httpContext.getMessage( " No se encuentra disponible", "") ;
            new web.msgdebug(remoteHandle, context).execute( AV31Pgmname, AV20response_raw) ;
         }
      }
      else
      {
         AV20response_raw = GXutil.trim( AV10httpclient.getErrDescription()) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( 0, AV31Pgmname, httpContext.getMessage( "status ", "")+GXutil.trim( GXutil.str( AV21statusCode, 8, 0))+httpContext.getMessage( " response ", "")+GXutil.trim( AV20response_raw)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = restexecute2.this.AV20response_raw;
      this.aP10[0] = restexecute2.this.AV21statusCode;
      CloseOpenCursors();
      AV10httpclient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20response_raw = "" ;
      AV16message = "" ;
      AV31Pgmname = "" ;
      AV10httpclient = new com.genexus.internet.HttpClient();
      AV23itemHttpHeader = new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
      AV11item = new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
      AV31Pgmname = "RestExecute2" ;
      /* GeneXus formulas. */
      AV31Pgmname = "RestExecute2" ;
      Gx_err = (short)(0) ;
   }

   private short AV19parmLocation_Secure ;
   private short AV28timeOut ;
   private short Gx_err ;
   private int AV14Location_Port ;
   private int AV21statusCode ;
   private int AV32GXV1 ;
   private String AV17method ;
   private String AV31Pgmname ;
   private String AV13Location_Host ;
   private String AV12Location_BaseURL ;
   private String AV8body ;
   private String AV22filePath ;
   private String AV20response_raw ;
   private String AV16message ;
   private com.genexus.internet.HttpClient AV10httpclient ;
   private int[] aP10 ;
   private String[] aP9 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV9http_headers ;
   private web.Sdthttp_headers_http_headersItem AV23itemHttpHeader ;
   private web.Sdthttp_headers_http_headersItem AV11item ;
}

