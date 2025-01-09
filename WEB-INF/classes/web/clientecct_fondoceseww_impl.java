package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clientecct_fondoceseww_impl extends GXDataArea
{
   public clientecct_fondoceseww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clientecct_fondoceseww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_fondoceseww_impl.class ));
   }

   public clientecct_fondoceseww_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkCliConveFondoRem = UIFactory.getCheckbox(this);
      chkCliConveFondoNre = UIFactory.getCheckbox(this);
      chkCliConveFondoDes = UIFactory.getCheckbox(this);
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
            AV8MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8MenuOpcCod", AV8MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MenuOpcCod, ""))));
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
      AV65ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV25ColumnsSelector);
      AV78Pgmname = httpContext.GetPar( "Pgmname") ;
      AV8MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV28TFCliConveVig = localUtil.parseDateParm( httpContext.GetPar( "TFCliConveVig")) ;
      AV29TFCliConveVig_To = localUtil.parseDateParm( httpContext.GetPar( "TFCliConveVig_To")) ;
      AV33TFCliConveFondoSec = (short)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoSec"))) ;
      AV34TFCliConveFondoSec_To = (short)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoSec_To"))) ;
      AV35TFCliConveFondoMeses = (short)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoMeses"))) ;
      AV36TFCliConveFondoMeses_To = (short)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoMeses_To"))) ;
      AV37TFCliConveFondoPrc = CommonUtil.decimalVal( httpContext.GetPar( "TFCliConveFondoPrc"), ".") ;
      AV38TFCliConveFondoPrc_To = CommonUtil.decimalVal( httpContext.GetPar( "TFCliConveFondoPrc_To"), ".") ;
      AV39TFCliConveFondoRem_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoRem_Sel"))) ;
      AV40TFCliConveFondoNre_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoNre_Sel"))) ;
      AV41TFCliConveFondoDes_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFCliConveFondoDes_Sel"))) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV59CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV48IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV50IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
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
      paMG2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startMG2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clientecct_fondoceseww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV8MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV59CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV48IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV42DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV42DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV25ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV25ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV63ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV63ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV44GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV45GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV46GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CLICONVEVIGAUXDATE", localUtil.dtoc( AV30DDO_CliConveVigAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CLICONVEVIGAUXDATETO", localUtil.dtoc( AV31DDO_CliConveVigAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV65ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV78Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV8MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEVIG", localUtil.dtoc( AV28TFCliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEVIG_TO", localUtil.dtoc( AV29TFCliConveVig_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOSEC", GXutil.ltrim( localUtil.ntoc( AV33TFCliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOSEC_TO", GXutil.ltrim( localUtil.ntoc( AV34TFCliConveFondoSec_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOMESES", GXutil.ltrim( localUtil.ntoc( AV35TFCliConveFondoMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOMESES_TO", GXutil.ltrim( localUtil.ntoc( AV36TFCliConveFondoMeses_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOPRC", GXutil.ltrim( localUtil.ntoc( AV37TFCliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOPRC_TO", GXutil.ltrim( localUtil.ntoc( AV38TFCliConveFondoPrc_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDOREM_SEL", GXutil.ltrim( localUtil.ntoc( AV39TFCliConveFondoRem_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDONRE_SEL", GXutil.ltrim( localUtil.ntoc( AV40TFCliConveFondoNre_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICONVEFONDODES_SEL", GXutil.ltrim( localUtil.ntoc( AV41TFCliConveFondoDes_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV59CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV59CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV48IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV48IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV50IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
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
         weMG2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtMG2( ) ;
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
      return formatLink("web.clientecct_fondoceseww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV8MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Clientecct_fondoceseWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Convenio Fondo de cese laboral", "") ;
   }

   public void wbMG0( )
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
         wb_table1_9_MG2( true) ;
      }
      else
      {
         wb_table1_9_MG2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_MG2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV42DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_cliconvevigauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 141,'',false,'" + sGXsfl_110_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_cliconvevigauxdatetext_Internalname, AV32DDO_CliConveVigAuxDateText, GXutil.rtrim( localUtil.format( AV32DDO_CliConveVigAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,141);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_cliconvevigauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clientecct_fondoceseWW.htm");
         /* User Defined Control */
         ucTfcliconvevig_rangepicker.setProperty("Start Date", AV30DDO_CliConveVigAuxDate);
         ucTfcliconvevig_rangepicker.setProperty("End Date", AV31DDO_CliConveVigAuxDateTo);
         ucTfcliconvevig_rangepicker.render(context, "wwp.daterangepicker", Tfcliconvevig_rangepicker_Internalname, "TFCLICONVEVIG_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void startMG2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Convenio Fondo de cese laboral", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupMG0( ) ;
   }

   public void wsMG2( )
   {
      startMG2( ) ;
      evtMG2( ) ;
   }

   public void evtMG2( )
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
                           e11MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17MG2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18MG2 ();
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
                           A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
                           A1575CliConveVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtCliConveVig_Internalname), 0)) ;
                           A2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2148CliConveFondoMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2150CliConveFondoPrc = localUtil.ctond( httpContext.cgiGet( edtCliConveFondoPrc_Internalname)) ;
                           A2151CliConveFondoRem = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoRem.getInternalname())) ;
                           A2152CliConveFondoNre = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoNre.getInternalname())) ;
                           A2153CliConveFondoDes = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoDes.getInternalname())) ;
                           A2154CliConveFondoRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV17CliReDTChar = httpContext.cgiGet( edtavCliredtchar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCliredtchar_Internalname, AV17CliReDTChar);
                           AV47Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV47Update);
                           AV49Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV49Delete);
                           AV51Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV51Display);
                           AV18VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV18VerSVG);
                           AV19ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV19ModificarSVG);
                           AV20EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV20EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19MG2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20MG2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21MG2 ();
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

   public void weMG2( )
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

   public void paMG2( )
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
                                 byte AV65ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ,
                                 String AV78Pgmname ,
                                 String AV8MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 java.util.Date AV28TFCliConveVig ,
                                 java.util.Date AV29TFCliConveVig_To ,
                                 short AV33TFCliConveFondoSec ,
                                 short AV34TFCliConveFondoSec_To ,
                                 short AV35TFCliConveFondoMeses ,
                                 short AV36TFCliConveFondoMeses_To ,
                                 java.math.BigDecimal AV37TFCliConveFondoPrc ,
                                 java.math.BigDecimal AV38TFCliConveFondoPrc_To ,
                                 byte AV39TFCliConveFondoRem_Sel ,
                                 byte AV40TFCliConveFondoNre_Sel ,
                                 byte AV41TFCliConveFondoDes_Sel ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV59CliCod ,
                                 boolean AV48IsAuthorized_Update ,
                                 boolean AV50IsAuthorized_Delete ,
                                 boolean AV21WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20MG2 ();
      GRID_nCurrentRecord = 0 ;
      rfMG2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICONVE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIO", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEVIG", getSecureSignedToken( "", A1575CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVIG", localUtil.format(A1575CliConveVig, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEFONDOSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEFONDOSEC", GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), ".", "")));
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
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfMG2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV78Pgmname = "Clientecct_fondoceseWW" ;
      Gx_err = (short)(0) ;
      edtavCliredtchar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliredtchar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliredtchar_Enabled), 5, 0), !bGXsfl_110_Refreshing);
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

   public void rfMG2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e20MG2 ();
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
                                              AV79Clientecct_fondocesewwds_1_tfcliconvevig ,
                                              AV80Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                              Short.valueOf(AV81Clientecct_fondocesewwds_3_tfcliconvefondosec) ,
                                              Short.valueOf(AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to) ,
                                              Short.valueOf(AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses) ,
                                              Short.valueOf(AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) ,
                                              AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                              AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                              Byte.valueOf(AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel) ,
                                              Byte.valueOf(AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel) ,
                                              Byte.valueOf(AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel) ,
                                              A1575CliConveVig ,
                                              Short.valueOf(A2147CliConveFondoSec) ,
                                              Short.valueOf(A2148CliConveFondoMeses) ,
                                              A2150CliConveFondoPrc ,
                                              Boolean.valueOf(A2151CliConveFondoRem) ,
                                              Boolean.valueOf(A2152CliConveFondoNre) ,
                                              Boolean.valueOf(A2153CliConveFondoDes) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV59CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                              TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor H00MG2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV59CliCod), AV79Clientecct_fondocesewwds_1_tfcliconvevig, AV80Clientecct_fondocesewwds_2_tfcliconvevig_to, Short.valueOf(AV81Clientecct_fondocesewwds_3_tfcliconvefondosec), Short.valueOf(AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to), Short.valueOf(AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses), Short.valueOf(AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to), AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc, AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2154CliConveFondoRelSec = H00MG2_A2154CliConveFondoRelSec[0] ;
            A2153CliConveFondoDes = H00MG2_A2153CliConveFondoDes[0] ;
            A2152CliConveFondoNre = H00MG2_A2152CliConveFondoNre[0] ;
            A2151CliConveFondoRem = H00MG2_A2151CliConveFondoRem[0] ;
            A2150CliConveFondoPrc = H00MG2_A2150CliConveFondoPrc[0] ;
            A2148CliConveFondoMeses = H00MG2_A2148CliConveFondoMeses[0] ;
            A2147CliConveFondoSec = H00MG2_A2147CliConveFondoSec[0] ;
            A1575CliConveVig = H00MG2_A1575CliConveVig[0] ;
            A1565CliConvenio = H00MG2_A1565CliConvenio[0] ;
            A1564CliPaiConve = H00MG2_A1564CliPaiConve[0] ;
            A3CliCod = H00MG2_A3CliCod[0] ;
            e21MG2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbMG0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesMG2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV78Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV78Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV8MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV59CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV59CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV48IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV48IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV50IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEVIG"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, A1575CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEFONDOSEC"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9")));
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
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV79Clientecct_fondocesewwds_1_tfcliconvevig ,
                                           AV80Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                           Short.valueOf(AV81Clientecct_fondocesewwds_3_tfcliconvefondosec) ,
                                           Short.valueOf(AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to) ,
                                           Short.valueOf(AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses) ,
                                           Short.valueOf(AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) ,
                                           AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                           AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                           Byte.valueOf(AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel) ,
                                           Byte.valueOf(AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel) ,
                                           Byte.valueOf(AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel) ,
                                           A1575CliConveVig ,
                                           Short.valueOf(A2147CliConveFondoSec) ,
                                           Short.valueOf(A2148CliConveFondoMeses) ,
                                           A2150CliConveFondoPrc ,
                                           Boolean.valueOf(A2151CliConveFondoRem) ,
                                           Boolean.valueOf(A2152CliConveFondoNre) ,
                                           Boolean.valueOf(A2153CliConveFondoDes) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV59CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor H00MG3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV59CliCod), AV79Clientecct_fondocesewwds_1_tfcliconvevig, AV80Clientecct_fondocesewwds_2_tfcliconvevig_to, Short.valueOf(AV81Clientecct_fondocesewwds_3_tfcliconvefondosec), Short.valueOf(AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to), Short.valueOf(AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses), Short.valueOf(AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to), AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc, AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to});
      GRID_nRecordCount = H00MG3_AGRID_nRecordCount[0] ;
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
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV65ManageFiltersExecutionStep, AV25ColumnsSelector, AV78Pgmname, AV8MenuOpcCod, AV12GridState, AV28TFCliConveVig, AV29TFCliConveVig_To, AV33TFCliConveFondoSec, AV34TFCliConveFondoSec_To, AV35TFCliConveFondoMeses, AV36TFCliConveFondoMeses_To, AV37TFCliConveFondoPrc, AV38TFCliConveFondoPrc_To, AV39TFCliConveFondoRem_Sel, AV40TFCliConveFondoNre_Sel, AV41TFCliConveFondoDes_Sel, AV14OrderedBy, AV15OrderedDsc, AV59CliCod, AV48IsAuthorized_Update, AV50IsAuthorized_Delete, AV21WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV78Pgmname = "Clientecct_fondoceseWW" ;
      Gx_err = (short)(0) ;
      edtavCliredtchar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliredtchar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliredtchar_Enabled), 5, 0), !bGXsfl_110_Refreshing);
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

   public void strupMG0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19MG2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV42DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV25ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV63ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV44GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV45GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV46GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV30DDO_CliConveVigAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_CLICONVEVIGAUXDATE"), 0) ;
         AV31DDO_CliConveVigAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_CLICONVEVIGAUXDATETO"), 0) ;
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
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
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
         AV22WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
         AV32DDO_CliConveVigAuxDateText = httpContext.cgiGet( edtavDdo_cliconvevigauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32DDO_CliConveVigAuxDateText", AV32DDO_CliConveVigAuxDateText);
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
      e19MG2 ();
      if (returnInSub) return;
   }

   public void e19MG2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV8MenuOpcCod, "", "") ;
      GXt_int1 = AV59CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clientecct_fondoceseww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV59CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV59CliCod), "ZZZZZ9")));
      this.executeUsercontrolMethod("", false, "TFCLICONVEVIG_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_cliconvevigauxdatetext_Internalname});
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV9HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Convenio Fondo de cese laboral", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV42DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV42DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV54MenuBienveImgURL ;
      GXv_char6[0] = AV56MenuBienveTitulo ;
      GXv_char7[0] = AV57MenuBienveTexto ;
      GXv_boolean8[0] = AV58MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV8MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      clientecct_fondoceseww_impl.this.AV54MenuBienveImgURL = GXv_char5[0] ;
      clientecct_fondoceseww_impl.this.AV56MenuBienveTitulo = GXv_char6[0] ;
      clientecct_fondoceseww_impl.this.AV57MenuBienveTexto = GXv_char7[0] ;
      clientecct_fondoceseww_impl.this.AV58MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV58MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV58MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV56MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV57MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV22WelcomeMessage_Foto = AV54MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV22WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV22WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV22WelcomeMessage_Foto), true);
         AV77Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV54MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV22WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV22WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV22WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      clientecct_fondoceseww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV74observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV74observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV74observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV74observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e20MG2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV59CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clientecct_fondoceseww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV59CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV59CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV65ManageFiltersExecutionStep == 1 )
      {
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV65ManageFiltersExecutionStep == 2 )
      {
         AV65ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV27Session.getValue("Clientecct_fondoceseWWColumnsSelector"), "") != 0 )
      {
         AV23ColumnsSelectorXML = AV27Session.getValue("Clientecct_fondoceseWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV23ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtCliConveVig_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtCliConveFondoSec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoSec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtCliConveFondoMeses_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoMeses_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoMeses_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtCliConveFondoPrc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoPrc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoPrc_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkCliConveFondoRem.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoRem.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveFondoRem.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkCliConveFondoNre.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoNre.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveFondoNre.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkCliConveFondoDes.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoDes.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveFondoDes.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtavCliredtchar_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliredtchar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliredtchar_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV44GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44GridCurrentPage), 10, 0));
      AV45GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45GridPageCount), 10, 0));
      GXt_char10 = AV46GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV78Pgmname, GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV46GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46GridAppliedFilters", AV46GridAppliedFilters);
      GXt_char10 = AV70MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV8MenuOpcCod, GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV70MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV70MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV70MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV72filterCount) ;
      GXv_char7[0] = AV73filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char7) ;
      clientecct_fondoceseww_impl.this.AV72filterCount = GXv_int12[0] ;
      clientecct_fondoceseww_impl.this.AV73filtrosTexto = GXv_char7[0] ;
      if ( AV72filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV72filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV73filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = AV28TFCliConveVig ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = AV29TFCliConveVig_To ;
      AV81Clientecct_fondocesewwds_3_tfcliconvefondosec = AV33TFCliConveFondoSec ;
      AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV34TFCliConveFondoSec_To ;
      AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV35TFCliConveFondoMeses ;
      AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV36TFCliConveFondoMeses_To ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV37TFCliConveFondoPrc ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV38TFCliConveFondoPrc_To ;
      AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV39TFCliConveFondoRem_Sel ;
      AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV40TFCliConveFondoNre_Sel ;
      AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV41TFCliConveFondoDes_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25ColumnsSelector", AV25ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13MG2( )
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
         AV43PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV43PageToGo) ;
      }
   }

   public void e14MG2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15MG2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveVig") == 0 )
         {
            AV28TFCliConveVig = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFCliConveVig", localUtil.format(AV28TFCliConveVig, "99/99/99"));
            AV29TFCliConveVig_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCliConveVig_To", localUtil.format(AV29TFCliConveVig_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoSec") == 0 )
         {
            AV33TFCliConveFondoSec = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFCliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFCliConveFondoSec), 4, 0));
            AV34TFCliConveFondoSec_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFCliConveFondoSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFCliConveFondoSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoMeses") == 0 )
         {
            AV35TFCliConveFondoMeses = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFCliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFCliConveFondoMeses), 4, 0));
            AV36TFCliConveFondoMeses_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFCliConveFondoMeses_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFCliConveFondoMeses_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoPrc") == 0 )
         {
            AV37TFCliConveFondoPrc = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFCliConveFondoPrc", GXutil.ltrimstr( AV37TFCliConveFondoPrc, 6, 4));
            AV38TFCliConveFondoPrc_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFCliConveFondoPrc_To", GXutil.ltrimstr( AV38TFCliConveFondoPrc_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoRem") == 0 )
         {
            AV39TFCliConveFondoRem_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFCliConveFondoRem_Sel", GXutil.str( AV39TFCliConveFondoRem_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoNre") == 0 )
         {
            AV40TFCliConveFondoNre_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFCliConveFondoNre_Sel", GXutil.str( AV40TFCliConveFondoNre_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliConveFondoDes") == 0 )
         {
            AV41TFCliConveFondoDes_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFCliConveFondoDes_Sel", GXutil.str( AV41TFCliConveFondoDes_Sel, 1, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e21MG2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV47Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV47Update);
      if ( AV48IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.clientecct_fondocese", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(A1575CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(A2147CliConveFondoSec,4,0))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"})  ;
      }
      AV49Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV49Delete);
      if ( AV50IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.clientecct_fondocese", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(A1575CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(A2147CliConveFondoSec,4,0))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"})  ;
      }
      AV51Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV51Display);
      edtavDisplay_Link = formatLink("web.clientecct_fondoceseview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(A1575CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(A2147CliConveFondoSec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec","TabCode"})  ;
      edtCliConveFondoMeses_Link = formatLink("web.clientecct_fondoceseview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(A1575CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(A2147CliConveFondoSec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec","TabCode"})  ;
      GXt_char10 = AV17CliReDTChar ;
      GXv_char7[0] = GXt_char10 ;
      new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A2154CliConveFondoRelSec, GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV17CliReDTChar = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCliredtchar_Internalname, AV17CliReDTChar);
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV18VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV18VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV18VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV19ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV19ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV19ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV20EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV20EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV20EliminarSVG);
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

   public void e11MG2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV23ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV25ColumnsSelector.fromJSonString(AV23ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Clientecct_fondoceseWWColumnsSelector", ((GXutil.strcmp("", AV23ColumnsSelectorXML)==0) ? "" : AV25ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25ColumnsSelector", AV25ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12MG2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Clientecct_fondoceseWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV78Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Clientecct_fondoceseWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV65ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ManageFiltersExecutionStep", GXutil.str( AV65ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV64ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Clientecct_fondoceseWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV64ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV64ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV78Pgmname+"GridState", AV64ManageFiltersXml) ;
            AV12GridState.fromxml(AV64ManageFiltersXml, null, null);
            AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
            AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25ColumnsSelector", AV25ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV63ManageFiltersData", AV63ManageFiltersData);
   }

   public void e16MG2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.clientecct_fondocese", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.formatDateParm(GXutil.nullDate())),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17MG2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV61ExcelFilename ;
      GXv_char6[0] = AV62ErrorMessage ;
      new web.clientecct_fondocesewwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      clientecct_fondoceseww_impl.this.AV61ExcelFilename = GXv_char7[0] ;
      clientecct_fondoceseww_impl.this.AV62ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV61ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV61ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV62ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveVig", "", "Fecha de vigencia", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoSec", "", "Fondo Sec", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoMeses", "", "Meses desde", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoPrc", "", "Porcentaje", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoRem", "", "Contemplar remunerativos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoNre", "", "Contemplar no remunerativos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliConveFondoDes", "", "Contemplar descuentos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV24UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Clientecct_fondoceseWWColumnsSelector", GXv_char7) ;
      clientecct_fondoceseww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV24UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV24UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV24UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV25ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV59CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV48IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Update", GXv_boolean8) ;
      clientecct_fondoceseww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV48IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48IsAuthorized_Update", AV48IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV48IsAuthorized_Update));
      if ( ! ( AV48IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV50IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Delete", GXv_boolean8) ;
      clientecct_fondoceseww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV50IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50IsAuthorized_Delete", AV50IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      if ( ! ( AV50IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV53TempBoolean ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Insert", GXv_boolean8) ;
      clientecct_fondoceseww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV53TempBoolean = GXt_boolean15 ;
      if ( ! ( AV53TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV63ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Clientecct_fondoceseWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV63ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV28TFCliConveVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFCliConveVig", localUtil.format(AV28TFCliConveVig, "99/99/99"));
      AV29TFCliConveVig_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFCliConveVig_To", localUtil.format(AV29TFCliConveVig_To, "99/99/99"));
      AV33TFCliConveFondoSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFCliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFCliConveFondoSec), 4, 0));
      AV34TFCliConveFondoSec_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFCliConveFondoSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFCliConveFondoSec_To), 4, 0));
      AV35TFCliConveFondoMeses = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFCliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFCliConveFondoMeses), 4, 0));
      AV36TFCliConveFondoMeses_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFCliConveFondoMeses_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFCliConveFondoMeses_To), 4, 0));
      AV37TFCliConveFondoPrc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFCliConveFondoPrc", GXutil.ltrimstr( AV37TFCliConveFondoPrc, 6, 4));
      AV38TFCliConveFondoPrc_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFCliConveFondoPrc_To", GXutil.ltrimstr( AV38TFCliConveFondoPrc_To, 6, 4));
      AV39TFCliConveFondoRem_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFCliConveFondoRem_Sel", GXutil.str( AV39TFCliConveFondoRem_Sel, 1, 0));
      AV40TFCliConveFondoNre_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFCliConveFondoNre_Sel", GXutil.str( AV40TFCliConveFondoNre_Sel, 1, 0));
      AV41TFCliConveFondoDes_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFCliConveFondoDes_Sel", GXutil.str( AV41TFCliConveFondoDes_Sel, 1, 0));
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
      if ( GXutil.strcmp(AV27Session.getValue(AV78Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV78Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV27Session.getValue(AV78Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV12GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV90GXV1 = 1 ;
      while ( AV90GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV90GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVIG") == 0 )
         {
            AV28TFCliConveVig = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFCliConveVig", localUtil.format(AV28TFCliConveVig, "99/99/99"));
            AV29TFCliConveVig_To = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFCliConveVig_To", localUtil.format(AV29TFCliConveVig_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOSEC") == 0 )
         {
            AV33TFCliConveFondoSec = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFCliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFCliConveFondoSec), 4, 0));
            AV34TFCliConveFondoSec_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFCliConveFondoSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFCliConveFondoSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOMESES") == 0 )
         {
            AV35TFCliConveFondoMeses = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFCliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFCliConveFondoMeses), 4, 0));
            AV36TFCliConveFondoMeses_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFCliConveFondoMeses_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFCliConveFondoMeses_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOPRC") == 0 )
         {
            AV37TFCliConveFondoPrc = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFCliConveFondoPrc", GXutil.ltrimstr( AV37TFCliConveFondoPrc, 6, 4));
            AV38TFCliConveFondoPrc_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFCliConveFondoPrc_To", GXutil.ltrimstr( AV38TFCliConveFondoPrc_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOREM_SEL") == 0 )
         {
            AV39TFCliConveFondoRem_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFCliConveFondoRem_Sel", GXutil.str( AV39TFCliConveFondoRem_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDONRE_SEL") == 0 )
         {
            AV40TFCliConveFondoNre_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFCliConveFondoNre_Sel", GXutil.str( AV40TFCliConveFondoNre_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDODES_SEL") == 0 )
         {
            AV41TFCliConveFondoDes_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFCliConveFondoDes_Sel", GXutil.str( AV41TFCliConveFondoDes_Sel, 1, 0));
         }
         AV90GXV1 = (int)(AV90GXV1+1) ;
      }
      Ddo_grid_Selectedvalue_set = "||||"+((0==AV39TFCliConveFondoRem_Sel) ? "" : GXutil.str( AV39TFCliConveFondoRem_Sel, 1, 0))+"|"+((0==AV40TFCliConveFondoNre_Sel) ? "" : GXutil.str( AV40TFCliConveFondoNre_Sel, 1, 0))+"|"+((0==AV41TFCliConveFondoDes_Sel) ? "" : GXutil.str( AV41TFCliConveFondoDes_Sel, 1, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV28TFCliConveVig)) ? "" : localUtil.dtoc( AV28TFCliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((0==AV33TFCliConveFondoSec) ? "" : GXutil.str( AV33TFCliConveFondoSec, 4, 0))+"|"+((0==AV35TFCliConveFondoMeses) ? "" : GXutil.str( AV35TFCliConveFondoMeses, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFCliConveFondoPrc)==0) ? "" : GXutil.str( AV37TFCliConveFondoPrc, 6, 4))+"||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV29TFCliConveVig_To)) ? "" : localUtil.dtoc( AV29TFCliConveVig_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((0==AV34TFCliConveFondoSec_To) ? "" : GXutil.str( AV34TFCliConveFondoSec_To, 4, 0))+"|"+((0==AV36TFCliConveFondoMeses_To) ? "" : GXutil.str( AV36TFCliConveFondoMeses_To, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFCliConveFondoPrc_To)==0) ? "" : GXutil.str( AV38TFCliConveFondoPrc_To, 6, 4))+"||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV27Session.getValue(AV78Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEVIG", httpContext.getMessage( "Fecha de vigencia", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV28TFCliConveVig))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV29TFCliConveVig_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV28TFCliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV29TFCliConveVig_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDOSEC", httpContext.getMessage( "Fondo Sec", ""), !((0==AV33TFCliConveFondoSec)&&(0==AV34TFCliConveFondoSec_To)), (short)(0), GXutil.trim( GXutil.str( AV33TFCliConveFondoSec, 4, 0)), GXutil.trim( GXutil.str( AV34TFCliConveFondoSec_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDOMESES", httpContext.getMessage( "Meses desde", ""), !((0==AV35TFCliConveFondoMeses)&&(0==AV36TFCliConveFondoMeses_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFCliConveFondoMeses, 4, 0)), GXutil.trim( GXutil.str( AV36TFCliConveFondoMeses_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDOPRC", httpContext.getMessage( "Porcentaje", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFCliConveFondoPrc)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFCliConveFondoPrc_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV37TFCliConveFondoPrc, 6, 4)), GXutil.trim( GXutil.str( AV38TFCliConveFondoPrc_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDOREM_SEL", httpContext.getMessage( "Contemplar remunerativos", ""), !(0==AV39TFCliConveFondoRem_Sel), (short)(0), GXutil.trim( GXutil.str( AV39TFCliConveFondoRem_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDONRE_SEL", httpContext.getMessage( "Contemplar no remunerativos", ""), !(0==AV40TFCliConveFondoNre_Sel), (short)(0), GXutil.trim( GXutil.str( AV40TFCliConveFondoNre_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCLICONVEFONDODES_SEL", httpContext.getMessage( "Contemplar descuentos", ""), !(0==AV41TFCliConveFondoDes_Sel), (short)(0), GXutil.trim( GXutil.str( AV41TFCliConveFondoDes_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (GXutil.strcmp("", AV8MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV8MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV78Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV78Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Clientecct_fondocese" );
      AV27Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18MG2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV21WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV8MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV55textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV59CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         clientecct_fondoceseww_impl.this.AV55textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV55textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV8MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_MG2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_MG2( true) ;
      }
      else
      {
         wb_table2_12_MG2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_MG2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_MG2e( true) ;
      }
      else
      {
         wb_table1_9_MG2e( false) ;
      }
   }

   public void wb_table2_12_MG2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e22mg1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Clientecct_fondoceseWW.htm");
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
         AV22WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV22WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV77Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV22WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV22WelcomeMessage_Foto)==0) ? AV77Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV22WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV22WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clientecct_fondoceseWW.htm");
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
         wb_table3_30_MG2( true) ;
      }
      else
      {
         wb_table3_30_MG2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_MG2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_MG2( true) ;
      }
      else
      {
         wb_table4_35_MG2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_MG2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
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
         wb_table5_54_MG2( true) ;
      }
      else
      {
         wb_table5_54_MG2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_MG2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_MG2( true) ;
      }
      else
      {
         wb_table6_63_MG2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_MG2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV44GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV45GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV46GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_MG2e( true) ;
      }
      else
      {
         wb_table2_12_MG2e( false) ;
      }
   }

   public void wb_table6_63_MG2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Clientecct_fondoceseWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV42DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV25ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV63ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clientecct_fondoceseWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clientecct_fondoceseWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Clientecct_fondoceseWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_MG2( true) ;
      }
      else
      {
         wb_table7_99_MG2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_MG2e( boolean wbgen )
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
         wb_table6_63_MG2e( true) ;
      }
      else
      {
         wb_table6_63_MG2e( false) ;
      }
   }

   public void wb_table7_99_MG2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_MG2e( true) ;
      }
      else
      {
         wb_table7_99_MG2e( false) ;
      }
   }

   public void wb_table5_54_MG2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_MG2e( true) ;
      }
      else
      {
         wb_table5_54_MG2e( false) ;
      }
   }

   public void wb_table4_35_MG2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_MG2e( true) ;
      }
      else
      {
         wb_table4_35_MG2e( false) ;
      }
   }

   public void wb_table3_30_MG2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondoceseWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_MG2e( true) ;
      }
      else
      {
         wb_table3_30_MG2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8MenuOpcCod", AV8MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MenuOpcCod, ""))));
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
      paMG2( ) ;
      wsMG2( ) ;
      weMG2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713263020", true, true);
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
      httpContext.AddJavascriptSource("clientecct_fondoceseww.js", "?20251713263020", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_idx ;
      edtCliPaiConve_Internalname = "CLIPAICONVE_"+sGXsfl_110_idx ;
      edtCliConvenio_Internalname = "CLICONVENIO_"+sGXsfl_110_idx ;
      edtCliConveVig_Internalname = "CLICONVEVIG_"+sGXsfl_110_idx ;
      edtCliConveFondoSec_Internalname = "CLICONVEFONDOSEC_"+sGXsfl_110_idx ;
      edtCliConveFondoMeses_Internalname = "CLICONVEFONDOMESES_"+sGXsfl_110_idx ;
      edtCliConveFondoPrc_Internalname = "CLICONVEFONDOPRC_"+sGXsfl_110_idx ;
      chkCliConveFondoRem.setInternalname( "CLICONVEFONDOREM_"+sGXsfl_110_idx );
      chkCliConveFondoNre.setInternalname( "CLICONVEFONDONRE_"+sGXsfl_110_idx );
      chkCliConveFondoDes.setInternalname( "CLICONVEFONDODES_"+sGXsfl_110_idx );
      edtCliConveFondoRelSec_Internalname = "CLICONVEFONDORELSEC_"+sGXsfl_110_idx ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR_"+sGXsfl_110_idx ;
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
      edtCliPaiConve_Internalname = "CLIPAICONVE_"+sGXsfl_110_fel_idx ;
      edtCliConvenio_Internalname = "CLICONVENIO_"+sGXsfl_110_fel_idx ;
      edtCliConveVig_Internalname = "CLICONVEVIG_"+sGXsfl_110_fel_idx ;
      edtCliConveFondoSec_Internalname = "CLICONVEFONDOSEC_"+sGXsfl_110_fel_idx ;
      edtCliConveFondoMeses_Internalname = "CLICONVEFONDOMESES_"+sGXsfl_110_fel_idx ;
      edtCliConveFondoPrc_Internalname = "CLICONVEFONDOPRC_"+sGXsfl_110_fel_idx ;
      chkCliConveFondoRem.setInternalname( "CLICONVEFONDOREM_"+sGXsfl_110_fel_idx );
      chkCliConveFondoNre.setInternalname( "CLICONVEFONDONRE_"+sGXsfl_110_fel_idx );
      chkCliConveFondoDes.setInternalname( "CLICONVEFONDODES_"+sGXsfl_110_fel_idx );
      edtCliConveFondoRelSec_Internalname = "CLICONVEFONDORELSEC_"+sGXsfl_110_fel_idx ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR_"+sGXsfl_110_fel_idx ;
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
      wbMG0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliPaiConve_Internalname,GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliPaiConve_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConvenio_Internalname,GXutil.rtrim( A1565CliConvenio),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConvenio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliConveVig_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVig_Internalname,localUtil.format(A1575CliConveVig, "99/99/99"),localUtil.format( A1575CliConveVig, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliConveVig_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliConveFondoSec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveFondoSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveFondoSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliConveFondoSec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliConveFondoMeses_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveFondoMeses_Internalname,GXutil.ltrim( localUtil.ntoc( A2148CliConveFondoMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'",edtCliConveFondoMeses_Link,"","","",edtCliConveFondoMeses_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliConveFondoMeses_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliConveFondoPrc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveFondoPrc_Internalname,GXutil.ltrim( localUtil.ntoc( A2150CliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A2150CliConveFondoPrc, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveFondoPrc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliConveFondoPrc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkCliConveFondoRem.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CLICONVEFONDOREM_" + sGXsfl_110_idx ;
         chkCliConveFondoRem.setName( GXCCtl );
         chkCliConveFondoRem.setWebtags( "" );
         chkCliConveFondoRem.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoRem.getInternalname(), "TitleCaption", chkCliConveFondoRem.getCaption(), !bGXsfl_110_Refreshing);
         chkCliConveFondoRem.setCheckedValue( "false" );
         A2151CliConveFondoRem = GXutil.strtobool( GXutil.booltostr( A2151CliConveFondoRem)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCliConveFondoRem.getInternalname(),GXutil.booltostr( A2151CliConveFondoRem),"","",Integer.valueOf(chkCliConveFondoRem.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkCliConveFondoNre.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CLICONVEFONDONRE_" + sGXsfl_110_idx ;
         chkCliConveFondoNre.setName( GXCCtl );
         chkCliConveFondoNre.setWebtags( "" );
         chkCliConveFondoNre.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoNre.getInternalname(), "TitleCaption", chkCliConveFondoNre.getCaption(), !bGXsfl_110_Refreshing);
         chkCliConveFondoNre.setCheckedValue( "false" );
         A2152CliConveFondoNre = GXutil.strtobool( GXutil.booltostr( A2152CliConveFondoNre)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCliConveFondoNre.getInternalname(),GXutil.booltostr( A2152CliConveFondoNre),"","",Integer.valueOf(chkCliConveFondoNre.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkCliConveFondoDes.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CLICONVEFONDODES_" + sGXsfl_110_idx ;
         chkCliConveFondoDes.setName( GXCCtl );
         chkCliConveFondoDes.setWebtags( "" );
         chkCliConveFondoDes.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoDes.getInternalname(), "TitleCaption", chkCliConveFondoDes.getCaption(), !bGXsfl_110_Refreshing);
         chkCliConveFondoDes.setCheckedValue( "false" );
         A2153CliConveFondoDes = GXutil.strtobool( GXutil.booltostr( A2153CliConveFondoDes)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCliConveFondoDes.getInternalname(),GXutil.booltostr( A2153CliConveFondoDes),"","",Integer.valueOf(chkCliConveFondoDes.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveFondoRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2154CliConveFondoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveFondoRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavCliredtchar_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCliredtchar_Internalname,AV17CliReDTChar,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCliredtchar_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavCliredtchar_Visible),Integer.valueOf(edtavCliredtchar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV47Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV49Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV51Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV18VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV19ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV20EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesMG2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliConveVig_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliConveFondoSec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fondo Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliConveFondoMeses_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Meses desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliConveFondoPrc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Porcentaje", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkCliConveFondoRem.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contemplar remunerativos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkCliConveFondoNre.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contemplar no remunerativos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkCliConveFondoDes.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contemplar descuentos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavCliredtchar_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha/hora de liberación", "")) ;
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
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1565CliConvenio));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A1575CliConveVig, "99/99/99"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveVig_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveFondoSec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2148CliConveFondoMeses, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCliConveFondoMeses_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveFondoMeses_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2150CliConveFondoPrc, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveFondoPrc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2151CliConveFondoRem));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkCliConveFondoRem.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2152CliConveFondoNre));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkCliConveFondoNre.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2153CliConveFondoDes));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkCliConveFondoDes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2154CliConveFondoRelSec, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV17CliReDTChar);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCliredtchar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavCliredtchar_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV47Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV49Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV19ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV20EliminarSVG));
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
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      edtCliConveVig_Internalname = "CLICONVEVIG" ;
      edtCliConveFondoSec_Internalname = "CLICONVEFONDOSEC" ;
      edtCliConveFondoMeses_Internalname = "CLICONVEFONDOMESES" ;
      edtCliConveFondoPrc_Internalname = "CLICONVEFONDOPRC" ;
      chkCliConveFondoRem.setInternalname( "CLICONVEFONDOREM" );
      chkCliConveFondoNre.setInternalname( "CLICONVEFONDONRE" );
      chkCliConveFondoDes.setInternalname( "CLICONVEFONDODES" );
      edtCliConveFondoRelSec_Internalname = "CLICONVEFONDORELSEC" ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR" ;
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
      edtavDdo_cliconvevigauxdatetext_Internalname = "vDDO_CLICONVEVIGAUXDATETEXT" ;
      Tfcliconvevig_rangepicker_Internalname = "TFCLICONVEVIG_RANGEPICKER" ;
      divDdo_cliconvevigauxdates_Internalname = "DDO_CLICONVEVIGAUXDATES" ;
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
      edtavCliredtchar_Jsonclick = "" ;
      edtavCliredtchar_Enabled = 0 ;
      edtCliConveFondoRelSec_Jsonclick = "" ;
      chkCliConveFondoDes.setCaption( "" );
      chkCliConveFondoNre.setCaption( "" );
      chkCliConveFondoRem.setCaption( "" );
      edtCliConveFondoPrc_Jsonclick = "" ;
      edtCliConveFondoMeses_Jsonclick = "" ;
      edtCliConveFondoMeses_Link = "" ;
      edtCliConveFondoSec_Jsonclick = "" ;
      edtCliConveVig_Jsonclick = "" ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliPaiConve_Jsonclick = "" ;
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
      edtavCliredtchar_Visible = -1 ;
      chkCliConveFondoDes.setVisible( -1 );
      chkCliConveFondoNre.setVisible( -1 );
      chkCliConveFondoRem.setVisible( -1 );
      edtCliConveFondoPrc_Visible = -1 ;
      edtCliConveFondoMeses_Visible = -1 ;
      edtCliConveFondoSec_Visible = -1 ;
      edtCliConveVig_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_cliconvevigauxdatetext_Jsonclick = "" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|4.0|4.0|6.4||||" ;
      Ddo_grid_Datalistfixedvalues = "||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|" ;
      Ddo_grid_Datalisttype = "||||FixedValues|FixedValues|FixedValues|" ;
      Ddo_grid_Includedatalist = "||||T|T|T|" ;
      Ddo_grid_Filterisrange = "P|T|T|T||||" ;
      Ddo_grid_Filtertype = "Date|Numeric|Numeric|Numeric||||" ;
      Ddo_grid_Includefilter = "T|T|T|T||||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T|" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|" ;
      Ddo_grid_Columnids = "3:CliConveVig|4:CliConveFondoSec|5:CliConveFondoMeses|6:CliConveFondoPrc|7:CliConveFondoRem|8:CliConveFondoNre|9:CliConveFondoDes|11:CliReDTChar" ;
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
      Form.setCaption( httpContext.getMessage( " Convenio Fondo de cese laboral", "") );
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
      AV21WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV21WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21WelcomeMessage_NoMostrarMas", AV21WelcomeMessage_NoMostrarMas);
      GXCCtl = "CLICONVEFONDOREM_" + sGXsfl_110_idx ;
      chkCliConveFondoRem.setName( GXCCtl );
      chkCliConveFondoRem.setWebtags( "" );
      chkCliConveFondoRem.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoRem.getInternalname(), "TitleCaption", chkCliConveFondoRem.getCaption(), !bGXsfl_110_Refreshing);
      chkCliConveFondoRem.setCheckedValue( "false" );
      A2151CliConveFondoRem = GXutil.strtobool( GXutil.booltostr( A2151CliConveFondoRem)) ;
      GXCCtl = "CLICONVEFONDONRE_" + sGXsfl_110_idx ;
      chkCliConveFondoNre.setName( GXCCtl );
      chkCliConveFondoNre.setWebtags( "" );
      chkCliConveFondoNre.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoNre.getInternalname(), "TitleCaption", chkCliConveFondoNre.getCaption(), !bGXsfl_110_Refreshing);
      chkCliConveFondoNre.setCheckedValue( "false" );
      A2152CliConveFondoNre = GXutil.strtobool( GXutil.booltostr( A2152CliConveFondoNre)) ;
      GXCCtl = "CLICONVEFONDODES_" + sGXsfl_110_idx ;
      chkCliConveFondoDes.setName( GXCCtl );
      chkCliConveFondoDes.setWebtags( "" );
      chkCliConveFondoDes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoDes.getInternalname(), "TitleCaption", chkCliConveFondoDes.getCaption(), !bGXsfl_110_Refreshing);
      chkCliConveFondoDes.setCheckedValue( "false" );
      A2153CliConveFondoDes = GXutil.strtobool( GXutil.booltostr( A2153CliConveFondoDes)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliConveVig_Visible',ctrl:'CLICONVEVIG',prop:'Visible'},{av:'edtCliConveFondoSec_Visible',ctrl:'CLICONVEFONDOSEC',prop:'Visible'},{av:'edtCliConveFondoMeses_Visible',ctrl:'CLICONVEFONDOMESES',prop:'Visible'},{av:'edtCliConveFondoPrc_Visible',ctrl:'CLICONVEFONDOPRC',prop:'Visible'},{av:'chkCliConveFondoRem.getVisible()',ctrl:'CLICONVEFONDOREM',prop:'Visible'},{av:'chkCliConveFondoNre.getVisible()',ctrl:'CLICONVEFONDONRE',prop:'Visible'},{av:'chkCliConveFondoDes.getVisible()',ctrl:'CLICONVEFONDODES',prop:'Visible'},{av:'edtavCliredtchar_Visible',ctrl:'vCLIREDTCHAR',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13MG2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14MG2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15MG2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21MG2',iparms:[{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:'',hsh:true},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV47Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV49Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV51Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtCliConveFondoMeses_Link',ctrl:'CLICONVEFONDOMESES',prop:'Link'},{av:'AV17CliReDTChar',fld:'vCLIREDTCHAR',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV18VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV19ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV20EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11MG2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtCliConveVig_Visible',ctrl:'CLICONVEVIG',prop:'Visible'},{av:'edtCliConveFondoSec_Visible',ctrl:'CLICONVEFONDOSEC',prop:'Visible'},{av:'edtCliConveFondoMeses_Visible',ctrl:'CLICONVEFONDOMESES',prop:'Visible'},{av:'edtCliConveFondoPrc_Visible',ctrl:'CLICONVEFONDOPRC',prop:'Visible'},{av:'chkCliConveFondoRem.getVisible()',ctrl:'CLICONVEFONDOREM',prop:'Visible'},{av:'chkCliConveFondoNre.getVisible()',ctrl:'CLICONVEFONDONRE',prop:'Visible'},{av:'chkCliConveFondoDes.getVisible()',ctrl:'CLICONVEFONDODES',prop:'Visible'},{av:'edtavCliredtchar_Visible',ctrl:'vCLIREDTCHAR',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12MG2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV65ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFCliConveVig',fld:'vTFCLICONVEVIG',pic:''},{av:'AV29TFCliConveVig_To',fld:'vTFCLICONVEVIG_TO',pic:''},{av:'AV33TFCliConveFondoSec',fld:'vTFCLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV34TFCliConveFondoSec_To',fld:'vTFCLICONVEFONDOSEC_TO',pic:'ZZZ9'},{av:'AV35TFCliConveFondoMeses',fld:'vTFCLICONVEFONDOMESES',pic:'ZZZ9'},{av:'AV36TFCliConveFondoMeses_To',fld:'vTFCLICONVEFONDOMESES_TO',pic:'ZZZ9'},{av:'AV37TFCliConveFondoPrc',fld:'vTFCLICONVEFONDOPRC',pic:'9.9999'},{av:'AV38TFCliConveFondoPrc_To',fld:'vTFCLICONVEFONDOPRC_TO',pic:'9.9999'},{av:'AV39TFCliConveFondoRem_Sel',fld:'vTFCLICONVEFONDOREM_SEL',pic:'9'},{av:'AV40TFCliConveFondoNre_Sel',fld:'vTFCLICONVEFONDONRE_SEL',pic:'9'},{av:'AV41TFCliConveFondoDes_Sel',fld:'vTFCLICONVEFONDODES_SEL',pic:'9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliConveVig_Visible',ctrl:'CLICONVEVIG',prop:'Visible'},{av:'edtCliConveFondoSec_Visible',ctrl:'CLICONVEFONDOSEC',prop:'Visible'},{av:'edtCliConveFondoMeses_Visible',ctrl:'CLICONVEFONDOMESES',prop:'Visible'},{av:'edtCliConveFondoPrc_Visible',ctrl:'CLICONVEFONDOPRC',prop:'Visible'},{av:'chkCliConveFondoRem.getVisible()',ctrl:'CLICONVEFONDOREM',prop:'Visible'},{av:'chkCliConveFondoNre.getVisible()',ctrl:'CLICONVEFONDONRE',prop:'Visible'},{av:'chkCliConveFondoDes.getVisible()',ctrl:'CLICONVEFONDODES',prop:'Visible'},{av:'edtavCliredtchar_Visible',ctrl:'vCLIREDTCHAR',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV44GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV46GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV48IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV63ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16MG2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:'',hsh:true},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17MG2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18MG2',iparms:[{av:'AV21WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV8MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV59CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e22MG1',iparms:[]");
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
      wcpOAV8MenuOpcCod = "" ;
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
      AV8MenuOpcCod = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV78Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28TFCliConveVig = GXutil.nullDate() ;
      AV29TFCliConveVig_To = GXutil.nullDate() ;
      AV37TFCliConveFondoPrc = DecimalUtil.ZERO ;
      AV38TFCliConveFondoPrc_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV42DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV63ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV46GridAppliedFilters = "" ;
      AV30DDO_CliConveVigAuxDate = GXutil.nullDate() ;
      AV31DDO_CliConveVigAuxDateTo = GXutil.nullDate() ;
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
      TempTags = "" ;
      AV32DDO_CliConveVigAuxDateText = "" ;
      ucTfcliconvevig_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      AV17CliReDTChar = "" ;
      AV47Update = "" ;
      AV49Delete = "" ;
      AV51Display = "" ;
      AV18VerSVG = "" ;
      AV19ModificarSVG = "" ;
      AV20EliminarSVG = "" ;
      scmdbuf = "" ;
      AV79Clientecct_fondocesewwds_1_tfcliconvevig = GXutil.nullDate() ;
      AV80Clientecct_fondocesewwds_2_tfcliconvevig_to = GXutil.nullDate() ;
      AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc = DecimalUtil.ZERO ;
      AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = DecimalUtil.ZERO ;
      H00MG2_A2154CliConveFondoRelSec = new int[1] ;
      H00MG2_A2153CliConveFondoDes = new boolean[] {false} ;
      H00MG2_A2152CliConveFondoNre = new boolean[] {false} ;
      H00MG2_A2151CliConveFondoRem = new boolean[] {false} ;
      H00MG2_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00MG2_A2148CliConveFondoMeses = new short[1] ;
      H00MG2_A2147CliConveFondoSec = new short[1] ;
      H00MG2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00MG2_A1565CliConvenio = new String[] {""} ;
      H00MG2_A1564CliPaiConve = new short[1] ;
      H00MG2_A3CliCod = new int[1] ;
      H00MG3_AGRID_nRecordCount = new long[1] ;
      AV22WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV54MenuBienveImgURL = "" ;
      GXv_char5 = new String[1] ;
      AV56MenuBienveTitulo = "" ;
      AV57MenuBienveTexto = "" ;
      AV77Welcomemessage_foto_GXI = "" ;
      GXt_char9 = "" ;
      AV74observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV23ColumnsSelectorXML = "" ;
      AV70MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV73filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV64ManageFiltersXml = "" ;
      AV61ExcelFilename = "" ;
      AV62ErrorMessage = "" ;
      GXv_char6 = new String[1] ;
      AV24UserCustomValue = "" ;
      GXt_char10 = "" ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV55textoNoMostrara = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_fondoceseww__default(),
         new Object[] {
             new Object[] {
            H00MG2_A2154CliConveFondoRelSec, H00MG2_A2153CliConveFondoDes, H00MG2_A2152CliConveFondoNre, H00MG2_A2151CliConveFondoRem, H00MG2_A2150CliConveFondoPrc, H00MG2_A2148CliConveFondoMeses, H00MG2_A2147CliConveFondoSec, H00MG2_A1575CliConveVig, H00MG2_A1565CliConvenio, H00MG2_A1564CliPaiConve,
            H00MG2_A3CliCod
            }
            , new Object[] {
            H00MG3_AGRID_nRecordCount
            }
         }
      );
      AV78Pgmname = "Clientecct_fondoceseWW" ;
      /* GeneXus formulas. */
      AV78Pgmname = "Clientecct_fondoceseWW" ;
      Gx_err = (short)(0) ;
      edtavCliredtchar_Enabled = 0 ;
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
   private byte AV65ManageFiltersExecutionStep ;
   private byte AV39TFCliConveFondoRem_Sel ;
   private byte AV40TFCliConveFondoNre_Sel ;
   private byte AV41TFCliConveFondoDes_Sel ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel ;
   private byte AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel ;
   private byte AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV33TFCliConveFondoSec ;
   private short AV34TFCliConveFondoSec_To ;
   private short AV35TFCliConveFondoMeses ;
   private short AV36TFCliConveFondoMeses_To ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1564CliPaiConve ;
   private short A2147CliConveFondoSec ;
   private short A2148CliConveFondoMeses ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV81Clientecct_fondocesewwds_3_tfcliconvefondosec ;
   private short AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to ;
   private short AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses ;
   private short AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV59CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A2154CliConveFondoRelSec ;
   private int subGrid_Islastpage ;
   private int edtavCliredtchar_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtCliConveVig_Visible ;
   private int edtCliConveFondoSec_Visible ;
   private int edtCliConveFondoMeses_Visible ;
   private int edtCliConveFondoPrc_Visible ;
   private int edtavCliredtchar_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV72filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV43PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV90GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV44GridCurrentPage ;
   private long AV45GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV37TFCliConveFondoPrc ;
   private java.math.BigDecimal AV38TFCliConveFondoPrc_To ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private java.math.BigDecimal AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc ;
   private java.math.BigDecimal AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ;
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
   private String AV78Pgmname ;
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
   private String Ddo_grid_Datalistfixedvalues ;
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
   private String divDdo_cliconvevigauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_cliconvevigauxdatetext_Internalname ;
   private String edtavDdo_cliconvevigauxdatetext_Jsonclick ;
   private String Tfcliconvevig_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String edtCliPaiConve_Internalname ;
   private String A1565CliConvenio ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConveVig_Internalname ;
   private String edtCliConveFondoSec_Internalname ;
   private String edtCliConveFondoMeses_Internalname ;
   private String edtCliConveFondoPrc_Internalname ;
   private String edtCliConveFondoRelSec_Internalname ;
   private String edtavCliredtchar_Internalname ;
   private String AV47Update ;
   private String edtavUpdate_Internalname ;
   private String AV49Delete ;
   private String edtavDelete_Internalname ;
   private String AV51Display ;
   private String edtavDisplay_Internalname ;
   private String AV18VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV19ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV20EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char5[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char9 ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV74observerPalabra ;
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
   private String edtCliConveFondoMeses_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String GXv_char6[] ;
   private String GXt_char10 ;
   private String bttBtninsert_Internalname ;
   private String GXv_char7[] ;
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
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Jsonclick ;
   private String edtCliConveVig_Jsonclick ;
   private String edtCliConveFondoSec_Jsonclick ;
   private String edtCliConveFondoMeses_Jsonclick ;
   private String edtCliConveFondoPrc_Jsonclick ;
   private String GXCCtl ;
   private String edtCliConveFondoRelSec_Jsonclick ;
   private String edtavCliredtchar_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV28TFCliConveVig ;
   private java.util.Date AV29TFCliConveVig_To ;
   private java.util.Date AV30DDO_CliConveVigAuxDate ;
   private java.util.Date AV31DDO_CliConveVigAuxDateTo ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV79Clientecct_fondocesewwds_1_tfcliconvevig ;
   private java.util.Date AV80Clientecct_fondocesewwds_2_tfcliconvevig_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV48IsAuthorized_Update ;
   private boolean AV50IsAuthorized_Delete ;
   private boolean AV21WelcomeMessage_NoMostrarMas ;
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
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV58MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV53TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean8[] ;
   private boolean AV22WelcomeMessage_Foto_IsBlob ;
   private String AV57MenuBienveTexto ;
   private String AV23ColumnsSelectorXML ;
   private String AV64ManageFiltersXml ;
   private String AV24UserCustomValue ;
   private String AV55textoNoMostrara ;
   private String wcpOAV8MenuOpcCod ;
   private String AV8MenuOpcCod ;
   private String AV46GridAppliedFilters ;
   private String AV32DDO_CliConveVigAuxDateText ;
   private String AV17CliReDTChar ;
   private String AV54MenuBienveImgURL ;
   private String AV56MenuBienveTitulo ;
   private String AV77Welcomemessage_foto_GXI ;
   private String AV70MenuOpcTitulo ;
   private String AV73filtrosTexto ;
   private String AV61ExcelFilename ;
   private String AV62ErrorMessage ;
   private String AV22WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfcliconvevig_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkCliConveFondoRem ;
   private ICheckbox chkCliConveFondoNre ;
   private ICheckbox chkCliConveFondoDes ;
   private IDataStoreProvider pr_default ;
   private int[] H00MG2_A2154CliConveFondoRelSec ;
   private boolean[] H00MG2_A2153CliConveFondoDes ;
   private boolean[] H00MG2_A2152CliConveFondoNre ;
   private boolean[] H00MG2_A2151CliConveFondoRem ;
   private java.math.BigDecimal[] H00MG2_A2150CliConveFondoPrc ;
   private short[] H00MG2_A2148CliConveFondoMeses ;
   private short[] H00MG2_A2147CliConveFondoSec ;
   private java.util.Date[] H00MG2_A1575CliConveVig ;
   private String[] H00MG2_A1565CliConvenio ;
   private short[] H00MG2_A1564CliPaiConve ;
   private int[] H00MG2_A3CliCod ;
   private long[] H00MG3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV63ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV42DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class clientecct_fondoceseww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00MG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV79Clientecct_fondocesewwds_1_tfcliconvevig ,
                                          java.util.Date AV80Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                          short AV81Clientecct_fondocesewwds_3_tfcliconvefondosec ,
                                          short AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to ,
                                          short AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses ,
                                          short AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to ,
                                          java.math.BigDecimal AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                          java.math.BigDecimal AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                          byte AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel ,
                                          byte AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel ,
                                          byte AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel ,
                                          java.util.Date A1575CliConveVig ,
                                          short A2147CliConveFondoSec ,
                                          short A2148CliConveFondoMeses ,
                                          java.math.BigDecimal A2150CliConveFondoPrc ,
                                          boolean A2151CliConveFondoRem ,
                                          boolean A2152CliConveFondoNre ,
                                          boolean A2153CliConveFondoDes ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV59CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[12];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CliConveFondoRelSec, CliConveFondoDes, CliConveFondoNre, CliConveFondoRem, CliConveFondoPrc, CliConveFondoMeses, CliConveFondoSec, CliConveVig, CliConvenio, CliPaiConve," ;
      sSelectString += " CliCod" ;
      sFromString = " FROM Clientecct_fondocese" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV79Clientecct_fondocesewwds_1_tfcliconvevig)) )
      {
         addWhere(sWhereString, "(CliConveVig >= ?)");
      }
      else
      {
         GXv_int19[1] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV80Clientecct_fondocesewwds_2_tfcliconvevig_to)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( ! (0==AV81Clientecct_fondocesewwds_3_tfcliconvefondosec) )
      {
         addWhere(sWhereString, "(CliConveFondoSec >= ?)");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( ! (0==AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to) )
      {
         addWhere(sWhereString, "(CliConveFondoSec <= ?)");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( ! (0==AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses >= ?)");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( ! (0==AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses <= ?)");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc >= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc <= ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = TRUE)");
      }
      if ( AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = FALSE)");
      }
      if ( AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = TRUE)");
      }
      if ( AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = FALSE)");
      }
      if ( AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = TRUE)");
      }
      if ( AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = FALSE)");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveVig, CliCod, CliPaiConve, CliConvenio, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveVig DESC, CliCod, CliPaiConve, CliConvenio, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoSec, CliCod, CliPaiConve, CliConvenio, CliConveVig" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoSec DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoMeses, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoMeses DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoPrc, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoPrc DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoRem, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoRem DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoNre, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoNre DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliConveFondoDes, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliConveFondoDes DESC, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00MG3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV79Clientecct_fondocesewwds_1_tfcliconvevig ,
                                          java.util.Date AV80Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                          short AV81Clientecct_fondocesewwds_3_tfcliconvefondosec ,
                                          short AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to ,
                                          short AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses ,
                                          short AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to ,
                                          java.math.BigDecimal AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                          java.math.BigDecimal AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                          byte AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel ,
                                          byte AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel ,
                                          byte AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel ,
                                          java.util.Date A1575CliConveVig ,
                                          short A2147CliConveFondoSec ,
                                          short A2148CliConveFondoMeses ,
                                          java.math.BigDecimal A2150CliConveFondoPrc ,
                                          boolean A2151CliConveFondoRem ,
                                          boolean A2152CliConveFondoNre ,
                                          boolean A2153CliConveFondoDes ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV59CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[9];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Clientecct_fondocese" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV79Clientecct_fondocesewwds_1_tfcliconvevig)) )
      {
         addWhere(sWhereString, "(CliConveVig >= ?)");
      }
      else
      {
         GXv_int21[1] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV80Clientecct_fondocesewwds_2_tfcliconvevig_to)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( ! (0==AV81Clientecct_fondocesewwds_3_tfcliconvefondosec) )
      {
         addWhere(sWhereString, "(CliConveFondoSec >= ?)");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( ! (0==AV82Clientecct_fondocesewwds_4_tfcliconvefondosec_to) )
      {
         addWhere(sWhereString, "(CliConveFondoSec <= ?)");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( ! (0==AV83Clientecct_fondocesewwds_5_tfcliconvefondomeses) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses >= ?)");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( ! (0==AV84Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses <= ?)");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85Clientecct_fondocesewwds_7_tfcliconvefondoprc)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc >= ?)");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Clientecct_fondocesewwds_8_tfcliconvefondoprc_to)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc <= ?)");
      }
      else
      {
         GXv_int21[8] = (byte)(1) ;
      }
      if ( AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = TRUE)");
      }
      if ( AV87Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = FALSE)");
      }
      if ( AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = TRUE)");
      }
      if ( AV88Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = FALSE)");
      }
      if ( AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = TRUE)");
      }
      if ( AV89Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
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
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
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
                  return conditional_H00MG2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Boolean) dynConstraints[16]).booleanValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() );
            case 1 :
                  return conditional_H00MG3(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Boolean) dynConstraints[16]).booleanValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00MG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MG3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
      }
   }

}

