package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class modalidadafip_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"MPRDESCRIPSINAC") == 0 )
      {
         A303MprDescrip = httpContext.GetPar( "MprDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A303MprDescrip", A303MprDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asamprdescripsinac1235( A303MprDescrip) ;
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
            AV7MprCod = httpContext.GetPar( "MprCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7MprCod", AV7MprCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMPRCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7MprCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Modalidad AFIP", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMprCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public modalidadafip_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public modalidadafip_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( modalidadafip_impl.class ));
   }

   public modalidadafip_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkMprHabilitada = UIFactory.getCheckbox(this);
      chkMprEsParcial = UIFactory.getCheckbox(this);
      chkMprNoDetrae = UIFactory.getCheckbox(this);
      chkMprHorasExtras = UIFactory.getCheckbox(this);
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
      A304MprHabilitada = GXutil.strtobool( GXutil.booltostr( A304MprHabilitada)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
      A1024MprEsParcial = GXutil.strtobool( GXutil.booltostr( A1024MprEsParcial)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
      A1071MprNoDetrae = GXutil.strtobool( GXutil.booltostr( A1071MprNoDetrae)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
      A1353MprHorasExtras = GXutil.strtobool( GXutil.booltostr( A1353MprHorasExtras)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
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
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMprCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMprCod_Internalname, httpContext.getMessage( "Modalidad de Contratación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMprCod_Internalname, GXutil.rtrim( A18MprCod), GXutil.rtrim( localUtil.format( A18MprCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMprCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMprCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_ModalidadAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMprDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMprDescrip_Internalname, httpContext.getMessage( "Modalidad de Contratación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMprDescrip_Internalname, A303MprDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtMprDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ModalidadAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMprHabilitada.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMprHabilitada.getInternalname(), httpContext.getMessage( "Habilitada", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMprHabilitada.getInternalname(), GXutil.booltostr( A304MprHabilitada), "", httpContext.getMessage( "Habilitada", ""), 1, chkMprHabilitada.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(32, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMprEsParcial.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMprEsParcial.getInternalname(), httpContext.getMessage( "Tiempo parcial", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMprEsParcial.getInternalname(), GXutil.booltostr( A1024MprEsParcial), "", httpContext.getMessage( "Tiempo parcial", ""), 1, chkMprEsParcial.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMprNoDetrae.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMprNoDetrae.getInternalname(), httpContext.getMessage( "No realiza \"detracción\" (Importe a detraer en 0)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMprNoDetrae.getInternalname(), GXutil.booltostr( A1071MprNoDetrae), "", httpContext.getMessage( "No realiza \"detracción\" (Importe a detraer en 0)", ""), 1, chkMprNoDetrae.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMprHorasExtras.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMprHorasExtras.getInternalname(), httpContext.getMessage( "Puede realizar horas extras", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMprHorasExtras.getInternalname(), GXutil.booltostr( A1353MprHorasExtras), "", httpContext.getMessage( "Puede realizar horas extras", ""), 1, chkMprHorasExtras.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ModalidadAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ModalidadAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ModalidadAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      e11122 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z18MprCod = httpContext.cgiGet( "Z18MprCod") ;
            Z684MprDescripSinAc = httpContext.cgiGet( "Z684MprDescripSinAc") ;
            Z303MprDescrip = httpContext.cgiGet( "Z303MprDescrip") ;
            Z304MprHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z304MprHabilitada")) ;
            Z305MprTasa = localUtil.ctond( httpContext.cgiGet( "Z305MprTasa")) ;
            Z1024MprEsParcial = GXutil.strtobool( httpContext.cgiGet( "Z1024MprEsParcial")) ;
            Z1071MprNoDetrae = GXutil.strtobool( httpContext.cgiGet( "Z1071MprNoDetrae")) ;
            Z1353MprHorasExtras = GXutil.strtobool( httpContext.cgiGet( "Z1353MprHorasExtras")) ;
            A684MprDescripSinAc = httpContext.cgiGet( "Z684MprDescripSinAc") ;
            A305MprTasa = localUtil.ctond( httpContext.cgiGet( "Z305MprTasa")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A684MprDescripSinAc = httpContext.cgiGet( "MPRDESCRIPSINAC") ;
            AV7MprCod = httpContext.cgiGet( "vMPRCOD") ;
            A305MprTasa = localUtil.ctond( httpContext.cgiGet( "MPRTASA")) ;
            AV13Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A18MprCod = httpContext.cgiGet( edtMprCod_Internalname) ;
            n18MprCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
            A303MprDescrip = httpContext.cgiGet( edtMprDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A303MprDescrip", A303MprDescrip);
            A304MprHabilitada = GXutil.strtobool( httpContext.cgiGet( chkMprHabilitada.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
            A1024MprEsParcial = GXutil.strtobool( httpContext.cgiGet( chkMprEsParcial.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
            A1071MprNoDetrae = GXutil.strtobool( httpContext.cgiGet( chkMprNoDetrae.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
            A1353MprHorasExtras = GXutil.strtobool( httpContext.cgiGet( chkMprHorasExtras.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ModalidadAFIP");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MprTasa", localUtil.format( A305MprTasa, "ZZ9.99"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A18MprCod, Z18MprCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("modalidadafip:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A18MprCod = httpContext.GetPar( "MprCod") ;
               n18MprCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
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
                  sMode35 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode35 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound35 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_120( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "MPRCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMprCod_Internalname ;
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
                        e11122 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12122 ();
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
         e12122 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1235( ) ;
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
         disableAttributes1235( ) ;
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

   public void confirm_120( )
   {
      beforeValidate1235( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1235( ) ;
         }
         else
         {
            checkExtendedTable1235( ) ;
            closeExtendedTableCursors1235( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption120( )
   {
   }

   public void e11122( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWModalidad_Insert", GXv_boolean3) ;
         modalidadafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWModalidad_Update", GXv_boolean3) ;
         modalidadafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWModalidad_Delete", GXv_boolean3) ;
         modalidadafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e12122( )
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

   public void zm1235( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z684MprDescripSinAc = T00123_A684MprDescripSinAc[0] ;
            Z303MprDescrip = T00123_A303MprDescrip[0] ;
            Z304MprHabilitada = T00123_A304MprHabilitada[0] ;
            Z305MprTasa = T00123_A305MprTasa[0] ;
            Z1024MprEsParcial = T00123_A1024MprEsParcial[0] ;
            Z1071MprNoDetrae = T00123_A1071MprNoDetrae[0] ;
            Z1353MprHorasExtras = T00123_A1353MprHorasExtras[0] ;
         }
         else
         {
            Z684MprDescripSinAc = A684MprDescripSinAc ;
            Z303MprDescrip = A303MprDescrip ;
            Z304MprHabilitada = A304MprHabilitada ;
            Z305MprTasa = A305MprTasa ;
            Z1024MprEsParcial = A1024MprEsParcial ;
            Z1071MprNoDetrae = A1071MprNoDetrae ;
            Z1353MprHorasExtras = A1353MprHorasExtras ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z684MprDescripSinAc = A684MprDescripSinAc ;
         Z18MprCod = A18MprCod ;
         Z303MprDescrip = A303MprDescrip ;
         Z304MprHabilitada = A304MprHabilitada ;
         Z305MprTasa = A305MprTasa ;
         Z1024MprEsParcial = A1024MprEsParcial ;
         Z1071MprNoDetrae = A1071MprNoDetrae ;
         Z1353MprHorasExtras = A1353MprHorasExtras ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7MprCod)==0) )
      {
         A18MprCod = AV7MprCod ;
         n18MprCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
      }
      if ( ! (GXutil.strcmp("", AV7MprCod)==0) )
      {
         edtMprCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMprCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMprCod_Enabled), 5, 0), true);
      }
      else
      {
         edtMprCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMprCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMprCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7MprCod)==0) )
      {
         edtMprCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMprCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMprCod_Enabled), 5, 0), true);
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
         AV13Pgmname = "ModalidadAFIP" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      }
   }

   public void load1235( )
   {
      /* Using cursor T00124 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A684MprDescripSinAc = T00124_A684MprDescripSinAc[0] ;
         A303MprDescrip = T00124_A303MprDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A303MprDescrip", A303MprDescrip);
         A304MprHabilitada = T00124_A304MprHabilitada[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
         A305MprTasa = T00124_A305MprTasa[0] ;
         A1024MprEsParcial = T00124_A1024MprEsParcial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
         A1071MprNoDetrae = T00124_A1071MprNoDetrae[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
         A1353MprHorasExtras = T00124_A1353MprHorasExtras[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
         zm1235( -5) ;
      }
      pr_default.close(2);
      onLoadActions1235( ) ;
   }

   public void onLoadActions1235( )
   {
      AV13Pgmname = "ModalidadAFIP" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      GXt_char4 = A684MprDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A303MprDescrip, GXv_char5) ;
      modalidadafip_impl.this.GXt_char4 = GXv_char5[0] ;
      A684MprDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A684MprDescripSinAc", A684MprDescripSinAc);
   }

   public void checkExtendedTable1235( )
   {
      nIsDirty_35 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV13Pgmname = "ModalidadAFIP" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      nIsDirty_35 = (short)(1) ;
      GXt_char4 = A684MprDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A303MprDescrip, GXv_char5) ;
      modalidadafip_impl.this.GXt_char4 = GXv_char5[0] ;
      A684MprDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A684MprDescripSinAc", A684MprDescripSinAc);
   }

   public void closeExtendedTableCursors1235( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1235( )
   {
      /* Using cursor T00125 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound35 = (short)(1) ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00123 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1235( 5) ;
         RcdFound35 = (short)(1) ;
         A684MprDescripSinAc = T00123_A684MprDescripSinAc[0] ;
         A18MprCod = T00123_A18MprCod[0] ;
         n18MprCod = T00123_n18MprCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
         A303MprDescrip = T00123_A303MprDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A303MprDescrip", A303MprDescrip);
         A304MprHabilitada = T00123_A304MprHabilitada[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
         A305MprTasa = T00123_A305MprTasa[0] ;
         A1024MprEsParcial = T00123_A1024MprEsParcial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
         A1071MprNoDetrae = T00123_A1071MprNoDetrae[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
         A1353MprHorasExtras = T00123_A1353MprHorasExtras[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
         Z18MprCod = A18MprCod ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1235( ) ;
         if ( AnyError == 1 )
         {
            RcdFound35 = (short)(0) ;
            initializeNonKey1235( ) ;
         }
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound35 = (short)(0) ;
         initializeNonKey1235( ) ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1235( ) ;
      if ( RcdFound35 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound35 = (short)(0) ;
      /* Using cursor T00126 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00126_A18MprCod[0], A18MprCod) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00126_A18MprCod[0], A18MprCod) > 0 ) ) )
         {
            A18MprCod = T00126_A18MprCod[0] ;
            n18MprCod = T00126_n18MprCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound35 = (short)(0) ;
      /* Using cursor T00127 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00127_A18MprCod[0], A18MprCod) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00127_A18MprCod[0], A18MprCod) < 0 ) ) )
         {
            A18MprCod = T00127_A18MprCod[0] ;
            n18MprCod = T00127_n18MprCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1235( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMprCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1235( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound35 == 1 )
         {
            if ( GXutil.strcmp(A18MprCod, Z18MprCod) != 0 )
            {
               A18MprCod = Z18MprCod ;
               n18MprCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "MPRCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMprCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMprCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1235( ) ;
               GX_FocusControl = edtMprCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A18MprCod, Z18MprCod) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtMprCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1235( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "MPRCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtMprCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtMprCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1235( ) ;
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
      if ( GXutil.strcmp(A18MprCod, Z18MprCod) != 0 )
      {
         A18MprCod = Z18MprCod ;
         n18MprCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "MPRCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMprCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMprCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1235( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00122 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ModalidadAFIP"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z684MprDescripSinAc, T00122_A684MprDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z303MprDescrip, T00122_A303MprDescrip[0]) != 0 ) || ( Z304MprHabilitada != T00122_A304MprHabilitada[0] ) || ( DecimalUtil.compareTo(Z305MprTasa, T00122_A305MprTasa[0]) != 0 ) || ( Z1024MprEsParcial != T00122_A1024MprEsParcial[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1071MprNoDetrae != T00122_A1071MprNoDetrae[0] ) || ( Z1353MprHorasExtras != T00122_A1353MprHorasExtras[0] ) )
         {
            if ( GXutil.strcmp(Z684MprDescripSinAc, T00122_A684MprDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z684MprDescripSinAc);
               GXutil.writeLogRaw("Current: ",T00122_A684MprDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z303MprDescrip, T00122_A303MprDescrip[0]) != 0 )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprDescrip");
               GXutil.writeLogRaw("Old: ",Z303MprDescrip);
               GXutil.writeLogRaw("Current: ",T00122_A303MprDescrip[0]);
            }
            if ( Z304MprHabilitada != T00122_A304MprHabilitada[0] )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprHabilitada");
               GXutil.writeLogRaw("Old: ",Z304MprHabilitada);
               GXutil.writeLogRaw("Current: ",T00122_A304MprHabilitada[0]);
            }
            if ( DecimalUtil.compareTo(Z305MprTasa, T00122_A305MprTasa[0]) != 0 )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprTasa");
               GXutil.writeLogRaw("Old: ",Z305MprTasa);
               GXutil.writeLogRaw("Current: ",T00122_A305MprTasa[0]);
            }
            if ( Z1024MprEsParcial != T00122_A1024MprEsParcial[0] )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprEsParcial");
               GXutil.writeLogRaw("Old: ",Z1024MprEsParcial);
               GXutil.writeLogRaw("Current: ",T00122_A1024MprEsParcial[0]);
            }
            if ( Z1071MprNoDetrae != T00122_A1071MprNoDetrae[0] )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprNoDetrae");
               GXutil.writeLogRaw("Old: ",Z1071MprNoDetrae);
               GXutil.writeLogRaw("Current: ",T00122_A1071MprNoDetrae[0]);
            }
            if ( Z1353MprHorasExtras != T00122_A1353MprHorasExtras[0] )
            {
               GXutil.writeLogln("modalidadafip:[seudo value changed for attri]"+"MprHorasExtras");
               GXutil.writeLogRaw("Old: ",Z1353MprHorasExtras);
               GXutil.writeLogRaw("Current: ",T00122_A1353MprHorasExtras[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ModalidadAFIP"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1235( )
   {
      beforeValidate1235( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1235( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1235( 0) ;
         checkOptimisticConcurrency1235( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1235( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1235( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00128 */
                  pr_default.execute(6, new Object[] {A684MprDescripSinAc, Boolean.valueOf(n18MprCod), A18MprCod, A303MprDescrip, Boolean.valueOf(A304MprHabilitada), A305MprTasa, Boolean.valueOf(A1024MprEsParcial), Boolean.valueOf(A1071MprNoDetrae), Boolean.valueOf(A1353MprHorasExtras)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ModalidadAFIP");
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
                        resetCaption120( ) ;
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
            load1235( ) ;
         }
         endLevel1235( ) ;
      }
      closeExtendedTableCursors1235( ) ;
   }

   public void update1235( )
   {
      beforeValidate1235( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1235( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1235( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1235( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1235( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00129 */
                  pr_default.execute(7, new Object[] {A684MprDescripSinAc, A303MprDescrip, Boolean.valueOf(A304MprHabilitada), A305MprTasa, Boolean.valueOf(A1024MprEsParcial), Boolean.valueOf(A1071MprNoDetrae), Boolean.valueOf(A1353MprHorasExtras), Boolean.valueOf(n18MprCod), A18MprCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ModalidadAFIP");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ModalidadAFIP"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1235( ) ;
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
         endLevel1235( ) ;
      }
      closeExtendedTableCursors1235( ) ;
   }

   public void deferredUpdate1235( )
   {
   }

   public void delete( )
   {
      beforeValidate1235( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1235( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1235( ) ;
         afterConfirm1235( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1235( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001210 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ModalidadAFIP");
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
      sMode35 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1235( ) ;
      Gx_mode = sMode35 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1235( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "ModalidadAFIP" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001211 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel1235( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1235( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "modalidadafip");
         if ( AnyError == 0 )
         {
            confirmValues120( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "modalidadafip");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1235( )
   {
      /* Scan By routine */
      /* Using cursor T001212 */
      pr_default.execute(10);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A18MprCod = T001212_A18MprCod[0] ;
         n18MprCod = T001212_n18MprCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1235( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A18MprCod = T001212_A18MprCod[0] ;
         n18MprCod = T001212_n18MprCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
      }
   }

   public void scanEnd1235( )
   {
      pr_default.close(10);
   }

   public void afterConfirm1235( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1235( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1235( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1235( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1235( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1235( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1235( )
   {
      edtMprCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMprCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMprCod_Enabled), 5, 0), true);
      edtMprDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMprDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMprDescrip_Enabled), 5, 0), true);
      chkMprHabilitada.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMprHabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkMprHabilitada.getEnabled(), 5, 0), true);
      chkMprEsParcial.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMprEsParcial.getInternalname(), "Enabled", GXutil.ltrimstr( chkMprEsParcial.getEnabled(), 5, 0), true);
      chkMprNoDetrae.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMprNoDetrae.getInternalname(), "Enabled", GXutil.ltrimstr( chkMprNoDetrae.getEnabled(), 5, 0), true);
      chkMprHorasExtras.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMprHorasExtras.getInternalname(), "Enabled", GXutil.ltrimstr( chkMprHorasExtras.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1235( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues120( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.modalidadafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7MprCod))}, new String[] {"Gx_mode","MprCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ModalidadAFIP");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MprTasa", localUtil.format( A305MprTasa, "ZZ9.99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("modalidadafip:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z18MprCod", GXutil.rtrim( Z18MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z684MprDescripSinAc", Z684MprDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z303MprDescrip", Z303MprDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z304MprHabilitada", Z304MprHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, "Z305MprTasa", GXutil.ltrim( localUtil.ntoc( Z305MprTasa, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1024MprEsParcial", Z1024MprEsParcial);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1071MprNoDetrae", Z1071MprNoDetrae);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1353MprHorasExtras", Z1353MprHorasExtras);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "MPRDESCRIPSINAC", A684MprDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vMPRCOD", GXutil.rtrim( AV7MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMPRCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7MprCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "MPRTASA", GXutil.ltrim( localUtil.ntoc( A305MprTasa, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV13Pgmname));
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
      return formatLink("web.modalidadafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7MprCod))}, new String[] {"Gx_mode","MprCod"})  ;
   }

   public String getPgmname( )
   {
      return "ModalidadAFIP" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Modalidad AFIP", "") ;
   }

   public void initializeNonKey1235( )
   {
      A684MprDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A684MprDescripSinAc", A684MprDescripSinAc);
      A303MprDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A303MprDescrip", A303MprDescrip);
      A304MprHabilitada = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
      A305MprTasa = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A305MprTasa", GXutil.ltrimstr( A305MprTasa, 6, 2));
      A1024MprEsParcial = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
      A1071MprNoDetrae = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
      A1353MprHorasExtras = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
      Z684MprDescripSinAc = "" ;
      Z303MprDescrip = "" ;
      Z304MprHabilitada = false ;
      Z305MprTasa = DecimalUtil.ZERO ;
      Z1024MprEsParcial = false ;
      Z1071MprNoDetrae = false ;
      Z1353MprHorasExtras = false ;
   }

   public void initAll1235( )
   {
      A18MprCod = "" ;
      n18MprCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A18MprCod", A18MprCod);
      initializeNonKey1235( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713544467", true, true);
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
      httpContext.AddJavascriptSource("modalidadafip.js", "?20251713544468", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtMprCod_Internalname = "MPRCOD" ;
      edtMprDescrip_Internalname = "MPRDESCRIP" ;
      chkMprHabilitada.setInternalname( "MPRHABILITADA" );
      chkMprEsParcial.setInternalname( "MPRESPARCIAL" );
      chkMprNoDetrae.setInternalname( "MPRNODETRAE" );
      chkMprHorasExtras.setInternalname( "MPRHORASEXTRAS" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Modalidad AFIP", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkMprHorasExtras.setEnabled( 1 );
      chkMprNoDetrae.setEnabled( 1 );
      chkMprEsParcial.setEnabled( 1 );
      chkMprHabilitada.setEnabled( 1 );
      edtMprDescrip_Enabled = 1 ;
      edtMprCod_Jsonclick = "" ;
      edtMprCod_Enabled = 1 ;
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

   public void gx1asamprdescripsinac1235( String A303MprDescrip )
   {
      GXt_char4 = A684MprDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A303MprDescrip, GXv_char5) ;
      modalidadafip_impl.this.GXt_char4 = GXv_char5[0] ;
      A684MprDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A684MprDescripSinAc", A684MprDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A684MprDescripSinAc)+"\"") ;
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
      chkMprHabilitada.setName( "MPRHABILITADA" );
      chkMprHabilitada.setWebtags( "" );
      chkMprHabilitada.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMprHabilitada.getInternalname(), "TitleCaption", chkMprHabilitada.getCaption(), true);
      chkMprHabilitada.setCheckedValue( "false" );
      A304MprHabilitada = GXutil.strtobool( GXutil.booltostr( A304MprHabilitada)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A304MprHabilitada", A304MprHabilitada);
      chkMprEsParcial.setName( "MPRESPARCIAL" );
      chkMprEsParcial.setWebtags( "" );
      chkMprEsParcial.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMprEsParcial.getInternalname(), "TitleCaption", chkMprEsParcial.getCaption(), true);
      chkMprEsParcial.setCheckedValue( "false" );
      A1024MprEsParcial = GXutil.strtobool( GXutil.booltostr( A1024MprEsParcial)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1024MprEsParcial", A1024MprEsParcial);
      chkMprNoDetrae.setName( "MPRNODETRAE" );
      chkMprNoDetrae.setWebtags( "" );
      chkMprNoDetrae.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMprNoDetrae.getInternalname(), "TitleCaption", chkMprNoDetrae.getCaption(), true);
      chkMprNoDetrae.setCheckedValue( "false" );
      A1071MprNoDetrae = GXutil.strtobool( GXutil.booltostr( A1071MprNoDetrae)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1071MprNoDetrae", A1071MprNoDetrae);
      chkMprHorasExtras.setName( "MPRHORASEXTRAS" );
      chkMprHorasExtras.setWebtags( "" );
      chkMprHorasExtras.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMprHorasExtras.getInternalname(), "TitleCaption", chkMprHorasExtras.getCaption(), true);
      chkMprHorasExtras.setCheckedValue( "false" );
      A1353MprHorasExtras = GXutil.strtobool( GXutil.booltostr( A1353MprHorasExtras)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1353MprHorasExtras", A1353MprHorasExtras);
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

   public void valid_Mprdescrip( )
   {
      GXt_char4 = A684MprDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A303MprDescrip, GXv_char5) ;
      modalidadafip_impl.this.GXt_char4 = GXv_char5[0] ;
      A684MprDescripSinAc = GXt_char4 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A684MprDescripSinAc", A684MprDescripSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7MprCod',fld:'vMPRCOD',pic:'',hsh:true},{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7MprCod',fld:'vMPRCOD',pic:'',hsh:true},{av:'A305MprTasa',fld:'MPRTASA',pic:'ZZ9.99'},{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12122',iparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]}");
      setEventMetadata("VALID_MPRCOD","{handler:'valid_Mprcod',iparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]");
      setEventMetadata("VALID_MPRCOD",",oparms:[{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]}");
      setEventMetadata("VALID_MPRDESCRIP","{handler:'valid_Mprdescrip',iparms:[{av:'A303MprDescrip',fld:'MPRDESCRIP',pic:''},{av:'A684MprDescripSinAc',fld:'MPRDESCRIPSINAC',pic:''},{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]");
      setEventMetadata("VALID_MPRDESCRIP",",oparms:[{av:'A684MprDescripSinAc',fld:'MPRDESCRIPSINAC',pic:''},{av:'A304MprHabilitada',fld:'MPRHABILITADA',pic:''},{av:'A1024MprEsParcial',fld:'MPRESPARCIAL',pic:''},{av:'A1071MprNoDetrae',fld:'MPRNODETRAE',pic:''},{av:'A1353MprHorasExtras',fld:'MPRHORASEXTRAS',pic:''}]}");
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
      return "modalidadpromovida_Execute";
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
      wcpOAV7MprCod = "" ;
      Z18MprCod = "" ;
      Z684MprDescripSinAc = "" ;
      Z303MprDescrip = "" ;
      Z305MprTasa = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A303MprDescrip = "" ;
      Gx_mode = "" ;
      AV7MprCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A18MprCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A684MprDescripSinAc = "" ;
      A305MprTasa = DecimalUtil.ZERO ;
      AV13Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode35 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      T00124_A684MprDescripSinAc = new String[] {""} ;
      T00124_A18MprCod = new String[] {""} ;
      T00124_n18MprCod = new boolean[] {false} ;
      T00124_A303MprDescrip = new String[] {""} ;
      T00124_A304MprHabilitada = new boolean[] {false} ;
      T00124_A305MprTasa = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00124_A1024MprEsParcial = new boolean[] {false} ;
      T00124_A1071MprNoDetrae = new boolean[] {false} ;
      T00124_A1353MprHorasExtras = new boolean[] {false} ;
      T00125_A18MprCod = new String[] {""} ;
      T00125_n18MprCod = new boolean[] {false} ;
      T00123_A684MprDescripSinAc = new String[] {""} ;
      T00123_A18MprCod = new String[] {""} ;
      T00123_n18MprCod = new boolean[] {false} ;
      T00123_A303MprDescrip = new String[] {""} ;
      T00123_A304MprHabilitada = new boolean[] {false} ;
      T00123_A305MprTasa = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00123_A1024MprEsParcial = new boolean[] {false} ;
      T00123_A1071MprNoDetrae = new boolean[] {false} ;
      T00123_A1353MprHorasExtras = new boolean[] {false} ;
      T00126_A18MprCod = new String[] {""} ;
      T00126_n18MprCod = new boolean[] {false} ;
      T00127_A18MprCod = new String[] {""} ;
      T00127_n18MprCod = new boolean[] {false} ;
      T00122_A684MprDescripSinAc = new String[] {""} ;
      T00122_A18MprCod = new String[] {""} ;
      T00122_n18MprCod = new boolean[] {false} ;
      T00122_A303MprDescrip = new String[] {""} ;
      T00122_A304MprHabilitada = new boolean[] {false} ;
      T00122_A305MprTasa = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00122_A1024MprEsParcial = new boolean[] {false} ;
      T00122_A1071MprNoDetrae = new boolean[] {false} ;
      T00122_A1353MprHorasExtras = new boolean[] {false} ;
      T001211_A3CliCod = new int[1] ;
      T001211_A1EmpCod = new short[1] ;
      T001211_A6LegNumero = new int[1] ;
      T001212_A18MprCod = new String[] {""} ;
      T001212_n18MprCod = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.modalidadafip__default(),
         new Object[] {
             new Object[] {
            T00122_A684MprDescripSinAc, T00122_A18MprCod, T00122_A303MprDescrip, T00122_A304MprHabilitada, T00122_A305MprTasa, T00122_A1024MprEsParcial, T00122_A1071MprNoDetrae, T00122_A1353MprHorasExtras
            }
            , new Object[] {
            T00123_A684MprDescripSinAc, T00123_A18MprCod, T00123_A303MprDescrip, T00123_A304MprHabilitada, T00123_A305MprTasa, T00123_A1024MprEsParcial, T00123_A1071MprNoDetrae, T00123_A1353MprHorasExtras
            }
            , new Object[] {
            T00124_A684MprDescripSinAc, T00124_A18MprCod, T00124_A303MprDescrip, T00124_A304MprHabilitada, T00124_A305MprTasa, T00124_A1024MprEsParcial, T00124_A1071MprNoDetrae, T00124_A1353MprHorasExtras
            }
            , new Object[] {
            T00125_A18MprCod
            }
            , new Object[] {
            T00126_A18MprCod
            }
            , new Object[] {
            T00127_A18MprCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001211_A3CliCod, T001211_A1EmpCod, T001211_A6LegNumero
            }
            , new Object[] {
            T001212_A18MprCod
            }
         }
      );
      AV13Pgmname = "ModalidadAFIP" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound35 ;
   private short nIsDirty_35 ;
   private int trnEnded ;
   private int edtMprCod_Enabled ;
   private int edtMprDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z305MprTasa ;
   private java.math.BigDecimal A305MprTasa ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7MprCod ;
   private String Z18MprCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7MprCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMprCod_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A18MprCod ;
   private String edtMprCod_Jsonclick ;
   private String edtMprDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV13Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode35 ;
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
   private boolean Z304MprHabilitada ;
   private boolean Z1024MprEsParcial ;
   private boolean Z1071MprNoDetrae ;
   private boolean Z1353MprHorasExtras ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A304MprHabilitada ;
   private boolean A1024MprEsParcial ;
   private boolean A1071MprNoDetrae ;
   private boolean A1353MprHorasExtras ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n18MprCod ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String Z684MprDescripSinAc ;
   private String Z303MprDescrip ;
   private String A303MprDescrip ;
   private String A684MprDescripSinAc ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkMprHabilitada ;
   private ICheckbox chkMprEsParcial ;
   private ICheckbox chkMprNoDetrae ;
   private ICheckbox chkMprHorasExtras ;
   private IDataStoreProvider pr_default ;
   private String[] T00124_A684MprDescripSinAc ;
   private String[] T00124_A18MprCod ;
   private boolean[] T00124_n18MprCod ;
   private String[] T00124_A303MprDescrip ;
   private boolean[] T00124_A304MprHabilitada ;
   private java.math.BigDecimal[] T00124_A305MprTasa ;
   private boolean[] T00124_A1024MprEsParcial ;
   private boolean[] T00124_A1071MprNoDetrae ;
   private boolean[] T00124_A1353MprHorasExtras ;
   private String[] T00125_A18MprCod ;
   private boolean[] T00125_n18MprCod ;
   private String[] T00123_A684MprDescripSinAc ;
   private String[] T00123_A18MprCod ;
   private boolean[] T00123_n18MprCod ;
   private String[] T00123_A303MprDescrip ;
   private boolean[] T00123_A304MprHabilitada ;
   private java.math.BigDecimal[] T00123_A305MprTasa ;
   private boolean[] T00123_A1024MprEsParcial ;
   private boolean[] T00123_A1071MprNoDetrae ;
   private boolean[] T00123_A1353MprHorasExtras ;
   private String[] T00126_A18MprCod ;
   private boolean[] T00126_n18MprCod ;
   private String[] T00127_A18MprCod ;
   private boolean[] T00127_n18MprCod ;
   private String[] T00122_A684MprDescripSinAc ;
   private String[] T00122_A18MprCod ;
   private boolean[] T00122_n18MprCod ;
   private String[] T00122_A303MprDescrip ;
   private boolean[] T00122_A304MprHabilitada ;
   private java.math.BigDecimal[] T00122_A305MprTasa ;
   private boolean[] T00122_A1024MprEsParcial ;
   private boolean[] T00122_A1071MprNoDetrae ;
   private boolean[] T00122_A1353MprHorasExtras ;
   private int[] T001211_A3CliCod ;
   private short[] T001211_A1EmpCod ;
   private int[] T001211_A6LegNumero ;
   private String[] T001212_A18MprCod ;
   private boolean[] T001212_n18MprCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class modalidadafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00122", "SELECT MprDescripSinAc, MprCod, MprDescrip, MprHabilitada, MprTasa, MprEsParcial, MprNoDetrae, MprHorasExtras FROM ModalidadAFIP WHERE MprCod = ?  FOR UPDATE OF ModalidadAFIP NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00123", "SELECT MprDescripSinAc, MprCod, MprDescrip, MprHabilitada, MprTasa, MprEsParcial, MprNoDetrae, MprHorasExtras FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00124", "SELECT TM1.MprDescripSinAc, TM1.MprCod, TM1.MprDescrip, TM1.MprHabilitada, TM1.MprTasa, TM1.MprEsParcial, TM1.MprNoDetrae, TM1.MprHorasExtras FROM ModalidadAFIP TM1 WHERE TM1.MprCod = ( ?) ORDER BY TM1.MprCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00125", "SELECT MprCod FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00126", "SELECT MprCod FROM ModalidadAFIP WHERE ( MprCod > ( ?)) ORDER BY MprCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00127", "SELECT MprCod FROM ModalidadAFIP WHERE ( MprCod < ( ?)) ORDER BY MprCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00128", "SAVEPOINT gxupdate;INSERT INTO ModalidadAFIP(MprDescripSinAc, MprCod, MprDescrip, MprHabilitada, MprTasa, MprEsParcial, MprNoDetrae, MprHorasExtras) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T00129", "SAVEPOINT gxupdate;UPDATE ModalidadAFIP SET MprDescripSinAc=?, MprDescrip=?, MprHabilitada=?, MprTasa=?, MprEsParcial=?, MprNoDetrae=?, MprHorasExtras=?  WHERE MprCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001210", "SAVEPOINT gxupdate;DELETE FROM ModalidadAFIP  WHERE MprCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001211", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE MprCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001212", "SELECT MprCod FROM ModalidadAFIP ORDER BY MprCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 10 :
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
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
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
      }
   }

}

