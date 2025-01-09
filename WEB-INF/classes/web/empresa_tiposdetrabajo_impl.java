package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresa_tiposdetrabajo_impl extends GXDataArea
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
         gx2asaclicod5N166( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A3CliCod, A1EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A1294PaiTipoTraId) ;
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
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9PaiTipoTraId", AV9PaiTipoTraId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PaiTipoTraId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "empresa_tiposdetrabajo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public empresa_tiposdetrabajo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresa_tiposdetrabajo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_tiposdetrabajo_impl.class ));
   }

   public empresa_tiposdetrabajo_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPaiTipoTraId = new HTMLChoice();
      cmbavCombopaitipotraid = new HTMLChoice();
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
      if ( cmbPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Values", cmbPaiTipoTraId.ToJavascriptSource(), true);
      }
      if ( cmbavCombopaitipotraid.getItemCount() > 0 )
      {
         AV20ComboPaiTipoTraId = cmbavCombopaitipotraid.getValidValue(AV20ComboPaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiTipoTraId", AV20ComboPaiTipoTraId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCombopaitipotraid.setValue( GXutil.rtrim( AV20ComboPaiTipoTraId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Values", cmbavCombopaitipotraid.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedpaitipotraid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaitipotraid_Internalname, httpContext.getMessage( "Tipo de Trabajo", ""), "", "", lblTextblockpaitipotraid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paitipotraid.setProperty("Caption", Combo_paitipotraid_Caption);
      ucCombo_paitipotraid.setProperty("Cls", Combo_paitipotraid_Cls);
      ucCombo_paitipotraid.setProperty("DataListProc", Combo_paitipotraid_Datalistproc);
      ucCombo_paitipotraid.setProperty("DataListProcParametersPrefix", Combo_paitipotraid_Datalistprocparametersprefix);
      ucCombo_paitipotraid.setProperty("EmptyItem", Combo_paitipotraid_Emptyitem);
      ucCombo_paitipotraid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_paitipotraid.setProperty("DropDownOptionsData", AV15PaiTipoTraId_Data);
      ucCombo_paitipotraid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paitipotraid_Internalname, "COMBO_PAITIPOTRAIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiTipoTraId.getInternalname(), httpContext.getMessage( "Tipo de Trabajo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTipoTraId, cmbPaiTipoTraId.getInternalname(), GXutil.rtrim( A1294PaiTipoTraId), 1, cmbPaiTipoTraId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbPaiTipoTraId.getVisible(), cmbPaiTipoTraId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "", true, (byte)(0), "HLP_empresa_tiposdetrabajo.htm");
      cmbPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Values", cmbPaiTipoTraId.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsDia_Internalname, httpContext.getMessage( "Límite de horas normales por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1344EmpHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsDia_Enabled!=0) ? localUtil.format( A1344EmpHsDia, "9.9") : localUtil.format( A1344EmpHsDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsSem_Internalname, httpContext.getMessage( "Límite de horas normales por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1345EmpHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsSem_Enabled!=0) ? localUtil.format( A1345EmpHsSem, "Z9.9") : localUtil.format( A1345EmpHsSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsMaxDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsMaxDia_Internalname, httpContext.getMessage( "Máximo de horas extras por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsMaxDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1386EmpHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsMaxDia_Enabled!=0) ? localUtil.format( A1386EmpHsMaxDia, "9.9") : localUtil.format( A1386EmpHsMaxDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsMaxDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsMaxDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsMaxSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsMaxSem_Internalname, httpContext.getMessage( "Máximo de horas extras por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsMaxSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1387EmpHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsMaxSem_Enabled!=0) ? localUtil.format( A1387EmpHsMaxSem, "Z9.9") : localUtil.format( A1387EmpHsMaxSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsMaxSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsMaxSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsMaxMes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsMaxMes_Internalname, httpContext.getMessage( "Máximo de horas extras por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsMaxMes_Internalname, GXutil.ltrim( localUtil.ntoc( A1388EmpHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsMaxMes_Enabled!=0) ? localUtil.format( A1388EmpHsMaxMes, "ZZ9.9") : localUtil.format( A1388EmpHsMaxMes, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsMaxMes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsMaxMes_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsMaxAnu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsMaxAnu_Internalname, httpContext.getMessage( "Máximo de horas extras por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsMaxAnu_Internalname, GXutil.ltrim( localUtil.ntoc( A1389EmpHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpHsMaxAnu_Enabled!=0) ? localUtil.format( A1389EmpHsMaxAnu, "ZZ9.9") : localUtil.format( A1389EmpHsMaxAnu, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsMaxAnu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsMaxAnu_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_empresa_tiposdetrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_empresa_tiposdetrabajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_paitipotraid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCombopaitipotraid, cmbavCombopaitipotraid.getInternalname(), GXutil.rtrim( AV20ComboPaiTipoTraId), 1, cmbavCombopaitipotraid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavCombopaitipotraid.getVisible(), cmbavCombopaitipotraid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_empresa_tiposdetrabajo.htm");
      cmbavCombopaitipotraid.setValue( GXutil.rtrim( AV20ComboPaiTipoTraId) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Values", cmbavCombopaitipotraid.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_empresa_tiposdetrabajo.htm");
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
      e115N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAITIPOTRAID_DATA"), AV15PaiTipoTraId_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1294PaiTipoTraId = httpContext.cgiGet( "Z1294PaiTipoTraId") ;
            Z1344EmpHsDia = localUtil.ctond( httpContext.cgiGet( "Z1344EmpHsDia")) ;
            Z1345EmpHsSem = localUtil.ctond( httpContext.cgiGet( "Z1345EmpHsSem")) ;
            Z1346EmpTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1346EmpTarifaXLim")) ;
            Z1352EmpTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1352EmpTarifaRec")) ;
            Z1386EmpHsMaxDia = localUtil.ctond( httpContext.cgiGet( "Z1386EmpHsMaxDia")) ;
            Z1387EmpHsMaxSem = localUtil.ctond( httpContext.cgiGet( "Z1387EmpHsMaxSem")) ;
            Z1388EmpHsMaxMes = localUtil.ctond( httpContext.cgiGet( "Z1388EmpHsMaxMes")) ;
            Z1389EmpHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "Z1389EmpHsMaxAnu")) ;
            Z2005EmpHsRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2005EmpHsRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2437EmpHsHorDes = httpContext.cgiGet( "Z2437EmpHsHorDes") ;
            A1346EmpTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1346EmpTarifaXLim")) ;
            A1352EmpTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1352EmpTarifaRec")) ;
            A2005EmpHsRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2005EmpHsRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2437EmpHsHorDes = httpContext.cgiGet( "Z2437EmpHsHorDes") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9PaiTipoTraId = httpContext.cgiGet( "vPAITIPOTRAID") ;
            A1346EmpTarifaXLim = localUtil.ctond( httpContext.cgiGet( "EMPTARIFAXLIM")) ;
            AV28EmpTarifaXLim = localUtil.ctond( httpContext.cgiGet( "vEMPTARIFAXLIM")) ;
            A1352EmpTarifaRec = localUtil.ctond( httpContext.cgiGet( "EMPTARIFAREC")) ;
            AV29EmpTarifaRec = localUtil.ctond( httpContext.cgiGet( "vEMPTARIFAREC")) ;
            AV25EmpHsDia = localUtil.ctond( httpContext.cgiGet( "vEMPHSDIA")) ;
            AV27EmpHsSem = localUtil.ctond( httpContext.cgiGet( "vEMPHSSEM")) ;
            AV30EmpHsMaxDia = localUtil.ctond( httpContext.cgiGet( "vEMPHSMAXDIA")) ;
            AV31EmpHsMaxSem = localUtil.ctond( httpContext.cgiGet( "vEMPHSMAXSEM")) ;
            AV32EmpHsMaxMes = localUtil.ctond( httpContext.cgiGet( "vEMPHSMAXMES")) ;
            AV26EmpHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "vEMPHSMAXANU")) ;
            A2005EmpHsRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "EMPHSRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2437EmpHsHorDes = httpContext.cgiGet( "EMPHSHORDES") ;
            AV33Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_paitipotraid_Objectcall = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Objectcall") ;
            Combo_paitipotraid_Class = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Class") ;
            Combo_paitipotraid_Icontype = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Icontype") ;
            Combo_paitipotraid_Icon = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Icon") ;
            Combo_paitipotraid_Caption = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Caption") ;
            Combo_paitipotraid_Tooltip = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Tooltip") ;
            Combo_paitipotraid_Cls = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Cls") ;
            Combo_paitipotraid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Selectedvalue_set") ;
            Combo_paitipotraid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Selectedvalue_get") ;
            Combo_paitipotraid_Selectedtext_set = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Selectedtext_set") ;
            Combo_paitipotraid_Selectedtext_get = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Selectedtext_get") ;
            Combo_paitipotraid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Gamoauthtoken") ;
            Combo_paitipotraid_Ddointernalname = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Ddointernalname") ;
            Combo_paitipotraid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Titlecontrolalign") ;
            Combo_paitipotraid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Dropdownoptionstype") ;
            Combo_paitipotraid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Enabled")) ;
            Combo_paitipotraid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Visible")) ;
            Combo_paitipotraid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Titlecontrolidtoreplace") ;
            Combo_paitipotraid_Datalisttype = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Datalisttype") ;
            Combo_paitipotraid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Allowmultipleselection")) ;
            Combo_paitipotraid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Datalistfixedvalues") ;
            Combo_paitipotraid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Isgriditem")) ;
            Combo_paitipotraid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Hasdescription")) ;
            Combo_paitipotraid_Datalistproc = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Datalistproc") ;
            Combo_paitipotraid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Datalistprocparametersprefix") ;
            Combo_paitipotraid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Remoteservicesparameters") ;
            Combo_paitipotraid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_paitipotraid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Includeonlyselectedoption")) ;
            Combo_paitipotraid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Includeselectalloption")) ;
            Combo_paitipotraid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Emptyitem")) ;
            Combo_paitipotraid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Includeaddnewoption")) ;
            Combo_paitipotraid_Htmltemplate = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Htmltemplate") ;
            Combo_paitipotraid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Multiplevaluestype") ;
            Combo_paitipotraid_Loadingdata = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Loadingdata") ;
            Combo_paitipotraid_Noresultsfound = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Noresultsfound") ;
            Combo_paitipotraid_Emptyitemtext = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Emptyitemtext") ;
            Combo_paitipotraid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Onlyselectedvalues") ;
            Combo_paitipotraid_Selectalltext = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Selectalltext") ;
            Combo_paitipotraid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Multiplevaluesseparator") ;
            Combo_paitipotraid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PAITIPOTRAID_Addnewoptiontext") ;
            Combo_paitipotraid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAITIPOTRAID_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            cmbPaiTipoTraId.setValue( httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) );
            A1294PaiTipoTraId = httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1344EmpHsDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1344EmpHsDia", GXutil.ltrimstr( A1344EmpHsDia, 3, 1));
            }
            else
            {
               A1344EmpHsDia = localUtil.ctond( httpContext.cgiGet( edtEmpHsDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1344EmpHsDia", GXutil.ltrimstr( A1344EmpHsDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1345EmpHsSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1345EmpHsSem", GXutil.ltrimstr( A1345EmpHsSem, 4, 1));
            }
            else
            {
               A1345EmpHsSem = localUtil.ctond( httpContext.cgiGet( edtEmpHsSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1345EmpHsSem", GXutil.ltrimstr( A1345EmpHsSem, 4, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSMAXDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsMaxDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1386EmpHsMaxDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1386EmpHsMaxDia", GXutil.ltrimstr( A1386EmpHsMaxDia, 3, 1));
            }
            else
            {
               A1386EmpHsMaxDia = localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1386EmpHsMaxDia", GXutil.ltrimstr( A1386EmpHsMaxDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSMAXSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsMaxSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1387EmpHsMaxSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1387EmpHsMaxSem", GXutil.ltrimstr( A1387EmpHsMaxSem, 4, 1));
            }
            else
            {
               A1387EmpHsMaxSem = localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1387EmpHsMaxSem", GXutil.ltrimstr( A1387EmpHsMaxSem, 4, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxMes_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxMes_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSMAXMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsMaxMes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1388EmpHsMaxMes = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1388EmpHsMaxMes", GXutil.ltrimstr( A1388EmpHsMaxMes, 5, 1));
            }
            else
            {
               A1388EmpHsMaxMes = localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxMes_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1388EmpHsMaxMes", GXutil.ltrimstr( A1388EmpHsMaxMes, 5, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxAnu_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxAnu_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSMAXANU");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsMaxAnu_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1389EmpHsMaxAnu", GXutil.ltrimstr( A1389EmpHsMaxAnu, 5, 1));
            }
            else
            {
               A1389EmpHsMaxAnu = localUtil.ctond( httpContext.cgiGet( edtEmpHsMaxAnu_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1389EmpHsMaxAnu", GXutil.ltrimstr( A1389EmpHsMaxAnu, 5, 1));
            }
            cmbavCombopaitipotraid.setValue( httpContext.cgiGet( cmbavCombopaitipotraid.getInternalname()) );
            AV20ComboPaiTipoTraId = httpContext.cgiGet( cmbavCombopaitipotraid.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiTipoTraId", AV20ComboPaiTipoTraId);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"empresa_tiposdetrabajo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("EmpTarifaXLim", localUtil.format( A1346EmpTarifaXLim, "9.9999"));
            forbiddenHiddens.add("EmpTarifaRec", localUtil.format( A1352EmpTarifaRec, "9.9999"));
            forbiddenHiddens.add("EmpHsRelSec", localUtil.format( DecimalUtil.doubleToDec(A2005EmpHsRelSec), "ZZZZZ9"));
            forbiddenHiddens.add("EmpHsHorDes", GXutil.rtrim( localUtil.format( A2437EmpHsHorDes, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("empresa_tiposdetrabajo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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
                  sMode166 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode166 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound166 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5N0( ) ;
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
                        e115N2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125N2 ();
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
         e125N2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5N166( ) ;
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
         disableAttributes5N166( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCombopaitipotraid.getEnabled(), 5, 0), true);
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

   public void confirm_5N0( )
   {
      beforeValidate5N166( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5N166( ) ;
         }
         else
         {
            checkExtendedTable5N166( ) ;
            closeExtendedTableCursors5N166( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5N0( )
   {
   }

   public void e115N2( )
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
      cmbPaiTipoTraId.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiTipoTraId.getVisible(), 5, 0), true);
      AV20ComboPaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiTipoTraId", AV20ComboPaiTipoTraId);
      cmbavCombopaitipotraid.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavCombopaitipotraid.getVisible(), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAITIPOTRAID' */
      S112 ();
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWempresa_tiposdetrabajo_Insert", GXv_boolean5) ;
         empresa_tiposdetrabajo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWempresa_tiposdetrabajo_Update", GXv_boolean5) ;
         empresa_tiposdetrabajo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWempresa_tiposdetrabajo_Delete", GXv_boolean5) ;
         empresa_tiposdetrabajo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV33Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      GXt_int6 = AV24PaiCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int7) ;
      empresa_tiposdetrabajo_impl.this.GXt_int6 = GXv_int7[0] ;
      AV24PaiCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24PaiCod), 4, 0));
      GXv_decimal8[0] = AV25EmpHsDia ;
      GXv_decimal9[0] = AV27EmpHsSem ;
      GXv_decimal10[0] = AV28EmpTarifaXLim ;
      GXv_decimal11[0] = AV29EmpTarifaRec ;
      GXv_decimal12[0] = AV30EmpHsMaxDia ;
      GXv_decimal13[0] = AV31EmpHsMaxSem ;
      GXv_decimal14[0] = AV32EmpHsMaxMes ;
      GXv_decimal15[0] = AV26EmpHsMaxAnu ;
      new web.getpaitipotraold(remoteHandle, context).execute( AV24PaiCod, AV9PaiTipoTraId, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_decimal12, GXv_decimal13, GXv_decimal14, GXv_decimal15) ;
      empresa_tiposdetrabajo_impl.this.AV25EmpHsDia = GXv_decimal8[0] ;
      empresa_tiposdetrabajo_impl.this.AV27EmpHsSem = GXv_decimal9[0] ;
      empresa_tiposdetrabajo_impl.this.AV28EmpTarifaXLim = GXv_decimal10[0] ;
      empresa_tiposdetrabajo_impl.this.AV29EmpTarifaRec = GXv_decimal11[0] ;
      empresa_tiposdetrabajo_impl.this.AV30EmpHsMaxDia = GXv_decimal12[0] ;
      empresa_tiposdetrabajo_impl.this.AV31EmpHsMaxSem = GXv_decimal13[0] ;
      empresa_tiposdetrabajo_impl.this.AV32EmpHsMaxMes = GXv_decimal14[0] ;
      empresa_tiposdetrabajo_impl.this.AV26EmpHsMaxAnu = GXv_decimal15[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmpHsDia", GXutil.ltrimstr( AV25EmpHsDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV27EmpHsSem", GXutil.ltrimstr( AV27EmpHsSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV28EmpTarifaXLim", GXutil.ltrimstr( AV28EmpTarifaXLim, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV29EmpTarifaRec", GXutil.ltrimstr( AV29EmpTarifaRec, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV30EmpHsMaxDia", GXutil.ltrimstr( AV30EmpHsMaxDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV31EmpHsMaxSem", GXutil.ltrimstr( AV31EmpHsMaxSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV32EmpHsMaxMes", GXutil.ltrimstr( AV32EmpHsMaxMes, 5, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV26EmpHsMaxAnu", GXutil.ltrimstr( AV26EmpHsMaxAnu, 5, 1));
   }

   public void e125N2( )
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

   public void S112( )
   {
      /* 'LOADCOMBOPAITIPOTRAID' Routine */
      returnInSub = false ;
      GXt_char16 = AV19Combo_DataJson ;
      GXv_char17[0] = AV17ComboSelectedValue ;
      GXv_char18[0] = AV18ComboSelectedText ;
      GXv_char19[0] = GXt_char16 ;
      new web.empresa_tiposdetrabajoloaddvcombo(remoteHandle, context).execute( "PaiTipoTraId", Gx_mode, false, AV7CliCod, AV8EmpCod, AV9PaiTipoTraId, "", GXv_char17, GXv_char18, GXv_char19) ;
      empresa_tiposdetrabajo_impl.this.AV17ComboSelectedValue = GXv_char17[0] ;
      empresa_tiposdetrabajo_impl.this.AV18ComboSelectedText = GXv_char18[0] ;
      empresa_tiposdetrabajo_impl.this.GXt_char16 = GXv_char19[0] ;
      AV19Combo_DataJson = GXt_char16 ;
      Combo_paitipotraid_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "SelectedValue_set", Combo_paitipotraid_Selectedvalue_set);
      Combo_paitipotraid_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "SelectedText_set", Combo_paitipotraid_Selectedtext_set);
      AV20ComboPaiTipoTraId = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiTipoTraId", AV20ComboPaiTipoTraId);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9PaiTipoTraId)==0) )
      {
         Combo_paitipotraid_Enabled = false ;
         ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "Enabled", GXutil.booltostr( Combo_paitipotraid_Enabled));
      }
   }

   public void zm5N166( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1344EmpHsDia = T005N3_A1344EmpHsDia[0] ;
            Z1345EmpHsSem = T005N3_A1345EmpHsSem[0] ;
            Z1346EmpTarifaXLim = T005N3_A1346EmpTarifaXLim[0] ;
            Z1352EmpTarifaRec = T005N3_A1352EmpTarifaRec[0] ;
            Z1386EmpHsMaxDia = T005N3_A1386EmpHsMaxDia[0] ;
            Z1387EmpHsMaxSem = T005N3_A1387EmpHsMaxSem[0] ;
            Z1388EmpHsMaxMes = T005N3_A1388EmpHsMaxMes[0] ;
            Z1389EmpHsMaxAnu = T005N3_A1389EmpHsMaxAnu[0] ;
            Z2005EmpHsRelSec = T005N3_A2005EmpHsRelSec[0] ;
            Z2437EmpHsHorDes = T005N3_A2437EmpHsHorDes[0] ;
         }
         else
         {
            Z1344EmpHsDia = A1344EmpHsDia ;
            Z1345EmpHsSem = A1345EmpHsSem ;
            Z1346EmpTarifaXLim = A1346EmpTarifaXLim ;
            Z1352EmpTarifaRec = A1352EmpTarifaRec ;
            Z1386EmpHsMaxDia = A1386EmpHsMaxDia ;
            Z1387EmpHsMaxSem = A1387EmpHsMaxSem ;
            Z1388EmpHsMaxMes = A1388EmpHsMaxMes ;
            Z1389EmpHsMaxAnu = A1389EmpHsMaxAnu ;
            Z2005EmpHsRelSec = A2005EmpHsRelSec ;
            Z2437EmpHsHorDes = A2437EmpHsHorDes ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z1344EmpHsDia = A1344EmpHsDia ;
         Z1345EmpHsSem = A1345EmpHsSem ;
         Z1346EmpTarifaXLim = A1346EmpTarifaXLim ;
         Z1352EmpTarifaRec = A1352EmpTarifaRec ;
         Z1386EmpHsMaxDia = A1386EmpHsMaxDia ;
         Z1387EmpHsMaxSem = A1387EmpHsMaxSem ;
         Z1388EmpHsMaxMes = A1388EmpHsMaxMes ;
         Z1389EmpHsMaxAnu = A1389EmpHsMaxAnu ;
         Z2005EmpHsRelSec = A2005EmpHsRelSec ;
         Z2437EmpHsHorDes = A2437EmpHsHorDes ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
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
            GXt_int20 = A3CliCod ;
            GXv_int21[0] = GXt_int20 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int21) ;
            empresa_tiposdetrabajo_impl.this.GXt_int20 = GXv_int21[0] ;
            A3CliCod = GXt_int20 ;
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
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9PaiTipoTraId)==0) )
      {
         cmbPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbPaiTipoTraId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9PaiTipoTraId)==0) )
      {
         cmbPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9PaiTipoTraId)==0) )
      {
         A1294PaiTipoTraId = AV9PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      else
      {
         A1294PaiTipoTraId = AV20ComboPaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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
         AV33Pgmname = "empresa_tiposdetrabajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      }
   }

   public void load5N166( )
   {
      /* Using cursor T005N6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = T005N6_A1344EmpHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1344EmpHsDia", GXutil.ltrimstr( A1344EmpHsDia, 3, 1));
         A1345EmpHsSem = T005N6_A1345EmpHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1345EmpHsSem", GXutil.ltrimstr( A1345EmpHsSem, 4, 1));
         A1346EmpTarifaXLim = T005N6_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = T005N6_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = T005N6_A1386EmpHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1386EmpHsMaxDia", GXutil.ltrimstr( A1386EmpHsMaxDia, 3, 1));
         A1387EmpHsMaxSem = T005N6_A1387EmpHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1387EmpHsMaxSem", GXutil.ltrimstr( A1387EmpHsMaxSem, 4, 1));
         A1388EmpHsMaxMes = T005N6_A1388EmpHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1388EmpHsMaxMes", GXutil.ltrimstr( A1388EmpHsMaxMes, 5, 1));
         A1389EmpHsMaxAnu = T005N6_A1389EmpHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1389EmpHsMaxAnu", GXutil.ltrimstr( A1389EmpHsMaxAnu, 5, 1));
         A2005EmpHsRelSec = T005N6_A2005EmpHsRelSec[0] ;
         A2437EmpHsHorDes = T005N6_A2437EmpHsHorDes[0] ;
         zm5N166( -19) ;
      }
      pr_default.close(4);
      onLoadActions5N166( ) ;
   }

   public void onLoadActions5N166( )
   {
      AV33Pgmname = "empresa_tiposdetrabajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
   }

   public void checkExtendedTable5N166( )
   {
      nIsDirty_166 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV33Pgmname = "empresa_tiposdetrabajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1344EmpHsDia, AV25EmpHsDia) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV25EmpHsDia, 3, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSDIA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsDia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1345EmpHsSem, AV27EmpHsSem) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV27EmpHsSem, 4, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSSEM");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsSem_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1346EmpTarifaXLim, AV28EmpTarifaXLim) < 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor menor a ", "")+GXutil.trim( GXutil.str( AV28EmpTarifaXLim, 6, 4))+httpContext.getMessage( " que es el aumento definido por país", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1352EmpTarifaRec, AV29EmpTarifaRec) < 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor menor a ", "")+GXutil.trim( GXutil.str( AV29EmpTarifaRec, 6, 4))+httpContext.getMessage( " que es el recargo definido por país", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1386EmpHsMaxDia, AV30EmpHsMaxDia) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV30EmpHsMaxDia, 3, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXDIA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsMaxDia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1387EmpHsMaxSem, AV31EmpHsMaxSem) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV31EmpHsMaxSem, 4, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXSEM");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsMaxSem_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1388EmpHsMaxMes, AV32EmpHsMaxMes) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV32EmpHsMaxMes, 5, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXMES");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsMaxMes_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  && ( DecimalUtil.compareTo(A1389EmpHsMaxAnu, AV26EmpHsMaxAnu) > 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV26EmpHsMaxAnu, 5, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXANU");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpHsMaxAnu_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005N4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T005N5 */
      pr_default.execute(3, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5N166( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_20( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T005N7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_21( String A1294PaiTipoTraId )
   {
      /* Using cursor T005N8 */
      pr_default.execute(6, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
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

   public void getKey5N166( )
   {
      /* Using cursor T005N9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound166 = (short)(1) ;
      }
      else
      {
         RcdFound166 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005N3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5N166( 19) ;
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = T005N3_A1344EmpHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1344EmpHsDia", GXutil.ltrimstr( A1344EmpHsDia, 3, 1));
         A1345EmpHsSem = T005N3_A1345EmpHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1345EmpHsSem", GXutil.ltrimstr( A1345EmpHsSem, 4, 1));
         A1346EmpTarifaXLim = T005N3_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = T005N3_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = T005N3_A1386EmpHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1386EmpHsMaxDia", GXutil.ltrimstr( A1386EmpHsMaxDia, 3, 1));
         A1387EmpHsMaxSem = T005N3_A1387EmpHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1387EmpHsMaxSem", GXutil.ltrimstr( A1387EmpHsMaxSem, 4, 1));
         A1388EmpHsMaxMes = T005N3_A1388EmpHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1388EmpHsMaxMes", GXutil.ltrimstr( A1388EmpHsMaxMes, 5, 1));
         A1389EmpHsMaxAnu = T005N3_A1389EmpHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1389EmpHsMaxAnu", GXutil.ltrimstr( A1389EmpHsMaxAnu, 5, 1));
         A2005EmpHsRelSec = T005N3_A2005EmpHsRelSec[0] ;
         A2437EmpHsHorDes = T005N3_A2437EmpHsHorDes[0] ;
         A3CliCod = T005N3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005N3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1294PaiTipoTraId = T005N3_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5N166( ) ;
         if ( AnyError == 1 )
         {
            RcdFound166 = (short)(0) ;
            initializeNonKey5N166( ) ;
         }
         Gx_mode = sMode166 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound166 = (short)(0) ;
         initializeNonKey5N166( ) ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode166 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5N166( ) ;
      if ( RcdFound166 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound166 = (short)(0) ;
      /* Using cursor T005N10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005N10_A3CliCod[0] < A3CliCod ) || ( T005N10_A3CliCod[0] == A3CliCod ) && ( T005N10_A1EmpCod[0] < A1EmpCod ) || ( T005N10_A1EmpCod[0] == A1EmpCod ) && ( T005N10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005N10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005N10_A3CliCod[0] > A3CliCod ) || ( T005N10_A3CliCod[0] == A3CliCod ) && ( T005N10_A1EmpCod[0] > A1EmpCod ) || ( T005N10_A1EmpCod[0] == A1EmpCod ) && ( T005N10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005N10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) ) )
         {
            A3CliCod = T005N10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005N10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1294PaiTipoTraId = T005N10_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            RcdFound166 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound166 = (short)(0) ;
      /* Using cursor T005N11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005N11_A3CliCod[0] > A3CliCod ) || ( T005N11_A3CliCod[0] == A3CliCod ) && ( T005N11_A1EmpCod[0] > A1EmpCod ) || ( T005N11_A1EmpCod[0] == A1EmpCod ) && ( T005N11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005N11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005N11_A3CliCod[0] < A3CliCod ) || ( T005N11_A3CliCod[0] == A3CliCod ) && ( T005N11_A1EmpCod[0] < A1EmpCod ) || ( T005N11_A1EmpCod[0] == A1EmpCod ) && ( T005N11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005N11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) ) )
         {
            A3CliCod = T005N11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005N11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1294PaiTipoTraId = T005N11_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            RcdFound166 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5N166( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5N166( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound166 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1294PaiTipoTraId = Z1294PaiTipoTraId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5N166( ) ;
               GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5N166( ) ;
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
                  GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5N166( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1294PaiTipoTraId = Z1294PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5N166( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005N2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1344EmpHsDia, T005N2_A1344EmpHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1345EmpHsSem, T005N2_A1345EmpHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1346EmpTarifaXLim, T005N2_A1346EmpTarifaXLim[0]) != 0 ) || ( DecimalUtil.compareTo(Z1352EmpTarifaRec, T005N2_A1352EmpTarifaRec[0]) != 0 ) || ( DecimalUtil.compareTo(Z1386EmpHsMaxDia, T005N2_A1386EmpHsMaxDia[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1387EmpHsMaxSem, T005N2_A1387EmpHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1388EmpHsMaxMes, T005N2_A1388EmpHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1389EmpHsMaxAnu, T005N2_A1389EmpHsMaxAnu[0]) != 0 ) || ( Z2005EmpHsRelSec != T005N2_A2005EmpHsRelSec[0] ) || ( GXutil.strcmp(Z2437EmpHsHorDes, T005N2_A2437EmpHsHorDes[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1344EmpHsDia, T005N2_A1344EmpHsDia[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsDia");
               GXutil.writeLogRaw("Old: ",Z1344EmpHsDia);
               GXutil.writeLogRaw("Current: ",T005N2_A1344EmpHsDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1345EmpHsSem, T005N2_A1345EmpHsSem[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsSem");
               GXutil.writeLogRaw("Old: ",Z1345EmpHsSem);
               GXutil.writeLogRaw("Current: ",T005N2_A1345EmpHsSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1346EmpTarifaXLim, T005N2_A1346EmpTarifaXLim[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpTarifaXLim");
               GXutil.writeLogRaw("Old: ",Z1346EmpTarifaXLim);
               GXutil.writeLogRaw("Current: ",T005N2_A1346EmpTarifaXLim[0]);
            }
            if ( DecimalUtil.compareTo(Z1352EmpTarifaRec, T005N2_A1352EmpTarifaRec[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpTarifaRec");
               GXutil.writeLogRaw("Old: ",Z1352EmpTarifaRec);
               GXutil.writeLogRaw("Current: ",T005N2_A1352EmpTarifaRec[0]);
            }
            if ( DecimalUtil.compareTo(Z1386EmpHsMaxDia, T005N2_A1386EmpHsMaxDia[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsMaxDia");
               GXutil.writeLogRaw("Old: ",Z1386EmpHsMaxDia);
               GXutil.writeLogRaw("Current: ",T005N2_A1386EmpHsMaxDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1387EmpHsMaxSem, T005N2_A1387EmpHsMaxSem[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsMaxSem");
               GXutil.writeLogRaw("Old: ",Z1387EmpHsMaxSem);
               GXutil.writeLogRaw("Current: ",T005N2_A1387EmpHsMaxSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1388EmpHsMaxMes, T005N2_A1388EmpHsMaxMes[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsMaxMes");
               GXutil.writeLogRaw("Old: ",Z1388EmpHsMaxMes);
               GXutil.writeLogRaw("Current: ",T005N2_A1388EmpHsMaxMes[0]);
            }
            if ( DecimalUtil.compareTo(Z1389EmpHsMaxAnu, T005N2_A1389EmpHsMaxAnu[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsMaxAnu");
               GXutil.writeLogRaw("Old: ",Z1389EmpHsMaxAnu);
               GXutil.writeLogRaw("Current: ",T005N2_A1389EmpHsMaxAnu[0]);
            }
            if ( Z2005EmpHsRelSec != T005N2_A2005EmpHsRelSec[0] )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsRelSec");
               GXutil.writeLogRaw("Old: ",Z2005EmpHsRelSec);
               GXutil.writeLogRaw("Current: ",T005N2_A2005EmpHsRelSec[0]);
            }
            if ( GXutil.strcmp(Z2437EmpHsHorDes, T005N2_A2437EmpHsHorDes[0]) != 0 )
            {
               GXutil.writeLogln("empresa_tiposdetrabajo:[seudo value changed for attri]"+"EmpHsHorDes");
               GXutil.writeLogRaw("Old: ",Z2437EmpHsHorDes);
               GXutil.writeLogRaw("Current: ",T005N2_A2437EmpHsHorDes[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresatipo_trabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5N166( )
   {
      beforeValidate5N166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5N166( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5N166( 0) ;
         checkOptimisticConcurrency5N166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5N166( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5N166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005N12 */
                  pr_default.execute(10, new Object[] {A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A2005EmpHsRelSec), A2437EmpHsHorDes, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
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
                        resetCaption5N0( ) ;
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
            load5N166( ) ;
         }
         endLevel5N166( ) ;
      }
      closeExtendedTableCursors5N166( ) ;
   }

   public void update5N166( )
   {
      beforeValidate5N166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5N166( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5N166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5N166( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5N166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005N13 */
                  pr_default.execute(11, new Object[] {A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A2005EmpHsRelSec), A2437EmpHsHorDes, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5N166( ) ;
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
         endLevel5N166( ) ;
      }
      closeExtendedTableCursors5N166( ) ;
   }

   public void deferredUpdate5N166( )
   {
   }

   public void delete( )
   {
      beforeValidate5N166( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5N166( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5N166( ) ;
         afterConfirm5N166( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5N166( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005N14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
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
      sMode166 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5N166( ) ;
      Gx_mode = sMode166 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5N166( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1344EmpHsDia, AV25EmpHsDia) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV25EmpHsDia, 3, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSDIA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsDia_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1345EmpHsSem, AV27EmpHsSem) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV27EmpHsSem, 4, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSSEM");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsSem_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1386EmpHsMaxDia, AV30EmpHsMaxDia) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV30EmpHsMaxDia, 3, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXDIA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsMaxDia_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1387EmpHsMaxSem, AV31EmpHsMaxSem) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV31EmpHsMaxSem, 4, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXSEM");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsMaxSem_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1388EmpHsMaxMes, AV32EmpHsMaxMes) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV32EmpHsMaxMes, 5, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXMES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsMaxMes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1389EmpHsMaxAnu, AV26EmpHsMaxAnu) > 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor mayor a ", "")+GXutil.trim( GXutil.str( AV26EmpHsMaxAnu, 5, 1))+httpContext.getMessage( " que es límite establecido por país", ""), 1, "EMPHSMAXANU");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpHsMaxAnu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1346EmpTarifaXLim, AV28EmpTarifaXLim) < 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor menor a ", "")+GXutil.trim( GXutil.str( AV28EmpTarifaXLim, 6, 4))+httpContext.getMessage( " que es el aumento definido por país", ""), 1, "");
            AnyError = (short)(1) ;
         }
         if ( isUpd( )  && ( DecimalUtil.compareTo(A1352EmpTarifaRec, AV29EmpTarifaRec) < 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No puede ingresar valor menor a ", "")+GXutil.trim( GXutil.str( AV29EmpTarifaRec, 6, 4))+httpContext.getMessage( " que es el recargo definido por país", ""), 1, "");
            AnyError = (short)(1) ;
         }
         AV33Pgmname = "empresa_tiposdetrabajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005N15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel5N166( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5N166( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresa_tiposdetrabajo");
         if ( AnyError == 0 )
         {
            confirmValues5N0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "empresa_tiposdetrabajo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5N166( )
   {
      /* Scan By routine */
      /* Using cursor T005N16 */
      pr_default.execute(14);
      RcdFound166 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A3CliCod = T005N16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005N16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1294PaiTipoTraId = T005N16_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5N166( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound166 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A3CliCod = T005N16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005N16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1294PaiTipoTraId = T005N16_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
   }

   public void scanEnd5N166( )
   {
      pr_default.close(14);
   }

   public void afterConfirm5N166( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5N166( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5N166( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5N166( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5N166( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5N166( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5N166( )
   {
      cmbPaiTipoTraId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      edtEmpHsDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsDia_Enabled), 5, 0), true);
      edtEmpHsSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsSem_Enabled), 5, 0), true);
      edtEmpHsMaxDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsMaxDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsMaxDia_Enabled), 5, 0), true);
      edtEmpHsMaxSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsMaxSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsMaxSem_Enabled), 5, 0), true);
      edtEmpHsMaxMes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsMaxMes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsMaxMes_Enabled), 5, 0), true);
      edtEmpHsMaxAnu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsMaxAnu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsMaxAnu_Enabled), 5, 0), true);
      cmbavCombopaitipotraid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCombopaitipotraid.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5N166( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5N0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresa_tiposdetrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9PaiTipoTraId))}, new String[] {"Gx_mode","CliCod","EmpCod","PaiTipoTraId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"empresa_tiposdetrabajo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("EmpTarifaXLim", localUtil.format( A1346EmpTarifaXLim, "9.9999"));
      forbiddenHiddens.add("EmpTarifaRec", localUtil.format( A1352EmpTarifaRec, "9.9999"));
      forbiddenHiddens.add("EmpHsRelSec", localUtil.format( DecimalUtil.doubleToDec(A2005EmpHsRelSec), "ZZZZZ9"));
      forbiddenHiddens.add("EmpHsHorDes", GXutil.rtrim( localUtil.format( A2437EmpHsHorDes, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("empresa_tiposdetrabajo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1294PaiTipoTraId", GXutil.rtrim( Z1294PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1344EmpHsDia", GXutil.ltrim( localUtil.ntoc( Z1344EmpHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1345EmpHsSem", GXutil.ltrim( localUtil.ntoc( Z1345EmpHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1346EmpTarifaXLim", GXutil.ltrim( localUtil.ntoc( Z1346EmpTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1352EmpTarifaRec", GXutil.ltrim( localUtil.ntoc( Z1352EmpTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1386EmpHsMaxDia", GXutil.ltrim( localUtil.ntoc( Z1386EmpHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1387EmpHsMaxSem", GXutil.ltrim( localUtil.ntoc( Z1387EmpHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1388EmpHsMaxMes", GXutil.ltrim( localUtil.ntoc( Z1388EmpHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1389EmpHsMaxAnu", GXutil.ltrim( localUtil.ntoc( Z1389EmpHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2005EmpHsRelSec", GXutil.ltrim( localUtil.ntoc( Z2005EmpHsRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2437EmpHsHorDes", GXutil.rtrim( Z2437EmpHsHorDes));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAITIPOTRAID_DATA", AV15PaiTipoTraId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAITIPOTRAID_DATA", AV15PaiTipoTraId_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOTRAID", GXutil.rtrim( AV9PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PaiTipoTraId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPTARIFAXLIM", GXutil.ltrim( localUtil.ntoc( A1346EmpTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPTARIFAXLIM", GXutil.ltrim( localUtil.ntoc( AV28EmpTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPTARIFAREC", GXutil.ltrim( localUtil.ntoc( A1352EmpTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPTARIFAREC", GXutil.ltrim( localUtil.ntoc( AV29EmpTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSDIA", GXutil.ltrim( localUtil.ntoc( AV25EmpHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSSEM", GXutil.ltrim( localUtil.ntoc( AV27EmpHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSMAXDIA", GXutil.ltrim( localUtil.ntoc( AV30EmpHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSMAXSEM", GXutil.ltrim( localUtil.ntoc( AV31EmpHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSMAXMES", GXutil.ltrim( localUtil.ntoc( AV32EmpHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSMAXANU", GXutil.ltrim( localUtil.ntoc( AV26EmpHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPHSRELSEC", GXutil.ltrim( localUtil.ntoc( A2005EmpHsRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPHSHORDES", GXutil.rtrim( A2437EmpHsHorDes));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV33Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Objectcall", GXutil.rtrim( Combo_paitipotraid_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Cls", GXutil.rtrim( Combo_paitipotraid_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Selectedvalue_set", GXutil.rtrim( Combo_paitipotraid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Selectedtext_set", GXutil.rtrim( Combo_paitipotraid_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Enabled", GXutil.booltostr( Combo_paitipotraid_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Datalistproc", GXutil.rtrim( Combo_paitipotraid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_paitipotraid_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAITIPOTRAID_Emptyitem", GXutil.booltostr( Combo_paitipotraid_Emptyitem));
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
      return formatLink("web.empresa_tiposdetrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9PaiTipoTraId))}, new String[] {"Gx_mode","CliCod","EmpCod","PaiTipoTraId"})  ;
   }

   public String getPgmname( )
   {
      return "empresa_tiposdetrabajo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "empresa_tiposdetrabajo", "") ;
   }

   public void initializeNonKey5N166( )
   {
      A1292TipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1292TipoTraId", A1292TipoTraId);
      A1344EmpHsDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1344EmpHsDia", GXutil.ltrimstr( A1344EmpHsDia, 3, 1));
      A1345EmpHsSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1345EmpHsSem", GXutil.ltrimstr( A1345EmpHsSem, 4, 1));
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1346EmpTarifaXLim", GXutil.ltrimstr( A1346EmpTarifaXLim, 6, 4));
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1352EmpTarifaRec", GXutil.ltrimstr( A1352EmpTarifaRec, 6, 4));
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1386EmpHsMaxDia", GXutil.ltrimstr( A1386EmpHsMaxDia, 3, 1));
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1387EmpHsMaxSem", GXutil.ltrimstr( A1387EmpHsMaxSem, 4, 1));
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1388EmpHsMaxMes", GXutil.ltrimstr( A1388EmpHsMaxMes, 5, 1));
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1389EmpHsMaxAnu", GXutil.ltrimstr( A1389EmpHsMaxAnu, 5, 1));
      A2005EmpHsRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2005EmpHsRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2005EmpHsRelSec), 6, 0));
      A2437EmpHsHorDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2437EmpHsHorDes", A2437EmpHsHorDes);
      Z1344EmpHsDia = DecimalUtil.ZERO ;
      Z1345EmpHsSem = DecimalUtil.ZERO ;
      Z1346EmpTarifaXLim = DecimalUtil.ZERO ;
      Z1352EmpTarifaRec = DecimalUtil.ZERO ;
      Z1386EmpHsMaxDia = DecimalUtil.ZERO ;
      Z1387EmpHsMaxSem = DecimalUtil.ZERO ;
      Z1388EmpHsMaxMes = DecimalUtil.ZERO ;
      Z1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Z2005EmpHsRelSec = 0 ;
      Z2437EmpHsHorDes = "" ;
   }

   public void initAll5N166( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1294PaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      initializeNonKey5N166( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202519851418", true, true);
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
      httpContext.AddJavascriptSource("empresa_tiposdetrabajo.js", "?202519851419", false, true);
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
      lblTextblockpaitipotraid_Internalname = "TEXTBLOCKPAITIPOTRAID" ;
      Combo_paitipotraid_Internalname = "COMBO_PAITIPOTRAID" ;
      cmbPaiTipoTraId.setInternalname( "PAITIPOTRAID" );
      divTablesplittedpaitipotraid_Internalname = "TABLESPLITTEDPAITIPOTRAID" ;
      edtEmpHsDia_Internalname = "EMPHSDIA" ;
      edtEmpHsSem_Internalname = "EMPHSSEM" ;
      edtEmpHsMaxDia_Internalname = "EMPHSMAXDIA" ;
      edtEmpHsMaxSem_Internalname = "EMPHSMAXSEM" ;
      edtEmpHsMaxMes_Internalname = "EMPHSMAXMES" ;
      edtEmpHsMaxAnu_Internalname = "EMPHSMAXANU" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      cmbavCombopaitipotraid.setInternalname( "vCOMBOPAITIPOTRAID" );
      divSectionattribute_paitipotraid_Internalname = "SECTIONATTRIBUTE_PAITIPOTRAID" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
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
      Form.setCaption( httpContext.getMessage( "empresa_tiposdetrabajo", "") );
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      cmbavCombopaitipotraid.setJsonclick( "" );
      cmbavCombopaitipotraid.setVisible( 1 );
      cmbavCombopaitipotraid.setEnabled( 0 );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtEmpHsMaxAnu_Jsonclick = "" ;
      edtEmpHsMaxAnu_Enabled = 1 ;
      edtEmpHsMaxMes_Jsonclick = "" ;
      edtEmpHsMaxMes_Enabled = 1 ;
      edtEmpHsMaxSem_Jsonclick = "" ;
      edtEmpHsMaxSem_Enabled = 1 ;
      edtEmpHsMaxDia_Jsonclick = "" ;
      edtEmpHsMaxDia_Enabled = 1 ;
      edtEmpHsSem_Jsonclick = "" ;
      edtEmpHsSem_Enabled = 1 ;
      edtEmpHsDia_Jsonclick = "" ;
      edtEmpHsDia_Enabled = 1 ;
      cmbPaiTipoTraId.setJsonclick( "" );
      cmbPaiTipoTraId.setVisible( 1 );
      cmbPaiTipoTraId.setEnabled( 1 );
      Combo_paitipotraid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_paitipotraid_Datalistprocparametersprefix = " \"ComboName\": \"PaiTipoTraId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0, \"PaiTipoTraId\": \"\"" ;
      Combo_paitipotraid_Datalistproc = "empresa_tiposdetrabajoLoadDVCombo" ;
      Combo_paitipotraid_Cls = "ExtendedCombo Attribute" ;
      Combo_paitipotraid_Caption = "" ;
      Combo_paitipotraid_Enabled = GXutil.toBoolean( -1) ;
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

   public void gx2asaclicod5N166( int AV7CliCod )
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
            GXt_int20 = A3CliCod ;
            GXv_int21[0] = GXt_int20 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int21) ;
            empresa_tiposdetrabajo_impl.this.GXt_int20 = GXv_int21[0] ;
            A3CliCod = GXt_int20 ;
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
      cmbPaiTipoTraId.setName( "PAITIPOTRAID" );
      cmbPaiTipoTraId.setWebtags( "" );
      cmbPaiTipoTraId.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbPaiTipoTraId.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbPaiTipoTraId.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      cmbavCombopaitipotraid.setName( "vCOMBOPAITIPOTRAID" );
      cmbavCombopaitipotraid.setWebtags( "" );
      cmbavCombopaitipotraid.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbavCombopaitipotraid.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbavCombopaitipotraid.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbavCombopaitipotraid.getItemCount() > 0 )
      {
         AV20ComboPaiTipoTraId = cmbavCombopaitipotraid.getValidValue(AV20ComboPaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiTipoTraId", AV20ComboPaiTipoTraId);
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

   public void valid_Paitipotraid( )
   {
      A1294PaiTipoTraId = cmbPaiTipoTraId.getValue() ;
      /* Using cursor T005N17 */
      pr_default.execute(15, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
      }
      pr_default.close(15);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( cmbPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Empcod( )
   {
      /* Using cursor T005N18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      if ( cmbPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = cmbPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true},{av:'A1346EmpTarifaXLim',fld:'EMPTARIFAXLIM',pic:'9.9999'},{av:'A1352EmpTarifaRec',fld:'EMPTARIFAREC',pic:'9.9999'},{av:'A2005EmpHsRelSec',fld:'EMPHSRELSEC',pic:'ZZZZZ9'},{av:'A2437EmpHsHorDes',fld:'EMPHSHORDES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e125N2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PAITIPOTRAID","{handler:'valid_Paitipotraid',iparms:[{av:'cmbPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("VALID_PAITIPOTRAID",",oparms:[]}");
      setEventMetadata("VALID_EMPHSDIA","{handler:'valid_Emphsdia',iparms:[]");
      setEventMetadata("VALID_EMPHSDIA",",oparms:[]}");
      setEventMetadata("VALID_EMPHSSEM","{handler:'valid_Emphssem',iparms:[]");
      setEventMetadata("VALID_EMPHSSEM",",oparms:[]}");
      setEventMetadata("VALID_EMPHSMAXDIA","{handler:'valid_Emphsmaxdia',iparms:[]");
      setEventMetadata("VALID_EMPHSMAXDIA",",oparms:[]}");
      setEventMetadata("VALID_EMPHSMAXSEM","{handler:'valid_Emphsmaxsem',iparms:[]");
      setEventMetadata("VALID_EMPHSMAXSEM",",oparms:[]}");
      setEventMetadata("VALID_EMPHSMAXMES","{handler:'valid_Emphsmaxmes',iparms:[]");
      setEventMetadata("VALID_EMPHSMAXMES",",oparms:[]}");
      setEventMetadata("VALID_EMPHSMAXANU","{handler:'valid_Emphsmaxanu',iparms:[]");
      setEventMetadata("VALID_EMPHSMAXANU",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPAITIPOTRAID","{handler:'validv_Combopaitipotraid',iparms:[]");
      setEventMetadata("VALIDV_COMBOPAITIPOTRAID",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
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
      pr_default.close(16);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9PaiTipoTraId = "" ;
      Z1294PaiTipoTraId = "" ;
      Z1344EmpHsDia = DecimalUtil.ZERO ;
      Z1345EmpHsSem = DecimalUtil.ZERO ;
      Z1346EmpTarifaXLim = DecimalUtil.ZERO ;
      Z1352EmpTarifaRec = DecimalUtil.ZERO ;
      Z1386EmpHsMaxDia = DecimalUtil.ZERO ;
      Z1387EmpHsMaxSem = DecimalUtil.ZERO ;
      Z1388EmpHsMaxMes = DecimalUtil.ZERO ;
      Z1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Z2437EmpHsHorDes = "" ;
      Combo_paitipotraid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1294PaiTipoTraId = "" ;
      Gx_mode = "" ;
      AV9PaiTipoTraId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      AV20ComboPaiTipoTraId = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockpaitipotraid_Jsonclick = "" ;
      ucCombo_paitipotraid = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15PaiTipoTraId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      A2437EmpHsHorDes = "" ;
      AV28EmpTarifaXLim = DecimalUtil.ZERO ;
      AV29EmpTarifaRec = DecimalUtil.ZERO ;
      AV25EmpHsDia = DecimalUtil.ZERO ;
      AV27EmpHsSem = DecimalUtil.ZERO ;
      AV30EmpHsMaxDia = DecimalUtil.ZERO ;
      AV31EmpHsMaxSem = DecimalUtil.ZERO ;
      AV32EmpHsMaxMes = DecimalUtil.ZERO ;
      AV26EmpHsMaxAnu = DecimalUtil.ZERO ;
      AV33Pgmname = "" ;
      Combo_paitipotraid_Objectcall = "" ;
      Combo_paitipotraid_Class = "" ;
      Combo_paitipotraid_Icontype = "" ;
      Combo_paitipotraid_Icon = "" ;
      Combo_paitipotraid_Tooltip = "" ;
      Combo_paitipotraid_Selectedvalue_set = "" ;
      Combo_paitipotraid_Selectedtext_set = "" ;
      Combo_paitipotraid_Selectedtext_get = "" ;
      Combo_paitipotraid_Gamoauthtoken = "" ;
      Combo_paitipotraid_Ddointernalname = "" ;
      Combo_paitipotraid_Titlecontrolalign = "" ;
      Combo_paitipotraid_Dropdownoptionstype = "" ;
      Combo_paitipotraid_Titlecontrolidtoreplace = "" ;
      Combo_paitipotraid_Datalisttype = "" ;
      Combo_paitipotraid_Datalistfixedvalues = "" ;
      Combo_paitipotraid_Remoteservicesparameters = "" ;
      Combo_paitipotraid_Htmltemplate = "" ;
      Combo_paitipotraid_Multiplevaluestype = "" ;
      Combo_paitipotraid_Loadingdata = "" ;
      Combo_paitipotraid_Noresultsfound = "" ;
      Combo_paitipotraid_Emptyitemtext = "" ;
      Combo_paitipotraid_Onlyselectedvalues = "" ;
      Combo_paitipotraid_Selectalltext = "" ;
      Combo_paitipotraid_Multiplevaluesseparator = "" ;
      Combo_paitipotraid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode166 = "" ;
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
      GXv_int7 = new short[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      AV19Combo_DataJson = "" ;
      GXt_char16 = "" ;
      AV17ComboSelectedValue = "" ;
      GXv_char17 = new String[1] ;
      AV18ComboSelectedText = "" ;
      GXv_char18 = new String[1] ;
      GXv_char19 = new String[1] ;
      T005N6_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N6_A2005EmpHsRelSec = new int[1] ;
      T005N6_A2437EmpHsHorDes = new String[] {""} ;
      T005N6_A3CliCod = new int[1] ;
      T005N6_A1EmpCod = new short[1] ;
      T005N6_A1294PaiTipoTraId = new String[] {""} ;
      T005N4_A3CliCod = new int[1] ;
      T005N5_A1292TipoTraId = new String[] {""} ;
      T005N7_A3CliCod = new int[1] ;
      T005N8_A1292TipoTraId = new String[] {""} ;
      T005N9_A3CliCod = new int[1] ;
      T005N9_A1EmpCod = new short[1] ;
      T005N9_A1294PaiTipoTraId = new String[] {""} ;
      T005N3_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N3_A2005EmpHsRelSec = new int[1] ;
      T005N3_A2437EmpHsHorDes = new String[] {""} ;
      T005N3_A3CliCod = new int[1] ;
      T005N3_A1EmpCod = new short[1] ;
      T005N3_A1294PaiTipoTraId = new String[] {""} ;
      T005N10_A3CliCod = new int[1] ;
      T005N10_A1EmpCod = new short[1] ;
      T005N10_A1294PaiTipoTraId = new String[] {""} ;
      T005N11_A3CliCod = new int[1] ;
      T005N11_A1EmpCod = new short[1] ;
      T005N11_A1294PaiTipoTraId = new String[] {""} ;
      T005N2_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005N2_A2005EmpHsRelSec = new int[1] ;
      T005N2_A2437EmpHsHorDes = new String[] {""} ;
      T005N2_A3CliCod = new int[1] ;
      T005N2_A1EmpCod = new short[1] ;
      T005N2_A1294PaiTipoTraId = new String[] {""} ;
      T005N15_A3CliCod = new int[1] ;
      T005N15_A1EmpCod = new short[1] ;
      T005N15_A1340EmpHsExSec = new short[1] ;
      T005N16_A3CliCod = new int[1] ;
      T005N16_A1EmpCod = new short[1] ;
      T005N16_A1294PaiTipoTraId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      A1292TipoTraId = "" ;
      GXv_int21 = new int[1] ;
      T005N17_A1292TipoTraId = new String[] {""} ;
      T005N18_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_tiposdetrabajo__default(),
         new Object[] {
             new Object[] {
            T005N2_A1344EmpHsDia, T005N2_A1345EmpHsSem, T005N2_A1346EmpTarifaXLim, T005N2_A1352EmpTarifaRec, T005N2_A1386EmpHsMaxDia, T005N2_A1387EmpHsMaxSem, T005N2_A1388EmpHsMaxMes, T005N2_A1389EmpHsMaxAnu, T005N2_A2005EmpHsRelSec, T005N2_A2437EmpHsHorDes,
            T005N2_A3CliCod, T005N2_A1EmpCod, T005N2_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N3_A1344EmpHsDia, T005N3_A1345EmpHsSem, T005N3_A1346EmpTarifaXLim, T005N3_A1352EmpTarifaRec, T005N3_A1386EmpHsMaxDia, T005N3_A1387EmpHsMaxSem, T005N3_A1388EmpHsMaxMes, T005N3_A1389EmpHsMaxAnu, T005N3_A2005EmpHsRelSec, T005N3_A2437EmpHsHorDes,
            T005N3_A3CliCod, T005N3_A1EmpCod, T005N3_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N4_A3CliCod
            }
            , new Object[] {
            T005N5_A1292TipoTraId
            }
            , new Object[] {
            T005N6_A1344EmpHsDia, T005N6_A1345EmpHsSem, T005N6_A1346EmpTarifaXLim, T005N6_A1352EmpTarifaRec, T005N6_A1386EmpHsMaxDia, T005N6_A1387EmpHsMaxSem, T005N6_A1388EmpHsMaxMes, T005N6_A1389EmpHsMaxAnu, T005N6_A2005EmpHsRelSec, T005N6_A2437EmpHsHorDes,
            T005N6_A3CliCod, T005N6_A1EmpCod, T005N6_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N7_A3CliCod
            }
            , new Object[] {
            T005N8_A1292TipoTraId
            }
            , new Object[] {
            T005N9_A3CliCod, T005N9_A1EmpCod, T005N9_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N10_A3CliCod, T005N10_A1EmpCod, T005N10_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N11_A3CliCod, T005N11_A1EmpCod, T005N11_A1294PaiTipoTraId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005N15_A3CliCod, T005N15_A1EmpCod, T005N15_A1340EmpHsExSec
            }
            , new Object[] {
            T005N16_A3CliCod, T005N16_A1EmpCod, T005N16_A1294PaiTipoTraId
            }
            , new Object[] {
            T005N17_A1292TipoTraId
            }
            , new Object[] {
            T005N18_A3CliCod
            }
         }
      );
      AV33Pgmname = "empresa_tiposdetrabajo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound166 ;
   private short AV24PaiCod ;
   private short GXt_int6 ;
   private short GXv_int7[] ;
   private short nIsDirty_166 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2005EmpHsRelSec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtEmpHsDia_Enabled ;
   private int edtEmpHsSem_Enabled ;
   private int edtEmpHsMaxDia_Enabled ;
   private int edtEmpHsMaxSem_Enabled ;
   private int edtEmpHsMaxMes_Enabled ;
   private int edtEmpHsMaxAnu_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int A2005EmpHsRelSec ;
   private int Combo_paitipotraid_Datalistupdateminimumcharacters ;
   private int Combo_paitipotraid_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int20 ;
   private int GXv_int21[] ;
   private java.math.BigDecimal Z1344EmpHsDia ;
   private java.math.BigDecimal Z1345EmpHsSem ;
   private java.math.BigDecimal Z1346EmpTarifaXLim ;
   private java.math.BigDecimal Z1352EmpTarifaRec ;
   private java.math.BigDecimal Z1386EmpHsMaxDia ;
   private java.math.BigDecimal Z1387EmpHsMaxSem ;
   private java.math.BigDecimal Z1388EmpHsMaxMes ;
   private java.math.BigDecimal Z1389EmpHsMaxAnu ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private java.math.BigDecimal A1345EmpHsSem ;
   private java.math.BigDecimal A1386EmpHsMaxDia ;
   private java.math.BigDecimal A1387EmpHsMaxSem ;
   private java.math.BigDecimal A1388EmpHsMaxMes ;
   private java.math.BigDecimal A1389EmpHsMaxAnu ;
   private java.math.BigDecimal A1346EmpTarifaXLim ;
   private java.math.BigDecimal A1352EmpTarifaRec ;
   private java.math.BigDecimal AV28EmpTarifaXLim ;
   private java.math.BigDecimal AV29EmpTarifaRec ;
   private java.math.BigDecimal AV25EmpHsDia ;
   private java.math.BigDecimal AV27EmpHsSem ;
   private java.math.BigDecimal AV30EmpHsMaxDia ;
   private java.math.BigDecimal AV31EmpHsMaxSem ;
   private java.math.BigDecimal AV32EmpHsMaxMes ;
   private java.math.BigDecimal AV26EmpHsMaxAnu ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9PaiTipoTraId ;
   private String Z1294PaiTipoTraId ;
   private String Z2437EmpHsHorDes ;
   private String Combo_paitipotraid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1294PaiTipoTraId ;
   private String Gx_mode ;
   private String AV9PaiTipoTraId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String AV20ComboPaiTipoTraId ;
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
   private String divTablesplittedpaitipotraid_Internalname ;
   private String lblTextblockpaitipotraid_Internalname ;
   private String lblTextblockpaitipotraid_Jsonclick ;
   private String Combo_paitipotraid_Caption ;
   private String Combo_paitipotraid_Cls ;
   private String Combo_paitipotraid_Datalistproc ;
   private String Combo_paitipotraid_Datalistprocparametersprefix ;
   private String Combo_paitipotraid_Internalname ;
   private String TempTags ;
   private String edtEmpHsDia_Internalname ;
   private String edtEmpHsDia_Jsonclick ;
   private String edtEmpHsSem_Internalname ;
   private String edtEmpHsSem_Jsonclick ;
   private String edtEmpHsMaxDia_Internalname ;
   private String edtEmpHsMaxDia_Jsonclick ;
   private String edtEmpHsMaxSem_Internalname ;
   private String edtEmpHsMaxSem_Jsonclick ;
   private String edtEmpHsMaxMes_Internalname ;
   private String edtEmpHsMaxMes_Jsonclick ;
   private String edtEmpHsMaxAnu_Internalname ;
   private String edtEmpHsMaxAnu_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_paitipotraid_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String A2437EmpHsHorDes ;
   private String AV33Pgmname ;
   private String Combo_paitipotraid_Objectcall ;
   private String Combo_paitipotraid_Class ;
   private String Combo_paitipotraid_Icontype ;
   private String Combo_paitipotraid_Icon ;
   private String Combo_paitipotraid_Tooltip ;
   private String Combo_paitipotraid_Selectedvalue_set ;
   private String Combo_paitipotraid_Selectedtext_set ;
   private String Combo_paitipotraid_Selectedtext_get ;
   private String Combo_paitipotraid_Gamoauthtoken ;
   private String Combo_paitipotraid_Ddointernalname ;
   private String Combo_paitipotraid_Titlecontrolalign ;
   private String Combo_paitipotraid_Dropdownoptionstype ;
   private String Combo_paitipotraid_Titlecontrolidtoreplace ;
   private String Combo_paitipotraid_Datalisttype ;
   private String Combo_paitipotraid_Datalistfixedvalues ;
   private String Combo_paitipotraid_Remoteservicesparameters ;
   private String Combo_paitipotraid_Htmltemplate ;
   private String Combo_paitipotraid_Multiplevaluestype ;
   private String Combo_paitipotraid_Loadingdata ;
   private String Combo_paitipotraid_Noresultsfound ;
   private String Combo_paitipotraid_Emptyitemtext ;
   private String Combo_paitipotraid_Onlyselectedvalues ;
   private String Combo_paitipotraid_Selectalltext ;
   private String Combo_paitipotraid_Multiplevaluesseparator ;
   private String Combo_paitipotraid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode166 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXv_char18[] ;
   private String GXv_char19[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String A1292TipoTraId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_paitipotraid_Emptyitem ;
   private boolean Combo_paitipotraid_Enabled ;
   private boolean Combo_paitipotraid_Visible ;
   private boolean Combo_paitipotraid_Allowmultipleselection ;
   private boolean Combo_paitipotraid_Isgriditem ;
   private boolean Combo_paitipotraid_Hasdescription ;
   private boolean Combo_paitipotraid_Includeonlyselectedoption ;
   private boolean Combo_paitipotraid_Includeselectalloption ;
   private boolean Combo_paitipotraid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV19Combo_DataJson ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paitipotraid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPaiTipoTraId ;
   private HTMLChoice cmbavCombopaitipotraid ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T005N6_A1344EmpHsDia ;
   private java.math.BigDecimal[] T005N6_A1345EmpHsSem ;
   private java.math.BigDecimal[] T005N6_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] T005N6_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] T005N6_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] T005N6_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] T005N6_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] T005N6_A1389EmpHsMaxAnu ;
   private int[] T005N6_A2005EmpHsRelSec ;
   private String[] T005N6_A2437EmpHsHorDes ;
   private int[] T005N6_A3CliCod ;
   private short[] T005N6_A1EmpCod ;
   private String[] T005N6_A1294PaiTipoTraId ;
   private int[] T005N4_A3CliCod ;
   private String[] T005N5_A1292TipoTraId ;
   private int[] T005N7_A3CliCod ;
   private String[] T005N8_A1292TipoTraId ;
   private int[] T005N9_A3CliCod ;
   private short[] T005N9_A1EmpCod ;
   private String[] T005N9_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] T005N3_A1344EmpHsDia ;
   private java.math.BigDecimal[] T005N3_A1345EmpHsSem ;
   private java.math.BigDecimal[] T005N3_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] T005N3_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] T005N3_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] T005N3_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] T005N3_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] T005N3_A1389EmpHsMaxAnu ;
   private int[] T005N3_A2005EmpHsRelSec ;
   private String[] T005N3_A2437EmpHsHorDes ;
   private int[] T005N3_A3CliCod ;
   private short[] T005N3_A1EmpCod ;
   private String[] T005N3_A1294PaiTipoTraId ;
   private int[] T005N10_A3CliCod ;
   private short[] T005N10_A1EmpCod ;
   private String[] T005N10_A1294PaiTipoTraId ;
   private int[] T005N11_A3CliCod ;
   private short[] T005N11_A1EmpCod ;
   private String[] T005N11_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] T005N2_A1344EmpHsDia ;
   private java.math.BigDecimal[] T005N2_A1345EmpHsSem ;
   private java.math.BigDecimal[] T005N2_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] T005N2_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] T005N2_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] T005N2_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] T005N2_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] T005N2_A1389EmpHsMaxAnu ;
   private int[] T005N2_A2005EmpHsRelSec ;
   private String[] T005N2_A2437EmpHsHorDes ;
   private int[] T005N2_A3CliCod ;
   private short[] T005N2_A1EmpCod ;
   private String[] T005N2_A1294PaiTipoTraId ;
   private int[] T005N15_A3CliCod ;
   private short[] T005N15_A1EmpCod ;
   private short[] T005N15_A1340EmpHsExSec ;
   private int[] T005N16_A3CliCod ;
   private short[] T005N16_A1EmpCod ;
   private String[] T005N16_A1294PaiTipoTraId ;
   private String[] T005N17_A1292TipoTraId ;
   private int[] T005N18_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15PaiTipoTraId_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class empresa_tiposdetrabajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005N2", "SELECT EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes, CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N3", "SELECT EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes, CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N4", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N5", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N6", "SELECT TM1.EmpHsDia, TM1.EmpHsSem, TM1.EmpTarifaXLim, TM1.EmpTarifaRec, TM1.EmpHsMaxDia, TM1.EmpHsMaxSem, TM1.EmpHsMaxMes, TM1.EmpHsMaxAnu, TM1.EmpHsRelSec, TM1.EmpHsHorDes, TM1.CliCod, TM1.EmpCod, TM1.PaiTipoTraId FROM Empresatipo_trabajo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.PaiTipoTraId = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N7", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N8", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N9", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N10", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and PaiTipoTraId > ( ?)) ORDER BY CliCod, EmpCod, PaiTipoTraId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005N11", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and PaiTipoTraId < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, PaiTipoTraId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005N12", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes, CliCod, EmpCod, PaiTipoTraId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005N13", "SAVEPOINT gxupdate;UPDATE Empresatipo_trabajo SET EmpHsDia=?, EmpHsSem=?, EmpTarifaXLim=?, EmpTarifaRec=?, EmpHsMaxDia=?, EmpHsMaxSem=?, EmpHsMaxMes=?, EmpHsMaxAnu=?, EmpHsRelSec=?, EmpHsHorDes=?  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005N14", "SAVEPOINT gxupdate;DELETE FROM Empresatipo_trabajo  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005N15", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005N16", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo ORDER BY CliCod, EmpCod, PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N17", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005N18", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 5);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 5);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 5);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 16 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 10 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 5);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setString(13, (String)parms[12], 20);
               return;
            case 11 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 5);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setString(13, (String)parms[12], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

