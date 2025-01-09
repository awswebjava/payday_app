package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cliente_update_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A1881CliUpdCliCod = (int)(GXutil.lval( httpContext.GetPar( "CliUpdCliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
         A1887CliUpdRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliUpdRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A1881CliUpdCliCod, A1887CliUpdRelSec) ;
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
            AV24CliUpdCliCod = (int)(GXutil.lval( httpContext.GetPar( "CliUpdCliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24CliUpdCliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIUPDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24CliUpdCliCod), "ZZZZZ9")));
            AV25CliUpdRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliUpdRelSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25CliUpdRelSec), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIUPDRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25CliUpdRelSec), "ZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Actualizaciones", ""), (short)(0)) ;
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

   public cliente_update_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cliente_update_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_update_impl.class ));
   }

   public cliente_update_impl( int remoteHandle ,
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Origen", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV16CliCod_Data);
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcliupdclicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliupdclicod_Internalname, httpContext.getMessage( "de release", ""), "", "", lblTextblockcliupdclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliupdclicod.setProperty("Caption", Combo_cliupdclicod_Caption);
      ucCombo_cliupdclicod.setProperty("Cls", Combo_cliupdclicod_Cls);
      ucCombo_cliupdclicod.setProperty("DataListProc", Combo_cliupdclicod_Datalistproc);
      ucCombo_cliupdclicod.setProperty("DataListProcParametersPrefix", Combo_cliupdclicod_Datalistprocparametersprefix);
      ucCombo_cliupdclicod.setProperty("EmptyItem", Combo_cliupdclicod_Emptyitem);
      ucCombo_cliupdclicod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_cliupdclicod.setProperty("DropDownOptionsData", AV22CliUpdCliCod_Data);
      ucCombo_cliupdclicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cliupdclicod_Internalname, "COMBO_CLIUPDCLICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliUpdCliCod_Internalname, httpContext.getMessage( "Cliente liberador de release", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliUpdCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1881CliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1881CliUpdCliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliUpdCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliUpdCliCod_Visible, edtCliUpdCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcliupdrelsec_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliupdrelsec_Internalname, httpContext.getMessage( "Rel Sec", ""), "", "", lblTextblockcliupdrelsec_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliupdrelsec.setProperty("Caption", Combo_cliupdrelsec_Caption);
      ucCombo_cliupdrelsec.setProperty("Cls", Combo_cliupdrelsec_Cls);
      ucCombo_cliupdrelsec.setProperty("DataListProc", Combo_cliupdrelsec_Datalistproc);
      ucCombo_cliupdrelsec.setProperty("EmptyItem", Combo_cliupdrelsec_Emptyitem);
      ucCombo_cliupdrelsec.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_cliupdrelsec.setProperty("DropDownOptionsData", AV26CliUpdRelSec_Data);
      ucCombo_cliupdrelsec.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cliupdrelsec_Internalname, "COMBO_CLIUPDRELSECContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliUpdRelSec_Internalname, httpContext.getMessage( "Cli Upd Rel Sec", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliUpdRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1887CliUpdRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1887CliUpdRelSec), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliUpdRelSec_Jsonclick, 0, "Attribute", "", "", "", "", edtCliUpdRelSec_Visible, edtCliUpdRelSec_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliUpdDTApl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliUpdDTApl_Internalname, httpContext.getMessage( "Fecha de aplicación de la actualización", ""), "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliUpdDTApl_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliUpdDTApl_Internalname, localUtil.ttoc( A1883CliUpdDTApl, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A1883CliUpdDTApl, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliUpdDTApl_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtCliUpdDTApl_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliUpdDTApl_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCliUpdDTApl_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cliente_Update.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Update.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_cliupdclicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliupdclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboCliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombocliupdclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboCliUpdCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboCliUpdCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliupdclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliupdclicod_Visible, edtavCombocliupdclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_cliupdrelsec_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliupdrelsec_Internalname, GXutil.ltrim( localUtil.ntoc( AV27ComboCliUpdRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombocliupdrelsec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV27ComboCliUpdRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV27ComboCliUpdRelSec), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliupdrelsec_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliupdrelsec_Visible, edtavCombocliupdrelsec_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Update.htm");
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
      e115S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV16CliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLIUPDCLICOD_DATA"), AV22CliUpdCliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLIUPDRELSEC_DATA"), AV26CliUpdRelSec_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1881CliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z1881CliUpdCliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1887CliUpdRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1887CliUpdRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1883CliUpdDTApl = localUtil.ctot( httpContext.cgiGet( "Z1883CliUpdDTApl"), 0) ;
            Z1884CliUpdRelDesc = httpContext.cgiGet( "Z1884CliUpdRelDesc") ;
            Z1963CliUpdNotificado = GXutil.strtobool( httpContext.cgiGet( "Z1963CliUpdNotificado")) ;
            A1884CliUpdRelDesc = httpContext.cgiGet( "Z1884CliUpdRelDesc") ;
            A1963CliUpdNotificado = GXutil.strtobool( httpContext.cgiGet( "Z1963CliUpdNotificado")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV29Cond_CliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_CLIUPDCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV24CliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLIUPDCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV25CliUpdRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "vCLIUPDRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1884CliUpdRelDesc = httpContext.cgiGet( "CLIUPDRELDESC") ;
            A1963CliUpdNotificado = GXutil.strtobool( httpContext.cgiGet( "CLIUPDNOTIFICADO")) ;
            A1962CliUpdFecRel = localUtil.ctot( httpContext.cgiGet( "CLIUPDFECREL"), 0) ;
            A1964CliUpdRelHab = GXutil.strtobool( httpContext.cgiGet( "CLIUPDRELHAB")) ;
            AV30Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_cliupdclicod_Objectcall = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Objectcall") ;
            Combo_cliupdclicod_Class = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Class") ;
            Combo_cliupdclicod_Icontype = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Icontype") ;
            Combo_cliupdclicod_Icon = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Icon") ;
            Combo_cliupdclicod_Caption = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Caption") ;
            Combo_cliupdclicod_Tooltip = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Tooltip") ;
            Combo_cliupdclicod_Cls = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Cls") ;
            Combo_cliupdclicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Selectedvalue_set") ;
            Combo_cliupdclicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Selectedvalue_get") ;
            Combo_cliupdclicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Selectedtext_set") ;
            Combo_cliupdclicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Selectedtext_get") ;
            Combo_cliupdclicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Gamoauthtoken") ;
            Combo_cliupdclicod_Ddointernalname = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Ddointernalname") ;
            Combo_cliupdclicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Titlecontrolalign") ;
            Combo_cliupdclicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Dropdownoptionstype") ;
            Combo_cliupdclicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Enabled")) ;
            Combo_cliupdclicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Visible")) ;
            Combo_cliupdclicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Titlecontrolidtoreplace") ;
            Combo_cliupdclicod_Datalisttype = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Datalisttype") ;
            Combo_cliupdclicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Allowmultipleselection")) ;
            Combo_cliupdclicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Datalistfixedvalues") ;
            Combo_cliupdclicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Isgriditem")) ;
            Combo_cliupdclicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Hasdescription")) ;
            Combo_cliupdclicod_Datalistproc = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Datalistproc") ;
            Combo_cliupdclicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Datalistprocparametersprefix") ;
            Combo_cliupdclicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Remoteservicesparameters") ;
            Combo_cliupdclicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliupdclicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Includeonlyselectedoption")) ;
            Combo_cliupdclicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Includeselectalloption")) ;
            Combo_cliupdclicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Emptyitem")) ;
            Combo_cliupdclicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Includeaddnewoption")) ;
            Combo_cliupdclicod_Htmltemplate = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Htmltemplate") ;
            Combo_cliupdclicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Multiplevaluestype") ;
            Combo_cliupdclicod_Loadingdata = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Loadingdata") ;
            Combo_cliupdclicod_Noresultsfound = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Noresultsfound") ;
            Combo_cliupdclicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Emptyitemtext") ;
            Combo_cliupdclicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Onlyselectedvalues") ;
            Combo_cliupdclicod_Selectalltext = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Selectalltext") ;
            Combo_cliupdclicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Multiplevaluesseparator") ;
            Combo_cliupdclicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLIUPDCLICOD_Addnewoptiontext") ;
            Combo_cliupdrelsec_Objectcall = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Objectcall") ;
            Combo_cliupdrelsec_Class = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Class") ;
            Combo_cliupdrelsec_Icontype = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Icontype") ;
            Combo_cliupdrelsec_Icon = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Icon") ;
            Combo_cliupdrelsec_Caption = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Caption") ;
            Combo_cliupdrelsec_Tooltip = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Tooltip") ;
            Combo_cliupdrelsec_Cls = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Cls") ;
            Combo_cliupdrelsec_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Selectedvalue_set") ;
            Combo_cliupdrelsec_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Selectedvalue_get") ;
            Combo_cliupdrelsec_Selectedtext_set = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Selectedtext_set") ;
            Combo_cliupdrelsec_Selectedtext_get = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Selectedtext_get") ;
            Combo_cliupdrelsec_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Gamoauthtoken") ;
            Combo_cliupdrelsec_Ddointernalname = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Ddointernalname") ;
            Combo_cliupdrelsec_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Titlecontrolalign") ;
            Combo_cliupdrelsec_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Dropdownoptionstype") ;
            Combo_cliupdrelsec_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Enabled")) ;
            Combo_cliupdrelsec_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Visible")) ;
            Combo_cliupdrelsec_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Titlecontrolidtoreplace") ;
            Combo_cliupdrelsec_Datalisttype = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Datalisttype") ;
            Combo_cliupdrelsec_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Allowmultipleselection")) ;
            Combo_cliupdrelsec_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Datalistfixedvalues") ;
            Combo_cliupdrelsec_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Isgriditem")) ;
            Combo_cliupdrelsec_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Hasdescription")) ;
            Combo_cliupdrelsec_Datalistproc = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Datalistproc") ;
            Combo_cliupdrelsec_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Datalistprocparametersprefix") ;
            Combo_cliupdrelsec_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Remoteservicesparameters") ;
            Combo_cliupdrelsec_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliupdrelsec_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Includeonlyselectedoption")) ;
            Combo_cliupdrelsec_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Includeselectalloption")) ;
            Combo_cliupdrelsec_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Emptyitem")) ;
            Combo_cliupdrelsec_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Includeaddnewoption")) ;
            Combo_cliupdrelsec_Htmltemplate = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Htmltemplate") ;
            Combo_cliupdrelsec_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Multiplevaluestype") ;
            Combo_cliupdrelsec_Loadingdata = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Loadingdata") ;
            Combo_cliupdrelsec_Noresultsfound = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Noresultsfound") ;
            Combo_cliupdrelsec_Emptyitemtext = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Emptyitemtext") ;
            Combo_cliupdrelsec_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Onlyselectedvalues") ;
            Combo_cliupdrelsec_Selectalltext = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Selectalltext") ;
            Combo_cliupdrelsec_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Multiplevaluesseparator") ;
            Combo_cliupdrelsec_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLIUPDRELSEC_Addnewoptiontext") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliUpdCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliUpdCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIUPDCLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliUpdCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1881CliUpdCliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
            }
            else
            {
               A1881CliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliUpdCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliUpdRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliUpdRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIUPDRELSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliUpdRelSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1887CliUpdRelSec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
            }
            else
            {
               A1887CliUpdRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtCliUpdRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
            }
            if ( localUtil.vcdtime( httpContext.cgiGet( edtCliUpdDTApl_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "CLIUPDDTAPL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliUpdDTApl_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
               httpContext.ajax_rsp_assign_attri("", false, "A1883CliUpdDTApl", localUtil.ttoc( A1883CliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            else
            {
               A1883CliUpdDTApl = localUtil.ctot( httpContext.cgiGet( edtCliUpdDTApl_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1883CliUpdDTApl", localUtil.ttoc( A1883CliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            AV21ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCliCod), 6, 0));
            AV23ComboCliUpdCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocliupdclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliUpdCliCod), 6, 0));
            AV27ComboCliUpdRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocliupdrelsec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ComboCliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ComboCliUpdRelSec), 6, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Cliente_Update");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CliUpdRelDesc", GXutil.rtrim( localUtil.format( A1884CliUpdRelDesc, "")));
            forbiddenHiddens.add("CliUpdNotificado", GXutil.booltostr( A1963CliUpdNotificado));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1881CliUpdCliCod != Z1881CliUpdCliCod ) || ( A1887CliUpdRelSec != Z1887CliUpdRelSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("cliente_update:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1881CliUpdCliCod = (int)(GXutil.lval( httpContext.GetPar( "CliUpdCliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
               A1887CliUpdRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliUpdRelSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
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
                  sMode252 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode252 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound252 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5S0( ) ;
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
                        e115S2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125S2 ();
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
         e125S2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5S252( ) ;
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
         disableAttributes5S252( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdclicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdrelsec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdrelsec_Enabled), 5, 0), true);
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

   public void confirm_5S0( )
   {
      beforeValidate5S252( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5S252( ) ;
         }
         else
         {
            checkExtendedTable5S252( ) ;
            closeExtendedTableCursors5S252( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5S0( )
   {
   }

   public void e115S2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliUpdRelSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliUpdRelSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdRelSec_Visible), 5, 0), true);
      AV27ComboCliUpdRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboCliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ComboCliUpdRelSec), 6, 0));
      edtavCombocliupdrelsec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdrelsec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdrelsec_Visible), 5, 0), true);
      edtCliUpdCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliUpdCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdCliCod_Visible), 5, 0), true);
      AV23ComboCliUpdCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliUpdCliCod), 6, 0));
      edtavCombocliupdclicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdclicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdclicod_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV21ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCliCod), 6, 0));
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
      /* Execute user subroutine: 'LOADCOMBOCLIUPDCLICOD' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCLIUPDRELSEC' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update_Insert", GXv_boolean5) ;
         cliente_update_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update_Update", GXv_boolean5) ;
         cliente_update_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update_Delete", GXv_boolean5) ;
         cliente_update_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV30Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e125S2( )
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
      /* 'LOADCOMBOCLIUPDRELSEC' Routine */
      returnInSub = false ;
      Combo_cliupdrelsec_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CliUpdRelSec\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliUpdCliCod\": 0, \"CliUpdRelSec\": 0, \"Cond_CliUpdCliCod\": \"#%1#\"", edtCliUpdCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_cliupdrelsec.sendProperty(context, "", false, Combo_cliupdrelsec_Internalname, "DataListProcParametersPrefix", Combo_cliupdrelsec_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.cliente_updateloaddvcombo(remoteHandle, context).execute( "CliUpdRelSec", Gx_mode, false, AV7CliCod, AV24CliUpdCliCod, AV25CliUpdRelSec, A1881CliUpdCliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      cliente_update_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      cliente_update_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      cliente_update_impl.this.GXt_char6 = GXv_char9[0] ;
      AV20Combo_DataJson = GXt_char6 ;
      Combo_cliupdrelsec_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_cliupdrelsec.sendProperty(context, "", false, Combo_cliupdrelsec_Internalname, "SelectedValue_set", Combo_cliupdrelsec_Selectedvalue_set);
      Combo_cliupdrelsec_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_cliupdrelsec.sendProperty(context, "", false, Combo_cliupdrelsec_Internalname, "SelectedText_set", Combo_cliupdrelsec_Selectedtext_set);
      AV27ComboCliUpdRelSec = (int)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboCliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27ComboCliUpdRelSec), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV25CliUpdRelSec) )
      {
         Combo_cliupdrelsec_Enabled = false ;
         ucCombo_cliupdrelsec.sendProperty(context, "", false, Combo_cliupdrelsec_Internalname, "Enabled", GXutil.booltostr( Combo_cliupdrelsec_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOCLIUPDCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.cliente_updateloaddvcombo(remoteHandle, context).execute( "CliUpdCliCod", Gx_mode, false, AV7CliCod, AV24CliUpdCliCod, AV25CliUpdRelSec, A1881CliUpdCliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      cliente_update_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      cliente_update_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      cliente_update_impl.this.GXt_char6 = GXv_char7[0] ;
      AV20Combo_DataJson = GXt_char6 ;
      Combo_cliupdclicod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_cliupdclicod.sendProperty(context, "", false, Combo_cliupdclicod_Internalname, "SelectedValue_set", Combo_cliupdclicod_Selectedvalue_set);
      Combo_cliupdclicod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_cliupdclicod.sendProperty(context, "", false, Combo_cliupdclicod_Internalname, "SelectedText_set", Combo_cliupdclicod_Selectedtext_set);
      AV23ComboCliUpdCliCod = (int)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliUpdCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV24CliUpdCliCod) )
      {
         Combo_cliupdclicod_Enabled = false ;
         ucCombo_cliupdclicod.sendProperty(context, "", false, Combo_cliupdclicod_Internalname, "Enabled", GXutil.booltostr( Combo_cliupdclicod_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.cliente_updateloaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV24CliUpdCliCod, AV25CliUpdRelSec, A1881CliUpdCliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      cliente_update_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      cliente_update_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      cliente_update_impl.this.GXt_char6 = GXv_char7[0] ;
      AV20Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV21ComboCliCod = (int)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm5S252( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1883CliUpdDTApl = T005S3_A1883CliUpdDTApl[0] ;
            Z1884CliUpdRelDesc = T005S3_A1884CliUpdRelDesc[0] ;
            Z1963CliUpdNotificado = T005S3_A1963CliUpdNotificado[0] ;
         }
         else
         {
            Z1883CliUpdDTApl = A1883CliUpdDTApl ;
            Z1884CliUpdRelDesc = A1884CliUpdRelDesc ;
            Z1963CliUpdNotificado = A1963CliUpdNotificado ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z1883CliUpdDTApl = A1883CliUpdDTApl ;
         Z1884CliUpdRelDesc = A1884CliUpdRelDesc ;
         Z1962CliUpdFecRel = A1962CliUpdFecRel ;
         Z1963CliUpdNotificado = A1963CliUpdNotificado ;
         Z3CliCod = A3CliCod ;
         Z1881CliUpdCliCod = A1881CliUpdCliCod ;
         Z1887CliUpdRelSec = A1887CliUpdRelSec ;
         Z1964CliUpdRelHab = A1964CliUpdRelHab ;
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
      if ( ! (0==AV24CliUpdCliCod) )
      {
         edtCliUpdCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliUpdCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV24CliUpdCliCod) )
      {
         edtCliUpdCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV25CliUpdRelSec) )
      {
         edtCliUpdRelSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdRelSec_Enabled), 5, 0), true);
      }
      else
      {
         edtCliUpdRelSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdRelSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV25CliUpdRelSec) )
      {
         edtCliUpdRelSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliUpdRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdRelSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV25CliUpdRelSec) )
      {
         A1887CliUpdRelSec = AV25CliUpdRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
      }
      else
      {
         A1887CliUpdRelSec = AV27ComboCliUpdRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
      }
      if ( ! (0==AV24CliUpdCliCod) )
      {
         A1881CliUpdCliCod = AV24CliUpdCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
      }
      else
      {
         A1881CliUpdCliCod = AV23ComboCliUpdCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV21ComboCliCod ;
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
         AV30Pgmname = "Cliente_Update" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         /* Using cursor T005S5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
         A1962CliUpdFecRel = T005S5_A1962CliUpdFecRel[0] ;
         A1964CliUpdRelHab = T005S5_A1964CliUpdRelHab[0] ;
         pr_default.close(3);
      }
   }

   public void load5S252( )
   {
      /* Using cursor T005S6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound252 = (short)(1) ;
         A1883CliUpdDTApl = T005S6_A1883CliUpdDTApl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1883CliUpdDTApl", localUtil.ttoc( A1883CliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A1884CliUpdRelDesc = T005S6_A1884CliUpdRelDesc[0] ;
         A1962CliUpdFecRel = T005S6_A1962CliUpdFecRel[0] ;
         A1964CliUpdRelHab = T005S6_A1964CliUpdRelHab[0] ;
         A1963CliUpdNotificado = T005S6_A1963CliUpdNotificado[0] ;
         zm5S252( -10) ;
      }
      pr_default.close(4);
      onLoadActions5S252( ) ;
   }

   public void onLoadActions5S252( )
   {
      AV30Pgmname = "Cliente_Update" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
   }

   public void checkExtendedTable5S252( )
   {
      nIsDirty_252 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV30Pgmname = "Cliente_Update" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      /* Using cursor T005S4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T005S5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Release", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIUPDRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliUpdCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1962CliUpdFecRel = T005S5_A1962CliUpdFecRel[0] ;
      A1964CliUpdRelHab = T005S5_A1964CliUpdRelHab[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors5S252( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( int A3CliCod )
   {
      /* Using cursor T005S7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
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

   public void gxload_12( int A1881CliUpdCliCod ,
                          int A1887CliUpdRelSec )
   {
      /* Using cursor T005S8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Release", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIUPDRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliUpdCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1962CliUpdFecRel = T005S8_A1962CliUpdFecRel[0] ;
      A1964CliUpdRelHab = T005S8_A1964CliUpdRelHab[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A1962CliUpdFecRel, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( A1964CliUpdRelHab))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey5S252( )
   {
      /* Using cursor T005S9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound252 = (short)(1) ;
      }
      else
      {
         RcdFound252 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005S3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5S252( 10) ;
         RcdFound252 = (short)(1) ;
         A1883CliUpdDTApl = T005S3_A1883CliUpdDTApl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1883CliUpdDTApl", localUtil.ttoc( A1883CliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A1884CliUpdRelDesc = T005S3_A1884CliUpdRelDesc[0] ;
         A1963CliUpdNotificado = T005S3_A1963CliUpdNotificado[0] ;
         A3CliCod = T005S3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1881CliUpdCliCod = T005S3_A1881CliUpdCliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
         A1887CliUpdRelSec = T005S3_A1887CliUpdRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
         Z3CliCod = A3CliCod ;
         Z1881CliUpdCliCod = A1881CliUpdCliCod ;
         Z1887CliUpdRelSec = A1887CliUpdRelSec ;
         sMode252 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5S252( ) ;
         if ( AnyError == 1 )
         {
            RcdFound252 = (short)(0) ;
            initializeNonKey5S252( ) ;
         }
         Gx_mode = sMode252 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound252 = (short)(0) ;
         initializeNonKey5S252( ) ;
         sMode252 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode252 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5S252( ) ;
      if ( RcdFound252 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound252 = (short)(0) ;
      /* Using cursor T005S10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005S10_A3CliCod[0] < A3CliCod ) || ( T005S10_A3CliCod[0] == A3CliCod ) && ( T005S10_A1881CliUpdCliCod[0] < A1881CliUpdCliCod ) || ( T005S10_A1881CliUpdCliCod[0] == A1881CliUpdCliCod ) && ( T005S10_A3CliCod[0] == A3CliCod ) && ( T005S10_A1887CliUpdRelSec[0] < A1887CliUpdRelSec ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005S10_A3CliCod[0] > A3CliCod ) || ( T005S10_A3CliCod[0] == A3CliCod ) && ( T005S10_A1881CliUpdCliCod[0] > A1881CliUpdCliCod ) || ( T005S10_A1881CliUpdCliCod[0] == A1881CliUpdCliCod ) && ( T005S10_A3CliCod[0] == A3CliCod ) && ( T005S10_A1887CliUpdRelSec[0] > A1887CliUpdRelSec ) ) )
         {
            A3CliCod = T005S10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1881CliUpdCliCod = T005S10_A1881CliUpdCliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
            A1887CliUpdRelSec = T005S10_A1887CliUpdRelSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
            RcdFound252 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound252 = (short)(0) ;
      /* Using cursor T005S11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005S11_A3CliCod[0] > A3CliCod ) || ( T005S11_A3CliCod[0] == A3CliCod ) && ( T005S11_A1881CliUpdCliCod[0] > A1881CliUpdCliCod ) || ( T005S11_A1881CliUpdCliCod[0] == A1881CliUpdCliCod ) && ( T005S11_A3CliCod[0] == A3CliCod ) && ( T005S11_A1887CliUpdRelSec[0] > A1887CliUpdRelSec ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005S11_A3CliCod[0] < A3CliCod ) || ( T005S11_A3CliCod[0] == A3CliCod ) && ( T005S11_A1881CliUpdCliCod[0] < A1881CliUpdCliCod ) || ( T005S11_A1881CliUpdCliCod[0] == A1881CliUpdCliCod ) && ( T005S11_A3CliCod[0] == A3CliCod ) && ( T005S11_A1887CliUpdRelSec[0] < A1887CliUpdRelSec ) ) )
         {
            A3CliCod = T005S11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1881CliUpdCliCod = T005S11_A1881CliUpdCliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
            A1887CliUpdRelSec = T005S11_A1887CliUpdRelSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
            RcdFound252 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5S252( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5S252( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound252 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1881CliUpdCliCod != Z1881CliUpdCliCod ) || ( A1887CliUpdRelSec != Z1887CliUpdRelSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1881CliUpdCliCod = Z1881CliUpdCliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
               A1887CliUpdRelSec = Z1887CliUpdRelSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
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
               update5S252( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1881CliUpdCliCod != Z1881CliUpdCliCod ) || ( A1887CliUpdRelSec != Z1887CliUpdRelSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5S252( ) ;
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
                  insert5S252( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1881CliUpdCliCod != Z1881CliUpdCliCod ) || ( A1887CliUpdRelSec != Z1887CliUpdRelSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1881CliUpdCliCod = Z1881CliUpdCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
         A1887CliUpdRelSec = Z1887CliUpdRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
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

   public void checkOptimisticConcurrency5S252( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente_Update"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(Z1883CliUpdDTApl, T005S2_A1883CliUpdDTApl[0]) ) || ( GXutil.strcmp(Z1884CliUpdRelDesc, T005S2_A1884CliUpdRelDesc[0]) != 0 ) || ( Z1963CliUpdNotificado != T005S2_A1963CliUpdNotificado[0] ) )
         {
            if ( !( GXutil.dateCompare(Z1883CliUpdDTApl, T005S2_A1883CliUpdDTApl[0]) ) )
            {
               GXutil.writeLogln("cliente_update:[seudo value changed for attri]"+"CliUpdDTApl");
               GXutil.writeLogRaw("Old: ",Z1883CliUpdDTApl);
               GXutil.writeLogRaw("Current: ",T005S2_A1883CliUpdDTApl[0]);
            }
            if ( GXutil.strcmp(Z1884CliUpdRelDesc, T005S2_A1884CliUpdRelDesc[0]) != 0 )
            {
               GXutil.writeLogln("cliente_update:[seudo value changed for attri]"+"CliUpdRelDesc");
               GXutil.writeLogRaw("Old: ",Z1884CliUpdRelDesc);
               GXutil.writeLogRaw("Current: ",T005S2_A1884CliUpdRelDesc[0]);
            }
            if ( Z1963CliUpdNotificado != T005S2_A1963CliUpdNotificado[0] )
            {
               GXutil.writeLogln("cliente_update:[seudo value changed for attri]"+"CliUpdNotificado");
               GXutil.writeLogRaw("Old: ",Z1963CliUpdNotificado);
               GXutil.writeLogRaw("Current: ",T005S2_A1963CliUpdNotificado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cliente_Update"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5S252( )
   {
      beforeValidate5S252( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5S252( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5S252( 0) ;
         checkOptimisticConcurrency5S252( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5S252( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5S252( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005S12 */
                  pr_default.execute(10, new Object[] {A1962CliUpdFecRel, A1883CliUpdDTApl, A1884CliUpdRelDesc, Boolean.valueOf(A1963CliUpdNotificado), Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
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
                        resetCaption5S0( ) ;
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
            load5S252( ) ;
         }
         endLevel5S252( ) ;
      }
      closeExtendedTableCursors5S252( ) ;
   }

   public void update5S252( )
   {
      beforeValidate5S252( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5S252( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5S252( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5S252( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5S252( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005S13 */
                  pr_default.execute(11, new Object[] {A1962CliUpdFecRel, A1883CliUpdDTApl, A1884CliUpdRelDesc, Boolean.valueOf(A1963CliUpdNotificado), Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente_Update"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5S252( ) ;
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
         endLevel5S252( ) ;
      }
      closeExtendedTableCursors5S252( ) ;
   }

   public void deferredUpdate5S252( )
   {
   }

   public void delete( )
   {
      beforeValidate5S252( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5S252( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5S252( ) ;
         afterConfirm5S252( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5S252( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005S14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
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
      sMode252 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5S252( ) ;
      Gx_mode = sMode252 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5S252( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV30Pgmname = "Cliente_Update" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         /* Using cursor T005S15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
         A1962CliUpdFecRel = T005S15_A1962CliUpdFecRel[0] ;
         A1964CliUpdRelHab = T005S15_A1964CliUpdRelHab[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel5S252( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5S252( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "cliente_update");
         if ( AnyError == 0 )
         {
            confirmValues5S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "cliente_update");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5S252( )
   {
      /* Scan By routine */
      /* Using cursor T005S16 */
      pr_default.execute(14);
      RcdFound252 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound252 = (short)(1) ;
         A3CliCod = T005S16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1881CliUpdCliCod = T005S16_A1881CliUpdCliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
         A1887CliUpdRelSec = T005S16_A1887CliUpdRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5S252( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound252 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound252 = (short)(1) ;
         A3CliCod = T005S16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1881CliUpdCliCod = T005S16_A1881CliUpdCliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
         A1887CliUpdRelSec = T005S16_A1887CliUpdRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
      }
   }

   public void scanEnd5S252( )
   {
      pr_default.close(14);
   }

   public void afterConfirm5S252( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5S252( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5S252( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5S252( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5S252( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5S252( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5S252( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliUpdCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliUpdCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdCliCod_Enabled), 5, 0), true);
      edtCliUpdRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliUpdRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdRelSec_Enabled), 5, 0), true);
      edtCliUpdDTApl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliUpdDTApl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliUpdDTApl_Enabled), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      edtavCombocliupdclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdclicod_Enabled), 5, 0), true);
      edtavCombocliupdrelsec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliupdrelsec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliupdrelsec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5S252( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5S0( )
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.cliente_update", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV24CliUpdCliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV25CliUpdRelSec,6,0))}, new String[] {"Gx_mode","CliCod","CliUpdCliCod","CliUpdRelSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Cliente_Update");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CliUpdRelDesc", GXutil.rtrim( localUtil.format( A1884CliUpdRelDesc, "")));
      forbiddenHiddens.add("CliUpdNotificado", GXutil.booltostr( A1963CliUpdNotificado));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("cliente_update:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1881CliUpdCliCod", GXutil.ltrim( localUtil.ntoc( Z1881CliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1887CliUpdRelSec", GXutil.ltrim( localUtil.ntoc( Z1887CliUpdRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1883CliUpdDTApl", localUtil.ttoc( Z1883CliUpdDTApl, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1884CliUpdRelDesc", Z1884CliUpdRelDesc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1963CliUpdNotificado", Z1963CliUpdNotificado);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV16CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV16CliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLIUPDCLICOD_DATA", AV22CliUpdCliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLIUPDCLICOD_DATA", AV22CliUpdCliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLIUPDRELSEC_DATA", AV26CliUpdRelSec_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLIUPDRELSEC_DATA", AV26CliUpdRelSec_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLIUPDCLICOD", GXutil.ltrim( localUtil.ntoc( AV29Cond_CliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIUPDCLICOD", GXutil.ltrim( localUtil.ntoc( AV24CliUpdCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIUPDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24CliUpdCliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIUPDRELSEC", GXutil.ltrim( localUtil.ntoc( AV25CliUpdRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIUPDRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25CliUpdRelSec), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIUPDRELDESC", A1884CliUpdRelDesc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLIUPDNOTIFICADO", A1963CliUpdNotificado);
      web.GxWebStd.gx_hidden_field( httpContext, "CLIUPDFECREL", localUtil.ttoc( A1962CliUpdFecRel, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLIUPDRELHAB", A1964CliUpdRelHab);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV30Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Objectcall", GXutil.rtrim( Combo_cliupdclicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Cls", GXutil.rtrim( Combo_cliupdclicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Selectedvalue_set", GXutil.rtrim( Combo_cliupdclicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Selectedtext_set", GXutil.rtrim( Combo_cliupdclicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Enabled", GXutil.booltostr( Combo_cliupdclicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Datalistproc", GXutil.rtrim( Combo_cliupdclicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliupdclicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDCLICOD_Emptyitem", GXutil.booltostr( Combo_cliupdclicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Objectcall", GXutil.rtrim( Combo_cliupdrelsec_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Cls", GXutil.rtrim( Combo_cliupdrelsec_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Selectedvalue_set", GXutil.rtrim( Combo_cliupdrelsec_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Selectedtext_set", GXutil.rtrim( Combo_cliupdrelsec_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Enabled", GXutil.booltostr( Combo_cliupdrelsec_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Datalistproc", GXutil.rtrim( Combo_cliupdrelsec_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliupdrelsec_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIUPDRELSEC_Emptyitem", GXutil.booltostr( Combo_cliupdrelsec_Emptyitem));
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
      return formatLink("web.cliente_update", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV24CliUpdCliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV25CliUpdRelSec,6,0))}, new String[] {"Gx_mode","CliCod","CliUpdCliCod","CliUpdRelSec"})  ;
   }

   public String getPgmname( )
   {
      return "Cliente_Update" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Actualizaciones", "") ;
   }

   public void initializeNonKey5S252( )
   {
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A1883CliUpdDTApl", localUtil.ttoc( A1883CliUpdDTApl, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A1884CliUpdRelDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1884CliUpdRelDesc", A1884CliUpdRelDesc);
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A1962CliUpdFecRel", localUtil.ttoc( A1962CliUpdFecRel, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A1964CliUpdRelHab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1964CliUpdRelHab", A1964CliUpdRelHab);
      A1963CliUpdNotificado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1963CliUpdNotificado", A1963CliUpdNotificado);
      Z1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      Z1884CliUpdRelDesc = "" ;
      Z1963CliUpdNotificado = false ;
   }

   public void initAll5S252( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1881CliUpdCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1881CliUpdCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1881CliUpdCliCod), 6, 0));
      A1887CliUpdRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1887CliUpdRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1887CliUpdRelSec), 6, 0));
      initializeNonKey5S252( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201945798", true, true);
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
      httpContext.AddJavascriptSource("cliente_update.js", "?202412201945798", false, true);
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
      lblTextblockcliupdclicod_Internalname = "TEXTBLOCKCLIUPDCLICOD" ;
      Combo_cliupdclicod_Internalname = "COMBO_CLIUPDCLICOD" ;
      edtCliUpdCliCod_Internalname = "CLIUPDCLICOD" ;
      divTablesplittedcliupdclicod_Internalname = "TABLESPLITTEDCLIUPDCLICOD" ;
      lblTextblockcliupdrelsec_Internalname = "TEXTBLOCKCLIUPDRELSEC" ;
      Combo_cliupdrelsec_Internalname = "COMBO_CLIUPDRELSEC" ;
      edtCliUpdRelSec_Internalname = "CLIUPDRELSEC" ;
      divTablesplittedcliupdrelsec_Internalname = "TABLESPLITTEDCLIUPDRELSEC" ;
      edtCliUpdDTApl_Internalname = "CLIUPDDTAPL" ;
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
      edtavCombocliupdclicod_Internalname = "vCOMBOCLIUPDCLICOD" ;
      divSectionattribute_cliupdclicod_Internalname = "SECTIONATTRIBUTE_CLIUPDCLICOD" ;
      edtavCombocliupdrelsec_Internalname = "vCOMBOCLIUPDRELSEC" ;
      divSectionattribute_cliupdrelsec_Internalname = "SECTIONATTRIBUTE_CLIUPDRELSEC" ;
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
      Form.setCaption( httpContext.getMessage( "Actualizaciones", "") );
      Combo_cliupdrelsec_Datalistprocparametersprefix = "" ;
      edtavCombocliupdrelsec_Jsonclick = "" ;
      edtavCombocliupdrelsec_Enabled = 0 ;
      edtavCombocliupdrelsec_Visible = 1 ;
      edtavCombocliupdclicod_Jsonclick = "" ;
      edtavCombocliupdclicod_Enabled = 0 ;
      edtavCombocliupdclicod_Visible = 1 ;
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtCliUpdDTApl_Jsonclick = "" ;
      edtCliUpdDTApl_Enabled = 1 ;
      edtCliUpdRelSec_Jsonclick = "" ;
      edtCliUpdRelSec_Enabled = 1 ;
      edtCliUpdRelSec_Visible = 1 ;
      Combo_cliupdrelsec_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliupdrelsec_Datalistproc = "Cliente_UpdateLoadDVCombo" ;
      Combo_cliupdrelsec_Cls = "ExtendedCombo Attribute" ;
      Combo_cliupdrelsec_Caption = "" ;
      Combo_cliupdrelsec_Enabled = GXutil.toBoolean( -1) ;
      edtCliUpdCliCod_Jsonclick = "" ;
      edtCliUpdCliCod_Enabled = 1 ;
      edtCliUpdCliCod_Visible = 1 ;
      Combo_cliupdclicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliupdclicod_Datalistprocparametersprefix = " \"ComboName\": \"CliUpdCliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliUpdCliCod\": 0, \"CliUpdRelSec\": 0" ;
      Combo_cliupdclicod_Datalistproc = "Cliente_UpdateLoadDVCombo" ;
      Combo_cliupdclicod_Cls = "ExtendedCombo Attribute" ;
      Combo_cliupdclicod_Caption = "" ;
      Combo_cliupdclicod_Enabled = GXutil.toBoolean( -1) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliUpdCliCod\": 0, \"CliUpdRelSec\": 0" ;
      Combo_clicod_Datalistproc = "Cliente_UpdateLoadDVCombo" ;
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
      /* Using cursor T005S17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Cliupdrelsec( )
   {
      /* Using cursor T005S15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Release", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIUPDRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliUpdCliCod_Internalname ;
      }
      A1962CliUpdFecRel = T005S15_A1962CliUpdFecRel[0] ;
      A1964CliUpdRelHab = T005S15_A1964CliUpdRelHab[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1962CliUpdFecRel", localUtil.ttoc( A1962CliUpdFecRel, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A1964CliUpdRelHab", A1964CliUpdRelHab);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV24CliUpdCliCod',fld:'vCLIUPDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25CliUpdRelSec',fld:'vCLIUPDRELSEC',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV24CliUpdCliCod',fld:'vCLIUPDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25CliUpdRelSec',fld:'vCLIUPDRELSEC',pic:'ZZZZZ9',hsh:true},{av:'A1884CliUpdRelDesc',fld:'CLIUPDRELDESC',pic:''},{av:'A1963CliUpdNotificado',fld:'CLIUPDNOTIFICADO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e125S2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIUPDCLICOD","{handler:'valid_Cliupdclicod',iparms:[]");
      setEventMetadata("VALID_CLIUPDCLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIUPDRELSEC","{handler:'valid_Cliupdrelsec',iparms:[{av:'A1881CliUpdCliCod',fld:'CLIUPDCLICOD',pic:'ZZZZZ9'},{av:'A1887CliUpdRelSec',fld:'CLIUPDRELSEC',pic:'ZZZZZ9'},{av:'A1962CliUpdFecRel',fld:'CLIUPDFECREL',pic:'99/99/99 99:99'},{av:'A1964CliUpdRelHab',fld:'CLIUPDRELHAB',pic:''}]");
      setEventMetadata("VALID_CLIUPDRELSEC",",oparms:[{av:'A1962CliUpdFecRel',fld:'CLIUPDFECREL',pic:'99/99/99 99:99'},{av:'A1964CliUpdRelHab',fld:'CLIUPDRELHAB',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCLIUPDCLICOD","{handler:'validv_Combocliupdclicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLIUPDCLICOD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCLIUPDRELSEC","{handler:'validv_Combocliupdrelsec',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLIUPDRELSEC",",oparms:[]}");
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
      Z1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      Z1884CliUpdRelDesc = "" ;
      Combo_cliupdrelsec_Selectedvalue_get = "" ;
      Combo_cliupdclicod_Selectedvalue_get = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
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
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockcliupdclicod_Jsonclick = "" ;
      ucCombo_cliupdclicod = new com.genexus.webpanels.GXUserControl();
      AV22CliUpdCliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockcliupdrelsec_Jsonclick = "" ;
      ucCombo_cliupdrelsec = new com.genexus.webpanels.GXUserControl();
      AV26CliUpdRelSec_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1884CliUpdRelDesc = "" ;
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      AV30Pgmname = "" ;
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
      Combo_cliupdclicod_Objectcall = "" ;
      Combo_cliupdclicod_Class = "" ;
      Combo_cliupdclicod_Icontype = "" ;
      Combo_cliupdclicod_Icon = "" ;
      Combo_cliupdclicod_Tooltip = "" ;
      Combo_cliupdclicod_Selectedvalue_set = "" ;
      Combo_cliupdclicod_Selectedtext_set = "" ;
      Combo_cliupdclicod_Selectedtext_get = "" ;
      Combo_cliupdclicod_Gamoauthtoken = "" ;
      Combo_cliupdclicod_Ddointernalname = "" ;
      Combo_cliupdclicod_Titlecontrolalign = "" ;
      Combo_cliupdclicod_Dropdownoptionstype = "" ;
      Combo_cliupdclicod_Titlecontrolidtoreplace = "" ;
      Combo_cliupdclicod_Datalisttype = "" ;
      Combo_cliupdclicod_Datalistfixedvalues = "" ;
      Combo_cliupdclicod_Remoteservicesparameters = "" ;
      Combo_cliupdclicod_Htmltemplate = "" ;
      Combo_cliupdclicod_Multiplevaluestype = "" ;
      Combo_cliupdclicod_Loadingdata = "" ;
      Combo_cliupdclicod_Noresultsfound = "" ;
      Combo_cliupdclicod_Emptyitemtext = "" ;
      Combo_cliupdclicod_Onlyselectedvalues = "" ;
      Combo_cliupdclicod_Selectalltext = "" ;
      Combo_cliupdclicod_Multiplevaluesseparator = "" ;
      Combo_cliupdclicod_Addnewoptiontext = "" ;
      Combo_cliupdrelsec_Objectcall = "" ;
      Combo_cliupdrelsec_Class = "" ;
      Combo_cliupdrelsec_Icontype = "" ;
      Combo_cliupdrelsec_Icon = "" ;
      Combo_cliupdrelsec_Tooltip = "" ;
      Combo_cliupdrelsec_Selectedvalue_set = "" ;
      Combo_cliupdrelsec_Selectedtext_set = "" ;
      Combo_cliupdrelsec_Selectedtext_get = "" ;
      Combo_cliupdrelsec_Gamoauthtoken = "" ;
      Combo_cliupdrelsec_Ddointernalname = "" ;
      Combo_cliupdrelsec_Titlecontrolalign = "" ;
      Combo_cliupdrelsec_Dropdownoptionstype = "" ;
      Combo_cliupdrelsec_Titlecontrolidtoreplace = "" ;
      Combo_cliupdrelsec_Datalisttype = "" ;
      Combo_cliupdrelsec_Datalistfixedvalues = "" ;
      Combo_cliupdrelsec_Remoteservicesparameters = "" ;
      Combo_cliupdrelsec_Htmltemplate = "" ;
      Combo_cliupdrelsec_Multiplevaluestype = "" ;
      Combo_cliupdrelsec_Loadingdata = "" ;
      Combo_cliupdrelsec_Noresultsfound = "" ;
      Combo_cliupdrelsec_Emptyitemtext = "" ;
      Combo_cliupdrelsec_Onlyselectedvalues = "" ;
      Combo_cliupdrelsec_Selectalltext = "" ;
      Combo_cliupdrelsec_Multiplevaluesseparator = "" ;
      Combo_cliupdrelsec_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode252 = "" ;
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
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      T005S5_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S5_A1964CliUpdRelHab = new boolean[] {false} ;
      T005S6_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      T005S6_A1884CliUpdRelDesc = new String[] {""} ;
      T005S6_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S6_A1964CliUpdRelHab = new boolean[] {false} ;
      T005S6_A1963CliUpdNotificado = new boolean[] {false} ;
      T005S6_A3CliCod = new int[1] ;
      T005S6_A1881CliUpdCliCod = new int[1] ;
      T005S6_A1887CliUpdRelSec = new int[1] ;
      T005S4_A3CliCod = new int[1] ;
      T005S7_A3CliCod = new int[1] ;
      T005S8_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S8_A1964CliUpdRelHab = new boolean[] {false} ;
      T005S9_A3CliCod = new int[1] ;
      T005S9_A1881CliUpdCliCod = new int[1] ;
      T005S9_A1887CliUpdRelSec = new int[1] ;
      T005S3_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      T005S3_A1884CliUpdRelDesc = new String[] {""} ;
      T005S3_A1963CliUpdNotificado = new boolean[] {false} ;
      T005S3_A3CliCod = new int[1] ;
      T005S3_A1881CliUpdCliCod = new int[1] ;
      T005S3_A1887CliUpdRelSec = new int[1] ;
      T005S3_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S10_A3CliCod = new int[1] ;
      T005S10_A1881CliUpdCliCod = new int[1] ;
      T005S10_A1887CliUpdRelSec = new int[1] ;
      T005S11_A3CliCod = new int[1] ;
      T005S11_A1881CliUpdCliCod = new int[1] ;
      T005S11_A1887CliUpdRelSec = new int[1] ;
      T005S2_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      T005S2_A1884CliUpdRelDesc = new String[] {""} ;
      T005S2_A1963CliUpdNotificado = new boolean[] {false} ;
      T005S2_A3CliCod = new int[1] ;
      T005S2_A1881CliUpdCliCod = new int[1] ;
      T005S2_A1887CliUpdRelSec = new int[1] ;
      T005S2_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S15_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      T005S15_A1964CliUpdRelHab = new boolean[] {false} ;
      T005S16_A3CliCod = new int[1] ;
      T005S16_A1881CliUpdCliCod = new int[1] ;
      T005S16_A1887CliUpdRelSec = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005S17_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_update__default(),
         new Object[] {
             new Object[] {
            T005S2_A1883CliUpdDTApl, T005S2_A1884CliUpdRelDesc, T005S2_A1963CliUpdNotificado, T005S2_A3CliCod, T005S2_A1881CliUpdCliCod, T005S2_A1887CliUpdRelSec, T005S2_A1962CliUpdFecRel
            }
            , new Object[] {
            T005S3_A1883CliUpdDTApl, T005S3_A1884CliUpdRelDesc, T005S3_A1963CliUpdNotificado, T005S3_A3CliCod, T005S3_A1881CliUpdCliCod, T005S3_A1887CliUpdRelSec, T005S3_A1962CliUpdFecRel
            }
            , new Object[] {
            T005S4_A3CliCod
            }
            , new Object[] {
            T005S5_A1962CliUpdFecRel, T005S5_A1964CliUpdRelHab
            }
            , new Object[] {
            T005S6_A1883CliUpdDTApl, T005S6_A1884CliUpdRelDesc, T005S6_A1962CliUpdFecRel, T005S6_A1964CliUpdRelHab, T005S6_A1963CliUpdNotificado, T005S6_A3CliCod, T005S6_A1881CliUpdCliCod, T005S6_A1887CliUpdRelSec
            }
            , new Object[] {
            T005S7_A3CliCod
            }
            , new Object[] {
            T005S8_A1962CliUpdFecRel, T005S8_A1964CliUpdRelHab
            }
            , new Object[] {
            T005S9_A3CliCod, T005S9_A1881CliUpdCliCod, T005S9_A1887CliUpdRelSec
            }
            , new Object[] {
            T005S10_A3CliCod, T005S10_A1881CliUpdCliCod, T005S10_A1887CliUpdRelSec
            }
            , new Object[] {
            T005S11_A3CliCod, T005S11_A1881CliUpdCliCod, T005S11_A1887CliUpdRelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005S15_A1962CliUpdFecRel, T005S15_A1964CliUpdRelHab
            }
            , new Object[] {
            T005S16_A3CliCod, T005S16_A1881CliUpdCliCod, T005S16_A1887CliUpdRelSec
            }
            , new Object[] {
            T005S17_A3CliCod
            }
         }
      );
      AV30Pgmname = "Cliente_Update" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound252 ;
   private short nIsDirty_252 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV24CliUpdCliCod ;
   private int wcpOAV25CliUpdRelSec ;
   private int Z3CliCod ;
   private int Z1881CliUpdCliCod ;
   private int Z1887CliUpdRelSec ;
   private int A3CliCod ;
   private int A1881CliUpdCliCod ;
   private int A1887CliUpdRelSec ;
   private int AV7CliCod ;
   private int AV24CliUpdCliCod ;
   private int AV25CliUpdRelSec ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliUpdCliCod_Visible ;
   private int edtCliUpdCliCod_Enabled ;
   private int edtCliUpdRelSec_Visible ;
   private int edtCliUpdRelSec_Enabled ;
   private int edtCliUpdDTApl_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV21ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int AV23ComboCliUpdCliCod ;
   private int edtavCombocliupdclicod_Enabled ;
   private int edtavCombocliupdclicod_Visible ;
   private int AV27ComboCliUpdRelSec ;
   private int edtavCombocliupdrelsec_Enabled ;
   private int edtavCombocliupdrelsec_Visible ;
   private int AV29Cond_CliUpdCliCod ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Combo_cliupdclicod_Datalistupdateminimumcharacters ;
   private int Combo_cliupdrelsec_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_cliupdrelsec_Selectedvalue_get ;
   private String Combo_cliupdclicod_Selectedvalue_get ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
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
   private String divTablesplittedcliupdclicod_Internalname ;
   private String lblTextblockcliupdclicod_Internalname ;
   private String lblTextblockcliupdclicod_Jsonclick ;
   private String Combo_cliupdclicod_Caption ;
   private String Combo_cliupdclicod_Cls ;
   private String Combo_cliupdclicod_Datalistproc ;
   private String Combo_cliupdclicod_Datalistprocparametersprefix ;
   private String Combo_cliupdclicod_Internalname ;
   private String edtCliUpdCliCod_Internalname ;
   private String edtCliUpdCliCod_Jsonclick ;
   private String divTablesplittedcliupdrelsec_Internalname ;
   private String lblTextblockcliupdrelsec_Internalname ;
   private String lblTextblockcliupdrelsec_Jsonclick ;
   private String Combo_cliupdrelsec_Caption ;
   private String Combo_cliupdrelsec_Cls ;
   private String Combo_cliupdrelsec_Datalistproc ;
   private String Combo_cliupdrelsec_Internalname ;
   private String edtCliUpdRelSec_Internalname ;
   private String edtCliUpdRelSec_Jsonclick ;
   private String edtCliUpdDTApl_Internalname ;
   private String edtCliUpdDTApl_Jsonclick ;
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
   private String divSectionattribute_cliupdclicod_Internalname ;
   private String edtavCombocliupdclicod_Internalname ;
   private String edtavCombocliupdclicod_Jsonclick ;
   private String divSectionattribute_cliupdrelsec_Internalname ;
   private String edtavCombocliupdrelsec_Internalname ;
   private String edtavCombocliupdrelsec_Jsonclick ;
   private String AV30Pgmname ;
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
   private String Combo_cliupdclicod_Objectcall ;
   private String Combo_cliupdclicod_Class ;
   private String Combo_cliupdclicod_Icontype ;
   private String Combo_cliupdclicod_Icon ;
   private String Combo_cliupdclicod_Tooltip ;
   private String Combo_cliupdclicod_Selectedvalue_set ;
   private String Combo_cliupdclicod_Selectedtext_set ;
   private String Combo_cliupdclicod_Selectedtext_get ;
   private String Combo_cliupdclicod_Gamoauthtoken ;
   private String Combo_cliupdclicod_Ddointernalname ;
   private String Combo_cliupdclicod_Titlecontrolalign ;
   private String Combo_cliupdclicod_Dropdownoptionstype ;
   private String Combo_cliupdclicod_Titlecontrolidtoreplace ;
   private String Combo_cliupdclicod_Datalisttype ;
   private String Combo_cliupdclicod_Datalistfixedvalues ;
   private String Combo_cliupdclicod_Remoteservicesparameters ;
   private String Combo_cliupdclicod_Htmltemplate ;
   private String Combo_cliupdclicod_Multiplevaluestype ;
   private String Combo_cliupdclicod_Loadingdata ;
   private String Combo_cliupdclicod_Noresultsfound ;
   private String Combo_cliupdclicod_Emptyitemtext ;
   private String Combo_cliupdclicod_Onlyselectedvalues ;
   private String Combo_cliupdclicod_Selectalltext ;
   private String Combo_cliupdclicod_Multiplevaluesseparator ;
   private String Combo_cliupdclicod_Addnewoptiontext ;
   private String Combo_cliupdrelsec_Objectcall ;
   private String Combo_cliupdrelsec_Class ;
   private String Combo_cliupdrelsec_Icontype ;
   private String Combo_cliupdrelsec_Icon ;
   private String Combo_cliupdrelsec_Tooltip ;
   private String Combo_cliupdrelsec_Selectedvalue_set ;
   private String Combo_cliupdrelsec_Selectedtext_set ;
   private String Combo_cliupdrelsec_Selectedtext_get ;
   private String Combo_cliupdrelsec_Gamoauthtoken ;
   private String Combo_cliupdrelsec_Ddointernalname ;
   private String Combo_cliupdrelsec_Titlecontrolalign ;
   private String Combo_cliupdrelsec_Dropdownoptionstype ;
   private String Combo_cliupdrelsec_Titlecontrolidtoreplace ;
   private String Combo_cliupdrelsec_Datalisttype ;
   private String Combo_cliupdrelsec_Datalistfixedvalues ;
   private String Combo_cliupdrelsec_Datalistprocparametersprefix ;
   private String Combo_cliupdrelsec_Remoteservicesparameters ;
   private String Combo_cliupdrelsec_Htmltemplate ;
   private String Combo_cliupdrelsec_Multiplevaluestype ;
   private String Combo_cliupdrelsec_Loadingdata ;
   private String Combo_cliupdrelsec_Noresultsfound ;
   private String Combo_cliupdrelsec_Emptyitemtext ;
   private String Combo_cliupdrelsec_Onlyselectedvalues ;
   private String Combo_cliupdrelsec_Selectalltext ;
   private String Combo_cliupdrelsec_Multiplevaluesseparator ;
   private String Combo_cliupdrelsec_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode252 ;
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
   private java.util.Date Z1883CliUpdDTApl ;
   private java.util.Date A1883CliUpdDTApl ;
   private java.util.Date A1962CliUpdFecRel ;
   private java.util.Date Z1962CliUpdFecRel ;
   private boolean Z1963CliUpdNotificado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_cliupdclicod_Emptyitem ;
   private boolean Combo_cliupdrelsec_Emptyitem ;
   private boolean A1963CliUpdNotificado ;
   private boolean A1964CliUpdRelHab ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
   private boolean Combo_cliupdclicod_Enabled ;
   private boolean Combo_cliupdclicod_Visible ;
   private boolean Combo_cliupdclicod_Allowmultipleselection ;
   private boolean Combo_cliupdclicod_Isgriditem ;
   private boolean Combo_cliupdclicod_Hasdescription ;
   private boolean Combo_cliupdclicod_Includeonlyselectedoption ;
   private boolean Combo_cliupdclicod_Includeselectalloption ;
   private boolean Combo_cliupdclicod_Includeaddnewoption ;
   private boolean Combo_cliupdrelsec_Enabled ;
   private boolean Combo_cliupdrelsec_Visible ;
   private boolean Combo_cliupdrelsec_Allowmultipleselection ;
   private boolean Combo_cliupdrelsec_Isgriditem ;
   private boolean Combo_cliupdrelsec_Hasdescription ;
   private boolean Combo_cliupdrelsec_Includeonlyselectedoption ;
   private boolean Combo_cliupdrelsec_Includeselectalloption ;
   private boolean Combo_cliupdrelsec_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Z1964CliUpdRelHab ;
   private String AV20Combo_DataJson ;
   private String Z1884CliUpdRelDesc ;
   private String A1884CliUpdRelDesc ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliupdclicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliupdrelsec ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T005S5_A1962CliUpdFecRel ;
   private boolean[] T005S5_A1964CliUpdRelHab ;
   private java.util.Date[] T005S6_A1883CliUpdDTApl ;
   private String[] T005S6_A1884CliUpdRelDesc ;
   private java.util.Date[] T005S6_A1962CliUpdFecRel ;
   private boolean[] T005S6_A1964CliUpdRelHab ;
   private boolean[] T005S6_A1963CliUpdNotificado ;
   private int[] T005S6_A3CliCod ;
   private int[] T005S6_A1881CliUpdCliCod ;
   private int[] T005S6_A1887CliUpdRelSec ;
   private int[] T005S4_A3CliCod ;
   private int[] T005S7_A3CliCod ;
   private java.util.Date[] T005S8_A1962CliUpdFecRel ;
   private boolean[] T005S8_A1964CliUpdRelHab ;
   private int[] T005S9_A3CliCod ;
   private int[] T005S9_A1881CliUpdCliCod ;
   private int[] T005S9_A1887CliUpdRelSec ;
   private java.util.Date[] T005S3_A1883CliUpdDTApl ;
   private String[] T005S3_A1884CliUpdRelDesc ;
   private boolean[] T005S3_A1963CliUpdNotificado ;
   private int[] T005S3_A3CliCod ;
   private int[] T005S3_A1881CliUpdCliCod ;
   private int[] T005S3_A1887CliUpdRelSec ;
   private java.util.Date[] T005S3_A1962CliUpdFecRel ;
   private int[] T005S10_A3CliCod ;
   private int[] T005S10_A1881CliUpdCliCod ;
   private int[] T005S10_A1887CliUpdRelSec ;
   private int[] T005S11_A3CliCod ;
   private int[] T005S11_A1881CliUpdCliCod ;
   private int[] T005S11_A1887CliUpdRelSec ;
   private java.util.Date[] T005S2_A1883CliUpdDTApl ;
   private String[] T005S2_A1884CliUpdRelDesc ;
   private boolean[] T005S2_A1963CliUpdNotificado ;
   private int[] T005S2_A3CliCod ;
   private int[] T005S2_A1881CliUpdCliCod ;
   private int[] T005S2_A1887CliUpdRelSec ;
   private java.util.Date[] T005S2_A1962CliUpdFecRel ;
   private java.util.Date[] T005S15_A1962CliUpdFecRel ;
   private boolean[] T005S15_A1964CliUpdRelHab ;
   private int[] T005S16_A3CliCod ;
   private int[] T005S16_A1881CliUpdCliCod ;
   private int[] T005S16_A1887CliUpdRelSec ;
   private int[] T005S17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16CliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22CliUpdCliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV26CliUpdRelSec_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class cliente_update__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005S2", "SELECT CliUpdDTApl, CliUpdRelDesc, CliUpdNotificado, CliCod, CliUpdCliCod, CliUpdRelSec, CliUpdFecRel FROM Cliente_Update WHERE CliCod = ? AND CliUpdCliCod = ? AND CliUpdRelSec = ?  FOR UPDATE OF Cliente_Update NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S3", "SELECT CliUpdDTApl, CliUpdRelDesc, CliUpdNotificado, CliCod, CliUpdCliCod, CliUpdRelSec, CliUpdFecRel FROM Cliente_Update WHERE CliCod = ? AND CliUpdCliCod = ? AND CliUpdRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S5", "SELECT CliRelease AS CliUpdFecRel, CliReHabilitado AS CliUpdRelHab FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S6", "SELECT TM1.CliUpdDTApl, TM1.CliUpdRelDesc, TM1.CliUpdFecRel AS CliUpdFecRel, T2.CliReHabilitado AS CliUpdRelHab, TM1.CliUpdNotificado, TM1.CliCod, TM1.CliUpdCliCod AS CliUpdCliCod, TM1.CliUpdRelSec AS CliUpdRelSec FROM (Cliente_Update TM1 INNER JOIN Cliente_Release T2 ON T2.CliCod = TM1.CliUpdCliCod AND T2.CliRelSec = TM1.CliUpdRelSec) WHERE TM1.CliCod = ? and TM1.CliUpdCliCod = ? and TM1.CliUpdRelSec = ? ORDER BY TM1.CliCod, TM1.CliUpdCliCod, TM1.CliUpdRelSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S7", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S8", "SELECT CliRelease AS CliUpdFecRel, CliReHabilitado AS CliUpdRelHab FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S9", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE CliCod = ? AND CliUpdCliCod = ? AND CliUpdRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S10", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE ( CliCod > ? or CliCod = ? and CliUpdCliCod > ? or CliUpdCliCod = ? and CliCod = ? and CliUpdRelSec > ?) ORDER BY CliCod, CliUpdCliCod, CliUpdRelSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005S11", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE ( CliCod < ? or CliCod = ? and CliUpdCliCod < ? or CliUpdCliCod = ? and CliCod = ? and CliUpdRelSec < ?) ORDER BY CliCod DESC, CliUpdCliCod DESC, CliUpdRelSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005S12", "SAVEPOINT gxupdate;INSERT INTO Cliente_Update(CliUpdFecRel, CliUpdDTApl, CliUpdRelDesc, CliUpdNotificado, CliCod, CliUpdCliCod, CliUpdRelSec) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005S13", "SAVEPOINT gxupdate;UPDATE Cliente_Update SET CliUpdFecRel=?, CliUpdDTApl=?, CliUpdRelDesc=?, CliUpdNotificado=?  WHERE CliCod = ? AND CliUpdCliCod = ? AND CliUpdRelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005S14", "SAVEPOINT gxupdate;DELETE FROM Cliente_Update  WHERE CliCod = ? AND CliUpdCliCod = ? AND CliUpdRelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005S15", "SELECT CliRelease AS CliUpdFecRel, CliReHabilitado AS CliUpdRelHab FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S16", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update ORDER BY CliCod, CliUpdCliCod, CliUpdRelSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005S17", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 11 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

