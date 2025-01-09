package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_masterpagetopactionswc_impl extends GXWebComponent
{
   public wwp_masterpagetopactionswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_masterpagetopactionswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_masterpagetopactionswc_impl.class ));
   }

   public wwp_masterpagetopactionswc_impl( int remoteHandle ,
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
         paJP2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "WWP_Master Page Top Actions WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.wwp_masterpagetopactionswc", new String[] {}, new String[] {}) +"\">") ;
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
   }

   public void renderHtmlCloseFormJP2( )
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
      return "WWPBaseObjects.WWP_MasterPageTopActionsWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Master Page Top Actions WC", "") ;
   }

   public void wbJP0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.wwpbaseobjects.wwp_masterpagetopactionswc");
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
         web.GxWebStd.gx_div_start( httpContext, divUserinformation_Internalname, 1, 0, "px", 0, "px", "ddoMenuUserInfo", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "UserImageCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "User Image", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "Attribute" + " " + ((GXutil.strcmp(imgavUserimage_gximage, "")==0) ? "" : "GX_Image_"+imgavUserimage_gximage+"_Class") ;
         StyleString = "" ;
         AV5UserImage_IsBlob = (boolean)(((GXutil.strcmp("", AV5UserImage)==0)&&(GXutil.strcmp("", AV22Userimage_GXI)==0))||!(GXutil.strcmp("", AV5UserImage)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV5UserImage)==0) ? AV22Userimage_GXI : httpContext.getResourceRelative(AV5UserImage)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavUserimage_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV5UserImage_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WWP_MasterPageTopActionsWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "UserInfoNameCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, httpContext.getMessage( "User Name", ""), "gx-form-item UserInfoNameLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV8UserName, GXutil.rtrim( localUtil.format( AV8UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,15);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUsername_Jsonclick, 0, "UserInfoName", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), false, "", "left", true, "", "HLP_WWPBaseObjects\\WWP_MasterPageTopActionsWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "UserInfoRoleCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavRolesdescriptions_Internalname, httpContext.getMessage( "Roles Descriptions", ""), "gx-form-item UserInfoRoleLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavRolesdescriptions_Internalname, AV9RolesDescriptions, GXutil.rtrim( localUtil.format( AV9RolesDescriptions, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,18);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRolesdescriptions_Jsonclick, 0, "UserInfoRole", "", "", "", "", 1, edtavRolesdescriptions_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), false, "", "left", true, "", "HLP_WWPBaseObjects\\WWP_MasterPageTopActionsWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnactionchangepassword.setProperty("BeforeIconClass", Btnactionchangepassword_Beforeiconclass);
         ucBtnactionchangepassword.setProperty("Caption", Btnactionchangepassword_Caption);
         ucBtnactionchangepassword.setProperty("Class", Btnactionchangepassword_Class);
         ucBtnactionchangepassword.render(context, "wwp_iconbutton", Btnactionchangepassword_Internalname, sPrefix+"BTNACTIONCHANGEPASSWORDContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnlogout.setProperty("BeforeIconClass", Btnlogout_Beforeiconclass);
         ucBtnlogout.setProperty("Caption", Btnlogout_Caption);
         ucBtnlogout.setProperty("Class", Btnlogout_Class);
         ucBtnlogout.render(context, "wwp_iconbutton", Btnlogout_Internalname, sPrefix+"BTNLOGOUTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablestyle_Internalname, 1, 0, "px", 0, "px", "userStyle", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Estilo", ""), "", "", lblTextblock1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_MasterPageTopActionsWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Back Style", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_radio_ctrl( httpContext, radavBackstyle, radavBackstyle.getInternalname(), GXutil.rtrim( AV19BackStyle), "", 1, 1, 0, 0, StyleString, ClassString, "", "", 0, radavBackstyle.getJsonclick(), "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "HLP_WWPBaseObjects\\WWP_MasterPageTopActionsWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void startJP2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Master Page Top Actions WC", ""), (short)(0)) ;
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
            strupJP0( ) ;
         }
      }
   }

   public void wsJP2( )
   {
      startJP2( ) ;
      evtJP2( ) ;
   }

   public void evtJP2( )
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
                              strupJP0( ) ;
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
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOACTIONCHANGEPASSWORD'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoActionChangePassword' */
                                 e12JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOLOGOUT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoLogout' */
                                 e13JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e14JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VBACKSTYLE.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e16JP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJP0( ) ;
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
                              strupJP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavUsername_Internalname ;
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

   public void weJP2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormJP2( ) ;
         }
      }
   }

   public void paJP2( )
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
            GX_FocusControl = edtavUsername_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19BackStyle", AV19BackStyle);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJP2( ) ;
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
      edtavUsername_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      edtavRolesdescriptions_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRolesdescriptions_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRolesdescriptions_Enabled), 5, 0), true);
   }

   public void rfJP2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e14JP2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e16JP2 ();
         wbJP0( ) ;
      }
   }

   public void send_integrity_lvl_hashesJP2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavUsername_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      edtavRolesdescriptions_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRolesdescriptions_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRolesdescriptions_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupJP0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11JP2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
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
      e11JP2 ();
      if (returnInSub) return;
   }

   public void e11JP2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      wwp_masterpagetopactionswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXt_char3 = AV16SecUserName ;
      GXv_char4[0] = GXt_char3 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char4) ;
      wwp_masterpagetopactionswc_impl.this.GXt_char3 = GXv_char4[0] ;
      AV16SecUserName = GXt_char3 ;
      GXv_char4[0] = AV17SecUserPerName ;
      GXv_char5[0] = "" ;
      GXv_char6[0] = AV9RolesDescriptions ;
      new web.usergetdatosbyname(remoteHandle, context).execute( AV16SecUserName, GXv_char4, GXv_char5, GXv_char6) ;
      wwp_masterpagetopactionswc_impl.this.AV17SecUserPerName = GXv_char4[0] ;
      wwp_masterpagetopactionswc_impl.this.AV9RolesDescriptions = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9RolesDescriptions", AV9RolesDescriptions);
      AV8UserName = GXutil.trim( AV17SecUserPerName) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8UserName", AV8UserName);
      AV5UserImage = httpContext.convertURL( context.getHttpContext().getImagePath( "3a2bb037-746f-4ca9-85b6-8a9333319398", "", context.getHttpContext().getTheme( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavUserimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV5UserImage)==0) ? AV22Userimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5UserImage))), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavUserimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5UserImage), true);
      imgavUserimage_gximage = "Avatar" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavUserimage_Internalname, "gximage", imgavUserimage_gximage, true);
      GXt_SdtWWP_DesignSystemSettings7 = AV18WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings8[0] = GXt_SdtWWP_DesignSystemSettings7;
      new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings8) ;
      GXt_SdtWWP_DesignSystemSettings7 = GXv_SdtWWP_DesignSystemSettings8[0] ;
      AV18WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings7;
      AV19BackStyle = AV18WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19BackStyle", AV19BackStyle);
   }

   public void e12JP2( )
   {
      /* 'DoActionChangePassword' Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "DropDownComponent_Close", new Object[] {divTablemain_Internalname}, false);
      callWebObject(formatLink("web.wwpbaseobjects.secchangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Cambiar contraseña", "")))}, new String[] {"MenuOpcCod"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e13JP2( )
   {
      /* 'DoLogout' Routine */
      returnInSub = false ;
      AV10WebSession.destroy();
      callWebObject(formatLink("web.login", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"defaultSecUserName","URL"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e14JP2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      wwp_masterpagetopactionswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   public void e15JP2( )
   {
      /* Backstyle_Controlvaluechanged Routine */
      returnInSub = false ;
      GXt_SdtWWP_DesignSystemSettings7 = AV18WWP_DesignSystemSettings;
      GXv_SdtWWP_DesignSystemSettings8[0] = GXt_SdtWWP_DesignSystemSettings7;
      new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings8) ;
      GXt_SdtWWP_DesignSystemSettings7 = GXv_SdtWWP_DesignSystemSettings8[0] ;
      AV18WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings7;
      AV18WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( AV19BackStyle );
      this.executeExternalObjectMethod(sPrefix, false, "gx.core.ds", "setOption", new Object[] {"background-color",AV18WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV18WWP_DesignSystemSettings.toJSonString(false, true)) ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
   }

   protected void nextLoad( )
   {
   }

   protected void e16JP2( )
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
      paJP2( ) ;
      wsJP2( ) ;
      weJP2( ) ;
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
      paJP2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_masterpagetopactionswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paJP2( ) ;
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
      paJP2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsJP2( ) ;
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
      wsJP2( ) ;
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
      weJP2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202045135", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_masterpagetopactionswc.js", "?202412202045136", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgavUserimage_Internalname = sPrefix+"vUSERIMAGE" ;
      edtavUsername_Internalname = sPrefix+"vUSERNAME" ;
      edtavRolesdescriptions_Internalname = sPrefix+"vROLESDESCRIPTIONS" ;
      divUserinformation_Internalname = sPrefix+"USERINFORMATION" ;
      Btnactionchangepassword_Internalname = sPrefix+"BTNACTIONCHANGEPASSWORD" ;
      Btnlogout_Internalname = sPrefix+"BTNLOGOUT" ;
      lblTextblock1_Internalname = sPrefix+"TEXTBLOCK1" ;
      radavBackstyle.setInternalname( sPrefix+"vBACKSTYLE" );
      divTablestyle_Internalname = sPrefix+"TABLESTYLE" ;
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
      radavBackstyle.setJsonclick( "" );
      Btnlogout_Class = "MasterPageTopActionsOption" ;
      Btnlogout_Caption = httpContext.getMessage( "WWP_GAM_Logout", "") ;
      Btnlogout_Beforeiconclass = "fas fa-sign-out-alt FontIconTopRightActions" ;
      Btnactionchangepassword_Class = "MasterPageTopActionsOption" ;
      Btnactionchangepassword_Caption = httpContext.getMessage( "WWP_GAM_ChangePassword", "") ;
      Btnactionchangepassword_Beforeiconclass = "fa fa-lock FontIconTopRightActions" ;
      edtavRolesdescriptions_Jsonclick = "" ;
      edtavRolesdescriptions_Enabled = 1 ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
      imgavUserimage_gximage = "" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'radavBackstyle'},{av:'AV19BackStyle',fld:'vBACKSTYLE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOACTIONCHANGEPASSWORD'","{handler:'e12JP2',iparms:[]");
      setEventMetadata("'DOACTIONCHANGEPASSWORD'",",oparms:[]}");
      setEventMetadata("'DOLOGOUT'","{handler:'e13JP2',iparms:[]");
      setEventMetadata("'DOLOGOUT'",",oparms:[]}");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED","{handler:'e15JP2',iparms:[{av:'radavBackstyle'},{av:'AV19BackStyle',fld:'vBACKSTYLE',pic:''}]");
      setEventMetadata("VBACKSTYLE.CONTROLVALUECHANGED",",oparms:[]}");
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
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV5UserImage = "" ;
      AV22Userimage_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      AV8UserName = "" ;
      AV9RolesDescriptions = "" ;
      ucBtnactionchangepassword = new com.genexus.webpanels.GXUserControl();
      ucBtnlogout = new com.genexus.webpanels.GXUserControl();
      lblTextblock1_Jsonclick = "" ;
      AV19BackStyle = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV16SecUserName = "" ;
      GXt_char3 = "" ;
      AV17SecUserPerName = "" ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_char6 = new String[1] ;
      AV18WWP_DesignSystemSettings = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      GXt_SdtWWP_DesignSystemSettings7 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings8 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavUsername_Enabled = 0 ;
      edtavRolesdescriptions_Enabled = 0 ;
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
   private int edtavUsername_Enabled ;
   private int edtavRolesdescriptions_Enabled ;
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
   private String divUserinformation_Internalname ;
   private String ClassString ;
   private String imgavUserimage_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgavUserimage_Internalname ;
   private String edtavUsername_Internalname ;
   private String TempTags ;
   private String edtavUsername_Jsonclick ;
   private String edtavRolesdescriptions_Internalname ;
   private String edtavRolesdescriptions_Jsonclick ;
   private String Btnactionchangepassword_Beforeiconclass ;
   private String Btnactionchangepassword_Caption ;
   private String Btnactionchangepassword_Class ;
   private String Btnactionchangepassword_Internalname ;
   private String Btnlogout_Beforeiconclass ;
   private String Btnlogout_Caption ;
   private String Btnlogout_Class ;
   private String Btnlogout_Internalname ;
   private String divTablestyle_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV5UserImage_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV22Userimage_GXI ;
   private String AV8UserName ;
   private String AV9RolesDescriptions ;
   private String AV19BackStyle ;
   private String AV16SecUserName ;
   private String AV17SecUserPerName ;
   private String AV5UserImage ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucBtnactionchangepassword ;
   private com.genexus.webpanels.GXUserControl ucBtnlogout ;
   private HTMLChoice radavBackstyle ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings AV18WWP_DesignSystemSettings ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings7 ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings8[] ;
}

