package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class restexecute extends GXProcedure
{
   public restexecute( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( restexecute.class ), "" );
   }

   public restexecute( int remoteHandle ,
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
                          short aP7 ,
                          String[] aP8 )
   {
      restexecute.this.aP9 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        short aP2 ,
                        String aP3 ,
                        GXBaseCollection<web.Sdthttp_headers_http_headersItem> aP4 ,
                        String aP5 ,
                        String aP6 ,
                        short aP7 ,
                        String[] aP8 ,
                        int[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             short aP2 ,
                             String aP3 ,
                             GXBaseCollection<web.Sdthttp_headers_http_headersItem> aP4 ,
                             String aP5 ,
                             String aP6 ,
                             short aP7 ,
                             String[] aP8 ,
                             int[] aP9 )
   {
      restexecute.this.AV9Location_Host = aP0;
      restexecute.this.AV10Location_Port = aP1;
      restexecute.this.AV20parmLocation_Secure = aP2;
      restexecute.this.AV12Location_BaseURL = aP3;
      restexecute.this.AV13http_headers = aP4;
      restexecute.this.AV16method = aP5;
      restexecute.this.AV15body = aP6;
      restexecute.this.AV24timeOut = aP7;
      restexecute.this.aP8 = aP8;
      restexecute.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22message = httpContext.getMessage( "Location_BaseURL: ", "") + GXutil.trim( AV12Location_BaseURL) + " " + httpContext.getMessage( "Location_Host: ", "") + GXutil.trim( AV9Location_Host) + " " + httpContext.getMessage( "Location_Port: ", "") + GXutil.trim( GXutil.str( AV10Location_Port, 8, 0)) + " " + httpContext.getMessage( "parmLocation_Secure: ", "") + GXutil.trim( GXutil.str( AV20parmLocation_Secure, 4, 0)) + " " + httpContext.getMessage( "http_headers: ", "") + GXutil.trim( AV13http_headers.toJSonString(false)) + " " + httpContext.getMessage( "body length: ", "") + GXutil.trim( GXutil.str( GXutil.len( AV15body), 10, 0)) + " " + httpContext.getMessage( "method: ", "") + GXutil.trim( AV16method) ;
      GXt_int1 = AV23CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      restexecute.this.GXt_int1 = GXv_int2[0] ;
      AV23CliCod = GXt_int1 ;
      System.out.println( httpContext.getMessage( "restexecute clicod ", "")+GXutil.trim( GXutil.str( AV23CliCod, 6, 0)) );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, AV22message) ;
      AV8httpclient.setHost( GXutil.trim( AV9Location_Host) );
      AV8httpclient.setPort( AV10Location_Port );
      if ( ( AV20parmLocation_Secure == ( 1 )) )
      {
         AV8httpclient.setSecure( (byte)(1) );
      }
      else
      {
         if ( AV10Location_Port == 443 )
         {
            AV8httpclient.setSecure( (byte)(1) );
         }
         else
         {
            AV8httpclient.setSecure( (byte)(0) );
         }
      }
      AV8httpclient.setBaseURL( GXutil.trim( AV12Location_BaseURL) );
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV13http_headers.size() )
      {
         AV14item = (web.Sdthttp_headers_http_headersItem)((web.Sdthttp_headers_http_headersItem)AV13http_headers.elementAt(-1+AV28GXV1));
         AV8httpclient.addHeader(GXutil.trim( AV14item.getgxTv_Sdthttp_headers_http_headersItem_Name()), GXutil.trim( AV14item.getgxTv_Sdthttp_headers_http_headersItem_Value()));
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
      if ( ! (GXutil.strcmp("", AV15body)==0) )
      {
         AV8httpclient.addString(GXutil.trim( AV15body));
      }
      AV8httpclient.setTimeout( AV24timeOut );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "antes del execute", "")) ;
      AV8httpclient.execute(GXutil.trim( AV16method), "");
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "despues del execute", "")) ;
      AV18statusCode = AV8httpclient.getStatusCode() ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "&statusCode ", "")+GXutil.trim( GXutil.str( AV18statusCode, 8, 0))) ;
      if ( (GXutil.strcmp("", AV8httpclient.getErrDescription())==0) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "ok 1", "")) ;
         AV17response_raw = GXutil.trim( AV8httpclient.getString()) ;
         if ( GXutil.strSearch( AV17response_raw, httpContext.getMessage( "HTTP Status 404", ""), 1) != 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "e404", "")) ;
            AV17response_raw = httpContext.getMessage( "Error: El WS ", "") + GXutil.trim( AV9Location_Host) + " " + GXutil.trim( AV12Location_BaseURL) + httpContext.getMessage( " No se encuentra disponible", "") ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "e404 ---> ", "")+AV17response_raw) ;
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "e1", "")) ;
         AV17response_raw = GXutil.trim( AV8httpclient.getErrDescription()) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "e2", "")) ;
         AV17response_raw += httpContext.getMessage( ". Base Url: ", "") + GXutil.trim( AV12Location_BaseURL) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV27Pgmname, httpContext.getMessage( "status ", "")+GXutil.trim( GXutil.str( AV18statusCode, 8, 0))+httpContext.getMessage( " response ", "")+GXutil.trim( AV17response_raw)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = restexecute.this.AV17response_raw;
      this.aP9[0] = restexecute.this.AV18statusCode;
      CloseOpenCursors();
      AV8httpclient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17response_raw = "" ;
      AV22message = "" ;
      GXv_int2 = new int[1] ;
      AV27Pgmname = "" ;
      AV8httpclient = new com.genexus.internet.HttpClient();
      AV14item = new web.Sdthttp_headers_http_headersItem(remoteHandle, context);
      AV27Pgmname = "RestExecute" ;
      /* GeneXus formulas. */
      AV27Pgmname = "RestExecute" ;
      Gx_err = (short)(0) ;
   }

   private short AV20parmLocation_Secure ;
   private short AV24timeOut ;
   private short Gx_err ;
   private int AV10Location_Port ;
   private int AV18statusCode ;
   private int AV23CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV28GXV1 ;
   private String AV16method ;
   private String AV27Pgmname ;
   private String AV9Location_Host ;
   private String AV12Location_BaseURL ;
   private String AV15body ;
   private String AV17response_raw ;
   private String AV22message ;
   private com.genexus.internet.HttpClient AV8httpclient ;
   private int[] aP9 ;
   private String[] aP8 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV13http_headers ;
   private web.Sdthttp_headers_http_headersItem AV14item ;
}

