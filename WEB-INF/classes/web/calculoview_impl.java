package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class calculoview_impl extends GXDataArea
{
   public calculoview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public calculoview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculoview_impl.class ));
   }

   public calculoview_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
            AV10PaiCod = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PaiCod), "ZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV11idOperando = httpContext.GetPar( "idOperando") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11idOperando", AV11idOperando);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11idOperando, ""))));
               AV8TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa9O2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9O2( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV11idOperando)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"PaiCod","idOperando","TabCode"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23Opecodformula, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11idOperando, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV10PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "IDOPERANDO", GXutil.rtrim( A74idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "vIDOPERANDO", GXutil.rtrim( AV11idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11idOperando, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV12LoadAllTabs);
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV13SelectedTabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECODFORMULA", GXutil.rtrim( AV23Opecodformula));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23Opecodformula, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV8TabCode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Class", GXutil.rtrim( Tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      web.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         WebComp_Generalwc.componentjscripts();
      }
      if ( ! ( WebComp_Calculo_parametroswc == null ) )
      {
         WebComp_Calculo_parametroswc.componentjscripts();
      }
      if ( ! ( WebComp_Operandoseusaenwc == null ) )
      {
         WebComp_Operandoseusaenwc.componentjscripts();
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
         we9O2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9O2( ) ;
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
      return formatLink("web.calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV11idOperando)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"PaiCod","idOperando","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "CalculoView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Calculo View", "") ;
   }

   public void wb9O0( )
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_9_9O2( true) ;
      }
      else
      {
         wb_table1_9_9O2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_9O2e( boolean wbgen )
   {
      if ( wbgen )
      {
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

   public void start9O2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Calculo View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9O0( ) ;
   }

   public void ws9O2( )
   {
      start9O2( ) ;
      evt9O2( ) ;
   }

   public void evt9O2( )
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
                        else if ( GXutil.strcmp(sEvt, "TABS.TABCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e119O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e129O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e139O2 ();
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
                     if ( nCmpId == 23 )
                     {
                        OldGeneralwc = httpContext.cgiGet( "W0023") ;
                        if ( ( GXutil.len( OldGeneralwc) == 0 ) || ( GXutil.strcmp(OldGeneralwc, WebComp_Generalwc_Component) != 0 ) )
                        {
                           WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web." + OldGeneralwc + "_impl", remoteHandle, context);
                           WebComp_Generalwc_Component = OldGeneralwc ;
                        }
                        if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
                        {
                           WebComp_Generalwc.componentprocess("W0023", "", sEvt);
                        }
                        WebComp_Generalwc_Component = OldGeneralwc ;
                     }
                     else if ( nCmpId == 31 )
                     {
                        OldCalculo_parametroswc = httpContext.cgiGet( "W0031") ;
                        if ( ( GXutil.len( OldCalculo_parametroswc) == 0 ) || ( GXutil.strcmp(OldCalculo_parametroswc, WebComp_Calculo_parametroswc_Component) != 0 ) )
                        {
                           WebComp_Calculo_parametroswc = WebUtils.getWebComponent(getClass(), "web." + OldCalculo_parametroswc + "_impl", remoteHandle, context);
                           WebComp_Calculo_parametroswc_Component = OldCalculo_parametroswc ;
                        }
                        if ( GXutil.len( WebComp_Calculo_parametroswc_Component) != 0 )
                        {
                           WebComp_Calculo_parametroswc.componentprocess("W0031", "", sEvt);
                        }
                        WebComp_Calculo_parametroswc_Component = OldCalculo_parametroswc ;
                     }
                     else if ( nCmpId == 39 )
                     {
                        OldOperandoseusaenwc = httpContext.cgiGet( "W0039") ;
                        if ( ( GXutil.len( OldOperandoseusaenwc) == 0 ) || ( GXutil.strcmp(OldOperandoseusaenwc, WebComp_Operandoseusaenwc_Component) != 0 ) )
                        {
                           WebComp_Operandoseusaenwc = WebUtils.getWebComponent(getClass(), "web." + OldOperandoseusaenwc + "_impl", remoteHandle, context);
                           WebComp_Operandoseusaenwc_Component = OldOperandoseusaenwc ;
                        }
                        if ( GXutil.len( WebComp_Operandoseusaenwc_Component) != 0 )
                        {
                           WebComp_Operandoseusaenwc.componentprocess("W0039", "", sEvt);
                        }
                        WebComp_Operandoseusaenwc_Component = OldOperandoseusaenwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we9O2( )
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

   public void pa9O2( )
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
      rf9O2( ) ;
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

   public void rf9O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Calculo_parametroswc_Component) != 0 )
            {
               WebComp_Calculo_parametroswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Operandoseusaenwc_Component) != 0 )
            {
               WebComp_Operandoseusaenwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e139O2 ();
         wb9O0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9O2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECODFORMULA", GXutil.rtrim( AV23Opecodformula));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23Opecodformula, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e129O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
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
      e129O2 ();
      if (returnInSub) return;
   }

   public void e129O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", httpContext.getMessage( "DSP", ""), "") ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      AV21GXLvl11 = (byte)(0) ;
      /* Using cursor H009O2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), AV11idOperando, Short.valueOf(AV10PaiCod), AV11idOperando});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A74idOperando = H009O2_A74idOperando[0] ;
         A46PaiCod = H009O2_A46PaiCod[0] ;
         A473OpeCodFormula = H009O2_A473OpeCodFormula[0] ;
         AV21GXLvl11 = (byte)(1) ;
         Form.setCaption( A473OpeCodFormula );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl11 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV13SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SelectedTabCode", AV13SelectedTabCode);
         Tabs_Activepagecontrolname = AV13SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e139O2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void e119O2( )
   {
      /* Tabs_Tabchanged Routine */
      returnInSub = false ;
      AV13SelectedTabCode = Tabs_Activepagecontrolname ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13SelectedTabCode", AV13SelectedTabCode);
      AV12LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12LoadAllTabs", AV12LoadAllTabs);
      /* Execute user subroutine: 'LOADTABS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      /* Using cursor H009O3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV10PaiCod), AV11idOperando, Short.valueOf(AV10PaiCod), AV11idOperando});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A74idOperando = H009O3_A74idOperando[0] ;
         A46PaiCod = H009O3_A46PaiCod[0] ;
         if ( AV12LoadAllTabs || ( GXutil.strcmp(AV13SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV13SelectedTabCode, "General") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Generalwc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "OperandoGeneral")) != 0 )
            {
               WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "web.operandogeneral_impl", remoteHandle, context);
               WebComp_Generalwc_Component = "OperandoGeneral" ;
            }
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.setjustcreated();
               WebComp_Generalwc.componentprepare(new Object[] {"W0023","",Short.valueOf(AV10PaiCod),AV11idOperando});
               WebComp_Generalwc.componentbind(new Object[] {"",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
               WebComp_Generalwc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         if ( AV12LoadAllTabs || ( GXutil.strcmp(AV13SelectedTabCode, "Calculo_parametros") == 0 ) )
         {
            /* Object Property */
            if ( true )
            {
               bDynCreated_Calculo_parametroswc = true ;
            }
            if ( GXutil.strcmp(GXutil.lower( WebComp_Calculo_parametroswc_Component), GXutil.lower( "Calculo_parametrosTab")) != 0 )
            {
               WebComp_Calculo_parametroswc = WebUtils.getWebComponent(getClass(), "web.calculo_parametrostab_impl", remoteHandle, context);
               WebComp_Calculo_parametroswc_Component = "Calculo_parametrosTab" ;
            }
            if ( GXutil.len( WebComp_Calculo_parametroswc_Component) != 0 )
            {
               WebComp_Calculo_parametroswc.setjustcreated();
               WebComp_Calculo_parametroswc.componentprepare(new Object[] {"W0031","",Short.valueOf(AV10PaiCod),AV11idOperando});
               WebComp_Calculo_parametroswc.componentbind(new Object[] {"",""});
            }
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Calculo_parametroswc )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
               WebComp_Calculo_parametroswc.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
         }
         GXt_boolean2 = AV14TempBoolean ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "OperandoSeUsaEn", GXv_boolean3) ;
         calculoview_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV14TempBoolean = GXt_boolean2 ;
         if ( AV14TempBoolean )
         {
            if ( AV12LoadAllTabs || ( GXutil.strcmp(AV13SelectedTabCode, "OperandoSeUsaEn") == 0 ) )
            {
               /* Object Property */
               if ( true )
               {
                  bDynCreated_Operandoseusaenwc = true ;
               }
               if ( GXutil.strcmp(GXutil.lower( WebComp_Operandoseusaenwc_Component), GXutil.lower( "OperandoSeUsaEn")) != 0 )
               {
                  WebComp_Operandoseusaenwc = WebUtils.getWebComponent(getClass(), "web.operandoseusaen_impl", remoteHandle, context);
                  WebComp_Operandoseusaenwc_Component = "OperandoSeUsaEn" ;
               }
               if ( GXutil.len( WebComp_Operandoseusaenwc_Component) != 0 )
               {
                  WebComp_Operandoseusaenwc.setjustcreated();
                  WebComp_Operandoseusaenwc.componentprepare(new Object[] {"W0039","",AV23Opecodformula});
                  WebComp_Operandoseusaenwc.componentbind(new Object[] {""});
               }
               if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Operandoseusaenwc )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
                  WebComp_Operandoseusaenwc.componentdraw();
                  httpContext.ajax_rspEndCmp();
               }
            }
         }
         else
         {
            this.executeUsercontrolMethod("", false, "TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   public void wb_table1_9_9O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellViewTabsPosition'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableviewcontainer_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTab", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabs.setProperty("PageCount", Tabs_Pagecount);
         ucTabs.setProperty("Class", Tabs_Class);
         ucTabs.setProperty("HistoryManagement", Tabs_Historymanagement);
         ucTabs.render(context, "tab", Tabs_Internalname, "TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablegeneral_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0023"+"", GXutil.rtrim( WebComp_Generalwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0023"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0023"+"");
               }
               WebComp_Generalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCalculo_parametros_title_Internalname, httpContext.getMessage( "Parámetros", ""), "", "", lblCalculo_parametros_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Calculo_parametros") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablecalculo_parametros_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0031"+"", GXutil.rtrim( WebComp_Calculo_parametroswc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0031"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Calculo_parametroswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldCalculo_parametroswc), GXutil.lower( WebComp_Calculo_parametroswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
               }
               WebComp_Calculo_parametroswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldCalculo_parametroswc), GXutil.lower( WebComp_Calculo_parametroswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblOperandoseusaen_title_Internalname, httpContext.getMessage( "Se usa en", ""), "", "", lblOperandoseusaen_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_CalculoView.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "OperandoSeUsaEn") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableoperandoseusaen_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0039"+"", GXutil.rtrim( WebComp_Operandoseusaenwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0039"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Operandoseusaenwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldOperandoseusaenwc), GXutil.lower( WebComp_Operandoseusaenwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
               }
               WebComp_Operandoseusaenwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldOperandoseusaenwc), GXutil.lower( WebComp_Operandoseusaenwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_9O2e( true) ;
      }
      else
      {
         wb_table1_9_9O2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10PaiCod), "ZZZ9")));
      AV11idOperando = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11idOperando", AV11idOperando);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11idOperando, ""))));
      AV8TabCode = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa9O2( ) ;
      ws9O2( ) ;
      we9O2( ) ;
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Calculo_parametroswc == null ) )
      {
         if ( GXutil.len( WebComp_Calculo_parametroswc_Component) != 0 )
         {
            WebComp_Calculo_parametroswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Operandoseusaenwc == null ) )
      {
         if ( GXutil.len( WebComp_Operandoseusaenwc_Component) != 0 )
         {
            WebComp_Operandoseusaenwc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201942412", true, true);
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
      httpContext.AddJavascriptSource("calculoview.js", "?202412201942412", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      divUnnamedtablegeneral_Internalname = "UNNAMEDTABLEGENERAL" ;
      lblCalculo_parametros_title_Internalname = "CALCULO_PARAMETROS_TITLE" ;
      divUnnamedtablecalculo_parametros_Internalname = "UNNAMEDTABLECALCULO_PARAMETROS" ;
      lblOperandoseusaen_title_Internalname = "OPERANDOSEUSAEN_TITLE" ;
      divUnnamedtableoperandoseusaen_Internalname = "UNNAMEDTABLEOPERANDOSEUSAEN" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 3 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Calculo View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV11idOperando',fld:'vIDOPERANDO',pic:'',hsh:true},{av:'AV23Opecodformula',fld:'vOPECODFORMULA',pic:'',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("TABS.TABCHANGED","{handler:'e119O2',iparms:[{av:'Tabs_Activepagecontrolname',ctrl:'TABS',prop:'ActivePageControlName'},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV10PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'AV11idOperando',fld:'vIDOPERANDO',pic:'',hsh:true},{av:'AV12LoadAllTabs',fld:'vLOADALLTABS',pic:''},{av:'AV13SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV23Opecodformula',fld:'vOPECODFORMULA',pic:'',hsh:true}]");
      setEventMetadata("TABS.TABCHANGED",",oparms:[{av:'AV13SelectedTabCode',fld:'vSELECTEDTABCODE',pic:''},{av:'AV12LoadAllTabs',fld:'vLOADALLTABS',pic:''},{ctrl:'GENERALWC'},{ctrl:'CALCULO_PARAMETROSWC'},{ctrl:'OPERANDOSEUSAENWC'}]}");
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
      wcpOAV11idOperando = "" ;
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV11idOperando = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV23Opecodformula = "" ;
      GXKey = "" ;
      A74idOperando = "" ;
      AV13SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldGeneralwc = "" ;
      WebComp_Generalwc_Component = "" ;
      OldCalculo_parametroswc = "" ;
      WebComp_Calculo_parametroswc_Component = "" ;
      OldOperandoseusaenwc = "" ;
      WebComp_Operandoseusaenwc_Component = "" ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H009O2_A74idOperando = new String[] {""} ;
      H009O2_A46PaiCod = new short[1] ;
      H009O2_A473OpeCodFormula = new String[] {""} ;
      A473OpeCodFormula = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      H009O3_A74idOperando = new String[] {""} ;
      H009O3_A46PaiCod = new short[1] ;
      GXv_boolean3 = new boolean[1] ;
      sStyleString = "" ;
      lblGeneral_title_Jsonclick = "" ;
      lblCalculo_parametros_title_Jsonclick = "" ;
      lblOperandoseusaen_title_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculoview__default(),
         new Object[] {
             new Object[] {
            H009O2_A74idOperando, H009O2_A46PaiCod, H009O2_A473OpeCodFormula
            }
            , new Object[] {
            H009O3_A74idOperando, H009O3_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Calculo_parametroswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Operandoseusaenwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV21GXLvl11 ;
   private byte nGXWrapped ;
   private short wcpOAV10PaiCod ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV10PaiCod ;
   private short A46PaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Tabs_Pagecount ;
   private int idxLst ;
   private String wcpOAV11idOperando ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV11idOperando ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV23Opecodformula ;
   private String GXKey ;
   private String A74idOperando ;
   private String AV13SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldGeneralwc ;
   private String WebComp_Generalwc_Component ;
   private String OldCalculo_parametroswc ;
   private String WebComp_Calculo_parametroswc_Component ;
   private String OldOperandoseusaenwc ;
   private String WebComp_Operandoseusaenwc_Component ;
   private String scmdbuf ;
   private String A473OpeCodFormula ;
   private String Tabs_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private String lblCalculo_parametros_title_Internalname ;
   private String lblCalculo_parametros_title_Jsonclick ;
   private String divUnnamedtablecalculo_parametros_Internalname ;
   private String lblOperandoseusaen_title_Internalname ;
   private String lblOperandoseusaen_title_Jsonclick ;
   private String divUnnamedtableoperandoseusaen_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean bDynCreated_Calculo_parametroswc ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean bDynCreated_Operandoseusaenwc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_Calculo_parametroswc ;
   private GXWebComponent WebComp_Operandoseusaenwc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private String[] H009O2_A74idOperando ;
   private short[] H009O2_A46PaiCod ;
   private String[] H009O2_A473OpeCodFormula ;
   private String[] H009O3_A74idOperando ;
   private short[] H009O3_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class calculoview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009O2", "SELECT idOperando, PaiCod, OpeCodFormula FROM calculo WHERE (PaiCod = ? and idOperando = ( ?)) AND (PaiCod = ? and idOperando = ( ?)) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H009O3", "SELECT idOperando, PaiCod FROM calculo WHERE (PaiCod = ? and idOperando = ( ?)) AND (PaiCod = ? and idOperando = ( ?)) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}
