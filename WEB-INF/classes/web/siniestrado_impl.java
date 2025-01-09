package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class siniestrado_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"SINIEDESCRISINAC") == 0 )
      {
         A333SinieDescri = httpContext.GetPar( "SinieDescri") ;
         httpContext.ajax_rsp_assign_attri("", false, "A333SinieDescri", A333SinieDescri);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asasiniedescrisinac1C45( A333SinieDescri) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7SinieCodigo = httpContext.GetPar( "SinieCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SinieCodigo", AV7SinieCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSINIECODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SinieCodigo, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Siniestrado", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSinieCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public siniestrado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public siniestrado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siniestrado_impl.class ));
   }

   public siniestrado_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Siniestrado", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Siniestrado.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinieCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinieCodigo_Internalname, httpContext.getMessage( "Siniestrado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSinieCodigo_Internalname, GXutil.rtrim( A19SinieCodigo), GXutil.rtrim( localUtil.format( A19SinieCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSinieCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSinieCodigo_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Siniestrado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinieDescri_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinieDescri_Internalname, httpContext.getMessage( "Siniestrado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtSinieDescri_Internalname, A333SinieDescri, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", (short)(0), 1, edtSinieDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Siniestrado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Siniestrado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Siniestrado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Siniestrado.htm");
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

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z19SinieCodigo = httpContext.cgiGet( "Z19SinieCodigo") ;
            Z688SinieDescriSinAc = httpContext.cgiGet( "Z688SinieDescriSinAc") ;
            Z333SinieDescri = httpContext.cgiGet( "Z333SinieDescri") ;
            Z1514SinieEsIncap = GXutil.strtobool( httpContext.cgiGet( "Z1514SinieEsIncap")) ;
            n1514SinieEsIncap = ((false==A1514SinieEsIncap) ? true : false) ;
            A688SinieDescriSinAc = httpContext.cgiGet( "Z688SinieDescriSinAc") ;
            A1514SinieEsIncap = GXutil.strtobool( httpContext.cgiGet( "Z1514SinieEsIncap")) ;
            n1514SinieEsIncap = false ;
            n1514SinieEsIncap = ((false==A1514SinieEsIncap) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A688SinieDescriSinAc = httpContext.cgiGet( "SINIEDESCRISINAC") ;
            AV7SinieCodigo = httpContext.cgiGet( "vSINIECODIGO") ;
            A1514SinieEsIncap = GXutil.strtobool( httpContext.cgiGet( "SINIEESINCAP")) ;
            n1514SinieEsIncap = ((false==A1514SinieEsIncap) ? true : false) ;
            AV18Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A19SinieCodigo = httpContext.cgiGet( edtSinieCodigo_Internalname) ;
            n19SinieCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
            A333SinieDescri = httpContext.cgiGet( edtSinieDescri_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A333SinieDescri", A333SinieDescri);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Siniestrado");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SinieEsIncap", GXutil.booltostr( A1514SinieEsIncap));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A19SinieCodigo, Z19SinieCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("siniestrado:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A19SinieCodigo = httpContext.GetPar( "SinieCodigo") ;
               n19SinieCodigo = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode45 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode45 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound45 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1C0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SINIECODIGO");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSinieCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e111C2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121C2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e121C2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1C45( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1C45( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_1C0( )
   {
      beforeValidate1C45( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1C45( ) ;
         }
         else
         {
            checkExtendedTable1C45( ) ;
            closeExtendedTableCursors1C45( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1C0( )
   {
   }

   public void e111C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSiniestrado_Insert", GXv_boolean3) ;
         siniestrado_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSiniestrado_Update", GXv_boolean3) ;
         siniestrado_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSiniestrado_Delete", GXv_boolean3) ;
         siniestrado_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e121C2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1C45( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z688SinieDescriSinAc = T001C3_A688SinieDescriSinAc[0] ;
            Z333SinieDescri = T001C3_A333SinieDescri[0] ;
            Z1514SinieEsIncap = T001C3_A1514SinieEsIncap[0] ;
         }
         else
         {
            Z688SinieDescriSinAc = A688SinieDescriSinAc ;
            Z333SinieDescri = A333SinieDescri ;
            Z1514SinieEsIncap = A1514SinieEsIncap ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z688SinieDescriSinAc = A688SinieDescriSinAc ;
         Z19SinieCodigo = A19SinieCodigo ;
         Z333SinieDescri = A333SinieDescri ;
         Z1514SinieEsIncap = A1514SinieEsIncap ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7SinieCodigo)==0) )
      {
         A19SinieCodigo = AV7SinieCodigo ;
         n19SinieCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
      }
      if ( ! (GXutil.strcmp("", AV7SinieCodigo)==0) )
      {
         edtSinieCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinieCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinieCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSinieCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinieCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinieCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SinieCodigo)==0) )
      {
         edtSinieCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinieCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinieCodigo_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV18Pgmname = "Siniestrado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      }
   }

   public void load1C45( )
   {
      /* Using cursor T001C4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A688SinieDescriSinAc = T001C4_A688SinieDescriSinAc[0] ;
         A333SinieDescri = T001C4_A333SinieDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A333SinieDescri", A333SinieDescri);
         A1514SinieEsIncap = T001C4_A1514SinieEsIncap[0] ;
         n1514SinieEsIncap = T001C4_n1514SinieEsIncap[0] ;
         zm1C45( -5) ;
      }
      pr_default.close(2);
      onLoadActions1C45( ) ;
   }

   public void onLoadActions1C45( )
   {
      AV18Pgmname = "Siniestrado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      GXt_char4 = A688SinieDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char5) ;
      siniestrado_impl.this.GXt_char4 = GXv_char5[0] ;
      A688SinieDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
   }

   public void checkExtendedTable1C45( )
   {
      nIsDirty_45 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV18Pgmname = "Siniestrado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      nIsDirty_45 = (short)(1) ;
      GXt_char4 = A688SinieDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char5) ;
      siniestrado_impl.this.GXt_char4 = GXv_char5[0] ;
      A688SinieDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
   }

   public void closeExtendedTableCursors1C45( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1C45( )
   {
      /* Using cursor T001C5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound45 = (short)(1) ;
      }
      else
      {
         RcdFound45 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001C3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1C45( 5) ;
         RcdFound45 = (short)(1) ;
         A688SinieDescriSinAc = T001C3_A688SinieDescriSinAc[0] ;
         A19SinieCodigo = T001C3_A19SinieCodigo[0] ;
         n19SinieCodigo = T001C3_n19SinieCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
         A333SinieDescri = T001C3_A333SinieDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A333SinieDescri", A333SinieDescri);
         A1514SinieEsIncap = T001C3_A1514SinieEsIncap[0] ;
         n1514SinieEsIncap = T001C3_n1514SinieEsIncap[0] ;
         Z19SinieCodigo = A19SinieCodigo ;
         sMode45 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1C45( ) ;
         if ( AnyError == 1 )
         {
            RcdFound45 = (short)(0) ;
            initializeNonKey1C45( ) ;
         }
         Gx_mode = sMode45 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound45 = (short)(0) ;
         initializeNonKey1C45( ) ;
         sMode45 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode45 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1C45( ) ;
      if ( RcdFound45 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound45 = (short)(0) ;
      /* Using cursor T001C6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001C6_A19SinieCodigo[0], A19SinieCodigo) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001C6_A19SinieCodigo[0], A19SinieCodigo) > 0 ) ) )
         {
            A19SinieCodigo = T001C6_A19SinieCodigo[0] ;
            n19SinieCodigo = T001C6_n19SinieCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
            RcdFound45 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound45 = (short)(0) ;
      /* Using cursor T001C7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001C7_A19SinieCodigo[0], A19SinieCodigo) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001C7_A19SinieCodigo[0], A19SinieCodigo) < 0 ) ) )
         {
            A19SinieCodigo = T001C7_A19SinieCodigo[0] ;
            n19SinieCodigo = T001C7_n19SinieCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
            RcdFound45 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1C45( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSinieCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1C45( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound45 == 1 )
         {
            if ( GXutil.strcmp(A19SinieCodigo, Z19SinieCodigo) != 0 )
            {
               A19SinieCodigo = Z19SinieCodigo ;
               n19SinieCodigo = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SINIECODIGO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSinieCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSinieCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1C45( ) ;
               GX_FocusControl = edtSinieCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A19SinieCodigo, Z19SinieCodigo) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtSinieCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1C45( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SINIECODIGO");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSinieCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSinieCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1C45( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( GXutil.strcmp(A19SinieCodigo, Z19SinieCodigo) != 0 )
      {
         A19SinieCodigo = Z19SinieCodigo ;
         n19SinieCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SINIECODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSinieCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSinieCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1C45( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001C2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Siniestrado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z688SinieDescriSinAc, T001C2_A688SinieDescriSinAc[0]) != 0 ) || ( GXutil.strcmp(Z333SinieDescri, T001C2_A333SinieDescri[0]) != 0 ) || ( Z1514SinieEsIncap != T001C2_A1514SinieEsIncap[0] ) )
         {
            if ( GXutil.strcmp(Z688SinieDescriSinAc, T001C2_A688SinieDescriSinAc[0]) != 0 )
            {
               GXutil.writeLogln("siniestrado:[seudo value changed for attri]"+"SinieDescriSinAc");
               GXutil.writeLogRaw("Old: ",Z688SinieDescriSinAc);
               GXutil.writeLogRaw("Current: ",T001C2_A688SinieDescriSinAc[0]);
            }
            if ( GXutil.strcmp(Z333SinieDescri, T001C2_A333SinieDescri[0]) != 0 )
            {
               GXutil.writeLogln("siniestrado:[seudo value changed for attri]"+"SinieDescri");
               GXutil.writeLogRaw("Old: ",Z333SinieDescri);
               GXutil.writeLogRaw("Current: ",T001C2_A333SinieDescri[0]);
            }
            if ( Z1514SinieEsIncap != T001C2_A1514SinieEsIncap[0] )
            {
               GXutil.writeLogln("siniestrado:[seudo value changed for attri]"+"SinieEsIncap");
               GXutil.writeLogRaw("Old: ",Z1514SinieEsIncap);
               GXutil.writeLogRaw("Current: ",T001C2_A1514SinieEsIncap[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Siniestrado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1C45( )
   {
      beforeValidate1C45( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1C45( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1C45( 0) ;
         checkOptimisticConcurrency1C45( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1C45( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1C45( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001C8 */
                  pr_default.execute(6, new Object[] {A688SinieDescriSinAc, Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, A333SinieDescri, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
                  if ( (pr_default.getStatus(6) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1C0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load1C45( ) ;
         }
         endLevel1C45( ) ;
      }
      closeExtendedTableCursors1C45( ) ;
   }

   public void update1C45( )
   {
      beforeValidate1C45( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1C45( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1C45( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1C45( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1C45( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001C9 */
                  pr_default.execute(7, new Object[] {A688SinieDescriSinAc, A333SinieDescri, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Siniestrado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1C45( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel1C45( ) ;
      }
      closeExtendedTableCursors1C45( ) ;
   }

   public void deferredUpdate1C45( )
   {
   }

   public void delete( )
   {
      beforeValidate1C45( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1C45( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1C45( ) ;
         afterConfirm1C45( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1C45( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001C10 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode45 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1C45( ) ;
      Gx_mode = sMode45 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1C45( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV18Pgmname = "Siniestrado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001C11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Estado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor T001C12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel1C45( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1C45( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "siniestrado");
         if ( AnyError == 0 )
         {
            confirmValues1C0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "siniestrado");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1C45( )
   {
      /* Scan By routine */
      /* Using cursor T001C13 */
      pr_default.execute(11);
      RcdFound45 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A19SinieCodigo = T001C13_A19SinieCodigo[0] ;
         n19SinieCodigo = T001C13_n19SinieCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1C45( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound45 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A19SinieCodigo = T001C13_A19SinieCodigo[0] ;
         n19SinieCodigo = T001C13_n19SinieCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
      }
   }

   public void scanEnd1C45( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1C45( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1C45( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1C45( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1C45( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1C45( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1C45( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1C45( )
   {
      edtSinieCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinieCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinieCodigo_Enabled), 5, 0), true);
      edtSinieDescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinieDescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinieDescri_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1C45( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1C0( )
   {
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
      MasterPageObj.master_styles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.siniestrado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7SinieCodigo))}, new String[] {"Gx_mode","SinieCodigo"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Siniestrado");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SinieEsIncap", GXutil.booltostr( A1514SinieEsIncap));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("siniestrado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z19SinieCodigo", GXutil.rtrim( Z19SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z688SinieDescriSinAc", Z688SinieDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z333SinieDescri", Z333SinieDescri);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1514SinieEsIncap", Z1514SinieEsIncap);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "SINIEDESCRISINAC", A688SinieDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vSINIECODIGO", GXutil.rtrim( AV7SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSINIECODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SinieCodigo, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SINIEESINCAP", A1514SinieEsIncap);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV18Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.siniestrado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7SinieCodigo))}, new String[] {"Gx_mode","SinieCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Siniestrado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Siniestrado", "") ;
   }

   public void initializeNonKey1C45( )
   {
      A688SinieDescriSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
      A333SinieDescri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A333SinieDescri", A333SinieDescri);
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1514SinieEsIncap", A1514SinieEsIncap);
      Z688SinieDescriSinAc = "" ;
      Z333SinieDescri = "" ;
      Z1514SinieEsIncap = false ;
   }

   public void initAll1C45( )
   {
      A19SinieCodigo = "" ;
      n19SinieCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A19SinieCodigo", A19SinieCodigo);
      initializeNonKey1C45( ) ;
   }

   public void standaloneModalInsert( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713584154", true, true);
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
      httpContext.AddJavascriptSource("siniestrado.js", "?20251713584154", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtSinieCodigo_Internalname = "SINIECODIGO" ;
      edtSinieDescri_Internalname = "SINIEDESCRI" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Siniestrado", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtSinieDescri_Enabled = 1 ;
      edtSinieCodigo_Jsonclick = "" ;
      edtSinieCodigo_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx1asasiniedescrisinac1C45( String A333SinieDescri )
   {
      GXt_char4 = A688SinieDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char5) ;
      siniestrado_impl.this.GXt_char4 = GXv_char5[0] ;
      A688SinieDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A688SinieDescriSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Siniedescri( )
   {
      GXt_char4 = A688SinieDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char5) ;
      siniestrado_impl.this.GXt_char4 = GXv_char5[0] ;
      A688SinieDescriSinAc = GXt_char4 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SinieCodigo',fld:'vSINIECODIGO',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SinieCodigo',fld:'vSINIECODIGO',pic:'',hsh:true},{av:'A1514SinieEsIncap',fld:'SINIEESINCAP',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e121C2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SINIECODIGO","{handler:'valid_Siniecodigo',iparms:[]");
      setEventMetadata("VALID_SINIECODIGO",",oparms:[]}");
      setEventMetadata("VALID_SINIEDESCRI","{handler:'valid_Siniedescri',iparms:[{av:'A333SinieDescri',fld:'SINIEDESCRI',pic:''},{av:'A688SinieDescriSinAc',fld:'SINIEDESCRISINAC',pic:''}]");
      setEventMetadata("VALID_SINIEDESCRI",",oparms:[{av:'A688SinieDescriSinAc',fld:'SINIEDESCRISINAC',pic:''}]}");
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
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7SinieCodigo = "" ;
      Z19SinieCodigo = "" ;
      Z688SinieDescriSinAc = "" ;
      Z333SinieDescri = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A333SinieDescri = "" ;
      Gx_mode = "" ;
      AV7SinieCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A19SinieCodigo = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A688SinieDescriSinAc = "" ;
      AV18Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode45 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      T001C4_A688SinieDescriSinAc = new String[] {""} ;
      T001C4_A19SinieCodigo = new String[] {""} ;
      T001C4_n19SinieCodigo = new boolean[] {false} ;
      T001C4_A333SinieDescri = new String[] {""} ;
      T001C4_A1514SinieEsIncap = new boolean[] {false} ;
      T001C4_n1514SinieEsIncap = new boolean[] {false} ;
      T001C5_A19SinieCodigo = new String[] {""} ;
      T001C5_n19SinieCodigo = new boolean[] {false} ;
      T001C3_A688SinieDescriSinAc = new String[] {""} ;
      T001C3_A19SinieCodigo = new String[] {""} ;
      T001C3_n19SinieCodigo = new boolean[] {false} ;
      T001C3_A333SinieDescri = new String[] {""} ;
      T001C3_A1514SinieEsIncap = new boolean[] {false} ;
      T001C3_n1514SinieEsIncap = new boolean[] {false} ;
      T001C6_A19SinieCodigo = new String[] {""} ;
      T001C6_n19SinieCodigo = new boolean[] {false} ;
      T001C7_A19SinieCodigo = new String[] {""} ;
      T001C7_n19SinieCodigo = new boolean[] {false} ;
      T001C2_A688SinieDescriSinAc = new String[] {""} ;
      T001C2_A19SinieCodigo = new String[] {""} ;
      T001C2_n19SinieCodigo = new boolean[] {false} ;
      T001C2_A333SinieDescri = new String[] {""} ;
      T001C2_A1514SinieEsIncap = new boolean[] {false} ;
      T001C2_n1514SinieEsIncap = new boolean[] {false} ;
      T001C11_A16SitCodigo = new String[] {""} ;
      T001C12_A3CliCod = new int[1] ;
      T001C12_A1EmpCod = new short[1] ;
      T001C12_A6LegNumero = new int[1] ;
      T001C13_A19SinieCodigo = new String[] {""} ;
      T001C13_n19SinieCodigo = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siniestrado__default(),
         new Object[] {
             new Object[] {
            T001C2_A688SinieDescriSinAc, T001C2_A19SinieCodigo, T001C2_A333SinieDescri, T001C2_A1514SinieEsIncap, T001C2_n1514SinieEsIncap
            }
            , new Object[] {
            T001C3_A688SinieDescriSinAc, T001C3_A19SinieCodigo, T001C3_A333SinieDescri, T001C3_A1514SinieEsIncap, T001C3_n1514SinieEsIncap
            }
            , new Object[] {
            T001C4_A688SinieDescriSinAc, T001C4_A19SinieCodigo, T001C4_A333SinieDescri, T001C4_A1514SinieEsIncap, T001C4_n1514SinieEsIncap
            }
            , new Object[] {
            T001C5_A19SinieCodigo
            }
            , new Object[] {
            T001C6_A19SinieCodigo
            }
            , new Object[] {
            T001C7_A19SinieCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001C11_A16SitCodigo
            }
            , new Object[] {
            T001C12_A3CliCod, T001C12_A1EmpCod, T001C12_A6LegNumero
            }
            , new Object[] {
            T001C13_A19SinieCodigo
            }
         }
      );
      AV18Pgmname = "Siniestrado" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound45 ;
   private short nIsDirty_45 ;
   private int trnEnded ;
   private int edtSinieCodigo_Enabled ;
   private int edtSinieDescri_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7SinieCodigo ;
   private String Z19SinieCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7SinieCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSinieCodigo_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A19SinieCodigo ;
   private String edtSinieCodigo_Jsonclick ;
   private String edtSinieDescri_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV18Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode45 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean Z1514SinieEsIncap ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n1514SinieEsIncap ;
   private boolean A1514SinieEsIncap ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n19SinieCodigo ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z688SinieDescriSinAc ;
   private String Z333SinieDescri ;
   private String A333SinieDescri ;
   private String A688SinieDescriSinAc ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T001C4_A688SinieDescriSinAc ;
   private String[] T001C4_A19SinieCodigo ;
   private boolean[] T001C4_n19SinieCodigo ;
   private String[] T001C4_A333SinieDescri ;
   private boolean[] T001C4_A1514SinieEsIncap ;
   private boolean[] T001C4_n1514SinieEsIncap ;
   private String[] T001C5_A19SinieCodigo ;
   private boolean[] T001C5_n19SinieCodigo ;
   private String[] T001C3_A688SinieDescriSinAc ;
   private String[] T001C3_A19SinieCodigo ;
   private boolean[] T001C3_n19SinieCodigo ;
   private String[] T001C3_A333SinieDescri ;
   private boolean[] T001C3_A1514SinieEsIncap ;
   private boolean[] T001C3_n1514SinieEsIncap ;
   private String[] T001C6_A19SinieCodigo ;
   private boolean[] T001C6_n19SinieCodigo ;
   private String[] T001C7_A19SinieCodigo ;
   private boolean[] T001C7_n19SinieCodigo ;
   private String[] T001C2_A688SinieDescriSinAc ;
   private String[] T001C2_A19SinieCodigo ;
   private boolean[] T001C2_n19SinieCodigo ;
   private String[] T001C2_A333SinieDescri ;
   private boolean[] T001C2_A1514SinieEsIncap ;
   private boolean[] T001C2_n1514SinieEsIncap ;
   private String[] T001C11_A16SitCodigo ;
   private int[] T001C12_A3CliCod ;
   private short[] T001C12_A1EmpCod ;
   private int[] T001C12_A6LegNumero ;
   private String[] T001C13_A19SinieCodigo ;
   private boolean[] T001C13_n19SinieCodigo ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class siniestrado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001C2", "SELECT SinieDescriSinAc, SinieCodigo, SinieDescri, SinieEsIncap FROM Siniestrado WHERE SinieCodigo = ?  FOR UPDATE OF Siniestrado NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001C3", "SELECT SinieDescriSinAc, SinieCodigo, SinieDescri, SinieEsIncap FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001C4", "SELECT TM1.SinieDescriSinAc, TM1.SinieCodigo, TM1.SinieDescri, TM1.SinieEsIncap FROM Siniestrado TM1 WHERE TM1.SinieCodigo = ( ?) ORDER BY TM1.SinieCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001C5", "SELECT SinieCodigo FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001C6", "SELECT SinieCodigo FROM Siniestrado WHERE ( SinieCodigo > ( ?)) ORDER BY SinieCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001C7", "SELECT SinieCodigo FROM Siniestrado WHERE ( SinieCodigo < ( ?)) ORDER BY SinieCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001C8", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieDescriSinAc, SinieCodigo, SinieDescri, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001C9", "SAVEPOINT gxupdate;UPDATE Siniestrado SET SinieDescriSinAc=?, SinieDescri=?, SinieEsIncap=?  WHERE SinieCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001C10", "SAVEPOINT gxupdate;DELETE FROM Siniestrado  WHERE SinieCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001C11", "SELECT SitCodigo FROM Estado WHERE EstadoSiniestro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001C12", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE SinieCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001C13", "SELECT SinieCodigo FROM Siniestrado ORDER BY SinieCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 4);
               }
               stmt.setVarchar(3, (String)parms[3], 400, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[5]).booleanValue());
               }
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 4);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
      }
   }

}

