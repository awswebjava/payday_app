package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class scrape extends GXProcedure
{
   public scrape( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( scrape.class ), "" );
   }

   public scrape( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      scrape.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      scrape.this.AV9CliCod = aP0;
      scrape.this.AV23VarBaseURL = aP1;
      scrape.this.AV27VarScrapTipo = aP2;
      scrape.this.AV26VarScrapTDoc = aP3;
      scrape.this.AV24VarBusGoogle = aP4;
      scrape.this.AV25VarBusWeb = aP5;
      scrape.this.AV29VarScrapFin = aP6;
      scrape.this.AV28Dato = aP7;
      scrape.this.aP8 = aP8;
      scrape.this.aP9 = aP9;
      scrape.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV30a3lutilitieshost ;
      GXv_int2[0] = AV17puerto ;
      GXv_char3[0] = AV31urlBase ;
      GXv_char4[0] = "" ;
      GXv_objcol_Sdthttp_headers_http_headersItem5[0] = AV8http_headers ;
      GXv_int6[0] = AV32timeOut ;
      new web.getnodedatos(remoteHandle, context).execute( AV9CliCod, (short)(0), 0, httpContext.getMessage( "scrape", ""), "", false, true, "", GXv_char1, GXv_int2, GXv_char3, GXv_char4, GXv_objcol_Sdthttp_headers_http_headersItem5, GXv_int6) ;
      scrape.this.AV30a3lutilitieshost = GXv_char1[0] ;
      scrape.this.AV17puerto = (short)((short)(GXv_int2[0])) ;
      scrape.this.AV31urlBase = GXv_char3[0] ;
      AV8http_headers = GXv_objcol_Sdthttp_headers_http_headersItem5[0] ;
      scrape.this.AV32timeOut = GXv_int6[0] ;
      AV20scrapeVarReqItem = (web.SdtscrapeVarReq_scrapeVarReqItem)new web.SdtscrapeVarReq_scrapeVarReqItem(remoteHandle, context);
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl( GXutil.trim( AV23VarBaseURL) );
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle( GXutil.trim( AV24VarBusGoogle) );
      AV20scrapeVarReqItem.getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables().add(GXutil.trim( AV25VarBusWeb), 0);
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento( GXutil.trim( AV26VarScrapTDoc) );
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping( GXutil.trim( AV27VarScrapTipo) );
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato( AV28Dato );
      AV20scrapeVarReqItem.setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin( AV29VarScrapFin );
      AV19scrapeVarReq.add(AV20scrapeVarReqItem, 0);
      GXv_char4[0] = AV18response_raw ;
      GXv_int2[0] = 0 ;
      new web.restexecute(remoteHandle, context).execute( AV30a3lutilitieshost, AV17puerto, (short)(0), AV31urlBase, AV8http_headers, httpContext.getMessage( "POST", ""), AV19scrapeVarReq.toJSonString(false), AV32timeOut, GXv_char4, GXv_int2) ;
      scrape.this.AV18response_raw = GXv_char4[0] ;
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
               new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&response_raw ", "")+GXutil.trim( AV18response_raw)) ;
            }
            else
            {
               AV10error = httpContext.getMessage( "El Webservice de scraping no está corriendo", "") ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV10error)) ;
      }
      else
      {
         AV21scrapeVarRes.fromJSonString(AV18response_raw, null);
         if ( AV21scrapeVarRes.size() == 0 )
         {
            AV10error = httpContext.getMessage( "No se pudo recuperar el dato", "") ;
         }
         else
         {
            if ( ((web.SdtscrapeVarRes_scrapeVarResItem)AV21scrapeVarRes.elementAt(-1+1)).getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables().size() == 0 )
            {
               AV10error = httpContext.getMessage( "Error al recuperar el dato", "") ;
            }
            else
            {
               AV15OpeCliValor = GXutil.trim( ((web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem)((web.SdtscrapeVarRes_scrapeVarResItem)AV21scrapeVarRes.elementAt(-1+1)).getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables().elementAt(-1+1)).getgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor()) ;
               AV22URL = ((web.SdtscrapeVarRes_scrapeVarResItem)AV21scrapeVarRes.elementAt(-1+1)).getgxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada() ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = scrape.this.AV15OpeCliValor;
      this.aP9[0] = scrape.this.AV22URL;
      this.aP10[0] = scrape.this.AV10error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15OpeCliValor = "" ;
      AV22URL = "" ;
      AV10error = "" ;
      AV30a3lutilitieshost = "" ;
      GXv_char1 = new String[1] ;
      AV31urlBase = "" ;
      GXv_char3 = new String[1] ;
      AV8http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem5 = new GXBaseCollection[1] ;
      GXv_int6 = new short[1] ;
      AV20scrapeVarReqItem = new web.SdtscrapeVarReq_scrapeVarReqItem(remoteHandle, context);
      AV19scrapeVarReq = new GXBaseCollection<web.SdtscrapeVarReq_scrapeVarReqItem>(web.SdtscrapeVarReq_scrapeVarReqItem.class, "scrapeVarReqItem", "PayDay", remoteHandle);
      AV18response_raw = "" ;
      GXv_char4 = new String[1] ;
      GXv_int2 = new int[1] ;
      AV35Pgmname = "" ;
      AV21scrapeVarRes = new GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem>(web.SdtscrapeVarRes_scrapeVarResItem.class, "scrapeVarResItem", "PayDay", remoteHandle);
      AV35Pgmname = "scrape" ;
      /* GeneXus formulas. */
      AV35Pgmname = "scrape" ;
      Gx_err = (short)(0) ;
   }

   private short AV17puerto ;
   private short AV32timeOut ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int GXv_int2[] ;
   private String AV27VarScrapTipo ;
   private String AV26VarScrapTDoc ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV35Pgmname ;
   private String AV23VarBaseURL ;
   private String AV24VarBusGoogle ;
   private String AV25VarBusWeb ;
   private String AV29VarScrapFin ;
   private String AV28Dato ;
   private String AV15OpeCliValor ;
   private String AV22URL ;
   private String AV10error ;
   private String AV30a3lutilitieshost ;
   private String AV31urlBase ;
   private String AV18response_raw ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV8http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem5[] ;
   private GXBaseCollection<web.SdtscrapeVarReq_scrapeVarReqItem> AV19scrapeVarReq ;
   private GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem> AV21scrapeVarRes ;
   private web.SdtscrapeVarReq_scrapeVarReqItem AV20scrapeVarReqItem ;
}

