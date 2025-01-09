package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocar_rest extends GXProcedure
{
   public invocar_rest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocar_rest.class ), "" );
   }

   public invocar_rest( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      invocar_rest.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 )
   {
      invocar_rest.this.AV11CliCod = aP0;
      invocar_rest.this.AV40RestLocId = aP1;
      invocar_rest.this.AV10body = aP2;
      invocar_rest.this.aP3 = aP3;
      invocar_rest.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV38RestLocHab ;
      GXv_char2[0] = AV36RestLocBaseUrl ;
      GXv_int3[0] = AV37RestLocCancelOnError ;
      GXv_char4[0] = AV39RestLocHost ;
      GXv_int5[0] = AV41RestLocPort ;
      GXv_int6[0] = AV43RestLocTimeout ;
      GXv_int7[0] = AV42RestLocSecure ;
      new web.getrest_location(remoteHandle, context).execute( AV11CliCod, AV40RestLocId, (short)(0), GXv_boolean1, GXv_char2, GXv_int3, GXv_char4, GXv_int5, GXv_int6, GXv_int7) ;
      invocar_rest.this.AV38RestLocHab = GXv_boolean1[0] ;
      invocar_rest.this.AV36RestLocBaseUrl = GXv_char2[0] ;
      invocar_rest.this.AV37RestLocCancelOnError = GXv_int3[0] ;
      invocar_rest.this.AV39RestLocHost = GXv_char4[0] ;
      invocar_rest.this.AV41RestLocPort = GXv_int5[0] ;
      invocar_rest.this.AV43RestLocTimeout = GXv_int6[0] ;
      invocar_rest.this.AV42RestLocSecure = GXv_int7[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV54Pgmname, httpContext.getMessage( "&RestLocHab ", "")+GXutil.trim( GXutil.booltostr( AV38RestLocHab))) ;
      if ( AV38RestLocHab )
      {
         GXv_objcol_Sdthttp_headers_http_headersItem8[0] = AV17http_headers ;
         new web.headerjsonadd(remoteHandle, context).execute( GXv_objcol_Sdthttp_headers_http_headersItem8) ;
         AV17http_headers = GXv_objcol_Sdthttp_headers_http_headersItem8[0] ;
         AV50auxRestLocPort = AV41RestLocPort ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV54Pgmname, httpContext.getMessage( "ini &auxRestLocPort ", "")+GXutil.trim( GXutil.str( AV50auxRestLocPort, 8, 0))) ;
         GXv_char4[0] = AV35response_raw ;
         GXv_int5[0] = AV44statusCode ;
         new web.restexecute(remoteHandle, context).execute( AV39RestLocHost, AV50auxRestLocPort, AV42RestLocSecure, AV36RestLocBaseUrl, AV17http_headers, httpContext.getMessage( "POST", ""), AV10body, AV43RestLocTimeout, GXv_char4, GXv_int5) ;
         invocar_rest.this.AV35response_raw = GXv_char4[0] ;
         invocar_rest.this.AV44statusCode = GXv_int5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV54Pgmname, httpContext.getMessage( "fin", "")) ;
         if ( AV44statusCode != 200 )
         {
            AV15error = GXutil.trim( AV35response_raw) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = invocar_rest.this.AV38RestLocHab;
      this.aP4[0] = invocar_rest.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15error = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV36RestLocBaseUrl = "" ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new byte[1] ;
      AV39RestLocHost = "" ;
      GXv_int6 = new short[1] ;
      GXv_int7 = new byte[1] ;
      AV54Pgmname = "" ;
      AV17http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem8 = new GXBaseCollection[1] ;
      AV35response_raw = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new int[1] ;
      AV54Pgmname = "invocar_rest" ;
      /* GeneXus formulas. */
      AV54Pgmname = "invocar_rest" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37RestLocCancelOnError ;
   private byte GXv_int3[] ;
   private byte AV42RestLocSecure ;
   private byte GXv_int7[] ;
   private short AV43RestLocTimeout ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV41RestLocPort ;
   private int AV50auxRestLocPort ;
   private int AV44statusCode ;
   private int GXv_int5[] ;
   private String AV40RestLocId ;
   private String GXv_char2[] ;
   private String AV54Pgmname ;
   private String GXv_char4[] ;
   private boolean AV38RestLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV10body ;
   private String AV15error ;
   private String AV36RestLocBaseUrl ;
   private String AV39RestLocHost ;
   private String AV35response_raw ;
   private String[] aP4 ;
   private boolean[] aP3 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV17http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem8[] ;
}

