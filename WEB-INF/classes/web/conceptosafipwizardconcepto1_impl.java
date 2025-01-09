package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptosafipwizardconcepto1_impl extends GXWebComponent
{
   public conceptosafipwizardconcepto1_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptosafipwizardconcepto1_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosafipwizardconcepto1_impl.class ));
   }

   public conceptosafipwizardconcepto1_impl( int remoteHandle ,
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
      dynavConafipsubt1 = new HTMLChoice();
      dynavConafipconcepto = new HTMLChoice();
      cmbavConafipsipaapo = new HTMLChoice();
      cmbavConafipinssjypapo = new HTMLChoice();
      cmbavConafipobrasocapo = new HTMLChoice();
      cmbavConafipfonsolredapo = new HTMLChoice();
      cmbavConafiprenateaapo = new HTMLChoice();
      cmbavConafipregdifapo = new HTMLChoice();
      cmbavConafipregespapo = new HTMLChoice();
      cmbavConafipsipacont = new HTMLChoice();
      cmbavConafipinssjypcont = new HTMLChoice();
      cmbavConafipobrasoccont = new HTMLChoice();
      cmbavConafipfonsolredcont = new HTMLChoice();
      cmbavConafiprenateacont = new HTMLChoice();
      cmbavConafipasigfamcont = new HTMLChoice();
      cmbavConafipfonnacempcont = new HTMLChoice();
      cmbavConafipleyrietrabcont = new HTMLChoice();
      cmbavConafiptipo = new HTMLChoice();
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
               AV6WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
               AV8PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
               AV7GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV6WebSessionKey,AV8PreviousStep,Boolean.valueOf(AV7GoingBack)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vCONAFIPSUBT1") == 0 )
            {
               AV32ConAFIPTipo = httpContext.GetPar( "ConAFIPTipo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvconafipsubt16Y2( AV32ConAFIPTipo) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vCONAFIPCONCEPTO") == 0 )
            {
               AV32ConAFIPTipo = httpContext.GetPar( "ConAFIPTipo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
               AV33ConAfipSubT1 = httpContext.GetPar( "ConAfipSubT1") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", AV33ConAfipSubT1);
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvconafipconcepto6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
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
         pa6Y2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Conceptos Afip Wizard Concepto1", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptosafipwizardconcepto1", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV8PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV7GoingBack))}, new String[] {"WebSessionKey","PreviousStep","GoingBack"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPROPIO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV30Propio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6WebSessionKey", wcpOAV6WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8PreviousStep", wcpOAV8PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV7GoingBack", wcpOAV7GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV12CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPROPIO", GXutil.rtrim( AV30Propio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPROPIO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV30Propio, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV6WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV8PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV7GoingBack);
   }

   public void renderHtmlCloseForm6Y2( )
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
      return "ConceptosAfipWizardConcepto1" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos Afip Wizard Concepto1", "") ;
   }

   public void wb6Y0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptosafipwizardconcepto1");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableinfo_Internalname, 1, 0, "px", 0, "px", "TableStepInfo", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_12_6Y2( true) ;
      }
      else
      {
         wb_table1_12_6Y2( false) ;
      }
      return  ;
   }

   public void wb_table1_12_6Y2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellWizardActions", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;justify-content:space-between;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnwizardprevious.setProperty("BeforeIconClass", Btnwizardprevious_Beforeiconclass);
         ucBtnwizardprevious.setProperty("Caption", Btnwizardprevious_Caption);
         ucBtnwizardprevious.setProperty("Class", Btnwizardprevious_Class);
         ucBtnwizardprevious.render(context, "wwp_iconbutton", Btnwizardprevious_Internalname, sPrefix+"BTNWIZARDPREVIOUSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnwizardnext.setProperty("AfterIconClass", Btnwizardnext_Aftericonclass);
         ucBtnwizardnext.setProperty("Caption", Btnwizardnext_Caption);
         ucBtnwizardnext.setProperty("Class", Btnwizardnext_Class);
         ucBtnwizardnext.render(context, "wwp_iconbutton", Btnwizardnext_Internalname, sPrefix+"BTNWIZARDNEXTContainer");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafiptipo, cmbavConafiptipo.getInternalname(), GXutil.rtrim( AV32ConAFIPTipo), 1, cmbavConafiptipo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPTIPO.CLICK."+"'", "char", "", cmbavConafiptipo.getVisible(), 1, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,140);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafiptipo.setValue( GXutil.rtrim( AV32ConAFIPTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiptipo.getInternalname(), "Values", cmbavConafiptipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6Y2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos Afip Wizard Concepto1", ""), (short)(0)) ;
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
            strup6Y0( ) ;
         }
      }
   }

   public void ws6Y2( )
   {
      start6Y2( ) ;
      evt6Y2( ) ;
   }

   public void evt6Y2( )
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
                              strup6Y0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e116Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
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
                                       e126Y2 ();
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
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardPrevious' */
                                 e136Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e146Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPCONCEPTO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e156Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPSUBT1.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e166Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPSIPAAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e176Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPINSSJYPAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e186Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPOBRASOCAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e196Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPFONSOLREDAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e206Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPRENATEAAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e216Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPREGDIFAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e226Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPREGESPAPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e236Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPSIPACONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e246Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPINSSJYPCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e256Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPOBRASOCCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e266Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPFONSOLREDCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e276Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPRENATEACONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e286Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPASIGFAMCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e296Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPFONNACEMPCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e306Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPLEYRIETRABCONT.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e316Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONAFIPTIPO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e326Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIBRE.ISVALID") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e336Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e346Y2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = dynavConafipsubt1.getInternalname() ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void we6Y2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6Y2( ) ;
         }
      }
   }

   public void pa6Y2( )
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
            GX_FocusControl = dynavConafipsubt1.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvconafipsubt1_html6Y2( AV32ConAFIPTipo) ;
      gxvvconafipconcepto_html6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
      /* End function dynload_actions */
   }

   public void gxdlvvconafipsubt16Y2( String AV32ConAFIPTipo )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvconafipsubt1_data6Y2( AV32ConAFIPTipo) ;
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

   public void gxvvconafipsubt1_html6Y2( String AV32ConAFIPTipo )
   {
      String gxdynajaxvalue;
      gxdlvvconafipsubt1_data6Y2( AV32ConAFIPTipo) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConafipsubt1.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConafipsubt1.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvconafipsubt1_data6Y2( String AV32ConAFIPTipo )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H006Y2 */
      pr_default.execute(0, new Object[] {AV32ConAFIPTipo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H006Y2_A38SubTipoConCod1[0]));
         gxdynajaxctrldescr.add(H006Y2_A371SubTipoConDes1[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvconafipconcepto6Y2( String AV32ConAFIPTipo ,
                                         String AV33ConAfipSubT1 )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvconafipconcepto_data6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
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

   public void gxvvconafipconcepto_html6Y2( String AV32ConAFIPTipo ,
                                            String AV33ConAfipSubT1 )
   {
      String gxdynajaxvalue;
      gxdlvvconafipconcepto_data6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConafipconcepto.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConafipconcepto.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvconafipconcepto_data6Y2( String AV32ConAFIPTipo ,
                                                 String AV33ConAfipSubT1 )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H006Y3 */
      pr_default.execute(1, new Object[] {AV32ConAFIPTipo, AV33ConAfipSubT1});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H006Y3_A72AFIPConCod[0]));
         gxdynajaxctrldescr.add(H006Y3_A385AfipConCodMasDesc[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
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
      if ( dynavConafipsubt1.getItemCount() > 0 )
      {
         AV33ConAfipSubT1 = dynavConafipsubt1.getValidValue(AV33ConAfipSubT1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", AV33ConAfipSubT1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConafipsubt1.setValue( GXutil.rtrim( AV33ConAfipSubT1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipsubt1.getInternalname(), "Values", dynavConafipsubt1.ToJavascriptSource(), true);
      }
      if ( dynavConafipconcepto.getItemCount() > 0 )
      {
         AV34ConAFIPConcepto = dynavConafipconcepto.getValidValue(AV34ConAFIPConcepto) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", AV34ConAFIPConcepto);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipconcepto.getInternalname(), "Values", dynavConafipconcepto.ToJavascriptSource(), true);
      }
      if ( cmbavConafipsipaapo.getItemCount() > 0 )
      {
         AV15ConAFIPSIPAApo = cmbavConafipsipaapo.getValidValue(AV15ConAFIPSIPAApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipsipaapo.setValue( GXutil.rtrim( AV15ConAFIPSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipaapo.getInternalname(), "Values", cmbavConafipsipaapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipinssjypapo.getItemCount() > 0 )
      {
         AV16ConAFIPINSSJyPApo = cmbavConafipinssjypapo.getValidValue(AV16ConAFIPINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipinssjypapo.setValue( GXutil.rtrim( AV16ConAFIPINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypapo.getInternalname(), "Values", cmbavConafipinssjypapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipobrasocapo.getItemCount() > 0 )
      {
         AV17ConAFIPObraSocApo = cmbavConafipobrasocapo.getValidValue(AV17ConAFIPObraSocApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipobrasocapo.setValue( GXutil.rtrim( AV17ConAFIPObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasocapo.getInternalname(), "Values", cmbavConafipobrasocapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipfonsolredapo.getItemCount() > 0 )
      {
         AV18ConAFIPFonSolRedApo = cmbavConafipfonsolredapo.getValidValue(AV18ConAFIPFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipfonsolredapo.setValue( GXutil.rtrim( AV18ConAFIPFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredapo.getInternalname(), "Values", cmbavConafipfonsolredapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafiprenateaapo.getItemCount() > 0 )
      {
         AV19ConAFIPRenateaApo = cmbavConafiprenateaapo.getValidValue(AV19ConAFIPRenateaApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafiprenateaapo.setValue( GXutil.rtrim( AV19ConAFIPRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateaapo.getInternalname(), "Values", cmbavConafiprenateaapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipregdifapo.getItemCount() > 0 )
      {
         AV20ConAFIPRegDifApo = cmbavConafipregdifapo.getValidValue(AV20ConAFIPRegDifApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipregdifapo.setValue( GXutil.rtrim( AV20ConAFIPRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregdifapo.getInternalname(), "Values", cmbavConafipregdifapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipregespapo.getItemCount() > 0 )
      {
         AV21ConAFIPRegEspApo = cmbavConafipregespapo.getValidValue(AV21ConAFIPRegEspApo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipregespapo.setValue( GXutil.rtrim( AV21ConAFIPRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregespapo.getInternalname(), "Values", cmbavConafipregespapo.ToJavascriptSource(), true);
      }
      if ( cmbavConafipsipacont.getItemCount() > 0 )
      {
         AV22ConAFIPSIPACont = cmbavConafipsipacont.getValidValue(AV22ConAFIPSIPACont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipsipacont.setValue( GXutil.rtrim( AV22ConAFIPSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipacont.getInternalname(), "Values", cmbavConafipsipacont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipinssjypcont.getItemCount() > 0 )
      {
         AV23ConAFIPINSSJyPCont = cmbavConafipinssjypcont.getValidValue(AV23ConAFIPINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipinssjypcont.setValue( GXutil.rtrim( AV23ConAFIPINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypcont.getInternalname(), "Values", cmbavConafipinssjypcont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipobrasoccont.getItemCount() > 0 )
      {
         AV24ConAFIPObraSocCont = cmbavConafipobrasoccont.getValidValue(AV24ConAFIPObraSocCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipobrasoccont.setValue( GXutil.rtrim( AV24ConAFIPObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasoccont.getInternalname(), "Values", cmbavConafipobrasoccont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipfonsolredcont.getItemCount() > 0 )
      {
         AV25ConAFIPFonSolRedCont = cmbavConafipfonsolredcont.getValidValue(AV25ConAFIPFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipfonsolredcont.setValue( GXutil.rtrim( AV25ConAFIPFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredcont.getInternalname(), "Values", cmbavConafipfonsolredcont.ToJavascriptSource(), true);
      }
      if ( cmbavConafiprenateacont.getItemCount() > 0 )
      {
         AV26ConAFIPRenateaCont = cmbavConafiprenateacont.getValidValue(AV26ConAFIPRenateaCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafiprenateacont.setValue( GXutil.rtrim( AV26ConAFIPRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateacont.getInternalname(), "Values", cmbavConafiprenateacont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipasigfamcont.getItemCount() > 0 )
      {
         AV27ConAFIPAsigFamCont = cmbavConafipasigfamcont.getValidValue(AV27ConAFIPAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipasigfamcont.setValue( GXutil.rtrim( AV27ConAFIPAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipasigfamcont.getInternalname(), "Values", cmbavConafipasigfamcont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipfonnacempcont.getItemCount() > 0 )
      {
         AV28ConAFIPFonNacEmpCont = cmbavConafipfonnacempcont.getValidValue(AV28ConAFIPFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipfonnacempcont.setValue( GXutil.rtrim( AV28ConAFIPFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonnacempcont.getInternalname(), "Values", cmbavConafipfonnacempcont.ToJavascriptSource(), true);
      }
      if ( cmbavConafipleyrietrabcont.getItemCount() > 0 )
      {
         AV29ConAFIPLeyRieTrabCont = cmbavConafipleyrietrabcont.getValidValue(AV29ConAFIPLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafipleyrietrabcont.setValue( GXutil.rtrim( AV29ConAFIPLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipleyrietrabcont.getInternalname(), "Values", cmbavConafipleyrietrabcont.ToJavascriptSource(), true);
      }
      if ( cmbavConafiptipo.getItemCount() > 0 )
      {
         AV32ConAFIPTipo = cmbavConafiptipo.getValidValue(AV32ConAFIPTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConafiptipo.setValue( GXutil.rtrim( AV32ConAFIPTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiptipo.getInternalname(), "Values", cmbavConafiptipo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6Y2( ) ;
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

   public void rf6Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e146Y2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e346Y2 ();
         wb6Y0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6Y2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV12CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPROPIO", GXutil.rtrim( AV30Propio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPROPIO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV30Propio, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
         wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
         wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
         /* Read variables values. */
         dynavConafipsubt1.setValue( httpContext.cgiGet( dynavConafipsubt1.getInternalname()) );
         AV33ConAfipSubT1 = httpContext.cgiGet( dynavConafipsubt1.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", AV33ConAfipSubT1);
         dynavConafipconcepto.setValue( httpContext.cgiGet( dynavConafipconcepto.getInternalname()) );
         AV34ConAFIPConcepto = httpContext.cgiGet( dynavConafipconcepto.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", AV34ConAFIPConcepto);
         AV35libre = httpContext.cgiGet( edtavLibre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35libre", AV35libre);
         cmbavConafipsipaapo.setValue( httpContext.cgiGet( cmbavConafipsipaapo.getInternalname()) );
         AV15ConAFIPSIPAApo = httpContext.cgiGet( cmbavConafipsipaapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
         cmbavConafipinssjypapo.setValue( httpContext.cgiGet( cmbavConafipinssjypapo.getInternalname()) );
         AV16ConAFIPINSSJyPApo = httpContext.cgiGet( cmbavConafipinssjypapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
         cmbavConafipobrasocapo.setValue( httpContext.cgiGet( cmbavConafipobrasocapo.getInternalname()) );
         AV17ConAFIPObraSocApo = httpContext.cgiGet( cmbavConafipobrasocapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
         cmbavConafipfonsolredapo.setValue( httpContext.cgiGet( cmbavConafipfonsolredapo.getInternalname()) );
         AV18ConAFIPFonSolRedApo = httpContext.cgiGet( cmbavConafipfonsolredapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
         cmbavConafiprenateaapo.setValue( httpContext.cgiGet( cmbavConafiprenateaapo.getInternalname()) );
         AV19ConAFIPRenateaApo = httpContext.cgiGet( cmbavConafiprenateaapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
         cmbavConafipregdifapo.setValue( httpContext.cgiGet( cmbavConafipregdifapo.getInternalname()) );
         AV20ConAFIPRegDifApo = httpContext.cgiGet( cmbavConafipregdifapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
         cmbavConafipregespapo.setValue( httpContext.cgiGet( cmbavConafipregespapo.getInternalname()) );
         AV21ConAFIPRegEspApo = httpContext.cgiGet( cmbavConafipregespapo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
         cmbavConafipsipacont.setValue( httpContext.cgiGet( cmbavConafipsipacont.getInternalname()) );
         AV22ConAFIPSIPACont = httpContext.cgiGet( cmbavConafipsipacont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
         cmbavConafipinssjypcont.setValue( httpContext.cgiGet( cmbavConafipinssjypcont.getInternalname()) );
         AV23ConAFIPINSSJyPCont = httpContext.cgiGet( cmbavConafipinssjypcont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
         cmbavConafipobrasoccont.setValue( httpContext.cgiGet( cmbavConafipobrasoccont.getInternalname()) );
         AV24ConAFIPObraSocCont = httpContext.cgiGet( cmbavConafipobrasoccont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
         cmbavConafipfonsolredcont.setValue( httpContext.cgiGet( cmbavConafipfonsolredcont.getInternalname()) );
         AV25ConAFIPFonSolRedCont = httpContext.cgiGet( cmbavConafipfonsolredcont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
         cmbavConafiprenateacont.setValue( httpContext.cgiGet( cmbavConafiprenateacont.getInternalname()) );
         AV26ConAFIPRenateaCont = httpContext.cgiGet( cmbavConafiprenateacont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
         cmbavConafipasigfamcont.setValue( httpContext.cgiGet( cmbavConafipasigfamcont.getInternalname()) );
         AV27ConAFIPAsigFamCont = httpContext.cgiGet( cmbavConafipasigfamcont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
         cmbavConafipfonnacempcont.setValue( httpContext.cgiGet( cmbavConafipfonnacempcont.getInternalname()) );
         AV28ConAFIPFonNacEmpCont = httpContext.cgiGet( cmbavConafipfonnacempcont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
         cmbavConafipleyrietrabcont.setValue( httpContext.cgiGet( cmbavConafipleyrietrabcont.getInternalname()) );
         AV29ConAFIPLeyRieTrabCont = httpContext.cgiGet( cmbavConafipleyrietrabcont.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
         cmbavConafiptipo.setValue( httpContext.cgiGet( cmbavConafiptipo.getInternalname()) );
         AV32ConAFIPTipo = httpContext.cgiGet( cmbavConafiptipo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
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
      e116Y2 ();
      if (returnInSub) return;
   }

   public void e116Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV30Propio = AV5WebSession.getValue(httpContext.getMessage( "ConCodPropio", "")) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30Propio", AV30Propio);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPROPIO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV30Propio, ""))));
      GXt_int1 = AV12CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptosafipwizardconcepto1_impl.this.GXt_int1 = GXv_int2[0] ;
      AV12CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      cmbavConafiptipo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiptipo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConafiptipo.getVisible(), 5, 0), true);
      GXv_char3[0] = AV52ConDescrip ;
      new web.conceptogetdescri(remoteHandle, context).execute( AV12CliCod, AV30Propio, GXv_char3) ;
      conceptosafipwizardconcepto1_impl.this.AV52ConDescrip = GXv_char3[0] ;
      Dvpanel_panelafip_Title = httpContext.getMessage( "Concepto ", "")+GXutil.trim( AV30Propio)+" - "+GXutil.trim( AV52ConDescrip) ;
      ucDvpanel_panelafip.sendProperty(context, sPrefix, false, Dvpanel_panelafip_Internalname, "Title", Dvpanel_panelafip_Title);
      if ( GXutil.strcmp(AV32ConAFIPTipo, "REM_ARG") == 0 )
      {
         lblTipo_Caption = httpContext.getMessage( "Remunerativo Tipo", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTipo_Internalname, "Caption", lblTipo_Caption, true);
      }
      else
      {
         if ( GXutil.strcmp(AV32ConAFIPTipo, "DES_ARG") == 0 )
         {
            lblTipo_Caption = httpContext.getMessage( "Descuento Tipo", "") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTipo_Internalname, "Caption", lblTipo_Caption, true);
         }
         else
         {
            lblTipo_Caption = httpContext.getMessage( "No Remunerativo Tipo", "") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTipo_Internalname, "Caption", lblTipo_Caption, true);
         }
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e126Y2 ();
      if (returnInSub) return;
   }

   public void e126Y2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( true )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S122 ();
         if (returnInSub) return;
         GXv_objcol_svchar4[0] = AV50error ;
         new web.validarwizardconceptosafip(remoteHandle, context).execute( AV12CliCod, AV30Propio, GXv_objcol_svchar4) ;
         AV50error = GXv_objcol_svchar4[0] ;
         if ( AV50error.size() > 0 )
         {
            AV51e = (short)(1) ;
            while ( AV51e <= AV50error.size() )
            {
               httpContext.GX_msglist.addItem((String)AV50error.elementAt(-1+AV51e));
               AV51e = (short)(AV51e+1) ;
            }
         }
         else
         {
            AV44proximoPaso = AV5WebSession.getValue(httpContext.getMessage( "proximoPaso", "")) ;
            callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV30Propio))),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV44proximoPaso))),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      else
      {
         if ( ! AV10HasValidationErrors )
         {
            /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
            S122 ();
            if (returnInSub) return;
            callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim("Concepto1")),GXutil.URLEncode(GXutil.rtrim("paso2Dummy")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void e136Y2( )
   {
      /* 'WizardPrevious' Routine */
      returnInSub = false ;
      if ( true )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S122 ();
         if (returnInSub) return;
         AV45steps.fromJSonString(AV5WebSession.getValue(httpContext.getMessage( "&WizardSteps", "")), null);
         AV47anterior = "" ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV45steps.size() )
         {
            AV46step = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV45steps.elementAt(-1+AV58GXV1));
            if ( GXutil.strcmp(GXutil.trim( AV46step.getgxTv_SdtWizardSteps_WizardStepsItem_Code()), GXutil.trim( AV30Propio)) == 0 )
            {
               if (true) break;
            }
            AV47anterior = GXutil.trim( AV46step.getgxTv_SdtWizardSteps_WizardStepsItem_Code()) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
         callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(AV47anterior)),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S122 ();
         if (returnInSub) return;
         callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim("Concepto1")),GXutil.URLEncode(GXutil.rtrim("Inicio")),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV15ConAFIPSIPAApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
      AV16ConAFIPINSSJyPApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
      AV17ConAFIPObraSocApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
      AV18ConAFIPFonSolRedApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
      AV19ConAFIPRenateaApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
      AV20ConAFIPRegDifApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
      AV21ConAFIPRegEspApo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
      AV22ConAFIPSIPACont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
      AV23ConAFIPINSSJyPCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
      AV24ConAFIPObraSocCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
      AV25ConAFIPFonSolRedCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
      AV26ConAFIPRenateaCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
      AV27ConAFIPAsigFamCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
      AV28ConAFIPFonNacEmpCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
      AV29ConAFIPLeyRieTrabCont = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
      AV33ConAfipSubT1 = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", AV33ConAfipSubT1);
      AV34ConAFIPConcepto = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", AV34ConAFIPConcepto);
      AV35libre = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35libre", AV35libre);
      AV32ConAFIPTipo = AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
      if ( (GXutil.strcmp("", AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo())==0) )
      {
         /* Using cursor H006Y4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV12CliCod), AV30Propio});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A380ConAFIPTipo = H006Y4_A380ConAFIPTipo[0] ;
            A381ConAfipSubT1 = H006Y4_A381ConAfipSubT1[0] ;
            A386ConAFIPConcepto = H006Y4_A386ConAFIPConcepto[0] ;
            n386ConAFIPConcepto = H006Y4_n386ConAFIPConcepto[0] ;
            A141ConAFIPSIPAApo = H006Y4_A141ConAFIPSIPAApo[0] ;
            A142ConAFIPSIPACont = H006Y4_A142ConAFIPSIPACont[0] ;
            A131ConAFIPINSSJyPApo = H006Y4_A131ConAFIPINSSJyPApo[0] ;
            A132ConAFIPINSSJyPCont = H006Y4_A132ConAFIPINSSJyPCont[0] ;
            A135ConAFIPObraSocApo = H006Y4_A135ConAFIPObraSocApo[0] ;
            A136ConAFIPObraSocCont = H006Y4_A136ConAFIPObraSocCont[0] ;
            A129ConAFIPFonSolRedApo = H006Y4_A129ConAFIPFonSolRedApo[0] ;
            A130ConAFIPFonSolRedCont = H006Y4_A130ConAFIPFonSolRedCont[0] ;
            A139ConAFIPRenateaApo = H006Y4_A139ConAFIPRenateaApo[0] ;
            A140ConAFIPRenateaCont = H006Y4_A140ConAFIPRenateaCont[0] ;
            A127ConAFIPAsigFamCont = H006Y4_A127ConAFIPAsigFamCont[0] ;
            A128ConAFIPFonNacEmpCont = H006Y4_A128ConAFIPFonNacEmpCont[0] ;
            A133ConAFIPLeyRieTrabCont = H006Y4_A133ConAFIPLeyRieTrabCont[0] ;
            A137ConAFIPRegDifApo = H006Y4_A137ConAFIPRegDifApo[0] ;
            A138ConAFIPRegEspApo = H006Y4_A138ConAFIPRegEspApo[0] ;
            A379ConAfipEstado = H006Y4_A379ConAfipEstado[0] ;
            A382ConAfipSubT2 = H006Y4_A382ConAfipSubT2[0] ;
            A383ConAfipDesc = H006Y4_A383ConAfipDesc[0] ;
            A73ConCodPropio = H006Y4_A73ConCodPropio[0] ;
            A3CliCod = H006Y4_A3CliCod[0] ;
            GXt_char5 = A391ConAfipSubT2Def ;
            GXv_char3[0] = GXt_char5 ;
            new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char3) ;
            conceptosafipwizardconcepto1_impl.this.GXt_char5 = GXv_char3[0] ;
            A391ConAfipSubT2Def = GXt_char5 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
            GXt_char5 = A390ConAfipSubT1Def ;
            GXv_char3[0] = GXt_char5 ;
            new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char3) ;
            conceptosafipwizardconcepto1_impl.this.GXt_char5 = GXv_char3[0] ;
            A390ConAfipSubT1Def = GXt_char5 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
            GXt_char5 = A389ConAFIPTipoDef ;
            GXv_char3[0] = GXt_char5 ;
            new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char3) ;
            conceptosafipwizardconcepto1_impl.this.GXt_char5 = GXv_char3[0] ;
            A389ConAFIPTipoDef = GXt_char5 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
            AV32ConAFIPTipo = A380ConAFIPTipo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32ConAFIPTipo", AV32ConAFIPTipo);
            AV33ConAfipSubT1 = A381ConAfipSubT1 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", AV33ConAfipSubT1);
            GXt_boolean6 = AV49existeAfipConcepto ;
            GXv_boolean7[0] = GXt_boolean6 ;
            new web.existeafipconcepto(remoteHandle, context).execute( A386ConAFIPConcepto, GXv_boolean7) ;
            conceptosafipwizardconcepto1_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
            AV49existeAfipConcepto = GXt_boolean6 ;
            if ( AV49existeAfipConcepto )
            {
               AV34ConAFIPConcepto = A386ConAFIPConcepto ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", AV34ConAFIPConcepto);
            }
            else
            {
               if ( ! (GXutil.strcmp("", A386ConAFIPConcepto)==0) )
               {
                  AV35libre = GXutil.trim( A386ConAFIPConcepto) ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35libre", AV35libre);
               }
            }
            AV15ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
            AV22ConAFIPSIPACont = A142ConAFIPSIPACont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
            AV16ConAFIPINSSJyPApo = A131ConAFIPINSSJyPApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
            AV23ConAFIPINSSJyPCont = A132ConAFIPINSSJyPCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
            AV17ConAFIPObraSocApo = A135ConAFIPObraSocApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
            AV24ConAFIPObraSocCont = A136ConAFIPObraSocCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
            AV18ConAFIPFonSolRedApo = A129ConAFIPFonSolRedApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
            AV25ConAFIPFonSolRedCont = A130ConAFIPFonSolRedCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
            AV19ConAFIPRenateaApo = A139ConAFIPRenateaApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
            AV26ConAFIPRenateaCont = A140ConAFIPRenateaCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
            AV27ConAFIPAsigFamCont = A127ConAFIPAsigFamCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
            AV28ConAFIPFonNacEmpCont = A128ConAFIPFonNacEmpCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
            AV29ConAFIPLeyRieTrabCont = A133ConAFIPLeyRieTrabCont ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
            AV20ConAFIPRegDifApo = A137ConAFIPRegDifApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
            AV21ConAFIPRegEspApo = A138ConAFIPRegEspApo ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
            AV39ConAfipEstado = A379ConAfipEstado ;
            AV40ConAfipSubT2 = A382ConAfipSubT2 ;
            AV31ConAfipDesc = A383ConAfipDesc ;
            AV41ConAFIPTipoDef = A389ConAFIPTipoDef ;
            AV42ConAfipSubT1Def = A390ConAfipSubT1Def ;
            AV43ConAfipSubT2Def = A391ConAfipSubT2Def ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
      /* Execute user subroutine: 'ACTUALIZAR PERMISIBLES' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LIBRE VISIBLE' */
      S132 ();
      if (returnInSub) return;
   }

   public void S122( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo( AV15ConAFIPSIPAApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo( AV16ConAFIPINSSJyPApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo( AV17ConAFIPObraSocApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo( AV18ConAFIPFonSolRedApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo( AV19ConAFIPRenateaApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo( AV20ConAFIPRegDifApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo( AV21ConAFIPRegEspApo );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont( AV22ConAFIPSIPACont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont( AV23ConAFIPINSSJyPCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont( AV24ConAFIPObraSocCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont( AV25ConAFIPFonSolRedCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont( AV26ConAFIPRenateaCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont( AV27ConAFIPAsigFamCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont( AV28ConAFIPFonNacEmpCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont( AV29ConAFIPLeyRieTrabCont );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1( AV33ConAfipSubT1 );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto( AV34ConAFIPConcepto );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Libre( AV35libre );
      AV11WizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().setgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo( AV32ConAFIPTipo );
      AV5WebSession.setValue(AV6WebSessionKey, AV11WizardData.toJSonString(false, true));
      new web.grabaconceptoafip(remoteHandle, context).execute( AV12CliCod, AV30Propio, AV11WizardData) ;
   }

   public void e146Y2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV12CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptosafipwizardconcepto1_impl.this.GXt_int1 = GXv_int2[0] ;
      AV12CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e156Y2( )
   {
      /* Conafipconcepto_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LIBRE VISIBLE' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e166Y2( )
   {
      /* Conafipsubt1_Click Routine */
      returnInSub = false ;
      GXv_char3[0] = AV34ConAFIPConcepto ;
      new web.autoselconafip(remoteHandle, context).execute( AV33ConAfipSubT1, GXv_char3) ;
      conceptosafipwizardconcepto1_impl.this.AV34ConAFIPConcepto = GXv_char3[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", AV34ConAFIPConcepto);
      /* Execute user subroutine: 'ACTUALIZAR PERMISIBLES' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LIBRE VISIBLE' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipconcepto.getInternalname(), "Values", dynavConafipconcepto.ToJavascriptSource(), true);
      cmbavConafipsipaapo.setValue( GXutil.rtrim( AV15ConAFIPSIPAApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipaapo.getInternalname(), "Values", cmbavConafipsipaapo.ToJavascriptSource(), true);
      cmbavConafipsipacont.setValue( GXutil.rtrim( AV22ConAFIPSIPACont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipacont.getInternalname(), "Values", cmbavConafipsipacont.ToJavascriptSource(), true);
      cmbavConafipinssjypapo.setValue( GXutil.rtrim( AV16ConAFIPINSSJyPApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypapo.getInternalname(), "Values", cmbavConafipinssjypapo.ToJavascriptSource(), true);
      cmbavConafipinssjypcont.setValue( GXutil.rtrim( AV23ConAFIPINSSJyPCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypcont.getInternalname(), "Values", cmbavConafipinssjypcont.ToJavascriptSource(), true);
      cmbavConafipobrasocapo.setValue( GXutil.rtrim( AV17ConAFIPObraSocApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasocapo.getInternalname(), "Values", cmbavConafipobrasocapo.ToJavascriptSource(), true);
      cmbavConafipobrasoccont.setValue( GXutil.rtrim( AV24ConAFIPObraSocCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasoccont.getInternalname(), "Values", cmbavConafipobrasoccont.ToJavascriptSource(), true);
      cmbavConafipfonsolredapo.setValue( GXutil.rtrim( AV18ConAFIPFonSolRedApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredapo.getInternalname(), "Values", cmbavConafipfonsolredapo.ToJavascriptSource(), true);
      cmbavConafipfonsolredcont.setValue( GXutil.rtrim( AV25ConAFIPFonSolRedCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredcont.getInternalname(), "Values", cmbavConafipfonsolredcont.ToJavascriptSource(), true);
      cmbavConafiprenateaapo.setValue( GXutil.rtrim( AV19ConAFIPRenateaApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateaapo.getInternalname(), "Values", cmbavConafiprenateaapo.ToJavascriptSource(), true);
      cmbavConafiprenateacont.setValue( GXutil.rtrim( AV26ConAFIPRenateaCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateacont.getInternalname(), "Values", cmbavConafiprenateacont.ToJavascriptSource(), true);
      cmbavConafipasigfamcont.setValue( GXutil.rtrim( AV27ConAFIPAsigFamCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipasigfamcont.getInternalname(), "Values", cmbavConafipasigfamcont.ToJavascriptSource(), true);
      cmbavConafipfonnacempcont.setValue( GXutil.rtrim( AV28ConAFIPFonNacEmpCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonnacempcont.getInternalname(), "Values", cmbavConafipfonnacempcont.ToJavascriptSource(), true);
      cmbavConafipleyrietrabcont.setValue( GXutil.rtrim( AV29ConAFIPLeyRieTrabCont) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipleyrietrabcont.getInternalname(), "Values", cmbavConafipleyrietrabcont.ToJavascriptSource(), true);
      cmbavConafipregdifapo.setValue( GXutil.rtrim( AV20ConAFIPRegDifApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregdifapo.getInternalname(), "Values", cmbavConafipregdifapo.ToJavascriptSource(), true);
      cmbavConafipregespapo.setValue( GXutil.rtrim( AV21ConAFIPRegEspApo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregespapo.getInternalname(), "Values", cmbavConafipregespapo.ToJavascriptSource(), true);
   }

   public void e176Y2( )
   {
      /* Conafipsipaapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e186Y2( )
   {
      /* Conafipinssjypapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e196Y2( )
   {
      /* Conafipobrasocapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e206Y2( )
   {
      /* Conafipfonsolredapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e216Y2( )
   {
      /* Conafiprenateaapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e226Y2( )
   {
      /* Conafipregdifapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e236Y2( )
   {
      /* Conafipregespapo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e246Y2( )
   {
      /* Conafipsipacont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e256Y2( )
   {
      /* Conafipinssjypcont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e266Y2( )
   {
      /* Conafipobrasoccont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e276Y2( )
   {
      /* Conafipfonsolredcont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e286Y2( )
   {
      /* Conafiprenateacont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e296Y2( )
   {
      /* Conafipasigfamcont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e306Y2( )
   {
      /* Conafipfonnacempcont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e316Y2( )
   {
      /* Conafipleyrietrabcont_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e326Y2( )
   {
      /* Conafiptipo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e336Y2( )
   {
      /* Libre_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'LIBRE VISIBLE' Routine */
      returnInSub = false ;
      GXt_char5 = "" ;
      GXv_char3[0] = GXt_char5 ;
      new web.conafipgetinvitemessage(remoteHandle, context).execute( AV32ConAFIPTipo, AV33ConAfipSubT1, GXv_char3) ;
      conceptosafipwizardconcepto1_impl.this.GXt_char5 = GXv_char3[0] ;
      edtavLibre_Invitemessage = GXt_char5 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLibre_Internalname, "Invitemessage", edtavLibre_Invitemessage, true);
      if ( (GXutil.strcmp("", AV34ConAFIPConcepto)==0) )
      {
         edtavLibre_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLibre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLibre_Visible), 5, 0), true);
      }
      else
      {
         edtavLibre_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLibre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLibre_Visible), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'ACTUALIZAR PERMISIBLES' Routine */
      returnInSub = false ;
      cmbavConafipsipaapo.removeAllItems();
      cmbavConafipsipacont.removeAllItems();
      cmbavConafipinssjypapo.removeAllItems();
      cmbavConafipinssjypcont.removeAllItems();
      cmbavConafipobrasocapo.removeAllItems();
      cmbavConafipobrasoccont.removeAllItems();
      cmbavConafipfonsolredapo.removeAllItems();
      cmbavConafipfonsolredcont.removeAllItems();
      cmbavConafiprenateaapo.removeAllItems();
      cmbavConafiprenateacont.removeAllItems();
      cmbavConafipasigfamcont.removeAllItems();
      cmbavConafipfonnacempcont.removeAllItems();
      cmbavConafipleyrietrabcont.removeAllItems();
      cmbavConafipregdifapo.removeAllItems();
      cmbavConafipregespapo.removeAllItems();
      AV54aplicaAlgo = false ;
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "SIPA", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipsipaapo.addItem("", "-", (short)(0));
         cmbavConafipsipaapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipsipaapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV15ConAFIPSIPAApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
         }
      }
      else
      {
         cmbavConafipsipaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipsipaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipsipaapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipsipaapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV15ConAFIPSIPAApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConAFIPSIPAApo", AV15ConAFIPSIPAApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "SIPA", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipsipacont.addItem("", "-", (short)(0));
         cmbavConafipsipacont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipsipacont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV22ConAFIPSIPACont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
         }
      }
      else
      {
         cmbavConafipsipacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipsipacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipsipacont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipsipacont.getEnabled(), 5, 0), true);
         AV22ConAFIPSIPACont = "1" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22ConAFIPSIPACont", AV22ConAFIPSIPACont);
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "INSSJYP", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipinssjypapo.addItem("", "-", (short)(0));
         cmbavConafipinssjypapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipinssjypapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV16ConAFIPINSSJyPApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
         }
      }
      else
      {
         cmbavConafipinssjypapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipinssjypapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipinssjypapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipinssjypapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV16ConAFIPINSSJyPApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16ConAFIPINSSJyPApo", AV16ConAFIPINSSJyPApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "INSSJYP", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipinssjypcont.addItem("", "-", (short)(0));
         cmbavConafipinssjypcont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipinssjypcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV23ConAFIPINSSJyPCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
         }
      }
      else
      {
         cmbavConafipinssjypcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipinssjypcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipinssjypcont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipinssjypcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV23ConAFIPINSSJyPCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23ConAFIPINSSJyPCont", AV23ConAFIPINSSJyPCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "OS", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipobrasocapo.addItem("", "-", (short)(0));
         cmbavConafipobrasocapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipobrasocapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV17ConAFIPObraSocApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
         }
      }
      else
      {
         cmbavConafipobrasocapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipobrasocapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipobrasocapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipobrasocapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV17ConAFIPObraSocApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConAFIPObraSocApo", AV17ConAFIPObraSocApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "OS", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipobrasoccont.addItem("", "-", (short)(0));
         cmbavConafipobrasoccont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipobrasoccont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV24ConAFIPObraSocCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
         }
      }
      else
      {
         cmbavConafipobrasoccont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipobrasoccont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipobrasoccont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipobrasoccont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV24ConAFIPObraSocCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ConAFIPObraSocCont", AV24ConAFIPObraSocCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "FSR", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipfonsolredapo.addItem("", "-", (short)(0));
         cmbavConafipfonsolredapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonsolredapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV18ConAFIPFonSolRedApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
         }
      }
      else
      {
         cmbavConafipfonsolredapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipfonsolredapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipfonsolredapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonsolredapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV18ConAFIPFonSolRedApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ConAFIPFonSolRedApo", AV18ConAFIPFonSolRedApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "FSR", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipfonsolredcont.addItem("", "-", (short)(0));
         cmbavConafipfonsolredcont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonsolredcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV25ConAFIPFonSolRedCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
         }
      }
      else
      {
         cmbavConafipfonsolredapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipfonsolredcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipfonsolredcont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonsolredcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV25ConAFIPFonSolRedCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ConAFIPFonSolRedCont", AV25ConAFIPFonSolRedCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "RENATEA", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafiprenateaapo.addItem("", "-", (short)(0));
         cmbavConafiprenateaapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafiprenateaapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV19ConAFIPRenateaApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
         }
      }
      else
      {
         cmbavConafiprenateaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafiprenateaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafiprenateaapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafiprenateaapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV19ConAFIPRenateaApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19ConAFIPRenateaApo", AV19ConAFIPRenateaApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "RENATEA", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafiprenateacont.addItem("", "-", (short)(0));
         cmbavConafiprenateacont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafiprenateacont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV26ConAFIPRenateaCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
         }
      }
      else
      {
         cmbavConafiprenateacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafiprenateacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafiprenateacont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafiprenateacont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV26ConAFIPRenateaCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConAFIPRenateaCont", AV26ConAFIPRenateaCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "AAFF", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipasigfamcont.addItem("", "-", (short)(0));
         cmbavConafipasigfamcont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipasigfamcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV27ConAFIPAsigFamCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
         }
      }
      else
      {
         cmbavConafipasigfamcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipasigfamcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipasigfamcont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipasigfamcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV27ConAFIPAsigFamCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConAFIPAsigFamCont", AV27ConAFIPAsigFamCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "FNE", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipfonnacempcont.addItem("", "-", (short)(0));
         cmbavConafipfonnacempcont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonnacempcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV28ConAFIPFonNacEmpCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
         }
      }
      else
      {
         cmbavConafipfonnacempcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipfonnacempcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipfonnacempcont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipfonnacempcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV28ConAFIPFonNacEmpCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28ConAFIPFonNacEmpCont", AV28ConAFIPFonNacEmpCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "LRT", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipleyrietrabcont.addItem("", "-", (short)(0));
         cmbavConafipleyrietrabcont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipleyrietrabcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV29ConAFIPLeyRieTrabCont = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
         }
      }
      else
      {
         cmbavConafipleyrietrabcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipleyrietrabcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipleyrietrabcont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipleyrietrabcont.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV29ConAFIPLeyRieTrabCont = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29ConAFIPLeyRieTrabCont", AV29ConAFIPLeyRieTrabCont);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "DIFERENCIALES", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipregdifapo.addItem("", "-", (short)(0));
         cmbavConafipregdifapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipregdifapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV20ConAFIPRegDifApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
         }
      }
      else
      {
         cmbavConafipregdifapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipregdifapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipregdifapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipregdifapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV20ConAFIPRegDifApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20ConAFIPRegDifApo", AV20ConAFIPRegDifApo);
         }
         AV54aplicaAlgo = true ;
      }
      if ( ! new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "ESPECIALES", ""), AV32ConAFIPTipo, AV33ConAfipSubT1) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConafipregespapo.addItem("", "-", (short)(0));
         cmbavConafipregespapo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipregespapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV21ConAFIPRegEspApo = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
         }
      }
      else
      {
         cmbavConafipregespapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
         cmbavConafipregespapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
         cmbavConafipregespapo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConafipregespapo.getEnabled(), 5, 0), true);
         if ( ! ( GXutil.strcmp(AV55httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) )
         {
            AV21ConAFIPRegEspApo = "1" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21ConAFIPRegEspApo", AV21ConAFIPRegEspApo);
         }
         AV54aplicaAlgo = true ;
      }
      tblTblapocon_Visible = (AV54aplicaAlgo ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblapocon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblapocon_Visible), 5, 0), true);
   }

   protected void nextLoad( )
   {
   }

   protected void e346Y2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_12_6Y2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelafip.setProperty("Width", Dvpanel_panelafip_Width);
         ucDvpanel_panelafip.setProperty("AutoWidth", Dvpanel_panelafip_Autowidth);
         ucDvpanel_panelafip.setProperty("AutoHeight", Dvpanel_panelafip_Autoheight);
         ucDvpanel_panelafip.setProperty("Cls", Dvpanel_panelafip_Cls);
         ucDvpanel_panelafip.setProperty("Title", Dvpanel_panelafip_Title);
         ucDvpanel_panelafip.setProperty("Collapsible", Dvpanel_panelafip_Collapsible);
         ucDvpanel_panelafip.setProperty("Collapsed", Dvpanel_panelafip_Collapsed);
         ucDvpanel_panelafip.setProperty("ShowCollapseIcon", Dvpanel_panelafip_Showcollapseicon);
         ucDvpanel_panelafip.setProperty("IconPosition", Dvpanel_panelafip_Iconposition);
         ucDvpanel_panelafip.setProperty("AutoScroll", Dvpanel_panelafip_Autoscroll);
         ucDvpanel_panelafip.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelafip_Internalname, sPrefix+"DVPANEL_PANELAFIPContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_PANELAFIPContainer"+"PanelAfip"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelafip_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_20_6Y2( true) ;
      }
      else
      {
         wb_table2_20_6Y2( false) ;
      }
      return  ;
   }

   public void wb_table2_20_6Y2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table3_38_6Y2( true) ;
      }
      else
      {
         wb_table3_38_6Y2( false) ;
      }
      return  ;
   }

   public void wb_table3_38_6Y2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_12_6Y2e( true) ;
      }
      else
      {
         wb_table1_12_6Y2e( false) ;
      }
   }

   public void wb_table3_38_6Y2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblapocon_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblapocon_Internalname, tblTblapocon_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelapocont.setProperty("Width", Dvpanel_panelapocont_Width);
         ucDvpanel_panelapocont.setProperty("AutoWidth", Dvpanel_panelapocont_Autowidth);
         ucDvpanel_panelapocont.setProperty("AutoHeight", Dvpanel_panelapocont_Autoheight);
         ucDvpanel_panelapocont.setProperty("Cls", Dvpanel_panelapocont_Cls);
         ucDvpanel_panelapocont.setProperty("Title", Dvpanel_panelapocont_Title);
         ucDvpanel_panelapocont.setProperty("Collapsible", Dvpanel_panelapocont_Collapsible);
         ucDvpanel_panelapocont.setProperty("Collapsed", Dvpanel_panelapocont_Collapsed);
         ucDvpanel_panelapocont.setProperty("ShowCollapseIcon", Dvpanel_panelapocont_Showcollapseicon);
         ucDvpanel_panelapocont.setProperty("IconPosition", Dvpanel_panelapocont_Iconposition);
         ucDvpanel_panelapocont.setProperty("AutoScroll", Dvpanel_panelapocont_Autoscroll);
         ucDvpanel_panelapocont.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelapocont_Internalname, sPrefix+"DVPANEL_PANELAPOCONTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_PANELAPOCONTContainer"+"PanelApoCont"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelapocont_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table4_46_6Y2( true) ;
      }
      else
      {
         wb_table4_46_6Y2( false) ;
      }
      return  ;
   }

   public void wb_table4_46_6Y2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_38_6Y2e( true) ;
      }
      else
      {
         wb_table3_38_6Y2e( false) ;
      }
   }

   public void wb_table4_46_6Y2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTbl2_Internalname, tblTbl2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblS1_Internalname, " ", "", "", lblS1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblSipatxt__Internalname, httpContext.getMessage( "SIPA", ""), "", "", lblSipatxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblInjtxt__Internalname, httpContext.getMessage( "INSSJyP", ""), "", "", lblInjtxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblOstxt__Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblOstxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFsr__Internalname, httpContext.getMessage( "FSR", ""), "", "", lblFsr__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblUatretxt__Internalname, httpContext.getMessage( "UATRE", ""), "", "", lblUatretxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAafftxt__Internalname, httpContext.getMessage( "AAFF", ""), "", "", lblAafftxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFnetxt__Internalname, httpContext.getMessage( "FNE", ""), "", "", lblFnetxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDiftxt__Internalname, httpContext.getMessage( "Diferenciales", ""), "", "", lblDiftxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblRegesptxt__Internalname, httpContext.getMessage( "Reg. Especiales", ""), "", "", lblRegesptxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAportxt__Internalname, httpContext.getMessage( "Aportes", ""), "", "", lblAportxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipsipaapo.getInternalname(), httpContext.getMessage( "Con AFIPSIPAApo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipsipaapo, cmbavConafipsipaapo.getInternalname(), GXutil.rtrim( AV15ConAFIPSIPAApo), 1, cmbavConafipsipaapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPSIPAAPO.CLICK."+"'", "char", "", 1, cmbavConafipsipaapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipsipaapo.setValue( GXutil.rtrim( AV15ConAFIPSIPAApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipaapo.getInternalname(), "Values", cmbavConafipsipaapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipinssjypapo.getInternalname(), httpContext.getMessage( "Con AFIPINSSJy PApo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipinssjypapo, cmbavConafipinssjypapo.getInternalname(), GXutil.rtrim( AV16ConAFIPINSSJyPApo), 1, cmbavConafipinssjypapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPINSSJYPAPO.CLICK."+"'", "char", "", 1, cmbavConafipinssjypapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,76);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipinssjypapo.setValue( GXutil.rtrim( AV16ConAFIPINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypapo.getInternalname(), "Values", cmbavConafipinssjypapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipobrasocapo.getInternalname(), httpContext.getMessage( "Con AFIPObra Soc Apo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipobrasocapo, cmbavConafipobrasocapo.getInternalname(), GXutil.rtrim( AV17ConAFIPObraSocApo), 1, cmbavConafipobrasocapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPOBRASOCAPO.CLICK."+"'", "char", "", 1, cmbavConafipobrasocapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipobrasocapo.setValue( GXutil.rtrim( AV17ConAFIPObraSocApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasocapo.getInternalname(), "Values", cmbavConafipobrasocapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipfonsolredapo.getInternalname(), httpContext.getMessage( "Con AFIPFon Sol Red Apo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipfonsolredapo, cmbavConafipfonsolredapo.getInternalname(), GXutil.rtrim( AV18ConAFIPFonSolRedApo), 1, cmbavConafipfonsolredapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPFONSOLREDAPO.CLICK."+"'", "char", "", 1, cmbavConafipfonsolredapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipfonsolredapo.setValue( GXutil.rtrim( AV18ConAFIPFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredapo.getInternalname(), "Values", cmbavConafipfonsolredapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafiprenateaapo.getInternalname(), httpContext.getMessage( "Con AFIPRenatea Apo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafiprenateaapo, cmbavConafiprenateaapo.getInternalname(), GXutil.rtrim( AV19ConAFIPRenateaApo), 1, cmbavConafiprenateaapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPRENATEAAPO.CLICK."+"'", "char", "", 1, cmbavConafiprenateaapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafiprenateaapo.setValue( GXutil.rtrim( AV19ConAFIPRenateaApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateaapo.getInternalname(), "Values", cmbavConafiprenateaapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion1__Internalname, "-", "", "", lblGuion1__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion2__Internalname, "-", "", "", lblGuion2__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipregdifapo.getInternalname(), httpContext.getMessage( "Con AFIPReg Dif Apo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipregdifapo, cmbavConafipregdifapo.getInternalname(), GXutil.rtrim( AV20ConAFIPRegDifApo), 1, cmbavConafipregdifapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPREGDIFAPO.CLICK."+"'", "char", "", 1, cmbavConafipregdifapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipregdifapo.setValue( GXutil.rtrim( AV20ConAFIPRegDifApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregdifapo.getInternalname(), "Values", cmbavConafipregdifapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipregespapo.getInternalname(), httpContext.getMessage( "Con AFIPReg Esp Apo", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipregespapo, cmbavConafipregespapo.getInternalname(), GXutil.rtrim( AV21ConAFIPRegEspApo), 1, cmbavConafipregespapo.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPREGESPAPO.CLICK."+"'", "char", "", 1, cmbavConafipregespapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipregespapo.setValue( GXutil.rtrim( AV21ConAFIPRegEspApo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipregespapo.getInternalname(), "Values", cmbavConafipregespapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblContrtxt__Internalname, httpContext.getMessage( "Contribuciones", ""), "", "", lblContrtxt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipsipacont.getInternalname(), httpContext.getMessage( "Con AFIPSIPACont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipsipacont, cmbavConafipsipacont.getInternalname(), GXutil.rtrim( AV22ConAFIPSIPACont), 1, cmbavConafipsipacont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPSIPACONT.CLICK."+"'", "char", "", 1, cmbavConafipsipacont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,101);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipsipacont.setValue( GXutil.rtrim( AV22ConAFIPSIPACont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipsipacont.getInternalname(), "Values", cmbavConafipsipacont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipinssjypcont.getInternalname(), httpContext.getMessage( "Con AFIPINSSJy PCont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipinssjypcont, cmbavConafipinssjypcont.getInternalname(), GXutil.rtrim( AV23ConAFIPINSSJyPCont), 1, cmbavConafipinssjypcont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPINSSJYPCONT.CLICK."+"'", "char", "", 1, cmbavConafipinssjypcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipinssjypcont.setValue( GXutil.rtrim( AV23ConAFIPINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipinssjypcont.getInternalname(), "Values", cmbavConafipinssjypcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipobrasoccont.getInternalname(), httpContext.getMessage( "Con AFIPObra Soc Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipobrasoccont, cmbavConafipobrasoccont.getInternalname(), GXutil.rtrim( AV24ConAFIPObraSocCont), 1, cmbavConafipobrasoccont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPOBRASOCCONT.CLICK."+"'", "char", "", 1, cmbavConafipobrasoccont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipobrasoccont.setValue( GXutil.rtrim( AV24ConAFIPObraSocCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipobrasoccont.getInternalname(), "Values", cmbavConafipobrasoccont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipfonsolredcont.getInternalname(), httpContext.getMessage( "Con AFIPFon Sol Red Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipfonsolredcont, cmbavConafipfonsolredcont.getInternalname(), GXutil.rtrim( AV25ConAFIPFonSolRedCont), 1, cmbavConafipfonsolredcont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPFONSOLREDCONT.CLICK."+"'", "char", "", 1, cmbavConafipfonsolredcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,110);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipfonsolredcont.setValue( GXutil.rtrim( AV25ConAFIPFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonsolredcont.getInternalname(), "Values", cmbavConafipfonsolredcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafiprenateacont.getInternalname(), httpContext.getMessage( "Con AFIPRenatea Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafiprenateacont, cmbavConafiprenateacont.getInternalname(), GXutil.rtrim( AV26ConAFIPRenateaCont), 1, cmbavConafiprenateacont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPRENATEACONT.CLICK."+"'", "char", "", 1, cmbavConafiprenateacont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,113);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafiprenateacont.setValue( GXutil.rtrim( AV26ConAFIPRenateaCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafiprenateacont.getInternalname(), "Values", cmbavConafiprenateacont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipasigfamcont.getInternalname(), httpContext.getMessage( "Con AFIPAsig Fam Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipasigfamcont, cmbavConafipasigfamcont.getInternalname(), GXutil.rtrim( AV27ConAFIPAsigFamCont), 1, cmbavConafipasigfamcont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPASIGFAMCONT.CLICK."+"'", "char", "", 1, cmbavConafipasigfamcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,116);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipasigfamcont.setValue( GXutil.rtrim( AV27ConAFIPAsigFamCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipasigfamcont.getInternalname(), "Values", cmbavConafipasigfamcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipfonnacempcont.getInternalname(), httpContext.getMessage( "Con AFIPFon Nac Emp Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipfonnacempcont, cmbavConafipfonnacempcont.getInternalname(), GXutil.rtrim( AV28ConAFIPFonNacEmpCont), 1, cmbavConafipfonnacempcont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPFONNACEMPCONT.CLICK."+"'", "char", "", 1, cmbavConafipfonnacempcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,119);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipfonnacempcont.setValue( GXutil.rtrim( AV28ConAFIPFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipfonnacempcont.getInternalname(), "Values", cmbavConafipfonnacempcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion3__Internalname, "-", "", "", lblGuion3__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion4__Internalname, "-", "", "", lblGuion4__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLrt_txt__Internalname, httpContext.getMessage( "LRT", ""), "", "", lblLrt_txt__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConafipleyrietrabcont.getInternalname(), httpContext.getMessage( "Con AFIPLey Rie Trab Cont", ""), "gx-form-item widthAutoLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConafipleyrietrabcont, cmbavConafipleyrietrabcont.getInternalname(), GXutil.rtrim( AV29ConAFIPLeyRieTrabCont), 1, cmbavConafipleyrietrabcont.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPLEYRIETRABCONT.CLICK."+"'", "char", "", 1, cmbavConafipleyrietrabcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "widthAuto", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,129);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         cmbavConafipleyrietrabcont.setValue( GXutil.rtrim( AV29ConAFIPLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConafipleyrietrabcont.getInternalname(), "Values", cmbavConafipleyrietrabcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_46_6Y2e( true) ;
      }
      else
      {
         wb_table4_46_6Y2e( false) ;
      }
   }

   public void wb_table2_20_6Y2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTbl1_Internalname, tblTbl1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTipo_Internalname, lblTipo_Caption, "", "", lblTipo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConafipsubt1.getInternalname(), httpContext.getMessage( "Con Afip Sub T1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConafipsubt1, dynavConafipsubt1.getInternalname(), GXutil.rtrim( AV33ConAfipSubT1), 1, dynavConafipsubt1.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPSUBT1.CLICK."+"'", "char", "", 1, dynavConafipsubt1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         dynavConafipsubt1.setValue( GXutil.rtrim( AV33ConAfipSubT1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipsubt1.getInternalname(), "Values", dynavConafipsubt1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock3__Internalname, httpContext.getMessage( "Código AFIP", ""), "", "", lblTextblock3__Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConafipconcepto.getInternalname(), httpContext.getMessage( "Con AFIPConcepto", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConafipconcepto, dynavConafipconcepto.getInternalname(), GXutil.rtrim( AV34ConAFIPConcepto), 1, dynavConafipconcepto.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONAFIPCONCEPTO.CLICK."+"'", "char", "", 1, dynavConafipconcepto.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_ConceptosAfipWizardConcepto1.htm");
         dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipconcepto.getInternalname(), "Values", dynavConafipconcepto.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLibre_Internalname, httpContext.getMessage( "libre", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLibre_Internalname, GXutil.rtrim( AV35libre), GXutil.rtrim( localUtil.format( AV35libre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", edtavLibre_Invitemessage, edtavLibre_Jsonclick, 0, "Attribute", "", "", "", "", edtavLibre_Visible, edtavLibre_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptosAfipWizardConcepto1.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_20_6Y2e( true) ;
      }
      else
      {
         wb_table2_20_6Y2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
      AV8PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
      AV7GoingBack = ((Boolean) getParm(obj,2,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
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
      pa6Y2( ) ;
      ws6Y2( ) ;
      we6Y2( ) ;
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
      sCtrlAV6WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV8PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV7GoingBack = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa6Y2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptosafipwizardconcepto1", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa6Y2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV6WebSessionKey = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
         AV8PreviousStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
         AV7GoingBack = ((Boolean) getParm(obj,4,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
      }
      wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
      wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
      wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6WebSessionKey, wcpOAV6WebSessionKey) != 0 ) || ( GXutil.strcmp(AV8PreviousStep, wcpOAV8PreviousStep) != 0 ) || ( AV7GoingBack != wcpOAV7GoingBack ) ) )
      {
         setjustcreated();
      }
      wcpOAV6WebSessionKey = AV6WebSessionKey ;
      wcpOAV8PreviousStep = AV8PreviousStep ;
      wcpOAV7GoingBack = AV7GoingBack ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV6WebSessionKey = httpContext.cgiGet( sPrefix+"AV6WebSessionKey_CTRL") ;
      if ( GXutil.len( sCtrlAV6WebSessionKey) > 0 )
      {
         AV6WebSessionKey = httpContext.cgiGet( sCtrlAV6WebSessionKey) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
      }
      else
      {
         AV6WebSessionKey = httpContext.cgiGet( sPrefix+"AV6WebSessionKey_PARM") ;
      }
      sCtrlAV8PreviousStep = httpContext.cgiGet( sPrefix+"AV8PreviousStep_CTRL") ;
      if ( GXutil.len( sCtrlAV8PreviousStep) > 0 )
      {
         AV8PreviousStep = httpContext.cgiGet( sCtrlAV8PreviousStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
      }
      else
      {
         AV8PreviousStep = httpContext.cgiGet( sPrefix+"AV8PreviousStep_PARM") ;
      }
      sCtrlAV7GoingBack = httpContext.cgiGet( sPrefix+"AV7GoingBack_CTRL") ;
      if ( GXutil.len( sCtrlAV7GoingBack) > 0 )
      {
         AV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sCtrlAV7GoingBack)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
      }
      else
      {
         AV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV7GoingBack_PARM")) ;
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
      pa6Y2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws6Y2( ) ;
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
      ws6Y2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WebSessionKey_PARM", AV6WebSessionKey);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6WebSessionKey)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WebSessionKey_CTRL", GXutil.rtrim( sCtrlAV6WebSessionKey));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PreviousStep_PARM", AV8PreviousStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8PreviousStep)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PreviousStep_CTRL", GXutil.rtrim( sCtrlAV8PreviousStep));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7GoingBack_PARM", GXutil.booltostr( AV7GoingBack));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7GoingBack)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7GoingBack_CTRL", GXutil.rtrim( sCtrlAV7GoingBack));
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
      we6Y2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019472528", true, true);
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
      httpContext.AddJavascriptSource("conceptosafipwizardconcepto1.js", "?2024122019472529", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTipo_Internalname = sPrefix+"TIPO" ;
      dynavConafipsubt1.setInternalname( sPrefix+"vCONAFIPSUBT1" );
      lblTextblock3__Internalname = sPrefix+"TEXTBLOCK3_" ;
      dynavConafipconcepto.setInternalname( sPrefix+"vCONAFIPCONCEPTO" );
      edtavLibre_Internalname = sPrefix+"vLIBRE" ;
      tblTbl1_Internalname = sPrefix+"TBL1" ;
      divPanelafip_Internalname = sPrefix+"PANELAFIP" ;
      Dvpanel_panelafip_Internalname = sPrefix+"DVPANEL_PANELAFIP" ;
      lblS1_Internalname = sPrefix+"S1" ;
      lblSipatxt__Internalname = sPrefix+"SIPATXT_" ;
      lblInjtxt__Internalname = sPrefix+"INJTXT_" ;
      lblOstxt__Internalname = sPrefix+"OSTXT_" ;
      lblFsr__Internalname = sPrefix+"FSR_" ;
      lblUatretxt__Internalname = sPrefix+"UATRETXT_" ;
      lblAafftxt__Internalname = sPrefix+"AAFFTXT_" ;
      lblFnetxt__Internalname = sPrefix+"FNETXT_" ;
      lblDiftxt__Internalname = sPrefix+"DIFTXT_" ;
      lblRegesptxt__Internalname = sPrefix+"REGESPTXT_" ;
      lblAportxt__Internalname = sPrefix+"APORTXT_" ;
      cmbavConafipsipaapo.setInternalname( sPrefix+"vCONAFIPSIPAAPO" );
      cmbavConafipinssjypapo.setInternalname( sPrefix+"vCONAFIPINSSJYPAPO" );
      cmbavConafipobrasocapo.setInternalname( sPrefix+"vCONAFIPOBRASOCAPO" );
      cmbavConafipfonsolredapo.setInternalname( sPrefix+"vCONAFIPFONSOLREDAPO" );
      cmbavConafiprenateaapo.setInternalname( sPrefix+"vCONAFIPRENATEAAPO" );
      lblGuion1__Internalname = sPrefix+"GUION1_" ;
      lblGuion2__Internalname = sPrefix+"GUION2_" ;
      cmbavConafipregdifapo.setInternalname( sPrefix+"vCONAFIPREGDIFAPO" );
      cmbavConafipregespapo.setInternalname( sPrefix+"vCONAFIPREGESPAPO" );
      lblContrtxt__Internalname = sPrefix+"CONTRTXT_" ;
      cmbavConafipsipacont.setInternalname( sPrefix+"vCONAFIPSIPACONT" );
      cmbavConafipinssjypcont.setInternalname( sPrefix+"vCONAFIPINSSJYPCONT" );
      cmbavConafipobrasoccont.setInternalname( sPrefix+"vCONAFIPOBRASOCCONT" );
      cmbavConafipfonsolredcont.setInternalname( sPrefix+"vCONAFIPFONSOLREDCONT" );
      cmbavConafiprenateacont.setInternalname( sPrefix+"vCONAFIPRENATEACONT" );
      cmbavConafipasigfamcont.setInternalname( sPrefix+"vCONAFIPASIGFAMCONT" );
      cmbavConafipfonnacempcont.setInternalname( sPrefix+"vCONAFIPFONNACEMPCONT" );
      lblGuion3__Internalname = sPrefix+"GUION3_" ;
      lblGuion4__Internalname = sPrefix+"GUION4_" ;
      lblLrt_txt__Internalname = sPrefix+"LRT_TXT_" ;
      cmbavConafipleyrietrabcont.setInternalname( sPrefix+"vCONAFIPLEYRIETRABCONT" );
      tblTbl2_Internalname = sPrefix+"TBL2" ;
      divPanelapocont_Internalname = sPrefix+"PANELAPOCONT" ;
      Dvpanel_panelapocont_Internalname = sPrefix+"DVPANEL_PANELAPOCONT" ;
      tblTblapocon_Internalname = sPrefix+"TBLAPOCON" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      divTableinfo_Internalname = sPrefix+"TABLEINFO" ;
      Btnwizardprevious_Internalname = sPrefix+"BTNWIZARDPREVIOUS" ;
      Btnwizardnext_Internalname = sPrefix+"BTNWIZARDNEXT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      cmbavConafiptipo.setInternalname( sPrefix+"vCONAFIPTIPO" );
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
      edtavLibre_Jsonclick = "" ;
      edtavLibre_Enabled = 1 ;
      dynavConafipconcepto.setJsonclick( "" );
      dynavConafipconcepto.setEnabled( 1 );
      dynavConafipsubt1.setJsonclick( "" );
      dynavConafipsubt1.setEnabled( 1 );
      cmbavConafipleyrietrabcont.setJsonclick( "" );
      cmbavConafipfonnacempcont.setJsonclick( "" );
      cmbavConafipasigfamcont.setJsonclick( "" );
      cmbavConafiprenateacont.setJsonclick( "" );
      cmbavConafipfonsolredcont.setJsonclick( "" );
      cmbavConafipobrasoccont.setJsonclick( "" );
      cmbavConafipinssjypcont.setJsonclick( "" );
      cmbavConafipsipacont.setJsonclick( "" );
      cmbavConafipregespapo.setJsonclick( "" );
      cmbavConafipregdifapo.setJsonclick( "" );
      cmbavConafiprenateaapo.setJsonclick( "" );
      cmbavConafipfonsolredapo.setJsonclick( "" );
      cmbavConafipobrasocapo.setJsonclick( "" );
      cmbavConafipinssjypapo.setJsonclick( "" );
      cmbavConafipsipaapo.setJsonclick( "" );
      Dvpanel_panelapocont_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont_Iconposition = "Right" ;
      Dvpanel_panelapocont_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont_Title = httpContext.getMessage( "Aportes y Contribuciones", "") ;
      Dvpanel_panelapocont_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelapocont_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelapocont_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont_Width = "100%" ;
      Dvpanel_panelafip_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelafip_Iconposition = "Right" ;
      Dvpanel_panelafip_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelafip_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelafip_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panelafip_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelafip_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelafip_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelafip_Width = "100%" ;
      tblTblapocon_Visible = 1 ;
      cmbavConafipregespapo.setEnabled( 1 );
      cmbavConafipregdifapo.setEnabled( 1 );
      cmbavConafipleyrietrabcont.setEnabled( 1 );
      cmbavConafipfonnacempcont.setEnabled( 1 );
      cmbavConafipasigfamcont.setEnabled( 1 );
      cmbavConafiprenateacont.setEnabled( 1 );
      cmbavConafiprenateaapo.setEnabled( 1 );
      cmbavConafipfonsolredcont.setEnabled( 1 );
      cmbavConafipfonsolredapo.setEnabled( 1 );
      cmbavConafipobrasoccont.setEnabled( 1 );
      cmbavConafipobrasocapo.setEnabled( 1 );
      cmbavConafipinssjypcont.setEnabled( 1 );
      cmbavConafipinssjypapo.setEnabled( 1 );
      cmbavConafipsipacont.setEnabled( 1 );
      cmbavConafipsipaapo.setEnabled( 1 );
      edtavLibre_Visible = 1 ;
      edtavLibre_Invitemessage = "" ;
      lblTipo_Caption = httpContext.getMessage( "Tipo", "") ;
      Dvpanel_panelafip_Title = httpContext.getMessage( "Concepto", "") ;
      cmbavConafiptipo.setJsonclick( "" );
      cmbavConafiptipo.setVisible( 1 );
      Btnwizardnext_Class = "Button ButtonWizard" ;
      Btnwizardnext_Caption = httpContext.getMessage( "GXM_next", "") ;
      Btnwizardnext_Aftericonclass = "fas fa-arrow-right" ;
      Btnwizardprevious_Class = "BtnDefault ButtonWizard" ;
      Btnwizardprevious_Caption = httpContext.getMessage( "GXM_previous", "") ;
      Btnwizardprevious_Beforeiconclass = "fas fa-arrow-left" ;
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
      dynavConafipsubt1.setName( "vCONAFIPSUBT1" );
      dynavConafipsubt1.setWebtags( "" );
      dynavConafipconcepto.setName( "vCONAFIPCONCEPTO" );
      dynavConafipconcepto.setWebtags( "" );
      cmbavConafipsipaapo.setName( "vCONAFIPSIPAAPO" );
      cmbavConafipsipaapo.setWebtags( "" );
      cmbavConafipsipaapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipsipaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipsipaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipsipaapo.addItem("", "-", (short)(0));
      if ( cmbavConafipsipaapo.getItemCount() > 0 )
      {
      }
      cmbavConafipinssjypapo.setName( "vCONAFIPINSSJYPAPO" );
      cmbavConafipinssjypapo.setWebtags( "" );
      cmbavConafipinssjypapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipinssjypapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipinssjypapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipinssjypapo.addItem("", "-", (short)(0));
      if ( cmbavConafipinssjypapo.getItemCount() > 0 )
      {
      }
      cmbavConafipobrasocapo.setName( "vCONAFIPOBRASOCAPO" );
      cmbavConafipobrasocapo.setWebtags( "" );
      cmbavConafipobrasocapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipobrasocapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipobrasocapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipobrasocapo.addItem("", "-", (short)(0));
      if ( cmbavConafipobrasocapo.getItemCount() > 0 )
      {
      }
      cmbavConafipfonsolredapo.setName( "vCONAFIPFONSOLREDAPO" );
      cmbavConafipfonsolredapo.setWebtags( "" );
      cmbavConafipfonsolredapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipfonsolredapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipfonsolredapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipfonsolredapo.addItem("", "-", (short)(0));
      if ( cmbavConafipfonsolredapo.getItemCount() > 0 )
      {
      }
      cmbavConafiprenateaapo.setName( "vCONAFIPRENATEAAPO" );
      cmbavConafiprenateaapo.setWebtags( "" );
      cmbavConafiprenateaapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafiprenateaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafiprenateaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafiprenateaapo.addItem("", "-", (short)(0));
      if ( cmbavConafiprenateaapo.getItemCount() > 0 )
      {
      }
      cmbavConafipregdifapo.setName( "vCONAFIPREGDIFAPO" );
      cmbavConafipregdifapo.setWebtags( "" );
      cmbavConafipregdifapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipregdifapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipregdifapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipregdifapo.addItem("", "-", (short)(0));
      if ( cmbavConafipregdifapo.getItemCount() > 0 )
      {
      }
      cmbavConafipregespapo.setName( "vCONAFIPREGESPAPO" );
      cmbavConafipregespapo.setWebtags( "" );
      cmbavConafipregespapo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipregespapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipregespapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipregespapo.addItem("", "-", (short)(0));
      if ( cmbavConafipregespapo.getItemCount() > 0 )
      {
      }
      cmbavConafipsipacont.setName( "vCONAFIPSIPACONT" );
      cmbavConafipsipacont.setWebtags( "" );
      cmbavConafipsipacont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipsipacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipsipacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipsipacont.addItem("", "-", (short)(0));
      if ( cmbavConafipsipacont.getItemCount() > 0 )
      {
      }
      cmbavConafipinssjypcont.setName( "vCONAFIPINSSJYPCONT" );
      cmbavConafipinssjypcont.setWebtags( "" );
      cmbavConafipinssjypcont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipinssjypcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipinssjypcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipinssjypcont.addItem("", "-", (short)(0));
      if ( cmbavConafipinssjypcont.getItemCount() > 0 )
      {
      }
      cmbavConafipobrasoccont.setName( "vCONAFIPOBRASOCCONT" );
      cmbavConafipobrasoccont.setWebtags( "" );
      cmbavConafipobrasoccont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipobrasoccont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipobrasoccont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipobrasoccont.addItem("", "-", (short)(0));
      if ( cmbavConafipobrasoccont.getItemCount() > 0 )
      {
      }
      cmbavConafipfonsolredcont.setName( "vCONAFIPFONSOLREDCONT" );
      cmbavConafipfonsolredcont.setWebtags( "" );
      cmbavConafipfonsolredcont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipfonsolredcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipfonsolredcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipfonsolredcont.addItem("", "-", (short)(0));
      if ( cmbavConafipfonsolredcont.getItemCount() > 0 )
      {
      }
      cmbavConafiprenateacont.setName( "vCONAFIPRENATEACONT" );
      cmbavConafiprenateacont.setWebtags( "" );
      cmbavConafiprenateacont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafiprenateacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafiprenateacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafiprenateacont.addItem("", "-", (short)(0));
      if ( cmbavConafiprenateacont.getItemCount() > 0 )
      {
      }
      cmbavConafipasigfamcont.setName( "vCONAFIPASIGFAMCONT" );
      cmbavConafipasigfamcont.setWebtags( "" );
      cmbavConafipasigfamcont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipasigfamcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipasigfamcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipasigfamcont.addItem("", "-", (short)(0));
      if ( cmbavConafipasigfamcont.getItemCount() > 0 )
      {
      }
      cmbavConafipfonnacempcont.setName( "vCONAFIPFONNACEMPCONT" );
      cmbavConafipfonnacempcont.setWebtags( "" );
      cmbavConafipfonnacempcont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipfonnacempcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipfonnacempcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipfonnacempcont.addItem("", "-", (short)(0));
      if ( cmbavConafipfonnacempcont.getItemCount() > 0 )
      {
      }
      cmbavConafipleyrietrabcont.setName( "vCONAFIPLEYRIETRABCONT" );
      cmbavConafipleyrietrabcont.setWebtags( "" );
      cmbavConafipleyrietrabcont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbavConafipleyrietrabcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConafipleyrietrabcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConafipleyrietrabcont.addItem("", "-", (short)(0));
      if ( cmbavConafipleyrietrabcont.getItemCount() > 0 )
      {
      }
      cmbavConafiptipo.setName( "vCONAFIPTIPO" );
      cmbavConafiptipo.setWebtags( "" );
      cmbavConafiptipo.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbavConafiptipo.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbavConafiptipo.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbavConafiptipo.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbavConafiptipo.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public void validv_Conafipsubt1( )
   {
      AV32ConAFIPTipo = cmbavConafiptipo.getValue() ;
      AV33ConAfipSubT1 = dynavConafipsubt1.getValue() ;
      AV34ConAFIPConcepto = dynavConafipconcepto.getValue() ;
      gxvvconafipconcepto_html6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
      dynload_actions( ) ;
      if ( dynavConafipconcepto.getItemCount() > 0 )
      {
         AV34ConAFIPConcepto = dynavConafipconcepto.getValidValue(AV34ConAFIPConcepto) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", GXutil.rtrim( AV34ConAFIPConcepto));
      dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipconcepto.getInternalname(), "Values", dynavConafipconcepto.ToJavascriptSource(), true);
   }

   public void validv_Conafiptipo( )
   {
      AV32ConAFIPTipo = cmbavConafiptipo.getValue() ;
      AV33ConAfipSubT1 = dynavConafipsubt1.getValue() ;
      AV34ConAFIPConcepto = dynavConafipconcepto.getValue() ;
      if ( ! ( ( GXutil.strcmp(AV32ConAFIPTipo, "REM_ARG") == 0 ) || ( GXutil.strcmp(AV32ConAFIPTipo, "NRE_ARG") == 0 ) || ( GXutil.strcmp(AV32ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(AV32ConAFIPTipo, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con AFIPTipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "vCONAFIPTIPO");
         GX_FocusControl = cmbavConafiptipo.getInternalname() ;
      }
      gxvvconafipsubt1_html6Y2( AV32ConAFIPTipo) ;
      gxvvconafipconcepto_html6Y2( AV32ConAFIPTipo, AV33ConAfipSubT1) ;
      dynload_actions( ) ;
      if ( dynavConafipsubt1.getItemCount() > 0 )
      {
         AV33ConAfipSubT1 = dynavConafipsubt1.getValidValue(AV33ConAfipSubT1) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConafipsubt1.setValue( GXutil.rtrim( AV33ConAfipSubT1) );
      }
      if ( dynavConafipconcepto.getItemCount() > 0 )
      {
         AV34ConAFIPConcepto = dynavConafipconcepto.getValidValue(AV34ConAFIPConcepto) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33ConAfipSubT1", GXutil.rtrim( AV33ConAfipSubT1));
      dynavConafipsubt1.setValue( GXutil.rtrim( AV33ConAfipSubT1) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipsubt1.getInternalname(), "Values", dynavConafipsubt1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34ConAFIPConcepto", GXutil.rtrim( AV34ConAFIPConcepto));
      dynavConafipconcepto.setValue( GXutil.rtrim( AV34ConAFIPConcepto) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConafipconcepto.getInternalname(), "Values", dynavConafipconcepto.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("ENTER","{handler:'e126Y2',iparms:[{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e136Y2',iparms:[{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[]}");
      setEventMetadata("VCONAFIPCONCEPTO.CLICK","{handler:'e156Y2',iparms:[{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPCONCEPTO.CLICK",",oparms:[{av:'edtavLibre_Invitemessage',ctrl:'vLIBRE',prop:'Invitemessage'},{av:'edtavLibre_Visible',ctrl:'vLIBRE',prop:'Visible'}]}");
      setEventMetadata("VCONAFIPSUBT1.CLICK","{handler:'e166Y2',iparms:[{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPSUBT1.CLICK",",oparms:[{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'tblTblapocon_Visible',ctrl:'TBLAPOCON',prop:'Visible'},{av:'edtavLibre_Invitemessage',ctrl:'vLIBRE',prop:'Invitemessage'},{av:'edtavLibre_Visible',ctrl:'vLIBRE',prop:'Visible'}]}");
      setEventMetadata("VCONAFIPSIPAAPO.CLICK","{handler:'e176Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPSIPAAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPINSSJYPAPO.CLICK","{handler:'e186Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPINSSJYPAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPOBRASOCAPO.CLICK","{handler:'e196Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPOBRASOCAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPFONSOLREDAPO.CLICK","{handler:'e206Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPFONSOLREDAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPRENATEAAPO.CLICK","{handler:'e216Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPRENATEAAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPREGDIFAPO.CLICK","{handler:'e226Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPREGDIFAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPREGESPAPO.CLICK","{handler:'e236Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPREGESPAPO.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPSIPACONT.CLICK","{handler:'e246Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPSIPACONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPINSSJYPCONT.CLICK","{handler:'e256Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPINSSJYPCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPOBRASOCCONT.CLICK","{handler:'e266Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPOBRASOCCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPFONSOLREDCONT.CLICK","{handler:'e276Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPFONSOLREDCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPRENATEACONT.CLICK","{handler:'e286Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPRENATEACONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPASIGFAMCONT.CLICK","{handler:'e296Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPASIGFAMCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPFONNACEMPCONT.CLICK","{handler:'e306Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPFONNACEMPCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPLEYRIETRABCONT.CLICK","{handler:'e316Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPLEYRIETRABCONT.CLICK",",oparms:[]}");
      setEventMetadata("VCONAFIPTIPO.CLICK","{handler:'e326Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VCONAFIPTIPO.CLICK",",oparms:[]}");
      setEventMetadata("VLIBRE.ISVALID","{handler:'e336Y2',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'cmbavConafipsipaapo'},{av:'AV15ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:''},{av:'cmbavConafipinssjypapo'},{av:'AV16ConAFIPINSSJyPApo',fld:'vCONAFIPINSSJYPAPO',pic:''},{av:'cmbavConafipobrasocapo'},{av:'AV17ConAFIPObraSocApo',fld:'vCONAFIPOBRASOCAPO',pic:''},{av:'cmbavConafipfonsolredapo'},{av:'AV18ConAFIPFonSolRedApo',fld:'vCONAFIPFONSOLREDAPO',pic:''},{av:'cmbavConafiprenateaapo'},{av:'AV19ConAFIPRenateaApo',fld:'vCONAFIPRENATEAAPO',pic:''},{av:'cmbavConafipregdifapo'},{av:'AV20ConAFIPRegDifApo',fld:'vCONAFIPREGDIFAPO',pic:''},{av:'cmbavConafipregespapo'},{av:'AV21ConAFIPRegEspApo',fld:'vCONAFIPREGESPAPO',pic:''},{av:'cmbavConafipsipacont'},{av:'AV22ConAFIPSIPACont',fld:'vCONAFIPSIPACONT',pic:''},{av:'cmbavConafipinssjypcont'},{av:'AV23ConAFIPINSSJyPCont',fld:'vCONAFIPINSSJYPCONT',pic:''},{av:'cmbavConafipobrasoccont'},{av:'AV24ConAFIPObraSocCont',fld:'vCONAFIPOBRASOCCONT',pic:''},{av:'cmbavConafipfonsolredcont'},{av:'AV25ConAFIPFonSolRedCont',fld:'vCONAFIPFONSOLREDCONT',pic:''},{av:'cmbavConafiprenateacont'},{av:'AV26ConAFIPRenateaCont',fld:'vCONAFIPRENATEACONT',pic:''},{av:'cmbavConafipasigfamcont'},{av:'AV27ConAFIPAsigFamCont',fld:'vCONAFIPASIGFAMCONT',pic:''},{av:'cmbavConafipfonnacempcont'},{av:'AV28ConAFIPFonNacEmpCont',fld:'vCONAFIPFONNACEMPCONT',pic:''},{av:'cmbavConafipleyrietrabcont'},{av:'AV29ConAFIPLeyRieTrabCont',fld:'vCONAFIPLEYRIETRABCONT',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''},{av:'AV35libre',fld:'vLIBRE',pic:''},{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV30Propio',fld:'vPROPIO',pic:'',hsh:true}]");
      setEventMetadata("VLIBRE.ISVALID",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPSUBT1","{handler:'validv_Conafipsubt1',iparms:[{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''}]");
      setEventMetadata("VALIDV_CONAFIPSUBT1",",oparms:[{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''}]}");
      setEventMetadata("VALIDV_CONAFIPSIPAAPO","{handler:'validv_Conafipsipaapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPSIPAAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPINSSJYPAPO","{handler:'validv_Conafipinssjypapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPINSSJYPAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPOBRASOCAPO","{handler:'validv_Conafipobrasocapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPOBRASOCAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPFONSOLREDAPO","{handler:'validv_Conafipfonsolredapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPFONSOLREDAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPRENATEAAPO","{handler:'validv_Conafiprenateaapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPRENATEAAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPREGDIFAPO","{handler:'validv_Conafipregdifapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPREGDIFAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPREGESPAPO","{handler:'validv_Conafipregespapo',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPREGESPAPO",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPSIPACONT","{handler:'validv_Conafipsipacont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPSIPACONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPINSSJYPCONT","{handler:'validv_Conafipinssjypcont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPINSSJYPCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPOBRASOCCONT","{handler:'validv_Conafipobrasoccont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPOBRASOCCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPFONSOLREDCONT","{handler:'validv_Conafipfonsolredcont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPFONSOLREDCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPRENATEACONT","{handler:'validv_Conafiprenateacont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPRENATEACONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPASIGFAMCONT","{handler:'validv_Conafipasigfamcont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPASIGFAMCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPFONNACEMPCONT","{handler:'validv_Conafipfonnacempcont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPFONNACEMPCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPLEYRIETRABCONT","{handler:'validv_Conafipleyrietrabcont',iparms:[]");
      setEventMetadata("VALIDV_CONAFIPLEYRIETRABCONT",",oparms:[]}");
      setEventMetadata("VALIDV_CONAFIPTIPO","{handler:'validv_Conafiptipo',iparms:[{av:'cmbavConafiptipo'},{av:'AV32ConAFIPTipo',fld:'vCONAFIPTIPO',pic:''},{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''}]");
      setEventMetadata("VALIDV_CONAFIPTIPO",",oparms:[{av:'dynavConafipsubt1'},{av:'AV33ConAfipSubT1',fld:'vCONAFIPSUBT1',pic:''},{av:'dynavConafipconcepto'},{av:'AV34ConAFIPConcepto',fld:'vCONAFIPCONCEPTO',pic:''}]}");
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
      wcpOAV6WebSessionKey = "" ;
      wcpOAV8PreviousStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6WebSessionKey = "" ;
      AV8PreviousStep = "" ;
      AV32ConAFIPTipo = "" ;
      AV33ConAfipSubT1 = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV30Propio = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ucBtnwizardprevious = new com.genexus.webpanels.GXUserControl();
      ucBtnwizardnext = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H006Y2_A38SubTipoConCod1 = new String[] {""} ;
      H006Y2_A371SubTipoConDes1 = new String[] {""} ;
      H006Y2_A37TipoConCod = new String[] {""} ;
      AV34ConAFIPConcepto = "" ;
      H006Y3_A72AFIPConCod = new String[] {""} ;
      H006Y3_A385AfipConCodMasDesc = new String[] {""} ;
      H006Y3_A387AfipConTipoConCod = new String[] {""} ;
      H006Y3_A388AfipConSubTipoConCod1 = new String[] {""} ;
      AV15ConAFIPSIPAApo = "" ;
      AV16ConAFIPINSSJyPApo = "" ;
      AV17ConAFIPObraSocApo = "" ;
      AV18ConAFIPFonSolRedApo = "" ;
      AV19ConAFIPRenateaApo = "" ;
      AV20ConAFIPRegDifApo = "" ;
      AV21ConAFIPRegEspApo = "" ;
      AV22ConAFIPSIPACont = "" ;
      AV23ConAFIPINSSJyPCont = "" ;
      AV24ConAFIPObraSocCont = "" ;
      AV25ConAFIPFonSolRedCont = "" ;
      AV26ConAFIPRenateaCont = "" ;
      AV27ConAFIPAsigFamCont = "" ;
      AV28ConAFIPFonNacEmpCont = "" ;
      AV29ConAFIPLeyRieTrabCont = "" ;
      AV35libre = "" ;
      AV5WebSession = httpContext.getWebSession();
      AV52ConDescrip = "" ;
      ucDvpanel_panelafip = new com.genexus.webpanels.GXUserControl();
      AV50error = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar4 = new GXSimpleCollection[1] ;
      AV44proximoPaso = "" ;
      AV45steps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle);
      AV47anterior = "" ;
      AV46step = new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV11WizardData = new web.SdtConceptosAfipWizardData(remoteHandle, context);
      H006Y4_A380ConAFIPTipo = new String[] {""} ;
      H006Y4_A381ConAfipSubT1 = new String[] {""} ;
      H006Y4_A386ConAFIPConcepto = new String[] {""} ;
      H006Y4_n386ConAFIPConcepto = new boolean[] {false} ;
      H006Y4_A141ConAFIPSIPAApo = new String[] {""} ;
      H006Y4_A142ConAFIPSIPACont = new String[] {""} ;
      H006Y4_A131ConAFIPINSSJyPApo = new String[] {""} ;
      H006Y4_A132ConAFIPINSSJyPCont = new String[] {""} ;
      H006Y4_A135ConAFIPObraSocApo = new String[] {""} ;
      H006Y4_A136ConAFIPObraSocCont = new String[] {""} ;
      H006Y4_A129ConAFIPFonSolRedApo = new String[] {""} ;
      H006Y4_A130ConAFIPFonSolRedCont = new String[] {""} ;
      H006Y4_A139ConAFIPRenateaApo = new String[] {""} ;
      H006Y4_A140ConAFIPRenateaCont = new String[] {""} ;
      H006Y4_A127ConAFIPAsigFamCont = new String[] {""} ;
      H006Y4_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      H006Y4_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      H006Y4_A137ConAFIPRegDifApo = new String[] {""} ;
      H006Y4_A138ConAFIPRegEspApo = new String[] {""} ;
      H006Y4_A379ConAfipEstado = new String[] {""} ;
      H006Y4_A382ConAfipSubT2 = new String[] {""} ;
      H006Y4_A383ConAfipDesc = new String[] {""} ;
      H006Y4_A73ConCodPropio = new String[] {""} ;
      H006Y4_A3CliCod = new int[1] ;
      A380ConAFIPTipo = "" ;
      A381ConAfipSubT1 = "" ;
      A386ConAFIPConcepto = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      A379ConAfipEstado = "" ;
      A382ConAfipSubT2 = "" ;
      A383ConAfipDesc = "" ;
      A73ConCodPropio = "" ;
      A391ConAfipSubT2Def = "" ;
      A390ConAfipSubT1Def = "" ;
      A389ConAFIPTipoDef = "" ;
      GXv_boolean7 = new boolean[1] ;
      AV39ConAfipEstado = "" ;
      AV40ConAfipSubT2 = "" ;
      AV31ConAfipDesc = "" ;
      AV41ConAFIPTipoDef = "" ;
      AV42ConAfipSubT1Def = "" ;
      AV43ConAfipSubT2Def = "" ;
      GXv_int2 = new int[1] ;
      GXt_char5 = "" ;
      GXv_char3 = new String[1] ;
      AV55httpRequest = httpContext.getHttpRequest();
      sStyleString = "" ;
      ucDvpanel_panelapocont = new com.genexus.webpanels.GXUserControl();
      lblS1_Jsonclick = "" ;
      lblSipatxt__Jsonclick = "" ;
      lblInjtxt__Jsonclick = "" ;
      lblOstxt__Jsonclick = "" ;
      lblFsr__Jsonclick = "" ;
      lblUatretxt__Jsonclick = "" ;
      lblAafftxt__Jsonclick = "" ;
      lblFnetxt__Jsonclick = "" ;
      lblDiftxt__Jsonclick = "" ;
      lblRegesptxt__Jsonclick = "" ;
      lblAportxt__Jsonclick = "" ;
      lblGuion1__Jsonclick = "" ;
      lblGuion2__Jsonclick = "" ;
      lblContrtxt__Jsonclick = "" ;
      lblGuion3__Jsonclick = "" ;
      lblGuion4__Jsonclick = "" ;
      lblLrt_txt__Jsonclick = "" ;
      lblTipo_Jsonclick = "" ;
      lblTextblock3__Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6WebSessionKey = "" ;
      sCtrlAV8PreviousStep = "" ;
      sCtrlAV7GoingBack = "" ;
      ZV34ConAFIPConcepto = "" ;
      ZV33ConAfipSubT1 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptosafipwizardconcepto1__default(),
         new Object[] {
             new Object[] {
            H006Y2_A38SubTipoConCod1, H006Y2_A371SubTipoConDes1, H006Y2_A37TipoConCod
            }
            , new Object[] {
            H006Y3_A72AFIPConCod, H006Y3_A385AfipConCodMasDesc, H006Y3_A387AfipConTipoConCod, H006Y3_A388AfipConSubTipoConCod1
            }
            , new Object[] {
            H006Y4_A380ConAFIPTipo, H006Y4_A381ConAfipSubT1, H006Y4_A386ConAFIPConcepto, H006Y4_n386ConAFIPConcepto, H006Y4_A141ConAFIPSIPAApo, H006Y4_A142ConAFIPSIPACont, H006Y4_A131ConAFIPINSSJyPApo, H006Y4_A132ConAFIPINSSJyPCont, H006Y4_A135ConAFIPObraSocApo, H006Y4_A136ConAFIPObraSocCont,
            H006Y4_A129ConAFIPFonSolRedApo, H006Y4_A130ConAFIPFonSolRedCont, H006Y4_A139ConAFIPRenateaApo, H006Y4_A140ConAFIPRenateaCont, H006Y4_A127ConAFIPAsigFamCont, H006Y4_A128ConAFIPFonNacEmpCont, H006Y4_A133ConAFIPLeyRieTrabCont, H006Y4_A137ConAFIPRegDifApo, H006Y4_A138ConAFIPRegEspApo, H006Y4_A379ConAfipEstado,
            H006Y4_A382ConAfipSubT2, H006Y4_A383ConAfipDesc, H006Y4_A73ConCodPropio, H006Y4_A3CliCod
            }
         }
      );
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
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV51e ;
   private int AV12CliCod ;
   private int gxdynajaxindex ;
   private int AV58GXV1 ;
   private int A3CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtavLibre_Visible ;
   private int tblTblapocon_Visible ;
   private int edtavLibre_Enabled ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV32ConAFIPTipo ;
   private String AV33ConAfipSubT1 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV30Propio ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableinfo_Internalname ;
   private String divTableactions_Internalname ;
   private String Btnwizardprevious_Beforeiconclass ;
   private String Btnwizardprevious_Caption ;
   private String Btnwizardprevious_Class ;
   private String Btnwizardprevious_Internalname ;
   private String Btnwizardnext_Aftericonclass ;
   private String Btnwizardnext_Caption ;
   private String Btnwizardnext_Class ;
   private String Btnwizardnext_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV34ConAFIPConcepto ;
   private String AV15ConAFIPSIPAApo ;
   private String AV16ConAFIPINSSJyPApo ;
   private String AV17ConAFIPObraSocApo ;
   private String AV18ConAFIPFonSolRedApo ;
   private String AV19ConAFIPRenateaApo ;
   private String AV20ConAFIPRegDifApo ;
   private String AV21ConAFIPRegEspApo ;
   private String AV22ConAFIPSIPACont ;
   private String AV23ConAFIPINSSJyPCont ;
   private String AV24ConAFIPObraSocCont ;
   private String AV25ConAFIPFonSolRedCont ;
   private String AV26ConAFIPRenateaCont ;
   private String AV27ConAFIPAsigFamCont ;
   private String AV28ConAFIPFonNacEmpCont ;
   private String AV29ConAFIPLeyRieTrabCont ;
   private String AV35libre ;
   private String edtavLibre_Internalname ;
   private String Dvpanel_panelafip_Title ;
   private String Dvpanel_panelafip_Internalname ;
   private String lblTipo_Caption ;
   private String lblTipo_Internalname ;
   private String AV44proximoPaso ;
   private String AV47anterior ;
   private String A380ConAFIPTipo ;
   private String A381ConAfipSubT1 ;
   private String A386ConAFIPConcepto ;
   private String A141ConAFIPSIPAApo ;
   private String A142ConAFIPSIPACont ;
   private String A131ConAFIPINSSJyPApo ;
   private String A132ConAFIPINSSJyPCont ;
   private String A135ConAFIPObraSocApo ;
   private String A136ConAFIPObraSocCont ;
   private String A129ConAFIPFonSolRedApo ;
   private String A130ConAFIPFonSolRedCont ;
   private String A139ConAFIPRenateaApo ;
   private String A140ConAFIPRenateaCont ;
   private String A127ConAFIPAsigFamCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String A137ConAFIPRegDifApo ;
   private String A138ConAFIPRegEspApo ;
   private String A379ConAfipEstado ;
   private String A382ConAfipSubT2 ;
   private String A73ConCodPropio ;
   private String A391ConAfipSubT2Def ;
   private String A390ConAfipSubT1Def ;
   private String A389ConAFIPTipoDef ;
   private String AV39ConAfipEstado ;
   private String AV40ConAfipSubT2 ;
   private String AV41ConAFIPTipoDef ;
   private String AV42ConAfipSubT1Def ;
   private String AV43ConAfipSubT2Def ;
   private String edtavLibre_Invitemessage ;
   private String GXt_char5 ;
   private String GXv_char3[] ;
   private String tblTblapocon_Internalname ;
   private String sStyleString ;
   private String tblUnnamedtable1_Internalname ;
   private String Dvpanel_panelafip_Width ;
   private String Dvpanel_panelafip_Cls ;
   private String Dvpanel_panelafip_Iconposition ;
   private String divPanelafip_Internalname ;
   private String Dvpanel_panelapocont_Width ;
   private String Dvpanel_panelapocont_Cls ;
   private String Dvpanel_panelapocont_Title ;
   private String Dvpanel_panelapocont_Iconposition ;
   private String Dvpanel_panelapocont_Internalname ;
   private String divPanelapocont_Internalname ;
   private String tblTbl2_Internalname ;
   private String lblS1_Internalname ;
   private String lblS1_Jsonclick ;
   private String lblSipatxt__Internalname ;
   private String lblSipatxt__Jsonclick ;
   private String lblInjtxt__Internalname ;
   private String lblInjtxt__Jsonclick ;
   private String lblOstxt__Internalname ;
   private String lblOstxt__Jsonclick ;
   private String lblFsr__Internalname ;
   private String lblFsr__Jsonclick ;
   private String lblUatretxt__Internalname ;
   private String lblUatretxt__Jsonclick ;
   private String lblAafftxt__Internalname ;
   private String lblAafftxt__Jsonclick ;
   private String lblFnetxt__Internalname ;
   private String lblFnetxt__Jsonclick ;
   private String lblDiftxt__Internalname ;
   private String lblDiftxt__Jsonclick ;
   private String lblRegesptxt__Internalname ;
   private String lblRegesptxt__Jsonclick ;
   private String lblAportxt__Internalname ;
   private String lblAportxt__Jsonclick ;
   private String lblGuion1__Internalname ;
   private String lblGuion1__Jsonclick ;
   private String lblGuion2__Internalname ;
   private String lblGuion2__Jsonclick ;
   private String lblContrtxt__Internalname ;
   private String lblContrtxt__Jsonclick ;
   private String lblGuion3__Internalname ;
   private String lblGuion3__Jsonclick ;
   private String lblGuion4__Internalname ;
   private String lblGuion4__Jsonclick ;
   private String lblLrt_txt__Internalname ;
   private String lblLrt_txt__Jsonclick ;
   private String tblTbl1_Internalname ;
   private String lblTipo_Jsonclick ;
   private String lblTextblock3__Internalname ;
   private String lblTextblock3__Jsonclick ;
   private String edtavLibre_Jsonclick ;
   private String sCtrlAV6WebSessionKey ;
   private String sCtrlAV8PreviousStep ;
   private String sCtrlAV7GoingBack ;
   private String ZV34ConAFIPConcepto ;
   private String ZV33ConAfipSubT1 ;
   private boolean wcpOAV7GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV7GoingBack ;
   private boolean AV10HasValidationErrors ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean n386ConAFIPConcepto ;
   private boolean AV49existeAfipConcepto ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean AV54aplicaAlgo ;
   private boolean Cond_result ;
   private boolean Dvpanel_panelafip_Autowidth ;
   private boolean Dvpanel_panelafip_Autoheight ;
   private boolean Dvpanel_panelafip_Collapsible ;
   private boolean Dvpanel_panelafip_Collapsed ;
   private boolean Dvpanel_panelafip_Showcollapseicon ;
   private boolean Dvpanel_panelafip_Autoscroll ;
   private boolean Dvpanel_panelapocont_Autowidth ;
   private boolean Dvpanel_panelapocont_Autoheight ;
   private boolean Dvpanel_panelapocont_Collapsible ;
   private boolean Dvpanel_panelapocont_Collapsed ;
   private boolean Dvpanel_panelapocont_Showcollapseicon ;
   private boolean Dvpanel_panelapocont_Autoscroll ;
   private String wcpOAV6WebSessionKey ;
   private String wcpOAV8PreviousStep ;
   private String AV6WebSessionKey ;
   private String AV8PreviousStep ;
   private String AV52ConDescrip ;
   private String A383ConAfipDesc ;
   private String AV31ConAfipDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV55httpRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV5WebSession ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardprevious ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardnext ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelafip ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelapocont ;
   private HTMLChoice dynavConafipsubt1 ;
   private HTMLChoice dynavConafipconcepto ;
   private HTMLChoice cmbavConafipsipaapo ;
   private HTMLChoice cmbavConafipinssjypapo ;
   private HTMLChoice cmbavConafipobrasocapo ;
   private HTMLChoice cmbavConafipfonsolredapo ;
   private HTMLChoice cmbavConafiprenateaapo ;
   private HTMLChoice cmbavConafipregdifapo ;
   private HTMLChoice cmbavConafipregespapo ;
   private HTMLChoice cmbavConafipsipacont ;
   private HTMLChoice cmbavConafipinssjypcont ;
   private HTMLChoice cmbavConafipobrasoccont ;
   private HTMLChoice cmbavConafipfonsolredcont ;
   private HTMLChoice cmbavConafiprenateacont ;
   private HTMLChoice cmbavConafipasigfamcont ;
   private HTMLChoice cmbavConafipfonnacempcont ;
   private HTMLChoice cmbavConafipleyrietrabcont ;
   private HTMLChoice cmbavConafiptipo ;
   private IDataStoreProvider pr_default ;
   private String[] H006Y2_A38SubTipoConCod1 ;
   private String[] H006Y2_A371SubTipoConDes1 ;
   private String[] H006Y2_A37TipoConCod ;
   private String[] H006Y3_A72AFIPConCod ;
   private String[] H006Y3_A385AfipConCodMasDesc ;
   private String[] H006Y3_A387AfipConTipoConCod ;
   private String[] H006Y3_A388AfipConSubTipoConCod1 ;
   private String[] H006Y4_A380ConAFIPTipo ;
   private String[] H006Y4_A381ConAfipSubT1 ;
   private String[] H006Y4_A386ConAFIPConcepto ;
   private boolean[] H006Y4_n386ConAFIPConcepto ;
   private String[] H006Y4_A141ConAFIPSIPAApo ;
   private String[] H006Y4_A142ConAFIPSIPACont ;
   private String[] H006Y4_A131ConAFIPINSSJyPApo ;
   private String[] H006Y4_A132ConAFIPINSSJyPCont ;
   private String[] H006Y4_A135ConAFIPObraSocApo ;
   private String[] H006Y4_A136ConAFIPObraSocCont ;
   private String[] H006Y4_A129ConAFIPFonSolRedApo ;
   private String[] H006Y4_A130ConAFIPFonSolRedCont ;
   private String[] H006Y4_A139ConAFIPRenateaApo ;
   private String[] H006Y4_A140ConAFIPRenateaCont ;
   private String[] H006Y4_A127ConAFIPAsigFamCont ;
   private String[] H006Y4_A128ConAFIPFonNacEmpCont ;
   private String[] H006Y4_A133ConAFIPLeyRieTrabCont ;
   private String[] H006Y4_A137ConAFIPRegDifApo ;
   private String[] H006Y4_A138ConAFIPRegEspApo ;
   private String[] H006Y4_A379ConAfipEstado ;
   private String[] H006Y4_A382ConAfipSubT2 ;
   private String[] H006Y4_A383ConAfipDesc ;
   private String[] H006Y4_A73ConCodPropio ;
   private int[] H006Y4_A3CliCod ;
   private GXSimpleCollection<String> AV50error ;
   private GXSimpleCollection<String> GXv_objcol_svchar4[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV45steps ;
   private web.SdtConceptosAfipWizardData AV11WizardData ;
   private web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV46step ;
}

final  class conceptosafipwizardconcepto1__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006Y2", "SELECT SubTipoConCod1, SubTipoConDes1, TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) ORDER BY SubTipoConDes1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006Y3", "SELECT AFIPConCod, AfipConCodMasDesc, AfipConTipoConCod, AfipConSubTipoConCod1 FROM AFIPConcepto WHERE (AfipConTipoConCod = ( ?)) AND (AfipConSubTipoConCod1 = ( ?)) ORDER BY AfipConCodMasDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006Y4", "SELECT ConAFIPTipo, ConAfipSubT1, ConAFIPConcepto, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAfipSubT2, ConAfipDesc, ConCodPropio, CliCod FROM ConceptoAFIP WHERE CliCod = ? and ConCodPropio = ( ?) ORDER BY CliCod, ConCodPropio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 20);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getVarchar(21);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((int[]) buf[23])[0] = rslt.getInt(23);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

