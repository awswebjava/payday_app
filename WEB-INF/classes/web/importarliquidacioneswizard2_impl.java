package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importarliquidacioneswizard2_impl extends GXDataArea
{
   public importarliquidacioneswizard2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importarliquidacioneswizard2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarliquidacioneswizard2_impl.class ));
   }

   public importarliquidacioneswizard2_impl( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
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
            AV11PreviousStep = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11PreviousStep", AV11PreviousStep);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PreviousStep, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV6CurrentStep = httpContext.GetPar( "CurrentStep") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV6CurrentStep", AV6CurrentStep);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6CurrentStep, ""))));
               AV9GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
               AV18MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18MenuOpcCod", AV18MenuOpcCod);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
            }
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
      paO82( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startO82( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV6CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack)),GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PreviousStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6CurrentStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV18MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPREVIOUSSTEP", AV11PreviousStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PreviousStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCURRENTSTEP", AV6CurrentStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6CurrentStep, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vGOINGBACK", AV9GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
      if ( ! ( WebComp_Steptitles == null ) )
      {
         WebComp_Steptitles.componentjscripts();
      }
      if ( ! ( WebComp_Wizardstepwc == null ) )
      {
         WebComp_Wizardstepwc.componentjscripts();
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
         weO82( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtO82( ) ;
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
      return formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV6CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack)),GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ImportarLiquidacionesWizard2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importar liquidaciones históricas", "") ;
   }

   public void wbO80( )
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_6_O82( true) ;
      }
      else
      {
         wb_table1_6_O82( false) ;
      }
      return  ;
   }

   public void wb_table1_6_O82e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startO82( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Importar liquidaciones históricas", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupO80( ) ;
   }

   public void wsO82( )
   {
      startO82( ) ;
      evtO82( ) ;
   }

   public void evtO82( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e11O82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e12O82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13O82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e14O82 ();
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
                     if ( nCmpId == 46 )
                     {
                        OldSteptitles = httpContext.cgiGet( "W0046") ;
                        if ( ( GXutil.len( OldSteptitles) == 0 ) || ( GXutil.strcmp(OldSteptitles, WebComp_Steptitles_Component) != 0 ) )
                        {
                           WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "web." + OldSteptitles + "_impl", remoteHandle, context);
                           WebComp_Steptitles_Component = OldSteptitles ;
                        }
                        if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
                        {
                           WebComp_Steptitles.componentprocess("W0046", "", sEvt);
                        }
                        WebComp_Steptitles_Component = OldSteptitles ;
                     }
                     else if ( nCmpId == 49 )
                     {
                        OldWizardstepwc = httpContext.cgiGet( "W0049") ;
                        if ( ( GXutil.len( OldWizardstepwc) == 0 ) || ( GXutil.strcmp(OldWizardstepwc, WebComp_Wizardstepwc_Component) != 0 ) )
                        {
                           WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web." + OldWizardstepwc + "_impl", remoteHandle, context);
                           WebComp_Wizardstepwc_Component = OldWizardstepwc ;
                        }
                        if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
                        {
                           WebComp_Wizardstepwc.componentprocess("W0049", "", sEvt);
                        }
                        WebComp_Wizardstepwc_Component = OldWizardstepwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weO82( )
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

   public void paO82( )
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
      AV24WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV24WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24WelcomeMessage_NoMostrarMas", AV24WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfO82( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV28Pgmname = "ImportarLiquidacionesWizard2" ;
      Gx_err = (short)(0) ;
   }

   public void rfO82( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e12O82 ();
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
            {
               WebComp_Steptitles.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e14O82 ();
         wbO80( ) ;
      }
   }

   public void send_integrity_lvl_hashesO82( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV18MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
   }

   public void before_start_formulas( )
   {
      AV28Pgmname = "ImportarLiquidacionesWizard2" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupO80( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11O82 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV25WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV24WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24WelcomeMessage_NoMostrarMas", AV24WelcomeMessage_NoMostrarMas);
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
      e11O82 ();
      if (returnInSub) return;
   }

   public void e11O82( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV18MenuOpcCod, "", "") ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      AV17WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle) ;
      AV16WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "ImportCC" );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "1 - Relacionar conceptos", "") );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Importar el mismo txt que empleaste para relacionar los conceptos de afip a los conceptos del sistema anterior. La importación se encargará de relacionarlos con los conceptos del sistema actual, o se podrán relacionar manualmente en caso de que no se encuentre un concepto automáticamente.", "") );
      AV17WizardSteps.add(AV16WizardStep, 0);
      AV16WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "ImportLSD" );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "2 - Importar LSDs", "") );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Importar archivos de LSD que se deseen migrar al sistema para tener disponible los datos históricos", "") );
      AV17WizardSteps.add(AV16WizardStep, 0);
      AV16WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "ConfirmarLSDImport" );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "3 - Confirmar", "") );
      AV16WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "3 - Confirmar", "") );
      AV17WizardSteps.add(AV16WizardStep, 0);
      if ( (GXutil.strcmp("", AV6CurrentStep)==0) )
      {
         AV7CurrentStepAux = "ImportCC" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CurrentStepAux", AV7CurrentStepAux);
         AV14WebSession.remove(AV28Pgmname+"_Data");
      }
      else
      {
         AV7CurrentStepAux = AV6CurrentStep ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CurrentStepAux", AV7CurrentStepAux);
      }
      /* Execute user subroutine: 'LOADWIZARDSTEPWC' */
      S112 ();
      if (returnInSub) return;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Steptitles = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Steptitles_Component), GXutil.lower( "WWPBaseObjects.WizardStepsLineWC")) != 0 )
      {
         WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "web.wwpbaseobjects.wizardstepslinewc_impl", remoteHandle, context);
         WebComp_Steptitles_Component = "WWPBaseObjects.WizardStepsLineWC" ;
      }
      if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
      {
         WebComp_Steptitles.setjustcreated();
         WebComp_Steptitles.componentprepare(new Object[] {"W0046","",AV17WizardSteps,AV7CurrentStepAux});
         WebComp_Steptitles.componentbind(new Object[] {"",""});
      }
      GXv_char3[0] = AV19MenuBienveImgURL ;
      GXv_char4[0] = AV21MenuBienveTitulo ;
      GXv_char5[0] = AV22MenuBienveTexto ;
      GXv_boolean6[0] = AV23MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV18MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      importarliquidacioneswizard2_impl.this.AV19MenuBienveImgURL = GXv_char3[0] ;
      importarliquidacioneswizard2_impl.this.AV21MenuBienveTitulo = GXv_char4[0] ;
      importarliquidacioneswizard2_impl.this.AV22MenuBienveTexto = GXv_char5[0] ;
      importarliquidacioneswizard2_impl.this.AV23MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV23MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV23MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV21MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV22MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV25WelcomeMessage_Foto = AV19MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV25WelcomeMessage_Foto)==0) ? AV29Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV25WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV25WelcomeMessage_Foto), true);
         AV29Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV19MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV25WelcomeMessage_Foto)==0) ? AV29Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV25WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV25WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      importarliquidacioneswizard2_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      importarliquidacioneswizard2_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Aquí podrás importar datos de liquidaciones de sueldo históricas al sistema en 3 simples pasos, utilizando los mismos archivos que solicita la afip para Libro de Sueldos Digital", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
   }

   public void S112( )
   {
      /* 'LOADWIZARDSTEPWC' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV7CurrentStepAux, "ImportCC") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ImportarLiquidacionesWizard2ImportCC")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.importarliquidacioneswizard2importcc_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "ImportarLiquidacionesWizard2ImportCC" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0049","",AV28Pgmname+"_Data",AV11PreviousStep,Boolean.valueOf(AV9GoingBack),AV18MenuOpcCod});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else if ( GXutil.strcmp(AV7CurrentStepAux, "ImportLSD") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ImportarLiquidacionesWizard2ImportLSD")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.importarliquidacioneswizard2importlsd_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "ImportarLiquidacionesWizard2ImportLSD" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0049","",AV28Pgmname+"_Data",AV11PreviousStep,Boolean.valueOf(AV9GoingBack),AV18MenuOpcCod});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else if ( GXutil.strcmp(AV7CurrentStepAux, "ConfirmarLSDImport") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ImportarLiquidacionesWizard2ConfirmarLSDImport")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.importarliquidacioneswizard2confirmarlsdimport_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "ImportarLiquidacionesWizard2ConfirmarLSDImport" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0049","",AV28Pgmname+"_Data",AV11PreviousStep,Boolean.valueOf(AV9GoingBack),AV18MenuOpcCod});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   public void e12O82( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importarliquidacioneswizard2_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e13O82( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV24WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV18MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV20textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV5CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         importarliquidacioneswizard2_impl.this.AV20textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV20textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV18MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e14O82( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_6_O82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableWizardMain100", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e15o81_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ImportarLiquidacionesWizard2.htm");
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
         AV25WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV25WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV29Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV25WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV25WelcomeMessage_Foto)==0) ? AV29Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV25WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV25WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ImportarLiquidacionesWizard2.htm");
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
         wb_table2_24_O82( true) ;
      }
      else
      {
         wb_table2_24_O82( false) ;
      }
      return  ;
   }

   public void wb_table2_24_O82e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_29_O82( true) ;
      }
      else
      {
         wb_table3_29_O82( false) ;
      }
      return  ;
   }

   public void wb_table3_29_O82e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV24WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarLiquidacionesWizard2.htm");
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
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0046"+"", GXutil.rtrim( WebComp_Steptitles_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0046"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0046"+"");
               }
               WebComp_Steptitles.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0049"+"", GXutil.rtrim( WebComp_Wizardstepwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0049"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0049"+"");
               }
               WebComp_Wizardstepwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_O82e( true) ;
      }
      else
      {
         wb_table1_6_O82e( false) ;
      }
   }

   public void wb_table3_29_O82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarLiquidacionesWizard2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_29_O82e( true) ;
      }
      else
      {
         wb_table3_29_O82e( false) ;
      }
   }

   public void wb_table2_24_O82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarLiquidacionesWizard2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_24_O82e( true) ;
      }
      else
      {
         wb_table2_24_O82e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11PreviousStep = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11PreviousStep", AV11PreviousStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PreviousStep, ""))));
      AV6CurrentStep = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CurrentStep", AV6CurrentStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6CurrentStep, ""))));
      AV9GoingBack = ((Boolean) getParm(obj,2)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
      AV18MenuOpcCod = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18MenuOpcCod", AV18MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18MenuOpcCod, ""))));
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
      paO82( ) ;
      wsO82( ) ;
      weO82( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Steptitles == null ) )
      {
         if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
         {
            WebComp_Steptitles.componentthemes();
         }
      }
      if ( ! ( WebComp_Wizardstepwc == null ) )
      {
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020115876", true, true);
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
      httpContext.AddJavascriptSource("importarliquidacioneswizard2.js", "?2024122020115876", false, true);
      /* End function include_jscripts */
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
      tblTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Importar liquidaciones históricas", "") );
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
      AV24WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV24WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24WelcomeMessage_NoMostrarMas", AV24WelcomeMessage_NoMostrarMas);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV24WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11PreviousStep',fld:'vPREVIOUSSTEP',pic:'',hsh:true},{av:'AV6CurrentStep',fld:'vCURRENTSTEP',pic:'',hsh:true},{av:'AV9GoingBack',fld:'vGOINGBACK',pic:'',hsh:true},{av:'AV18MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e13O82',iparms:[{av:'AV24WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV18MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e15O81',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
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
      wcpOAV11PreviousStep = "" ;
      wcpOAV6CurrentStep = "" ;
      wcpOAV18MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV11PreviousStep = "" ;
      AV6CurrentStep = "" ;
      AV18MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldSteptitles = "" ;
      WebComp_Steptitles_Component = "" ;
      OldWizardstepwc = "" ;
      WebComp_Wizardstepwc_Component = "" ;
      AV28Pgmname = "" ;
      AV25WelcomeMessage_Foto = "" ;
      AV17WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle);
      AV16WizardStep = new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV7CurrentStepAux = "" ;
      AV14WebSession = httpContext.getWebSession();
      AV19MenuBienveImgURL = "" ;
      GXv_char3 = new String[1] ;
      AV21MenuBienveTitulo = "" ;
      AV22MenuBienveTexto = "" ;
      AV29Welcomemessage_foto_GXI = "" ;
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_int2 = new int[1] ;
      AV20textoNoMostrara = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      sStyleString = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      AV28Pgmname = "ImportarLiquidacionesWizard2" ;
      /* GeneXus formulas. */
      AV28Pgmname = "ImportarLiquidacionesWizard2" ;
      Gx_err = (short)(0) ;
      WebComp_Steptitles = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Wizardstepwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV5CliCod ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldSteptitles ;
   private String WebComp_Steptitles_Component ;
   private String OldWizardstepwc ;
   private String WebComp_Wizardstepwc_Component ;
   private String AV28Pgmname ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String GXv_char3[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char7 ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String GXv_char5[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String sStyleString ;
   private String tblTablemain_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private boolean wcpOAV9GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9GoingBack ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV24WelcomeMessage_NoMostrarMas ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Steptitles ;
   private boolean AV23MenuBienveVisible ;
   private boolean bDynCreated_Wizardstepwc ;
   private boolean GXv_boolean6[] ;
   private boolean AV25WelcomeMessage_Foto_IsBlob ;
   private String AV22MenuBienveTexto ;
   private String AV20textoNoMostrara ;
   private String wcpOAV11PreviousStep ;
   private String wcpOAV6CurrentStep ;
   private String wcpOAV18MenuOpcCod ;
   private String AV11PreviousStep ;
   private String AV6CurrentStep ;
   private String AV18MenuOpcCod ;
   private String AV7CurrentStepAux ;
   private String AV19MenuBienveImgURL ;
   private String AV21MenuBienveTitulo ;
   private String AV29Welcomemessage_foto_GXI ;
   private String AV25WelcomeMessage_Foto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Steptitles ;
   private GXWebComponent WebComp_Wizardstepwc ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV17WizardSteps ;
   private web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV16WizardStep ;
}

