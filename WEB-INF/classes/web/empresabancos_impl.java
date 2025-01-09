package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabancos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPCOD") == 0 )
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
         gxdlaempcod5Y259( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
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
         gx3asaclicod5Y259( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
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
         gxload_13( A3CliCod, A1EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1966EmpBanCod = httpContext.GetPar( "EmpBanCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A3CliCod, A1966EmpBanCod) ;
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
            AV9EmpBanCod = httpContext.GetPar( "EmpBanCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9EmpBanCod", AV9EmpBanCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBANCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBanCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Empresa Bancos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEmpBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public empresabancos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabancos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabancos_impl.class ));
   }

   public empresabancos_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynEmpCod = new HTMLChoice();
      cmbEmpBanTipCuen = new HTMLChoice();
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
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      }
      if ( cmbEmpBanTipCuen.getItemCount() > 0 )
      {
         A1970EmpBanTipCuen = cmbEmpBanTipCuen.getValidValue(A1970EmpBanTipCuen) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBanTipCuen.setValue( GXutil.rtrim( A1970EmpBanTipCuen) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBanTipCuen.getInternalname(), "Values", cmbEmpBanTipCuen.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynEmpCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynEmpCod.getInternalname(), httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynEmpCod, dynEmpCod.getInternalname(), GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), 1, dynEmpCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynEmpCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EmpresaBancos.htm");
      dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedempbancod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockempbancod_Internalname, httpContext.getMessage( "Banco", ""), "", "", lblTextblockempbancod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_empbancod.setProperty("Caption", Combo_empbancod_Caption);
      ucCombo_empbancod.setProperty("Cls", Combo_empbancod_Cls);
      ucCombo_empbancod.setProperty("EmptyItem", Combo_empbancod_Emptyitem);
      ucCombo_empbancod.setProperty("DropDownOptionsData", AV15EmpBanCod_Data);
      ucCombo_empbancod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_empbancod_Internalname, "COMBO_EMPBANCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBanCod_Internalname, httpContext.getMessage( "Banco", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBanCod_Internalname, GXutil.rtrim( A1966EmpBanCod), GXutil.rtrim( localUtil.format( A1966EmpBanCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBanCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpBanCod_Visible, edtEmpBanCod_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpresaBancos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBanTipCuen.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBanTipCuen.getInternalname(), httpContext.getMessage( "Tipo de cuenta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBanTipCuen, cmbEmpBanTipCuen.getInternalname(), GXutil.rtrim( A1970EmpBanTipCuen), 1, cmbEmpBanTipCuen.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpBanTipCuen.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_EmpresaBancos.htm");
      cmbEmpBanTipCuen.setValue( GXutil.rtrim( A1970EmpBanTipCuen) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBanTipCuen.getInternalname(), "Values", cmbEmpBanTipCuen.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBanSuc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBanSuc_Internalname, httpContext.getMessage( "Sucursal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBanSuc_Internalname, A1969EmpBanSuc, GXutil.rtrim( localUtil.format( A1969EmpBanSuc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBanSuc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBanSuc_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBanCBU_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBanCBU_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBanCBU_Internalname, A1968EmpBanCBU, GXutil.rtrim( localUtil.format( A1968EmpBanCBU, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBanCBU_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBanCBU_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CBU", "left", true, "", "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCuentaBanc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCuentaBanc_Internalname, httpContext.getMessage( "Cta. Bancaria", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCuentaBanc_Internalname, A1971EmpCuentaBanc, GXutil.rtrim( localUtil.format( A1971EmpCuentaBanc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCuentaBanc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCuentaBanc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_EmpresaBancos.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpresaBancos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_empbancod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboempbancod_Internalname, GXutil.rtrim( AV20ComboEmpBanCod), GXutil.rtrim( localUtil.format( AV20ComboEmpBanCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboempbancod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboempbancod_Visible, edtavComboempbancod_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpresaBancos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpresaBancos.htm");
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
      e115Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPBANCOD_DATA"), AV15EmpBanCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1966EmpBanCod = httpContext.cgiGet( "Z1966EmpBanCod") ;
            Z1968EmpBanCBU = httpContext.cgiGet( "Z1968EmpBanCBU") ;
            Z1969EmpBanSuc = httpContext.cgiGet( "Z1969EmpBanSuc") ;
            Z1970EmpBanTipCuen = httpContext.cgiGet( "Z1970EmpBanTipCuen") ;
            Z1971EmpCuentaBanc = httpContext.cgiGet( "Z1971EmpCuentaBanc") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9EmpBanCod = httpContext.cgiGet( "vEMPBANCOD") ;
            A1967EmpBanDescrip = httpContext.cgiGet( "EMPBANDESCRIP") ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_empbancod_Objectcall = httpContext.cgiGet( "COMBO_EMPBANCOD_Objectcall") ;
            Combo_empbancod_Class = httpContext.cgiGet( "COMBO_EMPBANCOD_Class") ;
            Combo_empbancod_Icontype = httpContext.cgiGet( "COMBO_EMPBANCOD_Icontype") ;
            Combo_empbancod_Icon = httpContext.cgiGet( "COMBO_EMPBANCOD_Icon") ;
            Combo_empbancod_Caption = httpContext.cgiGet( "COMBO_EMPBANCOD_Caption") ;
            Combo_empbancod_Tooltip = httpContext.cgiGet( "COMBO_EMPBANCOD_Tooltip") ;
            Combo_empbancod_Cls = httpContext.cgiGet( "COMBO_EMPBANCOD_Cls") ;
            Combo_empbancod_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMPBANCOD_Selectedvalue_set") ;
            Combo_empbancod_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMPBANCOD_Selectedvalue_get") ;
            Combo_empbancod_Selectedtext_set = httpContext.cgiGet( "COMBO_EMPBANCOD_Selectedtext_set") ;
            Combo_empbancod_Selectedtext_get = httpContext.cgiGet( "COMBO_EMPBANCOD_Selectedtext_get") ;
            Combo_empbancod_Gamoauthtoken = httpContext.cgiGet( "COMBO_EMPBANCOD_Gamoauthtoken") ;
            Combo_empbancod_Ddointernalname = httpContext.cgiGet( "COMBO_EMPBANCOD_Ddointernalname") ;
            Combo_empbancod_Titlecontrolalign = httpContext.cgiGet( "COMBO_EMPBANCOD_Titlecontrolalign") ;
            Combo_empbancod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_EMPBANCOD_Dropdownoptionstype") ;
            Combo_empbancod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Enabled")) ;
            Combo_empbancod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Visible")) ;
            Combo_empbancod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_EMPBANCOD_Titlecontrolidtoreplace") ;
            Combo_empbancod_Datalisttype = httpContext.cgiGet( "COMBO_EMPBANCOD_Datalisttype") ;
            Combo_empbancod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Allowmultipleselection")) ;
            Combo_empbancod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_EMPBANCOD_Datalistfixedvalues") ;
            Combo_empbancod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Isgriditem")) ;
            Combo_empbancod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Hasdescription")) ;
            Combo_empbancod_Datalistproc = httpContext.cgiGet( "COMBO_EMPBANCOD_Datalistproc") ;
            Combo_empbancod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_EMPBANCOD_Datalistprocparametersprefix") ;
            Combo_empbancod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_EMPBANCOD_Remoteservicesparameters") ;
            Combo_empbancod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMPBANCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_empbancod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Includeonlyselectedoption")) ;
            Combo_empbancod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Includeselectalloption")) ;
            Combo_empbancod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Emptyitem")) ;
            Combo_empbancod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPBANCOD_Includeaddnewoption")) ;
            Combo_empbancod_Htmltemplate = httpContext.cgiGet( "COMBO_EMPBANCOD_Htmltemplate") ;
            Combo_empbancod_Multiplevaluestype = httpContext.cgiGet( "COMBO_EMPBANCOD_Multiplevaluestype") ;
            Combo_empbancod_Loadingdata = httpContext.cgiGet( "COMBO_EMPBANCOD_Loadingdata") ;
            Combo_empbancod_Noresultsfound = httpContext.cgiGet( "COMBO_EMPBANCOD_Noresultsfound") ;
            Combo_empbancod_Emptyitemtext = httpContext.cgiGet( "COMBO_EMPBANCOD_Emptyitemtext") ;
            Combo_empbancod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_EMPBANCOD_Onlyselectedvalues") ;
            Combo_empbancod_Selectalltext = httpContext.cgiGet( "COMBO_EMPBANCOD_Selectalltext") ;
            Combo_empbancod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_EMPBANCOD_Multiplevaluesseparator") ;
            Combo_empbancod_Addnewoptiontext = httpContext.cgiGet( "COMBO_EMPBANCOD_Addnewoptiontext") ;
            Combo_empbancod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMPBANCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            dynEmpCod.setValue( httpContext.cgiGet( dynEmpCod.getInternalname()) );
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1966EmpBanCod = httpContext.cgiGet( edtEmpBanCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
            cmbEmpBanTipCuen.setValue( httpContext.cgiGet( cmbEmpBanTipCuen.getInternalname()) );
            A1970EmpBanTipCuen = httpContext.cgiGet( cmbEmpBanTipCuen.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
            A1969EmpBanSuc = GXutil.upper( httpContext.cgiGet( edtEmpBanSuc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1969EmpBanSuc", A1969EmpBanSuc);
            A1968EmpBanCBU = httpContext.cgiGet( edtEmpBanCBU_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1968EmpBanCBU", A1968EmpBanCBU);
            A1971EmpCuentaBanc = GXutil.upper( httpContext.cgiGet( edtEmpCuentaBanc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1971EmpCuentaBanc", A1971EmpCuentaBanc);
            AV20ComboEmpBanCod = httpContext.cgiGet( edtavComboempbancod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmpBanCod", AV20ComboEmpBanCod);
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
            forbiddenHiddens.add("hshsalt", "hsh"+"EmpresaBancos");
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1966EmpBanCod, Z1966EmpBanCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("empresabancos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1966EmpBanCod = httpContext.GetPar( "EmpBanCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
               getEqualNoModal( ) ;
               gxaempcod_html5Y259( AV7CliCod) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode259 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxaempcod_html5Y259( AV7CliCod) ;
                  Gx_mode = sMode259 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound259 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5Y0( ) ;
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
                        e115Y2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125Y2 ();
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
         e125Y2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5Y259( ) ;
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
         disableAttributes5Y259( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempbancod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempbancod_Enabled), 5, 0), true);
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

   public void confirm_5Y0( )
   {
      beforeValidate5Y259( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5Y259( ) ;
         }
         else
         {
            checkExtendedTable5Y259( ) ;
            closeExtendedTableCursors5Y259( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5Y0( )
   {
   }

   public void e115Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      edtEmpBanCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCod_Visible), 5, 0), true);
      AV20ComboEmpBanCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmpBanCod", AV20ComboEmpBanCod);
      edtavComboempbancod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempbancod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempbancod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOEMPBANCOD' */
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
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos_Insert", GXv_boolean3) ;
         empresabancos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos_Update", GXv_boolean3) ;
         empresabancos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos_Delete", GXv_boolean3) ;
         empresabancos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e125Y2( )
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
      /* 'LOADCOMBOEMPBANCOD' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = AV15EmpBanCod_Data ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item6[0] = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      new web.empresabancosloaddvcombo(remoteHandle, context).execute( "EmpBanCod", Gx_mode, AV7CliCod, AV8EmpCod, AV9EmpBanCod, GXv_char5, GXv_objcol_SdtDVB_SDTComboData_Item6) ;
      empresabancos_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = GXv_objcol_SdtDVB_SDTComboData_Item6[0] ;
      AV15EmpBanCod_Data = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      Combo_empbancod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_empbancod.sendProperty(context, "", false, Combo_empbancod_Internalname, "SelectedValue_set", Combo_empbancod_Selectedvalue_set);
      AV20ComboEmpBanCod = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmpBanCod", AV20ComboEmpBanCod);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9EmpBanCod)==0) )
      {
         Combo_empbancod_Enabled = false ;
         ucCombo_empbancod.sendProperty(context, "", false, Combo_empbancod_Internalname, "Enabled", GXutil.booltostr( Combo_empbancod_Enabled));
      }
   }

   public void zm5Y259( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1968EmpBanCBU = T005Y3_A1968EmpBanCBU[0] ;
            Z1969EmpBanSuc = T005Y3_A1969EmpBanSuc[0] ;
            Z1970EmpBanTipCuen = T005Y3_A1970EmpBanTipCuen[0] ;
            Z1971EmpCuentaBanc = T005Y3_A1971EmpCuentaBanc[0] ;
         }
         else
         {
            Z1968EmpBanCBU = A1968EmpBanCBU ;
            Z1969EmpBanSuc = A1969EmpBanSuc ;
            Z1970EmpBanTipCuen = A1970EmpBanTipCuen ;
            Z1971EmpCuentaBanc = A1971EmpCuentaBanc ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z1968EmpBanCBU = A1968EmpBanCBU ;
         Z1969EmpBanSuc = A1969EmpBanSuc ;
         Z1970EmpBanTipCuen = A1970EmpBanTipCuen ;
         Z1971EmpCuentaBanc = A1971EmpCuentaBanc ;
         Z3CliCod = A3CliCod ;
         Z1966EmpBanCod = A1966EmpBanCod ;
         Z1EmpCod = A1EmpCod ;
         Z1967EmpBanDescrip = A1967EmpBanDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaempcod_html5Y259( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            empresabancos_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
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
      if ( ! (GXutil.strcmp("", AV9EmpBanCod)==0) )
      {
         edtEmpBanCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpBanCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9EmpBanCod)==0) )
      {
         edtEmpBanCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9EmpBanCod)==0) )
      {
         A1966EmpBanCod = AV9EmpBanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
      }
      else
      {
         A1966EmpBanCod = AV20ComboEmpBanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
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
         AV22Pgmname = "EmpresaBancos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T005Y4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod});
         A1967EmpBanDescrip = T005Y4_A1967EmpBanDescrip[0] ;
         pr_default.close(2);
      }
   }

   public void load5Y259( )
   {
      /* Using cursor T005Y6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod, Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound259 = (short)(1) ;
         A1967EmpBanDescrip = T005Y6_A1967EmpBanDescrip[0] ;
         A1968EmpBanCBU = T005Y6_A1968EmpBanCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1968EmpBanCBU", A1968EmpBanCBU);
         A1969EmpBanSuc = T005Y6_A1969EmpBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1969EmpBanSuc", A1969EmpBanSuc);
         A1970EmpBanTipCuen = T005Y6_A1970EmpBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
         A1971EmpCuentaBanc = T005Y6_A1971EmpCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1971EmpCuentaBanc", A1971EmpCuentaBanc);
         zm5Y259( -11) ;
      }
      pr_default.close(4);
      onLoadActions5Y259( ) ;
   }

   public void onLoadActions5Y259( )
   {
      AV22Pgmname = "EmpresaBancos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable5Y259( )
   {
      nIsDirty_259 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "EmpresaBancos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T005Y5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T005Y4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPBANCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1967EmpBanDescrip = T005Y4_A1967EmpBanDescrip[0] ;
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1970EmpBanTipCuen, "CA") == 0 ) || ( GXutil.strcmp(A1970EmpBanTipCuen, "CC") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de cuenta", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPBANTIPCUEN");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEmpBanTipCuen.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5Y259( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_13( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T005Y7 */
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

   public void gxload_12( int A3CliCod ,
                          String A1966EmpBanCod )
   {
      /* Using cursor T005Y8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPBANCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1967EmpBanDescrip = T005Y8_A1967EmpBanDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1967EmpBanDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey5Y259( )
   {
      /* Using cursor T005Y9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound259 = (short)(1) ;
      }
      else
      {
         RcdFound259 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005Y3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5Y259( 11) ;
         RcdFound259 = (short)(1) ;
         A1968EmpBanCBU = T005Y3_A1968EmpBanCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1968EmpBanCBU", A1968EmpBanCBU);
         A1969EmpBanSuc = T005Y3_A1969EmpBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1969EmpBanSuc", A1969EmpBanSuc);
         A1970EmpBanTipCuen = T005Y3_A1970EmpBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
         A1971EmpCuentaBanc = T005Y3_A1971EmpCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1971EmpCuentaBanc", A1971EmpCuentaBanc);
         A3CliCod = T005Y3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1966EmpBanCod = T005Y3_A1966EmpBanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
         A1EmpCod = T005Y3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1966EmpBanCod = A1966EmpBanCod ;
         sMode259 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5Y259( ) ;
         if ( AnyError == 1 )
         {
            RcdFound259 = (short)(0) ;
            initializeNonKey5Y259( ) ;
         }
         Gx_mode = sMode259 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound259 = (short)(0) ;
         initializeNonKey5Y259( ) ;
         sMode259 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode259 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5Y259( ) ;
      if ( RcdFound259 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound259 = (short)(0) ;
      /* Using cursor T005Y10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1966EmpBanCod, A1966EmpBanCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005Y10_A3CliCod[0] < A3CliCod ) || ( T005Y10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005Y10_A1966EmpBanCod[0], A1966EmpBanCod) < 0 ) || ( GXutil.strcmp(T005Y10_A1966EmpBanCod[0], A1966EmpBanCod) == 0 ) && ( T005Y10_A3CliCod[0] == A3CliCod ) && ( T005Y10_A1EmpCod[0] < A1EmpCod ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005Y10_A3CliCod[0] > A3CliCod ) || ( T005Y10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005Y10_A1966EmpBanCod[0], A1966EmpBanCod) > 0 ) || ( GXutil.strcmp(T005Y10_A1966EmpBanCod[0], A1966EmpBanCod) == 0 ) && ( T005Y10_A3CliCod[0] == A3CliCod ) && ( T005Y10_A1EmpCod[0] > A1EmpCod ) ) )
         {
            A3CliCod = T005Y10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1966EmpBanCod = T005Y10_A1966EmpBanCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
            A1EmpCod = T005Y10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            RcdFound259 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound259 = (short)(0) ;
      /* Using cursor T005Y11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1966EmpBanCod, A1966EmpBanCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005Y11_A3CliCod[0] > A3CliCod ) || ( T005Y11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005Y11_A1966EmpBanCod[0], A1966EmpBanCod) > 0 ) || ( GXutil.strcmp(T005Y11_A1966EmpBanCod[0], A1966EmpBanCod) == 0 ) && ( T005Y11_A3CliCod[0] == A3CliCod ) && ( T005Y11_A1EmpCod[0] > A1EmpCod ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005Y11_A3CliCod[0] < A3CliCod ) || ( T005Y11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005Y11_A1966EmpBanCod[0], A1966EmpBanCod) < 0 ) || ( GXutil.strcmp(T005Y11_A1966EmpBanCod[0], A1966EmpBanCod) == 0 ) && ( T005Y11_A3CliCod[0] == A3CliCod ) && ( T005Y11_A1EmpCod[0] < A1EmpCod ) ) )
         {
            A3CliCod = T005Y11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1966EmpBanCod = T005Y11_A1966EmpBanCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
            A1EmpCod = T005Y11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            RcdFound259 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5Y259( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEmpBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5Y259( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound259 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1966EmpBanCod, Z1966EmpBanCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1966EmpBanCod = Z1966EmpBanCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEmpBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5Y259( ) ;
               GX_FocusControl = edtEmpBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1966EmpBanCod, Z1966EmpBanCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtEmpBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5Y259( ) ;
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
                  GX_FocusControl = edtEmpBanCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5Y259( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1966EmpBanCod, Z1966EmpBanCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1966EmpBanCod = Z1966EmpBanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEmpBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5Y259( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005Y2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EmpresaBancos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1968EmpBanCBU, T005Y2_A1968EmpBanCBU[0]) != 0 ) || ( GXutil.strcmp(Z1969EmpBanSuc, T005Y2_A1969EmpBanSuc[0]) != 0 ) || ( GXutil.strcmp(Z1970EmpBanTipCuen, T005Y2_A1970EmpBanTipCuen[0]) != 0 ) || ( GXutil.strcmp(Z1971EmpCuentaBanc, T005Y2_A1971EmpCuentaBanc[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1968EmpBanCBU, T005Y2_A1968EmpBanCBU[0]) != 0 )
            {
               GXutil.writeLogln("empresabancos:[seudo value changed for attri]"+"EmpBanCBU");
               GXutil.writeLogRaw("Old: ",Z1968EmpBanCBU);
               GXutil.writeLogRaw("Current: ",T005Y2_A1968EmpBanCBU[0]);
            }
            if ( GXutil.strcmp(Z1969EmpBanSuc, T005Y2_A1969EmpBanSuc[0]) != 0 )
            {
               GXutil.writeLogln("empresabancos:[seudo value changed for attri]"+"EmpBanSuc");
               GXutil.writeLogRaw("Old: ",Z1969EmpBanSuc);
               GXutil.writeLogRaw("Current: ",T005Y2_A1969EmpBanSuc[0]);
            }
            if ( GXutil.strcmp(Z1970EmpBanTipCuen, T005Y2_A1970EmpBanTipCuen[0]) != 0 )
            {
               GXutil.writeLogln("empresabancos:[seudo value changed for attri]"+"EmpBanTipCuen");
               GXutil.writeLogRaw("Old: ",Z1970EmpBanTipCuen);
               GXutil.writeLogRaw("Current: ",T005Y2_A1970EmpBanTipCuen[0]);
            }
            if ( GXutil.strcmp(Z1971EmpCuentaBanc, T005Y2_A1971EmpCuentaBanc[0]) != 0 )
            {
               GXutil.writeLogln("empresabancos:[seudo value changed for attri]"+"EmpCuentaBanc");
               GXutil.writeLogRaw("Old: ",Z1971EmpCuentaBanc);
               GXutil.writeLogRaw("Current: ",T005Y2_A1971EmpCuentaBanc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"EmpresaBancos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5Y259( )
   {
      beforeValidate5Y259( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5Y259( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5Y259( 0) ;
         checkOptimisticConcurrency5Y259( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5Y259( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5Y259( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005Y12 */
                  pr_default.execute(10, new Object[] {A1968EmpBanCBU, A1969EmpBanSuc, A1970EmpBanTipCuen, A1971EmpCuentaBanc, Integer.valueOf(A3CliCod), A1966EmpBanCod, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EmpresaBancos");
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
                        resetCaption5Y0( ) ;
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
            load5Y259( ) ;
         }
         endLevel5Y259( ) ;
      }
      closeExtendedTableCursors5Y259( ) ;
   }

   public void update5Y259( )
   {
      beforeValidate5Y259( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5Y259( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5Y259( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5Y259( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5Y259( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005Y13 */
                  pr_default.execute(11, new Object[] {A1968EmpBanCBU, A1969EmpBanSuc, A1970EmpBanTipCuen, A1971EmpCuentaBanc, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EmpresaBancos");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EmpresaBancos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5Y259( ) ;
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
         endLevel5Y259( ) ;
      }
      closeExtendedTableCursors5Y259( ) ;
   }

   public void deferredUpdate5Y259( )
   {
   }

   public void delete( )
   {
      beforeValidate5Y259( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5Y259( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5Y259( ) ;
         afterConfirm5Y259( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5Y259( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005Y14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1966EmpBanCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("EmpresaBancos");
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
      sMode259 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5Y259( ) ;
      Gx_mode = sMode259 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5Y259( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "EmpresaBancos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T005Y15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod});
         A1967EmpBanDescrip = T005Y15_A1967EmpBanDescrip[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel5Y259( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5Y259( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresabancos");
         if ( AnyError == 0 )
         {
            confirmValues5Y0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "empresabancos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5Y259( )
   {
      /* Scan By routine */
      /* Using cursor T005Y16 */
      pr_default.execute(14);
      RcdFound259 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound259 = (short)(1) ;
         A3CliCod = T005Y16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005Y16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1966EmpBanCod = T005Y16_A1966EmpBanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5Y259( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound259 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound259 = (short)(1) ;
         A3CliCod = T005Y16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005Y16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1966EmpBanCod = T005Y16_A1966EmpBanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
      }
   }

   public void scanEnd5Y259( )
   {
      pr_default.close(14);
   }

   public void afterConfirm5Y259( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5Y259( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5Y259( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5Y259( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5Y259( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5Y259( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5Y259( )
   {
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      edtEmpBanCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCod_Enabled), 5, 0), true);
      cmbEmpBanTipCuen.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBanTipCuen.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBanTipCuen.getEnabled(), 5, 0), true);
      edtEmpBanSuc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBanSuc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanSuc_Enabled), 5, 0), true);
      edtEmpBanCBU_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBanCBU_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBanCBU_Enabled), 5, 0), true);
      edtEmpCuentaBanc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCuentaBanc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCuentaBanc_Enabled), 5, 0), true);
      edtavComboempbancod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempbancod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempbancod_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5Y259( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5Y0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresabancos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9EmpBanCod))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpBanCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"EmpresaBancos");
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("empresabancos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1966EmpBanCod", GXutil.rtrim( Z1966EmpBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1968EmpBanCBU", Z1968EmpBanCBU);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1969EmpBanSuc", Z1969EmpBanSuc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1970EmpBanTipCuen", GXutil.rtrim( Z1970EmpBanTipCuen));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1971EmpCuentaBanc", Z1971EmpCuentaBanc);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPBANCOD_DATA", AV15EmpBanCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPBANCOD_DATA", AV15EmpBanCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBANCOD", GXutil.rtrim( AV9EmpBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBANCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9EmpBanCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPBANDESCRIP", A1967EmpBanDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPBANCOD_Objectcall", GXutil.rtrim( Combo_empbancod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPBANCOD_Cls", GXutil.rtrim( Combo_empbancod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPBANCOD_Selectedvalue_set", GXutil.rtrim( Combo_empbancod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPBANCOD_Enabled", GXutil.booltostr( Combo_empbancod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPBANCOD_Emptyitem", GXutil.booltostr( Combo_empbancod_Emptyitem));
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
      return formatLink("web.empresabancos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9EmpBanCod))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpBanCod"})  ;
   }

   public String getPgmname( )
   {
      return "EmpresaBancos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresa Bancos", "") ;
   }

   public void initializeNonKey5Y259( )
   {
      A1967EmpBanDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1967EmpBanDescrip", A1967EmpBanDescrip);
      A1968EmpBanCBU = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1968EmpBanCBU", A1968EmpBanCBU);
      A1969EmpBanSuc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1969EmpBanSuc", A1969EmpBanSuc);
      A1970EmpBanTipCuen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
      A1971EmpCuentaBanc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1971EmpCuentaBanc", A1971EmpCuentaBanc);
      Z1968EmpBanCBU = "" ;
      Z1969EmpBanSuc = "" ;
      Z1970EmpBanTipCuen = "" ;
      Z1971EmpCuentaBanc = "" ;
   }

   public void initAll5Y259( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1966EmpBanCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1966EmpBanCod", A1966EmpBanCod);
      initializeNonKey5Y259( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202513934192", true, true);
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
      httpContext.AddJavascriptSource("empresabancos.js", "?202513934192", false, true);
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
      dynEmpCod.setInternalname( "EMPCOD" );
      lblTextblockempbancod_Internalname = "TEXTBLOCKEMPBANCOD" ;
      Combo_empbancod_Internalname = "COMBO_EMPBANCOD" ;
      edtEmpBanCod_Internalname = "EMPBANCOD" ;
      divTablesplittedempbancod_Internalname = "TABLESPLITTEDEMPBANCOD" ;
      cmbEmpBanTipCuen.setInternalname( "EMPBANTIPCUEN" );
      edtEmpBanSuc_Internalname = "EMPBANSUC" ;
      edtEmpBanCBU_Internalname = "EMPBANCBU" ;
      edtEmpCuentaBanc_Internalname = "EMPCUENTABANC" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboempbancod_Internalname = "vCOMBOEMPBANCOD" ;
      divSectionattribute_empbancod_Internalname = "SECTIONATTRIBUTE_EMPBANCOD" ;
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
      Form.setCaption( httpContext.getMessage( "Empresa Bancos", "") );
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboempbancod_Jsonclick = "" ;
      edtavComboempbancod_Enabled = 0 ;
      edtavComboempbancod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtEmpCuentaBanc_Jsonclick = "" ;
      edtEmpCuentaBanc_Enabled = 1 ;
      edtEmpBanCBU_Jsonclick = "" ;
      edtEmpBanCBU_Enabled = 1 ;
      edtEmpBanSuc_Jsonclick = "" ;
      edtEmpBanSuc_Enabled = 1 ;
      cmbEmpBanTipCuen.setJsonclick( "" );
      cmbEmpBanTipCuen.setEnabled( 1 );
      edtEmpBanCod_Jsonclick = "" ;
      edtEmpBanCod_Enabled = 1 ;
      edtEmpBanCod_Visible = 1 ;
      Combo_empbancod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_empbancod_Cls = "ExtendedCombo Attribute" ;
      Combo_empbancod_Enabled = GXutil.toBoolean( -1) ;
      dynEmpCod.setJsonclick( "" );
      dynEmpCod.setEnabled( 0 );
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

   public void gxdlaempcod5Y259( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaempcod_data5Y259( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaempcod_html5Y259( int AV7CliCod )
   {
      short gxdynajaxvalue;
      gxdlaempcod_data5Y259( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynEmpCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynEmpCod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaempcod_data5Y259( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005Y17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005Y17_A1EmpCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005Y17_A2EmpNom[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gx3asaclicod5Y259( int AV7CliCod )
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
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            empresabancos_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
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
      dynEmpCod.setName( "EMPCOD" );
      dynEmpCod.setWebtags( "" );
      cmbEmpBanTipCuen.setName( "EMPBANTIPCUEN" );
      cmbEmpBanTipCuen.setWebtags( "" );
      cmbEmpBanTipCuen.addItem("CA", httpContext.getMessage( "Caja de Ahorro", ""), (short)(0));
      cmbEmpBanTipCuen.addItem("CC", httpContext.getMessage( "Cuenta Corriente", ""), (short)(0));
      if ( cmbEmpBanTipCuen.getItemCount() > 0 )
      {
         A1970EmpBanTipCuen = cmbEmpBanTipCuen.getValidValue(A1970EmpBanTipCuen) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1970EmpBanTipCuen", A1970EmpBanTipCuen);
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

   public void valid_Clicod( )
   {
      A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValue())) ;
      /* Using cursor T005Y18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A1966EmpBanCod});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPBANCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A1967EmpBanDescrip = T005Y18_A1967EmpBanDescrip[0] ;
      pr_default.close(16);
      /* Using cursor T005Y19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(17);
      dynload_actions( ) ;
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1967EmpBanDescrip", A1967EmpBanDescrip);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpBanCod',fld:'vEMPBANCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpBanCod',fld:'vEMPBANCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e125Y2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_EMPBANCOD","{handler:'valid_Empbancod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPBANCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_EMPBANTIPCUEN","{handler:'valid_Empbantipcuen',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPBANTIPCUEN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOEMPBANCOD","{handler:'validv_Comboempbancod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_COMBOEMPBANCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1966EmpBanCod',fld:'EMPBANCOD',pic:''},{av:'A1967EmpBanDescrip',fld:'EMPBANDESCRIP',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1967EmpBanDescrip',fld:'EMPBANDESCRIP',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
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
      pr_default.close(13);
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9EmpBanCod = "" ;
      Z1966EmpBanCod = "" ;
      Z1968EmpBanCBU = "" ;
      Z1969EmpBanSuc = "" ;
      Z1970EmpBanTipCuen = "" ;
      Z1971EmpCuentaBanc = "" ;
      Combo_empbancod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1966EmpBanCod = "" ;
      Gx_mode = "" ;
      AV9EmpBanCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1970EmpBanTipCuen = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockempbancod_Jsonclick = "" ;
      ucCombo_empbancod = new com.genexus.webpanels.GXUserControl();
      Combo_empbancod_Caption = "" ;
      AV15EmpBanCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1969EmpBanSuc = "" ;
      A1968EmpBanCBU = "" ;
      A1971EmpCuentaBanc = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20ComboEmpBanCod = "" ;
      A1967EmpBanDescrip = "" ;
      AV22Pgmname = "" ;
      Combo_empbancod_Objectcall = "" ;
      Combo_empbancod_Class = "" ;
      Combo_empbancod_Icontype = "" ;
      Combo_empbancod_Icon = "" ;
      Combo_empbancod_Tooltip = "" ;
      Combo_empbancod_Selectedvalue_set = "" ;
      Combo_empbancod_Selectedtext_set = "" ;
      Combo_empbancod_Selectedtext_get = "" ;
      Combo_empbancod_Gamoauthtoken = "" ;
      Combo_empbancod_Ddointernalname = "" ;
      Combo_empbancod_Titlecontrolalign = "" ;
      Combo_empbancod_Dropdownoptionstype = "" ;
      Combo_empbancod_Titlecontrolidtoreplace = "" ;
      Combo_empbancod_Datalisttype = "" ;
      Combo_empbancod_Datalistfixedvalues = "" ;
      Combo_empbancod_Datalistproc = "" ;
      Combo_empbancod_Datalistprocparametersprefix = "" ;
      Combo_empbancod_Remoteservicesparameters = "" ;
      Combo_empbancod_Htmltemplate = "" ;
      Combo_empbancod_Multiplevaluestype = "" ;
      Combo_empbancod_Loadingdata = "" ;
      Combo_empbancod_Noresultsfound = "" ;
      Combo_empbancod_Emptyitemtext = "" ;
      Combo_empbancod_Onlyselectedvalues = "" ;
      Combo_empbancod_Selectalltext = "" ;
      Combo_empbancod_Multiplevaluesseparator = "" ;
      Combo_empbancod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode259 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      GXt_objcol_SdtDVB_SDTComboData_Item4 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV17ComboSelectedValue = "" ;
      GXv_char5 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection[1] ;
      Z1967EmpBanDescrip = "" ;
      T005Y4_A1967EmpBanDescrip = new String[] {""} ;
      T005Y6_A1967EmpBanDescrip = new String[] {""} ;
      T005Y6_A1968EmpBanCBU = new String[] {""} ;
      T005Y6_A1969EmpBanSuc = new String[] {""} ;
      T005Y6_A1970EmpBanTipCuen = new String[] {""} ;
      T005Y6_A1971EmpCuentaBanc = new String[] {""} ;
      T005Y6_A3CliCod = new int[1] ;
      T005Y6_A1966EmpBanCod = new String[] {""} ;
      T005Y6_A1EmpCod = new short[1] ;
      T005Y5_A3CliCod = new int[1] ;
      T005Y7_A3CliCod = new int[1] ;
      T005Y8_A1967EmpBanDescrip = new String[] {""} ;
      T005Y9_A3CliCod = new int[1] ;
      T005Y9_A1EmpCod = new short[1] ;
      T005Y9_A1966EmpBanCod = new String[] {""} ;
      T005Y3_A1968EmpBanCBU = new String[] {""} ;
      T005Y3_A1969EmpBanSuc = new String[] {""} ;
      T005Y3_A1970EmpBanTipCuen = new String[] {""} ;
      T005Y3_A1971EmpCuentaBanc = new String[] {""} ;
      T005Y3_A3CliCod = new int[1] ;
      T005Y3_A1966EmpBanCod = new String[] {""} ;
      T005Y3_A1EmpCod = new short[1] ;
      T005Y10_A3CliCod = new int[1] ;
      T005Y10_A1966EmpBanCod = new String[] {""} ;
      T005Y10_A1EmpCod = new short[1] ;
      T005Y11_A3CliCod = new int[1] ;
      T005Y11_A1966EmpBanCod = new String[] {""} ;
      T005Y11_A1EmpCod = new short[1] ;
      T005Y2_A1968EmpBanCBU = new String[] {""} ;
      T005Y2_A1969EmpBanSuc = new String[] {""} ;
      T005Y2_A1970EmpBanTipCuen = new String[] {""} ;
      T005Y2_A1971EmpCuentaBanc = new String[] {""} ;
      T005Y2_A3CliCod = new int[1] ;
      T005Y2_A1966EmpBanCod = new String[] {""} ;
      T005Y2_A1EmpCod = new short[1] ;
      T005Y15_A1967EmpBanDescrip = new String[] {""} ;
      T005Y16_A3CliCod = new int[1] ;
      T005Y16_A1EmpCod = new short[1] ;
      T005Y16_A1966EmpBanCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005Y17_A3CliCod = new int[1] ;
      T005Y17_A1EmpCod = new short[1] ;
      T005Y17_A2EmpNom = new String[] {""} ;
      GXv_int8 = new int[1] ;
      T005Y18_A1967EmpBanDescrip = new String[] {""} ;
      T005Y19_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabancos__default(),
         new Object[] {
             new Object[] {
            T005Y2_A1968EmpBanCBU, T005Y2_A1969EmpBanSuc, T005Y2_A1970EmpBanTipCuen, T005Y2_A1971EmpCuentaBanc, T005Y2_A3CliCod, T005Y2_A1966EmpBanCod, T005Y2_A1EmpCod
            }
            , new Object[] {
            T005Y3_A1968EmpBanCBU, T005Y3_A1969EmpBanSuc, T005Y3_A1970EmpBanTipCuen, T005Y3_A1971EmpCuentaBanc, T005Y3_A3CliCod, T005Y3_A1966EmpBanCod, T005Y3_A1EmpCod
            }
            , new Object[] {
            T005Y4_A1967EmpBanDescrip
            }
            , new Object[] {
            T005Y5_A3CliCod
            }
            , new Object[] {
            T005Y6_A1967EmpBanDescrip, T005Y6_A1968EmpBanCBU, T005Y6_A1969EmpBanSuc, T005Y6_A1970EmpBanTipCuen, T005Y6_A1971EmpCuentaBanc, T005Y6_A3CliCod, T005Y6_A1966EmpBanCod, T005Y6_A1EmpCod
            }
            , new Object[] {
            T005Y7_A3CliCod
            }
            , new Object[] {
            T005Y8_A1967EmpBanDescrip
            }
            , new Object[] {
            T005Y9_A3CliCod, T005Y9_A1EmpCod, T005Y9_A1966EmpBanCod
            }
            , new Object[] {
            T005Y10_A3CliCod, T005Y10_A1966EmpBanCod, T005Y10_A1EmpCod
            }
            , new Object[] {
            T005Y11_A3CliCod, T005Y11_A1966EmpBanCod, T005Y11_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005Y15_A1967EmpBanDescrip
            }
            , new Object[] {
            T005Y16_A3CliCod, T005Y16_A1EmpCod, T005Y16_A1966EmpBanCod
            }
            , new Object[] {
            T005Y17_A3CliCod, T005Y17_A1EmpCod, T005Y17_A2EmpNom
            }
            , new Object[] {
            T005Y18_A1967EmpBanDescrip
            }
            , new Object[] {
            T005Y19_A3CliCod
            }
         }
      );
      AV22Pgmname = "EmpresaBancos" ;
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
   private short RcdFound259 ;
   private short nIsDirty_259 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtEmpBanCod_Visible ;
   private int edtEmpBanCod_Enabled ;
   private int edtEmpBanSuc_Enabled ;
   private int edtEmpBanCBU_Enabled ;
   private int edtEmpCuentaBanc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboempbancod_Visible ;
   private int edtavComboempbancod_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Combo_empbancod_Datalistupdateminimumcharacters ;
   private int Combo_empbancod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9EmpBanCod ;
   private String Z1966EmpBanCod ;
   private String Z1970EmpBanTipCuen ;
   private String Combo_empbancod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1966EmpBanCod ;
   private String Gx_mode ;
   private String AV9EmpBanCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEmpBanCod_Internalname ;
   private String A1970EmpBanTipCuen ;
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
   private String divTablesplittedempbancod_Internalname ;
   private String lblTextblockempbancod_Internalname ;
   private String lblTextblockempbancod_Jsonclick ;
   private String Combo_empbancod_Caption ;
   private String Combo_empbancod_Cls ;
   private String Combo_empbancod_Internalname ;
   private String TempTags ;
   private String edtEmpBanCod_Jsonclick ;
   private String edtEmpBanSuc_Internalname ;
   private String edtEmpBanSuc_Jsonclick ;
   private String edtEmpBanCBU_Internalname ;
   private String edtEmpBanCBU_Jsonclick ;
   private String edtEmpCuentaBanc_Internalname ;
   private String edtEmpCuentaBanc_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_empbancod_Internalname ;
   private String edtavComboempbancod_Internalname ;
   private String AV20ComboEmpBanCod ;
   private String edtavComboempbancod_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_empbancod_Objectcall ;
   private String Combo_empbancod_Class ;
   private String Combo_empbancod_Icontype ;
   private String Combo_empbancod_Icon ;
   private String Combo_empbancod_Tooltip ;
   private String Combo_empbancod_Selectedvalue_set ;
   private String Combo_empbancod_Selectedtext_set ;
   private String Combo_empbancod_Selectedtext_get ;
   private String Combo_empbancod_Gamoauthtoken ;
   private String Combo_empbancod_Ddointernalname ;
   private String Combo_empbancod_Titlecontrolalign ;
   private String Combo_empbancod_Dropdownoptionstype ;
   private String Combo_empbancod_Titlecontrolidtoreplace ;
   private String Combo_empbancod_Datalisttype ;
   private String Combo_empbancod_Datalistfixedvalues ;
   private String Combo_empbancod_Datalistproc ;
   private String Combo_empbancod_Datalistprocparametersprefix ;
   private String Combo_empbancod_Remoteservicesparameters ;
   private String Combo_empbancod_Htmltemplate ;
   private String Combo_empbancod_Multiplevaluestype ;
   private String Combo_empbancod_Loadingdata ;
   private String Combo_empbancod_Noresultsfound ;
   private String Combo_empbancod_Emptyitemtext ;
   private String Combo_empbancod_Onlyselectedvalues ;
   private String Combo_empbancod_Selectalltext ;
   private String Combo_empbancod_Multiplevaluesseparator ;
   private String Combo_empbancod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode259 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char5[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_empbancod_Emptyitem ;
   private boolean Combo_empbancod_Enabled ;
   private boolean Combo_empbancod_Visible ;
   private boolean Combo_empbancod_Allowmultipleselection ;
   private boolean Combo_empbancod_Isgriditem ;
   private boolean Combo_empbancod_Hasdescription ;
   private boolean Combo_empbancod_Includeonlyselectedoption ;
   private boolean Combo_empbancod_Includeselectalloption ;
   private boolean Combo_empbancod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean gxdyncontrolsrefreshing ;
   private String Z1968EmpBanCBU ;
   private String Z1969EmpBanSuc ;
   private String Z1971EmpCuentaBanc ;
   private String A1969EmpBanSuc ;
   private String A1968EmpBanCBU ;
   private String A1971EmpCuentaBanc ;
   private String A1967EmpBanDescrip ;
   private String AV17ComboSelectedValue ;
   private String Z1967EmpBanDescrip ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_empbancod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynEmpCod ;
   private HTMLChoice cmbEmpBanTipCuen ;
   private IDataStoreProvider pr_default ;
   private String[] T005Y4_A1967EmpBanDescrip ;
   private String[] T005Y6_A1967EmpBanDescrip ;
   private String[] T005Y6_A1968EmpBanCBU ;
   private String[] T005Y6_A1969EmpBanSuc ;
   private String[] T005Y6_A1970EmpBanTipCuen ;
   private String[] T005Y6_A1971EmpCuentaBanc ;
   private int[] T005Y6_A3CliCod ;
   private String[] T005Y6_A1966EmpBanCod ;
   private short[] T005Y6_A1EmpCod ;
   private int[] T005Y5_A3CliCod ;
   private int[] T005Y7_A3CliCod ;
   private String[] T005Y8_A1967EmpBanDescrip ;
   private int[] T005Y9_A3CliCod ;
   private short[] T005Y9_A1EmpCod ;
   private String[] T005Y9_A1966EmpBanCod ;
   private String[] T005Y3_A1968EmpBanCBU ;
   private String[] T005Y3_A1969EmpBanSuc ;
   private String[] T005Y3_A1970EmpBanTipCuen ;
   private String[] T005Y3_A1971EmpCuentaBanc ;
   private int[] T005Y3_A3CliCod ;
   private String[] T005Y3_A1966EmpBanCod ;
   private short[] T005Y3_A1EmpCod ;
   private int[] T005Y10_A3CliCod ;
   private String[] T005Y10_A1966EmpBanCod ;
   private short[] T005Y10_A1EmpCod ;
   private int[] T005Y11_A3CliCod ;
   private String[] T005Y11_A1966EmpBanCod ;
   private short[] T005Y11_A1EmpCod ;
   private String[] T005Y2_A1968EmpBanCBU ;
   private String[] T005Y2_A1969EmpBanSuc ;
   private String[] T005Y2_A1970EmpBanTipCuen ;
   private String[] T005Y2_A1971EmpCuentaBanc ;
   private int[] T005Y2_A3CliCod ;
   private String[] T005Y2_A1966EmpBanCod ;
   private short[] T005Y2_A1EmpCod ;
   private String[] T005Y15_A1967EmpBanDescrip ;
   private int[] T005Y16_A3CliCod ;
   private short[] T005Y16_A1EmpCod ;
   private String[] T005Y16_A1966EmpBanCod ;
   private int[] T005Y17_A3CliCod ;
   private short[] T005Y17_A1EmpCod ;
   private String[] T005Y17_A2EmpNom ;
   private String[] T005Y18_A1967EmpBanDescrip ;
   private int[] T005Y19_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15EmpBanCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item4 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item6[] ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class empresabancos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005Y2", "SELECT EmpBanCBU, EmpBanSuc, EmpBanTipCuen, EmpCuentaBanc, CliCod, EmpBanCod, EmpCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ? AND EmpBanCod = ?  FOR UPDATE OF EmpresaBancos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y3", "SELECT EmpBanCBU, EmpBanSuc, EmpBanTipCuen, EmpCuentaBanc, CliCod, EmpBanCod, EmpCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ? AND EmpBanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y4", "SELECT BanDescrip AS EmpBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y5", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y6", "SELECT T2.BanDescrip AS EmpBanDescrip, TM1.EmpBanCBU, TM1.EmpBanSuc, TM1.EmpBanTipCuen, TM1.EmpCuentaBanc, TM1.CliCod, TM1.EmpBanCod AS EmpBanCod, TM1.EmpCod FROM (EmpresaBancos TM1 INNER JOIN Banco T2 ON T2.CliCod = TM1.CliCod AND T2.BanCod = TM1.EmpBanCod) WHERE TM1.CliCod = ? and TM1.EmpBanCod = ( ?) and TM1.EmpCod = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpBanCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y7", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y8", "SELECT BanDescrip AS EmpBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y9", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ? AND EmpBanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y10", "SELECT CliCod, EmpBanCod, EmpCod FROM EmpresaBancos WHERE ( CliCod > ? or CliCod = ? and EmpBanCod > ( ?) or EmpBanCod = ( ?) and CliCod = ? and EmpCod > ?) ORDER BY CliCod, EmpCod, EmpBanCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005Y11", "SELECT CliCod, EmpBanCod, EmpCod FROM EmpresaBancos WHERE ( CliCod < ? or CliCod = ? and EmpBanCod < ( ?) or EmpBanCod = ( ?) and CliCod = ? and EmpCod < ?) ORDER BY CliCod DESC, EmpCod DESC, EmpBanCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005Y12", "SAVEPOINT gxupdate;INSERT INTO EmpresaBancos(EmpBanCBU, EmpBanSuc, EmpBanTipCuen, EmpCuentaBanc, CliCod, EmpBanCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005Y13", "SAVEPOINT gxupdate;UPDATE EmpresaBancos SET EmpBanCBU=?, EmpBanSuc=?, EmpBanTipCuen=?, EmpCuentaBanc=?  WHERE CliCod = ? AND EmpCod = ? AND EmpBanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005Y14", "SAVEPOINT gxupdate;DELETE FROM EmpresaBancos  WHERE CliCod = ? AND EmpCod = ? AND EmpBanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005Y15", "SELECT BanDescrip AS EmpBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y16", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos ORDER BY CliCod, EmpCod, EmpBanCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y17", "SELECT CliCod, EmpCod, EmpNom FROM Empresa WHERE CliCod = ? ORDER BY EmpNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y18", "SELECT BanDescrip AS EmpBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005Y19", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 6);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
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
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 6);
               stmt.setString(4, (String)parms[3], 6);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 6);
               stmt.setString(4, (String)parms[3], 6);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 22, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 20, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 6);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 22, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 20, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 6);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

