package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptosafipwizard_impl extends GXDataArea
{
   public conceptosafipwizard_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptosafipwizard_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosafipwizard_impl.class ));
   }

   public conceptosafipwizard_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
            AV10PreviousStep = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PreviousStep", AV10PreviousStep);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV11CurrentStep = httpContext.GetPar( "CurrentStep") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11CurrentStep", AV11CurrentStep);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
               AV9GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpage");
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
      pa0E2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0E2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV11CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWIZARDSTEPS", getSecureSignedToken( "", AV13WizardSteps));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vWIZARDSTEPS", AV13WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vWIZARDSTEPS", AV13WizardSteps);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWIZARDSTEPS", getSecureSignedToken( "", AV13WizardSteps));
      web.GxWebStd.gx_hidden_field( httpContext, "vCURRENTSTEPAUX", AV12CurrentStepAux);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPREVIOUSSTEP", AV10PreviousStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCURRENTSTEP", AV11CurrentStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
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
         we0E2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0E2( ) ;
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
      return formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV11CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack))}, new String[] {"PreviousStep","CurrentStep","GoingBack"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptosAfipWizard" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos Afip Wizard", "") ;
   }

   public void wb0E0( )
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablewizardmain_Internalname, 1, 0, "px", 0, "px", "TableWizardMainFullWidth", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WizardVerticalStepTitlesCell", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0008"+"", GXutil.rtrim( WebComp_Steptitles_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0008"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0008"+"");
               }
               WebComp_Steptitles.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WizardVerticalStepsPositionCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWizardstepdescription_Internalname, lblWizardstepdescription_Caption, "", "", lblWizardstepdescription_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WizardStepDescriptionVertical", 0, "", lblWizardstepdescription_Visible, 1, 0, (short)(0), "HLP_ConceptosAfipWizard.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0016"+"", GXutil.rtrim( WebComp_Wizardstepwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0016"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               }
               WebComp_Wizardstepwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgVolver_gximage, "")==0) ? "GX_Image_VolverIcon_Class" : "GX_Image_"+imgVolver_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11248daf-d5b7-49c1-9201-63944b55a495", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgVolver_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "Volver", ""), 0, 0, 0, "px", 0, "px", 0, 0, 7, imgVolver_Jsonclick, "'"+""+"'"+",false,"+"'"+"e110e1_client"+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ConceptosAfipWizard.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0E2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos Afip Wizard", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0E0( ) ;
   }

   public void ws0E2( )
   {
      start0E2( ) ;
      evt0E2( ) ;
   }

   public void evt0E2( )
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
                           e120E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e130E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e140E2 ();
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
                     if ( nCmpId == 8 )
                     {
                        OldSteptitles = httpContext.cgiGet( "W0008") ;
                        if ( ( GXutil.len( OldSteptitles) == 0 ) || ( GXutil.strcmp(OldSteptitles, WebComp_Steptitles_Component) != 0 ) )
                        {
                           WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "web." + OldSteptitles + "_impl", remoteHandle, context);
                           WebComp_Steptitles_Component = OldSteptitles ;
                        }
                        if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
                        {
                           WebComp_Steptitles.componentprocess("W0008", "", sEvt);
                        }
                        WebComp_Steptitles_Component = OldSteptitles ;
                     }
                     else if ( nCmpId == 16 )
                     {
                        OldWizardstepwc = httpContext.cgiGet( "W0016") ;
                        if ( ( GXutil.len( OldWizardstepwc) == 0 ) || ( GXutil.strcmp(OldWizardstepwc, WebComp_Wizardstepwc_Component) != 0 ) )
                        {
                           WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web." + OldWizardstepwc + "_impl", remoteHandle, context);
                           WebComp_Wizardstepwc_Component = OldWizardstepwc ;
                        }
                        if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
                        {
                           WebComp_Wizardstepwc.componentprocess("W0016", "", sEvt);
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

   public void we0E2( )
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

   public void pa0E2( )
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
      rf0E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV27Pgmname = "ConceptosAfipWizard" ;
      Gx_err = (short)(0) ;
   }

   public void rf0E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e130E2 ();
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
         e140E2 ();
         wb0E0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0E2( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vWIZARDSTEPS", AV13WizardSteps);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vWIZARDSTEPS", AV13WizardSteps);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWIZARDSTEPS", getSecureSignedToken( "", AV13WizardSteps));
      web.GxWebStd.gx_hidden_field( httpContext, "vCURRENTSTEPAUX", AV12CurrentStepAux);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
   }

   public void before_start_formulas( )
   {
      AV27Pgmname = "ConceptosAfipWizard" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
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
      e120E2 ();
      if (returnInSub) return;
   }

   public void e120E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( true )
      {
         GXt_int1 = AV16CliCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
         conceptosafipwizard_impl.this.GXt_int1 = GXv_int2[0] ;
         AV16CliCod = GXt_int1 ;
         AV20primerPaso = "" ;
         if ( (GXutil.strcmp("", AV11CurrentStep)==0) )
         {
            AV13WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle) ;
            AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Inicio" );
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Asistente", "") );
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Parametrización de Conceptos", "") );
            AV13WizardSteps.add(AV14WizardStep, 0);
            GXv_objcol_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem3[0] = AV18sdt_conceptos_afip ;
            new web.cargarconceptosafip(remoteHandle, context).execute( AV16CliCod, GXv_objcol_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem3) ;
            AV18sdt_conceptos_afip = GXv_objcol_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem3[0] ;
            AV18sdt_conceptos_afip.sort(httpContext.getMessage( "ConOrden", ""));
            AV25GXV1 = 1 ;
            while ( AV25GXV1 <= AV18sdt_conceptos_afip.size() )
            {
               AV19item = (web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)((web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)AV18sdt_conceptos_afip.elementAt(-1+AV25GXV1));
               if ( (GXutil.strcmp("", AV20primerPaso)==0) )
               {
                  AV20primerPaso = GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio()) ;
               }
               if ( ( AV22proximo ) && (GXutil.strcmp("", AV21proximoPaso)==0) )
               {
                  AV21proximoPaso = GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio()) ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21proximoPaso", AV21proximoPaso);
               }
               if ( ( GXutil.strcmp(GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio()), AV11CurrentStep) == 0 ) || (GXutil.strcmp("", AV11CurrentStep)==0) )
               {
                  AV22proximo = true ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22proximo", AV22proximo);
               }
               AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
               AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio()) );
               AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc()) );
               AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio())+" - "+GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Conafipdesc()) );
               AV13WizardSteps.add(AV14WizardStep, 0);
               AV25GXV1 = (int)(AV25GXV1+1) ;
            }
            if ( (GXutil.strcmp("", AV21proximoPaso)==0) )
            {
               AV21proximoPaso = "Completado" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21proximoPaso", AV21proximoPaso);
            }
            AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Completado" );
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Generar Archivo", "") );
            AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Generar Archivo", "") );
            AV13WizardSteps.add(AV14WizardStep, 0);
            AV12CurrentStepAux = "Inicio" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
            AV21proximoPaso = GXutil.trim( AV20primerPaso) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21proximoPaso", AV21proximoPaso);
            AV26GXV2 = 1 ;
            while ( AV26GXV2 <= AV18sdt_conceptos_afip.size() )
            {
               AV19item = (web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)((web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem)AV18sdt_conceptos_afip.elementAt(-1+AV26GXV2));
               AV7WebSession.remove(AV27Pgmname+"_"+GXutil.trim( AV19item.getgxTv_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem_Concodpropio()));
               AV26GXV2 = (int)(AV26GXV2+1) ;
            }
            AV7WebSession.setValue(httpContext.getMessage( "&WizardSteps", ""), AV13WizardSteps.toJSonString(false));
         }
         else
         {
            AV13WizardSteps.fromJSonString(AV7WebSession.getValue(httpContext.getMessage( "&WizardSteps", "")), null);
            AV28GXV3 = 1 ;
            while ( AV28GXV3 <= AV13WizardSteps.size() )
            {
               AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV13WizardSteps.elementAt(-1+AV28GXV3));
               if ( (GXutil.strcmp("", AV20primerPaso)==0) )
               {
                  AV20primerPaso = AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code() ;
               }
               if ( ( AV22proximo ) && (GXutil.strcmp("", AV21proximoPaso)==0) )
               {
                  AV21proximoPaso = AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21proximoPaso", AV21proximoPaso);
               }
               if ( ( GXutil.strcmp(AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV11CurrentStep) == 0 ) || (GXutil.strcmp("", AV11CurrentStep)==0) )
               {
                  AV22proximo = true ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22proximo", AV22proximo);
               }
               AV28GXV3 = (int)(AV28GXV3+1) ;
            }
            if ( (GXutil.strcmp("", AV21proximoPaso)==0) )
            {
               AV21proximoPaso = "Completado" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21proximoPaso", AV21proximoPaso);
            }
            AV12CurrentStepAux = AV11CurrentStep ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
         }
         /* Execute user subroutine: 'LOADWIZARDSTEPWC' */
         S112 ();
         if (returnInSub) return;
         /* Object Property */
         if ( true )
         {
            bDynCreated_Steptitles = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Steptitles_Component), GXutil.lower( "WWPBaseObjects.WizardConceptosAfipSteps")) != 0 )
         {
            WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "web.wwpbaseobjects.wizardconceptosafipsteps_impl", remoteHandle, context);
            WebComp_Steptitles_Component = "WWPBaseObjects.WizardConceptosAfipSteps" ;
         }
         if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
         {
            WebComp_Steptitles.setjustcreated();
            WebComp_Steptitles.componentprepare(new Object[] {"W0008","",AV13WizardSteps,AV12CurrentStepAux});
            WebComp_Steptitles.componentbind(new Object[] {"",""});
         }
      }
      else
      {
         GXt_int1 = AV16CliCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
         conceptosafipwizard_impl.this.GXt_int1 = GXv_int2[0] ;
         AV16CliCod = GXt_int1 ;
         AV13WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle) ;
         AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Inicio" );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Explicación", "") );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Explicación", "") );
         AV13WizardSteps.add(AV14WizardStep, 0);
         AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Concepto1" );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Concepto 1", "") );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Concepto 1", "") );
         AV13WizardSteps.add(AV14WizardStep, 0);
         AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "paso2Dummy" );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "paso2Dummy", "") );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "paso2Dummy", "") );
         AV13WizardSteps.add(AV14WizardStep, 0);
         AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Completado" );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Generar Archivo", "") );
         AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Generar Archivo", "") );
         AV13WizardSteps.add(AV14WizardStep, 0);
         if ( (GXutil.strcmp("", AV11CurrentStep)==0) )
         {
            AV12CurrentStepAux = "Inicio" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
            AV7WebSession.remove(AV27Pgmname+"_Data");
         }
         else
         {
            AV12CurrentStepAux = AV11CurrentStep ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEPAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12CurrentStepAux, ""))));
         }
         /* Execute user subroutine: 'LOADWIZARDSTEPWC' */
         S112 ();
         if (returnInSub) return;
         /* Object Property */
         if ( true )
         {
            bDynCreated_Steptitles = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Steptitles_Component), GXutil.lower( "WWPBaseObjects.WizardConceptosAfipSteps")) != 0 )
         {
            WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "web.wwpbaseobjects.wizardconceptosafipsteps_impl", remoteHandle, context);
            WebComp_Steptitles_Component = "WWPBaseObjects.WizardConceptosAfipSteps" ;
         }
         if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
         {
            WebComp_Steptitles.setjustcreated();
            WebComp_Steptitles.componentprepare(new Object[] {"W0008","",AV13WizardSteps,AV12CurrentStepAux});
            WebComp_Steptitles.componentbind(new Object[] {"",""});
         }
      }
   }

   public void S112( )
   {
      /* 'LOADWIZARDSTEPWC' Routine */
      returnInSub = false ;
      if ( true )
      {
         AV7WebSession.setValue(httpContext.getMessage( "proximoPaso", ""), GXutil.trim( AV21proximoPaso));
         if ( GXutil.strcmp(AV12CurrentStepAux, "Inicio") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardInicio")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardinicio_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardInicio" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         else if ( GXutil.strcmp(AV12CurrentStepAux, "Completado") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardCompletado")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardcompletado_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardCompletado" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         else
         {
            AV7WebSession.setValue(httpContext.getMessage( "ConCodPropio", ""), GXutil.trim( AV12CurrentStepAux));
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardConcepto1")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardconcepto1_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardConcepto1" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_"+GXutil.trim( AV12CurrentStepAux),AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+""+""+""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
      }
      else
      {
         if ( GXutil.strcmp(AV12CurrentStepAux, "Inicio") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardInicio")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardinicio_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardInicio" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         else if ( GXutil.strcmp(AV12CurrentStepAux, "Concepto1") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardConcepto1")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardconcepto1_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardConcepto1" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         else if ( GXutil.strcmp(AV12CurrentStepAux, "paso2Dummy") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardpaso2Dummy")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardpaso2dummy_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardpaso2Dummy" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         else if ( GXutil.strcmp(AV12CurrentStepAux, "Completado") == 0 )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Wizardstepwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "ConceptosAfipWizardCompletado")) != 0 )
            {
               WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "web.conceptosafipwizardcompletado_impl", remoteHandle, context);
               WebComp_Wizardstepwc_Component = "ConceptosAfipWizardCompletado" ;
            }
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.setjustcreated();
               WebComp_Wizardstepwc.componentprepare(new Object[] {"W0016","",AV27Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
               WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0016"+"");
               WebComp_Wizardstepwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
      }
   }

   public void e130E2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      if ( true )
      {
         GXt_int1 = AV16CliCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
         conceptosafipwizard_impl.this.GXt_int1 = GXv_int2[0] ;
         AV16CliCod = GXt_int1 ;
         lblWizardstepdescription_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Caption", lblWizardstepdescription_Caption, true);
         lblWizardstepdescription_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblWizardstepdescription_Visible), 5, 0), true);
         AV15StepNumber = (byte)(1) ;
         AV29GXV4 = 1 ;
         while ( AV29GXV4 <= AV13WizardSteps.size() )
         {
            AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV13WizardSteps.elementAt(-1+AV29GXV4));
            if ( GXutil.strcmp(AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV12CurrentStepAux) == 0 )
            {
               if ( ! (GXutil.strcmp("", AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Description())==0) )
               {
                  lblWizardstepdescription_Caption = GXutil.trim( AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Description()) ;
                  httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Caption", lblWizardstepdescription_Caption, true);
               }
               if ( ( GXutil.strcmp(AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), httpContext.getMessage( "Inicio", "")) == 0 ) || ( GXutil.strcmp(AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), httpContext.getMessage( "Completado", "")) == 0 ) )
               {
                  lblWizardstepdescription_Visible = 1 ;
                  httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblWizardstepdescription_Visible), 5, 0), true);
               }
            }
            else
            {
               AV15StepNumber = (byte)(AV15StepNumber+1) ;
            }
            AV29GXV4 = (int)(AV29GXV4+1) ;
         }
      }
      else
      {
         GXt_int1 = AV16CliCod ;
         GXv_int2[0] = GXt_int1 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
         conceptosafipwizard_impl.this.GXt_int1 = GXv_int2[0] ;
         AV16CliCod = GXt_int1 ;
         lblWizardstepdescription_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Caption", lblWizardstepdescription_Caption, true);
         AV15StepNumber = (byte)(1) ;
         AV30GXV5 = 1 ;
         while ( AV30GXV5 <= AV13WizardSteps.size() )
         {
            AV14WizardStep = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV13WizardSteps.elementAt(-1+AV30GXV5));
            if ( GXutil.strcmp(AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), AV12CurrentStepAux) == 0 )
            {
               if ( ! (GXutil.strcmp("", AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Description())==0) )
               {
                  lblWizardstepdescription_Caption = GXutil.format( httpContext.getMessage( "Step %1/%2 :: %3", ""), GXutil.trim( GXutil.str( AV15StepNumber, 2, 0)), GXutil.trim( GXutil.str( AV13WizardSteps.size(), 9, 0)), AV14WizardStep.getgxTv_SdtWizardSteps_WizardStepsItem_Description(), "", "", "", "", "", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, lblWizardstepdescription_Internalname, "Caption", lblWizardstepdescription_Caption, true);
               }
            }
            else
            {
               AV15StepNumber = (byte)(AV15StepNumber+1) ;
            }
            AV30GXV5 = (int)(AV30GXV5+1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e140E2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10PreviousStep = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10PreviousStep", AV10PreviousStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      AV11CurrentStep = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11CurrentStep", AV11CurrentStep);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
      AV9GoingBack = ((Boolean) getParm(obj,2)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
      pa0E2( ) ;
      ws0E2( ) ;
      we0E2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019471983", true, true);
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
      httpContext.AddJavascriptSource("conceptosafipwizard.js", "?2024122019471983", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblWizardstepdescription_Internalname = "WIZARDSTEPDESCRIPTION" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      imgVolver_Internalname = "VOLVER" ;
      divTablewizardmain_Internalname = "TABLEWIZARDMAIN" ;
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
      lblWizardstepdescription_Caption = httpContext.getMessage( "Step Description", "") ;
      lblWizardstepdescription_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Conceptos Afip Wizard", "") );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13WizardSteps',fld:'vWIZARDSTEPS',pic:'',hsh:true},{av:'AV12CurrentStepAux',fld:'vCURRENTSTEPAUX',pic:'',hsh:true},{av:'AV10PreviousStep',fld:'vPREVIOUSSTEP',pic:'',hsh:true},{av:'AV11CurrentStep',fld:'vCURRENTSTEP',pic:'',hsh:true},{av:'AV9GoingBack',fld:'vGOINGBACK',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'lblWizardstepdescription_Visible',ctrl:'WIZARDSTEPDESCRIPTION',prop:'Visible'},{av:'lblWizardstepdescription_Caption',ctrl:'WIZARDSTEPDESCRIPTION',prop:'Caption'}]}");
      setEventMetadata("'DOVOLVER'","{handler:'e110E1',iparms:[]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
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
      wcpOAV10PreviousStep = "" ;
      wcpOAV11CurrentStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV10PreviousStep = "" ;
      AV11CurrentStep = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV13WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle);
      AV12CurrentStepAux = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      WebComp_Steptitles_Component = "" ;
      OldSteptitles = "" ;
      lblWizardstepdescription_Jsonclick = "" ;
      WebComp_Wizardstepwc_Component = "" ;
      OldWizardstepwc = "" ;
      TempTags = "" ;
      ClassString = "" ;
      imgVolver_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      imgVolver_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV27Pgmname = "" ;
      AV20primerPaso = "" ;
      AV14WizardStep = new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV18sdt_conceptos_afip = new GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem>(web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem.class, "sdt_conceptos_afipItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem3 = new GXBaseCollection[1] ;
      AV19item = new web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem(remoteHandle, context);
      AV21proximoPaso = "" ;
      AV7WebSession = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      AV27Pgmname = "ConceptosAfipWizard" ;
      /* GeneXus formulas. */
      AV27Pgmname = "ConceptosAfipWizard" ;
      Gx_err = (short)(0) ;
      WebComp_Steptitles = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Wizardstepwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV15StepNumber ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int lblWizardstepdescription_Visible ;
   private int AV16CliCod ;
   private int AV25GXV1 ;
   private int AV26GXV2 ;
   private int AV28GXV3 ;
   private int AV29GXV4 ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV30GXV5 ;
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
   private String divTablewizardmain_Internalname ;
   private String WebComp_Steptitles_Component ;
   private String OldSteptitles ;
   private String divTablecontent_Internalname ;
   private String lblWizardstepdescription_Internalname ;
   private String lblWizardstepdescription_Caption ;
   private String lblWizardstepdescription_Jsonclick ;
   private String WebComp_Wizardstepwc_Component ;
   private String OldWizardstepwc ;
   private String TempTags ;
   private String ClassString ;
   private String imgVolver_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgVolver_Internalname ;
   private String imgVolver_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV27Pgmname ;
   private String AV21proximoPaso ;
   private boolean wcpOAV9GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9GoingBack ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV22proximo ;
   private boolean bDynCreated_Steptitles ;
   private boolean bDynCreated_Wizardstepwc ;
   private String wcpOAV10PreviousStep ;
   private String wcpOAV11CurrentStep ;
   private String AV10PreviousStep ;
   private String AV11CurrentStep ;
   private String AV12CurrentStepAux ;
   private String AV20primerPaso ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Steptitles ;
   private GXWebComponent WebComp_Wizardstepwc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV7WebSession ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV13WizardSteps ;
   private GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem> AV18sdt_conceptos_afip ;
   private GXBaseCollection<web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem> GXv_objcol_Sdtsdt_conceptos_afip_sdt_conceptos_afipItem3[] ;
   private web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV14WizardStep ;
   private web.Sdtsdt_conceptos_afip_sdt_conceptos_afipItem AV19item ;
}

