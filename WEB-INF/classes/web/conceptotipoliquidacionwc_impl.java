package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacionwc_impl extends GXWebComponent
{
   public conceptotipoliquidacionwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptotipoliquidacionwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacionwc_impl.class ));
   }

   public conceptotipoliquidacionwc_impl( int remoteHandle ,
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
      cmbavGridactions = new HTMLChoice();
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
               AV23CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
               AV7ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7ConCodigo", AV7ConCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV23CliCod),AV7ConCodigo});
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
      nRC_GXsfl_26 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_26"))) ;
      nGXsfl_26_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_26_idx"))) ;
      sGXsfl_26_idx = httpContext.GetPar( "sGXsfl_26_idx") ;
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
      AV23CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7ConCodigo = httpContext.GetPar( "ConCodigo") ;
      AV29EditableGrid_Mode = httpContext.GetPar( "EditableGrid_Mode") ;
      AV39Pgmname = httpContext.GetPar( "Pgmname") ;
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV27IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV34TLiqCod_SelectedLine = httpContext.GetPar( "TLiqCod_SelectedLine") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa4V2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Concepto Tipo Liquidacion WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptotipoliquidacionwc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV23CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7ConCodigo))}, new String[] {"CliCod","ConCodigo"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptoTipoLiquidacionWC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptotipoliquidacionwc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_26", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_26, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV19GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV20GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV21GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV23CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV23CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7ConCodigo", GXutil.rtrim( wcpOAV7ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEDITABLEGRID_MODE", AV29EditableGrid_Mode);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV39Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV27IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTLIQCOD_SELECTEDLINE", GXutil.rtrim( AV34TLiqCod_SelectedLine));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMESSAGES", AV31Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMESSAGES", AV31Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV23CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONCODIGO", GXutil.rtrim( AV7ConCodigo));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Fixedcolumns", GXutil.rtrim( Grid_empowerer_Fixedcolumns));
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

   public void renderHtmlCloseForm4V2( )
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
      return "ConceptoTipoLiquidacionWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto Tipo Liquidacion WC", "") ;
   }

   public void wb4V0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptotipoliquidacionwc");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 26, 2, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoTipoLiquidacionWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol26( ) ;
      }
      if ( wbEnd == 26 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_26 = (int)(nGXsfl_26_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV19GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV20GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV21GridAppliedFilters);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoTipoLiquidacionWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtConCodigo_Visible, 0, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_ConceptoTipoLiquidacionWC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("FixedColumns", Grid_empowerer_Fixedcolumns);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 26 )
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

   public void start4V2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Concepto Tipo Liquidacion WC", ""), (short)(0)) ;
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
            strup4V0( ) ;
         }
      }
   }

   public void ws4V2( )
   {
      start4V2( ) ;
      evt4V2( ) ;
   }

   public void evt4V2( )
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
                              strup4V0( ) ;
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
                              strup4V0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e114V2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4V0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e124V2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4V0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e134V2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4V0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoInsert' */
                                 e144V2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4V0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "'EDITABLEGRIDCONFIRM'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "'EDITABLEGRIDCANCEL'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VGRIDACTIONS.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "'EDITABLEGRIDCANCEL'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VGRIDACTIONS.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "'EDITABLEGRIDCONFIRM'") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4V0( ) ;
                           }
                           nGXsfl_26_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_262( ) ;
                           AV35EditableGridCancel = httpContext.cgiGet( edtavEditablegridcancel_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEditablegridcancel_Internalname, AV35EditableGridCancel);
                           cmbavGridactions.setName( cmbavGridactions.getInternalname() );
                           cmbavGridactions.setValue( httpContext.cgiGet( cmbavGridactions.getInternalname()) );
                           AV22GridActions = (short)(GXutil.lval( httpContext.cgiGet( cmbavGridactions.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GridActions), 4, 0));
                           A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                           A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
                           AV36EditableGridConfirm = httpContext.cgiGet( edtavEditablegridconfirm_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEditablegridconfirm_Internalname, AV36EditableGridConfirm);
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
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e154V2 ();
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
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e164V2 ();
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
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e174V2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "'EDITABLEGRIDCONFIRM'") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: 'EditableGridConfirm' */
                                       e184V2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "'EDITABLEGRIDCANCEL'") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: 'EditableGridCancel' */
                                       e194V2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VGRIDACTIONS.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e204V2 ();
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
                                    strup4V0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEditablegridcancel_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void we4V2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4V2( ) ;
         }
      }
   }

   public void pa4V2( )
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
      subsflControlProps_262( ) ;
      while ( nGXsfl_26_idx <= nRC_GXsfl_26 )
      {
         sendrow_262( ) ;
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV23CliCod ,
                                 String AV7ConCodigo ,
                                 String AV29EditableGrid_Mode ,
                                 String AV39Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV27IsAuthorized_Delete ,
                                 String AV34TLiqCod_SelectedLine ,
                                 int A3CliCod ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e164V2 ();
      GRID_nCurrentRecord = 0 ;
      rf4V2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptoTipoLiquidacionWC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptotipoliquidacionwc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_TLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( A32TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TLIQCOD", GXutil.rtrim( A32TLiqCod));
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
      rf4V2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV39Pgmname = "ConceptoTipoLiquidacionWC" ;
      Gx_err = (short)(0) ;
      edtavEditablegridcancel_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridcancel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridcancel_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditablegridconfirm_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridconfirm_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridconfirm_Enabled), 5, 0), !bGXsfl_26_Refreshing);
   }

   public void rf4V2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(26) ;
      /* Execute user event: Refresh */
      e164V2 ();
      nGXsfl_26_idx = 1 ;
      sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_262( ) ;
      bGXsfl_26_Refreshing = true ;
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
         subsflControlProps_262( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV23CliCod) ,
                                              AV7ConCodigo ,
                                              Integer.valueOf(A3CliCod) ,
                                              A26ConCodigo } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                              }
         });
         /* Using cursor H004V2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV23CliCod), AV7ConCodigo, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_26_idx = 1 ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H004V2_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = H004V2_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            A340TliqDesc = H004V2_A340TliqDesc[0] ;
            A32TLiqCod = H004V2_A32TLiqCod[0] ;
            A340TliqDesc = H004V2_A340TliqDesc[0] ;
            e174V2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(26) ;
         wb4V0( ) ;
      }
      bGXsfl_26_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes4V2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV39Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV27IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_TLIQCOD"+"_"+sGXsfl_26_idx, getSecureSignedToken( sPrefix+sGXsfl_26_idx, GXutil.rtrim( localUtil.format( A32TLiqCod, ""))));
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
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV23CliCod) ,
                                           AV7ConCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           A26ConCodigo } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor H004V3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV23CliCod), AV7ConCodigo});
      GRID_nRecordCount = H004V3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV23CliCod, AV7ConCodigo, AV29EditableGrid_Mode, AV39Pgmname, AV13OrderedBy, AV14OrderedDsc, AV27IsAuthorized_Delete, AV34TLiqCod_SelectedLine, A3CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV39Pgmname = "ConceptoTipoLiquidacionWC" ;
      Gx_err = (short)(0) ;
      edtavEditablegridcancel_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridcancel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridcancel_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditablegridconfirm_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridconfirm_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridconfirm_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup4V0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e154V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_26 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_26"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV19GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV20GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV21GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV23CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV23CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV7ConCodigo = httpContext.cgiGet( sPrefix+"wcpOAV7ConCodigo") ;
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
         Grid_empowerer_Fixedcolumns = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Fixedcolumns") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptoTipoLiquidacionWC");
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("conceptotipoliquidacionwc:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
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
      e154V2 ();
      if (returnInSub) return;
   }

   public void e154V2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV23CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionwc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV23CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e164V2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV23CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionwc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV23CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( (GXutil.strcmp("", AV29EditableGrid_Mode)==0) )
      {
         AV29EditableGrid_Mode = "TrnMode.Display" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29EditableGrid_Mode", AV29EditableGrid_Mode);
      }
      if ( GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Display") != 0 )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
      AV19GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GridCurrentPage), 10, 0));
      AV20GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GridPageCount), 10, 0));
      GXt_char6 = AV21GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV39Pgmname, GXv_char7) ;
      conceptotipoliquidacionwc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV21GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21GridAppliedFilters", AV21GridAppliedFilters);
      cmbavGridactions.setVisible( (((GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Display")==0)) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactions.getInternalname(), "Visible", GXutil.ltrimstr( cmbavGridactions.getVisible(), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditablegridcancel_Visible = (((GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Display")!=0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridcancel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridcancel_Visible), 5, 0), !bGXsfl_26_Refreshing);
      edtavEditablegridconfirm_Visible = (((GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Display")!=0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEditablegridconfirm_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditablegridconfirm_Visible), 5, 0), !bGXsfl_26_Refreshing);
      /*  Sending Event outputs  */
   }

   public void e114V2( )
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
         AV18PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV18PageToGo) ;
      }
   }

   public void e124V2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e134V2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e174V2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV35EditableGridCancel = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEditablegridcancel_Internalname, AV35EditableGridCancel);
      cmbavGridactions.removeAllItems();
      cmbavGridactions.addItem("0", ";fa fa-bars", (short)(0));
      if ( AV27IsAuthorized_Delete )
      {
         cmbavGridactions.addItem("1", GXutil.format( "%1;%2", httpContext.getMessage( "GX_BtnDelete", ""), "fa fa-times", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( cmbavGridactions.getItemCount() == 1 )
      {
         cmbavGridactions.setThemeClass( "Invisible" );
      }
      else
      {
         cmbavGridactions.setThemeClass( "ConvertToDDO" );
      }
      AV36EditableGridConfirm = "<i class=\"fas fa-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEditablegridconfirm_Internalname, AV36EditableGridConfirm);
      if ( GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Display") != 0 )
      {
         AV32IsCurrentRecordSelected = false ;
         if ( ( GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Insert") != 0 ) && ( GXutil.strcmp(AV34TLiqCod_SelectedLine, A32TLiqCod) == 0 ) )
         {
            AV32IsCurrentRecordSelected = true ;
         }
         if ( GXutil.strcmp(AV29EditableGrid_Mode, "TrnMode.Delete") == 0 )
         {
            edtTLiqCod_Class = (AV32IsCurrentRecordSelected ? "Attribute InGridDeletion" : "Attribute") ;
            edtTliqDesc_Class = (AV32IsCurrentRecordSelected ? "Attribute InGridDeletion" : "Attribute") ;
         }
         edtavEditablegridcancel_Class = (AV32IsCurrentRecordSelected ? "Attribute" : "Invisible") ;
         edtavEditablegridconfirm_Class = (AV32IsCurrentRecordSelected ? "Attribute" : "Invisible") ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(26) ;
      }
      sendrow_262( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_26_Refreshing )
      {
         httpContext.doAjaxLoad(26, GridRow);
      }
      /*  Sending Event outputs  */
      cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV22GridActions, 4, 0)) );
   }

   public void e184V2( )
   {
      /* 'EditableGridConfirm' Routine */
      returnInSub = false ;
      AV33TipoLiquidacionEditableGrid.Load(A3CliCod, A32TLiqCod);
      AV31Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      if ( AV33TipoLiquidacionEditableGrid.Success() )
      {
         AV33TipoLiquidacionEditableGrid.Delete();
         if ( AV33TipoLiquidacionEditableGrid.Success() )
         {
            AV29EditableGrid_Mode = "TrnMode.Display" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29EditableGrid_Mode", AV29EditableGrid_Mode);
            AV34TLiqCod_SelectedLine = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TLiqCod_SelectedLine", AV34TLiqCod_SelectedLine);
            Application.commitDataStores(context, remoteHandle, pr_default, "conceptotipoliquidacionwc");
            httpContext.doAjaxRefreshCmp(sPrefix);
         }
         else
         {
            AV31Messages = AV33TipoLiquidacionEditableGrid.GetMessages() ;
         }
      }
      else
      {
         AV31Messages = AV33TipoLiquidacionEditableGrid.GetMessages() ;
      }
      if ( AV31Messages.size() > 0 )
      {
         AV34TLiqCod_SelectedLine = A32TLiqCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TLiqCod_SelectedLine", AV34TLiqCod_SelectedLine);
         /* Execute user subroutine: 'SHOW MESSAGES' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV31Messages", AV31Messages);
   }

   public void e194V2( )
   {
      /* 'EditableGridCancel' Routine */
      returnInSub = false ;
      AV34TLiqCod_SelectedLine = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TLiqCod_SelectedLine", AV34TLiqCod_SelectedLine);
      AV29EditableGrid_Mode = "TrnMode.Display" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29EditableGrid_Mode", AV29EditableGrid_Mode);
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
   }

   public void e204V2( )
   {
      /* Gridactions_Click Routine */
      returnInSub = false ;
      if ( AV22GridActions == 1 )
      {
         /* Execute user subroutine: 'DO DELETE' */
         S172 ();
         if (returnInSub) return;
      }
      AV22GridActions = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GridActions), 4, 0));
      /*  Sending Event outputs  */
      cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV22GridActions, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactions.getInternalname(), "Values", cmbavGridactions.ToJavascriptSource(), true);
   }

   public void e144V2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.tipoliquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV23CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","TLiqCod"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean8 = AV27IsAuthorized_Delete ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Delete", GXv_boolean9) ;
      conceptotipoliquidacionwc_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV27IsAuthorized_Delete = GXt_boolean8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27IsAuthorized_Delete", AV27IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Delete));
      bttBtninsert_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      GXt_boolean8 = AV28TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Insert", GXv_boolean9) ;
      conceptotipoliquidacionwc_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV28TempBoolean = GXt_boolean8 ;
      if ( ! ( AV28TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'DO DELETE' Routine */
      returnInSub = false ;
      AV34TLiqCod_SelectedLine = A32TLiqCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TLiqCod_SelectedLine", AV34TLiqCod_SelectedLine);
      AV29EditableGrid_Mode = "TrnMode.Delete" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29EditableGrid_Mode", AV29EditableGrid_Mode);
      httpContext.doAjaxRefreshCmp(sPrefix);
   }

   public void S162( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV31Messages.size() )
      {
         AV30Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV31Messages.elementAt(-1+AV40GXV1));
         httpContext.GX_msglist.addItem(AV30Message.getgxTv_SdtMessages_Message_Description());
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15Session.getValue(AV39Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV39Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV15Session.getValue(AV39Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV15Session.getValue(AV39Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV39Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV39Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "TipoLiquidacion" );
      AV10TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV23CliCod, 6, 0) );
      AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV10TrnContextAtt, 0);
      AV10TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "ConCodigo" );
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV7ConCodigo );
      AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV10TrnContextAtt, 0);
      AV15Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV23CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
      AV7ConCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7ConCodigo", AV7ConCodigo);
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
      pa4V2( ) ;
      ws4V2( ) ;
      we4V2( ) ;
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
      sCtrlAV23CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7ConCodigo = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4V2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptotipoliquidacionwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4V2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV23CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
         AV7ConCodigo = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7ConCodigo", AV7ConCodigo);
      }
      wcpOAV23CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV23CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV7ConCodigo = httpContext.cgiGet( sPrefix+"wcpOAV7ConCodigo") ;
      if ( ! GetJustCreated( ) && ( ( AV23CliCod != wcpOAV23CliCod ) || ( GXutil.strcmp(AV7ConCodigo, wcpOAV7ConCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV23CliCod = AV23CliCod ;
      wcpOAV7ConCodigo = AV7ConCodigo ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV23CliCod = httpContext.cgiGet( sPrefix+"AV23CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV23CliCod) > 0 )
      {
         AV23CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV23CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
      }
      else
      {
         AV23CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV23CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV7ConCodigo = httpContext.cgiGet( sPrefix+"AV7ConCodigo_CTRL") ;
      if ( GXutil.len( sCtrlAV7ConCodigo) > 0 )
      {
         AV7ConCodigo = httpContext.cgiGet( sCtrlAV7ConCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7ConCodigo", AV7ConCodigo);
      }
      else
      {
         AV7ConCodigo = httpContext.cgiGet( sPrefix+"AV7ConCodigo_PARM") ;
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
      pa4V2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4V2( ) ;
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
      ws4V2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV23CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV23CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV23CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV23CliCod_CTRL", GXutil.rtrim( sCtrlAV23CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7ConCodigo_PARM", GXutil.rtrim( AV7ConCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7ConCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7ConCodigo_CTRL", GXutil.rtrim( sCtrlAV7ConCodigo));
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
      we4V2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713303410", true, true);
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
      httpContext.AddJavascriptSource("conceptotipoliquidacionwc.js", "?20251713303410", false, true);
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

   public void subsflControlProps_262( )
   {
      edtavEditablegridcancel_Internalname = sPrefix+"vEDITABLEGRIDCANCEL_"+sGXsfl_26_idx ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS_"+sGXsfl_26_idx );
      edtTLiqCod_Internalname = sPrefix+"TLIQCOD_"+sGXsfl_26_idx ;
      edtTliqDesc_Internalname = sPrefix+"TLIQDESC_"+sGXsfl_26_idx ;
      edtavEditablegridconfirm_Internalname = sPrefix+"vEDITABLEGRIDCONFIRM_"+sGXsfl_26_idx ;
   }

   public void subsflControlProps_fel_262( )
   {
      edtavEditablegridcancel_Internalname = sPrefix+"vEDITABLEGRIDCANCEL_"+sGXsfl_26_fel_idx ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS_"+sGXsfl_26_fel_idx );
      edtTLiqCod_Internalname = sPrefix+"TLIQCOD_"+sGXsfl_26_fel_idx ;
      edtTliqDesc_Internalname = sPrefix+"TLIQDESC_"+sGXsfl_26_fel_idx ;
      edtavEditablegridconfirm_Internalname = sPrefix+"vEDITABLEGRIDCONFIRM_"+sGXsfl_26_fel_idx ;
   }

   public void sendrow_262( )
   {
      subsflControlProps_262( ) ;
      wb4V0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_26_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_26_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_26_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEditablegridcancel_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEditablegridcancel_Enabled!=0)&&(edtavEditablegridcancel_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 27,'"+sPrefix+"',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = edtavEditablegridcancel_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEditablegridcancel_Internalname,GXutil.rtrim( AV35EditableGridCancel),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEditablegridcancel_Enabled!=0)&&(edtavEditablegridcancel_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,27);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'EDITABLEGRIDCANCEL\\'."+sGXsfl_26_idx+"'","","",httpContext.getMessage( "GX_BtnCancel", ""),"",edtavEditablegridcancel_Jsonclick,Integer.valueOf(5),edtavEditablegridcancel_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavEditablegridcancel_Visible),Integer.valueOf(edtavEditablegridcancel_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbavGridactions.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         TempTags = " " + ((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 28,'"+sPrefix+"',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         if ( ( cmbavGridactions.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vGRIDACTIONS_" + sGXsfl_26_idx ;
            cmbavGridactions.setName( GXCCtl );
            cmbavGridactions.setWebtags( "" );
            if ( cmbavGridactions.getItemCount() > 0 )
            {
               AV22GridActions = (short)(GXutil.lval( cmbavGridactions.getValidValue(GXutil.trim( GXutil.str( AV22GridActions, 4, 0))))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GridActions), 4, 0));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavGridactions,cmbavGridactions.getInternalname(),GXutil.trim( GXutil.str( AV22GridActions, 4, 0)),Integer.valueOf(1),cmbavGridactions.getJsonclick(),Integer.valueOf(5),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVGRIDACTIONS.CLICK."+sGXsfl_26_idx+"'","int","",Integer.valueOf(cmbavGridactions.getVisible()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","",cmbavGridactions.getThemeClass(),"WWActionGroupColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,28);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV22GridActions, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactions.getInternalname(), "Values", cmbavGridactions.ToJavascriptSource(), !bGXsfl_26_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtTLiqCod_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqCod_Internalname,GXutil.rtrim( A32TLiqCod),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtTLiqCod_Jsonclick,Integer.valueOf(0),edtTLiqCod_Class,"",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtTliqDesc_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTliqDesc_Internalname,A340TliqDesc,GXutil.rtrim( localUtil.format( A340TliqDesc, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtTliqDesc_Jsonclick,Integer.valueOf(0),edtTliqDesc_Class,"",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEditablegridconfirm_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEditablegridconfirm_Enabled!=0)&&(edtavEditablegridconfirm_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 31,'"+sPrefix+"',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = edtavEditablegridconfirm_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEditablegridconfirm_Internalname,GXutil.rtrim( AV36EditableGridConfirm),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEditablegridconfirm_Enabled!=0)&&(edtavEditablegridconfirm_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,31);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'EDITABLEGRIDCONFIRM\\'."+sGXsfl_26_idx+"'","","",httpContext.getMessage( "GX_BtnEnter", ""),"",edtavEditablegridconfirm_Jsonclick,Integer.valueOf(5),edtavEditablegridconfirm_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavEditablegridconfirm_Visible),Integer.valueOf(edtavEditablegridconfirm_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes4V2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      /* End function sendrow_262 */
   }

   public void startgridcontrol26( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"26\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEditablegridcancel_Class+"\" "+" style=\""+((edtavEditablegridcancel_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+cmbavGridactions.getThemeClass()+"\" "+" style=\""+((cmbavGridactions.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtTLiqCod_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtTliqDesc_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEditablegridconfirm_Class+"\" "+" style=\""+((edtavEditablegridconfirm_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV35EditableGridCancel));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEditablegridcancel_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEditablegridcancel_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEditablegridcancel_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV22GridActions, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( cmbavGridactions.getThemeClass()));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavGridactions.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtTLiqCod_Class));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A340TliqDesc);
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtTliqDesc_Class));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV36EditableGridConfirm));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEditablegridconfirm_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEditablegridconfirm_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEditablegridconfirm_Visible, (byte)(5), (byte)(0), ".", "")));
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
      bttBtninsert_Internalname = sPrefix+"BTNINSERT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      edtavEditablegridcancel_Internalname = sPrefix+"vEDITABLEGRIDCANCEL" ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS" );
      edtTLiqCod_Internalname = sPrefix+"TLIQCOD" ;
      edtTliqDesc_Internalname = sPrefix+"TLIQDESC" ;
      edtavEditablegridconfirm_Internalname = sPrefix+"vEDITABLEGRIDCONFIRM" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
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
      edtavEditablegridconfirm_Jsonclick = "" ;
      edtavEditablegridconfirm_Class = "Attribute" ;
      edtavEditablegridconfirm_Enabled = 1 ;
      edtTliqDesc_Jsonclick = "" ;
      edtTliqDesc_Class = "Attribute" ;
      edtTLiqCod_Jsonclick = "" ;
      edtTLiqCod_Class = "Attribute" ;
      cmbavGridactions.setJsonclick( "" );
      cmbavGridactions.setEnabled( 1 );
      cmbavGridactions.setThemeClass( "ConvertToDDO" );
      edtavEditablegridcancel_Jsonclick = "" ;
      edtavEditablegridcancel_Class = "Attribute" ;
      edtavEditablegridcancel_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavEditablegridconfirm_Visible = -1 ;
      edtavEditablegridcancel_Visible = -1 ;
      cmbavGridactions.setVisible( -1 );
      subGrid_Sortable = (byte)(0) ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      Grid_empowerer_Fixedcolumns = ";L;;;" ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2" ;
      Ddo_grid_Columnids = "2:TLiqCod|3:TliqDesc" ;
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
      GXCCtl = "vGRIDACTIONS_" + sGXsfl_26_idx ;
      cmbavGridactions.setName( GXCCtl );
      cmbavGridactions.setWebtags( "" );
      if ( cmbavGridactions.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'sPrefix'},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV20GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV21GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'cmbavGridactions'},{av:'edtavEditablegridcancel_Visible',ctrl:'vEDITABLEGRIDCANCEL',prop:'Visible'},{av:'edtavEditablegridconfirm_Visible',ctrl:'vEDITABLEGRIDCONFIRM',prop:'Visible'},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e114V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e124V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e134V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e174V2',iparms:[{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV35EditableGridCancel',fld:'vEDITABLEGRIDCANCEL',pic:''},{av:'cmbavGridactions'},{av:'AV22GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'AV36EditableGridConfirm',fld:'vEDITABLEGRIDCONFIRM',pic:''},{av:'edtTLiqCod_Class',ctrl:'TLIQCOD',prop:'Class'},{av:'edtTliqDesc_Class',ctrl:'TLIQDESC',prop:'Class'},{av:'edtavEditablegridcancel_Class',ctrl:'vEDITABLEGRIDCANCEL',prop:'Class'},{av:'edtavEditablegridconfirm_Class',ctrl:'vEDITABLEGRIDCONFIRM',prop:'Class'}]}");
      setEventMetadata("'EDITABLEGRIDCONFIRM'","{handler:'e184V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true},{av:'AV31Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("'EDITABLEGRIDCONFIRM'",",oparms:[{av:'AV31Messages',fld:'vMESSAGES',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV20GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV21GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'cmbavGridactions'},{av:'edtavEditablegridcancel_Visible',ctrl:'vEDITABLEGRIDCANCEL',prop:'Visible'},{av:'edtavEditablegridconfirm_Visible',ctrl:'vEDITABLEGRIDCONFIRM',prop:'Visible'},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]}");
      setEventMetadata("'EDITABLEGRIDCANCEL'","{handler:'e194V2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'}]");
      setEventMetadata("'EDITABLEGRIDCANCEL'",",oparms:[{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV20GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV21GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'cmbavGridactions'},{av:'edtavEditablegridcancel_Visible',ctrl:'vEDITABLEGRIDCANCEL',prop:'Visible'},{av:'edtavEditablegridconfirm_Visible',ctrl:'vEDITABLEGRIDCONFIRM',prop:'Visible'},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]}");
      setEventMetadata("VGRIDACTIONS.CLICK","{handler:'e204V2',iparms:[{av:'cmbavGridactions'},{av:'AV22GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV39Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("VGRIDACTIONS.CLICK",",oparms:[{av:'cmbavGridactions'},{av:'AV22GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'AV34TLiqCod_SelectedLine',fld:'vTLIQCOD_SELECTEDLINE',pic:''},{av:'AV29EditableGrid_Mode',fld:'vEDITABLEGRID_MODE',pic:''},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV20GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV21GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'edtavEditablegridcancel_Visible',ctrl:'vEDITABLEGRIDCANCEL',prop:'Visible'},{av:'edtavEditablegridconfirm_Visible',ctrl:'vEDITABLEGRIDCONFIRM',prop:'Visible'},{av:'AV27IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]}");
      setEventMetadata("'DOINSERT'","{handler:'e144V2',iparms:[{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Editablegridconfirm',iparms:[]");
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
      wcpOAV7ConCodigo = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV7ConCodigo = "" ;
      AV29EditableGrid_Mode = "" ;
      AV39Pgmname = "" ;
      AV34TLiqCod_SelectedLine = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV21GridAppliedFilters = "" ;
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV31Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A26ConCodigo = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV35EditableGridCancel = "" ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      AV36EditableGridConfirm = "" ;
      scmdbuf = "" ;
      H004V2_A3CliCod = new int[1] ;
      H004V2_A26ConCodigo = new String[] {""} ;
      H004V2_A340TliqDesc = new String[] {""} ;
      H004V2_A32TLiqCod = new String[] {""} ;
      H004V3_AGRID_nRecordCount = new long[1] ;
      hsh = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV33TipoLiquidacionEditableGrid = new web.SdtTipoLiquidacion(remoteHandle);
      GXv_boolean9 = new boolean[1] ;
      AV30Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV15Session = httpContext.getWebSession();
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8HTTPRequest = httpContext.getHttpRequest();
      AV10TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV23CliCod = "" ;
      sCtrlAV7ConCodigo = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacionwc__default(),
         new Object[] {
             new Object[] {
            H004V2_A3CliCod, H004V2_A26ConCodigo, H004V2_A340TliqDesc, H004V2_A32TLiqCod
            }
            , new Object[] {
            H004V3_AGRID_nRecordCount
            }
         }
      );
      AV39Pgmname = "ConceptoTipoLiquidacionWC" ;
      /* GeneXus formulas. */
      AV39Pgmname = "ConceptoTipoLiquidacionWC" ;
      Gx_err = (short)(0) ;
      edtavEditablegridcancel_Enabled = 0 ;
      edtavEditablegridconfirm_Enabled = 0 ;
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
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short AV22GridActions ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV23CliCod ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_26 ;
   private int AV23CliCod ;
   private int nGXsfl_26_idx=1 ;
   private int A3CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int edtCliCod_Visible ;
   private int edtConCodigo_Visible ;
   private int subGrid_Islastpage ;
   private int edtavEditablegridcancel_Enabled ;
   private int edtavEditablegridconfirm_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtavEditablegridcancel_Visible ;
   private int edtavEditablegridconfirm_Visible ;
   private int AV18PageToGo ;
   private int AV40GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV19GridCurrentPage ;
   private long AV20GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String wcpOAV7ConCodigo ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV7ConCodigo ;
   private String sGXsfl_26_idx="0001" ;
   private String AV39Pgmname ;
   private String AV34TLiqCod_SelectedLine ;
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
   private String Grid_empowerer_Fixedcolumns ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtConCodigo_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavEditablegridcancel_Internalname ;
   private String AV35EditableGridCancel ;
   private String A32TLiqCod ;
   private String edtTLiqCod_Internalname ;
   private String edtTliqDesc_Internalname ;
   private String AV36EditableGridConfirm ;
   private String edtavEditablegridconfirm_Internalname ;
   private String scmdbuf ;
   private String hsh ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String edtTLiqCod_Class ;
   private String edtTliqDesc_Class ;
   private String edtavEditablegridcancel_Class ;
   private String edtavEditablegridconfirm_Class ;
   private String sCtrlAV23CliCod ;
   private String sCtrlAV7ConCodigo ;
   private String sGXsfl_26_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavEditablegridcancel_Jsonclick ;
   private String GXCCtl ;
   private String edtTLiqCod_Jsonclick ;
   private String edtTliqDesc_Jsonclick ;
   private String edtavEditablegridconfirm_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV27IsAuthorized_Delete ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_26_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV32IsCurrentRecordSelected ;
   private boolean AV28TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV29EditableGrid_Mode ;
   private String AV21GridAppliedFilters ;
   private String A340TliqDesc ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavGridactions ;
   private IDataStoreProvider pr_default ;
   private int[] H004V2_A3CliCod ;
   private String[] H004V2_A26ConCodigo ;
   private String[] H004V2_A340TliqDesc ;
   private String[] H004V2_A32TLiqCod ;
   private long[] H004V3_AGRID_nRecordCount ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV31Messages ;
   private com.genexus.SdtMessages_Message AV30Message ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV10TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.SdtTipoLiquidacion AV33TipoLiquidacionEditableGrid ;
}

final  class conceptotipoliquidacionwc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H004V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV23CliCod ,
                                          String AV7ConCodigo ,
                                          int A3CliCod ,
                                          String A26ConCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.CliCod, T1.ConCodigo, T2.TliqDesc, T1.TLiqCod" ;
      sFromString = " FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.ConCodigo = ( ?))");
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.ConCodigo DESC, T1.TLiqCod DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.ConCodigo, T2.TliqDesc, T1.TLiqCod" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.ConCodigo DESC, T2.TliqDesc DESC, T1.TLiqCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_H004V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV23CliCod ,
                                          String AV7ConCodigo ,
                                          int A3CliCod ,
                                          String A26ConCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[2];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.ConCodigo = ( ?))");
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_H004V2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] );
            case 1 :
                  return conditional_H004V3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 10);
               }
               return;
      }
   }

}
