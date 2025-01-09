package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class novedadesww_impl extends GXDataArea
{
   public novedadesww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public novedadesww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadesww_impl.class ));
   }

   public novedadesww_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkavVerliquidadas = UIFactory.getCheckbox(this);
      cmbTipoConCod = new HTMLChoice();
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
            AV120MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120MenuOpcCod", AV120MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV120MenuOpcCod, ""))));
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
      nRC_GXsfl_125 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_125"))) ;
      nGXsfl_125_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_125_idx"))) ;
      sGXsfl_125_idx = httpContext.GetPar( "sGXsfl_125_idx") ;
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
      AV108VerLiquidadas = GXutil.strtobool( httpContext.GetPar( "VerLiquidadas")) ;
      AV115ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20ColumnsSelector);
      AV144Pgmname = httpContext.GetPar( "Pgmname") ;
      AV120MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11GridState);
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV61TFLegId = httpContext.GetPar( "TFLegId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV81TFLegId_Sels);
      AV98TFLegNomApe = httpContext.GetPar( "TFLegNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV99TFLegNomApe_Sels);
      AV40TFConCodigo = httpContext.GetPar( "TFConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV77TFConCodigo_Sels);
      AV42TFConDescrip = httpContext.GetPar( "TFConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV79TFConDescrip_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV93TFTipoConCod_Sels);
      AV44TFAgeCanti = CommonUtil.decimalVal( httpContext.GetPar( "TFAgeCanti"), ".") ;
      AV45TFAgeCanti_To = CommonUtil.decimalVal( httpContext.GetPar( "TFAgeCanti_To"), ".") ;
      AV130TFAgePerDescrip = httpContext.GetPar( "TFAgePerDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV131TFAgePerDescrip_Sels);
      AV50TFAgeFecDes = localUtil.parseDateParm( httpContext.GetPar( "TFAgeFecDes")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV110TFAgeFecDes_Sels);
      AV55TFAgeFecHas = localUtil.parseDateParm( httpContext.GetPar( "TFAgeFecHas")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV112TFAgeFecHas_Sels);
      AV106TFAgeLiqNro = (int)(GXutil.lval( httpContext.GetPar( "TFAgeLiqNro"))) ;
      AV107TFAgeLiqNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFAgeLiqNro_To"))) ;
      AV82CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV84IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV85IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV69EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV122WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
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
      pa2L2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2L2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.novedadesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV120MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV144Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV120MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV82CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV85IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69EmpCod), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vVERLIQUIDADAS", GXutil.booltostr( AV108VerLiquidadas));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_125", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_125, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV63DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV63DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV113ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV113ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV65GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV66GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV67GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV115ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV144Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV144Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV120MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV120MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGID", GXutil.rtrim( AV61TFLegId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGID_SELS", AV81TFLegId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGID_SELS", AV81TFLegId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGNOMAPE", AV98TFLegNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGNOMAPE_SELS", AV99TFLegNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGNOMAPE_SELS", AV99TFLegNomApe_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO", GXutil.rtrim( AV40TFConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODIGO_SELS", AV77TFConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODIGO_SELS", AV77TFConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP", AV42TFConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONDESCRIP_SELS", AV79TFConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONDESCRIP_SELS", AV79TFConDescrip_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTIPOCONCOD_SELS", AV93TFTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTIPOCONCOD_SELS", AV93TFTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGECANTI", GXutil.ltrim( localUtil.ntoc( AV44TFAgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGECANTI_TO", GXutil.ltrim( localUtil.ntoc( AV45TFAgeCanti_To, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEPERDESCRIP", AV130TFAgePerDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAGEPERDESCRIP_SELS", AV131TFAgePerDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAGEPERDESCRIP_SELS", AV131TFAgePerDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEFECDES", localUtil.dtoc( AV50TFAgeFecDes, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAGEFECDES_SELS", AV110TFAgeFecDes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAGEFECDES_SELS", AV110TFAgeFecDes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEFECHAS", localUtil.dtoc( AV55TFAgeFecHas, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAGEFECHAS_SELS", AV112TFAgeFecHas_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAGEFECHAS_SELS", AV112TFAgeFecHas_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGELIQNRO", GXutil.ltrim( localUtil.ntoc( AV106TFAgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGELIQNRO_TO", GXutil.ltrim( localUtil.ntoc( AV107TFAgeLiqNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV82CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV82CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV85IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV85IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGID_SELSJSON", AV80TFLegId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGNOMAPE_SELSJSON", AV97TFLegNomApe_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO_SELSJSON", AV76TFConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP_SELSJSON", AV78TFConDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOCONCOD_SELSJSON", AV92TFTipoConCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEPERDESCRIP_SELSJSON", AV129TFAgePerDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEFECDES_SELSJSON", AV109TFAgeFecDes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAGEFECHAS_SELSJSON", AV111TFAgeFecHas_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV69EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69EmpCod), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEXTRAPARMS", AV96ExtraParms);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEXTRAPARMS", AV96ExtraParms);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Width", GXutil.rtrim( Importexcel_modal_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Title", GXutil.rtrim( Importexcel_modal_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Confirmtype", GXutil.rtrim( Importexcel_modal_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Bodytype", GXutil.rtrim( Importexcel_modal_Bodytype));
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
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         WebComp_Wwpaux_wc.componentjscripts();
      }
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
         we2L2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2L2( ) ;
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
      return formatLink("web.novedadesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV120MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "NovedadesWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Agenda de Novedades", "") ;
   }

   public void wb2L0( )
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
         wb_table1_9_2L2( true) ;
      }
      else
      {
         wb_table1_9_2L2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2L2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV63DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         wb_table2_157_2L2( true) ;
      }
      else
      {
         wb_table2_157_2L2( false) ;
      }
      return  ;
   }

   public void wb_table2_157_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0164"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0164"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_125_Refreshing )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0164"+"");
                  }
                  WebComp_Wwpaux_wc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_agefecdesauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 166,'',false,'" + sGXsfl_125_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDdo_agefecdesauxdate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_agefecdesauxdate_Internalname, localUtil.format(AV52DDO_AgeFecDesAuxDate, "99/99/9999"), localUtil.format( AV52DDO_AgeFecDesAuxDate, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,166);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_agefecdesauxdate_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadesWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDdo_agefecdesauxdate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_NovedadesWW.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_agefechasauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 168,'',false,'" + sGXsfl_125_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDdo_agefechasauxdate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_agefechasauxdate_Internalname, localUtil.format(AV57DDO_AgeFecHasAuxDate, "99/99/9999"), localUtil.format( AV57DDO_AgeFecHasAuxDate, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,168);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_agefechasauxdate_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadesWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDdo_agefechasauxdate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_NovedadesWW.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 125 )
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

   public void start2L2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Agenda de Novedades", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2L0( ) ;
   }

   public void ws2L2( )
   {
      start2L2( ) ;
      evt2L2( ) ;
   }

   public void evt2L2( )
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
                           e112L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "IMPORTEXCEL_MODAL.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e162L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOTEST'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Dotest' */
                           e172L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e182L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e192L2 ();
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
                           nGXsfl_125_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_125_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_125_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1252( ) ;
                           A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A93LegId = httpContext.cgiGet( edtLegId_Internalname) ;
                           n93LegId = false ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( edtAgeOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A591LegNomApe = httpContext.cgiGet( edtLegNomApe_Internalname) ;
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
                           cmbTipoConCod.setName( cmbTipoConCod.getInternalname() );
                           cmbTipoConCod.setValue( httpContext.cgiGet( cmbTipoConCod.getInternalname()) );
                           A37TipoConCod = httpContext.cgiGet( cmbTipoConCod.getInternalname()) ;
                           A110AgeCanti = localUtil.ctond( httpContext.cgiGet( edtAgeCanti_Internalname)) ;
                           n110AgeCanti = false ;
                           A113AgeImporte = localUtil.ctond( httpContext.cgiGet( edtAgeImporte_Internalname)) ;
                           n113AgeImporte = false ;
                           A1132AgePrevis = httpContext.cgiGet( edtAgePrevis_Internalname) ;
                           A2159AgePerDescrip = httpContext.cgiGet( edtAgePerDescrip_Internalname) ;
                           A111AgeFecDes = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtAgeFecDes_Internalname), 0)) ;
                           n111AgeFecDes = false ;
                           A112AgeFecHas = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtAgeFecHas_Internalname), 0)) ;
                           n112AgeFecHas = false ;
                           A1254AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtAgeLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1254AgeLiqNro = false ;
                           AV94Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV94Update);
                           AV95Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV95Delete);
                           AV119Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV119Display);
                           AV116VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV116VerSVG);
                           AV117ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV117ModificarSVG);
                           AV118EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV118EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e202L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e212L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e222L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Verliquidadas Changed */
                                    if ( GXutil.strtobool( httpContext.cgiGet( "GXH_vVERLIQUIDADAS")) != AV108VerLiquidadas )
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 164 )
                     {
                        OldWwpaux_wc = httpContext.cgiGet( "W0164") ;
                        if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                        {
                           WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "web." + OldWwpaux_wc + "_impl", remoteHandle, context);
                           WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                        }
                        if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                        {
                           WebComp_Wwpaux_wc.componentprocess("W0164", "", sEvt);
                        }
                        WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we2L2( )
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

   public void pa2L2( )
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
      subsflControlProps_1252( ) ;
      while ( nGXsfl_125_idx <= nRC_GXsfl_125 )
      {
         sendrow_1252( ) ;
         nGXsfl_125_idx = ((subGrid_Islastpage==1)&&(nGXsfl_125_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_125_idx+1) ;
         sGXsfl_125_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_125_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1252( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 boolean AV108VerLiquidadas ,
                                 byte AV115ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ,
                                 String AV144Pgmname ,
                                 String AV120MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV11GridState ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 String AV61TFLegId ,
                                 GXSimpleCollection<String> AV81TFLegId_Sels ,
                                 String AV98TFLegNomApe ,
                                 GXSimpleCollection<String> AV99TFLegNomApe_Sels ,
                                 String AV40TFConCodigo ,
                                 GXSimpleCollection<String> AV77TFConCodigo_Sels ,
                                 String AV42TFConDescrip ,
                                 GXSimpleCollection<String> AV79TFConDescrip_Sels ,
                                 GXSimpleCollection<String> AV93TFTipoConCod_Sels ,
                                 java.math.BigDecimal AV44TFAgeCanti ,
                                 java.math.BigDecimal AV45TFAgeCanti_To ,
                                 String AV130TFAgePerDescrip ,
                                 GXSimpleCollection<String> AV131TFAgePerDescrip_Sels ,
                                 java.util.Date AV50TFAgeFecDes ,
                                 GXSimpleCollection<java.util.Date> AV110TFAgeFecDes_Sels ,
                                 java.util.Date AV55TFAgeFecHas ,
                                 GXSimpleCollection<java.util.Date> AV112TFAgeFecHas_Sels ,
                                 int AV106TFAgeLiqNro ,
                                 int AV107TFAgeLiqNro_To ,
                                 int AV82CliCod ,
                                 boolean AV84IsAuthorized_Update ,
                                 boolean AV85IsAuthorized_Delete ,
                                 short AV69EmpCod ,
                                 boolean AV122WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e212L2 ();
      GRID_nCurrentRecord = 0 ;
      rf2L2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_AGELIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1254AgeLiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "AGELIQNRO", GXutil.ltrim( localUtil.ntoc( A1254AgeLiqNro, (byte)(8), (byte)(0), ".", "")));
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
      AV122WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV122WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV122WelcomeMessage_NoMostrarMas", AV122WelcomeMessage_NoMostrarMas);
      AV108VerLiquidadas = GXutil.strtobool( GXutil.booltostr( AV108VerLiquidadas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108VerLiquidadas", AV108VerLiquidadas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2L2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV144Pgmname = "NovedadesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
   }

   public void rf2L2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(125) ;
      /* Execute user event: Refresh */
      e212L2 ();
      nGXsfl_125_idx = 1 ;
      sGXsfl_125_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_125_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1252( ) ;
      bGXsfl_125_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
            {
               WebComp_Wwpaux_wc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1252( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A93LegId ,
                                              AV81TFLegId_Sels ,
                                              A591LegNomApe ,
                                              AV99TFLegNomApe_Sels ,
                                              A26ConCodigo ,
                                              AV77TFConCodigo_Sels ,
                                              A41ConDescrip ,
                                              AV79TFConDescrip_Sels ,
                                              A37TipoConCod ,
                                              AV93TFTipoConCod_Sels ,
                                              A2159AgePerDescrip ,
                                              AV131TFAgePerDescrip_Sels ,
                                              A111AgeFecDes ,
                                              AV110TFAgeFecDes_Sels ,
                                              A112AgeFecHas ,
                                              AV112TFAgeFecHas_Sels ,
                                              Boolean.valueOf(AV108VerLiquidadas) ,
                                              Integer.valueOf(AV81TFLegId_Sels.size()) ,
                                              AV61TFLegId ,
                                              Integer.valueOf(AV99TFLegNomApe_Sels.size()) ,
                                              AV98TFLegNomApe ,
                                              Integer.valueOf(AV77TFConCodigo_Sels.size()) ,
                                              AV40TFConCodigo ,
                                              Integer.valueOf(AV79TFConDescrip_Sels.size()) ,
                                              AV42TFConDescrip ,
                                              Integer.valueOf(AV93TFTipoConCod_Sels.size()) ,
                                              AV44TFAgeCanti ,
                                              AV45TFAgeCanti_To ,
                                              Integer.valueOf(AV131TFAgePerDescrip_Sels.size()) ,
                                              AV130TFAgePerDescrip ,
                                              Integer.valueOf(AV110TFAgeFecDes_Sels.size()) ,
                                              Integer.valueOf(AV112TFAgeFecHas_Sels.size()) ,
                                              Integer.valueOf(AV106TFAgeLiqNro) ,
                                              Integer.valueOf(AV107TFAgeLiqNro_To) ,
                                              Integer.valueOf(A1254AgeLiqNro) ,
                                              A110AgeCanti ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV82CliCod) ,
                                              Short.valueOf(AV69EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                              TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV61TFLegId = GXutil.padr( GXutil.rtrim( AV61TFLegId), 20, "%") ;
         lV98TFLegNomApe = GXutil.concat( GXutil.rtrim( AV98TFLegNomApe), "%", "") ;
         lV40TFConCodigo = GXutil.padr( GXutil.rtrim( AV40TFConCodigo), 10, "%") ;
         lV42TFConDescrip = GXutil.concat( GXutil.rtrim( AV42TFConDescrip), "%", "") ;
         lV130TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV130TFAgePerDescrip), "%", "") ;
         /* Using cursor H002L2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV82CliCod), Short.valueOf(AV69EmpCod), lV61TFLegId, lV98TFLegNomApe, lV40TFConCodigo, lV42TFConDescrip, AV44TFAgeCanti, AV45TFAgeCanti_To, lV130TFAgePerDescrip, Integer.valueOf(AV106TFAgeLiqNro), Integer.valueOf(AV107TFAgeLiqNro_To), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_125_idx = 1 ;
         sGXsfl_125_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_125_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1252( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1254AgeLiqNro = H002L2_A1254AgeLiqNro[0] ;
            n1254AgeLiqNro = H002L2_n1254AgeLiqNro[0] ;
            A2159AgePerDescrip = H002L2_A2159AgePerDescrip[0] ;
            A37TipoConCod = H002L2_A37TipoConCod[0] ;
            A41ConDescrip = H002L2_A41ConDescrip[0] ;
            A591LegNomApe = H002L2_A591LegNomApe[0] ;
            A25AgeOrden = H002L2_A25AgeOrden[0] ;
            A93LegId = H002L2_A93LegId[0] ;
            n93LegId = H002L2_n93LegId[0] ;
            A239LegCUIL = H002L2_A239LegCUIL[0] ;
            A112AgeFecHas = H002L2_A112AgeFecHas[0] ;
            n112AgeFecHas = H002L2_n112AgeFecHas[0] ;
            A111AgeFecDes = H002L2_A111AgeFecDes[0] ;
            n111AgeFecDes = H002L2_n111AgeFecDes[0] ;
            A113AgeImporte = H002L2_A113AgeImporte[0] ;
            n113AgeImporte = H002L2_n113AgeImporte[0] ;
            A110AgeCanti = H002L2_A110AgeCanti[0] ;
            n110AgeCanti = H002L2_n110AgeCanti[0] ;
            A26ConCodigo = H002L2_A26ConCodigo[0] ;
            A6LegNumero = H002L2_A6LegNumero[0] ;
            A1EmpCod = H002L2_A1EmpCod[0] ;
            A3CliCod = H002L2_A3CliCod[0] ;
            A591LegNomApe = H002L2_A591LegNomApe[0] ;
            A93LegId = H002L2_A93LegId[0] ;
            n93LegId = H002L2_n93LegId[0] ;
            A239LegCUIL = H002L2_A239LegCUIL[0] ;
            A37TipoConCod = H002L2_A37TipoConCod[0] ;
            A41ConDescrip = H002L2_A41ConDescrip[0] ;
            GXt_char1 = A1132AgePrevis ;
            GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char3[0] = "" ;
            GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char5[0] = GXt_char1 ;
            new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal2, GXv_char3, GXv_decimal4, GXv_char5) ;
            novedadesww_impl.this.GXt_char1 = GXv_char5[0] ;
            A1132AgePrevis = GXt_char1 ;
            e222L2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(125) ;
         wb2L0( ) ;
      }
      bGXsfl_125_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2L2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV144Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV144Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV120MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV120MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_AGELIQNRO"+"_"+sGXsfl_125_idx, getSecureSignedToken( sGXsfl_125_idx, localUtil.format( DecimalUtil.doubleToDec(A1254AgeLiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV82CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV82CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV84IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV85IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV85IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV69EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69EmpCod), "ZZZ9")));
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
                                           A93LegId ,
                                           AV81TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV99TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV77TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV79TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV93TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV131TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV110TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV112TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV108VerLiquidadas) ,
                                           Integer.valueOf(AV81TFLegId_Sels.size()) ,
                                           AV61TFLegId ,
                                           Integer.valueOf(AV99TFLegNomApe_Sels.size()) ,
                                           AV98TFLegNomApe ,
                                           Integer.valueOf(AV77TFConCodigo_Sels.size()) ,
                                           AV40TFConCodigo ,
                                           Integer.valueOf(AV79TFConDescrip_Sels.size()) ,
                                           AV42TFConDescrip ,
                                           Integer.valueOf(AV93TFTipoConCod_Sels.size()) ,
                                           AV44TFAgeCanti ,
                                           AV45TFAgeCanti_To ,
                                           Integer.valueOf(AV131TFAgePerDescrip_Sels.size()) ,
                                           AV130TFAgePerDescrip ,
                                           Integer.valueOf(AV110TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV112TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV106TFAgeLiqNro) ,
                                           Integer.valueOf(AV107TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV82CliCod) ,
                                           Short.valueOf(AV69EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV61TFLegId = GXutil.padr( GXutil.rtrim( AV61TFLegId), 20, "%") ;
      lV98TFLegNomApe = GXutil.concat( GXutil.rtrim( AV98TFLegNomApe), "%", "") ;
      lV40TFConCodigo = GXutil.padr( GXutil.rtrim( AV40TFConCodigo), 10, "%") ;
      lV42TFConDescrip = GXutil.concat( GXutil.rtrim( AV42TFConDescrip), "%", "") ;
      lV130TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV130TFAgePerDescrip), "%", "") ;
      /* Using cursor H002L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV82CliCod), Short.valueOf(AV69EmpCod), lV61TFLegId, lV98TFLegNomApe, lV40TFConCodigo, lV42TFConDescrip, AV44TFAgeCanti, AV45TFAgeCanti_To, lV130TFAgePerDescrip, Integer.valueOf(AV106TFAgeLiqNro), Integer.valueOf(AV107TFAgeLiqNro_To)});
      GRID_nRecordCount = H002L3_AGRID_nRecordCount[0] ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV108VerLiquidadas, AV115ManageFiltersExecutionStep, AV20ColumnsSelector, AV144Pgmname, AV120MenuOpcCod, AV11GridState, AV13OrderedBy, AV14OrderedDsc, AV61TFLegId, AV81TFLegId_Sels, AV98TFLegNomApe, AV99TFLegNomApe_Sels, AV40TFConCodigo, AV77TFConCodigo_Sels, AV42TFConDescrip, AV79TFConDescrip_Sels, AV93TFTipoConCod_Sels, AV44TFAgeCanti, AV45TFAgeCanti_To, AV130TFAgePerDescrip, AV131TFAgePerDescrip_Sels, AV50TFAgeFecDes, AV110TFAgeFecDes_Sels, AV55TFAgeFecHas, AV112TFAgeFecHas_Sels, AV106TFAgeLiqNro, AV107TFAgeLiqNro_To, AV82CliCod, AV84IsAuthorized_Update, AV85IsAuthorized_Delete, AV69EmpCod, AV122WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV144Pgmname = "NovedadesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_125_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2L0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e202L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV63DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV20ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV113ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEXTRAPARMS"), AV96ExtraParms);
         /* Read saved values. */
         nRC_GXsfl_125 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_125"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV65GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV66GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV67GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV69EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV82CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV120MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
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
         Importexcel_modal_Width = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Width") ;
         Importexcel_modal_Title = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Title") ;
         Importexcel_modal_Confirmtype = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Confirmtype") ;
         Importexcel_modal_Bodytype = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Bodytype") ;
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
         AV128WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV122WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV122WelcomeMessage_NoMostrarMas", AV122WelcomeMessage_NoMostrarMas);
         AV108VerLiquidadas = GXutil.strtobool( httpContext.cgiGet( chkavVerliquidadas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV108VerLiquidadas", AV108VerLiquidadas);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDdo_agefecdesauxdate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDDO_AGEFECDESAUXDATE");
            GX_FocusControl = edtavDdo_agefecdesauxdate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV52DDO_AgeFecDesAuxDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52DDO_AgeFecDesAuxDate", localUtil.format(AV52DDO_AgeFecDesAuxDate, "99/99/9999"));
         }
         else
         {
            AV52DDO_AgeFecDesAuxDate = localUtil.ctod( httpContext.cgiGet( edtavDdo_agefecdesauxdate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52DDO_AgeFecDesAuxDate", localUtil.format(AV52DDO_AgeFecDesAuxDate, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDdo_agefechasauxdate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDDO_AGEFECHASAUXDATE");
            GX_FocusControl = edtavDdo_agefechasauxdate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV57DDO_AgeFecHasAuxDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57DDO_AgeFecHasAuxDate", localUtil.format(AV57DDO_AgeFecHasAuxDate, "99/99/9999"));
         }
         else
         {
            AV57DDO_AgeFecHasAuxDate = localUtil.ctod( httpContext.cgiGet( edtavDdo_agefechasauxdate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57DDO_AgeFecHasAuxDate", localUtil.format(AV57DDO_AgeFecHasAuxDate, "99/99/9999"));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strtobool( httpContext.cgiGet( "GXH_vVERLIQUIDADAS")) != AV108VerLiquidadas )
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
      e202L2 ();
      if (returnInSub) return;
   }

   public void e202L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV120MenuOpcCod, "", "") ;
      GXt_int6 = AV82CliCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
      novedadesww_impl.this.GXt_int6 = GXv_int7[0] ;
      AV82CliCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV82CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " Agenda de Novedades", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8 = AV63DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9[0] ;
      AV63DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV123MenuBienveImgURL ;
      GXv_char3[0] = AV125MenuBienveTitulo ;
      GXv_char10[0] = AV126MenuBienveTexto ;
      GXv_boolean11[0] = AV127MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV120MenuOpcCod, GXv_char5, GXv_char3, GXv_char10, GXv_boolean11) ;
      novedadesww_impl.this.AV123MenuBienveImgURL = GXv_char5[0] ;
      novedadesww_impl.this.AV125MenuBienveTitulo = GXv_char3[0] ;
      novedadesww_impl.this.AV126MenuBienveTexto = GXv_char10[0] ;
      novedadesww_impl.this.AV127MenuBienveVisible = GXv_boolean11[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV127MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV127MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV125MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV126MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV128WelcomeMessage_Foto = AV123MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV128WelcomeMessage_Foto)==0) ? AV143Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV128WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV128WelcomeMessage_Foto), true);
         AV143Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV123MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV128WelcomeMessage_Foto)==0) ? AV143Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV128WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV128WelcomeMessage_Foto), true);
      }
      GXt_char1 = "" ;
      GXt_char12 = "" ;
      GXv_char10[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      GXv_char5[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char5) ;
      novedadesww_impl.this.GXt_char1 = GXv_char5[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV137observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV137observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV137observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV137observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXt_char12 = "" ;
      GXv_char10[0] = GXt_char12 ;
      new web.descripcionnovedadconceptoslarga(remoteHandle, context).execute( AV82CliCod, GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      Form.setCaption( GXt_char12 );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
   }

   public void e212L2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int13 = AV69EmpCod ;
      GXv_int14[0] = GXt_int13 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int14) ;
      novedadesww_impl.this.GXt_int13 = GXv_int14[0] ;
      AV69EmpCod = GXt_int13 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69EmpCod), "ZZZ9")));
      GXt_int6 = AV82CliCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
      novedadesww_impl.this.GXt_int6 = GXv_int7[0] ;
      AV82CliCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV82CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext15[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext15) ;
      AV6WWPContext = GXv_SdtWWPContext15[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV115ManageFiltersExecutionStep == 1 )
      {
         AV115ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115ManageFiltersExecutionStep", GXutil.str( AV115ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV115ManageFiltersExecutionStep == 2 )
      {
         AV115ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115ManageFiltersExecutionStep", GXutil.str( AV115ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV22Session.getValue("NovedadesWWColumnsSelector"), "") != 0 )
      {
         AV18ColumnsSelectorXML = AV22Session.getValue("NovedadesWWColumnsSelector") ;
         AV20ColumnsSelector.fromxml(AV18ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtLegCUIL_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtLegId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegId_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtLegNomApe_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNomApe_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNomApe_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtConDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Visible), 5, 0), !bGXsfl_125_Refreshing);
      cmbTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbTipoConCod.getVisible(), 5, 0), !bGXsfl_125_Refreshing);
      edtAgeCanti_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeCanti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeCanti_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtAgePrevis_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgePrevis_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgePrevis_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtAgePerDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgePerDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgePerDescrip_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtAgeFecDes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeFecDes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeFecDes_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtAgeFecHas_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeFecHas_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeFecHas_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtAgeLiqNro_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeLiqNro_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_125_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_125_Refreshing);
      AV65GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65GridCurrentPage), 10, 0));
      AV66GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66GridPageCount), 10, 0));
      GXt_char12 = AV67GridAppliedFilters ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV144Pgmname, GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV67GridAppliedFilters = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67GridAppliedFilters", AV67GridAppliedFilters);
      GXt_char12 = AV136MenuOpcTitulo ;
      GXv_char10[0] = GXt_char12 ;
      new web.gettxtcount(remoteHandle, context).execute( AV120MenuOpcCod, GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV136MenuOpcTitulo = GXt_char12 ;
      if ( (GXutil.strcmp("", AV136MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV136MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int14[0] = (short)(AV139filterCount) ;
      GXv_char10[0] = AV140filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV11GridState, GXv_int14, GXv_char10) ;
      novedadesww_impl.this.AV139filterCount = GXv_int14[0] ;
      novedadesww_impl.this.AV140filtrosTexto = GXv_char10[0] ;
      if ( AV139filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV139filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV140filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV113ManageFiltersData", AV113ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e132L2( )
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
         AV64PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV64PageToGo) ;
      }
   }

   public void e142L2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e152L2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegId") == 0 )
         {
            AV61TFLegId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFLegId", AV61TFLegId);
            AV80TFLegId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFLegId_SelsJson", AV80TFLegId_SelsJson);
            AV81TFLegId_Sels.fromJSonString(AV80TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegNomApe") == 0 )
         {
            AV98TFLegNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFLegNomApe", AV98TFLegNomApe);
            AV97TFLegNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFLegNomApe_SelsJson", AV97TFLegNomApe_SelsJson);
            AV99TFLegNomApe_Sels.fromJSonString(AV97TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodigo") == 0 )
         {
            AV40TFConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConCodigo", AV40TFConCodigo);
            AV76TFConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFConCodigo_SelsJson", AV76TFConCodigo_SelsJson);
            AV77TFConCodigo_Sels.fromJSonString(AV76TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConDescrip") == 0 )
         {
            AV42TFConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConDescrip", AV42TFConDescrip);
            AV78TFConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFConDescrip_SelsJson", AV78TFConDescrip_SelsJson);
            AV79TFConDescrip_Sels.fromJSonString(AV78TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipoConCod") == 0 )
         {
            AV92TFTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFTipoConCod_SelsJson", AV92TFTipoConCod_SelsJson);
            AV93TFTipoConCod_Sels.fromJSonString(AV92TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AgeCanti") == 0 )
         {
            AV44TFAgeCanti = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFAgeCanti", GXutil.ltrimstr( AV44TFAgeCanti, 9, 2));
            AV45TFAgeCanti_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFAgeCanti_To", GXutil.ltrimstr( AV45TFAgeCanti_To, 9, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AgePerDescrip") == 0 )
         {
            AV130TFAgePerDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV130TFAgePerDescrip", AV130TFAgePerDescrip);
            AV129TFAgePerDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFAgePerDescrip_SelsJson", AV129TFAgePerDescrip_SelsJson);
            AV131TFAgePerDescrip_Sels.fromJSonString(AV129TFAgePerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AgeFecDes") == 0 )
         {
            AV50TFAgeFecDes = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFAgeFecDes", localUtil.format(AV50TFAgeFecDes, "99/99/9999"));
            AV109TFAgeFecDes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV109TFAgeFecDes_SelsJson", AV109TFAgeFecDes_SelsJson);
            AV110TFAgeFecDes_Sels.fromJSonString(AV109TFAgeFecDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AgeFecHas") == 0 )
         {
            AV55TFAgeFecHas = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFAgeFecHas", localUtil.format(AV55TFAgeFecHas, "99/99/9999"));
            AV111TFAgeFecHas_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFAgeFecHas_SelsJson", AV111TFAgeFecHas_SelsJson);
            AV112TFAgeFecHas_Sels.fromJSonString(AV111TFAgeFecHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AgeLiqNro") == 0 )
         {
            AV106TFAgeLiqNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV106TFAgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV106TFAgeLiqNro), 8, 0));
            AV107TFAgeLiqNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFAgeLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV107TFAgeLiqNro_To), 8, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV112TFAgeFecHas_Sels", AV112TFAgeFecHas_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV110TFAgeFecDes_Sels", AV110TFAgeFecDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV131TFAgePerDescrip_Sels", AV131TFAgePerDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFTipoConCod_Sels", AV93TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFConDescrip_Sels", AV79TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFConCodigo_Sels", AV77TFConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV99TFLegNomApe_Sels", AV99TFLegNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFLegId_Sels", AV81TFLegId_Sels);
   }

   private void e222L2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV94Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV94Update);
      if ( AV84IsAuthorized_Update )
      {
         if ( (0==A1254AgeLiqNro) )
         {
            edtavUpdate_Link = formatLink("web.novedades", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A25AgeOrden,4,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","AgeOrden"})  ;
            edtavUpdate_Class = "Attribute" ;
         }
         else
         {
            edtavUpdate_Link = "" ;
            edtavUpdate_Class = "Invisible" ;
         }
      }
      AV95Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV95Delete);
      if ( AV85IsAuthorized_Delete )
      {
         if ( (0==A1254AgeLiqNro) )
         {
            edtavDelete_Link = formatLink("web.novedades", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A25AgeOrden,4,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","AgeOrden"})  ;
            edtavDelete_Class = "Attribute" ;
         }
         else
         {
            edtavDelete_Link = "" ;
            edtavDelete_Class = "Invisible" ;
         }
      }
      AV119Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV119Display);
      edtavDisplay_Link = formatLink("web.novedadesview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A25AgeOrden,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","AgeOrden","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char12 = AV116VerSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV116VerSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV116VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char12 = AV117ModificarSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV117ModificarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV117ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char12 = AV118EliminarSVG ;
      GXv_char10[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV118EliminarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV118EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(125) ;
      }
      sendrow_1252( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_125_Refreshing )
      {
         httpContext.doAjaxLoad(125, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e112L2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV18ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV20ColumnsSelector.fromJSonString(AV18ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "NovedadesWWColumnsSelector", ((GXutil.strcmp("", AV18ColumnsSelectorXML)==0) ? "" : AV20ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV113ManageFiltersData", AV113ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e122L2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("NovedadesWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV144Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV115ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115ManageFiltersExecutionStep", GXutil.str( AV115ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("NovedadesWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV115ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115ManageFiltersExecutionStep", GXutil.str( AV115ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char12 = AV114ManageFiltersXml ;
         GXv_char10[0] = GXt_char12 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "NovedadesWWFilters", Ddo_managefilters_Activeeventkey, GXv_char10) ;
         novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
         AV114ManageFiltersXml = GXt_char12 ;
         if ( (GXutil.strcmp("", AV114ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV144Pgmname+"GridState", AV114ManageFiltersXml) ;
            AV11GridState.fromxml(AV114ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFLegId_Sels", AV81TFLegId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV99TFLegNomApe_Sels", AV99TFLegNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV77TFConCodigo_Sels", AV77TFConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFConDescrip_Sels", AV79TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFTipoConCod_Sels", AV93TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV131TFAgePerDescrip_Sels", AV131TFAgePerDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV110TFAgeFecDes_Sels", AV110TFAgeFecDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV112TFAgeFecHas_Sels", AV112TFAgeFecHas_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV113ManageFiltersData", AV113ManageFiltersData);
   }

   public void e172L2( )
   {
      /* 'Dotest' Routine */
      returnInSub = false ;
      new web.agendatest(remoteHandle, context).execute( ) ;
   }

   public void e162L2( )
   {
      /* Importexcel_modal_Close Routine */
      returnInSub = false ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV113ManageFiltersData", AV113ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e182L2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char10[0] = AV16ExcelFilename ;
      GXv_char5[0] = AV17ErrorMessage ;
      new web.novedadeswwexport(remoteHandle, context).execute( GXv_char10, GXv_char5) ;
      novedadesww_impl.this.AV16ExcelFilename = GXv_char10[0] ;
      novedadesww_impl.this.AV17ErrorMessage = GXv_char5[0] ;
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
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "LegCUIL", "", "CUIL", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "LegId", "", "Legajo Id.", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "LegNomApe", "", "Legajo", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "ConCodigo", "", "Concepto", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "ConDescrip", "", "Descripción", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "TipoConCod", "", "Tipo", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgeCanti", "", "Cantidad", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgePrevis", "", "Importe", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgePerDescrip", "", "Periodo", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgeFecDes", "", "Desde", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgeFecHas", "", "Hasta", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "AgeLiqNro", "", "Nro. Liq.", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&VerSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      if ( (0==A1254AgeLiqNro) )
      {
         GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&ModificarSVG", "", "", true, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "", "", "", false, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      if ( (0==A1254AgeLiqNro) )
      {
         GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&EliminarSVG", "", "", true, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector16[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "", "", "", false, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      GXt_char12 = AV19UserCustomValue ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "NovedadesWWColumnsSelector", GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      AV19UserCustomValue = GXt_char12 ;
      if ( ! ( (GXutil.strcmp("", AV19UserCustomValue)==0) ) )
      {
         AV21ColumnsSelectorAux.fromxml(AV19UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector16[0] = AV21ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector17[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, GXv_SdtWWPColumnsSelector17) ;
         AV21ColumnsSelectorAux = GXv_SdtWWPColumnsSelector16[0] ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
      }
      GXv_SdtWWPColumnsSelector17[0] = AV20ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV82CliCod, GXv_SdtWWPColumnsSelector17) ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean18 = AV84IsAuthorized_Update ;
      GXv_boolean11[0] = GXt_boolean18 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Update", GXv_boolean11) ;
      novedadesww_impl.this.GXt_boolean18 = GXv_boolean11[0] ;
      AV84IsAuthorized_Update = GXt_boolean18 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84IsAuthorized_Update", AV84IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV84IsAuthorized_Update));
      if ( ! ( AV84IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_125_Refreshing);
      }
      GXt_boolean18 = AV85IsAuthorized_Delete ;
      GXv_boolean11[0] = GXt_boolean18 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Delete", GXv_boolean11) ;
      novedadesww_impl.this.GXt_boolean18 = GXv_boolean11[0] ;
      AV85IsAuthorized_Delete = GXt_boolean18 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85IsAuthorized_Delete", AV85IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV85IsAuthorized_Delete));
      if ( ! ( AV85IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_125_Refreshing);
      }
      if ( ! ( false ) )
      {
         bttBtntest_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntest_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntest_Visible), 5, 0), true);
      }
      GXt_boolean18 = AV88TempBoolean ;
      GXv_boolean11[0] = GXt_boolean18 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean11) ;
      novedadesww_impl.this.GXt_boolean18 = GXv_boolean11[0] ;
      AV88TempBoolean = GXt_boolean18 ;
      if ( ! ( AV88TempBoolean ) )
      {
         bttBtnimportexcel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnimportexcel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportexcel_Visible), 5, 0), true);
      }
      GXt_boolean18 = AV88TempBoolean ;
      GXv_boolean11[0] = GXt_boolean18 ;
      new web.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "ABMNovedadConcepto", GXv_boolean11) ;
      novedadesww_impl.this.GXt_boolean18 = GXv_boolean11[0] ;
      AV88TempBoolean = GXt_boolean18 ;
      if ( ! ( AV88TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = AV113ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item20[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "NovedadesWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item20) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item20[0] ;
      AV113ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV108VerLiquidadas = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108VerLiquidadas", AV108VerLiquidadas);
      AV61TFLegId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFLegId", AV61TFLegId);
      AV81TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV98TFLegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98TFLegNomApe", AV98TFLegNomApe);
      AV99TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40TFConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFConCodigo", AV40TFConCodigo);
      AV77TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42TFConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFConDescrip", AV42TFConDescrip);
      AV79TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV93TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44TFAgeCanti = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFAgeCanti", GXutil.ltrimstr( AV44TFAgeCanti, 9, 2));
      AV45TFAgeCanti_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFAgeCanti_To", GXutil.ltrimstr( AV45TFAgeCanti_To, 9, 2));
      AV130TFAgePerDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV130TFAgePerDescrip", AV130TFAgePerDescrip);
      AV131TFAgePerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50TFAgeFecDes = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFAgeFecDes", localUtil.format(AV50TFAgeFecDes, "99/99/9999"));
      AV110TFAgeFecDes_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      AV55TFAgeFecHas = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFAgeFecHas", localUtil.format(AV55TFAgeFecHas, "99/99/9999"));
      AV112TFAgeFecHas_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      AV106TFAgeLiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV106TFAgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV106TFAgeLiqNro), 8, 0));
      AV107TFAgeLiqNro_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV107TFAgeLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV107TFAgeLiqNro_To), 8, 0));
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
      if ( GXutil.strcmp(AV22Session.getValue(AV144Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV144Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV22Session.getValue(AV144Pgmname+"GridState"), null, null);
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
      AV145GXV1 = 1 ;
      while ( AV145GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV145GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "VERLIQUIDADAS") == 0 )
         {
            AV108VerLiquidadas = GXutil.boolval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108VerLiquidadas", AV108VerLiquidadas);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV61TFLegId = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFLegId", AV61TFLegId);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV80TFLegId_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFLegId_SelsJson", AV80TFLegId_SelsJson);
            AV81TFLegId_Sels.fromJSonString(AV80TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV98TFLegNomApe = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFLegNomApe", AV98TFLegNomApe);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV97TFLegNomApe_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFLegNomApe_SelsJson", AV97TFLegNomApe_SelsJson);
            AV99TFLegNomApe_Sels.fromJSonString(AV97TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV40TFConCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConCodigo", AV40TFConCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV76TFConCodigo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFConCodigo_SelsJson", AV76TFConCodigo_SelsJson);
            AV77TFConCodigo_Sels.fromJSonString(AV76TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV42TFConDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConDescrip", AV42TFConDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV78TFConDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFConDescrip_SelsJson", AV78TFConDescrip_SelsJson);
            AV79TFConDescrip_Sels.fromJSonString(AV78TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV92TFTipoConCod_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFTipoConCod_SelsJson", AV92TFTipoConCod_SelsJson);
            AV93TFTipoConCod_Sels.fromJSonString(AV92TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGECANTI") == 0 )
         {
            AV44TFAgeCanti = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFAgeCanti", GXutil.ltrimstr( AV44TFAgeCanti, 9, 2));
            AV45TFAgeCanti_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFAgeCanti_To", GXutil.ltrimstr( AV45TFAgeCanti_To, 9, 2));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP") == 0 )
         {
            AV130TFAgePerDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV130TFAgePerDescrip", AV130TFAgePerDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP_SEL") == 0 )
         {
            AV129TFAgePerDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFAgePerDescrip_SelsJson", AV129TFAgePerDescrip_SelsJson);
            AV131TFAgePerDescrip_Sels.fromJSonString(AV129TFAgePerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES") == 0 )
         {
            AV50TFAgeFecDes = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFAgeFecDes", localUtil.format(AV50TFAgeFecDes, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES_SEL") == 0 )
         {
            AV109TFAgeFecDes_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV109TFAgeFecDes_SelsJson", AV109TFAgeFecDes_SelsJson);
            AV110TFAgeFecDes_Sels.fromJSonString(AV109TFAgeFecDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS") == 0 )
         {
            AV55TFAgeFecHas = localUtil.ctod( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFAgeFecHas", localUtil.format(AV55TFAgeFecHas, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS_SEL") == 0 )
         {
            AV111TFAgeFecHas_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFAgeFecHas_SelsJson", AV111TFAgeFecHas_SelsJson);
            AV112TFAgeFecHas_Sels.fromJSonString(AV111TFAgeFecHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGELIQNRO") == 0 )
         {
            AV106TFAgeLiqNro = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV106TFAgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV106TFAgeLiqNro), 8, 0));
            AV107TFAgeLiqNro_To = (int)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFAgeLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV107TFAgeLiqNro_To), 8, 0));
         }
         AV145GXV1 = (int)(AV145GXV1+1) ;
      }
      GXt_char12 = "" ;
      GXv_char10[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV81TFLegId_Sels.size()==0), AV80TFLegId_SelsJson, GXv_char10) ;
      novedadesww_impl.this.GXt_char12 = GXv_char10[0] ;
      GXt_char1 = "" ;
      GXv_char5[0] = GXt_char1 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV99TFLegNomApe_Sels.size()==0), AV97TFLegNomApe_SelsJson, GXv_char5) ;
      novedadesww_impl.this.GXt_char1 = GXv_char5[0] ;
      GXt_char21 = "" ;
      GXv_char3[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV77TFConCodigo_Sels.size()==0), AV76TFConCodigo_SelsJson, GXv_char3) ;
      novedadesww_impl.this.GXt_char21 = GXv_char3[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV79TFConDescrip_Sels.size()==0), AV78TFConDescrip_SelsJson, GXv_char23) ;
      novedadesww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV93TFTipoConCod_Sels.size()==0), AV92TFTipoConCod_SelsJson, GXv_char25) ;
      novedadesww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV131TFAgePerDescrip_Sels.size()==0), AV129TFAgePerDescrip_SelsJson, GXv_char27) ;
      novedadesww_impl.this.GXt_char26 = GXv_char27[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char12+"|"+GXt_char1+"|"+GXt_char21+"|"+GXt_char22+"|"+GXt_char24+"|||"+GXt_char26+"|"+((AV110TFAgeFecDes_Sels.size()==0) ? "" : AV109TFAgeFecDes_SelsJson)+"|"+((AV112TFAgeFecHas_Sels.size()==0) ? "" : AV111TFAgeFecHas_SelsJson)+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV61TFLegId)==0), AV61TFLegId, GXv_char27) ;
      novedadesww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV98TFLegNomApe)==0), AV98TFLegNomApe, GXv_char25) ;
      novedadesww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFConCodigo)==0), AV40TFConCodigo, GXv_char23) ;
      novedadesww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char21 = "" ;
      GXv_char10[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFConDescrip)==0), AV42TFConDescrip, GXv_char10) ;
      novedadesww_impl.this.GXt_char21 = GXv_char10[0] ;
      GXt_char12 = "" ;
      GXv_char5[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV130TFAgePerDescrip)==0), AV130TFAgePerDescrip, GXv_char5) ;
      novedadesww_impl.this.GXt_char12 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char26+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char21+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFAgeCanti)==0) ? "" : GXutil.str( AV44TFAgeCanti, 9, 2))+"||"+GXt_char12+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50TFAgeFecDes)) ? "" : localUtil.dtoc( AV50TFAgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55TFAgeFecHas)) ? "" : localUtil.dtoc( AV55TFAgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((0==AV106TFAgeLiqNro) ? "" : GXutil.str( AV106TFAgeLiqNro, 8, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFAgeCanti_To)==0) ? "" : GXutil.str( AV45TFAgeCanti_To, 9, 2))+"|||||"+((0==AV107TFAgeLiqNro_To) ? "" : GXutil.str( AV107TFAgeLiqNro_To, 8, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV22Session.getValue(AV144Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "VERLIQUIDADAS", httpContext.getMessage( "Ver registros ya liquidados", ""), !(false==AV108VerLiquidadas), (short)(0), GXutil.trim( GXutil.booltostr( AV108VerLiquidadas)), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLEGID", httpContext.getMessage( "Legajo Id.", ""), !(GXutil.strcmp("", AV61TFLegId)==0), (short)(0), AV61TFLegId, "", !(AV81TFLegId_Sels.size()==0), AV81TFLegId_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLEGNOMAPE", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV98TFLegNomApe)==0), (short)(0), AV98TFLegNomApe, "", !(AV99TFLegNomApe_Sels.size()==0), AV99TFLegNomApe_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFCONCODIGO", httpContext.getMessage( "Concepto", ""), !(GXutil.strcmp("", AV40TFConCodigo)==0), (short)(0), AV40TFConCodigo, "", !(AV77TFConCodigo_Sels.size()==0), AV77TFConCodigo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFCONDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV42TFConDescrip)==0), (short)(0), AV42TFConDescrip, "", !(AV79TFConDescrip_Sels.size()==0), AV79TFConDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFTIPOCONCOD_SEL", httpContext.getMessage( "Tipo", ""), !(AV93TFTipoConCod_Sels.size()==0), (short)(0), AV93TFTipoConCod_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFAGECANTI", httpContext.getMessage( "Cantidad", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFAgeCanti)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFAgeCanti_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV44TFAgeCanti, 9, 2)), GXutil.trim( GXutil.str( AV45TFAgeCanti_To, 9, 2))) ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFAGEPERDESCRIP", httpContext.getMessage( "Periodo", ""), !(GXutil.strcmp("", AV130TFAgePerDescrip)==0), (short)(0), AV130TFAgePerDescrip, "", !(AV131TFAgePerDescrip_Sels.size()==0), AV131TFAgePerDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFAGEFECDES", httpContext.getMessage( "Desde", ""), !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50TFAgeFecDes)), (short)(0), GXutil.trim( localUtil.dtoc( AV50TFAgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "", !(AV110TFAgeFecDes_Sels.size()==0), AV110TFAgeFecDes_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFAGEFECHAS", httpContext.getMessage( "Hasta", ""), !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55TFAgeFecHas)), (short)(0), GXutil.trim( localUtil.dtoc( AV55TFAgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "", !(AV112TFAgeFecHas_Sels.size()==0), AV112TFAgeFecHas_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFAGELIQNRO", httpContext.getMessage( "Nro. Liq.", ""), !((0==AV106TFAgeLiqNro)&&(0==AV107TFAgeLiqNro_To)), (short)(0), GXutil.trim( GXutil.str( AV106TFAgeLiqNro, 8, 0)), GXutil.trim( GXutil.str( AV107TFAgeLiqNro_To, 8, 0))) ;
      AV11GridState = GXv_SdtWWPGridState28[0] ;
      if ( ! (GXutil.strcmp("", AV120MenuOpcCod)==0) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV120MenuOpcCod );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV144Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV144Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Novedades" );
      AV22Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e192L2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV122WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean11[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV120MenuOpcCod, GXv_boolean11) ;
         GXv_char27[0] = AV124textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV82CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char27) ;
         novedadesww_impl.this.AV124textoNoMostrara = GXv_char27[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV124textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean11[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV120MenuOpcCod, GXv_boolean11) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table2_157_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableimportexcel_modal_Internalname, tblTableimportexcel_modal_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucImportexcel_modal.setProperty("Width", Importexcel_modal_Width);
         ucImportexcel_modal.setProperty("Title", Importexcel_modal_Title);
         ucImportexcel_modal.setProperty("ConfirmType", Importexcel_modal_Confirmtype);
         ucImportexcel_modal.setProperty("BodyType", Importexcel_modal_Bodytype);
         ucImportexcel_modal.render(context, "dvelop.gxbootstrap.confirmpanel", Importexcel_modal_Internalname, "IMPORTEXCEL_MODALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"IMPORTEXCEL_MODALContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_157_2L2e( true) ;
      }
      else
      {
         wb_table2_157_2L2e( false) ;
      }
   }

   public void wb_table1_9_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table3_12_2L2( true) ;
      }
      else
      {
         wb_table3_12_2L2( false) ;
      }
      return  ;
   }

   public void wb_table3_12_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2L2e( true) ;
      }
      else
      {
         wb_table1_9_2L2e( false) ;
      }
   }

   public void wb_table3_12_2L2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e232l1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_NovedadesWW.htm");
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
         AV128WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV128WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV143Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV128WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV128WelcomeMessage_Foto)==0) ? AV143Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV128WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV128WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_NovedadesWW.htm");
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
         wb_table4_30_2L2( true) ;
      }
      else
      {
         wb_table4_30_2L2( false) ;
      }
      return  ;
   }

   public void wb_table4_30_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table5_35_2L2( true) ;
      }
      else
      {
         wb_table5_35_2L2( false) ;
      }
      return  ;
   }

   public void wb_table5_35_2L2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_125_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV122WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
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
         wb_table6_54_2L2( true) ;
      }
      else
      {
         wb_table6_54_2L2( false) ;
      }
      return  ;
   }

   public void wb_table6_54_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table7_63_2L2( true) ;
      }
      else
      {
         wb_table7_63_2L2( false) ;
      }
      return  ;
   }

   public void wb_table7_63_2L2e( boolean wbgen )
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
         startgridcontrol125( ) ;
      }
      if ( wbEnd == 125 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_125 = (int)(nGXsfl_125_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV65GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV66GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV67GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_12_2L2e( true) ;
      }
      else
      {
         wb_table3_12_2L2e( false) ;
      }
   }

   public void wb_table7_63_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table8_66_2L2( true) ;
      }
      else
      {
         wb_table8_66_2L2( false) ;
      }
      return  ;
   }

   public void wb_table8_66_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_NovedadesWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
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
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtntest_Internalname, "gx.evt.setGridEvt("+GXutil.str( 125, 3, 0)+","+"null"+");", httpContext.getMessage( "test", ""), bttBtntest_Jsonclick, 5, httpContext.getMessage( "test", ""), "", StyleString, ClassString, bttBtntest_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOTEST\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportexcel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 125, 3, 0)+","+"null"+");", httpContext.getMessage( "Importar Excel", ""), bttBtnimportexcel_Jsonclick, 7, httpContext.getMessage( "WWP_ImportExcelTooltip", ""), "", StyleString, ClassString, bttBtnimportexcel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e242l1_client"+"'", TempTags, "", 2, "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV63DDO_TitleSettingsIcons);
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV113ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 125, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e252l1_client"+"'", TempTags, "", 2, "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 125, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_NovedadesWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_NovedadesWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table9_114_2L2( true) ;
      }
      else
      {
         wb_table9_114_2L2( false) ;
      }
      return  ;
   }

   public void wb_table9_114_2L2e( boolean wbgen )
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
         wb_table7_63_2L2e( true) ;
      }
      else
      {
         wb_table7_63_2L2e( false) ;
      }
   }

   public void wb_table9_114_2L2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_114_2L2e( true) ;
      }
      else
      {
         wb_table9_114_2L2e( false) ;
      }
   }

   public void wb_table8_66_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableverregistrosliquidados_Internalname, tblTableverregistrosliquidados_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table10_69_2L2( true) ;
      }
      else
      {
         wb_table10_69_2L2( false) ;
      }
      return  ;
   }

   public void wb_table10_69_2L2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Ver registros ya liquidados", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_66_2L2e( true) ;
      }
      else
      {
         wb_table8_66_2L2e( false) ;
      }
   }

   public void wb_table10_69_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablecheck_Internalname, tblTablecheck_Internalname, "", "MB16n", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavVerliquidadas.getInternalname(), httpContext.getMessage( "Ver Liquidadas", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'" + sGXsfl_125_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavVerliquidadas.getInternalname(), GXutil.booltostr( AV108VerLiquidadas), "", httpContext.getMessage( "Ver Liquidadas", ""), 1, chkavVerliquidadas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(73, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,73);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_69_2L2e( true) ;
      }
      else
      {
         wb_table10_69_2L2e( false) ;
      }
   }

   public void wb_table6_54_2L2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_54_2L2e( true) ;
      }
      else
      {
         wb_table6_54_2L2e( false) ;
      }
   }

   public void wb_table5_35_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_35_2L2e( true) ;
      }
      else
      {
         wb_table5_35_2L2e( false) ;
      }
   }

   public void wb_table4_30_2L2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_30_2L2e( true) ;
      }
      else
      {
         wb_table4_30_2L2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV120MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV120MenuOpcCod", AV120MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV120MenuOpcCod, ""))));
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
      pa2L2( ) ;
      ws2L2( ) ;
      we2L2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
         {
            WebComp_Wwpaux_wc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171355141", true, true);
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
      httpContext.AddJavascriptSource("novedadesww.js", "?2025171355141", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1252( )
   {
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_125_idx ;
      edtLegId_Internalname = "LEGID_"+sGXsfl_125_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_125_idx ;
      edtAgeOrden_Internalname = "AGEORDEN_"+sGXsfl_125_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_125_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_125_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_125_idx ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_125_idx );
      edtAgeCanti_Internalname = "AGECANTI_"+sGXsfl_125_idx ;
      edtAgeImporte_Internalname = "AGEIMPORTE_"+sGXsfl_125_idx ;
      edtAgePrevis_Internalname = "AGEPREVIS_"+sGXsfl_125_idx ;
      edtAgePerDescrip_Internalname = "AGEPERDESCRIP_"+sGXsfl_125_idx ;
      edtAgeFecDes_Internalname = "AGEFECDES_"+sGXsfl_125_idx ;
      edtAgeFecHas_Internalname = "AGEFECHAS_"+sGXsfl_125_idx ;
      edtAgeLiqNro_Internalname = "AGELIQNRO_"+sGXsfl_125_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_125_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_125_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_125_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_125_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_125_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_125_idx ;
   }

   public void subsflControlProps_fel_1252( )
   {
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_125_fel_idx ;
      edtLegId_Internalname = "LEGID_"+sGXsfl_125_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_125_fel_idx ;
      edtAgeOrden_Internalname = "AGEORDEN_"+sGXsfl_125_fel_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_125_fel_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_125_fel_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_125_fel_idx ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_125_fel_idx );
      edtAgeCanti_Internalname = "AGECANTI_"+sGXsfl_125_fel_idx ;
      edtAgeImporte_Internalname = "AGEIMPORTE_"+sGXsfl_125_fel_idx ;
      edtAgePrevis_Internalname = "AGEPREVIS_"+sGXsfl_125_fel_idx ;
      edtAgePerDescrip_Internalname = "AGEPERDESCRIP_"+sGXsfl_125_fel_idx ;
      edtAgeFecDes_Internalname = "AGEFECDES_"+sGXsfl_125_fel_idx ;
      edtAgeFecHas_Internalname = "AGEFECHAS_"+sGXsfl_125_fel_idx ;
      edtAgeLiqNro_Internalname = "AGELIQNRO_"+sGXsfl_125_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_125_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_125_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_125_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_125_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_125_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_125_fel_idx ;
   }

   public void sendrow_1252( )
   {
      subsflControlProps_1252( ) ;
      wb2L0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_125_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_125_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_125_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegCUIL_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegId_Internalname,GXutil.rtrim( A93LegId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeOrden_Internalname,GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A25AgeOrden), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeOrden_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegNomApe_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNomApe_Internalname,A591LegNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegNomApe_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConDescrip_Internalname,A41ConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "TIPOCONCOD_" + sGXsfl_125_idx ;
         cmbTipoConCod.setName( GXCCtl );
         cmbTipoConCod.setWebtags( "" );
         cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
         cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
         cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
         cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
         if ( cmbTipoConCod.getItemCount() > 0 )
         {
            A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbTipoConCod,cmbTipoConCod.getInternalname(),GXutil.rtrim( A37TipoConCod),Integer.valueOf(1),cmbTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), !bGXsfl_125_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAgeCanti_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeCanti_Internalname,GXutil.ltrim( localUtil.ntoc( A110AgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A110AgeCanti, "ZZZZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeCanti_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtAgeCanti_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A113AgeImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A113AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAgePrevis_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgePrevis_Internalname,A1132AgePrevis,A1132AgePrevis,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgePrevis_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtAgePrevis_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAgePerDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgePerDescrip_Internalname,A2159AgePerDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgePerDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtAgePerDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAgeFecDes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeFecDes_Internalname,localUtil.format(A111AgeFecDes, "99/99/9999"),localUtil.format( A111AgeFecDes, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeFecDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAgeFecDes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAgeFecHas_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeFecHas_Internalname,localUtil.format(A112AgeFecHas, "99/99/9999"),localUtil.format( A112AgeFecHas, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeFecHas_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAgeFecHas_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAgeLiqNro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAgeLiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1254AgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1254AgeLiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAgeLiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtAgeLiqNro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtavUpdate_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV94Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),edtavUpdate_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtavDelete_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV95Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),edtavDelete_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV119Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV116VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV117ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV118EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(125),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2L2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_125_idx = ((subGrid_Islastpage==1)&&(nGXsfl_125_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_125_idx+1) ;
         sGXsfl_125_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_125_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1252( ) ;
      }
      /* End function sendrow_1252 */
   }

   public void startgridcontrol125( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"125\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo Id.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegNomApe_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgeCanti_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgePrevis_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgePerDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgeFecDes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgeFecHas_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Hasta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAgeLiqNro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro. Liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUpdate_Class+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDelete_Class+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A93LegId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A591LegNomApe);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegNomApe_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A41ConDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A37TipoConCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbTipoConCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A110AgeCanti, (byte)(9), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgeCanti_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A113AgeImporte, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1132AgePrevis);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgePrevis_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2159AgePerDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgePerDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A111AgeFecDes, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgeFecDes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A112AgeFecHas, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgeFecHas_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1254AgeLiqNro, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAgeLiqNro_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV94Update));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUpdate_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV95Delete));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDelete_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV119Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV116VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV117ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV118EliminarSVG));
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
      chkavVerliquidadas.setInternalname( "vVERLIQUIDADAS" );
      tblTablecheck_Internalname = "TABLECHECK" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      tblTableverregistrosliquidados_Internalname = "TABLEVERREGISTROSLIQUIDADOS" ;
      lblButtonexport1_textblock_svg_Internalname = "BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = "BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = "BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = "BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = "BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = "BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      bttBtntest_Internalname = "BTNTEST" ;
      bttBtnimportexcel_Internalname = "BTNIMPORTEXCEL" ;
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
      edtLegCUIL_Internalname = "LEGCUIL" ;
      edtLegId_Internalname = "LEGID" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtAgeOrden_Internalname = "AGEORDEN" ;
      edtLegNomApe_Internalname = "LEGNOMAPE" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtConDescrip_Internalname = "CONDESCRIP" ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD" );
      edtAgeCanti_Internalname = "AGECANTI" ;
      edtAgeImporte_Internalname = "AGEIMPORTE" ;
      edtAgePrevis_Internalname = "AGEPREVIS" ;
      edtAgePerDescrip_Internalname = "AGEPERDESCRIP" ;
      edtAgeFecDes_Internalname = "AGEFECDES" ;
      edtAgeFecHas_Internalname = "AGEFECHAS" ;
      edtAgeLiqNro_Internalname = "AGELIQNRO" ;
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
      Importexcel_modal_Internalname = "IMPORTEXCEL_MODAL" ;
      tblTableimportexcel_modal_Internalname = "TABLEIMPORTEXCEL_MODAL" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divDiv_wwpauxwc_Internalname = "DIV_WWPAUXWC" ;
      edtavDdo_agefecdesauxdate_Internalname = "vDDO_AGEFECDESAUXDATE" ;
      divDdo_agefecdesauxdates_Internalname = "DDO_AGEFECDESAUXDATES" ;
      edtavDdo_agefechasauxdate_Internalname = "vDDO_AGEFECHASAUXDATE" ;
      divDdo_agefechasauxdates_Internalname = "DDO_AGEFECHASAUXDATES" ;
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
      edtavDelete_Class = "Attribute" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Class = "Attribute" ;
      edtavUpdate_Enabled = 0 ;
      edtAgeLiqNro_Jsonclick = "" ;
      edtAgeFecHas_Jsonclick = "" ;
      edtAgeFecDes_Jsonclick = "" ;
      edtAgePerDescrip_Jsonclick = "" ;
      edtAgePrevis_Jsonclick = "" ;
      edtAgeImporte_Jsonclick = "" ;
      edtAgeCanti_Jsonclick = "" ;
      cmbTipoConCod.setJsonclick( "" );
      edtConDescrip_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
      edtLegNomApe_Jsonclick = "" ;
      edtAgeOrden_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtLegId_Jsonclick = "" ;
      edtLegCUIL_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      chkavVerliquidadas.setEnabled( 1 );
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      bttBtnimportexcel_Visible = 1 ;
      bttBtntest_Visible = 1 ;
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
      edtAgeLiqNro_Visible = -1 ;
      edtAgeFecHas_Visible = -1 ;
      edtAgeFecDes_Visible = -1 ;
      edtAgePerDescrip_Visible = -1 ;
      edtAgePrevis_Visible = -1 ;
      edtAgeCanti_Visible = -1 ;
      cmbTipoConCod.setVisible( -1 );
      edtConDescrip_Visible = -1 ;
      edtConCodigo_Visible = -1 ;
      edtLegNomApe_Visible = -1 ;
      edtLegId_Visible = -1 ;
      edtLegCUIL_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_agefechasauxdate_Jsonclick = "" ;
      edtavDdo_agefecdesauxdate_Jsonclick = "" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Importexcel_modal_Bodytype = "WebComponent" ;
      Importexcel_modal_Confirmtype = "" ;
      Importexcel_modal_Title = httpContext.getMessage( "Importar archivo", "") ;
      Importexcel_modal_Width = "400" ;
      Ddo_grid_Format = "||||||9.2|||||8.0" ;
      Ddo_grid_Datalistproc = "NovedadesWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención,CAL_ARG:Cálculo||||||" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|T|T|||T|T|T|" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|||Dynamic|Dynamic|Dynamic|" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|||T|T|T|" ;
      Ddo_grid_Filterisrange = "||||||T|||||T" ;
      Ddo_grid_Filtertype = "|Character|Character|Character|Character||Numeric||Character|Date|Date|Numeric" ;
      Ddo_grid_Includefilter = "|T|T|T|T||T||T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T||T|T|T|T||T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|3||4|5|6|7||8|9|10|11" ;
      Ddo_grid_Columnids = "0:LegCUIL|1:LegId|4:LegNomApe|5:ConCodigo|6:ConDescrip|7:TipoConCod|8:AgeCanti|10:AgePrevis|11:AgePerDescrip|12:AgeFecDes|13:AgeFecHas|14:AgeLiqNro" ;
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
      Form.setCaption( httpContext.getMessage( " Agenda de Novedades", "") );
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
      AV122WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV122WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV122WelcomeMessage_NoMostrarMas", AV122WelcomeMessage_NoMostrarMas);
      chkavVerliquidadas.setName( "vVERLIQUIDADAS" );
      chkavVerliquidadas.setWebtags( "" );
      chkavVerliquidadas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavVerliquidadas.getInternalname(), "TitleCaption", chkavVerliquidadas.getCaption(), true);
      chkavVerliquidadas.setCheckedValue( "false" );
      AV108VerLiquidadas = GXutil.strtobool( GXutil.booltostr( AV108VerLiquidadas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108VerLiquidadas", AV108VerLiquidadas);
      GXCCtl = "TIPOCONCOD_" + sGXsfl_125_idx ;
      cmbTipoConCod.setName( GXCCtl );
      cmbTipoConCod.setWebtags( "" );
      cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'A1254AgeLiqNro',fld:'AGELIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtAgeCanti_Visible',ctrl:'AGECANTI',prop:'Visible'},{av:'edtAgePrevis_Visible',ctrl:'AGEPREVIS',prop:'Visible'},{av:'edtAgePerDescrip_Visible',ctrl:'AGEPERDESCRIP',prop:'Visible'},{av:'edtAgeFecDes_Visible',ctrl:'AGEFECDES',prop:'Visible'},{av:'edtAgeFecHas_Visible',ctrl:'AGEFECHAS',prop:'Visible'},{av:'edtAgeLiqNro_Visible',ctrl:'AGELIQNRO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV65GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV66GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV67GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNTEST',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV113ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e132L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e142L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e152L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV111TFAgeFecHas_SelsJson',fld:'vTFAGEFECHAS_SELSJSON',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV109TFAgeFecDes_SelsJson',fld:'vTFAGEFECDES_SELSJSON',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV129TFAgePerDescrip_SelsJson',fld:'vTFAGEPERDESCRIP_SELSJSON',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV92TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV78TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV76TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV97TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV80TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e222L2',iparms:[{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A1254AgeLiqNro',fld:'AGELIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A25AgeOrden',fld:'AGEORDEN',pic:'ZZZ9'},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV94Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavUpdate_Class',ctrl:'vUPDATE',prop:'Class'},{av:'AV95Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtavDelete_Class',ctrl:'vDELETE',prop:'Class'},{av:'AV119Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV116VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV117ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV118EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e112L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'A1254AgeLiqNro',fld:'AGELIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtAgeCanti_Visible',ctrl:'AGECANTI',prop:'Visible'},{av:'edtAgePrevis_Visible',ctrl:'AGEPREVIS',prop:'Visible'},{av:'edtAgePerDescrip_Visible',ctrl:'AGEPERDESCRIP',prop:'Visible'},{av:'edtAgeFecDes_Visible',ctrl:'AGEFECDES',prop:'Visible'},{av:'edtAgeFecHas_Visible',ctrl:'AGEFECHAS',prop:'Visible'},{av:'edtAgeLiqNro_Visible',ctrl:'AGELIQNRO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV65GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV66GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV67GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNTEST',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV113ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e122L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV80TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV97TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV76TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV78TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV92TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV129TFAgePerDescrip_SelsJson',fld:'vTFAGEPERDESCRIP_SELSJSON',pic:''},{av:'AV109TFAgeFecDes_SelsJson',fld:'vTFAGEFECDES_SELSJSON',pic:''},{av:'AV111TFAgeFecHas_SelsJson',fld:'vTFAGEFECHAS_SELSJSON',pic:''},{av:'A1254AgeLiqNro',fld:'AGELIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV111TFAgeFecHas_SelsJson',fld:'vTFAGEFECHAS_SELSJSON',pic:''},{av:'AV109TFAgeFecDes_SelsJson',fld:'vTFAGEFECDES_SELSJSON',pic:''},{av:'AV129TFAgePerDescrip_SelsJson',fld:'vTFAGEPERDESCRIP_SELSJSON',pic:''},{av:'AV92TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV78TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV76TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV97TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV80TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtAgeCanti_Visible',ctrl:'AGECANTI',prop:'Visible'},{av:'edtAgePrevis_Visible',ctrl:'AGEPREVIS',prop:'Visible'},{av:'edtAgePerDescrip_Visible',ctrl:'AGEPERDESCRIP',prop:'Visible'},{av:'edtAgeFecDes_Visible',ctrl:'AGEFECDES',prop:'Visible'},{av:'edtAgeFecHas_Visible',ctrl:'AGEFECHAS',prop:'Visible'},{av:'edtAgeLiqNro_Visible',ctrl:'AGELIQNRO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV65GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV66GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV67GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNTEST',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV113ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOTEST'","{handler:'e172L2',iparms:[]");
      setEventMetadata("'DOTEST'",",oparms:[]}");
      setEventMetadata("'DOIMPORTEXCEL'","{handler:'e242L1',iparms:[]");
      setEventMetadata("'DOIMPORTEXCEL'",",oparms:[]}");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE","{handler:'e162L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV108VerLiquidadas',fld:'vVERLIQUIDADAS',pic:''},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV144Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV61TFLegId',fld:'vTFLEGID',pic:''},{av:'AV81TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV98TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV99TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV40TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV77TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV42TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV79TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV93TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV44TFAgeCanti',fld:'vTFAGECANTI',pic:'ZZZZZ9.99'},{av:'AV45TFAgeCanti_To',fld:'vTFAGECANTI_TO',pic:'ZZZZZ9.99'},{av:'AV130TFAgePerDescrip',fld:'vTFAGEPERDESCRIP',pic:''},{av:'AV131TFAgePerDescrip_Sels',fld:'vTFAGEPERDESCRIP_SELS',pic:''},{av:'AV50TFAgeFecDes',fld:'vTFAGEFECDES',pic:''},{av:'AV110TFAgeFecDes_Sels',fld:'vTFAGEFECDES_SELS',pic:''},{av:'AV55TFAgeFecHas',fld:'vTFAGEFECHAS',pic:''},{av:'AV112TFAgeFecHas_Sels',fld:'vTFAGEFECHAS_SELS',pic:''},{av:'AV106TFAgeLiqNro',fld:'vTFAGELIQNRO',pic:'ZZZZZZZ9'},{av:'AV107TFAgeLiqNro_To',fld:'vTFAGELIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'A1254AgeLiqNro',fld:'AGELIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE",",oparms:[{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV115ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtAgeCanti_Visible',ctrl:'AGECANTI',prop:'Visible'},{av:'edtAgePrevis_Visible',ctrl:'AGEPREVIS',prop:'Visible'},{av:'edtAgePerDescrip_Visible',ctrl:'AGEPERDESCRIP',prop:'Visible'},{av:'edtAgeFecDes_Visible',ctrl:'AGEFECDES',prop:'Visible'},{av:'edtAgeFecHas_Visible',ctrl:'AGEFECHAS',prop:'Visible'},{av:'edtAgeLiqNro_Visible',ctrl:'AGELIQNRO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV65GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV66GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV67GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV84IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV85IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNTEST',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV113ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e252L1',iparms:[{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV69EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e182L2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e192L2',iparms:[{av:'AV122WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV120MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV82CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e232L1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[]}");
      setEventMetadata("VALID_AGECANTI","{handler:'valid_Agecanti',iparms:[]");
      setEventMetadata("VALID_AGECANTI",",oparms:[]}");
      setEventMetadata("VALID_AGEIMPORTE","{handler:'valid_Ageimporte',iparms:[]");
      setEventMetadata("VALID_AGEIMPORTE",",oparms:[]}");
      setEventMetadata("VALID_AGEFECDES","{handler:'valid_Agefecdes',iparms:[]");
      setEventMetadata("VALID_AGEFECDES",",oparms:[]}");
      setEventMetadata("VALID_AGEFECHAS","{handler:'valid_Agefechas',iparms:[]");
      setEventMetadata("VALID_AGEFECHAS",",oparms:[]}");
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
      wcpOAV120MenuOpcCod = "" ;
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
      AV120MenuOpcCod = "" ;
      AV20ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV144Pgmname = "" ;
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV61TFLegId = "" ;
      AV81TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98TFLegNomApe = "" ;
      AV99TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFConCodigo = "" ;
      AV77TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFConDescrip = "" ;
      AV79TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFAgeCanti = DecimalUtil.ZERO ;
      AV45TFAgeCanti_To = DecimalUtil.ZERO ;
      AV130TFAgePerDescrip = "" ;
      AV131TFAgePerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFAgeFecDes = GXutil.nullDate() ;
      AV110TFAgeFecDes_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV55TFAgeFecHas = GXutil.nullDate() ;
      AV112TFAgeFecHas_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV63DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV113ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV67GridAppliedFilters = "" ;
      AV80TFLegId_SelsJson = "" ;
      AV97TFLegNomApe_SelsJson = "" ;
      AV76TFConCodigo_SelsJson = "" ;
      AV78TFConDescrip_SelsJson = "" ;
      AV92TFTipoConCod_SelsJson = "" ;
      AV129TFAgePerDescrip_SelsJson = "" ;
      AV109TFAgeFecDes_SelsJson = "" ;
      AV111TFAgeFecHas_SelsJson = "" ;
      AV96ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
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
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      TempTags = "" ;
      AV52DDO_AgeFecDesAuxDate = GXutil.nullDate() ;
      AV57DDO_AgeFecHasAuxDate = GXutil.nullDate() ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A110AgeCanti = DecimalUtil.ZERO ;
      A113AgeImporte = DecimalUtil.ZERO ;
      A1132AgePrevis = "" ;
      A2159AgePerDescrip = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      AV94Update = "" ;
      AV95Delete = "" ;
      AV119Display = "" ;
      AV116VerSVG = "" ;
      AV117ModificarSVG = "" ;
      AV118EliminarSVG = "" ;
      scmdbuf = "" ;
      lV61TFLegId = "" ;
      lV98TFLegNomApe = "" ;
      lV40TFConCodigo = "" ;
      lV42TFConDescrip = "" ;
      lV130TFAgePerDescrip = "" ;
      H002L2_A1254AgeLiqNro = new int[1] ;
      H002L2_n1254AgeLiqNro = new boolean[] {false} ;
      H002L2_A2159AgePerDescrip = new String[] {""} ;
      H002L2_A37TipoConCod = new String[] {""} ;
      H002L2_A41ConDescrip = new String[] {""} ;
      H002L2_A591LegNomApe = new String[] {""} ;
      H002L2_A25AgeOrden = new short[1] ;
      H002L2_A93LegId = new String[] {""} ;
      H002L2_n93LegId = new boolean[] {false} ;
      H002L2_A239LegCUIL = new long[1] ;
      H002L2_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      H002L2_n112AgeFecHas = new boolean[] {false} ;
      H002L2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      H002L2_n111AgeFecDes = new boolean[] {false} ;
      H002L2_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002L2_n113AgeImporte = new boolean[] {false} ;
      H002L2_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002L2_n110AgeCanti = new boolean[] {false} ;
      H002L2_A26ConCodigo = new String[] {""} ;
      H002L2_A6LegNumero = new int[1] ;
      H002L2_A1EmpCod = new short[1] ;
      H002L2_A3CliCod = new int[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      H002L3_AGRID_nRecordCount = new long[1] ;
      AV128WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV123MenuBienveImgURL = "" ;
      AV125MenuBienveTitulo = "" ;
      AV126MenuBienveTexto = "" ;
      AV143Welcomemessage_foto_GXI = "" ;
      AV137observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int7 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext15 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV18ColumnsSelectorXML = "" ;
      AV136MenuOpcTitulo = "" ;
      GXv_int14 = new short[1] ;
      AV140filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV114ManageFiltersXml = "" ;
      AV16ExcelFilename = "" ;
      AV17ErrorMessage = "" ;
      AV19UserCustomValue = "" ;
      AV21ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector16 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector17 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item20 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      GXt_char26 = "" ;
      GXt_char24 = "" ;
      GXv_char25 = new String[1] ;
      GXt_char22 = "" ;
      GXv_char23 = new String[1] ;
      GXt_char21 = "" ;
      GXv_char10 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState28 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV124textoNoMostrara = "" ;
      GXv_char27 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      ucImportexcel_modal = new com.genexus.webpanels.GXUserControl();
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      bttBtntest_Jsonclick = "" ;
      bttBtnimportexcel_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTextblock1_Jsonclick = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadesww__default(),
         new Object[] {
             new Object[] {
            H002L2_A1254AgeLiqNro, H002L2_n1254AgeLiqNro, H002L2_A2159AgePerDescrip, H002L2_A37TipoConCod, H002L2_A41ConDescrip, H002L2_A591LegNomApe, H002L2_A25AgeOrden, H002L2_A93LegId, H002L2_n93LegId, H002L2_A239LegCUIL,
            H002L2_A112AgeFecHas, H002L2_n112AgeFecHas, H002L2_A111AgeFecDes, H002L2_n111AgeFecDes, H002L2_A113AgeImporte, H002L2_n113AgeImporte, H002L2_A110AgeCanti, H002L2_n110AgeCanti, H002L2_A26ConCodigo, H002L2_A6LegNumero,
            H002L2_A1EmpCod, H002L2_A3CliCod
            }
            , new Object[] {
            H002L3_AGRID_nRecordCount
            }
         }
      );
      AV144Pgmname = "NovedadesWW" ;
      /* GeneXus formulas. */
      AV144Pgmname = "NovedadesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      WebComp_Wwpaux_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV115ManageFiltersExecutionStep ;
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
   private short AV13OrderedBy ;
   private short AV69EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A25AgeOrden ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int13 ;
   private short GXv_int14[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_125 ;
   private int nGXsfl_125_idx=1 ;
   private int AV106TFAgeLiqNro ;
   private int AV107TFAgeLiqNro_To ;
   private int AV82CliCod ;
   private int A3CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A6LegNumero ;
   private int A1254AgeLiqNro ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV81TFLegId_Sels_size ;
   private int AV99TFLegNomApe_Sels_size ;
   private int AV77TFConCodigo_Sels_size ;
   private int AV79TFConDescrip_Sels_size ;
   private int AV93TFTipoConCod_Sels_size ;
   private int AV131TFAgePerDescrip_Sels_size ;
   private int AV110TFAgeFecDes_Sels_size ;
   private int AV112TFAgeFecHas_Sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private int edtLegCUIL_Visible ;
   private int edtLegId_Visible ;
   private int edtLegNomApe_Visible ;
   private int edtConCodigo_Visible ;
   private int edtConDescrip_Visible ;
   private int edtAgeCanti_Visible ;
   private int edtAgePrevis_Visible ;
   private int edtAgePerDescrip_Visible ;
   private int edtAgeFecDes_Visible ;
   private int edtAgeFecHas_Visible ;
   private int edtAgeLiqNro_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV139filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV64PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtntest_Visible ;
   private int bttBtnimportexcel_Visible ;
   private int bttBtninsert_Visible ;
   private int AV145GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV65GridCurrentPage ;
   private long AV66GridPageCount ;
   private long A239LegCUIL ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV44TFAgeCanti ;
   private java.math.BigDecimal AV45TFAgeCanti_To ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
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
   private String sGXsfl_125_idx="0001" ;
   private String AV144Pgmname ;
   private String AV61TFLegId ;
   private String AV40TFConCodigo ;
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
   private String Importexcel_modal_Width ;
   private String Importexcel_modal_Title ;
   private String Importexcel_modal_Confirmtype ;
   private String Importexcel_modal_Bodytype ;
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
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String divDdo_agefecdesauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_agefecdesauxdate_Internalname ;
   private String edtavDdo_agefecdesauxdate_Jsonclick ;
   private String divDdo_agefechasauxdates_Internalname ;
   private String edtavDdo_agefechasauxdate_Internalname ;
   private String edtavDdo_agefechasauxdate_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtLegCUIL_Internalname ;
   private String A93LegId ;
   private String edtLegId_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtAgeOrden_Internalname ;
   private String edtLegNomApe_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String edtConDescrip_Internalname ;
   private String A37TipoConCod ;
   private String edtAgeCanti_Internalname ;
   private String edtAgeImporte_Internalname ;
   private String edtAgePrevis_Internalname ;
   private String edtAgePerDescrip_Internalname ;
   private String edtAgeFecDes_Internalname ;
   private String edtAgeFecHas_Internalname ;
   private String edtAgeLiqNro_Internalname ;
   private String AV94Update ;
   private String edtavUpdate_Internalname ;
   private String AV95Delete ;
   private String edtavDelete_Internalname ;
   private String AV119Display ;
   private String edtavDisplay_Internalname ;
   private String AV116VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV117ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV118EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV61TFLegId ;
   private String lV40TFConCodigo ;
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
   private String AV137observerPalabra ;
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
   private String edtavUpdate_Class ;
   private String edtavDelete_Link ;
   private String edtavDelete_Class ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtntest_Internalname ;
   private String bttBtnimportexcel_Internalname ;
   private String bttBtninsert_Internalname ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXt_char26 ;
   private String GXt_char24 ;
   private String GXv_char25[] ;
   private String GXt_char22 ;
   private String GXv_char23[] ;
   private String GXt_char21 ;
   private String GXv_char10[] ;
   private String GXt_char12 ;
   private String GXv_char5[] ;
   private String GXv_char27[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTableimportexcel_modal_Internalname ;
   private String Importexcel_modal_Internalname ;
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
   private String bttBtntest_Jsonclick ;
   private String bttBtnimportexcel_Jsonclick ;
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
   private String tblTableverregistrosliquidados_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String tblTablecheck_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_125_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtLegCUIL_Jsonclick ;
   private String edtLegId_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtAgeOrden_Jsonclick ;
   private String edtLegNomApe_Jsonclick ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Jsonclick ;
   private String GXCCtl ;
   private String edtAgeCanti_Jsonclick ;
   private String edtAgeImporte_Jsonclick ;
   private String edtAgePrevis_Jsonclick ;
   private String edtAgePerDescrip_Jsonclick ;
   private String edtAgeFecDes_Jsonclick ;
   private String edtAgeFecHas_Jsonclick ;
   private String edtAgeLiqNro_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV50TFAgeFecDes ;
   private java.util.Date AV55TFAgeFecHas ;
   private java.util.Date AV52DDO_AgeFecDesAuxDate ;
   private java.util.Date AV57DDO_AgeFecHasAuxDate ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV108VerLiquidadas ;
   private boolean AV14OrderedDsc ;
   private boolean AV84IsAuthorized_Update ;
   private boolean AV85IsAuthorized_Delete ;
   private boolean AV122WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean bGXsfl_125_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n93LegId ;
   private boolean n110AgeCanti ;
   private boolean n113AgeImporte ;
   private boolean n111AgeFecDes ;
   private boolean n112AgeFecHas ;
   private boolean n1254AgeLiqNro ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV127MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV88TempBoolean ;
   private boolean GXt_boolean18 ;
   private boolean GXv_boolean11[] ;
   private boolean AV128WelcomeMessage_Foto_IsBlob ;
   private String AV80TFLegId_SelsJson ;
   private String AV97TFLegNomApe_SelsJson ;
   private String AV76TFConCodigo_SelsJson ;
   private String AV78TFConDescrip_SelsJson ;
   private String AV92TFTipoConCod_SelsJson ;
   private String AV129TFAgePerDescrip_SelsJson ;
   private String AV109TFAgeFecDes_SelsJson ;
   private String AV111TFAgeFecHas_SelsJson ;
   private String A1132AgePrevis ;
   private String AV126MenuBienveTexto ;
   private String AV18ColumnsSelectorXML ;
   private String AV114ManageFiltersXml ;
   private String AV19UserCustomValue ;
   private String AV124textoNoMostrara ;
   private String wcpOAV120MenuOpcCod ;
   private String AV120MenuOpcCod ;
   private String AV98TFLegNomApe ;
   private String AV42TFConDescrip ;
   private String AV130TFAgePerDescrip ;
   private String AV67GridAppliedFilters ;
   private String A591LegNomApe ;
   private String A41ConDescrip ;
   private String A2159AgePerDescrip ;
   private String lV98TFLegNomApe ;
   private String lV42TFConDescrip ;
   private String lV130TFAgePerDescrip ;
   private String AV123MenuBienveImgURL ;
   private String AV125MenuBienveTitulo ;
   private String AV143Welcomemessage_foto_GXI ;
   private String AV136MenuOpcTitulo ;
   private String AV140filtrosTexto ;
   private String AV16ExcelFilename ;
   private String AV17ErrorMessage ;
   private String AV128WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucImportexcel_modal ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkavVerliquidadas ;
   private HTMLChoice cmbTipoConCod ;
   private IDataStoreProvider pr_default ;
   private int[] H002L2_A1254AgeLiqNro ;
   private boolean[] H002L2_n1254AgeLiqNro ;
   private String[] H002L2_A2159AgePerDescrip ;
   private String[] H002L2_A37TipoConCod ;
   private String[] H002L2_A41ConDescrip ;
   private String[] H002L2_A591LegNomApe ;
   private short[] H002L2_A25AgeOrden ;
   private String[] H002L2_A93LegId ;
   private boolean[] H002L2_n93LegId ;
   private long[] H002L2_A239LegCUIL ;
   private java.util.Date[] H002L2_A112AgeFecHas ;
   private boolean[] H002L2_n112AgeFecHas ;
   private java.util.Date[] H002L2_A111AgeFecDes ;
   private boolean[] H002L2_n111AgeFecDes ;
   private java.math.BigDecimal[] H002L2_A113AgeImporte ;
   private boolean[] H002L2_n113AgeImporte ;
   private java.math.BigDecimal[] H002L2_A110AgeCanti ;
   private boolean[] H002L2_n110AgeCanti ;
   private String[] H002L2_A26ConCodigo ;
   private int[] H002L2_A6LegNumero ;
   private short[] H002L2_A1EmpCod ;
   private int[] H002L2_A3CliCod ;
   private long[] H002L3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV81TFLegId_Sels ;
   private GXSimpleCollection<String> AV77TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV93TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV99TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV79TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV131TFAgePerDescrip_Sels ;
   private GXSimpleCollection<String> AV96ExtraParms ;
   private GXSimpleCollection<java.util.Date> AV110TFAgeFecDes_Sels ;
   private GXSimpleCollection<java.util.Date> AV112TFAgeFecHas_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV113ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item19 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item20[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext15[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState28[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector16[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector17[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV63DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons8 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9[] ;
}

final  class novedadesww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV81TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV99TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV77TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV79TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV93TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV131TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV110TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV112TFAgeFecHas_Sels ,
                                          boolean AV108VerLiquidadas ,
                                          int AV81TFLegId_Sels_size ,
                                          String AV61TFLegId ,
                                          int AV99TFLegNomApe_Sels_size ,
                                          String AV98TFLegNomApe ,
                                          int AV77TFConCodigo_Sels_size ,
                                          String AV40TFConCodigo ,
                                          int AV79TFConDescrip_Sels_size ,
                                          String AV42TFConDescrip ,
                                          int AV93TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV44TFAgeCanti ,
                                          java.math.BigDecimal AV45TFAgeCanti_To ,
                                          int AV131TFAgePerDescrip_Sels_size ,
                                          String AV130TFAgePerDescrip ,
                                          int AV110TFAgeFecDes_Sels_size ,
                                          int AV112TFAgeFecHas_Sels_size ,
                                          int AV106TFAgeLiqNro ,
                                          int AV107TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV82CliCod ,
                                          short AV69EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[14];
      Object[] GXv_Object30 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.AgeLiqNro, T1.AgePerDescrip, T3.TipoConCod, T3.ConDescrip, T2.LegNomApe, T1.AgeOrden, T2.LegId, T2.LegCUIL, T1.AgeFecHas, T1.AgeFecDes, T1.AgeImporte, T1.AgeCanti," ;
      sSelectString += " T1.ConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod" ;
      sFromString = " FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod" ;
      sFromString += " = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! AV108VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV81TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int29[2] = (byte)(1) ;
      }
      if ( AV81TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV99TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int29[3] = (byte)(1) ;
      }
      if ( AV99TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV77TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int29[4] = (byte)(1) ;
      }
      if ( AV77TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV79TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV42TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( AV79TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV93TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
      }
      if ( ( AV131TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV130TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int29[8] = (byte)(1) ;
      }
      if ( AV131TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV131TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV110TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV112TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV106TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int29[9] = (byte)(1) ;
      }
      if ( ! (0==AV107TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int29[10] = (byte)(1) ;
      }
      if ( AV13OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.AgeFecDes DESC, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.LegCUIL, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.LegCUIL DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.LegId, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.LegId DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConCodigo, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConCodigo DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.ConDescrip, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.ConDescrip DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.TipoConCod, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.TipoConCod DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.AgeCanti, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.AgeCanti DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.AgePerDescrip, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.AgePerDescrip DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.AgeFecDes, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.AgeFecDes DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.AgeFecHas, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.AgeFecHas DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.AgeLiqNro, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.AgeLiqNro DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeOrden" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
   }

   protected Object[] conditional_H002L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV81TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV99TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV77TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV79TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV93TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV131TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV110TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV112TFAgeFecHas_Sels ,
                                          boolean AV108VerLiquidadas ,
                                          int AV81TFLegId_Sels_size ,
                                          String AV61TFLegId ,
                                          int AV99TFLegNomApe_Sels_size ,
                                          String AV98TFLegNomApe ,
                                          int AV77TFConCodigo_Sels_size ,
                                          String AV40TFConCodigo ,
                                          int AV79TFConDescrip_Sels_size ,
                                          String AV42TFConDescrip ,
                                          int AV93TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV44TFAgeCanti ,
                                          java.math.BigDecimal AV45TFAgeCanti_To ,
                                          int AV131TFAgePerDescrip_Sels_size ,
                                          String AV130TFAgePerDescrip ,
                                          int AV110TFAgeFecDes_Sels_size ,
                                          int AV112TFAgeFecHas_Sels_size ,
                                          int AV106TFAgeLiqNro ,
                                          int AV107TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV82CliCod ,
                                          short AV69EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int32 = new byte[11];
      Object[] GXv_Object33 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto" ;
      scmdbuf += " T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! AV108VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV81TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int32[2] = (byte)(1) ;
      }
      if ( AV81TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV99TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int32[3] = (byte)(1) ;
      }
      if ( AV99TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV77TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int32[4] = (byte)(1) ;
      }
      if ( AV77TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV79TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV42TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int32[5] = (byte)(1) ;
      }
      if ( AV79TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV93TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int32[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int32[7] = (byte)(1) ;
      }
      if ( ( AV131TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV130TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int32[8] = (byte)(1) ;
      }
      if ( AV131TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV131TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV110TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV112TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV106TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int32[9] = (byte)(1) ;
      }
      if ( ! (0==AV107TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int32[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV13OrderedBy == 1 )
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
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object33[0] = scmdbuf ;
      GXv_Object33[1] = GXv_int32 ;
      return GXv_Object33 ;
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
                  return conditional_H002L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() );
            case 1 :
                  return conditional_H002L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(8);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(13, 10);
               ((int[]) buf[19])[0] = rslt.getInt(14);
               ((short[]) buf[20])[0] = rslt.getShort(15);
               ((int[]) buf[21])[0] = rslt.getInt(16);
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
      }
   }

}

