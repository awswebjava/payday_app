package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cliente_updateww_impl extends GXDataArea
{
   public cliente_updateww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cliente_updateww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_updateww_impl.class ));
   }

   public cliente_updateww_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkavCliupdrelhab = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV48MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48MenuOpcCod", AV48MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_67 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_67"))) ;
      nGXsfl_67_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_67_idx"))) ;
      sGXsfl_67_idx = httpContext.GetPar( "sGXsfl_67_idx") ;
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
      AV58ahora = localUtil.parseDTimeParm( httpContext.GetPar( "ahora")) ;
      AV68Pgmname = httpContext.GetPar( "Pgmname") ;
      AV48MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV57CliUpdFecRel = localUtil.parseDTimeParm( httpContext.GetPar( "CliUpdFecRel")) ;
      AV59CliUpdRelHab = GXutil.strtobool( httpContext.GetPar( "CliUpdRelHab")) ;
      AV23TFCliUpdRelDesc = httpContext.GetPar( "TFCliUpdRelDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24TFCliUpdRelDesc_Sels);
      AV25TFCliUpdDTApl = localUtil.parseDTimeParm( httpContext.GetPar( "TFCliUpdDTApl")) ;
      AV26TFCliUpdDTApl_To = localUtil.parseDTimeParm( httpContext.GetPar( "TFCliUpdDTApl_To")) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV36CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      paKE2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startKE2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.cliente_updateww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vAHORA", localUtil.ttoc( AV58ahora, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_67", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_67, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV32GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV33GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV34GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CLIUPDDTAPLAUXDATE", localUtil.dtoc( AV27DDO_CliUpdDTAplAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CLIUPDDTAPLAUXDATETO", localUtil.dtoc( AV28DDO_CliUpdDTAplAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV68Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV48MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLIUPDRELDESC", AV23TFCliUpdRelDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCLIUPDRELDESC_SELS", AV24TFCliUpdRelDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCLIUPDRELDESC_SELS", AV24TFCliUpdRelDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLIUPDDTAPL", localUtil.ttoc( AV25TFCliUpdDTApl, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLIUPDDTAPL_TO", localUtil.ttoc( AV26TFCliUpdDTApl_To, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIUPDCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV41CliUpdCliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV42CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIUPDRELSEC_SELECTED", GXutil.ltrim( localUtil.ntoc( AV43CliUpdRelSec_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV36CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Title", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Result", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ACTUALIZAR_Result", GXutil.rtrim( Dvelop_confirmpanel_actualizar_Result));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
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
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weKE2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtKE2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.cliente_updateww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Cliente_UpdateWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Actualizaciones", "") ;
   }

   public void wbKE0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_KE2( true) ;
      }
      else
      {
         wb_table1_9_KE2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavCliupdfecrel_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCliupdfecrel_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCliupdfecrel_Internalname, httpContext.getMessage( "Aplicados hasta la fecha", ""), "col-sm-3 AttributeDateTimeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'" + sGXsfl_67_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavCliupdfecrel_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCliupdfecrel_Internalname, localUtil.ttoc( AV57CliUpdFecRel, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV57CliUpdFecRel, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCliupdfecrel_Jsonclick, 0, "AttributeDateTime", "", "", "", "", edtavCliupdfecrel_Visible, edtavCliupdfecrel_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavCliupdfecrel_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavCliupdfecrel_Visible==0)||(edtavCliupdfecrel_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cliente_UpdateWW.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavCliupdrelhab.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCliupdrelhab.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavCliupdrelhab.getInternalname(), httpContext.getMessage( "habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'" + sGXsfl_67_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCliupdrelhab.getInternalname(), GXutil.booltostr( AV59CliUpdRelHab), "", httpContext.getMessage( "habilitado", ""), chkavCliupdrelhab.getVisible(), chkavCliupdrelhab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(93, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,93);\"");
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
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV30DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'" + sGXsfl_67_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavAhora_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAhora_Internalname, localUtil.ttoc( AV58ahora, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV58ahora, "99/99/99 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,98);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAhora_Jsonclick, 0, "Attribute", "", "", "", "", edtavAhora_Visible, 1, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "ahora", "right", false, "", "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavAhora_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavAhora_Visible==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cliente_UpdateWW.htm");
         httpContext.writeTextNL( "</div>") ;
         wb_table2_99_KE2( true) ;
      }
      else
      {
         wb_table2_99_KE2( false) ;
      }
      return  ;
   }

   public void wb_table2_99_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_cliupddtaplauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'" + sGXsfl_67_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_cliupddtaplauxdatetext_Internalname, AV29DDO_CliUpdDTAplAuxDateText, GXutil.rtrim( localUtil.format( AV29DDO_CliUpdDTAplAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,106);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_cliupddtaplauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cliente_UpdateWW.htm");
         /* User Defined Control */
         ucTfcliupddtapl_rangepicker.setProperty("Start Date", AV27DDO_CliUpdDTAplAuxDate);
         ucTfcliupddtapl_rangepicker.setProperty("End Date", AV28DDO_CliUpdDTAplAuxDateTo);
         ucTfcliupddtapl_rangepicker.render(context, "wwp.daterangepicker", Tfcliupddtapl_rangepicker_Internalname, "TFCLIUPDDTAPL_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 67 )
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
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startKE2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( " Actualizaciones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupKE0( ) ;
   }

   public void wsKE2( )
   {
      startKE2( ) ;
      evtKE2( ) ;
   }

   public void evtKE2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11KE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12KE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13KE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ACTUALIZAR.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14KE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15KE2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_67_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_672( ) ;
                           A1884CliUpdRelDesc = httpContext.cgiGet( edtCliUpdRelDesc_Internalname) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1881CliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliUpdCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1887CliUpdRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtCliUpdRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV44CliNom = GXutil.upper( httpContext.cgiGet( edtavClinom_Internalname)) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavClinom_Internalname, AV44CliNom);
                           AV45CliReObs = httpContext.cgiGet( edtavClireobs_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavClireobs_Internalname, AV45CliReObs);
                           A1883CliUpdDTApl = localUtil.ctot( httpContext.cgiGet( edtCliUpdDTApl_Internalname), 0) ;
                           AV47Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV47Display);
                           AV35Actualizar = httpContext.cgiGet( edtavActualizar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavActualizar_Internalname, AV35Actualizar);
                           AV46VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV46VerSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e16KE2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e17KE2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18KE2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Ahora Changed */
                                    if ( !( GXutil.dateCompare(localUtil.ctot( httpContext.cgiGet( "GXH_vAHORA"), 0), AV58ahora) ) )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
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

   public void weKE2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void paKE2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      subsflControlProps_672( ) ;
      while ( nGXsfl_67_idx <= nRC_GXsfl_67 )
      {
         sendrow_672( ) ;
         nGXsfl_67_idx = ((subGrid_Islastpage==1)&&(nGXsfl_67_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 java.util.Date AV58ahora ,
                                 String AV68Pgmname ,
                                 String AV48MenuOpcCod ,
                                 java.util.Date AV57CliUpdFecRel ,
                                 boolean AV59CliUpdRelHab ,
                                 String AV23TFCliUpdRelDesc ,
                                 GXSimpleCollection<String> AV24TFCliUpdRelDesc_Sels ,
                                 java.util.Date AV25TFCliUpdDTApl ,
                                 java.util.Date AV26TFCliUpdDTApl_To ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV36CliCod ,
                                 boolean AV50WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e17KE2 ();
      GRID_nCurrentRecord = 0 ;
      rfKE2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIUPDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1881CliUpdCliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIUPDCLICOD", GXutil.ltrim( localUtil.ntoc( A1881CliUpdCliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIUPDRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1887CliUpdRelSec), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIUPDRELSEC", GXutil.ltrim( localUtil.ntoc( A1887CliUpdRelSec, (byte)(6), (byte)(0), ".", "")));
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
      AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV50WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50WelcomeMessage_NoMostrarMas", AV50WelcomeMessage_NoMostrarMas);
      AV59CliUpdRelHab = GXutil.strtobool( GXutil.booltostr( AV59CliUpdRelHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliUpdRelHab", AV59CliUpdRelHab);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfKE2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV68Pgmname = "Cliente_UpdateWW" ;
      Gx_err = (short)(0) ;
      edtavClinom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClinom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClinom_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavClireobs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClireobs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClireobs_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavActualizar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavActualizar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActualizar_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_67_Refreshing);
   }

   public void rfKE2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(67) ;
      /* Execute user event: Refresh */
      e17KE2 ();
      nGXsfl_67_idx = 1 ;
      sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_672( ) ;
      bGXsfl_67_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
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
         subsflControlProps_672( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A1884CliUpdRelDesc ,
                                              AV72Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                              Integer.valueOf(AV72Cliente_updatewwds_4_tfcliupdreldesc_sels.size()) ,
                                              AV71Cliente_updatewwds_3_tfcliupdreldesc ,
                                              AV73Cliente_updatewwds_5_tfcliupddtapl ,
                                              AV74Cliente_updatewwds_6_tfcliupddtapl_to ,
                                              A1883CliUpdDTApl ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              AV58ahora ,
                                              A1962CliUpdFecRel ,
                                              Boolean.valueOf(A1964CliUpdRelHab) ,
                                              Integer.valueOf(AV36CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV71Cliente_updatewwds_3_tfcliupdreldesc = GXutil.concat( GXutil.rtrim( AV71Cliente_updatewwds_3_tfcliupdreldesc), "%", "") ;
         /* Using cursor H00KE2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), AV58ahora, lV71Cliente_updatewwds_3_tfcliupdreldesc, AV73Cliente_updatewwds_5_tfcliupddtapl, AV74Cliente_updatewwds_6_tfcliupddtapl_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_67_idx = 1 ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1964CliUpdRelHab = H00KE2_A1964CliUpdRelHab[0] ;
            A1962CliUpdFecRel = H00KE2_A1962CliUpdFecRel[0] ;
            A1883CliUpdDTApl = H00KE2_A1883CliUpdDTApl[0] ;
            A1887CliUpdRelSec = H00KE2_A1887CliUpdRelSec[0] ;
            A1881CliUpdCliCod = H00KE2_A1881CliUpdCliCod[0] ;
            A3CliCod = H00KE2_A3CliCod[0] ;
            A1884CliUpdRelDesc = H00KE2_A1884CliUpdRelDesc[0] ;
            A1964CliUpdRelHab = H00KE2_A1964CliUpdRelHab[0] ;
            e18KE2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(67) ;
         wbKE0( ) ;
      }
      bGXsfl_67_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesKE2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV68Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV68Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV48MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIUPDCLICOD"+"_"+sGXsfl_67_idx, getSecureSignedToken( sGXsfl_67_idx, localUtil.format( DecimalUtil.doubleToDec(A1881CliUpdCliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD"+"_"+sGXsfl_67_idx, getSecureSignedToken( sGXsfl_67_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIUPDRELSEC"+"_"+sGXsfl_67_idx, getSecureSignedToken( sGXsfl_67_idx, localUtil.format( DecimalUtil.doubleToDec(A1887CliUpdRelSec), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV36CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
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
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1884CliUpdRelDesc ,
                                           AV72Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                           Integer.valueOf(AV72Cliente_updatewwds_4_tfcliupdreldesc_sels.size()) ,
                                           AV71Cliente_updatewwds_3_tfcliupdreldesc ,
                                           AV73Cliente_updatewwds_5_tfcliupddtapl ,
                                           AV74Cliente_updatewwds_6_tfcliupddtapl_to ,
                                           A1883CliUpdDTApl ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           AV58ahora ,
                                           A1962CliUpdFecRel ,
                                           Boolean.valueOf(A1964CliUpdRelHab) ,
                                           Integer.valueOf(AV36CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV71Cliente_updatewwds_3_tfcliupdreldesc = GXutil.concat( GXutil.rtrim( AV71Cliente_updatewwds_3_tfcliupdreldesc), "%", "") ;
      /* Using cursor H00KE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV36CliCod), AV58ahora, lV71Cliente_updatewwds_3_tfcliupdreldesc, AV73Cliente_updatewwds_5_tfcliupddtapl, AV74Cliente_updatewwds_6_tfcliupddtapl_to});
      GRID_nRecordCount = H00KE3_AGRID_nRecordCount[0] ;
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
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV68Pgmname = "Cliente_UpdateWW" ;
      Gx_err = (short)(0) ;
      edtavClinom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClinom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClinom_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavClireobs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClireobs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClireobs_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavActualizar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavActualizar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActualizar_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupKE0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e16KE2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV30DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_67 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_67"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV32GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV33GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV34GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV27DDO_CliUpdDTAplAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_CLIUPDDTAPLAUXDATE"), 0) ;
         AV28DDO_CliUpdDTAplAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_CLIUPDDTAPLAUXDATETO"), 0) ;
         AV43CliUpdRelSec_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vCLIUPDRELSEC_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV42CliCod_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV41CliUpdCliCod_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vCLIUPDCLICOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Dvelop_confirmpanel_actualizar_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Title") ;
         Dvelop_confirmpanel_actualizar_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Confirmationtext") ;
         Dvelop_confirmpanel_actualizar_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_actualizar_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_actualizar_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_actualizar_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_actualizar_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Confirmtype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Dvelop_confirmpanel_actualizar_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ACTUALIZAR_Result") ;
         /* Read variables values. */
         AV56WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50WelcomeMessage_NoMostrarMas", AV50WelcomeMessage_NoMostrarMas);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavCliupdfecrel_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vCLIUPDFECREL");
            GX_FocusControl = edtavCliupdfecrel_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV57CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV57CliUpdFecRel", localUtil.ttoc( AV57CliUpdFecRel, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV57CliUpdFecRel = localUtil.ctot( httpContext.cgiGet( edtavCliupdfecrel_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57CliUpdFecRel", localUtil.ttoc( AV57CliUpdFecRel, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         AV59CliUpdRelHab = GXutil.strtobool( httpContext.cgiGet( chkavCliupdrelhab.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CliUpdRelHab", AV59CliUpdRelHab);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavAhora_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vAHORA");
            GX_FocusControl = edtavAhora_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV58ahora = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV58ahora", localUtil.ttoc( AV58ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV58ahora = localUtil.ctot( httpContext.cgiGet( edtavAhora_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58ahora", localUtil.ttoc( AV58ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         AV29DDO_CliUpdDTAplAuxDateText = httpContext.cgiGet( edtavDdo_cliupddtaplauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29DDO_CliUpdDTAplAuxDateText", AV29DDO_CliUpdDTAplAuxDateText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( !( GXutil.dateCompare(localUtil.ctot( httpContext.cgiGet( "GXH_vAHORA")), AV58ahora) ) )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e16KE2 ();
      if (returnInSub) return;
   }

   public void e16KE2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV48MenuOpcCod, "", "") ;
      GXt_int1 = AV36CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      cliente_updateww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV36CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      this.executeUsercontrolMethod("", false, "TFCLIUPDDTAPL_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_cliupddtaplauxdatetext_Internalname});
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      edtavAhora_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAhora_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAhora_Visible), 5, 0), true);
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Actualizaciones", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV14OrderedBy < 1 )
      {
         AV14OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV30DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV30DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV51MenuBienveImgURL ;
      GXv_char6[0] = AV53MenuBienveTitulo ;
      GXv_char7[0] = AV54MenuBienveTexto ;
      GXv_boolean8[0] = AV55MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV48MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      cliente_updateww_impl.this.AV51MenuBienveImgURL = GXv_char5[0] ;
      cliente_updateww_impl.this.AV53MenuBienveTitulo = GXv_char6[0] ;
      cliente_updateww_impl.this.AV54MenuBienveTexto = GXv_char7[0] ;
      cliente_updateww_impl.this.AV55MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV55MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV55MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV53MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV54MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV56WelcomeMessage_Foto = AV51MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV56WelcomeMessage_Foto)==0) ? AV67Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV56WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV56WelcomeMessage_Foto), true);
         AV67Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV51MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV56WelcomeMessage_Foto)==0) ? AV67Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV56WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV56WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      cliente_updateww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      GXt_dtime11 = AV58ahora ;
      GXv_dtime12[0] = GXt_dtime11 ;
      new web.getahora(remoteHandle, context).execute( AV36CliCod, GXv_dtime12) ;
      cliente_updateww_impl.this.GXt_dtime11 = GXv_dtime12[0] ;
      AV58ahora = GXt_dtime11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58ahora", localUtil.ttoc( AV58ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
   }

   public void e17KE2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV36CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      cliente_updateww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV36CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      AV32GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GridCurrentPage), 10, 0));
      AV33GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GridPageCount), 10, 0));
      GXt_char10 = AV34GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV68Pgmname, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV34GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34GridAppliedFilters", AV34GridAppliedFilters);
      GXt_char10 = AV64MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV48MenuOpcCod, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV64MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV64MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV64MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      AV69Cliente_updatewwds_1_cliupdfecrel = AV57CliUpdFecRel ;
      AV70Cliente_updatewwds_2_cliupdrelhab = AV59CliUpdRelHab ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = AV23TFCliUpdRelDesc ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = AV24TFCliUpdRelDesc_Sels ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = AV25TFCliUpdDTApl ;
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = AV26TFCliUpdDTApl_To ;
      /*  Sending Event outputs  */
   }

   public void e11KE2( )
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
         AV31PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV31PageToGo) ;
      }
   }

   public void e12KE2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13KE2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV14OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         AV15OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliUpdRelDesc") == 0 )
         {
            AV23TFCliUpdRelDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFCliUpdRelDesc", AV23TFCliUpdRelDesc);
            AV22TFCliUpdRelDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFCliUpdRelDesc_SelsJson", AV22TFCliUpdRelDesc_SelsJson);
            AV24TFCliUpdRelDesc_Sels.fromJSonString(AV22TFCliUpdRelDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliUpdDTApl") == 0 )
         {
            AV25TFCliUpdDTApl = localUtil.ctot( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliUpdDTApl", localUtil.ttoc( AV25TFCliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV26TFCliUpdDTApl_To = localUtil.ctot( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFCliUpdDTApl_To", localUtil.ttoc( AV26TFCliUpdDTApl_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV26TFCliUpdDTApl_To) )
            {
               AV26TFCliUpdDTApl_To = localUtil.ymdhmsToT( (short)(GXutil.year( AV26TFCliUpdDTApl_To)), (byte)(GXutil.month( AV26TFCliUpdDTApl_To)), (byte)(GXutil.day( AV26TFCliUpdDTApl_To)), (byte)(23), (byte)(59), (byte)(59)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26TFCliUpdDTApl_To", localUtil.ttoc( AV26TFCliUpdDTApl_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24TFCliUpdRelDesc_Sels", AV24TFCliUpdRelDesc_Sels);
   }

   private void e18KE2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV47Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV47Display);
      edtavDisplay_Link = formatLink("web.cliente_updateview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1881CliUpdCliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1887CliUpdRelSec,6,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliUpdCliCod","CliUpdRelSec","TabCode"})  ;
      AV35Actualizar = "<i class=\"fas fa-cloud-arrow-down fas fa-cloud-arrow-down\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavActualizar_Internalname, AV35Actualizar);
      if ( GXutil.dateCompare(GXutil.nullDate(), A1883CliUpdDTApl) )
      {
         edtavActualizar_Class = "Attribute" ;
      }
      else
      {
         edtavActualizar_Class = "Invisible" ;
      }
      GXt_char10 = AV44CliNom ;
      GXv_char7[0] = GXt_char10 ;
      new web.getnombrecliente(remoteHandle, context).execute( A1881CliUpdCliCod, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV44CliNom = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavClinom_Internalname, AV44CliNom);
      GXt_char10 = AV45CliReObs ;
      GXv_char7[0] = GXt_char10 ;
      new web.getclireobs(remoteHandle, context).execute( A3CliCod, A1887CliUpdRelSec, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV45CliReObs = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavClireobs_Internalname, AV45CliReObs);
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV46VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV46VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV46VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(67) ;
      }
      sendrow_672( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_67_Refreshing )
      {
         httpContext.doAjaxLoad(67, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e14KE2( )
   {
      /* Dvelop_confirmpanel_actualizar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_actualizar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTUALIZAR' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'DO ACTUALIZAR' Routine */
      returnInSub = false ;
      new web.wwpbaseobjects.actualizar(remoteHandle, context).execute( AV41CliUpdCliCod_Selected, AV42CliCod_Selected, AV43CliUpdRelSec_Selected) ;
      gxgrgrid_refresh( subGrid_Rows, AV58ahora, AV68Pgmname, AV48MenuOpcCod, AV57CliUpdFecRel, AV59CliUpdRelHab, AV23TFCliUpdRelDesc, AV24TFCliUpdRelDesc_Sels, AV25TFCliUpdDTApl, AV26TFCliUpdDTApl_To, AV14OrderedBy, AV15OrderedDsc, AV36CliCod, AV50WelcomeMessage_NoMostrarMas) ;
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue(AV68Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV68Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV68Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      AV75GXV1 = 1 ;
      while ( AV75GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV75GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLIUPDFECREL") == 0 )
         {
            AV57CliUpdFecRel = localUtil.ctot( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57CliUpdFecRel", localUtil.ttoc( AV57CliUpdFecRel, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLIUPDRELHAB") == 0 )
         {
            AV59CliUpdRelHab = GXutil.boolval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59CliUpdRelHab", AV59CliUpdRelHab);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDRELDESC") == 0 )
         {
            AV23TFCliUpdRelDesc = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFCliUpdRelDesc", AV23TFCliUpdRelDesc);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDRELDESC_SEL") == 0 )
         {
            AV22TFCliUpdRelDesc_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFCliUpdRelDesc_SelsJson", AV22TFCliUpdRelDesc_SelsJson);
            AV24TFCliUpdRelDesc_Sels.fromJSonString(AV22TFCliUpdRelDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDDTAPL") == 0 )
         {
            AV25TFCliUpdDTApl = localUtil.ctot( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliUpdDTApl", localUtil.ttoc( AV25TFCliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV26TFCliUpdDTApl_To = localUtil.ctot( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFCliUpdDTApl_To", localUtil.ttoc( AV26TFCliUpdDTApl_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV27DDO_CliUpdDTAplAuxDate = GXutil.resetTime(AV25TFCliUpdDTApl) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27DDO_CliUpdDTAplAuxDate", localUtil.format(AV27DDO_CliUpdDTAplAuxDate, "99/99/99"));
            AV28DDO_CliUpdDTAplAuxDateTo = GXutil.resetTime(AV26TFCliUpdDTApl_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28DDO_CliUpdDTAplAuxDateTo", localUtil.format(AV28DDO_CliUpdDTAplAuxDateTo, "99/99/99"));
         }
         AV75GXV1 = (int)(AV75GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV24TFCliUpdRelDesc_Sels.size()==0), AV22TFCliUpdRelDesc_SelsJson, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV23TFCliUpdRelDesc)==0), AV23TFCliUpdRelDesc, GXv_char7) ;
      cliente_updateww_impl.this.GXt_char10 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char10+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV25TFCliUpdDTApl) ? "" : localUtil.dtoc( AV27DDO_CliUpdDTAplAuxDate, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+(GXutil.dateCompare(GXutil.nullDate(), AV26TFCliUpdDTApl_To) ? "" : localUtil.dtoc( AV28DDO_CliUpdDTAplAuxDateTo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV12GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV68Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState14[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState14, "CLIUPDFECREL", httpContext.getMessage( "Aplicados hasta la fecha", ""), !GXutil.dateCompare(GXutil.nullDate(), AV57CliUpdFecRel), (short)(0), GXutil.trim( localUtil.ttoc( AV57CliUpdFecRel, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ")), "") ;
      AV12GridState = GXv_SdtWWPGridState14[0] ;
      GXv_SdtWWPGridState14[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState14, "CLIUPDRELHAB", httpContext.getMessage( "habilitado", ""), !(false==AV59CliUpdRelHab), (short)(0), GXutil.trim( GXutil.booltostr( AV59CliUpdRelHab)), "") ;
      AV12GridState = GXv_SdtWWPGridState14[0] ;
      GXv_SdtWWPGridState14[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState14, "TFCLIUPDRELDESC", httpContext.getMessage( "Actualización", ""), !(GXutil.strcmp("", AV23TFCliUpdRelDesc)==0), (short)(0), AV23TFCliUpdRelDesc, "", !(AV24TFCliUpdRelDesc_Sels.size()==0), AV24TFCliUpdRelDesc_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState14[0] ;
      GXv_SdtWWPGridState14[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState14, "TFCLIUPDDTAPL", httpContext.getMessage( "Fecha de aplicación de la actualización", ""), !(GXutil.dateCompare(GXutil.nullDate(), AV25TFCliUpdDTApl)&&GXutil.dateCompare(GXutil.nullDate(), AV26TFCliUpdDTApl_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV25TFCliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV26TFCliUpdDTApl_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
      AV12GridState = GXv_SdtWWPGridState14[0] ;
      if ( ! (GXutil.strcmp("", AV48MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV48MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV68Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV68Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Cliente_Update" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue(AV68Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV68Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV68Pgmname+"GridState"), null, null);
      }
      if ( ! ( false ) )
      {
         edtavCliupdfecrel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCliupdfecrel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliupdfecrel_Visible), 5, 0), true);
         GXv_SdtWWPGridState14[0] = AV12GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState14, "CLIUPDFECREL", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV12GridState = GXv_SdtWWPGridState14[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV68Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
      if ( ! ( false ) )
      {
         chkavCliupdrelhab.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavCliupdrelhab.getInternalname(), "Visible", GXutil.ltrimstr( chkavCliupdrelhab.getVisible(), 5, 0), true);
         GXv_SdtWWPGridState14[0] = AV12GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState14, "CLIUPDRELHAB", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV12GridState = GXv_SdtWWPGridState14[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV68Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      GXv_SdtWWPColumnsSelector15[0] = AV19ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV36CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void e15KE2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV50WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV48MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV52textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV36CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         cliente_updateww_impl.this.AV52textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV52textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV48MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table2_99_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_actualizar_Internalname, tblTabledvelop_confirmpanel_actualizar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_actualizar.setProperty("Title", Dvelop_confirmpanel_actualizar_Title);
         ucDvelop_confirmpanel_actualizar.setProperty("ConfirmationText", Dvelop_confirmpanel_actualizar_Confirmationtext);
         ucDvelop_confirmpanel_actualizar.setProperty("YesButtonCaption", Dvelop_confirmpanel_actualizar_Yesbuttoncaption);
         ucDvelop_confirmpanel_actualizar.setProperty("NoButtonCaption", Dvelop_confirmpanel_actualizar_Nobuttoncaption);
         ucDvelop_confirmpanel_actualizar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_actualizar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_actualizar.setProperty("YesButtonPosition", Dvelop_confirmpanel_actualizar_Yesbuttonposition);
         ucDvelop_confirmpanel_actualizar.setProperty("ConfirmType", Dvelop_confirmpanel_actualizar_Confirmtype);
         ucDvelop_confirmpanel_actualizar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_actualizar_Internalname, "DVELOP_CONFIRMPANEL_ACTUALIZARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_ACTUALIZARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_99_KE2e( true) ;
      }
      else
      {
         wb_table2_99_KE2e( false) ;
      }
   }

   public void wb_table1_9_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table3_12_KE2( true) ;
      }
      else
      {
         wb_table3_12_KE2( false) ;
      }
      return  ;
   }

   public void wb_table3_12_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_KE2e( true) ;
      }
      else
      {
         wb_table1_9_KE2e( false) ;
      }
   }

   public void wb_table3_12_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepadding_Internalname, tblTablepadding_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e19ke1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentitem_Internalname, 1, 0, "px", 0, "px", "WelcomeContentItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentflex_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableImagenCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableimagen_Internalname, 1, 0, "px", 0, "px", "WelcomeTableImagen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Welcome Message_Foto", ""), "gx-form-item WelcomeImagenLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "WelcomeImagen" + " " + ((GXutil.strcmp(imgavWelcomemessage_foto_gximage, "")==0) ? "" : "GX_Image_"+imgavWelcomemessage_foto_gximage+"_Class") ;
         StyleString = "" ;
         AV56WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV56WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV67Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV56WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV56WelcomeMessage_Foto)==0) ? AV67Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV56WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV56WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableTextoCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletexto_Internalname, 1, 0, "px", 0, "px", "WelcomeTableTexto", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_30_KE2( true) ;
      }
      else
      {
         wb_table4_30_KE2( false) ;
      }
      return  ;
   }

   public void wb_table4_30_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table5_35_KE2( true) ;
      }
      else
      {
         wb_table5_35_KE2( false) ;
      }
      return  ;
   }

   public void wb_table5_35_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomebottomitem_Internalname, 1, 0, "px", 0, "px", "WelcomeBottomItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablecmb_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablec_Internalname, 1, 0, "px", 0, "px", "TableC font14px", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_67_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV50WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletext_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table6_54_KE2( true) ;
      }
      else
      {
         wb_table6_54_KE2( false) ;
      }
      return  ;
   }

   public void wb_table6_54_KE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridFixedTitles HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol67( ) ;
      }
      if ( wbEnd == 67 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_67 = (int)(nGXsfl_67_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV32GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV33GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV34GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_12_KE2e( true) ;
      }
      else
      {
         wb_table3_12_KE2e( false) ;
      }
   }

   public void wb_table6_54_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabletotalregistros_Internalname, tblTabletotalregistros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotal_Internalname, 1, 0, "px", 0, "px", "TotalPill ML15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Cliente_UpdateWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_54_KE2e( true) ;
      }
      else
      {
         wb_table6_54_KE2e( false) ;
      }
   }

   public void wb_table5_35_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_UpdateWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_35_KE2e( true) ;
      }
      else
      {
         wb_table5_35_KE2e( false) ;
      }
   }

   public void wb_table4_30_KE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_UpdateWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_30_KE2e( true) ;
      }
      else
      {
         wb_table4_30_KE2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV48MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48MenuOpcCod", AV48MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
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
      paKE2( ) ;
      wsKE2( ) ;
      weKE2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713274036", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("cliente_updateww.js", "?20251713274036", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_672( )
   {
      edtCliUpdRelDesc_Internalname = "CLIUPDRELDESC_"+sGXsfl_67_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_67_idx ;
      edtCliUpdCliCod_Internalname = "CLIUPDCLICOD_"+sGXsfl_67_idx ;
      edtCliUpdRelSec_Internalname = "CLIUPDRELSEC_"+sGXsfl_67_idx ;
      edtavClinom_Internalname = "vCLINOM_"+sGXsfl_67_idx ;
      edtavClireobs_Internalname = "vCLIREOBS_"+sGXsfl_67_idx ;
      edtCliUpdDTApl_Internalname = "CLIUPDDTAPL_"+sGXsfl_67_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_67_idx ;
      edtavActualizar_Internalname = "vACTUALIZAR_"+sGXsfl_67_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_67_idx ;
   }

   public void subsflControlProps_fel_672( )
   {
      edtCliUpdRelDesc_Internalname = "CLIUPDRELDESC_"+sGXsfl_67_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_67_fel_idx ;
      edtCliUpdCliCod_Internalname = "CLIUPDCLICOD_"+sGXsfl_67_fel_idx ;
      edtCliUpdRelSec_Internalname = "CLIUPDRELSEC_"+sGXsfl_67_fel_idx ;
      edtavClinom_Internalname = "vCLINOM_"+sGXsfl_67_fel_idx ;
      edtavClireobs_Internalname = "vCLIREOBS_"+sGXsfl_67_fel_idx ;
      edtCliUpdDTApl_Internalname = "CLIUPDDTAPL_"+sGXsfl_67_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_67_fel_idx ;
      edtavActualizar_Internalname = "vACTUALIZAR_"+sGXsfl_67_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_67_fel_idx ;
   }

   public void sendrow_672( )
   {
      subsflControlProps_672( ) ;
      wbKE0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_67_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_67_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_67_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliUpdRelDesc_Internalname,A1884CliUpdRelDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliUpdRelDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliUpdCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1881CliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1881CliUpdCliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliUpdCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliUpdRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1887CliUpdRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1887CliUpdRelSec), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliUpdRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClinom_Enabled!=0)&&(edtavClinom_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 72,'',false,'"+sGXsfl_67_idx+"',67)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClinom_Internalname,AV44CliNom,GXutil.rtrim( localUtil.format( AV44CliNom, "@!")),TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+((edtavClinom_Enabled!=0)&&(edtavClinom_Visible!=0) ? " onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,72);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClinom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavClinom_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClireobs_Enabled!=0)&&(edtavClireobs_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 73,'',false,'"+sGXsfl_67_idx+"',67)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClireobs_Internalname,AV45CliReObs,AV45CliReObs,TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavClireobs_Enabled!=0)&&(edtavClireobs_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,73);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClireobs_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavClireobs_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliUpdDTApl_Internalname,localUtil.ttoc( A1883CliUpdDTApl, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( A1883CliUpdDTApl, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliUpdDTApl_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 75,'',false,'"+sGXsfl_67_idx+"',67)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV47Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,75);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavActualizar_Enabled!=0)&&(edtavActualizar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 76,'',false,'"+sGXsfl_67_idx+"',67)\"" : " ") ;
         ROClassString = edtavActualizar_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavActualizar_Internalname,GXutil.rtrim( AV35Actualizar),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavActualizar_Enabled!=0)&&(edtavActualizar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,76);\"" : " "),"'"+""+"'"+",false,"+"'"+"e20ke2_client"+"'","","","","",edtavActualizar_Jsonclick,Integer.valueOf(7),edtavActualizar_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavActualizar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 77,'',false,'"+sGXsfl_67_idx+"',67)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV46VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,77);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(-1),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesKE2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_67_idx = ((subGrid_Islastpage==1)&&(nGXsfl_67_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
      }
      /* End function sendrow_672 */
   }

   public void startgridcontrol67( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"67\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Actualización", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "de release", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Rel Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Origen", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de aplicación de la actualización", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavActualizar_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
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
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1884CliUpdRelDesc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1881CliUpdCliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1887CliUpdRelSec, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV44CliNom);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClinom_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV45CliReObs);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClireobs_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.ttoc( A1883CliUpdDTApl, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV47Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV35Actualizar));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavActualizar_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavActualizar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV46VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
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
      lblWelcomemessage_closehelp_Internalname = "WELCOMEMESSAGE_CLOSEHELP" ;
      divWelcomemessage_tableclose_Internalname = "WELCOMEMESSAGE_TABLECLOSE" ;
      divWelcomemessage_welcometableprincipal_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL" ;
      imgavWelcomemessage_foto_Internalname = "vWELCOMEMESSAGE_FOTO" ;
      divWelcomemessage_welcometableimagen_Internalname = "WELCOMEMESSAGE_WELCOMETABLEIMAGEN" ;
      lblWelcomemessage_titulo_Internalname = "WELCOMEMESSAGE_TITULO" ;
      tblWelcomemessage_tabletitulo_Internalname = "WELCOMEMESSAGE_TABLETITULO" ;
      lblWelcomemessage_descripcion_Internalname = "WELCOMEMESSAGE_DESCRIPCION" ;
      tblWelcomemessage_tabledescripcion_Internalname = "WELCOMEMESSAGE_TABLEDESCRIPCION" ;
      divWelcomemessage_tabletexto_Internalname = "WELCOMEMESSAGE_TABLETEXTO" ;
      divWelcomemessage_welcomecontentflex_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTFLEX" ;
      divWelcomemessage_welcomecontentitem_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTITEM" ;
      chkavWelcomemessage_nomostrarmas.setInternalname( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      divWelcomemessage_tablec_Internalname = "WELCOMEMESSAGE_TABLEC" ;
      lblWelcomemessage_combotext_Internalname = "WELCOMEMESSAGE_COMBOTEXT" ;
      divWelcomemessage_tabletext_Internalname = "WELCOMEMESSAGE_TABLETEXT" ;
      divWelcomemessage_tablecmb_Internalname = "WELCOMEMESSAGE_TABLECMB" ;
      divWelcomemessage_welcomebottomitem_Internalname = "WELCOMEMESSAGE_WELCOMEBOTTOMITEM" ;
      divWelcomemessage_welcometableparent_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPARENT" ;
      lblTotaltext_Internalname = "TOTALTEXT" ;
      lblCouttext_Internalname = "COUTTEXT" ;
      divTabletotal_Internalname = "TABLETOTAL" ;
      tblTabletotalregistros_Internalname = "TABLETOTALREGISTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtCliUpdRelDesc_Internalname = "CLIUPDRELDESC" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliUpdCliCod_Internalname = "CLIUPDCLICOD" ;
      edtCliUpdRelSec_Internalname = "CLIUPDRELSEC" ;
      edtavClinom_Internalname = "vCLINOM" ;
      edtavClireobs_Internalname = "vCLIREOBS" ;
      edtCliUpdDTApl_Internalname = "CLIUPDDTAPL" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavActualizar_Internalname = "vACTUALIZAR" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      edtavCliupdfecrel_Internalname = "vCLIUPDFECREL" ;
      chkavCliupdrelhab.setInternalname( "vCLIUPDRELHAB" );
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      edtavAhora_Internalname = "vAHORA" ;
      Dvelop_confirmpanel_actualizar_Internalname = "DVELOP_CONFIRMPANEL_ACTUALIZAR" ;
      tblTabledvelop_confirmpanel_actualizar_Internalname = "TABLEDVELOP_CONFIRMPANEL_ACTUALIZAR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_cliupddtaplauxdatetext_Internalname = "vDDO_CLIUPDDTAPLAUXDATETEXT" ;
      Tfcliupddtapl_rangepicker_Internalname = "TFCLIUPDDTAPL_RANGEPICKER" ;
      divDdo_cliupddtaplauxdates_Internalname = "DDO_CLIUPDDTAPLAUXDATES" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Visible = -1 ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavActualizar_Jsonclick = "" ;
      edtavActualizar_Class = "Attribute" ;
      edtavActualizar_Visible = -1 ;
      edtavActualizar_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtavDisplay_Visible = -1 ;
      edtCliUpdDTApl_Jsonclick = "" ;
      edtavClireobs_Jsonclick = "" ;
      edtavClireobs_Visible = -1 ;
      edtavClireobs_Enabled = 1 ;
      edtavClinom_Jsonclick = "" ;
      edtavClinom_Visible = -1 ;
      edtavClinom_Enabled = 1 ;
      edtCliUpdRelSec_Jsonclick = "" ;
      edtCliUpdCliCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliUpdRelDesc_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavDisplay_Link = "" ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_cliupddtaplauxdatetext_Jsonclick = "" ;
      edtavAhora_Jsonclick = "" ;
      edtavAhora_Visible = 1 ;
      chkavCliupdrelhab.setEnabled( 1 );
      chkavCliupdrelhab.setVisible( 1 );
      edtavCliupdfecrel_Jsonclick = "" ;
      edtavCliupdfecrel_Enabled = 1 ;
      edtavCliupdfecrel_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Dvelop_confirmpanel_actualizar_Confirmtype = "1" ;
      Dvelop_confirmpanel_actualizar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_actualizar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_actualizar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_actualizar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_actualizar_Confirmationtext = "¿Confirma aplicar la actualización?" ;
      Dvelop_confirmpanel_actualizar_Title = httpContext.getMessage( "Confirmar actualización", "") ;
      Ddo_grid_Datalistproc = "Cliente_UpdateWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "T|" ;
      Ddo_grid_Datalisttype = "Dynamic|" ;
      Ddo_grid_Includedatalist = "T|" ;
      Ddo_grid_Filterisrange = "|P" ;
      Ddo_grid_Filtertype = "Character|Date" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3" ;
      Ddo_grid_Columnids = "0:CliUpdRelDesc|6:CliUpdDTApl" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Actualizaciones", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavWelcomemessage_nomostrarmas.setName( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      chkavWelcomemessage_nomostrarmas.setWebtags( "" );
      chkavWelcomemessage_nomostrarmas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "TitleCaption", chkavWelcomemessage_nomostrarmas.getCaption(), true);
      chkavWelcomemessage_nomostrarmas.setCheckedValue( "false" );
      AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV50WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50WelcomeMessage_NoMostrarMas", AV50WelcomeMessage_NoMostrarMas);
      chkavCliupdrelhab.setName( "vCLIUPDRELHAB" );
      chkavCliupdrelhab.setWebtags( "" );
      chkavCliupdrelhab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCliupdrelhab.getInternalname(), "TitleCaption", chkavCliupdrelhab.getCaption(), true);
      chkavCliupdrelhab.setCheckedValue( "false" );
      AV59CliUpdRelHab = GXutil.strtobool( GXutil.booltostr( AV59CliUpdRelHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliUpdRelHab", AV59CliUpdRelHab);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV58ahora',fld:'vAHORA',pic:'99/99/99 99:99:99.999'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV68Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliUpdFecRel',fld:'vCLIUPDFECREL',pic:'99/99/99 99:99'},{av:'AV59CliUpdRelHab',fld:'vCLIUPDRELHAB',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV32GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV33GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV34GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11KE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV58ahora',fld:'vAHORA',pic:'99/99/99 99:99:99.999'},{av:'AV68Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliUpdFecRel',fld:'vCLIUPDFECREL',pic:'99/99/99 99:99'},{av:'AV59CliUpdRelHab',fld:'vCLIUPDRELHAB',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12KE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV58ahora',fld:'vAHORA',pic:'99/99/99 99:99:99.999'},{av:'AV68Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliUpdFecRel',fld:'vCLIUPDFECREL',pic:'99/99/99 99:99'},{av:'AV59CliUpdRelHab',fld:'vCLIUPDRELHAB',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13KE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV58ahora',fld:'vAHORA',pic:'99/99/99 99:99:99.999'},{av:'AV68Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliUpdFecRel',fld:'vCLIUPDFECREL',pic:'99/99/99 99:99'},{av:'AV59CliUpdRelHab',fld:'vCLIUPDRELHAB',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV22TFCliUpdRelDesc_SelsJson',fld:'vTFCLIUPDRELDESC_SELSJSON',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e18KE2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1881CliUpdCliCod',fld:'CLIUPDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1887CliUpdRelSec',fld:'CLIUPDRELSEC',pic:'ZZZZZ9',hsh:true},{av:'A1883CliUpdDTApl',fld:'CLIUPDDTAPL',pic:'99/99/99 99:99'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV47Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV35Actualizar',fld:'vACTUALIZAR',pic:''},{av:'edtavActualizar_Class',ctrl:'vACTUALIZAR',prop:'Class'},{av:'AV44CliNom',fld:'vCLINOM',pic:'@!'},{av:'AV45CliReObs',fld:'vCLIREOBS',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV46VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("VACTUALIZAR.CLICK","{handler:'e20KE2',iparms:[{av:'A1881CliUpdCliCod',fld:'CLIUPDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1887CliUpdRelSec',fld:'CLIUPDRELSEC',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VACTUALIZAR.CLICK",",oparms:[{av:'AV41CliUpdCliCod_Selected',fld:'vCLIUPDCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV42CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV43CliUpdRelSec_Selected',fld:'vCLIUPDRELSEC_SELECTED',pic:'ZZZZZ9'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ACTUALIZAR.CLOSE","{handler:'e14KE2',iparms:[{av:'Dvelop_confirmpanel_actualizar_Result',ctrl:'DVELOP_CONFIRMPANEL_ACTUALIZAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV58ahora',fld:'vAHORA',pic:'99/99/99 99:99:99.999'},{av:'AV68Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliUpdFecRel',fld:'vCLIUPDFECREL',pic:'99/99/99 99:99'},{av:'AV59CliUpdRelHab',fld:'vCLIUPDRELHAB',pic:''},{av:'AV23TFCliUpdRelDesc',fld:'vTFCLIUPDRELDESC',pic:''},{av:'AV24TFCliUpdRelDesc_Sels',fld:'vTFCLIUPDRELDESC_SELS',pic:''},{av:'AV25TFCliUpdDTApl',fld:'vTFCLIUPDDTAPL',pic:'99/99/99 99:99'},{av:'AV26TFCliUpdDTApl_To',fld:'vTFCLIUPDDTAPL_TO',pic:'99/99/99 99:99'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV41CliUpdCliCod_Selected',fld:'vCLIUPDCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV42CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV43CliUpdRelSec_Selected',fld:'vCLIUPDRELSEC_SELECTED',pic:'ZZZZZ9'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ACTUALIZAR.CLOSE",",oparms:[{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV32GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV33GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV34GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e15KE2',iparms:[{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV36CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e19KE1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLIUPDCLICOD","{handler:'valid_Cliupdclicod',iparms:[]");
      setEventMetadata("VALID_CLIUPDCLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIUPDRELSEC","{handler:'valid_Cliupdrelsec',iparms:[]");
      setEventMetadata("VALID_CLIUPDRELSEC",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Versvg',iparms:[]");
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
      wcpOAV48MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Dvelop_confirmpanel_actualizar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV48MenuOpcCod = "" ;
      AV58ahora = GXutil.resetTime( GXutil.nullDate() );
      AV68Pgmname = "" ;
      AV57CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      AV23TFCliUpdRelDesc = "" ;
      AV24TFCliUpdRelDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFCliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      AV26TFCliUpdDTApl_To = GXutil.resetTime( GXutil.nullDate() );
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV34GridAppliedFilters = "" ;
      AV30DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV27DDO_CliUpdDTAplAuxDate = GXutil.nullDate() ;
      AV28DDO_CliUpdDTAplAuxDateTo = GXutil.nullDate() ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV29DDO_CliUpdDTAplAuxDateText = "" ;
      ucTfcliupddtapl_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1884CliUpdRelDesc = "" ;
      AV44CliNom = "" ;
      AV45CliReObs = "" ;
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      AV47Display = "" ;
      AV35Actualizar = "" ;
      AV46VerSVG = "" ;
      AV72Cliente_updatewwds_4_tfcliupdreldesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV71Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      AV71Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      AV73Cliente_updatewwds_5_tfcliupddtapl = GXutil.resetTime( GXutil.nullDate() );
      AV74Cliente_updatewwds_6_tfcliupddtapl_to = GXutil.resetTime( GXutil.nullDate() );
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      H00KE2_A1964CliUpdRelHab = new boolean[] {false} ;
      H00KE2_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      H00KE2_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      H00KE2_A1887CliUpdRelSec = new int[1] ;
      H00KE2_A1881CliUpdCliCod = new int[1] ;
      H00KE2_A3CliCod = new int[1] ;
      H00KE2_A1884CliUpdRelDesc = new String[] {""} ;
      AV69Cliente_updatewwds_1_cliupdfecrel = GXutil.resetTime( GXutil.nullDate() );
      H00KE3_AGRID_nRecordCount = new long[1] ;
      AV56WelcomeMessage_Foto = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV51MenuBienveImgURL = "" ;
      GXv_char5 = new String[1] ;
      AV53MenuBienveTitulo = "" ;
      AV54MenuBienveTexto = "" ;
      AV67Welcomemessage_foto_GXI = "" ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXt_dtime11 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime12 = new java.util.Date[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV64MenuOpcTitulo = "" ;
      AV22TFCliUpdRelDesc_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV21Session = httpContext.getWebSession();
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXv_SdtWWPGridState14 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV52textoNoMostrara = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      ucDvelop_confirmpanel_actualizar = new com.genexus.webpanels.GXUserControl();
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_updateww__default(),
         new Object[] {
             new Object[] {
            H00KE2_A1964CliUpdRelHab, H00KE2_A1962CliUpdFecRel, H00KE2_A1883CliUpdDTApl, H00KE2_A1887CliUpdRelSec, H00KE2_A1881CliUpdCliCod, H00KE2_A3CliCod, H00KE2_A1884CliUpdRelDesc
            }
            , new Object[] {
            H00KE3_AGRID_nRecordCount
            }
         }
      );
      AV68Pgmname = "Cliente_UpdateWW" ;
      /* GeneXus formulas. */
      AV68Pgmname = "Cliente_UpdateWW" ;
      Gx_err = (short)(0) ;
      edtavClinom_Enabled = 0 ;
      edtavClireobs_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavActualizar_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
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
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short edtavVersvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_67 ;
   private int nGXsfl_67_idx=1 ;
   private int AV36CliCod ;
   private int AV41CliUpdCliCod_Selected ;
   private int AV42CliCod_Selected ;
   private int AV43CliUpdRelSec_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtavCliupdfecrel_Visible ;
   private int edtavCliupdfecrel_Enabled ;
   private int edtavAhora_Visible ;
   private int A3CliCod ;
   private int A1881CliUpdCliCod ;
   private int A1887CliUpdRelSec ;
   private int subGrid_Islastpage ;
   private int edtavClinom_Enabled ;
   private int edtavClireobs_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavActualizar_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int lblCouttext_Visible ;
   private int AV31PageToGo ;
   private int edtavDisplay_Visible ;
   private int AV75GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavClinom_Visible ;
   private int edtavClireobs_Visible ;
   private int edtavActualizar_Visible ;
   private int edtavVersvg_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV32GridCurrentPage ;
   private long AV33GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Dvelop_confirmpanel_actualizar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_67_idx="0001" ;
   private String AV68Pgmname ;
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
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistproc ;
   private String Dvelop_confirmpanel_actualizar_Title ;
   private String Dvelop_confirmpanel_actualizar_Confirmationtext ;
   private String Dvelop_confirmpanel_actualizar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_actualizar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_actualizar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_actualizar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_actualizar_Confirmtype ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtavCliupdfecrel_Internalname ;
   private String TempTags ;
   private String edtavCliupdfecrel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtavAhora_Internalname ;
   private String edtavAhora_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_cliupddtaplauxdates_Internalname ;
   private String edtavDdo_cliupddtaplauxdatetext_Internalname ;
   private String edtavDdo_cliupddtaplauxdatetext_Jsonclick ;
   private String Tfcliupddtapl_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliUpdRelDesc_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliUpdCliCod_Internalname ;
   private String edtCliUpdRelSec_Internalname ;
   private String edtavClinom_Internalname ;
   private String edtavClireobs_Internalname ;
   private String edtCliUpdDTApl_Internalname ;
   private String AV47Display ;
   private String edtavDisplay_Internalname ;
   private String AV35Actualizar ;
   private String edtavActualizar_Internalname ;
   private String AV46VerSVG ;
   private String edtavVersvg_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char5[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String edtavDisplay_Link ;
   private String edtavActualizar_Class ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String GXt_char10 ;
   private String GXv_char7[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTabledvelop_confirmpanel_actualizar_Internalname ;
   private String Dvelop_confirmpanel_actualizar_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String tblTablepadding_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String imgavWelcomemessage_foto_gximage ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_67_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliUpdRelDesc_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtCliUpdCliCod_Jsonclick ;
   private String edtCliUpdRelSec_Jsonclick ;
   private String edtavClinom_Jsonclick ;
   private String edtavClireobs_Jsonclick ;
   private String edtCliUpdDTApl_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavActualizar_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV58ahora ;
   private java.util.Date AV57CliUpdFecRel ;
   private java.util.Date AV25TFCliUpdDTApl ;
   private java.util.Date AV26TFCliUpdDTApl_To ;
   private java.util.Date A1883CliUpdDTApl ;
   private java.util.Date AV73Cliente_updatewwds_5_tfcliupddtapl ;
   private java.util.Date AV74Cliente_updatewwds_6_tfcliupddtapl_to ;
   private java.util.Date A1962CliUpdFecRel ;
   private java.util.Date AV69Cliente_updatewwds_1_cliupdfecrel ;
   private java.util.Date GXt_dtime11 ;
   private java.util.Date GXv_dtime12[] ;
   private java.util.Date AV27DDO_CliUpdDTAplAuxDate ;
   private java.util.Date AV28DDO_CliUpdDTAplAuxDateTo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV59CliUpdRelHab ;
   private boolean AV15OrderedDsc ;
   private boolean AV50WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_67_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean A1964CliUpdRelHab ;
   private boolean AV70Cliente_updatewwds_2_cliupdrelhab ;
   private boolean returnInSub ;
   private boolean AV55MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean GXv_boolean8[] ;
   private boolean AV56WelcomeMessage_Foto_IsBlob ;
   private String AV45CliReObs ;
   private String AV54MenuBienveTexto ;
   private String AV22TFCliUpdRelDesc_SelsJson ;
   private String AV52textoNoMostrara ;
   private String wcpOAV48MenuOpcCod ;
   private String AV48MenuOpcCod ;
   private String AV23TFCliUpdRelDesc ;
   private String AV34GridAppliedFilters ;
   private String AV29DDO_CliUpdDTAplAuxDateText ;
   private String A1884CliUpdRelDesc ;
   private String AV44CliNom ;
   private String lV71Cliente_updatewwds_3_tfcliupdreldesc ;
   private String AV71Cliente_updatewwds_3_tfcliupdreldesc ;
   private String AV51MenuBienveImgURL ;
   private String AV53MenuBienveTitulo ;
   private String AV67Welcomemessage_foto_GXI ;
   private String AV64MenuOpcTitulo ;
   private String AV56WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfcliupddtapl_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_actualizar ;
   private GXSimpleCollection<String> AV72Cliente_updatewwds_4_tfcliupdreldesc_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkavCliupdrelhab ;
   private IDataStoreProvider pr_default ;
   private boolean[] H00KE2_A1964CliUpdRelHab ;
   private java.util.Date[] H00KE2_A1962CliUpdFecRel ;
   private java.util.Date[] H00KE2_A1883CliUpdDTApl ;
   private int[] H00KE2_A1887CliUpdRelSec ;
   private int[] H00KE2_A1881CliUpdCliCod ;
   private int[] H00KE2_A3CliCod ;
   private String[] H00KE2_A1884CliUpdRelDesc ;
   private long[] H00KE3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV24TFCliUpdRelDesc_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState14[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV30DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class cliente_updateww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00KE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1884CliUpdRelDesc ,
                                          GXSimpleCollection<String> AV72Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                          int AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size ,
                                          String AV71Cliente_updatewwds_3_tfcliupdreldesc ,
                                          java.util.Date AV73Cliente_updatewwds_5_tfcliupddtapl ,
                                          java.util.Date AV74Cliente_updatewwds_6_tfcliupddtapl_to ,
                                          java.util.Date A1883CliUpdDTApl ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          java.util.Date AV58ahora ,
                                          java.util.Date A1962CliUpdFecRel ,
                                          boolean A1964CliUpdRelHab ,
                                          int AV36CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[8];
      Object[] GXv_Object17 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.CliReHabilitado AS CliUpdRelHab, T1.CliUpdFecRel AS CliUpdFecRel, T1.CliUpdDTApl, T1.CliUpdRelSec AS CliUpdRelSec, T1.CliUpdCliCod AS CliUpdCliCod, T1.CliCod," ;
      sSelectString += " T1.CliUpdRelDesc" ;
      sFromString = " FROM (Cliente_Update T1 INNER JOIN Cliente_Release T2 ON T2.CliCod = T1.CliUpdCliCod AND T2.CliRelSec = T1.CliUpdRelSec)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(? >= T1.CliUpdFecRel)");
      addWhere(sWhereString, "(T2.CliReHabilitado = TRUE)");
      if ( ( AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Cliente_updatewwds_3_tfcliupdreldesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliUpdRelDesc) like LOWER(?))");
      }
      else
      {
         GXv_int16[2] = (byte)(1) ;
      }
      if ( AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Cliente_updatewwds_4_tfcliupdreldesc_sels, "T1.CliUpdRelDesc IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV73Cliente_updatewwds_5_tfcliupddtapl) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl >= ?)");
      }
      else
      {
         GXv_int16[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV74Cliente_updatewwds_6_tfcliupddtapl_to) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl <= ?)");
      }
      else
      {
         GXv_int16[4] = (byte)(1) ;
      }
      if ( AV14OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliUpdFecRel DESC, T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliUpdRelDesc, T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliUpdRelDesc DESC, T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliUpdDTApl, T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliUpdDTApl DESC, T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.CliUpdCliCod, T1.CliUpdRelSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_H00KE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1884CliUpdRelDesc ,
                                          GXSimpleCollection<String> AV72Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                          int AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size ,
                                          String AV71Cliente_updatewwds_3_tfcliupdreldesc ,
                                          java.util.Date AV73Cliente_updatewwds_5_tfcliupddtapl ,
                                          java.util.Date AV74Cliente_updatewwds_6_tfcliupddtapl_to ,
                                          java.util.Date A1883CliUpdDTApl ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          java.util.Date AV58ahora ,
                                          java.util.Date A1962CliUpdFecRel ,
                                          boolean A1964CliUpdRelHab ,
                                          int AV36CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[5];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (Cliente_Update T1 INNER JOIN Cliente_Release T2 ON T2.CliCod = T1.CliUpdCliCod AND T2.CliRelSec = T1.CliUpdRelSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(? >= T1.CliUpdFecRel)");
      addWhere(sWhereString, "(T2.CliReHabilitado = TRUE)");
      if ( ( AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Cliente_updatewwds_3_tfcliupdreldesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliUpdRelDesc) like LOWER(?))");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( AV72Cliente_updatewwds_4_tfcliupdreldesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Cliente_updatewwds_4_tfcliupdreldesc_sels, "T1.CliUpdRelDesc IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV73Cliente_updatewwds_5_tfcliupddtapl) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl >= ?)");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV74Cliente_updatewwds_6_tfcliupddtapl_to) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl <= ?)");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV14OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
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
                  return conditional_H00KE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
            case 1 :
                  return conditional_H00KE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false, true);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[11], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[12], false);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[6], false, true);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[8], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               return;
      }
   }

}

