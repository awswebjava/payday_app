package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacion_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A3CliCod, A26ConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = httpContext.GetPar( "TLiqCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A3CliCod, A32TLiqCod) ;
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
            AV8ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ConCodigo", AV8ConCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConCodigo, ""))));
            AV9TLiqCod = httpContext.GetPar( "TLiqCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9TLiqCod", AV9TLiqCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTLIQCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9TLiqCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Concepto Tipo Liquidacion", ""), (short)(0)) ;
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

   public conceptotipoliquidacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptotipoliquidacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacion_impl.class ));
   }

   public conceptotipoliquidacion_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConTLVigencia = new HTMLChoice();
      cmbConTLCondicion = new HTMLChoice();
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
      if ( cmbConTLVigencia.getItemCount() > 0 )
      {
         A1409ConTLVigencia = (byte)(GXutil.lval( cmbConTLVigencia.getValidValue(GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0))))) ;
         n1409ConTLVigencia = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConTLVigencia.setValue( GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConTLVigencia.getInternalname(), "Values", cmbConTLVigencia.ToJavascriptSource(), true);
      }
      if ( cmbConTLCondicion.getItemCount() > 0 )
      {
         A1410ConTLCondicion = cmbConTLCondicion.getValidValue(A1410ConTLCondicion) ;
         n1410ConTLCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConTLCondicion.setValue( GXutil.rtrim( A1410ConTLCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConTLCondicion.getInternalname(), "Values", cmbConTLCondicion.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV15CliCod_Data);
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconcodigo_Internalname, httpContext.getMessage( "Código", ""), "", "", lblTextblockconcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_concodigo.setProperty("Caption", Combo_concodigo_Caption);
      ucCombo_concodigo.setProperty("Cls", Combo_concodigo_Cls);
      ucCombo_concodigo.setProperty("DataListProc", Combo_concodigo_Datalistproc);
      ucCombo_concodigo.setProperty("EmptyItem", Combo_concodigo_Emptyitem);
      ucCombo_concodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_concodigo.setProperty("DropDownOptionsData", AV21ConCodigo_Data);
      ucCombo_concodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concodigo_Internalname, "COMBO_CONCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtConCodigo_Visible, edtConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedtliqcod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktliqcod_Internalname, httpContext.getMessage( "Tipo Liquidacion", ""), "", "", lblTextblocktliqcod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_tliqcod.setProperty("Caption", Combo_tliqcod_Caption);
      ucCombo_tliqcod.setProperty("Cls", Combo_tliqcod_Cls);
      ucCombo_tliqcod.setProperty("DataListProc", Combo_tliqcod_Datalistproc);
      ucCombo_tliqcod.setProperty("EmptyItem", Combo_tliqcod_Emptyitem);
      ucCombo_tliqcod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_tliqcod.setProperty("DropDownOptionsData", AV24TLiqCod_Data);
      ucCombo_tliqcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_tliqcod_Internalname, "COMBO_TLIQCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTLiqCod_Internalname, httpContext.getMessage( "Tipo de Liquidación", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTLiqCod_Internalname, GXutil.rtrim( A32TLiqCod), GXutil.rtrim( localUtil.format( A32TLiqCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTLiqCod_Jsonclick, 0, "Attribute", "", "", "", "", edtTLiqCod_Visible, edtTLiqCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_ConceptoTipoLiquidacion.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConTLOrdejec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConTLOrdejec_Internalname, httpContext.getMessage( "TLOrdejec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConTLOrdejec_Internalname, GXutil.ltrim( localUtil.ntoc( A1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConTLOrdejec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1406ConTLOrdejec), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1406ConTLOrdejec), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConTLOrdejec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConTLOrdejec_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConTLVigencia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConTLVigencia.getInternalname(), httpContext.getMessage( "TLVigencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConTLVigencia, cmbConTLVigencia.getInternalname(), GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0)), 1, cmbConTLVigencia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConTLVigencia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "", true, (byte)(0), "HLP_ConceptoTipoLiquidacion.htm");
      cmbConTLVigencia.setValue( GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLVigencia.getInternalname(), "Values", cmbConTLVigencia.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConTLCondicion.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConTLCondicion.getInternalname(), httpContext.getMessage( "TLCondicion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConTLCondicion, cmbConTLCondicion.getInternalname(), GXutil.rtrim( A1410ConTLCondicion), 1, cmbConTLCondicion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConTLCondicion.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "", true, (byte)(0), "HLP_ConceptoTipoLiquidacion.htm");
      cmbConTLCondicion.setValue( GXutil.rtrim( A1410ConTLCondicion) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLCondicion.getInternalname(), "Values", cmbConTLCondicion.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConTLConHab_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConTLConHab_Internalname, httpContext.getMessage( "TLCon Hab", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConTLConHab_Internalname, GXutil.ltrim( localUtil.ntoc( A1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConTLConHab_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1470ConTLConHab), "9") : localUtil.format( DecimalUtil.doubleToDec(A1470ConTLConHab), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConTLConHab_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConTLConHab_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoTipoLiquidacion.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoTipoLiquidacion.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_concodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboconcodigo_Internalname, GXutil.rtrim( AV22ComboConCodigo), GXutil.rtrim( localUtil.format( AV22ComboConCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboconcodigo_Visible, edtavComboconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoTipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_tliqcod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombotliqcod_Internalname, GXutil.rtrim( AV25ComboTLiqCod), GXutil.rtrim( localUtil.format( AV25ComboTLiqCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombotliqcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombotliqcod_Visible, edtavCombotliqcod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoTipoLiquidacion.htm");
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
      e11592 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV15CliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONCODIGO_DATA"), AV21ConCodigo_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vTLIQCOD_DATA"), AV24TLiqCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
            Z32TLiqCod = httpContext.cgiGet( "Z32TLiqCod") ;
            Z1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( "Z1406ConTLOrdejec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1409ConTLVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1409ConTLVigencia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
            Z1410ConTLCondicion = httpContext.cgiGet( "Z1410ConTLCondicion") ;
            n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
            Z1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1470ConTLConHab"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1788ConTLTipoCon = httpContext.cgiGet( "Z1788ConTLTipoCon") ;
            n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
            Z1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1789CONTLSegPla"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
            A1788ConTLTipoCon = httpContext.cgiGet( "Z1788ConTLTipoCon") ;
            n1788ConTLTipoCon = false ;
            n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
            A1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1789CONTLSegPla"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1789CONTLSegPla = false ;
            n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV23Cond_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8ConCodigo = httpContext.cgiGet( "vCONCODIGO") ;
            AV9TLiqCod = httpContext.cgiGet( "vTLIQCOD") ;
            A1788ConTLTipoCon = httpContext.cgiGet( "CONTLTIPOCON") ;
            n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
            A1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( "CONTLSEGPLA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
            A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
            n42ConCodYDesc = false ;
            A41ConDescrip = httpContext.cgiGet( "CONDESCRIP") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_clicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_concodigo_Objectcall = httpContext.cgiGet( "COMBO_CONCODIGO_Objectcall") ;
            Combo_concodigo_Class = httpContext.cgiGet( "COMBO_CONCODIGO_Class") ;
            Combo_concodigo_Icontype = httpContext.cgiGet( "COMBO_CONCODIGO_Icontype") ;
            Combo_concodigo_Icon = httpContext.cgiGet( "COMBO_CONCODIGO_Icon") ;
            Combo_concodigo_Caption = httpContext.cgiGet( "COMBO_CONCODIGO_Caption") ;
            Combo_concodigo_Tooltip = httpContext.cgiGet( "COMBO_CONCODIGO_Tooltip") ;
            Combo_concodigo_Cls = httpContext.cgiGet( "COMBO_CONCODIGO_Cls") ;
            Combo_concodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedvalue_set") ;
            Combo_concodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedvalue_get") ;
            Combo_concodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedtext_set") ;
            Combo_concodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedtext_get") ;
            Combo_concodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONCODIGO_Gamoauthtoken") ;
            Combo_concodigo_Ddointernalname = httpContext.cgiGet( "COMBO_CONCODIGO_Ddointernalname") ;
            Combo_concodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONCODIGO_Titlecontrolalign") ;
            Combo_concodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONCODIGO_Dropdownoptionstype") ;
            Combo_concodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Enabled")) ;
            Combo_concodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Visible")) ;
            Combo_concodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONCODIGO_Titlecontrolidtoreplace") ;
            Combo_concodigo_Datalisttype = httpContext.cgiGet( "COMBO_CONCODIGO_Datalisttype") ;
            Combo_concodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Allowmultipleselection")) ;
            Combo_concodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistfixedvalues") ;
            Combo_concodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Isgriditem")) ;
            Combo_concodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Hasdescription")) ;
            Combo_concodigo_Datalistproc = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistproc") ;
            Combo_concodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistprocparametersprefix") ;
            Combo_concodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONCODIGO_Remoteservicesparameters") ;
            Combo_concodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_concodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeonlyselectedoption")) ;
            Combo_concodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeselectalloption")) ;
            Combo_concodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Emptyitem")) ;
            Combo_concodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeaddnewoption")) ;
            Combo_concodigo_Htmltemplate = httpContext.cgiGet( "COMBO_CONCODIGO_Htmltemplate") ;
            Combo_concodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONCODIGO_Multiplevaluestype") ;
            Combo_concodigo_Loadingdata = httpContext.cgiGet( "COMBO_CONCODIGO_Loadingdata") ;
            Combo_concodigo_Noresultsfound = httpContext.cgiGet( "COMBO_CONCODIGO_Noresultsfound") ;
            Combo_concodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_CONCODIGO_Emptyitemtext") ;
            Combo_concodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONCODIGO_Onlyselectedvalues") ;
            Combo_concodigo_Selectalltext = httpContext.cgiGet( "COMBO_CONCODIGO_Selectalltext") ;
            Combo_concodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONCODIGO_Multiplevaluesseparator") ;
            Combo_concodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONCODIGO_Addnewoptiontext") ;
            Combo_concodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tliqcod_Objectcall = httpContext.cgiGet( "COMBO_TLIQCOD_Objectcall") ;
            Combo_tliqcod_Class = httpContext.cgiGet( "COMBO_TLIQCOD_Class") ;
            Combo_tliqcod_Icontype = httpContext.cgiGet( "COMBO_TLIQCOD_Icontype") ;
            Combo_tliqcod_Icon = httpContext.cgiGet( "COMBO_TLIQCOD_Icon") ;
            Combo_tliqcod_Caption = httpContext.cgiGet( "COMBO_TLIQCOD_Caption") ;
            Combo_tliqcod_Tooltip = httpContext.cgiGet( "COMBO_TLIQCOD_Tooltip") ;
            Combo_tliqcod_Cls = httpContext.cgiGet( "COMBO_TLIQCOD_Cls") ;
            Combo_tliqcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_TLIQCOD_Selectedvalue_set") ;
            Combo_tliqcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_TLIQCOD_Selectedvalue_get") ;
            Combo_tliqcod_Selectedtext_set = httpContext.cgiGet( "COMBO_TLIQCOD_Selectedtext_set") ;
            Combo_tliqcod_Selectedtext_get = httpContext.cgiGet( "COMBO_TLIQCOD_Selectedtext_get") ;
            Combo_tliqcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_TLIQCOD_Gamoauthtoken") ;
            Combo_tliqcod_Ddointernalname = httpContext.cgiGet( "COMBO_TLIQCOD_Ddointernalname") ;
            Combo_tliqcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_TLIQCOD_Titlecontrolalign") ;
            Combo_tliqcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_TLIQCOD_Dropdownoptionstype") ;
            Combo_tliqcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Enabled")) ;
            Combo_tliqcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Visible")) ;
            Combo_tliqcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_TLIQCOD_Titlecontrolidtoreplace") ;
            Combo_tliqcod_Datalisttype = httpContext.cgiGet( "COMBO_TLIQCOD_Datalisttype") ;
            Combo_tliqcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Allowmultipleselection")) ;
            Combo_tliqcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_TLIQCOD_Datalistfixedvalues") ;
            Combo_tliqcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Isgriditem")) ;
            Combo_tliqcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Hasdescription")) ;
            Combo_tliqcod_Datalistproc = httpContext.cgiGet( "COMBO_TLIQCOD_Datalistproc") ;
            Combo_tliqcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_TLIQCOD_Datalistprocparametersprefix") ;
            Combo_tliqcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_TLIQCOD_Remoteservicesparameters") ;
            Combo_tliqcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TLIQCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tliqcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Includeonlyselectedoption")) ;
            Combo_tliqcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Includeselectalloption")) ;
            Combo_tliqcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Emptyitem")) ;
            Combo_tliqcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TLIQCOD_Includeaddnewoption")) ;
            Combo_tliqcod_Htmltemplate = httpContext.cgiGet( "COMBO_TLIQCOD_Htmltemplate") ;
            Combo_tliqcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_TLIQCOD_Multiplevaluestype") ;
            Combo_tliqcod_Loadingdata = httpContext.cgiGet( "COMBO_TLIQCOD_Loadingdata") ;
            Combo_tliqcod_Noresultsfound = httpContext.cgiGet( "COMBO_TLIQCOD_Noresultsfound") ;
            Combo_tliqcod_Emptyitemtext = httpContext.cgiGet( "COMBO_TLIQCOD_Emptyitemtext") ;
            Combo_tliqcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_TLIQCOD_Onlyselectedvalues") ;
            Combo_tliqcod_Selectalltext = httpContext.cgiGet( "COMBO_TLIQCOD_Selectalltext") ;
            Combo_tliqcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_TLIQCOD_Multiplevaluesseparator") ;
            Combo_tliqcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_TLIQCOD_Addnewoptiontext") ;
            Combo_tliqcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TLIQCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConTLOrdejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConTLOrdejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONTLORDEJEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConTLOrdejec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1406ConTLOrdejec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
            }
            else
            {
               A1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( edtConTLOrdejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
            }
            cmbConTLVigencia.setValue( httpContext.cgiGet( cmbConTLVigencia.getInternalname()) );
            A1409ConTLVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConTLVigencia.getInternalname()))) ;
            n1409ConTLVigencia = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
            n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
            cmbConTLCondicion.setValue( httpContext.cgiGet( cmbConTLCondicion.getInternalname()) );
            A1410ConTLCondicion = httpContext.cgiGet( cmbConTLCondicion.getInternalname()) ;
            n1410ConTLCondicion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
            n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConTLConHab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConTLConHab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONTLCONHAB");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConTLConHab_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1470ConTLConHab = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
            }
            else
            {
               A1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( edtConTLConHab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
            }
            AV20ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
            AV22ComboConCodigo = httpContext.cgiGet( edtavComboconcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConCodigo", AV22ComboConCodigo);
            AV25ComboTLiqCod = httpContext.cgiGet( edtavCombotliqcod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboTLiqCod", AV25ComboTLiqCod);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoTipoLiquidacion");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConTLTipoCon", GXutil.rtrim( localUtil.format( A1788ConTLTipoCon, "")));
            forbiddenHiddens.add("CONTLSegPla", localUtil.format( DecimalUtil.doubleToDec(A1789CONTLSegPla), "9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("conceptotipoliquidacion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               A32TLiqCod = httpContext.GetPar( "TLiqCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
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
                  sMode8 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode8 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound8 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_590( ) ;
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
                        e11592 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12592 ();
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
         e12592 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll598( ) ;
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
         disableAttributes598( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotliqcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotliqcod_Enabled), 5, 0), true);
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

   public void confirm_590( )
   {
      beforeValidate598( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls598( ) ;
         }
         else
         {
            checkExtendedTable598( ) ;
            closeExtendedTableCursors598( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption590( )
   {
   }

   public void e11592( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtTLiqCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Visible), 5, 0), true);
      AV25ComboTLiqCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboTLiqCod", AV25ComboTLiqCod);
      edtavCombotliqcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotliqcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotliqcod_Visible), 5, 0), true);
      edtConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), true);
      AV22ComboConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConCodigo", AV22ComboConCodigo);
      edtavComboconcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV20ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      edtavComboclicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOTLIQCOD' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion_Insert", GXv_boolean5) ;
         conceptotipoliquidacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion_Update", GXv_boolean5) ;
         conceptotipoliquidacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion_Delete", GXv_boolean5) ;
         conceptotipoliquidacion_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e12592( )
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

   public void S132( )
   {
      /* 'LOADCOMBOTLIQCOD' Routine */
      returnInSub = false ;
      Combo_tliqcod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"TLiqCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"TLiqCod\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_tliqcod.sendProperty(context, "", false, Combo_tliqcod_Internalname, "DataListProcParametersPrefix", Combo_tliqcod_Datalistprocparametersprefix);
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.conceptotipoliquidacionloaddvcombo(remoteHandle, context).execute( "TLiqCod", Gx_mode, false, AV7CliCod, AV8ConCodigo, AV9TLiqCod, A3CliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      conceptotipoliquidacion_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      conceptotipoliquidacion_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      conceptotipoliquidacion_impl.this.GXt_char6 = GXv_char9[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_tliqcod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_tliqcod.sendProperty(context, "", false, Combo_tliqcod_Internalname, "SelectedValue_set", Combo_tliqcod_Selectedvalue_set);
      Combo_tliqcod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_tliqcod.sendProperty(context, "", false, Combo_tliqcod_Internalname, "SelectedText_set", Combo_tliqcod_Selectedtext_set);
      AV25ComboTLiqCod = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboTLiqCod", AV25ComboTLiqCod);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9TLiqCod)==0) )
      {
         Combo_tliqcod_Enabled = false ;
         ucCombo_tliqcod.sendProperty(context, "", false, Combo_tliqcod_Internalname, "Enabled", GXutil.booltostr( Combo_tliqcod_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOCONCODIGO' Routine */
      returnInSub = false ;
      Combo_concodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ConCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"TLiqCod\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "DataListProcParametersPrefix", Combo_concodigo_Datalistprocparametersprefix);
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptotipoliquidacionloaddvcombo(remoteHandle, context).execute( "ConCodigo", Gx_mode, false, AV7CliCod, AV8ConCodigo, AV9TLiqCod, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptotipoliquidacion_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      conceptotipoliquidacion_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      conceptotipoliquidacion_impl.this.GXt_char6 = GXv_char7[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_concodigo_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
      Combo_concodigo_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedText_set", Combo_concodigo_Selectedtext_set);
      AV22ComboConCodigo = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConCodigo", AV22ComboConCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         Combo_concodigo_Enabled = false ;
         ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptotipoliquidacionloaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV8ConCodigo, AV9TLiqCod, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptotipoliquidacion_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      conceptotipoliquidacion_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      conceptotipoliquidacion_impl.this.GXt_char6 = GXv_char7[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV20ComboCliCod = (int)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm598( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1406ConTLOrdejec = T00593_A1406ConTLOrdejec[0] ;
            Z1409ConTLVigencia = T00593_A1409ConTLVigencia[0] ;
            Z1410ConTLCondicion = T00593_A1410ConTLCondicion[0] ;
            Z1470ConTLConHab = T00593_A1470ConTLConHab[0] ;
            Z1788ConTLTipoCon = T00593_A1788ConTLTipoCon[0] ;
            Z1789CONTLSegPla = T00593_A1789CONTLSegPla[0] ;
         }
         else
         {
            Z1406ConTLOrdejec = A1406ConTLOrdejec ;
            Z1409ConTLVigencia = A1409ConTLVigencia ;
            Z1410ConTLCondicion = A1410ConTLCondicion ;
            Z1470ConTLConHab = A1470ConTLConHab ;
            Z1788ConTLTipoCon = A1788ConTLTipoCon ;
            Z1789CONTLSegPla = A1789CONTLSegPla ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z1406ConTLOrdejec = A1406ConTLOrdejec ;
         Z1409ConTLVigencia = A1409ConTLVigencia ;
         Z1410ConTLCondicion = A1410ConTLCondicion ;
         Z1470ConTLConHab = A1470ConTLConHab ;
         Z1788ConTLTipoCon = A1788ConTLTipoCon ;
         Z1789CONTLSegPla = A1789CONTLSegPla ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
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
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9TLiqCod)==0) )
      {
         edtTLiqCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      }
      else
      {
         edtTLiqCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9TLiqCod)==0) )
      {
         edtTLiqCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9TLiqCod)==0) )
      {
         A32TLiqCod = AV9TLiqCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      else
      {
         A32TLiqCod = AV25ComboTLiqCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         A26ConCodigo = AV8ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      else
      {
         A26ConCodigo = AV22ComboConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV20ComboCliCod ;
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
         AV26Pgmname = "ConceptoTipoLiquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         /* Using cursor T00595 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T00595_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T00595_n42ConCodYDesc[0] ;
         A41ConDescrip = T00595_A41ConDescrip[0] ;
         A41ConDescrip = T00595_A41ConDescrip[0] ;
         pr_default.close(3);
      }
   }

   public void load598( )
   {
      /* Using cursor T00596 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod, A26ConCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A42ConCodYDesc = T00596_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T00596_n42ConCodYDesc[0] ;
         A1406ConTLOrdejec = T00596_A1406ConTLOrdejec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
         A1409ConTLVigencia = T00596_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = T00596_n1409ConTLVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
         A1410ConTLCondicion = T00596_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = T00596_n1410ConTLCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
         A1470ConTLConHab = T00596_A1470ConTLConHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
         A1788ConTLTipoCon = T00596_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = T00596_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = T00596_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = T00596_n1789CONTLSegPla[0] ;
         A41ConDescrip = T00596_A41ConDescrip[0] ;
         zm598( -12) ;
      }
      pr_default.close(4);
      onLoadActions598( ) ;
   }

   public void onLoadActions598( )
   {
      AV26Pgmname = "ConceptoTipoLiquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
   }

   public void checkExtendedTable598( )
   {
      nIsDirty_8 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "ConceptoTipoLiquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      /* Using cursor T00595 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T00595_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T00595_n42ConCodYDesc[0] ;
      A41ConDescrip = T00595_A41ConDescrip[0] ;
      A41ConDescrip = T00595_A41ConDescrip[0] ;
      pr_default.close(3);
      /* Using cursor T00594 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A1409ConTLVigencia == 0 ) || ( A1409ConTLVigencia == 1 ) || (0==A1409ConTLVigencia) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con TLVigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONTLVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConTLVigencia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1410ConTLCondicion, "A0") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A3") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A4") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A5") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A8") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A9") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A10") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A11") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A12") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A13") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A14") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B2") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B3") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B4") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B5") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B6") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B7") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B9") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B10") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B11") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B12") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B13") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B14") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B15") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "N01") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B16") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B19") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B20") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B21") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B22") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B23") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B24") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "VP") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "AI") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "R1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "MI") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "H1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "LA") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "GU") == 0 ) || (GXutil.strcmp("", A1410ConTLCondicion)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con TLCondicion", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONTLCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConTLCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors598( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_14( int A3CliCod ,
                          String A26ConCodigo )
   {
      /* Using cursor T00597 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T00597_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T00597_n42ConCodYDesc[0] ;
      A41ConDescrip = T00597_A41ConDescrip[0] ;
      A41ConDescrip = T00597_A41ConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A42ConCodYDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_13( int A3CliCod ,
                          String A32TLiqCod )
   {
      /* Using cursor T00598 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
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

   public void getKey598( )
   {
      /* Using cursor T00599 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound8 = (short)(1) ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00593 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm598( 12) ;
         RcdFound8 = (short)(1) ;
         A1406ConTLOrdejec = T00593_A1406ConTLOrdejec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
         A1409ConTLVigencia = T00593_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = T00593_n1409ConTLVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
         A1410ConTLCondicion = T00593_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = T00593_n1410ConTLCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
         A1470ConTLConHab = T00593_A1470ConTLConHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
         A1788ConTLTipoCon = T00593_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = T00593_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = T00593_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = T00593_n1789CONTLSegPla[0] ;
         A3CliCod = T00593_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = T00593_A32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         A26ConCodigo = T00593_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z32TLiqCod = A32TLiqCod ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load598( ) ;
         if ( AnyError == 1 )
         {
            RcdFound8 = (short)(0) ;
            initializeNonKey598( ) ;
         }
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound8 = (short)(0) ;
         initializeNonKey598( ) ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey598( ) ;
      if ( RcdFound8 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound8 = (short)(0) ;
      /* Using cursor T005910 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A32TLiqCod, A32TLiqCod, Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005910_A3CliCod[0] < A3CliCod ) || ( T005910_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005910_A32TLiqCod[0], A32TLiqCod) < 0 ) || ( GXutil.strcmp(T005910_A32TLiqCod[0], A32TLiqCod) == 0 ) && ( T005910_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005910_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005910_A3CliCod[0] > A3CliCod ) || ( T005910_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005910_A32TLiqCod[0], A32TLiqCod) > 0 ) || ( GXutil.strcmp(T005910_A32TLiqCod[0], A32TLiqCod) == 0 ) && ( T005910_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005910_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A3CliCod = T005910_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A32TLiqCod = T005910_A32TLiqCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            A26ConCodigo = T005910_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound8 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound8 = (short)(0) ;
      /* Using cursor T005911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A32TLiqCod, A32TLiqCod, Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005911_A3CliCod[0] > A3CliCod ) || ( T005911_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005911_A32TLiqCod[0], A32TLiqCod) > 0 ) || ( GXutil.strcmp(T005911_A32TLiqCod[0], A32TLiqCod) == 0 ) && ( T005911_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005911_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005911_A3CliCod[0] < A3CliCod ) || ( T005911_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005911_A32TLiqCod[0], A32TLiqCod) < 0 ) || ( GXutil.strcmp(T005911_A32TLiqCod[0], A32TLiqCod) == 0 ) && ( T005911_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005911_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A3CliCod = T005911_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A32TLiqCod = T005911_A32TLiqCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            A26ConCodigo = T005911_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound8 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey598( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert598( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound8 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A26ConCodigo = Z26ConCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               A32TLiqCod = Z32TLiqCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
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
               update598( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert598( ) ;
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
                  insert598( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = Z26ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A32TLiqCod = Z32TLiqCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
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

   public void checkOptimisticConcurrency598( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00592 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1406ConTLOrdejec != T00592_A1406ConTLOrdejec[0] ) || ( Z1409ConTLVigencia != T00592_A1409ConTLVigencia[0] ) || ( GXutil.strcmp(Z1410ConTLCondicion, T00592_A1410ConTLCondicion[0]) != 0 ) || ( Z1470ConTLConHab != T00592_A1470ConTLConHab[0] ) || ( GXutil.strcmp(Z1788ConTLTipoCon, T00592_A1788ConTLTipoCon[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1789CONTLSegPla != T00592_A1789CONTLSegPla[0] ) )
         {
            if ( Z1406ConTLOrdejec != T00592_A1406ConTLOrdejec[0] )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"ConTLOrdejec");
               GXutil.writeLogRaw("Old: ",Z1406ConTLOrdejec);
               GXutil.writeLogRaw("Current: ",T00592_A1406ConTLOrdejec[0]);
            }
            if ( Z1409ConTLVigencia != T00592_A1409ConTLVigencia[0] )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"ConTLVigencia");
               GXutil.writeLogRaw("Old: ",Z1409ConTLVigencia);
               GXutil.writeLogRaw("Current: ",T00592_A1409ConTLVigencia[0]);
            }
            if ( GXutil.strcmp(Z1410ConTLCondicion, T00592_A1410ConTLCondicion[0]) != 0 )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"ConTLCondicion");
               GXutil.writeLogRaw("Old: ",Z1410ConTLCondicion);
               GXutil.writeLogRaw("Current: ",T00592_A1410ConTLCondicion[0]);
            }
            if ( Z1470ConTLConHab != T00592_A1470ConTLConHab[0] )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"ConTLConHab");
               GXutil.writeLogRaw("Old: ",Z1470ConTLConHab);
               GXutil.writeLogRaw("Current: ",T00592_A1470ConTLConHab[0]);
            }
            if ( GXutil.strcmp(Z1788ConTLTipoCon, T00592_A1788ConTLTipoCon[0]) != 0 )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"ConTLTipoCon");
               GXutil.writeLogRaw("Old: ",Z1788ConTLTipoCon);
               GXutil.writeLogRaw("Current: ",T00592_A1788ConTLTipoCon[0]);
            }
            if ( Z1789CONTLSegPla != T00592_A1789CONTLSegPla[0] )
            {
               GXutil.writeLogln("conceptotipoliquidacion:[seudo value changed for attri]"+"CONTLSegPla");
               GXutil.writeLogRaw("Old: ",Z1789CONTLSegPla);
               GXutil.writeLogRaw("Current: ",T00592_A1789CONTLSegPla[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoTipoLiquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert598( )
   {
      beforeValidate598( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable598( ) ;
      }
      if ( AnyError == 0 )
      {
         zm598( 0) ;
         checkOptimisticConcurrency598( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm598( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert598( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005912 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A1406ConTLOrdejec), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A32TLiqCod, A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        resetCaption590( ) ;
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
            load598( ) ;
         }
         endLevel598( ) ;
      }
      closeExtendedTableCursors598( ) ;
   }

   public void update598( )
   {
      beforeValidate598( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable598( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency598( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm598( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate598( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005913 */
                  pr_default.execute(11, new Object[] {Long.valueOf(A1406ConTLOrdejec), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate598( ) ;
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
         endLevel598( ) ;
      }
      closeExtendedTableCursors598( ) ;
   }

   public void deferredUpdate598( )
   {
   }

   public void delete( )
   {
      beforeValidate598( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency598( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls598( ) ;
         afterConfirm598( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete598( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005914 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
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
      sMode8 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel598( ) ;
      Gx_mode = sMode8 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls598( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "ConceptoTipoLiquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         /* Using cursor T005915 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T005915_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T005915_n42ConCodYDesc[0] ;
         A41ConDescrip = T005915_A41ConDescrip[0] ;
         A41ConDescrip = T005915_A41ConDescrip[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel598( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete598( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptotipoliquidacion");
         if ( AnyError == 0 )
         {
            confirmValues590( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "conceptotipoliquidacion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart598( )
   {
      /* Scan By routine */
      /* Using cursor T005916 */
      pr_default.execute(14);
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A3CliCod = T005916_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005916_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A32TLiqCod = T005916_A32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext598( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A3CliCod = T005916_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005916_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A32TLiqCod = T005916_A32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
   }

   public void scanEnd598( )
   {
      pr_default.close(14);
   }

   public void afterConfirm598( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert598( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate598( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete598( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete598( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate598( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes598( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtTLiqCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      edtConTLOrdejec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTLOrdejec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTLOrdejec_Enabled), 5, 0), true);
      cmbConTLVigencia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLVigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConTLVigencia.getEnabled(), 5, 0), true);
      cmbConTLCondicion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConTLCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConTLCondicion.getEnabled(), 5, 0), true);
      edtConTLConHab_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTLConHab_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTLConHab_Enabled), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      edtavComboconcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
      edtavCombotliqcod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotliqcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotliqcod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes598( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues590( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptotipoliquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConCodigo)),GXutil.URLEncode(GXutil.rtrim(AV9TLiqCod))}, new String[] {"Gx_mode","CliCod","ConCodigo","TLiqCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoTipoLiquidacion");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConTLTipoCon", GXutil.rtrim( localUtil.format( A1788ConTLTipoCon, "")));
      forbiddenHiddens.add("CONTLSegPla", localUtil.format( DecimalUtil.doubleToDec(A1789CONTLSegPla), "9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptotipoliquidacion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z32TLiqCod", GXutil.rtrim( Z32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1406ConTLOrdejec", GXutil.ltrim( localUtil.ntoc( Z1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1409ConTLVigencia", GXutil.ltrim( localUtil.ntoc( Z1409ConTLVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1410ConTLCondicion", GXutil.rtrim( Z1410ConTLCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1470ConTLConHab", GXutil.ltrim( localUtil.ntoc( Z1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1788ConTLTipoCon", GXutil.rtrim( Z1788ConTLTipoCon));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1789CONTLSegPla", GXutil.ltrim( localUtil.ntoc( Z1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV15CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV15CliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONCODIGO_DATA", AV21ConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONCODIGO_DATA", AV21ConCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTLIQCOD_DATA", AV24TLiqCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTLIQCOD_DATA", AV24TLiqCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLICOD", GXutil.ltrim( localUtil.ntoc( AV23Cond_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV8ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTLIQCOD", GXutil.rtrim( AV9TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTLIQCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLTIPOCON", GXutil.rtrim( A1788ConTLTipoCon));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLSEGPLA", GXutil.ltrim( localUtil.ntoc( A1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDESCRIP", A41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Objectcall", GXutil.rtrim( Combo_concodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Cls", GXutil.rtrim( Combo_concodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_concodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Selectedtext_set", GXutil.rtrim( Combo_concodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Datalistproc", GXutil.rtrim( Combo_concodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_concodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Emptyitem", GXutil.booltostr( Combo_concodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Objectcall", GXutil.rtrim( Combo_tliqcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Cls", GXutil.rtrim( Combo_tliqcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Selectedvalue_set", GXutil.rtrim( Combo_tliqcod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Selectedtext_set", GXutil.rtrim( Combo_tliqcod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Enabled", GXutil.booltostr( Combo_tliqcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Datalistproc", GXutil.rtrim( Combo_tliqcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_tliqcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TLIQCOD_Emptyitem", GXutil.booltostr( Combo_tliqcod_Emptyitem));
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
      return formatLink("web.conceptotipoliquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConCodigo)),GXutil.URLEncode(GXutil.rtrim(AV9TLiqCod))}, new String[] {"Gx_mode","CliCod","ConCodigo","TLiqCod"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptoTipoLiquidacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto Tipo Liquidacion", "") ;
   }

   public void initializeNonKey598( )
   {
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      A1406ConTLOrdejec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
      A1409ConTLVigencia = (byte)(0) ;
      n1409ConTLVigencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
      n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
      A1410ConTLCondicion = "" ;
      n1410ConTLCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
      n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
      A1470ConTLConHab = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
      A1788ConTLTipoCon = "" ;
      n1788ConTLTipoCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1788ConTLTipoCon", A1788ConTLTipoCon);
      A1789CONTLSegPla = (byte)(0) ;
      n1789CONTLSegPla = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1789CONTLSegPla", GXutil.str( A1789CONTLSegPla, 1, 0));
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      Z1406ConTLOrdejec = 0 ;
      Z1409ConTLVigencia = (byte)(0) ;
      Z1410ConTLCondicion = "" ;
      Z1470ConTLConHab = (byte)(0) ;
      Z1788ConTLTipoCon = "" ;
      Z1789CONTLSegPla = (byte)(0) ;
   }

   public void initAll598( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      A32TLiqCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      initializeNonKey598( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713303055", true, true);
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
      httpContext.AddJavascriptSource("conceptotipoliquidacion.js", "?20251713303056", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      lblTextblockclicod_Internalname = "TEXTBLOCKCLICOD" ;
      Combo_clicod_Internalname = "COMBO_CLICOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      divTablesplittedclicod_Internalname = "TABLESPLITTEDCLICOD" ;
      lblTextblockconcodigo_Internalname = "TEXTBLOCKCONCODIGO" ;
      Combo_concodigo_Internalname = "COMBO_CONCODIGO" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      divTablesplittedconcodigo_Internalname = "TABLESPLITTEDCONCODIGO" ;
      lblTextblocktliqcod_Internalname = "TEXTBLOCKTLIQCOD" ;
      Combo_tliqcod_Internalname = "COMBO_TLIQCOD" ;
      edtTLiqCod_Internalname = "TLIQCOD" ;
      divTablesplittedtliqcod_Internalname = "TABLESPLITTEDTLIQCOD" ;
      edtConTLOrdejec_Internalname = "CONTLORDEJEC" ;
      cmbConTLVigencia.setInternalname( "CONTLVIGENCIA" );
      cmbConTLCondicion.setInternalname( "CONTLCONDICION" );
      edtConTLConHab_Internalname = "CONTLCONHAB" ;
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
      edtavComboconcodigo_Internalname = "vCOMBOCONCODIGO" ;
      divSectionattribute_concodigo_Internalname = "SECTIONATTRIBUTE_CONCODIGO" ;
      edtavCombotliqcod_Internalname = "vCOMBOTLIQCOD" ;
      divSectionattribute_tliqcod_Internalname = "SECTIONATTRIBUTE_TLIQCOD" ;
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
      Form.setCaption( httpContext.getMessage( "Concepto Tipo Liquidacion", "") );
      Combo_concodigo_Datalistprocparametersprefix = "" ;
      Combo_tliqcod_Datalistprocparametersprefix = "" ;
      edtavCombotliqcod_Jsonclick = "" ;
      edtavCombotliqcod_Enabled = 0 ;
      edtavCombotliqcod_Visible = 1 ;
      edtavComboconcodigo_Jsonclick = "" ;
      edtavComboconcodigo_Enabled = 0 ;
      edtavComboconcodigo_Visible = 1 ;
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConTLConHab_Jsonclick = "" ;
      edtConTLConHab_Enabled = 1 ;
      cmbConTLCondicion.setJsonclick( "" );
      cmbConTLCondicion.setEnabled( 1 );
      cmbConTLVigencia.setJsonclick( "" );
      cmbConTLVigencia.setEnabled( 1 );
      edtConTLOrdejec_Jsonclick = "" ;
      edtConTLOrdejec_Enabled = 1 ;
      edtTLiqCod_Jsonclick = "" ;
      edtTLiqCod_Enabled = 1 ;
      edtTLiqCod_Visible = 1 ;
      Combo_tliqcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_tliqcod_Datalistproc = "ConceptoTipoLiquidacionLoadDVCombo" ;
      Combo_tliqcod_Cls = "ExtendedCombo Attribute" ;
      Combo_tliqcod_Caption = "" ;
      Combo_tliqcod_Enabled = GXutil.toBoolean( -1) ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      edtConCodigo_Visible = 1 ;
      Combo_concodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_concodigo_Datalistproc = "ConceptoTipoLiquidacionLoadDVCombo" ;
      Combo_concodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_concodigo_Caption = "" ;
      Combo_concodigo_Enabled = GXutil.toBoolean( -1) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"TLiqCod\": \"\"" ;
      Combo_clicod_Datalistproc = "ConceptoTipoLiquidacionLoadDVCombo" ;
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
      cmbConTLVigencia.setName( "CONTLVIGENCIA" );
      cmbConTLVigencia.setWebtags( "" );
      cmbConTLVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConTLVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConTLVigencia.getItemCount() > 0 )
      {
         A1409ConTLVigencia = (byte)(GXutil.lval( cmbConTLVigencia.getValidValue(GXutil.trim( GXutil.str( A1409ConTLVigencia, 1, 0))))) ;
         n1409ConTLVigencia = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
      }
      cmbConTLCondicion.setName( "CONTLCONDICION" );
      cmbConTLCondicion.setWebtags( "" );
      cmbConTLCondicion.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConTLCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbConTLCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbConTLCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbConTLCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbConTLCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbConTLCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbConTLCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbConTLCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbConTLCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbConTLCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbConTLCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbConTLCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConTLCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConTLCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConTLCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbConTLCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbConTLCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbConTLCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbConTLCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbConTLCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbConTLCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbConTLCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbConTLCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbConTLCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbConTLCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbConTLCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConTLCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbConTLCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbConTLCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbConTLCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbConTLCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbConTLCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbConTLCondicion.getItemCount() > 0 )
      {
         A1410ConTLCondicion = cmbConTLCondicion.getValidValue(A1410ConTLCondicion) ;
         n1410ConTLCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
      }
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

   public void valid_Concodigo( )
   {
      n42ConCodYDesc = false ;
      /* Using cursor T005915 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A42ConCodYDesc = T005915_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T005915_n42ConCodYDesc[0] ;
      A41ConDescrip = T005915_A41ConDescrip[0] ;
      A41ConDescrip = T005915_A41ConDescrip[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
   }

   public void valid_Tliqcod( )
   {
      /* Using cursor T005917 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV9TLiqCod',fld:'vTLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV9TLiqCod',fld:'vTLIQCOD',pic:'',hsh:true},{av:'A1788ConTLTipoCon',fld:'CONTLTIPOCON',pic:''},{av:'A1789CONTLSegPla',fld:'CONTLSEGPLA',pic:'9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12592',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''}]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[]}");
      setEventMetadata("VALID_CONTLVIGENCIA","{handler:'valid_Contlvigencia',iparms:[]");
      setEventMetadata("VALID_CONTLVIGENCIA",",oparms:[]}");
      setEventMetadata("VALID_CONTLCONDICION","{handler:'valid_Contlcondicion',iparms:[]");
      setEventMetadata("VALID_CONTLCONDICION",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCONCODIGO","{handler:'validv_Comboconcodigo',iparms:[]");
      setEventMetadata("VALIDV_COMBOCONCODIGO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOTLIQCOD","{handler:'validv_Combotliqcod',iparms:[]");
      setEventMetadata("VALIDV_COMBOTLIQCOD",",oparms:[]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8ConCodigo = "" ;
      wcpOAV9TLiqCod = "" ;
      Z26ConCodigo = "" ;
      Z32TLiqCod = "" ;
      Z1410ConTLCondicion = "" ;
      Z1788ConTLTipoCon = "" ;
      Combo_tliqcod_Selectedvalue_get = "" ;
      Combo_concodigo_Selectedvalue_get = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      Gx_mode = "" ;
      AV8ConCodigo = "" ;
      AV9TLiqCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1410ConTLCondicion = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockconcodigo_Jsonclick = "" ;
      ucCombo_concodigo = new com.genexus.webpanels.GXUserControl();
      AV21ConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblocktliqcod_Jsonclick = "" ;
      ucCombo_tliqcod = new com.genexus.webpanels.GXUserControl();
      AV24TLiqCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboConCodigo = "" ;
      AV25ComboTLiqCod = "" ;
      A1788ConTLTipoCon = "" ;
      A42ConCodYDesc = "" ;
      A41ConDescrip = "" ;
      AV26Pgmname = "" ;
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
      Combo_concodigo_Objectcall = "" ;
      Combo_concodigo_Class = "" ;
      Combo_concodigo_Icontype = "" ;
      Combo_concodigo_Icon = "" ;
      Combo_concodigo_Tooltip = "" ;
      Combo_concodigo_Selectedvalue_set = "" ;
      Combo_concodigo_Selectedtext_set = "" ;
      Combo_concodigo_Selectedtext_get = "" ;
      Combo_concodigo_Gamoauthtoken = "" ;
      Combo_concodigo_Ddointernalname = "" ;
      Combo_concodigo_Titlecontrolalign = "" ;
      Combo_concodigo_Dropdownoptionstype = "" ;
      Combo_concodigo_Titlecontrolidtoreplace = "" ;
      Combo_concodigo_Datalisttype = "" ;
      Combo_concodigo_Datalistfixedvalues = "" ;
      Combo_concodigo_Remoteservicesparameters = "" ;
      Combo_concodigo_Htmltemplate = "" ;
      Combo_concodigo_Multiplevaluestype = "" ;
      Combo_concodigo_Loadingdata = "" ;
      Combo_concodigo_Noresultsfound = "" ;
      Combo_concodigo_Emptyitemtext = "" ;
      Combo_concodigo_Onlyselectedvalues = "" ;
      Combo_concodigo_Selectalltext = "" ;
      Combo_concodigo_Multiplevaluesseparator = "" ;
      Combo_concodigo_Addnewoptiontext = "" ;
      Combo_tliqcod_Objectcall = "" ;
      Combo_tliqcod_Class = "" ;
      Combo_tliqcod_Icontype = "" ;
      Combo_tliqcod_Icon = "" ;
      Combo_tliqcod_Tooltip = "" ;
      Combo_tliqcod_Selectedvalue_set = "" ;
      Combo_tliqcod_Selectedtext_set = "" ;
      Combo_tliqcod_Selectedtext_get = "" ;
      Combo_tliqcod_Gamoauthtoken = "" ;
      Combo_tliqcod_Ddointernalname = "" ;
      Combo_tliqcod_Titlecontrolalign = "" ;
      Combo_tliqcod_Dropdownoptionstype = "" ;
      Combo_tliqcod_Titlecontrolidtoreplace = "" ;
      Combo_tliqcod_Datalisttype = "" ;
      Combo_tliqcod_Datalistfixedvalues = "" ;
      Combo_tliqcod_Remoteservicesparameters = "" ;
      Combo_tliqcod_Htmltemplate = "" ;
      Combo_tliqcod_Multiplevaluestype = "" ;
      Combo_tliqcod_Loadingdata = "" ;
      Combo_tliqcod_Noresultsfound = "" ;
      Combo_tliqcod_Emptyitemtext = "" ;
      Combo_tliqcod_Onlyselectedvalues = "" ;
      Combo_tliqcod_Selectalltext = "" ;
      Combo_tliqcod_Multiplevaluesseparator = "" ;
      Combo_tliqcod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode8 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      T00595_A42ConCodYDesc = new String[] {""} ;
      T00595_n42ConCodYDesc = new boolean[] {false} ;
      T00595_A41ConDescrip = new String[] {""} ;
      T00596_A42ConCodYDesc = new String[] {""} ;
      T00596_n42ConCodYDesc = new boolean[] {false} ;
      T00596_A1406ConTLOrdejec = new long[1] ;
      T00596_A1409ConTLVigencia = new byte[1] ;
      T00596_n1409ConTLVigencia = new boolean[] {false} ;
      T00596_A1410ConTLCondicion = new String[] {""} ;
      T00596_n1410ConTLCondicion = new boolean[] {false} ;
      T00596_A1470ConTLConHab = new byte[1] ;
      T00596_A1788ConTLTipoCon = new String[] {""} ;
      T00596_n1788ConTLTipoCon = new boolean[] {false} ;
      T00596_A1789CONTLSegPla = new byte[1] ;
      T00596_n1789CONTLSegPla = new boolean[] {false} ;
      T00596_A41ConDescrip = new String[] {""} ;
      T00596_A3CliCod = new int[1] ;
      T00596_A32TLiqCod = new String[] {""} ;
      T00596_A26ConCodigo = new String[] {""} ;
      T00594_A3CliCod = new int[1] ;
      T00597_A42ConCodYDesc = new String[] {""} ;
      T00597_n42ConCodYDesc = new boolean[] {false} ;
      T00597_A41ConDescrip = new String[] {""} ;
      T00598_A3CliCod = new int[1] ;
      T00599_A3CliCod = new int[1] ;
      T00599_A26ConCodigo = new String[] {""} ;
      T00599_A32TLiqCod = new String[] {""} ;
      T00593_A1406ConTLOrdejec = new long[1] ;
      T00593_A1409ConTLVigencia = new byte[1] ;
      T00593_n1409ConTLVigencia = new boolean[] {false} ;
      T00593_A1410ConTLCondicion = new String[] {""} ;
      T00593_n1410ConTLCondicion = new boolean[] {false} ;
      T00593_A1470ConTLConHab = new byte[1] ;
      T00593_A1788ConTLTipoCon = new String[] {""} ;
      T00593_n1788ConTLTipoCon = new boolean[] {false} ;
      T00593_A1789CONTLSegPla = new byte[1] ;
      T00593_n1789CONTLSegPla = new boolean[] {false} ;
      T00593_A3CliCod = new int[1] ;
      T00593_A32TLiqCod = new String[] {""} ;
      T00593_A26ConCodigo = new String[] {""} ;
      T005910_A3CliCod = new int[1] ;
      T005910_A32TLiqCod = new String[] {""} ;
      T005910_A26ConCodigo = new String[] {""} ;
      T005911_A3CliCod = new int[1] ;
      T005911_A32TLiqCod = new String[] {""} ;
      T005911_A26ConCodigo = new String[] {""} ;
      T00592_A1406ConTLOrdejec = new long[1] ;
      T00592_A1409ConTLVigencia = new byte[1] ;
      T00592_n1409ConTLVigencia = new boolean[] {false} ;
      T00592_A1410ConTLCondicion = new String[] {""} ;
      T00592_n1410ConTLCondicion = new boolean[] {false} ;
      T00592_A1470ConTLConHab = new byte[1] ;
      T00592_A1788ConTLTipoCon = new String[] {""} ;
      T00592_n1788ConTLTipoCon = new boolean[] {false} ;
      T00592_A1789CONTLSegPla = new byte[1] ;
      T00592_n1789CONTLSegPla = new boolean[] {false} ;
      T00592_A3CliCod = new int[1] ;
      T00592_A32TLiqCod = new String[] {""} ;
      T00592_A26ConCodigo = new String[] {""} ;
      T005915_A42ConCodYDesc = new String[] {""} ;
      T005915_n42ConCodYDesc = new boolean[] {false} ;
      T005915_A41ConDescrip = new String[] {""} ;
      T005916_A3CliCod = new int[1] ;
      T005916_A26ConCodigo = new String[] {""} ;
      T005916_A32TLiqCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005917_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacion__default(),
         new Object[] {
             new Object[] {
            T00592_A1406ConTLOrdejec, T00592_A1409ConTLVigencia, T00592_n1409ConTLVigencia, T00592_A1410ConTLCondicion, T00592_n1410ConTLCondicion, T00592_A1470ConTLConHab, T00592_A1788ConTLTipoCon, T00592_n1788ConTLTipoCon, T00592_A1789CONTLSegPla, T00592_n1789CONTLSegPla,
            T00592_A3CliCod, T00592_A32TLiqCod, T00592_A26ConCodigo
            }
            , new Object[] {
            T00593_A1406ConTLOrdejec, T00593_A1409ConTLVigencia, T00593_n1409ConTLVigencia, T00593_A1410ConTLCondicion, T00593_n1410ConTLCondicion, T00593_A1470ConTLConHab, T00593_A1788ConTLTipoCon, T00593_n1788ConTLTipoCon, T00593_A1789CONTLSegPla, T00593_n1789CONTLSegPla,
            T00593_A3CliCod, T00593_A32TLiqCod, T00593_A26ConCodigo
            }
            , new Object[] {
            T00594_A3CliCod
            }
            , new Object[] {
            T00595_A42ConCodYDesc, T00595_n42ConCodYDesc, T00595_A41ConDescrip
            }
            , new Object[] {
            T00596_A42ConCodYDesc, T00596_n42ConCodYDesc, T00596_A1406ConTLOrdejec, T00596_A1409ConTLVigencia, T00596_n1409ConTLVigencia, T00596_A1410ConTLCondicion, T00596_n1410ConTLCondicion, T00596_A1470ConTLConHab, T00596_A1788ConTLTipoCon, T00596_n1788ConTLTipoCon,
            T00596_A1789CONTLSegPla, T00596_n1789CONTLSegPla, T00596_A41ConDescrip, T00596_A3CliCod, T00596_A32TLiqCod, T00596_A26ConCodigo
            }
            , new Object[] {
            T00597_A42ConCodYDesc, T00597_n42ConCodYDesc, T00597_A41ConDescrip
            }
            , new Object[] {
            T00598_A3CliCod
            }
            , new Object[] {
            T00599_A3CliCod, T00599_A26ConCodigo, T00599_A32TLiqCod
            }
            , new Object[] {
            T005910_A3CliCod, T005910_A32TLiqCod, T005910_A26ConCodigo
            }
            , new Object[] {
            T005911_A3CliCod, T005911_A32TLiqCod, T005911_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005915_A42ConCodYDesc, T005915_n42ConCodYDesc, T005915_A41ConDescrip
            }
            , new Object[] {
            T005916_A3CliCod, T005916_A26ConCodigo, T005916_A32TLiqCod
            }
            , new Object[] {
            T005917_A3CliCod
            }
         }
      );
      AV26Pgmname = "ConceptoTipoLiquidacion" ;
   }

   private byte Z1409ConTLVigencia ;
   private byte Z1470ConTLConHab ;
   private byte Z1789CONTLSegPla ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte A1789CONTLSegPla ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound8 ;
   private short nIsDirty_8 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtConCodigo_Visible ;
   private int edtConCodigo_Enabled ;
   private int edtTLiqCod_Visible ;
   private int edtTLiqCod_Enabled ;
   private int edtConTLOrdejec_Enabled ;
   private int edtConTLConHab_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV20ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int edtavComboconcodigo_Visible ;
   private int edtavComboconcodigo_Enabled ;
   private int edtavCombotliqcod_Visible ;
   private int edtavCombotliqcod_Enabled ;
   private int AV23Cond_CliCod ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Combo_clicod_Gxcontroltype ;
   private int Combo_concodigo_Datalistupdateminimumcharacters ;
   private int Combo_concodigo_Gxcontroltype ;
   private int Combo_tliqcod_Datalistupdateminimumcharacters ;
   private int Combo_tliqcod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private long Z1406ConTLOrdejec ;
   private long A1406ConTLOrdejec ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8ConCodigo ;
   private String wcpOAV9TLiqCod ;
   private String Z26ConCodigo ;
   private String Z32TLiqCod ;
   private String Z1410ConTLCondicion ;
   private String Z1788ConTLTipoCon ;
   private String Combo_tliqcod_Selectedvalue_get ;
   private String Combo_concodigo_Selectedvalue_get ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private String Gx_mode ;
   private String AV8ConCodigo ;
   private String AV9TLiqCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String A1410ConTLCondicion ;
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
   private String divTablesplittedconcodigo_Internalname ;
   private String lblTextblockconcodigo_Internalname ;
   private String lblTextblockconcodigo_Jsonclick ;
   private String Combo_concodigo_Caption ;
   private String Combo_concodigo_Cls ;
   private String Combo_concodigo_Datalistproc ;
   private String Combo_concodigo_Internalname ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
   private String divTablesplittedtliqcod_Internalname ;
   private String lblTextblocktliqcod_Internalname ;
   private String lblTextblocktliqcod_Jsonclick ;
   private String Combo_tliqcod_Caption ;
   private String Combo_tliqcod_Cls ;
   private String Combo_tliqcod_Datalistproc ;
   private String Combo_tliqcod_Internalname ;
   private String edtTLiqCod_Internalname ;
   private String edtTLiqCod_Jsonclick ;
   private String edtConTLOrdejec_Internalname ;
   private String edtConTLOrdejec_Jsonclick ;
   private String edtConTLConHab_Internalname ;
   private String edtConTLConHab_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
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
   private String divSectionattribute_concodigo_Internalname ;
   private String edtavComboconcodigo_Internalname ;
   private String AV22ComboConCodigo ;
   private String edtavComboconcodigo_Jsonclick ;
   private String divSectionattribute_tliqcod_Internalname ;
   private String edtavCombotliqcod_Internalname ;
   private String AV25ComboTLiqCod ;
   private String edtavCombotliqcod_Jsonclick ;
   private String A1788ConTLTipoCon ;
   private String AV26Pgmname ;
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
   private String Combo_concodigo_Objectcall ;
   private String Combo_concodigo_Class ;
   private String Combo_concodigo_Icontype ;
   private String Combo_concodigo_Icon ;
   private String Combo_concodigo_Tooltip ;
   private String Combo_concodigo_Selectedvalue_set ;
   private String Combo_concodigo_Selectedtext_set ;
   private String Combo_concodigo_Selectedtext_get ;
   private String Combo_concodigo_Gamoauthtoken ;
   private String Combo_concodigo_Ddointernalname ;
   private String Combo_concodigo_Titlecontrolalign ;
   private String Combo_concodigo_Dropdownoptionstype ;
   private String Combo_concodigo_Titlecontrolidtoreplace ;
   private String Combo_concodigo_Datalisttype ;
   private String Combo_concodigo_Datalistfixedvalues ;
   private String Combo_concodigo_Datalistprocparametersprefix ;
   private String Combo_concodigo_Remoteservicesparameters ;
   private String Combo_concodigo_Htmltemplate ;
   private String Combo_concodigo_Multiplevaluestype ;
   private String Combo_concodigo_Loadingdata ;
   private String Combo_concodigo_Noresultsfound ;
   private String Combo_concodigo_Emptyitemtext ;
   private String Combo_concodigo_Onlyselectedvalues ;
   private String Combo_concodigo_Selectalltext ;
   private String Combo_concodigo_Multiplevaluesseparator ;
   private String Combo_concodigo_Addnewoptiontext ;
   private String Combo_tliqcod_Objectcall ;
   private String Combo_tliqcod_Class ;
   private String Combo_tliqcod_Icontype ;
   private String Combo_tliqcod_Icon ;
   private String Combo_tliqcod_Tooltip ;
   private String Combo_tliqcod_Selectedvalue_set ;
   private String Combo_tliqcod_Selectedtext_set ;
   private String Combo_tliqcod_Selectedtext_get ;
   private String Combo_tliqcod_Gamoauthtoken ;
   private String Combo_tliqcod_Ddointernalname ;
   private String Combo_tliqcod_Titlecontrolalign ;
   private String Combo_tliqcod_Dropdownoptionstype ;
   private String Combo_tliqcod_Titlecontrolidtoreplace ;
   private String Combo_tliqcod_Datalisttype ;
   private String Combo_tliqcod_Datalistfixedvalues ;
   private String Combo_tliqcod_Datalistprocparametersprefix ;
   private String Combo_tliqcod_Remoteservicesparameters ;
   private String Combo_tliqcod_Htmltemplate ;
   private String Combo_tliqcod_Multiplevaluestype ;
   private String Combo_tliqcod_Loadingdata ;
   private String Combo_tliqcod_Noresultsfound ;
   private String Combo_tliqcod_Emptyitemtext ;
   private String Combo_tliqcod_Onlyselectedvalues ;
   private String Combo_tliqcod_Selectalltext ;
   private String Combo_tliqcod_Multiplevaluesseparator ;
   private String Combo_tliqcod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode8 ;
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
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_concodigo_Emptyitem ;
   private boolean Combo_tliqcod_Emptyitem ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1789CONTLSegPla ;
   private boolean n42ConCodYDesc ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
   private boolean Combo_concodigo_Enabled ;
   private boolean Combo_concodigo_Visible ;
   private boolean Combo_concodigo_Allowmultipleselection ;
   private boolean Combo_concodigo_Isgriditem ;
   private boolean Combo_concodigo_Hasdescription ;
   private boolean Combo_concodigo_Includeonlyselectedoption ;
   private boolean Combo_concodigo_Includeselectalloption ;
   private boolean Combo_concodigo_Includeaddnewoption ;
   private boolean Combo_tliqcod_Enabled ;
   private boolean Combo_tliqcod_Visible ;
   private boolean Combo_tliqcod_Allowmultipleselection ;
   private boolean Combo_tliqcod_Isgriditem ;
   private boolean Combo_tliqcod_Hasdescription ;
   private boolean Combo_tliqcod_Includeonlyselectedoption ;
   private boolean Combo_tliqcod_Includeselectalloption ;
   private boolean Combo_tliqcod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV19Combo_DataJson ;
   private String A42ConCodYDesc ;
   private String A41ConDescrip ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_concodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_tliqcod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConTLVigencia ;
   private HTMLChoice cmbConTLCondicion ;
   private IDataStoreProvider pr_default ;
   private String[] T00595_A42ConCodYDesc ;
   private boolean[] T00595_n42ConCodYDesc ;
   private String[] T00595_A41ConDescrip ;
   private String[] T00596_A42ConCodYDesc ;
   private boolean[] T00596_n42ConCodYDesc ;
   private long[] T00596_A1406ConTLOrdejec ;
   private byte[] T00596_A1409ConTLVigencia ;
   private boolean[] T00596_n1409ConTLVigencia ;
   private String[] T00596_A1410ConTLCondicion ;
   private boolean[] T00596_n1410ConTLCondicion ;
   private byte[] T00596_A1470ConTLConHab ;
   private String[] T00596_A1788ConTLTipoCon ;
   private boolean[] T00596_n1788ConTLTipoCon ;
   private byte[] T00596_A1789CONTLSegPla ;
   private boolean[] T00596_n1789CONTLSegPla ;
   private String[] T00596_A41ConDescrip ;
   private int[] T00596_A3CliCod ;
   private String[] T00596_A32TLiqCod ;
   private String[] T00596_A26ConCodigo ;
   private int[] T00594_A3CliCod ;
   private String[] T00597_A42ConCodYDesc ;
   private boolean[] T00597_n42ConCodYDesc ;
   private String[] T00597_A41ConDescrip ;
   private int[] T00598_A3CliCod ;
   private int[] T00599_A3CliCod ;
   private String[] T00599_A26ConCodigo ;
   private String[] T00599_A32TLiqCod ;
   private long[] T00593_A1406ConTLOrdejec ;
   private byte[] T00593_A1409ConTLVigencia ;
   private boolean[] T00593_n1409ConTLVigencia ;
   private String[] T00593_A1410ConTLCondicion ;
   private boolean[] T00593_n1410ConTLCondicion ;
   private byte[] T00593_A1470ConTLConHab ;
   private String[] T00593_A1788ConTLTipoCon ;
   private boolean[] T00593_n1788ConTLTipoCon ;
   private byte[] T00593_A1789CONTLSegPla ;
   private boolean[] T00593_n1789CONTLSegPla ;
   private int[] T00593_A3CliCod ;
   private String[] T00593_A32TLiqCod ;
   private String[] T00593_A26ConCodigo ;
   private int[] T005910_A3CliCod ;
   private String[] T005910_A32TLiqCod ;
   private String[] T005910_A26ConCodigo ;
   private int[] T005911_A3CliCod ;
   private String[] T005911_A32TLiqCod ;
   private String[] T005911_A26ConCodigo ;
   private long[] T00592_A1406ConTLOrdejec ;
   private byte[] T00592_A1409ConTLVigencia ;
   private boolean[] T00592_n1409ConTLVigencia ;
   private String[] T00592_A1410ConTLCondicion ;
   private boolean[] T00592_n1410ConTLCondicion ;
   private byte[] T00592_A1470ConTLConHab ;
   private String[] T00592_A1788ConTLTipoCon ;
   private boolean[] T00592_n1788ConTLTipoCon ;
   private byte[] T00592_A1789CONTLSegPla ;
   private boolean[] T00592_n1789CONTLSegPla ;
   private int[] T00592_A3CliCod ;
   private String[] T00592_A32TLiqCod ;
   private String[] T00592_A26ConCodigo ;
   private String[] T005915_A42ConCodYDesc ;
   private boolean[] T005915_n42ConCodYDesc ;
   private String[] T005915_A41ConDescrip ;
   private int[] T005916_A3CliCod ;
   private String[] T005916_A26ConCodigo ;
   private String[] T005916_A32TLiqCod ;
   private int[] T005917_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21ConCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24TLiqCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class conceptotipoliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00592", "SELECT ConTLOrdejec, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod, ConCodigo FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?  FOR UPDATE OF ConceptoTipoLiquidacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00593", "SELECT ConTLOrdejec, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod, ConCodigo FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00594", "SELECT CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00595", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00596", "SELECT T2.ConCodYDesc, TM1.ConTLOrdejec, TM1.ConTLVigencia, TM1.ConTLCondicion, TM1.ConTLConHab, TM1.ConTLTipoCon, TM1.CONTLSegPla, T2.ConDescrip, TM1.CliCod, TM1.TLiqCod, TM1.ConCodigo FROM (ConceptoTipoLiquidacion TM1 INNER JOIN Concepto T2 ON T2.CliCod = TM1.CliCod AND T2.ConCodigo = TM1.ConCodigo) WHERE TM1.CliCod = ? and TM1.TLiqCod = ( ?) and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo, TM1.TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00597", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00598", "SELECT CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00599", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005910", "SELECT CliCod, TLiqCod, ConCodigo FROM ConceptoTipoLiquidacion WHERE ( CliCod > ? or CliCod = ? and TLiqCod > ( ?) or TLiqCod = ( ?) and CliCod = ? and ConCodigo > ( ?)) ORDER BY CliCod, ConCodigo, TLiqCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005911", "SELECT CliCod, TLiqCod, ConCodigo FROM ConceptoTipoLiquidacion WHERE ( CliCod < ? or CliCod = ? and TLiqCod < ( ?) or TLiqCod = ( ?) and CliCod = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, ConCodigo DESC, TLiqCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005912", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(ConTLOrdejec, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod, ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLConOrd) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005913", "SAVEPOINT gxupdate;UPDATE ConceptoTipoLiquidacion SET ConTLOrdejec=?, ConTLVigencia=?, ConTLCondicion=?, ConTLConHab=?, ConTLTipoCon=?, CONTLSegPla=?  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005914", "SAVEPOINT gxupdate;DELETE FROM ConceptoTipoLiquidacion  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005915", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005916", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion ORDER BY CliCod, ConCodigo, TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005917", "SELECT CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((String[]) buf[11])[0] = rslt.getString(8, 20);
               ((String[]) buf[12])[0] = rslt.getString(9, 10);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((String[]) buf[11])[0] = rslt.getString(8, 20);
               ((String[]) buf[12])[0] = rslt.getString(9, 10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(5);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((int[]) buf[13])[0] = rslt.getInt(9);
               ((String[]) buf[14])[0] = rslt.getString(10, 20);
               ((String[]) buf[15])[0] = rslt.getString(11, 10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 15 :
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               stmt.setByte(4, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[7], 20);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[9]).byteValue());
               }
               stmt.setInt(7, ((Number) parms[10]).intValue());
               stmt.setString(8, (String)parms[11], 20);
               stmt.setString(9, (String)parms[12], 10);
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               stmt.setByte(4, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[7], 20);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[9]).byteValue());
               }
               stmt.setInt(7, ((Number) parms[10]).intValue());
               stmt.setString(8, (String)parms[11], 10);
               stmt.setString(9, (String)parms[12], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

