package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importarliquidacioneswizard2importcc_impl extends GXWebComponent
{
   public importarliquidacioneswizard2importcc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importarliquidacioneswizard2importcc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarliquidacioneswizard2importcc_impl.class ));
   }

   public importarliquidacioneswizard2importcc_impl( int remoteHandle ,
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
               AV6WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
               AV8PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
               AV7GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
               AV16MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MenuOpcCod", AV16MenuOpcCod);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV6WebSessionKey,AV8PreviousStep,Boolean.valueOf(AV7GoingBack),AV16MenuOpcCod});
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
         paOC2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Importar Liquidaciones Wizard2 Import CC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importarliquidacioneswizard2importcc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV8PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV7GoingBack)),GXutil.URLEncode(GXutil.rtrim(AV16MenuOpcCod))}, new String[] {"WebSessionKey","PreviousStep","GoingBack","MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16MenuOpcCod", wcpOAV16MenuOpcCod);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV7GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV12CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV6WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV16MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV8PreviousStep);
   }

   public void renderHtmlCloseFormOC2( )
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
         if ( ! ( WebComp_Wcimportcc == null ) )
         {
            WebComp_Wcimportcc.componentjscripts();
         }
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
      return "ImportarLiquidacionesWizard2ImportCC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importar Liquidaciones Wizard2 Import CC", "") ;
   }

   public void wbOC0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importarliquidacioneswizard2importcc");
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
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0009"+"", GXutil.rtrim( WebComp_Wcimportcc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0009"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wcimportcc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWcimportcc), GXutil.lower( WebComp_Wcimportcc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0009"+"");
               }
               WebComp_Wcimportcc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWcimportcc), GXutil.lower( WebComp_Wcimportcc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnwizardfirstprevious.setProperty("BeforeIconClass", Btnwizardfirstprevious_Beforeiconclass);
         ucBtnwizardfirstprevious.setProperty("Caption", Btnwizardfirstprevious_Caption);
         ucBtnwizardfirstprevious.setProperty("Class", Btnwizardfirstprevious_Class);
         ucBtnwizardfirstprevious.render(context, "wwp_iconbutton", Btnwizardfirstprevious_Internalname, sPrefix+"BTNWIZARDFIRSTPREVIOUSContainer");
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startOC2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Importar Liquidaciones Wizard2 Import CC", ""), (short)(0)) ;
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
            strupOC0( ) ;
         }
      }
   }

   public void wsOC2( )
   {
      startOC2( ) ;
      evtOC2( ) ;
   }

   public void evtOC2( )
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
                              strupOC0( ) ;
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
                              strupOC0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11OC2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOC0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e12OC2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOC0( ) ;
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
                                       e13OC2 ();
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
                              strupOC0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardPrevious' */
                                 e14OC2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOC0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e15OC2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupOC0( ) ;
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 9 )
                     {
                        OldWcimportcc = httpContext.cgiGet( sPrefix+"W0009") ;
                        if ( ( GXutil.len( OldWcimportcc) == 0 ) || ( GXutil.strcmp(OldWcimportcc, WebComp_Wcimportcc_Component) != 0 ) )
                        {
                           WebComp_Wcimportcc = WebUtils.getWebComponent(getClass(), "web." + OldWcimportcc + "_impl", remoteHandle, context);
                           WebComp_Wcimportcc_Component = OldWcimportcc ;
                        }
                        if ( GXutil.len( WebComp_Wcimportcc_Component) != 0 )
                        {
                           WebComp_Wcimportcc.componentprocess(sPrefix+"W0009", "", sEvt);
                        }
                        WebComp_Wcimportcc_Component = OldWcimportcc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weOC2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormOC2( ) ;
         }
      }
   }

   public void paOC2( )
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
      rfOC2( ) ;
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

   public void rfOC2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e12OC2 ();
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wcimportcc_Component) != 0 )
            {
               WebComp_Wcimportcc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e15OC2 ();
         wbOC0( ) ;
      }
   }

   public void send_integrity_lvl_hashesOC2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV12CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupOC0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11OC2 ();
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
         wcpOAV16MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV16MenuOpcCod") ;
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
      e11OC2 ();
      if (returnInSub) return;
   }

   public void e11OC2( )
   {
      /* Start Routine */
      returnInSub = false ;
      System.out.println( httpContext.getMessage( "start &MenuOpcCod ", "")+AV16MenuOpcCod );
      GXt_int1 = AV13EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2importcc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13EmpCod = GXt_int1 ;
      GXt_int3 = AV12CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      importarliquidacioneswizard2importcc_impl.this.GXt_int3 = GXv_int4[0] ;
      AV12CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      /* Object Property */
      if ( GXutil.len( sPrefix) == 0 )
      {
         bDynCreated_Wcimportcc = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Wcimportcc_Component), GXutil.lower( "ImportCC")) != 0 )
      {
         WebComp_Wcimportcc = WebUtils.getWebComponent(getClass(), "web.importcc_impl", remoteHandle, context);
         WebComp_Wcimportcc_Component = "ImportCC" ;
      }
      if ( GXutil.len( WebComp_Wcimportcc_Component) != 0 )
      {
         WebComp_Wcimportcc.setjustcreated();
         WebComp_Wcimportcc.componentprepare(new Object[] {sPrefix+"W0009","",Integer.valueOf(AV12CliCod),Short.valueOf(AV13EmpCod)});
         WebComp_Wcimportcc.componentbind(new Object[] {"",""});
      }
   }

   public void e12OC2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2importcc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13EmpCod = GXt_int1 ;
      GXt_int3 = AV12CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      importarliquidacioneswizard2importcc_impl.this.GXt_int3 = GXv_int4[0] ;
      AV12CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV12CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13OC2 ();
      if (returnInSub) return;
   }

   public void e13OC2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      System.out.println( httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+httpContext.getMessage( " &HasValidationErrors ", "")+GXutil.trim( GXutil.booltostr( AV10HasValidationErrors))+httpContext.getMessage( " &WebSessionKey ", "")+AV6WebSessionKey );
      if ( true )
      {
         if ( ! AV10HasValidationErrors )
         {
            System.out.println( "1 " );
            /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
            S132 ();
            if (returnInSub) return;
            System.out.println( "2 " );
            callWebObject(formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim("ImportCC")),GXutil.URLEncode(GXutil.rtrim("ImportLSD")),GXutil.URLEncode(GXutil.booltostr(false)),GXutil.URLEncode(GXutil.rtrim(AV16MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
            System.out.println( "3 " );
         }
      }
      else
      {
         if ( ! AV10HasValidationErrors )
         {
            /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
            S132 ();
            if (returnInSub) return;
            callWebObject(formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim("ImportCC")),GXutil.URLEncode(GXutil.rtrim("ImportLSD")),GXutil.URLEncode(GXutil.booltostr(false)),GXutil.URLEncode(GXutil.rtrim(AV16MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void e14OC2( )
   {
      /* 'WizardPrevious' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {AV16MenuOpcCod});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV16MenuOpcCod"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ! AV7GoingBack ) )
      {
         Btnwizardfirstprevious_Visible = false ;
         ucBtnwizardfirstprevious.sendProperty(context, sPrefix, false, Btnwizardfirstprevious_Internalname, "Visible", GXutil.booltostr( Btnwizardfirstprevious_Visible));
      }
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
   }

   public void S132( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV5WebSession.setValue(AV6WebSessionKey, AV11WizardData.toJSonString(false, true));
   }

   protected void nextLoad( )
   {
   }

   protected void e15OC2( )
   {
      /* Load Routine */
      returnInSub = false ;
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
      AV16MenuOpcCod = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MenuOpcCod", AV16MenuOpcCod);
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
      paOC2( ) ;
      wsOC2( ) ;
      weOC2( ) ;
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
      sCtrlAV16MenuOpcCod = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paOC2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importarliquidacioneswizard2importcc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paOC2( ) ;
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
         AV16MenuOpcCod = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MenuOpcCod", AV16MenuOpcCod);
      }
      wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
      wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
      wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
      wcpOAV16MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV16MenuOpcCod") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6WebSessionKey, wcpOAV6WebSessionKey) != 0 ) || ( GXutil.strcmp(AV8PreviousStep, wcpOAV8PreviousStep) != 0 ) || ( AV7GoingBack != wcpOAV7GoingBack ) || ( GXutil.strcmp(AV16MenuOpcCod, wcpOAV16MenuOpcCod) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV6WebSessionKey = AV6WebSessionKey ;
      wcpOAV8PreviousStep = AV8PreviousStep ;
      wcpOAV7GoingBack = AV7GoingBack ;
      wcpOAV16MenuOpcCod = AV16MenuOpcCod ;
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
      sCtrlAV16MenuOpcCod = httpContext.cgiGet( sPrefix+"AV16MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV16MenuOpcCod) > 0 )
      {
         AV16MenuOpcCod = httpContext.cgiGet( sCtrlAV16MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MenuOpcCod", AV16MenuOpcCod);
      }
      else
      {
         AV16MenuOpcCod = httpContext.cgiGet( sPrefix+"AV16MenuOpcCod_PARM") ;
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
      paOC2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsOC2( ) ;
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
      wsOC2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16MenuOpcCod_PARM", AV16MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV16MenuOpcCod));
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
      weOC2( ) ;
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
      if ( ! ( WebComp_Wcimportcc == null ) )
      {
         WebComp_Wcimportcc.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wcimportcc == null ) )
      {
         if ( GXutil.len( WebComp_Wcimportcc_Component) != 0 )
         {
            WebComp_Wcimportcc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020115968", true, true);
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
      httpContext.AddJavascriptSource("importarliquidacioneswizard2importcc.js", "?2024122020115969", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      Btnwizardfirstprevious_Internalname = sPrefix+"BTNWIZARDFIRSTPREVIOUS" ;
      Btnwizardnext_Internalname = sPrefix+"BTNWIZARDNEXT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
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
      Btnwizardfirstprevious_Visible = GXutil.toBoolean( -1) ;
      Btnwizardnext_Class = "Button ButtonWizard" ;
      Btnwizardnext_Caption = httpContext.getMessage( "GXM_next", "") ;
      Btnwizardnext_Aftericonclass = "fas fa-arrow-right" ;
      Btnwizardfirstprevious_Class = "BtnDefault ButtonWizard" ;
      Btnwizardfirstprevious_Caption = httpContext.getMessage( "GX_BtnCancel", "") ;
      Btnwizardfirstprevious_Beforeiconclass = "fas fa-arrow-left" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV7GoingBack',fld:'vGOINGBACK',pic:''},{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'Btnwizardfirstprevious_Visible',ctrl:'BTNWIZARDFIRSTPREVIOUS',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e13OC2',iparms:[{av:'AV12CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV16MenuOpcCod',fld:'vMENUOPCCOD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV16MenuOpcCod',fld:'vMENUOPCCOD',pic:''}]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e14OC2',iparms:[{av:'AV16MenuOpcCod',fld:'vMENUOPCCOD',pic:''}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[]}");
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
      wcpOAV16MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6WebSessionKey = "" ;
      AV8PreviousStep = "" ;
      AV16MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      WebComp_Wcimportcc_Component = "" ;
      OldWcimportcc = "" ;
      ucBtnwizardfirstprevious = new com.genexus.webpanels.GXUserControl();
      ucBtnwizardnext = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV11WizardData = new web.SdtImportarLiquidacionesWizard2Data(remoteHandle, context);
      AV5WebSession = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6WebSessionKey = "" ;
      sCtrlAV8PreviousStep = "" ;
      sCtrlAV7GoingBack = "" ;
      sCtrlAV16MenuOpcCod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Wcimportcc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV13EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int AV12CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int idxLst ;
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
   private String WebComp_Wcimportcc_Component ;
   private String OldWcimportcc ;
   private String divTableactions_Internalname ;
   private String Btnwizardfirstprevious_Beforeiconclass ;
   private String Btnwizardfirstprevious_Caption ;
   private String Btnwizardfirstprevious_Class ;
   private String Btnwizardfirstprevious_Internalname ;
   private String Btnwizardnext_Aftericonclass ;
   private String Btnwizardnext_Caption ;
   private String Btnwizardnext_Class ;
   private String Btnwizardnext_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sCtrlAV6WebSessionKey ;
   private String sCtrlAV8PreviousStep ;
   private String sCtrlAV7GoingBack ;
   private String sCtrlAV16MenuOpcCod ;
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
   private boolean bDynCreated_Wcimportcc ;
   private boolean Btnwizardfirstprevious_Visible ;
   private String wcpOAV6WebSessionKey ;
   private String wcpOAV8PreviousStep ;
   private String wcpOAV16MenuOpcCod ;
   private String AV6WebSessionKey ;
   private String AV8PreviousStep ;
   private String AV16MenuOpcCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wcimportcc ;
   private com.genexus.webpanels.WebSession AV5WebSession ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardfirstprevious ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardnext ;
   private web.SdtImportarLiquidacionesWizard2Data AV11WizardData ;
}
