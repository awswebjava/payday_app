package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importarliquidacioneswizard2confirmarlsdimport_impl extends GXWebComponent
{
   public importarliquidacioneswizard2confirmarlsdimport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importarliquidacioneswizard2confirmarlsdimport_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarliquidacioneswizard2confirmarlsdimport_impl.class ));
   }

   public importarliquidacioneswizard2confirmarlsdimport_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
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
               AV15WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
               AV13PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13PreviousStep", AV13PreviousStep);
               AV11GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11GoingBack", AV11GoingBack);
               AV21MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21MenuOpcCod", AV21MenuOpcCod);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV15WebSessionKey,AV13PreviousStep,Boolean.valueOf(AV11GoingBack),AV21MenuOpcCod});
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
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paOE2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Importar Liquidaciones Wizard2 Confirmar LSDImport", "")) ;
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
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importarliquidacioneswizard2confirmarlsdimport", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV13PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV11GoingBack)),GXutil.URLEncode(GXutil.rtrim(AV21MenuOpcCod))}, new String[] {"WebSessionKey","PreviousStep","GoingBack","MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV12HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV15WebSessionKey", wcpOAV15WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV13PreviousStep", wcpOAV13PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV11GoingBack", wcpOAV11GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV21MenuOpcCod", wcpOAV21MenuOpcCod);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV12HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV12HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV15WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV21MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQUIDACIONES_GENERADASJSON", AV19liquidaciones_generadasJSON);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV13PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV11GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_btnconfirmar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_btnconfirmar_Result));
   }

   public void renderHtmlCloseFormOE2( )
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
      return "ImportarLiquidacionesWizard2ConfirmarLSDImport" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importar Liquidaciones Wizard2 Confirmar LSDImport", "") ;
   }

   public void wbOE0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importarliquidacioneswizard2confirmarlsdimport");
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompletedimage_Internalname, lblCompletedimage_Caption, "", "", lblCompletedimage_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_ImportarLiquidacionesWizard2ConfirmarLSDImport.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompletedtitle_Internalname, lblCompletedtitle_Caption, "", "", lblCompletedtitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardTextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarLiquidacionesWizard2ConfirmarLSDImport.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompleteddescription_Internalname, lblCompleteddescription_Caption, "", "", lblCompleteddescription_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardTextBlockDescription", 0, "", lblCompleteddescription_Visible, 1, 0, (short)(1), "HLP_ImportarLiquidacionesWizard2ConfirmarLSDImport.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellWizardActions", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnwizardprevious.setProperty("BeforeIconClass", Btnwizardprevious_Beforeiconclass);
         ucBtnwizardprevious.setProperty("Caption", Btnwizardprevious_Caption);
         ucBtnwizardprevious.setProperty("Class", Btnwizardprevious_Class);
         ucBtnwizardprevious.render(context, "wwp_iconbutton", Btnwizardprevious_Internalname, sPrefix+"BTNWIZARDPREVIOUSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "", httpContext.getMessage( "Confirmar Importación", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar Importación", ""), "", StyleString, ClassString, bttBtnconfirmar_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportarLiquidacionesWizard2ConfirmarLSDImport.htm");
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
         wb_table1_26_OE2( true) ;
      }
      else
      {
         wb_table1_26_OE2( false) ;
      }
      return  ;
   }

   public void wb_table1_26_OE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startOE2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Importar Liquidaciones Wizard2 Confirmar LSDImport", ""), (short)(0)) ;
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
            strupOE0( ) ;
         }
      }
   }

   public void wsOE2( )
   {
      startOE2( ) ;
      evtOE2( ) ;
   }

   public void evtOE2( )
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
                              strupOE0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_BTNCONFIRMAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11OE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12OE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
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
                                       /* Execute user event: Enter */
                                       e13OE2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'WIZARDPREVIOUS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardPrevious' */
                                 e14OE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoConfirmar' */
                                 e15OE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e16OE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e17OE2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOE0( ) ;
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
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weOE2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormOE2( ) ;
         }
      }
   }

   public void paOE2( )
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
      rfOE2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rfOE2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e16OE2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e17OE2 ();
         wbOE0( ) ;
      }
   }

   public void send_integrity_lvl_hashesOE2( )
   {
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV12HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV12HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupOE0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12OE2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV15WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV15WebSessionKey") ;
         wcpOAV13PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV13PreviousStep") ;
         wcpOAV11GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV11GoingBack")) ;
         wcpOAV21MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV21MenuOpcCod") ;
         Dvelop_confirmpanel_btnconfirmar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMAR_Result") ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12OE2 ();
      if (returnInSub) return;
   }

   public void e12OE2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV6CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.GXt_int1 = GXv_int2[0] ;
      AV6CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      GXt_int3 = AV9EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.GXt_int3 = GXv_int4[0] ;
      AV9EmpCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      GXv_objcol_svchar5[0] = AV10errores ;
      GXv_int4[0] = AV5cant ;
      GXv_int6[0] = (short)(0) ;
      new web.erroresimportacionlsd(remoteHandle, context).execute( AV6CliCod, AV9EmpCod, (short)(1), GXv_objcol_svchar5, GXv_int4, GXv_int6) ;
      AV10errores = GXv_objcol_svchar5[0] ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.AV5cant = GXv_int4[0] ;
      if ( AV10errores.size() > 0 )
      {
         lblCompletedimage_Caption = httpContext.getMessage( "<i class='fas fa-times' style='font-size: 100px'></i>", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedimage_Internalname, "Caption", lblCompletedimage_Caption, true);
         lblCompletedtitle_Caption = httpContext.getMessage( "Antes de confirmar la importación debe solucionar los siguientes errores:", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Caption", lblCompletedtitle_Caption, true);
         AV8e = (short)(1) ;
         lblCompleteddescription_Caption = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompleteddescription_Internalname, "Caption", lblCompleteddescription_Caption, true);
         while ( AV8e <= AV10errores.size() )
         {
            lblCompleteddescription_Caption = lblCompleteddescription_Caption+GXutil.trim( (String)AV10errores.elementAt(-1+AV8e))+httpContext.getMessage( "<BR>", "") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompleteddescription_Internalname, "Caption", lblCompleteddescription_Caption, true);
            AV8e = (short)(AV8e+1) ;
         }
         bttBtnconfirmar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
      }
      else
      {
         lblCompletedtitle_Caption = httpContext.getMessage( "No se detectaron errores", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Caption", lblCompletedtitle_Caption, true);
         lblCompletedtitle_Caption = httpContext.getMessage( "Al confirmar se importarán las liquidaciones al sistema", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Caption", lblCompletedtitle_Caption, true);
         bttBtnconfirmar_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13OE2 ();
      if (returnInSub) return;
   }

   public void e13OE2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( ! AV12HasValidationErrors )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S122 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'FINISHWIZARD' */
         S132 ();
         if (returnInSub) return;
         AV14WebSession.remove(AV15WebSessionKey);
      }
      /*  Sending Event outputs  */
   }

   public void e14OE2( )
   {
      /* 'WizardPrevious' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      callWebObject(formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim("ConfirmarLSDImport")),GXutil.URLEncode(GXutil.rtrim("ImportLSD")),GXutil.URLEncode(GXutil.booltostr(true)),GXutil.URLEncode(GXutil.rtrim(AV21MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e15OE2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      GXv_objcol_svchar5[0] = AV10errores ;
      GXv_int6[0] = AV5cant ;
      GXv_int4[0] = AV18cantLiq ;
      new web.erroresimportacionlsd(remoteHandle, context).execute( AV6CliCod, AV9EmpCod, (short)(1), GXv_objcol_svchar5, GXv_int6, GXv_int4) ;
      AV10errores = GXv_objcol_svchar5[0] ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.AV5cant = GXv_int6[0] ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.AV18cantLiq = GXv_int4[0] ;
      if ( AV10errores.size() > 0 )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "No se puede importar porque hay errores", "")) ;
      }
      else
      {
         Dvelop_confirmpanel_btnconfirmar_Confirmationtext = httpContext.getMessage( "¿Confirma la importación?", "") ;
         ucDvelop_confirmpanel_btnconfirmar.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_btnconfirmar_Internalname, "ConfirmationText", Dvelop_confirmpanel_btnconfirmar_Confirmationtext);
         this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer", "Confirm", "", new Object[] {});
      }
      /*  Sending Event outputs  */
   }

   public void e11OE2( )
   {
      /* Dvelop_confirmpanel_btnconfirmar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_btnconfirmar_Result, "Yes") == 0 )
      {
         GXv_char7[0] = AV19liquidaciones_generadasJSON ;
         new web.confirmarimportacionliquidacionlsd2(remoteHandle, context).execute( AV6CliCod, AV9EmpCod, (short)(1), GXv_char7) ;
         importarliquidacioneswizard2confirmarlsdimport_impl.this.AV19liquidaciones_generadasJSON = GXv_char7[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19liquidaciones_generadasJSON", AV19liquidaciones_generadasJSON);
      }
      if ( GXutil.strcmp(Dvelop_confirmpanel_btnconfirmar_Result, "Yes") == 0 )
      {
         AV17liquidaciones_generadas.fromJSonString(AV19liquidaciones_generadasJSON, null);
         GXv_char7[0] = AV20error ;
         new web.getestadoliquidaciones(remoteHandle, context).execute( AV6CliCod, AV9EmpCod, AV17liquidaciones_generadas, GXv_char7) ;
         importarliquidacioneswizard2confirmarlsdimport_impl.this.AV20error = GXv_char7[0] ;
         if ( (GXutil.strcmp("", AV20error)==0) )
         {
            if ( AV17liquidaciones_generadas.size() == 1 )
            {
               AV14WebSession.setValue(httpContext.getMessage( "&erroresLiq", ""), httpContext.getMessage( "La liquidación histórica se importó con éxito", ""));
            }
            else
            {
               AV14WebSession.setValue(httpContext.getMessage( "&erroresLiq", ""), httpContext.getMessage( "La liquidaciones históricas se importaron con éxito", ""));
            }
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Importación finalizada", "")) ;
            bttBtnconfirmar_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
            lblCompleteddescription_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompleteddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCompleteddescription_Visible), 5, 0), true);
            lblCompletedtitle_Caption = httpContext.getMessage( "Importación finalizada con éxito", "") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Caption", lblCompletedtitle_Caption, true);
         }
         else
         {
            new web.alert(remoteHandle, context).execute( "info", AV20error) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV16WizardData.fromJSonString(AV14WebSession.getValue(AV15WebSessionKey), null);
   }

   public void S122( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV16WizardData.fromJSonString(AV14WebSession.getValue(AV15WebSessionKey), null);
      AV14WebSession.setValue(AV15WebSessionKey, AV16WizardData.toJSonString(false, true));
   }

   public void S132( )
   {
      /* 'FINISHWIZARD' Routine */
      returnInSub = false ;
   }

   public void e16OE2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV6CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2confirmarlsdimport_impl.this.GXt_int1 = GXv_int2[0] ;
      AV6CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e17OE2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_26_OE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_btnconfirmar_Internalname, tblTabledvelop_confirmpanel_btnconfirmar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_btnconfirmar.setProperty("Title", Dvelop_confirmpanel_btnconfirmar_Title);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("ConfirmationText", Dvelop_confirmpanel_btnconfirmar_Confirmationtext);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("YesButtonCaption", Dvelop_confirmpanel_btnconfirmar_Yesbuttoncaption);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("NoButtonCaption", Dvelop_confirmpanel_btnconfirmar_Nobuttoncaption);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_btnconfirmar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("YesButtonPosition", Dvelop_confirmpanel_btnconfirmar_Yesbuttonposition);
         ucDvelop_confirmpanel_btnconfirmar.setProperty("ConfirmType", Dvelop_confirmpanel_btnconfirmar_Confirmtype);
         ucDvelop_confirmpanel_btnconfirmar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_btnconfirmar_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_26_OE2e( true) ;
      }
      else
      {
         wb_table1_26_OE2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
      AV13PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13PreviousStep", AV13PreviousStep);
      AV11GoingBack = ((Boolean) getParm(obj,2,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11GoingBack", AV11GoingBack);
      AV21MenuOpcCod = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21MenuOpcCod", AV21MenuOpcCod);
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
      paOE2( ) ;
      wsOE2( ) ;
      weOE2( ) ;
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
      sCtrlAV15WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV13PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV11GoingBack = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV21MenuOpcCod = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paOE2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importarliquidacioneswizard2confirmarlsdimport", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paOE2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV15WebSessionKey = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
         AV13PreviousStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13PreviousStep", AV13PreviousStep);
         AV11GoingBack = ((Boolean) getParm(obj,4,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11GoingBack", AV11GoingBack);
         AV21MenuOpcCod = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21MenuOpcCod", AV21MenuOpcCod);
      }
      wcpOAV15WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV15WebSessionKey") ;
      wcpOAV13PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV13PreviousStep") ;
      wcpOAV11GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV11GoingBack")) ;
      wcpOAV21MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV21MenuOpcCod") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV15WebSessionKey, wcpOAV15WebSessionKey) != 0 ) || ( GXutil.strcmp(AV13PreviousStep, wcpOAV13PreviousStep) != 0 ) || ( AV11GoingBack != wcpOAV11GoingBack ) || ( GXutil.strcmp(AV21MenuOpcCod, wcpOAV21MenuOpcCod) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV15WebSessionKey = AV15WebSessionKey ;
      wcpOAV13PreviousStep = AV13PreviousStep ;
      wcpOAV11GoingBack = AV11GoingBack ;
      wcpOAV21MenuOpcCod = AV21MenuOpcCod ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV15WebSessionKey = httpContext.cgiGet( sPrefix+"AV15WebSessionKey_CTRL") ;
      if ( GXutil.len( sCtrlAV15WebSessionKey) > 0 )
      {
         AV15WebSessionKey = httpContext.cgiGet( sCtrlAV15WebSessionKey) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
      }
      else
      {
         AV15WebSessionKey = httpContext.cgiGet( sPrefix+"AV15WebSessionKey_PARM") ;
      }
      sCtrlAV13PreviousStep = httpContext.cgiGet( sPrefix+"AV13PreviousStep_CTRL") ;
      if ( GXutil.len( sCtrlAV13PreviousStep) > 0 )
      {
         AV13PreviousStep = httpContext.cgiGet( sCtrlAV13PreviousStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13PreviousStep", AV13PreviousStep);
      }
      else
      {
         AV13PreviousStep = httpContext.cgiGet( sPrefix+"AV13PreviousStep_PARM") ;
      }
      sCtrlAV11GoingBack = httpContext.cgiGet( sPrefix+"AV11GoingBack_CTRL") ;
      if ( GXutil.len( sCtrlAV11GoingBack) > 0 )
      {
         AV11GoingBack = GXutil.strtobool( httpContext.cgiGet( sCtrlAV11GoingBack)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11GoingBack", AV11GoingBack);
      }
      else
      {
         AV11GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV11GoingBack_PARM")) ;
      }
      sCtrlAV21MenuOpcCod = httpContext.cgiGet( sPrefix+"AV21MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV21MenuOpcCod) > 0 )
      {
         AV21MenuOpcCod = httpContext.cgiGet( sCtrlAV21MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21MenuOpcCod", AV21MenuOpcCod);
      }
      else
      {
         AV21MenuOpcCod = httpContext.cgiGet( sPrefix+"AV21MenuOpcCod_PARM") ;
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
      paOE2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsOE2( ) ;
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
      wsOE2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15WebSessionKey_PARM", AV15WebSessionKey);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV15WebSessionKey)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15WebSessionKey_CTRL", GXutil.rtrim( sCtrlAV15WebSessionKey));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13PreviousStep_PARM", AV13PreviousStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV13PreviousStep)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13PreviousStep_CTRL", GXutil.rtrim( sCtrlAV13PreviousStep));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11GoingBack_PARM", GXutil.booltostr( AV11GoingBack));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11GoingBack)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11GoingBack_CTRL", GXutil.rtrim( sCtrlAV11GoingBack));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV21MenuOpcCod_PARM", AV21MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV21MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV21MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV21MenuOpcCod));
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
      weOE2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020115927", true, true);
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
      httpContext.AddJavascriptSource("importarliquidacioneswizard2confirmarlsdimport.js", "?2024122020115927", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblCompletedimage_Internalname = sPrefix+"COMPLETEDIMAGE" ;
      lblCompletedtitle_Internalname = sPrefix+"COMPLETEDTITLE" ;
      lblCompleteddescription_Internalname = sPrefix+"COMPLETEDDESCRIPTION" ;
      Btnwizardprevious_Internalname = sPrefix+"BTNWIZARDPREVIOUS" ;
      bttBtnconfirmar_Internalname = sPrefix+"BTNCONFIRMAR" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Dvelop_confirmpanel_btnconfirmar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_BTNCONFIRMAR" ;
      tblTabledvelop_confirmpanel_btnconfirmar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_BTNCONFIRMAR" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      Dvelop_confirmpanel_btnconfirmar_Confirmtype = "1" ;
      Dvelop_confirmpanel_btnconfirmar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_btnconfirmar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_btnconfirmar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_btnconfirmar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_btnconfirmar_Title = "" ;
      Dvelop_confirmpanel_btnconfirmar_Confirmationtext = "" ;
      bttBtnconfirmar_Visible = 1 ;
      Btnwizardprevious_Class = "BtnDefault ButtonWizard" ;
      Btnwizardprevious_Caption = httpContext.getMessage( "GXM_previous", "") ;
      Btnwizardprevious_Beforeiconclass = "fas fa-arrow-left" ;
      lblCompleteddescription_Caption = httpContext.getMessage( "WWP_WizardCompletedDescription", "") ;
      lblCompleteddescription_Visible = 1 ;
      lblCompletedtitle_Caption = httpContext.getMessage( "WWP_WizardCompleted", "") ;
      lblCompletedimage_Caption = httpContext.getMessage( "<i class='fas fa-check' style='font-size: 100px'></i>", "") ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV12HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("ENTER","{handler:'e13OE2',iparms:[{av:'AV12HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV15WebSessionKey',fld:'vWEBSESSIONKEY',pic:''}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e14OE2',iparms:[{av:'AV21MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15WebSessionKey',fld:'vWEBSESSIONKEY',pic:''}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[{av:'AV21MenuOpcCod',fld:'vMENUOPCCOD',pic:''}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e15OE2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'Dvelop_confirmpanel_btnconfirmar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_BTNCONFIRMAR',prop:'ConfirmationText'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNCONFIRMAR.CLOSE","{handler:'e11OE2',iparms:[{av:'Dvelop_confirmpanel_btnconfirmar_Result',ctrl:'DVELOP_CONFIRMPANEL_BTNCONFIRMAR',prop:'Result'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV19liquidaciones_generadasJSON',fld:'vLIQUIDACIONES_GENERADASJSON',pic:''}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNCONFIRMAR.CLOSE",",oparms:[{av:'AV19liquidaciones_generadasJSON',fld:'vLIQUIDACIONES_GENERADASJSON',pic:''},{ctrl:'BTNCONFIRMAR',prop:'Visible'},{av:'lblCompleteddescription_Visible',ctrl:'COMPLETEDDESCRIPTION',prop:'Visible'},{av:'lblCompletedtitle_Caption',ctrl:'COMPLETEDTITLE',prop:'Caption'}]}");
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
      wcpOAV15WebSessionKey = "" ;
      wcpOAV13PreviousStep = "" ;
      wcpOAV21MenuOpcCod = "" ;
      Dvelop_confirmpanel_btnconfirmar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV15WebSessionKey = "" ;
      AV13PreviousStep = "" ;
      AV21MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV19liquidaciones_generadasJSON = "" ;
      GX_FocusControl = "" ;
      lblCompletedimage_Jsonclick = "" ;
      lblCompletedtitle_Jsonclick = "" ;
      lblCompleteddescription_Jsonclick = "" ;
      ucBtnwizardprevious = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14WebSession = httpContext.getWebSession();
      GXv_objcol_svchar5 = new GXSimpleCollection[1] ;
      GXv_int6 = new short[1] ;
      GXv_int4 = new short[1] ;
      ucDvelop_confirmpanel_btnconfirmar = new com.genexus.webpanels.GXUserControl();
      AV17liquidaciones_generadas = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV20error = "" ;
      GXv_char7 = new String[1] ;
      AV16WizardData = new web.SdtImportarLiquidacionesWizard2Data(remoteHandle, context);
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV15WebSessionKey = "" ;
      sCtrlAV13PreviousStep = "" ;
      sCtrlAV11GoingBack = "" ;
      sCtrlAV21MenuOpcCod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV9EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int3 ;
   private short AV5cant ;
   private short AV8e ;
   private short GXv_int6[] ;
   private short AV18cantLiq ;
   private short GXv_int4[] ;
   private int AV6CliCod ;
   private int lblCompleteddescription_Visible ;
   private int bttBtnconfirmar_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String Dvelop_confirmpanel_btnconfirmar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblCompletedimage_Internalname ;
   private String lblCompletedimage_Caption ;
   private String lblCompletedimage_Jsonclick ;
   private String lblCompletedtitle_Internalname ;
   private String lblCompletedtitle_Caption ;
   private String lblCompletedtitle_Jsonclick ;
   private String lblCompleteddescription_Internalname ;
   private String lblCompleteddescription_Caption ;
   private String lblCompleteddescription_Jsonclick ;
   private String divTableactions_Internalname ;
   private String Btnwizardprevious_Beforeiconclass ;
   private String Btnwizardprevious_Caption ;
   private String Btnwizardprevious_Class ;
   private String Btnwizardprevious_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String Dvelop_confirmpanel_btnconfirmar_Confirmationtext ;
   private String Dvelop_confirmpanel_btnconfirmar_Internalname ;
   private String GXv_char7[] ;
   private String sStyleString ;
   private String tblTabledvelop_confirmpanel_btnconfirmar_Internalname ;
   private String Dvelop_confirmpanel_btnconfirmar_Title ;
   private String Dvelop_confirmpanel_btnconfirmar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_btnconfirmar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_btnconfirmar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_btnconfirmar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_btnconfirmar_Confirmtype ;
   private String sCtrlAV15WebSessionKey ;
   private String sCtrlAV13PreviousStep ;
   private String sCtrlAV11GoingBack ;
   private String sCtrlAV21MenuOpcCod ;
   private boolean wcpOAV11GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11GoingBack ;
   private boolean AV12HasValidationErrors ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV15WebSessionKey ;
   private String wcpOAV13PreviousStep ;
   private String wcpOAV21MenuOpcCod ;
   private String AV15WebSessionKey ;
   private String AV13PreviousStep ;
   private String AV21MenuOpcCod ;
   private String AV19liquidaciones_generadasJSON ;
   private String AV20error ;
   private GXSimpleCollection<Integer> AV17liquidaciones_generadas ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardprevious ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_btnconfirmar ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private GXSimpleCollection<String> AV10errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar5[] ;
   private web.SdtImportarLiquidacionesWizard2Data AV16WizardData ;
}

