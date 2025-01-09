package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipo_obligacion_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A1159TipoOblPaiCod = (short)(GXutil.lval( httpContext.GetPar( "TipoOblPaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A1159TipoOblPaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A1161EmbargaSec = (short)(GXutil.lval( httpContext.GetPar( "EmbargaSec"))) ;
         n1161EmbargaSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A1161EmbargaSec) ;
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
            AV7TipoOblSec = (short)(GXutil.lval( httpContext.GetPar( "TipoOblSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7TipoOblSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOOBLSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7TipoOblSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "tipo_obligacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtTipoOblCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public tipo_obligacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipo_obligacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_obligacion_impl.class ));
   }

   public tipo_obligacion_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkTipoOblAnti = UIFactory.getCheckbox(this);
      cmbTipoOblTotTipo = new HTMLChoice();
      chkTipoOblSoloDescu = UIFactory.getCheckbox(this);
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
      A1167TipoOblAnti = GXutil.strtobool( GXutil.booltostr( A1167TipoOblAnti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
      if ( cmbTipoOblTotTipo.getItemCount() > 0 )
      {
         A1168TipoOblTotTipo = (byte)(GXutil.lval( cmbTipoOblTotTipo.getValidValue(GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoOblTotTipo.setValue( GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoOblTotTipo.getInternalname(), "Values", cmbTipoOblTotTipo.ToJavascriptSource(), true);
      }
      A2346TipoOblSoloDescu = GXutil.strtobool( GXutil.booltostr( A2346TipoOblSoloDescu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoOblSec_Internalname, httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoOblSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoOblSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoOblSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoOblSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoOblCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoOblCodigo_Internalname, GXutil.rtrim( A1164TipoOblCodigo), GXutil.rtrim( localUtil.format( A1164TipoOblCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoOblCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoOblCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoOblDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtTipoOblDescrip_Internalname, A1165TipoOblDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtTipoOblDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedtipooblpaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktipooblpaicod_Internalname, httpContext.getMessage( "Pai Cod", ""), "", "", lblTextblocktipooblpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_tipooblpaicod.setProperty("Caption", Combo_tipooblpaicod_Caption);
      ucCombo_tipooblpaicod.setProperty("Cls", Combo_tipooblpaicod_Cls);
      ucCombo_tipooblpaicod.setProperty("DataListProc", Combo_tipooblpaicod_Datalistproc);
      ucCombo_tipooblpaicod.setProperty("DataListProcParametersPrefix", Combo_tipooblpaicod_Datalistprocparametersprefix);
      ucCombo_tipooblpaicod.setProperty("EmptyItem", Combo_tipooblpaicod_Emptyitem);
      ucCombo_tipooblpaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_tipooblpaicod.setProperty("DropDownOptionsData", AV16TipoOblPaiCod_Data);
      ucCombo_tipooblpaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_tipooblpaicod_Internalname, "COMBO_TIPOOBLPAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoOblPaiCod_Internalname, httpContext.getMessage( "Tipo Obl Pai Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoOblPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1159TipoOblPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoOblPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtTipoOblPaiCod_Visible, edtTipoOblPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_tipo_obligacion.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTipoOblAnti.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkTipoOblAnti.getInternalname(), httpContext.getMessage( "Es por anticipo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTipoOblAnti.getInternalname(), GXutil.booltostr( A1167TipoOblAnti), "", httpContext.getMessage( "Es por anticipo", ""), 1, chkTipoOblAnti.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(48, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,48);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbTipoOblTotTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbTipoOblTotTipo.getInternalname(), httpContext.getMessage( "Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipoOblTotTipo, cmbTipoOblTotTipo.getInternalname(), GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)), 1, cmbTipoOblTotTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbTipoOblTotTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_tipo_obligacion.htm");
      cmbTipoOblTotTipo.setValue( GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoOblTotTipo.getInternalname(), "Values", cmbTipoOblTotTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedembargasec_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockembargasec_Internalname, httpContext.getMessage( "embargabilidad", ""), "", "", lblTextblockembargasec_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_embargasec.setProperty("Caption", Combo_embargasec_Caption);
      ucCombo_embargasec.setProperty("Cls", Combo_embargasec_Cls);
      ucCombo_embargasec.setProperty("DataListProc", Combo_embargasec_Datalistproc);
      ucCombo_embargasec.setProperty("DataListProcParametersPrefix", Combo_embargasec_Datalistprocparametersprefix);
      ucCombo_embargasec.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_embargasec.setProperty("DropDownOptionsData", AV23EmbargaSec_Data);
      ucCombo_embargasec.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_embargasec_Internalname, "COMBO_EMBARGASECContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmbargaSec_Internalname, httpContext.getMessage( "Embargabilidad predefinida", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmbargaSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmbargaSec_Jsonclick, 0, "Attribute", "", "", "", "", edtEmbargaSec_Visible, edtEmbargaSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_obligacion.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTipoOblSoloDescu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkTipoOblSoloDescu.getInternalname(), httpContext.getMessage( "Solo descuentos", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTipoOblSoloDescu.getInternalname(), GXutil.booltostr( A2346TipoOblSoloDescu), "", httpContext.getMessage( "Solo descuentos", ""), 1, chkTipoOblSoloDescu.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(69, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,69);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_obligacion.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_tipooblpaicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombotipooblpaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboTipoOblPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombotipooblpaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombotipooblpaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombotipooblpaicod_Visible, edtavCombotipooblpaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_embargasec_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboembargasec_Internalname, GXutil.ltrim( localUtil.ntoc( AV24ComboEmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboembargasec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboembargasec_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboembargasec_Visible, edtavComboembargasec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_obligacion.htm");
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
      e113C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vTIPOOBLPAICOD_DATA"), AV16TipoOblPaiCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMBARGASEC_DATA"), AV23EmbargaSec_Data);
            /* Read saved values. */
            Z1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1163TipoOblSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1164TipoOblCodigo = httpContext.cgiGet( "Z1164TipoOblCodigo") ;
            Z1165TipoOblDescrip = httpContext.cgiGet( "Z1165TipoOblDescrip") ;
            Z1167TipoOblAnti = GXutil.strtobool( httpContext.cgiGet( "Z1167TipoOblAnti")) ;
            Z1168TipoOblTotTipo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1168TipoOblTotTipo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2346TipoOblSoloDescu = GXutil.strtobool( httpContext.cgiGet( "Z2346TipoOblSoloDescu")) ;
            Z1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1161EmbargaSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1161EmbargaSec = ((0==A1161EmbargaSec) ? true : false) ;
            Z1159TipoOblPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1159TipoOblPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1159TipoOblPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N1159TipoOblPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "N1161EmbargaSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1161EmbargaSec = ((0==A1161EmbargaSec) ? true : false) ;
            AV7TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "vTIPOOBLSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_TipoOblPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOOBLPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14Insert_EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_EMBARGASEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1162EmbargaDescrip = httpContext.cgiGet( "EMBARGADESCRIP") ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_tipooblpaicod_Objectcall = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Objectcall") ;
            Combo_tipooblpaicod_Class = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Class") ;
            Combo_tipooblpaicod_Icontype = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Icontype") ;
            Combo_tipooblpaicod_Icon = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Icon") ;
            Combo_tipooblpaicod_Caption = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Caption") ;
            Combo_tipooblpaicod_Tooltip = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Tooltip") ;
            Combo_tipooblpaicod_Cls = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Cls") ;
            Combo_tipooblpaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Selectedvalue_set") ;
            Combo_tipooblpaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Selectedvalue_get") ;
            Combo_tipooblpaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Selectedtext_set") ;
            Combo_tipooblpaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Selectedtext_get") ;
            Combo_tipooblpaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Gamoauthtoken") ;
            Combo_tipooblpaicod_Ddointernalname = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Ddointernalname") ;
            Combo_tipooblpaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Titlecontrolalign") ;
            Combo_tipooblpaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Dropdownoptionstype") ;
            Combo_tipooblpaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Enabled")) ;
            Combo_tipooblpaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Visible")) ;
            Combo_tipooblpaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Titlecontrolidtoreplace") ;
            Combo_tipooblpaicod_Datalisttype = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Datalisttype") ;
            Combo_tipooblpaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Allowmultipleselection")) ;
            Combo_tipooblpaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Datalistfixedvalues") ;
            Combo_tipooblpaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Isgriditem")) ;
            Combo_tipooblpaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Hasdescription")) ;
            Combo_tipooblpaicod_Datalistproc = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Datalistproc") ;
            Combo_tipooblpaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Datalistprocparametersprefix") ;
            Combo_tipooblpaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Remoteservicesparameters") ;
            Combo_tipooblpaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tipooblpaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Includeonlyselectedoption")) ;
            Combo_tipooblpaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Includeselectalloption")) ;
            Combo_tipooblpaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Emptyitem")) ;
            Combo_tipooblpaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Includeaddnewoption")) ;
            Combo_tipooblpaicod_Htmltemplate = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Htmltemplate") ;
            Combo_tipooblpaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Multiplevaluestype") ;
            Combo_tipooblpaicod_Loadingdata = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Loadingdata") ;
            Combo_tipooblpaicod_Noresultsfound = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Noresultsfound") ;
            Combo_tipooblpaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Emptyitemtext") ;
            Combo_tipooblpaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Onlyselectedvalues") ;
            Combo_tipooblpaicod_Selectalltext = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Selectalltext") ;
            Combo_tipooblpaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Multiplevaluesseparator") ;
            Combo_tipooblpaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Addnewoptiontext") ;
            Combo_tipooblpaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOOBLPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_embargasec_Objectcall = httpContext.cgiGet( "COMBO_EMBARGASEC_Objectcall") ;
            Combo_embargasec_Class = httpContext.cgiGet( "COMBO_EMBARGASEC_Class") ;
            Combo_embargasec_Icontype = httpContext.cgiGet( "COMBO_EMBARGASEC_Icontype") ;
            Combo_embargasec_Icon = httpContext.cgiGet( "COMBO_EMBARGASEC_Icon") ;
            Combo_embargasec_Caption = httpContext.cgiGet( "COMBO_EMBARGASEC_Caption") ;
            Combo_embargasec_Tooltip = httpContext.cgiGet( "COMBO_EMBARGASEC_Tooltip") ;
            Combo_embargasec_Cls = httpContext.cgiGet( "COMBO_EMBARGASEC_Cls") ;
            Combo_embargasec_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMBARGASEC_Selectedvalue_set") ;
            Combo_embargasec_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMBARGASEC_Selectedvalue_get") ;
            Combo_embargasec_Selectedtext_set = httpContext.cgiGet( "COMBO_EMBARGASEC_Selectedtext_set") ;
            Combo_embargasec_Selectedtext_get = httpContext.cgiGet( "COMBO_EMBARGASEC_Selectedtext_get") ;
            Combo_embargasec_Gamoauthtoken = httpContext.cgiGet( "COMBO_EMBARGASEC_Gamoauthtoken") ;
            Combo_embargasec_Ddointernalname = httpContext.cgiGet( "COMBO_EMBARGASEC_Ddointernalname") ;
            Combo_embargasec_Titlecontrolalign = httpContext.cgiGet( "COMBO_EMBARGASEC_Titlecontrolalign") ;
            Combo_embargasec_Dropdownoptionstype = httpContext.cgiGet( "COMBO_EMBARGASEC_Dropdownoptionstype") ;
            Combo_embargasec_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Enabled")) ;
            Combo_embargasec_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Visible")) ;
            Combo_embargasec_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_EMBARGASEC_Titlecontrolidtoreplace") ;
            Combo_embargasec_Datalisttype = httpContext.cgiGet( "COMBO_EMBARGASEC_Datalisttype") ;
            Combo_embargasec_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Allowmultipleselection")) ;
            Combo_embargasec_Datalistfixedvalues = httpContext.cgiGet( "COMBO_EMBARGASEC_Datalistfixedvalues") ;
            Combo_embargasec_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Isgriditem")) ;
            Combo_embargasec_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Hasdescription")) ;
            Combo_embargasec_Datalistproc = httpContext.cgiGet( "COMBO_EMBARGASEC_Datalistproc") ;
            Combo_embargasec_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_EMBARGASEC_Datalistprocparametersprefix") ;
            Combo_embargasec_Remoteservicesparameters = httpContext.cgiGet( "COMBO_EMBARGASEC_Remoteservicesparameters") ;
            Combo_embargasec_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMBARGASEC_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_embargasec_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Includeonlyselectedoption")) ;
            Combo_embargasec_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Includeselectalloption")) ;
            Combo_embargasec_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Emptyitem")) ;
            Combo_embargasec_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARGASEC_Includeaddnewoption")) ;
            Combo_embargasec_Htmltemplate = httpContext.cgiGet( "COMBO_EMBARGASEC_Htmltemplate") ;
            Combo_embargasec_Multiplevaluestype = httpContext.cgiGet( "COMBO_EMBARGASEC_Multiplevaluestype") ;
            Combo_embargasec_Loadingdata = httpContext.cgiGet( "COMBO_EMBARGASEC_Loadingdata") ;
            Combo_embargasec_Noresultsfound = httpContext.cgiGet( "COMBO_EMBARGASEC_Noresultsfound") ;
            Combo_embargasec_Emptyitemtext = httpContext.cgiGet( "COMBO_EMBARGASEC_Emptyitemtext") ;
            Combo_embargasec_Onlyselectedvalues = httpContext.cgiGet( "COMBO_EMBARGASEC_Onlyselectedvalues") ;
            Combo_embargasec_Selectalltext = httpContext.cgiGet( "COMBO_EMBARGASEC_Selectalltext") ;
            Combo_embargasec_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_EMBARGASEC_Multiplevaluesseparator") ;
            Combo_embargasec_Addnewoptiontext = httpContext.cgiGet( "COMBO_EMBARGASEC_Addnewoptiontext") ;
            Combo_embargasec_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMBARGASEC_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoOblSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            A1164TipoOblCodigo = httpContext.cgiGet( edtTipoOblCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
            A1165TipoOblDescrip = httpContext.cgiGet( edtTipoOblDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoOblPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoOblPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOOBLPAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoOblPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1159TipoOblPaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
            }
            else
            {
               A1159TipoOblPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoOblPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
            }
            A1167TipoOblAnti = GXutil.strtobool( httpContext.cgiGet( chkTipoOblAnti.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
            cmbTipoOblTotTipo.setValue( httpContext.cgiGet( cmbTipoOblTotTipo.getInternalname()) );
            A1168TipoOblTotTipo = (byte)(GXutil.lval( httpContext.cgiGet( cmbTipoOblTotTipo.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMBARGASEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmbargaSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1161EmbargaSec = (short)(0) ;
               n1161EmbargaSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            }
            else
            {
               A1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1161EmbargaSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            }
            n1161EmbargaSec = ((0==A1161EmbargaSec) ? true : false) ;
            A2346TipoOblSoloDescu = GXutil.strtobool( httpContext.cgiGet( chkTipoOblSoloDescu.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
            AV21ComboTipoOblPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombotipooblpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboTipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), 4, 0));
            AV24ComboEmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboembargasec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboEmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"tipo_obligacion");
            A1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoOblSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            forbiddenHiddens.add("TipoOblSec", localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1163TipoOblSec != Z1163TipoOblSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("tipo_obligacion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1163TipoOblSec = (short)(GXutil.lval( httpContext.GetPar( "TipoOblSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
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
                  sMode133 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode133 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound133 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3C0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "TIPOOBLSEC");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtTipoOblSec_Internalname ;
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
                        e113C2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123C2 ();
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
         e123C2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3C133( ) ;
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
         disableAttributes3C133( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipooblpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipooblpaicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembargasec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembargasec_Enabled), 5, 0), true);
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

   public void confirm_3C0( )
   {
      beforeValidate3C133( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3C133( ) ;
         }
         else
         {
            checkExtendedTable3C133( ) ;
            closeExtendedTableCursors3C133( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3C0( )
   {
   }

   public void e113C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtEmbargaSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Visible), 5, 0), true);
      AV24ComboEmbargaSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboEmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), 4, 0));
      edtavComboembargasec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembargasec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembargasec_Visible), 5, 0), true);
      edtTipoOblPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblPaiCod_Visible), 5, 0), true);
      AV21ComboTipoOblPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboTipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), 4, 0));
      edtavCombotipooblpaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipooblpaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipooblpaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOTIPOOBLPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOEMBARGASEC' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion_Insert", GXv_boolean5) ;
         tipo_obligacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion_Update", GXv_boolean5) ;
         tipo_obligacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion_Delete", GXv_boolean5) ;
         tipo_obligacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         while ( AV26GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoOblPaiCod") == 0 )
            {
               AV13Insert_TipoOblPaiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TipoOblPaiCod), 4, 0));
               if ( ! (0==AV13Insert_TipoOblPaiCod) )
               {
                  AV21ComboTipoOblPaiCod = AV13Insert_TipoOblPaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboTipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), 4, 0));
                  Combo_tipooblpaicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboTipoOblPaiCod, 4, 0)) ;
                  ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "SelectedValue_set", Combo_tipooblpaicod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "TipoOblPaiCod", "GET", false, AV7TipoOblSec, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  tipo_obligacion_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  tipo_obligacion_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  tipo_obligacion_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_tipooblpaicod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "SelectedText_set", Combo_tipooblpaicod_Selectedtext_set);
                  Combo_tipooblpaicod_Enabled = false ;
                  ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_tipooblpaicod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmbargaSec") == 0 )
            {
               AV14Insert_EmbargaSec = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_EmbargaSec), 4, 0));
               if ( ! (0==AV14Insert_EmbargaSec) )
               {
                  AV24ComboEmbargaSec = AV14Insert_EmbargaSec ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboEmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), 4, 0));
                  Combo_embargasec_Selectedvalue_set = GXutil.trim( GXutil.str( AV24ComboEmbargaSec, 4, 0)) ;
                  ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "SelectedValue_set", Combo_embargasec_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "EmbargaSec", "GET", false, AV7TipoOblSec, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  tipo_obligacion_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  tipo_obligacion_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  tipo_obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_embargasec_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "SelectedText_set", Combo_embargasec_Selectedtext_set);
                  Combo_embargasec_Enabled = false ;
                  ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "Enabled", GXutil.booltostr( Combo_embargasec_Enabled));
               }
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         }
      }
   }

   public void e123C2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'LOADCOMBOEMBARGASEC' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "EmbargaSec", Gx_mode, false, AV7TipoOblSec, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipo_obligacion_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      tipo_obligacion_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      tipo_obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_embargasec_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "SelectedValue_set", Combo_embargasec_Selectedvalue_set);
      Combo_embargasec_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "SelectedText_set", Combo_embargasec_Selectedtext_set);
      AV24ComboEmbargaSec = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboEmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboEmbargaSec), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_embargasec_Enabled = false ;
         ucCombo_embargasec.sendProperty(context, "", false, Combo_embargasec_Internalname, "Enabled", GXutil.booltostr( Combo_embargasec_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOTIPOOBLPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "TipoOblPaiCod", Gx_mode, false, AV7TipoOblSec, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipo_obligacion_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      tipo_obligacion_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      tipo_obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_tipooblpaicod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "SelectedValue_set", Combo_tipooblpaicod_Selectedvalue_set);
      Combo_tipooblpaicod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "SelectedText_set", Combo_tipooblpaicod_Selectedtext_set);
      AV21ComboTipoOblPaiCod = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboTipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboTipoOblPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_tipooblpaicod_Enabled = false ;
         ucCombo_tipooblpaicod.sendProperty(context, "", false, Combo_tipooblpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_tipooblpaicod_Enabled));
      }
   }

   public void zm3C133( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1164TipoOblCodigo = T003C3_A1164TipoOblCodigo[0] ;
            Z1165TipoOblDescrip = T003C3_A1165TipoOblDescrip[0] ;
            Z1167TipoOblAnti = T003C3_A1167TipoOblAnti[0] ;
            Z1168TipoOblTotTipo = T003C3_A1168TipoOblTotTipo[0] ;
            Z2346TipoOblSoloDescu = T003C3_A2346TipoOblSoloDescu[0] ;
            Z1161EmbargaSec = T003C3_A1161EmbargaSec[0] ;
            Z1159TipoOblPaiCod = T003C3_A1159TipoOblPaiCod[0] ;
         }
         else
         {
            Z1164TipoOblCodigo = A1164TipoOblCodigo ;
            Z1165TipoOblDescrip = A1165TipoOblDescrip ;
            Z1167TipoOblAnti = A1167TipoOblAnti ;
            Z1168TipoOblTotTipo = A1168TipoOblTotTipo ;
            Z2346TipoOblSoloDescu = A2346TipoOblSoloDescu ;
            Z1161EmbargaSec = A1161EmbargaSec ;
            Z1159TipoOblPaiCod = A1159TipoOblPaiCod ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z1163TipoOblSec = A1163TipoOblSec ;
         Z1164TipoOblCodigo = A1164TipoOblCodigo ;
         Z1165TipoOblDescrip = A1165TipoOblDescrip ;
         Z1167TipoOblAnti = A1167TipoOblAnti ;
         Z1168TipoOblTotTipo = A1168TipoOblTotTipo ;
         Z2346TipoOblSoloDescu = A2346TipoOblSoloDescu ;
         Z1161EmbargaSec = A1161EmbargaSec ;
         Z1159TipoOblPaiCod = A1159TipoOblPaiCod ;
         Z1162EmbargaDescrip = A1162EmbargaDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      edtTipoOblSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblSec_Enabled), 5, 0), true);
      edtTipoOblSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblSec_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7TipoOblSec) )
      {
         A1163TipoOblSec = AV7TipoOblSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoOblPaiCod) )
      {
         edtTipoOblPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoOblPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtTipoOblPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoOblPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblPaiCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_EmbargaSec) )
      {
         edtEmbargaSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      }
      else
      {
         edtEmbargaSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoOblPaiCod) )
      {
         A1159TipoOblPaiCod = AV13Insert_TipoOblPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
      }
      else
      {
         A1159TipoOblPaiCod = AV21ComboTipoOblPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_EmbargaSec) )
      {
         A1161EmbargaSec = AV14Insert_EmbargaSec ;
         n1161EmbargaSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      }
      else
      {
         if ( (0==AV24ComboEmbargaSec) )
         {
            A1161EmbargaSec = (short)(0) ;
            n1161EmbargaSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            n1161EmbargaSec = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         }
         else
         {
            if ( ! (0==AV24ComboEmbargaSec) )
            {
               A1161EmbargaSec = AV24ComboEmbargaSec ;
               n1161EmbargaSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            }
         }
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
         AV25Pgmname = "tipo_obligacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T003C4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
         A1162EmbargaDescrip = T003C4_A1162EmbargaDescrip[0] ;
         pr_default.close(2);
      }
   }

   public void load3C133( )
   {
      /* Using cursor T003C6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound133 = (short)(1) ;
         A1164TipoOblCodigo = T003C6_A1164TipoOblCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
         A1165TipoOblDescrip = T003C6_A1165TipoOblDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
         A1167TipoOblAnti = T003C6_A1167TipoOblAnti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
         A1168TipoOblTotTipo = T003C6_A1168TipoOblTotTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
         A1162EmbargaDescrip = T003C6_A1162EmbargaDescrip[0] ;
         A2346TipoOblSoloDescu = T003C6_A2346TipoOblSoloDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
         A1161EmbargaSec = T003C6_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003C6_n1161EmbargaSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         A1159TipoOblPaiCod = T003C6_A1159TipoOblPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
         zm3C133( -12) ;
      }
      pr_default.close(4);
      onLoadActions3C133( ) ;
   }

   public void onLoadActions3C133( )
   {
      AV25Pgmname = "tipo_obligacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
   }

   public void checkExtendedTable3C133( )
   {
      nIsDirty_133 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV25Pgmname = "tipo_obligacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      /* Using cursor T003C7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1159TipoOblPaiCod), A1164TipoOblCodigo, Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Tipo Obl Pai Cod", "")+","+httpContext.getMessage( "Código", "")}), 1, "TIPOOBLPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      /* Using cursor T003C5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1159TipoOblPaiCod)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Obl Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( ( A1168TipoOblTotTipo == 0 ) || ( A1168TipoOblTotTipo == 1 ) || ( A1168TipoOblTotTipo == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Total", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOOBLTOTTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoOblTotTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T003C4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A1161EmbargaSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "embargabilidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARGASEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmbargaSec_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A1162EmbargaDescrip = T003C4_A1162EmbargaDescrip[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors3C133( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( short A1159TipoOblPaiCod )
   {
      /* Using cursor T003C8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1159TipoOblPaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Obl Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_14( short A1161EmbargaSec )
   {
      /* Using cursor T003C9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A1161EmbargaSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "embargabilidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARGASEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmbargaSec_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A1162EmbargaDescrip = T003C9_A1162EmbargaDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1162EmbargaDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void getKey3C133( )
   {
      /* Using cursor T003C10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound133 = (short)(1) ;
      }
      else
      {
         RcdFound133 = (short)(0) ;
      }
      pr_default.close(8);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003C3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3C133( 12) ;
         RcdFound133 = (short)(1) ;
         A1163TipoOblSec = T003C3_A1163TipoOblSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         A1164TipoOblCodigo = T003C3_A1164TipoOblCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
         A1165TipoOblDescrip = T003C3_A1165TipoOblDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
         A1167TipoOblAnti = T003C3_A1167TipoOblAnti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
         A1168TipoOblTotTipo = T003C3_A1168TipoOblTotTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
         A2346TipoOblSoloDescu = T003C3_A2346TipoOblSoloDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
         A1161EmbargaSec = T003C3_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003C3_n1161EmbargaSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         A1159TipoOblPaiCod = T003C3_A1159TipoOblPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
         Z1163TipoOblSec = A1163TipoOblSec ;
         sMode133 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3C133( ) ;
         if ( AnyError == 1 )
         {
            RcdFound133 = (short)(0) ;
            initializeNonKey3C133( ) ;
         }
         Gx_mode = sMode133 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound133 = (short)(0) ;
         initializeNonKey3C133( ) ;
         sMode133 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode133 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3C133( ) ;
      if ( RcdFound133 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound133 = (short)(0) ;
      /* Using cursor T003C11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T003C11_A1163TipoOblSec[0] < A1163TipoOblSec ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T003C11_A1163TipoOblSec[0] > A1163TipoOblSec ) ) )
         {
            A1163TipoOblSec = T003C11_A1163TipoOblSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            RcdFound133 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void move_previous( )
   {
      RcdFound133 = (short)(0) ;
      /* Using cursor T003C12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T003C12_A1163TipoOblSec[0] > A1163TipoOblSec ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T003C12_A1163TipoOblSec[0] < A1163TipoOblSec ) ) )
         {
            A1163TipoOblSec = T003C12_A1163TipoOblSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            RcdFound133 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3C133( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtTipoOblCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3C133( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound133 == 1 )
         {
            if ( A1163TipoOblSec != Z1163TipoOblSec )
            {
               A1163TipoOblSec = Z1163TipoOblSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "TIPOOBLSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoOblSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtTipoOblCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3C133( ) ;
               GX_FocusControl = edtTipoOblCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1163TipoOblSec != Z1163TipoOblSec )
            {
               /* Insert record */
               GX_FocusControl = edtTipoOblCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3C133( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "TIPOOBLSEC");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtTipoOblSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtTipoOblCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3C133( ) ;
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
      if ( A1163TipoOblSec != Z1163TipoOblSec )
      {
         A1163TipoOblSec = Z1163TipoOblSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtTipoOblCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3C133( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003C2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1163TipoOblSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_obligacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1164TipoOblCodigo, T003C2_A1164TipoOblCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1165TipoOblDescrip, T003C2_A1165TipoOblDescrip[0]) != 0 ) || ( Z1167TipoOblAnti != T003C2_A1167TipoOblAnti[0] ) || ( Z1168TipoOblTotTipo != T003C2_A1168TipoOblTotTipo[0] ) || ( Z2346TipoOblSoloDescu != T003C2_A2346TipoOblSoloDescu[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1161EmbargaSec != T003C2_A1161EmbargaSec[0] ) || ( Z1159TipoOblPaiCod != T003C2_A1159TipoOblPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z1164TipoOblCodigo, T003C2_A1164TipoOblCodigo[0]) != 0 )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblCodigo");
               GXutil.writeLogRaw("Old: ",Z1164TipoOblCodigo);
               GXutil.writeLogRaw("Current: ",T003C2_A1164TipoOblCodigo[0]);
            }
            if ( GXutil.strcmp(Z1165TipoOblDescrip, T003C2_A1165TipoOblDescrip[0]) != 0 )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblDescrip");
               GXutil.writeLogRaw("Old: ",Z1165TipoOblDescrip);
               GXutil.writeLogRaw("Current: ",T003C2_A1165TipoOblDescrip[0]);
            }
            if ( Z1167TipoOblAnti != T003C2_A1167TipoOblAnti[0] )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblAnti");
               GXutil.writeLogRaw("Old: ",Z1167TipoOblAnti);
               GXutil.writeLogRaw("Current: ",T003C2_A1167TipoOblAnti[0]);
            }
            if ( Z1168TipoOblTotTipo != T003C2_A1168TipoOblTotTipo[0] )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblTotTipo");
               GXutil.writeLogRaw("Old: ",Z1168TipoOblTotTipo);
               GXutil.writeLogRaw("Current: ",T003C2_A1168TipoOblTotTipo[0]);
            }
            if ( Z2346TipoOblSoloDescu != T003C2_A2346TipoOblSoloDescu[0] )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblSoloDescu");
               GXutil.writeLogRaw("Old: ",Z2346TipoOblSoloDescu);
               GXutil.writeLogRaw("Current: ",T003C2_A2346TipoOblSoloDescu[0]);
            }
            if ( Z1161EmbargaSec != T003C2_A1161EmbargaSec[0] )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"EmbargaSec");
               GXutil.writeLogRaw("Old: ",Z1161EmbargaSec);
               GXutil.writeLogRaw("Current: ",T003C2_A1161EmbargaSec[0]);
            }
            if ( Z1159TipoOblPaiCod != T003C2_A1159TipoOblPaiCod[0] )
            {
               GXutil.writeLogln("tipo_obligacion:[seudo value changed for attri]"+"TipoOblPaiCod");
               GXutil.writeLogRaw("Old: ",Z1159TipoOblPaiCod);
               GXutil.writeLogRaw("Current: ",T003C2_A1159TipoOblPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"tipo_obligacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3C133( )
   {
      beforeValidate3C133( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3C133( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3C133( 0) ;
         checkOptimisticConcurrency3C133( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3C133( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3C133( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003C13 */
                  pr_default.execute(11, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Boolean.valueOf(A1167TipoOblAnti), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Short.valueOf(A1159TipoOblPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T003C14 */
                  pr_default.execute(12);
                  A1163TipoOblSec = T003C14_A1163TipoOblSec[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
                  pr_default.close(12);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption3C0( ) ;
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
            load3C133( ) ;
         }
         endLevel3C133( ) ;
      }
      closeExtendedTableCursors3C133( ) ;
   }

   public void update3C133( )
   {
      beforeValidate3C133( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3C133( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3C133( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3C133( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3C133( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003C15 */
                  pr_default.execute(13, new Object[] {A1164TipoOblCodigo, A1165TipoOblDescrip, Boolean.valueOf(A1167TipoOblAnti), Byte.valueOf(A1168TipoOblTotTipo), Boolean.valueOf(A2346TipoOblSoloDescu), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec), Short.valueOf(A1159TipoOblPaiCod), Short.valueOf(A1163TipoOblSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_obligacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3C133( ) ;
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
         endLevel3C133( ) ;
      }
      closeExtendedTableCursors3C133( ) ;
   }

   public void deferredUpdate3C133( )
   {
   }

   public void delete( )
   {
      beforeValidate3C133( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3C133( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3C133( ) ;
         afterConfirm3C133( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3C133( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003C16 */
               pr_default.execute(14, new Object[] {Short.valueOf(A1163TipoOblSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_obligacion");
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
      sMode133 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3C133( ) ;
      Gx_mode = sMode133 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3C133( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "tipo_obligacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T003C17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
         A1162EmbargaDescrip = T003C17_A1162EmbargaDescrip[0] ;
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003C18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A1163TipoOblSec)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void endLevel3C133( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3C133( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "tipo_obligacion");
         if ( AnyError == 0 )
         {
            confirmValues3C0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "tipo_obligacion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3C133( )
   {
      /* Scan By routine */
      /* Using cursor T003C19 */
      pr_default.execute(17);
      RcdFound133 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound133 = (short)(1) ;
         A1163TipoOblSec = T003C19_A1163TipoOblSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3C133( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound133 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound133 = (short)(1) ;
         A1163TipoOblSec = T003C19_A1163TipoOblSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
   }

   public void scanEnd3C133( )
   {
      pr_default.close(17);
   }

   public void afterConfirm3C133( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3C133( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3C133( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3C133( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3C133( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3C133( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3C133( )
   {
      edtTipoOblSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblSec_Enabled), 5, 0), true);
      edtTipoOblCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblCodigo_Enabled), 5, 0), true);
      edtTipoOblDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblDescrip_Enabled), 5, 0), true);
      edtTipoOblPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoOblPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoOblPaiCod_Enabled), 5, 0), true);
      chkTipoOblAnti.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkTipoOblAnti.getInternalname(), "Enabled", GXutil.ltrimstr( chkTipoOblAnti.getEnabled(), 5, 0), true);
      cmbTipoOblTotTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoOblTotTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoOblTotTipo.getEnabled(), 5, 0), true);
      edtEmbargaSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      chkTipoOblSoloDescu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkTipoOblSoloDescu.getInternalname(), "Enabled", GXutil.ltrimstr( chkTipoOblSoloDescu.getEnabled(), 5, 0), true);
      edtavCombotipooblpaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipooblpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipooblpaicod_Enabled), 5, 0), true);
      edtavComboembargasec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembargasec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembargasec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3C133( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3C0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipo_obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7TipoOblSec,4,0))}, new String[] {"Gx_mode","TipoOblSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"tipo_obligacion");
      forbiddenHiddens.add("TipoOblSec", localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("tipo_obligacion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1163TipoOblSec", GXutil.ltrim( localUtil.ntoc( Z1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1164TipoOblCodigo", GXutil.rtrim( Z1164TipoOblCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1165TipoOblDescrip", Z1165TipoOblDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1167TipoOblAnti", Z1167TipoOblAnti);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1168TipoOblTotTipo", GXutil.ltrim( localUtil.ntoc( Z1168TipoOblTotTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2346TipoOblSoloDescu", Z2346TipoOblSoloDescu);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1161EmbargaSec", GXutil.ltrim( localUtil.ntoc( Z1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1159TipoOblPaiCod", GXutil.ltrim( localUtil.ntoc( Z1159TipoOblPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1159TipoOblPaiCod", GXutil.ltrim( localUtil.ntoc( A1159TipoOblPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1161EmbargaSec", GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTIPOOBLPAICOD_DATA", AV16TipoOblPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTIPOOBLPAICOD_DATA", AV16TipoOblPaiCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMBARGASEC_DATA", AV23EmbargaSec_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMBARGASEC_DATA", AV23EmbargaSec_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOOBLSEC", GXutil.ltrim( localUtil.ntoc( AV7TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOOBLSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7TipoOblSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOOBLPAICOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_TipoOblPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_EMBARGASEC", GXutil.ltrim( localUtil.ntoc( AV14Insert_EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMBARGADESCRIP", A1162EmbargaDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Objectcall", GXutil.rtrim( Combo_tipooblpaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Cls", GXutil.rtrim( Combo_tipooblpaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Selectedvalue_set", GXutil.rtrim( Combo_tipooblpaicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Selectedtext_set", GXutil.rtrim( Combo_tipooblpaicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Enabled", GXutil.booltostr( Combo_tipooblpaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Datalistproc", GXutil.rtrim( Combo_tipooblpaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_tipooblpaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOOBLPAICOD_Emptyitem", GXutil.booltostr( Combo_tipooblpaicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Objectcall", GXutil.rtrim( Combo_embargasec_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Cls", GXutil.rtrim( Combo_embargasec_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Selectedvalue_set", GXutil.rtrim( Combo_embargasec_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Selectedtext_set", GXutil.rtrim( Combo_embargasec_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Enabled", GXutil.booltostr( Combo_embargasec_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Datalistproc", GXutil.rtrim( Combo_embargasec_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARGASEC_Datalistprocparametersprefix", GXutil.rtrim( Combo_embargasec_Datalistprocparametersprefix));
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
      return formatLink("web.tipo_obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7TipoOblSec,4,0))}, new String[] {"Gx_mode","TipoOblSec"})  ;
   }

   public String getPgmname( )
   {
      return "tipo_obligacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "tipo_obligacion", "") ;
   }

   public void initializeNonKey3C133( )
   {
      A1159TipoOblPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1159TipoOblPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1159TipoOblPaiCod), 4, 0));
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      n1161EmbargaSec = ((0==A1161EmbargaSec) ? true : false) ;
      A1164TipoOblCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
      A1165TipoOblDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
      A1167TipoOblAnti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
      A1168TipoOblTotTipo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
      A1162EmbargaDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
      A2346TipoOblSoloDescu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
      Z1164TipoOblCodigo = "" ;
      Z1165TipoOblDescrip = "" ;
      Z1167TipoOblAnti = false ;
      Z1168TipoOblTotTipo = (byte)(0) ;
      Z2346TipoOblSoloDescu = false ;
      Z1161EmbargaSec = (short)(0) ;
      Z1159TipoOblPaiCod = (short)(0) ;
   }

   public void initAll3C133( )
   {
      A1163TipoOblSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      initializeNonKey3C133( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181783866", true, true);
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
      httpContext.AddJavascriptSource("tipo_obligacion.js", "?2025181783866", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtTipoOblSec_Internalname = "TIPOOBLSEC" ;
      edtTipoOblCodigo_Internalname = "TIPOOBLCODIGO" ;
      edtTipoOblDescrip_Internalname = "TIPOOBLDESCRIP" ;
      lblTextblocktipooblpaicod_Internalname = "TEXTBLOCKTIPOOBLPAICOD" ;
      Combo_tipooblpaicod_Internalname = "COMBO_TIPOOBLPAICOD" ;
      edtTipoOblPaiCod_Internalname = "TIPOOBLPAICOD" ;
      divTablesplittedtipooblpaicod_Internalname = "TABLESPLITTEDTIPOOBLPAICOD" ;
      chkTipoOblAnti.setInternalname( "TIPOOBLANTI" );
      cmbTipoOblTotTipo.setInternalname( "TIPOOBLTOTTIPO" );
      lblTextblockembargasec_Internalname = "TEXTBLOCKEMBARGASEC" ;
      Combo_embargasec_Internalname = "COMBO_EMBARGASEC" ;
      edtEmbargaSec_Internalname = "EMBARGASEC" ;
      divTablesplittedembargasec_Internalname = "TABLESPLITTEDEMBARGASEC" ;
      chkTipoOblSoloDescu.setInternalname( "TIPOOBLSOLODESCU" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombotipooblpaicod_Internalname = "vCOMBOTIPOOBLPAICOD" ;
      divSectionattribute_tipooblpaicod_Internalname = "SECTIONATTRIBUTE_TIPOOBLPAICOD" ;
      edtavComboembargasec_Internalname = "vCOMBOEMBARGASEC" ;
      divSectionattribute_embargasec_Internalname = "SECTIONATTRIBUTE_EMBARGASEC" ;
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
      Form.setCaption( httpContext.getMessage( "tipo_obligacion", "") );
      edtavComboembargasec_Jsonclick = "" ;
      edtavComboembargasec_Enabled = 0 ;
      edtavComboembargasec_Visible = 1 ;
      edtavCombotipooblpaicod_Jsonclick = "" ;
      edtavCombotipooblpaicod_Enabled = 0 ;
      edtavCombotipooblpaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkTipoOblSoloDescu.setEnabled( 1 );
      edtEmbargaSec_Jsonclick = "" ;
      edtEmbargaSec_Enabled = 1 ;
      edtEmbargaSec_Visible = 1 ;
      Combo_embargasec_Datalistprocparametersprefix = " \"ComboName\": \"EmbargaSec\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"TipoOblSec\": 0" ;
      Combo_embargasec_Datalistproc = "tipo_obligacionLoadDVCombo" ;
      Combo_embargasec_Cls = "ExtendedCombo Attribute" ;
      Combo_embargasec_Caption = "" ;
      Combo_embargasec_Enabled = GXutil.toBoolean( -1) ;
      cmbTipoOblTotTipo.setJsonclick( "" );
      cmbTipoOblTotTipo.setEnabled( 1 );
      chkTipoOblAnti.setEnabled( 1 );
      edtTipoOblPaiCod_Jsonclick = "" ;
      edtTipoOblPaiCod_Enabled = 1 ;
      edtTipoOblPaiCod_Visible = 1 ;
      Combo_tipooblpaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_tipooblpaicod_Datalistprocparametersprefix = " \"ComboName\": \"TipoOblPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"TipoOblSec\": 0" ;
      Combo_tipooblpaicod_Datalistproc = "tipo_obligacionLoadDVCombo" ;
      Combo_tipooblpaicod_Cls = "ExtendedCombo Attribute" ;
      Combo_tipooblpaicod_Caption = "" ;
      Combo_tipooblpaicod_Enabled = GXutil.toBoolean( -1) ;
      edtTipoOblDescrip_Enabled = 1 ;
      edtTipoOblCodigo_Jsonclick = "" ;
      edtTipoOblCodigo_Enabled = 1 ;
      edtTipoOblSec_Jsonclick = "" ;
      edtTipoOblSec_Enabled = 0 ;
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
      chkTipoOblAnti.setName( "TIPOOBLANTI" );
      chkTipoOblAnti.setWebtags( "" );
      chkTipoOblAnti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTipoOblAnti.getInternalname(), "TitleCaption", chkTipoOblAnti.getCaption(), true);
      chkTipoOblAnti.setCheckedValue( "false" );
      A1167TipoOblAnti = GXutil.strtobool( GXutil.booltostr( A1167TipoOblAnti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1167TipoOblAnti", A1167TipoOblAnti);
      cmbTipoOblTotTipo.setName( "TIPOOBLTOTTIPO" );
      cmbTipoOblTotTipo.setWebtags( "" );
      cmbTipoOblTotTipo.addItem("0", httpContext.getMessage( "Sin total", ""), (short)(0));
      cmbTipoOblTotTipo.addItem("1", httpContext.getMessage( "Total fijo", ""), (short)(0));
      cmbTipoOblTotTipo.addItem("2", httpContext.getMessage( "Total liquidado", ""), (short)(0));
      if ( cmbTipoOblTotTipo.getItemCount() > 0 )
      {
         A1168TipoOblTotTipo = (byte)(GXutil.lval( cmbTipoOblTotTipo.getValidValue(GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
      }
      chkTipoOblSoloDescu.setName( "TIPOOBLSOLODESCU" );
      chkTipoOblSoloDescu.setWebtags( "" );
      chkTipoOblSoloDescu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTipoOblSoloDescu.getInternalname(), "TitleCaption", chkTipoOblSoloDescu.getCaption(), true);
      chkTipoOblSoloDescu.setCheckedValue( "false" );
      A2346TipoOblSoloDescu = GXutil.strtobool( GXutil.booltostr( A2346TipoOblSoloDescu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
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

   public void valid_Tipooblpaicod( )
   {
      /* Using cursor T003C20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A1159TipoOblPaiCod)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Obl Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblPaiCod_Internalname ;
      }
      pr_default.close(18);
      /* Using cursor T003C21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A1159TipoOblPaiCod), A1164TipoOblCodigo, Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Tipo Obl Pai Cod", "")+","+httpContext.getMessage( "Código", "")}), 1, "TIPOOBLPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoOblPaiCod_Internalname ;
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Embargasec( )
   {
      n1161EmbargaSec = false ;
      /* Using cursor T003C17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A1161EmbargaSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "embargabilidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARGASEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmbargaSec_Internalname ;
         }
      }
      A1162EmbargaDescrip = T003C17_A1162EmbargaDescrip[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7TipoOblSec',fld:'vTIPOOBLSEC',pic:'ZZZ9',hsh:true},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7TipoOblSec',fld:'vTIPOOBLSEC',pic:'ZZZ9',hsh:true},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123C2',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLSEC","{handler:'valid_Tipooblsec',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALID_TIPOOBLSEC",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLCODIGO","{handler:'valid_Tipooblcodigo',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALID_TIPOOBLCODIGO",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLPAICOD","{handler:'valid_Tipooblpaicod',iparms:[{av:'A1159TipoOblPaiCod',fld:'TIPOOBLPAICOD',pic:'ZZZ9'},{av:'A1164TipoOblCodigo',fld:'TIPOOBLCODIGO',pic:''},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALID_TIPOOBLPAICOD",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLTOTTIPO","{handler:'valid_Tipoobltottipo',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALID_TIPOOBLTOTTIPO",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALID_EMBARGASEC","{handler:'valid_Embargasec',iparms:[{av:'A1161EmbargaSec',fld:'EMBARGASEC',pic:'ZZZ9'},{av:'A1162EmbargaDescrip',fld:'EMBARGADESCRIP',pic:'@!'},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALID_EMBARGASEC",",oparms:[{av:'A1162EmbargaDescrip',fld:'EMBARGADESCRIP',pic:'@!'},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALIDV_COMBOTIPOOBLPAICOD","{handler:'validv_Combotipooblpaicod',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALIDV_COMBOTIPOOBLPAICOD",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
      setEventMetadata("VALIDV_COMBOEMBARGASEC","{handler:'validv_Comboembargasec',iparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("VALIDV_COMBOEMBARGASEC",",oparms:[{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]}");
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
      pr_default.close(15);
      pr_default.close(18);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1164TipoOblCodigo = "" ;
      Z1165TipoOblDescrip = "" ;
      Combo_embargasec_Selectedvalue_get = "" ;
      Combo_tipooblpaicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1164TipoOblCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1165TipoOblDescrip = "" ;
      lblTextblocktipooblpaicod_Jsonclick = "" ;
      ucCombo_tipooblpaicod = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16TipoOblPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockembargasec_Jsonclick = "" ;
      ucCombo_embargasec = new com.genexus.webpanels.GXUserControl();
      AV23EmbargaSec_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1162EmbargaDescrip = "" ;
      AV25Pgmname = "" ;
      Combo_tipooblpaicod_Objectcall = "" ;
      Combo_tipooblpaicod_Class = "" ;
      Combo_tipooblpaicod_Icontype = "" ;
      Combo_tipooblpaicod_Icon = "" ;
      Combo_tipooblpaicod_Tooltip = "" ;
      Combo_tipooblpaicod_Selectedvalue_set = "" ;
      Combo_tipooblpaicod_Selectedtext_set = "" ;
      Combo_tipooblpaicod_Selectedtext_get = "" ;
      Combo_tipooblpaicod_Gamoauthtoken = "" ;
      Combo_tipooblpaicod_Ddointernalname = "" ;
      Combo_tipooblpaicod_Titlecontrolalign = "" ;
      Combo_tipooblpaicod_Dropdownoptionstype = "" ;
      Combo_tipooblpaicod_Titlecontrolidtoreplace = "" ;
      Combo_tipooblpaicod_Datalisttype = "" ;
      Combo_tipooblpaicod_Datalistfixedvalues = "" ;
      Combo_tipooblpaicod_Remoteservicesparameters = "" ;
      Combo_tipooblpaicod_Htmltemplate = "" ;
      Combo_tipooblpaicod_Multiplevaluestype = "" ;
      Combo_tipooblpaicod_Loadingdata = "" ;
      Combo_tipooblpaicod_Noresultsfound = "" ;
      Combo_tipooblpaicod_Emptyitemtext = "" ;
      Combo_tipooblpaicod_Onlyselectedvalues = "" ;
      Combo_tipooblpaicod_Selectalltext = "" ;
      Combo_tipooblpaicod_Multiplevaluesseparator = "" ;
      Combo_tipooblpaicod_Addnewoptiontext = "" ;
      Combo_embargasec_Objectcall = "" ;
      Combo_embargasec_Class = "" ;
      Combo_embargasec_Icontype = "" ;
      Combo_embargasec_Icon = "" ;
      Combo_embargasec_Tooltip = "" ;
      Combo_embargasec_Selectedvalue_set = "" ;
      Combo_embargasec_Selectedtext_set = "" ;
      Combo_embargasec_Selectedtext_get = "" ;
      Combo_embargasec_Gamoauthtoken = "" ;
      Combo_embargasec_Ddointernalname = "" ;
      Combo_embargasec_Titlecontrolalign = "" ;
      Combo_embargasec_Dropdownoptionstype = "" ;
      Combo_embargasec_Titlecontrolidtoreplace = "" ;
      Combo_embargasec_Datalisttype = "" ;
      Combo_embargasec_Datalistfixedvalues = "" ;
      Combo_embargasec_Remoteservicesparameters = "" ;
      Combo_embargasec_Htmltemplate = "" ;
      Combo_embargasec_Multiplevaluestype = "" ;
      Combo_embargasec_Loadingdata = "" ;
      Combo_embargasec_Noresultsfound = "" ;
      Combo_embargasec_Emptyitemtext = "" ;
      Combo_embargasec_Onlyselectedvalues = "" ;
      Combo_embargasec_Selectalltext = "" ;
      Combo_embargasec_Multiplevaluesseparator = "" ;
      Combo_embargasec_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode133 = "" ;
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
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z1162EmbargaDescrip = "" ;
      T003C4_A1162EmbargaDescrip = new String[] {""} ;
      T003C6_A1163TipoOblSec = new short[1] ;
      T003C6_A1164TipoOblCodigo = new String[] {""} ;
      T003C6_A1165TipoOblDescrip = new String[] {""} ;
      T003C6_A1167TipoOblAnti = new boolean[] {false} ;
      T003C6_A1168TipoOblTotTipo = new byte[1] ;
      T003C6_A1162EmbargaDescrip = new String[] {""} ;
      T003C6_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003C6_A1161EmbargaSec = new short[1] ;
      T003C6_n1161EmbargaSec = new boolean[] {false} ;
      T003C6_A1159TipoOblPaiCod = new short[1] ;
      T003C7_A1159TipoOblPaiCod = new short[1] ;
      T003C5_A1159TipoOblPaiCod = new short[1] ;
      T003C8_A1159TipoOblPaiCod = new short[1] ;
      T003C9_A1162EmbargaDescrip = new String[] {""} ;
      T003C10_A1163TipoOblSec = new short[1] ;
      T003C3_A1163TipoOblSec = new short[1] ;
      T003C3_A1164TipoOblCodigo = new String[] {""} ;
      T003C3_A1165TipoOblDescrip = new String[] {""} ;
      T003C3_A1167TipoOblAnti = new boolean[] {false} ;
      T003C3_A1168TipoOblTotTipo = new byte[1] ;
      T003C3_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003C3_A1161EmbargaSec = new short[1] ;
      T003C3_n1161EmbargaSec = new boolean[] {false} ;
      T003C3_A1159TipoOblPaiCod = new short[1] ;
      T003C11_A1163TipoOblSec = new short[1] ;
      T003C12_A1163TipoOblSec = new short[1] ;
      T003C2_A1163TipoOblSec = new short[1] ;
      T003C2_A1164TipoOblCodigo = new String[] {""} ;
      T003C2_A1165TipoOblDescrip = new String[] {""} ;
      T003C2_A1167TipoOblAnti = new boolean[] {false} ;
      T003C2_A1168TipoOblTotTipo = new byte[1] ;
      T003C2_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003C2_A1161EmbargaSec = new short[1] ;
      T003C2_n1161EmbargaSec = new boolean[] {false} ;
      T003C2_A1159TipoOblPaiCod = new short[1] ;
      T003C14_A1163TipoOblSec = new short[1] ;
      T003C17_A1162EmbargaDescrip = new String[] {""} ;
      T003C18_A3CliCod = new int[1] ;
      T003C18_A1EmpCod = new short[1] ;
      T003C18_A6LegNumero = new int[1] ;
      T003C18_A1172OblSecuencial = new short[1] ;
      T003C19_A1163TipoOblSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T003C20_A1159TipoOblPaiCod = new short[1] ;
      T003C21_A1159TipoOblPaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_obligacion__default(),
         new Object[] {
             new Object[] {
            T003C2_A1163TipoOblSec, T003C2_A1164TipoOblCodigo, T003C2_A1165TipoOblDescrip, T003C2_A1167TipoOblAnti, T003C2_A1168TipoOblTotTipo, T003C2_A2346TipoOblSoloDescu, T003C2_A1161EmbargaSec, T003C2_n1161EmbargaSec, T003C2_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C3_A1163TipoOblSec, T003C3_A1164TipoOblCodigo, T003C3_A1165TipoOblDescrip, T003C3_A1167TipoOblAnti, T003C3_A1168TipoOblTotTipo, T003C3_A2346TipoOblSoloDescu, T003C3_A1161EmbargaSec, T003C3_n1161EmbargaSec, T003C3_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C4_A1162EmbargaDescrip
            }
            , new Object[] {
            T003C5_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C6_A1163TipoOblSec, T003C6_A1164TipoOblCodigo, T003C6_A1165TipoOblDescrip, T003C6_A1167TipoOblAnti, T003C6_A1168TipoOblTotTipo, T003C6_A1162EmbargaDescrip, T003C6_A2346TipoOblSoloDescu, T003C6_A1161EmbargaSec, T003C6_n1161EmbargaSec, T003C6_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C7_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C8_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C9_A1162EmbargaDescrip
            }
            , new Object[] {
            T003C10_A1163TipoOblSec
            }
            , new Object[] {
            T003C11_A1163TipoOblSec
            }
            , new Object[] {
            T003C12_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            T003C14_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003C17_A1162EmbargaDescrip
            }
            , new Object[] {
            T003C18_A3CliCod, T003C18_A1EmpCod, T003C18_A6LegNumero, T003C18_A1172OblSecuencial
            }
            , new Object[] {
            T003C19_A1163TipoOblSec
            }
            , new Object[] {
            T003C20_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003C21_A1159TipoOblPaiCod
            }
         }
      );
      AV25Pgmname = "tipo_obligacion" ;
   }

   private byte Z1168TipoOblTotTipo ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1168TipoOblTotTipo ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7TipoOblSec ;
   private short Z1163TipoOblSec ;
   private short Z1161EmbargaSec ;
   private short Z1159TipoOblPaiCod ;
   private short N1159TipoOblPaiCod ;
   private short N1161EmbargaSec ;
   private short A1159TipoOblPaiCod ;
   private short A1161EmbargaSec ;
   private short AV7TipoOblSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1163TipoOblSec ;
   private short AV21ComboTipoOblPaiCod ;
   private short AV24ComboEmbargaSec ;
   private short AV13Insert_TipoOblPaiCod ;
   private short AV14Insert_EmbargaSec ;
   private short RcdFound133 ;
   private short nIsDirty_133 ;
   private int trnEnded ;
   private int edtTipoOblSec_Enabled ;
   private int edtTipoOblCodigo_Enabled ;
   private int edtTipoOblDescrip_Enabled ;
   private int edtTipoOblPaiCod_Visible ;
   private int edtTipoOblPaiCod_Enabled ;
   private int edtEmbargaSec_Visible ;
   private int edtEmbargaSec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombotipooblpaicod_Enabled ;
   private int edtavCombotipooblpaicod_Visible ;
   private int edtavComboembargasec_Enabled ;
   private int edtavComboembargasec_Visible ;
   private int Combo_tipooblpaicod_Datalistupdateminimumcharacters ;
   private int Combo_tipooblpaicod_Gxcontroltype ;
   private int Combo_embargasec_Datalistupdateminimumcharacters ;
   private int Combo_embargasec_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1164TipoOblCodigo ;
   private String Combo_embargasec_Selectedvalue_get ;
   private String Combo_tipooblpaicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtTipoOblCodigo_Internalname ;
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
   private String edtTipoOblSec_Internalname ;
   private String edtTipoOblSec_Jsonclick ;
   private String TempTags ;
   private String A1164TipoOblCodigo ;
   private String edtTipoOblCodigo_Jsonclick ;
   private String edtTipoOblDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablesplittedtipooblpaicod_Internalname ;
   private String lblTextblocktipooblpaicod_Internalname ;
   private String lblTextblocktipooblpaicod_Jsonclick ;
   private String Combo_tipooblpaicod_Caption ;
   private String Combo_tipooblpaicod_Cls ;
   private String Combo_tipooblpaicod_Datalistproc ;
   private String Combo_tipooblpaicod_Datalistprocparametersprefix ;
   private String Combo_tipooblpaicod_Internalname ;
   private String edtTipoOblPaiCod_Internalname ;
   private String edtTipoOblPaiCod_Jsonclick ;
   private String divTablesplittedembargasec_Internalname ;
   private String lblTextblockembargasec_Internalname ;
   private String lblTextblockembargasec_Jsonclick ;
   private String Combo_embargasec_Caption ;
   private String Combo_embargasec_Cls ;
   private String Combo_embargasec_Datalistproc ;
   private String Combo_embargasec_Datalistprocparametersprefix ;
   private String Combo_embargasec_Internalname ;
   private String edtEmbargaSec_Internalname ;
   private String edtEmbargaSec_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_tipooblpaicod_Internalname ;
   private String edtavCombotipooblpaicod_Internalname ;
   private String edtavCombotipooblpaicod_Jsonclick ;
   private String divSectionattribute_embargasec_Internalname ;
   private String edtavComboembargasec_Internalname ;
   private String edtavComboembargasec_Jsonclick ;
   private String AV25Pgmname ;
   private String Combo_tipooblpaicod_Objectcall ;
   private String Combo_tipooblpaicod_Class ;
   private String Combo_tipooblpaicod_Icontype ;
   private String Combo_tipooblpaicod_Icon ;
   private String Combo_tipooblpaicod_Tooltip ;
   private String Combo_tipooblpaicod_Selectedvalue_set ;
   private String Combo_tipooblpaicod_Selectedtext_set ;
   private String Combo_tipooblpaicod_Selectedtext_get ;
   private String Combo_tipooblpaicod_Gamoauthtoken ;
   private String Combo_tipooblpaicod_Ddointernalname ;
   private String Combo_tipooblpaicod_Titlecontrolalign ;
   private String Combo_tipooblpaicod_Dropdownoptionstype ;
   private String Combo_tipooblpaicod_Titlecontrolidtoreplace ;
   private String Combo_tipooblpaicod_Datalisttype ;
   private String Combo_tipooblpaicod_Datalistfixedvalues ;
   private String Combo_tipooblpaicod_Remoteservicesparameters ;
   private String Combo_tipooblpaicod_Htmltemplate ;
   private String Combo_tipooblpaicod_Multiplevaluestype ;
   private String Combo_tipooblpaicod_Loadingdata ;
   private String Combo_tipooblpaicod_Noresultsfound ;
   private String Combo_tipooblpaicod_Emptyitemtext ;
   private String Combo_tipooblpaicod_Onlyselectedvalues ;
   private String Combo_tipooblpaicod_Selectalltext ;
   private String Combo_tipooblpaicod_Multiplevaluesseparator ;
   private String Combo_tipooblpaicod_Addnewoptiontext ;
   private String Combo_embargasec_Objectcall ;
   private String Combo_embargasec_Class ;
   private String Combo_embargasec_Icontype ;
   private String Combo_embargasec_Icon ;
   private String Combo_embargasec_Tooltip ;
   private String Combo_embargasec_Selectedvalue_set ;
   private String Combo_embargasec_Selectedtext_set ;
   private String Combo_embargasec_Selectedtext_get ;
   private String Combo_embargasec_Gamoauthtoken ;
   private String Combo_embargasec_Ddointernalname ;
   private String Combo_embargasec_Titlecontrolalign ;
   private String Combo_embargasec_Dropdownoptionstype ;
   private String Combo_embargasec_Titlecontrolidtoreplace ;
   private String Combo_embargasec_Datalisttype ;
   private String Combo_embargasec_Datalistfixedvalues ;
   private String Combo_embargasec_Remoteservicesparameters ;
   private String Combo_embargasec_Htmltemplate ;
   private String Combo_embargasec_Multiplevaluestype ;
   private String Combo_embargasec_Loadingdata ;
   private String Combo_embargasec_Noresultsfound ;
   private String Combo_embargasec_Emptyitemtext ;
   private String Combo_embargasec_Onlyselectedvalues ;
   private String Combo_embargasec_Selectalltext ;
   private String Combo_embargasec_Multiplevaluesseparator ;
   private String Combo_embargasec_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode133 ;
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
   private boolean Z1167TipoOblAnti ;
   private boolean Z2346TipoOblSoloDescu ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1161EmbargaSec ;
   private boolean wbErr ;
   private boolean A1167TipoOblAnti ;
   private boolean A2346TipoOblSoloDescu ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_tipooblpaicod_Emptyitem ;
   private boolean Combo_tipooblpaicod_Enabled ;
   private boolean Combo_tipooblpaicod_Visible ;
   private boolean Combo_tipooblpaicod_Allowmultipleselection ;
   private boolean Combo_tipooblpaicod_Isgriditem ;
   private boolean Combo_tipooblpaicod_Hasdescription ;
   private boolean Combo_tipooblpaicod_Includeonlyselectedoption ;
   private boolean Combo_tipooblpaicod_Includeselectalloption ;
   private boolean Combo_tipooblpaicod_Includeaddnewoption ;
   private boolean Combo_embargasec_Enabled ;
   private boolean Combo_embargasec_Visible ;
   private boolean Combo_embargasec_Allowmultipleselection ;
   private boolean Combo_embargasec_Isgriditem ;
   private boolean Combo_embargasec_Hasdescription ;
   private boolean Combo_embargasec_Includeonlyselectedoption ;
   private boolean Combo_embargasec_Includeselectalloption ;
   private boolean Combo_embargasec_Emptyitem ;
   private boolean Combo_embargasec_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV20Combo_DataJson ;
   private String Z1165TipoOblDescrip ;
   private String A1165TipoOblDescrip ;
   private String A1162EmbargaDescrip ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z1162EmbargaDescrip ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_tipooblpaicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_embargasec ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkTipoOblAnti ;
   private HTMLChoice cmbTipoOblTotTipo ;
   private ICheckbox chkTipoOblSoloDescu ;
   private IDataStoreProvider pr_default ;
   private String[] T003C4_A1162EmbargaDescrip ;
   private short[] T003C6_A1163TipoOblSec ;
   private String[] T003C6_A1164TipoOblCodigo ;
   private String[] T003C6_A1165TipoOblDescrip ;
   private boolean[] T003C6_A1167TipoOblAnti ;
   private byte[] T003C6_A1168TipoOblTotTipo ;
   private String[] T003C6_A1162EmbargaDescrip ;
   private boolean[] T003C6_A2346TipoOblSoloDescu ;
   private short[] T003C6_A1161EmbargaSec ;
   private boolean[] T003C6_n1161EmbargaSec ;
   private short[] T003C6_A1159TipoOblPaiCod ;
   private short[] T003C7_A1159TipoOblPaiCod ;
   private short[] T003C5_A1159TipoOblPaiCod ;
   private short[] T003C8_A1159TipoOblPaiCod ;
   private String[] T003C9_A1162EmbargaDescrip ;
   private short[] T003C10_A1163TipoOblSec ;
   private short[] T003C3_A1163TipoOblSec ;
   private String[] T003C3_A1164TipoOblCodigo ;
   private String[] T003C3_A1165TipoOblDescrip ;
   private boolean[] T003C3_A1167TipoOblAnti ;
   private byte[] T003C3_A1168TipoOblTotTipo ;
   private boolean[] T003C3_A2346TipoOblSoloDescu ;
   private short[] T003C3_A1161EmbargaSec ;
   private boolean[] T003C3_n1161EmbargaSec ;
   private short[] T003C3_A1159TipoOblPaiCod ;
   private short[] T003C11_A1163TipoOblSec ;
   private short[] T003C12_A1163TipoOblSec ;
   private short[] T003C2_A1163TipoOblSec ;
   private String[] T003C2_A1164TipoOblCodigo ;
   private String[] T003C2_A1165TipoOblDescrip ;
   private boolean[] T003C2_A1167TipoOblAnti ;
   private byte[] T003C2_A1168TipoOblTotTipo ;
   private boolean[] T003C2_A2346TipoOblSoloDescu ;
   private short[] T003C2_A1161EmbargaSec ;
   private boolean[] T003C2_n1161EmbargaSec ;
   private short[] T003C2_A1159TipoOblPaiCod ;
   private short[] T003C14_A1163TipoOblSec ;
   private String[] T003C17_A1162EmbargaDescrip ;
   private int[] T003C18_A3CliCod ;
   private short[] T003C18_A1EmpCod ;
   private int[] T003C18_A6LegNumero ;
   private short[] T003C18_A1172OblSecuencial ;
   private short[] T003C19_A1163TipoOblSec ;
   private short[] T003C20_A1159TipoOblPaiCod ;
   private short[] T003C21_A1159TipoOblPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16TipoOblPaiCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23EmbargaSec_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class tipo_obligacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003C2", "SELECT TipoOblSec, TipoOblCodigo, TipoOblDescrip, TipoOblAnti, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec, TipoOblPaiCod FROM tipo_obligacion WHERE TipoOblSec = ?  FOR UPDATE OF tipo_obligacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C3", "SELECT TipoOblSec, TipoOblCodigo, TipoOblDescrip, TipoOblAnti, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec, TipoOblPaiCod FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C4", "SELECT EmbargaDescrip FROM embargabilidad WHERE EmbargaSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C5", "SELECT PaiCod AS TipoOblPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C6", "SELECT TM1.TipoOblSec, TM1.TipoOblCodigo, TM1.TipoOblDescrip, TM1.TipoOblAnti, TM1.TipoOblTotTipo, T2.EmbargaDescrip, TM1.TipoOblSoloDescu, TM1.EmbargaSec, TM1.TipoOblPaiCod AS TipoOblPaiCod FROM (tipo_obligacion TM1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = TM1.EmbargaSec) WHERE TM1.TipoOblSec = ? ORDER BY TM1.TipoOblSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C7", "SELECT TipoOblPaiCod FROM tipo_obligacion WHERE (TipoOblPaiCod = ? AND TipoOblCodigo = ?) AND (Not ( TipoOblSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C8", "SELECT PaiCod AS TipoOblPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C9", "SELECT EmbargaDescrip FROM embargabilidad WHERE EmbargaSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C10", "SELECT TipoOblSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C11", "SELECT TipoOblSec FROM tipo_obligacion WHERE ( TipoOblSec > ?) ORDER BY TipoOblSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003C12", "SELECT TipoOblSec FROM tipo_obligacion WHERE ( TipoOblSec < ?) ORDER BY TipoOblSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003C13", "SAVEPOINT gxupdate;INSERT INTO tipo_obligacion(TipoOblCodigo, TipoOblDescrip, TipoOblAnti, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec, TipoOblPaiCod) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003C14", "SELECT currval('TipoOblSec') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T003C15", "SAVEPOINT gxupdate;UPDATE tipo_obligacion SET TipoOblCodigo=?, TipoOblDescrip=?, TipoOblAnti=?, TipoOblTotTipo=?, TipoOblSoloDescu=?, EmbargaSec=?, TipoOblPaiCod=?  WHERE TipoOblSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003C16", "SAVEPOINT gxupdate;DELETE FROM tipo_obligacion  WHERE TipoOblSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003C17", "SELECT EmbargaDescrip FROM embargabilidad WHERE EmbargaSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C18", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE TipoOblSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003C19", "SELECT TipoOblSec FROM tipo_obligacion ORDER BY TipoOblSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C20", "SELECT PaiCod AS TipoOblPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003C21", "SELECT TipoOblPaiCod FROM tipo_obligacion WHERE (TipoOblPaiCod = ? AND TipoOblCodigo = ?) AND (Not ( TipoOblSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(9);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[6]).shortValue());
               }
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[6]).shortValue());
               }
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

