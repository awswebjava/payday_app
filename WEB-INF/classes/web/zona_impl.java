package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class zona_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"ZONDESCRIPSINAC") == 0 )
      {
         A342ZonDescrip = httpContext.GetPar( "ZonDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A342ZonDescrip", A342ZonDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asazondescripsinac1F48( A342ZonDescrip) ;
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
            AV7ZonCod = httpContext.GetPar( "ZonCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ZonCod", AV7ZonCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vZONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ZonCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Zona", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtZonCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public zona_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public zona_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( zona_impl.class ));
   }

   public zona_impl( int remoteHandle ,
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Zona", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Zona.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtZonCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtZonCod_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtZonCod_Internalname, GXutil.rtrim( A20ZonCod), GXutil.rtrim( localUtil.format( A20ZonCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtZonCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtZonCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_Zona.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtZonDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtZonDescrip_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtZonDescrip_Internalname, A342ZonDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", (short)(0), 1, edtZonDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Zona.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtZonPorcAumenDed_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtZonPorcAumenDed_Internalname, httpContext.getMessage( "Porcentaje de aumento de deducciones personales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtZonPorcAumenDed_Internalname, GXutil.ltrim( localUtil.ntoc( A880ZonPorcAumenDed, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtZonPorcAumenDed_Enabled!=0) ? localUtil.format( A880ZonPorcAumenDed, "9.9999") : localUtil.format( A880ZonPorcAumenDed, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtZonPorcAumenDed_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtZonPorcAumenDed_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Zona.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtZonProvincia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtZonProvincia_Internalname, httpContext.getMessage( "Provincia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtZonProvincia_Internalname, A589ZonProvincia, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", (short)(0), 1, edtZonProvincia_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Zona.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Zona.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Zona.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Zona.htm");
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
      e111F2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z20ZonCod = httpContext.cgiGet( "Z20ZonCod") ;
            Z678ZonDescripSinAc = httpContext.cgiGet( "Z678ZonDescripSinAc") ;
            Z342ZonDescrip = httpContext.cgiGet( "Z342ZonDescrip") ;
            Z589ZonProvincia = httpContext.cgiGet( "Z589ZonProvincia") ;
            Z343ZonPorcReduc = localUtil.ctond( httpContext.cgiGet( "Z343ZonPorcReduc")) ;
            Z880ZonPorcAumenDed = localUtil.ctond( httpContext.cgiGet( "Z880ZonPorcAumenDed")) ;
            Z2223ZonLocEs = GXutil.strtobool( httpContext.cgiGet( "Z2223ZonLocEs")) ;
            Z2264zonAfipCod = httpContext.cgiGet( "Z2264zonAfipCod") ;
            A678ZonDescripSinAc = httpContext.cgiGet( "Z678ZonDescripSinAc") ;
            A343ZonPorcReduc = localUtil.ctond( httpContext.cgiGet( "Z343ZonPorcReduc")) ;
            A2223ZonLocEs = GXutil.strtobool( httpContext.cgiGet( "Z2223ZonLocEs")) ;
            A2264zonAfipCod = httpContext.cgiGet( "Z2264zonAfipCod") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A678ZonDescripSinAc = httpContext.cgiGet( "ZONDESCRIPSINAC") ;
            AV7ZonCod = httpContext.cgiGet( "vZONCOD") ;
            A343ZonPorcReduc = localUtil.ctond( httpContext.cgiGet( "ZONPORCREDUC")) ;
            A2223ZonLocEs = GXutil.strtobool( httpContext.cgiGet( "ZONLOCES")) ;
            A2264zonAfipCod = httpContext.cgiGet( "ZONAFIPCOD") ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A20ZonCod = httpContext.cgiGet( edtZonCod_Internalname) ;
            n20ZonCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
            A342ZonDescrip = httpContext.cgiGet( edtZonDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A342ZonDescrip", A342ZonDescrip);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtZonPorcAumenDed_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtZonPorcAumenDed_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ZONPORCAUMENDED");
               AnyError = (short)(1) ;
               GX_FocusControl = edtZonPorcAumenDed_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A880ZonPorcAumenDed = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A880ZonPorcAumenDed", GXutil.ltrimstr( A880ZonPorcAumenDed, 6, 4));
            }
            else
            {
               A880ZonPorcAumenDed = localUtil.ctond( httpContext.cgiGet( edtZonPorcAumenDed_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A880ZonPorcAumenDed", GXutil.ltrimstr( A880ZonPorcAumenDed, 6, 4));
            }
            A589ZonProvincia = httpContext.cgiGet( edtZonProvincia_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A589ZonProvincia", A589ZonProvincia);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Zona");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ZonPorcReduc", localUtil.format( A343ZonPorcReduc, "ZZ9.99"));
            forbiddenHiddens.add("ZonLocEs", GXutil.booltostr( A2223ZonLocEs));
            forbiddenHiddens.add("zonAfipCod", GXutil.rtrim( localUtil.format( A2264zonAfipCod, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A20ZonCod, Z20ZonCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("zona:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A20ZonCod = httpContext.GetPar( "ZonCod") ;
               n20ZonCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
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
                  sMode48 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode48 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound48 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1F0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ZONCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtZonCod_Internalname ;
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
                        e111F2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121F2 ();
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
         e121F2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1F48( ) ;
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
         disableAttributes1F48( ) ;
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

   public void confirm_1F0( )
   {
      beforeValidate1F48( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1F48( ) ;
         }
         else
         {
            checkExtendedTable1F48( ) ;
            closeExtendedTableCursors1F48( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1F0( )
   {
   }

   public void e111F2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWZona_Insert", GXv_boolean3) ;
         zona_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWZona_Update", GXv_boolean3) ;
         zona_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWZona_Delete", GXv_boolean3) ;
         zona_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e121F2( )
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

   public void zm1F48( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z678ZonDescripSinAc = T001F3_A678ZonDescripSinAc[0] ;
            Z342ZonDescrip = T001F3_A342ZonDescrip[0] ;
            Z589ZonProvincia = T001F3_A589ZonProvincia[0] ;
            Z343ZonPorcReduc = T001F3_A343ZonPorcReduc[0] ;
            Z880ZonPorcAumenDed = T001F3_A880ZonPorcAumenDed[0] ;
            Z2223ZonLocEs = T001F3_A2223ZonLocEs[0] ;
            Z2264zonAfipCod = T001F3_A2264zonAfipCod[0] ;
         }
         else
         {
            Z678ZonDescripSinAc = A678ZonDescripSinAc ;
            Z342ZonDescrip = A342ZonDescrip ;
            Z589ZonProvincia = A589ZonProvincia ;
            Z343ZonPorcReduc = A343ZonPorcReduc ;
            Z880ZonPorcAumenDed = A880ZonPorcAumenDed ;
            Z2223ZonLocEs = A2223ZonLocEs ;
            Z2264zonAfipCod = A2264zonAfipCod ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z678ZonDescripSinAc = A678ZonDescripSinAc ;
         Z20ZonCod = A20ZonCod ;
         Z342ZonDescrip = A342ZonDescrip ;
         Z589ZonProvincia = A589ZonProvincia ;
         Z343ZonPorcReduc = A343ZonPorcReduc ;
         Z880ZonPorcAumenDed = A880ZonPorcAumenDed ;
         Z2223ZonLocEs = A2223ZonLocEs ;
         Z2264zonAfipCod = A2264zonAfipCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7ZonCod)==0) )
      {
         A20ZonCod = AV7ZonCod ;
         n20ZonCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
      }
      if ( ! (GXutil.strcmp("", AV7ZonCod)==0) )
      {
         edtZonCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonCod_Enabled), 5, 0), true);
      }
      else
      {
         edtZonCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7ZonCod)==0) )
      {
         edtZonCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonCod_Enabled), 5, 0), true);
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
         AV15Pgmname = "Zona" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      }
   }

   public void load1F48( )
   {
      /* Using cursor T001F4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A678ZonDescripSinAc = T001F4_A678ZonDescripSinAc[0] ;
         A342ZonDescrip = T001F4_A342ZonDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A342ZonDescrip", A342ZonDescrip);
         A589ZonProvincia = T001F4_A589ZonProvincia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A589ZonProvincia", A589ZonProvincia);
         A343ZonPorcReduc = T001F4_A343ZonPorcReduc[0] ;
         A880ZonPorcAumenDed = T001F4_A880ZonPorcAumenDed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A880ZonPorcAumenDed", GXutil.ltrimstr( A880ZonPorcAumenDed, 6, 4));
         A2223ZonLocEs = T001F4_A2223ZonLocEs[0] ;
         A2264zonAfipCod = T001F4_A2264zonAfipCod[0] ;
         zm1F48( -5) ;
      }
      pr_default.close(2);
      onLoadActions1F48( ) ;
   }

   public void onLoadActions1F48( )
   {
      AV15Pgmname = "Zona" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      GXt_char4 = A678ZonDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A342ZonDescrip, GXv_char5) ;
      zona_impl.this.GXt_char4 = GXv_char5[0] ;
      A678ZonDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
   }

   public void checkExtendedTable1F48( )
   {
      nIsDirty_48 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV15Pgmname = "Zona" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      nIsDirty_48 = (short)(1) ;
      GXt_char4 = A678ZonDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A342ZonDescrip, GXv_char5) ;
      zona_impl.this.GXt_char4 = GXv_char5[0] ;
      A678ZonDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
   }

   public void closeExtendedTableCursors1F48( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1F48( )
   {
      /* Using cursor T001F5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound48 = (short)(1) ;
      }
      else
      {
         RcdFound48 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001F3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1F48( 5) ;
         RcdFound48 = (short)(1) ;
         A678ZonDescripSinAc = T001F3_A678ZonDescripSinAc[0] ;
         A20ZonCod = T001F3_A20ZonCod[0] ;
         n20ZonCod = T001F3_n20ZonCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
         A342ZonDescrip = T001F3_A342ZonDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A342ZonDescrip", A342ZonDescrip);
         A589ZonProvincia = T001F3_A589ZonProvincia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A589ZonProvincia", A589ZonProvincia);
         A343ZonPorcReduc = T001F3_A343ZonPorcReduc[0] ;
         A880ZonPorcAumenDed = T001F3_A880ZonPorcAumenDed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A880ZonPorcAumenDed", GXutil.ltrimstr( A880ZonPorcAumenDed, 6, 4));
         A2223ZonLocEs = T001F3_A2223ZonLocEs[0] ;
         A2264zonAfipCod = T001F3_A2264zonAfipCod[0] ;
         Z20ZonCod = A20ZonCod ;
         sMode48 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1F48( ) ;
         if ( AnyError == 1 )
         {
            RcdFound48 = (short)(0) ;
            initializeNonKey1F48( ) ;
         }
         Gx_mode = sMode48 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound48 = (short)(0) ;
         initializeNonKey1F48( ) ;
         sMode48 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode48 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1F48( ) ;
      if ( RcdFound48 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound48 = (short)(0) ;
      /* Using cursor T001F6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001F6_A20ZonCod[0], A20ZonCod) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001F6_A20ZonCod[0], A20ZonCod) > 0 ) ) )
         {
            A20ZonCod = T001F6_A20ZonCod[0] ;
            n20ZonCod = T001F6_n20ZonCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
            RcdFound48 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound48 = (short)(0) ;
      /* Using cursor T001F7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001F7_A20ZonCod[0], A20ZonCod) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001F7_A20ZonCod[0], A20ZonCod) < 0 ) ) )
         {
            A20ZonCod = T001F7_A20ZonCod[0] ;
            n20ZonCod = T001F7_n20ZonCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
            RcdFound48 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1F48( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtZonCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1F48( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound48 == 1 )
         {
            if ( GXutil.strcmp(A20ZonCod, Z20ZonCod) != 0 )
            {
               A20ZonCod = Z20ZonCod ;
               n20ZonCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ZONCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtZonCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtZonCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1F48( ) ;
               GX_FocusControl = edtZonCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A20ZonCod, Z20ZonCod) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtZonCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1F48( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ZONCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtZonCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtZonCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1F48( ) ;
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
      if ( GXutil.strcmp(A20ZonCod, Z20ZonCod) != 0 )
      {
         A20ZonCod = Z20ZonCod ;
         n20ZonCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ZONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtZonCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtZonCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1F48( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001F2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Zona"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z678ZonDescripSinAc, T001F2_A678ZonDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z342ZonDescrip, T001F2_A342ZonDescrip[0]) != 0 ) || ( GXutil.strcmp(Z589ZonProvincia, T001F2_A589ZonProvincia[0]) != 0 ) || ( DecimalUtil.compareTo(Z343ZonPorcReduc, T001F2_A343ZonPorcReduc[0]) != 0 ) || ( DecimalUtil.compareTo(Z880ZonPorcAumenDed, T001F2_A880ZonPorcAumenDed[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2223ZonLocEs != T001F2_A2223ZonLocEs[0] ) || ( GXutil.strcmp(Z2264zonAfipCod, T001F2_A2264zonAfipCod[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z678ZonDescripSinAc, T001F2_A678ZonDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z678ZonDescripSinAc);
               GXutil.writeLogRaw("Current: ",T001F2_A678ZonDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z342ZonDescrip, T001F2_A342ZonDescrip[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonDescrip");
               GXutil.writeLogRaw("Old: ",Z342ZonDescrip);
               GXutil.writeLogRaw("Current: ",T001F2_A342ZonDescrip[0]);
            }
            if ( GXutil.strcmp(Z589ZonProvincia, T001F2_A589ZonProvincia[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonProvincia");
               GXutil.writeLogRaw("Old: ",Z589ZonProvincia);
               GXutil.writeLogRaw("Current: ",T001F2_A589ZonProvincia[0]);
            }
            if ( DecimalUtil.compareTo(Z343ZonPorcReduc, T001F2_A343ZonPorcReduc[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonPorcReduc");
               GXutil.writeLogRaw("Old: ",Z343ZonPorcReduc);
               GXutil.writeLogRaw("Current: ",T001F2_A343ZonPorcReduc[0]);
            }
            if ( DecimalUtil.compareTo(Z880ZonPorcAumenDed, T001F2_A880ZonPorcAumenDed[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonPorcAumenDed");
               GXutil.writeLogRaw("Old: ",Z880ZonPorcAumenDed);
               GXutil.writeLogRaw("Current: ",T001F2_A880ZonPorcAumenDed[0]);
            }
            if ( Z2223ZonLocEs != T001F2_A2223ZonLocEs[0] )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"ZonLocEs");
               GXutil.writeLogRaw("Old: ",Z2223ZonLocEs);
               GXutil.writeLogRaw("Current: ",T001F2_A2223ZonLocEs[0]);
            }
            if ( GXutil.strcmp(Z2264zonAfipCod, T001F2_A2264zonAfipCod[0]) != 0 )
            {
               GXutil.writeLogln("zona:[seudo value changed for attri]"+"zonAfipCod");
               GXutil.writeLogRaw("Old: ",Z2264zonAfipCod);
               GXutil.writeLogRaw("Current: ",T001F2_A2264zonAfipCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Zona"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1F48( )
   {
      beforeValidate1F48( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1F48( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1F48( 0) ;
         checkOptimisticConcurrency1F48( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1F48( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1F48( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001F8 */
                  pr_default.execute(6, new Object[] {A678ZonDescripSinAc, Boolean.valueOf(n20ZonCod), A20ZonCod, A342ZonDescrip, A589ZonProvincia, A343ZonPorcReduc, A880ZonPorcAumenDed, Boolean.valueOf(A2223ZonLocEs), A2264zonAfipCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Zona");
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
                        resetCaption1F0( ) ;
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
            load1F48( ) ;
         }
         endLevel1F48( ) ;
      }
      closeExtendedTableCursors1F48( ) ;
   }

   public void update1F48( )
   {
      beforeValidate1F48( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1F48( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1F48( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1F48( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1F48( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001F9 */
                  pr_default.execute(7, new Object[] {A678ZonDescripSinAc, A342ZonDescrip, A589ZonProvincia, A343ZonPorcReduc, A880ZonPorcAumenDed, Boolean.valueOf(A2223ZonLocEs), A2264zonAfipCod, Boolean.valueOf(n20ZonCod), A20ZonCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Zona");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Zona"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1F48( ) ;
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
         endLevel1F48( ) ;
      }
      closeExtendedTableCursors1F48( ) ;
   }

   public void deferredUpdate1F48( )
   {
   }

   public void delete( )
   {
      beforeValidate1F48( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1F48( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1F48( ) ;
         afterConfirm1F48( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1F48( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001F10 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Zona");
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
      sMode48 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1F48( ) ;
      Gx_mode = sMode48 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1F48( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV15Pgmname = "Zona" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001F11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Localidad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor T001F12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor T001F13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel1F48( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1F48( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "zona");
         if ( AnyError == 0 )
         {
            confirmValues1F0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "zona");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1F48( )
   {
      /* Scan By routine */
      /* Using cursor T001F14 */
      pr_default.execute(12);
      RcdFound48 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A20ZonCod = T001F14_A20ZonCod[0] ;
         n20ZonCod = T001F14_n20ZonCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1F48( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound48 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A20ZonCod = T001F14_A20ZonCod[0] ;
         n20ZonCod = T001F14_n20ZonCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
      }
   }

   public void scanEnd1F48( )
   {
      pr_default.close(12);
   }

   public void afterConfirm1F48( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1F48( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1F48( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1F48( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1F48( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1F48( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1F48( )
   {
      edtZonCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonCod_Enabled), 5, 0), true);
      edtZonDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtZonDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonDescrip_Enabled), 5, 0), true);
      edtZonPorcAumenDed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtZonPorcAumenDed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonPorcAumenDed_Enabled), 5, 0), true);
      edtZonProvincia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtZonProvincia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonProvincia_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1F48( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1F0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.zona", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7ZonCod))}, new String[] {"Gx_mode","ZonCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Zona");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ZonPorcReduc", localUtil.format( A343ZonPorcReduc, "ZZ9.99"));
      forbiddenHiddens.add("ZonLocEs", GXutil.booltostr( A2223ZonLocEs));
      forbiddenHiddens.add("zonAfipCod", GXutil.rtrim( localUtil.format( A2264zonAfipCod, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("zona:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z20ZonCod", GXutil.rtrim( Z20ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z678ZonDescripSinAc", Z678ZonDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z342ZonDescrip", Z342ZonDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z589ZonProvincia", Z589ZonProvincia);
      web.GxWebStd.gx_hidden_field( httpContext, "Z343ZonPorcReduc", GXutil.ltrim( localUtil.ntoc( Z343ZonPorcReduc, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z880ZonPorcAumenDed", GXutil.ltrim( localUtil.ntoc( Z880ZonPorcAumenDed, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2223ZonLocEs", Z2223ZonLocEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2264zonAfipCod", GXutil.rtrim( Z2264zonAfipCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "ZONDESCRIPSINAC", A678ZonDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vZONCOD", GXutil.rtrim( AV7ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vZONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ZonCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "ZONPORCREDUC", GXutil.ltrim( localUtil.ntoc( A343ZonPorcReduc, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "ZONLOCES", A2223ZonLocEs);
      web.GxWebStd.gx_hidden_field( httpContext, "ZONAFIPCOD", GXutil.rtrim( A2264zonAfipCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
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
      return formatLink("web.zona", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7ZonCod))}, new String[] {"Gx_mode","ZonCod"})  ;
   }

   public String getPgmname( )
   {
      return "Zona" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Zona", "") ;
   }

   public void initializeNonKey1F48( )
   {
      A678ZonDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
      A342ZonDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A342ZonDescrip", A342ZonDescrip);
      A589ZonProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A589ZonProvincia", A589ZonProvincia);
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A343ZonPorcReduc", GXutil.ltrimstr( A343ZonPorcReduc, 6, 2));
      A880ZonPorcAumenDed = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A880ZonPorcAumenDed", GXutil.ltrimstr( A880ZonPorcAumenDed, 6, 4));
      A2223ZonLocEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2223ZonLocEs", A2223ZonLocEs);
      A2264zonAfipCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2264zonAfipCod", A2264zonAfipCod);
      Z678ZonDescripSinAc = "" ;
      Z342ZonDescrip = "" ;
      Z589ZonProvincia = "" ;
      Z343ZonPorcReduc = DecimalUtil.ZERO ;
      Z880ZonPorcAumenDed = DecimalUtil.ZERO ;
      Z2223ZonLocEs = false ;
      Z2264zonAfipCod = "" ;
   }

   public void initAll1F48( )
   {
      A20ZonCod = "" ;
      n20ZonCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A20ZonCod", A20ZonCod);
      initializeNonKey1F48( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171359586", true, true);
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
      httpContext.AddJavascriptSource("zona.js", "?2025171359586", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtZonCod_Internalname = "ZONCOD" ;
      edtZonDescrip_Internalname = "ZONDESCRIP" ;
      edtZonPorcAumenDed_Internalname = "ZONPORCAUMENDED" ;
      edtZonProvincia_Internalname = "ZONPROVINCIA" ;
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
      Form.setCaption( httpContext.getMessage( "Zona", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtZonProvincia_Enabled = 1 ;
      edtZonPorcAumenDed_Jsonclick = "" ;
      edtZonPorcAumenDed_Enabled = 1 ;
      edtZonDescrip_Enabled = 1 ;
      edtZonCod_Jsonclick = "" ;
      edtZonCod_Enabled = 1 ;
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

   public void gx1asazondescripsinac1F48( String A342ZonDescrip )
   {
      GXt_char4 = A678ZonDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A342ZonDescrip, GXv_char5) ;
      zona_impl.this.GXt_char4 = GXv_char5[0] ;
      A678ZonDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A678ZonDescripSinAc)+"\"") ;
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

   public void valid_Zondescrip( )
   {
      GXt_char4 = A678ZonDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A342ZonDescrip, GXv_char5) ;
      zona_impl.this.GXt_char4 = GXv_char5[0] ;
      A678ZonDescripSinAc = GXt_char4 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ZonCod',fld:'vZONCOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ZonCod',fld:'vZONCOD',pic:'',hsh:true},{av:'A343ZonPorcReduc',fld:'ZONPORCREDUC',pic:'ZZ9.99'},{av:'A2223ZonLocEs',fld:'ZONLOCES',pic:''},{av:'A2264zonAfipCod',fld:'ZONAFIPCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e121F2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ZONCOD","{handler:'valid_Zoncod',iparms:[]");
      setEventMetadata("VALID_ZONCOD",",oparms:[]}");
      setEventMetadata("VALID_ZONDESCRIP","{handler:'valid_Zondescrip',iparms:[{av:'A342ZonDescrip',fld:'ZONDESCRIP',pic:''},{av:'A678ZonDescripSinAc',fld:'ZONDESCRIPSINAC',pic:''}]");
      setEventMetadata("VALID_ZONDESCRIP",",oparms:[{av:'A678ZonDescripSinAc',fld:'ZONDESCRIPSINAC',pic:''}]}");
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
      wcpOAV7ZonCod = "" ;
      Z20ZonCod = "" ;
      Z678ZonDescripSinAc = "" ;
      Z342ZonDescrip = "" ;
      Z589ZonProvincia = "" ;
      Z343ZonPorcReduc = DecimalUtil.ZERO ;
      Z880ZonPorcAumenDed = DecimalUtil.ZERO ;
      Z2264zonAfipCod = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A342ZonDescrip = "" ;
      Gx_mode = "" ;
      AV7ZonCod = "" ;
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
      A20ZonCod = "" ;
      A880ZonPorcAumenDed = DecimalUtil.ZERO ;
      A589ZonProvincia = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A678ZonDescripSinAc = "" ;
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      A2264zonAfipCod = "" ;
      AV15Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode48 = "" ;
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
      T001F4_A678ZonDescripSinAc = new String[] {""} ;
      T001F4_A20ZonCod = new String[] {""} ;
      T001F4_n20ZonCod = new boolean[] {false} ;
      T001F4_A342ZonDescrip = new String[] {""} ;
      T001F4_A589ZonProvincia = new String[] {""} ;
      T001F4_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F4_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F4_A2223ZonLocEs = new boolean[] {false} ;
      T001F4_A2264zonAfipCod = new String[] {""} ;
      T001F5_A20ZonCod = new String[] {""} ;
      T001F5_n20ZonCod = new boolean[] {false} ;
      T001F3_A678ZonDescripSinAc = new String[] {""} ;
      T001F3_A20ZonCod = new String[] {""} ;
      T001F3_n20ZonCod = new boolean[] {false} ;
      T001F3_A342ZonDescrip = new String[] {""} ;
      T001F3_A589ZonProvincia = new String[] {""} ;
      T001F3_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F3_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F3_A2223ZonLocEs = new boolean[] {false} ;
      T001F3_A2264zonAfipCod = new String[] {""} ;
      T001F6_A20ZonCod = new String[] {""} ;
      T001F6_n20ZonCod = new boolean[] {false} ;
      T001F7_A20ZonCod = new String[] {""} ;
      T001F7_n20ZonCod = new boolean[] {false} ;
      T001F2_A678ZonDescripSinAc = new String[] {""} ;
      T001F2_A20ZonCod = new String[] {""} ;
      T001F2_n20ZonCod = new boolean[] {false} ;
      T001F2_A342ZonDescrip = new String[] {""} ;
      T001F2_A589ZonProvincia = new String[] {""} ;
      T001F2_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F2_A880ZonPorcAumenDed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001F2_A2223ZonLocEs = new boolean[] {false} ;
      T001F2_A2264zonAfipCod = new String[] {""} ;
      T001F11_A46PaiCod = new short[1] ;
      T001F11_A47ProvCod = new short[1] ;
      T001F11_A48LocCod = new short[1] ;
      T001F12_A3CliCod = new int[1] ;
      T001F12_A1EmpCod = new short[1] ;
      T001F13_A3CliCod = new int[1] ;
      T001F13_A1EmpCod = new short[1] ;
      T001F13_A6LegNumero = new int[1] ;
      T001F14_A20ZonCod = new String[] {""} ;
      T001F14_n20ZonCod = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.zona__default(),
         new Object[] {
             new Object[] {
            T001F2_A678ZonDescripSinAc, T001F2_A20ZonCod, T001F2_A342ZonDescrip, T001F2_A589ZonProvincia, T001F2_A343ZonPorcReduc, T001F2_A880ZonPorcAumenDed, T001F2_A2223ZonLocEs, T001F2_A2264zonAfipCod
            }
            , new Object[] {
            T001F3_A678ZonDescripSinAc, T001F3_A20ZonCod, T001F3_A342ZonDescrip, T001F3_A589ZonProvincia, T001F3_A343ZonPorcReduc, T001F3_A880ZonPorcAumenDed, T001F3_A2223ZonLocEs, T001F3_A2264zonAfipCod
            }
            , new Object[] {
            T001F4_A678ZonDescripSinAc, T001F4_A20ZonCod, T001F4_A342ZonDescrip, T001F4_A589ZonProvincia, T001F4_A343ZonPorcReduc, T001F4_A880ZonPorcAumenDed, T001F4_A2223ZonLocEs, T001F4_A2264zonAfipCod
            }
            , new Object[] {
            T001F5_A20ZonCod
            }
            , new Object[] {
            T001F6_A20ZonCod
            }
            , new Object[] {
            T001F7_A20ZonCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001F11_A46PaiCod, T001F11_A47ProvCod, T001F11_A48LocCod
            }
            , new Object[] {
            T001F12_A3CliCod, T001F12_A1EmpCod
            }
            , new Object[] {
            T001F13_A3CliCod, T001F13_A1EmpCod, T001F13_A6LegNumero
            }
            , new Object[] {
            T001F14_A20ZonCod
            }
         }
      );
      AV15Pgmname = "Zona" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound48 ;
   private short nIsDirty_48 ;
   private int trnEnded ;
   private int edtZonCod_Enabled ;
   private int edtZonDescrip_Enabled ;
   private int edtZonPorcAumenDed_Enabled ;
   private int edtZonProvincia_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z343ZonPorcReduc ;
   private java.math.BigDecimal Z880ZonPorcAumenDed ;
   private java.math.BigDecimal A880ZonPorcAumenDed ;
   private java.math.BigDecimal A343ZonPorcReduc ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7ZonCod ;
   private String Z20ZonCod ;
   private String Z2264zonAfipCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7ZonCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtZonCod_Internalname ;
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
   private String A20ZonCod ;
   private String edtZonCod_Jsonclick ;
   private String edtZonDescrip_Internalname ;
   private String edtZonPorcAumenDed_Internalname ;
   private String edtZonPorcAumenDed_Jsonclick ;
   private String edtZonProvincia_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String A2264zonAfipCod ;
   private String AV15Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode48 ;
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
   private boolean Z2223ZonLocEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A2223ZonLocEs ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n20ZonCod ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String Z678ZonDescripSinAc ;
   private String Z342ZonDescrip ;
   private String Z589ZonProvincia ;
   private String A342ZonDescrip ;
   private String A589ZonProvincia ;
   private String A678ZonDescripSinAc ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T001F4_A678ZonDescripSinAc ;
   private String[] T001F4_A20ZonCod ;
   private boolean[] T001F4_n20ZonCod ;
   private String[] T001F4_A342ZonDescrip ;
   private String[] T001F4_A589ZonProvincia ;
   private java.math.BigDecimal[] T001F4_A343ZonPorcReduc ;
   private java.math.BigDecimal[] T001F4_A880ZonPorcAumenDed ;
   private boolean[] T001F4_A2223ZonLocEs ;
   private String[] T001F4_A2264zonAfipCod ;
   private String[] T001F5_A20ZonCod ;
   private boolean[] T001F5_n20ZonCod ;
   private String[] T001F3_A678ZonDescripSinAc ;
   private String[] T001F3_A20ZonCod ;
   private boolean[] T001F3_n20ZonCod ;
   private String[] T001F3_A342ZonDescrip ;
   private String[] T001F3_A589ZonProvincia ;
   private java.math.BigDecimal[] T001F3_A343ZonPorcReduc ;
   private java.math.BigDecimal[] T001F3_A880ZonPorcAumenDed ;
   private boolean[] T001F3_A2223ZonLocEs ;
   private String[] T001F3_A2264zonAfipCod ;
   private String[] T001F6_A20ZonCod ;
   private boolean[] T001F6_n20ZonCod ;
   private String[] T001F7_A20ZonCod ;
   private boolean[] T001F7_n20ZonCod ;
   private String[] T001F2_A678ZonDescripSinAc ;
   private String[] T001F2_A20ZonCod ;
   private boolean[] T001F2_n20ZonCod ;
   private String[] T001F2_A342ZonDescrip ;
   private String[] T001F2_A589ZonProvincia ;
   private java.math.BigDecimal[] T001F2_A343ZonPorcReduc ;
   private java.math.BigDecimal[] T001F2_A880ZonPorcAumenDed ;
   private boolean[] T001F2_A2223ZonLocEs ;
   private String[] T001F2_A2264zonAfipCod ;
   private short[] T001F11_A46PaiCod ;
   private short[] T001F11_A47ProvCod ;
   private short[] T001F11_A48LocCod ;
   private int[] T001F12_A3CliCod ;
   private short[] T001F12_A1EmpCod ;
   private int[] T001F13_A3CliCod ;
   private short[] T001F13_A1EmpCod ;
   private int[] T001F13_A6LegNumero ;
   private String[] T001F14_A20ZonCod ;
   private boolean[] T001F14_n20ZonCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class zona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001F2", "SELECT ZonDescripSinAc, ZonCod, ZonDescrip, ZonProvincia, ZonPorcReduc, ZonPorcAumenDed, ZonLocEs, zonAfipCod FROM Zona WHERE ZonCod = ?  FOR UPDATE OF Zona NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001F3", "SELECT ZonDescripSinAc, ZonCod, ZonDescrip, ZonProvincia, ZonPorcReduc, ZonPorcAumenDed, ZonLocEs, zonAfipCod FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001F4", "SELECT TM1.ZonDescripSinAc, TM1.ZonCod, TM1.ZonDescrip, TM1.ZonProvincia, TM1.ZonPorcReduc, TM1.ZonPorcAumenDed, TM1.ZonLocEs, TM1.zonAfipCod FROM Zona TM1 WHERE TM1.ZonCod = ( ?) ORDER BY TM1.ZonCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001F5", "SELECT ZonCod FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001F6", "SELECT ZonCod FROM Zona WHERE ( ZonCod > ( ?)) ORDER BY ZonCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001F7", "SELECT ZonCod FROM Zona WHERE ( ZonCod < ( ?)) ORDER BY ZonCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001F8", "SAVEPOINT gxupdate;INSERT INTO Zona(ZonDescripSinAc, ZonCod, ZonDescrip, ZonProvincia, ZonPorcReduc, ZonPorcAumenDed, ZonLocEs, zonAfipCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001F9", "SAVEPOINT gxupdate;UPDATE Zona SET ZonDescripSinAc=?, ZonDescrip=?, ZonProvincia=?, ZonPorcReduc=?, ZonPorcAumenDed=?, ZonLocEs=?, zonAfipCod=?  WHERE ZonCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001F10", "SAVEPOINT gxupdate;DELETE FROM Zona  WHERE ZonCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001F11", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE LocaZona = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001F12", "SELECT CliCod, EmpCod FROM Empresa WHERE EmpZonCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001F13", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE ZonCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001F14", "SELECT ZonCod FROM Zona ORDER BY ZonCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
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
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setVarchar(3, (String)parms[3], 400, false);
               stmt.setVarchar(4, (String)parms[4], 400, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               stmt.setString(8, (String)parms[8], 2);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setString(7, (String)parms[6], 2);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[8], 20);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
      }
   }

}

