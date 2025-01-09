package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class condiciones_concepto_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A1757CondicionPais = (short)(GXutil.lval( httpContext.GetPar( "CondicionPais"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A1757CondicionPais) ;
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
            AV7ConCondicion = httpContext.GetPar( "ConCondicion") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ConCondicion", AV7ConCondicion);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCONDICION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ConCondicion, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Condiciones_concepto", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public condiciones_concepto_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public condiciones_concepto_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condiciones_concepto_impl.class ));
   }

   public condiciones_concepto_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConCondicion = new HTMLChoice();
      chkCondLiqBasica = UIFactory.getCheckbox(this);
      cmbCondSegPla = new HTMLChoice();
      chkCondRestaDias = UIFactory.getCheckbox(this);
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
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), true);
      }
      A1779CondLiqBasica = GXutil.strtobool( GXutil.booltostr( A1779CondLiqBasica)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
      if ( cmbCondSegPla.getItemCount() > 0 )
      {
         A1786CondSegPla = (byte)(GXutil.lval( cmbCondSegPla.getValidValue(GXutil.trim( GXutil.str( A1786CondSegPla, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCondSegPla.setValue( GXutil.trim( GXutil.str( A1786CondSegPla, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCondSegPla.getInternalname(), "Values", cmbCondSegPla.ToJavascriptSource(), true);
      }
      A2133CondRestaDias = GXutil.strtobool( GXutil.booltostr( A2133CondRestaDias)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConCondicion.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConCondicion.getInternalname(), httpContext.getMessage( "Condición para liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConCondicion, cmbConCondicion.getInternalname(), GXutil.rtrim( A953ConCondicion), 1, cmbConCondicion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConCondicion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Condiciones_concepto.htm");
      cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcondicionpais_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcondicionpais_Internalname, httpContext.getMessage( "País", ""), "", "", lblTextblockcondicionpais_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Condiciones_concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_condicionpais.setProperty("Caption", Combo_condicionpais_Caption);
      ucCombo_condicionpais.setProperty("Cls", Combo_condicionpais_Cls);
      ucCombo_condicionpais.setProperty("DataListProc", Combo_condicionpais_Datalistproc);
      ucCombo_condicionpais.setProperty("DataListProcParametersPrefix", Combo_condicionpais_Datalistprocparametersprefix);
      ucCombo_condicionpais.setProperty("EmptyItem", Combo_condicionpais_Emptyitem);
      ucCombo_condicionpais.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_condicionpais.setProperty("DropDownOptionsData", AV15CondicionPais_Data);
      ucCombo_condicionpais.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_condicionpais_Internalname, "COMBO_CONDICIONPAISContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondicionPais_Internalname, httpContext.getMessage( "País", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCondicionPais_Internalname, GXutil.ltrim( localUtil.ntoc( A1757CondicionPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1757CondicionPais), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondicionPais_Jsonclick, 0, "Attribute", "", "", "", "", edtCondicionPais_Visible, edtCondicionPais_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Condiciones_concepto.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondicionDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondicionDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCondicionDescrip_Internalname, A1758CondicionDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtCondicionDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Condiciones_concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondLiqBasica.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCondLiqBasica.getInternalname(), httpContext.getMessage( "Condición es compatible con liquidación básica", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondLiqBasica.getInternalname(), GXutil.booltostr( A1779CondLiqBasica), "", httpContext.getMessage( "Condición es compatible con liquidación básica", ""), 1, chkCondLiqBasica.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(43, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,43);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCondSegPla.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCondSegPla.getInternalname(), httpContext.getMessage( " Si no se cumple la condición, liquidar en segundo plano", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCondSegPla, cmbCondSegPla.getInternalname(), GXutil.trim( GXutil.str( A1786CondSegPla, 1, 0)), 1, cmbCondSegPla.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbCondSegPla.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_Condiciones_concepto.htm");
      cmbCondSegPla.setValue( GXutil.trim( GXutil.str( A1786CondSegPla, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCondSegPla.getInternalname(), "Values", cmbCondSegPla.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondRestaDias.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCondRestaDias.getInternalname(), httpContext.getMessage( "Resta días trabajados cuando el importe es negativo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondRestaDias.getInternalname(), GXutil.booltostr( A2133CondRestaDias), "", httpContext.getMessage( "Resta días trabajados cuando el importe es negativo", ""), 1, chkCondRestaDias.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(53, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,53);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Condiciones_concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Condiciones_concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Condiciones_concepto.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_condicionpais_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocondicionpais_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCondicionPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombocondicionpais_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCondicionPais), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCondicionPais), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocondicionpais_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocondicionpais_Visible, edtavCombocondicionpais_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Condiciones_concepto.htm");
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
      e115A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONDICIONPAIS_DATA"), AV15CondicionPais_Data);
            /* Read saved values. */
            Z953ConCondicion = httpContext.cgiGet( "Z953ConCondicion") ;
            Z1758CondicionDescrip = httpContext.cgiGet( "Z1758CondicionDescrip") ;
            Z1779CondLiqBasica = GXutil.strtobool( httpContext.cgiGet( "Z1779CondLiqBasica")) ;
            Z1786CondSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1786CondSegPla"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2133CondRestaDias = GXutil.strtobool( httpContext.cgiGet( "Z2133CondRestaDias")) ;
            Z1757CondicionPais = (short)(localUtil.ctol( httpContext.cgiGet( "Z1757CondicionPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1757CondicionPais = (short)(localUtil.ctol( httpContext.cgiGet( "N1757CondicionPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7ConCondicion = httpContext.cgiGet( "vCONCONDICION") ;
            AV13Insert_CondicionPais = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CONDICIONPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_condicionpais_Objectcall = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Objectcall") ;
            Combo_condicionpais_Class = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Class") ;
            Combo_condicionpais_Icontype = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Icontype") ;
            Combo_condicionpais_Icon = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Icon") ;
            Combo_condicionpais_Caption = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Caption") ;
            Combo_condicionpais_Tooltip = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Tooltip") ;
            Combo_condicionpais_Cls = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Cls") ;
            Combo_condicionpais_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Selectedvalue_set") ;
            Combo_condicionpais_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Selectedvalue_get") ;
            Combo_condicionpais_Selectedtext_set = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Selectedtext_set") ;
            Combo_condicionpais_Selectedtext_get = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Selectedtext_get") ;
            Combo_condicionpais_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Gamoauthtoken") ;
            Combo_condicionpais_Ddointernalname = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Ddointernalname") ;
            Combo_condicionpais_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Titlecontrolalign") ;
            Combo_condicionpais_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Dropdownoptionstype") ;
            Combo_condicionpais_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Enabled")) ;
            Combo_condicionpais_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Visible")) ;
            Combo_condicionpais_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Titlecontrolidtoreplace") ;
            Combo_condicionpais_Datalisttype = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Datalisttype") ;
            Combo_condicionpais_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Allowmultipleselection")) ;
            Combo_condicionpais_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Datalistfixedvalues") ;
            Combo_condicionpais_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Isgriditem")) ;
            Combo_condicionpais_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Hasdescription")) ;
            Combo_condicionpais_Datalistproc = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Datalistproc") ;
            Combo_condicionpais_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Datalistprocparametersprefix") ;
            Combo_condicionpais_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Remoteservicesparameters") ;
            Combo_condicionpais_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_condicionpais_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Includeonlyselectedoption")) ;
            Combo_condicionpais_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Includeselectalloption")) ;
            Combo_condicionpais_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Emptyitem")) ;
            Combo_condicionpais_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Includeaddnewoption")) ;
            Combo_condicionpais_Htmltemplate = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Htmltemplate") ;
            Combo_condicionpais_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Multiplevaluestype") ;
            Combo_condicionpais_Loadingdata = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Loadingdata") ;
            Combo_condicionpais_Noresultsfound = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Noresultsfound") ;
            Combo_condicionpais_Emptyitemtext = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Emptyitemtext") ;
            Combo_condicionpais_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Onlyselectedvalues") ;
            Combo_condicionpais_Selectalltext = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Selectalltext") ;
            Combo_condicionpais_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Multiplevaluesseparator") ;
            Combo_condicionpais_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONDICIONPAIS_Addnewoptiontext") ;
            Combo_condicionpais_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDICIONPAIS_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            cmbConCondicion.setValue( httpContext.cgiGet( cmbConCondicion.getInternalname()) );
            A953ConCondicion = httpContext.cgiGet( cmbConCondicion.getInternalname()) ;
            n953ConCondicion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCondicionPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCondicionPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONDICIONPAIS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCondicionPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1757CondicionPais = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
            }
            else
            {
               A1757CondicionPais = (short)(localUtil.ctol( httpContext.cgiGet( edtCondicionPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
            }
            A1758CondicionDescrip = httpContext.cgiGet( edtCondicionDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1758CondicionDescrip", A1758CondicionDescrip);
            A1779CondLiqBasica = GXutil.strtobool( httpContext.cgiGet( chkCondLiqBasica.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
            cmbCondSegPla.setValue( httpContext.cgiGet( cmbCondSegPla.getInternalname()) );
            A1786CondSegPla = (byte)(GXutil.lval( httpContext.cgiGet( cmbCondSegPla.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
            A2133CondRestaDias = GXutil.strtobool( httpContext.cgiGet( chkCondRestaDias.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
            AV20ComboCondicionPais = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombocondicionpais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCondicionPais), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Condiciones_concepto");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A953ConCondicion, Z953ConCondicion) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("condiciones_concepto:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A953ConCondicion = httpContext.GetPar( "ConCondicion") ;
               n953ConCondicion = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
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
                  sMode238 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode238 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound238 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5A0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CONCONDICION");
                     AnyError = (short)(1) ;
                     GX_FocusControl = cmbConCondicion.getInternalname() ;
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
                        e115A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125A2 ();
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
         e125A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5A238( ) ;
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
         disableAttributes5A238( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondicionpais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondicionpais_Enabled), 5, 0), true);
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

   public void confirm_5A0( )
   {
      beforeValidate5A238( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5A238( ) ;
         }
         else
         {
            checkExtendedTable5A238( ) ;
            closeExtendedTableCursors5A238( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5A0( )
   {
   }

   public void e115A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCondicionPais_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondicionPais_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondicionPais_Visible), 5, 0), true);
      AV20ComboCondicionPais = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCondicionPais), 4, 0));
      edtavCombocondicionpais_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondicionpais_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondicionpais_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONDICIONPAIS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondiciones_concepto_Insert", GXv_boolean5) ;
         condiciones_concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondiciones_concepto_Update", GXv_boolean5) ;
         condiciones_concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondiciones_concepto_Delete", GXv_boolean5) ;
         condiciones_concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CondicionPais") == 0 )
            {
               AV13Insert_CondicionPais = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CondicionPais), 4, 0));
               if ( ! (0==AV13Insert_CondicionPais) )
               {
                  AV20ComboCondicionPais = AV13Insert_CondicionPais ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCondicionPais), 4, 0));
                  Combo_condicionpais_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboCondicionPais, 4, 0)) ;
                  ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "SelectedValue_set", Combo_condicionpais_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.condiciones_conceptoloaddvcombo(remoteHandle, context).execute( "CondicionPais", "GET", false, AV7ConCondicion, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  condiciones_concepto_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  condiciones_concepto_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  condiciones_concepto_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_condicionpais_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "SelectedText_set", Combo_condicionpais_Selectedtext_set);
                  Combo_condicionpais_Enabled = false ;
                  ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "Enabled", GXutil.booltostr( Combo_condicionpais_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e125A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.ajustartiposliq(remoteHandle, context).execute( 0, A1757CondicionPais, "", A953ConCondicion) ;
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
      /* 'LOADCOMBOCONDICIONPAIS' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.condiciones_conceptoloaddvcombo(remoteHandle, context).execute( "CondicionPais", Gx_mode, false, AV7ConCondicion, "", GXv_char9, GXv_char8, GXv_char7) ;
      condiciones_concepto_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      condiciones_concepto_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      condiciones_concepto_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_condicionpais_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "SelectedValue_set", Combo_condicionpais_Selectedvalue_set);
      Combo_condicionpais_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "SelectedText_set", Combo_condicionpais_Selectedtext_set);
      AV20ComboCondicionPais = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCondicionPais), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_condicionpais_Enabled = false ;
         ucCombo_condicionpais.sendProperty(context, "", false, Combo_condicionpais_Internalname, "Enabled", GXutil.booltostr( Combo_condicionpais_Enabled));
      }
   }

   public void zm5A238( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1758CondicionDescrip = T005A3_A1758CondicionDescrip[0] ;
            Z1779CondLiqBasica = T005A3_A1779CondLiqBasica[0] ;
            Z1786CondSegPla = T005A3_A1786CondSegPla[0] ;
            Z2133CondRestaDias = T005A3_A2133CondRestaDias[0] ;
            Z1757CondicionPais = T005A3_A1757CondicionPais[0] ;
         }
         else
         {
            Z1758CondicionDescrip = A1758CondicionDescrip ;
            Z1779CondLiqBasica = A1779CondLiqBasica ;
            Z1786CondSegPla = A1786CondSegPla ;
            Z2133CondRestaDias = A2133CondRestaDias ;
            Z1757CondicionPais = A1757CondicionPais ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z953ConCondicion = A953ConCondicion ;
         Z1758CondicionDescrip = A1758CondicionDescrip ;
         Z1779CondLiqBasica = A1779CondLiqBasica ;
         Z1786CondSegPla = A1786CondSegPla ;
         Z2133CondRestaDias = A2133CondRestaDias ;
         Z1757CondicionPais = A1757CondicionPais ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7ConCondicion)==0) )
      {
         A953ConCondicion = AV7ConCondicion ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      if ( ! (GXutil.strcmp("", AV7ConCondicion)==0) )
      {
         cmbConCondicion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConCondicion.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7ConCondicion)==0) )
      {
         cmbConCondicion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CondicionPais) )
      {
         edtCondicionPais_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondicionPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondicionPais_Enabled), 5, 0), true);
      }
      else
      {
         edtCondicionPais_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondicionPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondicionPais_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CondicionPais) )
      {
         A1757CondicionPais = AV13Insert_CondicionPais ;
         httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
      }
      else
      {
         A1757CondicionPais = AV20ComboCondicionPais ;
         httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
      }
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
         AV22Pgmname = "Condiciones_concepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load5A238( )
   {
      /* Using cursor T005A5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound238 = (short)(1) ;
         A1758CondicionDescrip = T005A5_A1758CondicionDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1758CondicionDescrip", A1758CondicionDescrip);
         A1779CondLiqBasica = T005A5_A1779CondLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
         A1786CondSegPla = T005A5_A1786CondSegPla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
         A2133CondRestaDias = T005A5_A2133CondRestaDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
         A1757CondicionPais = T005A5_A1757CondicionPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
         zm5A238( -11) ;
      }
      pr_default.close(3);
      onLoadActions5A238( ) ;
   }

   public void onLoadActions5A238( )
   {
      AV22Pgmname = "Condiciones_concepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable5A238( )
   {
      nIsDirty_238 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "Condiciones_concepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      if ( ! ( ( GXutil.strcmp(A953ConCondicion, "A0") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A8") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B2") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B6") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B7") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B15") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "N01") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B16") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B19") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B22") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B23") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B24") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "VP") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "AI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "R1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "MI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "H1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "LA") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "GU") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Condición para liquidación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005A4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1757CondicionPais)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICIONPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCondicionPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A1786CondSegPla == 0 ) || ( A1786CondSegPla == 1 ) || ( A1786CondSegPla == 2 ) || ( A1786CondSegPla == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONDSEGPLA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCondSegPla.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5A238( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( short A1757CondicionPais )
   {
      /* Using cursor T005A6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1757CondicionPais)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICIONPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCondicionPais_Internalname ;
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

   public void getKey5A238( )
   {
      /* Using cursor T005A7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound238 = (short)(1) ;
      }
      else
      {
         RcdFound238 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005A3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5A238( 11) ;
         RcdFound238 = (short)(1) ;
         A953ConCondicion = T005A3_A953ConCondicion[0] ;
         n953ConCondicion = T005A3_n953ConCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         A1758CondicionDescrip = T005A3_A1758CondicionDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1758CondicionDescrip", A1758CondicionDescrip);
         A1779CondLiqBasica = T005A3_A1779CondLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
         A1786CondSegPla = T005A3_A1786CondSegPla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
         A2133CondRestaDias = T005A3_A2133CondRestaDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
         A1757CondicionPais = T005A3_A1757CondicionPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
         Z953ConCondicion = A953ConCondicion ;
         sMode238 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5A238( ) ;
         if ( AnyError == 1 )
         {
            RcdFound238 = (short)(0) ;
            initializeNonKey5A238( ) ;
         }
         Gx_mode = sMode238 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound238 = (short)(0) ;
         initializeNonKey5A238( ) ;
         sMode238 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode238 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5A238( ) ;
      if ( RcdFound238 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound238 = (short)(0) ;
      /* Using cursor T005A8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( GXutil.strcmp(T005A8_A953ConCondicion[0], A953ConCondicion) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( GXutil.strcmp(T005A8_A953ConCondicion[0], A953ConCondicion) > 0 ) ) )
         {
            A953ConCondicion = T005A8_A953ConCondicion[0] ;
            n953ConCondicion = T005A8_n953ConCondicion[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            RcdFound238 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound238 = (short)(0) ;
      /* Using cursor T005A9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T005A9_A953ConCondicion[0], A953ConCondicion) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T005A9_A953ConCondicion[0], A953ConCondicion) < 0 ) ) )
         {
            A953ConCondicion = T005A9_A953ConCondicion[0] ;
            n953ConCondicion = T005A9_n953ConCondicion[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            RcdFound238 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5A238( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5A238( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound238 == 1 )
         {
            if ( GXutil.strcmp(A953ConCondicion, Z953ConCondicion) != 0 )
            {
               A953ConCondicion = Z953ConCondicion ;
               n953ConCondicion = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CONCONDICION");
               AnyError = (short)(1) ;
               GX_FocusControl = cmbConCondicion.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbConCondicion.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5A238( ) ;
               GX_FocusControl = cmbConCondicion.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A953ConCondicion, Z953ConCondicion) != 0 )
            {
               /* Insert record */
               GX_FocusControl = cmbConCondicion.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5A238( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CONCONDICION");
                  AnyError = (short)(1) ;
                  GX_FocusControl = cmbConCondicion.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = cmbConCondicion.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5A238( ) ;
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
      if ( GXutil.strcmp(A953ConCondicion, Z953ConCondicion) != 0 )
      {
         A953ConCondicion = Z953ConCondicion ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CONCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5A238( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005A2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Condiciones_concepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1758CondicionDescrip, T005A2_A1758CondicionDescrip[0]) != 0 ) || ( Z1779CondLiqBasica != T005A2_A1779CondLiqBasica[0] ) || ( Z1786CondSegPla != T005A2_A1786CondSegPla[0] ) || ( Z2133CondRestaDias != T005A2_A2133CondRestaDias[0] ) || ( Z1757CondicionPais != T005A2_A1757CondicionPais[0] ) )
         {
            if ( GXutil.strcmp(Z1758CondicionDescrip, T005A2_A1758CondicionDescrip[0]) != 0 )
            {
               GXutil.writeLogln("condiciones_concepto:[seudo value changed for attri]"+"CondicionDescrip");
               GXutil.writeLogRaw("Old: ",Z1758CondicionDescrip);
               GXutil.writeLogRaw("Current: ",T005A2_A1758CondicionDescrip[0]);
            }
            if ( Z1779CondLiqBasica != T005A2_A1779CondLiqBasica[0] )
            {
               GXutil.writeLogln("condiciones_concepto:[seudo value changed for attri]"+"CondLiqBasica");
               GXutil.writeLogRaw("Old: ",Z1779CondLiqBasica);
               GXutil.writeLogRaw("Current: ",T005A2_A1779CondLiqBasica[0]);
            }
            if ( Z1786CondSegPla != T005A2_A1786CondSegPla[0] )
            {
               GXutil.writeLogln("condiciones_concepto:[seudo value changed for attri]"+"CondSegPla");
               GXutil.writeLogRaw("Old: ",Z1786CondSegPla);
               GXutil.writeLogRaw("Current: ",T005A2_A1786CondSegPla[0]);
            }
            if ( Z2133CondRestaDias != T005A2_A2133CondRestaDias[0] )
            {
               GXutil.writeLogln("condiciones_concepto:[seudo value changed for attri]"+"CondRestaDias");
               GXutil.writeLogRaw("Old: ",Z2133CondRestaDias);
               GXutil.writeLogRaw("Current: ",T005A2_A2133CondRestaDias[0]);
            }
            if ( Z1757CondicionPais != T005A2_A1757CondicionPais[0] )
            {
               GXutil.writeLogln("condiciones_concepto:[seudo value changed for attri]"+"CondicionPais");
               GXutil.writeLogRaw("Old: ",Z1757CondicionPais);
               GXutil.writeLogRaw("Current: ",T005A2_A1757CondicionPais[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Condiciones_concepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5A238( )
   {
      beforeValidate5A238( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5A238( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5A238( 0) ;
         checkOptimisticConcurrency5A238( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5A238( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5A238( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005A10 */
                  pr_default.execute(8, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion, A1758CondicionDescrip, Boolean.valueOf(A1779CondLiqBasica), Byte.valueOf(A1786CondSegPla), Boolean.valueOf(A2133CondRestaDias), Short.valueOf(A1757CondicionPais)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Condiciones_concepto");
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
                        resetCaption5A0( ) ;
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
            load5A238( ) ;
         }
         endLevel5A238( ) ;
      }
      closeExtendedTableCursors5A238( ) ;
   }

   public void update5A238( )
   {
      beforeValidate5A238( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5A238( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5A238( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5A238( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5A238( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005A11 */
                  pr_default.execute(9, new Object[] {A1758CondicionDescrip, Boolean.valueOf(A1779CondLiqBasica), Byte.valueOf(A1786CondSegPla), Boolean.valueOf(A2133CondRestaDias), Short.valueOf(A1757CondicionPais), Boolean.valueOf(n953ConCondicion), A953ConCondicion});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Condiciones_concepto");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Condiciones_concepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5A238( ) ;
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
         endLevel5A238( ) ;
      }
      closeExtendedTableCursors5A238( ) ;
   }

   public void deferredUpdate5A238( )
   {
   }

   public void delete( )
   {
      beforeValidate5A238( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5A238( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5A238( ) ;
         afterConfirm5A238( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5A238( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005A12 */
               pr_default.execute(10, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Condiciones_concepto");
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
      sMode238 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5A238( ) ;
      Gx_mode = sMode238 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5A238( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Condiciones_concepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005A13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T005A14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel5A238( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5A238( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "condiciones_concepto");
         if ( AnyError == 0 )
         {
            confirmValues5A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "condiciones_concepto");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5A238( )
   {
      /* Scan By routine */
      /* Using cursor T005A15 */
      pr_default.execute(13);
      RcdFound238 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound238 = (short)(1) ;
         A953ConCondicion = T005A15_A953ConCondicion[0] ;
         n953ConCondicion = T005A15_n953ConCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5A238( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound238 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound238 = (short)(1) ;
         A953ConCondicion = T005A15_A953ConCondicion[0] ;
         n953ConCondicion = T005A15_n953ConCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
   }

   public void scanEnd5A238( )
   {
      pr_default.close(13);
   }

   public void afterConfirm5A238( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5A238( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5A238( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5A238( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5A238( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5A238( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5A238( )
   {
      cmbConCondicion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      edtCondicionPais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondicionPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondicionPais_Enabled), 5, 0), true);
      edtCondicionDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondicionDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondicionDescrip_Enabled), 5, 0), true);
      chkCondLiqBasica.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCondLiqBasica.getInternalname(), "Enabled", GXutil.ltrimstr( chkCondLiqBasica.getEnabled(), 5, 0), true);
      cmbCondSegPla.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCondSegPla.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCondSegPla.getEnabled(), 5, 0), true);
      chkCondRestaDias.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCondRestaDias.getInternalname(), "Enabled", GXutil.ltrimstr( chkCondRestaDias.getEnabled(), 5, 0), true);
      edtavCombocondicionpais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondicionpais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondicionpais_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5A238( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5A0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.condiciones_concepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7ConCondicion))}, new String[] {"Gx_mode","ConCondicion"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Condiciones_concepto");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("condiciones_concepto:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z953ConCondicion", GXutil.rtrim( Z953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1758CondicionDescrip", Z1758CondicionDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1779CondLiqBasica", Z1779CondLiqBasica);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1786CondSegPla", GXutil.ltrim( localUtil.ntoc( Z1786CondSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2133CondRestaDias", Z2133CondRestaDias);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1757CondicionPais", GXutil.ltrim( localUtil.ntoc( Z1757CondicionPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1757CondicionPais", GXutil.ltrim( localUtil.ntoc( A1757CondicionPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONDICIONPAIS_DATA", AV15CondicionPais_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONDICIONPAIS_DATA", AV15CondicionPais_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCONDICION", GXutil.rtrim( AV7ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCONDICION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ConCondicion, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONDICIONPAIS", GXutil.ltrim( localUtil.ntoc( AV13Insert_CondicionPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Objectcall", GXutil.rtrim( Combo_condicionpais_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Cls", GXutil.rtrim( Combo_condicionpais_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Selectedvalue_set", GXutil.rtrim( Combo_condicionpais_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Selectedtext_set", GXutil.rtrim( Combo_condicionpais_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Enabled", GXutil.booltostr( Combo_condicionpais_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Datalistproc", GXutil.rtrim( Combo_condicionpais_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Datalistprocparametersprefix", GXutil.rtrim( Combo_condicionpais_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDICIONPAIS_Emptyitem", GXutil.booltostr( Combo_condicionpais_Emptyitem));
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
      return formatLink("web.condiciones_concepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7ConCondicion))}, new String[] {"Gx_mode","ConCondicion"})  ;
   }

   public String getPgmname( )
   {
      return "Condiciones_concepto" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Condiciones_concepto", "") ;
   }

   public void initializeNonKey5A238( )
   {
      A1757CondicionPais = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1757CondicionPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1757CondicionPais), 4, 0));
      A1758CondicionDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1758CondicionDescrip", A1758CondicionDescrip);
      A1779CondLiqBasica = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
      A1786CondSegPla = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
      A2133CondRestaDias = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
      Z1758CondicionDescrip = "" ;
      Z1779CondLiqBasica = false ;
      Z1786CondSegPla = (byte)(0) ;
      Z2133CondRestaDias = false ;
      Z1757CondicionPais = (short)(0) ;
   }

   public void initAll5A238( )
   {
      A953ConCondicion = "" ;
      n953ConCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      initializeNonKey5A238( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171332789", true, true);
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
      httpContext.AddJavascriptSource("condiciones_concepto.js", "?2025171332790", false, true);
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
      cmbConCondicion.setInternalname( "CONCONDICION" );
      lblTextblockcondicionpais_Internalname = "TEXTBLOCKCONDICIONPAIS" ;
      Combo_condicionpais_Internalname = "COMBO_CONDICIONPAIS" ;
      edtCondicionPais_Internalname = "CONDICIONPAIS" ;
      divTablesplittedcondicionpais_Internalname = "TABLESPLITTEDCONDICIONPAIS" ;
      edtCondicionDescrip_Internalname = "CONDICIONDESCRIP" ;
      chkCondLiqBasica.setInternalname( "CONDLIQBASICA" );
      cmbCondSegPla.setInternalname( "CONDSEGPLA" );
      chkCondRestaDias.setInternalname( "CONDRESTADIAS" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocondicionpais_Internalname = "vCOMBOCONDICIONPAIS" ;
      divSectionattribute_condicionpais_Internalname = "SECTIONATTRIBUTE_CONDICIONPAIS" ;
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
      Form.setCaption( httpContext.getMessage( "Condiciones_concepto", "") );
      edtavCombocondicionpais_Jsonclick = "" ;
      edtavCombocondicionpais_Enabled = 0 ;
      edtavCombocondicionpais_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkCondRestaDias.setEnabled( 1 );
      cmbCondSegPla.setJsonclick( "" );
      cmbCondSegPla.setEnabled( 1 );
      chkCondLiqBasica.setEnabled( 1 );
      edtCondicionDescrip_Enabled = 1 ;
      edtCondicionPais_Jsonclick = "" ;
      edtCondicionPais_Enabled = 1 ;
      edtCondicionPais_Visible = 1 ;
      Combo_condicionpais_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_condicionpais_Datalistprocparametersprefix = " \"ComboName\": \"CondicionPais\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ConCondicion\": \"\"" ;
      Combo_condicionpais_Datalistproc = "Condiciones_conceptoLoadDVCombo" ;
      Combo_condicionpais_Cls = "ExtendedCombo Attribute" ;
      Combo_condicionpais_Caption = "" ;
      Combo_condicionpais_Enabled = GXutil.toBoolean( -1) ;
      cmbConCondicion.setJsonclick( "" );
      cmbConCondicion.setEnabled( 1 );
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
      cmbConCondicion.setName( "CONCONDICION" );
      cmbConCondicion.setWebtags( "" );
      cmbConCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbConCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbConCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbConCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbConCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbConCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbConCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbConCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbConCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbConCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbConCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbConCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbConCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbConCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbConCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbConCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbConCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbConCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbConCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbConCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbConCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbConCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      chkCondLiqBasica.setName( "CONDLIQBASICA" );
      chkCondLiqBasica.setWebtags( "" );
      chkCondLiqBasica.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCondLiqBasica.getInternalname(), "TitleCaption", chkCondLiqBasica.getCaption(), true);
      chkCondLiqBasica.setCheckedValue( "false" );
      A1779CondLiqBasica = GXutil.strtobool( GXutil.booltostr( A1779CondLiqBasica)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1779CondLiqBasica", A1779CondLiqBasica);
      cmbCondSegPla.setName( "CONDSEGPLA" );
      cmbCondSegPla.setWebtags( "" );
      cmbCondSegPla.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbCondSegPla.addItem("1", httpContext.getMessage( "Sì", ""), (short)(0));
      cmbCondSegPla.addItem("2", httpContext.getMessage( "Si la empresa es agente de retención de ganancias", ""), (short)(0));
      cmbCondSegPla.addItem("3", httpContext.getMessage( "Si se liquida SAC o si la empresa es agente de retención de ganancias", ""), (short)(0));
      if ( cmbCondSegPla.getItemCount() > 0 )
      {
         A1786CondSegPla = (byte)(GXutil.lval( cmbCondSegPla.getValidValue(GXutil.trim( GXutil.str( A1786CondSegPla, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1786CondSegPla", GXutil.str( A1786CondSegPla, 1, 0));
      }
      chkCondRestaDias.setName( "CONDRESTADIAS" );
      chkCondRestaDias.setWebtags( "" );
      chkCondRestaDias.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCondRestaDias.getInternalname(), "TitleCaption", chkCondRestaDias.getCaption(), true);
      chkCondRestaDias.setCheckedValue( "false" );
      A2133CondRestaDias = GXutil.strtobool( GXutil.booltostr( A2133CondRestaDias)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2133CondRestaDias", A2133CondRestaDias);
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

   public void valid_Condicionpais( )
   {
      /* Using cursor T005A16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A1757CondicionPais)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICIONPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCondicionPais_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ConCondicion',fld:'vCONCONDICION',pic:'',hsh:true},{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ConCondicion',fld:'vCONCONDICION',pic:'',hsh:true},{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125A2',iparms:[{av:'A1757CondicionPais',fld:'CONDICIONPAIS',pic:'ZZZ9'},{av:'cmbConCondicion'},{av:'A953ConCondicion',fld:'CONCONDICION',pic:''},{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("VALID_CONCONDICION","{handler:'valid_Concondicion',iparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("VALID_CONCONDICION",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("VALID_CONDICIONPAIS","{handler:'valid_Condicionpais',iparms:[{av:'A1757CondicionPais',fld:'CONDICIONPAIS',pic:'ZZZ9'},{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("VALID_CONDICIONPAIS",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("VALID_CONDSEGPLA","{handler:'valid_Condsegpla',iparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("VALID_CONDSEGPLA",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONDICIONPAIS","{handler:'validv_Combocondicionpais',iparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]");
      setEventMetadata("VALIDV_COMBOCONDICIONPAIS",",oparms:[{av:'A1779CondLiqBasica',fld:'CONDLIQBASICA',pic:''},{av:'A2133CondRestaDias',fld:'CONDRESTADIAS',pic:''}]}");
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
      wcpOAV7ConCondicion = "" ;
      Z953ConCondicion = "" ;
      Z1758CondicionDescrip = "" ;
      Combo_condicionpais_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7ConCondicion = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A953ConCondicion = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      lblTextblockcondicionpais_Jsonclick = "" ;
      ucCombo_condicionpais = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CondicionPais_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      A1758CondicionDescrip = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22Pgmname = "" ;
      Combo_condicionpais_Objectcall = "" ;
      Combo_condicionpais_Class = "" ;
      Combo_condicionpais_Icontype = "" ;
      Combo_condicionpais_Icon = "" ;
      Combo_condicionpais_Tooltip = "" ;
      Combo_condicionpais_Selectedvalue_set = "" ;
      Combo_condicionpais_Selectedtext_set = "" ;
      Combo_condicionpais_Selectedtext_get = "" ;
      Combo_condicionpais_Gamoauthtoken = "" ;
      Combo_condicionpais_Ddointernalname = "" ;
      Combo_condicionpais_Titlecontrolalign = "" ;
      Combo_condicionpais_Dropdownoptionstype = "" ;
      Combo_condicionpais_Titlecontrolidtoreplace = "" ;
      Combo_condicionpais_Datalisttype = "" ;
      Combo_condicionpais_Datalistfixedvalues = "" ;
      Combo_condicionpais_Remoteservicesparameters = "" ;
      Combo_condicionpais_Htmltemplate = "" ;
      Combo_condicionpais_Multiplevaluestype = "" ;
      Combo_condicionpais_Loadingdata = "" ;
      Combo_condicionpais_Noresultsfound = "" ;
      Combo_condicionpais_Emptyitemtext = "" ;
      Combo_condicionpais_Onlyselectedvalues = "" ;
      Combo_condicionpais_Selectalltext = "" ;
      Combo_condicionpais_Multiplevaluesseparator = "" ;
      Combo_condicionpais_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode238 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T005A5_A953ConCondicion = new String[] {""} ;
      T005A5_n953ConCondicion = new boolean[] {false} ;
      T005A5_A1758CondicionDescrip = new String[] {""} ;
      T005A5_A1779CondLiqBasica = new boolean[] {false} ;
      T005A5_A1786CondSegPla = new byte[1] ;
      T005A5_A2133CondRestaDias = new boolean[] {false} ;
      T005A5_A1757CondicionPais = new short[1] ;
      T005A4_A1757CondicionPais = new short[1] ;
      T005A6_A1757CondicionPais = new short[1] ;
      T005A7_A953ConCondicion = new String[] {""} ;
      T005A7_n953ConCondicion = new boolean[] {false} ;
      T005A3_A953ConCondicion = new String[] {""} ;
      T005A3_n953ConCondicion = new boolean[] {false} ;
      T005A3_A1758CondicionDescrip = new String[] {""} ;
      T005A3_A1779CondLiqBasica = new boolean[] {false} ;
      T005A3_A1786CondSegPla = new byte[1] ;
      T005A3_A2133CondRestaDias = new boolean[] {false} ;
      T005A3_A1757CondicionPais = new short[1] ;
      T005A8_A953ConCondicion = new String[] {""} ;
      T005A8_n953ConCondicion = new boolean[] {false} ;
      T005A9_A953ConCondicion = new String[] {""} ;
      T005A9_n953ConCondicion = new boolean[] {false} ;
      T005A2_A953ConCondicion = new String[] {""} ;
      T005A2_n953ConCondicion = new boolean[] {false} ;
      T005A2_A1758CondicionDescrip = new String[] {""} ;
      T005A2_A1779CondLiqBasica = new boolean[] {false} ;
      T005A2_A1786CondSegPla = new byte[1] ;
      T005A2_A2133CondRestaDias = new boolean[] {false} ;
      T005A2_A1757CondicionPais = new short[1] ;
      T005A13_A3CliCod = new int[1] ;
      T005A13_A1EmpCod = new short[1] ;
      T005A13_A6LegNumero = new int[1] ;
      T005A13_A1829PreliqTLiqCod = new String[] {""} ;
      T005A13_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T005A13_A1832PreliqCondicion = new String[] {""} ;
      T005A14_A3CliCod = new int[1] ;
      T005A14_A26ConCodigo = new String[] {""} ;
      T005A15_A953ConCondicion = new String[] {""} ;
      T005A15_n953ConCondicion = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005A16_A1757CondicionPais = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condiciones_concepto__default(),
         new Object[] {
             new Object[] {
            T005A2_A953ConCondicion, T005A2_A1758CondicionDescrip, T005A2_A1779CondLiqBasica, T005A2_A1786CondSegPla, T005A2_A2133CondRestaDias, T005A2_A1757CondicionPais
            }
            , new Object[] {
            T005A3_A953ConCondicion, T005A3_A1758CondicionDescrip, T005A3_A1779CondLiqBasica, T005A3_A1786CondSegPla, T005A3_A2133CondRestaDias, T005A3_A1757CondicionPais
            }
            , new Object[] {
            T005A4_A1757CondicionPais
            }
            , new Object[] {
            T005A5_A953ConCondicion, T005A5_A1758CondicionDescrip, T005A5_A1779CondLiqBasica, T005A5_A1786CondSegPla, T005A5_A2133CondRestaDias, T005A5_A1757CondicionPais
            }
            , new Object[] {
            T005A6_A1757CondicionPais
            }
            , new Object[] {
            T005A7_A953ConCondicion
            }
            , new Object[] {
            T005A8_A953ConCondicion
            }
            , new Object[] {
            T005A9_A953ConCondicion
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005A13_A3CliCod, T005A13_A1EmpCod, T005A13_A6LegNumero, T005A13_A1829PreliqTLiqCod, T005A13_A1830PreliqPeriodo, T005A13_A1832PreliqCondicion
            }
            , new Object[] {
            T005A14_A3CliCod, T005A14_A26ConCodigo
            }
            , new Object[] {
            T005A15_A953ConCondicion
            }
            , new Object[] {
            T005A16_A1757CondicionPais
            }
         }
      );
      AV22Pgmname = "Condiciones_concepto" ;
   }

   private byte Z1786CondSegPla ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1786CondSegPla ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1757CondicionPais ;
   private short N1757CondicionPais ;
   private short A1757CondicionPais ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV20ComboCondicionPais ;
   private short AV13Insert_CondicionPais ;
   private short RcdFound238 ;
   private short nIsDirty_238 ;
   private int trnEnded ;
   private int edtCondicionPais_Visible ;
   private int edtCondicionPais_Enabled ;
   private int edtCondicionDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombocondicionpais_Enabled ;
   private int edtavCombocondicionpais_Visible ;
   private int Combo_condicionpais_Datalistupdateminimumcharacters ;
   private int Combo_condicionpais_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7ConCondicion ;
   private String Z953ConCondicion ;
   private String Combo_condicionpais_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7ConCondicion ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A953ConCondicion ;
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
   private String divTablesplittedcondicionpais_Internalname ;
   private String lblTextblockcondicionpais_Internalname ;
   private String lblTextblockcondicionpais_Jsonclick ;
   private String Combo_condicionpais_Caption ;
   private String Combo_condicionpais_Cls ;
   private String Combo_condicionpais_Datalistproc ;
   private String Combo_condicionpais_Datalistprocparametersprefix ;
   private String Combo_condicionpais_Internalname ;
   private String edtCondicionPais_Internalname ;
   private String edtCondicionPais_Jsonclick ;
   private String edtCondicionDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_condicionpais_Internalname ;
   private String edtavCombocondicionpais_Internalname ;
   private String edtavCombocondicionpais_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_condicionpais_Objectcall ;
   private String Combo_condicionpais_Class ;
   private String Combo_condicionpais_Icontype ;
   private String Combo_condicionpais_Icon ;
   private String Combo_condicionpais_Tooltip ;
   private String Combo_condicionpais_Selectedvalue_set ;
   private String Combo_condicionpais_Selectedtext_set ;
   private String Combo_condicionpais_Selectedtext_get ;
   private String Combo_condicionpais_Gamoauthtoken ;
   private String Combo_condicionpais_Ddointernalname ;
   private String Combo_condicionpais_Titlecontrolalign ;
   private String Combo_condicionpais_Dropdownoptionstype ;
   private String Combo_condicionpais_Titlecontrolidtoreplace ;
   private String Combo_condicionpais_Datalisttype ;
   private String Combo_condicionpais_Datalistfixedvalues ;
   private String Combo_condicionpais_Remoteservicesparameters ;
   private String Combo_condicionpais_Htmltemplate ;
   private String Combo_condicionpais_Multiplevaluestype ;
   private String Combo_condicionpais_Loadingdata ;
   private String Combo_condicionpais_Noresultsfound ;
   private String Combo_condicionpais_Emptyitemtext ;
   private String Combo_condicionpais_Onlyselectedvalues ;
   private String Combo_condicionpais_Selectalltext ;
   private String Combo_condicionpais_Multiplevaluesseparator ;
   private String Combo_condicionpais_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode238 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z1779CondLiqBasica ;
   private boolean Z2133CondRestaDias ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n953ConCondicion ;
   private boolean A1779CondLiqBasica ;
   private boolean A2133CondRestaDias ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_condicionpais_Emptyitem ;
   private boolean Combo_condicionpais_Enabled ;
   private boolean Combo_condicionpais_Visible ;
   private boolean Combo_condicionpais_Allowmultipleselection ;
   private boolean Combo_condicionpais_Isgriditem ;
   private boolean Combo_condicionpais_Hasdescription ;
   private boolean Combo_condicionpais_Includeonlyselectedoption ;
   private boolean Combo_condicionpais_Includeselectalloption ;
   private boolean Combo_condicionpais_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String Z1758CondicionDescrip ;
   private String A1758CondicionDescrip ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_condicionpais ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConCondicion ;
   private ICheckbox chkCondLiqBasica ;
   private HTMLChoice cmbCondSegPla ;
   private ICheckbox chkCondRestaDias ;
   private IDataStoreProvider pr_default ;
   private String[] T005A5_A953ConCondicion ;
   private boolean[] T005A5_n953ConCondicion ;
   private String[] T005A5_A1758CondicionDescrip ;
   private boolean[] T005A5_A1779CondLiqBasica ;
   private byte[] T005A5_A1786CondSegPla ;
   private boolean[] T005A5_A2133CondRestaDias ;
   private short[] T005A5_A1757CondicionPais ;
   private short[] T005A4_A1757CondicionPais ;
   private short[] T005A6_A1757CondicionPais ;
   private String[] T005A7_A953ConCondicion ;
   private boolean[] T005A7_n953ConCondicion ;
   private String[] T005A3_A953ConCondicion ;
   private boolean[] T005A3_n953ConCondicion ;
   private String[] T005A3_A1758CondicionDescrip ;
   private boolean[] T005A3_A1779CondLiqBasica ;
   private byte[] T005A3_A1786CondSegPla ;
   private boolean[] T005A3_A2133CondRestaDias ;
   private short[] T005A3_A1757CondicionPais ;
   private String[] T005A8_A953ConCondicion ;
   private boolean[] T005A8_n953ConCondicion ;
   private String[] T005A9_A953ConCondicion ;
   private boolean[] T005A9_n953ConCondicion ;
   private String[] T005A2_A953ConCondicion ;
   private boolean[] T005A2_n953ConCondicion ;
   private String[] T005A2_A1758CondicionDescrip ;
   private boolean[] T005A2_A1779CondLiqBasica ;
   private byte[] T005A2_A1786CondSegPla ;
   private boolean[] T005A2_A2133CondRestaDias ;
   private short[] T005A2_A1757CondicionPais ;
   private int[] T005A13_A3CliCod ;
   private short[] T005A13_A1EmpCod ;
   private int[] T005A13_A6LegNumero ;
   private String[] T005A13_A1829PreliqTLiqCod ;
   private java.util.Date[] T005A13_A1830PreliqPeriodo ;
   private String[] T005A13_A1832PreliqCondicion ;
   private int[] T005A14_A3CliCod ;
   private String[] T005A14_A26ConCodigo ;
   private String[] T005A15_A953ConCondicion ;
   private boolean[] T005A15_n953ConCondicion ;
   private short[] T005A16_A1757CondicionPais ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CondicionPais_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class condiciones_concepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005A2", "SELECT ConCondicion, CondicionDescrip, CondLiqBasica, CondSegPla, CondRestaDias, CondicionPais FROM Condiciones_concepto WHERE ConCondicion = ?  FOR UPDATE OF Condiciones_concepto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A3", "SELECT ConCondicion, CondicionDescrip, CondLiqBasica, CondSegPla, CondRestaDias, CondicionPais FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A4", "SELECT PaiCod AS CondicionPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A5", "SELECT TM1.ConCondicion, TM1.CondicionDescrip, TM1.CondLiqBasica, TM1.CondSegPla, TM1.CondRestaDias, TM1.CondicionPais AS CondicionPais FROM Condiciones_concepto TM1 WHERE TM1.ConCondicion = ( ?) ORDER BY TM1.ConCondicion ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A6", "SELECT PaiCod AS CondicionPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A7", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A8", "SELECT ConCondicion FROM Condiciones_concepto WHERE ( ConCondicion > ( ?)) ORDER BY ConCondicion  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005A9", "SELECT ConCondicion FROM Condiciones_concepto WHERE ( ConCondicion < ( ?)) ORDER BY ConCondicion DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005A10", "SAVEPOINT gxupdate;INSERT INTO Condiciones_concepto(ConCondicion, CondicionDescrip, CondLiqBasica, CondSegPla, CondRestaDias, CondicionPais) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005A11", "SAVEPOINT gxupdate;UPDATE Condiciones_concepto SET CondicionDescrip=?, CondLiqBasica=?, CondSegPla=?, CondRestaDias=?, CondicionPais=?  WHERE ConCondicion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005A12", "SAVEPOINT gxupdate;DELETE FROM Condiciones_concepto  WHERE ConCondicion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005A13", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo, PreliqCondicion FROM LegPreliqCondicionesExclu WHERE PreliqCondicion = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005A14", "SELECT CliCod, ConCodigo FROM Concepto WHERE ConCondicion = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005A15", "SELECT ConCondicion FROM Condiciones_concepto ORDER BY ConCondicion ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005A16", "SELECT PaiCod AS CondicionPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
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
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
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
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

