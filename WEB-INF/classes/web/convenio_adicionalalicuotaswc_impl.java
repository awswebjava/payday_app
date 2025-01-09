package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_adicionalalicuotaswc_impl extends GXWebComponent
{
   public convenio_adicionalalicuotaswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_adicionalalicuotaswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalalicuotaswc_impl.class ));
   }

   public convenio_adicionalalicuotaswc_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
            gxfirstwebparm_bkp = gxfirstwebparm ;
            gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
            toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               dyncall( httpContext.GetNextPar( )) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV26CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
               AV28CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28CliPaiConve), 4, 0));
               AV29CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CliConvenio", AV29CliConvenio);
               AV10ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10ConveAdicod", AV10ConveAdicod);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV26CliCod),Short.valueOf(AV28CliPaiConve),AV29CliConvenio,AV10ConveAdicod});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               gxnrgrid_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
            {
               gxgrgrid_refresh_invoke( ) ;
               return  ;
            }
            else
            {
               if ( ! httpContext.IsValidAjaxCall( false) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = gxfirstwebparm_bkp ;
            }
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
      nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
      sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV26CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV28CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      AV29CliConvenio = httpContext.GetPar( "CliConvenio") ;
      AV10ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
      AV32Pgmname = httpContext.GetPar( "Pgmname") ;
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paE72( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "convenio_adicionalalicuotas WC", "")) ;
         httpContext.writeTextNL( "</title>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( GXutil.len( sDynURL) > 0 )
         {
            httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
         }
         define_styles( ) ;
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_adicionalalicuotaswc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV26CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV28CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV29CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10ConveAdicod))}, new String[] {"CliCod","CliPaiConve","CliConvenio","ConveAdicod"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV22GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV23GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV24GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV26CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV26CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV28CliPaiConve", GXutil.ltrim( localUtil.ntoc( wcpOAV28CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV29CliConvenio", GXutil.rtrim( wcpOAV29CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10ConveAdicod", GXutil.rtrim( wcpOAV10ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV32Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV26CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV28CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICONVENIO", GXutil.rtrim( AV29CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONVEADICOD", GXutil.rtrim( AV10ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
   }

   public void renderHtmlCloseFormE72( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         httpContext.writeTextNL( "</form>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "convenio_adicionalalicuotasWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "convenio_adicionalalicuotas WC", "") ;
   }

   public void wbE70( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.convenio_adicionalalicuotaswc");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablegridheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol15( ) ;
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV22GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV23GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV24GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_convenio_adicionalalicuotasWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_convenio_adicionalalicuotasWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicionalalicuotasWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdicod_Internalname, GXutil.rtrim( A996ConveAdicod), GXutil.rtrim( localUtil.format( A996ConveAdicod, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdicod_Jsonclick, 0, "Attribute", "", "", "", "", edtConveAdicod_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicionalalicuotasWC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startE72( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "convenio_adicionalalicuotas WC", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strupE70( ) ;
         }
      }
   }

   public void wsE72( )
   {
      startE72( ) ;
      evtE72( ) ;
   }

   public void evtE72( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11E72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12E72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13E72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupE70( ) ;
                           }
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           A1011ConveAdiOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1021ConveAdiOpcFor = httpContext.cgiGet( edtConveAdiOpcFor_Internalname) ;
                           A1012ConveAdiOpcDes = httpContext.cgiGet( edtConveAdiOpcDes_Internalname) ;
                           A1013ConveAdiOpcAli = localUtil.ctond( httpContext.cgiGet( edtConveAdiOpcAli_Internalname)) ;
                           A1900ConveAdiOpcRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e14E72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Refresh */
                                       e15E72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e16E72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strupE70( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weE72( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormE72( ) ;
         }
      }
   }

   public void paE72( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGrid_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV26CliCod ,
                                 short AV28CliPaiConve ,
                                 String AV29CliConvenio ,
                                 String AV10ConveAdicod ,
                                 String AV32Pgmname ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15E72 ();
      GRID_nCurrentRecord = 0 ;
      rfE72( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfE72( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV32Pgmname = "convenio_adicionalalicuotasWC" ;
      Gx_err = (short)(0) ;
   }

   public void rfE72( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e15E72 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(AV26CliCod) ,
                                              Short.valueOf(AV28CliPaiConve) ,
                                              AV29CliConvenio ,
                                              AV10ConveAdicod ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              A1565CliConvenio ,
                                              A996ConveAdicod } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         /* Using cursor H00E72 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV28CliPaiConve), AV29CliConvenio, AV10ConveAdicod, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_15_idx = 1 ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H00E72_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = H00E72_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = H00E72_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = H00E72_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A996ConveAdicod", A996ConveAdicod);
            A1900ConveAdiOpcRelSec = H00E72_A1900ConveAdiOpcRelSec[0] ;
            A1013ConveAdiOpcAli = H00E72_A1013ConveAdiOpcAli[0] ;
            A1012ConveAdiOpcDes = H00E72_A1012ConveAdiOpcDes[0] ;
            A1021ConveAdiOpcFor = H00E72_A1021ConveAdiOpcFor[0] ;
            A1011ConveAdiOpcCod = H00E72_A1011ConveAdiOpcCod[0] ;
            e16E72 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(15) ;
         wbE70( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesE72( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV32Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(AV26CliCod) ,
                                           Short.valueOf(AV28CliPaiConve) ,
                                           AV29CliConvenio ,
                                           AV10ConveAdicod ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio ,
                                           A996ConveAdicod } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      /* Using cursor H00E73 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV28CliPaiConve), AV29CliConvenio, AV10ConveAdicod});
      GRID_nRecordCount = H00E73_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26CliCod, AV28CliPaiConve, AV29CliConvenio, AV10ConveAdicod, AV32Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV32Pgmname = "convenio_adicionalalicuotasWC" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupE70( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14E72 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV22GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV23GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV24GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV26CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV26CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV28CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV28CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV29CliConvenio = httpContext.cgiGet( sPrefix+"wcpOAV29CliConvenio") ;
         wcpOAV10ConveAdicod = httpContext.cgiGet( sPrefix+"wcpOAV10ConveAdicod") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Class = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( sPrefix+"DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = httpContext.cgiGet( edtConveAdicod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A996ConveAdicod", A996ConveAdicod);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e14E72 ();
      if (returnInSub) return;
   }

   public void e14E72( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV26CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicionalalicuotaswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV26CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      edtConveAdicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveAdicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV16OrderedBy < 1 )
      {
         AV16OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e15E72( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV26CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicionalalicuotaswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV26CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV22GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GridCurrentPage), 10, 0));
      AV23GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridPageCount), 10, 0));
      GXt_char6 = AV24GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV32Pgmname, GXv_char7) ;
      convenio_adicionalalicuotaswc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV24GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24GridAppliedFilters", AV24GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e11E72( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV21PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV21PageToGo) ;
      }
   }

   public void e12E72( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13E72( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV16OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
         AV17OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e16E72( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(15) ;
      }
      sendrow_152( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
      {
         httpContext.doAjaxLoad(15, GridRow);
      }
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV16OrderedBy, 4, 0))+":"+(AV17OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18Session.getValue(AV32Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV32Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV18Session.getValue(AV32Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV14GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV14GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV14GridState.fromxml(AV18Session.getValue(AV32Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV32Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV32Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "convenio_adicional" );
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV26CliCod, 6, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliPaiConve" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV28CliPaiConve, 4, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliConvenio" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV29CliConvenio );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "ConveAdicod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV10ConveAdicod );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV18Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV26CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
      AV28CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28CliPaiConve), 4, 0));
      AV29CliConvenio = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CliConvenio", AV29CliConvenio);
      AV10ConveAdicod = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10ConveAdicod", AV10ConveAdicod);
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      paE72( ) ;
      wsE72( ) ;
      weE72( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV26CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV28CliPaiConve = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV29CliConvenio = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10ConveAdicod = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paE72( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "convenio_adicionalalicuotaswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paE72( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV26CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
         AV28CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28CliPaiConve), 4, 0));
         AV29CliConvenio = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CliConvenio", AV29CliConvenio);
         AV10ConveAdicod = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10ConveAdicod", AV10ConveAdicod);
      }
      wcpOAV26CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV26CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV28CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV28CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV29CliConvenio = httpContext.cgiGet( sPrefix+"wcpOAV29CliConvenio") ;
      wcpOAV10ConveAdicod = httpContext.cgiGet( sPrefix+"wcpOAV10ConveAdicod") ;
      if ( ! GetJustCreated( ) && ( ( AV26CliCod != wcpOAV26CliCod ) || ( AV28CliPaiConve != wcpOAV28CliPaiConve ) || ( GXutil.strcmp(AV29CliConvenio, wcpOAV29CliConvenio) != 0 ) || ( GXutil.strcmp(AV10ConveAdicod, wcpOAV10ConveAdicod) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV26CliCod = AV26CliCod ;
      wcpOAV28CliPaiConve = AV28CliPaiConve ;
      wcpOAV29CliConvenio = AV29CliConvenio ;
      wcpOAV10ConveAdicod = AV10ConveAdicod ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV26CliCod = httpContext.cgiGet( sPrefix+"AV26CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV26CliCod) > 0 )
      {
         AV26CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV26CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26CliCod), 6, 0));
      }
      else
      {
         AV26CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV26CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV28CliPaiConve = httpContext.cgiGet( sPrefix+"AV28CliPaiConve_CTRL") ;
      if ( GXutil.len( sCtrlAV28CliPaiConve) > 0 )
      {
         AV28CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV28CliPaiConve), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28CliPaiConve), 4, 0));
      }
      else
      {
         AV28CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV28CliPaiConve_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV29CliConvenio = httpContext.cgiGet( sPrefix+"AV29CliConvenio_CTRL") ;
      if ( GXutil.len( sCtrlAV29CliConvenio) > 0 )
      {
         AV29CliConvenio = httpContext.cgiGet( sCtrlAV29CliConvenio) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CliConvenio", AV29CliConvenio);
      }
      else
      {
         AV29CliConvenio = httpContext.cgiGet( sPrefix+"AV29CliConvenio_PARM") ;
      }
      sCtrlAV10ConveAdicod = httpContext.cgiGet( sPrefix+"AV10ConveAdicod_CTRL") ;
      if ( GXutil.len( sCtrlAV10ConveAdicod) > 0 )
      {
         AV10ConveAdicod = httpContext.cgiGet( sCtrlAV10ConveAdicod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10ConveAdicod", AV10ConveAdicod);
      }
      else
      {
         AV10ConveAdicod = httpContext.cgiGet( sPrefix+"AV10ConveAdicod_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      paE72( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsE72( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wsE72( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV26CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV26CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV26CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV26CliCod_CTRL", GXutil.rtrim( sCtrlAV26CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV28CliPaiConve_PARM", GXutil.ltrim( localUtil.ntoc( AV28CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV28CliPaiConve)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV28CliPaiConve_CTRL", GXutil.rtrim( sCtrlAV28CliPaiConve));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV29CliConvenio_PARM", GXutil.rtrim( AV29CliConvenio));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV29CliConvenio)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV29CliConvenio_CTRL", GXutil.rtrim( sCtrlAV29CliConvenio));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10ConveAdicod_PARM", GXutil.rtrim( AV10ConveAdicod));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10ConveAdicod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10ConveAdicod_CTRL", GXutil.rtrim( sCtrlAV10ConveAdicod));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      weE72( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171333417", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("convenio_adicionalalicuotaswc.js", "?2025171333418", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      edtConveAdiOpcCod_Internalname = sPrefix+"CONVEADIOPCCOD_"+sGXsfl_15_idx ;
      edtConveAdiOpcFor_Internalname = sPrefix+"CONVEADIOPCFOR_"+sGXsfl_15_idx ;
      edtConveAdiOpcDes_Internalname = sPrefix+"CONVEADIOPCDES_"+sGXsfl_15_idx ;
      edtConveAdiOpcAli_Internalname = sPrefix+"CONVEADIOPCALI_"+sGXsfl_15_idx ;
      edtConveAdiOpcRelSec_Internalname = sPrefix+"CONVEADIOPCRELSEC_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtConveAdiOpcCod_Internalname = sPrefix+"CONVEADIOPCCOD_"+sGXsfl_15_fel_idx ;
      edtConveAdiOpcFor_Internalname = sPrefix+"CONVEADIOPCFOR_"+sGXsfl_15_fel_idx ;
      edtConveAdiOpcDes_Internalname = sPrefix+"CONVEADIOPCDES_"+sGXsfl_15_fel_idx ;
      edtConveAdiOpcAli_Internalname = sPrefix+"CONVEADIOPCALI_"+sGXsfl_15_fel_idx ;
      edtConveAdiOpcRelSec_Internalname = sPrefix+"CONVEADIOPCRELSEC_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wbE70( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_15_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_15_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1011ConveAdiOpcCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcFor_Internalname,GXutil.rtrim( A1021ConveAdiOpcFor),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcDes_Internalname,A1012ConveAdiOpcDes,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcAli_Internalname,GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1013ConveAdiOpcAli, "9.9999")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcAli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1900ConveAdiOpcRelSec), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesE72( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_15_idx = ((subGrid_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      /* End function sendrow_152 */
   }

   public void startgridcontrol15( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"15\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción Nro.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Alícuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", sPrefix);
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1021ConveAdiOpcFor));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1012ConveAdiOpcDes);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtConveAdiOpcCod_Internalname = sPrefix+"CONVEADIOPCCOD" ;
      edtConveAdiOpcFor_Internalname = sPrefix+"CONVEADIOPCFOR" ;
      edtConveAdiOpcDes_Internalname = sPrefix+"CONVEADIOPCDES" ;
      edtConveAdiOpcAli_Internalname = sPrefix+"CONVEADIOPCALI" ;
      edtConveAdiOpcRelSec_Internalname = sPrefix+"CONVEADIOPCRELSEC" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtCliPaiConve_Internalname = sPrefix+"CLIPAICONVE" ;
      edtCliConvenio_Internalname = sPrefix+"CLICONVENIO" ;
      edtConveAdicod_Internalname = sPrefix+"CONVEADICOD" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtConveAdiOpcRelSec_Jsonclick = "" ;
      edtConveAdiOpcAli_Jsonclick = "" ;
      edtConveAdiOpcDes_Jsonclick = "" ;
      edtConveAdiOpcFor_Jsonclick = "" ;
      edtConveAdiOpcCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      edtConveAdicod_Jsonclick = "" ;
      edtConveAdicod_Visible = 1 ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5" ;
      Ddo_grid_Columnids = "0:ConveAdiOpcCod|1:ConveAdiOpcFor|2:ConveAdiOpcDes|3:ConveAdiOpcAli|4:ConveAdiOpcRelSec" ;
      Ddo_grid_Gridinternalname = "" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV28CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9'},{av:'AV29CliConvenio',fld:'vCLICONVENIO',pic:''},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:''},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV26CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV22GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV23GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV24GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11E72',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV28CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9'},{av:'AV29CliConvenio',fld:'vCLICONVENIO',pic:''},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:''},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12E72',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV28CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9'},{av:'AV29CliConvenio',fld:'vCLICONVENIO',pic:''},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:''},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13E72',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV28CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9'},{av:'AV29CliConvenio',fld:'vCLICONVENIO',pic:''},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:''},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e16E72',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveadiopcrelsec',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV29CliConvenio = "" ;
      wcpOAV10ConveAdicod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV29CliConvenio = "" ;
      AV10ConveAdicod = "" ;
      AV32Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV24GridAppliedFilters = "" ;
      AV19DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      H00E72_A3CliCod = new int[1] ;
      H00E72_A1564CliPaiConve = new short[1] ;
      H00E72_A1565CliConvenio = new String[] {""} ;
      H00E72_A996ConveAdicod = new String[] {""} ;
      H00E72_A1900ConveAdiOpcRelSec = new int[1] ;
      H00E72_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00E72_A1012ConveAdiOpcDes = new String[] {""} ;
      H00E72_A1021ConveAdiOpcFor = new String[] {""} ;
      H00E72_A1011ConveAdiOpcCod = new short[1] ;
      H00E73_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV18Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV26CliCod = "" ;
      sCtrlAV28CliPaiConve = "" ;
      sCtrlAV29CliConvenio = "" ;
      sCtrlAV10ConveAdicod = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalalicuotaswc__default(),
         new Object[] {
             new Object[] {
            H00E72_A3CliCod, H00E72_A1564CliPaiConve, H00E72_A1565CliConvenio, H00E72_A996ConveAdicod, H00E72_A1900ConveAdiOpcRelSec, H00E72_A1013ConveAdiOpcAli, H00E72_A1012ConveAdiOpcDes, H00E72_A1021ConveAdiOpcFor, H00E72_A1011ConveAdiOpcCod
            }
            , new Object[] {
            H00E73_AGRID_nRecordCount
            }
         }
      );
      AV32Pgmname = "convenio_adicionalalicuotasWC" ;
      /* GeneXus formulas. */
      AV32Pgmname = "convenio_adicionalalicuotasWC" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wcpOAV28CliPaiConve ;
   private short AV28CliPaiConve ;
   private short AV16OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV26CliCod ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_15 ;
   private int AV26CliCod ;
   private int nGXsfl_15_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int edtCliConvenio_Visible ;
   private int edtConveAdicod_Visible ;
   private int A1900ConveAdiOpcRelSec ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV21PageToGo ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV22GridCurrentPage ;
   private long AV23GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private String wcpOAV29CliConvenio ;
   private String wcpOAV10ConveAdicod ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV29CliConvenio ;
   private String AV10ConveAdicod ;
   private String sGXsfl_15_idx="0001" ;
   private String AV32Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String A1565CliConvenio ;
   private String edtCliConvenio_Jsonclick ;
   private String edtConveAdicod_Internalname ;
   private String A996ConveAdicod ;
   private String edtConveAdicod_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtConveAdiOpcCod_Internalname ;
   private String A1021ConveAdiOpcFor ;
   private String edtConveAdiOpcFor_Internalname ;
   private String edtConveAdiOpcDes_Internalname ;
   private String edtConveAdiOpcAli_Internalname ;
   private String edtConveAdiOpcRelSec_Internalname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sCtrlAV26CliCod ;
   private String sCtrlAV28CliPaiConve ;
   private String sCtrlAV29CliConvenio ;
   private String sCtrlAV10ConveAdicod ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtConveAdiOpcCod_Jsonclick ;
   private String edtConveAdiOpcFor_Jsonclick ;
   private String edtConveAdiOpcDes_Jsonclick ;
   private String edtConveAdiOpcAli_Jsonclick ;
   private String edtConveAdiOpcRelSec_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV24GridAppliedFilters ;
   private String A1012ConveAdiOpcDes ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private IDataStoreProvider pr_default ;
   private int[] H00E72_A3CliCod ;
   private short[] H00E72_A1564CliPaiConve ;
   private String[] H00E72_A1565CliConvenio ;
   private String[] H00E72_A996ConveAdicod ;
   private int[] H00E72_A1900ConveAdiOpcRelSec ;
   private java.math.BigDecimal[] H00E72_A1013ConveAdiOpcAli ;
   private String[] H00E72_A1012ConveAdiOpcDes ;
   private String[] H00E72_A1021ConveAdiOpcFor ;
   private short[] H00E72_A1011ConveAdiOpcCod ;
   private long[] H00E73_AGRID_nRecordCount ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class convenio_adicionalalicuotaswc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00E72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV26CliCod ,
                                          short AV28CliPaiConve ,
                                          String AV29CliConvenio ,
                                          String AV10ConveAdicod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String A996ConveAdicod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcRelSec, ConveAdiOpcAli, ConveAdiOpcDes, ConveAdiOpcFor, ConveAdiOpcCod" ;
      sFromString = " FROM convenio_adicionalalicuotas" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?))");
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiOpcCod DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcFor, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiOpcFor DESC, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcDes, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiOpcDes DESC, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcAli, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiOpcAli DESC, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcRelSec, ConveAdiOpcCod" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiOpcRelSec DESC, ConveAdiOpcCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_H00E73( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV26CliCod ,
                                          short AV28CliPaiConve ,
                                          String AV29CliConvenio ,
                                          String AV10ConveAdicod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String A996ConveAdicod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[4];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?))");
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H00E72(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] );
            case 1 :
                  return conditional_H00E73(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00E72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00E73", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

