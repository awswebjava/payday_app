package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class scrapecuil extends GXProcedure
{
   public scrapecuil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( scrapecuil.class ), "" );
   }

   public scrapecuil( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      scrapecuil.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      scrapecuil.this.AV9CliCod = aP0;
      scrapecuil.this.AV30MigrLegCUIL = aP1;
      scrapecuil.this.aP2 = aP2;
      scrapecuil.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV33a3lutilitieshost ;
      GXv_int2[0] = AV17puerto ;
      GXv_char3[0] = AV34urlBase ;
      GXv_char4[0] = "" ;
      GXv_objcol_Sdthttp_headers_http_headersItem5[0] = AV8http_headers ;
      GXv_int6[0] = AV35timeOut ;
      new web.getnodedatos(remoteHandle, context).execute( AV9CliCod, (short)(0), 0, httpContext.getMessage( "CUIL", ""), "", false, true, "", GXv_char1, GXv_int2, GXv_char3, GXv_char4, GXv_objcol_Sdthttp_headers_http_headersItem5, GXv_int6) ;
      scrapecuil.this.AV33a3lutilitieshost = GXv_char1[0] ;
      scrapecuil.this.AV17puerto = (short)((short)(GXv_int2[0])) ;
      scrapecuil.this.AV34urlBase = GXv_char3[0] ;
      AV8http_headers = GXv_objcol_Sdthttp_headers_http_headersItem5[0] ;
      scrapecuil.this.AV35timeOut = GXv_int6[0] ;
      GXv_char4[0] = AV18response_raw ;
      GXv_int2[0] = 0 ;
      new web.restexecute(remoteHandle, context).execute( AV33a3lutilitieshost, AV17puerto, (short)(0), AV34urlBase, AV8http_headers, httpContext.getMessage( "POST", ""), httpContext.getMessage( "{\"cuil\":\"", "")+GXutil.trim( AV30MigrLegCUIL)+"\"}", AV35timeOut, GXv_char4, GXv_int2) ;
      scrapecuil.this.AV18response_raw = GXv_char4[0] ;
      if ( GXutil.strSearch( AV18response_raw, httpContext.getMessage( "\"message\":\"OK\"", ""), 1) == 0 )
      {
         if ( (GXutil.strcmp("", AV18response_raw)==0) )
         {
            AV10error = httpContext.getMessage( "El Webservice de scraping no responde", "") ;
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV18response_raw)==0) )
            {
               AV10error = httpContext.getMessage( "Error al invocar WS de scraping", "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&response_raw ", "")+GXutil.trim( AV18response_raw)) ;
            }
            else
            {
               AV10error = httpContext.getMessage( "El Webservice de scraping no está corriendo", "") ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV10error)) ;
      }
      else
      {
         AV31scrapeCUILResponse.fromJSonString(AV18response_raw, null);
         if ( (GXutil.strcmp("", AV31scrapeCUILResponse.getgxTv_SdtscrapeCUILResponse_Nombre())==0) )
         {
            AV10error = httpContext.getMessage( "Error al recuperar el dato", "") ;
         }
         else
         {
            AV32nombreYApellido = GXutil.trim( AV31scrapeCUILResponse.getgxTv_SdtscrapeCUILResponse_Nombre()) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = scrapecuil.this.AV32nombreYApellido;
      this.aP3[0] = scrapecuil.this.AV10error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32nombreYApellido = "" ;
      AV10error = "" ;
      AV33a3lutilitieshost = "" ;
      GXv_char1 = new String[1] ;
      AV34urlBase = "" ;
      GXv_char3 = new String[1] ;
      AV8http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem5 = new GXBaseCollection[1] ;
      GXv_int6 = new short[1] ;
      AV18response_raw = "" ;
      GXv_char4 = new String[1] ;
      GXv_int2 = new int[1] ;
      AV38Pgmname = "" ;
      AV31scrapeCUILResponse = new web.SdtscrapeCUILResponse(remoteHandle, context);
      AV38Pgmname = "scrapeCUIL" ;
      /* GeneXus formulas. */
      AV38Pgmname = "scrapeCUIL" ;
      Gx_err = (short)(0) ;
   }

   private short AV17puerto ;
   private short AV35timeOut ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int GXv_int2[] ;
   private String AV30MigrLegCUIL ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV38Pgmname ;
   private String AV32nombreYApellido ;
   private String AV10error ;
   private String AV33a3lutilitieshost ;
   private String AV34urlBase ;
   private String AV18response_raw ;
   private String[] aP3 ;
   private String[] aP2 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV8http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem5[] ;
   private web.SdtscrapeCUILResponse AV31scrapeCUILResponse ;
}

