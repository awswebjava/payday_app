package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class soap_locationww_impl extends GXDataArea
{
   public soap_locationww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public soap_locationww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( soap_locationww_impl.class ));
   }

   public soap_locationww_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkSoapLocHab = UIFactory.getCheckbox(this);
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
            AV58MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58MenuOpcCod", AV58MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV58MenuOpcCod, ""))));
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
      nRC_GXsfl_110 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_110"))) ;
      nGXsfl_110_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_110_idx"))) ;
      sGXsfl_110_idx = httpContext.GetPar( "sGXsfl_110_idx") ;
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
      AV66ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20ColumnsSelector);
      AV87Pgmname = httpContext.GetPar( "Pgmname") ;
      AV58MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11GridState);
      AV67TFCliCod = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod"))) ;
      AV68TFCliCod_To = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod_To"))) ;
      AV24TFSoapLocId = httpContext.GetPar( "TFSoapLocId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV25TFSoapLocId_Sels);
      AV26TFSoapLocHab_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFSoapLocHab_Sel"))) ;
      AV28TFSoapLocBaseUrl = httpContext.GetPar( "TFSoapLocBaseUrl") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFSoapLocBaseUrl_Sels);
      AV30TFSoapLocCancelOnError = (byte)(GXutil.lval( httpContext.GetPar( "TFSoapLocCancelOnError"))) ;
      AV31TFSoapLocCancelOnError_To = (byte)(GXutil.lval( httpContext.GetPar( "TFSoapLocCancelOnError_To"))) ;
      AV33TFSoapLocHost = httpContext.GetPar( "TFSoapLocHost") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34TFSoapLocHost_Sels);
      AV35TFSoapLocPort = (int)(GXutil.lval( httpContext.GetPar( "TFSoapLocPort"))) ;
      AV36TFSoapLocPort_To = (int)(GXutil.lval( httpContext.GetPar( "TFSoapLocPort_To"))) ;
      AV38TFSoapLocResourceName = httpContext.GetPar( "TFSoapLocResourceName") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV39TFSoapLocResourceName_Sels);
      AV40TFSoapLocSecure = (byte)(GXutil.lval( httpContext.GetPar( "TFSoapLocSecure"))) ;
      AV41TFSoapLocSecure_To = (byte)(GXutil.lval( httpContext.GetPar( "TFSoapLocSecure_To"))) ;
      AV42TFSoapLocTimeout = (short)(GXutil.lval( httpContext.GetPar( "TFSoapLocTimeout"))) ;
      AV43TFSoapLocTimeout_To = (short)(GXutil.lval( httpContext.GetPar( "TFSoapLocTimeout_To"))) ;
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV56CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV50IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV52IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV62WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
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
      paOL2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startOL2( ) ;
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
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.soap_locationww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV58MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV56CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_110", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_110, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV20ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV20ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV46GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV47GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV48GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV66ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV58MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV58MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD", GXutil.ltrim( localUtil.ntoc( AV67TFCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD_TO", GXutil.ltrim( localUtil.ntoc( AV68TFCliCod_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCID", GXutil.rtrim( AV24TFSoapLocId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSOAPLOCID_SELS", AV25TFSoapLocId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSOAPLOCID_SELS", AV25TFSoapLocId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCHAB_SEL", GXutil.ltrim( localUtil.ntoc( AV26TFSoapLocHab_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCBASEURL", AV28TFSoapLocBaseUrl);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSOAPLOCBASEURL_SELS", AV29TFSoapLocBaseUrl_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSOAPLOCBASEURL_SELS", AV29TFSoapLocBaseUrl_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCCANCELONERROR", GXutil.ltrim( localUtil.ntoc( AV30TFSoapLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCCANCELONERROR_TO", GXutil.ltrim( localUtil.ntoc( AV31TFSoapLocCancelOnError_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCHOST", AV33TFSoapLocHost);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSOAPLOCHOST_SELS", AV34TFSoapLocHost_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSOAPLOCHOST_SELS", AV34TFSoapLocHost_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCPORT", GXutil.ltrim( localUtil.ntoc( AV35TFSoapLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCPORT_TO", GXutil.ltrim( localUtil.ntoc( AV36TFSoapLocPort_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCRESOURCENAME", AV38TFSoapLocResourceName);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSOAPLOCRESOURCENAME_SELS", AV39TFSoapLocResourceName_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSOAPLOCRESOURCENAME_SELS", AV39TFSoapLocResourceName_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCSECURE", GXutil.ltrim( localUtil.ntoc( AV40TFSoapLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCSECURE_TO", GXutil.ltrim( localUtil.ntoc( AV41TFSoapLocSecure_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCTIMEOUT", GXutil.ltrim( localUtil.ntoc( AV42TFSoapLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCTIMEOUT_TO", GXutil.ltrim( localUtil.ntoc( AV43TFSoapLocTimeout_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV56CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV56CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV50IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCID_SELSJSON", AV23TFSoapLocId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCBASEURL_SELSJSON", AV27TFSoapLocBaseUrl_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCHOST_SELSJSON", AV32TFSoapLocHost_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSOAPLOCRESOURCENAME_SELSJSON", AV37TFSoapLocResourceName_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Observer", GXutil.rtrim( Buttonexport1_a3lexport_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_clon_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_orig_id));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Observer", GXutil.rtrim( Buttonfilter1_a3lfilter_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_A3l_filter_id", GXutil.rtrim( Buttonfilter1_a3lfilter_A3l_filter_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Filter_orig", GXutil.rtrim( Buttonfilter1_a3lfilter_Filter_orig));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         weOL2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtOL2( ) ;
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
      return formatLink("web.soap_locationww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "soap_locationWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " soap_location", "") ;
   }

   public void wbOL0( )
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
         wb_table1_9_OL2( true) ;
      }
      else
      {
         wb_table1_9_OL2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_OL2e( boolean wbgen )
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
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV44DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 110 )
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

   public void startOL2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " soap_location", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupOL0( ) ;
   }

   public void wsOL2( )
   {
      startOL2( ) ;
      evtOL2( ) ;
   }

   public void evtOL2( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17OL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18OL2 ();
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
                           nGXsfl_110_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1102( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2162SoapLocId = httpContext.cgiGet( edtSoapLocId_Internalname) ;
                           A2163SoapLocHab = GXutil.strtobool( httpContext.cgiGet( chkSoapLocHab.getInternalname())) ;
                           A2164SoapLocBaseUrl = httpContext.cgiGet( edtSoapLocBaseUrl_Internalname) ;
                           A2165SoapLocCancelOnError = (byte)(localUtil.ctol( httpContext.cgiGet( edtSoapLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2166SoapLocHost = httpContext.cgiGet( edtSoapLocHost_Internalname) ;
                           A2167SoapLocPort = (int)(localUtil.ctol( httpContext.cgiGet( edtSoapLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2168SoapLocResourceName = httpContext.cgiGet( edtSoapLocResourceName_Internalname) ;
                           A2169SoapLocSecure = (byte)(localUtil.ctol( httpContext.cgiGet( edtSoapLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2170SoapLocTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtSoapLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV49Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV49Update);
                           AV51Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
                           AV69Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV69Display);
                           AV59VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV59VerSVG);
                           AV60ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV60ModificarSVG);
                           AV61EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV61EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19OL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20OL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21OL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
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

   public void weOL2( )
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

   public void paOL2( )
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
      subsflControlProps_1102( ) ;
      while ( nGXsfl_110_idx <= nRC_GXsfl_110 )
      {
         sendrow_1102( ) ;
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV66ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ,
                                 String AV87Pgmname ,
                                 String AV58MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV11GridState ,
                                 int AV67TFCliCod ,
                                 int AV68TFCliCod_To ,
                                 String AV24TFSoapLocId ,
                                 GXSimpleCollection<String> AV25TFSoapLocId_Sels ,
                                 byte AV26TFSoapLocHab_Sel ,
                                 String AV28TFSoapLocBaseUrl ,
                                 GXSimpleCollection<String> AV29TFSoapLocBaseUrl_Sels ,
                                 byte AV30TFSoapLocCancelOnError ,
                                 byte AV31TFSoapLocCancelOnError_To ,
                                 String AV33TFSoapLocHost ,
                                 GXSimpleCollection<String> AV34TFSoapLocHost_Sels ,
                                 int AV35TFSoapLocPort ,
                                 int AV36TFSoapLocPort_To ,
                                 String AV38TFSoapLocResourceName ,
                                 GXSimpleCollection<String> AV39TFSoapLocResourceName_Sels ,
                                 byte AV40TFSoapLocSecure ,
                                 byte AV41TFSoapLocSecure_To ,
                                 short AV42TFSoapLocTimeout ,
                                 short AV43TFSoapLocTimeout_To ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 int AV56CliCod ,
                                 boolean AV50IsAuthorized_Update ,
                                 boolean AV52IsAuthorized_Delete ,
                                 boolean AV62WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20OL2 ();
      GRID_nCurrentRecord = 0 ;
      rfOL2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SOAPLOCID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A2162SoapLocId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "SOAPLOCID", GXutil.rtrim( A2162SoapLocId));
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
      AV62WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV62WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62WelcomeMessage_NoMostrarMas", AV62WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfOL2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV87Pgmname = "soap_locationWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
   }

   public void rfOL2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e20OL2 ();
      nGXsfl_110_idx = 1 ;
      sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1102( ) ;
      bGXsfl_110_Refreshing = true ;
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
         subsflControlProps_1102( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A2162SoapLocId ,
                                              AV91Soap_locationwwds_4_tfsoaplocid_sels ,
                                              A2164SoapLocBaseUrl ,
                                              AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                              A2166SoapLocHost ,
                                              AV98Soap_locationwwds_11_tfsoaplochost_sels ,
                                              A2168SoapLocResourceName ,
                                              AV102Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                              Integer.valueOf(AV88Soap_locationwwds_1_tfclicod) ,
                                              Integer.valueOf(AV89Soap_locationwwds_2_tfclicod_to) ,
                                              Integer.valueOf(AV91Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                              AV90Soap_locationwwds_3_tfsoaplocid ,
                                              Byte.valueOf(AV92Soap_locationwwds_5_tfsoaplochab_sel) ,
                                              Integer.valueOf(AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                              AV93Soap_locationwwds_6_tfsoaplocbaseurl ,
                                              Byte.valueOf(AV95Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                              Byte.valueOf(AV96Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                              Integer.valueOf(AV98Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                              AV97Soap_locationwwds_10_tfsoaplochost ,
                                              Integer.valueOf(AV99Soap_locationwwds_12_tfsoaplocport) ,
                                              Integer.valueOf(AV100Soap_locationwwds_13_tfsoaplocport_to) ,
                                              Integer.valueOf(AV102Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                              AV101Soap_locationwwds_14_tfsoaplocresourcename ,
                                              Byte.valueOf(AV103Soap_locationwwds_16_tfsoaplocsecure) ,
                                              Byte.valueOf(AV104Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                              Short.valueOf(AV105Soap_locationwwds_18_tfsoaploctimeout) ,
                                              Short.valueOf(AV106Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Boolean.valueOf(A2163SoapLocHab) ,
                                              Byte.valueOf(A2165SoapLocCancelOnError) ,
                                              Integer.valueOf(A2167SoapLocPort) ,
                                              Byte.valueOf(A2169SoapLocSecure) ,
                                              Short.valueOf(A2170SoapLocTimeout) ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV56CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT
                                              }
         });
         lV90Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV90Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
         lV93Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV93Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
         lV97Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV97Soap_locationwwds_10_tfsoaplochost), "%", "") ;
         lV101Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV101Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
         /* Using cursor H00OL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), Integer.valueOf(AV88Soap_locationwwds_1_tfclicod), Integer.valueOf(AV89Soap_locationwwds_2_tfclicod_to), lV90Soap_locationwwds_3_tfsoaplocid, lV93Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV95Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV96Soap_locationwwds_9_tfsoaploccancelonerror_to), lV97Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV99Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV100Soap_locationwwds_13_tfsoaplocport_to), lV101Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV103Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV104Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV105Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV106Soap_locationwwds_19_tfsoaploctimeout_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2170SoapLocTimeout = H00OL2_A2170SoapLocTimeout[0] ;
            A2169SoapLocSecure = H00OL2_A2169SoapLocSecure[0] ;
            A2168SoapLocResourceName = H00OL2_A2168SoapLocResourceName[0] ;
            A2167SoapLocPort = H00OL2_A2167SoapLocPort[0] ;
            A2166SoapLocHost = H00OL2_A2166SoapLocHost[0] ;
            A2165SoapLocCancelOnError = H00OL2_A2165SoapLocCancelOnError[0] ;
            A2164SoapLocBaseUrl = H00OL2_A2164SoapLocBaseUrl[0] ;
            A2163SoapLocHab = H00OL2_A2163SoapLocHab[0] ;
            A2162SoapLocId = H00OL2_A2162SoapLocId[0] ;
            A3CliCod = H00OL2_A3CliCod[0] ;
            e21OL2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbOL0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesOL2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV58MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV58MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV56CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV56CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV50IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV52IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SOAPLOCID"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A2162SoapLocId, ""))));
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
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV91Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV98Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV102Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV88Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV89Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV91Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV90Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV92Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV93Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV95Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV96Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV98Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV97Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV99Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV100Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV102Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV101Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV103Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV104Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV105Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV106Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV56CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV90Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV90Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV93Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV93Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV97Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV97Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV101Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV101Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor H00OL3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV56CliCod), Integer.valueOf(AV88Soap_locationwwds_1_tfclicod), Integer.valueOf(AV89Soap_locationwwds_2_tfclicod_to), lV90Soap_locationwwds_3_tfsoaplocid, lV93Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV95Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV96Soap_locationwwds_9_tfsoaploccancelonerror_to), lV97Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV99Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV100Soap_locationwwds_13_tfsoaplocport_to), lV101Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV103Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV104Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV105Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV106Soap_locationwwds_19_tfsoaploctimeout_to)});
      GRID_nRecordCount = H00OL3_AGRID_nRecordCount[0] ;
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
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV66ManageFiltersExecutionStep, AV20ColumnsSelector, AV87Pgmname, AV58MenuOpcCod, AV11GridState, AV67TFCliCod, AV68TFCliCod_To, AV24TFSoapLocId, AV25TFSoapLocId_Sels, AV26TFSoapLocHab_Sel, AV28TFSoapLocBaseUrl, AV29TFSoapLocBaseUrl_Sels, AV30TFSoapLocCancelOnError, AV31TFSoapLocCancelOnError_To, AV33TFSoapLocHost, AV34TFSoapLocHost_Sels, AV35TFSoapLocPort, AV36TFSoapLocPort_To, AV38TFSoapLocResourceName, AV39TFSoapLocResourceName_Sels, AV40TFSoapLocSecure, AV41TFSoapLocSecure_To, AV42TFSoapLocTimeout, AV43TFSoapLocTimeout_To, AV13OrderedBy, AV14OrderedDsc, AV56CliCod, AV50IsAuthorized_Update, AV52IsAuthorized_Delete, AV62WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV87Pgmname = "soap_locationWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupOL0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19OL2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV44DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV20ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV64ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV46GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV47GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV48GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Buttonexport1_a3lexport_Observer = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Observer") ;
         Buttonexport1_a3lexport_Boton_clon_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id") ;
         Buttonexport1_a3lexport_Boton_orig_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Buttonfilter1_a3lfilter_Observer = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Observer") ;
         Buttonfilter1_a3lfilter_A3l_filter_id = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_A3l_filter_id") ;
         Buttonfilter1_a3lfilter_Filter_orig = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Filter_orig") ;
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
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( "DDO_GRID_Format") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV63WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV62WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62WelcomeMessage_NoMostrarMas", AV62WelcomeMessage_NoMostrarMas);
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
      e19OL2 ();
      if (returnInSub) return;
   }

   public void e19OL2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV58MenuOpcCod, "", "") ;
      GXt_int1 = AV56CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      soap_locationww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV56CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV56CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " soap_location", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV44DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV44DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV75MenuBienveImgURL ;
      GXv_char6[0] = AV77MenuBienveTitulo ;
      GXv_char7[0] = AV78MenuBienveTexto ;
      GXv_boolean8[0] = AV79MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV58MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      soap_locationww_impl.this.AV75MenuBienveImgURL = GXv_char5[0] ;
      soap_locationww_impl.this.AV77MenuBienveTitulo = GXv_char6[0] ;
      soap_locationww_impl.this.AV78MenuBienveTexto = GXv_char7[0] ;
      soap_locationww_impl.this.AV79MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV79MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV79MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV77MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV78MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV63WelcomeMessage_Foto = AV75MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV63WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV63WelcomeMessage_Foto), true);
         AV86Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV75MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV63WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV63WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      soap_locationww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV83observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV83observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV83observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV83observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e20OL2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV56CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      soap_locationww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV56CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV56CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV66ManageFiltersExecutionStep == 1 )
      {
         AV66ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66ManageFiltersExecutionStep", GXutil.str( AV66ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV66ManageFiltersExecutionStep == 2 )
      {
         AV66ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66ManageFiltersExecutionStep", GXutil.str( AV66ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV22Session.getValue("soap_locationWWColumnsSelector"), "") != 0 )
      {
         AV18ColumnsSelectorXML = AV22Session.getValue("soap_locationWWColumnsSelector") ;
         AV20ColumnsSelector.fromxml(AV18ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtCliCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocId_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkSoapLocHab.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSoapLocHab.getInternalname(), "Visible", GXutil.ltrimstr( chkSoapLocHab.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocBaseUrl_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocBaseUrl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocBaseUrl_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocCancelOnError_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocCancelOnError_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocCancelOnError_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocHost_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocHost_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocHost_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocPort_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocPort_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocPort_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocResourceName_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocResourceName_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocResourceName_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocSecure_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocSecure_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocSecure_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSoapLocTimeout_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocTimeout_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocTimeout_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV46GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GridCurrentPage), 10, 0));
      AV47GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47GridPageCount), 10, 0));
      GXt_char10 = AV48GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV87Pgmname, GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV48GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48GridAppliedFilters", AV48GridAppliedFilters);
      GXt_char10 = AV74MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV58MenuOpcCod, GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV74MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV74MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV74MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV81filterCount) ;
      GXv_char7[0] = AV82filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV11GridState, GXv_int12, GXv_char7) ;
      soap_locationww_impl.this.AV81filterCount = GXv_int12[0] ;
      soap_locationww_impl.this.AV82filtrosTexto = GXv_char7[0] ;
      if ( AV81filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV81filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV82filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV88Soap_locationwwds_1_tfclicod = AV67TFCliCod ;
      AV89Soap_locationwwds_2_tfclicod_to = AV68TFCliCod_To ;
      AV90Soap_locationwwds_3_tfsoaplocid = AV24TFSoapLocId ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = AV25TFSoapLocId_Sels ;
      AV92Soap_locationwwds_5_tfsoaplochab_sel = AV26TFSoapLocHab_Sel ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = AV28TFSoapLocBaseUrl ;
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV29TFSoapLocBaseUrl_Sels ;
      AV95Soap_locationwwds_8_tfsoaploccancelonerror = AV30TFSoapLocCancelOnError ;
      AV96Soap_locationwwds_9_tfsoaploccancelonerror_to = AV31TFSoapLocCancelOnError_To ;
      AV97Soap_locationwwds_10_tfsoaplochost = AV33TFSoapLocHost ;
      AV98Soap_locationwwds_11_tfsoaplochost_sels = AV34TFSoapLocHost_Sels ;
      AV99Soap_locationwwds_12_tfsoaplocport = AV35TFSoapLocPort ;
      AV100Soap_locationwwds_13_tfsoaplocport_to = AV36TFSoapLocPort_To ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = AV38TFSoapLocResourceName ;
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = AV39TFSoapLocResourceName_Sels ;
      AV103Soap_locationwwds_16_tfsoaplocsecure = AV40TFSoapLocSecure ;
      AV104Soap_locationwwds_17_tfsoaplocsecure_to = AV41TFSoapLocSecure_To ;
      AV105Soap_locationwwds_18_tfsoaploctimeout = AV42TFSoapLocTimeout ;
      AV106Soap_locationwwds_19_tfsoaploctimeout_to = AV43TFSoapLocTimeout_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e13OL2( )
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
         AV45PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV45PageToGo) ;
      }
   }

   public void e14OL2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15OL2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliCod") == 0 )
         {
            AV67TFCliCod = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFCliCod), 6, 0));
            AV68TFCliCod_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocId") == 0 )
         {
            AV24TFSoapLocId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFSoapLocId", AV24TFSoapLocId);
            AV23TFSoapLocId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFSoapLocId_SelsJson", AV23TFSoapLocId_SelsJson);
            AV25TFSoapLocId_Sels.fromJSonString(AV23TFSoapLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocHab") == 0 )
         {
            AV26TFSoapLocHab_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFSoapLocHab_Sel", GXutil.str( AV26TFSoapLocHab_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocBaseUrl") == 0 )
         {
            AV28TFSoapLocBaseUrl = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFSoapLocBaseUrl", AV28TFSoapLocBaseUrl);
            AV27TFSoapLocBaseUrl_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFSoapLocBaseUrl_SelsJson", AV27TFSoapLocBaseUrl_SelsJson);
            AV29TFSoapLocBaseUrl_Sels.fromJSonString(AV27TFSoapLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocCancelOnError") == 0 )
         {
            AV30TFSoapLocCancelOnError = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSoapLocCancelOnError", GXutil.str( AV30TFSoapLocCancelOnError, 1, 0));
            AV31TFSoapLocCancelOnError_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSoapLocCancelOnError_To", GXutil.str( AV31TFSoapLocCancelOnError_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocHost") == 0 )
         {
            AV33TFSoapLocHost = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSoapLocHost", AV33TFSoapLocHost);
            AV32TFSoapLocHost_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSoapLocHost_SelsJson", AV32TFSoapLocHost_SelsJson);
            AV34TFSoapLocHost_Sels.fromJSonString(AV32TFSoapLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocPort") == 0 )
         {
            AV35TFSoapLocPort = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSoapLocPort), 8, 0));
            AV36TFSoapLocPort_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSoapLocPort_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSoapLocPort_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocResourceName") == 0 )
         {
            AV38TFSoapLocResourceName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFSoapLocResourceName", AV38TFSoapLocResourceName);
            AV37TFSoapLocResourceName_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSoapLocResourceName_SelsJson", AV37TFSoapLocResourceName_SelsJson);
            AV39TFSoapLocResourceName_Sels.fromJSonString(AV37TFSoapLocResourceName_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocSecure") == 0 )
         {
            AV40TFSoapLocSecure = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFSoapLocSecure", GXutil.str( AV40TFSoapLocSecure, 1, 0));
            AV41TFSoapLocSecure_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSoapLocSecure_To", GXutil.str( AV41TFSoapLocSecure_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SoapLocTimeout") == 0 )
         {
            AV42TFSoapLocTimeout = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFSoapLocTimeout), 4, 0));
            AV43TFSoapLocTimeout_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFSoapLocTimeout_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFSoapLocTimeout_To), 4, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV39TFSoapLocResourceName_Sels", AV39TFSoapLocResourceName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFSoapLocHost_Sels", AV34TFSoapLocHost_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFSoapLocBaseUrl_Sels", AV29TFSoapLocBaseUrl_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFSoapLocId_Sels", AV25TFSoapLocId_Sels);
   }

   private void e21OL2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV49Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV49Update);
      if ( AV50IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.soap_location", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A2162SoapLocId))}, new String[] {"Mode","CliCod","SoapLocId"})  ;
      }
      AV51Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
      if ( AV52IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.soap_location", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A2162SoapLocId))}, new String[] {"Mode","CliCod","SoapLocId"})  ;
      }
      AV69Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV69Display);
      edtavDisplay_Link = formatLink("web.soap_locationview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A2162SoapLocId)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","SoapLocId","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV59VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV59VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV59VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV60ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV60ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV60ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV61EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV61EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV61EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(110) ;
      }
      sendrow_1102( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_110_Refreshing )
      {
         httpContext.doAjaxLoad(110, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11OL2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV18ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV20ColumnsSelector.fromJSonString(AV18ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "soap_locationWWColumnsSelector", ((GXutil.strcmp("", AV18ColumnsSelectorXML)==0) ? "" : AV20ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12OL2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S182 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("soap_locationWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV87Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV66ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66ManageFiltersExecutionStep", GXutil.str( AV66ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("soap_locationWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV66ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66ManageFiltersExecutionStep", GXutil.str( AV66ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV65ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "soap_locationWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV65ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV65ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV65ManageFiltersXml) ;
            AV11GridState.fromxml(AV65ManageFiltersXml, null, null);
            AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
            AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S192 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFSoapLocId_Sels", AV25TFSoapLocId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFSoapLocBaseUrl_Sels", AV29TFSoapLocBaseUrl_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34TFSoapLocHost_Sels", AV34TFSoapLocHost_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV39TFSoapLocResourceName_Sels", AV39TFSoapLocResourceName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
   }

   public void e16OL2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.soap_location", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","SoapLocId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17OL2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV16ExcelFilename ;
      GXv_char6[0] = AV17ErrorMessage ;
      new web.soap_locationwwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      soap_locationww_impl.this.AV16ExcelFilename = GXv_char7[0] ;
      soap_locationww_impl.this.AV17ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV16ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV16ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV17ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV20ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliCod", "", "Cod", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocId", "", "Loc Id", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocHab", "", "Loc Hab", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocBaseUrl", "", "Base Url", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocCancelOnError", "", "On Error", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocHost", "", "Loc Host", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocPort", "", "Loc Port", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocResourceName", "", "Resource Name", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocSecure", "", "Loc Secure", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SoapLocTimeout", "", "Loc Timeout", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV19UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "soap_locationWWColumnsSelector", GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV19UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV19UserCustomValue)==0) ) )
      {
         AV21ColumnsSelectorAux.fromxml(AV19UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV21ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV56CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV50IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Update", GXv_boolean8) ;
      soap_locationww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV50IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50IsAuthorized_Update", AV50IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV50IsAuthorized_Update));
      if ( ! ( AV50IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV52IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Delete", GXv_boolean8) ;
      soap_locationww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV52IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Delete", AV52IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV52IsAuthorized_Delete));
      if ( ! ( AV52IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV55TempBoolean ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Insert", GXv_boolean8) ;
      soap_locationww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV55TempBoolean = GXt_boolean15 ;
      if ( ! ( AV55TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV64ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "soap_locationWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV64ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV67TFCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFCliCod), 6, 0));
      AV68TFCliCod_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFCliCod_To), 6, 0));
      AV24TFSoapLocId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24TFSoapLocId", AV24TFSoapLocId);
      AV25TFSoapLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26TFSoapLocHab_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26TFSoapLocHab_Sel", GXutil.str( AV26TFSoapLocHab_Sel, 1, 0));
      AV28TFSoapLocBaseUrl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFSoapLocBaseUrl", AV28TFSoapLocBaseUrl);
      AV29TFSoapLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30TFSoapLocCancelOnError = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFSoapLocCancelOnError", GXutil.str( AV30TFSoapLocCancelOnError, 1, 0));
      AV31TFSoapLocCancelOnError_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFSoapLocCancelOnError_To", GXutil.str( AV31TFSoapLocCancelOnError_To, 1, 0));
      AV33TFSoapLocHost = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFSoapLocHost", AV33TFSoapLocHost);
      AV34TFSoapLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35TFSoapLocPort = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFSoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSoapLocPort), 8, 0));
      AV36TFSoapLocPort_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFSoapLocPort_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSoapLocPort_To), 8, 0));
      AV38TFSoapLocResourceName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFSoapLocResourceName", AV38TFSoapLocResourceName);
      AV39TFSoapLocResourceName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40TFSoapLocSecure = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFSoapLocSecure", GXutil.str( AV40TFSoapLocSecure, 1, 0));
      AV41TFSoapLocSecure_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFSoapLocSecure_To", GXutil.str( AV41TFSoapLocSecure_To, 1, 0));
      AV42TFSoapLocTimeout = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFSoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFSoapLocTimeout), 4, 0));
      AV43TFSoapLocTimeout_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFSoapLocTimeout_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFSoapLocTimeout_To), 4, 0));
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue(AV87Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV87Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV22Session.getValue(AV87Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV107GXV1 = 1 ;
      while ( AV107GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV107GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV67TFCliCod = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFCliCod), 6, 0));
            AV68TFCliCod_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID") == 0 )
         {
            AV24TFSoapLocId = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFSoapLocId", AV24TFSoapLocId);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID_SEL") == 0 )
         {
            AV23TFSoapLocId_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFSoapLocId_SelsJson", AV23TFSoapLocId_SelsJson);
            AV25TFSoapLocId_Sels.fromJSonString(AV23TFSoapLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHAB_SEL") == 0 )
         {
            AV26TFSoapLocHab_Sel = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFSoapLocHab_Sel", GXutil.str( AV26TFSoapLocHab_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL") == 0 )
         {
            AV28TFSoapLocBaseUrl = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFSoapLocBaseUrl", AV28TFSoapLocBaseUrl);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL_SEL") == 0 )
         {
            AV27TFSoapLocBaseUrl_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFSoapLocBaseUrl_SelsJson", AV27TFSoapLocBaseUrl_SelsJson);
            AV29TFSoapLocBaseUrl_Sels.fromJSonString(AV27TFSoapLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCCANCELONERROR") == 0 )
         {
            AV30TFSoapLocCancelOnError = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFSoapLocCancelOnError", GXutil.str( AV30TFSoapLocCancelOnError, 1, 0));
            AV31TFSoapLocCancelOnError_To = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFSoapLocCancelOnError_To", GXutil.str( AV31TFSoapLocCancelOnError_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST") == 0 )
         {
            AV33TFSoapLocHost = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFSoapLocHost", AV33TFSoapLocHost);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST_SEL") == 0 )
         {
            AV32TFSoapLocHost_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFSoapLocHost_SelsJson", AV32TFSoapLocHost_SelsJson);
            AV34TFSoapLocHost_Sels.fromJSonString(AV32TFSoapLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCPORT") == 0 )
         {
            AV35TFSoapLocPort = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFSoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFSoapLocPort), 8, 0));
            AV36TFSoapLocPort_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSoapLocPort_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFSoapLocPort_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME") == 0 )
         {
            AV38TFSoapLocResourceName = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFSoapLocResourceName", AV38TFSoapLocResourceName);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME_SEL") == 0 )
         {
            AV37TFSoapLocResourceName_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSoapLocResourceName_SelsJson", AV37TFSoapLocResourceName_SelsJson);
            AV39TFSoapLocResourceName_Sels.fromJSonString(AV37TFSoapLocResourceName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCSECURE") == 0 )
         {
            AV40TFSoapLocSecure = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFSoapLocSecure", GXutil.str( AV40TFSoapLocSecure, 1, 0));
            AV41TFSoapLocSecure_To = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSoapLocSecure_To", GXutil.str( AV41TFSoapLocSecure_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCTIMEOUT") == 0 )
         {
            AV42TFSoapLocTimeout = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFSoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42TFSoapLocTimeout), 4, 0));
            AV43TFSoapLocTimeout_To = (short)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFSoapLocTimeout_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFSoapLocTimeout_To), 4, 0));
         }
         AV107GXV1 = (int)(AV107GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV25TFSoapLocId_Sels.size()==0), AV23TFSoapLocId_SelsJson, GXv_char7) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFSoapLocBaseUrl_Sels.size()==0), AV27TFSoapLocBaseUrl_SelsJson, GXv_char6) ;
      soap_locationww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char18 = "" ;
      GXv_char5[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV34TFSoapLocHost_Sels.size()==0), AV32TFSoapLocHost_SelsJson, GXv_char5) ;
      soap_locationww_impl.this.GXt_char18 = GXv_char5[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV39TFSoapLocResourceName_Sels.size()==0), AV37TFSoapLocResourceName_SelsJson, GXv_char20) ;
      soap_locationww_impl.this.GXt_char19 = GXv_char20[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"|"+((0==AV26TFSoapLocHab_Sel) ? "" : GXutil.str( AV26TFSoapLocHab_Sel, 1, 0))+"|"+GXt_char9+"||"+GXt_char18+"||"+GXt_char19+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV24TFSoapLocId)==0), AV24TFSoapLocId, GXv_char20) ;
      soap_locationww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFSoapLocBaseUrl)==0), AV28TFSoapLocBaseUrl, GXv_char7) ;
      soap_locationww_impl.this.GXt_char18 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFSoapLocHost)==0), AV33TFSoapLocHost, GXv_char6) ;
      soap_locationww_impl.this.GXt_char10 = GXv_char6[0] ;
      GXt_char9 = "" ;
      GXv_char5[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFSoapLocResourceName)==0), AV38TFSoapLocResourceName, GXv_char5) ;
      soap_locationww_impl.this.GXt_char9 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV67TFCliCod) ? "" : GXutil.str( AV67TFCliCod, 6, 0))+"|"+GXt_char19+"||"+GXt_char18+"|"+((0==AV30TFSoapLocCancelOnError) ? "" : GXutil.str( AV30TFSoapLocCancelOnError, 1, 0))+"|"+GXt_char10+"|"+((0==AV35TFSoapLocPort) ? "" : GXutil.str( AV35TFSoapLocPort, 8, 0))+"|"+GXt_char9+"|"+((0==AV40TFSoapLocSecure) ? "" : GXutil.str( AV40TFSoapLocSecure, 1, 0))+"|"+((0==AV42TFSoapLocTimeout) ? "" : GXutil.str( AV42TFSoapLocTimeout, 4, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV68TFCliCod_To) ? "" : GXutil.str( AV68TFCliCod_To, 6, 0))+"||||"+((0==AV31TFSoapLocCancelOnError_To) ? "" : GXutil.str( AV31TFSoapLocCancelOnError_To, 1, 0))+"||"+((0==AV36TFSoapLocPort_To) ? "" : GXutil.str( AV36TFSoapLocPort_To, 8, 0))+"||"+((0==AV41TFSoapLocSecure_To) ? "" : GXutil.str( AV41TFSoapLocSecure_To, 1, 0))+"|"+((0==AV43TFSoapLocTimeout_To) ? "" : GXutil.str( AV43TFSoapLocTimeout_To, 4, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV22Session.getValue(AV87Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCLICOD", httpContext.getMessage( "Cod", ""), !((0==AV67TFCliCod)&&(0==AV68TFCliCod_To)), (short)(0), GXutil.trim( GXutil.str( AV67TFCliCod, 6, 0)), GXutil.trim( GXutil.str( AV68TFCliCod_To, 6, 0))) ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCID", httpContext.getMessage( "Loc Id", ""), !(GXutil.strcmp("", AV24TFSoapLocId)==0), (short)(0), AV24TFSoapLocId, "", !(AV25TFSoapLocId_Sels.size()==0), AV25TFSoapLocId_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCHAB_SEL", httpContext.getMessage( "Loc Hab", ""), !(0==AV26TFSoapLocHab_Sel), (short)(0), GXutil.trim( GXutil.str( AV26TFSoapLocHab_Sel, 1, 0)), "") ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCBASEURL", httpContext.getMessage( "Base Url", ""), !(GXutil.strcmp("", AV28TFSoapLocBaseUrl)==0), (short)(0), AV28TFSoapLocBaseUrl, "", !(AV29TFSoapLocBaseUrl_Sels.size()==0), AV29TFSoapLocBaseUrl_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCCANCELONERROR", httpContext.getMessage( "On Error", ""), !((0==AV30TFSoapLocCancelOnError)&&(0==AV31TFSoapLocCancelOnError_To)), (short)(0), GXutil.trim( GXutil.str( AV30TFSoapLocCancelOnError, 1, 0)), GXutil.trim( GXutil.str( AV31TFSoapLocCancelOnError_To, 1, 0))) ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCHOST", httpContext.getMessage( "Loc Host", ""), !(GXutil.strcmp("", AV33TFSoapLocHost)==0), (short)(0), AV33TFSoapLocHost, "", !(AV34TFSoapLocHost_Sels.size()==0), AV34TFSoapLocHost_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCPORT", httpContext.getMessage( "Loc Port", ""), !((0==AV35TFSoapLocPort)&&(0==AV36TFSoapLocPort_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFSoapLocPort, 8, 0)), GXutil.trim( GXutil.str( AV36TFSoapLocPort_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCRESOURCENAME", httpContext.getMessage( "Resource Name", ""), !(GXutil.strcmp("", AV38TFSoapLocResourceName)==0), (short)(0), AV38TFSoapLocResourceName, "", !(AV39TFSoapLocResourceName_Sels.size()==0), AV39TFSoapLocResourceName_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCSECURE", httpContext.getMessage( "Loc Secure", ""), !((0==AV40TFSoapLocSecure)&&(0==AV41TFSoapLocSecure_To)), (short)(0), GXutil.trim( GXutil.str( AV40TFSoapLocSecure, 1, 0)), GXutil.trim( GXutil.str( AV41TFSoapLocSecure_To, 1, 0))) ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFSOAPLOCTIMEOUT", httpContext.getMessage( "Loc Timeout", ""), !((0==AV42TFSoapLocTimeout)&&(0==AV43TFSoapLocTimeout_To)), (short)(0), GXutil.trim( GXutil.str( AV42TFSoapLocTimeout, 4, 0)), GXutil.trim( GXutil.str( AV43TFSoapLocTimeout_To, 4, 0))) ;
      AV11GridState = GXv_SdtWWPGridState21[0] ;
      if ( ! (GXutil.strcmp("", AV58MenuOpcCod)==0) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV58MenuOpcCod );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV87Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "soap_location" );
      AV22Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18OL2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV62WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV58MenuOpcCod, GXv_boolean8) ;
         GXv_char20[0] = AV76textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV56CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char20) ;
         soap_locationww_impl.this.AV76textoNoMostrara = GXv_char20[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV76textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV58MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void S202( )
   {
      /* 'DOEXPORT' Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_OL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_OL2( true) ;
      }
      else
      {
         wb_table2_12_OL2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_OL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_OL2e( true) ;
      }
      else
      {
         wb_table1_9_OL2e( false) ;
      }
   }

   public void wb_table2_12_OL2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e22ol1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_soap_locationWW.htm");
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
         AV63WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV86Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV63WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV63WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV63WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_soap_locationWW.htm");
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
         wb_table3_30_OL2( true) ;
      }
      else
      {
         wb_table3_30_OL2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_OL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_OL2( true) ;
      }
      else
      {
         wb_table4_35_OL2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_OL2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_110_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV62WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
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
         wb_table5_54_OL2( true) ;
      }
      else
      {
         wb_table5_54_OL2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_OL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_OL2( true) ;
      }
      else
      {
         wb_table6_63_OL2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_OL2e( boolean wbgen )
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
         startgridcontrol110( ) ;
      }
      if ( wbEnd == 110 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_110 = (int)(nGXsfl_110_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV46GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV47GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV48GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_OL2e( true) ;
      }
      else
      {
         wb_table2_12_OL2e( false) ;
      }
   }

   public void wb_table6_63_OL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, "BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV44DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV20ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV64ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_soap_locationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_soap_locationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_OL2( true) ;
      }
      else
      {
         wb_table7_99_OL2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_OL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, "BUTTONFILTER1_A3LFILTERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_63_OL2e( true) ;
      }
      else
      {
         wb_table6_63_OL2e( false) ;
      }
   }

   public void wb_table7_99_OL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblButtonfilter1_tablebadge_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblButtonfilter1_tablebadge_Internalname, tblButtonfilter1_tablebadge_Internalname, "", "TableBadge", 0, "", tblButtonfilter1_tablebadge_Tooltiptext, 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_OL2e( true) ;
      }
      else
      {
         wb_table7_99_OL2e( false) ;
      }
   }

   public void wb_table5_54_OL2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_OL2e( true) ;
      }
      else
      {
         wb_table5_54_OL2e( false) ;
      }
   }

   public void wb_table4_35_OL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_OL2e( true) ;
      }
      else
      {
         wb_table4_35_OL2e( false) ;
      }
   }

   public void wb_table3_30_OL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_soap_locationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_OL2e( true) ;
      }
      else
      {
         wb_table3_30_OL2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV58MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58MenuOpcCod", AV58MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV58MenuOpcCod, ""))));
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
      paOL2( ) ;
      wsOL2( ) ;
      weOL2( ) ;
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
      httpContext.AddStyleSheetFile("a3lfilter.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020402873", true, true);
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
      httpContext.AddJavascriptSource("soap_locationww.js", "?2024122020402873", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
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

   public void subsflControlProps_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_idx ;
      edtSoapLocId_Internalname = "SOAPLOCID_"+sGXsfl_110_idx ;
      chkSoapLocHab.setInternalname( "SOAPLOCHAB_"+sGXsfl_110_idx );
      edtSoapLocBaseUrl_Internalname = "SOAPLOCBASEURL_"+sGXsfl_110_idx ;
      edtSoapLocCancelOnError_Internalname = "SOAPLOCCANCELONERROR_"+sGXsfl_110_idx ;
      edtSoapLocHost_Internalname = "SOAPLOCHOST_"+sGXsfl_110_idx ;
      edtSoapLocPort_Internalname = "SOAPLOCPORT_"+sGXsfl_110_idx ;
      edtSoapLocResourceName_Internalname = "SOAPLOCRESOURCENAME_"+sGXsfl_110_idx ;
      edtSoapLocSecure_Internalname = "SOAPLOCSECURE_"+sGXsfl_110_idx ;
      edtSoapLocTimeout_Internalname = "SOAPLOCTIMEOUT_"+sGXsfl_110_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_fel_idx ;
      edtSoapLocId_Internalname = "SOAPLOCID_"+sGXsfl_110_fel_idx ;
      chkSoapLocHab.setInternalname( "SOAPLOCHAB_"+sGXsfl_110_fel_idx );
      edtSoapLocBaseUrl_Internalname = "SOAPLOCBASEURL_"+sGXsfl_110_fel_idx ;
      edtSoapLocCancelOnError_Internalname = "SOAPLOCCANCELONERROR_"+sGXsfl_110_fel_idx ;
      edtSoapLocHost_Internalname = "SOAPLOCHOST_"+sGXsfl_110_fel_idx ;
      edtSoapLocPort_Internalname = "SOAPLOCPORT_"+sGXsfl_110_fel_idx ;
      edtSoapLocResourceName_Internalname = "SOAPLOCRESOURCENAME_"+sGXsfl_110_fel_idx ;
      edtSoapLocSecure_Internalname = "SOAPLOCSECURE_"+sGXsfl_110_fel_idx ;
      edtSoapLocTimeout_Internalname = "SOAPLOCTIMEOUT_"+sGXsfl_110_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_fel_idx ;
   }

   public void sendrow_1102( )
   {
      subsflControlProps_1102( ) ;
      wbOL0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_110_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_110_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_110_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSoapLocId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocId_Internalname,GXutil.rtrim( A2162SoapLocId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkSoapLocHab.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SOAPLOCHAB_" + sGXsfl_110_idx ;
         chkSoapLocHab.setName( GXCCtl );
         chkSoapLocHab.setWebtags( "" );
         chkSoapLocHab.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkSoapLocHab.getInternalname(), "TitleCaption", chkSoapLocHab.getCaption(), !bGXsfl_110_Refreshing);
         chkSoapLocHab.setCheckedValue( "false" );
         A2163SoapLocHab = GXutil.strtobool( GXutil.booltostr( A2163SoapLocHab)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSoapLocHab.getInternalname(),GXutil.booltostr( A2163SoapLocHab),"","",Integer.valueOf(chkSoapLocHab.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSoapLocBaseUrl_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocBaseUrl_Internalname,A2164SoapLocBaseUrl,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocBaseUrl_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocBaseUrl_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSoapLocCancelOnError_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocCancelOnError_Internalname,GXutil.ltrim( localUtil.ntoc( A2165SoapLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2165SoapLocCancelOnError), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocCancelOnError_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocCancelOnError_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSoapLocHost_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocHost_Internalname,A2166SoapLocHost,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocHost_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocHost_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSoapLocPort_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocPort_Internalname,GXutil.ltrim( localUtil.ntoc( A2167SoapLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2167SoapLocPort), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocPort_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocPort_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSoapLocResourceName_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocResourceName_Internalname,A2168SoapLocResourceName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocResourceName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocResourceName_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSoapLocSecure_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocSecure_Internalname,GXutil.ltrim( localUtil.ntoc( A2169SoapLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2169SoapLocSecure), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocSecure_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocSecure_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtSoapLocTimeout_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSoapLocTimeout_Internalname,GXutil.ltrim( localUtil.ntoc( A2170SoapLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2170SoapLocTimeout), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSoapLocTimeout_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSoapLocTimeout_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV49Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV51Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV69Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV59VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV60ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV61EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesOL2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      /* End function sendrow_1102 */
   }

   public void startgridcontrol110( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"110\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkSoapLocHab.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Hab", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocBaseUrl_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base Url", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocCancelOnError_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "On Error", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocHost_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Host", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocPort_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Port", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocResourceName_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Resource Name", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocSecure_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Secure", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSoapLocTimeout_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Loc Timeout", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2162SoapLocId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2163SoapLocHab));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkSoapLocHab.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2164SoapLocBaseUrl);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocBaseUrl_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2165SoapLocCancelOnError, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocCancelOnError_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2166SoapLocHost);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocHost_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2167SoapLocPort, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocPort_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2168SoapLocResourceName);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocResourceName_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2169SoapLocSecure, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocSecure_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2170SoapLocTimeout, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSoapLocTimeout_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV49Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV69Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV59VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV60ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV61EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      lblButtonexport1_textblock_svg_Internalname = "BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = "BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = "BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = "BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = "BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = "BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      bttBtninsert_Internalname = "BTNINSERT" ;
      bttBtnexport_Internalname = "BTNEXPORT" ;
      lblButtonfilter1_textblock_svg_Internalname = "BUTTONFILTER1_TEXTBLOCK_SVG" ;
      divButtonfilter1_table_svg_Internalname = "BUTTONFILTER1_TABLE_SVG" ;
      lblButtonfilter1_textblock_texto_Internalname = "BUTTONFILTER1_TEXTBLOCK_TEXTO" ;
      divButtonfilter1_table_texto_Internalname = "BUTTONFILTER1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = "BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = "BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilter1_filtros_Internalname = "BUTTONFILTER1_FILTROS" ;
      Buttonfilter1_a3lfilter_Internalname = "BUTTONFILTER1_A3LFILTER" ;
      divButtonfilter1_tablecontent_Internalname = "BUTTONFILTER1_TABLECONTENT" ;
      tblTablefiltros_Internalname = "TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtSoapLocId_Internalname = "SOAPLOCID" ;
      chkSoapLocHab.setInternalname( "SOAPLOCHAB" );
      edtSoapLocBaseUrl_Internalname = "SOAPLOCBASEURL" ;
      edtSoapLocCancelOnError_Internalname = "SOAPLOCCANCELONERROR" ;
      edtSoapLocHost_Internalname = "SOAPLOCHOST" ;
      edtSoapLocPort_Internalname = "SOAPLOCPORT" ;
      edtSoapLocResourceName_Internalname = "SOAPLOCRESOURCENAME" ;
      edtSoapLocSecure_Internalname = "SOAPLOCSECURE" ;
      edtSoapLocTimeout_Internalname = "SOAPLOCTIMEOUT" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
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
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 0 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtSoapLocTimeout_Jsonclick = "" ;
      edtSoapLocSecure_Jsonclick = "" ;
      edtSoapLocResourceName_Jsonclick = "" ;
      edtSoapLocPort_Jsonclick = "" ;
      edtSoapLocHost_Jsonclick = "" ;
      edtSoapLocCancelOnError_Jsonclick = "" ;
      edtSoapLocBaseUrl_Jsonclick = "" ;
      chkSoapLocHab.setCaption( "" );
      edtSoapLocId_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavEliminarsvg_Visible = -1 ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtSoapLocTimeout_Visible = -1 ;
      edtSoapLocSecure_Visible = -1 ;
      edtSoapLocResourceName_Visible = -1 ;
      edtSoapLocPort_Visible = -1 ;
      edtSoapLocHost_Visible = -1 ;
      edtSoapLocCancelOnError_Visible = -1 ;
      edtSoapLocBaseUrl_Visible = -1 ;
      chkSoapLocHab.setVisible( -1 );
      edtSoapLocId_Visible = -1 ;
      edtCliCod_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "6.0||||1.0||8.0||1.0|4.0" ;
      Ddo_grid_Datalistproc = "soap_locationWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||1:WWP_TSChecked,2:WWP_TSUnChecked|||||||" ;
      Ddo_grid_Allowmultipleselection = "|T||T||T||T||" ;
      Ddo_grid_Datalisttype = "|Dynamic|FixedValues|Dynamic||Dynamic||Dynamic||" ;
      Ddo_grid_Includedatalist = "|T|T|T||T||T||" ;
      Ddo_grid_Filterisrange = "T||||T||T||T|T" ;
      Ddo_grid_Filtertype = "Numeric|Character||Character|Numeric|Character|Numeric|Character|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "T|T||T|T|T|T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10" ;
      Ddo_grid_Columnids = "0:CliCod|1:SoapLocId|2:SoapLocHab|3:SoapLocBaseUrl|4:SoapLocCancelOnError|5:SoapLocHost|6:SoapLocPort|7:SoapLocResourceName|8:SoapLocSecure|9:SoapLocTimeout" ;
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
      Buttonfilter1_a3lfilter_Filter_orig = "" ;
      Buttonfilter1_a3lfilter_A3l_filter_id = "" ;
      Buttonfilter1_a3lfilter_Observer = "" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Buttonexport1_a3lexport_Boton_orig_id = "" ;
      Buttonexport1_a3lexport_Boton_clon_id = "" ;
      Buttonexport1_a3lexport_Observer = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " soap_location", "") );
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
      AV62WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV62WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62WelcomeMessage_NoMostrarMas", AV62WelcomeMessage_NoMostrarMas);
      GXCCtl = "SOAPLOCHAB_" + sGXsfl_110_idx ;
      chkSoapLocHab.setName( GXCCtl );
      chkSoapLocHab.setWebtags( "" );
      chkSoapLocHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSoapLocHab.getInternalname(), "TitleCaption", chkSoapLocHab.getCaption(), !bGXsfl_110_Refreshing);
      chkSoapLocHab.setCheckedValue( "false" );
      A2163SoapLocHab = GXutil.strtobool( GXutil.booltostr( A2163SoapLocHab)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtSoapLocId_Visible',ctrl:'SOAPLOCID',prop:'Visible'},{av:'chkSoapLocHab.getVisible()',ctrl:'SOAPLOCHAB',prop:'Visible'},{av:'edtSoapLocBaseUrl_Visible',ctrl:'SOAPLOCBASEURL',prop:'Visible'},{av:'edtSoapLocCancelOnError_Visible',ctrl:'SOAPLOCCANCELONERROR',prop:'Visible'},{av:'edtSoapLocHost_Visible',ctrl:'SOAPLOCHOST',prop:'Visible'},{av:'edtSoapLocPort_Visible',ctrl:'SOAPLOCPORT',prop:'Visible'},{av:'edtSoapLocResourceName_Visible',ctrl:'SOAPLOCRESOURCENAME',prop:'Visible'},{av:'edtSoapLocSecure_Visible',ctrl:'SOAPLOCSECURE',prop:'Visible'},{av:'edtSoapLocTimeout_Visible',ctrl:'SOAPLOCTIMEOUT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV48GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13OL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14OL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15OL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV37TFSoapLocResourceName_SelsJson',fld:'vTFSOAPLOCRESOURCENAME_SELSJSON',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV32TFSoapLocHost_SelsJson',fld:'vTFSOAPLOCHOST_SELSJSON',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV27TFSoapLocBaseUrl_SelsJson',fld:'vTFSOAPLOCBASEURL_SELSJSON',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV23TFSoapLocId_SelsJson',fld:'vTFSOAPLOCID_SELSJSON',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21OL2',iparms:[{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A2162SoapLocId',fld:'SOAPLOCID',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV49Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV51Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV69Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV59VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV60ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV61EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11OL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtSoapLocId_Visible',ctrl:'SOAPLOCID',prop:'Visible'},{av:'chkSoapLocHab.getVisible()',ctrl:'SOAPLOCHAB',prop:'Visible'},{av:'edtSoapLocBaseUrl_Visible',ctrl:'SOAPLOCBASEURL',prop:'Visible'},{av:'edtSoapLocCancelOnError_Visible',ctrl:'SOAPLOCCANCELONERROR',prop:'Visible'},{av:'edtSoapLocHost_Visible',ctrl:'SOAPLOCHOST',prop:'Visible'},{av:'edtSoapLocPort_Visible',ctrl:'SOAPLOCPORT',prop:'Visible'},{av:'edtSoapLocResourceName_Visible',ctrl:'SOAPLOCRESOURCENAME',prop:'Visible'},{av:'edtSoapLocSecure_Visible',ctrl:'SOAPLOCSECURE',prop:'Visible'},{av:'edtSoapLocTimeout_Visible',ctrl:'SOAPLOCTIMEOUT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV48GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12OL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV23TFSoapLocId_SelsJson',fld:'vTFSOAPLOCID_SELSJSON',pic:''},{av:'AV27TFSoapLocBaseUrl_SelsJson',fld:'vTFSOAPLOCBASEURL_SELSJSON',pic:''},{av:'AV32TFSoapLocHost_SelsJson',fld:'vTFSOAPLOCHOST_SELSJSON',pic:''},{av:'AV37TFSoapLocResourceName_SelsJson',fld:'vTFSOAPLOCRESOURCENAME_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV66ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV67TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV68TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV24TFSoapLocId',fld:'vTFSOAPLOCID',pic:''},{av:'AV25TFSoapLocId_Sels',fld:'vTFSOAPLOCID_SELS',pic:''},{av:'AV26TFSoapLocHab_Sel',fld:'vTFSOAPLOCHAB_SEL',pic:'9'},{av:'AV28TFSoapLocBaseUrl',fld:'vTFSOAPLOCBASEURL',pic:''},{av:'AV29TFSoapLocBaseUrl_Sels',fld:'vTFSOAPLOCBASEURL_SELS',pic:''},{av:'AV30TFSoapLocCancelOnError',fld:'vTFSOAPLOCCANCELONERROR',pic:'9'},{av:'AV31TFSoapLocCancelOnError_To',fld:'vTFSOAPLOCCANCELONERROR_TO',pic:'9'},{av:'AV33TFSoapLocHost',fld:'vTFSOAPLOCHOST',pic:''},{av:'AV34TFSoapLocHost_Sels',fld:'vTFSOAPLOCHOST_SELS',pic:''},{av:'AV35TFSoapLocPort',fld:'vTFSOAPLOCPORT',pic:'ZZZZZZZ9'},{av:'AV36TFSoapLocPort_To',fld:'vTFSOAPLOCPORT_TO',pic:'ZZZZZZZ9'},{av:'AV38TFSoapLocResourceName',fld:'vTFSOAPLOCRESOURCENAME',pic:''},{av:'AV39TFSoapLocResourceName_Sels',fld:'vTFSOAPLOCRESOURCENAME_SELS',pic:''},{av:'AV40TFSoapLocSecure',fld:'vTFSOAPLOCSECURE',pic:'9'},{av:'AV41TFSoapLocSecure_To',fld:'vTFSOAPLOCSECURE_TO',pic:'9'},{av:'AV42TFSoapLocTimeout',fld:'vTFSOAPLOCTIMEOUT',pic:'ZZZ9'},{av:'AV43TFSoapLocTimeout_To',fld:'vTFSOAPLOCTIMEOUT_TO',pic:'ZZZ9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV37TFSoapLocResourceName_SelsJson',fld:'vTFSOAPLOCRESOURCENAME_SELSJSON',pic:''},{av:'AV32TFSoapLocHost_SelsJson',fld:'vTFSOAPLOCHOST_SELSJSON',pic:''},{av:'AV27TFSoapLocBaseUrl_SelsJson',fld:'vTFSOAPLOCBASEURL_SELSJSON',pic:''},{av:'AV23TFSoapLocId_SelsJson',fld:'vTFSOAPLOCID_SELSJSON',pic:''},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtSoapLocId_Visible',ctrl:'SOAPLOCID',prop:'Visible'},{av:'chkSoapLocHab.getVisible()',ctrl:'SOAPLOCHAB',prop:'Visible'},{av:'edtSoapLocBaseUrl_Visible',ctrl:'SOAPLOCBASEURL',prop:'Visible'},{av:'edtSoapLocCancelOnError_Visible',ctrl:'SOAPLOCCANCELONERROR',prop:'Visible'},{av:'edtSoapLocHost_Visible',ctrl:'SOAPLOCHOST',prop:'Visible'},{av:'edtSoapLocPort_Visible',ctrl:'SOAPLOCPORT',prop:'Visible'},{av:'edtSoapLocResourceName_Visible',ctrl:'SOAPLOCRESOURCENAME',prop:'Visible'},{av:'edtSoapLocSecure_Visible',ctrl:'SOAPLOCSECURE',prop:'Visible'},{av:'edtSoapLocTimeout_Visible',ctrl:'SOAPLOCTIMEOUT',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV48GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV50IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV52IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16OL2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A2162SoapLocId',fld:'SOAPLOCID',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17OL2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18OL2',iparms:[{av:'AV62WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV56CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e22OL1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Eliminarsvg',iparms:[]");
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
      wcpOAV58MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV58MenuOpcCod = "" ;
      AV20ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV87Pgmname = "" ;
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24TFSoapLocId = "" ;
      AV25TFSoapLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFSoapLocBaseUrl = "" ;
      AV29TFSoapLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33TFSoapLocHost = "" ;
      AV34TFSoapLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFSoapLocResourceName = "" ;
      AV39TFSoapLocResourceName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV44DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV64ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV48GridAppliedFilters = "" ;
      AV23TFSoapLocId_SelsJson = "" ;
      AV27TFSoapLocBaseUrl_SelsJson = "" ;
      AV32TFSoapLocHost_SelsJson = "" ;
      AV37TFSoapLocResourceName_SelsJson = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
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
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A2162SoapLocId = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      AV49Update = "" ;
      AV51Delete = "" ;
      AV69Display = "" ;
      AV59VerSVG = "" ;
      AV60ModificarSVG = "" ;
      AV61EliminarSVG = "" ;
      AV91Soap_locationwwds_4_tfsoaplocid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Soap_locationwwds_11_tfsoaplochost_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV102Soap_locationwwds_15_tfsoaplocresourcename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV90Soap_locationwwds_3_tfsoaplocid = "" ;
      lV93Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      lV97Soap_locationwwds_10_tfsoaplochost = "" ;
      lV101Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      AV90Soap_locationwwds_3_tfsoaplocid = "" ;
      AV93Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      AV97Soap_locationwwds_10_tfsoaplochost = "" ;
      AV101Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      H00OL2_A2170SoapLocTimeout = new short[1] ;
      H00OL2_A2169SoapLocSecure = new byte[1] ;
      H00OL2_A2168SoapLocResourceName = new String[] {""} ;
      H00OL2_A2167SoapLocPort = new int[1] ;
      H00OL2_A2166SoapLocHost = new String[] {""} ;
      H00OL2_A2165SoapLocCancelOnError = new byte[1] ;
      H00OL2_A2164SoapLocBaseUrl = new String[] {""} ;
      H00OL2_A2163SoapLocHab = new boolean[] {false} ;
      H00OL2_A2162SoapLocId = new String[] {""} ;
      H00OL2_A3CliCod = new int[1] ;
      H00OL3_AGRID_nRecordCount = new long[1] ;
      AV63WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV75MenuBienveImgURL = "" ;
      AV77MenuBienveTitulo = "" ;
      AV78MenuBienveTexto = "" ;
      AV86Welcomemessage_foto_GXI = "" ;
      AV83observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV18ColumnsSelectorXML = "" ;
      AV74MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV82filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV65ManageFiltersXml = "" ;
      AV16ExcelFilename = "" ;
      AV17ErrorMessage = "" ;
      AV19UserCustomValue = "" ;
      AV21ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char19 = "" ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState21 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV76textoNoMostrara = "" ;
      GXv_char20 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.soap_locationww__default(),
         new Object[] {
             new Object[] {
            H00OL2_A2170SoapLocTimeout, H00OL2_A2169SoapLocSecure, H00OL2_A2168SoapLocResourceName, H00OL2_A2167SoapLocPort, H00OL2_A2166SoapLocHost, H00OL2_A2165SoapLocCancelOnError, H00OL2_A2164SoapLocBaseUrl, H00OL2_A2163SoapLocHab, H00OL2_A2162SoapLocId, H00OL2_A3CliCod
            }
            , new Object[] {
            H00OL3_AGRID_nRecordCount
            }
         }
      );
      AV87Pgmname = "soap_locationWW" ;
      /* GeneXus formulas. */
      AV87Pgmname = "soap_locationWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV66ManageFiltersExecutionStep ;
   private byte AV26TFSoapLocHab_Sel ;
   private byte AV30TFSoapLocCancelOnError ;
   private byte AV31TFSoapLocCancelOnError_To ;
   private byte AV40TFSoapLocSecure ;
   private byte AV41TFSoapLocSecure_To ;
   private byte gxajaxcallmode ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV92Soap_locationwwds_5_tfsoaplochab_sel ;
   private byte AV95Soap_locationwwds_8_tfsoaploccancelonerror ;
   private byte AV96Soap_locationwwds_9_tfsoaploccancelonerror_to ;
   private byte AV103Soap_locationwwds_16_tfsoaplocsecure ;
   private byte AV104Soap_locationwwds_17_tfsoaplocsecure_to ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV42TFSoapLocTimeout ;
   private short AV43TFSoapLocTimeout_To ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A2170SoapLocTimeout ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV105Soap_locationwwds_18_tfsoaploctimeout ;
   private short AV106Soap_locationwwds_19_tfsoaploctimeout_to ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV67TFCliCod ;
   private int AV68TFCliCod_To ;
   private int AV35TFSoapLocPort ;
   private int AV36TFSoapLocPort_To ;
   private int AV56CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A2167SoapLocPort ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV91Soap_locationwwds_4_tfsoaplocid_sels_size ;
   private int AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ;
   private int AV98Soap_locationwwds_11_tfsoaplochost_sels_size ;
   private int AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size ;
   private int AV88Soap_locationwwds_1_tfclicod ;
   private int AV89Soap_locationwwds_2_tfclicod_to ;
   private int AV99Soap_locationwwds_12_tfsoaplocport ;
   private int AV100Soap_locationwwds_13_tfsoaplocport_to ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtCliCod_Visible ;
   private int edtSoapLocId_Visible ;
   private int edtSoapLocBaseUrl_Visible ;
   private int edtSoapLocCancelOnError_Visible ;
   private int edtSoapLocHost_Visible ;
   private int edtSoapLocPort_Visible ;
   private int edtSoapLocResourceName_Visible ;
   private int edtSoapLocSecure_Visible ;
   private int edtSoapLocTimeout_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV81filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV45PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV107GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV46GridCurrentPage ;
   private long AV47GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_110_idx="0001" ;
   private String AV87Pgmname ;
   private String AV24TFSoapLocId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Buttonexport1_a3lexport_Observer ;
   private String Buttonexport1_a3lexport_Boton_clon_id ;
   private String Buttonexport1_a3lexport_Boton_orig_id ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Buttonfilter1_a3lfilter_Observer ;
   private String Buttonfilter1_a3lfilter_A3l_filter_id ;
   private String Buttonfilter1_a3lfilter_Filter_orig ;
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
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String A2162SoapLocId ;
   private String edtSoapLocId_Internalname ;
   private String edtSoapLocBaseUrl_Internalname ;
   private String edtSoapLocCancelOnError_Internalname ;
   private String edtSoapLocHost_Internalname ;
   private String edtSoapLocPort_Internalname ;
   private String edtSoapLocResourceName_Internalname ;
   private String edtSoapLocSecure_Internalname ;
   private String edtSoapLocTimeout_Internalname ;
   private String AV49Update ;
   private String edtavUpdate_Internalname ;
   private String AV51Delete ;
   private String edtavDelete_Internalname ;
   private String AV69Display ;
   private String edtavDisplay_Internalname ;
   private String AV59VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV60ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV61EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV90Soap_locationwwds_3_tfsoaplocid ;
   private String AV90Soap_locationwwds_3_tfsoaplocid ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV83observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char19 ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXv_char20[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
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
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_filtros_Internalname ;
   private String divButtonfilter1_table_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Jsonclick ;
   private String divButtonfilter1_table_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Jsonclick ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_110_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtSoapLocId_Jsonclick ;
   private String GXCCtl ;
   private String edtSoapLocBaseUrl_Jsonclick ;
   private String edtSoapLocCancelOnError_Jsonclick ;
   private String edtSoapLocHost_Jsonclick ;
   private String edtSoapLocPort_Jsonclick ;
   private String edtSoapLocResourceName_Jsonclick ;
   private String edtSoapLocSecure_Jsonclick ;
   private String edtSoapLocTimeout_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV50IsAuthorized_Update ;
   private boolean AV52IsAuthorized_Delete ;
   private boolean AV62WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean A2163SoapLocHab ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV79MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV55TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean8[] ;
   private boolean AV63WelcomeMessage_Foto_IsBlob ;
   private String AV23TFSoapLocId_SelsJson ;
   private String AV27TFSoapLocBaseUrl_SelsJson ;
   private String AV32TFSoapLocHost_SelsJson ;
   private String AV37TFSoapLocResourceName_SelsJson ;
   private String AV78MenuBienveTexto ;
   private String AV18ColumnsSelectorXML ;
   private String AV65ManageFiltersXml ;
   private String AV19UserCustomValue ;
   private String AV76textoNoMostrara ;
   private String wcpOAV58MenuOpcCod ;
   private String AV58MenuOpcCod ;
   private String AV28TFSoapLocBaseUrl ;
   private String AV33TFSoapLocHost ;
   private String AV38TFSoapLocResourceName ;
   private String AV48GridAppliedFilters ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private String lV93Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String lV97Soap_locationwwds_10_tfsoaplochost ;
   private String lV101Soap_locationwwds_14_tfsoaplocresourcename ;
   private String AV93Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String AV97Soap_locationwwds_10_tfsoaplochost ;
   private String AV101Soap_locationwwds_14_tfsoaplocresourcename ;
   private String AV75MenuBienveImgURL ;
   private String AV77MenuBienveTitulo ;
   private String AV86Welcomemessage_foto_GXI ;
   private String AV74MenuOpcTitulo ;
   private String AV82filtrosTexto ;
   private String AV16ExcelFilename ;
   private String AV17ErrorMessage ;
   private String AV63WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV91Soap_locationwwds_4_tfsoaplocid_sels ;
   private GXSimpleCollection<String> AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels ;
   private GXSimpleCollection<String> AV98Soap_locationwwds_11_tfsoaplochost_sels ;
   private GXSimpleCollection<String> AV102Soap_locationwwds_15_tfsoaplocresourcename_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkSoapLocHab ;
   private IDataStoreProvider pr_default ;
   private short[] H00OL2_A2170SoapLocTimeout ;
   private byte[] H00OL2_A2169SoapLocSecure ;
   private String[] H00OL2_A2168SoapLocResourceName ;
   private int[] H00OL2_A2167SoapLocPort ;
   private String[] H00OL2_A2166SoapLocHost ;
   private byte[] H00OL2_A2165SoapLocCancelOnError ;
   private String[] H00OL2_A2164SoapLocBaseUrl ;
   private boolean[] H00OL2_A2163SoapLocHab ;
   private String[] H00OL2_A2162SoapLocId ;
   private int[] H00OL2_A3CliCod ;
   private long[] H00OL3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV25TFSoapLocId_Sels ;
   private GXSimpleCollection<String> AV29TFSoapLocBaseUrl_Sels ;
   private GXSimpleCollection<String> AV34TFSoapLocHost_Sels ;
   private GXSimpleCollection<String> AV39TFSoapLocResourceName_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV64ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState21[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV44DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class soap_locationww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00OL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV91Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV98Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV102Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV88Soap_locationwwds_1_tfclicod ,
                                          int AV89Soap_locationwwds_2_tfclicod_to ,
                                          int AV91Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV90Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV92Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV93Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV95Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV96Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV98Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV97Soap_locationwwds_10_tfsoaplochost ,
                                          int AV99Soap_locationwwds_12_tfsoaplocport ,
                                          int AV100Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV101Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV103Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV104Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV105Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV106Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV56CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[18];
      Object[] GXv_Object23 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " SoapLocTimeout, SoapLocSecure, SoapLocResourceName, SoapLocPort, SoapLocHost, SoapLocCancelOnError, SoapLocBaseUrl, SoapLocHab, SoapLocId, CliCod" ;
      sFromString = " FROM soap_location" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV88Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int22[1] = (byte)(1) ;
      }
      if ( ! (0==AV89Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      if ( ( AV91Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( AV91Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV92Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV92Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV95Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( ! (0==AV96Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ( AV98Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV97Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( AV98Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV99Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (0==AV100Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( ( AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV103Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( ! (0==AV104Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( ! (0==AV105Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int22[13] = (byte)(1) ;
      }
      if ( ! (0==AV106Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int22[14] = (byte)(1) ;
      }
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocId, CliCod" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocId DESC, CliCod" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocHab, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocHab DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocBaseUrl, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocBaseUrl DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocCancelOnError, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocCancelOnError DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocHost, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocHost DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocPort, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocPort DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocResourceName, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocResourceName DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocSecure, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocSecure DESC, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY SoapLocTimeout, CliCod, SoapLocId" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY SoapLocTimeout DESC, CliCod, SoapLocId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, SoapLocId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_H00OL3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV91Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV98Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV102Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV88Soap_locationwwds_1_tfclicod ,
                                          int AV89Soap_locationwwds_2_tfclicod_to ,
                                          int AV91Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV90Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV92Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV93Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV95Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV96Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV98Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV97Soap_locationwwds_10_tfsoaplochost ,
                                          int AV99Soap_locationwwds_12_tfsoaplocport ,
                                          int AV100Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV101Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV103Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV104Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV105Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV106Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV56CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[15];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV88Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int25[1] = (byte)(1) ;
      }
      if ( ! (0==AV89Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int25[2] = (byte)(1) ;
      }
      if ( ( AV91Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( AV91Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV92Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV92Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      if ( AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV95Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int25[5] = (byte)(1) ;
      }
      if ( ! (0==AV96Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int25[6] = (byte)(1) ;
      }
      if ( ( AV98Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV97Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int25[7] = (byte)(1) ;
      }
      if ( AV98Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV99Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int25[8] = (byte)(1) ;
      }
      if ( ! (0==AV100Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int25[9] = (byte)(1) ;
      }
      if ( ( AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int25[10] = (byte)(1) ;
      }
      if ( AV102Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV103Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int25[11] = (byte)(1) ;
      }
      if ( ! (0==AV104Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int25[12] = (byte)(1) ;
      }
      if ( ! (0==AV105Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int25[13] = (byte)(1) ;
      }
      if ( ! (0==AV106Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int25[14] = (byte)(1) ;
      }
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
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
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
                  return conditional_H00OL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).intValue() );
            case 1 :
                  return conditional_H00OL3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00OL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OL3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 40);
               ((int[]) buf[9])[0] = rslt.getInt(10);
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
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[24]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[30]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[34]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
      }
   }

}

