package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_masterpageruntimesettings_impl extends GXWebComponent
{
   public wwp_masterpageruntimesettings_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_masterpageruntimesettings_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_masterpageruntimesettings_impl.class ));
   }

   public wwp_masterpageruntimesettings_impl( int remoteHandle ,
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
      radavBackstyle = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetNextPar( ) ;
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
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
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
               gxfirstwebparm = httpContext.GetNextPar( ) ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         pa352( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "WWP_Master Page Runtime Settings", "")) ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.wwp_masterpageruntimesettings", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFONTSIZESELECTED", AV11FontSizeSelected);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWP_DESIGNSYSTEMSETTINGS", AV5WWP_DesignSystemSettings);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWP_DESIGNSYSTEMSETTINGS", AV5WWP_DesignSystemSettings);
      }
   }

   public void renderHtmlCloseForm352( )
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
      return "WWPBaseObjects.WWP_MasterPageRuntimeSettings" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Master Page Runtime Settings", "") ;
   }

   public void wb350( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.wwpbaseobjects.wwp_masterpageruntimesettings");
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainDesignerSelector", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblBackstyletxt_Internalname, httpContext.getMessage( "WWP_BackgroundStyle_Dsc", ""), "", "", lblBackstyletxt_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RuntimeDesignSettingsTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavBackstyle.getInternalname()+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_radio_ctrl( httpContext, radavBackstyle, radavBackstyle.getInternalname(), GXutil.rtrim( AV6BackStyle), "", 1, 1, 0, 0, StyleString, ClassString, "", "", 0, radavBackstyle.getJsonclick(), "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,14);\"", "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFontsizetxt_Internalname, httpContext.getMessage( "WWP_FontSize_Dsc", ""), "", "", lblFontsizetxt_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RuntimeDesignSettingsTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:space-around;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFontsizesmall_Internalname, httpContext.getMessage( "A", ""), "", "", lblFontsizesmall_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZESMALL.CLICK."+"'", "", lblFontsizesmall_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFontsizemedium_Internalname, httpContext.getMessage( "A", ""), "", "", lblFontsizemedium_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZEMEDIUM.CLICK."+"'", "", lblFontsizemedium_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divFontsizelargecell_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFontsizelarge_Internalname, httpContext.getMessage( "A", ""), "", "", lblFontsizelarge_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFONTSIZELARGE.CLICK."+"'", "", lblFontsizelarge_Class, 5, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageRuntimeSettings.htm");
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

   public void start352( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Master Page Runtime Settings", ""), (short)(0)) ;
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
            strup350( ) ;
         }
      }
   }

   public void ws352( )
   {
      start352( ) ;
      evt352( ) ;
   }

   public void evt352( )
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
                              strup350( ) ;
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
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e12352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZESMALL.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZEMEDIUM.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "FONTSIZELARGE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VBACKSTYLE.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e16352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e17352 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
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
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup350( ) ;
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

   public void we352( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm352( ) ;
         }
      }
   }

   public void pa352( )
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf352( ) ;
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

   public void rf352( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e12352 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e17352 ();
         wb350( ) ;
      }
   }

   public void send_integrity_lvl_hashes352( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup350( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11352 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV6BackStyle = httpContext.cgiGet( radavBackstyle.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
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
      e11352 ();
      if (returnInSub) return;
   }

   public void e11352( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      wwp_masterpageruntimesettings_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXt_SdtWWP_DesignSystemSettings3 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings4[0] = GXt_SdtWWP_DesignSystemSettings3;
      new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings4) ;
      GXt_SdtWWP_DesignSystemSettings3 = GXv_SdtWWP_DesignSystemSettings4[0] ;
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings3;
      AV6BackStyle = AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6BackStyle", AV6BackStyle);
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S112 ();
      if (returnInSub) return;
   }

   public void e12352( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      wwp_masterpageruntimesettings_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   public void e13352( )
   {
      /* Fontsizesmall_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Small" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e14352( )
   {
      /* Fontsizemedium_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Medium" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e15352( )
   {
      /* Fontsizelarge_Click Routine */
      returnInSub = false ;
      AV11FontSizeSelected = "Large" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      /* Execute user subroutine: 'SELECTFONT' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATESELECTEDFONT' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void e16352( )
   {
      /* Backstyle_Controlvaluechanged Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings3 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings4[0] = GXt_SdtWWP_DesignSystemSettings3;
      new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings4) ;
      GXt_SdtWWP_DesignSystemSettings3 = GXv_SdtWWP_DesignSystemSettings4[0] ;
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings3;
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( AV6BackStyle );
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"background-color",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV5WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5WWP_DesignSystemSettings", AV5WWP_DesignSystemSettings);
   }

   public void S122( )
   {
      /* 'SELECTFONT' Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings3 = AV5WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings4[0] = GXt_SdtWWP_DesignSystemSettings3;
      new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings4) ;
      GXt_SdtWWP_DesignSystemSettings3 = GXv_SdtWWP_DesignSystemSettings4[0] ;
      AV5WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings3;
      AV5WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Fontsize( AV11FontSizeSelected );
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV5WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"font-size",AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize()}, false);
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
   }

   public void S112( )
   {
      /* 'UPDATESELECTEDFONT' Routine */
      returnInSub = false ;
      AV11FontSizeSelected = AV5WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FontSizeSelected", AV11FontSizeSelected);
      lblFontsizesmall_Class = "FontSizeSelectorSmall" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizesmall_Internalname, "Class", lblFontsizesmall_Class, true);
      lblFontsizemedium_Class = "FontSizeSelectorMedium" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizemedium_Internalname, "Class", lblFontsizemedium_Class, true);
      lblFontsizelarge_Class = "FontSizeSelectorLarge" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizelarge_Internalname, "Class", lblFontsizelarge_Class, true);
      if ( GXutil.strcmp(AV11FontSizeSelected, "Small") == 0 )
      {
         lblFontsizesmall_Class = lblFontsizesmall_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizesmall_Internalname, "Class", lblFontsizesmall_Class, true);
      }
      else if ( GXutil.strcmp(AV11FontSizeSelected, "Medium") == 0 )
      {
         lblFontsizemedium_Class = lblFontsizemedium_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizemedium_Internalname, "Class", lblFontsizemedium_Class, true);
      }
      else if ( GXutil.strcmp(AV11FontSizeSelected, "Large") == 0 )
      {
         lblFontsizelarge_Class = lblFontsizelarge_Class+" "+"FontSizeSelectorSelected" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblFontsizelarge_Internalname, "Class", lblFontsizelarge_Class, true);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e17352( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa352( ) ;
      ws352( ) ;
      we352( ) ;
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
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa352( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_masterpageruntimesettings", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa352( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
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
      pa352( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws352( ) ;
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
      ws352( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
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
      we352( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020451271", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_masterpageruntimesettings.js", "?2024122020451271", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblBackstyletxt_Internalname = sPrefix+"BACKSTYLETXT" ;
      radavBackstyle.setInternalname( sPrefix+"vBACKSTYLE" );
      lblFontsizetxt_Internalname = sPrefix+"FONTSIZETXT" ;
      lblFontsizesmall_Internalname = sPrefix+"FONTSIZESMALL" ;
      lblFontsizemedium_Internalname = sPrefix+"FONTSIZEMEDIUM" ;
      lblFontsizelarge_Internalname = sPrefix+"FONTSIZELARGE" ;
      divFontsizelargecell_Internalname = sPrefix+"FONTSIZELARGECELL" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
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
      lblFontsizelarge_Class = "FontSizeSelectorLarge" ;
      lblFontsizemedium_Class = "FontSizeSelectorMedium" ;
      lblFontsizesmall_Class = "FontSizeSelectorSmall" ;
      radavBackstyle.setJsonclick( "" );
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
      radavBackstyle.setName( "vBACKSTYLE" );
      radavBackstyle.setWebtags( "" );
      radavBackstyle.addItem("Light", httpContext.getMessage( "WWP_BackgroundStyle_Light", ""), (short)(0));
      radavBackstyle.addItem("Dark", httpContext.getMessage( "WWP_BackgroundStyle_Dark", ""), (short)(0));
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("FONTSIZESMALL.CLICK","{handler:'e13352',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZESMALL.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FONTSIZEMEDIUM.CLICK","{handler:'e14352',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZEMEDIUM.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("FONTSIZELARGE.CLICK","{handler:'e15352',iparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]");
      setEventMetadata("FONTSIZELARGE.CLICK",",oparms:[{av:'AV11FontSizeSelected',fld:'vFONTSIZESELECTED',pic:''},{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''},{av:'lblFontsizesmall_Class',ctrl:'FONTSIZESMALL',prop:'Class'},{av:'lblFontsizemedium_Class',ctrl:'FONTSIZEMEDIUM',prop:'Class'},{av:'lblFontsizelarge_Class',ctrl:'FONTSIZELARGE',prop:'Class'}]}");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED","{handler:'e16352',iparms:[{av:'radavBackstyle'},{av:'AV6BackStyle',fld:'vBACKSTYLE',pic:''}]");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED",",oparms:[{av:'AV5WWP_DesignSystemSettings',fld:'vWWP_DESIGNSYSTEMSETTINGS',pic:''}]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11FontSizeSelected = "" ;
      AV5WWP_DesignSystemSettings = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GX_FocusControl = "" ;
      lblBackstyletxt_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      AV6BackStyle = "" ;
      lblFontsizetxt_Jsonclick = "" ;
      lblFontsizesmall_Jsonclick = "" ;
      lblFontsizemedium_Jsonclick = "" ;
      lblFontsizelarge_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXv_int2 = new int[1] ;
      GXt_SdtWWP_DesignSystemSettings3 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings4 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
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
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
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
   private String lblBackstyletxt_Internalname ;
   private String lblBackstyletxt_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String lblFontsizetxt_Internalname ;
   private String lblFontsizetxt_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String lblFontsizesmall_Internalname ;
   private String lblFontsizesmall_Jsonclick ;
   private String lblFontsizesmall_Class ;
   private String lblFontsizemedium_Internalname ;
   private String lblFontsizemedium_Jsonclick ;
   private String lblFontsizemedium_Class ;
   private String divFontsizelargecell_Internalname ;
   private String lblFontsizelarge_Internalname ;
   private String lblFontsizelarge_Jsonclick ;
   private String lblFontsizelarge_Class ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV11FontSizeSelected ;
   private String AV6BackStyle ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice radavBackstyle ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings AV5WWP_DesignSystemSettings ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings3 ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings4[] ;
}

