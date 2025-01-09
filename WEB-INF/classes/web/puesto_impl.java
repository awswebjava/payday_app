package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class puesto_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"PUESTODESCRIPSINAC") == 0 )
      {
         A1241PuestoDescrip = httpContext.GetPar( "PuestoDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1241PuestoDescrip", A1241PuestoDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asapuestodescripsinac3L153( A1241PuestoDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaclicod3L153( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = httpContext.GetPar( "SecCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A3CliCod, A13SecCodigo) ;
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
            AV14SecCodigo = httpContext.GetPar( "SecCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14SecCodigo", AV14SecCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14SecCodigo, ""))));
            AV8PuestoCodigo = httpContext.GetPar( "PuestoCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PuestoCodigo", AV8PuestoCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPUESTOCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8PuestoCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Puesto", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public puesto_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public puesto_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( puesto_impl.class ));
   }

   public puesto_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkPuestoHorasExt = UIFactory.getCheckbox(this);
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
      A1255PuestoHorasExt = GXutil.strtobool( GXutil.booltostr( A1255PuestoHorasExt)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedseccodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockseccodigo_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockseccodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_seccodigo.setProperty("Caption", Combo_seccodigo_Caption);
      ucCombo_seccodigo.setProperty("Cls", Combo_seccodigo_Cls);
      ucCombo_seccodigo.setProperty("DataListProc", Combo_seccodigo_Datalistproc);
      ucCombo_seccodigo.setProperty("EmptyItem", Combo_seccodigo_Emptyitem);
      ucCombo_seccodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_seccodigo.setProperty("DropDownOptionsData", AV15SecCodigo_Data);
      ucCombo_seccodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_seccodigo_Internalname, "COMBO_SECCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecCodigo_Internalname, httpContext.getMessage( "Área", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecCodigo_Internalname, GXutil.rtrim( A13SecCodigo), GXutil.rtrim( localUtil.format( A13SecCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtSecCodigo_Visible, edtSecCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_Puesto.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPuestoCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPuestoCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPuestoCodigo_Internalname, GXutil.rtrim( A1240PuestoCodigo), GXutil.rtrim( localUtil.format( A1240PuestoCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPuestoCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPuestoCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPuestoDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPuestoDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtPuestoDescrip_Internalname, A1241PuestoDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtPuestoDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPuestoHorasExt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPuestoHorasExt.getInternalname(), httpContext.getMessage( "Puede realizar horas extras", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPuestoHorasExt.getInternalname(), GXutil.booltostr( A1255PuestoHorasExt), "", httpContext.getMessage( "Puede realizar horas extras", ""), 1, chkPuestoHorasExt.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(43, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,43);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Puesto.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_seccodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboseccodigo_Internalname, GXutil.rtrim( AV20ComboSecCodigo), GXutil.rtrim( localUtil.format( AV20ComboSecCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboseccodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboseccodigo_Visible, edtavComboseccodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Puesto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Puesto.htm");
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
      e113L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECCODIGO_DATA"), AV15SecCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z13SecCodigo = httpContext.cgiGet( "Z13SecCodigo") ;
            Z1240PuestoCodigo = httpContext.cgiGet( "Z1240PuestoCodigo") ;
            Z1242PuestoDescripSinAc = httpContext.cgiGet( "Z1242PuestoDescripSinAc") ;
            Z1241PuestoDescrip = httpContext.cgiGet( "Z1241PuestoDescrip") ;
            Z1255PuestoHorasExt = GXutil.strtobool( httpContext.cgiGet( "Z1255PuestoHorasExt")) ;
            A1242PuestoDescripSinAc = httpContext.cgiGet( "Z1242PuestoDescripSinAc") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1242PuestoDescripSinAc = httpContext.cgiGet( "PUESTODESCRIPSINAC") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14SecCodigo = httpContext.cgiGet( "vSECCODIGO") ;
            AV8PuestoCodigo = httpContext.cgiGet( "vPUESTOCODIGO") ;
            AV21Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_seccodigo_Objectcall = httpContext.cgiGet( "COMBO_SECCODIGO_Objectcall") ;
            Combo_seccodigo_Class = httpContext.cgiGet( "COMBO_SECCODIGO_Class") ;
            Combo_seccodigo_Icontype = httpContext.cgiGet( "COMBO_SECCODIGO_Icontype") ;
            Combo_seccodigo_Icon = httpContext.cgiGet( "COMBO_SECCODIGO_Icon") ;
            Combo_seccodigo_Caption = httpContext.cgiGet( "COMBO_SECCODIGO_Caption") ;
            Combo_seccodigo_Tooltip = httpContext.cgiGet( "COMBO_SECCODIGO_Tooltip") ;
            Combo_seccodigo_Cls = httpContext.cgiGet( "COMBO_SECCODIGO_Cls") ;
            Combo_seccodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedvalue_set") ;
            Combo_seccodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedvalue_get") ;
            Combo_seccodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedtext_set") ;
            Combo_seccodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedtext_get") ;
            Combo_seccodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_SECCODIGO_Gamoauthtoken") ;
            Combo_seccodigo_Ddointernalname = httpContext.cgiGet( "COMBO_SECCODIGO_Ddointernalname") ;
            Combo_seccodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_SECCODIGO_Titlecontrolalign") ;
            Combo_seccodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SECCODIGO_Dropdownoptionstype") ;
            Combo_seccodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Enabled")) ;
            Combo_seccodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Visible")) ;
            Combo_seccodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SECCODIGO_Titlecontrolidtoreplace") ;
            Combo_seccodigo_Datalisttype = httpContext.cgiGet( "COMBO_SECCODIGO_Datalisttype") ;
            Combo_seccodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Allowmultipleselection")) ;
            Combo_seccodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SECCODIGO_Datalistfixedvalues") ;
            Combo_seccodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Isgriditem")) ;
            Combo_seccodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Hasdescription")) ;
            Combo_seccodigo_Datalistproc = httpContext.cgiGet( "COMBO_SECCODIGO_Datalistproc") ;
            Combo_seccodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SECCODIGO_Datalistprocparametersprefix") ;
            Combo_seccodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_SECCODIGO_Remoteservicesparameters") ;
            Combo_seccodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SECCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_seccodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Includeonlyselectedoption")) ;
            Combo_seccodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Includeselectalloption")) ;
            Combo_seccodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Emptyitem")) ;
            Combo_seccodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Includeaddnewoption")) ;
            Combo_seccodigo_Htmltemplate = httpContext.cgiGet( "COMBO_SECCODIGO_Htmltemplate") ;
            Combo_seccodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_SECCODIGO_Multiplevaluestype") ;
            Combo_seccodigo_Loadingdata = httpContext.cgiGet( "COMBO_SECCODIGO_Loadingdata") ;
            Combo_seccodigo_Noresultsfound = httpContext.cgiGet( "COMBO_SECCODIGO_Noresultsfound") ;
            Combo_seccodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_SECCODIGO_Emptyitemtext") ;
            Combo_seccodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SECCODIGO_Onlyselectedvalues") ;
            Combo_seccodigo_Selectalltext = httpContext.cgiGet( "COMBO_SECCODIGO_Selectalltext") ;
            Combo_seccodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SECCODIGO_Multiplevaluesseparator") ;
            Combo_seccodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_SECCODIGO_Addnewoptiontext") ;
            Combo_seccodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SECCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A13SecCodigo = httpContext.cgiGet( edtSecCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            A1240PuestoCodigo = httpContext.cgiGet( edtPuestoCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
            A1241PuestoDescrip = httpContext.cgiGet( edtPuestoDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1241PuestoDescrip", A1241PuestoDescrip);
            A1255PuestoHorasExt = GXutil.strtobool( httpContext.cgiGet( chkPuestoHorasExt.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
            AV20ComboSecCodigo = httpContext.cgiGet( edtavComboseccodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSecCodigo", AV20ComboSecCodigo);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Puesto");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) || ( GXutil.strcmp(A1240PuestoCodigo, Z1240PuestoCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("puesto:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A13SecCodigo = httpContext.GetPar( "SecCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
               A1240PuestoCodigo = httpContext.GetPar( "PuestoCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
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
                  sMode153 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode153 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound153 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3L0( ) ;
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
                        e113L2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123L2 ();
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
         e123L2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3L153( ) ;
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
         disableAttributes3L153( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboseccodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboseccodigo_Enabled), 5, 0), true);
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

   public void confirm_3L0( )
   {
      beforeValidate3L153( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3L153( ) ;
         }
         else
         {
            checkExtendedTable3L153( ) ;
            closeExtendedTableCursors3L153( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3L0( )
   {
   }

   public void e113L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtSecCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Visible), 5, 0), true);
      AV20ComboSecCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSecCodigo", AV20ComboSecCodigo);
      edtavComboseccodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboseccodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboseccodigo_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOSECCODIGO' */
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPuesto_Insert", GXv_boolean5) ;
         puesto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPuesto_Update", GXv_boolean5) ;
         puesto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPuesto_Delete", GXv_boolean5) ;
         puesto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV21Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e123L2( )
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
      /* 'LOADCOMBOSECCODIGO' Routine */
      returnInSub = false ;
      Combo_seccodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"SecCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"SecCodigo\": \"\", \"PuestoCodigo\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_seccodigo.sendProperty(context, "", false, Combo_seccodigo_Internalname, "DataListProcParametersPrefix", Combo_seccodigo_Datalistprocparametersprefix);
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.puestoloaddvcombo(remoteHandle, context).execute( "SecCodigo", Gx_mode, false, AV7CliCod, AV14SecCodigo, AV8PuestoCodigo, A3CliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      puesto_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      puesto_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      puesto_impl.this.GXt_char6 = GXv_char9[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_seccodigo_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_seccodigo.sendProperty(context, "", false, Combo_seccodigo_Internalname, "SelectedValue_set", Combo_seccodigo_Selectedvalue_set);
      Combo_seccodigo_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_seccodigo.sendProperty(context, "", false, Combo_seccodigo_Internalname, "SelectedText_set", Combo_seccodigo_Selectedtext_set);
      AV20ComboSecCodigo = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSecCodigo", AV20ComboSecCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV14SecCodigo)==0) )
      {
         Combo_seccodigo_Enabled = false ;
         ucCombo_seccodigo.sendProperty(context, "", false, Combo_seccodigo_Internalname, "Enabled", GXutil.booltostr( Combo_seccodigo_Enabled));
      }
   }

   public void zm3L153( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1242PuestoDescripSinAc = T003L3_A1242PuestoDescripSinAc[0] ;
            Z1241PuestoDescrip = T003L3_A1241PuestoDescrip[0] ;
            Z1255PuestoHorasExt = T003L3_A1255PuestoHorasExt[0] ;
         }
         else
         {
            Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
            Z1241PuestoDescrip = A1241PuestoDescrip ;
            Z1255PuestoHorasExt = A1255PuestoHorasExt ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         Z1241PuestoDescrip = A1241PuestoDescrip ;
         Z1255PuestoHorasExt = A1255PuestoHorasExt ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            puesto_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
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
      if ( ! (GXutil.strcmp("", AV14SecCodigo)==0) )
      {
         edtSecCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSecCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV14SecCodigo)==0) )
      {
         edtSecCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8PuestoCodigo)==0) )
      {
         A1240PuestoCodigo = AV8PuestoCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
      }
      if ( ! (GXutil.strcmp("", AV8PuestoCodigo)==0) )
      {
         edtPuestoCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtPuestoCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8PuestoCodigo)==0) )
      {
         edtPuestoCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV14SecCodigo)==0) )
      {
         A13SecCodigo = AV14SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
      else
      {
         A13SecCodigo = AV20ComboSecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
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
         AV21Pgmname = "Puesto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      }
   }

   public void load3L153( )
   {
      /* Using cursor T003L5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = T003L5_A1242PuestoDescripSinAc[0] ;
         A1241PuestoDescrip = T003L5_A1241PuestoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1241PuestoDescrip", A1241PuestoDescrip);
         A1255PuestoHorasExt = T003L5_A1255PuestoHorasExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
         zm3L153( -11) ;
      }
      pr_default.close(3);
      onLoadActions3L153( ) ;
   }

   public void onLoadActions3L153( )
   {
      AV21Pgmname = "Puesto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char9) ;
      puesto_impl.this.GXt_char6 = GXv_char9[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public void checkExtendedTable3L153( )
   {
      nIsDirty_153 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV21Pgmname = "Puesto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      /* Using cursor T003L4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_153 = (short)(1) ;
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char9) ;
      puesto_impl.this.GXt_char6 = GXv_char9[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public void closeExtendedTableCursors3L153( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( int A3CliCod ,
                          String A13SecCodigo )
   {
      /* Using cursor T003L6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECCODIGO");
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

   public void getKey3L153( )
   {
      /* Using cursor T003L7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound153 = (short)(1) ;
      }
      else
      {
         RcdFound153 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3L153( 11) ;
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = T003L3_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = T003L3_A1240PuestoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
         A1241PuestoDescrip = T003L3_A1241PuestoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1241PuestoDescrip", A1241PuestoDescrip);
         A1255PuestoHorasExt = T003L3_A1255PuestoHorasExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
         A3CliCod = T003L3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = T003L3_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3L153( ) ;
         if ( AnyError == 1 )
         {
            RcdFound153 = (short)(0) ;
            initializeNonKey3L153( ) ;
         }
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound153 = (short)(0) ;
         initializeNonKey3L153( ) ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3L153( ) ;
      if ( RcdFound153 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound153 = (short)(0) ;
      /* Using cursor T003L8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A13SecCodigo, A13SecCodigo, Integer.valueOf(A3CliCod), A1240PuestoCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T003L8_A3CliCod[0] < A3CliCod ) || ( T003L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L8_A13SecCodigo[0], A13SecCodigo) < 0 ) || ( GXutil.strcmp(T003L8_A13SecCodigo[0], A13SecCodigo) == 0 ) && ( T003L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L8_A1240PuestoCodigo[0], A1240PuestoCodigo) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T003L8_A3CliCod[0] > A3CliCod ) || ( T003L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L8_A13SecCodigo[0], A13SecCodigo) > 0 ) || ( GXutil.strcmp(T003L8_A13SecCodigo[0], A13SecCodigo) == 0 ) && ( T003L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L8_A1240PuestoCodigo[0], A1240PuestoCodigo) > 0 ) ) )
         {
            A3CliCod = T003L8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A13SecCodigo = T003L8_A13SecCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            A1240PuestoCodigo = T003L8_A1240PuestoCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
            RcdFound153 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound153 = (short)(0) ;
      /* Using cursor T003L9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A13SecCodigo, A13SecCodigo, Integer.valueOf(A3CliCod), A1240PuestoCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T003L9_A3CliCod[0] > A3CliCod ) || ( T003L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L9_A13SecCodigo[0], A13SecCodigo) > 0 ) || ( GXutil.strcmp(T003L9_A13SecCodigo[0], A13SecCodigo) == 0 ) && ( T003L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L9_A1240PuestoCodigo[0], A1240PuestoCodigo) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T003L9_A3CliCod[0] < A3CliCod ) || ( T003L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L9_A13SecCodigo[0], A13SecCodigo) < 0 ) || ( GXutil.strcmp(T003L9_A13SecCodigo[0], A13SecCodigo) == 0 ) && ( T003L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003L9_A1240PuestoCodigo[0], A1240PuestoCodigo) < 0 ) ) )
         {
            A3CliCod = T003L9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A13SecCodigo = T003L9_A13SecCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            A1240PuestoCodigo = T003L9_A1240PuestoCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
            RcdFound153 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3L153( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3L153( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound153 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) || ( GXutil.strcmp(A1240PuestoCodigo, Z1240PuestoCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A13SecCodigo = Z13SecCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
               A1240PuestoCodigo = Z1240PuestoCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3L153( ) ;
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) || ( GXutil.strcmp(A1240PuestoCodigo, Z1240PuestoCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3L153( ) ;
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
                  GX_FocusControl = edtSecCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3L153( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) || ( GXutil.strcmp(A1240PuestoCodigo, Z1240PuestoCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = Z13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         A1240PuestoCodigo = Z1240PuestoCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3L153( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003L2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1242PuestoDescripSinAc, T003L2_A1242PuestoDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z1241PuestoDescrip, T003L2_A1241PuestoDescrip[0]) != 0 ) || ( Z1255PuestoHorasExt != T003L2_A1255PuestoHorasExt[0] ) )
         {
            if ( GXutil.strcmp(Z1242PuestoDescripSinAc, T003L2_A1242PuestoDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("puesto:[seudo value changed for attri]"+"PuestoDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z1242PuestoDescripSinAc);
               GXutil.writeLogRaw("Current: ",T003L2_A1242PuestoDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z1241PuestoDescrip, T003L2_A1241PuestoDescrip[0]) != 0 )
            {
               GXutil.writeLogln("puesto:[seudo value changed for attri]"+"PuestoDescrip");
               GXutil.writeLogRaw("Old: ",Z1241PuestoDescrip);
               GXutil.writeLogRaw("Current: ",T003L2_A1241PuestoDescrip[0]);
            }
            if ( Z1255PuestoHorasExt != T003L2_A1255PuestoHorasExt[0] )
            {
               GXutil.writeLogln("puesto:[seudo value changed for attri]"+"PuestoHorasExt");
               GXutil.writeLogRaw("Old: ",Z1255PuestoHorasExt);
               GXutil.writeLogRaw("Current: ",T003L2_A1255PuestoHorasExt[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Puesto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3L153( )
   {
      beforeValidate3L153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3L153( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3L153( 0) ;
         checkOptimisticConcurrency3L153( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3L153( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3L153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003L10 */
                  pr_default.execute(8, new Object[] {A1242PuestoDescripSinAc, A1240PuestoCodigo, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A3CliCod), A13SecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
                        resetCaption3L0( ) ;
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
            load3L153( ) ;
         }
         endLevel3L153( ) ;
      }
      closeExtendedTableCursors3L153( ) ;
   }

   public void update3L153( )
   {
      beforeValidate3L153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3L153( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3L153( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3L153( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3L153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003L11 */
                  pr_default.execute(9, new Object[] {A1242PuestoDescripSinAc, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3L153( ) ;
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
         endLevel3L153( ) ;
      }
      closeExtendedTableCursors3L153( ) ;
   }

   public void deferredUpdate3L153( )
   {
   }

   public void delete( )
   {
      beforeValidate3L153( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3L153( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3L153( ) ;
         afterConfirm3L153( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3L153( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003L12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
      sMode153 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3L153( ) ;
      Gx_mode = sMode153 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3L153( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV21Pgmname = "Puesto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003L13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionPuesto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T003L14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel3L153( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3L153( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "puesto");
         if ( AnyError == 0 )
         {
            confirmValues3L0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "puesto");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3L153( )
   {
      /* Scan By routine */
      /* Using cursor T003L15 */
      pr_default.execute(13);
      RcdFound153 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A3CliCod = T003L15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = T003L15_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         A1240PuestoCodigo = T003L15_A1240PuestoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3L153( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound153 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A3CliCod = T003L15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = T003L15_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         A1240PuestoCodigo = T003L15_A1240PuestoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
      }
   }

   public void scanEnd3L153( )
   {
      pr_default.close(13);
   }

   public void afterConfirm3L153( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3L153( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3L153( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3L153( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3L153( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3L153( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3L153( )
   {
      edtSecCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      edtPuestoCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), true);
      edtPuestoDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPuestoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoDescrip_Enabled), 5, 0), true);
      chkPuestoHorasExt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "Enabled", GXutil.ltrimstr( chkPuestoHorasExt.getEnabled(), 5, 0), true);
      edtavComboseccodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboseccodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboseccodigo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3L153( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3L0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.puesto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV14SecCodigo)),GXutil.URLEncode(GXutil.rtrim(AV8PuestoCodigo))}, new String[] {"Gx_mode","CliCod","SecCodigo","PuestoCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Puesto");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("puesto:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z13SecCodigo", GXutil.rtrim( Z13SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1240PuestoCodigo", GXutil.rtrim( Z1240PuestoCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1242PuestoDescripSinAc", Z1242PuestoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1241PuestoDescrip", Z1241PuestoDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1255PuestoHorasExt", Z1255PuestoHorasExt);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECCODIGO_DATA", AV15SecCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECCODIGO_DATA", AV15SecCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTODESCRIPSINAC", A1242PuestoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECCODIGO", GXutil.rtrim( AV14SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14SecCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPUESTOCODIGO", GXutil.rtrim( AV8PuestoCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPUESTOCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8PuestoCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV21Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Objectcall", GXutil.rtrim( Combo_seccodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Cls", GXutil.rtrim( Combo_seccodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_seccodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Selectedtext_set", GXutil.rtrim( Combo_seccodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Enabled", GXutil.booltostr( Combo_seccodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Datalistproc", GXutil.rtrim( Combo_seccodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_seccodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Emptyitem", GXutil.booltostr( Combo_seccodigo_Emptyitem));
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
      return formatLink("web.puesto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV14SecCodigo)),GXutil.URLEncode(GXutil.rtrim(AV8PuestoCodigo))}, new String[] {"Gx_mode","CliCod","SecCodigo","PuestoCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Puesto" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Puesto", "") ;
   }

   public void initializeNonKey3L153( )
   {
      A1242PuestoDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
      A1241PuestoDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1241PuestoDescrip", A1241PuestoDescrip);
      A1255PuestoHorasExt = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
      Z1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      Z1255PuestoHorasExt = false ;
   }

   public void initAll3L153( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A13SecCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      A1240PuestoCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1240PuestoCodigo", A1240PuestoCodigo);
      initializeNonKey3L153( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713581826", true, true);
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
      httpContext.AddJavascriptSource("puesto.js", "?20251713581827", false, true);
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
      lblTextblockseccodigo_Internalname = "TEXTBLOCKSECCODIGO" ;
      Combo_seccodigo_Internalname = "COMBO_SECCODIGO" ;
      edtSecCodigo_Internalname = "SECCODIGO" ;
      divTablesplittedseccodigo_Internalname = "TABLESPLITTEDSECCODIGO" ;
      edtPuestoCodigo_Internalname = "PUESTOCODIGO" ;
      edtPuestoDescrip_Internalname = "PUESTODESCRIP" ;
      chkPuestoHorasExt.setInternalname( "PUESTOHORASEXT" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboseccodigo_Internalname = "vCOMBOSECCODIGO" ;
      divSectionattribute_seccodigo_Internalname = "SECTIONATTRIBUTE_SECCODIGO" ;
      edtCliCod_Internalname = "CLICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Puesto", "") );
      Combo_seccodigo_Datalistprocparametersprefix = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboseccodigo_Jsonclick = "" ;
      edtavComboseccodigo_Enabled = 0 ;
      edtavComboseccodigo_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkPuestoHorasExt.setEnabled( 1 );
      edtPuestoDescrip_Enabled = 1 ;
      edtPuestoCodigo_Jsonclick = "" ;
      edtPuestoCodigo_Enabled = 1 ;
      edtSecCodigo_Jsonclick = "" ;
      edtSecCodigo_Enabled = 1 ;
      edtSecCodigo_Visible = 1 ;
      Combo_seccodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_seccodigo_Datalistproc = "PuestoLoadDVCombo" ;
      Combo_seccodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_seccodigo_Caption = "" ;
      Combo_seccodigo_Enabled = GXutil.toBoolean( -1) ;
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

   public void gx1asapuestodescripsinac3L153( String A1241PuestoDescrip )
   {
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char9) ;
      puesto_impl.this.GXt_char6 = GXv_char9[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1242PuestoDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx2asaclicod3L153( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            puesto_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
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
      chkPuestoHorasExt.setName( "PUESTOHORASEXT" );
      chkPuestoHorasExt.setWebtags( "" );
      chkPuestoHorasExt.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "TitleCaption", chkPuestoHorasExt.getCaption(), true);
      chkPuestoHorasExt.setCheckedValue( "false" );
      A1255PuestoHorasExt = GXutil.strtobool( GXutil.booltostr( A1255PuestoHorasExt)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1255PuestoHorasExt", A1255PuestoHorasExt);
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
      /* Using cursor T003L16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Puestodescrip( )
   {
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char9) ;
      puesto_impl.this.GXt_char6 = GXv_char9[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14SecCodigo',fld:'vSECCODIGO',pic:'',hsh:true},{av:'AV8PuestoCodigo',fld:'vPUESTOCODIGO',pic:'',hsh:true},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14SecCodigo',fld:'vSECCODIGO',pic:'',hsh:true},{av:'AV8PuestoCodigo',fld:'vPUESTOCODIGO',pic:'',hsh:true},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123L2',iparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("VALID_SECCODIGO","{handler:'valid_Seccodigo',iparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("VALID_SECCODIGO",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("VALID_PUESTOCODIGO","{handler:'valid_Puestocodigo',iparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("VALID_PUESTOCODIGO",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("VALID_PUESTODESCRIP","{handler:'valid_Puestodescrip',iparms:[{av:'A1241PuestoDescrip',fld:'PUESTODESCRIP',pic:''},{av:'A1242PuestoDescripSinAc',fld:'PUESTODESCRIPSINAC',pic:''},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("VALID_PUESTODESCRIP",",oparms:[{av:'A1242PuestoDescripSinAc',fld:'PUESTODESCRIPSINAC',pic:''},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("VALIDV_COMBOSECCODIGO","{handler:'validv_Comboseccodigo',iparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("VALIDV_COMBOSECCODIGO",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A13SecCodigo',fld:'SECCODIGO',pic:''},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''}]}");
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
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV14SecCodigo = "" ;
      wcpOAV8PuestoCodigo = "" ;
      Z13SecCodigo = "" ;
      Z1240PuestoCodigo = "" ;
      Z1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      Combo_seccodigo_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1241PuestoDescrip = "" ;
      A13SecCodigo = "" ;
      Gx_mode = "" ;
      AV14SecCodigo = "" ;
      AV8PuestoCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockseccodigo_Jsonclick = "" ;
      ucCombo_seccodigo = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15SecCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1240PuestoCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20ComboSecCodigo = "" ;
      A1242PuestoDescripSinAc = "" ;
      AV21Pgmname = "" ;
      Combo_seccodigo_Objectcall = "" ;
      Combo_seccodigo_Class = "" ;
      Combo_seccodigo_Icontype = "" ;
      Combo_seccodigo_Icon = "" ;
      Combo_seccodigo_Tooltip = "" ;
      Combo_seccodigo_Selectedvalue_set = "" ;
      Combo_seccodigo_Selectedtext_set = "" ;
      Combo_seccodigo_Selectedtext_get = "" ;
      Combo_seccodigo_Gamoauthtoken = "" ;
      Combo_seccodigo_Ddointernalname = "" ;
      Combo_seccodigo_Titlecontrolalign = "" ;
      Combo_seccodigo_Dropdownoptionstype = "" ;
      Combo_seccodigo_Titlecontrolidtoreplace = "" ;
      Combo_seccodigo_Datalisttype = "" ;
      Combo_seccodigo_Datalistfixedvalues = "" ;
      Combo_seccodigo_Remoteservicesparameters = "" ;
      Combo_seccodigo_Htmltemplate = "" ;
      Combo_seccodigo_Multiplevaluestype = "" ;
      Combo_seccodigo_Loadingdata = "" ;
      Combo_seccodigo_Noresultsfound = "" ;
      Combo_seccodigo_Emptyitemtext = "" ;
      Combo_seccodigo_Onlyselectedvalues = "" ;
      Combo_seccodigo_Selectalltext = "" ;
      Combo_seccodigo_Multiplevaluesseparator = "" ;
      Combo_seccodigo_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode153 = "" ;
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
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV18ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      T003L5_A1242PuestoDescripSinAc = new String[] {""} ;
      T003L5_A1240PuestoCodigo = new String[] {""} ;
      T003L5_A1241PuestoDescrip = new String[] {""} ;
      T003L5_A1255PuestoHorasExt = new boolean[] {false} ;
      T003L5_A3CliCod = new int[1] ;
      T003L5_A13SecCodigo = new String[] {""} ;
      T003L4_A3CliCod = new int[1] ;
      T003L6_A3CliCod = new int[1] ;
      T003L7_A3CliCod = new int[1] ;
      T003L7_A13SecCodigo = new String[] {""} ;
      T003L7_A1240PuestoCodigo = new String[] {""} ;
      T003L3_A1242PuestoDescripSinAc = new String[] {""} ;
      T003L3_A1240PuestoCodigo = new String[] {""} ;
      T003L3_A1241PuestoDescrip = new String[] {""} ;
      T003L3_A1255PuestoHorasExt = new boolean[] {false} ;
      T003L3_A3CliCod = new int[1] ;
      T003L3_A13SecCodigo = new String[] {""} ;
      T003L8_A3CliCod = new int[1] ;
      T003L8_A13SecCodigo = new String[] {""} ;
      T003L8_A1240PuestoCodigo = new String[] {""} ;
      T003L9_A3CliCod = new int[1] ;
      T003L9_A13SecCodigo = new String[] {""} ;
      T003L9_A1240PuestoCodigo = new String[] {""} ;
      T003L2_A1242PuestoDescripSinAc = new String[] {""} ;
      T003L2_A1240PuestoCodigo = new String[] {""} ;
      T003L2_A1241PuestoDescrip = new String[] {""} ;
      T003L2_A1255PuestoHorasExt = new boolean[] {false} ;
      T003L2_A3CliCod = new int[1] ;
      T003L2_A13SecCodigo = new String[] {""} ;
      T003L13_A3CliCod = new int[1] ;
      T003L13_A1EmpCod = new short[1] ;
      T003L13_A31LiqNro = new int[1] ;
      T003L13_A2145LiqArea = new String[] {""} ;
      T003L13_A2146LiqPuesto = new String[] {""} ;
      T003L14_A3CliCod = new int[1] ;
      T003L14_A1EmpCod = new short[1] ;
      T003L14_A6LegNumero = new int[1] ;
      T003L15_A3CliCod = new int[1] ;
      T003L15_A13SecCodigo = new String[] {""} ;
      T003L15_A1240PuestoCodigo = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int11 = new int[1] ;
      T003L16_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.puesto__default(),
         new Object[] {
             new Object[] {
            T003L2_A1242PuestoDescripSinAc, T003L2_A1240PuestoCodigo, T003L2_A1241PuestoDescrip, T003L2_A1255PuestoHorasExt, T003L2_A3CliCod, T003L2_A13SecCodigo
            }
            , new Object[] {
            T003L3_A1242PuestoDescripSinAc, T003L3_A1240PuestoCodigo, T003L3_A1241PuestoDescrip, T003L3_A1255PuestoHorasExt, T003L3_A3CliCod, T003L3_A13SecCodigo
            }
            , new Object[] {
            T003L4_A3CliCod
            }
            , new Object[] {
            T003L5_A1242PuestoDescripSinAc, T003L5_A1240PuestoCodigo, T003L5_A1241PuestoDescrip, T003L5_A1255PuestoHorasExt, T003L5_A3CliCod, T003L5_A13SecCodigo
            }
            , new Object[] {
            T003L6_A3CliCod
            }
            , new Object[] {
            T003L7_A3CliCod, T003L7_A13SecCodigo, T003L7_A1240PuestoCodigo
            }
            , new Object[] {
            T003L8_A3CliCod, T003L8_A13SecCodigo, T003L8_A1240PuestoCodigo
            }
            , new Object[] {
            T003L9_A3CliCod, T003L9_A13SecCodigo, T003L9_A1240PuestoCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003L13_A3CliCod, T003L13_A1EmpCod, T003L13_A31LiqNro, T003L13_A2145LiqArea, T003L13_A2146LiqPuesto
            }
            , new Object[] {
            T003L14_A3CliCod, T003L14_A1EmpCod, T003L14_A6LegNumero
            }
            , new Object[] {
            T003L15_A3CliCod, T003L15_A13SecCodigo, T003L15_A1240PuestoCodigo
            }
            , new Object[] {
            T003L16_A3CliCod
            }
         }
      );
      AV21Pgmname = "Puesto" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound153 ;
   private short nIsDirty_153 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtSecCodigo_Visible ;
   private int edtSecCodigo_Enabled ;
   private int edtPuestoCodigo_Enabled ;
   private int edtPuestoDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboseccodigo_Visible ;
   private int edtavComboseccodigo_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Combo_seccodigo_Datalistupdateminimumcharacters ;
   private int Combo_seccodigo_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV14SecCodigo ;
   private String wcpOAV8PuestoCodigo ;
   private String Z13SecCodigo ;
   private String Z1240PuestoCodigo ;
   private String Combo_seccodigo_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A13SecCodigo ;
   private String Gx_mode ;
   private String AV14SecCodigo ;
   private String AV8PuestoCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecCodigo_Internalname ;
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
   private String divTablesplittedseccodigo_Internalname ;
   private String lblTextblockseccodigo_Internalname ;
   private String lblTextblockseccodigo_Jsonclick ;
   private String Combo_seccodigo_Caption ;
   private String Combo_seccodigo_Cls ;
   private String Combo_seccodigo_Datalistproc ;
   private String Combo_seccodigo_Internalname ;
   private String TempTags ;
   private String edtSecCodigo_Jsonclick ;
   private String edtPuestoCodigo_Internalname ;
   private String A1240PuestoCodigo ;
   private String edtPuestoCodigo_Jsonclick ;
   private String edtPuestoDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_seccodigo_Internalname ;
   private String edtavComboseccodigo_Internalname ;
   private String AV20ComboSecCodigo ;
   private String edtavComboseccodigo_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV21Pgmname ;
   private String Combo_seccodigo_Objectcall ;
   private String Combo_seccodigo_Class ;
   private String Combo_seccodigo_Icontype ;
   private String Combo_seccodigo_Icon ;
   private String Combo_seccodigo_Tooltip ;
   private String Combo_seccodigo_Selectedvalue_set ;
   private String Combo_seccodigo_Selectedtext_set ;
   private String Combo_seccodigo_Selectedtext_get ;
   private String Combo_seccodigo_Gamoauthtoken ;
   private String Combo_seccodigo_Ddointernalname ;
   private String Combo_seccodigo_Titlecontrolalign ;
   private String Combo_seccodigo_Dropdownoptionstype ;
   private String Combo_seccodigo_Titlecontrolidtoreplace ;
   private String Combo_seccodigo_Datalisttype ;
   private String Combo_seccodigo_Datalistfixedvalues ;
   private String Combo_seccodigo_Datalistprocparametersprefix ;
   private String Combo_seccodigo_Remoteservicesparameters ;
   private String Combo_seccodigo_Htmltemplate ;
   private String Combo_seccodigo_Multiplevaluestype ;
   private String Combo_seccodigo_Loadingdata ;
   private String Combo_seccodigo_Noresultsfound ;
   private String Combo_seccodigo_Emptyitemtext ;
   private String Combo_seccodigo_Onlyselectedvalues ;
   private String Combo_seccodigo_Selectalltext ;
   private String Combo_seccodigo_Multiplevaluesseparator ;
   private String Combo_seccodigo_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode153 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private boolean Z1255PuestoHorasExt ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1255PuestoHorasExt ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_seccodigo_Emptyitem ;
   private boolean Combo_seccodigo_Enabled ;
   private boolean Combo_seccodigo_Visible ;
   private boolean Combo_seccodigo_Allowmultipleselection ;
   private boolean Combo_seccodigo_Isgriditem ;
   private boolean Combo_seccodigo_Hasdescription ;
   private boolean Combo_seccodigo_Includeonlyselectedoption ;
   private boolean Combo_seccodigo_Includeselectalloption ;
   private boolean Combo_seccodigo_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String Z1242PuestoDescripSinAc ;
   private String Z1241PuestoDescrip ;
   private String A1241PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_seccodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkPuestoHorasExt ;
   private IDataStoreProvider pr_default ;
   private String[] T003L5_A1242PuestoDescripSinAc ;
   private String[] T003L5_A1240PuestoCodigo ;
   private String[] T003L5_A1241PuestoDescrip ;
   private boolean[] T003L5_A1255PuestoHorasExt ;
   private int[] T003L5_A3CliCod ;
   private String[] T003L5_A13SecCodigo ;
   private int[] T003L4_A3CliCod ;
   private int[] T003L6_A3CliCod ;
   private int[] T003L7_A3CliCod ;
   private String[] T003L7_A13SecCodigo ;
   private String[] T003L7_A1240PuestoCodigo ;
   private String[] T003L3_A1242PuestoDescripSinAc ;
   private String[] T003L3_A1240PuestoCodigo ;
   private String[] T003L3_A1241PuestoDescrip ;
   private boolean[] T003L3_A1255PuestoHorasExt ;
   private int[] T003L3_A3CliCod ;
   private String[] T003L3_A13SecCodigo ;
   private int[] T003L8_A3CliCod ;
   private String[] T003L8_A13SecCodigo ;
   private String[] T003L8_A1240PuestoCodigo ;
   private int[] T003L9_A3CliCod ;
   private String[] T003L9_A13SecCodigo ;
   private String[] T003L9_A1240PuestoCodigo ;
   private String[] T003L2_A1242PuestoDescripSinAc ;
   private String[] T003L2_A1240PuestoCodigo ;
   private String[] T003L2_A1241PuestoDescrip ;
   private boolean[] T003L2_A1255PuestoHorasExt ;
   private int[] T003L2_A3CliCod ;
   private String[] T003L2_A13SecCodigo ;
   private int[] T003L13_A3CliCod ;
   private short[] T003L13_A1EmpCod ;
   private int[] T003L13_A31LiqNro ;
   private String[] T003L13_A2145LiqArea ;
   private String[] T003L13_A2146LiqPuesto ;
   private int[] T003L14_A3CliCod ;
   private short[] T003L14_A1EmpCod ;
   private int[] T003L14_A6LegNumero ;
   private int[] T003L15_A3CliCod ;
   private String[] T003L15_A13SecCodigo ;
   private String[] T003L15_A1240PuestoCodigo ;
   private int[] T003L16_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15SecCodigo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class puesto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003L2", "SELECT PuestoDescripSinAc, PuestoCodigo, PuestoDescrip, PuestoHorasExt, CliCod, SecCodigo FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?  FOR UPDATE OF Puesto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L3", "SELECT PuestoDescripSinAc, PuestoCodigo, PuestoDescrip, PuestoHorasExt, CliCod, SecCodigo FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L4", "SELECT CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L5", "SELECT TM1.PuestoDescripSinAc, TM1.PuestoCodigo, TM1.PuestoDescrip, TM1.PuestoHorasExt, TM1.CliCod, TM1.SecCodigo FROM Puesto TM1 WHERE TM1.CliCod = ? and TM1.SecCodigo = ( ?) and TM1.PuestoCodigo = ( ?) ORDER BY TM1.CliCod, TM1.SecCodigo, TM1.PuestoCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L6", "SELECT CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L7", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L8", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE ( CliCod > ? or CliCod = ? and SecCodigo > ( ?) or SecCodigo = ( ?) and CliCod = ? and PuestoCodigo > ( ?)) ORDER BY CliCod, SecCodigo, PuestoCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003L9", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE ( CliCod < ? or CliCod = ? and SecCodigo < ( ?) or SecCodigo = ( ?) and CliCod = ? and PuestoCodigo < ( ?)) ORDER BY CliCod DESC, SecCodigo DESC, PuestoCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003L10", "SAVEPOINT gxupdate;INSERT INTO Puesto(PuestoDescripSinAc, PuestoCodigo, PuestoDescrip, PuestoHorasExt, CliCod, SecCodigo, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, 0, 0, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003L11", "SAVEPOINT gxupdate;UPDATE Puesto SET PuestoDescripSinAc=?, PuestoDescrip=?, PuestoHorasExt=?  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003L12", "SAVEPOINT gxupdate;DELETE FROM Puesto  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003L13", "SELECT CliCod, EmpCod, LiqNro, LiqArea, LiqPuesto FROM LiquidacionPuesto WHERE CliCod = ? AND LiqArea = ? AND LiqPuesto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003L14", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ? AND LegPuesCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003L15", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto ORDER BY CliCod, SecCodigo, PuestoCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003L16", "SELECT CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 14 :
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

