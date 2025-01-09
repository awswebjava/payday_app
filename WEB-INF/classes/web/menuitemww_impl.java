package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuitemww_impl extends GXDataArea
{
   public menuitemww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuitemww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitemww_impl.class ));
   }

   public menuitemww_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkMItemEsMenu = UIFactory.getCheckbox(this);
      chkMItemPadreObl = UIFactory.getCheckbox(this);
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
      AV78ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22ColumnsSelector);
      AV91Pgmname = httpContext.GetPar( "Pgmname") ;
      AV48MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV46TFPerfilId = (byte)(GXutil.lval( httpContext.GetPar( "TFPerfilId"))) ;
      AV47TFPerfilId_To = (byte)(GXutil.lval( httpContext.GetPar( "TFPerfilId_To"))) ;
      AV26TFMenuItemId = httpContext.GetPar( "TFMenuItemId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV27TFMenuItemId_Sels);
      AV29TFMenuItemTitulo = httpContext.GetPar( "TFMenuItemTitulo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFMenuItemTitulo_Sels);
      AV31TFMItemEsMenu_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFMItemEsMenu_Sel"))) ;
      AV69TFMItemPadreDef = httpContext.GetPar( "TFMItemPadreDef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV70TFMItemPadreDef_Sels);
      AV71TFMItemPadreObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFMItemPadreObl_Sel"))) ;
      AV66TFMItemIcoSVG = httpContext.GetPar( "TFMItemIcoSVG") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV67TFMItemIcoSVG_Sels);
      AV60TFMItemBienTitDef = httpContext.GetPar( "TFMItemBienTitDef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV61TFMItemBienTitDef_Sels);
      AV57TFMItemBienTextDef = httpContext.GetPar( "TFMItemBienTextDef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV58TFMItemBienTextDef_Sels);
      AV63TFMItemHelp = httpContext.GetPar( "TFMItemHelp") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV64TFMItemHelp_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV44CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV38IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV40IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV72IsAuthorized_MItemIcoSVG = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_MItemIcoSVG")) ;
      AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
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
      paL52( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startL52( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menuitemww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV44CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV38IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MITEMICOSVG", getSecureSignedToken( "", AV72IsAuthorized_MItemIcoSVG));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV32DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV32DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV76ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV76ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV34GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV35GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV36GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV78ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV91Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV48MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPERFILID", GXutil.ltrim( localUtil.ntoc( AV46TFPerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFPERFILID_TO", GXutil.ltrim( localUtil.ntoc( AV47TFPerfilId_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMENUITEMID", AV26TFMenuItemId);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMENUITEMID_SELS", AV27TFMenuItemId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMENUITEMID_SELS", AV27TFMenuItemId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMENUITEMTITULO", AV29TFMenuItemTitulo);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMENUITEMTITULO_SELS", AV30TFMenuItemTitulo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMENUITEMTITULO_SELS", AV30TFMenuItemTitulo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMESMENU_SEL", GXutil.ltrim( localUtil.ntoc( AV31TFMItemEsMenu_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMPADREDEF", AV69TFMItemPadreDef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMITEMPADREDEF_SELS", AV70TFMItemPadreDef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMITEMPADREDEF_SELS", AV70TFMItemPadreDef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMPADREOBL_SEL", GXutil.ltrim( localUtil.ntoc( AV71TFMItemPadreObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMICOSVG", GXutil.rtrim( AV66TFMItemIcoSVG));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMITEMICOSVG_SELS", AV67TFMItemIcoSVG_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMITEMICOSVG_SELS", AV67TFMItemIcoSVG_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMBIENTITDEF", AV60TFMItemBienTitDef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMITEMBIENTITDEF_SELS", AV61TFMItemBienTitDef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMITEMBIENTITDEF_SELS", AV61TFMItemBienTitDef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMBIENTEXTDEF", AV57TFMItemBienTextDef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMITEMBIENTEXTDEF_SELS", AV58TFMItemBienTextDef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMITEMBIENTEXTDEF_SELS", AV58TFMItemBienTextDef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMHELP", AV63TFMItemHelp);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMITEMHELP_SELS", AV64TFMItemHelp_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMITEMHELP_SELS", AV64TFMItemHelp_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV44CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV44CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV38IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV38IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MITEMICOSVG", AV72IsAuthorized_MItemIcoSVG);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MITEMICOSVG", getSecureSignedToken( "", AV72IsAuthorized_MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMENUITEMID_SELSJSON", AV25TFMenuItemId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMENUITEMTITULO_SELSJSON", AV28TFMenuItemTitulo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMPADREDEF_SELSJSON", AV68TFMItemPadreDef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMICOSVG_SELSJSON", AV65TFMItemIcoSVG_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMBIENTITDEF_SELSJSON", AV59TFMItemBienTitDef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMBIENTEXTDEF_SELSJSON", AV56TFMItemBienTextDef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMITEMHELP_SELSJSON", AV62TFMItemHelp_SelsJson);
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
         weL52( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtL52( ) ;
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
      return formatLink("web.menuitemww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "MenuItemWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Menu Item", "") ;
   }

   public void wbL50( )
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
         wb_table1_9_L52( true) ;
      }
      else
      {
         wb_table1_9_L52( false) ;
      }
      return  ;
   }

   public void wb_table1_9_L52e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV32DDO_TitleSettingsIcons);
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

   public void startL52( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Menu Item", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupL50( ) ;
   }

   public void wsL52( )
   {
      startL52( ) ;
      evtL52( ) ;
   }

   public void evtL52( )
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
                           e11L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17L52 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18L52 ();
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
                           A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( edtPerfilId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1937MenuItemId = httpContext.cgiGet( edtMenuItemId_Internalname) ;
                           A1939MenuItemTitulo = httpContext.cgiGet( edtMenuItemTitulo_Internalname) ;
                           A1938MItemEsMenu = GXutil.strtobool( httpContext.cgiGet( chkMItemEsMenu.getInternalname())) ;
                           A1944MItemPadreDef = httpContext.cgiGet( edtMItemPadreDef_Internalname) ;
                           n1944MItemPadreDef = false ;
                           A1945MItemPadreObl = GXutil.strtobool( httpContext.cgiGet( chkMItemPadreObl.getInternalname())) ;
                           A1957MItemIcoSVG = httpContext.cgiGet( edtMItemIcoSVG_Internalname) ;
                           n1957MItemIcoSVG = false ;
                           A1958MitemIcoImg = httpContext.cgiGet( edtMitemIcoImg_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), !bGXsfl_110_Refreshing);
                           A1952MItemBienImgDef = httpContext.cgiGet( edtMItemBienImgDef_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), !bGXsfl_110_Refreshing);
                           A1955MItemBienTitDef = httpContext.cgiGet( edtMItemBienTitDef_Internalname) ;
                           A1956MItemBienTextDef = httpContext.cgiGet( edtMItemBienTextDef_Internalname) ;
                           A1961MItemHelp = httpContext.cgiGet( edtMItemHelp_Internalname) ;
                           AV37Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV37Update);
                           AV39Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV39Delete);
                           AV41Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV41Display);
                           AV17VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV17VerSVG);
                           AV18ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV18ModificarSVG);
                           AV19EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV19EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19L52 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20L52 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21L52 ();
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

   public void weL52( )
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

   public void paL52( )
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
                                 byte AV78ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ,
                                 String AV91Pgmname ,
                                 String AV48MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 byte AV46TFPerfilId ,
                                 byte AV47TFPerfilId_To ,
                                 String AV26TFMenuItemId ,
                                 GXSimpleCollection<String> AV27TFMenuItemId_Sels ,
                                 String AV29TFMenuItemTitulo ,
                                 GXSimpleCollection<String> AV30TFMenuItemTitulo_Sels ,
                                 byte AV31TFMItemEsMenu_Sel ,
                                 String AV69TFMItemPadreDef ,
                                 GXSimpleCollection<String> AV70TFMItemPadreDef_Sels ,
                                 byte AV71TFMItemPadreObl_Sel ,
                                 String AV66TFMItemIcoSVG ,
                                 GXSimpleCollection<String> AV67TFMItemIcoSVG_Sels ,
                                 String AV60TFMItemBienTitDef ,
                                 GXSimpleCollection<String> AV61TFMItemBienTitDef_Sels ,
                                 String AV57TFMItemBienTextDef ,
                                 GXSimpleCollection<String> AV58TFMItemBienTextDef_Sels ,
                                 String AV63TFMItemHelp ,
                                 GXSimpleCollection<String> AV64TFMItemHelp_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV44CliCod ,
                                 boolean AV38IsAuthorized_Update ,
                                 boolean AV40IsAuthorized_Delete ,
                                 boolean AV72IsAuthorized_MItemIcoSVG ,
                                 boolean AV50WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20L52 ();
      GRID_nCurrentRecord = 0 ;
      rfL52( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MITEMESMENU", getSecureSignedToken( "", A1938MItemEsMenu));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMESMENU", GXutil.booltostr( A1938MItemEsMenu));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERFILID", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MENUITEMID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A1937MenuItemId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMID", A1937MenuItemId);
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfL52( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV91Pgmname = "MenuItemWW" ;
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

   public void rfL52( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e20L52 ();
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
                                              A1937MenuItemId ,
                                              AV95Menuitemwwds_4_tfmenuitemid_sels ,
                                              A1939MenuItemTitulo ,
                                              AV97Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                              A1944MItemPadreDef ,
                                              AV100Menuitemwwds_9_tfmitempadredef_sels ,
                                              A1957MItemIcoSVG ,
                                              AV103Menuitemwwds_12_tfmitemicosvg_sels ,
                                              A1955MItemBienTitDef ,
                                              AV105Menuitemwwds_14_tfmitembientitdef_sels ,
                                              A1956MItemBienTextDef ,
                                              AV107Menuitemwwds_16_tfmitembientextdef_sels ,
                                              A1961MItemHelp ,
                                              AV109Menuitemwwds_18_tfmitemhelp_sels ,
                                              Byte.valueOf(AV92Menuitemwwds_1_tfperfilid) ,
                                              Byte.valueOf(AV93Menuitemwwds_2_tfperfilid_to) ,
                                              Integer.valueOf(AV95Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                              AV94Menuitemwwds_3_tfmenuitemid ,
                                              Integer.valueOf(AV97Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                              AV96Menuitemwwds_5_tfmenuitemtitulo ,
                                              Byte.valueOf(AV98Menuitemwwds_7_tfmitemesmenu_sel) ,
                                              Integer.valueOf(AV100Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                              AV99Menuitemwwds_8_tfmitempadredef ,
                                              Byte.valueOf(AV101Menuitemwwds_10_tfmitempadreobl_sel) ,
                                              Integer.valueOf(AV103Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                              AV102Menuitemwwds_11_tfmitemicosvg ,
                                              Integer.valueOf(AV105Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                              AV104Menuitemwwds_13_tfmitembientitdef ,
                                              Integer.valueOf(AV107Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                              AV106Menuitemwwds_15_tfmitembientextdef ,
                                              Integer.valueOf(AV109Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                              AV108Menuitemwwds_17_tfmitemhelp ,
                                              Byte.valueOf(A1925PerfilId) ,
                                              Boolean.valueOf(A1938MItemEsMenu) ,
                                              Boolean.valueOf(A1945MItemPadreObl) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV94Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV94Menuitemwwds_3_tfmenuitemid), "%", "") ;
         lV96Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV96Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
         lV99Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV99Menuitemwwds_8_tfmitempadredef), "%", "") ;
         lV102Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV102Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
         lV104Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV104Menuitemwwds_13_tfmitembientitdef), "%", "") ;
         lV106Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV106Menuitemwwds_15_tfmitembientextdef), "%", "") ;
         lV108Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV108Menuitemwwds_17_tfmitemhelp), "%", "") ;
         /* Using cursor H00L52 */
         pr_default.execute(0, new Object[] {Byte.valueOf(AV92Menuitemwwds_1_tfperfilid), Byte.valueOf(AV93Menuitemwwds_2_tfperfilid_to), lV94Menuitemwwds_3_tfmenuitemid, lV96Menuitemwwds_5_tfmenuitemtitulo, lV99Menuitemwwds_8_tfmitempadredef, lV102Menuitemwwds_11_tfmitemicosvg, lV104Menuitemwwds_13_tfmitembientitdef, lV106Menuitemwwds_15_tfmitembientextdef, lV108Menuitemwwds_17_tfmitemhelp, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1954MItemBienImgNom = H00L52_A1954MItemBienImgNom[0] ;
            edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
            A1960MitemIcoImgNom = H00L52_A1960MitemIcoImgNom[0] ;
            edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
            A1953MItemBienImgExt = H00L52_A1953MItemBienImgExt[0] ;
            edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
            httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, !bGXsfl_110_Refreshing);
            A1959MItemIcoImgExt = H00L52_A1959MItemIcoImgExt[0] ;
            edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
            httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, !bGXsfl_110_Refreshing);
            A1961MItemHelp = H00L52_A1961MItemHelp[0] ;
            A1956MItemBienTextDef = H00L52_A1956MItemBienTextDef[0] ;
            A1955MItemBienTitDef = H00L52_A1955MItemBienTitDef[0] ;
            A1952MItemBienImgDef = H00L52_A1952MItemBienImgDef[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), !bGXsfl_110_Refreshing);
            A1958MitemIcoImg = H00L52_A1958MitemIcoImg[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), !bGXsfl_110_Refreshing);
            A1957MItemIcoSVG = H00L52_A1957MItemIcoSVG[0] ;
            n1957MItemIcoSVG = H00L52_n1957MItemIcoSVG[0] ;
            A1945MItemPadreObl = H00L52_A1945MItemPadreObl[0] ;
            A1944MItemPadreDef = H00L52_A1944MItemPadreDef[0] ;
            n1944MItemPadreDef = H00L52_n1944MItemPadreDef[0] ;
            A1938MItemEsMenu = H00L52_A1938MItemEsMenu[0] ;
            A1939MenuItemTitulo = H00L52_A1939MenuItemTitulo[0] ;
            A1937MenuItemId = H00L52_A1937MenuItemId[0] ;
            A1925PerfilId = H00L52_A1925PerfilId[0] ;
            e21L52 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbL50( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesL52( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV91Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV91Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV48MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MITEMESMENU"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, A1938MItemEsMenu));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV44CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV44CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV38IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV38IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MITEMICOSVG", AV72IsAuthorized_MItemIcoSVG);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MITEMICOSVG", getSecureSignedToken( "", AV72IsAuthorized_MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_PERFILID"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MENUITEMID"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A1937MenuItemId, ""))));
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
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV95Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV97Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV100Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV103Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV105Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV107Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV109Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV92Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV93Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV95Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV94Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV97Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV96Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV98Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV100Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV99Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV101Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV103Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV102Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV105Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV104Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV107Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV106Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV109Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV108Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV94Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV94Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV96Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV96Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV99Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV99Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV102Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV102Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV104Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV104Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV106Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV106Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV108Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV108Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor H00L53 */
      pr_default.execute(1, new Object[] {Byte.valueOf(AV92Menuitemwwds_1_tfperfilid), Byte.valueOf(AV93Menuitemwwds_2_tfperfilid_to), lV94Menuitemwwds_3_tfmenuitemid, lV96Menuitemwwds_5_tfmenuitemtitulo, lV99Menuitemwwds_8_tfmitempadredef, lV102Menuitemwwds_11_tfmitemicosvg, lV104Menuitemwwds_13_tfmitembientitdef, lV106Menuitemwwds_15_tfmitembientextdef, lV108Menuitemwwds_17_tfmitemhelp});
      GRID_nRecordCount = H00L53_AGRID_nRecordCount[0] ;
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
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV78ManageFiltersExecutionStep, AV22ColumnsSelector, AV91Pgmname, AV48MenuOpcCod, AV12GridState, AV46TFPerfilId, AV47TFPerfilId_To, AV26TFMenuItemId, AV27TFMenuItemId_Sels, AV29TFMenuItemTitulo, AV30TFMenuItemTitulo_Sels, AV31TFMItemEsMenu_Sel, AV69TFMItemPadreDef, AV70TFMItemPadreDef_Sels, AV71TFMItemPadreObl_Sel, AV66TFMItemIcoSVG, AV67TFMItemIcoSVG_Sels, AV60TFMItemBienTitDef, AV61TFMItemBienTitDef_Sels, AV57TFMItemBienTextDef, AV58TFMItemBienTextDef_Sels, AV63TFMItemHelp, AV64TFMItemHelp_Sels, AV14OrderedBy, AV15OrderedDsc, AV44CliCod, AV38IsAuthorized_Update, AV40IsAuthorized_Delete, AV72IsAuthorized_MItemIcoSVG, AV50WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV91Pgmname = "MenuItemWW" ;
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

   public void strupL50( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19L52 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV32DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV22ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV76ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV34GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV35GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV36GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV73WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV50WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50WelcomeMessage_NoMostrarMas", AV50WelcomeMessage_NoMostrarMas);
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
      e19L52 ();
      if (returnInSub) return;
   }

   public void e19L52( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV48MenuOpcCod, "", "") ;
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
      GXt_boolean1 = AV72IsAuthorized_MItemIcoSVG ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSVG", GXv_boolean2) ;
      menuitemww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV72IsAuthorized_MItemIcoSVG = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72IsAuthorized_MItemIcoSVG", AV72IsAuthorized_MItemIcoSVG);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MITEMICOSVG", getSecureSignedToken( "", AV72IsAuthorized_MItemIcoSVG));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Menu Item", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV32DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV32DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV51MenuBienveImgURL ;
      GXv_char6[0] = AV53MenuBienveTitulo ;
      GXv_char7[0] = AV54MenuBienveTexto ;
      GXv_boolean2[0] = AV55MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV48MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean2) ;
      menuitemww_impl.this.AV51MenuBienveImgURL = GXv_char5[0] ;
      menuitemww_impl.this.AV53MenuBienveTitulo = GXv_char6[0] ;
      menuitemww_impl.this.AV54MenuBienveTexto = GXv_char7[0] ;
      menuitemww_impl.this.AV55MenuBienveVisible = GXv_boolean2[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV55MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV55MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV53MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV54MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV73WelcomeMessage_Foto = AV51MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV73WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV73WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV73WelcomeMessage_Foto), true);
         AV90Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV51MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV73WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV73WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV73WelcomeMessage_Foto), true);
      }
      GXt_char8 = "" ;
      GXt_char9 = "" ;
      GXv_char7[0] = GXt_char9 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char8 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char9, GXv_char6) ;
      menuitemww_impl.this.GXt_char8 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char8 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV87observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV87observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV87observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV87observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e20L52( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext10[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext10) ;
      AV6WWPContext = GXv_SdtWWPContext10[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV78ManageFiltersExecutionStep == 1 )
      {
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV78ManageFiltersExecutionStep == 2 )
      {
         AV78ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV24Session.getValue("MenuItemWWColumnsSelector"), "") != 0 )
      {
         AV20ColumnsSelectorXML = AV24Session.getValue("MenuItemWWColumnsSelector") ;
         AV22ColumnsSelector.fromxml(AV20ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtPerfilId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPerfilId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPerfilId_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMenuItemId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMenuItemTitulo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemTitulo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemTitulo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkMItemEsMenu.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemEsMenu.getInternalname(), "Visible", GXutil.ltrimstr( chkMItemEsMenu.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemPadreDef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemPadreDef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemPadreDef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkMItemPadreObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemPadreObl.getInternalname(), "Visible", GXutil.ltrimstr( chkMItemPadreObl.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemIcoSVG_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemIcoSVG_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemIcoSVG_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMitemIcoImg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMitemIcoImg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemBienImgDef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienImgDef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemBienTitDef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienTitDef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienTitDef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemBienTextDef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienTextDef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienTextDef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtMItemHelp_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemHelp_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemHelp_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV34GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34GridCurrentPage), 10, 0));
      AV35GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35GridPageCount), 10, 0));
      GXt_char9 = AV36GridAppliedFilters ;
      GXv_char7[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV91Pgmname, GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV36GridAppliedFilters = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36GridAppliedFilters", AV36GridAppliedFilters);
      GXt_char9 = AV83MenuOpcTitulo ;
      GXv_char7[0] = GXt_char9 ;
      new web.gettxtcount(remoteHandle, context).execute( AV48MenuOpcCod, GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV83MenuOpcTitulo = GXt_char9 ;
      if ( (GXutil.strcmp("", AV83MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV83MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV85filterCount) ;
      GXv_char7[0] = AV86filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int11, GXv_char7) ;
      menuitemww_impl.this.AV85filterCount = GXv_int11[0] ;
      menuitemww_impl.this.AV86filtrosTexto = GXv_char7[0] ;
      if ( AV85filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV85filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV86filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV92Menuitemwwds_1_tfperfilid = AV46TFPerfilId ;
      AV93Menuitemwwds_2_tfperfilid_to = AV47TFPerfilId_To ;
      AV94Menuitemwwds_3_tfmenuitemid = AV26TFMenuItemId ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = AV27TFMenuItemId_Sels ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = AV29TFMenuItemTitulo ;
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = AV30TFMenuItemTitulo_Sels ;
      AV98Menuitemwwds_7_tfmitemesmenu_sel = AV31TFMItemEsMenu_Sel ;
      AV99Menuitemwwds_8_tfmitempadredef = AV69TFMItemPadreDef ;
      AV100Menuitemwwds_9_tfmitempadredef_sels = AV70TFMItemPadreDef_Sels ;
      AV101Menuitemwwds_10_tfmitempadreobl_sel = AV71TFMItemPadreObl_Sel ;
      AV102Menuitemwwds_11_tfmitemicosvg = AV66TFMItemIcoSVG ;
      AV103Menuitemwwds_12_tfmitemicosvg_sels = AV67TFMItemIcoSVG_Sels ;
      AV104Menuitemwwds_13_tfmitembientitdef = AV60TFMItemBienTitDef ;
      AV105Menuitemwwds_14_tfmitembientitdef_sels = AV61TFMItemBienTitDef_Sels ;
      AV106Menuitemwwds_15_tfmitembientextdef = AV57TFMItemBienTextDef ;
      AV107Menuitemwwds_16_tfmitembientextdef_sels = AV58TFMItemBienTextDef_Sels ;
      AV108Menuitemwwds_17_tfmitemhelp = AV63TFMItemHelp ;
      AV109Menuitemwwds_18_tfmitemhelp_sels = AV64TFMItemHelp_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13L52( )
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
         AV33PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV33PageToGo) ;
      }
   }

   public void e14L52( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15L52( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PerfilId") == 0 )
         {
            AV46TFPerfilId = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPerfilId), 2, 0));
            AV47TFPerfilId_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPerfilId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47TFPerfilId_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MenuItemId") == 0 )
         {
            AV26TFMenuItemId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFMenuItemId", AV26TFMenuItemId);
            AV25TFMenuItemId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFMenuItemId_SelsJson", AV25TFMenuItemId_SelsJson);
            AV27TFMenuItemId_Sels.fromJSonString(AV25TFMenuItemId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MenuItemTitulo") == 0 )
         {
            AV29TFMenuItemTitulo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFMenuItemTitulo", AV29TFMenuItemTitulo);
            AV28TFMenuItemTitulo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFMenuItemTitulo_SelsJson", AV28TFMenuItemTitulo_SelsJson);
            AV30TFMenuItemTitulo_Sels.fromJSonString(AV28TFMenuItemTitulo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemEsMenu") == 0 )
         {
            AV31TFMItemEsMenu_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMItemEsMenu_Sel", GXutil.str( AV31TFMItemEsMenu_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemPadreDef") == 0 )
         {
            AV69TFMItemPadreDef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFMItemPadreDef", AV69TFMItemPadreDef);
            AV68TFMItemPadreDef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFMItemPadreDef_SelsJson", AV68TFMItemPadreDef_SelsJson);
            AV70TFMItemPadreDef_Sels.fromJSonString(AV68TFMItemPadreDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemPadreObl") == 0 )
         {
            AV71TFMItemPadreObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFMItemPadreObl_Sel", GXutil.str( AV71TFMItemPadreObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemIcoSVG") == 0 )
         {
            AV66TFMItemIcoSVG = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFMItemIcoSVG", AV66TFMItemIcoSVG);
            AV65TFMItemIcoSVG_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFMItemIcoSVG_SelsJson", AV65TFMItemIcoSVG_SelsJson);
            AV67TFMItemIcoSVG_Sels.fromJSonString(AV65TFMItemIcoSVG_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemBienTitDef") == 0 )
         {
            AV60TFMItemBienTitDef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFMItemBienTitDef", AV60TFMItemBienTitDef);
            AV59TFMItemBienTitDef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFMItemBienTitDef_SelsJson", AV59TFMItemBienTitDef_SelsJson);
            AV61TFMItemBienTitDef_Sels.fromJSonString(AV59TFMItemBienTitDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemBienTextDef") == 0 )
         {
            AV57TFMItemBienTextDef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFMItemBienTextDef", AV57TFMItemBienTextDef);
            AV56TFMItemBienTextDef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFMItemBienTextDef_SelsJson", AV56TFMItemBienTextDef_SelsJson);
            AV58TFMItemBienTextDef_Sels.fromJSonString(AV56TFMItemBienTextDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MItemHelp") == 0 )
         {
            AV63TFMItemHelp = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFMItemHelp", AV63TFMItemHelp);
            AV62TFMItemHelp_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFMItemHelp_SelsJson", AV62TFMItemHelp_SelsJson);
            AV64TFMItemHelp_Sels.fromJSonString(AV62TFMItemHelp_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFMItemHelp_Sels", AV64TFMItemHelp_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFMItemBienTextDef_Sels", AV58TFMItemBienTextDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFMItemBienTitDef_Sels", AV61TFMItemBienTitDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFMItemIcoSVG_Sels", AV67TFMItemIcoSVG_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFMItemPadreDef_Sels", AV70TFMItemPadreDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFMenuItemTitulo_Sels", AV30TFMenuItemTitulo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFMenuItemId_Sels", AV27TFMenuItemId_Sels);
   }

   private void e21L52( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV37Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV37Update);
      if ( AV38IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(A1937MenuItemId))}, new String[] {"Mode","PerfilId","MenuItemId"})  ;
      }
      AV39Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV39Delete);
      if ( AV40IsAuthorized_Delete )
      {
         if ( A1938MItemEsMenu )
         {
            edtavDelete_Link = formatLink("web.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(A1937MenuItemId))}, new String[] {"Mode","PerfilId","MenuItemId"})  ;
            edtavDelete_Class = "Attribute" ;
         }
         else
         {
            edtavDelete_Link = "" ;
            edtavDelete_Class = "Invisible" ;
         }
      }
      AV41Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV41Display);
      edtavDisplay_Link = formatLink("web.menuitemview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(A1937MenuItemId)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PerfilId","MenuItemId","TabCode"})  ;
      edtMenuItemTitulo_Link = formatLink("web.menuitemview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(A1937MenuItemId)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PerfilId","MenuItemId","TabCode"})  ;
      if ( AV72IsAuthorized_MItemIcoSVG )
      {
         edtMItemIcoSVG_Link = formatLink("web.svgview", new String[] {GXutil.URLEncode(GXutil.rtrim(A1957MItemIcoSVG)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SVGId","TabCode"})  ;
      }
      edtavVersvg_Format = (short)(1) ;
      GXt_char9 = AV17VerSVG ;
      GXv_char7[0] = GXt_char9 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV17VerSVG = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV17VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char9 = AV18ModificarSVG ;
      GXv_char7[0] = GXt_char9 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV18ModificarSVG = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV18ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char9 = AV19EliminarSVG ;
      GXv_char7[0] = GXt_char9 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV19EliminarSVG = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV19EliminarSVG);
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

   public void e11L52( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV20ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV22ColumnsSelector.fromJSonString(AV20ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "MenuItemWWColumnsSelector", ((GXutil.strcmp("", AV20ColumnsSelectorXML)==0) ? "" : AV22ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12L52( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("MenuItemWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV91Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("MenuItemWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV78ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78ManageFiltersExecutionStep", GXutil.str( AV78ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char9 = AV77ManageFiltersXml ;
         GXv_char7[0] = GXt_char9 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "MenuItemWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
         AV77ManageFiltersXml = GXt_char9 ;
         if ( (GXutil.strcmp("", AV77ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV91Pgmname+"GridState", AV77ManageFiltersXml) ;
            AV12GridState.fromxml(AV77ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFMenuItemId_Sels", AV27TFMenuItemId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFMenuItemTitulo_Sels", AV30TFMenuItemTitulo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFMItemPadreDef_Sels", AV70TFMItemPadreDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFMItemIcoSVG_Sels", AV67TFMItemIcoSVG_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFMItemBienTitDef_Sels", AV61TFMItemBienTitDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFMItemBienTextDef_Sels", AV58TFMItemBienTextDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFMItemHelp_Sels", AV64TFMItemHelp_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ManageFiltersData", AV76ManageFiltersData);
   }

   public void e16L52( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","PerfilId","MenuItemId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17L52( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV74ExcelFilename ;
      GXv_char6[0] = AV75ErrorMessage ;
      new web.menuitemwwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      menuitemww_impl.this.AV74ExcelFilename = GXv_char7[0] ;
      menuitemww_impl.this.AV75ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV74ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV74ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV75ErrorMessage);
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
      AV22ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "PerfilId", "", "Perfil", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MenuItemId", "", "Menú item ID", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MenuItemTitulo", "", "Título por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemEsMenu", "", "Es menú", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemPadreDef", "", "Padre default", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemPadreObl", "", "Padre default es obligatorio", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemIcoSVG", "", "SVG de ícono por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MitemIcoImg", "", "Img de ícono por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemBienImgDef", "", "Imagen de bienvenida por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemBienTitDef", "", "Título de bienvenida por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemBienTextDef", "", "Texto de bienvenida por defecto", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "MItemHelp", "", "Help", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&VerSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&ModificarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      if ( A1938MItemEsMenu )
      {
         GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&EliminarSVG", "", "", true, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector12[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "", "", "", false, "") ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      GXt_char9 = AV21UserCustomValue ;
      GXv_char7[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "MenuItemWWColumnsSelector", GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV21UserCustomValue = GXt_char9 ;
      if ( ! ( (GXutil.strcmp("", AV21UserCustomValue)==0) ) )
      {
         AV23ColumnsSelectorAux.fromxml(AV21UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector12[0] = AV23ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector13[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, GXv_SdtWWPColumnsSelector13) ;
         AV23ColumnsSelectorAux = GXv_SdtWWPColumnsSelector12[0] ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV22ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV44CliCod, GXv_SdtWWPColumnsSelector13) ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV38IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Update", GXv_boolean2) ;
      menuitemww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV38IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38IsAuthorized_Update", AV38IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV38IsAuthorized_Update));
      if ( ! ( AV38IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean1 = AV40IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Delete", GXv_boolean2) ;
      menuitemww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV40IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40IsAuthorized_Delete", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      if ( ! ( AV40IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean1 = AV43TempBoolean ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Insert", GXv_boolean2) ;
      menuitemww_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV43TempBoolean = GXt_boolean1 ;
      if ( ! ( AV43TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = AV76ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "MenuItemWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] ;
      AV76ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV46TFPerfilId = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFPerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPerfilId), 2, 0));
      AV47TFPerfilId_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFPerfilId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47TFPerfilId_To), 2, 0));
      AV26TFMenuItemId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26TFMenuItemId", AV26TFMenuItemId);
      AV27TFMenuItemId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29TFMenuItemTitulo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFMenuItemTitulo", AV29TFMenuItemTitulo);
      AV30TFMenuItemTitulo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFMItemEsMenu_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFMItemEsMenu_Sel", GXutil.str( AV31TFMItemEsMenu_Sel, 1, 0));
      AV69TFMItemPadreDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFMItemPadreDef", AV69TFMItemPadreDef);
      AV70TFMItemPadreDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71TFMItemPadreObl_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFMItemPadreObl_Sel", GXutil.str( AV71TFMItemPadreObl_Sel, 1, 0));
      AV66TFMItemIcoSVG = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFMItemIcoSVG", AV66TFMItemIcoSVG);
      AV67TFMItemIcoSVG_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60TFMItemBienTitDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFMItemBienTitDef", AV60TFMItemBienTitDef);
      AV61TFMItemBienTitDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57TFMItemBienTextDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFMItemBienTextDef", AV57TFMItemBienTextDef);
      AV58TFMItemBienTextDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63TFMItemHelp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFMItemHelp", AV63TFMItemHelp);
      AV64TFMItemHelp_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV24Session.getValue(AV91Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV91Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV24Session.getValue(AV91Pgmname+"GridState"), null, null);
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
      AV110GXV1 = 1 ;
      while ( AV110GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV110GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILID") == 0 )
         {
            AV46TFPerfilId = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFPerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFPerfilId), 2, 0));
            AV47TFPerfilId_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFPerfilId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47TFPerfilId_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID") == 0 )
         {
            AV26TFMenuItemId = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFMenuItemId", AV26TFMenuItemId);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID_SEL") == 0 )
         {
            AV25TFMenuItemId_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFMenuItemId_SelsJson", AV25TFMenuItemId_SelsJson);
            AV27TFMenuItemId_Sels.fromJSonString(AV25TFMenuItemId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO") == 0 )
         {
            AV29TFMenuItemTitulo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFMenuItemTitulo", AV29TFMenuItemTitulo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO_SEL") == 0 )
         {
            AV28TFMenuItemTitulo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFMenuItemTitulo_SelsJson", AV28TFMenuItemTitulo_SelsJson);
            AV30TFMenuItemTitulo_Sels.fromJSonString(AV28TFMenuItemTitulo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMESMENU_SEL") == 0 )
         {
            AV31TFMItemEsMenu_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMItemEsMenu_Sel", GXutil.str( AV31TFMItemEsMenu_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF") == 0 )
         {
            AV69TFMItemPadreDef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFMItemPadreDef", AV69TFMItemPadreDef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF_SEL") == 0 )
         {
            AV68TFMItemPadreDef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFMItemPadreDef_SelsJson", AV68TFMItemPadreDef_SelsJson);
            AV70TFMItemPadreDef_Sels.fromJSonString(AV68TFMItemPadreDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREOBL_SEL") == 0 )
         {
            AV71TFMItemPadreObl_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFMItemPadreObl_Sel", GXutil.str( AV71TFMItemPadreObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG") == 0 )
         {
            AV66TFMItemIcoSVG = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFMItemIcoSVG", AV66TFMItemIcoSVG);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG_SEL") == 0 )
         {
            AV65TFMItemIcoSVG_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFMItemIcoSVG_SelsJson", AV65TFMItemIcoSVG_SelsJson);
            AV67TFMItemIcoSVG_Sels.fromJSonString(AV65TFMItemIcoSVG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF") == 0 )
         {
            AV60TFMItemBienTitDef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFMItemBienTitDef", AV60TFMItemBienTitDef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF_SEL") == 0 )
         {
            AV59TFMItemBienTitDef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFMItemBienTitDef_SelsJson", AV59TFMItemBienTitDef_SelsJson);
            AV61TFMItemBienTitDef_Sels.fromJSonString(AV59TFMItemBienTitDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF") == 0 )
         {
            AV57TFMItemBienTextDef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFMItemBienTextDef", AV57TFMItemBienTextDef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF_SEL") == 0 )
         {
            AV56TFMItemBienTextDef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFMItemBienTextDef_SelsJson", AV56TFMItemBienTextDef_SelsJson);
            AV58TFMItemBienTextDef_Sels.fromJSonString(AV56TFMItemBienTextDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP") == 0 )
         {
            AV63TFMItemHelp = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFMItemHelp", AV63TFMItemHelp);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP_SEL") == 0 )
         {
            AV62TFMItemHelp_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFMItemHelp_SelsJson", AV62TFMItemHelp_SelsJson);
            AV64TFMItemHelp_Sels.fromJSonString(AV62TFMItemHelp_SelsJson, null);
         }
         AV110GXV1 = (int)(AV110GXV1+1) ;
      }
      GXt_char9 = "" ;
      GXv_char7[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV27TFMenuItemId_Sels.size()==0), AV25TFMenuItemId_SelsJson, GXv_char7) ;
      menuitemww_impl.this.GXt_char9 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char6[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFMenuItemTitulo_Sels.size()==0), AV28TFMenuItemTitulo_SelsJson, GXv_char6) ;
      menuitemww_impl.this.GXt_char8 = GXv_char6[0] ;
      GXt_char16 = "" ;
      GXv_char5[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV70TFMItemPadreDef_Sels.size()==0), AV68TFMItemPadreDef_SelsJson, GXv_char5) ;
      menuitemww_impl.this.GXt_char16 = GXv_char5[0] ;
      GXt_char17 = "" ;
      GXv_char18[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV67TFMItemIcoSVG_Sels.size()==0), AV65TFMItemIcoSVG_SelsJson, GXv_char18) ;
      menuitemww_impl.this.GXt_char17 = GXv_char18[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV61TFMItemBienTitDef_Sels.size()==0), AV59TFMItemBienTitDef_SelsJson, GXv_char20) ;
      menuitemww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV58TFMItemBienTextDef_Sels.size()==0), AV56TFMItemBienTextDef_SelsJson, GXv_char22) ;
      menuitemww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV64TFMItemHelp_Sels.size()==0), AV62TFMItemHelp_SelsJson, GXv_char24) ;
      menuitemww_impl.this.GXt_char23 = GXv_char24[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char9+"|"+GXt_char8+"|"+((0==AV31TFMItemEsMenu_Sel) ? "" : GXutil.str( AV31TFMItemEsMenu_Sel, 1, 0))+"|"+GXt_char16+"|"+((0==AV71TFMItemPadreObl_Sel) ? "" : GXutil.str( AV71TFMItemPadreObl_Sel, 1, 0))+"|"+GXt_char17+"|||"+GXt_char19+"|"+GXt_char21+"|"+GXt_char23 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV26TFMenuItemId)==0), AV26TFMenuItemId, GXv_char24) ;
      menuitemww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFMenuItemTitulo)==0), AV29TFMenuItemTitulo, GXv_char22) ;
      menuitemww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV69TFMItemPadreDef)==0), AV69TFMItemPadreDef, GXv_char20) ;
      menuitemww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char17 = "" ;
      GXv_char18[0] = GXt_char17 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV66TFMItemIcoSVG)==0), AV66TFMItemIcoSVG, GXv_char18) ;
      menuitemww_impl.this.GXt_char17 = GXv_char18[0] ;
      GXt_char16 = "" ;
      GXv_char7[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV60TFMItemBienTitDef)==0), AV60TFMItemBienTitDef, GXv_char7) ;
      menuitemww_impl.this.GXt_char16 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV57TFMItemBienTextDef)==0), AV57TFMItemBienTextDef, GXv_char6) ;
      menuitemww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV63TFMItemHelp)==0), AV63TFMItemHelp, GXv_char5) ;
      menuitemww_impl.this.GXt_char8 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV46TFPerfilId) ? "" : GXutil.str( AV46TFPerfilId, 2, 0))+"|"+GXt_char23+"|"+GXt_char21+"||"+GXt_char19+"||"+GXt_char17+"|||"+GXt_char16+"|"+GXt_char9+"|"+GXt_char8 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV47TFPerfilId_To) ? "" : GXutil.str( AV47TFPerfilId_To, 2, 0))+"|||||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV24Session.getValue(AV91Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFPERFILID", httpContext.getMessage( "Perfil", ""), !((0==AV46TFPerfilId)&&(0==AV47TFPerfilId_To)), (short)(0), GXutil.trim( GXutil.str( AV46TFPerfilId, 2, 0)), GXutil.trim( GXutil.str( AV47TFPerfilId_To, 2, 0))) ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMENUITEMID", httpContext.getMessage( "Menú item ID", ""), !(GXutil.strcmp("", AV26TFMenuItemId)==0), (short)(0), AV26TFMenuItemId, "", !(AV27TFMenuItemId_Sels.size()==0), AV27TFMenuItemId_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMENUITEMTITULO", httpContext.getMessage( "Título por defecto", ""), !(GXutil.strcmp("", AV29TFMenuItemTitulo)==0), (short)(0), AV29TFMenuItemTitulo, "", !(AV30TFMenuItemTitulo_Sels.size()==0), AV30TFMenuItemTitulo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMESMENU_SEL", httpContext.getMessage( "Es menú", ""), !(0==AV31TFMItemEsMenu_Sel), (short)(0), GXutil.trim( GXutil.str( AV31TFMItemEsMenu_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMPADREDEF", httpContext.getMessage( "Padre default", ""), !(GXutil.strcmp("", AV69TFMItemPadreDef)==0), (short)(0), AV69TFMItemPadreDef, "", !(AV70TFMItemPadreDef_Sels.size()==0), AV70TFMItemPadreDef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMPADREOBL_SEL", httpContext.getMessage( "Padre default es obligatorio", ""), !(0==AV71TFMItemPadreObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV71TFMItemPadreObl_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMICOSVG", httpContext.getMessage( "SVG de ícono por defecto", ""), !(GXutil.strcmp("", AV66TFMItemIcoSVG)==0), (short)(0), AV66TFMItemIcoSVG, "", !(AV67TFMItemIcoSVG_Sels.size()==0), AV67TFMItemIcoSVG_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMBIENTITDEF", httpContext.getMessage( "Título de bienvenida por defecto", ""), !(GXutil.strcmp("", AV60TFMItemBienTitDef)==0), (short)(0), AV60TFMItemBienTitDef, "", !(AV61TFMItemBienTitDef_Sels.size()==0), AV61TFMItemBienTitDef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMBIENTEXTDEF", httpContext.getMessage( "Texto de bienvenida por defecto", ""), !(GXutil.strcmp("", AV57TFMItemBienTextDef)==0), (short)(0), AV57TFMItemBienTextDef, "", !(AV58TFMItemBienTextDef_Sels.size()==0), AV58TFMItemBienTextDef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFMITEMHELP", httpContext.getMessage( "Help", ""), !(GXutil.strcmp("", AV63TFMItemHelp)==0), (short)(0), AV63TFMItemHelp, "", !(AV64TFMItemHelp_Sels.size()==0), AV64TFMItemHelp_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      if ( ! (GXutil.strcmp("", AV48MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV48MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV91Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV91Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MenuItem" );
      AV24Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18L52( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV50WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean2[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV48MenuOpcCod, GXv_boolean2) ;
         GXv_char24[0] = AV52textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV44CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char24) ;
         menuitemww_impl.this.AV52textoNoMostrara = GXv_char24[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV52textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean2[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV48MenuOpcCod, GXv_boolean2) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_L52( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_L52( true) ;
      }
      else
      {
         wb_table2_12_L52( false) ;
      }
      return  ;
   }

   public void wb_table2_12_L52e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_L52e( true) ;
      }
      else
      {
         wb_table1_9_L52e( false) ;
      }
   }

   public void wb_table2_12_L52( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e22l51_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_MenuItemWW.htm");
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
         AV73WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV73WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV90Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV73WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV73WelcomeMessage_Foto)==0) ? AV90Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV73WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV73WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_MenuItemWW.htm");
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
         wb_table3_30_L52( true) ;
      }
      else
      {
         wb_table3_30_L52( false) ;
      }
      return  ;
   }

   public void wb_table3_30_L52e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_L52( true) ;
      }
      else
      {
         wb_table4_35_L52( false) ;
      }
      return  ;
   }

   public void wb_table4_35_L52e( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
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
         wb_table5_54_L52( true) ;
      }
      else
      {
         wb_table5_54_L52( false) ;
      }
      return  ;
   }

   public void wb_table5_54_L52e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_L52( true) ;
      }
      else
      {
         wb_table6_63_L52( false) ;
      }
      return  ;
   }

   public void wb_table6_63_L52e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV34GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV35GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV36GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_L52e( true) ;
      }
      else
      {
         wb_table2_12_L52e( false) ;
      }
   }

   public void wb_table6_63_L52( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_MenuItemWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV32DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV22ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV76ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuItemWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuItemWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_MenuItemWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_L52( true) ;
      }
      else
      {
         wb_table7_99_L52( false) ;
      }
      return  ;
   }

   public void wb_table7_99_L52e( boolean wbgen )
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
         wb_table6_63_L52e( true) ;
      }
      else
      {
         wb_table6_63_L52e( false) ;
      }
   }

   public void wb_table7_99_L52( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_L52e( true) ;
      }
      else
      {
         wb_table7_99_L52e( false) ;
      }
   }

   public void wb_table5_54_L52( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_L52e( true) ;
      }
      else
      {
         wb_table5_54_L52e( false) ;
      }
   }

   public void wb_table4_35_L52( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_L52e( true) ;
      }
      else
      {
         wb_table4_35_L52e( false) ;
      }
   }

   public void wb_table3_30_L52( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_MenuItemWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_L52e( true) ;
      }
      else
      {
         wb_table3_30_L52e( false) ;
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
      paL52( ) ;
      wsL52( ) ;
      weL52( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020281431", true, true);
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
      httpContext.AddJavascriptSource("menuitemww.js", "?2024122020281431", false, true);
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
      edtPerfilId_Internalname = "PERFILID_"+sGXsfl_110_idx ;
      edtMenuItemId_Internalname = "MENUITEMID_"+sGXsfl_110_idx ;
      edtMenuItemTitulo_Internalname = "MENUITEMTITULO_"+sGXsfl_110_idx ;
      chkMItemEsMenu.setInternalname( "MITEMESMENU_"+sGXsfl_110_idx );
      edtMItemPadreDef_Internalname = "MITEMPADREDEF_"+sGXsfl_110_idx ;
      chkMItemPadreObl.setInternalname( "MITEMPADREOBL_"+sGXsfl_110_idx );
      edtMItemIcoSVG_Internalname = "MITEMICOSVG_"+sGXsfl_110_idx ;
      edtMitemIcoImg_Internalname = "MITEMICOIMG_"+sGXsfl_110_idx ;
      edtMItemBienImgDef_Internalname = "MITEMBIENIMGDEF_"+sGXsfl_110_idx ;
      edtMItemBienTitDef_Internalname = "MITEMBIENTITDEF_"+sGXsfl_110_idx ;
      edtMItemBienTextDef_Internalname = "MITEMBIENTEXTDEF_"+sGXsfl_110_idx ;
      edtMItemHelp_Internalname = "MITEMHELP_"+sGXsfl_110_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtPerfilId_Internalname = "PERFILID_"+sGXsfl_110_fel_idx ;
      edtMenuItemId_Internalname = "MENUITEMID_"+sGXsfl_110_fel_idx ;
      edtMenuItemTitulo_Internalname = "MENUITEMTITULO_"+sGXsfl_110_fel_idx ;
      chkMItemEsMenu.setInternalname( "MITEMESMENU_"+sGXsfl_110_fel_idx );
      edtMItemPadreDef_Internalname = "MITEMPADREDEF_"+sGXsfl_110_fel_idx ;
      chkMItemPadreObl.setInternalname( "MITEMPADREOBL_"+sGXsfl_110_fel_idx );
      edtMItemIcoSVG_Internalname = "MITEMICOSVG_"+sGXsfl_110_fel_idx ;
      edtMitemIcoImg_Internalname = "MITEMICOIMG_"+sGXsfl_110_fel_idx ;
      edtMItemBienImgDef_Internalname = "MITEMBIENIMGDEF_"+sGXsfl_110_fel_idx ;
      edtMItemBienTitDef_Internalname = "MITEMBIENTITDEF_"+sGXsfl_110_fel_idx ;
      edtMItemBienTextDef_Internalname = "MITEMBIENTEXTDEF_"+sGXsfl_110_fel_idx ;
      edtMItemHelp_Internalname = "MITEMHELP_"+sGXsfl_110_fel_idx ;
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
      wbL50( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtPerfilId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPerfilId_Internalname,GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPerfilId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtPerfilId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMenuItemId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuItemId_Internalname,A1937MenuItemId,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuItemId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMenuItemId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMenuItemTitulo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuItemTitulo_Internalname,A1939MenuItemTitulo,"","","'"+""+"'"+",false,"+"'"+""+"'",edtMenuItemTitulo_Link,"","","",edtMenuItemTitulo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMenuItemTitulo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkMItemEsMenu.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "MITEMESMENU_" + sGXsfl_110_idx ;
         chkMItemEsMenu.setName( GXCCtl );
         chkMItemEsMenu.setWebtags( "" );
         chkMItemEsMenu.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkMItemEsMenu.getInternalname(), "TitleCaption", chkMItemEsMenu.getCaption(), !bGXsfl_110_Refreshing);
         chkMItemEsMenu.setCheckedValue( "false" );
         A1938MItemEsMenu = GXutil.strtobool( GXutil.booltostr( A1938MItemEsMenu)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMItemEsMenu.getInternalname(),GXutil.booltostr( A1938MItemEsMenu),"","",Integer.valueOf(chkMItemEsMenu.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemPadreDef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMItemPadreDef_Internalname,A1944MItemPadreDef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMItemPadreDef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMItemPadreDef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkMItemPadreObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "MITEMPADREOBL_" + sGXsfl_110_idx ;
         chkMItemPadreObl.setName( GXCCtl );
         chkMItemPadreObl.setWebtags( "" );
         chkMItemPadreObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkMItemPadreObl.getInternalname(), "TitleCaption", chkMItemPadreObl.getCaption(), !bGXsfl_110_Refreshing);
         chkMItemPadreObl.setCheckedValue( "false" );
         A1945MItemPadreObl = GXutil.strtobool( GXutil.booltostr( A1945MItemPadreObl)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMItemPadreObl.getInternalname(),GXutil.booltostr( A1945MItemPadreObl),"","",Integer.valueOf(chkMItemPadreObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemIcoSVG_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMItemIcoSVG_Internalname,GXutil.rtrim( A1957MItemIcoSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtMItemIcoSVG_Link,"","","",edtMItemIcoSVG_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMItemIcoSVG_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMitemIcoImg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
         edtMitemIcoImg_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, !bGXsfl_110_Refreshing);
         edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, !bGXsfl_110_Refreshing);
         if ( ! (GXutil.strcmp("", A1958MitemIcoImg)==0) )
         {
            gxblobfileaux.setSource( A1958MitemIcoImg );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMitemIcoImg_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtMitemIcoImg_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A1958MitemIcoImg = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), !bGXsfl_110_Refreshing);
               edtMitemIcoImg_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, !bGXsfl_110_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), !bGXsfl_110_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtMitemIcoImg_Internalname,GXutil.rtrim( A1958MitemIcoImg),httpContext.getResourceRelative(A1958MitemIcoImg),((GXutil.strcmp("", edtMitemIcoImg_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMitemIcoImg_Filetype)==0) ? A1958MitemIcoImg : edtMitemIcoImg_Filetype)) : edtMitemIcoImg_Contenttype),Boolean.valueOf(true),"",edtMitemIcoImg_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(edtMitemIcoImg_Visible),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtMitemIcoImg_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemBienImgDef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
         edtMItemBienImgDef_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, !bGXsfl_110_Refreshing);
         edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, !bGXsfl_110_Refreshing);
         if ( ! (GXutil.strcmp("", A1952MItemBienImgDef)==0) )
         {
            gxblobfileaux.setSource( A1952MItemBienImgDef );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMItemBienImgDef_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtMItemBienImgDef_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A1952MItemBienImgDef = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), !bGXsfl_110_Refreshing);
               edtMItemBienImgDef_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, !bGXsfl_110_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), !bGXsfl_110_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtMItemBienImgDef_Internalname,GXutil.rtrim( A1952MItemBienImgDef),httpContext.getResourceRelative(A1952MItemBienImgDef),((GXutil.strcmp("", edtMItemBienImgDef_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMItemBienImgDef_Filetype)==0) ? A1952MItemBienImgDef : edtMItemBienImgDef_Filetype)) : edtMItemBienImgDef_Contenttype),Boolean.valueOf(true),"",edtMItemBienImgDef_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(edtMItemBienImgDef_Visible),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtMItemBienImgDef_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemBienTitDef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMItemBienTitDef_Internalname,A1955MItemBienTitDef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMItemBienTitDef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMItemBienTitDef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemBienTextDef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMItemBienTextDef_Internalname,A1956MItemBienTextDef,A1956MItemBienTextDef,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMItemBienTextDef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMItemBienTextDef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMItemHelp_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMItemHelp_Internalname,A1961MItemHelp,A1961MItemHelp,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMItemHelp_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMItemHelp_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV37Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = edtavDelete_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV39Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),edtavDelete_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV41Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV17VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV18ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV19EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesL52( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtPerfilId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Perfil", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMenuItemId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Menú item ID", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMenuItemTitulo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Título por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkMItemEsMenu.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Es menú", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemPadreDef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Padre default", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkMItemPadreObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Padre default es obligatorio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemIcoSVG_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SVG de ícono por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMitemIcoImg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Img de ícono por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemBienImgDef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imagen de bienvenida por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemBienTitDef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Título de bienvenida por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemBienTextDef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Texto de bienvenida por defecto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMItemHelp_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Help", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtPerfilId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1937MenuItemId);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMenuItemId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1939MenuItemTitulo);
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtMenuItemTitulo_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMenuItemTitulo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1938MItemEsMenu));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkMItemEsMenu.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1944MItemPadreDef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemPadreDef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1945MItemPadreObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkMItemPadreObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1957MItemIcoSVG));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtMItemIcoSVG_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemIcoSVG_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1958MitemIcoImg);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMitemIcoImg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1952MItemBienImgDef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemBienImgDef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1955MItemBienTitDef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemBienTitDef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1956MItemBienTextDef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemBienTextDef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1961MItemHelp);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMItemHelp_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV37Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV39Delete));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDelete_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV41Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV17VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV19EliminarSVG));
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
      edtPerfilId_Internalname = "PERFILID" ;
      edtMenuItemId_Internalname = "MENUITEMID" ;
      edtMenuItemTitulo_Internalname = "MENUITEMTITULO" ;
      chkMItemEsMenu.setInternalname( "MITEMESMENU" );
      edtMItemPadreDef_Internalname = "MITEMPADREDEF" ;
      chkMItemPadreObl.setInternalname( "MITEMPADREOBL" );
      edtMItemIcoSVG_Internalname = "MITEMICOSVG" ;
      edtMitemIcoImg_Internalname = "MITEMICOIMG" ;
      edtMItemBienImgDef_Internalname = "MITEMBIENIMGDEF" ;
      edtMItemBienTitDef_Internalname = "MITEMBIENTITDEF" ;
      edtMItemBienTextDef_Internalname = "MITEMBIENTEXTDEF" ;
      edtMItemHelp_Internalname = "MITEMHELP" ;
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
      edtavDelete_Class = "Attribute" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtMItemHelp_Jsonclick = "" ;
      edtMItemBienTextDef_Jsonclick = "" ;
      edtMItemBienTitDef_Jsonclick = "" ;
      edtMItemBienImgDef_Jsonclick = "" ;
      edtMItemBienImgDef_Parameters = "" ;
      edtMItemBienImgDef_Contenttype = "" ;
      edtMitemIcoImg_Jsonclick = "" ;
      edtMitemIcoImg_Parameters = "" ;
      edtMitemIcoImg_Contenttype = "" ;
      edtMItemIcoSVG_Jsonclick = "" ;
      edtMItemIcoSVG_Link = "" ;
      chkMItemPadreObl.setCaption( "" );
      edtMItemPadreDef_Jsonclick = "" ;
      chkMItemEsMenu.setCaption( "" );
      edtMenuItemTitulo_Jsonclick = "" ;
      edtMenuItemTitulo_Link = "" ;
      edtMenuItemId_Jsonclick = "" ;
      edtPerfilId_Jsonclick = "" ;
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
      edtMItemHelp_Visible = -1 ;
      edtMItemBienTextDef_Visible = -1 ;
      edtMItemBienTitDef_Visible = -1 ;
      edtMItemBienImgDef_Visible = -1 ;
      edtMitemIcoImg_Visible = -1 ;
      edtMItemIcoSVG_Visible = -1 ;
      chkMItemPadreObl.setVisible( -1 );
      edtMItemPadreDef_Visible = -1 ;
      chkMItemEsMenu.setVisible( -1 );
      edtMenuItemTitulo_Visible = -1 ;
      edtMenuItemId_Visible = -1 ;
      edtPerfilId_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      edtMitemIcoImg_Filetype = "" ;
      edtMItemBienImgDef_Filetype = "" ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "2.0|||||||||||" ;
      Ddo_grid_Datalistproc = "MenuItemWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||1:WWP_TSChecked,2:WWP_TSUnChecked||1:WWP_TSChecked,2:WWP_TSUnChecked||||||" ;
      Ddo_grid_Allowmultipleselection = "|T|T||T||T|||T|T|T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|FixedValues|Dynamic|FixedValues|Dynamic|||Dynamic|Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|T|||T|T|T" ;
      Ddo_grid_Filterisrange = "T|||||||||||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character||Character||Character|||Character|Character|Character" ;
      Ddo_grid_Includefilter = "T|T|T||T||T|||T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T|||T|T|T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|||8|9|10" ;
      Ddo_grid_Columnids = "0:PerfilId|1:MenuItemId|2:MenuItemTitulo|3:MItemEsMenu|4:MItemPadreDef|5:MItemPadreObl|6:MItemIcoSVG|7:MitemIcoImg|8:MItemBienImgDef|9:MItemBienTitDef|10:MItemBienTextDef|11:MItemHelp" ;
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
      Form.setCaption( httpContext.getMessage( " Menu Item", "") );
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
      GXCCtl = "MITEMESMENU_" + sGXsfl_110_idx ;
      chkMItemEsMenu.setName( GXCCtl );
      chkMItemEsMenu.setWebtags( "" );
      chkMItemEsMenu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemEsMenu.getInternalname(), "TitleCaption", chkMItemEsMenu.getCaption(), !bGXsfl_110_Refreshing);
      chkMItemEsMenu.setCheckedValue( "false" );
      A1938MItemEsMenu = GXutil.strtobool( GXutil.booltostr( A1938MItemEsMenu)) ;
      GXCCtl = "MITEMPADREOBL_" + sGXsfl_110_idx ;
      chkMItemPadreObl.setName( GXCCtl );
      chkMItemPadreObl.setWebtags( "" );
      chkMItemPadreObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemPadreObl.getInternalname(), "TitleCaption", chkMItemPadreObl.getCaption(), !bGXsfl_110_Refreshing);
      chkMItemPadreObl.setCheckedValue( "false" );
      A1945MItemPadreObl = GXutil.strtobool( GXutil.booltostr( A1945MItemPadreObl)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPerfilId_Visible',ctrl:'PERFILID',prop:'Visible'},{av:'edtMenuItemId_Visible',ctrl:'MENUITEMID',prop:'Visible'},{av:'edtMenuItemTitulo_Visible',ctrl:'MENUITEMTITULO',prop:'Visible'},{av:'chkMItemEsMenu.getVisible()',ctrl:'MITEMESMENU',prop:'Visible'},{av:'edtMItemPadreDef_Visible',ctrl:'MITEMPADREDEF',prop:'Visible'},{av:'chkMItemPadreObl.getVisible()',ctrl:'MITEMPADREOBL',prop:'Visible'},{av:'edtMItemIcoSVG_Visible',ctrl:'MITEMICOSVG',prop:'Visible'},{av:'edtMitemIcoImg_Visible',ctrl:'MITEMICOIMG',prop:'Visible'},{av:'edtMItemBienImgDef_Visible',ctrl:'MITEMBIENIMGDEF',prop:'Visible'},{av:'edtMItemBienTitDef_Visible',ctrl:'MITEMBIENTITDEF',prop:'Visible'},{av:'edtMItemBienTextDef_Visible',ctrl:'MITEMBIENTEXTDEF',prop:'Visible'},{av:'edtMItemHelp_Visible',ctrl:'MITEMHELP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV34GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV35GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV36GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13L52',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14L52',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15L52',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV62TFMItemHelp_SelsJson',fld:'vTFMITEMHELP_SELSJSON',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV56TFMItemBienTextDef_SelsJson',fld:'vTFMITEMBIENTEXTDEF_SELSJSON',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV59TFMItemBienTitDef_SelsJson',fld:'vTFMITEMBIENTITDEF_SELSJSON',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV65TFMItemIcoSVG_SelsJson',fld:'vTFMITEMICOSVG_SELSJSON',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV68TFMItemPadreDef_SelsJson',fld:'vTFMITEMPADREDEF_SELSJSON',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV28TFMenuItemTitulo_SelsJson',fld:'vTFMENUITEMTITULO_SELSJSON',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV25TFMenuItemId_SelsJson',fld:'vTFMENUITEMID_SELSJSON',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21L52',iparms:[{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9',hsh:true},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV37Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV39Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtavDelete_Class',ctrl:'vDELETE',prop:'Class'},{av:'AV41Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtMenuItemTitulo_Link',ctrl:'MENUITEMTITULO',prop:'Link'},{av:'edtMItemIcoSVG_Link',ctrl:'MITEMICOSVG',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV17VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV18ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV19EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11L52',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:'',hsh:true}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtPerfilId_Visible',ctrl:'PERFILID',prop:'Visible'},{av:'edtMenuItemId_Visible',ctrl:'MENUITEMID',prop:'Visible'},{av:'edtMenuItemTitulo_Visible',ctrl:'MENUITEMTITULO',prop:'Visible'},{av:'chkMItemEsMenu.getVisible()',ctrl:'MITEMESMENU',prop:'Visible'},{av:'edtMItemPadreDef_Visible',ctrl:'MITEMPADREDEF',prop:'Visible'},{av:'chkMItemPadreObl.getVisible()',ctrl:'MITEMPADREOBL',prop:'Visible'},{av:'edtMItemIcoSVG_Visible',ctrl:'MITEMICOSVG',prop:'Visible'},{av:'edtMitemIcoImg_Visible',ctrl:'MITEMICOIMG',prop:'Visible'},{av:'edtMItemBienImgDef_Visible',ctrl:'MITEMBIENIMGDEF',prop:'Visible'},{av:'edtMItemBienTitDef_Visible',ctrl:'MITEMBIENTITDEF',prop:'Visible'},{av:'edtMItemBienTextDef_Visible',ctrl:'MITEMBIENTEXTDEF',prop:'Visible'},{av:'edtMItemHelp_Visible',ctrl:'MITEMHELP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV34GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV35GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV36GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12L52',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV91Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV72IsAuthorized_MItemIcoSVG',fld:'vISAUTHORIZED_MITEMICOSVG',pic:'',hsh:true},{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV25TFMenuItemId_SelsJson',fld:'vTFMENUITEMID_SELSJSON',pic:''},{av:'AV28TFMenuItemTitulo_SelsJson',fld:'vTFMENUITEMTITULO_SELSJSON',pic:''},{av:'AV68TFMItemPadreDef_SelsJson',fld:'vTFMITEMPADREDEF_SELSJSON',pic:''},{av:'AV65TFMItemIcoSVG_SelsJson',fld:'vTFMITEMICOSVG_SELSJSON',pic:''},{av:'AV59TFMItemBienTitDef_SelsJson',fld:'vTFMITEMBIENTITDEF_SELSJSON',pic:''},{av:'AV56TFMItemBienTextDef_SelsJson',fld:'vTFMITEMBIENTEXTDEF_SELSJSON',pic:''},{av:'AV62TFMItemHelp_SelsJson',fld:'vTFMITEMHELP_SELSJSON',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:'',hsh:true}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV78ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV46TFPerfilId',fld:'vTFPERFILID',pic:'Z9'},{av:'AV47TFPerfilId_To',fld:'vTFPERFILID_TO',pic:'Z9'},{av:'AV26TFMenuItemId',fld:'vTFMENUITEMID',pic:''},{av:'AV27TFMenuItemId_Sels',fld:'vTFMENUITEMID_SELS',pic:''},{av:'AV29TFMenuItemTitulo',fld:'vTFMENUITEMTITULO',pic:''},{av:'AV30TFMenuItemTitulo_Sels',fld:'vTFMENUITEMTITULO_SELS',pic:''},{av:'AV31TFMItemEsMenu_Sel',fld:'vTFMITEMESMENU_SEL',pic:'9'},{av:'AV69TFMItemPadreDef',fld:'vTFMITEMPADREDEF',pic:''},{av:'AV70TFMItemPadreDef_Sels',fld:'vTFMITEMPADREDEF_SELS',pic:''},{av:'AV71TFMItemPadreObl_Sel',fld:'vTFMITEMPADREOBL_SEL',pic:'9'},{av:'AV66TFMItemIcoSVG',fld:'vTFMITEMICOSVG',pic:''},{av:'AV67TFMItemIcoSVG_Sels',fld:'vTFMITEMICOSVG_SELS',pic:''},{av:'AV60TFMItemBienTitDef',fld:'vTFMITEMBIENTITDEF',pic:''},{av:'AV61TFMItemBienTitDef_Sels',fld:'vTFMITEMBIENTITDEF_SELS',pic:''},{av:'AV57TFMItemBienTextDef',fld:'vTFMITEMBIENTEXTDEF',pic:''},{av:'AV58TFMItemBienTextDef_Sels',fld:'vTFMITEMBIENTEXTDEF_SELS',pic:''},{av:'AV63TFMItemHelp',fld:'vTFMITEMHELP',pic:''},{av:'AV64TFMItemHelp_Sels',fld:'vTFMITEMHELP_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV62TFMItemHelp_SelsJson',fld:'vTFMITEMHELP_SELSJSON',pic:''},{av:'AV56TFMItemBienTextDef_SelsJson',fld:'vTFMITEMBIENTEXTDEF_SELSJSON',pic:''},{av:'AV59TFMItemBienTitDef_SelsJson',fld:'vTFMITEMBIENTITDEF_SELSJSON',pic:''},{av:'AV65TFMItemIcoSVG_SelsJson',fld:'vTFMITEMICOSVG_SELSJSON',pic:''},{av:'AV68TFMItemPadreDef_SelsJson',fld:'vTFMITEMPADREDEF_SELSJSON',pic:''},{av:'AV28TFMenuItemTitulo_SelsJson',fld:'vTFMENUITEMTITULO_SELSJSON',pic:''},{av:'AV25TFMenuItemId_SelsJson',fld:'vTFMENUITEMID_SELSJSON',pic:''},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtPerfilId_Visible',ctrl:'PERFILID',prop:'Visible'},{av:'edtMenuItemId_Visible',ctrl:'MENUITEMID',prop:'Visible'},{av:'edtMenuItemTitulo_Visible',ctrl:'MENUITEMTITULO',prop:'Visible'},{av:'chkMItemEsMenu.getVisible()',ctrl:'MITEMESMENU',prop:'Visible'},{av:'edtMItemPadreDef_Visible',ctrl:'MITEMPADREDEF',prop:'Visible'},{av:'chkMItemPadreObl.getVisible()',ctrl:'MITEMPADREOBL',prop:'Visible'},{av:'edtMItemIcoSVG_Visible',ctrl:'MITEMICOSVG',prop:'Visible'},{av:'edtMitemIcoImg_Visible',ctrl:'MITEMICOIMG',prop:'Visible'},{av:'edtMItemBienImgDef_Visible',ctrl:'MITEMBIENIMGDEF',prop:'Visible'},{av:'edtMItemBienTitDef_Visible',ctrl:'MITEMBIENTITDEF',prop:'Visible'},{av:'edtMItemBienTextDef_Visible',ctrl:'MITEMBIENTEXTDEF',prop:'Visible'},{av:'edtMItemHelp_Visible',ctrl:'MITEMHELP',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV34GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV35GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV36GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV38IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV76ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16L52',iparms:[{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9',hsh:true},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17L52',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18L52',iparms:[{av:'AV50WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV44CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e22L51',iparms:[]");
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
      wcpOAV48MenuOpcCod = "" ;
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
      AV48MenuOpcCod = "" ;
      AV22ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV91Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26TFMenuItemId = "" ;
      AV27TFMenuItemId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFMenuItemTitulo = "" ;
      AV30TFMenuItemTitulo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69TFMItemPadreDef = "" ;
      AV70TFMItemPadreDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66TFMItemIcoSVG = "" ;
      AV67TFMItemIcoSVG_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFMItemBienTitDef = "" ;
      AV61TFMItemBienTitDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFMItemBienTextDef = "" ;
      AV58TFMItemBienTextDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFMItemHelp = "" ;
      AV64TFMItemHelp_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV32DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV76ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV36GridAppliedFilters = "" ;
      AV25TFMenuItemId_SelsJson = "" ;
      AV28TFMenuItemTitulo_SelsJson = "" ;
      AV68TFMItemPadreDef_SelsJson = "" ;
      AV65TFMItemIcoSVG_SelsJson = "" ;
      AV59TFMItemBienTitDef_SelsJson = "" ;
      AV56TFMItemBienTextDef_SelsJson = "" ;
      AV62TFMItemHelp_SelsJson = "" ;
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
      A1937MenuItemId = "" ;
      A1939MenuItemTitulo = "" ;
      A1944MItemPadreDef = "" ;
      A1957MItemIcoSVG = "" ;
      A1958MitemIcoImg = "" ;
      A1952MItemBienImgDef = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      A1961MItemHelp = "" ;
      AV37Update = "" ;
      AV39Delete = "" ;
      AV41Display = "" ;
      AV17VerSVG = "" ;
      AV18ModificarSVG = "" ;
      AV19EliminarSVG = "" ;
      AV95Menuitemwwds_4_tfmenuitemid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97Menuitemwwds_6_tfmenuitemtitulo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Menuitemwwds_9_tfmitempadredef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV103Menuitemwwds_12_tfmitemicosvg_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV105Menuitemwwds_14_tfmitembientitdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV107Menuitemwwds_16_tfmitembientextdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV109Menuitemwwds_18_tfmitemhelp_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV94Menuitemwwds_3_tfmenuitemid = "" ;
      lV96Menuitemwwds_5_tfmenuitemtitulo = "" ;
      lV99Menuitemwwds_8_tfmitempadredef = "" ;
      lV102Menuitemwwds_11_tfmitemicosvg = "" ;
      lV104Menuitemwwds_13_tfmitembientitdef = "" ;
      lV106Menuitemwwds_15_tfmitembientextdef = "" ;
      lV108Menuitemwwds_17_tfmitemhelp = "" ;
      AV94Menuitemwwds_3_tfmenuitemid = "" ;
      AV96Menuitemwwds_5_tfmenuitemtitulo = "" ;
      AV99Menuitemwwds_8_tfmitempadredef = "" ;
      AV102Menuitemwwds_11_tfmitemicosvg = "" ;
      AV104Menuitemwwds_13_tfmitembientitdef = "" ;
      AV106Menuitemwwds_15_tfmitembientextdef = "" ;
      AV108Menuitemwwds_17_tfmitemhelp = "" ;
      H00L52_A1954MItemBienImgNom = new String[] {""} ;
      H00L52_A1960MitemIcoImgNom = new String[] {""} ;
      H00L52_A1953MItemBienImgExt = new String[] {""} ;
      H00L52_A1959MItemIcoImgExt = new String[] {""} ;
      H00L52_A1961MItemHelp = new String[] {""} ;
      H00L52_A1956MItemBienTextDef = new String[] {""} ;
      H00L52_A1955MItemBienTitDef = new String[] {""} ;
      H00L52_A1952MItemBienImgDef = new String[] {""} ;
      H00L52_A1958MitemIcoImg = new String[] {""} ;
      H00L52_A1957MItemIcoSVG = new String[] {""} ;
      H00L52_n1957MItemIcoSVG = new boolean[] {false} ;
      H00L52_A1945MItemPadreObl = new boolean[] {false} ;
      H00L52_A1944MItemPadreDef = new String[] {""} ;
      H00L52_n1944MItemPadreDef = new boolean[] {false} ;
      H00L52_A1938MItemEsMenu = new boolean[] {false} ;
      H00L52_A1939MenuItemTitulo = new String[] {""} ;
      H00L52_A1937MenuItemId = new String[] {""} ;
      H00L52_A1925PerfilId = new byte[1] ;
      A1954MItemBienImgNom = "" ;
      edtMItemBienImgDef_Filename = "" ;
      A1960MitemIcoImgNom = "" ;
      edtMitemIcoImg_Filename = "" ;
      A1953MItemBienImgExt = "" ;
      A1959MItemIcoImgExt = "" ;
      H00L53_AGRID_nRecordCount = new long[1] ;
      AV73WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV51MenuBienveImgURL = "" ;
      AV53MenuBienveTitulo = "" ;
      AV54MenuBienveTexto = "" ;
      AV90Welcomemessage_foto_GXI = "" ;
      AV87observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext10 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV20ColumnsSelectorXML = "" ;
      AV83MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV86filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV77ManageFiltersXml = "" ;
      AV74ExcelFilename = "" ;
      AV75ErrorMessage = "" ;
      AV21UserCustomValue = "" ;
      AV23ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char23 = "" ;
      GXt_char21 = "" ;
      GXv_char22 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char20 = new String[1] ;
      GXt_char17 = "" ;
      GXv_char18 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char8 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState25 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV52textoNoMostrara = "" ;
      GXv_char24 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
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
      gxblobfileaux = new com.genexus.util.GXFile();
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuitemww__default(),
         new Object[] {
             new Object[] {
            H00L52_A1954MItemBienImgNom, H00L52_A1960MitemIcoImgNom, H00L52_A1953MItemBienImgExt, H00L52_A1959MItemIcoImgExt, H00L52_A1961MItemHelp, H00L52_A1956MItemBienTextDef, H00L52_A1955MItemBienTitDef, H00L52_A1952MItemBienImgDef, H00L52_A1958MitemIcoImg, H00L52_A1957MItemIcoSVG,
            H00L52_n1957MItemIcoSVG, H00L52_A1945MItemPadreObl, H00L52_A1944MItemPadreDef, H00L52_n1944MItemPadreDef, H00L52_A1938MItemEsMenu, H00L52_A1939MenuItemTitulo, H00L52_A1937MenuItemId, H00L52_A1925PerfilId
            }
            , new Object[] {
            H00L53_AGRID_nRecordCount
            }
         }
      );
      AV91Pgmname = "MenuItemWW" ;
      /* GeneXus formulas. */
      AV91Pgmname = "MenuItemWW" ;
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
   private byte AV78ManageFiltersExecutionStep ;
   private byte AV46TFPerfilId ;
   private byte AV47TFPerfilId_To ;
   private byte AV31TFMItemEsMenu_Sel ;
   private byte AV71TFMItemPadreObl_Sel ;
   private byte gxajaxcallmode ;
   private byte A1925PerfilId ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV92Menuitemwwds_1_tfperfilid ;
   private byte AV93Menuitemwwds_2_tfperfilid_to ;
   private byte AV98Menuitemwwds_7_tfmitemesmenu_sel ;
   private byte AV101Menuitemwwds_10_tfmitempadreobl_sel ;
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
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV44CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV95Menuitemwwds_4_tfmenuitemid_sels_size ;
   private int AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size ;
   private int AV100Menuitemwwds_9_tfmitempadredef_sels_size ;
   private int AV103Menuitemwwds_12_tfmitemicosvg_sels_size ;
   private int AV105Menuitemwwds_14_tfmitembientitdef_sels_size ;
   private int AV107Menuitemwwds_16_tfmitembientextdef_sels_size ;
   private int AV109Menuitemwwds_18_tfmitemhelp_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int edtPerfilId_Visible ;
   private int edtMenuItemId_Visible ;
   private int edtMenuItemTitulo_Visible ;
   private int edtMItemPadreDef_Visible ;
   private int edtMItemIcoSVG_Visible ;
   private int edtMitemIcoImg_Visible ;
   private int edtMItemBienImgDef_Visible ;
   private int edtMItemBienTitDef_Visible ;
   private int edtMItemBienTextDef_Visible ;
   private int edtMItemHelp_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV85filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV33PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV110GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV34GridCurrentPage ;
   private long AV35GridPageCount ;
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
   private String AV91Pgmname ;
   private String AV66TFMItemIcoSVG ;
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
   private String edtPerfilId_Internalname ;
   private String edtMenuItemId_Internalname ;
   private String edtMenuItemTitulo_Internalname ;
   private String edtMItemPadreDef_Internalname ;
   private String A1957MItemIcoSVG ;
   private String edtMItemIcoSVG_Internalname ;
   private String edtMitemIcoImg_Internalname ;
   private String edtMItemBienImgDef_Internalname ;
   private String edtMItemBienTitDef_Internalname ;
   private String edtMItemBienTextDef_Internalname ;
   private String edtMItemHelp_Internalname ;
   private String AV37Update ;
   private String edtavUpdate_Internalname ;
   private String AV39Delete ;
   private String edtavDelete_Internalname ;
   private String AV41Display ;
   private String edtavDisplay_Internalname ;
   private String AV17VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV18ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV19EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV102Menuitemwwds_11_tfmitemicosvg ;
   private String AV102Menuitemwwds_11_tfmitemicosvg ;
   private String edtMItemBienImgDef_Filename ;
   private String edtMitemIcoImg_Filename ;
   private String A1953MItemBienImgExt ;
   private String edtMItemBienImgDef_Filetype ;
   private String A1959MItemIcoImgExt ;
   private String edtMitemIcoImg_Filetype ;
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
   private String AV87observerPalabra ;
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
   private String edtavDelete_Class ;
   private String edtavDisplay_Link ;
   private String edtMenuItemTitulo_Link ;
   private String edtMItemIcoSVG_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char23 ;
   private String GXt_char21 ;
   private String GXv_char22[] ;
   private String GXt_char19 ;
   private String GXv_char20[] ;
   private String GXt_char17 ;
   private String GXv_char18[] ;
   private String GXt_char16 ;
   private String GXv_char7[] ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String GXt_char8 ;
   private String GXv_char5[] ;
   private String GXv_char24[] ;
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
   private String edtPerfilId_Jsonclick ;
   private String edtMenuItemId_Jsonclick ;
   private String edtMenuItemTitulo_Jsonclick ;
   private String GXCCtl ;
   private String edtMItemPadreDef_Jsonclick ;
   private String edtMItemIcoSVG_Jsonclick ;
   private String edtMitemIcoImg_Contenttype ;
   private String edtMitemIcoImg_Parameters ;
   private String edtMitemIcoImg_Jsonclick ;
   private String edtMItemBienImgDef_Contenttype ;
   private String edtMItemBienImgDef_Parameters ;
   private String edtMItemBienImgDef_Jsonclick ;
   private String edtMItemBienTitDef_Jsonclick ;
   private String edtMItemBienTextDef_Jsonclick ;
   private String edtMItemHelp_Jsonclick ;
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
   private boolean AV38IsAuthorized_Update ;
   private boolean AV40IsAuthorized_Delete ;
   private boolean AV72IsAuthorized_MItemIcoSVG ;
   private boolean AV50WelcomeMessage_NoMostrarMas ;
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
   private boolean A1938MItemEsMenu ;
   private boolean n1944MItemPadreDef ;
   private boolean A1945MItemPadreObl ;
   private boolean n1957MItemIcoSVG ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV55MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV43TempBoolean ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean AV73WelcomeMessage_Foto_IsBlob ;
   private String AV25TFMenuItemId_SelsJson ;
   private String AV28TFMenuItemTitulo_SelsJson ;
   private String AV68TFMItemPadreDef_SelsJson ;
   private String AV65TFMItemIcoSVG_SelsJson ;
   private String AV59TFMItemBienTitDef_SelsJson ;
   private String AV56TFMItemBienTextDef_SelsJson ;
   private String AV62TFMItemHelp_SelsJson ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String AV54MenuBienveTexto ;
   private String AV20ColumnsSelectorXML ;
   private String AV77ManageFiltersXml ;
   private String AV21UserCustomValue ;
   private String AV52textoNoMostrara ;
   private String A1958MitemIcoImg ;
   private String A1952MItemBienImgDef ;
   private String wcpOAV48MenuOpcCod ;
   private String AV48MenuOpcCod ;
   private String AV26TFMenuItemId ;
   private String AV29TFMenuItemTitulo ;
   private String AV69TFMItemPadreDef ;
   private String AV60TFMItemBienTitDef ;
   private String AV57TFMItemBienTextDef ;
   private String AV63TFMItemHelp ;
   private String AV36GridAppliedFilters ;
   private String A1937MenuItemId ;
   private String A1939MenuItemTitulo ;
   private String A1944MItemPadreDef ;
   private String A1955MItemBienTitDef ;
   private String lV94Menuitemwwds_3_tfmenuitemid ;
   private String lV96Menuitemwwds_5_tfmenuitemtitulo ;
   private String lV99Menuitemwwds_8_tfmitempadredef ;
   private String lV104Menuitemwwds_13_tfmitembientitdef ;
   private String lV106Menuitemwwds_15_tfmitembientextdef ;
   private String lV108Menuitemwwds_17_tfmitemhelp ;
   private String AV94Menuitemwwds_3_tfmenuitemid ;
   private String AV96Menuitemwwds_5_tfmenuitemtitulo ;
   private String AV99Menuitemwwds_8_tfmitempadredef ;
   private String AV104Menuitemwwds_13_tfmitembientitdef ;
   private String AV106Menuitemwwds_15_tfmitembientextdef ;
   private String AV108Menuitemwwds_17_tfmitemhelp ;
   private String A1954MItemBienImgNom ;
   private String A1960MitemIcoImgNom ;
   private String AV51MenuBienveImgURL ;
   private String AV53MenuBienveTitulo ;
   private String AV90Welcomemessage_foto_GXI ;
   private String AV83MenuOpcTitulo ;
   private String AV86filtrosTexto ;
   private String AV74ExcelFilename ;
   private String AV75ErrorMessage ;
   private String AV73WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private GXSimpleCollection<String> AV103Menuitemwwds_12_tfmitemicosvg_sels ;
   private GXSimpleCollection<String> AV95Menuitemwwds_4_tfmenuitemid_sels ;
   private GXSimpleCollection<String> AV97Menuitemwwds_6_tfmenuitemtitulo_sels ;
   private GXSimpleCollection<String> AV100Menuitemwwds_9_tfmitempadredef_sels ;
   private GXSimpleCollection<String> AV105Menuitemwwds_14_tfmitembientitdef_sels ;
   private GXSimpleCollection<String> AV107Menuitemwwds_16_tfmitembientextdef_sels ;
   private GXSimpleCollection<String> AV109Menuitemwwds_18_tfmitemhelp_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkMItemEsMenu ;
   private ICheckbox chkMItemPadreObl ;
   private IDataStoreProvider pr_default ;
   private String[] H00L52_A1954MItemBienImgNom ;
   private String[] H00L52_A1960MitemIcoImgNom ;
   private String[] H00L52_A1953MItemBienImgExt ;
   private String[] H00L52_A1959MItemIcoImgExt ;
   private String[] H00L52_A1961MItemHelp ;
   private String[] H00L52_A1956MItemBienTextDef ;
   private String[] H00L52_A1955MItemBienTitDef ;
   private String[] H00L52_A1952MItemBienImgDef ;
   private String[] H00L52_A1958MitemIcoImg ;
   private String[] H00L52_A1957MItemIcoSVG ;
   private boolean[] H00L52_n1957MItemIcoSVG ;
   private boolean[] H00L52_A1945MItemPadreObl ;
   private String[] H00L52_A1944MItemPadreDef ;
   private boolean[] H00L52_n1944MItemPadreDef ;
   private boolean[] H00L52_A1938MItemEsMenu ;
   private String[] H00L52_A1939MenuItemTitulo ;
   private String[] H00L52_A1937MenuItemId ;
   private byte[] H00L52_A1925PerfilId ;
   private long[] H00L53_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV67TFMItemIcoSVG_Sels ;
   private GXSimpleCollection<String> AV27TFMenuItemId_Sels ;
   private GXSimpleCollection<String> AV30TFMenuItemTitulo_Sels ;
   private GXSimpleCollection<String> AV70TFMItemPadreDef_Sels ;
   private GXSimpleCollection<String> AV61TFMItemBienTitDef_Sels ;
   private GXSimpleCollection<String> AV58TFMItemBienTextDef_Sels ;
   private GXSimpleCollection<String> AV64TFMItemHelp_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV76ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext10[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState25[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV32DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class menuitemww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00L52( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV95Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV97Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV100Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV103Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV105Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV107Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV109Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV92Menuitemwwds_1_tfperfilid ,
                                          byte AV93Menuitemwwds_2_tfperfilid_to ,
                                          int AV95Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV94Menuitemwwds_3_tfmenuitemid ,
                                          int AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV96Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV98Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV100Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV99Menuitemwwds_8_tfmitempadredef ,
                                          byte AV101Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV103Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV102Menuitemwwds_11_tfmitemicosvg ,
                                          int AV105Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV104Menuitemwwds_13_tfmitembientitdef ,
                                          int AV107Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV106Menuitemwwds_15_tfmitembientextdef ,
                                          int AV109Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV108Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[12];
      Object[] GXv_Object27 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " MItemBienImgNom, MitemIcoImgNom, MItemBienImgExt, MItemIcoImgExt, MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemBienImgDef, MitemIcoImg, MItemIcoSVG, MItemPadreObl," ;
      sSelectString += " MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId" ;
      sFromString = " FROM MenuItem" ;
      sOrderString = "" ;
      if ( ! (0==AV92Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int26[0] = (byte)(1) ;
      }
      if ( ! (0==AV93Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int26[1] = (byte)(1) ;
      }
      if ( ( AV95Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( AV95Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV98Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV98Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV100Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( AV100Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV101Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV101Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV103Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV103Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV105Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( AV105Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV107Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( AV107Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV109Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV108Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( AV109Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV109Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY PerfilId DESC, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MenuItemId, PerfilId" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MenuItemId DESC, PerfilId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MenuItemTitulo, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MenuItemTitulo DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemEsMenu, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemEsMenu DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemPadreDef, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemPadreDef DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemPadreObl, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemPadreObl DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemIcoSVG, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemIcoSVG DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemBienTitDef, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemBienTitDef DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemBienTextDef, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemBienTextDef DESC, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY MItemHelp, PerfilId, MenuItemId" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY MItemHelp DESC, PerfilId, MenuItemId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY PerfilId, MenuItemId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
   }

   protected Object[] conditional_H00L53( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV95Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV97Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV100Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV103Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV105Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV107Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV109Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV92Menuitemwwds_1_tfperfilid ,
                                          byte AV93Menuitemwwds_2_tfperfilid_to ,
                                          int AV95Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV94Menuitemwwds_3_tfmenuitemid ,
                                          int AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV96Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV98Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV100Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV99Menuitemwwds_8_tfmitempadredef ,
                                          byte AV101Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV103Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV102Menuitemwwds_11_tfmitemicosvg ,
                                          int AV105Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV104Menuitemwwds_13_tfmitembientitdef ,
                                          int AV107Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV106Menuitemwwds_15_tfmitembientextdef ,
                                          int AV109Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV108Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[9];
      Object[] GXv_Object30 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM MenuItem" ;
      if ( ! (0==AV92Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int29[0] = (byte)(1) ;
      }
      if ( ! (0==AV93Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int29[1] = (byte)(1) ;
      }
      if ( ( AV95Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int29[2] = (byte)(1) ;
      }
      if ( AV95Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int29[3] = (byte)(1) ;
      }
      if ( AV97Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV98Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV98Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV100Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int29[4] = (byte)(1) ;
      }
      if ( AV100Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV101Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV101Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV103Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( AV103Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV105Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( AV105Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV107Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
      }
      if ( AV107Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV109Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV108Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int29[8] = (byte)(1) ;
      }
      if ( AV109Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV109Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
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
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
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
                  return conditional_H00L52(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).shortValue() , ((Boolean) dynConstraints[36]).booleanValue() );
            case 1 :
                  return conditional_H00L53(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).shortValue() , ((Boolean) dynConstraints[36]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00L52", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00L53", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getBLOBFile(8, rslt.getString(3, 20), rslt.getVarchar(1));
               ((String[]) buf[8])[0] = rslt.getBLOBFile(9, rslt.getString(4, 20), rslt.getVarchar(2));
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(11);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((String[]) buf[16])[0] = rslt.getVarchar(15);
               ((byte[]) buf[17])[0] = rslt.getByte(16);
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
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 200);
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
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
      }
   }

}

