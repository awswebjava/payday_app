package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptomotivosegreso_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
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
         gxload_17( A3CliCod, A26ConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A3CliCod, A11MegCodigo) ;
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
            AV27ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ConCodigo", AV27ConCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27ConCodigo, ""))));
            AV9MegCodigo = httpContext.GetPar( "MegCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9MegCodigo", AV9MegCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9MegCodigo, ""))));
            AV30ConMegSec = (short)(GXutil.lval( httpContext.GetPar( "ConMegSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30ConMegSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONMEGSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30ConMegSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Concepto Motivos Egreso", ""), (short)(0)) ;
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

   public conceptomotivosegreso_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptomotivosegreso_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptomotivosegreso_impl.class ));
   }

   public conceptomotivosegreso_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbMegPreaTipo = new HTMLChoice();
      cmbConMegDura = new HTMLChoice();
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
      if ( cmbMegPreaTipo.getItemCount() > 0 )
      {
         A1532MegPreaTipo = cmbMegPreaTipo.getValidValue(A1532MegPreaTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMegPreaTipo.setValue( GXutil.rtrim( A1532MegPreaTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Values", cmbMegPreaTipo.ToJavascriptSource(), true);
      }
      if ( cmbConMegDura.getItemCount() > 0 )
      {
         A1534ConMegDura = cmbConMegDura.getValidValue(A1534ConMegDura) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConMegDura.setValue( GXutil.rtrim( A1534ConMegDura) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Values", cmbConMegDura.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV18CliCod_Data);
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoMotivosEgreso.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmegcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmegcodigo_Internalname, httpContext.getMessage( "Motivo Egreso", ""), "", "", lblTextblockmegcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_megcodigo.setProperty("Caption", Combo_megcodigo_Caption);
      ucCombo_megcodigo.setProperty("Cls", Combo_megcodigo_Cls);
      ucCombo_megcodigo.setProperty("DataListProc", Combo_megcodigo_Datalistproc);
      ucCombo_megcodigo.setProperty("EmptyItem", Combo_megcodigo_Emptyitem);
      ucCombo_megcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_megcodigo.setProperty("DropDownOptionsData", AV24MegCodigo_Data);
      ucCombo_megcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_megcodigo_Internalname, "COMBO_MEGCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMegCodigo_Internalname, httpContext.getMessage( "Motivo Egreso", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMegCodigo_Internalname, GXutil.rtrim( A11MegCodigo), GXutil.rtrim( localUtil.format( A11MegCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMegCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtMegCodigo_Visible, edtMegCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_ConceptoMotivosEgreso.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbMegPreaTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMegPreaTipo.getInternalname(), httpContext.getMessage( "Preaviso", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMegPreaTipo, cmbMegPreaTipo.getInternalname(), GXutil.rtrim( A1532MegPreaTipo), 1, cmbMegPreaTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbMegPreaTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_ConceptoMotivosEgreso.htm");
      cmbMegPreaTipo.setValue( GXutil.rtrim( A1532MegPreaTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Values", cmbMegPreaTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConMegMeses_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConMegMeses_Internalname, httpContext.getMessage( "Con antiguedad mayor a", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConMegMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConMegMeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1530ConMegMeses), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1530ConMegMeses), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConMegMeses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConMegMeses_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConMegDura.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConMegDura.getInternalname(), httpContext.getMessage( "meses o años", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConMegDura, cmbConMegDura.getInternalname(), GXutil.rtrim( A1534ConMegDura), 1, cmbConMegDura.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConMegDura.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_ConceptoMotivosEgreso.htm");
      cmbConMegDura.setValue( GXutil.rtrim( A1534ConMegDura) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Values", cmbConMegDura.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConMegPropor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConMegPropor_Internalname, httpContext.getMessage( "Proporción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConMegPropor_Internalname, GXutil.ltrim( localUtil.ntoc( A1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConMegPropor_Enabled!=0) ? localUtil.format( A1529ConMegPropor, "9.9999") : localUtil.format( A1529ConMegPropor, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConMegPropor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConMegPropor_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ConceptoMotivosEgreso.htm");
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconcodigo_Internalname, httpContext.getMessage( "Código", ""), "", "", lblTextblockconcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_concodigo.setProperty("Caption", Combo_concodigo_Caption);
      ucCombo_concodigo.setProperty("Cls", Combo_concodigo_Cls);
      ucCombo_concodigo.setProperty("DataListProc", Combo_concodigo_Datalistproc);
      ucCombo_concodigo.setProperty("EmptyItem", Combo_concodigo_Emptyitem);
      ucCombo_concodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_concodigo.setProperty("DropDownOptionsData", AV28ConCodigo_Data);
      ucCombo_concodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concodigo_Internalname, "COMBO_CONCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtConCodigo_Visible, edtConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoMotivosEgreso.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_megcodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomegcodigo_Internalname, GXutil.rtrim( AV25ComboMegCodigo), GXutil.rtrim( localUtil.format( AV25ComboMegCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomegcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomegcodigo_Visible, edtavCombomegcodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoMotivosEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_concodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboconcodigo_Internalname, GXutil.rtrim( AV29ComboConCodigo), GXutil.rtrim( localUtil.format( AV29ComboConCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboconcodigo_Visible, edtavComboconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoMotivosEgreso.htm");
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
      e11582 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV18CliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEGCODIGO_DATA"), AV24MegCodigo_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONCODIGO_DATA"), AV28ConCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
            Z11MegCodigo = httpContext.cgiGet( "Z11MegCodigo") ;
            Z2077ConMegSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z2077ConMegSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1532MegPreaTipo = httpContext.cgiGet( "Z1532MegPreaTipo") ;
            Z1530ConMegMeses = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1530ConMegMeses"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1534ConMegDura = httpContext.cgiGet( "Z1534ConMegDura") ;
            Z1529ConMegPropor = localUtil.ctond( httpContext.cgiGet( "Z1529ConMegPropor")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV26Cond_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV27ConCodigo = httpContext.cgiGet( "vCONCODIGO") ;
            AV9MegCodigo = httpContext.cgiGet( "vMEGCODIGO") ;
            AV30ConMegSec = (short)(localUtil.ctol( httpContext.cgiGet( "vCONMEGSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2077ConMegSec = (short)(localUtil.ctol( httpContext.cgiGet( "CONMEGSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
            n42ConCodYDesc = false ;
            A41ConDescrip = httpContext.cgiGet( "CONDESCRIP") ;
            AV35Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_megcodigo_Objectcall = httpContext.cgiGet( "COMBO_MEGCODIGO_Objectcall") ;
            Combo_megcodigo_Class = httpContext.cgiGet( "COMBO_MEGCODIGO_Class") ;
            Combo_megcodigo_Icontype = httpContext.cgiGet( "COMBO_MEGCODIGO_Icontype") ;
            Combo_megcodigo_Icon = httpContext.cgiGet( "COMBO_MEGCODIGO_Icon") ;
            Combo_megcodigo_Caption = httpContext.cgiGet( "COMBO_MEGCODIGO_Caption") ;
            Combo_megcodigo_Tooltip = httpContext.cgiGet( "COMBO_MEGCODIGO_Tooltip") ;
            Combo_megcodigo_Cls = httpContext.cgiGet( "COMBO_MEGCODIGO_Cls") ;
            Combo_megcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_set") ;
            Combo_megcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_get") ;
            Combo_megcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_set") ;
            Combo_megcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_get") ;
            Combo_megcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_MEGCODIGO_Gamoauthtoken") ;
            Combo_megcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_MEGCODIGO_Ddointernalname") ;
            Combo_megcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolalign") ;
            Combo_megcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MEGCODIGO_Dropdownoptionstype") ;
            Combo_megcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Enabled")) ;
            Combo_megcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Visible")) ;
            Combo_megcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolidtoreplace") ;
            Combo_megcodigo_Datalisttype = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalisttype") ;
            Combo_megcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Allowmultipleselection")) ;
            Combo_megcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistfixedvalues") ;
            Combo_megcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Isgriditem")) ;
            Combo_megcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Hasdescription")) ;
            Combo_megcodigo_Datalistproc = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistproc") ;
            Combo_megcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistprocparametersprefix") ;
            Combo_megcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MEGCODIGO_Remoteservicesparameters") ;
            Combo_megcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_megcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeonlyselectedoption")) ;
            Combo_megcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeselectalloption")) ;
            Combo_megcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitem")) ;
            Combo_megcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeaddnewoption")) ;
            Combo_megcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_MEGCODIGO_Htmltemplate") ;
            Combo_megcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluestype") ;
            Combo_megcodigo_Loadingdata = httpContext.cgiGet( "COMBO_MEGCODIGO_Loadingdata") ;
            Combo_megcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_MEGCODIGO_Noresultsfound") ;
            Combo_megcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitemtext") ;
            Combo_megcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Onlyselectedvalues") ;
            Combo_megcodigo_Selectalltext = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectalltext") ;
            Combo_megcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluesseparator") ;
            Combo_megcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_MEGCODIGO_Addnewoptiontext") ;
            Combo_megcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A11MegCodigo = httpContext.cgiGet( edtMegCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            cmbMegPreaTipo.setValue( httpContext.cgiGet( cmbMegPreaTipo.getInternalname()) );
            A1532MegPreaTipo = httpContext.cgiGet( cmbMegPreaTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONMEGMESES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConMegMeses_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1530ConMegMeses = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1530ConMegMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1530ConMegMeses), 2, 0));
            }
            else
            {
               A1530ConMegMeses = (byte)(localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1530ConMegMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1530ConMegMeses), 2, 0));
            }
            cmbConMegDura.setValue( httpContext.cgiGet( cmbConMegDura.getInternalname()) );
            A1534ConMegDura = httpContext.cgiGet( cmbConMegDura.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConMegPropor_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConMegPropor_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONMEGPROPOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConMegPropor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1529ConMegPropor = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
            }
            else
            {
               A1529ConMegPropor = localUtil.ctond( httpContext.cgiGet( edtConMegPropor_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
            }
            A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            AV23ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliCod), 6, 0));
            AV25ComboMegCodigo = httpContext.cgiGet( edtavCombomegcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegCodigo", AV25ComboMegCodigo);
            AV29ComboConCodigo = httpContext.cgiGet( edtavComboconcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29ComboConCodigo", AV29ComboConCodigo);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoMotivosEgreso");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("conceptomotivosegreso:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
               A2077ConMegSec = (short)(GXutil.lval( httpContext.GetPar( "ConMegSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2077ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2077ConMegSec), 4, 0));
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
                  sMode261 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode261 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound261 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_580( ) ;
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
                        e11582 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12582 ();
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
         e12582 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll58261( ) ;
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
         disableAttributes58261( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
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

   public void confirm_580( )
   {
      beforeValidate58261( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls58261( ) ;
         }
         else
         {
            checkExtendedTable58261( ) ;
            closeExtendedTableCursors58261( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption580( )
   {
   }

   public void e11582( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV13WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV13WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), true);
      AV29ComboConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29ComboConCodigo", AV29ComboConCodigo);
      edtavComboconcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Visible), 5, 0), true);
      edtMegCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Visible), 5, 0), true);
      AV25ComboMegCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegCodigo", AV25ComboMegCodigo);
      edtavCombomegcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV23ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliCod), 6, 0));
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
      /* Execute user subroutine: 'LOADCOMBOMEGCODIGO' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV14IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso_Insert", GXv_boolean5) ;
         conceptomotivosegreso_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV14IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV14IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso_Update", GXv_boolean5) ;
         conceptomotivosegreso_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV14IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV14IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso_Delete", GXv_boolean5) ;
         conceptomotivosegreso_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV14IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( ! AV14IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV35Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV16TrnContext.fromxml(AV17WebSession.getValue("TrnContext"), null, null);
   }

   public void e12582( )
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
      /* 'LOADCOMBOCONCODIGO' Routine */
      returnInSub = false ;
      Combo_concodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ConCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"MegCodigo\": \"\", \"ConMegSec\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "DataListProcParametersPrefix", Combo_concodigo_Datalistprocparametersprefix);
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.conceptomotivosegresoloaddvcombo(remoteHandle, context).execute( "ConCodigo", Gx_mode, false, AV7CliCod, AV27ConCodigo, AV9MegCodigo, AV30ConMegSec, A3CliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      conceptomotivosegreso_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      conceptomotivosegreso_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      conceptomotivosegreso_impl.this.GXt_char6 = GXv_char9[0] ;
      AV22Combo_DataJson = GXt_char6 ;
      Combo_concodigo_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
      Combo_concodigo_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedText_set", Combo_concodigo_Selectedtext_set);
      AV29ComboConCodigo = AV20ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29ComboConCodigo", AV29ComboConCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV27ConCodigo)==0) )
      {
         Combo_concodigo_Enabled = false ;
         ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOMEGCODIGO' Routine */
      returnInSub = false ;
      Combo_megcodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"MegCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"MegCodigo\": \"\", \"ConMegSec\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "DataListProcParametersPrefix", Combo_megcodigo_Datalistprocparametersprefix);
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptomotivosegresoloaddvcombo(remoteHandle, context).execute( "MegCodigo", Gx_mode, false, AV7CliCod, AV27ConCodigo, AV9MegCodigo, AV30ConMegSec, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptomotivosegreso_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      conceptomotivosegreso_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      conceptomotivosegreso_impl.this.GXt_char6 = GXv_char7[0] ;
      AV22Combo_DataJson = GXt_char6 ;
      Combo_megcodigo_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "SelectedValue_set", Combo_megcodigo_Selectedvalue_set);
      Combo_megcodigo_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "SelectedText_set", Combo_megcodigo_Selectedtext_set);
      AV25ComboMegCodigo = AV20ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegCodigo", AV25ComboMegCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9MegCodigo)==0) )
      {
         Combo_megcodigo_Enabled = false ;
         ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_megcodigo_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptomotivosegresoloaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV27ConCodigo, AV9MegCodigo, AV30ConMegSec, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptomotivosegreso_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      conceptomotivosegreso_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      conceptomotivosegreso_impl.this.GXt_char6 = GXv_char7[0] ;
      AV22Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV23ComboCliCod = (int)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm58261( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1532MegPreaTipo = T00583_A1532MegPreaTipo[0] ;
            Z1530ConMegMeses = T00583_A1530ConMegMeses[0] ;
            Z1534ConMegDura = T00583_A1534ConMegDura[0] ;
            Z1529ConMegPropor = T00583_A1529ConMegPropor[0] ;
         }
         else
         {
            Z1532MegPreaTipo = A1532MegPreaTipo ;
            Z1530ConMegMeses = A1530ConMegMeses ;
            Z1534ConMegDura = A1534ConMegDura ;
            Z1529ConMegPropor = A1529ConMegPropor ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z2077ConMegSec = A2077ConMegSec ;
         Z1532MegPreaTipo = A1532MegPreaTipo ;
         Z1530ConMegMeses = A1530ConMegMeses ;
         Z1534ConMegDura = A1534ConMegDura ;
         Z1529ConMegPropor = A1529ConMegPropor ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
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
      if ( ! (GXutil.strcmp("", AV27ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV27ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtMegCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      if ( ! (0==AV30ConMegSec) )
      {
         A2077ConMegSec = AV30ConMegSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2077ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2077ConMegSec), 4, 0));
      }
      if ( ! (GXutil.strcmp("", AV27ConCodigo)==0) )
      {
         A26ConCodigo = AV27ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      else
      {
         A26ConCodigo = AV29ComboConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      if ( ! (GXutil.strcmp("", AV9MegCodigo)==0) )
      {
         A11MegCodigo = AV9MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      else
      {
         A11MegCodigo = AV25ComboMegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV23ComboCliCod ;
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
         AV35Pgmname = "ConceptoMotivosEgreso" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
         /* Using cursor T00585 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T00585_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T00585_n42ConCodYDesc[0] ;
         A41ConDescrip = T00585_A41ConDescrip[0] ;
         A41ConDescrip = T00585_A41ConDescrip[0] ;
         pr_default.close(3);
      }
   }

   public void load58261( )
   {
      /* Using cursor T00586 */
      pr_default.execute(4, new Object[] {Short.valueOf(A2077ConMegSec), Integer.valueOf(A3CliCod), A11MegCodigo, A26ConCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A42ConCodYDesc = T00586_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T00586_n42ConCodYDesc[0] ;
         A1532MegPreaTipo = T00586_A1532MegPreaTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
         A1530ConMegMeses = T00586_A1530ConMegMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1530ConMegMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1530ConMegMeses), 2, 0));
         A1534ConMegDura = T00586_A1534ConMegDura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
         A1529ConMegPropor = T00586_A1529ConMegPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
         A41ConDescrip = T00586_A41ConDescrip[0] ;
         zm58261( -14) ;
      }
      pr_default.close(4);
      onLoadActions58261( ) ;
   }

   public void onLoadActions58261( )
   {
      AV35Pgmname = "ConceptoMotivosEgreso" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
   }

   public void checkExtendedTable58261( )
   {
      nIsDirty_261 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV35Pgmname = "ConceptoMotivosEgreso" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
      /* Using cursor T00585 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T00585_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T00585_n42ConCodYDesc[0] ;
      A41ConDescrip = T00585_A41ConDescrip[0] ;
      A41ConDescrip = T00585_A41ConDescrip[0] ;
      pr_default.close(3);
      /* Using cursor T00584 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1532MegPreaTipo, "CON") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "SIN") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Preaviso", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "MEGPREATIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMegPreaTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1534ConMegDura, "años") == 0 ) || ( GXutil.strcmp(A1534ConMegDura, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "meses o años", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONMEGDURA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConMegDura.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00587 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Código", "")+","+httpContext.getMessage( "Motivo Egreso", "")+","+httpContext.getMessage( "Preaviso", "")+","+httpContext.getMessage( "Con antiguedad mayor a", "")+","+httpContext.getMessage( "meses o años", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
   }

   public void closeExtendedTableCursors58261( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( int A3CliCod ,
                          String A26ConCodigo )
   {
      /* Using cursor T00588 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T00588_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T00588_n42ConCodYDesc[0] ;
      A41ConDescrip = T00588_A41ConDescrip[0] ;
      A41ConDescrip = T00588_A41ConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A42ConCodYDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_16( int A3CliCod ,
                          String A11MegCodigo )
   {
      /* Using cursor T00589 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void getKey58261( )
   {
      /* Using cursor T005810 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound261 = (short)(1) ;
      }
      else
      {
         RcdFound261 = (short)(0) ;
      }
      pr_default.close(8);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00583 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm58261( 14) ;
         RcdFound261 = (short)(1) ;
         A2077ConMegSec = T00583_A2077ConMegSec[0] ;
         A1532MegPreaTipo = T00583_A1532MegPreaTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
         A1530ConMegMeses = T00583_A1530ConMegMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1530ConMegMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1530ConMegMeses), 2, 0));
         A1534ConMegDura = T00583_A1534ConMegDura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
         A1529ConMegPropor = T00583_A1529ConMegPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
         A3CliCod = T00583_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T00583_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A26ConCodigo = T00583_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z11MegCodigo = A11MegCodigo ;
         Z2077ConMegSec = A2077ConMegSec ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load58261( ) ;
         if ( AnyError == 1 )
         {
            RcdFound261 = (short)(0) ;
            initializeNonKey58261( ) ;
         }
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound261 = (short)(0) ;
         initializeNonKey58261( ) ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey58261( ) ;
      if ( RcdFound261 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound261 = (short)(0) ;
      /* Using cursor T005811 */
      pr_default.execute(9, new Object[] {Short.valueOf(A2077ConMegSec), Short.valueOf(A2077ConMegSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A2077ConMegSec), A11MegCodigo, A11MegCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A2077ConMegSec), A26ConCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005811_A2077ConMegSec[0] < A2077ConMegSec ) || ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( T005811_A3CliCod[0] < A3CliCod ) || ( T005811_A3CliCod[0] == A3CliCod ) && ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005811_A11MegCodigo[0], A11MegCodigo) < 0 ) || ( GXutil.strcmp(T005811_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005811_A3CliCod[0] == A3CliCod ) && ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005811_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005811_A2077ConMegSec[0] > A2077ConMegSec ) || ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( T005811_A3CliCod[0] > A3CliCod ) || ( T005811_A3CliCod[0] == A3CliCod ) && ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005811_A11MegCodigo[0], A11MegCodigo) > 0 ) || ( GXutil.strcmp(T005811_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005811_A3CliCod[0] == A3CliCod ) && ( T005811_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005811_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A2077ConMegSec = T005811_A2077ConMegSec[0] ;
            A3CliCod = T005811_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T005811_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            A26ConCodigo = T005811_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound261 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void move_previous( )
   {
      RcdFound261 = (short)(0) ;
      /* Using cursor T005812 */
      pr_default.execute(10, new Object[] {Short.valueOf(A2077ConMegSec), Short.valueOf(A2077ConMegSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A2077ConMegSec), A11MegCodigo, A11MegCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A2077ConMegSec), A26ConCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T005812_A2077ConMegSec[0] > A2077ConMegSec ) || ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( T005812_A3CliCod[0] > A3CliCod ) || ( T005812_A3CliCod[0] == A3CliCod ) && ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005812_A11MegCodigo[0], A11MegCodigo) > 0 ) || ( GXutil.strcmp(T005812_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005812_A3CliCod[0] == A3CliCod ) && ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005812_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T005812_A2077ConMegSec[0] < A2077ConMegSec ) || ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( T005812_A3CliCod[0] < A3CliCod ) || ( T005812_A3CliCod[0] == A3CliCod ) && ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005812_A11MegCodigo[0], A11MegCodigo) < 0 ) || ( GXutil.strcmp(T005812_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005812_A3CliCod[0] == A3CliCod ) && ( T005812_A2077ConMegSec[0] == A2077ConMegSec ) && ( GXutil.strcmp(T005812_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A2077ConMegSec = T005812_A2077ConMegSec[0] ;
            A3CliCod = T005812_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T005812_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            A26ConCodigo = T005812_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound261 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey58261( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert58261( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound261 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A2077ConMegSec != Z2077ConMegSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A26ConCodigo = Z26ConCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               A11MegCodigo = Z11MegCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
               A2077ConMegSec = Z2077ConMegSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A2077ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2077ConMegSec), 4, 0));
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
               update58261( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A2077ConMegSec != Z2077ConMegSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert58261( ) ;
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
                  insert58261( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A2077ConMegSec != Z2077ConMegSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = Z26ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A11MegCodigo = Z11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A2077ConMegSec = Z2077ConMegSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2077ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2077ConMegSec), 4, 0));
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

   public void checkOptimisticConcurrency58261( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00582 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1532MegPreaTipo, T00582_A1532MegPreaTipo[0]) != 0 ) || ( Z1530ConMegMeses != T00582_A1530ConMegMeses[0] ) || ( GXutil.strcmp(Z1534ConMegDura, T00582_A1534ConMegDura[0]) != 0 ) || ( DecimalUtil.compareTo(Z1529ConMegPropor, T00582_A1529ConMegPropor[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1532MegPreaTipo, T00582_A1532MegPreaTipo[0]) != 0 )
            {
               GXutil.writeLogln("conceptomotivosegreso:[seudo value changed for attri]"+"MegPreaTipo");
               GXutil.writeLogRaw("Old: ",Z1532MegPreaTipo);
               GXutil.writeLogRaw("Current: ",T00582_A1532MegPreaTipo[0]);
            }
            if ( Z1530ConMegMeses != T00582_A1530ConMegMeses[0] )
            {
               GXutil.writeLogln("conceptomotivosegreso:[seudo value changed for attri]"+"ConMegMeses");
               GXutil.writeLogRaw("Old: ",Z1530ConMegMeses);
               GXutil.writeLogRaw("Current: ",T00582_A1530ConMegMeses[0]);
            }
            if ( GXutil.strcmp(Z1534ConMegDura, T00582_A1534ConMegDura[0]) != 0 )
            {
               GXutil.writeLogln("conceptomotivosegreso:[seudo value changed for attri]"+"ConMegDura");
               GXutil.writeLogRaw("Old: ",Z1534ConMegDura);
               GXutil.writeLogRaw("Current: ",T00582_A1534ConMegDura[0]);
            }
            if ( DecimalUtil.compareTo(Z1529ConMegPropor, T00582_A1529ConMegPropor[0]) != 0 )
            {
               GXutil.writeLogln("conceptomotivosegreso:[seudo value changed for attri]"+"ConMegPropor");
               GXutil.writeLogRaw("Old: ",Z1529ConMegPropor);
               GXutil.writeLogRaw("Current: ",T00582_A1529ConMegPropor[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoMotivosEgreso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert58261( )
   {
      beforeValidate58261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable58261( ) ;
      }
      if ( AnyError == 0 )
      {
         zm58261( 0) ;
         checkOptimisticConcurrency58261( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm58261( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert58261( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005813 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A11MegCodigo, A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                  if ( (pr_default.getStatus(11) == 1) )
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
                        resetCaption580( ) ;
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
            load58261( ) ;
         }
         endLevel58261( ) ;
      }
      closeExtendedTableCursors58261( ) ;
   }

   public void update58261( )
   {
      beforeValidate58261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable58261( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency58261( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm58261( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate58261( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005814 */
                  pr_default.execute(12, new Object[] {A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate58261( ) ;
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
         endLevel58261( ) ;
      }
      closeExtendedTableCursors58261( ) ;
   }

   public void deferredUpdate58261( )
   {
   }

   public void delete( )
   {
      beforeValidate58261( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency58261( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls58261( ) ;
         afterConfirm58261( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete58261( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005815 */
               pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
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
      sMode261 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel58261( ) ;
      Gx_mode = sMode261 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls58261( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV35Pgmname = "ConceptoMotivosEgreso" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
         /* Using cursor T005816 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T005816_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T005816_n42ConCodYDesc[0] ;
         A41ConDescrip = T005816_A41ConDescrip[0] ;
         A41ConDescrip = T005816_A41ConDescrip[0] ;
         pr_default.close(14);
      }
   }

   public void endLevel58261( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete58261( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptomotivosegreso");
         if ( AnyError == 0 )
         {
            confirmValues580( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "conceptomotivosegreso");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart58261( )
   {
      /* Scan By routine */
      /* Using cursor T005817 */
      pr_default.execute(15);
      RcdFound261 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A3CliCod = T005817_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005817_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A11MegCodigo = T005817_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A2077ConMegSec = T005817_A2077ConMegSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext58261( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound261 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A3CliCod = T005817_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005817_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A11MegCodigo = T005817_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A2077ConMegSec = T005817_A2077ConMegSec[0] ;
      }
   }

   public void scanEnd58261( )
   {
      pr_default.close(15);
   }

   public void afterConfirm58261( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert58261( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate58261( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete58261( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete58261( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate58261( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes58261( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtMegCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      cmbMegPreaTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMegPreaTipo.getEnabled(), 5, 0), true);
      edtConMegMeses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConMegMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegMeses_Enabled), 5, 0), true);
      cmbConMegDura.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConMegDura.getEnabled(), 5, 0), true);
      edtConMegPropor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConMegPropor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegPropor_Enabled), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      edtavCombomegcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Enabled), 5, 0), true);
      edtavComboconcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes58261( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues580( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptomotivosegreso", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV27ConCodigo)),GXutil.URLEncode(GXutil.rtrim(AV9MegCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV30ConMegSec,4,0))}, new String[] {"Gx_mode","CliCod","ConCodigo","MegCodigo","ConMegSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoMotivosEgreso");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptomotivosegreso:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z11MegCodigo", GXutil.rtrim( Z11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2077ConMegSec", GXutil.ltrim( localUtil.ntoc( Z2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1532MegPreaTipo", GXutil.rtrim( Z1532MegPreaTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1530ConMegMeses", GXutil.ltrim( localUtil.ntoc( Z1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1534ConMegDura", GXutil.rtrim( Z1534ConMegDura));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1529ConMegPropor", GXutil.ltrim( localUtil.ntoc( Z1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV18CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV18CliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEGCODIGO_DATA", AV24MegCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEGCODIGO_DATA", AV24MegCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONCODIGO_DATA", AV28ConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONCODIGO_DATA", AV28ConCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLICOD", GXutil.ltrim( localUtil.ntoc( AV26Cond_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV27ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMEGCODIGO", GXutil.rtrim( AV9MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9MegCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONMEGSEC", GXutil.ltrim( localUtil.ntoc( AV30ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONMEGSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30ConMegSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONMEGSEC", GXutil.ltrim( localUtil.ntoc( A2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDESCRIP", A41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV35Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Objectcall", GXutil.rtrim( Combo_megcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Cls", GXutil.rtrim( Combo_megcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_megcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Selectedtext_set", GXutil.rtrim( Combo_megcodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Enabled", GXutil.booltostr( Combo_megcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistproc", GXutil.rtrim( Combo_megcodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_megcodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Emptyitem", GXutil.booltostr( Combo_megcodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Objectcall", GXutil.rtrim( Combo_concodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Cls", GXutil.rtrim( Combo_concodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_concodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Selectedtext_set", GXutil.rtrim( Combo_concodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Datalistproc", GXutil.rtrim( Combo_concodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_concodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Emptyitem", GXutil.booltostr( Combo_concodigo_Emptyitem));
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
      return formatLink("web.conceptomotivosegreso", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV27ConCodigo)),GXutil.URLEncode(GXutil.rtrim(AV9MegCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV30ConMegSec,4,0))}, new String[] {"Gx_mode","CliCod","ConCodigo","MegCodigo","ConMegSec"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptoMotivosEgreso" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto Motivos Egreso", "") ;
   }

   public void initializeNonKey58261( )
   {
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      A1532MegPreaTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
      A1530ConMegMeses = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1530ConMegMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1530ConMegMeses), 2, 0));
      A1534ConMegDura = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
      A1529ConMegPropor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      Z1532MegPreaTipo = "" ;
      Z1530ConMegMeses = (byte)(0) ;
      Z1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
   }

   public void initAll58261( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      A11MegCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      A2077ConMegSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2077ConMegSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2077ConMegSec), 4, 0));
      initializeNonKey58261( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251816585238", true, true);
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
      httpContext.AddJavascriptSource("conceptomotivosegreso.js", "?20251816585238", false, true);
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
      lblTextblockmegcodigo_Internalname = "TEXTBLOCKMEGCODIGO" ;
      Combo_megcodigo_Internalname = "COMBO_MEGCODIGO" ;
      edtMegCodigo_Internalname = "MEGCODIGO" ;
      divTablesplittedmegcodigo_Internalname = "TABLESPLITTEDMEGCODIGO" ;
      cmbMegPreaTipo.setInternalname( "MEGPREATIPO" );
      edtConMegMeses_Internalname = "CONMEGMESES" ;
      cmbConMegDura.setInternalname( "CONMEGDURA" );
      edtConMegPropor_Internalname = "CONMEGPROPOR" ;
      lblTextblockconcodigo_Internalname = "TEXTBLOCKCONCODIGO" ;
      Combo_concodigo_Internalname = "COMBO_CONCODIGO" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      divTablesplittedconcodigo_Internalname = "TABLESPLITTEDCONCODIGO" ;
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
      edtavCombomegcodigo_Internalname = "vCOMBOMEGCODIGO" ;
      divSectionattribute_megcodigo_Internalname = "SECTIONATTRIBUTE_MEGCODIGO" ;
      edtavComboconcodigo_Internalname = "vCOMBOCONCODIGO" ;
      divSectionattribute_concodigo_Internalname = "SECTIONATTRIBUTE_CONCODIGO" ;
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
      Form.setCaption( httpContext.getMessage( "Concepto Motivos Egreso", "") );
      Combo_megcodigo_Datalistprocparametersprefix = "" ;
      Combo_concodigo_Datalistprocparametersprefix = "" ;
      edtavComboconcodigo_Jsonclick = "" ;
      edtavComboconcodigo_Enabled = 0 ;
      edtavComboconcodigo_Visible = 1 ;
      edtavCombomegcodigo_Jsonclick = "" ;
      edtavCombomegcodigo_Enabled = 0 ;
      edtavCombomegcodigo_Visible = 1 ;
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      edtConCodigo_Visible = 1 ;
      Combo_concodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_concodigo_Datalistproc = "ConceptoMotivosEgresoLoadDVCombo" ;
      Combo_concodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_concodigo_Caption = "" ;
      Combo_concodigo_Enabled = GXutil.toBoolean( -1) ;
      edtConMegPropor_Jsonclick = "" ;
      edtConMegPropor_Enabled = 1 ;
      cmbConMegDura.setJsonclick( "" );
      cmbConMegDura.setEnabled( 1 );
      edtConMegMeses_Jsonclick = "" ;
      edtConMegMeses_Enabled = 1 ;
      cmbMegPreaTipo.setJsonclick( "" );
      cmbMegPreaTipo.setEnabled( 1 );
      edtMegCodigo_Jsonclick = "" ;
      edtMegCodigo_Enabled = 1 ;
      edtMegCodigo_Visible = 1 ;
      Combo_megcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_megcodigo_Datalistproc = "ConceptoMotivosEgresoLoadDVCombo" ;
      Combo_megcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_megcodigo_Caption = "" ;
      Combo_megcodigo_Enabled = GXutil.toBoolean( -1) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"MegCodigo\": \"\", \"ConMegSec\": 0" ;
      Combo_clicod_Datalistproc = "ConceptoMotivosEgresoLoadDVCombo" ;
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
      cmbMegPreaTipo.setName( "MEGPREATIPO" );
      cmbMegPreaTipo.setWebtags( "" );
      cmbMegPreaTipo.addItem("CON", httpContext.getMessage( "Con preaviso", ""), (short)(0));
      cmbMegPreaTipo.addItem("SIN", httpContext.getMessage( "Sin preaviso", ""), (short)(0));
      cmbMegPreaTipo.addItem("", httpContext.getMessage( "Ambos (Con o sin preaviso)", ""), (short)(0));
      if ( cmbMegPreaTipo.getItemCount() > 0 )
      {
         A1532MegPreaTipo = cmbMegPreaTipo.getValidValue(A1532MegPreaTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1532MegPreaTipo", A1532MegPreaTipo);
      }
      cmbConMegDura.setName( "CONMEGDURA" );
      cmbConMegDura.setWebtags( "" );
      cmbConMegDura.addItem("años", httpContext.getMessage( "años", ""), (short)(0));
      cmbConMegDura.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbConMegDura.getItemCount() > 0 )
      {
         A1534ConMegDura = cmbConMegDura.getValidValue(A1534ConMegDura) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1534ConMegDura", A1534ConMegDura);
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

   public void valid_Megcodigo( )
   {
      /* Using cursor T005818 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Concodigo( )
   {
      n42ConCodYDesc = false ;
      /* Using cursor T005816 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A42ConCodYDesc = T005816_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T005816_n42ConCodYDesc[0] ;
      A41ConDescrip = T005816_A41ConDescrip[0] ;
      A41ConDescrip = T005816_A41ConDescrip[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
   }

   public void valid_Conmegdura( )
   {
      A1532MegPreaTipo = cmbMegPreaTipo.getValue() ;
      A1534ConMegDura = cmbConMegDura.getValue() ;
      /* Using cursor T005819 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Código", "")+","+httpContext.getMessage( "Motivo Egreso", "")+","+httpContext.getMessage( "Preaviso", "")+","+httpContext.getMessage( "Con antiguedad mayor a", "")+","+httpContext.getMessage( "meses o años", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(17);
      if ( ! ( ( GXutil.strcmp(A1534ConMegDura, "años") == 0 ) || ( GXutil.strcmp(A1534ConMegDura, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "meses o años", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONMEGDURA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConMegDura.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV27ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV9MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'AV30ConMegSec',fld:'vCONMEGSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV27ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV9MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'AV30ConMegSec',fld:'vCONMEGSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12582',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_MEGCODIGO","{handler:'valid_Megcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''}]");
      setEventMetadata("VALID_MEGCODIGO",",oparms:[]}");
      setEventMetadata("VALID_MEGPREATIPO","{handler:'valid_Megpreatipo',iparms:[]");
      setEventMetadata("VALID_MEGPREATIPO",",oparms:[]}");
      setEventMetadata("VALID_CONMEGMESES","{handler:'valid_Conmegmeses',iparms:[]");
      setEventMetadata("VALID_CONMEGMESES",",oparms:[]}");
      setEventMetadata("VALID_CONMEGDURA","{handler:'valid_Conmegdura',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'cmbMegPreaTipo'},{av:'A1532MegPreaTipo',fld:'MEGPREATIPO',pic:''},{av:'A1530ConMegMeses',fld:'CONMEGMESES',pic:'Z9'},{av:'cmbConMegDura'},{av:'A1534ConMegDura',fld:'CONMEGDURA',pic:''},{av:'A2077ConMegSec',fld:'CONMEGSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CONMEGDURA",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMEGCODIGO","{handler:'validv_Combomegcodigo',iparms:[]");
      setEventMetadata("VALIDV_COMBOMEGCODIGO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCONCODIGO","{handler:'validv_Comboconcodigo',iparms:[]");
      setEventMetadata("VALIDV_COMBOCONCODIGO",",oparms:[]}");
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
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV27ConCodigo = "" ;
      wcpOAV9MegCodigo = "" ;
      Z26ConCodigo = "" ;
      Z11MegCodigo = "" ;
      Z1532MegPreaTipo = "" ;
      Z1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
      Combo_concodigo_Selectedvalue_get = "" ;
      Combo_megcodigo_Selectedvalue_get = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A26ConCodigo = "" ;
      A11MegCodigo = "" ;
      Gx_mode = "" ;
      AV27ConCodigo = "" ;
      AV9MegCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV19DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV18CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockmegcodigo_Jsonclick = "" ;
      ucCombo_megcodigo = new com.genexus.webpanels.GXUserControl();
      AV24MegCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1529ConMegPropor = DecimalUtil.ZERO ;
      lblTextblockconcodigo_Jsonclick = "" ;
      ucCombo_concodigo = new com.genexus.webpanels.GXUserControl();
      AV28ConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV25ComboMegCodigo = "" ;
      AV29ComboConCodigo = "" ;
      A42ConCodYDesc = "" ;
      A41ConDescrip = "" ;
      AV35Pgmname = "" ;
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
      Combo_megcodigo_Objectcall = "" ;
      Combo_megcodigo_Class = "" ;
      Combo_megcodigo_Icontype = "" ;
      Combo_megcodigo_Icon = "" ;
      Combo_megcodigo_Tooltip = "" ;
      Combo_megcodigo_Selectedvalue_set = "" ;
      Combo_megcodigo_Selectedtext_set = "" ;
      Combo_megcodigo_Selectedtext_get = "" ;
      Combo_megcodigo_Gamoauthtoken = "" ;
      Combo_megcodigo_Ddointernalname = "" ;
      Combo_megcodigo_Titlecontrolalign = "" ;
      Combo_megcodigo_Dropdownoptionstype = "" ;
      Combo_megcodigo_Titlecontrolidtoreplace = "" ;
      Combo_megcodigo_Datalisttype = "" ;
      Combo_megcodigo_Datalistfixedvalues = "" ;
      Combo_megcodigo_Remoteservicesparameters = "" ;
      Combo_megcodigo_Htmltemplate = "" ;
      Combo_megcodigo_Multiplevaluestype = "" ;
      Combo_megcodigo_Loadingdata = "" ;
      Combo_megcodigo_Noresultsfound = "" ;
      Combo_megcodigo_Emptyitemtext = "" ;
      Combo_megcodigo_Onlyselectedvalues = "" ;
      Combo_megcodigo_Selectalltext = "" ;
      Combo_megcodigo_Multiplevaluesseparator = "" ;
      Combo_megcodigo_Addnewoptiontext = "" ;
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
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode261 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV13WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV16TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV17WebSession = httpContext.getWebSession();
      AV22Combo_DataJson = "" ;
      AV20ComboSelectedValue = "" ;
      AV21ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      T00585_A42ConCodYDesc = new String[] {""} ;
      T00585_n42ConCodYDesc = new boolean[] {false} ;
      T00585_A41ConDescrip = new String[] {""} ;
      T00586_A42ConCodYDesc = new String[] {""} ;
      T00586_n42ConCodYDesc = new boolean[] {false} ;
      T00586_A2077ConMegSec = new short[1] ;
      T00586_A1532MegPreaTipo = new String[] {""} ;
      T00586_A1530ConMegMeses = new byte[1] ;
      T00586_A1534ConMegDura = new String[] {""} ;
      T00586_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00586_A41ConDescrip = new String[] {""} ;
      T00586_A3CliCod = new int[1] ;
      T00586_A11MegCodigo = new String[] {""} ;
      T00586_A26ConCodigo = new String[] {""} ;
      T00584_A3CliCod = new int[1] ;
      T00587_A3CliCod = new int[1] ;
      T00588_A42ConCodYDesc = new String[] {""} ;
      T00588_n42ConCodYDesc = new boolean[] {false} ;
      T00588_A41ConDescrip = new String[] {""} ;
      T00589_A3CliCod = new int[1] ;
      T005810_A3CliCod = new int[1] ;
      T005810_A26ConCodigo = new String[] {""} ;
      T005810_A11MegCodigo = new String[] {""} ;
      T005810_A2077ConMegSec = new short[1] ;
      T00583_A2077ConMegSec = new short[1] ;
      T00583_A1532MegPreaTipo = new String[] {""} ;
      T00583_A1530ConMegMeses = new byte[1] ;
      T00583_A1534ConMegDura = new String[] {""} ;
      T00583_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00583_A3CliCod = new int[1] ;
      T00583_A11MegCodigo = new String[] {""} ;
      T00583_A26ConCodigo = new String[] {""} ;
      T005811_A2077ConMegSec = new short[1] ;
      T005811_A3CliCod = new int[1] ;
      T005811_A11MegCodigo = new String[] {""} ;
      T005811_A26ConCodigo = new String[] {""} ;
      T005812_A2077ConMegSec = new short[1] ;
      T005812_A3CliCod = new int[1] ;
      T005812_A11MegCodigo = new String[] {""} ;
      T005812_A26ConCodigo = new String[] {""} ;
      T00582_A2077ConMegSec = new short[1] ;
      T00582_A1532MegPreaTipo = new String[] {""} ;
      T00582_A1530ConMegMeses = new byte[1] ;
      T00582_A1534ConMegDura = new String[] {""} ;
      T00582_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00582_A3CliCod = new int[1] ;
      T00582_A11MegCodigo = new String[] {""} ;
      T00582_A26ConCodigo = new String[] {""} ;
      T005816_A42ConCodYDesc = new String[] {""} ;
      T005816_n42ConCodYDesc = new boolean[] {false} ;
      T005816_A41ConDescrip = new String[] {""} ;
      T005817_A3CliCod = new int[1] ;
      T005817_A26ConCodigo = new String[] {""} ;
      T005817_A11MegCodigo = new String[] {""} ;
      T005817_A2077ConMegSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005818_A3CliCod = new int[1] ;
      T005819_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptomotivosegreso__default(),
         new Object[] {
             new Object[] {
            T00582_A2077ConMegSec, T00582_A1532MegPreaTipo, T00582_A1530ConMegMeses, T00582_A1534ConMegDura, T00582_A1529ConMegPropor, T00582_A3CliCod, T00582_A11MegCodigo, T00582_A26ConCodigo
            }
            , new Object[] {
            T00583_A2077ConMegSec, T00583_A1532MegPreaTipo, T00583_A1530ConMegMeses, T00583_A1534ConMegDura, T00583_A1529ConMegPropor, T00583_A3CliCod, T00583_A11MegCodigo, T00583_A26ConCodigo
            }
            , new Object[] {
            T00584_A3CliCod
            }
            , new Object[] {
            T00585_A42ConCodYDesc, T00585_n42ConCodYDesc, T00585_A41ConDescrip
            }
            , new Object[] {
            T00586_A42ConCodYDesc, T00586_n42ConCodYDesc, T00586_A2077ConMegSec, T00586_A1532MegPreaTipo, T00586_A1530ConMegMeses, T00586_A1534ConMegDura, T00586_A1529ConMegPropor, T00586_A41ConDescrip, T00586_A3CliCod, T00586_A11MegCodigo,
            T00586_A26ConCodigo
            }
            , new Object[] {
            T00587_A3CliCod
            }
            , new Object[] {
            T00588_A42ConCodYDesc, T00588_n42ConCodYDesc, T00588_A41ConDescrip
            }
            , new Object[] {
            T00589_A3CliCod
            }
            , new Object[] {
            T005810_A3CliCod, T005810_A26ConCodigo, T005810_A11MegCodigo, T005810_A2077ConMegSec
            }
            , new Object[] {
            T005811_A2077ConMegSec, T005811_A3CliCod, T005811_A11MegCodigo, T005811_A26ConCodigo
            }
            , new Object[] {
            T005812_A2077ConMegSec, T005812_A3CliCod, T005812_A11MegCodigo, T005812_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005816_A42ConCodYDesc, T005816_n42ConCodYDesc, T005816_A41ConDescrip
            }
            , new Object[] {
            T005817_A3CliCod, T005817_A26ConCodigo, T005817_A11MegCodigo, T005817_A2077ConMegSec
            }
            , new Object[] {
            T005818_A3CliCod
            }
            , new Object[] {
            T005819_A3CliCod
            }
         }
      );
      AV35Pgmname = "ConceptoMotivosEgreso" ;
   }

   private byte Z1530ConMegMeses ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1530ConMegMeses ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV30ConMegSec ;
   private short Z2077ConMegSec ;
   private short AV30ConMegSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2077ConMegSec ;
   private short RcdFound261 ;
   private short nIsDirty_261 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtMegCodigo_Visible ;
   private int edtMegCodigo_Enabled ;
   private int edtConMegMeses_Enabled ;
   private int edtConMegPropor_Enabled ;
   private int edtConCodigo_Visible ;
   private int edtConCodigo_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV23ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int edtavCombomegcodigo_Visible ;
   private int edtavCombomegcodigo_Enabled ;
   private int edtavComboconcodigo_Visible ;
   private int edtavComboconcodigo_Enabled ;
   private int AV26Cond_CliCod ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Combo_clicod_Gxcontroltype ;
   private int Combo_megcodigo_Datalistupdateminimumcharacters ;
   private int Combo_megcodigo_Gxcontroltype ;
   private int Combo_concodigo_Datalistupdateminimumcharacters ;
   private int Combo_concodigo_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z1529ConMegPropor ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV27ConCodigo ;
   private String wcpOAV9MegCodigo ;
   private String Z26ConCodigo ;
   private String Z11MegCodigo ;
   private String Z1532MegPreaTipo ;
   private String Z1534ConMegDura ;
   private String Combo_concodigo_Selectedvalue_get ;
   private String Combo_megcodigo_Selectedvalue_get ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A26ConCodigo ;
   private String A11MegCodigo ;
   private String Gx_mode ;
   private String AV27ConCodigo ;
   private String AV9MegCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
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
   private String divTablesplittedmegcodigo_Internalname ;
   private String lblTextblockmegcodigo_Internalname ;
   private String lblTextblockmegcodigo_Jsonclick ;
   private String Combo_megcodigo_Caption ;
   private String Combo_megcodigo_Cls ;
   private String Combo_megcodigo_Datalistproc ;
   private String Combo_megcodigo_Internalname ;
   private String edtMegCodigo_Internalname ;
   private String edtMegCodigo_Jsonclick ;
   private String edtConMegMeses_Internalname ;
   private String edtConMegMeses_Jsonclick ;
   private String edtConMegPropor_Internalname ;
   private String edtConMegPropor_Jsonclick ;
   private String divTablesplittedconcodigo_Internalname ;
   private String lblTextblockconcodigo_Internalname ;
   private String lblTextblockconcodigo_Jsonclick ;
   private String Combo_concodigo_Caption ;
   private String Combo_concodigo_Cls ;
   private String Combo_concodigo_Datalistproc ;
   private String Combo_concodigo_Internalname ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
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
   private String divSectionattribute_megcodigo_Internalname ;
   private String edtavCombomegcodigo_Internalname ;
   private String AV25ComboMegCodigo ;
   private String edtavCombomegcodigo_Jsonclick ;
   private String divSectionattribute_concodigo_Internalname ;
   private String edtavComboconcodigo_Internalname ;
   private String AV29ComboConCodigo ;
   private String edtavComboconcodigo_Jsonclick ;
   private String AV35Pgmname ;
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
   private String Combo_megcodigo_Objectcall ;
   private String Combo_megcodigo_Class ;
   private String Combo_megcodigo_Icontype ;
   private String Combo_megcodigo_Icon ;
   private String Combo_megcodigo_Tooltip ;
   private String Combo_megcodigo_Selectedvalue_set ;
   private String Combo_megcodigo_Selectedtext_set ;
   private String Combo_megcodigo_Selectedtext_get ;
   private String Combo_megcodigo_Gamoauthtoken ;
   private String Combo_megcodigo_Ddointernalname ;
   private String Combo_megcodigo_Titlecontrolalign ;
   private String Combo_megcodigo_Dropdownoptionstype ;
   private String Combo_megcodigo_Titlecontrolidtoreplace ;
   private String Combo_megcodigo_Datalisttype ;
   private String Combo_megcodigo_Datalistfixedvalues ;
   private String Combo_megcodigo_Datalistprocparametersprefix ;
   private String Combo_megcodigo_Remoteservicesparameters ;
   private String Combo_megcodigo_Htmltemplate ;
   private String Combo_megcodigo_Multiplevaluestype ;
   private String Combo_megcodigo_Loadingdata ;
   private String Combo_megcodigo_Noresultsfound ;
   private String Combo_megcodigo_Emptyitemtext ;
   private String Combo_megcodigo_Onlyselectedvalues ;
   private String Combo_megcodigo_Selectalltext ;
   private String Combo_megcodigo_Multiplevaluesseparator ;
   private String Combo_megcodigo_Addnewoptiontext ;
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
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode261 ;
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
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_megcodigo_Emptyitem ;
   private boolean Combo_concodigo_Emptyitem ;
   private boolean n42ConCodYDesc ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
   private boolean Combo_megcodigo_Enabled ;
   private boolean Combo_megcodigo_Visible ;
   private boolean Combo_megcodigo_Allowmultipleselection ;
   private boolean Combo_megcodigo_Isgriditem ;
   private boolean Combo_megcodigo_Hasdescription ;
   private boolean Combo_megcodigo_Includeonlyselectedoption ;
   private boolean Combo_megcodigo_Includeselectalloption ;
   private boolean Combo_megcodigo_Includeaddnewoption ;
   private boolean Combo_concodigo_Enabled ;
   private boolean Combo_concodigo_Visible ;
   private boolean Combo_concodigo_Allowmultipleselection ;
   private boolean Combo_concodigo_Isgriditem ;
   private boolean Combo_concodigo_Hasdescription ;
   private boolean Combo_concodigo_Includeonlyselectedoption ;
   private boolean Combo_concodigo_Includeselectalloption ;
   private boolean Combo_concodigo_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV14IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV22Combo_DataJson ;
   private String A42ConCodYDesc ;
   private String A41ConDescrip ;
   private String AV20ComboSelectedValue ;
   private String AV21ComboSelectedText ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private com.genexus.webpanels.WebSession AV17WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_megcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_concodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbMegPreaTipo ;
   private HTMLChoice cmbConMegDura ;
   private IDataStoreProvider pr_default ;
   private String[] T00585_A42ConCodYDesc ;
   private boolean[] T00585_n42ConCodYDesc ;
   private String[] T00585_A41ConDescrip ;
   private String[] T00586_A42ConCodYDesc ;
   private boolean[] T00586_n42ConCodYDesc ;
   private short[] T00586_A2077ConMegSec ;
   private String[] T00586_A1532MegPreaTipo ;
   private byte[] T00586_A1530ConMegMeses ;
   private String[] T00586_A1534ConMegDura ;
   private java.math.BigDecimal[] T00586_A1529ConMegPropor ;
   private String[] T00586_A41ConDescrip ;
   private int[] T00586_A3CliCod ;
   private String[] T00586_A11MegCodigo ;
   private String[] T00586_A26ConCodigo ;
   private int[] T00584_A3CliCod ;
   private int[] T00587_A3CliCod ;
   private String[] T00588_A42ConCodYDesc ;
   private boolean[] T00588_n42ConCodYDesc ;
   private String[] T00588_A41ConDescrip ;
   private int[] T00589_A3CliCod ;
   private int[] T005810_A3CliCod ;
   private String[] T005810_A26ConCodigo ;
   private String[] T005810_A11MegCodigo ;
   private short[] T005810_A2077ConMegSec ;
   private short[] T00583_A2077ConMegSec ;
   private String[] T00583_A1532MegPreaTipo ;
   private byte[] T00583_A1530ConMegMeses ;
   private String[] T00583_A1534ConMegDura ;
   private java.math.BigDecimal[] T00583_A1529ConMegPropor ;
   private int[] T00583_A3CliCod ;
   private String[] T00583_A11MegCodigo ;
   private String[] T00583_A26ConCodigo ;
   private short[] T005811_A2077ConMegSec ;
   private int[] T005811_A3CliCod ;
   private String[] T005811_A11MegCodigo ;
   private String[] T005811_A26ConCodigo ;
   private short[] T005812_A2077ConMegSec ;
   private int[] T005812_A3CliCod ;
   private String[] T005812_A11MegCodigo ;
   private String[] T005812_A26ConCodigo ;
   private short[] T00582_A2077ConMegSec ;
   private String[] T00582_A1532MegPreaTipo ;
   private byte[] T00582_A1530ConMegMeses ;
   private String[] T00582_A1534ConMegDura ;
   private java.math.BigDecimal[] T00582_A1529ConMegPropor ;
   private int[] T00582_A3CliCod ;
   private String[] T00582_A11MegCodigo ;
   private String[] T00582_A26ConCodigo ;
   private String[] T005816_A42ConCodYDesc ;
   private boolean[] T005816_n42ConCodYDesc ;
   private String[] T005816_A41ConDescrip ;
   private int[] T005817_A3CliCod ;
   private String[] T005817_A26ConCodigo ;
   private String[] T005817_A11MegCodigo ;
   private short[] T005817_A2077ConMegSec ;
   private int[] T005818_A3CliCod ;
   private int[] T005819_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18CliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24MegCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV28ConCodigo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV13WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV16TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class conceptomotivosegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00582", "SELECT ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo, ConCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?  FOR UPDATE OF ConceptoMotivosEgreso NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00583", "SELECT ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo, ConCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00584", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00585", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00586", "SELECT T2.ConCodYDesc, TM1.ConMegSec, TM1.MegPreaTipo, TM1.ConMegMeses, TM1.ConMegDura, TM1.ConMegPropor, T2.ConDescrip, TM1.CliCod, TM1.MegCodigo, TM1.ConCodigo FROM (ConceptoMotivosEgreso TM1 INNER JOIN Concepto T2 ON T2.CliCod = TM1.CliCod AND T2.ConCodigo = TM1.ConCodigo) WHERE TM1.ConMegSec = ? and TM1.CliCod = ? and TM1.MegCodigo = ( ?) and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo, TM1.MegCodigo, TM1.ConMegSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00587", "SELECT CliCod FROM ConceptoMotivosEgreso WHERE (CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND MegPreaTipo = ? AND ConMegMeses = ? AND ConMegDura = ?) AND (Not ( CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00588", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00589", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005810", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005811", "SELECT ConMegSec, CliCod, MegCodigo, ConCodigo FROM ConceptoMotivosEgreso WHERE ( ConMegSec > ? or ConMegSec = ? and CliCod > ? or CliCod = ? and ConMegSec = ? and MegCodigo > ( ?) or MegCodigo = ( ?) and CliCod = ? and ConMegSec = ? and ConCodigo > ( ?)) ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005812", "SELECT ConMegSec, CliCod, MegCodigo, ConCodigo FROM ConceptoMotivosEgreso WHERE ( ConMegSec < ? or ConMegSec = ? and CliCod < ? or CliCod = ? and ConMegSec = ? and MegCodigo < ( ?) or MegCodigo = ( ?) and CliCod = ? and ConMegSec = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, ConCodigo DESC, MegCodigo DESC, ConMegSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005813", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo, ConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005814", "SAVEPOINT gxupdate;UPDATE ConceptoMotivosEgreso SET MegPreaTipo=?, ConMegMeses=?, ConMegDura=?, ConMegPropor=?  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005815", "SAVEPOINT gxupdate;DELETE FROM ConceptoMotivosEgreso  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005816", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005817", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005818", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005819", "SELECT CliCod FROM ConceptoMotivosEgreso WHERE (CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND MegPreaTipo = ? AND ConMegMeses = ? AND ConMegDura = ?) AND (Not ( CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
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
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((String[]) buf[10])[0] = rslt.getString(10, 10);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 10);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 10);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 10);
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
      }
   }

}

