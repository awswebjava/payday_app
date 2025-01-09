package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_tiposdetrabajoww_impl extends GXDataArea
{
   public convenio_tiposdetrabajoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_tiposdetrabajoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_tiposdetrabajoww_impl.class ));
   }

   public convenio_tiposdetrabajoww_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbPaiTipoTraId = new HTMLChoice();
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
            AV72MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72MenuOpcCod", AV72MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72MenuOpcCod, ""))));
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
      AV60PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV59CliConvenio = httpContext.GetPar( "CliConvenio") ;
      AV86ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV99Pgmname = httpContext.GetPar( "Pgmname") ;
      AV72MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFPaiTipoTraId_Sels);
      AV31TFConveHsDia = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsDia"), ".") ;
      AV32TFConveHsDia_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsDia_To"), ".") ;
      AV33TFConveHsSem = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsSem"), ".") ;
      AV34TFConveHsSem_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsSem_To"), ".") ;
      AV39TFConveHsMaxDia = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxDia"), ".") ;
      AV40TFConveHsMaxDia_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxDia_To"), ".") ;
      AV41TFConveHsMaxSem = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxSem"), ".") ;
      AV42TFConveHsMaxSem_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxSem_To"), ".") ;
      AV66TFConveHsMaxMes = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxMes"), ".") ;
      AV67TFConveHsMaxMes_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxMes_To"), ".") ;
      AV45TFConveHsMaxAnu = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxAnu"), ".") ;
      AV46TFConveHsMaxAnu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveHsMaxAnu_To"), ".") ;
      AV82TFConveHsRelRef = httpContext.GetPar( "TFConveHsRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV83TFConveHsRelRef_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV57CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV53IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV55IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV74WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV61tipo_trabajo = httpContext.GetPar( "tipo_trabajo") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
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
      paFA2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startFA2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_tiposdetrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV72MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV57CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV53IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV55IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV60PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV59CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPO_TRABAJO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61tipo_trabajo, ""))));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV84ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV84ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV49GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV50GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV51GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV86ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV99Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV72MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFPAITIPOTRAID_SELS", AV30TFPaiTipoTraId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFPAITIPOTRAID_SELS", AV30TFPaiTipoTraId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSDIA", GXutil.ltrim( localUtil.ntoc( AV31TFConveHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSDIA_TO", GXutil.ltrim( localUtil.ntoc( AV32TFConveHsDia_To, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSSEM", GXutil.ltrim( localUtil.ntoc( AV33TFConveHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSSEM_TO", GXutil.ltrim( localUtil.ntoc( AV34TFConveHsSem_To, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXDIA", GXutil.ltrim( localUtil.ntoc( AV39TFConveHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXDIA_TO", GXutil.ltrim( localUtil.ntoc( AV40TFConveHsMaxDia_To, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXSEM", GXutil.ltrim( localUtil.ntoc( AV41TFConveHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXSEM_TO", GXutil.ltrim( localUtil.ntoc( AV42TFConveHsMaxSem_To, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXMES", GXutil.ltrim( localUtil.ntoc( AV66TFConveHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXMES_TO", GXutil.ltrim( localUtil.ntoc( AV67TFConveHsMaxMes_To, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXANU", GXutil.ltrim( localUtil.ntoc( AV45TFConveHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSMAXANU_TO", GXutil.ltrim( localUtil.ntoc( AV46TFConveHsMaxAnu_To, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSRELREF", AV82TFConveHsRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEHSRELREF_SELS", AV83TFConveHsRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEHSRELREF_SELS", AV83TFConveHsRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV57CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV57CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV53IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV53IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV55IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV55IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPAITIPOTRAID_SELSJSON", AV29TFPaiTipoTraId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSRELREF_SELSJSON", AV81TFConveHsRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV60PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV60PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV59CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV59CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPO_TRABAJO", GXutil.rtrim( AV61tipo_trabajo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPO_TRABAJO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61tipo_trabajo, ""))));
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
         weFA2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtFA2( ) ;
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
      return formatLink("web.convenio_tiposdetrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV72MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "convenio_tiposdetrabajoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " convenio_tiposdetrabajo", "") ;
   }

   public void wbFA0( )
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
         wb_table1_9_FA2( true) ;
      }
      else
      {
         wb_table1_9_FA2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_FA2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
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

   public void startFA2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " convenio_tiposdetrabajo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupFA0( ) ;
   }

   public void wsFA2( )
   {
      startFA2( ) ;
      evtFA2( ) ;
   }

   public void evtFA2( )
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
                           e11FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16FA2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17FA2 ();
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
                           cmbPaiTipoTraId.setName( cmbPaiTipoTraId.getInternalname() );
                           cmbPaiTipoTraId.setValue( httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) );
                           A1294PaiTipoTraId = httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) ;
                           A1323ConveHsDia = localUtil.ctond( httpContext.cgiGet( edtConveHsDia_Internalname)) ;
                           A1324ConveHsSem = localUtil.ctond( httpContext.cgiGet( edtConveHsSem_Internalname)) ;
                           A1391ConveHsMaxDia = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxDia_Internalname)) ;
                           A1392ConveHsMaxSem = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxSem_Internalname)) ;
                           A1393ConveHsMaxMes = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxMes_Internalname)) ;
                           A1394ConveHsMaxAnu = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxAnu_Internalname)) ;
                           A2064ConveHsRelRef = httpContext.cgiGet( edtConveHsRelRef_Internalname) ;
                           AV52Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV52Update);
                           AV54Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV54Delete);
                           AV71Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV71Display);
                           AV68VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV68VerSVG);
                           AV69ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV69ModificarSVG);
                           AV70EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV70EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18FA2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19FA2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20FA2 ();
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

   public void weFA2( )
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

   public void paFA2( )
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
                                 short AV60PaiCod ,
                                 String AV59CliConvenio ,
                                 byte AV86ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV99Pgmname ,
                                 String AV72MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 GXSimpleCollection<String> AV30TFPaiTipoTraId_Sels ,
                                 java.math.BigDecimal AV31TFConveHsDia ,
                                 java.math.BigDecimal AV32TFConveHsDia_To ,
                                 java.math.BigDecimal AV33TFConveHsSem ,
                                 java.math.BigDecimal AV34TFConveHsSem_To ,
                                 java.math.BigDecimal AV39TFConveHsMaxDia ,
                                 java.math.BigDecimal AV40TFConveHsMaxDia_To ,
                                 java.math.BigDecimal AV41TFConveHsMaxSem ,
                                 java.math.BigDecimal AV42TFConveHsMaxSem_To ,
                                 java.math.BigDecimal AV66TFConveHsMaxMes ,
                                 java.math.BigDecimal AV67TFConveHsMaxMes_To ,
                                 java.math.BigDecimal AV45TFConveHsMaxAnu ,
                                 java.math.BigDecimal AV46TFConveHsMaxAnu_To ,
                                 String AV82TFConveHsRelRef ,
                                 GXSimpleCollection<String> AV83TFConveHsRelRef_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV57CliCod ,
                                 boolean AV53IsAuthorized_Update ,
                                 boolean AV55IsAuthorized_Delete ,
                                 boolean AV74WelcomeMessage_NoMostrarMas ,
                                 String AV61tipo_trabajo )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19FA2 ();
      GRID_nCurrentRecord = 0 ;
      rfFA2( ) ;
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
      AV74WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV74WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74WelcomeMessage_NoMostrarMas", AV74WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfFA2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV99Pgmname = "convenio_tiposdetrabajoWW" ;
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

   public void rfFA2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e19FA2 ();
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
                                              A1294PaiTipoTraId ,
                                              AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                              A2064ConveHsRelRef ,
                                              AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                              Integer.valueOf(AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                              AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                              AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                              AV103Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                              AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                              AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                              AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                              AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                              AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                              AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                              AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                              AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                              AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                              Integer.valueOf(AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels.size()) ,
                                              AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                              A1323ConveHsDia ,
                                              A1324ConveHsSem ,
                                              A1391ConveHsMaxDia ,
                                              A1392ConveHsMaxSem ,
                                              A1393ConveHsMaxMes ,
                                              A1394ConveHsMaxAnu ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV57CliCod) ,
                                              Short.valueOf(AV60PaiCod) ,
                                              AV59CliConvenio ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              A1565CliConvenio } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.STRING
                                              }
         });
         lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = GXutil.concat( GXutil.rtrim( AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref), "%", "") ;
         /* Using cursor H00FA2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV57CliCod), Short.valueOf(AV60PaiCod), AV59CliConvenio, AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia, AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to, AV103Convenio_tiposdetrabajowwds_4_tfconvehssem, AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to, AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia, AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to, AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem, AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to, AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes, AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to, AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu, AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to, lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2064ConveHsRelRef = H00FA2_A2064ConveHsRelRef[0] ;
            A1394ConveHsMaxAnu = H00FA2_A1394ConveHsMaxAnu[0] ;
            A1393ConveHsMaxMes = H00FA2_A1393ConveHsMaxMes[0] ;
            A1392ConveHsMaxSem = H00FA2_A1392ConveHsMaxSem[0] ;
            A1391ConveHsMaxDia = H00FA2_A1391ConveHsMaxDia[0] ;
            A1324ConveHsSem = H00FA2_A1324ConveHsSem[0] ;
            A1323ConveHsDia = H00FA2_A1323ConveHsDia[0] ;
            A1294PaiTipoTraId = H00FA2_A1294PaiTipoTraId[0] ;
            A1565CliConvenio = H00FA2_A1565CliConvenio[0] ;
            A1564CliPaiConve = H00FA2_A1564CliPaiConve[0] ;
            A3CliCod = H00FA2_A3CliCod[0] ;
            e20FA2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbFA0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesFA2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV99Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV99Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV72MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV57CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV57CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV53IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV53IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV55IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV55IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV60PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV60PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV59CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV59CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPO_TRABAJO", GXutil.rtrim( AV61tipo_trabajo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPO_TRABAJO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV61tipo_trabajo, ""))));
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
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                           A2064ConveHsRelRef ,
                                           AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                           Integer.valueOf(AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                           AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                           AV103Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                           AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                           AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                           AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                           AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                           AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                           AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                           AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                           AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                           AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                           Integer.valueOf(AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels.size()) ,
                                           AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                           A1323ConveHsDia ,
                                           A1324ConveHsSem ,
                                           A1391ConveHsMaxDia ,
                                           A1392ConveHsMaxSem ,
                                           A1393ConveHsMaxMes ,
                                           A1394ConveHsMaxAnu ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV57CliCod) ,
                                           Short.valueOf(AV60PaiCod) ,
                                           AV59CliConvenio ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING
                                           }
      });
      lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = GXutil.concat( GXutil.rtrim( AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref), "%", "") ;
      /* Using cursor H00FA3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV57CliCod), Short.valueOf(AV60PaiCod), AV59CliConvenio, AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia, AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to, AV103Convenio_tiposdetrabajowwds_4_tfconvehssem, AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to, AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia, AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to, AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem, AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to, AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes, AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to, AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu, AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to, lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref});
      GRID_nRecordCount = H00FA3_AGRID_nRecordCount[0] ;
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
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV60PaiCod, AV59CliConvenio, AV86ManageFiltersExecutionStep, AV19ColumnsSelector, AV99Pgmname, AV72MenuOpcCod, AV12GridState, AV30TFPaiTipoTraId_Sels, AV31TFConveHsDia, AV32TFConveHsDia_To, AV33TFConveHsSem, AV34TFConveHsSem_To, AV39TFConveHsMaxDia, AV40TFConveHsMaxDia_To, AV41TFConveHsMaxSem, AV42TFConveHsMaxSem_To, AV66TFConveHsMaxMes, AV67TFConveHsMaxMes_To, AV45TFConveHsMaxAnu, AV46TFConveHsMaxAnu_To, AV82TFConveHsRelRef, AV83TFConveHsRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV57CliCod, AV53IsAuthorized_Update, AV55IsAuthorized_Delete, AV74WelcomeMessage_NoMostrarMas, AV61tipo_trabajo) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV99Pgmname = "convenio_tiposdetrabajoWW" ;
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

   public void strupFA0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18FA2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV47DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV84ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV49GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV50GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV51GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV61tipo_trabajo = httpContext.cgiGet( "vTIPO_TRABAJO") ;
         AV59CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
         AV60PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV57CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         AV80WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV74WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV74WelcomeMessage_NoMostrarMas", AV74WelcomeMessage_NoMostrarMas);
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
      e18FA2 ();
      if (returnInSub) return;
   }

   public void e18FA2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV72MenuOpcCod, "", "") ;
      GXt_int1 = AV57CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_tiposdetrabajoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV57CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV57CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " convenio_tiposdetrabajo", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV47DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV47DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV75MenuBienveImgURL ;
      GXv_char6[0] = AV77MenuBienveTitulo ;
      GXv_char7[0] = AV78MenuBienveTexto ;
      GXv_boolean8[0] = AV79MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV72MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      convenio_tiposdetrabajoww_impl.this.AV75MenuBienveImgURL = GXv_char5[0] ;
      convenio_tiposdetrabajoww_impl.this.AV77MenuBienveTitulo = GXv_char6[0] ;
      convenio_tiposdetrabajoww_impl.this.AV78MenuBienveTexto = GXv_char7[0] ;
      convenio_tiposdetrabajoww_impl.this.AV79MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV79MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV79MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV77MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV78MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV80WelcomeMessage_Foto = AV75MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV80WelcomeMessage_Foto)==0) ? AV98Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV80WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV80WelcomeMessage_Foto), true);
         AV98Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV75MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV80WelcomeMessage_Foto)==0) ? AV98Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV80WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV80WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV95observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV95observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV95observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV95observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_int11[0] = AV60PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV57CliCod, GXv_int11) ;
      convenio_tiposdetrabajoww_impl.this.AV60PaiCod = GXv_int11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV60PaiCod), "ZZZ9")));
      GXv_char7[0] = AV59CliConvenio ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.AV59CliConvenio = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliConvenio", AV59CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV59CliConvenio, ""))));
   }

   public void e19FA2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV57CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_tiposdetrabajoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV57CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV57CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext12[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext12) ;
      AV6WWPContext = GXv_SdtWWPContext12[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV86ManageFiltersExecutionStep == 1 )
      {
         AV86ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86ManageFiltersExecutionStep", GXutil.str( AV86ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV86ManageFiltersExecutionStep == 2 )
      {
         AV86ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86ManageFiltersExecutionStep", GXutil.str( AV86ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("convenio_tiposdetrabajoWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("convenio_tiposdetrabajoWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      cmbPaiTipoTraId.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiTipoTraId.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsDia_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsDia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsDia_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsSem_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsSem_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsSem_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsMaxDia_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxDia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxDia_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsMaxSem_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxSem_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxSem_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsMaxMes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxMes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxMes_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsMaxAnu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxAnu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxAnu_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV49GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49GridCurrentPage), 10, 0));
      AV50GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridPageCount), 10, 0));
      GXt_char10 = AV51GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV99Pgmname, GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV51GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51GridAppliedFilters", AV51GridAppliedFilters);
      GXt_char10 = AV91MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV72MenuOpcCod, GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV91MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV91MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV91MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV93filterCount) ;
      GXv_char7[0] = AV94filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int11, GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.AV93filterCount = GXv_int11[0] ;
      convenio_tiposdetrabajoww_impl.this.AV94filtrosTexto = GXv_char7[0] ;
      if ( AV93filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV93filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV94filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      GXv_char7[0] = AV59CliConvenio ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.AV59CliConvenio = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CliConvenio", AV59CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV59CliConvenio, ""))));
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV30TFPaiTipoTraId_Sels ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV31TFConveHsDia ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV32TFConveHsDia_To ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = AV33TFConveHsSem ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV34TFConveHsSem_To ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV39TFConveHsMaxDia ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV40TFConveHsMaxDia_To ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV41TFConveHsMaxSem ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV42TFConveHsMaxSem_To ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV66TFConveHsMaxMes ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV67TFConveHsMaxMes_To ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV45TFConveHsMaxAnu ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV46TFConveHsMaxAnu_To ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV82TFConveHsRelRef ;
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV83TFConveHsRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV84ManageFiltersData", AV84ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveHsRelRef_Sels", AV83TFConveHsRelRef_Sels);
   }

   public void e13FA2( )
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
         AV48PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV48PageToGo) ;
      }
   }

   public void e14FA2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15FA2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PaiTipoTraId") == 0 )
         {
            AV29TFPaiTipoTraId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPaiTipoTraId_SelsJson", AV29TFPaiTipoTraId_SelsJson);
            AV30TFPaiTipoTraId_Sels.fromJSonString(AV29TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsDia") == 0 )
         {
            AV31TFConveHsDia = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveHsDia", GXutil.ltrimstr( AV31TFConveHsDia, 3, 1));
            AV32TFConveHsDia_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveHsDia_To", GXutil.ltrimstr( AV32TFConveHsDia_To, 3, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsSem") == 0 )
         {
            AV33TFConveHsSem = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveHsSem", GXutil.ltrimstr( AV33TFConveHsSem, 4, 1));
            AV34TFConveHsSem_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveHsSem_To", GXutil.ltrimstr( AV34TFConveHsSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsMaxDia") == 0 )
         {
            AV39TFConveHsMaxDia = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveHsMaxDia", GXutil.ltrimstr( AV39TFConveHsMaxDia, 3, 1));
            AV40TFConveHsMaxDia_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveHsMaxDia_To", GXutil.ltrimstr( AV40TFConveHsMaxDia_To, 3, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsMaxSem") == 0 )
         {
            AV41TFConveHsMaxSem = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConveHsMaxSem", GXutil.ltrimstr( AV41TFConveHsMaxSem, 4, 1));
            AV42TFConveHsMaxSem_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConveHsMaxSem_To", GXutil.ltrimstr( AV42TFConveHsMaxSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsMaxMes") == 0 )
         {
            AV66TFConveHsMaxMes = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFConveHsMaxMes", GXutil.ltrimstr( AV66TFConveHsMaxMes, 5, 1));
            AV67TFConveHsMaxMes_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFConveHsMaxMes_To", GXutil.ltrimstr( AV67TFConveHsMaxMes_To, 5, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsMaxAnu") == 0 )
         {
            AV45TFConveHsMaxAnu = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveHsMaxAnu", GXutil.ltrimstr( AV45TFConveHsMaxAnu, 5, 1));
            AV46TFConveHsMaxAnu_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveHsMaxAnu_To", GXutil.ltrimstr( AV46TFConveHsMaxAnu_To, 5, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsRelRef") == 0 )
         {
            AV82TFConveHsRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveHsRelRef", AV82TFConveHsRelRef);
            AV81TFConveHsRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFConveHsRelRef_SelsJson", AV81TFConveHsRelRef_SelsJson);
            AV83TFConveHsRelRef_Sels.fromJSonString(AV81TFConveHsRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveHsRelRef_Sels", AV83TFConveHsRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFPaiTipoTraId_Sels", AV30TFPaiTipoTraId_Sels);
   }

   private void e20FA2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV52Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV52Update);
      if ( AV53IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.convenio_tiposdetrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.rtrim(A1294PaiTipoTraId))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","PaiTipoTraId"})  ;
      }
      AV54Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV54Delete);
      if ( AV55IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.convenio_tiposdetrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.rtrim(A1294PaiTipoTraId))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","PaiTipoTraId"})  ;
      }
      AV71Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV71Display);
      edtavDisplay_Link = formatLink("web.convenio_tiposdetrabajoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.rtrim(A1294PaiTipoTraId)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliPaiConve","CliConvenio","PaiTipoTraId","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV68VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV68VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV68VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV69ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV69ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV69ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV70EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV70EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV70EliminarSVG);
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

   public void e11FA2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "convenio_tiposdetrabajoWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV84ManageFiltersData", AV84ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveHsRelRef_Sels", AV83TFConveHsRelRef_Sels);
   }

   public void e12FA2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("convenio_tiposdetrabajoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV99Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV86ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86ManageFiltersExecutionStep", GXutil.str( AV86ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("convenio_tiposdetrabajoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV86ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86ManageFiltersExecutionStep", GXutil.str( AV86ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV85ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "convenio_tiposdetrabajoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV85ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV85ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV99Pgmname+"GridState", AV85ManageFiltersXml) ;
            AV12GridState.fromxml(AV85ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFPaiTipoTraId_Sels", AV30TFPaiTipoTraId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveHsRelRef_Sels", AV83TFConveHsRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV84ManageFiltersData", AV84ManageFiltersData);
   }

   public void e16FA2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV62ExcelFilename ;
      GXv_char6[0] = AV63ErrorMessage ;
      new web.convenio_tiposdetrabajowwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      convenio_tiposdetrabajoww_impl.this.AV62ExcelFilename = GXv_char7[0] ;
      convenio_tiposdetrabajoww_impl.this.AV63ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV62ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV62ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV63ErrorMessage);
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
      AV19ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "PaiTipoTraId", "", "Tipo de Trabajo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsDia", "", "Límite de horas normales por día", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsSem", "", "Límite de horas normales por semana", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsMaxDia", "", "Máximo de horas extras por día", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsMaxSem", "", "Máximo de horas extras por semana", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsMaxMes", "", "Máximo de horas extras por mes", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsMaxAnu", "", "Máximo de horas extras por año", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV57CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveHsRelRef", "", "Liberación", true, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
         AV82TFConveHsRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveHsRelRef", AV82TFConveHsRelRef);
         AV83TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV18UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "convenio_tiposdetrabajoWWColumnsSelector", GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV18UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV18UserCustomValue)==0) ) )
      {
         AV20ColumnsSelectorAux.fromxml(AV18UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV20ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV57CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV53IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_tiposdetrabajo_Update", GXv_boolean8) ;
      convenio_tiposdetrabajoww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV53IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53IsAuthorized_Update", AV53IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV53IsAuthorized_Update));
      if ( ! ( AV53IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV55IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_tiposdetrabajo_Delete", GXv_boolean8) ;
      convenio_tiposdetrabajoww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV55IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55IsAuthorized_Delete", AV55IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV55IsAuthorized_Delete));
      if ( ! ( AV55IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV56TempBoolean ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_tiposdetrabajo_Insert", GXv_boolean8) ;
      convenio_tiposdetrabajoww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV56TempBoolean = GXt_boolean15 ;
      if ( ! ( AV56TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV84ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "convenio_tiposdetrabajoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV84ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV30TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFConveHsDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveHsDia", GXutil.ltrimstr( AV31TFConveHsDia, 3, 1));
      AV32TFConveHsDia_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveHsDia_To", GXutil.ltrimstr( AV32TFConveHsDia_To, 3, 1));
      AV33TFConveHsSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveHsSem", GXutil.ltrimstr( AV33TFConveHsSem, 4, 1));
      AV34TFConveHsSem_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveHsSem_To", GXutil.ltrimstr( AV34TFConveHsSem_To, 4, 1));
      AV39TFConveHsMaxDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveHsMaxDia", GXutil.ltrimstr( AV39TFConveHsMaxDia, 3, 1));
      AV40TFConveHsMaxDia_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveHsMaxDia_To", GXutil.ltrimstr( AV40TFConveHsMaxDia_To, 3, 1));
      AV41TFConveHsMaxSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41TFConveHsMaxSem", GXutil.ltrimstr( AV41TFConveHsMaxSem, 4, 1));
      AV42TFConveHsMaxSem_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFConveHsMaxSem_To", GXutil.ltrimstr( AV42TFConveHsMaxSem_To, 4, 1));
      AV66TFConveHsMaxMes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFConveHsMaxMes", GXutil.ltrimstr( AV66TFConveHsMaxMes, 5, 1));
      AV67TFConveHsMaxMes_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFConveHsMaxMes_To", GXutil.ltrimstr( AV67TFConveHsMaxMes_To, 5, 1));
      AV45TFConveHsMaxAnu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveHsMaxAnu", GXutil.ltrimstr( AV45TFConveHsMaxAnu, 5, 1));
      AV46TFConveHsMaxAnu_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveHsMaxAnu_To", GXutil.ltrimstr( AV46TFConveHsMaxAnu_To, 5, 1));
      AV82TFConveHsRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveHsRelRef", AV82TFConveHsRelRef);
      AV83TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV21Session.getValue(AV99Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV99Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV99Pgmname+"GridState"), null, null);
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
      AV115GXV1 = 1 ;
      while ( AV115GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV115GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV29TFPaiTipoTraId_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFPaiTipoTraId_SelsJson", AV29TFPaiTipoTraId_SelsJson);
            AV30TFPaiTipoTraId_Sels.fromJSonString(AV29TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSDIA") == 0 )
         {
            AV31TFConveHsDia = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveHsDia", GXutil.ltrimstr( AV31TFConveHsDia, 3, 1));
            AV32TFConveHsDia_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveHsDia_To", GXutil.ltrimstr( AV32TFConveHsDia_To, 3, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSSEM") == 0 )
         {
            AV33TFConveHsSem = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveHsSem", GXutil.ltrimstr( AV33TFConveHsSem, 4, 1));
            AV34TFConveHsSem_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveHsSem_To", GXutil.ltrimstr( AV34TFConveHsSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXDIA") == 0 )
         {
            AV39TFConveHsMaxDia = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveHsMaxDia", GXutil.ltrimstr( AV39TFConveHsMaxDia, 3, 1));
            AV40TFConveHsMaxDia_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveHsMaxDia_To", GXutil.ltrimstr( AV40TFConveHsMaxDia_To, 3, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXSEM") == 0 )
         {
            AV41TFConveHsMaxSem = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConveHsMaxSem", GXutil.ltrimstr( AV41TFConveHsMaxSem, 4, 1));
            AV42TFConveHsMaxSem_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConveHsMaxSem_To", GXutil.ltrimstr( AV42TFConveHsMaxSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXMES") == 0 )
         {
            AV66TFConveHsMaxMes = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFConveHsMaxMes", GXutil.ltrimstr( AV66TFConveHsMaxMes, 5, 1));
            AV67TFConveHsMaxMes_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFConveHsMaxMes_To", GXutil.ltrimstr( AV67TFConveHsMaxMes_To, 5, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXANU") == 0 )
         {
            AV45TFConveHsMaxAnu = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveHsMaxAnu", GXutil.ltrimstr( AV45TFConveHsMaxAnu, 5, 1));
            AV46TFConveHsMaxAnu_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveHsMaxAnu_To", GXutil.ltrimstr( AV46TFConveHsMaxAnu_To, 5, 1));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF") == 0 )
         {
            AV82TFConveHsRelRef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveHsRelRef", AV82TFConveHsRelRef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF_SEL") == 0 )
         {
            AV81TFConveHsRelRef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFConveHsRelRef_SelsJson", AV81TFConveHsRelRef_SelsJson);
            AV83TFConveHsRelRef_Sels.fromJSonString(AV81TFConveHsRelRef_SelsJson, null);
         }
         AV115GXV1 = (int)(AV115GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFPaiTipoTraId_Sels.size()==0), AV29TFPaiTipoTraId_SelsJson, GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV83TFConveHsRelRef_Sels.size()==0), AV81TFConveHsRelRef_SelsJson, GXv_char6) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char9 = GXv_char6[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"|||||||"+GXt_char9 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV82TFConveHsRelRef)==0), AV82TFConveHsRelRef, GXv_char7) ;
      convenio_tiposdetrabajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = "|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFConveHsDia)==0) ? "" : GXutil.str( AV31TFConveHsDia, 3, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFConveHsSem)==0) ? "" : GXutil.str( AV33TFConveHsSem, 4, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFConveHsMaxDia)==0) ? "" : GXutil.str( AV39TFConveHsMaxDia, 3, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFConveHsMaxSem)==0) ? "" : GXutil.str( AV41TFConveHsMaxSem, 4, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFConveHsMaxMes)==0) ? "" : GXutil.str( AV66TFConveHsMaxMes, 5, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFConveHsMaxAnu)==0) ? "" : GXutil.str( AV45TFConveHsMaxAnu, 5, 1))+"|"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFConveHsDia_To)==0) ? "" : GXutil.str( AV32TFConveHsDia_To, 3, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFConveHsSem_To)==0) ? "" : GXutil.str( AV34TFConveHsSem_To, 4, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFConveHsMaxDia_To)==0) ? "" : GXutil.str( AV40TFConveHsMaxDia_To, 3, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFConveHsMaxSem_To)==0) ? "" : GXutil.str( AV42TFConveHsMaxSem_To, 4, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFConveHsMaxMes_To)==0) ? "" : GXutil.str( AV67TFConveHsMaxMes_To, 5, 1))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFConveHsMaxAnu_To)==0) ? "" : GXutil.str( AV46TFConveHsMaxAnu_To, 5, 1))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV99Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFPAITIPOTRAID_SEL", httpContext.getMessage( "Tipo de Trabajo", ""), !(AV30TFPaiTipoTraId_Sels.size()==0), (short)(0), AV30TFPaiTipoTraId_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSDIA", httpContext.getMessage( "Límite de horas normales por día", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFConveHsDia)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFConveHsDia_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV31TFConveHsDia, 3, 1)), GXutil.trim( GXutil.str( AV32TFConveHsDia_To, 3, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSSEM", httpContext.getMessage( "Límite de horas normales por semana", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFConveHsSem)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFConveHsSem_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV33TFConveHsSem, 4, 1)), GXutil.trim( GXutil.str( AV34TFConveHsSem_To, 4, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSMAXDIA", httpContext.getMessage( "Máximo de horas extras por día", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFConveHsMaxDia)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFConveHsMaxDia_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV39TFConveHsMaxDia, 3, 1)), GXutil.trim( GXutil.str( AV40TFConveHsMaxDia_To, 3, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSMAXSEM", httpContext.getMessage( "Máximo de horas extras por semana", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFConveHsMaxSem)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFConveHsMaxSem_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV41TFConveHsMaxSem, 4, 1)), GXutil.trim( GXutil.str( AV42TFConveHsMaxSem_To, 4, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSMAXMES", httpContext.getMessage( "Máximo de horas extras por mes", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFConveHsMaxMes)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFConveHsMaxMes_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV66TFConveHsMaxMes, 5, 1)), GXutil.trim( GXutil.str( AV67TFConveHsMaxMes_To, 5, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSMAXANU", httpContext.getMessage( "Máximo de horas extras por año", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFConveHsMaxAnu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFConveHsMaxAnu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV45TFConveHsMaxAnu, 5, 1)), GXutil.trim( GXutil.str( AV46TFConveHsMaxAnu_To, 5, 1))) ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEHSRELREF", httpContext.getMessage( "Liberación", ""), !(GXutil.strcmp("", AV82TFConveHsRelRef)==0), (short)(0), AV82TFConveHsRelRef, "", !(AV83TFConveHsRelRef_Sels.size()==0), AV83TFConveHsRelRef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (GXutil.strcmp("", AV72MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV72MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV99Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV99Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "convenio_tiposdetrabajo" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17FA2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV74WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV72MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV76textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV57CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         convenio_tiposdetrabajoww_impl.this.AV76textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV76textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV72MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_FA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_FA2( true) ;
      }
      else
      {
         wb_table2_12_FA2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_FA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_FA2e( true) ;
      }
      else
      {
         wb_table1_9_FA2e( false) ;
      }
   }

   public void wb_table2_12_FA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21fa1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_convenio_tiposdetrabajoWW.htm");
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
         AV80WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV80WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV98Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV80WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV80WelcomeMessage_Foto)==0) ? AV98Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV80WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV80WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_convenio_tiposdetrabajoWW.htm");
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
         wb_table3_30_FA2( true) ;
      }
      else
      {
         wb_table3_30_FA2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_FA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_FA2( true) ;
      }
      else
      {
         wb_table4_35_FA2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_FA2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV74WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
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
         wb_table5_54_FA2( true) ;
      }
      else
      {
         wb_table5_54_FA2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_FA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_FA2( true) ;
      }
      else
      {
         wb_table6_63_FA2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_FA2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV49GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV50GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV51GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_FA2e( true) ;
      }
      else
      {
         wb_table2_12_FA2e( false) ;
      }
   }

   public void wb_table6_63_FA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_convenio_tiposdetrabajoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV19ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV84ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22fa1_client"+"'", TempTags, "", 2, "HLP_convenio_tiposdetrabajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_tiposdetrabajoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_convenio_tiposdetrabajoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_FA2( true) ;
      }
      else
      {
         wb_table7_99_FA2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_FA2e( boolean wbgen )
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
         wb_table6_63_FA2e( true) ;
      }
      else
      {
         wb_table6_63_FA2e( false) ;
      }
   }

   public void wb_table7_99_FA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_FA2e( true) ;
      }
      else
      {
         wb_table7_99_FA2e( false) ;
      }
   }

   public void wb_table5_54_FA2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_FA2e( true) ;
      }
      else
      {
         wb_table5_54_FA2e( false) ;
      }
   }

   public void wb_table4_35_FA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_FA2e( true) ;
      }
      else
      {
         wb_table4_35_FA2e( false) ;
      }
   }

   public void wb_table3_30_FA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_tiposdetrabajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_FA2e( true) ;
      }
      else
      {
         wb_table3_30_FA2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV72MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72MenuOpcCod", AV72MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72MenuOpcCod, ""))));
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
      paFA2( ) ;
      wsFA2( ) ;
      weFA2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818585138", true, true);
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
      httpContext.AddJavascriptSource("convenio_tiposdetrabajoww.js", "?20251818585138", false, true);
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
      edtCliPaiConve_Internalname = "CLIPAICONVE_"+sGXsfl_110_idx ;
      edtCliConvenio_Internalname = "CLICONVENIO_"+sGXsfl_110_idx ;
      cmbPaiTipoTraId.setInternalname( "PAITIPOTRAID_"+sGXsfl_110_idx );
      edtConveHsDia_Internalname = "CONVEHSDIA_"+sGXsfl_110_idx ;
      edtConveHsSem_Internalname = "CONVEHSSEM_"+sGXsfl_110_idx ;
      edtConveHsMaxDia_Internalname = "CONVEHSMAXDIA_"+sGXsfl_110_idx ;
      edtConveHsMaxSem_Internalname = "CONVEHSMAXSEM_"+sGXsfl_110_idx ;
      edtConveHsMaxMes_Internalname = "CONVEHSMAXMES_"+sGXsfl_110_idx ;
      edtConveHsMaxAnu_Internalname = "CONVEHSMAXANU_"+sGXsfl_110_idx ;
      edtConveHsRelRef_Internalname = "CONVEHSRELREF_"+sGXsfl_110_idx ;
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
      cmbPaiTipoTraId.setInternalname( "PAITIPOTRAID_"+sGXsfl_110_fel_idx );
      edtConveHsDia_Internalname = "CONVEHSDIA_"+sGXsfl_110_fel_idx ;
      edtConveHsSem_Internalname = "CONVEHSSEM_"+sGXsfl_110_fel_idx ;
      edtConveHsMaxDia_Internalname = "CONVEHSMAXDIA_"+sGXsfl_110_fel_idx ;
      edtConveHsMaxSem_Internalname = "CONVEHSMAXSEM_"+sGXsfl_110_fel_idx ;
      edtConveHsMaxMes_Internalname = "CONVEHSMAXMES_"+sGXsfl_110_fel_idx ;
      edtConveHsMaxAnu_Internalname = "CONVEHSMAXANU_"+sGXsfl_110_fel_idx ;
      edtConveHsRelRef_Internalname = "CONVEHSRELREF_"+sGXsfl_110_fel_idx ;
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
      wbFA0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbPaiTipoTraId.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbPaiTipoTraId.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PAITIPOTRAID_" + sGXsfl_110_idx ;
            cmbPaiTipoTraId.setName( GXCCtl );
            cmbPaiTipoTraId.setWebtags( "" );
            cmbPaiTipoTraId.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
            cmbPaiTipoTraId.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
            cmbPaiTipoTraId.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
            if ( cmbPaiTipoTraId.getItemCount() > 0 )
            {
               A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPaiTipoTraId,cmbPaiTipoTraId.getInternalname(),GXutil.rtrim( A1294PaiTipoTraId),Integer.valueOf(1),cmbPaiTipoTraId.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbPaiTipoTraId.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Values", cmbPaiTipoTraId.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsDia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsDia_Internalname,GXutil.ltrim( localUtil.ntoc( A1323ConveHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1323ConveHsDia, "9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsDia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsSem_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsSem_Internalname,GXutil.ltrim( localUtil.ntoc( A1324ConveHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1324ConveHsSem, "Z9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsSem_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsSem_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsMaxDia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsMaxDia_Internalname,GXutil.ltrim( localUtil.ntoc( A1391ConveHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1391ConveHsMaxDia, "9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsMaxDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsMaxDia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsMaxSem_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsMaxSem_Internalname,GXutil.ltrim( localUtil.ntoc( A1392ConveHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1392ConveHsMaxSem, "Z9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsMaxSem_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsMaxSem_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsMaxMes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsMaxMes_Internalname,GXutil.ltrim( localUtil.ntoc( A1393ConveHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1393ConveHsMaxMes, "ZZ9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsMaxMes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsMaxMes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsMaxAnu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsMaxAnu_Internalname,GXutil.ltrim( localUtil.ntoc( A1394ConveHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1394ConveHsMaxAnu, "ZZ9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsMaxAnu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsMaxAnu_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveHsRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsRelRef_Internalname,A2064ConveHsRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtConveHsRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV52Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV54Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV71Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV68VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV69ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV70EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesFA2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbPaiTipoTraId.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Trabajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsDia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Límite de horas normales por día", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsSem_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Límite de horas normales por semana", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsMaxDia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Máximo de horas extras por día", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsMaxSem_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Máximo de horas extras por semana", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsMaxMes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Máximo de horas extras por mes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsMaxAnu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Máximo de horas extras por año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1294PaiTipoTraId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbPaiTipoTraId.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1323ConveHsDia, (byte)(3), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsDia_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1324ConveHsSem, (byte)(4), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsSem_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1391ConveHsMaxDia, (byte)(3), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsMaxDia_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1392ConveHsMaxSem, (byte)(4), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsMaxSem_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1393ConveHsMaxMes, (byte)(5), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsMaxMes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1394ConveHsMaxAnu, (byte)(5), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsMaxAnu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2064ConveHsRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV52Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV54Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV71Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV68VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV69ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV70EliminarSVG));
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
      cmbPaiTipoTraId.setInternalname( "PAITIPOTRAID" );
      edtConveHsDia_Internalname = "CONVEHSDIA" ;
      edtConveHsSem_Internalname = "CONVEHSSEM" ;
      edtConveHsMaxDia_Internalname = "CONVEHSMAXDIA" ;
      edtConveHsMaxSem_Internalname = "CONVEHSMAXSEM" ;
      edtConveHsMaxMes_Internalname = "CONVEHSMAXMES" ;
      edtConveHsMaxAnu_Internalname = "CONVEHSMAXANU" ;
      edtConveHsRelRef_Internalname = "CONVEHSRELREF" ;
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
      edtConveHsRelRef_Jsonclick = "" ;
      edtConveHsMaxAnu_Jsonclick = "" ;
      edtConveHsMaxMes_Jsonclick = "" ;
      edtConveHsMaxSem_Jsonclick = "" ;
      edtConveHsMaxDia_Jsonclick = "" ;
      edtConveHsSem_Jsonclick = "" ;
      edtConveHsDia_Jsonclick = "" ;
      cmbPaiTipoTraId.setJsonclick( "" );
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
      edtConveHsRelRef_Visible = -1 ;
      edtConveHsMaxAnu_Visible = -1 ;
      edtConveHsMaxMes_Visible = -1 ;
      edtConveHsMaxSem_Visible = -1 ;
      edtConveHsMaxDia_Visible = -1 ;
      edtConveHsSem_Visible = -1 ;
      edtConveHsDia_Visible = -1 ;
      cmbPaiTipoTraId.setVisible( -1 );
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|3.1|4.1|3.1|4.1|5.1|5.1|" ;
      Ddo_grid_Datalistproc = "convenio_tiposdetrabajoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "diurno:Diurno,nocturno:Nocturno,insalubre:Insalubre|||||||" ;
      Ddo_grid_Allowmultipleselection = "T|||||||T" ;
      Ddo_grid_Datalisttype = "FixedValues|||||||Dynamic" ;
      Ddo_grid_Includedatalist = "T|||||||T" ;
      Ddo_grid_Filterisrange = "|T|T|T|T|T|T|" ;
      Ddo_grid_Filtertype = "|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Character" ;
      Ddo_grid_Includefilter = "|T|T|T|T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8" ;
      Ddo_grid_Columnids = "3:PaiTipoTraId|4:ConveHsDia|5:ConveHsSem|6:ConveHsMaxDia|7:ConveHsMaxSem|8:ConveHsMaxMes|9:ConveHsMaxAnu|10:ConveHsRelRef" ;
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
      Form.setCaption( httpContext.getMessage( " convenio_tiposdetrabajo", "") );
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
      AV74WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV74WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74WelcomeMessage_NoMostrarMas", AV74WelcomeMessage_NoMostrarMas);
      GXCCtl = "PAITIPOTRAID_" + sGXsfl_110_idx ;
      cmbPaiTipoTraId.setName( GXCCtl );
      cmbPaiTipoTraId.setWebtags( "" );
      cmbPaiTipoTraId.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbPaiTipoTraId.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbPaiTipoTraId.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbPaiTipoTraId'},{av:'edtConveHsDia_Visible',ctrl:'CONVEHSDIA',prop:'Visible'},{av:'edtConveHsSem_Visible',ctrl:'CONVEHSSEM',prop:'Visible'},{av:'edtConveHsMaxDia_Visible',ctrl:'CONVEHSMAXDIA',prop:'Visible'},{av:'edtConveHsMaxSem_Visible',ctrl:'CONVEHSMAXSEM',prop:'Visible'},{av:'edtConveHsMaxMes_Visible',ctrl:'CONVEHSMAXMES',prop:'Visible'},{av:'edtConveHsMaxAnu_Visible',ctrl:'CONVEHSMAXANU',prop:'Visible'},{av:'edtConveHsRelRef_Visible',ctrl:'CONVEHSRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV84ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13FA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14FA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15FA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV81TFConveHsRelRef_SelsJson',fld:'vTFCONVEHSRELREF_SELSJSON',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV29TFPaiTipoTraId_SelsJson',fld:'vTFPAITIPOTRAID_SELSJSON',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20FA2',iparms:[{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'cmbPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV52Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV54Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV71Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV68VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV69ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV70EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11FA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'cmbPaiTipoTraId'},{av:'edtConveHsDia_Visible',ctrl:'CONVEHSDIA',prop:'Visible'},{av:'edtConveHsSem_Visible',ctrl:'CONVEHSSEM',prop:'Visible'},{av:'edtConveHsMaxDia_Visible',ctrl:'CONVEHSMAXDIA',prop:'Visible'},{av:'edtConveHsMaxSem_Visible',ctrl:'CONVEHSMAXSEM',prop:'Visible'},{av:'edtConveHsMaxMes_Visible',ctrl:'CONVEHSMAXMES',prop:'Visible'},{av:'edtConveHsMaxAnu_Visible',ctrl:'CONVEHSMAXANU',prop:'Visible'},{av:'edtConveHsRelRef_Visible',ctrl:'CONVEHSRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV84ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12FA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV29TFPaiTipoTraId_SelsJson',fld:'vTFPAITIPOTRAID_SELSJSON',pic:''},{av:'AV81TFConveHsRelRef_SelsJson',fld:'vTFCONVEHSRELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV86ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV30TFPaiTipoTraId_Sels',fld:'vTFPAITIPOTRAID_SELS',pic:''},{av:'AV31TFConveHsDia',fld:'vTFCONVEHSDIA',pic:'9.9'},{av:'AV32TFConveHsDia_To',fld:'vTFCONVEHSDIA_TO',pic:'9.9'},{av:'AV33TFConveHsSem',fld:'vTFCONVEHSSEM',pic:'Z9.9'},{av:'AV34TFConveHsSem_To',fld:'vTFCONVEHSSEM_TO',pic:'Z9.9'},{av:'AV39TFConveHsMaxDia',fld:'vTFCONVEHSMAXDIA',pic:'9.9'},{av:'AV40TFConveHsMaxDia_To',fld:'vTFCONVEHSMAXDIA_TO',pic:'9.9'},{av:'AV41TFConveHsMaxSem',fld:'vTFCONVEHSMAXSEM',pic:'Z9.9'},{av:'AV42TFConveHsMaxSem_To',fld:'vTFCONVEHSMAXSEM_TO',pic:'Z9.9'},{av:'AV66TFConveHsMaxMes',fld:'vTFCONVEHSMAXMES',pic:'ZZ9.9'},{av:'AV67TFConveHsMaxMes_To',fld:'vTFCONVEHSMAXMES_TO',pic:'ZZ9.9'},{av:'AV45TFConveHsMaxAnu',fld:'vTFCONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV46TFConveHsMaxAnu_To',fld:'vTFCONVEHSMAXANU_TO',pic:'ZZ9.9'},{av:'AV82TFConveHsRelRef',fld:'vTFCONVEHSRELREF',pic:''},{av:'AV83TFConveHsRelRef_Sels',fld:'vTFCONVEHSRELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV81TFConveHsRelRef_SelsJson',fld:'vTFCONVEHSRELREF_SELSJSON',pic:''},{av:'AV29TFPaiTipoTraId_SelsJson',fld:'vTFPAITIPOTRAID_SELSJSON',pic:''},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbPaiTipoTraId'},{av:'edtConveHsDia_Visible',ctrl:'CONVEHSDIA',prop:'Visible'},{av:'edtConveHsSem_Visible',ctrl:'CONVEHSSEM',prop:'Visible'},{av:'edtConveHsMaxDia_Visible',ctrl:'CONVEHSMAXDIA',prop:'Visible'},{av:'edtConveHsMaxSem_Visible',ctrl:'CONVEHSMAXSEM',prop:'Visible'},{av:'edtConveHsMaxMes_Visible',ctrl:'CONVEHSMAXMES',prop:'Visible'},{av:'edtConveHsMaxAnu_Visible',ctrl:'CONVEHSMAXANU',prop:'Visible'},{av:'edtConveHsRelRef_Visible',ctrl:'CONVEHSRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV51GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV53IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV55IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV84ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e22FA1',iparms:[{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV60PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV59CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV61tipo_trabajo',fld:'vTIPO_TRABAJO',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16FA2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17FA2',iparms:[{av:'AV74WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV72MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV57CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21FA1',iparms:[]");
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
      wcpOAV72MenuOpcCod = "" ;
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
      AV72MenuOpcCod = "" ;
      AV59CliConvenio = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV99Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFConveHsDia = DecimalUtil.ZERO ;
      AV32TFConveHsDia_To = DecimalUtil.ZERO ;
      AV33TFConveHsSem = DecimalUtil.ZERO ;
      AV34TFConveHsSem_To = DecimalUtil.ZERO ;
      AV39TFConveHsMaxDia = DecimalUtil.ZERO ;
      AV40TFConveHsMaxDia_To = DecimalUtil.ZERO ;
      AV41TFConveHsMaxSem = DecimalUtil.ZERO ;
      AV42TFConveHsMaxSem_To = DecimalUtil.ZERO ;
      AV66TFConveHsMaxMes = DecimalUtil.ZERO ;
      AV67TFConveHsMaxMes_To = DecimalUtil.ZERO ;
      AV45TFConveHsMaxAnu = DecimalUtil.ZERO ;
      AV46TFConveHsMaxAnu_To = DecimalUtil.ZERO ;
      AV82TFConveHsRelRef = "" ;
      AV83TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61tipo_trabajo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV47DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV84ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV51GridAppliedFilters = "" ;
      AV29TFPaiTipoTraId_SelsJson = "" ;
      AV81TFConveHsRelRef_SelsJson = "" ;
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
      A1565CliConvenio = "" ;
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A2064ConveHsRelRef = "" ;
      AV52Update = "" ;
      AV54Delete = "" ;
      AV71Display = "" ;
      AV68VerSVG = "" ;
      AV69ModificarSVG = "" ;
      AV70EliminarSVG = "" ;
      AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia = DecimalUtil.ZERO ;
      AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = DecimalUtil.ZERO ;
      AV103Convenio_tiposdetrabajowwds_4_tfconvehssem = DecimalUtil.ZERO ;
      AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to = DecimalUtil.ZERO ;
      AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = DecimalUtil.ZERO ;
      AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = DecimalUtil.ZERO ;
      AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = DecimalUtil.ZERO ;
      AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = DecimalUtil.ZERO ;
      AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = DecimalUtil.ZERO ;
      AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = DecimalUtil.ZERO ;
      AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = DecimalUtil.ZERO ;
      AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = DecimalUtil.ZERO ;
      AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      H00FA2_A2064ConveHsRelRef = new String[] {""} ;
      H00FA2_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FA2_A1294PaiTipoTraId = new String[] {""} ;
      H00FA2_A1565CliConvenio = new String[] {""} ;
      H00FA2_A1564CliPaiConve = new short[1] ;
      H00FA2_A3CliCod = new int[1] ;
      H00FA3_AGRID_nRecordCount = new long[1] ;
      AV80WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV75MenuBienveImgURL = "" ;
      GXv_char5 = new String[1] ;
      AV77MenuBienveTitulo = "" ;
      AV78MenuBienveTexto = "" ;
      AV98Welcomemessage_foto_GXI = "" ;
      AV95observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext12 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV91MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV94filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV85ManageFiltersXml = "" ;
      AV62ExcelFilename = "" ;
      AV63ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char10 = "" ;
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV76textoNoMostrara = "" ;
      GXv_char7 = new String[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_tiposdetrabajoww__default(),
         new Object[] {
             new Object[] {
            H00FA2_A2064ConveHsRelRef, H00FA2_A1394ConveHsMaxAnu, H00FA2_A1393ConveHsMaxMes, H00FA2_A1392ConveHsMaxSem, H00FA2_A1391ConveHsMaxDia, H00FA2_A1324ConveHsSem, H00FA2_A1323ConveHsDia, H00FA2_A1294PaiTipoTraId, H00FA2_A1565CliConvenio, H00FA2_A1564CliPaiConve,
            H00FA2_A3CliCod
            }
            , new Object[] {
            H00FA3_AGRID_nRecordCount
            }
         }
      );
      AV99Pgmname = "convenio_tiposdetrabajoWW" ;
      /* GeneXus formulas. */
      AV99Pgmname = "convenio_tiposdetrabajoWW" ;
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
   private byte AV86ManageFiltersExecutionStep ;
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
   private short AV60PaiCod ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1564CliPaiConve ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV57CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtConveHsDia_Visible ;
   private int edtConveHsSem_Visible ;
   private int edtConveHsMaxDia_Visible ;
   private int edtConveHsMaxSem_Visible ;
   private int edtConveHsMaxMes_Visible ;
   private int edtConveHsMaxAnu_Visible ;
   private int edtConveHsRelRef_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV93filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV48PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV115GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV49GridCurrentPage ;
   private long AV50GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV31TFConveHsDia ;
   private java.math.BigDecimal AV32TFConveHsDia_To ;
   private java.math.BigDecimal AV33TFConveHsSem ;
   private java.math.BigDecimal AV34TFConveHsSem_To ;
   private java.math.BigDecimal AV39TFConveHsMaxDia ;
   private java.math.BigDecimal AV40TFConveHsMaxDia_To ;
   private java.math.BigDecimal AV41TFConveHsMaxSem ;
   private java.math.BigDecimal AV42TFConveHsMaxSem_To ;
   private java.math.BigDecimal AV66TFConveHsMaxMes ;
   private java.math.BigDecimal AV67TFConveHsMaxMes_To ;
   private java.math.BigDecimal AV45TFConveHsMaxAnu ;
   private java.math.BigDecimal AV46TFConveHsMaxAnu_To ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private java.math.BigDecimal AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia ;
   private java.math.BigDecimal AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ;
   private java.math.BigDecimal AV103Convenio_tiposdetrabajowwds_4_tfconvehssem ;
   private java.math.BigDecimal AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to ;
   private java.math.BigDecimal AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ;
   private java.math.BigDecimal AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ;
   private java.math.BigDecimal AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ;
   private java.math.BigDecimal AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ;
   private java.math.BigDecimal AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ;
   private java.math.BigDecimal AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ;
   private java.math.BigDecimal AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ;
   private java.math.BigDecimal AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ;
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
   private String AV59CliConvenio ;
   private String AV99Pgmname ;
   private String AV61tipo_trabajo ;
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
   private String edtCliPaiConve_Internalname ;
   private String A1565CliConvenio ;
   private String edtCliConvenio_Internalname ;
   private String A1294PaiTipoTraId ;
   private String edtConveHsDia_Internalname ;
   private String edtConveHsSem_Internalname ;
   private String edtConveHsMaxDia_Internalname ;
   private String edtConveHsMaxSem_Internalname ;
   private String edtConveHsMaxMes_Internalname ;
   private String edtConveHsMaxAnu_Internalname ;
   private String edtConveHsRelRef_Internalname ;
   private String AV52Update ;
   private String edtavUpdate_Internalname ;
   private String AV54Delete ;
   private String edtavDelete_Internalname ;
   private String AV71Display ;
   private String edtavDisplay_Internalname ;
   private String AV68VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV69ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV70EliminarSVG ;
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
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV95observerPalabra ;
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
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String GXt_char10 ;
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
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Jsonclick ;
   private String GXCCtl ;
   private String edtConveHsDia_Jsonclick ;
   private String edtConveHsSem_Jsonclick ;
   private String edtConveHsMaxDia_Jsonclick ;
   private String edtConveHsMaxSem_Jsonclick ;
   private String edtConveHsMaxMes_Jsonclick ;
   private String edtConveHsMaxAnu_Jsonclick ;
   private String edtConveHsRelRef_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV53IsAuthorized_Update ;
   private boolean AV55IsAuthorized_Delete ;
   private boolean AV74WelcomeMessage_NoMostrarMas ;
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
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV79MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV56TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean8[] ;
   private boolean AV80WelcomeMessage_Foto_IsBlob ;
   private String AV29TFPaiTipoTraId_SelsJson ;
   private String AV81TFConveHsRelRef_SelsJson ;
   private String AV78MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV85ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV76textoNoMostrara ;
   private String wcpOAV72MenuOpcCod ;
   private String AV72MenuOpcCod ;
   private String AV82TFConveHsRelRef ;
   private String AV51GridAppliedFilters ;
   private String A2064ConveHsRelRef ;
   private String lV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String AV75MenuBienveImgURL ;
   private String AV77MenuBienveTitulo ;
   private String AV98Welcomemessage_foto_GXI ;
   private String AV91MenuOpcTitulo ;
   private String AV94filtrosTexto ;
   private String AV62ExcelFilename ;
   private String AV63ErrorMessage ;
   private String AV80WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ;
   private GXSimpleCollection<String> AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbPaiTipoTraId ;
   private IDataStoreProvider pr_default ;
   private String[] H00FA2_A2064ConveHsRelRef ;
   private java.math.BigDecimal[] H00FA2_A1394ConveHsMaxAnu ;
   private java.math.BigDecimal[] H00FA2_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] H00FA2_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] H00FA2_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] H00FA2_A1324ConveHsSem ;
   private java.math.BigDecimal[] H00FA2_A1323ConveHsDia ;
   private String[] H00FA2_A1294PaiTipoTraId ;
   private String[] H00FA2_A1565CliConvenio ;
   private short[] H00FA2_A1564CliPaiConve ;
   private int[] H00FA2_A3CliCod ;
   private long[] H00FA3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV30TFPaiTipoTraId_Sels ;
   private GXSimpleCollection<String> AV83TFConveHsRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV84ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV47DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext12[] ;
}

final  class convenio_tiposdetrabajoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00FA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                          String A2064ConveHsRelRef ,
                                          GXSimpleCollection<String> AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                          int AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                          java.math.BigDecimal AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                          java.math.BigDecimal AV103Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                          java.math.BigDecimal AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                          java.math.BigDecimal AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                          java.math.BigDecimal AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                          java.math.BigDecimal AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                          java.math.BigDecimal AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                          java.math.BigDecimal AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                          java.math.BigDecimal AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                          java.math.BigDecimal AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                          java.math.BigDecimal AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                          int AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ,
                                          String AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          java.math.BigDecimal A1324ConveHsSem ,
                                          java.math.BigDecimal A1391ConveHsMaxDia ,
                                          java.math.BigDecimal A1392ConveHsMaxSem ,
                                          java.math.BigDecimal A1393ConveHsMaxMes ,
                                          java.math.BigDecimal A1394ConveHsMaxAnu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV57CliCod ,
                                          short AV60PaiCod ,
                                          String AV59CliConvenio ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[19];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ConveHsRelRef, ConveHsMaxAnu, ConveHsMaxMes, ConveHsMaxSem, ConveHsMaxDia, ConveHsSem, ConveHsDia, PaiTipoTraId, CliConvenio, CliPaiConve, CliCod" ;
      sFromString = " FROM convenio_tiposdetrabajo" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia >= ?)");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia <= ?)");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Convenio_tiposdetrabajowwds_4_tfconvehssem)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem >= ?)");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem <= ?)");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia >= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia <= ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem >= ?)");
      }
      else
      {
         GXv_int19[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem <= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes >= ?)");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes <= ?)");
      }
      else
      {
         GXv_int19[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int19[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int19[14] = (byte)(1) ;
      }
      if ( ( AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int19[15] = (byte)(1) ;
      }
      if ( AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels, "ConveHsRelRef IN (", ")")+")");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PaiTipoTraId, CliCod, CliPaiConve, CliConvenio" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiTipoTraId DESC, CliCod, CliPaiConve, CliConvenio" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsDia, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsDia DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsSem, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsSem DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsMaxDia, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsMaxDia DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsMaxSem, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsMaxSem DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsMaxMes, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsMaxMes DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsMaxAnu, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsMaxAnu DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsRelRef, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsRelRef DESC, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00FA3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                          String A2064ConveHsRelRef ,
                                          GXSimpleCollection<String> AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                          int AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                          java.math.BigDecimal AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                          java.math.BigDecimal AV103Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                          java.math.BigDecimal AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                          java.math.BigDecimal AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                          java.math.BigDecimal AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                          java.math.BigDecimal AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                          java.math.BigDecimal AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                          java.math.BigDecimal AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                          java.math.BigDecimal AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                          java.math.BigDecimal AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                          java.math.BigDecimal AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                          int AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ,
                                          String AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          java.math.BigDecimal A1324ConveHsSem ,
                                          java.math.BigDecimal A1391ConveHsMaxDia ,
                                          java.math.BigDecimal A1392ConveHsMaxSem ,
                                          java.math.BigDecimal A1393ConveHsMaxMes ,
                                          java.math.BigDecimal A1394ConveHsMaxAnu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV57CliCod ,
                                          short AV60PaiCod ,
                                          String AV59CliConvenio ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[16];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101Convenio_tiposdetrabajowwds_2_tfconvehsdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia >= ?)");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Convenio_tiposdetrabajowwds_3_tfconvehsdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia <= ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Convenio_tiposdetrabajowwds_4_tfconvehssem)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem >= ?)");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Convenio_tiposdetrabajowwds_5_tfconvehssem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem <= ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia >= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia <= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem >= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem <= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes >= ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes <= ?)");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int22[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int22[14] = (byte)(1) ;
      }
      if ( ( AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Convenio_tiposdetrabajowwds_14_tfconvehsrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int22[15] = (byte)(1) ;
      }
      if ( AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels, "ConveHsRelRef IN (", ")")+")");
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
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_H00FA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] );
            case 1 :
                  return conditional_H00FA3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00FA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00FA3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 1);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 1);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 40);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[36]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[37]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 1);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 1);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 40);
               }
               return;
      }
   }

}

