package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class afipconcepto_impl extends GXDataArea
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
            AV7AFIPConCod = httpContext.GetPar( "AFIPConCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7AFIPConCod", AV7AFIPConCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAFIPCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7AFIPConCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "AFIPConcepto", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtAFIPConCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public afipconcepto_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public afipconcepto_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( afipconcepto_impl.class ));
   }

   public afipconcepto_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbAfipConTipoConCod = new HTMLChoice();
      chkAFIPConLiqAgil = UIFactory.getCheckbox(this);
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
      if ( cmbAfipConTipoConCod.getItemCount() > 0 )
      {
         A387AfipConTipoConCod = cmbAfipConTipoConCod.getValidValue(A387AfipConTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAfipConTipoConCod.setValue( GXutil.rtrim( A387AfipConTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAfipConTipoConCod.getInternalname(), "Values", cmbAfipConTipoConCod.ToJavascriptSource(), true);
      }
      A1646AFIPConLiqAgil = GXutil.strtobool( GXutil.booltostr( A1646AFIPConLiqAgil)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAFIPConCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAFIPConCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAFIPConCod_Internalname, GXutil.rtrim( A72AFIPConCod), GXutil.rtrim( localUtil.format( A72AFIPConCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAFIPConCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAFIPConCod_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAFIPConDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAFIPConDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtAFIPConDescrip_Internalname, A369AFIPConDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtAFIPConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAfipConTipoConCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbAfipConTipoConCod.getInternalname(), httpContext.getMessage( "Con Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAfipConTipoConCod, cmbAfipConTipoConCod.getInternalname(), GXutil.rtrim( A387AfipConTipoConCod), 1, cmbAfipConTipoConCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbAfipConTipoConCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_AFIPConcepto.htm");
      cmbAfipConTipoConCod.setValue( GXutil.rtrim( A387AfipConTipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAfipConTipoConCod.getInternalname(), "Values", cmbAfipConTipoConCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAfipConSubTipoConCod1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAfipConSubTipoConCod1_Internalname, httpContext.getMessage( "Con Cod1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAfipConSubTipoConCod1_Internalname, GXutil.rtrim( A388AfipConSubTipoConCod1), GXutil.rtrim( localUtil.format( A388AfipConSubTipoConCod1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAfipConSubTipoConCod1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAfipConSubTipoConCod1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAfipConCodMasDesc_Internalname+"\"", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtAfipConCodMasDesc_Internalname, A385AfipConCodMasDesc, "", "", (short)(0), 1, edtAfipConCodMasDesc_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkAFIPConLiqAgil.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkAFIPConLiqAgil.getInternalname(), httpContext.getMessage( "Compatible con liquidacion agil", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkAFIPConLiqAgil.getInternalname(), GXutil.booltostr( A1646AFIPConLiqAgil), "", httpContext.getMessage( "Compatible con liquidacion agil", ""), 1, chkAFIPConLiqAgil.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AFIPConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AFIPConcepto.htm");
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
      e111Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z72AFIPConCod = httpContext.cgiGet( "Z72AFIPConCod") ;
            Z385AfipConCodMasDesc = httpContext.cgiGet( "Z385AfipConCodMasDesc") ;
            Z369AFIPConDescrip = httpContext.cgiGet( "Z369AFIPConDescrip") ;
            Z387AfipConTipoConCod = httpContext.cgiGet( "Z387AfipConTipoConCod") ;
            Z388AfipConSubTipoConCod1 = httpContext.cgiGet( "Z388AfipConSubTipoConCod1") ;
            Z1646AFIPConLiqAgil = GXutil.strtobool( httpContext.cgiGet( "Z1646AFIPConLiqAgil")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7AFIPConCod = httpContext.cgiGet( "vAFIPCONCOD") ;
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
            A72AFIPConCod = httpContext.cgiGet( edtAFIPConCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
            A369AFIPConDescrip = httpContext.cgiGet( edtAFIPConDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A369AFIPConDescrip", A369AFIPConDescrip);
            cmbAfipConTipoConCod.setValue( httpContext.cgiGet( cmbAfipConTipoConCod.getInternalname()) );
            A387AfipConTipoConCod = httpContext.cgiGet( cmbAfipConTipoConCod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
            A388AfipConSubTipoConCod1 = httpContext.cgiGet( edtAfipConSubTipoConCod1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A388AfipConSubTipoConCod1", A388AfipConSubTipoConCod1);
            A385AfipConCodMasDesc = httpContext.cgiGet( edtAfipConCodMasDesc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
            A1646AFIPConLiqAgil = GXutil.strtobool( httpContext.cgiGet( chkAFIPConLiqAgil.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"AFIPConcepto");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A72AFIPConCod, Z72AFIPConCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("afipconcepto:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A72AFIPConCod = httpContext.GetPar( "AFIPConCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
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
                  sMode58 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode58 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound58 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1Q0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "AFIPCONCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAFIPConCod_Internalname ;
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
                        e111Q2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121Q2 ();
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
         e121Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1Q58( ) ;
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
         disableAttributes1Q58( ) ;
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

   public void confirm_1Q0( )
   {
      beforeValidate1Q58( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1Q58( ) ;
         }
         else
         {
            checkExtendedTable1Q58( ) ;
            closeExtendedTableCursors1Q58( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1Q0( )
   {
   }

   public void e111Q2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAFIPConcepto_Insert", GXv_boolean3) ;
         afipconcepto_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAFIPConcepto_Update", GXv_boolean3) ;
         afipconcepto_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAFIPConcepto_Delete", GXv_boolean3) ;
         afipconcepto_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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

   public void e121Q2( )
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

   public void zm1Q58( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z385AfipConCodMasDesc = T001Q3_A385AfipConCodMasDesc[0] ;
            Z369AFIPConDescrip = T001Q3_A369AFIPConDescrip[0] ;
            Z387AfipConTipoConCod = T001Q3_A387AfipConTipoConCod[0] ;
            Z388AfipConSubTipoConCod1 = T001Q3_A388AfipConSubTipoConCod1[0] ;
            Z1646AFIPConLiqAgil = T001Q3_A1646AFIPConLiqAgil[0] ;
         }
         else
         {
            Z385AfipConCodMasDesc = A385AfipConCodMasDesc ;
            Z369AFIPConDescrip = A369AFIPConDescrip ;
            Z387AfipConTipoConCod = A387AfipConTipoConCod ;
            Z388AfipConSubTipoConCod1 = A388AfipConSubTipoConCod1 ;
            Z1646AFIPConLiqAgil = A1646AFIPConLiqAgil ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z385AfipConCodMasDesc = A385AfipConCodMasDesc ;
         Z72AFIPConCod = A72AFIPConCod ;
         Z369AFIPConDescrip = A369AFIPConDescrip ;
         Z387AfipConTipoConCod = A387AfipConTipoConCod ;
         Z388AfipConSubTipoConCod1 = A388AfipConSubTipoConCod1 ;
         Z1646AFIPConLiqAgil = A1646AFIPConLiqAgil ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7AFIPConCod)==0) )
      {
         A72AFIPConCod = AV7AFIPConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
      }
      if ( ! (GXutil.strcmp("", AV7AFIPConCod)==0) )
      {
         edtAFIPConCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAFIPConCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAFIPConCod_Enabled), 5, 0), true);
      }
      else
      {
         edtAFIPConCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAFIPConCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAFIPConCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7AFIPConCod)==0) )
      {
         edtAFIPConCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAFIPConCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAFIPConCod_Enabled), 5, 0), true);
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
         AV13Pgmname = "AFIPConcepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      }
   }

   public void load1Q58( )
   {
      /* Using cursor T001Q4 */
      pr_default.execute(2, new Object[] {A72AFIPConCod});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound58 = (short)(1) ;
         A385AfipConCodMasDesc = T001Q4_A385AfipConCodMasDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
         A369AFIPConDescrip = T001Q4_A369AFIPConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A369AFIPConDescrip", A369AFIPConDescrip);
         A387AfipConTipoConCod = T001Q4_A387AfipConTipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
         A388AfipConSubTipoConCod1 = T001Q4_A388AfipConSubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A388AfipConSubTipoConCod1", A388AfipConSubTipoConCod1);
         A1646AFIPConLiqAgil = T001Q4_A1646AFIPConLiqAgil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
         zm1Q58( -6) ;
      }
      pr_default.close(2);
      onLoadActions1Q58( ) ;
   }

   public void onLoadActions1Q58( )
   {
      AV13Pgmname = "AFIPConcepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      A385AfipConCodMasDesc = GXutil.trim( A72AFIPConCod) + " - " + GXutil.trim( A369AFIPConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
   }

   public void checkExtendedTable1Q58( )
   {
      nIsDirty_58 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV13Pgmname = "AFIPConcepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      nIsDirty_58 = (short)(1) ;
      A385AfipConCodMasDesc = GXutil.trim( A72AFIPConCod) + " - " + GXutil.trim( A369AFIPConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
      if ( ! ( ( GXutil.strcmp(A387AfipConTipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A387AfipConTipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A387AfipConTipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A387AfipConTipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Afip Con Tipo Con Cod", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "AFIPCONTIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAfipConTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1Q58( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1Q58( )
   {
      /* Using cursor T001Q5 */
      pr_default.execute(3, new Object[] {A72AFIPConCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound58 = (short)(1) ;
      }
      else
      {
         RcdFound58 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001Q3 */
      pr_default.execute(1, new Object[] {A72AFIPConCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1Q58( 6) ;
         RcdFound58 = (short)(1) ;
         A385AfipConCodMasDesc = T001Q3_A385AfipConCodMasDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
         A72AFIPConCod = T001Q3_A72AFIPConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
         A369AFIPConDescrip = T001Q3_A369AFIPConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A369AFIPConDescrip", A369AFIPConDescrip);
         A387AfipConTipoConCod = T001Q3_A387AfipConTipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
         A388AfipConSubTipoConCod1 = T001Q3_A388AfipConSubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A388AfipConSubTipoConCod1", A388AfipConSubTipoConCod1);
         A1646AFIPConLiqAgil = T001Q3_A1646AFIPConLiqAgil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
         Z72AFIPConCod = A72AFIPConCod ;
         sMode58 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1Q58( ) ;
         if ( AnyError == 1 )
         {
            RcdFound58 = (short)(0) ;
            initializeNonKey1Q58( ) ;
         }
         Gx_mode = sMode58 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound58 = (short)(0) ;
         initializeNonKey1Q58( ) ;
         sMode58 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode58 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1Q58( ) ;
      if ( RcdFound58 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound58 = (short)(0) ;
      /* Using cursor T001Q6 */
      pr_default.execute(4, new Object[] {A72AFIPConCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001Q6_A72AFIPConCod[0], A72AFIPConCod) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T001Q6_A72AFIPConCod[0], A72AFIPConCod) > 0 ) ) )
         {
            A72AFIPConCod = T001Q6_A72AFIPConCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
            RcdFound58 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound58 = (short)(0) ;
      /* Using cursor T001Q7 */
      pr_default.execute(5, new Object[] {A72AFIPConCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001Q7_A72AFIPConCod[0], A72AFIPConCod) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T001Q7_A72AFIPConCod[0], A72AFIPConCod) < 0 ) ) )
         {
            A72AFIPConCod = T001Q7_A72AFIPConCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
            RcdFound58 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1Q58( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtAFIPConCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1Q58( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound58 == 1 )
         {
            if ( GXutil.strcmp(A72AFIPConCod, Z72AFIPConCod) != 0 )
            {
               A72AFIPConCod = Z72AFIPConCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "AFIPCONCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAFIPConCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtAFIPConCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1Q58( ) ;
               GX_FocusControl = edtAFIPConCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A72AFIPConCod, Z72AFIPConCod) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtAFIPConCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1Q58( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "AFIPCONCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtAFIPConCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtAFIPConCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1Q58( ) ;
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
      if ( GXutil.strcmp(A72AFIPConCod, Z72AFIPConCod) != 0 )
      {
         A72AFIPConCod = Z72AFIPConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "AFIPCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAFIPConCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtAFIPConCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1Q58( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001Q2 */
         pr_default.execute(0, new Object[] {A72AFIPConCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AFIPConcepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z385AfipConCodMasDesc, T001Q2_A385AfipConCodMasDesc[0]) != 0 ) || ( GXutil.strcmp(Z369AFIPConDescrip, T001Q2_A369AFIPConDescrip[0]) != 0 ) || ( GXutil.strcmp(Z387AfipConTipoConCod, T001Q2_A387AfipConTipoConCod[0]) != 0 ) || ( GXutil.strcmp(Z388AfipConSubTipoConCod1, T001Q2_A388AfipConSubTipoConCod1[0]) != 0 ) || ( Z1646AFIPConLiqAgil != T001Q2_A1646AFIPConLiqAgil[0] ) )
         {
            if ( GXutil.strcmp(Z385AfipConCodMasDesc, T001Q2_A385AfipConCodMasDesc[0]) != 0 )
            {
               GXutil.writeLogln("afipconcepto:[seudo value changed for attri]"+"AfipConCodMasDesc");
               GXutil.writeLogRaw("Old: ",Z385AfipConCodMasDesc);
               GXutil.writeLogRaw("Current: ",T001Q2_A385AfipConCodMasDesc[0]);
            }
            if ( GXutil.strcmp(Z369AFIPConDescrip, T001Q2_A369AFIPConDescrip[0]) != 0 )
            {
               GXutil.writeLogln("afipconcepto:[seudo value changed for attri]"+"AFIPConDescrip");
               GXutil.writeLogRaw("Old: ",Z369AFIPConDescrip);
               GXutil.writeLogRaw("Current: ",T001Q2_A369AFIPConDescrip[0]);
            }
            if ( GXutil.strcmp(Z387AfipConTipoConCod, T001Q2_A387AfipConTipoConCod[0]) != 0 )
            {
               GXutil.writeLogln("afipconcepto:[seudo value changed for attri]"+"AfipConTipoConCod");
               GXutil.writeLogRaw("Old: ",Z387AfipConTipoConCod);
               GXutil.writeLogRaw("Current: ",T001Q2_A387AfipConTipoConCod[0]);
            }
            if ( GXutil.strcmp(Z388AfipConSubTipoConCod1, T001Q2_A388AfipConSubTipoConCod1[0]) != 0 )
            {
               GXutil.writeLogln("afipconcepto:[seudo value changed for attri]"+"AfipConSubTipoConCod1");
               GXutil.writeLogRaw("Old: ",Z388AfipConSubTipoConCod1);
               GXutil.writeLogRaw("Current: ",T001Q2_A388AfipConSubTipoConCod1[0]);
            }
            if ( Z1646AFIPConLiqAgil != T001Q2_A1646AFIPConLiqAgil[0] )
            {
               GXutil.writeLogln("afipconcepto:[seudo value changed for attri]"+"AFIPConLiqAgil");
               GXutil.writeLogRaw("Old: ",Z1646AFIPConLiqAgil);
               GXutil.writeLogRaw("Current: ",T001Q2_A1646AFIPConLiqAgil[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"AFIPConcepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1Q58( )
   {
      beforeValidate1Q58( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1Q58( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1Q58( 0) ;
         checkOptimisticConcurrency1Q58( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1Q58( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1Q58( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001Q8 */
                  pr_default.execute(6, new Object[] {A385AfipConCodMasDesc, A72AFIPConCod, A369AFIPConDescrip, A387AfipConTipoConCod, A388AfipConSubTipoConCod1, Boolean.valueOf(A1646AFIPConLiqAgil)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AFIPConcepto");
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
                        resetCaption1Q0( ) ;
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
            load1Q58( ) ;
         }
         endLevel1Q58( ) ;
      }
      closeExtendedTableCursors1Q58( ) ;
   }

   public void update1Q58( )
   {
      beforeValidate1Q58( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1Q58( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1Q58( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1Q58( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1Q58( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001Q9 */
                  pr_default.execute(7, new Object[] {A385AfipConCodMasDesc, A369AFIPConDescrip, A387AfipConTipoConCod, A388AfipConSubTipoConCod1, Boolean.valueOf(A1646AFIPConLiqAgil), A72AFIPConCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AFIPConcepto");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AFIPConcepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1Q58( ) ;
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
         endLevel1Q58( ) ;
      }
      closeExtendedTableCursors1Q58( ) ;
   }

   public void deferredUpdate1Q58( )
   {
   }

   public void delete( )
   {
      beforeValidate1Q58( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1Q58( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1Q58( ) ;
         afterConfirm1Q58( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1Q58( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001Q10 */
               pr_default.execute(8, new Object[] {A72AFIPConCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("AFIPConcepto");
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
      sMode58 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1Q58( ) ;
      Gx_mode = sMode58 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1Q58( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "AFIPConcepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      }
   }

   public void endLevel1Q58( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1Q58( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "afipconcepto");
         if ( AnyError == 0 )
         {
            confirmValues1Q0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "afipconcepto");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1Q58( )
   {
      /* Scan By routine */
      /* Using cursor T001Q11 */
      pr_default.execute(9);
      RcdFound58 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound58 = (short)(1) ;
         A72AFIPConCod = T001Q11_A72AFIPConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1Q58( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound58 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound58 = (short)(1) ;
         A72AFIPConCod = T001Q11_A72AFIPConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
      }
   }

   public void scanEnd1Q58( )
   {
      pr_default.close(9);
   }

   public void afterConfirm1Q58( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1Q58( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1Q58( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1Q58( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1Q58( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1Q58( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1Q58( )
   {
      edtAFIPConCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAFIPConCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAFIPConCod_Enabled), 5, 0), true);
      edtAFIPConDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAFIPConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAFIPConDescrip_Enabled), 5, 0), true);
      cmbAfipConTipoConCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAfipConTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAfipConTipoConCod.getEnabled(), 5, 0), true);
      edtAfipConSubTipoConCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAfipConSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAfipConSubTipoConCod1_Enabled), 5, 0), true);
      edtAfipConCodMasDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAfipConCodMasDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAfipConCodMasDesc_Enabled), 5, 0), true);
      chkAFIPConLiqAgil.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkAFIPConLiqAgil.getInternalname(), "Enabled", GXutil.ltrimstr( chkAFIPConLiqAgil.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1Q58( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1Q0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.afipconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7AFIPConCod))}, new String[] {"Gx_mode","AFIPConCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"AFIPConcepto");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("afipconcepto:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z72AFIPConCod", GXutil.rtrim( Z72AFIPConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z385AfipConCodMasDesc", Z385AfipConCodMasDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z369AFIPConDescrip", Z369AFIPConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z387AfipConTipoConCod", GXutil.rtrim( Z387AfipConTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z388AfipConSubTipoConCod1", GXutil.rtrim( Z388AfipConSubTipoConCod1));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1646AFIPConLiqAgil", Z1646AFIPConLiqAgil);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vAFIPCONCOD", GXutil.rtrim( AV7AFIPConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAFIPCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7AFIPConCod, ""))));
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
      return formatLink("web.afipconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7AFIPConCod))}, new String[] {"Gx_mode","AFIPConCod"})  ;
   }

   public String getPgmname( )
   {
      return "AFIPConcepto" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "AFIPConcepto", "") ;
   }

   public void initializeNonKey1Q58( )
   {
      A385AfipConCodMasDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A385AfipConCodMasDesc", A385AfipConCodMasDesc);
      A369AFIPConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A369AFIPConDescrip", A369AFIPConDescrip);
      A387AfipConTipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
      A388AfipConSubTipoConCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A388AfipConSubTipoConCod1", A388AfipConSubTipoConCod1);
      A1646AFIPConLiqAgil = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
      Z385AfipConCodMasDesc = "" ;
      Z369AFIPConDescrip = "" ;
      Z387AfipConTipoConCod = "" ;
      Z388AfipConSubTipoConCod1 = "" ;
      Z1646AFIPConLiqAgil = false ;
   }

   public void initAll1Q58( )
   {
      A72AFIPConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A72AFIPConCod", A72AFIPConCod);
      initializeNonKey1Q58( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201940181", true, true);
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
      httpContext.AddJavascriptSource("afipconcepto.js", "?202412201940181", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtAFIPConCod_Internalname = "AFIPCONCOD" ;
      edtAFIPConDescrip_Internalname = "AFIPCONDESCRIP" ;
      cmbAfipConTipoConCod.setInternalname( "AFIPCONTIPOCONCOD" );
      edtAfipConSubTipoConCod1_Internalname = "AFIPCONSUBTIPOCONCOD1" ;
      edtAfipConCodMasDesc_Internalname = "AFIPCONCODMASDESC" ;
      chkAFIPConLiqAgil.setInternalname( "AFIPCONLIQAGIL" );
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
      Form.setCaption( httpContext.getMessage( "AFIPConcepto", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkAFIPConLiqAgil.setEnabled( 1 );
      edtAfipConCodMasDesc_Enabled = 0 ;
      edtAfipConSubTipoConCod1_Jsonclick = "" ;
      edtAfipConSubTipoConCod1_Enabled = 1 ;
      cmbAfipConTipoConCod.setJsonclick( "" );
      cmbAfipConTipoConCod.setEnabled( 1 );
      edtAFIPConDescrip_Enabled = 1 ;
      edtAFIPConCod_Jsonclick = "" ;
      edtAFIPConCod_Enabled = 1 ;
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

   public void init_web_controls( )
   {
      cmbAfipConTipoConCod.setName( "AFIPCONTIPOCONCOD" );
      cmbAfipConTipoConCod.setWebtags( "" );
      cmbAfipConTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbAfipConTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbAfipConTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbAfipConTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbAfipConTipoConCod.getItemCount() > 0 )
      {
         A387AfipConTipoConCod = cmbAfipConTipoConCod.getValidValue(A387AfipConTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A387AfipConTipoConCod", A387AfipConTipoConCod);
      }
      chkAFIPConLiqAgil.setName( "AFIPCONLIQAGIL" );
      chkAFIPConLiqAgil.setWebtags( "" );
      chkAFIPConLiqAgil.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkAFIPConLiqAgil.getInternalname(), "TitleCaption", chkAFIPConLiqAgil.getCaption(), true);
      chkAFIPConLiqAgil.setCheckedValue( "false" );
      A1646AFIPConLiqAgil = GXutil.strtobool( GXutil.booltostr( A1646AFIPConLiqAgil)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1646AFIPConLiqAgil", A1646AFIPConLiqAgil);
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7AFIPConCod',fld:'vAFIPCONCOD',pic:'',hsh:true},{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7AFIPConCod',fld:'vAFIPCONCOD',pic:'',hsh:true},{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121Q2',iparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
      setEventMetadata("VALID_AFIPCONCOD","{handler:'valid_Afipconcod',iparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("VALID_AFIPCONCOD",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
      setEventMetadata("VALID_AFIPCONDESCRIP","{handler:'valid_Afipcondescrip',iparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("VALID_AFIPCONDESCRIP",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
      setEventMetadata("VALID_AFIPCONTIPOCONCOD","{handler:'valid_Afipcontipoconcod',iparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]");
      setEventMetadata("VALID_AFIPCONTIPOCONCOD",",oparms:[{av:'A1646AFIPConLiqAgil',fld:'AFIPCONLIQAGIL',pic:''}]}");
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
      wcpOAV7AFIPConCod = "" ;
      Z72AFIPConCod = "" ;
      Z385AfipConCodMasDesc = "" ;
      Z369AFIPConDescrip = "" ;
      Z387AfipConTipoConCod = "" ;
      Z388AfipConSubTipoConCod1 = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7AFIPConCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A387AfipConTipoConCod = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A72AFIPConCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A369AFIPConDescrip = "" ;
      A388AfipConSubTipoConCod1 = "" ;
      A385AfipConCodMasDesc = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV13Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode58 = "" ;
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
      T001Q4_A385AfipConCodMasDesc = new String[] {""} ;
      T001Q4_A72AFIPConCod = new String[] {""} ;
      T001Q4_A369AFIPConDescrip = new String[] {""} ;
      T001Q4_A387AfipConTipoConCod = new String[] {""} ;
      T001Q4_A388AfipConSubTipoConCod1 = new String[] {""} ;
      T001Q4_A1646AFIPConLiqAgil = new boolean[] {false} ;
      T001Q5_A72AFIPConCod = new String[] {""} ;
      T001Q3_A385AfipConCodMasDesc = new String[] {""} ;
      T001Q3_A72AFIPConCod = new String[] {""} ;
      T001Q3_A369AFIPConDescrip = new String[] {""} ;
      T001Q3_A387AfipConTipoConCod = new String[] {""} ;
      T001Q3_A388AfipConSubTipoConCod1 = new String[] {""} ;
      T001Q3_A1646AFIPConLiqAgil = new boolean[] {false} ;
      T001Q6_A72AFIPConCod = new String[] {""} ;
      T001Q7_A72AFIPConCod = new String[] {""} ;
      T001Q2_A385AfipConCodMasDesc = new String[] {""} ;
      T001Q2_A72AFIPConCod = new String[] {""} ;
      T001Q2_A369AFIPConDescrip = new String[] {""} ;
      T001Q2_A387AfipConTipoConCod = new String[] {""} ;
      T001Q2_A388AfipConSubTipoConCod1 = new String[] {""} ;
      T001Q2_A1646AFIPConLiqAgil = new boolean[] {false} ;
      T001Q11_A72AFIPConCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.afipconcepto__default(),
         new Object[] {
             new Object[] {
            T001Q2_A385AfipConCodMasDesc, T001Q2_A72AFIPConCod, T001Q2_A369AFIPConDescrip, T001Q2_A387AfipConTipoConCod, T001Q2_A388AfipConSubTipoConCod1, T001Q2_A1646AFIPConLiqAgil
            }
            , new Object[] {
            T001Q3_A385AfipConCodMasDesc, T001Q3_A72AFIPConCod, T001Q3_A369AFIPConDescrip, T001Q3_A387AfipConTipoConCod, T001Q3_A388AfipConSubTipoConCod1, T001Q3_A1646AFIPConLiqAgil
            }
            , new Object[] {
            T001Q4_A385AfipConCodMasDesc, T001Q4_A72AFIPConCod, T001Q4_A369AFIPConDescrip, T001Q4_A387AfipConTipoConCod, T001Q4_A388AfipConSubTipoConCod1, T001Q4_A1646AFIPConLiqAgil
            }
            , new Object[] {
            T001Q5_A72AFIPConCod
            }
            , new Object[] {
            T001Q6_A72AFIPConCod
            }
            , new Object[] {
            T001Q7_A72AFIPConCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001Q11_A72AFIPConCod
            }
         }
      );
      AV13Pgmname = "AFIPConcepto" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound58 ;
   private short nIsDirty_58 ;
   private int trnEnded ;
   private int edtAFIPConCod_Enabled ;
   private int edtAFIPConDescrip_Enabled ;
   private int edtAfipConSubTipoConCod1_Enabled ;
   private int edtAfipConCodMasDesc_Enabled ;
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
   private String wcpOAV7AFIPConCod ;
   private String Z72AFIPConCod ;
   private String Z387AfipConTipoConCod ;
   private String Z388AfipConSubTipoConCod1 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7AFIPConCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtAFIPConCod_Internalname ;
   private String A387AfipConTipoConCod ;
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
   private String A72AFIPConCod ;
   private String edtAFIPConCod_Jsonclick ;
   private String edtAFIPConDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtAfipConSubTipoConCod1_Internalname ;
   private String A388AfipConSubTipoConCod1 ;
   private String edtAfipConSubTipoConCod1_Jsonclick ;
   private String edtAfipConCodMasDesc_Internalname ;
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
   private String sMode58 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z1646AFIPConLiqAgil ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1646AFIPConLiqAgil ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z385AfipConCodMasDesc ;
   private String Z369AFIPConDescrip ;
   private String A369AFIPConDescrip ;
   private String A385AfipConCodMasDesc ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbAfipConTipoConCod ;
   private ICheckbox chkAFIPConLiqAgil ;
   private IDataStoreProvider pr_default ;
   private String[] T001Q4_A385AfipConCodMasDesc ;
   private String[] T001Q4_A72AFIPConCod ;
   private String[] T001Q4_A369AFIPConDescrip ;
   private String[] T001Q4_A387AfipConTipoConCod ;
   private String[] T001Q4_A388AfipConSubTipoConCod1 ;
   private boolean[] T001Q4_A1646AFIPConLiqAgil ;
   private String[] T001Q5_A72AFIPConCod ;
   private String[] T001Q3_A385AfipConCodMasDesc ;
   private String[] T001Q3_A72AFIPConCod ;
   private String[] T001Q3_A369AFIPConDescrip ;
   private String[] T001Q3_A387AfipConTipoConCod ;
   private String[] T001Q3_A388AfipConSubTipoConCod1 ;
   private boolean[] T001Q3_A1646AFIPConLiqAgil ;
   private String[] T001Q6_A72AFIPConCod ;
   private String[] T001Q7_A72AFIPConCod ;
   private String[] T001Q2_A385AfipConCodMasDesc ;
   private String[] T001Q2_A72AFIPConCod ;
   private String[] T001Q2_A369AFIPConDescrip ;
   private String[] T001Q2_A387AfipConTipoConCod ;
   private String[] T001Q2_A388AfipConSubTipoConCod1 ;
   private boolean[] T001Q2_A1646AFIPConLiqAgil ;
   private String[] T001Q11_A72AFIPConCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class afipconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001Q2", "SELECT AfipConCodMasDesc, AFIPConCod, AFIPConDescrip, AfipConTipoConCod, AfipConSubTipoConCod1, AFIPConLiqAgil FROM AFIPConcepto WHERE AFIPConCod = ?  FOR UPDATE OF AFIPConcepto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001Q3", "SELECT AfipConCodMasDesc, AFIPConCod, AFIPConDescrip, AfipConTipoConCod, AfipConSubTipoConCod1, AFIPConLiqAgil FROM AFIPConcepto WHERE AFIPConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001Q4", "SELECT TM1.AfipConCodMasDesc, TM1.AFIPConCod, TM1.AFIPConDescrip, TM1.AfipConTipoConCod, TM1.AfipConSubTipoConCod1, TM1.AFIPConLiqAgil FROM AFIPConcepto TM1 WHERE TM1.AFIPConCod = ( ?) ORDER BY TM1.AFIPConCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001Q5", "SELECT AFIPConCod FROM AFIPConcepto WHERE AFIPConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001Q6", "SELECT AFIPConCod FROM AFIPConcepto WHERE ( AFIPConCod > ( ?)) ORDER BY AFIPConCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001Q7", "SELECT AFIPConCod FROM AFIPConcepto WHERE ( AFIPConCod < ( ?)) ORDER BY AFIPConCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001Q8", "SAVEPOINT gxupdate;INSERT INTO AFIPConcepto(AfipConCodMasDesc, AFIPConCod, AFIPConDescrip, AfipConTipoConCod, AfipConSubTipoConCod1, AFIPConLiqAgil) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001Q9", "SAVEPOINT gxupdate;UPDATE AFIPConcepto SET AfipConCodMasDesc=?, AFIPConDescrip=?, AfipConTipoConCod=?, AfipConSubTipoConCod1=?, AFIPConLiqAgil=?  WHERE AFIPConCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001Q10", "SAVEPOINT gxupdate;DELETE FROM AFIPConcepto  WHERE AFIPConCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001Q11", "SELECT AFIPConCod FROM AFIPConcepto ORDER BY AFIPConCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
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
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 6);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setString(2, (String)parms[1], 6);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setString(6, (String)parms[5], 6);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 6);
               return;
      }
   }

}

