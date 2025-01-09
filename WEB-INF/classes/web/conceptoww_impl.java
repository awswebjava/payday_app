package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptoww_impl extends GXDataArea
{
   public conceptoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoww_impl.class ));
   }

   public conceptoww_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbTipoConCod = new HTMLChoice();
      dynConceptoConveCodigo = new HTMLChoice();
      cmbConVigencia = new HTMLChoice();
      chkConVariable = UIFactory.getCheckbox(this);
      chkConHabilitado = UIFactory.getCheckbox(this);
      chkConRecalcular = UIFactory.getCheckbox(this);
      cmbConCondicion = new HTMLChoice();
      cmbConSacDeven = new HTMLChoice();
      cmbConBasePres = new HTMLChoice();
      cmbConBaseAnt = new HTMLChoice();
      cmbConBaseFer = new HTMLChoice();
      cmbConBaseFerProm = new HTMLChoice();
      cmbConBaseHorExt = new HTMLChoice();
      cmbConBaseHorExtProm = new HTMLChoice();
      cmbConBaseLic = new HTMLChoice();
      cmbConBaseLicProm = new HTMLChoice();
      cmbConBaseOSDif = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTOCONVECODIGO") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlaconceptoconvecodigo2K2( ) ;
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
            AV188MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV188MenuOpcCod", AV188MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV188MenuOpcCod, ""))));
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
      nRC_GXsfl_108 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_108"))) ;
      nGXsfl_108_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_108_idx"))) ;
      sGXsfl_108_idx = httpContext.GetPar( "sGXsfl_108_idx") ;
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
      AV125ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20ColumnsSelector);
      AV214Pgmname = httpContext.GetPar( "Pgmname") ;
      AV188MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11GridState);
      AV23TFConCodigo = httpContext.GetPar( "TFConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFConCodigo_Sels);
      AV25TFConDescrip = httpContext.GetPar( "TFConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV62TFConDescrip_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV81TFTipoConCod_Sels);
      AV127TFConClasifAux = httpContext.GetPar( "TFConClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV128TFConClasifAux_Sels);
      AV104TFConTipoLiqAux = httpContext.GetPar( "TFConTipoLiqAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV105TFConTipoLiqAux_Sels);
      AV146TFConceptoConveCodigo = httpContext.GetPar( "TFConceptoConveCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV147TFConceptoConveCodigo_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35TFConVigencia_Sels);
      AV36TFConVariable_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConVariable_Sel"))) ;
      AV38TFConFormula = httpContext.GetPar( "TFConFormula") ;
      AV27TFConHabilitado_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConHabilitado_Sel"))) ;
      AV40TFConObservacion = httpContext.GetPar( "TFConObservacion") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66TFConObservacion_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV135TFAplIIGG_Sels);
      AV46TFConFchModFor = localUtil.parseDTimeParm( httpContext.GetPar( "TFConFchModFor")) ;
      AV47TFConFchModFor_To = localUtil.parseDTimeParm( httpContext.GetPar( "TFConFchModFor_To")) ;
      AV120TFConRecalcular_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConRecalcular_Sel"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV133TFConCondicion_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV140TFConSacDeven_Sels);
      AV149TFConCodAfip = httpContext.GetPar( "TFConCodAfip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV150TFConCodAfip_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV154TFConBasePres_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV156TFConBaseAnt_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV158TFConBaseFer_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV160TFConBaseFerProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV162TFConBaseHorExt_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV164TFConBaseHorExtProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV166TFConBaseLic_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV168TFConBaseLicProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV170TFConBaseOSDif_Sels);
      AV200TFConRelRef = httpContext.GetPar( "TFConRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV201TFConRelRef_Sels);
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV69CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV191IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV74IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV190WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV138TipoConCod = httpContext.GetPar( "TipoConCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
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
      pa2K2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2K2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV188MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV214Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV188MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV191IsAuthorized_Display));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV138TipoConCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_108", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_108, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV51DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV51DDO_TitleSettingsIcons);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV123ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV123ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV53GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV54GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV55GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CONFCHMODFORAUXDATE", localUtil.dtoc( AV48DDO_ConFchModForAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_CONFCHMODFORAUXDATETO", localUtil.dtoc( AV49DDO_ConFchModForAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV125ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV214Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV214Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV188MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV188MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO", GXutil.rtrim( AV23TFConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODIGO_SELS", AV60TFConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODIGO_SELS", AV60TFConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP", AV25TFConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONDESCRIP_SELS", AV62TFConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONDESCRIP_SELS", AV62TFConDescrip_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTIPOCONCOD_SELS", AV81TFTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTIPOCONCOD_SELS", AV81TFTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX", AV127TFConClasifAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCLASIFAUX_SELS", AV128TFConClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCLASIFAUX_SELS", AV128TFConClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTIPOLIQAUX", AV104TFConTipoLiqAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONTIPOLIQAUX_SELS", AV105TFConTipoLiqAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONTIPOLIQAUX_SELS", AV105TFConTipoLiqAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOCONVECODIGO", AV146TFConceptoConveCodigo);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCEPTOCONVECODIGO_SELS", AV147TFConceptoConveCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCEPTOCONVECODIGO_SELS", AV147TFConceptoConveCodigo_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVIGENCIA_SELS", AV35TFConVigencia_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVIGENCIA_SELS", AV35TFConVigencia_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVARIABLE_SEL", GXutil.ltrim( localUtil.ntoc( AV36TFConVariable_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFORMULA", AV38TFConFormula);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONHABILITADO_SEL", GXutil.ltrim( localUtil.ntoc( AV27TFConHabilitado_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBSERVACION", AV40TFConObservacion);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONOBSERVACION_SELS", AV66TFConObservacion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONOBSERVACION_SELS", AV66TFConObservacion_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGG_SELS", AV135TFAplIIGG_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGG_SELS", AV135TFAplIIGG_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFCHMODFOR", localUtil.ttoc( AV46TFConFchModFor, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFCHMODFOR_TO", localUtil.ttoc( AV47TFConFchModFor_To, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRECALCULAR_SEL", GXutil.ltrim( localUtil.ntoc( AV120TFConRecalcular_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCONDICION_SELS", AV133TFConCondicion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCONDICION_SELS", AV133TFConCondicion_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONSACDEVEN_SELS", AV140TFConSacDeven_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONSACDEVEN_SELS", AV140TFConSacDeven_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODAFIP", GXutil.rtrim( AV149TFConCodAfip));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODAFIP_SELS", AV150TFConCodAfip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODAFIP_SELS", AV150TFConCodAfip_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEPRES_SELS", AV154TFConBasePres_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEPRES_SELS", AV154TFConBasePres_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEANT_SELS", AV156TFConBaseAnt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEANT_SELS", AV156TFConBaseAnt_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEFER_SELS", AV158TFConBaseFer_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEFER_SELS", AV158TFConBaseFer_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEFERPROM_SELS", AV160TFConBaseFerProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEFERPROM_SELS", AV160TFConBaseFerProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEHOREXT_SELS", AV162TFConBaseHorExt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEHOREXT_SELS", AV162TFConBaseHorExt_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEHOREXTPROM_SELS", AV164TFConBaseHorExtProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEHOREXTPROM_SELS", AV164TFConBaseHorExtProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASELIC_SELS", AV166TFConBaseLic_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASELIC_SELS", AV166TFConBaseLic_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASELICPROM_SELS", AV168TFConBaseLicProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASELICPROM_SELS", AV168TFConBaseLicProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEOSDIF_SELS", AV170TFConBaseOSDif_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEOSDIF_SELS", AV170TFConBaseOSDif_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRELREF", AV200TFConRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONRELREF_SELS", AV201TFConRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONRELREF_SELS", AV201TFConRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV69CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV191IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV191IsAuthorized_Display));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "CONPADRE", GXutil.rtrim( A921ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFORMULA", A148ConFormula);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO_SELSJSON", AV59TFConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP_SELSJSON", AV61TFConDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOCONCOD_SELSJSON", AV80TFTipoConCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX_SELSJSON", AV126TFConClasifAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTIPOLIQAUX_SELSJSON", AV103TFConTipoLiqAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOCONVECODIGO_SELSJSON", AV145TFConceptoConveCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVIGENCIA_SELSJSON", AV34TFConVigencia_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBSERVACION_SELSJSON", AV65TFConObservacion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGG_SELSJSON", AV134TFAplIIGG_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCONDICION_SELSJSON", AV132TFConCondicion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSACDEVEN_SELSJSON", AV139TFConSacDeven_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODAFIP_SELSJSON", AV148TFConCodAfip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEPRES_SELSJSON", AV153TFConBasePres_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEANT_SELSJSON", AV155TFConBaseAnt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEFER_SELSJSON", AV157TFConBaseFer_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEFERPROM_SELSJSON", AV159TFConBaseFerProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEHOREXT_SELSJSON", AV161TFConBaseHorExt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEHOREXTPROM_SELSJSON", AV163TFConBaseHorExtProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASELIC_SELSJSON", AV165TFConBaseLic_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASELICPROM_SELSJSON", AV167TFConBaseLicProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEOSDIF_SELSJSON", AV169TFConBaseOSDif_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRELREF_SELSJSON", AV199TFConRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV111CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO_SELECTED", GXutil.rtrim( AV112ConCodigo_Selected));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOCONCOD", GXutil.rtrim( AV138TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV138TipoConCod, ""))));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmtype));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
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
         we2K2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2K2( ) ;
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
      return formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV188MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Conceptos", "") ;
   }

   public void wb2K0( )
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
         wb_table1_9_2K2( true) ;
      }
      else
      {
         wb_table1_9_2K2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2K2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportarconceptos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Importar Conceptoss", ""), bttBtnimportarconceptos_Jsonclick, 7, httpContext.getMessage( "Importar Conceptoss", ""), "", StyleString, ClassString, bttBtnimportarconceptos_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e112k1_client"+"'", TempTags, "", 2, "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ml25", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction1_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "usados", ""), bttBtnuseraction1_Jsonclick, 5, httpContext.getMessage( "usados", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION1\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoWW.htm");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV51DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         wb_table2_165_2K2( true) ;
      }
      else
      {
         wb_table2_165_2K2( false) ;
      }
      return  ;
   }

   public void wb_table2_165_2K2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_confchmodforauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 172,'',false,'" + sGXsfl_108_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_confchmodforauxdatetext_Internalname, AV50DDO_ConFchModForAuxDateText, GXutil.rtrim( localUtil.format( AV50DDO_ConFchModForAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,172);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_confchmodforauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoWW.htm");
         /* User Defined Control */
         ucTfconfchmodfor_rangepicker.setProperty("Start Date", AV48DDO_ConFchModForAuxDate);
         ucTfconfchmodfor_rangepicker.setProperty("End Date", AV49DDO_ConFchModForAuxDateTo);
         ucTfconfchmodfor_rangepicker.render(context, "wwp.daterangepicker", Tfconfchmodfor_rangepicker_Internalname, "TFCONFCHMODFOR_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 108 )
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

   public void start2K2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Conceptos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2K0( ) ;
   }

   public void ws2K2( )
   {
      start2K2( ) ;
      evt2K2( ) ;
   }

   public void evt2K2( )
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
                           e122K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e162K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction1' */
                           e182K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e192K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e202K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e212K2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VELIMINARSVG.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VELIMINARSVG.CLICK") == 0 ) )
                        {
                           nGXsfl_108_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1082( ) ;
                           AV58EditarFormula = httpContext.cgiGet( edtavEditarformula_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEditarformula_Internalname, AV58EditarFormula);
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A38SubTipoConCod1 = httpContext.cgiGet( edtSubTipoConCod1_Internalname) ;
                           n38SubTipoConCod1 = false ;
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
                           cmbTipoConCod.setName( cmbTipoConCod.getInternalname() );
                           cmbTipoConCod.setValue( httpContext.cgiGet( cmbTipoConCod.getInternalname()) );
                           A37TipoConCod = httpContext.cgiGet( cmbTipoConCod.getInternalname()) ;
                           A970ConClasifAux = httpContext.cgiGet( edtConClasifAux_Internalname) ;
                           n970ConClasifAux = false ;
                           A503ConTipoLiqAux = httpContext.cgiGet( edtConTipoLiqAux_Internalname) ;
                           n503ConTipoLiqAux = false ;
                           dynConceptoConveCodigo.setName( dynConceptoConveCodigo.getInternalname() );
                           dynConceptoConveCodigo.setValue( httpContext.cgiGet( dynConceptoConveCodigo.getInternalname()) );
                           A1645ConceptoConveCodigo = httpContext.cgiGet( dynConceptoConveCodigo.getInternalname()) ;
                           n1645ConceptoConveCodigo = false ;
                           cmbConVigencia.setName( cmbConVigencia.getInternalname() );
                           cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
                           A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
                           A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
                           AV84ConFormula = httpContext.cgiGet( edtavConformula_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConformula_Internalname, AV84ConFormula);
                           A150ConHabilitado = GXutil.strtobool( httpContext.cgiGet( chkConHabilitado.getInternalname())) ;
                           A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
                           A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1112AplIIGG = false ;
                           A156ConUsuModFor = httpContext.cgiGet( edtConUsuModFor_Internalname) ;
                           n156ConUsuModFor = false ;
                           A145ConFchModFor = localUtil.ctot( httpContext.cgiGet( edtConFchModFor_Internalname), 0) ;
                           n145ConFchModFor = false ;
                           A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
                           cmbConCondicion.setName( cmbConCondicion.getInternalname() );
                           cmbConCondicion.setValue( httpContext.cgiGet( cmbConCondicion.getInternalname()) );
                           A953ConCondicion = httpContext.cgiGet( cmbConCondicion.getInternalname()) ;
                           n953ConCondicion = false ;
                           cmbConSacDeven.setName( cmbConSacDeven.getInternalname() );
                           cmbConSacDeven.setValue( httpContext.cgiGet( cmbConSacDeven.getInternalname()) );
                           A1539ConSacDeven = (byte)(GXutil.lval( httpContext.cgiGet( cmbConSacDeven.getInternalname()))) ;
                           A1648ConCodAfip = httpContext.cgiGet( edtConCodAfip_Internalname) ;
                           cmbConBasePres.setName( cmbConBasePres.getInternalname() );
                           cmbConBasePres.setValue( httpContext.cgiGet( cmbConBasePres.getInternalname()) );
                           A1800ConBasePres = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBasePres.getInternalname()))) ;
                           cmbConBaseAnt.setName( cmbConBaseAnt.getInternalname() );
                           cmbConBaseAnt.setValue( httpContext.cgiGet( cmbConBaseAnt.getInternalname()) );
                           A1801ConBaseAnt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseAnt.getInternalname()))) ;
                           cmbConBaseFer.setName( cmbConBaseFer.getInternalname() );
                           cmbConBaseFer.setValue( httpContext.cgiGet( cmbConBaseFer.getInternalname()) );
                           A1621ConBaseFer = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFer.getInternalname()))) ;
                           cmbConBaseFerProm.setName( cmbConBaseFerProm.getInternalname() );
                           cmbConBaseFerProm.setValue( httpContext.cgiGet( cmbConBaseFerProm.getInternalname()) );
                           A1798ConBaseFerProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFerProm.getInternalname()))) ;
                           cmbConBaseHorExt.setName( cmbConBaseHorExt.getInternalname() );
                           cmbConBaseHorExt.setValue( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()) );
                           A1622ConBaseHorExt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()))) ;
                           cmbConBaseHorExtProm.setName( cmbConBaseHorExtProm.getInternalname() );
                           cmbConBaseHorExtProm.setValue( httpContext.cgiGet( cmbConBaseHorExtProm.getInternalname()) );
                           A1799ConBaseHorExtProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExtProm.getInternalname()))) ;
                           cmbConBaseLic.setName( cmbConBaseLic.getInternalname() );
                           cmbConBaseLic.setValue( httpContext.cgiGet( cmbConBaseLic.getInternalname()) );
                           A1620ConBaseLic = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLic.getInternalname()))) ;
                           cmbConBaseLicProm.setName( cmbConBaseLicProm.getInternalname() );
                           cmbConBaseLicProm.setValue( httpContext.cgiGet( cmbConBaseLicProm.getInternalname()) );
                           A1797ConBaseLicProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLicProm.getInternalname()))) ;
                           cmbConBaseOSDif.setName( cmbConBaseOSDif.getInternalname() );
                           cmbConBaseOSDif.setValue( httpContext.cgiGet( cmbConBaseOSDif.getInternalname()) );
                           A1827ConBaseOSDif = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseOSDif.getInternalname()))) ;
                           A1886ConRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1905ConRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( edtConRelSecCli_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV178CliReDTChar = httpContext.cgiGet( edtavCliredtchar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCliredtchar_Internalname, AV178CliReDTChar);
                           A2013ConRelRef = httpContext.cgiGet( edtConRelRef_Internalname) ;
                           AV187Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV187Display);
                           AV113Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV113Update);
                           AV115Eliminar = httpContext.cgiGet( edtavEliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_Internalname, AV115Eliminar);
                           AV186EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV186EliminarSVG);
                           AV184VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV184VerSVG);
                           AV185ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV185ModificarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e222K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e232K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e242K2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VELIMINARSVG.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e252K2 ();
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

   public void we2K2( )
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

   public void pa2K2( )
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

   public void gxdlaconceptoconvecodigo2K2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconceptoconvecodigo_data2K2( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaconceptoconvecodigo_html2K2( )
   {
      String gxdynajaxvalue;
      gxdlaconceptoconvecodigo_data2K2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConceptoConveCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConceptoConveCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconceptoconvecodigo_data2K2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "No aplica", ""));
      /* Using cursor H002K2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H002K2_A1645ConceptoConveCodigo[0]));
         gxdynajaxctrldescr.add(H002K2_A160ConveDescri[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1082( ) ;
      while ( nGXsfl_108_idx <= nRC_GXsfl_108 )
      {
         sendrow_1082( ) ;
         nGXsfl_108_idx = ((subGrid_Islastpage==1)&&(nGXsfl_108_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_108_idx+1) ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV125ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ,
                                 String AV214Pgmname ,
                                 String AV188MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV11GridState ,
                                 String AV23TFConCodigo ,
                                 GXSimpleCollection<String> AV60TFConCodigo_Sels ,
                                 String AV25TFConDescrip ,
                                 GXSimpleCollection<String> AV62TFConDescrip_Sels ,
                                 GXSimpleCollection<String> AV81TFTipoConCod_Sels ,
                                 String AV127TFConClasifAux ,
                                 GXSimpleCollection<String> AV128TFConClasifAux_Sels ,
                                 String AV104TFConTipoLiqAux ,
                                 GXSimpleCollection<String> AV105TFConTipoLiqAux_Sels ,
                                 String AV146TFConceptoConveCodigo ,
                                 GXSimpleCollection<String> AV147TFConceptoConveCodigo_Sels ,
                                 GXSimpleCollection<Byte> AV35TFConVigencia_Sels ,
                                 byte AV36TFConVariable_Sel ,
                                 String AV38TFConFormula ,
                                 byte AV27TFConHabilitado_Sel ,
                                 String AV40TFConObservacion ,
                                 GXSimpleCollection<String> AV66TFConObservacion_Sels ,
                                 GXSimpleCollection<Short> AV135TFAplIIGG_Sels ,
                                 java.util.Date AV46TFConFchModFor ,
                                 java.util.Date AV47TFConFchModFor_To ,
                                 byte AV120TFConRecalcular_Sel ,
                                 GXSimpleCollection<String> AV133TFConCondicion_Sels ,
                                 GXSimpleCollection<Byte> AV140TFConSacDeven_Sels ,
                                 String AV149TFConCodAfip ,
                                 GXSimpleCollection<String> AV150TFConCodAfip_Sels ,
                                 GXSimpleCollection<Byte> AV154TFConBasePres_Sels ,
                                 GXSimpleCollection<Byte> AV156TFConBaseAnt_Sels ,
                                 GXSimpleCollection<Byte> AV158TFConBaseFer_Sels ,
                                 GXSimpleCollection<Byte> AV160TFConBaseFerProm_Sels ,
                                 GXSimpleCollection<Byte> AV162TFConBaseHorExt_Sels ,
                                 GXSimpleCollection<Byte> AV164TFConBaseHorExtProm_Sels ,
                                 GXSimpleCollection<Byte> AV166TFConBaseLic_Sels ,
                                 GXSimpleCollection<Byte> AV168TFConBaseLicProm_Sels ,
                                 GXSimpleCollection<Byte> AV170TFConBaseOSDif_Sels ,
                                 String AV200TFConRelRef ,
                                 GXSimpleCollection<String> AV201TFConRelRef_Sels ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 int AV69CliCod ,
                                 boolean AV191IsAuthorized_Display ,
                                 boolean AV74IsAuthorized_Update ,
                                 boolean AV190WelcomeMessage_NoMostrarMas ,
                                 String AV138TipoConCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e232K2 ();
      GRID_nCurrentRecord = 0 ;
      rf2K2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A26ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODIGO", GXutil.rtrim( A26ConCodigo));
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
      AV190WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV190WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV190WelcomeMessage_NoMostrarMas", AV190WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2K2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV214Pgmname = "ConceptoWW" ;
      Gx_err = (short)(0) ;
      edtavEditarformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEditarformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditarformula_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConformula_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavCliredtchar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliredtchar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliredtchar_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rf2K2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e232K2 ();
      nGXsfl_108_idx = 1 ;
      sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1082( ) ;
      bGXsfl_108_Refreshing = true ;
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
         subsflControlProps_1082( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              A26ConCodigo ,
                                              AV216Conceptowwds_2_tfconcodigo_sels ,
                                              A41ConDescrip ,
                                              AV218Conceptowwds_4_tfcondescrip_sels ,
                                              A37TipoConCod ,
                                              AV219Conceptowwds_5_tftipoconcod_sels ,
                                              A970ConClasifAux ,
                                              AV221Conceptowwds_7_tfconclasifaux_sels ,
                                              A503ConTipoLiqAux ,
                                              AV223Conceptowwds_9_tfcontipoliqaux_sels ,
                                              A1645ConceptoConveCodigo ,
                                              AV225Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                              Byte.valueOf(A162ConVigencia) ,
                                              AV226Conceptowwds_12_tfconvigencia_sels ,
                                              A153ConObservacion ,
                                              AV231Conceptowwds_17_tfconobservacion_sels ,
                                              Short.valueOf(A1112AplIIGG) ,
                                              AV232Conceptowwds_18_tfapliigg_sels ,
                                              A953ConCondicion ,
                                              AV236Conceptowwds_22_tfconcondicion_sels ,
                                              Byte.valueOf(A1539ConSacDeven) ,
                                              AV237Conceptowwds_23_tfconsacdeven_sels ,
                                              A1648ConCodAfip ,
                                              AV239Conceptowwds_25_tfconcodafip_sels ,
                                              Byte.valueOf(A1800ConBasePres) ,
                                              AV240Conceptowwds_26_tfconbasepres_sels ,
                                              Byte.valueOf(A1801ConBaseAnt) ,
                                              AV241Conceptowwds_27_tfconbaseant_sels ,
                                              Byte.valueOf(A1621ConBaseFer) ,
                                              AV242Conceptowwds_28_tfconbasefer_sels ,
                                              Byte.valueOf(A1798ConBaseFerProm) ,
                                              AV243Conceptowwds_29_tfconbaseferprom_sels ,
                                              Byte.valueOf(A1622ConBaseHorExt) ,
                                              AV244Conceptowwds_30_tfconbasehorext_sels ,
                                              Byte.valueOf(A1799ConBaseHorExtProm) ,
                                              AV245Conceptowwds_31_tfconbasehorextprom_sels ,
                                              Byte.valueOf(A1620ConBaseLic) ,
                                              AV246Conceptowwds_32_tfconbaselic_sels ,
                                              Byte.valueOf(A1797ConBaseLicProm) ,
                                              AV247Conceptowwds_33_tfconbaselicprom_sels ,
                                              Byte.valueOf(A1827ConBaseOSDif) ,
                                              AV248Conceptowwds_34_tfconbaseosdif_sels ,
                                              A2013ConRelRef ,
                                              AV250Conceptowwds_36_tfconrelref_sels ,
                                              Integer.valueOf(AV216Conceptowwds_2_tfconcodigo_sels.size()) ,
                                              AV215Conceptowwds_1_tfconcodigo ,
                                              Integer.valueOf(AV218Conceptowwds_4_tfcondescrip_sels.size()) ,
                                              AV217Conceptowwds_3_tfcondescrip ,
                                              Integer.valueOf(AV219Conceptowwds_5_tftipoconcod_sels.size()) ,
                                              Integer.valueOf(AV221Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                              AV220Conceptowwds_6_tfconclasifaux ,
                                              Integer.valueOf(AV223Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                              AV222Conceptowwds_8_tfcontipoliqaux ,
                                              Integer.valueOf(AV225Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                              AV224Conceptowwds_10_tfconceptoconvecodigo ,
                                              Integer.valueOf(AV226Conceptowwds_12_tfconvigencia_sels.size()) ,
                                              Byte.valueOf(AV227Conceptowwds_13_tfconvariable_sel) ,
                                              Byte.valueOf(AV229Conceptowwds_15_tfconhabilitado_sel) ,
                                              Integer.valueOf(AV231Conceptowwds_17_tfconobservacion_sels.size()) ,
                                              AV230Conceptowwds_16_tfconobservacion ,
                                              Integer.valueOf(AV232Conceptowwds_18_tfapliigg_sels.size()) ,
                                              AV233Conceptowwds_19_tfconfchmodfor ,
                                              AV234Conceptowwds_20_tfconfchmodfor_to ,
                                              Byte.valueOf(AV235Conceptowwds_21_tfconrecalcular_sel) ,
                                              Integer.valueOf(AV236Conceptowwds_22_tfconcondicion_sels.size()) ,
                                              Integer.valueOf(AV237Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                              Integer.valueOf(AV239Conceptowwds_25_tfconcodafip_sels.size()) ,
                                              AV238Conceptowwds_24_tfconcodafip ,
                                              Integer.valueOf(AV240Conceptowwds_26_tfconbasepres_sels.size()) ,
                                              Integer.valueOf(AV241Conceptowwds_27_tfconbaseant_sels.size()) ,
                                              Integer.valueOf(AV242Conceptowwds_28_tfconbasefer_sels.size()) ,
                                              Integer.valueOf(AV243Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                              Integer.valueOf(AV244Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                              Integer.valueOf(AV245Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                              Integer.valueOf(AV246Conceptowwds_32_tfconbaselic_sels.size()) ,
                                              Integer.valueOf(AV247Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                              Integer.valueOf(AV248Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                              Integer.valueOf(AV250Conceptowwds_36_tfconrelref_sels.size()) ,
                                              AV249Conceptowwds_35_tfconrelref ,
                                              AV38TFConFormula ,
                                              A160ConveDescri ,
                                              Boolean.valueOf(A159ConVariable) ,
                                              Boolean.valueOf(A150ConHabilitado) ,
                                              A145ConFchModFor ,
                                              Boolean.valueOf(A762ConRecalcular) ,
                                              A148ConFormula ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV69CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV215Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV215Conceptowwds_1_tfconcodigo), 10, "%") ;
         lV217Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV217Conceptowwds_3_tfcondescrip), "%", "") ;
         lV220Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV220Conceptowwds_6_tfconclasifaux), "%", "") ;
         lV222Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV222Conceptowwds_8_tfcontipoliqaux), "%", "") ;
         lV224Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV224Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
         lV230Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV230Conceptowwds_16_tfconobservacion), "%", "") ;
         lV238Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV238Conceptowwds_24_tfconcodafip), 6, "%") ;
         lV249Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV249Conceptowwds_35_tfconrelref), "%", "") ;
         lV38TFConFormula = GXutil.concat( GXutil.rtrim( AV38TFConFormula), "%", "") ;
         /* Using cursor H002K3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV69CliCod), lV215Conceptowwds_1_tfconcodigo, lV217Conceptowwds_3_tfcondescrip, lV220Conceptowwds_6_tfconclasifaux, lV222Conceptowwds_8_tfcontipoliqaux, lV224Conceptowwds_10_tfconceptoconvecodigo, lV230Conceptowwds_16_tfconobservacion, AV233Conceptowwds_19_tfconfchmodfor, AV234Conceptowwds_20_tfconfchmodfor_to, lV238Conceptowwds_24_tfconcodafip, lV249Conceptowwds_35_tfconrelref, lV38TFConFormula, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(1) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1644ConceptoPais = H002K3_A1644ConceptoPais[0] ;
            n1644ConceptoPais = H002K3_n1644ConceptoPais[0] ;
            A160ConveDescri = H002K3_A160ConveDescri[0] ;
            n160ConveDescri = H002K3_n160ConveDescri[0] ;
            A895ConTipoOrden = H002K3_A895ConTipoOrden[0] ;
            A921ConPadre = H002K3_A921ConPadre[0] ;
            n921ConPadre = H002K3_n921ConPadre[0] ;
            A148ConFormula = H002K3_A148ConFormula[0] ;
            n148ConFormula = H002K3_n148ConFormula[0] ;
            A2013ConRelRef = H002K3_A2013ConRelRef[0] ;
            A1905ConRelSecCli = H002K3_A1905ConRelSecCli[0] ;
            A1886ConRelSec = H002K3_A1886ConRelSec[0] ;
            A1827ConBaseOSDif = H002K3_A1827ConBaseOSDif[0] ;
            A1797ConBaseLicProm = H002K3_A1797ConBaseLicProm[0] ;
            A1620ConBaseLic = H002K3_A1620ConBaseLic[0] ;
            A1799ConBaseHorExtProm = H002K3_A1799ConBaseHorExtProm[0] ;
            A1622ConBaseHorExt = H002K3_A1622ConBaseHorExt[0] ;
            A1798ConBaseFerProm = H002K3_A1798ConBaseFerProm[0] ;
            A1621ConBaseFer = H002K3_A1621ConBaseFer[0] ;
            A1801ConBaseAnt = H002K3_A1801ConBaseAnt[0] ;
            A1800ConBasePres = H002K3_A1800ConBasePres[0] ;
            A1648ConCodAfip = H002K3_A1648ConCodAfip[0] ;
            A1539ConSacDeven = H002K3_A1539ConSacDeven[0] ;
            A953ConCondicion = H002K3_A953ConCondicion[0] ;
            n953ConCondicion = H002K3_n953ConCondicion[0] ;
            A762ConRecalcular = H002K3_A762ConRecalcular[0] ;
            A145ConFchModFor = H002K3_A145ConFchModFor[0] ;
            n145ConFchModFor = H002K3_n145ConFchModFor[0] ;
            A156ConUsuModFor = H002K3_A156ConUsuModFor[0] ;
            n156ConUsuModFor = H002K3_n156ConUsuModFor[0] ;
            A1112AplIIGG = H002K3_A1112AplIIGG[0] ;
            n1112AplIIGG = H002K3_n1112AplIIGG[0] ;
            A153ConObservacion = H002K3_A153ConObservacion[0] ;
            A150ConHabilitado = H002K3_A150ConHabilitado[0] ;
            A159ConVariable = H002K3_A159ConVariable[0] ;
            A162ConVigencia = H002K3_A162ConVigencia[0] ;
            A1645ConceptoConveCodigo = H002K3_A1645ConceptoConveCodigo[0] ;
            n1645ConceptoConveCodigo = H002K3_n1645ConceptoConveCodigo[0] ;
            A503ConTipoLiqAux = H002K3_A503ConTipoLiqAux[0] ;
            n503ConTipoLiqAux = H002K3_n503ConTipoLiqAux[0] ;
            A970ConClasifAux = H002K3_A970ConClasifAux[0] ;
            n970ConClasifAux = H002K3_n970ConClasifAux[0] ;
            A37TipoConCod = H002K3_A37TipoConCod[0] ;
            A41ConDescrip = H002K3_A41ConDescrip[0] ;
            A26ConCodigo = H002K3_A26ConCodigo[0] ;
            A38SubTipoConCod1 = H002K3_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = H002K3_n38SubTipoConCod1[0] ;
            A3CliCod = H002K3_A3CliCod[0] ;
            A160ConveDescri = H002K3_A160ConveDescri[0] ;
            n160ConveDescri = H002K3_n160ConveDescri[0] ;
            e242K2 ();
            pr_default.readNext(1);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(1) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(1);
         wbEnd = (short)(108) ;
         wb2K0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2K2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV214Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV214Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV188MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV188MenuOpcCod, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV191IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV191IsAuthorized_Display));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD"+"_"+sGXsfl_108_idx, getSecureSignedToken( sGXsfl_108_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CONCODIGO"+"_"+sGXsfl_108_idx, getSecureSignedToken( sGXsfl_108_idx, GXutil.rtrim( localUtil.format( A26ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOCONCOD", GXutil.rtrim( AV138TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV138TipoConCod, ""))));
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
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV216Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV218Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV219Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV221Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV223Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV225Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV226Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV231Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV232Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV236Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV237Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV239Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV240Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV241Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV242Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV243Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV244Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV245Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV246Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV247Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV248Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV250Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV216Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV215Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV218Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV217Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV219Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV221Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV220Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV223Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV222Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV225Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV224Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV226Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV227Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV229Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV231Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV230Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV232Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV233Conceptowwds_19_tfconfchmodfor ,
                                           AV234Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV235Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV236Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV237Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV239Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV238Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV240Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV241Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV242Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV243Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV244Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV245Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV246Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV247Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV248Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV250Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV249Conceptowwds_35_tfconrelref ,
                                           AV38TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV69CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV215Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV215Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV217Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV217Conceptowwds_3_tfcondescrip), "%", "") ;
      lV220Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV220Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV222Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV222Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV224Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV224Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV230Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV230Conceptowwds_16_tfconobservacion), "%", "") ;
      lV238Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV238Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV249Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV249Conceptowwds_35_tfconrelref), "%", "") ;
      lV38TFConFormula = GXutil.concat( GXutil.rtrim( AV38TFConFormula), "%", "") ;
      /* Using cursor H002K4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV69CliCod), lV215Conceptowwds_1_tfconcodigo, lV217Conceptowwds_3_tfcondescrip, lV220Conceptowwds_6_tfconclasifaux, lV222Conceptowwds_8_tfcontipoliqaux, lV224Conceptowwds_10_tfconceptoconvecodigo, lV230Conceptowwds_16_tfconobservacion, AV233Conceptowwds_19_tfconfchmodfor, AV234Conceptowwds_20_tfconfchmodfor_to, lV238Conceptowwds_24_tfconcodafip, lV249Conceptowwds_35_tfconrelref, lV38TFConFormula});
      GRID_nRecordCount = H002K4_AGRID_nRecordCount[0] ;
      pr_default.close(2);
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
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV214Pgmname = "ConceptoWW" ;
      Gx_err = (short)(0) ;
      edtavEditarformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEditarformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEditarformula_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConformula_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavCliredtchar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliredtchar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliredtchar_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      gxaconceptoconvecodigo_html2K2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2K0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e222K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV51DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV20ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV123ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV53GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV54GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV55GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV48DDO_ConFchModForAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_CONFCHMODFORAUXDATE"), 0) ;
         AV49DDO_ConFchModForAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_CONFCHMODFORAUXDATETO"), 0) ;
         AV112ConCodigo_Selected = httpContext.cgiGet( "vCONCODIGO_SELECTED") ;
         AV111CliCod_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Dvelop_confirmpanel_eliminar_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Title") ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext") ;
         Dvelop_confirmpanel_eliminar_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminar_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype") ;
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
         Dvelop_confirmpanel_eliminar_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Result") ;
         /* Read variables values. */
         AV197WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV190WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV190WelcomeMessage_NoMostrarMas", AV190WelcomeMessage_NoMostrarMas);
         AV50DDO_ConFchModForAuxDateText = httpContext.cgiGet( edtavDdo_confchmodforauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50DDO_ConFchModForAuxDateText", AV50DDO_ConFchModForAuxDateText);
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
      e222K2 ();
      if (returnInSub) return;
   }

   public void e222K2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV188MenuOpcCod, "", "") ;
      GXt_int1 = AV69CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV69CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod), 6, 0));
      this.executeUsercontrolMethod("", false, "TFCONFCHMODFOR_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_confchmodforauxdatetext_Internalname});
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
      Form.setCaption( httpContext.getMessage( " Conceptos", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV51DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV51DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV192MenuBienveImgURL ;
      GXv_char6[0] = AV194MenuBienveTitulo ;
      GXv_char7[0] = AV195MenuBienveTexto ;
      GXv_boolean8[0] = AV196MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV188MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      conceptoww_impl.this.AV192MenuBienveImgURL = GXv_char5[0] ;
      conceptoww_impl.this.AV194MenuBienveTitulo = GXv_char6[0] ;
      conceptoww_impl.this.AV195MenuBienveTexto = GXv_char7[0] ;
      conceptoww_impl.this.AV196MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV196MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV196MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV194MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV195MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV197WelcomeMessage_Foto = AV192MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV197WelcomeMessage_Foto)==0) ? AV213Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV197WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV197WelcomeMessage_Foto), true);
         AV213Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV192MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV197WelcomeMessage_Foto)==0) ? AV213Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV197WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV197WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      conceptoww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV207observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV207observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV207observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV207observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_char7[0] = AV144ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.AV144ConveCodigo = GXv_char7[0] ;
      GXv_int11[0] = AV143PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV69CliCod, GXv_int11) ;
      conceptoww_impl.this.AV143PaiCod = GXv_int11[0] ;
      GXv_char7[0] = AV142ConveDescri ;
      GXv_boolean8[0] = false ;
      new web.getconvenio(remoteHandle, context).execute( AV69CliCod, AV144ConveCodigo, GXv_char7, GXv_boolean8) ;
      conceptoww_impl.this.AV142ConveDescri = GXv_char7[0] ;
      GXv_char7[0] = AV152ConceptoConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.AV152ConceptoConveCodigo = GXv_char7[0] ;
      GXt_boolean12 = false ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      AV171esSistemaConceptosDefault = (short)((byte)((GXt_boolean12)?1:0)) ;
      GXv_boolean8[0] = AV172ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV69CliCod, GXv_boolean8) ;
      conceptoww_impl.this.AV172ClienteConveniador = GXv_boolean8[0] ;
   }

   public void e232K2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV69CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV69CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod), 6, 0));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV125ManageFiltersExecutionStep == 1 )
      {
         AV125ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV125ManageFiltersExecutionStep", GXutil.str( AV125ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV125ManageFiltersExecutionStep == 2 )
      {
         AV125ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV125ManageFiltersExecutionStep", GXutil.str( AV125ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV22Session.getValue("ConceptoWWColumnsSelector"), "") != 0 )
      {
         AV18ColumnsSelectorXML = AV22Session.getValue("ConceptoWWColumnsSelector") ;
         AV20ColumnsSelector.fromxml(AV18ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbTipoConCod.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtConClasifAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConClasifAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConClasifAux_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConTipoLiqAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTipoLiqAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTipoLiqAux_Visible), 5, 0), !bGXsfl_108_Refreshing);
      dynConceptoConveCodigo.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynConceptoConveCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynConceptoConveCodigo.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConVigencia.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Visible", GXutil.ltrimstr( cmbConVigencia.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      chkConVariable.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtavConformula_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConformula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConformula_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkConHabilitado.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConHabilitado.getInternalname(), "Visible", GXutil.ltrimstr( chkConHabilitado.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtConObservacion_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtAplIIGG_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConUsuModFor_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConUsuModFor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConUsuModFor_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtConFchModFor_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFchModFor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFchModFor_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkConRecalcular.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Visible", GXutil.ltrimstr( chkConRecalcular.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConCondicion.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbConCondicion.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConSacDeven.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Visible", GXutil.ltrimstr( cmbConSacDeven.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtConCodAfip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodAfip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodAfip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBasePres.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBasePres.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBasePres.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseAnt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseAnt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseAnt.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseFer.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseFer.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseFerProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFerProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseFerProm.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseHorExt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseHorExt.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseHorExtProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExtProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseHorExtProm.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseLic.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseLic.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseLicProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLicProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseLicProm.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbConBaseOSDif.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseOSDif.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseOSDif.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtConRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRelRef_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV53GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53GridCurrentPage), 10, 0));
      AV54GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54GridPageCount), 10, 0));
      GXt_char10 = AV55GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV214Pgmname, GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV55GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55GridAppliedFilters", AV55GridAppliedFilters);
      GXt_char10 = AV206MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV188MenuOpcCod, GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV206MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV206MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV206MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV209filterCount) ;
      GXv_char7[0] = AV210filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV11GridState, GXv_int11, GXv_char7) ;
      conceptoww_impl.this.AV209filterCount = GXv_int11[0] ;
      conceptoww_impl.this.AV210filtrosTexto = GXv_char7[0] ;
      if ( AV209filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV209filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV210filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      if ( GXutil.strcmp(AV72websession.getValue(httpContext.getMessage( "&ImpSec", "")), "") != 0 )
      {
         callWebObject(formatLink("web.aexcelhistorico", new String[] {GXutil.URLEncode(DecimalUtil.decToString(CommonUtil.decimalVal( AV72websession.getValue(httpContext.getMessage( "&ImpSec", "")), ".")))}, new String[] {"ImpSec"}) );
         httpContext.wjLocDisableFrm = (byte)(2) ;
         AV72websession.remove(httpContext.getMessage( "&ImpSec", ""));
      }
      GXv_char7[0] = AV144ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.AV144ConveCodigo = GXv_char7[0] ;
      GXv_char7[0] = AV152ConceptoConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.AV152ConceptoConveCodigo = GXv_char7[0] ;
      AV215Conceptowwds_1_tfconcodigo = AV23TFConCodigo ;
      AV216Conceptowwds_2_tfconcodigo_sels = AV60TFConCodigo_Sels ;
      AV217Conceptowwds_3_tfcondescrip = AV25TFConDescrip ;
      AV218Conceptowwds_4_tfcondescrip_sels = AV62TFConDescrip_Sels ;
      AV219Conceptowwds_5_tftipoconcod_sels = AV81TFTipoConCod_Sels ;
      AV220Conceptowwds_6_tfconclasifaux = AV127TFConClasifAux ;
      AV221Conceptowwds_7_tfconclasifaux_sels = AV128TFConClasifAux_Sels ;
      AV222Conceptowwds_8_tfcontipoliqaux = AV104TFConTipoLiqAux ;
      AV223Conceptowwds_9_tfcontipoliqaux_sels = AV105TFConTipoLiqAux_Sels ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = AV146TFConceptoConveCodigo ;
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = AV147TFConceptoConveCodigo_Sels ;
      AV226Conceptowwds_12_tfconvigencia_sels = AV35TFConVigencia_Sels ;
      AV227Conceptowwds_13_tfconvariable_sel = AV36TFConVariable_Sel ;
      AV228Conceptowwds_14_tfconformula = AV38TFConFormula ;
      AV229Conceptowwds_15_tfconhabilitado_sel = AV27TFConHabilitado_Sel ;
      AV230Conceptowwds_16_tfconobservacion = AV40TFConObservacion ;
      AV231Conceptowwds_17_tfconobservacion_sels = AV66TFConObservacion_Sels ;
      AV232Conceptowwds_18_tfapliigg_sels = AV135TFAplIIGG_Sels ;
      AV233Conceptowwds_19_tfconfchmodfor = AV46TFConFchModFor ;
      AV234Conceptowwds_20_tfconfchmodfor_to = AV47TFConFchModFor_To ;
      AV235Conceptowwds_21_tfconrecalcular_sel = AV120TFConRecalcular_Sel ;
      AV236Conceptowwds_22_tfconcondicion_sels = AV133TFConCondicion_Sels ;
      AV237Conceptowwds_23_tfconsacdeven_sels = AV140TFConSacDeven_Sels ;
      AV238Conceptowwds_24_tfconcodafip = AV149TFConCodAfip ;
      AV239Conceptowwds_25_tfconcodafip_sels = AV150TFConCodAfip_Sels ;
      AV240Conceptowwds_26_tfconbasepres_sels = AV154TFConBasePres_Sels ;
      AV241Conceptowwds_27_tfconbaseant_sels = AV156TFConBaseAnt_Sels ;
      AV242Conceptowwds_28_tfconbasefer_sels = AV158TFConBaseFer_Sels ;
      AV243Conceptowwds_29_tfconbaseferprom_sels = AV160TFConBaseFerProm_Sels ;
      AV244Conceptowwds_30_tfconbasehorext_sels = AV162TFConBaseHorExt_Sels ;
      AV245Conceptowwds_31_tfconbasehorextprom_sels = AV164TFConBaseHorExtProm_Sels ;
      AV246Conceptowwds_32_tfconbaselic_sels = AV166TFConBaseLic_Sels ;
      AV247Conceptowwds_33_tfconbaselicprom_sels = AV168TFConBaseLicProm_Sels ;
      AV248Conceptowwds_34_tfconbaseosdif_sels = AV170TFConBaseOSDif_Sels ;
      AV249Conceptowwds_35_tfconrelref = AV200TFConRelRef ;
      AV250Conceptowwds_36_tfconrelref_sels = AV201TFConRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV123ManageFiltersData", AV123ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV201TFConRelRef_Sels", AV201TFConRelRef_Sels);
   }

   public void e142K2( )
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
         AV52PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV52PageToGo) ;
      }
   }

   public void e152K2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e162K2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodigo") == 0 )
         {
            AV23TFConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFConCodigo", AV23TFConCodigo);
            AV59TFConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFConCodigo_SelsJson", AV59TFConCodigo_SelsJson);
            AV60TFConCodigo_Sels.fromJSonString(AV59TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConDescrip") == 0 )
         {
            AV25TFConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFConDescrip", AV25TFConDescrip);
            AV61TFConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFConDescrip_SelsJson", AV61TFConDescrip_SelsJson);
            AV62TFConDescrip_Sels.fromJSonString(AV61TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipoConCod") == 0 )
         {
            AV80TFTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFTipoConCod_SelsJson", AV80TFTipoConCod_SelsJson);
            AV81TFTipoConCod_Sels.fromJSonString(AV80TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConClasifAux") == 0 )
         {
            AV127TFConClasifAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV127TFConClasifAux", AV127TFConClasifAux);
            AV126TFConClasifAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV126TFConClasifAux_SelsJson", AV126TFConClasifAux_SelsJson);
            AV128TFConClasifAux_Sels.fromJSonString(AV126TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTipoLiqAux") == 0 )
         {
            AV104TFConTipoLiqAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV104TFConTipoLiqAux", AV104TFConTipoLiqAux);
            AV103TFConTipoLiqAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFConTipoLiqAux_SelsJson", AV103TFConTipoLiqAux_SelsJson);
            AV105TFConTipoLiqAux_Sels.fromJSonString(AV103TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConceptoConveCodigo") == 0 )
         {
            AV146TFConceptoConveCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV146TFConceptoConveCodigo", AV146TFConceptoConveCodigo);
            AV145TFConceptoConveCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV145TFConceptoConveCodigo_SelsJson", AV145TFConceptoConveCodigo_SelsJson);
            AV147TFConceptoConveCodigo_Sels.fromJSonString(AV145TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConVigencia") == 0 )
         {
            AV34TFConVigencia_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConVigencia_SelsJson", AV34TFConVigencia_SelsJson);
            AV35TFConVigencia_Sels.fromJSonString(GXutil.strReplace( AV34TFConVigencia_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConVariable") == 0 )
         {
            AV36TFConVariable_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConVariable_Sel", GXutil.str( AV36TFConVariable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFormula") == 0 )
         {
            AV38TFConFormula = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConFormula", AV38TFConFormula);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConHabilitado") == 0 )
         {
            AV27TFConHabilitado_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConHabilitado_Sel", GXutil.str( AV27TFConHabilitado_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConObservacion") == 0 )
         {
            AV40TFConObservacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConObservacion", AV40TFConObservacion);
            AV65TFConObservacion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConObservacion_SelsJson", AV65TFConObservacion_SelsJson);
            AV66TFConObservacion_Sels.fromJSonString(AV65TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGG") == 0 )
         {
            AV134TFAplIIGG_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFAplIIGG_SelsJson", AV134TFAplIIGG_SelsJson);
            AV135TFAplIIGG_Sels.fromJSonString(GXutil.strReplace( AV134TFAplIIGG_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFchModFor") == 0 )
         {
            AV46TFConFchModFor = localUtil.ctot( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConFchModFor", localUtil.ttoc( AV46TFConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV47TFConFchModFor_To = localUtil.ctot( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFConFchModFor_To", localUtil.ttoc( AV47TFConFchModFor_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV47TFConFchModFor_To) )
            {
               AV47TFConFchModFor_To = localUtil.ymdhmsToT( (short)(GXutil.year( AV47TFConFchModFor_To)), (byte)(GXutil.month( AV47TFConFchModFor_To)), (byte)(GXutil.day( AV47TFConFchModFor_To)), (byte)(23), (byte)(59), (byte)(59)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV47TFConFchModFor_To", localUtil.ttoc( AV47TFConFchModFor_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRecalcular") == 0 )
         {
            AV120TFConRecalcular_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRecalcular_Sel", GXutil.str( AV120TFConRecalcular_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCondicion") == 0 )
         {
            AV132TFConCondicion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV132TFConCondicion_SelsJson", AV132TFConCondicion_SelsJson);
            AV133TFConCondicion_Sels.fromJSonString(AV132TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConSacDeven") == 0 )
         {
            AV139TFConSacDeven_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFConSacDeven_SelsJson", AV139TFConSacDeven_SelsJson);
            AV140TFConSacDeven_Sels.fromJSonString(GXutil.strReplace( AV139TFConSacDeven_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodAfip") == 0 )
         {
            AV149TFConCodAfip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV149TFConCodAfip", AV149TFConCodAfip);
            AV148TFConCodAfip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV148TFConCodAfip_SelsJson", AV148TFConCodAfip_SelsJson);
            AV150TFConCodAfip_Sels.fromJSonString(AV148TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBasePres") == 0 )
         {
            AV153TFConBasePres_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV153TFConBasePres_SelsJson", AV153TFConBasePres_SelsJson);
            AV154TFConBasePres_Sels.fromJSonString(GXutil.strReplace( AV153TFConBasePres_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseAnt") == 0 )
         {
            AV155TFConBaseAnt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFConBaseAnt_SelsJson", AV155TFConBaseAnt_SelsJson);
            AV156TFConBaseAnt_Sels.fromJSonString(GXutil.strReplace( AV155TFConBaseAnt_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseFer") == 0 )
         {
            AV157TFConBaseFer_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV157TFConBaseFer_SelsJson", AV157TFConBaseFer_SelsJson);
            AV158TFConBaseFer_Sels.fromJSonString(GXutil.strReplace( AV157TFConBaseFer_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseFerProm") == 0 )
         {
            AV159TFConBaseFerProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV159TFConBaseFerProm_SelsJson", AV159TFConBaseFerProm_SelsJson);
            AV160TFConBaseFerProm_Sels.fromJSonString(GXutil.strReplace( AV159TFConBaseFerProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseHorExt") == 0 )
         {
            AV161TFConBaseHorExt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV161TFConBaseHorExt_SelsJson", AV161TFConBaseHorExt_SelsJson);
            AV162TFConBaseHorExt_Sels.fromJSonString(GXutil.strReplace( AV161TFConBaseHorExt_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseHorExtProm") == 0 )
         {
            AV163TFConBaseHorExtProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV163TFConBaseHorExtProm_SelsJson", AV163TFConBaseHorExtProm_SelsJson);
            AV164TFConBaseHorExtProm_Sels.fromJSonString(GXutil.strReplace( AV163TFConBaseHorExtProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseLic") == 0 )
         {
            AV165TFConBaseLic_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV165TFConBaseLic_SelsJson", AV165TFConBaseLic_SelsJson);
            AV166TFConBaseLic_Sels.fromJSonString(GXutil.strReplace( AV165TFConBaseLic_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseLicProm") == 0 )
         {
            AV167TFConBaseLicProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV167TFConBaseLicProm_SelsJson", AV167TFConBaseLicProm_SelsJson);
            AV168TFConBaseLicProm_Sels.fromJSonString(GXutil.strReplace( AV167TFConBaseLicProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseOSDif") == 0 )
         {
            AV169TFConBaseOSDif_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV169TFConBaseOSDif_SelsJson", AV169TFConBaseOSDif_SelsJson);
            AV170TFConBaseOSDif_Sels.fromJSonString(GXutil.strReplace( AV169TFConBaseOSDif_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRelRef") == 0 )
         {
            AV200TFConRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV200TFConRelRef", AV200TFConRelRef);
            AV199TFConRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV199TFConRelRef_SelsJson", AV199TFConRelRef_SelsJson);
            AV201TFConRelRef_Sels.fromJSonString(AV199TFConRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV201TFConRelRef_Sels", AV201TFConRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV170TFConBaseOSDif_Sels", AV170TFConBaseOSDif_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV168TFConBaseLicProm_Sels", AV168TFConBaseLicProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV166TFConBaseLic_Sels", AV166TFConBaseLic_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV164TFConBaseHorExtProm_Sels", AV164TFConBaseHorExtProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV162TFConBaseHorExt_Sels", AV162TFConBaseHorExt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV160TFConBaseFerProm_Sels", AV160TFConBaseFerProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV158TFConBaseFer_Sels", AV158TFConBaseFer_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV156TFConBaseAnt_Sels", AV156TFConBaseAnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV154TFConBasePres_Sels", AV154TFConBasePres_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV150TFConCodAfip_Sels", AV150TFConCodAfip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV140TFConSacDeven_Sels", AV140TFConSacDeven_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV133TFConCondicion_Sels", AV133TFConCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV135TFAplIIGG_Sels", AV135TFAplIIGG_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConObservacion_Sels", AV66TFConObservacion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV35TFConVigencia_Sels", AV35TFConVigencia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV147TFConceptoConveCodigo_Sels", AV147TFConceptoConveCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV105TFConTipoLiqAux_Sels", AV105TFConTipoLiqAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV128TFConClasifAux_Sels", AV128TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFTipoConCod_Sels", AV81TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV62TFConDescrip_Sels", AV62TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFConCodigo_Sels", AV60TFConCodigo_Sels);
   }

   private void e242K2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      GXt_boolean12 = false ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.permitemodificacionformula(remoteHandle, context).execute( A3CliCod, A26ConCodigo, GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      edtavEliminar_Visible = (GXt_boolean12 ? 1 : 0) ;
      AV58EditarFormula = "<i class=\"fas fa-flask\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEditarformula_Internalname, AV58EditarFormula);
      GXt_boolean12 = AV77TempBoolean ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.esredondeoosobregiro(remoteHandle, context).execute( A3CliCod, A26ConCodigo, GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      AV77TempBoolean = (boolean)(!GXt_boolean12) ;
      if ( AV77TempBoolean )
      {
         edtavEditarformula_Class = "Attribute" ;
      }
      else
      {
         edtavEditarformula_Class = "Invisible" ;
      }
      AV187Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV187Display);
      if ( AV191IsAuthorized_Display )
      {
         edtavDisplay_Link = formatLink("web.abmconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "DSP", ""))),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo))}, new String[] {"ParmTrnMode","CliCod","ConCodigo"})  ;
      }
      AV113Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV113Update);
      if ( AV74IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.abmconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo))}, new String[] {"ParmTrnMode","CliCod","ConCodigo"})  ;
      }
      AV115Eliminar = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_Internalname, AV115Eliminar);
      if ( (GXutil.strcmp("", A921ConPadre)==0) || (GXutil.strcmp("", A921ConPadre)==0) )
      {
         edtavEliminar_Class = "Attribute" ;
      }
      else
      {
         edtavEliminar_Class = "Invisible" ;
      }
      GXv_char7[0] = AV84ConFormula ;
      new web.getformulaabr(remoteHandle, context).execute( A3CliCod, A26ConCodigo, GXv_char7) ;
      conceptoww_impl.this.AV84ConFormula = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, edtavConformula_Internalname, AV84ConFormula);
      GXt_char10 = AV178CliReDTChar ;
      GXv_char7[0] = GXt_char10 ;
      new web.getreleasedtchar(remoteHandle, context).execute( A1905ConRelSecCli, A1886ConRelSec, GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV178CliReDTChar = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCliredtchar_Internalname, AV178CliReDTChar);
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV186EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV186EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV186EliminarSVG);
      edtavEliminarsvg_Link = edtavEliminar_Link ;
      edtavEliminar_Visible = 0 ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV184VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV184VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV184VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV185ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV185ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV185ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavConformula_Tooltiptext = A148ConFormula ;
      edtavEditarformula_Link = formatLink("web.formulawc", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Fórmula", ""))),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"MenuOpcCod","ConCodigo","parmLiqNro","parmLegNumero","llamador"})  ;
      if ( (GXutil.strcmp("", A921ConPadre)==0) || (GXutil.strcmp("", A921ConPadre)==0) )
      {
         edtavEliminarsvg_Visible = 1 ;
      }
      else
      {
         edtavEliminarsvg_Visible = 0 ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(108) ;
      }
      sendrow_1082( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_108_Refreshing )
      {
         httpContext.doAjaxLoad(108, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e122K2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV18ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV20ColumnsSelector.fromJSonString(AV18ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ConceptoWWColumnsSelector", ((GXutil.strcmp("", AV18ColumnsSelectorXML)==0) ? "" : AV20ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV123ManageFiltersData", AV123ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV201TFConRelRef_Sels", AV201TFConRelRef_Sels);
   }

   public void e132K2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("ConceptoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV214Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV125ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV125ManageFiltersExecutionStep", GXutil.str( AV125ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("ConceptoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV125ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV125ManageFiltersExecutionStep", GXutil.str( AV125ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV124ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "ConceptoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV124ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV124ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV214Pgmname+"GridState", AV124ManageFiltersXml) ;
            AV11GridState.fromxml(AV124ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFConCodigo_Sels", AV60TFConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV62TFConDescrip_Sels", AV62TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFTipoConCod_Sels", AV81TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV128TFConClasifAux_Sels", AV128TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV105TFConTipoLiqAux_Sels", AV105TFConTipoLiqAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV147TFConceptoConveCodigo_Sels", AV147TFConceptoConveCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV35TFConVigencia_Sels", AV35TFConVigencia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConObservacion_Sels", AV66TFConObservacion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV135TFAplIIGG_Sels", AV135TFAplIIGG_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV133TFConCondicion_Sels", AV133TFConCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV140TFConSacDeven_Sels", AV140TFConSacDeven_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV150TFConCodAfip_Sels", AV150TFConCodAfip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV154TFConBasePres_Sels", AV154TFConBasePres_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV156TFConBaseAnt_Sels", AV156TFConBaseAnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV158TFConBaseFer_Sels", AV158TFConBaseFer_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV160TFConBaseFerProm_Sels", AV160TFConBaseFerProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV162TFConBaseHorExt_Sels", AV162TFConBaseHorExt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV164TFConBaseHorExtProm_Sels", AV164TFConBaseHorExtProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV166TFConBaseLic_Sels", AV166TFConBaseLic_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV168TFConBaseLicProm_Sels", AV168TFConBaseLicProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV170TFConBaseOSDif_Sels", AV170TFConBaseOSDif_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV201TFConRelRef_Sels", AV201TFConRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV123ManageFiltersData", AV123ManageFiltersData);
   }

   public void e182K2( )
   {
      /* 'DoUserAction1' Routine */
      returnInSub = false ;
      new web.procedure4(remoteHandle, context).execute( AV69CliCod) ;
   }

   public void e172K2( )
   {
      /* Dvelop_confirmpanel_eliminar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ELIMINAR' */
         S202 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV123ManageFiltersData", AV123ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV201TFConRelRef_Sels", AV201TFConRelRef_Sels);
   }

   public void e212K2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.abmconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV69CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"ParmTrnMode","CliCod","ConCodigo"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e192K2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV16ExcelFilename ;
      GXv_char6[0] = AV17ErrorMessage ;
      new web.conceptowwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      conceptoww_impl.this.AV16ExcelFilename = GXv_char7[0] ;
      conceptoww_impl.this.AV17ErrorMessage = GXv_char6[0] ;
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
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConCodigo", "", "Código", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConDescrip", "", "Descripción", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "TipoConCod", "", "Tipo", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConClasifAux", "", "Clasificación", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConTipoLiqAux", "", "Tipo de Liquidación", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConceptoConveCodigo", "", "Convenio", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConVigencia", "", "Aplicación", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConVariable", "", "Rem. Var.", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ConFormula", "", "Fórmula", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConHabilitado", "", "Habilitado", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConObservacion", "", "Observación", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "AplIIGG", "", "Tratamiento IIGG", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConUsuModFor", "", "Usuario de Modificación", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConFchModFor", "", "Fecha de Modificación", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConRecalcular", "", "Recalcula Retroactivo en ganancias", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConCondicion", "", "Condición para liquidación", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConSacDeven", "", "Tipo devengamiento", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConCodAfip", "", "Concepto AFIP", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBasePres", "", "Base de cálculo para presentismo", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseAnt", "", "Base de cálculo para antiguedad", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseFer", "", "Base de cálculo para feriados de remuneración actual", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseFerProm", "", "Base de cálculo para feriados de remuneración promedio variable", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseHorExt", "", "Base de cálculo para horas extras de remuneración actual", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseHorExtProm", "", "Base de cálculo para horas extras de remuneración promedio variable", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseLic", "", "Base de cálculo para licencias de remuneraciòn actual", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseLicProm", "", "Base de cálculo para licencias de remuneración promedio variable", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConBaseOSDif", "", "Base de cálculo para obra social diferencial", false, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV69CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConRelRef", "", "Release", true, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV200TFConRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV200TFConRelRef", AV200TFConRelRef);
         AV201TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EliminarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ModificarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char10 = AV19UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConceptoWWColumnsSelector", GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV19UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV19UserCustomValue)==0) ) )
      {
         AV21ColumnsSelectorAux.fromxml(AV19UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV21ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV20ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV69CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( false ) )
      {
         bttBtnimportarconceptos_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnimportarconceptos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportarconceptos_Visible), 5, 0), true);
      }
      GXt_boolean12 = AV191IsAuthorized_Display ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ABMConcepto", GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      AV191IsAuthorized_Display = GXt_boolean12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV191IsAuthorized_Display", AV191IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV191IsAuthorized_Display));
      if ( ! ( AV191IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
      GXt_boolean12 = AV74IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ABMConcepto", GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      AV74IsAuthorized_Update = GXt_boolean12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74IsAuthorized_Update", AV74IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV74IsAuthorized_Update));
      if ( ! ( AV74IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
      GXt_boolean12 = AV77TempBoolean ;
      GXv_boolean8[0] = GXt_boolean12 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ABMConcepto", GXv_boolean8) ;
      conceptoww_impl.this.GXt_boolean12 = GXv_boolean8[0] ;
      AV77TempBoolean = GXt_boolean12 ;
      if ( ! ( AV77TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV123ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "ConceptoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV123ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV23TFConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23TFConCodigo", AV23TFConCodigo);
      AV60TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25TFConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFConDescrip", AV25TFConDescrip);
      AV62TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV81TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV127TFConClasifAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV127TFConClasifAux", AV127TFConClasifAux);
      AV128TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV104TFConTipoLiqAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV104TFConTipoLiqAux", AV104TFConTipoLiqAux);
      AV105TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV146TFConceptoConveCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV146TFConceptoConveCodigo", AV146TFConceptoConveCodigo);
      AV147TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35TFConVigencia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV36TFConVariable_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFConVariable_Sel", GXutil.str( AV36TFConVariable_Sel, 1, 0));
      AV38TFConFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFConFormula", AV38TFConFormula);
      AV27TFConHabilitado_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFConHabilitado_Sel", GXutil.str( AV27TFConHabilitado_Sel, 1, 0));
      AV40TFConObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFConObservacion", AV40TFConObservacion);
      AV66TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV135TFAplIIGG_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV46TFConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFConFchModFor", localUtil.ttoc( AV46TFConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      AV47TFConFchModFor_To = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFConFchModFor_To", localUtil.ttoc( AV47TFConFchModFor_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      AV120TFConRecalcular_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRecalcular_Sel", GXutil.str( AV120TFConRecalcular_Sel, 1, 0));
      AV133TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV140TFConSacDeven_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV149TFConCodAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV149TFConCodAfip", AV149TFConCodAfip);
      AV150TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV154TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV156TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV158TFConBaseFer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV160TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV162TFConBaseHorExt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV164TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV166TFConBaseLic_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV168TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV170TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV200TFConRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV200TFConRelRef", AV200TFConRelRef);
      AV201TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S202( )
   {
      /* 'DO ELIMINAR' Routine */
      returnInSub = false ;
      new web.eliminarconcepto(remoteHandle, context).execute( AV111CliCod_Selected, AV112ConCodigo_Selected) ;
      gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue(AV214Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV214Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV22Session.getValue(AV214Pgmname+"GridState"), null, null);
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
      GXv_char7[0] = AV152ConceptoConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char7) ;
      conceptoww_impl.this.AV152ConceptoConveCodigo = GXv_char7[0] ;
      AV251GXV1 = 1 ;
      while ( AV251GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV251GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV23TFConCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFConCodigo", AV23TFConCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV59TFConCodigo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFConCodigo_SelsJson", AV59TFConCodigo_SelsJson);
            AV60TFConCodigo_Sels.fromJSonString(AV59TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV25TFConDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFConDescrip", AV25TFConDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV61TFConDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFConDescrip_SelsJson", AV61TFConDescrip_SelsJson);
            AV62TFConDescrip_Sels.fromJSonString(AV61TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV80TFTipoConCod_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFTipoConCod_SelsJson", AV80TFTipoConCod_SelsJson);
            AV81TFTipoConCod_Sels.fromJSonString(AV80TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV127TFConClasifAux = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV127TFConClasifAux", AV127TFConClasifAux);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV126TFConClasifAux_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV126TFConClasifAux_SelsJson", AV126TFConClasifAux_SelsJson);
            AV128TFConClasifAux_Sels.fromJSonString(AV126TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX") == 0 )
         {
            AV104TFConTipoLiqAux = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV104TFConTipoLiqAux", AV104TFConTipoLiqAux);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX_SEL") == 0 )
         {
            AV103TFConTipoLiqAux_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFConTipoLiqAux_SelsJson", AV103TFConTipoLiqAux_SelsJson);
            AV105TFConTipoLiqAux_Sels.fromJSonString(AV103TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO") == 0 )
         {
            AV146TFConceptoConveCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV146TFConceptoConveCodigo", AV146TFConceptoConveCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO_SEL") == 0 )
         {
            AV145TFConceptoConveCodigo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV145TFConceptoConveCodigo_SelsJson", AV145TFConceptoConveCodigo_SelsJson);
            AV147TFConceptoConveCodigo_Sels.fromJSonString(AV145TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVIGENCIA_SEL") == 0 )
         {
            AV34TFConVigencia_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConVigencia_SelsJson", AV34TFConVigencia_SelsJson);
            AV35TFConVigencia_Sels.fromJSonString(AV34TFConVigencia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVARIABLE_SEL") == 0 )
         {
            AV36TFConVariable_Sel = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConVariable_Sel", GXutil.str( AV36TFConVariable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA") == 0 )
         {
            AV38TFConFormula = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConFormula", AV38TFConFormula);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONHABILITADO_SEL") == 0 )
         {
            AV27TFConHabilitado_Sel = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConHabilitado_Sel", GXutil.str( AV27TFConHabilitado_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION") == 0 )
         {
            AV40TFConObservacion = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConObservacion", AV40TFConObservacion);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION_SEL") == 0 )
         {
            AV65TFConObservacion_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConObservacion_SelsJson", AV65TFConObservacion_SelsJson);
            AV66TFConObservacion_Sels.fromJSonString(AV65TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG_SEL") == 0 )
         {
            AV134TFAplIIGG_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFAplIIGG_SelsJson", AV134TFAplIIGG_SelsJson);
            AV135TFAplIIGG_Sels.fromJSonString(AV134TFAplIIGG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFCHMODFOR") == 0 )
         {
            AV46TFConFchModFor = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConFchModFor", localUtil.ttoc( AV46TFConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV47TFConFchModFor_To = localUtil.ctot( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFConFchModFor_To", localUtil.ttoc( AV47TFConFchModFor_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            AV48DDO_ConFchModForAuxDate = GXutil.resetTime(AV46TFConFchModFor) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48DDO_ConFchModForAuxDate", localUtil.format(AV48DDO_ConFchModForAuxDate, "99/99/99"));
            AV49DDO_ConFchModForAuxDateTo = GXutil.resetTime(AV47TFConFchModFor_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49DDO_ConFchModForAuxDateTo", localUtil.format(AV49DDO_ConFchModForAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRECALCULAR_SEL") == 0 )
         {
            AV120TFConRecalcular_Sel = (byte)(GXutil.lval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRecalcular_Sel", GXutil.str( AV120TFConRecalcular_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV132TFConCondicion_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV132TFConCondicion_SelsJson", AV132TFConCondicion_SelsJson);
            AV133TFConCondicion_Sels.fromJSonString(AV132TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSACDEVEN_SEL") == 0 )
         {
            AV139TFConSacDeven_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFConSacDeven_SelsJson", AV139TFConSacDeven_SelsJson);
            AV140TFConSacDeven_Sels.fromJSonString(AV139TFConSacDeven_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP") == 0 )
         {
            AV149TFConCodAfip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV149TFConCodAfip", AV149TFConCodAfip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP_SEL") == 0 )
         {
            AV148TFConCodAfip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV148TFConCodAfip_SelsJson", AV148TFConCodAfip_SelsJson);
            AV150TFConCodAfip_Sels.fromJSonString(AV148TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEPRES_SEL") == 0 )
         {
            AV153TFConBasePres_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV153TFConBasePres_SelsJson", AV153TFConBasePres_SelsJson);
            AV154TFConBasePres_Sels.fromJSonString(AV153TFConBasePres_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEANT_SEL") == 0 )
         {
            AV155TFConBaseAnt_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFConBaseAnt_SelsJson", AV155TFConBaseAnt_SelsJson);
            AV156TFConBaseAnt_Sels.fromJSonString(AV155TFConBaseAnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFER_SEL") == 0 )
         {
            AV157TFConBaseFer_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV157TFConBaseFer_SelsJson", AV157TFConBaseFer_SelsJson);
            AV158TFConBaseFer_Sels.fromJSonString(AV157TFConBaseFer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFERPROM_SEL") == 0 )
         {
            AV159TFConBaseFerProm_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV159TFConBaseFerProm_SelsJson", AV159TFConBaseFerProm_SelsJson);
            AV160TFConBaseFerProm_Sels.fromJSonString(AV159TFConBaseFerProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXT_SEL") == 0 )
         {
            AV161TFConBaseHorExt_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV161TFConBaseHorExt_SelsJson", AV161TFConBaseHorExt_SelsJson);
            AV162TFConBaseHorExt_Sels.fromJSonString(AV161TFConBaseHorExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXTPROM_SEL") == 0 )
         {
            AV163TFConBaseHorExtProm_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV163TFConBaseHorExtProm_SelsJson", AV163TFConBaseHorExtProm_SelsJson);
            AV164TFConBaseHorExtProm_Sels.fromJSonString(AV163TFConBaseHorExtProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELIC_SEL") == 0 )
         {
            AV165TFConBaseLic_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV165TFConBaseLic_SelsJson", AV165TFConBaseLic_SelsJson);
            AV166TFConBaseLic_Sels.fromJSonString(AV165TFConBaseLic_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELICPROM_SEL") == 0 )
         {
            AV167TFConBaseLicProm_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV167TFConBaseLicProm_SelsJson", AV167TFConBaseLicProm_SelsJson);
            AV168TFConBaseLicProm_Sels.fromJSonString(AV167TFConBaseLicProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEOSDIF_SEL") == 0 )
         {
            AV169TFConBaseOSDif_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV169TFConBaseOSDif_SelsJson", AV169TFConBaseOSDif_SelsJson);
            AV170TFConBaseOSDif_Sels.fromJSonString(AV169TFConBaseOSDif_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF") == 0 )
         {
            AV200TFConRelRef = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV200TFConRelRef", AV200TFConRelRef);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF_SEL") == 0 )
         {
            AV199TFConRelRef_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV199TFConRelRef_SelsJson", AV199TFConRelRef_SelsJson);
            AV201TFConRelRef_Sels.fromJSonString(AV199TFConRelRef_SelsJson, null);
         }
         AV251GXV1 = (int)(AV251GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV60TFConCodigo_Sels.size()==0), AV59TFConCodigo_SelsJson, GXv_char7) ;
      conceptoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV62TFConDescrip_Sels.size()==0), AV61TFConDescrip_SelsJson, GXv_char6) ;
      conceptoww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char18 = "" ;
      GXv_char5[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV81TFTipoConCod_Sels.size()==0), AV80TFTipoConCod_SelsJson, GXv_char5) ;
      conceptoww_impl.this.GXt_char18 = GXv_char5[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV128TFConClasifAux_Sels.size()==0), AV126TFConClasifAux_SelsJson, GXv_char20) ;
      conceptoww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV105TFConTipoLiqAux_Sels.size()==0), AV103TFConTipoLiqAux_SelsJson, GXv_char22) ;
      conceptoww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV147TFConceptoConveCodigo_Sels.size()==0), AV145TFConceptoConveCodigo_SelsJson, GXv_char24) ;
      conceptoww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV66TFConObservacion_Sels.size()==0), AV65TFConObservacion_SelsJson, GXv_char26) ;
      conceptoww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV133TFConCondicion_Sels.size()==0), AV132TFConCondicion_SelsJson, GXv_char28) ;
      conceptoww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV150TFConCodAfip_Sels.size()==0), AV148TFConCodAfip_SelsJson, GXv_char30) ;
      conceptoww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV201TFConRelRef_Sels.size()==0), AV199TFConRelRef_SelsJson, GXv_char32) ;
      conceptoww_impl.this.GXt_char31 = GXv_char32[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"|"+GXt_char9+"|"+GXt_char18+"|"+GXt_char19+"|"+GXt_char21+"|"+GXt_char23+"|"+((AV35TFConVigencia_Sels.size()==0) ? "" : AV34TFConVigencia_SelsJson)+"|"+((0==AV36TFConVariable_Sel) ? "" : GXutil.str( AV36TFConVariable_Sel, 1, 0))+"||"+((0==AV27TFConHabilitado_Sel) ? "" : GXutil.str( AV27TFConHabilitado_Sel, 1, 0))+"|"+GXt_char25+"|"+((AV135TFAplIIGG_Sels.size()==0) ? "" : AV134TFAplIIGG_SelsJson)+"|||"+((0==AV120TFConRecalcular_Sel) ? "" : GXutil.str( AV120TFConRecalcular_Sel, 1, 0))+"|"+GXt_char27+"|"+((AV140TFConSacDeven_Sels.size()==0) ? "" : AV139TFConSacDeven_SelsJson)+"|"+GXt_char29+"|"+((AV154TFConBasePres_Sels.size()==0) ? "" : AV153TFConBasePres_SelsJson)+"|"+((AV156TFConBaseAnt_Sels.size()==0) ? "" : AV155TFConBaseAnt_SelsJson)+"|"+((AV158TFConBaseFer_Sels.size()==0) ? "" : AV157TFConBaseFer_SelsJson)+"|"+((AV160TFConBaseFerProm_Sels.size()==0) ? "" : AV159TFConBaseFerProm_SelsJson)+"|"+((AV162TFConBaseHorExt_Sels.size()==0) ? "" : AV161TFConBaseHorExt_SelsJson)+"|"+((AV164TFConBaseHorExtProm_Sels.size()==0) ? "" : AV163TFConBaseHorExtProm_SelsJson)+"|"+((AV166TFConBaseLic_Sels.size()==0) ? "" : AV165TFConBaseLic_SelsJson)+"|"+((AV168TFConBaseLicProm_Sels.size()==0) ? "" : AV167TFConBaseLicProm_SelsJson)+"|"+((AV170TFConBaseOSDif_Sels.size()==0) ? "" : AV169TFConBaseOSDif_SelsJson)+"|"+GXt_char31 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV23TFConCodigo)==0), AV23TFConCodigo, GXv_char32) ;
      conceptoww_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFConDescrip)==0), AV25TFConDescrip, GXv_char30) ;
      conceptoww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV127TFConClasifAux)==0), AV127TFConClasifAux, GXv_char28) ;
      conceptoww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV104TFConTipoLiqAux)==0), AV104TFConTipoLiqAux, GXv_char26) ;
      conceptoww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV146TFConceptoConveCodigo)==0), AV146TFConceptoConveCodigo, GXv_char24) ;
      conceptoww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV38TFConFormula)==0), AV38TFConFormula, GXv_char22) ;
      conceptoww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFConObservacion)==0), AV40TFConObservacion, GXv_char20) ;
      conceptoww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV149TFConCodAfip)==0), AV149TFConCodAfip, GXv_char7) ;
      conceptoww_impl.this.GXt_char18 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV200TFConRelRef)==0), AV200TFConRelRef, GXv_char6) ;
      conceptoww_impl.this.GXt_char10 = GXv_char6[0] ;
      Ddo_grid_Filteredtext_set = GXt_char31+"|"+GXt_char29+"||"+GXt_char27+"|"+GXt_char25+"|"+GXt_char23+"|||"+GXt_char21+"||"+GXt_char19+"|||"+(GXutil.dateCompare(GXutil.nullDate(), AV46TFConFchModFor) ? "" : localUtil.dtoc( AV48DDO_ConFchModForAuxDate, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||||"+GXt_char18+"||||||||||"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|||||||||||||"+(GXutil.dateCompare(GXutil.nullDate(), AV47TFConFchModFor_To) ? "" : localUtil.dtoc( AV49DDO_ConFchModForAuxDateTo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||||||||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV22Session.getValue(AV214Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONCODIGO", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV23TFConCodigo)==0), (short)(0), AV23TFConCodigo, "", !(AV60TFConCodigo_Sels.size()==0), AV60TFConCodigo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV25TFConDescrip)==0), (short)(0), AV25TFConDescrip, "", !(AV62TFConDescrip_Sels.size()==0), AV62TFConDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFTIPOCONCOD_SEL", httpContext.getMessage( "Tipo", ""), !(AV81TFTipoConCod_Sels.size()==0), (short)(0), AV81TFTipoConCod_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONCLASIFAUX", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV127TFConClasifAux)==0), (short)(0), AV127TFConClasifAux, "", !(AV128TFConClasifAux_Sels.size()==0), AV128TFConClasifAux_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONTIPOLIQAUX", httpContext.getMessage( "Tipo de Liquidación", ""), !(GXutil.strcmp("", AV104TFConTipoLiqAux)==0), (short)(0), AV104TFConTipoLiqAux, "", !(AV105TFConTipoLiqAux_Sels.size()==0), AV105TFConTipoLiqAux_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONCEPTOCONVECODIGO", httpContext.getMessage( "Convenio", ""), !(GXutil.strcmp("", AV146TFConceptoConveCodigo)==0), (short)(0), AV146TFConceptoConveCodigo, "", !(AV147TFConceptoConveCodigo_Sels.size()==0), AV147TFConceptoConveCodigo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONVIGENCIA_SEL", httpContext.getMessage( "Aplicación", ""), !(AV35TFConVigencia_Sels.size()==0), (short)(0), AV35TFConVigencia_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONVARIABLE_SEL", httpContext.getMessage( "Rem. Var.", ""), !(0==AV36TFConVariable_Sel), (short)(0), GXutil.trim( GXutil.str( AV36TFConVariable_Sel, 1, 0)), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONFORMULA", httpContext.getMessage( "Fórmula", ""), !(GXutil.strcmp("", AV38TFConFormula)==0), (short)(0), AV38TFConFormula, "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONHABILITADO_SEL", httpContext.getMessage( "Habilitado", ""), !(0==AV27TFConHabilitado_Sel), (short)(0), GXutil.trim( GXutil.str( AV27TFConHabilitado_Sel, 1, 0)), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONOBSERVACION", httpContext.getMessage( "Observación", ""), !(GXutil.strcmp("", AV40TFConObservacion)==0), (short)(0), AV40TFConObservacion, "", !(AV66TFConObservacion_Sels.size()==0), AV66TFConObservacion_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFAPLIIGG_SEL", httpContext.getMessage( "Tratamiento IIGG", ""), !(AV135TFAplIIGG_Sels.size()==0), (short)(0), AV135TFAplIIGG_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONFCHMODFOR", httpContext.getMessage( "Fecha de Modificación", ""), !(GXutil.dateCompare(GXutil.nullDate(), AV46TFConFchModFor)&&GXutil.dateCompare(GXutil.nullDate(), AV47TFConFchModFor_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV46TFConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV47TFConFchModFor_To, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONRECALCULAR_SEL", httpContext.getMessage( "Recalcula Retroactivo en ganancias", ""), !(0==AV120TFConRecalcular_Sel), (short)(0), GXutil.trim( GXutil.str( AV120TFConRecalcular_Sel, 1, 0)), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONCONDICION_SEL", httpContext.getMessage( "Condición para liquidación", ""), !(AV133TFConCondicion_Sels.size()==0), (short)(0), AV133TFConCondicion_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONSACDEVEN_SEL", httpContext.getMessage( "Tipo devengamiento", ""), !(AV140TFConSacDeven_Sels.size()==0), (short)(0), AV140TFConSacDeven_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONCODAFIP", httpContext.getMessage( "Concepto AFIP", ""), !(GXutil.strcmp("", AV149TFConCodAfip)==0), (short)(0), AV149TFConCodAfip, "", !(AV150TFConCodAfip_Sels.size()==0), AV150TFConCodAfip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEPRES_SEL", httpContext.getMessage( "Base de cálculo para presentismo", ""), !(AV154TFConBasePres_Sels.size()==0), (short)(0), AV154TFConBasePres_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEANT_SEL", httpContext.getMessage( "Base de cálculo para antiguedad", ""), !(AV156TFConBaseAnt_Sels.size()==0), (short)(0), AV156TFConBaseAnt_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEFER_SEL", httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", ""), !(AV158TFConBaseFer_Sels.size()==0), (short)(0), AV158TFConBaseFer_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEFERPROM_SEL", httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", ""), !(AV160TFConBaseFerProm_Sels.size()==0), (short)(0), AV160TFConBaseFerProm_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEHOREXT_SEL", httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", ""), !(AV162TFConBaseHorExt_Sels.size()==0), (short)(0), AV162TFConBaseHorExt_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEHOREXTPROM_SEL", httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", ""), !(AV164TFConBaseHorExtProm_Sels.size()==0), (short)(0), AV164TFConBaseHorExtProm_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASELIC_SEL", httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", ""), !(AV166TFConBaseLic_Sels.size()==0), (short)(0), AV166TFConBaseLic_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASELICPROM_SEL", httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", ""), !(AV168TFConBaseLicProm_Sels.size()==0), (short)(0), AV168TFConBaseLicProm_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONBASEOSDIF_SEL", httpContext.getMessage( "Base de cálculo para obra social diferencial", ""), !(AV170TFConBaseOSDif_Sels.size()==0), (short)(0), AV170TFConBaseOSDif_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      GXv_SdtWWPGridState33[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState33, "TFCONRELREF", httpContext.getMessage( "Release", ""), !(GXutil.strcmp("", AV200TFConRelRef)==0), (short)(0), AV200TFConRelRef, "", !(AV201TFConRelRef_Sels.size()==0), AV201TFConRelRef_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState33[0] ;
      if ( ! (GXutil.strcmp("", AV188MenuOpcCod)==0) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV188MenuOpcCod );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV214Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV214Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Concepto" );
      AV22Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e202K2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV190WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV188MenuOpcCod, GXv_boolean8) ;
         GXv_char32[0] = AV193textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV69CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char32) ;
         conceptoww_impl.this.AV193textoNoMostrara = GXv_char32[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV193textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV188MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e252K2( )
   {
      /* Eliminarsvg_Click Routine */
      returnInSub = false ;
      GXv_boolean8[0] = false ;
      GXv_boolean34[0] = false ;
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem35[0] = AV107sdt_conceptos ;
      GXv_boolean36[0] = false ;
      new web.analizarconceptosuso(remoteHandle, context).execute( A3CliCod, (short)(0), 0, 0, A26ConCodigo, AV138TipoConCod, httpContext.getMessage( "TODOS", ""), true, false, false, GXv_boolean8, GXv_boolean34, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem35, GXv_boolean36) ;
      AV107sdt_conceptos = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem35[0] ;
      if ( AV107sdt_conceptos.size() > 0 )
      {
         Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "¿Eliminar concepto en uso?", "") ;
         ucDvelop_confirmpanel_eliminar.sendProperty(context, "", false, Dvelop_confirmpanel_eliminar_Internalname, "Title", Dvelop_confirmpanel_eliminar_Title);
         AV109comentario = httpContext.getMessage( "**Advertencia**: El concepto es usado por ", "") ;
         if ( AV107sdt_conceptos.size() == 1 )
         {
            AV109comentario += httpContext.getMessage( "el concepto ", "") + GXutil.trim( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV107sdt_conceptos.elementAt(-1+1)).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo()) ;
         }
         else
         {
            AV109comentario += httpContext.getMessage( "los siguientes conceptos: ", "") ;
            AV110i = (short)(1) ;
            AV252GXV2 = 1 ;
            while ( AV252GXV2 <= AV107sdt_conceptos.size() )
            {
               AV108item = (web.Sdtsdt_conceptos_sdt_conceptosItem)((web.Sdtsdt_conceptos_sdt_conceptosItem)AV107sdt_conceptos.elementAt(-1+AV252GXV2));
               if ( AV110i != 1 )
               {
                  AV109comentario += ", " ;
               }
               AV109comentario += GXutil.trim( AV108item.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo()) ;
               AV110i = (short)(AV110i+1) ;
               AV252GXV2 = (int)(AV252GXV2+1) ;
            }
         }
         AV109comentario += "!" ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = GXutil.trim( AV109comentario) ;
         ucDvelop_confirmpanel_eliminar.sendProperty(context, "", false, Dvelop_confirmpanel_eliminar_Internalname, "ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
      }
      else
      {
         Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "Eliminar Concepto", "") ;
         ucDvelop_confirmpanel_eliminar.sendProperty(context, "", false, Dvelop_confirmpanel_eliminar_Internalname, "Title", Dvelop_confirmpanel_eliminar_Title);
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.getMessage( "¿Está seguro de que desea Eliminar el concepto?", "") ;
         ucDvelop_confirmpanel_eliminar.sendProperty(context, "", false, Dvelop_confirmpanel_eliminar_Internalname, "ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
      }
      /*  Sending Event outputs  */
   }

   public void S212( )
   {
      /* 'DO ACTION ELIMINAR' Routine */
      returnInSub = false ;
      new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "El concepto se ha elminado con éxito", "")) ;
      gxgrgrid_refresh( subGrid_Rows, AV125ManageFiltersExecutionStep, AV20ColumnsSelector, AV214Pgmname, AV188MenuOpcCod, AV11GridState, AV23TFConCodigo, AV60TFConCodigo_Sels, AV25TFConDescrip, AV62TFConDescrip_Sels, AV81TFTipoConCod_Sels, AV127TFConClasifAux, AV128TFConClasifAux_Sels, AV104TFConTipoLiqAux, AV105TFConTipoLiqAux_Sels, AV146TFConceptoConveCodigo, AV147TFConceptoConveCodigo_Sels, AV35TFConVigencia_Sels, AV36TFConVariable_Sel, AV38TFConFormula, AV27TFConHabilitado_Sel, AV40TFConObservacion, AV66TFConObservacion_Sels, AV135TFAplIIGG_Sels, AV46TFConFchModFor, AV47TFConFchModFor_To, AV120TFConRecalcular_Sel, AV133TFConCondicion_Sels, AV140TFConSacDeven_Sels, AV149TFConCodAfip, AV150TFConCodAfip_Sels, AV154TFConBasePres_Sels, AV156TFConBaseAnt_Sels, AV158TFConBaseFer_Sels, AV160TFConBaseFerProm_Sels, AV162TFConBaseHorExt_Sels, AV164TFConBaseHorExtProm_Sels, AV166TFConBaseLic_Sels, AV168TFConBaseLicProm_Sels, AV170TFConBaseOSDif_Sels, AV200TFConRelRef, AV201TFConRelRef_Sels, AV13OrderedBy, AV14OrderedDsc, AV69CliCod, AV191IsAuthorized_Display, AV74IsAuthorized_Update, AV190WelcomeMessage_NoMostrarMas, AV138TipoConCod) ;
   }

   public void wb_table2_165_2K2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_eliminar_Internalname, tblTabledvelop_confirmpanel_eliminar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_eliminar.setProperty("Title", Dvelop_confirmpanel_eliminar_Title);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonCaption", Dvelop_confirmpanel_eliminar_Yesbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("NoButtonCaption", Dvelop_confirmpanel_eliminar_Nobuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_eliminar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonPosition", Dvelop_confirmpanel_eliminar_Yesbuttonposition);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmType", Dvelop_confirmpanel_eliminar_Confirmtype);
         ucDvelop_confirmpanel_eliminar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_eliminar_Internalname, "DVELOP_CONFIRMPANEL_ELIMINARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_ELIMINARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_165_2K2e( true) ;
      }
      else
      {
         wb_table2_165_2K2e( false) ;
      }
   }

   public void wb_table1_9_2K2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table3_12_2K2( true) ;
      }
      else
      {
         wb_table3_12_2K2( false) ;
      }
      return  ;
   }

   public void wb_table3_12_2K2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2K2e( true) ;
      }
      else
      {
         wb_table1_9_2K2e( false) ;
      }
   }

   public void wb_table3_12_2K2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e262k1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ConceptoWW.htm");
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
         AV197WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV197WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV213Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV197WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV197WelcomeMessage_Foto)==0) ? AV213Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV197WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV197WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ConceptoWW.htm");
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
         wb_table4_30_2K2( true) ;
      }
      else
      {
         wb_table4_30_2K2( false) ;
      }
      return  ;
   }

   public void wb_table4_30_2K2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table5_35_2K2( true) ;
      }
      else
      {
         wb_table5_35_2K2( false) ;
      }
      return  ;
   }

   public void wb_table5_35_2K2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_108_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV190WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
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
         wb_table6_54_2K2( true) ;
      }
      else
      {
         wb_table6_54_2K2( false) ;
      }
      return  ;
   }

   public void wb_table6_54_2K2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltros_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ConceptoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, "BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV51DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV20ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV123ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_ConceptoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_2K2( true) ;
      }
      else
      {
         wb_table7_97_2K2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_2K2e( boolean wbgen )
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         startgridcontrol108( ) ;
      }
      if ( wbEnd == 108 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_108 = (int)(nGXsfl_108_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV53GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV54GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV55GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_12_2K2e( true) ;
      }
      else
      {
         wb_table3_12_2K2e( false) ;
      }
   }

   public void wb_table7_97_2K2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_2K2e( true) ;
      }
      else
      {
         wb_table7_97_2K2e( false) ;
      }
   }

   public void wb_table6_54_2K2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_54_2K2e( true) ;
      }
      else
      {
         wb_table6_54_2K2e( false) ;
      }
   }

   public void wb_table5_35_2K2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_35_2K2e( true) ;
      }
      else
      {
         wb_table5_35_2K2e( false) ;
      }
   }

   public void wb_table4_30_2K2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_30_2K2e( true) ;
      }
      else
      {
         wb_table4_30_2K2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV188MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV188MenuOpcCod", AV188MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV188MenuOpcCod, ""))));
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
      pa2K2( ) ;
      ws2K2( ) ;
      we2K2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202518720157", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("conceptoww.js", "?202518720158", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1082( )
   {
      edtavEditarformula_Internalname = "vEDITARFORMULA_"+sGXsfl_108_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_idx ;
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_108_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_108_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_108_idx ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_108_idx );
      edtConClasifAux_Internalname = "CONCLASIFAUX_"+sGXsfl_108_idx ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX_"+sGXsfl_108_idx ;
      dynConceptoConveCodigo.setInternalname( "CONCEPTOCONVECODIGO_"+sGXsfl_108_idx );
      cmbConVigencia.setInternalname( "CONVIGENCIA_"+sGXsfl_108_idx );
      chkConVariable.setInternalname( "CONVARIABLE_"+sGXsfl_108_idx );
      edtavConformula_Internalname = "vCONFORMULA_"+sGXsfl_108_idx ;
      chkConHabilitado.setInternalname( "CONHABILITADO_"+sGXsfl_108_idx );
      edtConObservacion_Internalname = "CONOBSERVACION_"+sGXsfl_108_idx ;
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_108_idx ;
      edtConUsuModFor_Internalname = "CONUSUMODFOR_"+sGXsfl_108_idx ;
      edtConFchModFor_Internalname = "CONFCHMODFOR_"+sGXsfl_108_idx ;
      chkConRecalcular.setInternalname( "CONRECALCULAR_"+sGXsfl_108_idx );
      cmbConCondicion.setInternalname( "CONCONDICION_"+sGXsfl_108_idx );
      cmbConSacDeven.setInternalname( "CONSACDEVEN_"+sGXsfl_108_idx );
      edtConCodAfip_Internalname = "CONCODAFIP_"+sGXsfl_108_idx ;
      cmbConBasePres.setInternalname( "CONBASEPRES_"+sGXsfl_108_idx );
      cmbConBaseAnt.setInternalname( "CONBASEANT_"+sGXsfl_108_idx );
      cmbConBaseFer.setInternalname( "CONBASEFER_"+sGXsfl_108_idx );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM_"+sGXsfl_108_idx );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT_"+sGXsfl_108_idx );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM_"+sGXsfl_108_idx );
      cmbConBaseLic.setInternalname( "CONBASELIC_"+sGXsfl_108_idx );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM_"+sGXsfl_108_idx );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF_"+sGXsfl_108_idx );
      edtConRelSec_Internalname = "CONRELSEC_"+sGXsfl_108_idx ;
      edtConRelSecCli_Internalname = "CONRELSECCLI_"+sGXsfl_108_idx ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR_"+sGXsfl_108_idx ;
      edtConRelRef_Internalname = "CONRELREF_"+sGXsfl_108_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_idx ;
      edtavEliminar_Internalname = "vELIMINAR_"+sGXsfl_108_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_108_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtavEditarformula_Internalname = "vEDITARFORMULA_"+sGXsfl_108_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_fel_idx ;
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_108_fel_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_108_fel_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_108_fel_idx ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_108_fel_idx );
      edtConClasifAux_Internalname = "CONCLASIFAUX_"+sGXsfl_108_fel_idx ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX_"+sGXsfl_108_fel_idx ;
      dynConceptoConveCodigo.setInternalname( "CONCEPTOCONVECODIGO_"+sGXsfl_108_fel_idx );
      cmbConVigencia.setInternalname( "CONVIGENCIA_"+sGXsfl_108_fel_idx );
      chkConVariable.setInternalname( "CONVARIABLE_"+sGXsfl_108_fel_idx );
      edtavConformula_Internalname = "vCONFORMULA_"+sGXsfl_108_fel_idx ;
      chkConHabilitado.setInternalname( "CONHABILITADO_"+sGXsfl_108_fel_idx );
      edtConObservacion_Internalname = "CONOBSERVACION_"+sGXsfl_108_fel_idx ;
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_108_fel_idx ;
      edtConUsuModFor_Internalname = "CONUSUMODFOR_"+sGXsfl_108_fel_idx ;
      edtConFchModFor_Internalname = "CONFCHMODFOR_"+sGXsfl_108_fel_idx ;
      chkConRecalcular.setInternalname( "CONRECALCULAR_"+sGXsfl_108_fel_idx );
      cmbConCondicion.setInternalname( "CONCONDICION_"+sGXsfl_108_fel_idx );
      cmbConSacDeven.setInternalname( "CONSACDEVEN_"+sGXsfl_108_fel_idx );
      edtConCodAfip_Internalname = "CONCODAFIP_"+sGXsfl_108_fel_idx ;
      cmbConBasePres.setInternalname( "CONBASEPRES_"+sGXsfl_108_fel_idx );
      cmbConBaseAnt.setInternalname( "CONBASEANT_"+sGXsfl_108_fel_idx );
      cmbConBaseFer.setInternalname( "CONBASEFER_"+sGXsfl_108_fel_idx );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM_"+sGXsfl_108_fel_idx );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT_"+sGXsfl_108_fel_idx );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM_"+sGXsfl_108_fel_idx );
      cmbConBaseLic.setInternalname( "CONBASELIC_"+sGXsfl_108_fel_idx );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM_"+sGXsfl_108_fel_idx );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF_"+sGXsfl_108_fel_idx );
      edtConRelSec_Internalname = "CONRELSEC_"+sGXsfl_108_fel_idx ;
      edtConRelSecCli_Internalname = "CONRELSECCLI_"+sGXsfl_108_fel_idx ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR_"+sGXsfl_108_fel_idx ;
      edtConRelRef_Internalname = "CONRELREF_"+sGXsfl_108_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_fel_idx ;
      edtavEliminar_Internalname = "vELIMINAR_"+sGXsfl_108_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_108_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wb2K0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_108_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_108_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_108_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEditarformula_Enabled!=0)&&(edtavEditarformula_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 109,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = edtavEditarformula_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEditarformula_Internalname,GXutil.rtrim( AV58EditarFormula),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEditarformula_Enabled!=0)&&(edtavEditarformula_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,109);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavEditarformula_Link,"","","",edtavEditarformula_Jsonclick,Integer.valueOf(0),edtavEditarformula_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEditarformula_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod1_Internalname,GXutil.rtrim( A38SubTipoConCod1),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConCod1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConDescrip_Internalname,A41ConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtConDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "TIPOCONCOD_" + sGXsfl_108_idx ;
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
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbTipoConCod,cmbTipoConCod.getInternalname(),GXutil.rtrim( A37TipoConCod),Integer.valueOf(1),cmbTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConClasifAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConClasifAux_Internalname,A970ConClasifAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConClasifAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConClasifAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConTipoLiqAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConTipoLiqAux_Internalname,A503ConTipoLiqAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConTipoLiqAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConTipoLiqAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         gxaconceptoconvecodigo_html2K2( ) ;
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((dynConceptoConveCodigo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( dynConceptoConveCodigo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONCEPTOCONVECODIGO_" + sGXsfl_108_idx ;
            dynConceptoConveCodigo.setName( GXCCtl );
            dynConceptoConveCodigo.setWebtags( "" );
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynConceptoConveCodigo,dynConceptoConveCodigo.getInternalname(),GXutil.rtrim( A1645ConceptoConveCodigo),Integer.valueOf(1),dynConceptoConveCodigo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(dynConceptoConveCodigo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         dynConceptoConveCodigo.setValue( GXutil.rtrim( A1645ConceptoConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynConceptoConveCodigo.getInternalname(), "Values", dynConceptoConveCodigo.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConVigencia.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConVigencia.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVIGENCIA_" + sGXsfl_108_idx ;
            cmbConVigencia.setName( GXCCtl );
            cmbConVigencia.setWebtags( "" );
            cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
            cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
            if ( cmbConVigencia.getItemCount() > 0 )
            {
               A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConVigencia,cmbConVigencia.getInternalname(),GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)),Integer.valueOf(1),cmbConVigencia.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConVigencia.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConVariable.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVARIABLE_" + sGXsfl_108_idx ;
         chkConVariable.setName( GXCCtl );
         chkConVariable.setWebtags( "" );
         chkConVariable.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), !bGXsfl_108_Refreshing);
         chkConVariable.setCheckedValue( "false" );
         A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConVariable.getInternalname(),GXutil.booltostr( A159ConVariable),"","",Integer.valueOf(chkConVariable.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavConformula_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavConformula_Enabled!=0)&&(edtavConformula_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 120,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConformula_Internalname,AV84ConFormula,AV84ConFormula,TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavConformula_Enabled!=0)&&(edtavConformula_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,120);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","",edtavConformula_Tooltiptext,"",edtavConformula_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavConformula_Visible),Integer.valueOf(edtavConformula_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConHabilitado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONHABILITADO_" + sGXsfl_108_idx ;
         chkConHabilitado.setName( GXCCtl );
         chkConHabilitado.setWebtags( "" );
         chkConHabilitado.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConHabilitado.getInternalname(), "TitleCaption", chkConHabilitado.getCaption(), !bGXsfl_108_Refreshing);
         chkConHabilitado.setCheckedValue( "false" );
         A150ConHabilitado = GXutil.strtobool( GXutil.booltostr( A150ConHabilitado)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConHabilitado.getInternalname(),GXutil.booltostr( A150ConHabilitado),"","",Integer.valueOf(chkConHabilitado.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConObservacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConObservacion_Internalname,A153ConObservacion,A153ConObservacion,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConObservacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConObservacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAplIIGG_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGG_Internalname,GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGG_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGG_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConUsuModFor_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConUsuModFor_Internalname,GXutil.rtrim( A156ConUsuModFor),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConUsuModFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConUsuModFor_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConFchModFor_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConFchModFor_Internalname,localUtil.ttoc( A145ConFchModFor, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( A145ConFchModFor, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConFchModFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConFchModFor_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConRecalcular.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONRECALCULAR_" + sGXsfl_108_idx ;
         chkConRecalcular.setName( GXCCtl );
         chkConRecalcular.setWebtags( "" );
         chkConRecalcular.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), !bGXsfl_108_Refreshing);
         chkConRecalcular.setCheckedValue( "false" );
         A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConRecalcular.getInternalname(),GXutil.booltostr( A762ConRecalcular),"","",Integer.valueOf(chkConRecalcular.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConCondicion.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConCondicion.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONCONDICION_" + sGXsfl_108_idx ;
            cmbConCondicion.setName( GXCCtl );
            cmbConCondicion.setWebtags( "" );
            cmbConCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
            cmbConCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
            cmbConCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
            cmbConCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
            cmbConCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
            cmbConCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
            cmbConCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
            cmbConCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
            cmbConCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
            cmbConCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
            cmbConCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
            cmbConCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
            cmbConCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
            cmbConCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
            cmbConCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
            cmbConCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
            cmbConCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
            cmbConCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
            cmbConCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
            cmbConCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
            cmbConCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
            cmbConCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
            cmbConCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
            cmbConCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
            cmbConCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
            cmbConCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
            if ( cmbConCondicion.getItemCount() > 0 )
            {
               A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
               n953ConCondicion = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConCondicion,cmbConCondicion.getInternalname(),GXutil.rtrim( A953ConCondicion),Integer.valueOf(1),cmbConCondicion.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConCondicion.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConSacDeven.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConSacDeven.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONSACDEVEN_" + sGXsfl_108_idx ;
            cmbConSacDeven.setName( GXCCtl );
            cmbConSacDeven.setWebtags( "" );
            cmbConSacDeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
            cmbConSacDeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbConSacDeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
            cmbConSacDeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
            cmbConSacDeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
            cmbConSacDeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
            if ( cmbConSacDeven.getItemCount() > 0 )
            {
               A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConSacDeven,cmbConSacDeven.getInternalname(),GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)),Integer.valueOf(1),cmbConSacDeven.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConSacDeven.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodAfip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodAfip_Internalname,GXutil.rtrim( A1648ConCodAfip),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodAfip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodAfip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBasePres.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBasePres.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEPRES_" + sGXsfl_108_idx ;
            cmbConBasePres.setName( GXCCtl );
            cmbConBasePres.setWebtags( "" );
            cmbConBasePres.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBasePres.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBasePres.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBasePres.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBasePres.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBasePres.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBasePres.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBasePres.getItemCount() > 0 )
            {
               A1800ConBasePres = (byte)(GXutil.lval( cmbConBasePres.getValidValue(GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBasePres,cmbConBasePres.getInternalname(),GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0)),Integer.valueOf(1),cmbConBasePres.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBasePres.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBasePres.setValue( GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBasePres.getInternalname(), "Values", cmbConBasePres.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseAnt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseAnt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEANT_" + sGXsfl_108_idx ;
            cmbConBaseAnt.setName( GXCCtl );
            cmbConBaseAnt.setWebtags( "" );
            cmbConBaseAnt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseAnt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseAnt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseAnt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseAnt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseAnt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseAnt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseAnt.getItemCount() > 0 )
            {
               A1801ConBaseAnt = (byte)(GXutil.lval( cmbConBaseAnt.getValidValue(GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseAnt,cmbConBaseAnt.getInternalname(),GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0)),Integer.valueOf(1),cmbConBaseAnt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseAnt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseAnt.setValue( GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseAnt.getInternalname(), "Values", cmbConBaseAnt.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseFer.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseFer.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEFER_" + sGXsfl_108_idx ;
            cmbConBaseFer.setName( GXCCtl );
            cmbConBaseFer.setWebtags( "" );
            cmbConBaseFer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseFer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseFer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseFer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseFer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseFer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseFer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseFer.getItemCount() > 0 )
            {
               A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseFer,cmbConBaseFer.getInternalname(),GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)),Integer.valueOf(1),cmbConBaseFer.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseFer.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseFerProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseFerProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEFERPROM_" + sGXsfl_108_idx ;
            cmbConBaseFerProm.setName( GXCCtl );
            cmbConBaseFerProm.setWebtags( "" );
            cmbConBaseFerProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseFerProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseFerProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseFerProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseFerProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseFerProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseFerProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseFerProm.getItemCount() > 0 )
            {
               A1798ConBaseFerProm = (byte)(GXutil.lval( cmbConBaseFerProm.getValidValue(GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseFerProm,cmbConBaseFerProm.getInternalname(),GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0)),Integer.valueOf(1),cmbConBaseFerProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseFerProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseFerProm.setValue( GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFerProm.getInternalname(), "Values", cmbConBaseFerProm.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseHorExt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseHorExt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEHOREXT_" + sGXsfl_108_idx ;
            cmbConBaseHorExt.setName( GXCCtl );
            cmbConBaseHorExt.setWebtags( "" );
            cmbConBaseHorExt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseHorExt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseHorExt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseHorExt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseHorExt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseHorExt.getItemCount() > 0 )
            {
               A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseHorExt,cmbConBaseHorExt.getInternalname(),GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)),Integer.valueOf(1),cmbConBaseHorExt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseHorExt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseHorExtProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseHorExtProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEHOREXTPROM_" + sGXsfl_108_idx ;
            cmbConBaseHorExtProm.setName( GXCCtl );
            cmbConBaseHorExtProm.setWebtags( "" );
            cmbConBaseHorExtProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseHorExtProm.getItemCount() > 0 )
            {
               A1799ConBaseHorExtProm = (byte)(GXutil.lval( cmbConBaseHorExtProm.getValidValue(GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseHorExtProm,cmbConBaseHorExtProm.getInternalname(),GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0)),Integer.valueOf(1),cmbConBaseHorExtProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseHorExtProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseHorExtProm.setValue( GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExtProm.getInternalname(), "Values", cmbConBaseHorExtProm.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseLic.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseLic.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASELIC_" + sGXsfl_108_idx ;
            cmbConBaseLic.setName( GXCCtl );
            cmbConBaseLic.setWebtags( "" );
            cmbConBaseLic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseLic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseLic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseLic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseLic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseLic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseLic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseLic.getItemCount() > 0 )
            {
               A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseLic,cmbConBaseLic.getInternalname(),GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)),Integer.valueOf(1),cmbConBaseLic.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseLic.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseLicProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseLicProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASELICPROM_" + sGXsfl_108_idx ;
            cmbConBaseLicProm.setName( GXCCtl );
            cmbConBaseLicProm.setWebtags( "" );
            cmbConBaseLicProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseLicProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseLicProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseLicProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseLicProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseLicProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseLicProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseLicProm.getItemCount() > 0 )
            {
               A1797ConBaseLicProm = (byte)(GXutil.lval( cmbConBaseLicProm.getValidValue(GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseLicProm,cmbConBaseLicProm.getInternalname(),GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0)),Integer.valueOf(1),cmbConBaseLicProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseLicProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseLicProm.setValue( GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLicProm.getInternalname(), "Values", cmbConBaseLicProm.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseOSDif.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseOSDif.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEOSDIF_" + sGXsfl_108_idx ;
            cmbConBaseOSDif.setName( GXCCtl );
            cmbConBaseOSDif.setWebtags( "" );
            cmbConBaseOSDif.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseOSDif.addItem("1", httpContext.getMessage( "Sí. Recalcular proporcional a jornada completa", ""), (short)(0));
            cmbConBaseOSDif.addItem("2", httpContext.getMessage( "Sí, el valor liquidado", ""), (short)(0));
            cmbConBaseOSDif.addItem("3", httpContext.getMessage( "Sí, el valor liquidado proporcional a jornada completa", ""), (short)(0));
            if ( cmbConBaseOSDif.getItemCount() > 0 )
            {
               A1827ConBaseOSDif = (byte)(GXutil.lval( cmbConBaseOSDif.getValidValue(GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseOSDif,cmbConBaseOSDif.getInternalname(),GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0)),Integer.valueOf(1),cmbConBaseOSDif.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseOSDif.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseOSDif.setValue( GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseOSDif.getInternalname(), "Values", cmbConBaseOSDif.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1886ConRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1886ConRelSec), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRelSecCli_Internalname,GXutil.ltrim( localUtil.ntoc( A1905ConRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1905ConRelSecCli), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRelSecCli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavCliredtchar_Enabled!=0)&&(edtavCliredtchar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 141,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCliredtchar_Internalname,AV178CliReDTChar,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCliredtchar_Enabled!=0)&&(edtavCliredtchar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,141);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCliredtchar_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavCliredtchar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRelRef_Internalname,A2013ConRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 143,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV187Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,143);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 144,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV113Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,144);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminar_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 145,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = edtavEliminar_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminar_Internalname,GXutil.rtrim( AV115Eliminar),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,145);\"" : " "),"'"+""+"'"+",false,"+"'"+"e272k2_client"+"'","","","","",edtavEliminar_Jsonclick,Integer.valueOf(7),edtavEliminar_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavEliminar_Visible),Integer.valueOf(edtavEliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 146,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV186EliminarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,146);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVELIMINARSVG.CLICK."+sGXsfl_108_idx+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(5),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 147,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV184VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,147);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 148,'',false,'"+sGXsfl_108_idx+"',108)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV185ModificarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,148);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2K2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_108_idx = ((subGrid_Islastpage==1)&&(nGXsfl_108_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_108_idx+1) ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
      }
      /* End function sendrow_1082 */
   }

   public void startgridcontrol108( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"108\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEditarformula_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConClasifAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Clasificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConTipoLiqAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((dynConceptoConveCodigo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConVigencia.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aplicación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConVariable.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Rem. Var.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavConformula_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fórmula", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConHabilitado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Habilitado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConObservacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGG_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tratamiento IIGG", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConUsuModFor_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Usuario de Modificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConFchModFor_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de Modificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConRecalcular.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Recalcula Retroactivo en ganancias", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConCondicion.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Condición para liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConSacDeven.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo devengamiento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodAfip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto AFIP", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBasePres.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para presentismo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseAnt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para antiguedad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseFer.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseFerProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseHorExt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseHorExtProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseLic.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseLicProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseOSDif.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para obra social diferencial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Release", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEliminar_Class+"\" "+" style=\""+((edtavEliminar_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV58EditarFormula));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEditarformula_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEditarformula_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEditarformula_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A38SubTipoConCod1));
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
         GridColumn.AddObjectProperty("Value", A970ConClasifAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConClasifAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A503ConTipoLiqAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConTipoLiqAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1645ConceptoConveCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynConceptoConveCodigo.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A162ConVigencia, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConVigencia.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A159ConVariable));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConVariable.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV84ConFormula);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConformula_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavConformula_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavConformula_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A150ConHabilitado));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConHabilitado.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A153ConObservacion);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConObservacion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGG_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A156ConUsuModFor));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConUsuModFor_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.ttoc( A145ConFchModFor, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConFchModFor_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A762ConRecalcular));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConRecalcular.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A953ConCondicion));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConCondicion.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1539ConSacDeven, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConSacDeven.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1648ConCodAfip));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCodAfip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1800ConBasePres, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBasePres.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1801ConBaseAnt, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseAnt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1621ConBaseFer, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseFer.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1798ConBaseFerProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseFerProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1622ConBaseHorExt, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseHorExt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1799ConBaseHorExtProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseHorExtProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1620ConBaseLic, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseLic.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1797ConBaseLicProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseLicProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1827ConBaseOSDif, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseOSDif.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1886ConRelSec, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1905ConRelSecCli, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV178CliReDTChar);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCliredtchar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2013ConRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV187Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV113Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV115Eliminar));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEliminar_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminar_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV186EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV184VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV185ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      divTablefiltros_Internalname = "TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtavEditarformula_Internalname = "vEDITARFORMULA" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtConDescrip_Internalname = "CONDESCRIP" ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD" );
      edtConClasifAux_Internalname = "CONCLASIFAUX" ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX" ;
      dynConceptoConveCodigo.setInternalname( "CONCEPTOCONVECODIGO" );
      cmbConVigencia.setInternalname( "CONVIGENCIA" );
      chkConVariable.setInternalname( "CONVARIABLE" );
      edtavConformula_Internalname = "vCONFORMULA" ;
      chkConHabilitado.setInternalname( "CONHABILITADO" );
      edtConObservacion_Internalname = "CONOBSERVACION" ;
      edtAplIIGG_Internalname = "APLIIGG" ;
      edtConUsuModFor_Internalname = "CONUSUMODFOR" ;
      edtConFchModFor_Internalname = "CONFCHMODFOR" ;
      chkConRecalcular.setInternalname( "CONRECALCULAR" );
      cmbConCondicion.setInternalname( "CONCONDICION" );
      cmbConSacDeven.setInternalname( "CONSACDEVEN" );
      edtConCodAfip_Internalname = "CONCODAFIP" ;
      cmbConBasePres.setInternalname( "CONBASEPRES" );
      cmbConBaseAnt.setInternalname( "CONBASEANT" );
      cmbConBaseFer.setInternalname( "CONBASEFER" );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM" );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT" );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM" );
      cmbConBaseLic.setInternalname( "CONBASELIC" );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM" );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF" );
      edtConRelSec_Internalname = "CONRELSEC" ;
      edtConRelSecCli_Internalname = "CONRELSECCLI" ;
      edtavCliredtchar_Internalname = "vCLIREDTCHAR" ;
      edtConRelRef_Internalname = "CONRELREF" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavEliminar_Internalname = "vELIMINAR" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtnimportarconceptos_Internalname = "BTNIMPORTARCONCEPTOS" ;
      bttBtnuseraction1_Internalname = "BTNUSERACTION1" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Dvelop_confirmpanel_eliminar_Internalname = "DVELOP_CONFIRMPANEL_ELIMINAR" ;
      tblTabledvelop_confirmpanel_eliminar_Internalname = "TABLEDVELOP_CONFIRMPANEL_ELIMINAR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_confchmodforauxdatetext_Internalname = "vDDO_CONFCHMODFORAUXDATETEXT" ;
      Tfconfchmodfor_rangepicker_Internalname = "TFCONFCHMODFOR_RANGEPICKER" ;
      divDdo_confchmodforauxdates_Internalname = "DDO_CONFCHMODFORAUXDATES" ;
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
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 1 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 1 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavEliminar_Jsonclick = "" ;
      edtavEliminar_Class = "Attribute" ;
      edtavEliminar_Enabled = 1 ;
      edtavEliminar_Visible = -1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtConRelRef_Jsonclick = "" ;
      edtavCliredtchar_Jsonclick = "" ;
      edtavCliredtchar_Visible = 0 ;
      edtavCliredtchar_Enabled = 1 ;
      edtConRelSecCli_Jsonclick = "" ;
      edtConRelSec_Jsonclick = "" ;
      cmbConBaseOSDif.setJsonclick( "" );
      cmbConBaseLicProm.setJsonclick( "" );
      cmbConBaseLic.setJsonclick( "" );
      cmbConBaseHorExtProm.setJsonclick( "" );
      cmbConBaseHorExt.setJsonclick( "" );
      cmbConBaseFerProm.setJsonclick( "" );
      cmbConBaseFer.setJsonclick( "" );
      cmbConBaseAnt.setJsonclick( "" );
      cmbConBasePres.setJsonclick( "" );
      edtConCodAfip_Jsonclick = "" ;
      cmbConSacDeven.setJsonclick( "" );
      cmbConCondicion.setJsonclick( "" );
      chkConRecalcular.setCaption( "" );
      edtConFchModFor_Jsonclick = "" ;
      edtConUsuModFor_Jsonclick = "" ;
      edtAplIIGG_Jsonclick = "" ;
      edtConObservacion_Jsonclick = "" ;
      chkConHabilitado.setCaption( "" );
      edtavConformula_Jsonclick = "" ;
      edtavConformula_Tooltiptext = "" ;
      edtavConformula_Enabled = 1 ;
      chkConVariable.setCaption( "" );
      cmbConVigencia.setJsonclick( "" );
      dynConceptoConveCodigo.setJsonclick( "" );
      edtConTipoLiqAux_Jsonclick = "" ;
      edtConClasifAux_Jsonclick = "" ;
      cmbTipoConCod.setJsonclick( "" );
      edtConDescrip_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
      edtSubTipoConCod1_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtavEditarformula_Jsonclick = "" ;
      edtavEditarformula_Class = "Attribute" ;
      edtavEditarformula_Visible = -1 ;
      edtavEditarformula_Link = "" ;
      edtavEditarformula_Enabled = 1 ;
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
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      edtavEliminar_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtavEliminarsvg_Visible = -1 ;
      edtConRelRef_Visible = -1 ;
      cmbConBaseOSDif.setVisible( -1 );
      cmbConBaseLicProm.setVisible( -1 );
      cmbConBaseLic.setVisible( -1 );
      cmbConBaseHorExtProm.setVisible( -1 );
      cmbConBaseHorExt.setVisible( -1 );
      cmbConBaseFerProm.setVisible( -1 );
      cmbConBaseFer.setVisible( -1 );
      cmbConBaseAnt.setVisible( -1 );
      cmbConBasePres.setVisible( -1 );
      edtConCodAfip_Visible = -1 ;
      cmbConSacDeven.setVisible( -1 );
      cmbConCondicion.setVisible( -1 );
      chkConRecalcular.setVisible( -1 );
      edtConFchModFor_Visible = -1 ;
      edtConUsuModFor_Visible = -1 ;
      edtAplIIGG_Visible = -1 ;
      edtConObservacion_Visible = -1 ;
      chkConHabilitado.setVisible( -1 );
      edtavConformula_Visible = -1 ;
      chkConVariable.setVisible( -1 );
      cmbConVigencia.setVisible( -1 );
      dynConceptoConveCodigo.setVisible( -1 );
      edtConTipoLiqAux_Visible = -1 ;
      edtConClasifAux_Visible = -1 ;
      cmbTipoConCod.setVisible( -1 );
      edtConDescrip_Visible = -1 ;
      edtConCodigo_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_confchmodforauxdatetext_Jsonclick = "" ;
      bttBtnimportarconceptos_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Dvelop_confirmpanel_eliminar_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = "mensaje" ;
      Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "titulo", "") ;
      Ddo_grid_Datalistproc = "ConceptoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención,CAL_ARG:Cálculo||||0:Automática,1:Por Novedad|1:WWP_TSChecked,2:WWP_TSUnChecked||1:WWP_TSChecked,2:WWP_TSUnChecked||1:Totalmente Gravado,2:Totalmente Exento,3:Parcialmente Exento. La aplicación de los topes y validaciones particulares se hace sobre fórmulas y procesos internos (horas extras\\\\, bonos\\\\, etc),0:No Aplica|||1:WWP_TSChecked,2:WWP_TSUnChecked|A0:Siempre,A1:Se ingresó por novedad el concepto de código relacionado a la condición,A3:Trabajador no es Jubilado y aplica a liquidación de aportes,A4:Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO\\\\, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto,A5:Es alcanzado por ganancias y calcula adelanto de retención (parámetro),A8:Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior,A9:Tiene familiares adherentes a la obra social,A10:Tiene Sindicato,A11:Tiene jornada parcial,A12:Obra social tiene aporte adicional,A13:Empleador es agente de retención,A14:El empleador es agente de retención y el empleado es alcanzado por ganancias,B1:Legajo tiene cargado licencia igual al código  relacionado a la condición,B2:Legajo tiene cargado SIRADIG de igual código  relacionado a la condición,B3:Tiene obligación activa de igual al código relacionado a la condición,B4:Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal,B5:Hay feriado no trabajado\\\\, y la empresa está configurada para exponer los feriados,B6:Hay día no laborable em periodo\\\\, y la empresa está configurada para exponer los feriados,B7:Hay licencia sin goce de sueldo\\\\, y el empleado es de clase mensual,B9:Es egreso y no maneja fondo de cese laboral,B10:Tipo de liquidación\\\\, mes de liquidación\\\\, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.,B11:Liquida sac o alcanza ganancias,B12:Empresa o convenio liquidan antiguedad,B13:Empresa o convenio liquidan presentismo,B14:Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición,B15:Legajo tiene cargado hijo o hija con asignación de servicio de guardería,N01:Nunca  (Calcular siempre en segundo plano luego de generar el recibo),B16:Legajo es de clase mensual y el concepto no fué previamente liquidado en el mismo periodo,B19:Legajo es de clase mensual\\\\, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo,B20:Legajo es de clase mensual\\\\, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo,B21:Legajo es de clase mensual\\\\, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo,B22:Legajo es de clase mensual\\\\, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo,B23:Legajo tiene asignado tìtulo igual al código relacionado a la condición,B24:Parametro para desglosar adicional está activado\\\\, legajo está en convenio y su categoría tiene adicional por zona desfavorable,VP:Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal,AI:Legajo es de clase mensual y tiene cargadas ausencias injustificadas,R1:Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo,MI:Legajo es de clase mensual\\\\, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes,H1:Si liquidación es compatible con SAC liquidar como concepto principal\\\\, y si no liquidarlo como concepto auxiliar en segundo plano,LA:Legajo aplica a liquidación de aportes,GU:Legajo tiene configurado grossing up|0:No aplica,1:Mensual,3:Trimestral,4:Cuatrimestral,6:Semestral,12:Anual||0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí. Recalcular proporcional a jornada completa,2:Sí\\\\, el valor liquidado,3:Sí\\\\, el valor liquidado proporcional a jornada completa|" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|T|T|T|T||||T|T||||T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|FixedValues|Dynamic|Dynamic|Dynamic|FixedValues|FixedValues||FixedValues|Dynamic|FixedValues|||FixedValues|FixedValues|FixedValues|Dynamic|FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "T|T|T|T|T|T|T|T||T|T|T|||T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Filterisrange = "|||||||||||||P||||||||||||||" ;
      Ddo_grid_Filtertype = "Character|Character||Character|Character|Character|||Character||Character|Numeric||Date||||Character||||||||||Character" ;
      Ddo_grid_Includefilter = "T|T||T|T|T|||T||T|T||T||||T||||||||||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T||||||||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7||||||||8|9|10|11|12|13|14|15|16|17|18|19|20|21|22" ;
      Ddo_grid_Columnids = "3:ConCodigo|4:ConDescrip|5:TipoConCod|6:ConClasifAux|7:ConTipoLiqAux|8:ConceptoConveCodigo|9:ConVigencia|10:ConVariable|11:ConFormula|12:ConHabilitado|13:ConObservacion|14:AplIIGG|15:ConUsuModFor|16:ConFchModFor|17:ConRecalcular|18:ConCondicion|19:ConSacDeven|20:ConCodAfip|21:ConBasePres|22:ConBaseAnt|23:ConBaseFer|24:ConBaseFerProm|25:ConBaseHorExt|26:ConBaseHorExtProm|27:ConBaseLic|28:ConBaseLicProm|29:ConBaseOSDif|33:ConRelRef" ;
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
      Form.setCaption( httpContext.getMessage( " Conceptos", "") );
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
      AV190WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV190WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV190WelcomeMessage_NoMostrarMas", AV190WelcomeMessage_NoMostrarMas);
      GXCCtl = "TIPOCONCOD_" + sGXsfl_108_idx ;
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
      GXCCtl = "CONCEPTOCONVECODIGO_" + sGXsfl_108_idx ;
      dynConceptoConveCodigo.setName( GXCCtl );
      dynConceptoConveCodigo.setWebtags( "" );
      GXCCtl = "CONVIGENCIA_" + sGXsfl_108_idx ;
      cmbConVigencia.setName( GXCCtl );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
      }
      GXCCtl = "CONVARIABLE_" + sGXsfl_108_idx ;
      chkConVariable.setName( GXCCtl );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), !bGXsfl_108_Refreshing);
      chkConVariable.setCheckedValue( "false" );
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      GXCCtl = "CONHABILITADO_" + sGXsfl_108_idx ;
      chkConHabilitado.setName( GXCCtl );
      chkConHabilitado.setWebtags( "" );
      chkConHabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConHabilitado.getInternalname(), "TitleCaption", chkConHabilitado.getCaption(), !bGXsfl_108_Refreshing);
      chkConHabilitado.setCheckedValue( "false" );
      A150ConHabilitado = GXutil.strtobool( GXutil.booltostr( A150ConHabilitado)) ;
      GXCCtl = "CONRECALCULAR_" + sGXsfl_108_idx ;
      chkConRecalcular.setName( GXCCtl );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), !bGXsfl_108_Refreshing);
      chkConRecalcular.setCheckedValue( "false" );
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      GXCCtl = "CONCONDICION_" + sGXsfl_108_idx ;
      cmbConCondicion.setName( GXCCtl );
      cmbConCondicion.setWebtags( "" );
      cmbConCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbConCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbConCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbConCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbConCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbConCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbConCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbConCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbConCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbConCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbConCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbConCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbConCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbConCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbConCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbConCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbConCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbConCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbConCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbConCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbConCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbConCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
      }
      GXCCtl = "CONSACDEVEN_" + sGXsfl_108_idx ;
      cmbConSacDeven.setName( GXCCtl );
      cmbConSacDeven.setWebtags( "" );
      cmbConSacDeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
      cmbConSacDeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConSacDeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
      cmbConSacDeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
      cmbConSacDeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
      cmbConSacDeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
      if ( cmbConSacDeven.getItemCount() > 0 )
      {
         A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
      }
      GXCCtl = "CONBASEPRES_" + sGXsfl_108_idx ;
      cmbConBasePres.setName( GXCCtl );
      cmbConBasePres.setWebtags( "" );
      cmbConBasePres.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBasePres.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBasePres.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBasePres.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBasePres.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBasePres.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBasePres.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBasePres.getItemCount() > 0 )
      {
         A1800ConBasePres = (byte)(GXutil.lval( cmbConBasePres.getValidValue(GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0))))) ;
      }
      GXCCtl = "CONBASEANT_" + sGXsfl_108_idx ;
      cmbConBaseAnt.setName( GXCCtl );
      cmbConBaseAnt.setWebtags( "" );
      cmbConBaseAnt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseAnt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseAnt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseAnt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseAnt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseAnt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseAnt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseAnt.getItemCount() > 0 )
      {
         A1801ConBaseAnt = (byte)(GXutil.lval( cmbConBaseAnt.getValidValue(GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0))))) ;
      }
      GXCCtl = "CONBASEFER_" + sGXsfl_108_idx ;
      cmbConBaseFer.setName( GXCCtl );
      cmbConBaseFer.setWebtags( "" );
      cmbConBaseFer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseFer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseFer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseFer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseFer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseFer.getItemCount() > 0 )
      {
         A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
      }
      GXCCtl = "CONBASEFERPROM_" + sGXsfl_108_idx ;
      cmbConBaseFerProm.setName( GXCCtl );
      cmbConBaseFerProm.setWebtags( "" );
      cmbConBaseFerProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseFerProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseFerProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseFerProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseFerProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseFerProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseFerProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseFerProm.getItemCount() > 0 )
      {
         A1798ConBaseFerProm = (byte)(GXutil.lval( cmbConBaseFerProm.getValidValue(GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASEHOREXT_" + sGXsfl_108_idx ;
      cmbConBaseHorExt.setName( GXCCtl );
      cmbConBaseHorExt.setWebtags( "" );
      cmbConBaseHorExt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseHorExt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseHorExt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseHorExt.getItemCount() > 0 )
      {
         A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
      }
      GXCCtl = "CONBASEHOREXTPROM_" + sGXsfl_108_idx ;
      cmbConBaseHorExtProm.setName( GXCCtl );
      cmbConBaseHorExtProm.setWebtags( "" );
      cmbConBaseHorExtProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseHorExtProm.getItemCount() > 0 )
      {
         A1799ConBaseHorExtProm = (byte)(GXutil.lval( cmbConBaseHorExtProm.getValidValue(GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASELIC_" + sGXsfl_108_idx ;
      cmbConBaseLic.setName( GXCCtl );
      cmbConBaseLic.setWebtags( "" );
      cmbConBaseLic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseLic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseLic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseLic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseLic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseLic.getItemCount() > 0 )
      {
         A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
      }
      GXCCtl = "CONBASELICPROM_" + sGXsfl_108_idx ;
      cmbConBaseLicProm.setName( GXCCtl );
      cmbConBaseLicProm.setWebtags( "" );
      cmbConBaseLicProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseLicProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseLicProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseLicProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseLicProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseLicProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseLicProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseLicProm.getItemCount() > 0 )
      {
         A1797ConBaseLicProm = (byte)(GXutil.lval( cmbConBaseLicProm.getValidValue(GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASEOSDIF_" + sGXsfl_108_idx ;
      cmbConBaseOSDif.setName( GXCCtl );
      cmbConBaseOSDif.setWebtags( "" );
      cmbConBaseOSDif.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseOSDif.addItem("1", httpContext.getMessage( "Sí. Recalcular proporcional a jornada completa", ""), (short)(0));
      cmbConBaseOSDif.addItem("2", httpContext.getMessage( "Sí, el valor liquidado", ""), (short)(0));
      cmbConBaseOSDif.addItem("3", httpContext.getMessage( "Sí, el valor liquidado proporcional a jornada completa", ""), (short)(0));
      if ( cmbConBaseOSDif.getItemCount() > 0 )
      {
         A1827ConBaseOSDif = (byte)(GXutil.lval( cmbConBaseOSDif.getValidValue(GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0))))) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'dynConceptoConveCodigo'},{av:'cmbConVigencia'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'edtavConformula_Visible',ctrl:'vCONFORMULA',prop:'Visible'},{av:'chkConHabilitado.getVisible()',ctrl:'CONHABILITADO',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtConUsuModFor_Visible',ctrl:'CONUSUMODFOR',prop:'Visible'},{av:'edtConFchModFor_Visible',ctrl:'CONFCHMODFOR',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'cmbConCondicion'},{av:'cmbConSacDeven'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseOSDif'},{av:'edtConRelRef_Visible',ctrl:'CONRELREF',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNIMPORTARCONCEPTOS',prop:'Visible'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV123ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e142K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e152K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e162K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV199TFConRelRef_SelsJson',fld:'vTFCONRELREF_SELSJSON',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV169TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV167TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV165TFConBaseLic_SelsJson',fld:'vTFCONBASELIC_SELSJSON',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV163TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV161TFConBaseHorExt_SelsJson',fld:'vTFCONBASEHOREXT_SELSJSON',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV159TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV157TFConBaseFer_SelsJson',fld:'vTFCONBASEFER_SELSJSON',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV155TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV153TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV148TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV139TFConSacDeven_SelsJson',fld:'vTFCONSACDEVEN_SELSJSON',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV132TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV134TFAplIIGG_SelsJson',fld:'vTFAPLIIGG_SELSJSON',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV65TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV34TFConVigencia_SelsJson',fld:'vTFCONVIGENCIA_SELSJSON',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV145TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV103TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV126TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV61TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV59TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e242K2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A921ConPadre',fld:'CONPADRE',pic:''},{av:'A1905ConRelSecCli',fld:'CONRELSECCLI',pic:'ZZZZZ9'},{av:'A1886ConRelSec',fld:'CONRELSEC',pic:'ZZZZZ9'},{av:'A148ConFormula',fld:'CONFORMULA',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavEliminar_Visible',ctrl:'vELIMINAR',prop:'Visible'},{av:'AV58EditarFormula',fld:'vEDITARFORMULA',pic:''},{av:'edtavEditarformula_Class',ctrl:'vEDITARFORMULA',prop:'Class'},{av:'AV187Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV113Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV115Eliminar',fld:'vELIMINAR',pic:''},{av:'edtavEliminar_Class',ctrl:'vELIMINAR',prop:'Class'},{av:'AV84ConFormula',fld:'vCONFORMULA',pic:''},{av:'AV178CliReDTChar',fld:'vCLIREDTCHAR',pic:''},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV186EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV184VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV185ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavConformula_Tooltiptext',ctrl:'vCONFORMULA',prop:'Tooltiptext'},{av:'edtavEditarformula_Link',ctrl:'vEDITARFORMULA',prop:'Link'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e122K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'dynConceptoConveCodigo'},{av:'cmbConVigencia'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'edtavConformula_Visible',ctrl:'vCONFORMULA',prop:'Visible'},{av:'chkConHabilitado.getVisible()',ctrl:'CONHABILITADO',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtConUsuModFor_Visible',ctrl:'CONUSUMODFOR',prop:'Visible'},{av:'edtConFchModFor_Visible',ctrl:'CONFCHMODFOR',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'cmbConCondicion'},{av:'cmbConSacDeven'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseOSDif'},{av:'edtConRelRef_Visible',ctrl:'CONRELREF',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNIMPORTARCONCEPTOS',prop:'Visible'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV123ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e132K2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV59TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV61TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV80TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV126TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV103TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV145TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV34TFConVigencia_SelsJson',fld:'vTFCONVIGENCIA_SELSJSON',pic:''},{av:'AV65TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV134TFAplIIGG_SelsJson',fld:'vTFAPLIIGG_SELSJSON',pic:''},{av:'AV132TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV139TFConSacDeven_SelsJson',fld:'vTFCONSACDEVEN_SELSJSON',pic:''},{av:'AV148TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV153TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV155TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV157TFConBaseFer_SelsJson',fld:'vTFCONBASEFER_SELSJSON',pic:''},{av:'AV159TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV161TFConBaseHorExt_SelsJson',fld:'vTFCONBASEHOREXT_SELSJSON',pic:''},{av:'AV163TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV165TFConBaseLic_SelsJson',fld:'vTFCONBASELIC_SELSJSON',pic:''},{av:'AV167TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV169TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV199TFConRelRef_SelsJson',fld:'vTFCONRELREF_SELSJSON',pic:''},{av:'AV48DDO_ConFchModForAuxDate',fld:'vDDO_CONFCHMODFORAUXDATE',pic:''},{av:'AV49DDO_ConFchModForAuxDateTo',fld:'vDDO_CONFCHMODFORAUXDATETO',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV199TFConRelRef_SelsJson',fld:'vTFCONRELREF_SELSJSON',pic:''},{av:'AV169TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV167TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV165TFConBaseLic_SelsJson',fld:'vTFCONBASELIC_SELSJSON',pic:''},{av:'AV163TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV161TFConBaseHorExt_SelsJson',fld:'vTFCONBASEHOREXT_SELSJSON',pic:''},{av:'AV159TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV157TFConBaseFer_SelsJson',fld:'vTFCONBASEFER_SELSJSON',pic:''},{av:'AV155TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV153TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV148TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV139TFConSacDeven_SelsJson',fld:'vTFCONSACDEVEN_SELSJSON',pic:''},{av:'AV132TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV48DDO_ConFchModForAuxDate',fld:'vDDO_CONFCHMODFORAUXDATE',pic:''},{av:'AV49DDO_ConFchModForAuxDateTo',fld:'vDDO_CONFCHMODFORAUXDATETO',pic:''},{av:'AV134TFAplIIGG_SelsJson',fld:'vTFAPLIIGG_SELSJSON',pic:''},{av:'AV65TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV34TFConVigencia_SelsJson',fld:'vTFCONVIGENCIA_SELSJSON',pic:''},{av:'AV145TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV103TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV126TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV80TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV61TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV59TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'dynConceptoConveCodigo'},{av:'cmbConVigencia'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'edtavConformula_Visible',ctrl:'vCONFORMULA',prop:'Visible'},{av:'chkConHabilitado.getVisible()',ctrl:'CONHABILITADO',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtConUsuModFor_Visible',ctrl:'CONUSUMODFOR',prop:'Visible'},{av:'edtConFchModFor_Visible',ctrl:'CONFCHMODFOR',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'cmbConCondicion'},{av:'cmbConSacDeven'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseOSDif'},{av:'edtConRelRef_Visible',ctrl:'CONRELREF',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNIMPORTARCONCEPTOS',prop:'Visible'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV123ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOIMPORTARCONCEPTOS'","{handler:'e112K1',iparms:[]");
      setEventMetadata("'DOIMPORTARCONCEPTOS'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION1'","{handler:'e182K2',iparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOUSERACTION1'",",oparms:[]}");
      setEventMetadata("VELIMINAR.CLICK","{handler:'e272K2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true}]");
      setEventMetadata("VELIMINAR.CLICK",",oparms:[{av:'AV111CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV112ConCodigo_Selected',fld:'vCONCODIGO_SELECTED',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE","{handler:'e172K2',iparms:[{av:'Dvelop_confirmpanel_eliminar_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV214Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV23TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV60TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV25TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV62TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV81TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV127TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV128TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV104TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV105TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV146TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV147TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV35TFConVigencia_Sels',fld:'vTFCONVIGENCIA_SELS',pic:''},{av:'AV36TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV38TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV27TFConHabilitado_Sel',fld:'vTFCONHABILITADO_SEL',pic:'9'},{av:'AV40TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV66TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV135TFAplIIGG_Sels',fld:'vTFAPLIIGG_SELS',pic:''},{av:'AV46TFConFchModFor',fld:'vTFCONFCHMODFOR',pic:'99/99/99 99:99'},{av:'AV47TFConFchModFor_To',fld:'vTFCONFCHMODFOR_TO',pic:'99/99/99 99:99'},{av:'AV120TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV133TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV140TFConSacDeven_Sels',fld:'vTFCONSACDEVEN_SELS',pic:''},{av:'AV149TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV150TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV154TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV156TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV158TFConBaseFer_Sels',fld:'vTFCONBASEFER_SELS',pic:''},{av:'AV160TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV162TFConBaseHorExt_Sels',fld:'vTFCONBASEHOREXT_SELS',pic:''},{av:'AV164TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV166TFConBaseLic_Sels',fld:'vTFCONBASELIC_SELS',pic:''},{av:'AV168TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV170TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true},{av:'AV111CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV112ConCodigo_Selected',fld:'vCONCODIGO_SELECTED',pic:''}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE",",oparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV125ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'dynConceptoConveCodigo'},{av:'cmbConVigencia'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'edtavConformula_Visible',ctrl:'vCONFORMULA',prop:'Visible'},{av:'chkConHabilitado.getVisible()',ctrl:'CONHABILITADO',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtConUsuModFor_Visible',ctrl:'CONUSUMODFOR',prop:'Visible'},{av:'edtConFchModFor_Visible',ctrl:'CONFCHMODFOR',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'cmbConCondicion'},{av:'cmbConSacDeven'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseOSDif'},{av:'edtConRelRef_Visible',ctrl:'CONRELREF',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV53GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV54GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNIMPORTARCONCEPTOS',prop:'Visible'},{av:'AV191IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV74IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV123ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV200TFConRelRef',fld:'vTFCONRELREF',pic:''},{av:'AV201TFConRelRef_Sels',fld:'vTFCONRELREF_SELS',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e212K2',iparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e192K2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e202K2',iparms:[{av:'AV190WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV188MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e262K1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VELIMINARSVG.CLICK","{handler:'e252K2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true},{av:'AV138TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true}]");
      setEventMetadata("VELIMINARSVG.CLICK",",oparms:[{av:'Dvelop_confirmpanel_eliminar_Title',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Title'},{av:'Dvelop_confirmpanel_eliminar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'ConfirmationText'}]}");
      setEventMetadata("VALID_CONCEPTOCONVECODIGO","{handler:'valid_Conceptoconvecodigo',iparms:[]");
      setEventMetadata("VALID_CONCEPTOCONVECODIGO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Modificarsvg',iparms:[]");
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
      wcpOAV188MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Dvelop_confirmpanel_eliminar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV188MenuOpcCod = "" ;
      AV20ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV214Pgmname = "" ;
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23TFConCodigo = "" ;
      AV60TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFConDescrip = "" ;
      AV62TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV127TFConClasifAux = "" ;
      AV128TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104TFConTipoLiqAux = "" ;
      AV105TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV146TFConceptoConveCodigo = "" ;
      AV147TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFConVigencia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV38TFConFormula = "" ;
      AV40TFConObservacion = "" ;
      AV66TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV135TFAplIIGG_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV46TFConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      AV47TFConFchModFor_To = GXutil.resetTime( GXutil.nullDate() );
      AV133TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV140TFConSacDeven_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV149TFConCodAfip = "" ;
      AV150TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV154TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV156TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV158TFConBaseFer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV160TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV162TFConBaseHorExt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV164TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV166TFConBaseLic_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV168TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV170TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV200TFConRelRef = "" ;
      AV201TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV138TipoConCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV51DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV123ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV55GridAppliedFilters = "" ;
      AV48DDO_ConFchModForAuxDate = GXutil.nullDate() ;
      AV49DDO_ConFchModForAuxDateTo = GXutil.nullDate() ;
      A921ConPadre = "" ;
      A148ConFormula = "" ;
      AV59TFConCodigo_SelsJson = "" ;
      AV61TFConDescrip_SelsJson = "" ;
      AV80TFTipoConCod_SelsJson = "" ;
      AV126TFConClasifAux_SelsJson = "" ;
      AV103TFConTipoLiqAux_SelsJson = "" ;
      AV145TFConceptoConveCodigo_SelsJson = "" ;
      AV34TFConVigencia_SelsJson = "" ;
      AV65TFConObservacion_SelsJson = "" ;
      AV134TFAplIIGG_SelsJson = "" ;
      AV132TFConCondicion_SelsJson = "" ;
      AV139TFConSacDeven_SelsJson = "" ;
      AV148TFConCodAfip_SelsJson = "" ;
      AV153TFConBasePres_SelsJson = "" ;
      AV155TFConBaseAnt_SelsJson = "" ;
      AV157TFConBaseFer_SelsJson = "" ;
      AV159TFConBaseFerProm_SelsJson = "" ;
      AV161TFConBaseHorExt_SelsJson = "" ;
      AV163TFConBaseHorExtProm_SelsJson = "" ;
      AV165TFConBaseLic_SelsJson = "" ;
      AV167TFConBaseLicProm_SelsJson = "" ;
      AV169TFConBaseOSDif_SelsJson = "" ;
      AV199TFConRelRef_SelsJson = "" ;
      AV112ConCodigo_Selected = "" ;
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
      TempTags = "" ;
      bttBtnimportarconceptos_Jsonclick = "" ;
      bttBtnuseraction1_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV50DDO_ConFchModForAuxDateText = "" ;
      ucTfconfchmodfor_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV58EditarFormula = "" ;
      A38SubTipoConCod1 = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A970ConClasifAux = "" ;
      A503ConTipoLiqAux = "" ;
      A1645ConceptoConveCodigo = "" ;
      AV84ConFormula = "" ;
      A153ConObservacion = "" ;
      A156ConUsuModFor = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A953ConCondicion = "" ;
      A1648ConCodAfip = "" ;
      AV178CliReDTChar = "" ;
      A2013ConRelRef = "" ;
      AV187Display = "" ;
      AV113Update = "" ;
      AV115Eliminar = "" ;
      AV186EliminarSVG = "" ;
      AV184VerSVG = "" ;
      AV185ModificarSVG = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H002K2_A1644ConceptoPais = new short[1] ;
      H002K2_n1644ConceptoPais = new boolean[] {false} ;
      H002K2_A1645ConceptoConveCodigo = new String[] {""} ;
      H002K2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      H002K2_A160ConveDescri = new String[] {""} ;
      H002K2_n160ConveDescri = new boolean[] {false} ;
      AV216Conceptowwds_2_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV218Conceptowwds_4_tfcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV219Conceptowwds_5_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV221Conceptowwds_7_tfconclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV223Conceptowwds_9_tfcontipoliqaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV225Conceptowwds_11_tfconceptoconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV226Conceptowwds_12_tfconvigencia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV231Conceptowwds_17_tfconobservacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV232Conceptowwds_18_tfapliigg_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV236Conceptowwds_22_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV237Conceptowwds_23_tfconsacdeven_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV239Conceptowwds_25_tfconcodafip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV240Conceptowwds_26_tfconbasepres_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV241Conceptowwds_27_tfconbaseant_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV242Conceptowwds_28_tfconbasefer_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV243Conceptowwds_29_tfconbaseferprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV244Conceptowwds_30_tfconbasehorext_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV245Conceptowwds_31_tfconbasehorextprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV246Conceptowwds_32_tfconbaselic_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV247Conceptowwds_33_tfconbaselicprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV248Conceptowwds_34_tfconbaseosdif_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV250Conceptowwds_36_tfconrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV215Conceptowwds_1_tfconcodigo = "" ;
      lV217Conceptowwds_3_tfcondescrip = "" ;
      lV220Conceptowwds_6_tfconclasifaux = "" ;
      lV222Conceptowwds_8_tfcontipoliqaux = "" ;
      lV224Conceptowwds_10_tfconceptoconvecodigo = "" ;
      lV230Conceptowwds_16_tfconobservacion = "" ;
      lV238Conceptowwds_24_tfconcodafip = "" ;
      lV249Conceptowwds_35_tfconrelref = "" ;
      lV38TFConFormula = "" ;
      AV215Conceptowwds_1_tfconcodigo = "" ;
      AV217Conceptowwds_3_tfcondescrip = "" ;
      AV220Conceptowwds_6_tfconclasifaux = "" ;
      AV222Conceptowwds_8_tfcontipoliqaux = "" ;
      AV224Conceptowwds_10_tfconceptoconvecodigo = "" ;
      AV230Conceptowwds_16_tfconobservacion = "" ;
      AV233Conceptowwds_19_tfconfchmodfor = GXutil.resetTime( GXutil.nullDate() );
      AV234Conceptowwds_20_tfconfchmodfor_to = GXutil.resetTime( GXutil.nullDate() );
      AV238Conceptowwds_24_tfconcodafip = "" ;
      AV249Conceptowwds_35_tfconrelref = "" ;
      A160ConveDescri = "" ;
      H002K3_A1644ConceptoPais = new short[1] ;
      H002K3_n1644ConceptoPais = new boolean[] {false} ;
      H002K3_A160ConveDescri = new String[] {""} ;
      H002K3_n160ConveDescri = new boolean[] {false} ;
      H002K3_A895ConTipoOrden = new short[1] ;
      H002K3_A921ConPadre = new String[] {""} ;
      H002K3_n921ConPadre = new boolean[] {false} ;
      H002K3_A148ConFormula = new String[] {""} ;
      H002K3_n148ConFormula = new boolean[] {false} ;
      H002K3_A2013ConRelRef = new String[] {""} ;
      H002K3_A1905ConRelSecCli = new int[1] ;
      H002K3_A1886ConRelSec = new int[1] ;
      H002K3_A1827ConBaseOSDif = new byte[1] ;
      H002K3_A1797ConBaseLicProm = new byte[1] ;
      H002K3_A1620ConBaseLic = new byte[1] ;
      H002K3_A1799ConBaseHorExtProm = new byte[1] ;
      H002K3_A1622ConBaseHorExt = new byte[1] ;
      H002K3_A1798ConBaseFerProm = new byte[1] ;
      H002K3_A1621ConBaseFer = new byte[1] ;
      H002K3_A1801ConBaseAnt = new byte[1] ;
      H002K3_A1800ConBasePres = new byte[1] ;
      H002K3_A1648ConCodAfip = new String[] {""} ;
      H002K3_A1539ConSacDeven = new byte[1] ;
      H002K3_A953ConCondicion = new String[] {""} ;
      H002K3_n953ConCondicion = new boolean[] {false} ;
      H002K3_A762ConRecalcular = new boolean[] {false} ;
      H002K3_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      H002K3_n145ConFchModFor = new boolean[] {false} ;
      H002K3_A156ConUsuModFor = new String[] {""} ;
      H002K3_n156ConUsuModFor = new boolean[] {false} ;
      H002K3_A1112AplIIGG = new short[1] ;
      H002K3_n1112AplIIGG = new boolean[] {false} ;
      H002K3_A153ConObservacion = new String[] {""} ;
      H002K3_A150ConHabilitado = new boolean[] {false} ;
      H002K3_A159ConVariable = new boolean[] {false} ;
      H002K3_A162ConVigencia = new byte[1] ;
      H002K3_A1645ConceptoConveCodigo = new String[] {""} ;
      H002K3_n1645ConceptoConveCodigo = new boolean[] {false} ;
      H002K3_A503ConTipoLiqAux = new String[] {""} ;
      H002K3_n503ConTipoLiqAux = new boolean[] {false} ;
      H002K3_A970ConClasifAux = new String[] {""} ;
      H002K3_n970ConClasifAux = new boolean[] {false} ;
      H002K3_A37TipoConCod = new String[] {""} ;
      H002K3_A41ConDescrip = new String[] {""} ;
      H002K3_A26ConCodigo = new String[] {""} ;
      H002K3_A38SubTipoConCod1 = new String[] {""} ;
      H002K3_n38SubTipoConCod1 = new boolean[] {false} ;
      H002K3_A3CliCod = new int[1] ;
      AV228Conceptowwds_14_tfconformula = "" ;
      H002K4_AGRID_nRecordCount = new long[1] ;
      AV197WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV8HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV192MenuBienveImgURL = "" ;
      AV194MenuBienveTitulo = "" ;
      AV195MenuBienveTexto = "" ;
      AV213Welcomemessage_foto_GXI = "" ;
      AV207observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV144ConveCodigo = "" ;
      AV142ConveDescri = "" ;
      AV152ConceptoConveCodigo = "" ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV18ColumnsSelectorXML = "" ;
      AV206MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV210filtrosTexto = "" ;
      AV72websession = httpContext.getWebSession();
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV124ManageFiltersXml = "" ;
      AV16ExcelFilename = "" ;
      AV17ErrorMessage = "" ;
      AV19UserCustomValue = "" ;
      AV21ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXt_char31 = "" ;
      GXt_char29 = "" ;
      GXv_char30 = new String[1] ;
      GXt_char27 = "" ;
      GXv_char28 = new String[1] ;
      GXt_char25 = "" ;
      GXv_char26 = new String[1] ;
      GXt_char23 = "" ;
      GXv_char24 = new String[1] ;
      GXt_char21 = "" ;
      GXv_char22 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char20 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXv_SdtWWPGridState33 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV193textoNoMostrara = "" ;
      GXv_char32 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_boolean34 = new boolean[1] ;
      AV107sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem35 = new GXBaseCollection[1] ;
      GXv_boolean36 = new boolean[1] ;
      ucDvelop_confirmpanel_eliminar = new com.genexus.webpanels.GXUserControl();
      AV109comentario = "" ;
      AV108item = new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoww__default(),
         new Object[] {
             new Object[] {
            H002K2_A1644ConceptoPais, H002K2_A1645ConceptoConveCodigo, H002K2_A160ConveDescri, H002K2_n160ConveDescri
            }
            , new Object[] {
            H002K3_A1644ConceptoPais, H002K3_n1644ConceptoPais, H002K3_A160ConveDescri, H002K3_n160ConveDescri, H002K3_A895ConTipoOrden, H002K3_A921ConPadre, H002K3_n921ConPadre, H002K3_A148ConFormula, H002K3_n148ConFormula, H002K3_A2013ConRelRef,
            H002K3_A1905ConRelSecCli, H002K3_A1886ConRelSec, H002K3_A1827ConBaseOSDif, H002K3_A1797ConBaseLicProm, H002K3_A1620ConBaseLic, H002K3_A1799ConBaseHorExtProm, H002K3_A1622ConBaseHorExt, H002K3_A1798ConBaseFerProm, H002K3_A1621ConBaseFer, H002K3_A1801ConBaseAnt,
            H002K3_A1800ConBasePres, H002K3_A1648ConCodAfip, H002K3_A1539ConSacDeven, H002K3_A953ConCondicion, H002K3_n953ConCondicion, H002K3_A762ConRecalcular, H002K3_A145ConFchModFor, H002K3_n145ConFchModFor, H002K3_A156ConUsuModFor, H002K3_n156ConUsuModFor,
            H002K3_A1112AplIIGG, H002K3_n1112AplIIGG, H002K3_A153ConObservacion, H002K3_A150ConHabilitado, H002K3_A159ConVariable, H002K3_A162ConVigencia, H002K3_A1645ConceptoConveCodigo, H002K3_n1645ConceptoConveCodigo, H002K3_A503ConTipoLiqAux, H002K3_n503ConTipoLiqAux,
            H002K3_A970ConClasifAux, H002K3_n970ConClasifAux, H002K3_A37TipoConCod, H002K3_A41ConDescrip, H002K3_A26ConCodigo, H002K3_A38SubTipoConCod1, H002K3_n38SubTipoConCod1, H002K3_A3CliCod
            }
            , new Object[] {
            H002K4_AGRID_nRecordCount
            }
         }
      );
      AV214Pgmname = "ConceptoWW" ;
      /* GeneXus formulas. */
      AV214Pgmname = "ConceptoWW" ;
      Gx_err = (short)(0) ;
      edtavEditarformula_Enabled = 0 ;
      edtavConformula_Enabled = 0 ;
      edtavCliredtchar_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavEliminar_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV125ManageFiltersExecutionStep ;
   private byte AV36TFConVariable_Sel ;
   private byte AV27TFConHabilitado_Sel ;
   private byte AV120TFConRecalcular_Sel ;
   private byte gxajaxcallmode ;
   private byte A162ConVigencia ;
   private byte A1539ConSacDeven ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A1827ConBaseOSDif ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV227Conceptowwds_13_tfconvariable_sel ;
   private byte AV229Conceptowwds_15_tfconhabilitado_sel ;
   private byte AV235Conceptowwds_21_tfconrecalcular_sel ;
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
   private short A1112AplIIGG ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1644ConceptoPais ;
   private short A895ConTipoOrden ;
   private short AV143PaiCod ;
   private short AV171esSistemaConceptosDefault ;
   private short GXv_int11[] ;
   private short edtavEliminarsvg_Format ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short AV110i ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV69CliCod ;
   private int AV111CliCod_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtnimportarconceptos_Visible ;
   private int A3CliCod ;
   private int A1886ConRelSec ;
   private int A1905ConRelSecCli ;
   private int gxdynajaxindex ;
   private int subGrid_Islastpage ;
   private int edtavEditarformula_Enabled ;
   private int edtavConformula_Enabled ;
   private int edtavCliredtchar_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavEliminar_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV216Conceptowwds_2_tfconcodigo_sels_size ;
   private int AV218Conceptowwds_4_tfcondescrip_sels_size ;
   private int AV219Conceptowwds_5_tftipoconcod_sels_size ;
   private int AV221Conceptowwds_7_tfconclasifaux_sels_size ;
   private int AV223Conceptowwds_9_tfcontipoliqaux_sels_size ;
   private int AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size ;
   private int AV226Conceptowwds_12_tfconvigencia_sels_size ;
   private int AV231Conceptowwds_17_tfconobservacion_sels_size ;
   private int AV232Conceptowwds_18_tfapliigg_sels_size ;
   private int AV236Conceptowwds_22_tfconcondicion_sels_size ;
   private int AV237Conceptowwds_23_tfconsacdeven_sels_size ;
   private int AV239Conceptowwds_25_tfconcodafip_sels_size ;
   private int AV240Conceptowwds_26_tfconbasepres_sels_size ;
   private int AV241Conceptowwds_27_tfconbaseant_sels_size ;
   private int AV242Conceptowwds_28_tfconbasefer_sels_size ;
   private int AV243Conceptowwds_29_tfconbaseferprom_sels_size ;
   private int AV244Conceptowwds_30_tfconbasehorext_sels_size ;
   private int AV245Conceptowwds_31_tfconbasehorextprom_sels_size ;
   private int AV246Conceptowwds_32_tfconbaselic_sels_size ;
   private int AV247Conceptowwds_33_tfconbaselicprom_sels_size ;
   private int AV248Conceptowwds_34_tfconbaseosdif_sels_size ;
   private int AV250Conceptowwds_36_tfconrelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtConCodigo_Visible ;
   private int edtConDescrip_Visible ;
   private int edtConClasifAux_Visible ;
   private int edtConTipoLiqAux_Visible ;
   private int edtavConformula_Visible ;
   private int edtConObservacion_Visible ;
   private int edtAplIIGG_Visible ;
   private int edtConUsuModFor_Visible ;
   private int edtConFchModFor_Visible ;
   private int edtConCodAfip_Visible ;
   private int edtConRelRef_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV209filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV52PageToGo ;
   private int edtavEliminar_Visible ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int bttBtninsert_Visible ;
   private int AV251GXV1 ;
   private int AV252GXV2 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavEditarformula_Visible ;
   private int edtavCliredtchar_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV53GridCurrentPage ;
   private long AV54GridPageCount ;
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
   private String Dvelop_confirmpanel_eliminar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_108_idx="0001" ;
   private String AV214Pgmname ;
   private String AV23TFConCodigo ;
   private String AV149TFConCodAfip ;
   private String AV138TipoConCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A921ConPadre ;
   private String AV112ConCodigo_Selected ;
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
   private String Dvelop_confirmpanel_eliminar_Title ;
   private String Dvelop_confirmpanel_eliminar_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminar_Confirmtype ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtnimportarconceptos_Internalname ;
   private String bttBtnimportarconceptos_Jsonclick ;
   private String bttBtnuseraction1_Internalname ;
   private String bttBtnuseraction1_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_confchmodforauxdates_Internalname ;
   private String edtavDdo_confchmodforauxdatetext_Internalname ;
   private String edtavDdo_confchmodforauxdatetext_Jsonclick ;
   private String Tfconfchmodfor_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV58EditarFormula ;
   private String edtavEditarformula_Internalname ;
   private String edtCliCod_Internalname ;
   private String A38SubTipoConCod1 ;
   private String edtSubTipoConCod1_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String edtConDescrip_Internalname ;
   private String A37TipoConCod ;
   private String edtConClasifAux_Internalname ;
   private String edtConTipoLiqAux_Internalname ;
   private String A1645ConceptoConveCodigo ;
   private String edtavConformula_Internalname ;
   private String edtConObservacion_Internalname ;
   private String edtAplIIGG_Internalname ;
   private String A156ConUsuModFor ;
   private String edtConUsuModFor_Internalname ;
   private String edtConFchModFor_Internalname ;
   private String A953ConCondicion ;
   private String A1648ConCodAfip ;
   private String edtConCodAfip_Internalname ;
   private String edtConRelSec_Internalname ;
   private String edtConRelSecCli_Internalname ;
   private String edtavCliredtchar_Internalname ;
   private String edtConRelRef_Internalname ;
   private String AV187Display ;
   private String edtavDisplay_Internalname ;
   private String AV113Update ;
   private String edtavUpdate_Internalname ;
   private String AV115Eliminar ;
   private String edtavEliminar_Internalname ;
   private String AV186EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String AV184VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV185ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String lV215Conceptowwds_1_tfconcodigo ;
   private String lV238Conceptowwds_24_tfconcodafip ;
   private String AV215Conceptowwds_1_tfconcodigo ;
   private String AV238Conceptowwds_24_tfconcodafip ;
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
   private String AV207observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String AV144ConveCodigo ;
   private String AV152ConceptoConveCodigo ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavEditarformula_Class ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavEliminar_Class ;
   private String edtavEliminarsvg_Link ;
   private String edtavEliminar_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavConformula_Tooltiptext ;
   private String edtavEditarformula_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXt_char31 ;
   private String GXt_char29 ;
   private String GXv_char30[] ;
   private String GXt_char27 ;
   private String GXv_char28[] ;
   private String GXt_char25 ;
   private String GXv_char26[] ;
   private String GXt_char23 ;
   private String GXv_char24[] ;
   private String GXt_char21 ;
   private String GXv_char22[] ;
   private String GXt_char19 ;
   private String GXv_char20[] ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXv_char32[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String Dvelop_confirmpanel_eliminar_Internalname ;
   private String tblTabledvelop_confirmpanel_eliminar_Internalname ;
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
   private String divTablefiltros_Internalname ;
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
   private String divGridtablewithpaginationbar_Internalname ;
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
   private String sGXsfl_108_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavEditarformula_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtSubTipoConCod1_Jsonclick ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Jsonclick ;
   private String GXCCtl ;
   private String edtConClasifAux_Jsonclick ;
   private String edtConTipoLiqAux_Jsonclick ;
   private String edtavConformula_Jsonclick ;
   private String edtConObservacion_Jsonclick ;
   private String edtAplIIGG_Jsonclick ;
   private String edtConUsuModFor_Jsonclick ;
   private String edtConFchModFor_Jsonclick ;
   private String edtConCodAfip_Jsonclick ;
   private String edtConRelSec_Jsonclick ;
   private String edtConRelSecCli_Jsonclick ;
   private String edtavCliredtchar_Jsonclick ;
   private String edtConRelRef_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavEliminar_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV46TFConFchModFor ;
   private java.util.Date AV47TFConFchModFor_To ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date AV233Conceptowwds_19_tfconfchmodfor ;
   private java.util.Date AV234Conceptowwds_20_tfconfchmodfor_to ;
   private java.util.Date AV48DDO_ConFchModForAuxDate ;
   private java.util.Date AV49DDO_ConFchModForAuxDateTo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV191IsAuthorized_Display ;
   private boolean AV74IsAuthorized_Update ;
   private boolean AV190WelcomeMessage_NoMostrarMas ;
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
   private boolean n38SubTipoConCod1 ;
   private boolean n970ConClasifAux ;
   private boolean n503ConTipoLiqAux ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean A159ConVariable ;
   private boolean A150ConHabilitado ;
   private boolean n1112AplIIGG ;
   private boolean n156ConUsuModFor ;
   private boolean n145ConFchModFor ;
   private boolean A762ConRecalcular ;
   private boolean n953ConCondicion ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean n1644ConceptoPais ;
   private boolean n160ConveDescri ;
   private boolean n921ConPadre ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean AV196MenuBienveVisible ;
   private boolean AV172ClienteConveniador ;
   private boolean gx_refresh_fired ;
   private boolean AV77TempBoolean ;
   private boolean Cond_result ;
   private boolean GXt_boolean12 ;
   private boolean GXv_boolean8[] ;
   private boolean GXv_boolean34[] ;
   private boolean GXv_boolean36[] ;
   private boolean AV197WelcomeMessage_Foto_IsBlob ;
   private String A148ConFormula ;
   private String AV59TFConCodigo_SelsJson ;
   private String AV61TFConDescrip_SelsJson ;
   private String AV80TFTipoConCod_SelsJson ;
   private String AV126TFConClasifAux_SelsJson ;
   private String AV103TFConTipoLiqAux_SelsJson ;
   private String AV145TFConceptoConveCodigo_SelsJson ;
   private String AV34TFConVigencia_SelsJson ;
   private String AV65TFConObservacion_SelsJson ;
   private String AV134TFAplIIGG_SelsJson ;
   private String AV132TFConCondicion_SelsJson ;
   private String AV139TFConSacDeven_SelsJson ;
   private String AV148TFConCodAfip_SelsJson ;
   private String AV153TFConBasePres_SelsJson ;
   private String AV155TFConBaseAnt_SelsJson ;
   private String AV157TFConBaseFer_SelsJson ;
   private String AV159TFConBaseFerProm_SelsJson ;
   private String AV161TFConBaseHorExt_SelsJson ;
   private String AV163TFConBaseHorExtProm_SelsJson ;
   private String AV165TFConBaseLic_SelsJson ;
   private String AV167TFConBaseLicProm_SelsJson ;
   private String AV169TFConBaseOSDif_SelsJson ;
   private String AV199TFConRelRef_SelsJson ;
   private String AV84ConFormula ;
   private String A153ConObservacion ;
   private String AV195MenuBienveTexto ;
   private String AV18ColumnsSelectorXML ;
   private String AV124ManageFiltersXml ;
   private String AV19UserCustomValue ;
   private String AV193textoNoMostrara ;
   private String wcpOAV188MenuOpcCod ;
   private String AV188MenuOpcCod ;
   private String AV25TFConDescrip ;
   private String AV127TFConClasifAux ;
   private String AV104TFConTipoLiqAux ;
   private String AV146TFConceptoConveCodigo ;
   private String AV38TFConFormula ;
   private String AV40TFConObservacion ;
   private String AV200TFConRelRef ;
   private String AV55GridAppliedFilters ;
   private String AV50DDO_ConFchModForAuxDateText ;
   private String A41ConDescrip ;
   private String A970ConClasifAux ;
   private String A503ConTipoLiqAux ;
   private String AV178CliReDTChar ;
   private String A2013ConRelRef ;
   private String lV217Conceptowwds_3_tfcondescrip ;
   private String lV220Conceptowwds_6_tfconclasifaux ;
   private String lV222Conceptowwds_8_tfcontipoliqaux ;
   private String lV224Conceptowwds_10_tfconceptoconvecodigo ;
   private String lV230Conceptowwds_16_tfconobservacion ;
   private String lV249Conceptowwds_35_tfconrelref ;
   private String lV38TFConFormula ;
   private String AV217Conceptowwds_3_tfcondescrip ;
   private String AV220Conceptowwds_6_tfconclasifaux ;
   private String AV222Conceptowwds_8_tfcontipoliqaux ;
   private String AV224Conceptowwds_10_tfconceptoconvecodigo ;
   private String AV230Conceptowwds_16_tfconobservacion ;
   private String AV249Conceptowwds_35_tfconrelref ;
   private String A160ConveDescri ;
   private String AV228Conceptowwds_14_tfconformula ;
   private String AV192MenuBienveImgURL ;
   private String AV194MenuBienveTitulo ;
   private String AV213Welcomemessage_foto_GXI ;
   private String AV142ConveDescri ;
   private String AV206MenuOpcTitulo ;
   private String AV210filtrosTexto ;
   private String AV16ExcelFilename ;
   private String AV17ErrorMessage ;
   private String AV109comentario ;
   private String AV197WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV226Conceptowwds_12_tfconvigencia_sels ;
   private GXSimpleCollection<Byte> AV237Conceptowwds_23_tfconsacdeven_sels ;
   private GXSimpleCollection<Byte> AV240Conceptowwds_26_tfconbasepres_sels ;
   private GXSimpleCollection<Byte> AV241Conceptowwds_27_tfconbaseant_sels ;
   private GXSimpleCollection<Byte> AV242Conceptowwds_28_tfconbasefer_sels ;
   private GXSimpleCollection<Byte> AV243Conceptowwds_29_tfconbaseferprom_sels ;
   private GXSimpleCollection<Byte> AV244Conceptowwds_30_tfconbasehorext_sels ;
   private GXSimpleCollection<Byte> AV245Conceptowwds_31_tfconbasehorextprom_sels ;
   private GXSimpleCollection<Byte> AV246Conceptowwds_32_tfconbaselic_sels ;
   private GXSimpleCollection<Byte> AV247Conceptowwds_33_tfconbaselicprom_sels ;
   private GXSimpleCollection<Byte> AV248Conceptowwds_34_tfconbaseosdif_sels ;
   private GXSimpleCollection<Short> AV232Conceptowwds_18_tfapliigg_sels ;
   private GXSimpleCollection<Byte> AV35TFConVigencia_Sels ;
   private GXSimpleCollection<Byte> AV140TFConSacDeven_Sels ;
   private GXSimpleCollection<Byte> AV154TFConBasePres_Sels ;
   private GXSimpleCollection<Byte> AV156TFConBaseAnt_Sels ;
   private GXSimpleCollection<Byte> AV158TFConBaseFer_Sels ;
   private GXSimpleCollection<Byte> AV160TFConBaseFerProm_Sels ;
   private GXSimpleCollection<Byte> AV162TFConBaseHorExt_Sels ;
   private GXSimpleCollection<Byte> AV164TFConBaseHorExtProm_Sels ;
   private GXSimpleCollection<Byte> AV166TFConBaseLic_Sels ;
   private GXSimpleCollection<Byte> AV168TFConBaseLicProm_Sels ;
   private GXSimpleCollection<Byte> AV170TFConBaseOSDif_Sels ;
   private GXSimpleCollection<Short> AV135TFAplIIGG_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private com.genexus.webpanels.WebSession AV72websession ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfconfchmodfor_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminar ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV216Conceptowwds_2_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV219Conceptowwds_5_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV225Conceptowwds_11_tfconceptoconvecodigo_sels ;
   private GXSimpleCollection<String> AV236Conceptowwds_22_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV239Conceptowwds_25_tfconcodafip_sels ;
   private GXSimpleCollection<String> AV218Conceptowwds_4_tfcondescrip_sels ;
   private GXSimpleCollection<String> AV221Conceptowwds_7_tfconclasifaux_sels ;
   private GXSimpleCollection<String> AV223Conceptowwds_9_tfcontipoliqaux_sels ;
   private GXSimpleCollection<String> AV231Conceptowwds_17_tfconobservacion_sels ;
   private GXSimpleCollection<String> AV250Conceptowwds_36_tfconrelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbTipoConCod ;
   private HTMLChoice dynConceptoConveCodigo ;
   private HTMLChoice cmbConVigencia ;
   private ICheckbox chkConVariable ;
   private ICheckbox chkConHabilitado ;
   private ICheckbox chkConRecalcular ;
   private HTMLChoice cmbConCondicion ;
   private HTMLChoice cmbConSacDeven ;
   private HTMLChoice cmbConBasePres ;
   private HTMLChoice cmbConBaseAnt ;
   private HTMLChoice cmbConBaseFer ;
   private HTMLChoice cmbConBaseFerProm ;
   private HTMLChoice cmbConBaseHorExt ;
   private HTMLChoice cmbConBaseHorExtProm ;
   private HTMLChoice cmbConBaseLic ;
   private HTMLChoice cmbConBaseLicProm ;
   private HTMLChoice cmbConBaseOSDif ;
   private IDataStoreProvider pr_default ;
   private short[] H002K2_A1644ConceptoPais ;
   private boolean[] H002K2_n1644ConceptoPais ;
   private String[] H002K2_A1645ConceptoConveCodigo ;
   private boolean[] H002K2_n1645ConceptoConveCodigo ;
   private String[] H002K2_A160ConveDescri ;
   private boolean[] H002K2_n160ConveDescri ;
   private short[] H002K3_A1644ConceptoPais ;
   private boolean[] H002K3_n1644ConceptoPais ;
   private String[] H002K3_A160ConveDescri ;
   private boolean[] H002K3_n160ConveDescri ;
   private short[] H002K3_A895ConTipoOrden ;
   private String[] H002K3_A921ConPadre ;
   private boolean[] H002K3_n921ConPadre ;
   private String[] H002K3_A148ConFormula ;
   private boolean[] H002K3_n148ConFormula ;
   private String[] H002K3_A2013ConRelRef ;
   private int[] H002K3_A1905ConRelSecCli ;
   private int[] H002K3_A1886ConRelSec ;
   private byte[] H002K3_A1827ConBaseOSDif ;
   private byte[] H002K3_A1797ConBaseLicProm ;
   private byte[] H002K3_A1620ConBaseLic ;
   private byte[] H002K3_A1799ConBaseHorExtProm ;
   private byte[] H002K3_A1622ConBaseHorExt ;
   private byte[] H002K3_A1798ConBaseFerProm ;
   private byte[] H002K3_A1621ConBaseFer ;
   private byte[] H002K3_A1801ConBaseAnt ;
   private byte[] H002K3_A1800ConBasePres ;
   private String[] H002K3_A1648ConCodAfip ;
   private byte[] H002K3_A1539ConSacDeven ;
   private String[] H002K3_A953ConCondicion ;
   private boolean[] H002K3_n953ConCondicion ;
   private boolean[] H002K3_A762ConRecalcular ;
   private java.util.Date[] H002K3_A145ConFchModFor ;
   private boolean[] H002K3_n145ConFchModFor ;
   private String[] H002K3_A156ConUsuModFor ;
   private boolean[] H002K3_n156ConUsuModFor ;
   private short[] H002K3_A1112AplIIGG ;
   private boolean[] H002K3_n1112AplIIGG ;
   private String[] H002K3_A153ConObservacion ;
   private boolean[] H002K3_A150ConHabilitado ;
   private boolean[] H002K3_A159ConVariable ;
   private byte[] H002K3_A162ConVigencia ;
   private String[] H002K3_A1645ConceptoConveCodigo ;
   private boolean[] H002K3_n1645ConceptoConveCodigo ;
   private String[] H002K3_A503ConTipoLiqAux ;
   private boolean[] H002K3_n503ConTipoLiqAux ;
   private String[] H002K3_A970ConClasifAux ;
   private boolean[] H002K3_n970ConClasifAux ;
   private String[] H002K3_A37TipoConCod ;
   private String[] H002K3_A41ConDescrip ;
   private String[] H002K3_A26ConCodigo ;
   private String[] H002K3_A38SubTipoConCod1 ;
   private boolean[] H002K3_n38SubTipoConCod1 ;
   private int[] H002K3_A3CliCod ;
   private long[] H002K4_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV60TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV81TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV147TFConceptoConveCodigo_Sels ;
   private GXSimpleCollection<String> AV133TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV150TFConCodAfip_Sels ;
   private GXSimpleCollection<String> AV62TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV128TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV105TFConTipoLiqAux_Sels ;
   private GXSimpleCollection<String> AV66TFConObservacion_Sels ;
   private GXSimpleCollection<String> AV201TFConRelRef_Sels ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV107sdt_conceptos ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem35[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV123ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState33[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV51DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.Sdtsdt_conceptos_sdt_conceptosItem AV108item ;
}

final  class conceptoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002K3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV216Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV218Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV219Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV221Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV223Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV225Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV226Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV231Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV232Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV236Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV237Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV239Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV240Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV241Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV242Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV243Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV244Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV245Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV246Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV247Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV248Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV250Conceptowwds_36_tfconrelref_sels ,
                                          int AV216Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV215Conceptowwds_1_tfconcodigo ,
                                          int AV218Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV217Conceptowwds_3_tfcondescrip ,
                                          int AV219Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV221Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV220Conceptowwds_6_tfconclasifaux ,
                                          int AV223Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV222Conceptowwds_8_tfcontipoliqaux ,
                                          int AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV224Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV226Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV227Conceptowwds_13_tfconvariable_sel ,
                                          byte AV229Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV231Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV230Conceptowwds_16_tfconobservacion ,
                                          int AV232Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV233Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV234Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV235Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV236Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV237Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV239Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV238Conceptowwds_24_tfconcodafip ,
                                          int AV240Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV241Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV242Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV243Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV244Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV245Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV246Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV247Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV248Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV250Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV249Conceptowwds_35_tfconrelref ,
                                          String AV38TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV69CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int37 = new byte[15];
      Object[] GXv_Object38 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.ConceptoPais AS ConceptoPais, T2.ConveDescri, T1.ConTipoOrden, T1.ConPadre, T1.ConFormula, T1.ConRelRef, T1.ConRelSecCli, T1.ConRelSec, T1.ConBaseOSDif, T1.ConBaseLicProm," ;
      sSelectString += " T1.ConBaseLic, T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion," ;
      sSelectString += " T1.ConRecalcular, T1.ConFchModFor, T1.ConUsuModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo," ;
      sSelectString += " T1.ConTipoLiqAux, T1.ConClasifAux, T1.TipoConCod, T1.ConDescrip, T1.ConCodigo, T1.SubTipoConCod1, T1.CliCod" ;
      sFromString = " FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV216Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV215Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int37[1] = (byte)(1) ;
      }
      if ( AV216Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV216Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV218Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV217Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int37[2] = (byte)(1) ;
      }
      if ( AV218Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV218Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV219Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV219Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV221Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV220Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int37[3] = (byte)(1) ;
      }
      if ( AV221Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV221Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV223Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV222Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int37[4] = (byte)(1) ;
      }
      if ( AV223Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV223Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV224Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int37[5] = (byte)(1) ;
      }
      if ( AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV225Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV226Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV226Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV227Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV227Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV229Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV229Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV231Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV230Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int37[6] = (byte)(1) ;
      }
      if ( AV231Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV231Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV232Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV232Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV233Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int37[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV234Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int37[8] = (byte)(1) ;
      }
      if ( AV235Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV235Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV236Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV236Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV237Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV237Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV239Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV238Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int37[9] = (byte)(1) ;
      }
      if ( AV239Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV239Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV240Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV240Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV241Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV241Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV242Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV242Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV243Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV243Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV244Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV244Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV245Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV245Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV246Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV246Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV247Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV247Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV248Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV248Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV250Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV249Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int37[10] = (byte)(1) ;
      }
      if ( AV250Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV250Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV38TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int37[11] = (byte)(1) ;
      }
      if ( AV13OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.ConTipoOrden, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConCodigo, T1.CliCod" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConCodigo DESC, T1.CliCod" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConDescrip, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConDescrip DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.TipoConCod, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.TipoConCod DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConClasifAux, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConClasifAux DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConTipoLiqAux, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConTipoLiqAux DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConceptoConveCodigo, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConceptoConveCodigo DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConFchModFor, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConFchModFor DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConRecalcular, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConRecalcular DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConCondicion, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConCondicion DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConSacDeven, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConSacDeven DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConCodAfip, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConCodAfip DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBasePres, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBasePres DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseAnt, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseAnt DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseFer, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseFer DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseFerProm, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseFerProm DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseHorExt, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseHorExt DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseHorExtProm, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseHorExtProm DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseLic, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseLic DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseLicProm, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseLicProm DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConBaseOSDif, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConBaseOSDif DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.ConRelRef, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.ConRelRef DESC, T1.CliCod, T1.ConCodigo" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.ConCodigo" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object38[0] = scmdbuf ;
      GXv_Object38[1] = GXv_int37 ;
      return GXv_Object38 ;
   }

   protected Object[] conditional_H002K4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV216Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV218Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV219Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV221Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV223Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV225Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV226Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV231Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV232Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV236Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV237Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV239Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV240Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV241Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV242Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV243Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV244Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV245Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV246Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV247Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV248Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV250Conceptowwds_36_tfconrelref_sels ,
                                          int AV216Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV215Conceptowwds_1_tfconcodigo ,
                                          int AV218Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV217Conceptowwds_3_tfcondescrip ,
                                          int AV219Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV221Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV220Conceptowwds_6_tfconclasifaux ,
                                          int AV223Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV222Conceptowwds_8_tfcontipoliqaux ,
                                          int AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV224Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV226Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV227Conceptowwds_13_tfconvariable_sel ,
                                          byte AV229Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV231Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV230Conceptowwds_16_tfconobservacion ,
                                          int AV232Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV233Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV234Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV235Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV236Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV237Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV239Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV238Conceptowwds_24_tfconcodafip ,
                                          int AV240Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV241Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV242Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV243Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV244Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV245Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV246Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV247Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV248Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV250Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV249Conceptowwds_35_tfconrelref ,
                                          String AV38TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV69CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int40 = new byte[12];
      Object[] GXv_Object41 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV216Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV215Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int40[1] = (byte)(1) ;
      }
      if ( AV216Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV216Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV218Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV217Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int40[2] = (byte)(1) ;
      }
      if ( AV218Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV218Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV219Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV219Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV221Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV220Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int40[3] = (byte)(1) ;
      }
      if ( AV221Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV221Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV223Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV222Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int40[4] = (byte)(1) ;
      }
      if ( AV223Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV223Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV224Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int40[5] = (byte)(1) ;
      }
      if ( AV225Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV225Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV226Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV226Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV227Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV227Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV229Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV229Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV231Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV230Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int40[6] = (byte)(1) ;
      }
      if ( AV231Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV231Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV232Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV232Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV233Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int40[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV234Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int40[8] = (byte)(1) ;
      }
      if ( AV235Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV235Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV236Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV236Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV237Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV237Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV239Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV238Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int40[9] = (byte)(1) ;
      }
      if ( AV239Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV239Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV240Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV240Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV241Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV241Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV242Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV242Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV243Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV243Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV244Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV244Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV245Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV245Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV246Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV246Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV247Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV247Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV248Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV248Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV250Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV249Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int40[10] = (byte)(1) ;
      }
      if ( AV250Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV250Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV38TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int40[11] = (byte)(1) ;
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
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 13 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 14 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 15 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 16 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 17 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 18 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 19 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 20 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 21 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 22 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object41[0] = scmdbuf ;
      GXv_Object41[1] = GXv_int40 ;
      return GXv_Object41 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_H002K3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).shortValue() , ((Boolean) dynConstraints[87]).booleanValue() , ((Number) dynConstraints[88]).intValue() , ((Number) dynConstraints[89]).intValue() );
            case 2 :
                  return conditional_H002K4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).shortValue() , ((Boolean) dynConstraints[87]).booleanValue() , ((Number) dynConstraints[88]).intValue() , ((Number) dynConstraints[89]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002K2", "SELECT PaiCod AS ConceptoPais, ConveCodigo AS ConceptoConveCodigo, ConveDescri FROM Convenio ORDER BY ConveDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002K3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002K4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((byte[]) buf[14])[0] = rslt.getByte(11);
               ((byte[]) buf[15])[0] = rslt.getByte(12);
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((byte[]) buf[17])[0] = rslt.getByte(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((byte[]) buf[19])[0] = rslt.getByte(16);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((String[]) buf[21])[0] = rslt.getString(18, 6);
               ((byte[]) buf[22])[0] = rslt.getByte(19);
               ((String[]) buf[23])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(21);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDateTime(22);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((short[]) buf[30])[0] = rslt.getShort(24);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getLongVarchar(25);
               ((boolean[]) buf[33])[0] = rslt.getBoolean(26);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(27);
               ((byte[]) buf[35])[0] = rslt.getByte(28);
               ((String[]) buf[36])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getString(32, 20);
               ((String[]) buf[43])[0] = rslt.getVarchar(33);
               ((String[]) buf[44])[0] = rslt.getString(34, 10);
               ((String[]) buf[45])[0] = rslt.getString(35, 20);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((int[]) buf[47])[0] = rslt.getInt(36);
               return;
            case 2 :
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
                  stmt.setString(sIdx, (String)parms[16], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[24], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

