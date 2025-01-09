package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class soap_location_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A3CliCod) ;
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
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8SoapLocId = httpContext.GetPar( "SoapLocId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SoapLocId", AV8SoapLocId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSOAPLOCID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8SoapLocId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "soap_location", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public soap_location_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public soap_location_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( soap_location_impl.class ));
   }

   public soap_location_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkSoapLocHab = UIFactory.getCheckbox(this);
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
      A2163SoapLocHab = GXutil.strtobool( GXutil.booltostr( A2163SoapLocHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedclicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV14CliCod_Data);
      ucCombo_clicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_clicod_Internalname, "COMBO_CLICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocId_Internalname, httpContext.getMessage( "Loc Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocId_Internalname, GXutil.rtrim( A2162SoapLocId), GXutil.rtrim( localUtil.format( A2162SoapLocId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSoapLocHab.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSoapLocHab.getInternalname(), httpContext.getMessage( "Loc Hab", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSoapLocHab.getInternalname(), GXutil.booltostr( A2163SoapLocHab), "", httpContext.getMessage( "Loc Hab", ""), 1, chkSoapLocHab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(38, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,38);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocBaseUrl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocBaseUrl_Internalname, httpContext.getMessage( "Base Url", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtSoapLocBaseUrl_Internalname, A2164SoapLocBaseUrl, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", (short)(0), 1, edtSoapLocBaseUrl_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocCancelOnError_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocCancelOnError_Internalname, httpContext.getMessage( "On Error", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocCancelOnError_Internalname, GXutil.ltrim( localUtil.ntoc( A2165SoapLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSoapLocCancelOnError_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2165SoapLocCancelOnError), "9") : localUtil.format( DecimalUtil.doubleToDec(A2165SoapLocCancelOnError), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocCancelOnError_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocCancelOnError_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocHost_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocHost_Internalname, httpContext.getMessage( "Loc Host", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocHost_Internalname, A2166SoapLocHost, GXutil.rtrim( localUtil.format( A2166SoapLocHost, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocHost_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocHost_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocPort_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocPort_Internalname, httpContext.getMessage( "Loc Port", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocPort_Internalname, GXutil.ltrim( localUtil.ntoc( A2167SoapLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSoapLocPort_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2167SoapLocPort), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2167SoapLocPort), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocPort_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocPort_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocResourceName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocResourceName_Internalname, httpContext.getMessage( "Resource Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocResourceName_Internalname, A2168SoapLocResourceName, GXutil.rtrim( localUtil.format( A2168SoapLocResourceName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocResourceName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocResourceName_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocSecure_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocSecure_Internalname, httpContext.getMessage( "Loc Secure", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocSecure_Internalname, GXutil.ltrim( localUtil.ntoc( A2169SoapLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSoapLocSecure_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2169SoapLocSecure), "9") : localUtil.format( DecimalUtil.doubleToDec(A2169SoapLocSecure), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocSecure_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocSecure_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSoapLocTimeout_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSoapLocTimeout_Internalname, httpContext.getMessage( "Loc Timeout", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSoapLocTimeout_Internalname, GXutil.ltrim( localUtil.ntoc( A2170SoapLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSoapLocTimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2170SoapLocTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2170SoapLocTimeout), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSoapLocTimeout_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSoapLocTimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_soap_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_soap_location.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_clicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_soap_location.htm");
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
      e11692 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV14CliCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2162SoapLocId = httpContext.cgiGet( "Z2162SoapLocId") ;
            Z2163SoapLocHab = GXutil.strtobool( httpContext.cgiGet( "Z2163SoapLocHab")) ;
            Z2164SoapLocBaseUrl = httpContext.cgiGet( "Z2164SoapLocBaseUrl") ;
            Z2165SoapLocCancelOnError = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2165SoapLocCancelOnError"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2166SoapLocHost = httpContext.cgiGet( "Z2166SoapLocHost") ;
            Z2167SoapLocPort = (int)(localUtil.ctol( httpContext.cgiGet( "Z2167SoapLocPort"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2168SoapLocResourceName = httpContext.cgiGet( "Z2168SoapLocResourceName") ;
            Z2169SoapLocSecure = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2169SoapLocSecure"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2170SoapLocTimeout = (short)(localUtil.ctol( httpContext.cgiGet( "Z2170SoapLocTimeout"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8SoapLocId = httpContext.cgiGet( "vSOAPLOCID") ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_clicod_Objectcall = httpContext.cgiGet( "COMBO_CLICOD_Objectcall") ;
            Combo_clicod_Class = httpContext.cgiGet( "COMBO_CLICOD_Class") ;
            Combo_clicod_Icontype = httpContext.cgiGet( "COMBO_CLICOD_Icontype") ;
            Combo_clicod_Icon = httpContext.cgiGet( "COMBO_CLICOD_Icon") ;
            Combo_clicod_Caption = httpContext.cgiGet( "COMBO_CLICOD_Caption") ;
            Combo_clicod_Tooltip = httpContext.cgiGet( "COMBO_CLICOD_Tooltip") ;
            Combo_clicod_Cls = httpContext.cgiGet( "COMBO_CLICOD_Cls") ;
            Combo_clicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_set") ;
            Combo_clicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_get") ;
            Combo_clicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_set") ;
            Combo_clicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_get") ;
            Combo_clicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICOD_Gamoauthtoken") ;
            Combo_clicod_Ddointernalname = httpContext.cgiGet( "COMBO_CLICOD_Ddointernalname") ;
            Combo_clicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolalign") ;
            Combo_clicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICOD_Dropdownoptionstype") ;
            Combo_clicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Enabled")) ;
            Combo_clicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Visible")) ;
            Combo_clicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolidtoreplace") ;
            Combo_clicod_Datalisttype = httpContext.cgiGet( "COMBO_CLICOD_Datalisttype") ;
            Combo_clicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Allowmultipleselection")) ;
            Combo_clicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICOD_Datalistfixedvalues") ;
            Combo_clicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Isgriditem")) ;
            Combo_clicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Hasdescription")) ;
            Combo_clicod_Datalistproc = httpContext.cgiGet( "COMBO_CLICOD_Datalistproc") ;
            Combo_clicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICOD_Datalistprocparametersprefix") ;
            Combo_clicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICOD_Remoteservicesparameters") ;
            Combo_clicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_clicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeonlyselectedoption")) ;
            Combo_clicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeselectalloption")) ;
            Combo_clicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Emptyitem")) ;
            Combo_clicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeaddnewoption")) ;
            Combo_clicod_Htmltemplate = httpContext.cgiGet( "COMBO_CLICOD_Htmltemplate") ;
            Combo_clicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluestype") ;
            Combo_clicod_Loadingdata = httpContext.cgiGet( "COMBO_CLICOD_Loadingdata") ;
            Combo_clicod_Noresultsfound = httpContext.cgiGet( "COMBO_CLICOD_Noresultsfound") ;
            Combo_clicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICOD_Emptyitemtext") ;
            Combo_clicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICOD_Onlyselectedvalues") ;
            Combo_clicod_Selectalltext = httpContext.cgiGet( "COMBO_CLICOD_Selectalltext") ;
            Combo_clicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluesseparator") ;
            Combo_clicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICOD_Addnewoptiontext") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            A2162SoapLocId = httpContext.cgiGet( edtSoapLocId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
            A2163SoapLocHab = GXutil.strtobool( httpContext.cgiGet( chkSoapLocHab.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
            A2164SoapLocBaseUrl = httpContext.cgiGet( edtSoapLocBaseUrl_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2164SoapLocBaseUrl", A2164SoapLocBaseUrl);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SOAPLOCCANCELONERROR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSoapLocCancelOnError_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2165SoapLocCancelOnError = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2165SoapLocCancelOnError", GXutil.str( A2165SoapLocCancelOnError, 1, 0));
            }
            else
            {
               A2165SoapLocCancelOnError = (byte)(localUtil.ctol( httpContext.cgiGet( edtSoapLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2165SoapLocCancelOnError", GXutil.str( A2165SoapLocCancelOnError, 1, 0));
            }
            A2166SoapLocHost = httpContext.cgiGet( edtSoapLocHost_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2166SoapLocHost", A2166SoapLocHost);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SOAPLOCPORT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSoapLocPort_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2167SoapLocPort = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A2167SoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2167SoapLocPort), 8, 0));
            }
            else
            {
               A2167SoapLocPort = (int)(localUtil.ctol( httpContext.cgiGet( edtSoapLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2167SoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2167SoapLocPort), 8, 0));
            }
            A2168SoapLocResourceName = httpContext.cgiGet( edtSoapLocResourceName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2168SoapLocResourceName", A2168SoapLocResourceName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SOAPLOCSECURE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSoapLocSecure_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2169SoapLocSecure = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2169SoapLocSecure", GXutil.str( A2169SoapLocSecure, 1, 0));
            }
            else
            {
               A2169SoapLocSecure = (byte)(localUtil.ctol( httpContext.cgiGet( edtSoapLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2169SoapLocSecure", GXutil.str( A2169SoapLocSecure, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSoapLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SOAPLOCTIMEOUT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSoapLocTimeout_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2170SoapLocTimeout = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2170SoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2170SoapLocTimeout), 4, 0));
            }
            else
            {
               A2170SoapLocTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtSoapLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2170SoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2170SoapLocTimeout), 4, 0));
            }
            AV19ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCliCod), 6, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"soap_location");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2162SoapLocId, Z2162SoapLocId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("soap_location:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A2162SoapLocId = httpContext.GetPar( "SoapLocId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
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
                  sMode272 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode272 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound272 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_690( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
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
                        e11692 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12692 ();
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
         e12692 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll69272( ) ;
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
         disableAttributes69272( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
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

   public void confirm_690( )
   {
      beforeValidate69272( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls69272( ) ;
         }
         else
         {
            checkExtendedTable69272( ) ;
            closeExtendedTableCursors69272( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption690( )
   {
   }

   public void e11692( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV19ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCliCod), 6, 0));
      edtavComboclicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Insert", GXv_boolean5) ;
         soap_location_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Update", GXv_boolean5) ;
         soap_location_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location_Delete", GXv_boolean5) ;
         soap_location_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e12692( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char7[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.soap_locationloaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV8SoapLocId, "", GXv_char7, GXv_char8, GXv_char9) ;
      soap_location_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
      soap_location_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      soap_location_impl.this.GXt_char6 = GXv_char9[0] ;
      AV18Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV19ComboCliCod = (int)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm69272( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2163SoapLocHab = T00693_A2163SoapLocHab[0] ;
            Z2164SoapLocBaseUrl = T00693_A2164SoapLocBaseUrl[0] ;
            Z2165SoapLocCancelOnError = T00693_A2165SoapLocCancelOnError[0] ;
            Z2166SoapLocHost = T00693_A2166SoapLocHost[0] ;
            Z2167SoapLocPort = T00693_A2167SoapLocPort[0] ;
            Z2168SoapLocResourceName = T00693_A2168SoapLocResourceName[0] ;
            Z2169SoapLocSecure = T00693_A2169SoapLocSecure[0] ;
            Z2170SoapLocTimeout = T00693_A2170SoapLocTimeout[0] ;
         }
         else
         {
            Z2163SoapLocHab = A2163SoapLocHab ;
            Z2164SoapLocBaseUrl = A2164SoapLocBaseUrl ;
            Z2165SoapLocCancelOnError = A2165SoapLocCancelOnError ;
            Z2166SoapLocHost = A2166SoapLocHost ;
            Z2167SoapLocPort = A2167SoapLocPort ;
            Z2168SoapLocResourceName = A2168SoapLocResourceName ;
            Z2169SoapLocSecure = A2169SoapLocSecure ;
            Z2170SoapLocTimeout = A2170SoapLocTimeout ;
         }
      }
      if ( GX_JID == -7 )
      {
         Z2162SoapLocId = A2162SoapLocId ;
         Z2163SoapLocHab = A2163SoapLocHab ;
         Z2164SoapLocBaseUrl = A2164SoapLocBaseUrl ;
         Z2165SoapLocCancelOnError = A2165SoapLocCancelOnError ;
         Z2166SoapLocHost = A2166SoapLocHost ;
         Z2167SoapLocPort = A2167SoapLocPort ;
         Z2168SoapLocResourceName = A2168SoapLocResourceName ;
         Z2169SoapLocSecure = A2169SoapLocSecure ;
         Z2170SoapLocTimeout = A2170SoapLocTimeout ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8SoapLocId)==0) )
      {
         A2162SoapLocId = AV8SoapLocId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
      }
      if ( ! (GXutil.strcmp("", AV8SoapLocId)==0) )
      {
         edtSoapLocId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSoapLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocId_Enabled), 5, 0), true);
      }
      else
      {
         edtSoapLocId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSoapLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8SoapLocId)==0) )
      {
         edtSoapLocId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSoapLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV19ComboCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
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
         AV20Pgmname = "soap_location" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load69272( )
   {
      /* Using cursor T00695 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound272 = (short)(1) ;
         A2163SoapLocHab = T00695_A2163SoapLocHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
         A2164SoapLocBaseUrl = T00695_A2164SoapLocBaseUrl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2164SoapLocBaseUrl", A2164SoapLocBaseUrl);
         A2165SoapLocCancelOnError = T00695_A2165SoapLocCancelOnError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2165SoapLocCancelOnError", GXutil.str( A2165SoapLocCancelOnError, 1, 0));
         A2166SoapLocHost = T00695_A2166SoapLocHost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2166SoapLocHost", A2166SoapLocHost);
         A2167SoapLocPort = T00695_A2167SoapLocPort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2167SoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2167SoapLocPort), 8, 0));
         A2168SoapLocResourceName = T00695_A2168SoapLocResourceName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2168SoapLocResourceName", A2168SoapLocResourceName);
         A2169SoapLocSecure = T00695_A2169SoapLocSecure[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2169SoapLocSecure", GXutil.str( A2169SoapLocSecure, 1, 0));
         A2170SoapLocTimeout = T00695_A2170SoapLocTimeout[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2170SoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2170SoapLocTimeout), 4, 0));
         zm69272( -7) ;
      }
      pr_default.close(3);
      onLoadActions69272( ) ;
   }

   public void onLoadActions69272( )
   {
      AV20Pgmname = "soap_location" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
   }

   public void checkExtendedTable69272( )
   {
      nIsDirty_272 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV20Pgmname = "soap_location" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T00694 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors69272( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_8( int A3CliCod )
   {
      /* Using cursor T00696 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey69272( )
   {
      /* Using cursor T00697 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound272 = (short)(1) ;
      }
      else
      {
         RcdFound272 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00693 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm69272( 7) ;
         RcdFound272 = (short)(1) ;
         A2162SoapLocId = T00693_A2162SoapLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
         A2163SoapLocHab = T00693_A2163SoapLocHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
         A2164SoapLocBaseUrl = T00693_A2164SoapLocBaseUrl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2164SoapLocBaseUrl", A2164SoapLocBaseUrl);
         A2165SoapLocCancelOnError = T00693_A2165SoapLocCancelOnError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2165SoapLocCancelOnError", GXutil.str( A2165SoapLocCancelOnError, 1, 0));
         A2166SoapLocHost = T00693_A2166SoapLocHost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2166SoapLocHost", A2166SoapLocHost);
         A2167SoapLocPort = T00693_A2167SoapLocPort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2167SoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2167SoapLocPort), 8, 0));
         A2168SoapLocResourceName = T00693_A2168SoapLocResourceName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2168SoapLocResourceName", A2168SoapLocResourceName);
         A2169SoapLocSecure = T00693_A2169SoapLocSecure[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2169SoapLocSecure", GXutil.str( A2169SoapLocSecure, 1, 0));
         A2170SoapLocTimeout = T00693_A2170SoapLocTimeout[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2170SoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2170SoapLocTimeout), 4, 0));
         A3CliCod = T00693_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         Z3CliCod = A3CliCod ;
         Z2162SoapLocId = A2162SoapLocId ;
         sMode272 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load69272( ) ;
         if ( AnyError == 1 )
         {
            RcdFound272 = (short)(0) ;
            initializeNonKey69272( ) ;
         }
         Gx_mode = sMode272 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound272 = (short)(0) ;
         initializeNonKey69272( ) ;
         sMode272 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode272 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey69272( ) ;
      if ( RcdFound272 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound272 = (short)(0) ;
      /* Using cursor T00698 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2162SoapLocId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00698_A3CliCod[0] < A3CliCod ) || ( T00698_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00698_A2162SoapLocId[0], A2162SoapLocId) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00698_A3CliCod[0] > A3CliCod ) || ( T00698_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00698_A2162SoapLocId[0], A2162SoapLocId) > 0 ) ) )
         {
            A3CliCod = T00698_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A2162SoapLocId = T00698_A2162SoapLocId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
            RcdFound272 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound272 = (short)(0) ;
      /* Using cursor T00699 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2162SoapLocId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00699_A3CliCod[0] > A3CliCod ) || ( T00699_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00699_A2162SoapLocId[0], A2162SoapLocId) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00699_A3CliCod[0] < A3CliCod ) || ( T00699_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00699_A2162SoapLocId[0], A2162SoapLocId) < 0 ) ) )
         {
            A3CliCod = T00699_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A2162SoapLocId = T00699_A2162SoapLocId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
            RcdFound272 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey69272( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert69272( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound272 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2162SoapLocId, Z2162SoapLocId) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A2162SoapLocId = Z2162SoapLocId ;
               httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update69272( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2162SoapLocId, Z2162SoapLocId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert69272( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert69272( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2162SoapLocId, Z2162SoapLocId) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2162SoapLocId = Z2162SoapLocId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency69272( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00692 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"soap_location"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z2163SoapLocHab != T00692_A2163SoapLocHab[0] ) || ( GXutil.strcmp(Z2164SoapLocBaseUrl, T00692_A2164SoapLocBaseUrl[0]) != 0 ) || ( Z2165SoapLocCancelOnError != T00692_A2165SoapLocCancelOnError[0] ) || ( GXutil.strcmp(Z2166SoapLocHost, T00692_A2166SoapLocHost[0]) != 0 ) || ( Z2167SoapLocPort != T00692_A2167SoapLocPort[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2168SoapLocResourceName, T00692_A2168SoapLocResourceName[0]) != 0 ) || ( Z2169SoapLocSecure != T00692_A2169SoapLocSecure[0] ) || ( Z2170SoapLocTimeout != T00692_A2170SoapLocTimeout[0] ) )
         {
            if ( Z2163SoapLocHab != T00692_A2163SoapLocHab[0] )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocHab");
               GXutil.writeLogRaw("Old: ",Z2163SoapLocHab);
               GXutil.writeLogRaw("Current: ",T00692_A2163SoapLocHab[0]);
            }
            if ( GXutil.strcmp(Z2164SoapLocBaseUrl, T00692_A2164SoapLocBaseUrl[0]) != 0 )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocBaseUrl");
               GXutil.writeLogRaw("Old: ",Z2164SoapLocBaseUrl);
               GXutil.writeLogRaw("Current: ",T00692_A2164SoapLocBaseUrl[0]);
            }
            if ( Z2165SoapLocCancelOnError != T00692_A2165SoapLocCancelOnError[0] )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocCancelOnError");
               GXutil.writeLogRaw("Old: ",Z2165SoapLocCancelOnError);
               GXutil.writeLogRaw("Current: ",T00692_A2165SoapLocCancelOnError[0]);
            }
            if ( GXutil.strcmp(Z2166SoapLocHost, T00692_A2166SoapLocHost[0]) != 0 )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocHost");
               GXutil.writeLogRaw("Old: ",Z2166SoapLocHost);
               GXutil.writeLogRaw("Current: ",T00692_A2166SoapLocHost[0]);
            }
            if ( Z2167SoapLocPort != T00692_A2167SoapLocPort[0] )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocPort");
               GXutil.writeLogRaw("Old: ",Z2167SoapLocPort);
               GXutil.writeLogRaw("Current: ",T00692_A2167SoapLocPort[0]);
            }
            if ( GXutil.strcmp(Z2168SoapLocResourceName, T00692_A2168SoapLocResourceName[0]) != 0 )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocResourceName");
               GXutil.writeLogRaw("Old: ",Z2168SoapLocResourceName);
               GXutil.writeLogRaw("Current: ",T00692_A2168SoapLocResourceName[0]);
            }
            if ( Z2169SoapLocSecure != T00692_A2169SoapLocSecure[0] )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocSecure");
               GXutil.writeLogRaw("Old: ",Z2169SoapLocSecure);
               GXutil.writeLogRaw("Current: ",T00692_A2169SoapLocSecure[0]);
            }
            if ( Z2170SoapLocTimeout != T00692_A2170SoapLocTimeout[0] )
            {
               GXutil.writeLogln("soap_location:[seudo value changed for attri]"+"SoapLocTimeout");
               GXutil.writeLogRaw("Old: ",Z2170SoapLocTimeout);
               GXutil.writeLogRaw("Current: ",T00692_A2170SoapLocTimeout[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"soap_location"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert69272( )
   {
      beforeValidate69272( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable69272( ) ;
      }
      if ( AnyError == 0 )
      {
         zm69272( 0) ;
         checkOptimisticConcurrency69272( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm69272( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert69272( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006910 */
                  pr_default.execute(8, new Object[] {A2162SoapLocId, Boolean.valueOf(A2163SoapLocHab), A2164SoapLocBaseUrl, Byte.valueOf(A2165SoapLocCancelOnError), A2166SoapLocHost, Integer.valueOf(A2167SoapLocPort), A2168SoapLocResourceName, Byte.valueOf(A2169SoapLocSecure), Short.valueOf(A2170SoapLocTimeout), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("soap_location");
                  if ( (pr_default.getStatus(8) == 1) )
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
                        resetCaption690( ) ;
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
            load69272( ) ;
         }
         endLevel69272( ) ;
      }
      closeExtendedTableCursors69272( ) ;
   }

   public void update69272( )
   {
      beforeValidate69272( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable69272( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency69272( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm69272( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate69272( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006911 */
                  pr_default.execute(9, new Object[] {Boolean.valueOf(A2163SoapLocHab), A2164SoapLocBaseUrl, Byte.valueOf(A2165SoapLocCancelOnError), A2166SoapLocHost, Integer.valueOf(A2167SoapLocPort), A2168SoapLocResourceName, Byte.valueOf(A2169SoapLocSecure), Short.valueOf(A2170SoapLocTimeout), Integer.valueOf(A3CliCod), A2162SoapLocId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("soap_location");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"soap_location"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate69272( ) ;
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
         endLevel69272( ) ;
      }
      closeExtendedTableCursors69272( ) ;
   }

   public void deferredUpdate69272( )
   {
   }

   public void delete( )
   {
      beforeValidate69272( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency69272( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls69272( ) ;
         afterConfirm69272( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete69272( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006912 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("soap_location");
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
      sMode272 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel69272( ) ;
      Gx_mode = sMode272 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls69272( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "soap_location" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void endLevel69272( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete69272( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "soap_location");
         if ( AnyError == 0 )
         {
            confirmValues690( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "soap_location");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart69272( )
   {
      /* Scan By routine */
      /* Using cursor T006913 */
      pr_default.execute(11);
      RcdFound272 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound272 = (short)(1) ;
         A3CliCod = T006913_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2162SoapLocId = T006913_A2162SoapLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext69272( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound272 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound272 = (short)(1) ;
         A3CliCod = T006913_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2162SoapLocId = T006913_A2162SoapLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
      }
   }

   public void scanEnd69272( )
   {
      pr_default.close(11);
   }

   public void afterConfirm69272( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert69272( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate69272( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete69272( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete69272( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate69272( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes69272( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtSoapLocId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocId_Enabled), 5, 0), true);
      chkSoapLocHab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSoapLocHab.getInternalname(), "Enabled", GXutil.ltrimstr( chkSoapLocHab.getEnabled(), 5, 0), true);
      edtSoapLocBaseUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocBaseUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocBaseUrl_Enabled), 5, 0), true);
      edtSoapLocCancelOnError_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocCancelOnError_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocCancelOnError_Enabled), 5, 0), true);
      edtSoapLocHost_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocHost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocHost_Enabled), 5, 0), true);
      edtSoapLocPort_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocPort_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocPort_Enabled), 5, 0), true);
      edtSoapLocResourceName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocResourceName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocResourceName_Enabled), 5, 0), true);
      edtSoapLocSecure_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocSecure_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocSecure_Enabled), 5, 0), true);
      edtSoapLocTimeout_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSoapLocTimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSoapLocTimeout_Enabled), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes69272( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues690( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.soap_location", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8SoapLocId))}, new String[] {"Gx_mode","CliCod","SoapLocId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"soap_location");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("soap_location:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2162SoapLocId", GXutil.rtrim( Z2162SoapLocId));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2163SoapLocHab", Z2163SoapLocHab);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2164SoapLocBaseUrl", Z2164SoapLocBaseUrl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2165SoapLocCancelOnError", GXutil.ltrim( localUtil.ntoc( Z2165SoapLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2166SoapLocHost", Z2166SoapLocHost);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2167SoapLocPort", GXutil.ltrim( localUtil.ntoc( Z2167SoapLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2168SoapLocResourceName", Z2168SoapLocResourceName);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2169SoapLocSecure", GXutil.ltrim( localUtil.ntoc( Z2169SoapLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2170SoapLocTimeout", GXutil.ltrim( localUtil.ntoc( Z2170SoapLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV14CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV14CliCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSOAPLOCID", GXutil.rtrim( AV8SoapLocId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSOAPLOCID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8SoapLocId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
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
      return formatLink("web.soap_location", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8SoapLocId))}, new String[] {"Gx_mode","CliCod","SoapLocId"})  ;
   }

   public String getPgmname( )
   {
      return "soap_location" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "soap_location", "") ;
   }

   public void initializeNonKey69272( )
   {
      A2163SoapLocHab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
      A2164SoapLocBaseUrl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2164SoapLocBaseUrl", A2164SoapLocBaseUrl);
      A2165SoapLocCancelOnError = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2165SoapLocCancelOnError", GXutil.str( A2165SoapLocCancelOnError, 1, 0));
      A2166SoapLocHost = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2166SoapLocHost", A2166SoapLocHost);
      A2167SoapLocPort = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2167SoapLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2167SoapLocPort), 8, 0));
      A2168SoapLocResourceName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2168SoapLocResourceName", A2168SoapLocResourceName);
      A2169SoapLocSecure = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2169SoapLocSecure", GXutil.str( A2169SoapLocSecure, 1, 0));
      A2170SoapLocTimeout = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2170SoapLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2170SoapLocTimeout), 4, 0));
      Z2163SoapLocHab = false ;
      Z2164SoapLocBaseUrl = "" ;
      Z2165SoapLocCancelOnError = (byte)(0) ;
      Z2166SoapLocHost = "" ;
      Z2167SoapLocPort = 0 ;
      Z2168SoapLocResourceName = "" ;
      Z2169SoapLocSecure = (byte)(0) ;
      Z2170SoapLocTimeout = (short)(0) ;
   }

   public void initAll69272( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A2162SoapLocId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2162SoapLocId", A2162SoapLocId);
      initializeNonKey69272( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020402150", true, true);
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
      httpContext.AddJavascriptSource("soap_location.js", "?2024122020402150", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockclicod_Internalname = "TEXTBLOCKCLICOD" ;
      Combo_clicod_Internalname = "COMBO_CLICOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      divTablesplittedclicod_Internalname = "TABLESPLITTEDCLICOD" ;
      edtSoapLocId_Internalname = "SOAPLOCID" ;
      chkSoapLocHab.setInternalname( "SOAPLOCHAB" );
      edtSoapLocBaseUrl_Internalname = "SOAPLOCBASEURL" ;
      edtSoapLocCancelOnError_Internalname = "SOAPLOCCANCELONERROR" ;
      edtSoapLocHost_Internalname = "SOAPLOCHOST" ;
      edtSoapLocPort_Internalname = "SOAPLOCPORT" ;
      edtSoapLocResourceName_Internalname = "SOAPLOCRESOURCENAME" ;
      edtSoapLocSecure_Internalname = "SOAPLOCSECURE" ;
      edtSoapLocTimeout_Internalname = "SOAPLOCTIMEOUT" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboclicod_Internalname = "vCOMBOCLICOD" ;
      divSectionattribute_clicod_Internalname = "SECTIONATTRIBUTE_CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      Form.setCaption( httpContext.getMessage( "soap_location", "") );
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtSoapLocTimeout_Jsonclick = "" ;
      edtSoapLocTimeout_Enabled = 1 ;
      edtSoapLocSecure_Jsonclick = "" ;
      edtSoapLocSecure_Enabled = 1 ;
      edtSoapLocResourceName_Jsonclick = "" ;
      edtSoapLocResourceName_Enabled = 1 ;
      edtSoapLocPort_Jsonclick = "" ;
      edtSoapLocPort_Enabled = 1 ;
      edtSoapLocHost_Jsonclick = "" ;
      edtSoapLocHost_Enabled = 1 ;
      edtSoapLocCancelOnError_Jsonclick = "" ;
      edtSoapLocCancelOnError_Enabled = 1 ;
      edtSoapLocBaseUrl_Enabled = 1 ;
      chkSoapLocHab.setEnabled( 1 );
      edtSoapLocId_Jsonclick = "" ;
      edtSoapLocId_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"SoapLocId\": \"\"" ;
      Combo_clicod_Datalistproc = "soap_locationLoadDVCombo" ;
      Combo_clicod_Cls = "ExtendedCombo Attribute" ;
      Combo_clicod_Caption = "" ;
      Combo_clicod_Enabled = GXutil.toBoolean( -1) ;
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
      chkSoapLocHab.setName( "SOAPLOCHAB" );
      chkSoapLocHab.setWebtags( "" );
      chkSoapLocHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSoapLocHab.getInternalname(), "TitleCaption", chkSoapLocHab.getCaption(), true);
      chkSoapLocHab.setCheckedValue( "false" );
      A2163SoapLocHab = GXutil.strtobool( GXutil.booltostr( A2163SoapLocHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2163SoapLocHab", A2163SoapLocHab);
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

   public void valid_Clicod( )
   {
      /* Using cursor T006914 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8SoapLocId',fld:'vSOAPLOCID',pic:'',hsh:true},{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8SoapLocId',fld:'vSOAPLOCID',pic:'',hsh:true},{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12692',iparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
      setEventMetadata("VALID_SOAPLOCID","{handler:'valid_Soaplocid',iparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("VALID_SOAPLOCID",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[{av:'A2163SoapLocHab',fld:'SOAPLOCHAB',pic:''}]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8SoapLocId = "" ;
      Z2162SoapLocId = "" ;
      Z2164SoapLocBaseUrl = "" ;
      Z2166SoapLocHost = "" ;
      Z2168SoapLocResourceName = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV8SoapLocId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A2162SoapLocId = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20Pgmname = "" ;
      Combo_clicod_Objectcall = "" ;
      Combo_clicod_Class = "" ;
      Combo_clicod_Icontype = "" ;
      Combo_clicod_Icon = "" ;
      Combo_clicod_Tooltip = "" ;
      Combo_clicod_Selectedvalue_set = "" ;
      Combo_clicod_Selectedtext_set = "" ;
      Combo_clicod_Selectedtext_get = "" ;
      Combo_clicod_Gamoauthtoken = "" ;
      Combo_clicod_Ddointernalname = "" ;
      Combo_clicod_Titlecontrolalign = "" ;
      Combo_clicod_Dropdownoptionstype = "" ;
      Combo_clicod_Titlecontrolidtoreplace = "" ;
      Combo_clicod_Datalisttype = "" ;
      Combo_clicod_Datalistfixedvalues = "" ;
      Combo_clicod_Remoteservicesparameters = "" ;
      Combo_clicod_Htmltemplate = "" ;
      Combo_clicod_Multiplevaluestype = "" ;
      Combo_clicod_Loadingdata = "" ;
      Combo_clicod_Noresultsfound = "" ;
      Combo_clicod_Emptyitemtext = "" ;
      Combo_clicod_Onlyselectedvalues = "" ;
      Combo_clicod_Selectalltext = "" ;
      Combo_clicod_Multiplevaluesseparator = "" ;
      Combo_clicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode272 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV18Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV16ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV17ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      T00695_A2162SoapLocId = new String[] {""} ;
      T00695_A2163SoapLocHab = new boolean[] {false} ;
      T00695_A2164SoapLocBaseUrl = new String[] {""} ;
      T00695_A2165SoapLocCancelOnError = new byte[1] ;
      T00695_A2166SoapLocHost = new String[] {""} ;
      T00695_A2167SoapLocPort = new int[1] ;
      T00695_A2168SoapLocResourceName = new String[] {""} ;
      T00695_A2169SoapLocSecure = new byte[1] ;
      T00695_A2170SoapLocTimeout = new short[1] ;
      T00695_A3CliCod = new int[1] ;
      T00694_A3CliCod = new int[1] ;
      T00696_A3CliCod = new int[1] ;
      T00697_A3CliCod = new int[1] ;
      T00697_A2162SoapLocId = new String[] {""} ;
      T00693_A2162SoapLocId = new String[] {""} ;
      T00693_A2163SoapLocHab = new boolean[] {false} ;
      T00693_A2164SoapLocBaseUrl = new String[] {""} ;
      T00693_A2165SoapLocCancelOnError = new byte[1] ;
      T00693_A2166SoapLocHost = new String[] {""} ;
      T00693_A2167SoapLocPort = new int[1] ;
      T00693_A2168SoapLocResourceName = new String[] {""} ;
      T00693_A2169SoapLocSecure = new byte[1] ;
      T00693_A2170SoapLocTimeout = new short[1] ;
      T00693_A3CliCod = new int[1] ;
      T00698_A3CliCod = new int[1] ;
      T00698_A2162SoapLocId = new String[] {""} ;
      T00699_A3CliCod = new int[1] ;
      T00699_A2162SoapLocId = new String[] {""} ;
      T00692_A2162SoapLocId = new String[] {""} ;
      T00692_A2163SoapLocHab = new boolean[] {false} ;
      T00692_A2164SoapLocBaseUrl = new String[] {""} ;
      T00692_A2165SoapLocCancelOnError = new byte[1] ;
      T00692_A2166SoapLocHost = new String[] {""} ;
      T00692_A2167SoapLocPort = new int[1] ;
      T00692_A2168SoapLocResourceName = new String[] {""} ;
      T00692_A2169SoapLocSecure = new byte[1] ;
      T00692_A2170SoapLocTimeout = new short[1] ;
      T00692_A3CliCod = new int[1] ;
      T006913_A3CliCod = new int[1] ;
      T006913_A2162SoapLocId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T006914_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.soap_location__default(),
         new Object[] {
             new Object[] {
            T00692_A2162SoapLocId, T00692_A2163SoapLocHab, T00692_A2164SoapLocBaseUrl, T00692_A2165SoapLocCancelOnError, T00692_A2166SoapLocHost, T00692_A2167SoapLocPort, T00692_A2168SoapLocResourceName, T00692_A2169SoapLocSecure, T00692_A2170SoapLocTimeout, T00692_A3CliCod
            }
            , new Object[] {
            T00693_A2162SoapLocId, T00693_A2163SoapLocHab, T00693_A2164SoapLocBaseUrl, T00693_A2165SoapLocCancelOnError, T00693_A2166SoapLocHost, T00693_A2167SoapLocPort, T00693_A2168SoapLocResourceName, T00693_A2169SoapLocSecure, T00693_A2170SoapLocTimeout, T00693_A3CliCod
            }
            , new Object[] {
            T00694_A3CliCod
            }
            , new Object[] {
            T00695_A2162SoapLocId, T00695_A2163SoapLocHab, T00695_A2164SoapLocBaseUrl, T00695_A2165SoapLocCancelOnError, T00695_A2166SoapLocHost, T00695_A2167SoapLocPort, T00695_A2168SoapLocResourceName, T00695_A2169SoapLocSecure, T00695_A2170SoapLocTimeout, T00695_A3CliCod
            }
            , new Object[] {
            T00696_A3CliCod
            }
            , new Object[] {
            T00697_A3CliCod, T00697_A2162SoapLocId
            }
            , new Object[] {
            T00698_A3CliCod, T00698_A2162SoapLocId
            }
            , new Object[] {
            T00699_A3CliCod, T00699_A2162SoapLocId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006913_A3CliCod, T006913_A2162SoapLocId
            }
            , new Object[] {
            T006914_A3CliCod
            }
         }
      );
      AV20Pgmname = "soap_location" ;
   }

   private byte Z2165SoapLocCancelOnError ;
   private byte Z2169SoapLocSecure ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z2170SoapLocTimeout ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2170SoapLocTimeout ;
   private short RcdFound272 ;
   private short nIsDirty_272 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2167SoapLocPort ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtSoapLocId_Enabled ;
   private int edtSoapLocBaseUrl_Enabled ;
   private int edtSoapLocCancelOnError_Enabled ;
   private int edtSoapLocHost_Enabled ;
   private int A2167SoapLocPort ;
   private int edtSoapLocPort_Enabled ;
   private int edtSoapLocResourceName_Enabled ;
   private int edtSoapLocSecure_Enabled ;
   private int edtSoapLocTimeout_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV19ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8SoapLocId ;
   private String Z2162SoapLocId ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV8SoapLocId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
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
   private String divTablesplittedclicod_Internalname ;
   private String lblTextblockclicod_Internalname ;
   private String lblTextblockclicod_Jsonclick ;
   private String Combo_clicod_Caption ;
   private String Combo_clicod_Cls ;
   private String Combo_clicod_Datalistproc ;
   private String Combo_clicod_Datalistprocparametersprefix ;
   private String Combo_clicod_Internalname ;
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String edtSoapLocId_Internalname ;
   private String A2162SoapLocId ;
   private String edtSoapLocId_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtSoapLocBaseUrl_Internalname ;
   private String edtSoapLocCancelOnError_Internalname ;
   private String edtSoapLocCancelOnError_Jsonclick ;
   private String edtSoapLocHost_Internalname ;
   private String edtSoapLocHost_Jsonclick ;
   private String edtSoapLocPort_Internalname ;
   private String edtSoapLocPort_Jsonclick ;
   private String edtSoapLocResourceName_Internalname ;
   private String edtSoapLocResourceName_Jsonclick ;
   private String edtSoapLocSecure_Internalname ;
   private String edtSoapLocSecure_Jsonclick ;
   private String edtSoapLocTimeout_Internalname ;
   private String edtSoapLocTimeout_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_clicod_Internalname ;
   private String edtavComboclicod_Internalname ;
   private String edtavComboclicod_Jsonclick ;
   private String AV20Pgmname ;
   private String Combo_clicod_Objectcall ;
   private String Combo_clicod_Class ;
   private String Combo_clicod_Icontype ;
   private String Combo_clicod_Icon ;
   private String Combo_clicod_Tooltip ;
   private String Combo_clicod_Selectedvalue_set ;
   private String Combo_clicod_Selectedtext_set ;
   private String Combo_clicod_Selectedtext_get ;
   private String Combo_clicod_Gamoauthtoken ;
   private String Combo_clicod_Ddointernalname ;
   private String Combo_clicod_Titlecontrolalign ;
   private String Combo_clicod_Dropdownoptionstype ;
   private String Combo_clicod_Titlecontrolidtoreplace ;
   private String Combo_clicod_Datalisttype ;
   private String Combo_clicod_Datalistfixedvalues ;
   private String Combo_clicod_Remoteservicesparameters ;
   private String Combo_clicod_Htmltemplate ;
   private String Combo_clicod_Multiplevaluestype ;
   private String Combo_clicod_Loadingdata ;
   private String Combo_clicod_Noresultsfound ;
   private String Combo_clicod_Emptyitemtext ;
   private String Combo_clicod_Onlyselectedvalues ;
   private String Combo_clicod_Selectalltext ;
   private String Combo_clicod_Multiplevaluesseparator ;
   private String Combo_clicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode272 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z2163SoapLocHab ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2163SoapLocHab ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV18Combo_DataJson ;
   private String Z2164SoapLocBaseUrl ;
   private String Z2166SoapLocHost ;
   private String Z2168SoapLocResourceName ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkSoapLocHab ;
   private IDataStoreProvider pr_default ;
   private String[] T00695_A2162SoapLocId ;
   private boolean[] T00695_A2163SoapLocHab ;
   private String[] T00695_A2164SoapLocBaseUrl ;
   private byte[] T00695_A2165SoapLocCancelOnError ;
   private String[] T00695_A2166SoapLocHost ;
   private int[] T00695_A2167SoapLocPort ;
   private String[] T00695_A2168SoapLocResourceName ;
   private byte[] T00695_A2169SoapLocSecure ;
   private short[] T00695_A2170SoapLocTimeout ;
   private int[] T00695_A3CliCod ;
   private int[] T00694_A3CliCod ;
   private int[] T00696_A3CliCod ;
   private int[] T00697_A3CliCod ;
   private String[] T00697_A2162SoapLocId ;
   private String[] T00693_A2162SoapLocId ;
   private boolean[] T00693_A2163SoapLocHab ;
   private String[] T00693_A2164SoapLocBaseUrl ;
   private byte[] T00693_A2165SoapLocCancelOnError ;
   private String[] T00693_A2166SoapLocHost ;
   private int[] T00693_A2167SoapLocPort ;
   private String[] T00693_A2168SoapLocResourceName ;
   private byte[] T00693_A2169SoapLocSecure ;
   private short[] T00693_A2170SoapLocTimeout ;
   private int[] T00693_A3CliCod ;
   private int[] T00698_A3CliCod ;
   private String[] T00698_A2162SoapLocId ;
   private int[] T00699_A3CliCod ;
   private String[] T00699_A2162SoapLocId ;
   private String[] T00692_A2162SoapLocId ;
   private boolean[] T00692_A2163SoapLocHab ;
   private String[] T00692_A2164SoapLocBaseUrl ;
   private byte[] T00692_A2165SoapLocCancelOnError ;
   private String[] T00692_A2166SoapLocHost ;
   private int[] T00692_A2167SoapLocPort ;
   private String[] T00692_A2168SoapLocResourceName ;
   private byte[] T00692_A2169SoapLocSecure ;
   private short[] T00692_A2170SoapLocTimeout ;
   private int[] T00692_A3CliCod ;
   private int[] T006913_A3CliCod ;
   private String[] T006913_A2162SoapLocId ;
   private int[] T006914_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14CliCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class soap_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00692", "SELECT SoapLocId, SoapLocHab, SoapLocBaseUrl, SoapLocCancelOnError, SoapLocHost, SoapLocPort, SoapLocResourceName, SoapLocSecure, SoapLocTimeout, CliCod FROM soap_location WHERE CliCod = ? AND SoapLocId = ?  FOR UPDATE OF soap_location NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00693", "SELECT SoapLocId, SoapLocHab, SoapLocBaseUrl, SoapLocCancelOnError, SoapLocHost, SoapLocPort, SoapLocResourceName, SoapLocSecure, SoapLocTimeout, CliCod FROM soap_location WHERE CliCod = ? AND SoapLocId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00694", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00695", "SELECT TM1.SoapLocId, TM1.SoapLocHab, TM1.SoapLocBaseUrl, TM1.SoapLocCancelOnError, TM1.SoapLocHost, TM1.SoapLocPort, TM1.SoapLocResourceName, TM1.SoapLocSecure, TM1.SoapLocTimeout, TM1.CliCod FROM soap_location TM1 WHERE TM1.CliCod = ? and TM1.SoapLocId = ( ?) ORDER BY TM1.CliCod, TM1.SoapLocId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00696", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00697", "SELECT CliCod, SoapLocId FROM soap_location WHERE CliCod = ? AND SoapLocId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00698", "SELECT CliCod, SoapLocId FROM soap_location WHERE ( CliCod > ? or CliCod = ? and SoapLocId > ( ?)) ORDER BY CliCod, SoapLocId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00699", "SELECT CliCod, SoapLocId FROM soap_location WHERE ( CliCod < ? or CliCod = ? and SoapLocId < ( ?)) ORDER BY CliCod DESC, SoapLocId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006910", "SAVEPOINT gxupdate;INSERT INTO soap_location(SoapLocId, SoapLocHab, SoapLocBaseUrl, SoapLocCancelOnError, SoapLocHost, SoapLocPort, SoapLocResourceName, SoapLocSecure, SoapLocTimeout, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006911", "SAVEPOINT gxupdate;UPDATE soap_location SET SoapLocHab=?, SoapLocBaseUrl=?, SoapLocCancelOnError=?, SoapLocHost=?, SoapLocPort=?, SoapLocResourceName=?, SoapLocSecure=?, SoapLocTimeout=?  WHERE CliCod = ? AND SoapLocId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006912", "SAVEPOINT gxupdate;DELETE FROM soap_location  WHERE CliCod = ? AND SoapLocId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006913", "SELECT CliCod, SoapLocId FROM soap_location ORDER BY CliCod, SoapLocId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006914", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setVarchar(3, (String)parms[2], 1000, false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setVarchar(7, (String)parms[6], 80, false);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 9 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setVarchar(6, (String)parms[5], 80, false);
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

