package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class siradig_codigos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action20") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A2006SiraRelSec = (int)(GXutil.lval( httpContext.GetPar( "SiraRelSec"))) ;
         n2006SiraRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_20_35123( Gx_mode, AV7CliCod, A2006SiraRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SIRARELSEC") == 0 )
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
         gxdlasirarelsec35123( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"CLICOD") == 0 )
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
         gx4asaclicod35123( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"") == 0 )
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
         gxasa200635123( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1100SiraConCodigo = httpContext.GetPar( "SiraConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A3CliCod, A1100SiraConCodigo) ;
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
            AV8SiraTipo = httpContext.GetPar( "SiraTipo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SiraTipo", AV8SiraTipo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSIRATIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8SiraTipo, ""))));
            AV9SiraCodigo = httpContext.GetPar( "SiraCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9SiraCodigo", AV9SiraCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSIRACODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9SiraCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Códigos Siradig", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbSiraTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public siradig_codigos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public siradig_codigos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradig_codigos_impl.class ));
   }

   public siradig_codigos_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSiraTipo = new HTMLChoice();
      dynSiraRelSec = new HTMLChoice();
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
      if ( cmbSiraTipo.getItemCount() > 0 )
      {
         A1101SiraTipo = cmbSiraTipo.getValidValue(A1101SiraTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSiraTipo.setValue( GXutil.rtrim( A1101SiraTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Values", cmbSiraTipo.ToJavascriptSource(), true);
      }
      if ( dynSiraRelSec.getItemCount() > 0 )
      {
         A2006SiraRelSec = (int)(GXutil.lval( dynSiraRelSec.getValidValue(GXutil.trim( GXutil.str( A2006SiraRelSec, 6, 0))))) ;
         n2006SiraRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSiraRelSec.setValue( GXutil.trim( GXutil.str( A2006SiraRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynSiraRelSec.getInternalname(), "Values", dynSiraRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSiraTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbSiraTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSiraTipo, cmbSiraTipo.getInternalname(), GXutil.rtrim( A1101SiraTipo), 1, cmbSiraTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSiraTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_siradig_codigos.htm");
      cmbSiraTipo.setValue( GXutil.rtrim( A1101SiraTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Values", cmbSiraTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSiraCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSiraCodigo_Internalname, httpContext.getMessage( "Cod. Siradig", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSiraCodigo_Internalname, GXutil.rtrim( A1102SiraCodigo), GXutil.rtrim( localUtil.format( A1102SiraCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSiraCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSiraCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedsiraconcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksiraconcodigo_Internalname, httpContext.getMessage( "Concepto relacionado", ""), "", "", lblTextblocksiraconcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_siraconcodigo.setProperty("Caption", Combo_siraconcodigo_Caption);
      ucCombo_siraconcodigo.setProperty("Cls", Combo_siraconcodigo_Cls);
      ucCombo_siraconcodigo.setProperty("DataListProc", Combo_siraconcodigo_Datalistproc);
      ucCombo_siraconcodigo.setProperty("EmptyItem", Combo_siraconcodigo_Emptyitem);
      ucCombo_siraconcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_siraconcodigo.setProperty("DropDownOptionsData", AV17SiraConCodigo_Data);
      ucCombo_siraconcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_siraconcodigo_Internalname, "COMBO_SIRACONCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSiraConCodigo_Internalname, httpContext.getMessage( "Concepto relacionado", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSiraConCodigo_Internalname, GXutil.rtrim( A1100SiraConCodigo), GXutil.rtrim( localUtil.format( A1100SiraConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSiraConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtSiraConCodigo_Visible, edtSiraConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_siradig_codigos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSiraPropor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSiraPropor_Internalname, httpContext.getMessage( "Proporción de factura (1 = 100%)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSiraPropor_Internalname, GXutil.ltrim( localUtil.ntoc( A1103SiraPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSiraPropor_Enabled!=0) ? localUtil.format( A1103SiraPropor, "9.9999") : localUtil.format( A1103SiraPropor, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSiraPropor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSiraPropor_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSirarelsec_cell_Internalname, 1, 0, "px", 0, "px", divSirarelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynSiraRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSiraRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynSiraRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSiraRelSec, dynSiraRelSec.getInternalname(), GXutil.trim( GXutil.str( A2006SiraRelSec, 6, 0)), 1, dynSiraRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynSiraRelSec.getVisible(), dynSiraRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_siradig_codigos.htm");
      dynSiraRelSec.setValue( GXutil.trim( GXutil.str( A2006SiraRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynSiraRelSec.getInternalname(), "Values", dynSiraRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_siradig_codigos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_siraconcodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombosiraconcodigo_Internalname, GXutil.rtrim( AV22ComboSiraConCodigo), GXutil.rtrim( localUtil.format( AV22ComboSiraConCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosiraconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosiraconcodigo_Visible, edtavCombosiraconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_siradig_codigos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_siradig_codigos.htm");
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
      e11352 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSIRACONCODIGO_DATA"), AV17SiraConCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1101SiraTipo = httpContext.cgiGet( "Z1101SiraTipo") ;
            Z1102SiraCodigo = httpContext.cgiGet( "Z1102SiraCodigo") ;
            Z1103SiraPropor = localUtil.ctond( httpContext.cgiGet( "Z1103SiraPropor")) ;
            Z2006SiraRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2006SiraRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2006SiraRelSec = ((0==A2006SiraRelSec) ? true : false) ;
            Z2007SiraRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z2007SiraRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2007SiraRelSecCli = ((0==A2007SiraRelSecCli) ? true : false) ;
            Z2008SiraTipoPadre = httpContext.cgiGet( "Z2008SiraTipoPadre") ;
            n2008SiraTipoPadre = ((GXutil.strcmp("", A2008SiraTipoPadre)==0) ? true : false) ;
            Z2009SiraCodPadre = httpContext.cgiGet( "Z2009SiraCodPadre") ;
            n2009SiraCodPadre = ((GXutil.strcmp("", A2009SiraCodPadre)==0) ? true : false) ;
            Z2022SiraRelRef = httpContext.cgiGet( "Z2022SiraRelRef") ;
            n2022SiraRelRef = ((GXutil.strcmp("", A2022SiraRelRef)==0) ? true : false) ;
            Z1100SiraConCodigo = httpContext.cgiGet( "Z1100SiraConCodigo") ;
            A2007SiraRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z2007SiraRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2007SiraRelSecCli = false ;
            n2007SiraRelSecCli = ((0==A2007SiraRelSecCli) ? true : false) ;
            A2008SiraTipoPadre = httpContext.cgiGet( "Z2008SiraTipoPadre") ;
            n2008SiraTipoPadre = false ;
            n2008SiraTipoPadre = ((GXutil.strcmp("", A2008SiraTipoPadre)==0) ? true : false) ;
            A2009SiraCodPadre = httpContext.cgiGet( "Z2009SiraCodPadre") ;
            n2009SiraCodPadre = false ;
            n2009SiraCodPadre = ((GXutil.strcmp("", A2009SiraCodPadre)==0) ? true : false) ;
            A2022SiraRelRef = httpContext.cgiGet( "Z2022SiraRelRef") ;
            n2022SiraRelRef = false ;
            n2022SiraRelRef = ((GXutil.strcmp("", A2022SiraRelRef)==0) ? true : false) ;
            O1103SiraPropor = localUtil.ctond( httpContext.cgiGet( "O1103SiraPropor")) ;
            O1100SiraConCodigo = httpContext.cgiGet( "O1100SiraConCodigo") ;
            O1102SiraCodigo = httpContext.cgiGet( "O1102SiraCodigo") ;
            O1101SiraTipo = httpContext.cgiGet( "O1101SiraTipo") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1100SiraConCodigo = httpContext.cgiGet( "N1100SiraConCodigo") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8SiraTipo = httpContext.cgiGet( "vSIRATIPO") ;
            AV9SiraCodigo = httpContext.cgiGet( "vSIRACODIGO") ;
            AV15Insert_SiraConCodigo = httpContext.cgiGet( "vINSERT_SIRACONCODIGO") ;
            AV25aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2007SiraRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "SIRARELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2007SiraRelSecCli = ((0==A2007SiraRelSecCli) ? true : false) ;
            A2008SiraTipoPadre = httpContext.cgiGet( "SIRATIPOPADRE") ;
            n2008SiraTipoPadre = ((GXutil.strcmp("", A2008SiraTipoPadre)==0) ? true : false) ;
            A2009SiraCodPadre = httpContext.cgiGet( "SIRACODPADRE") ;
            n2009SiraCodPadre = ((GXutil.strcmp("", A2009SiraCodPadre)==0) ? true : false) ;
            A2022SiraRelRef = httpContext.cgiGet( "SIRARELREF") ;
            n2022SiraRelRef = ((GXutil.strcmp("", A2022SiraRelRef)==0) ? true : false) ;
            A2026SiraOld = httpContext.cgiGet( "SIRAOLD") ;
            n2026SiraOld = false ;
            n2026SiraOld = ((GXutil.strcmp("", A2026SiraOld)==0) ? true : false) ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_siraconcodigo_Objectcall = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Objectcall") ;
            Combo_siraconcodigo_Class = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Class") ;
            Combo_siraconcodigo_Icontype = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Icontype") ;
            Combo_siraconcodigo_Icon = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Icon") ;
            Combo_siraconcodigo_Caption = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Caption") ;
            Combo_siraconcodigo_Tooltip = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Tooltip") ;
            Combo_siraconcodigo_Cls = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Cls") ;
            Combo_siraconcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Selectedvalue_set") ;
            Combo_siraconcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Selectedvalue_get") ;
            Combo_siraconcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Selectedtext_set") ;
            Combo_siraconcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Selectedtext_get") ;
            Combo_siraconcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Gamoauthtoken") ;
            Combo_siraconcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Ddointernalname") ;
            Combo_siraconcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Titlecontrolalign") ;
            Combo_siraconcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Dropdownoptionstype") ;
            Combo_siraconcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Enabled")) ;
            Combo_siraconcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Visible")) ;
            Combo_siraconcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Titlecontrolidtoreplace") ;
            Combo_siraconcodigo_Datalisttype = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Datalisttype") ;
            Combo_siraconcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Allowmultipleselection")) ;
            Combo_siraconcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Datalistfixedvalues") ;
            Combo_siraconcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Isgriditem")) ;
            Combo_siraconcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Hasdescription")) ;
            Combo_siraconcodigo_Datalistproc = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Datalistproc") ;
            Combo_siraconcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Datalistprocparametersprefix") ;
            Combo_siraconcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Remoteservicesparameters") ;
            Combo_siraconcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_siraconcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Includeonlyselectedoption")) ;
            Combo_siraconcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Includeselectalloption")) ;
            Combo_siraconcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Emptyitem")) ;
            Combo_siraconcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Includeaddnewoption")) ;
            Combo_siraconcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Htmltemplate") ;
            Combo_siraconcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Multiplevaluestype") ;
            Combo_siraconcodigo_Loadingdata = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Loadingdata") ;
            Combo_siraconcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Noresultsfound") ;
            Combo_siraconcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Emptyitemtext") ;
            Combo_siraconcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Onlyselectedvalues") ;
            Combo_siraconcodigo_Selectalltext = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Selectalltext") ;
            Combo_siraconcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Multiplevaluesseparator") ;
            Combo_siraconcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_SIRACONCODIGO_Addnewoptiontext") ;
            Combo_siraconcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SIRACONCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            cmbSiraTipo.setValue( httpContext.cgiGet( cmbSiraTipo.getInternalname()) );
            A1101SiraTipo = httpContext.cgiGet( cmbSiraTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
            A1102SiraCodigo = httpContext.cgiGet( edtSiraCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
            A1100SiraConCodigo = httpContext.cgiGet( edtSiraConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtSiraPropor_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtSiraPropor_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SIRAPROPOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSiraPropor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1103SiraPropor = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
            }
            else
            {
               A1103SiraPropor = localUtil.ctond( httpContext.cgiGet( edtSiraPropor_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
            }
            dynSiraRelSec.setValue( httpContext.cgiGet( dynSiraRelSec.getInternalname()) );
            A2006SiraRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynSiraRelSec.getInternalname()))) ;
            n2006SiraRelSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
            n2006SiraRelSec = ((0==A2006SiraRelSec) ? true : false) ;
            AV22ComboSiraConCodigo = httpContext.cgiGet( edtavCombosiraconcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSiraConCodigo", AV22ComboSiraConCodigo);
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
            forbiddenHiddens.add("hshsalt", "hsh"+"siradig_codigos");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SiraRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A2007SiraRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("SiraTipoPadre", GXutil.rtrim( localUtil.format( A2008SiraTipoPadre, "")));
            forbiddenHiddens.add("SiraCodPadre", GXutil.rtrim( localUtil.format( A2009SiraCodPadre, "")));
            forbiddenHiddens.add("SiraRelRef", GXutil.rtrim( localUtil.format( A2022SiraRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1101SiraTipo, Z1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, Z1102SiraCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("siradig_codigos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1101SiraTipo = httpContext.GetPar( "SiraTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
               A1102SiraCodigo = httpContext.GetPar( "SiraCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
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
                  sMode123 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode123 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound123 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_350( ) ;
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
                        e11352 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12352 ();
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
         e12352 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll35123( ) ;
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
         disableAttributes35123( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosiraconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosiraconcodigo_Enabled), 5, 0), true);
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

   public void confirm_350( )
   {
      beforeValidate35123( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls35123( ) ;
         }
         else
         {
            checkExtendedTable35123( ) ;
            closeExtendedTableCursors35123( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption350( )
   {
   }

   public void e11352( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtSiraConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSiraConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraConCodigo_Visible), 5, 0), true);
      AV22ComboSiraConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSiraConCodigo", AV22ComboSiraConCodigo);
      edtavCombosiraconcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosiraconcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosiraconcodigo_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOSIRACONCODIGO' */
      S112 ();
      if ( returnInSub )
      {
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos_Insert", GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos_Update", GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos_Delete", GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV13TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV26Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV27GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         while ( AV27GXV1 <= AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV27GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SiraConCodigo") == 0 )
            {
               AV15Insert_SiraConCodigo = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_SiraConCodigo", AV15Insert_SiraConCodigo);
               if ( ! (GXutil.strcmp("", AV15Insert_SiraConCodigo)==0) )
               {
                  AV22ComboSiraConCodigo = AV15Insert_SiraConCodigo ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSiraConCodigo", AV22ComboSiraConCodigo);
                  Combo_siraconcodigo_Selectedvalue_set = AV22ComboSiraConCodigo ;
                  ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "SelectedValue_set", Combo_siraconcodigo_Selectedvalue_set);
                  GXt_char6 = AV21Combo_DataJson ;
                  GXv_char7[0] = AV19ComboSelectedValue ;
                  GXv_char8[0] = AV20ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.siradig_codigosloaddvcombo(remoteHandle, context).execute( "SiraConCodigo", "GET", false, AV7CliCod, AV8SiraTipo, AV9SiraCodigo, AV24Insert_CliCod, AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  siradig_codigos_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
                  siradig_codigos_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
                  siradig_codigos_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_siraconcodigo_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "SelectedText_set", Combo_siraconcodigo_Selectedtext_set);
                  Combo_siraconcodigo_Enabled = false ;
                  ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_siraconcodigo_Enabled));
               }
            }
            AV27GXV1 = (int)(AV27GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e12352( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.siradiggrabarrelref(remoteHandle, context).execute( A3CliCod, A1101SiraTipo, A1102SiraCodigo) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divSirarelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOSIRACONCODIGO' Routine */
      returnInSub = false ;
      Combo_siraconcodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"SiraConCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"SiraTipo\": \"\", \"SiraCodigo\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "DataListProcParametersPrefix", Combo_siraconcodigo_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.siradig_codigosloaddvcombo(remoteHandle, context).execute( "SiraConCodigo", Gx_mode, false, AV7CliCod, AV8SiraTipo, AV9SiraCodigo, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      siradig_codigos_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      siradig_codigos_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      siradig_codigos_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_siraconcodigo_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "SelectedValue_set", Combo_siraconcodigo_Selectedvalue_set);
      Combo_siraconcodigo_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "SelectedText_set", Combo_siraconcodigo_Selectedtext_set);
      AV22ComboSiraConCodigo = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSiraConCodigo", AV22ComboSiraConCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_siraconcodigo_Enabled = false ;
         ucCombo_siraconcodigo.sendProperty(context, "", false, Combo_siraconcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_siraconcodigo_Enabled));
      }
   }

   public void zm35123( int GX_JID )
   {
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1103SiraPropor = T00353_A1103SiraPropor[0] ;
            Z2006SiraRelSec = T00353_A2006SiraRelSec[0] ;
            Z2007SiraRelSecCli = T00353_A2007SiraRelSecCli[0] ;
            Z2008SiraTipoPadre = T00353_A2008SiraTipoPadre[0] ;
            Z2009SiraCodPadre = T00353_A2009SiraCodPadre[0] ;
            Z2022SiraRelRef = T00353_A2022SiraRelRef[0] ;
            Z1100SiraConCodigo = T00353_A1100SiraConCodigo[0] ;
         }
         else
         {
            Z1103SiraPropor = A1103SiraPropor ;
            Z2006SiraRelSec = A2006SiraRelSec ;
            Z2007SiraRelSecCli = A2007SiraRelSecCli ;
            Z2008SiraTipoPadre = A2008SiraTipoPadre ;
            Z2009SiraCodPadre = A2009SiraCodPadre ;
            Z2022SiraRelRef = A2022SiraRelRef ;
            Z1100SiraConCodigo = A1100SiraConCodigo ;
         }
      }
      if ( GX_JID == -22 )
      {
         Z1101SiraTipo = A1101SiraTipo ;
         Z1102SiraCodigo = A1102SiraCodigo ;
         Z1103SiraPropor = A1103SiraPropor ;
         Z2006SiraRelSec = A2006SiraRelSec ;
         Z2007SiraRelSecCli = A2007SiraRelSecCli ;
         Z2008SiraTipoPadre = A2008SiraTipoPadre ;
         Z2009SiraCodPadre = A2009SiraCodPadre ;
         Z2022SiraRelRef = A2022SiraRelRef ;
         Z2026SiraOld = A2026SiraOld ;
         Z3CliCod = A3CliCod ;
         Z1100SiraConCodigo = A1100SiraConCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxasirarelsec_html35123( AV7CliCod) ;
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
            siradig_codigos_impl.this.GXt_int10 = GXv_int11[0] ;
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
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynSiraRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynSiraRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynSiraRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8SiraTipo)==0) )
      {
         A1101SiraTipo = AV8SiraTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
      }
      if ( ! (GXutil.strcmp("", AV8SiraTipo)==0) )
      {
         cmbSiraTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSiraTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbSiraTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSiraTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8SiraTipo)==0) )
      {
         cmbSiraTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSiraTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9SiraCodigo)==0) )
      {
         A1102SiraCodigo = AV9SiraCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
      }
      if ( ! (GXutil.strcmp("", AV9SiraCodigo)==0) )
      {
         edtSiraCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSiraCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSiraCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSiraCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9SiraCodigo)==0) )
      {
         edtSiraCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSiraCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_SiraConCodigo)==0) )
      {
         edtSiraConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSiraConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSiraConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSiraConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraConCodigo_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_SiraConCodigo)==0) )
      {
         A1100SiraConCodigo = AV15Insert_SiraConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
      }
      else
      {
         A1100SiraConCodigo = AV22ComboSiraConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
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
         AV26Pgmname = "siradig_codigos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
   }

   public void load35123( )
   {
      /* Using cursor T00355 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound123 = (short)(1) ;
         A1103SiraPropor = T00355_A1103SiraPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
         A2006SiraRelSec = T00355_A2006SiraRelSec[0] ;
         n2006SiraRelSec = T00355_n2006SiraRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
         A2007SiraRelSecCli = T00355_A2007SiraRelSecCli[0] ;
         n2007SiraRelSecCli = T00355_n2007SiraRelSecCli[0] ;
         A2008SiraTipoPadre = T00355_A2008SiraTipoPadre[0] ;
         n2008SiraTipoPadre = T00355_n2008SiraTipoPadre[0] ;
         A2009SiraCodPadre = T00355_A2009SiraCodPadre[0] ;
         n2009SiraCodPadre = T00355_n2009SiraCodPadre[0] ;
         A2022SiraRelRef = T00355_A2022SiraRelRef[0] ;
         n2022SiraRelRef = T00355_n2022SiraRelRef[0] ;
         A2026SiraOld = T00355_A2026SiraOld[0] ;
         n2026SiraOld = T00355_n2026SiraOld[0] ;
         A1100SiraConCodigo = T00355_A1100SiraConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
         zm35123( -22) ;
      }
      pr_default.close(3);
      onLoadActions35123( ) ;
   }

   public void onLoadActions35123( )
   {
      AV26Pgmname = "siradig_codigos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) )
      {
         divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) )
         {
            divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable35123( )
   {
      nIsDirty_123 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "siradig_codigos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2006SiraRelSec, GXv_boolean5) ;
         siradig_codigos_impl.this.AV25aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      }
      /* Using cursor T00354 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1100SiraConCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Codigo Siradig Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SIRACONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1101SiraTipo, "DED") == 0 ) || ( GXutil.strcmp(A1101SiraTipo, "OTR") == 0 ) || ( GXutil.strcmp(A1101SiraTipo, "PAG") == 0 ) || ( GXutil.strcmp(A1101SiraTipo, "RTO") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "SIRATIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSiraTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) )
      {
         divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) )
         {
            divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
         }
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) && (0==A2006SiraRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "SIRATIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSiraTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors35123( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( int A3CliCod ,
                          String A1100SiraConCodigo )
   {
      /* Using cursor T00356 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A1100SiraConCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Codigo Siradig Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SIRACONCODIGO");
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

   public void getKey35123( )
   {
      /* Using cursor T00357 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound123 = (short)(1) ;
      }
      else
      {
         RcdFound123 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00353 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm35123( 22) ;
         RcdFound123 = (short)(1) ;
         A1101SiraTipo = T00353_A1101SiraTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
         A1102SiraCodigo = T00353_A1102SiraCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
         A1103SiraPropor = T00353_A1103SiraPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
         A2006SiraRelSec = T00353_A2006SiraRelSec[0] ;
         n2006SiraRelSec = T00353_n2006SiraRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
         A2007SiraRelSecCli = T00353_A2007SiraRelSecCli[0] ;
         n2007SiraRelSecCli = T00353_n2007SiraRelSecCli[0] ;
         A2008SiraTipoPadre = T00353_A2008SiraTipoPadre[0] ;
         n2008SiraTipoPadre = T00353_n2008SiraTipoPadre[0] ;
         A2009SiraCodPadre = T00353_A2009SiraCodPadre[0] ;
         n2009SiraCodPadre = T00353_n2009SiraCodPadre[0] ;
         A2022SiraRelRef = T00353_A2022SiraRelRef[0] ;
         n2022SiraRelRef = T00353_n2022SiraRelRef[0] ;
         A2026SiraOld = T00353_A2026SiraOld[0] ;
         n2026SiraOld = T00353_n2026SiraOld[0] ;
         A3CliCod = T00353_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1100SiraConCodigo = T00353_A1100SiraConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
         O1103SiraPropor = A1103SiraPropor ;
         httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
         O1100SiraConCodigo = A1100SiraConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
         O1102SiraCodigo = A1102SiraCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
         O1101SiraTipo = A1101SiraTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
         Z3CliCod = A3CliCod ;
         Z1101SiraTipo = A1101SiraTipo ;
         Z1102SiraCodigo = A1102SiraCodigo ;
         sMode123 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load35123( ) ;
         if ( AnyError == 1 )
         {
            RcdFound123 = (short)(0) ;
            initializeNonKey35123( ) ;
         }
         Gx_mode = sMode123 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound123 = (short)(0) ;
         initializeNonKey35123( ) ;
         sMode123 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode123 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey35123( ) ;
      if ( RcdFound123 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound123 = (short)(0) ;
      /* Using cursor T00358 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1101SiraTipo, A1101SiraTipo, Integer.valueOf(A3CliCod), A1102SiraCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00358_A3CliCod[0] < A3CliCod ) || ( T00358_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00358_A1101SiraTipo[0], A1101SiraTipo) < 0 ) || ( GXutil.strcmp(T00358_A1101SiraTipo[0], A1101SiraTipo) == 0 ) && ( T00358_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00358_A1102SiraCodigo[0], A1102SiraCodigo) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00358_A3CliCod[0] > A3CliCod ) || ( T00358_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00358_A1101SiraTipo[0], A1101SiraTipo) > 0 ) || ( GXutil.strcmp(T00358_A1101SiraTipo[0], A1101SiraTipo) == 0 ) && ( T00358_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00358_A1102SiraCodigo[0], A1102SiraCodigo) > 0 ) ) )
         {
            A3CliCod = T00358_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1101SiraTipo = T00358_A1101SiraTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
            A1102SiraCodigo = T00358_A1102SiraCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
            RcdFound123 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound123 = (short)(0) ;
      /* Using cursor T00359 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1101SiraTipo, A1101SiraTipo, Integer.valueOf(A3CliCod), A1102SiraCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00359_A3CliCod[0] > A3CliCod ) || ( T00359_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00359_A1101SiraTipo[0], A1101SiraTipo) > 0 ) || ( GXutil.strcmp(T00359_A1101SiraTipo[0], A1101SiraTipo) == 0 ) && ( T00359_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00359_A1102SiraCodigo[0], A1102SiraCodigo) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00359_A3CliCod[0] < A3CliCod ) || ( T00359_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00359_A1101SiraTipo[0], A1101SiraTipo) < 0 ) || ( GXutil.strcmp(T00359_A1101SiraTipo[0], A1101SiraTipo) == 0 ) && ( T00359_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00359_A1102SiraCodigo[0], A1102SiraCodigo) < 0 ) ) )
         {
            A3CliCod = T00359_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1101SiraTipo = T00359_A1101SiraTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
            A1102SiraCodigo = T00359_A1102SiraCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
            RcdFound123 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey35123( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbSiraTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert35123( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound123 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1101SiraTipo, Z1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, Z1102SiraCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1101SiraTipo = Z1101SiraTipo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
               A1102SiraCodigo = Z1102SiraCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbSiraTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update35123( ) ;
               GX_FocusControl = cmbSiraTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1101SiraTipo, Z1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, Z1102SiraCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbSiraTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert35123( ) ;
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
                  GX_FocusControl = cmbSiraTipo.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert35123( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1101SiraTipo, Z1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, Z1102SiraCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1101SiraTipo = Z1101SiraTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
         A1102SiraCodigo = Z1102SiraCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbSiraTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency35123( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00352 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"siradig_codigos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1103SiraPropor, T00352_A1103SiraPropor[0]) != 0 ) || ( Z2006SiraRelSec != T00352_A2006SiraRelSec[0] ) || ( Z2007SiraRelSecCli != T00352_A2007SiraRelSecCli[0] ) || ( GXutil.strcmp(Z2008SiraTipoPadre, T00352_A2008SiraTipoPadre[0]) != 0 ) || ( GXutil.strcmp(Z2009SiraCodPadre, T00352_A2009SiraCodPadre[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2022SiraRelRef, T00352_A2022SiraRelRef[0]) != 0 ) || ( GXutil.strcmp(Z1100SiraConCodigo, T00352_A1100SiraConCodigo[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1103SiraPropor, T00352_A1103SiraPropor[0]) != 0 )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraPropor");
               GXutil.writeLogRaw("Old: ",Z1103SiraPropor);
               GXutil.writeLogRaw("Current: ",T00352_A1103SiraPropor[0]);
            }
            if ( Z2006SiraRelSec != T00352_A2006SiraRelSec[0] )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraRelSec");
               GXutil.writeLogRaw("Old: ",Z2006SiraRelSec);
               GXutil.writeLogRaw("Current: ",T00352_A2006SiraRelSec[0]);
            }
            if ( Z2007SiraRelSecCli != T00352_A2007SiraRelSecCli[0] )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraRelSecCli");
               GXutil.writeLogRaw("Old: ",Z2007SiraRelSecCli);
               GXutil.writeLogRaw("Current: ",T00352_A2007SiraRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z2008SiraTipoPadre, T00352_A2008SiraTipoPadre[0]) != 0 )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraTipoPadre");
               GXutil.writeLogRaw("Old: ",Z2008SiraTipoPadre);
               GXutil.writeLogRaw("Current: ",T00352_A2008SiraTipoPadre[0]);
            }
            if ( GXutil.strcmp(Z2009SiraCodPadre, T00352_A2009SiraCodPadre[0]) != 0 )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraCodPadre");
               GXutil.writeLogRaw("Old: ",Z2009SiraCodPadre);
               GXutil.writeLogRaw("Current: ",T00352_A2009SiraCodPadre[0]);
            }
            if ( GXutil.strcmp(Z2022SiraRelRef, T00352_A2022SiraRelRef[0]) != 0 )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraRelRef");
               GXutil.writeLogRaw("Old: ",Z2022SiraRelRef);
               GXutil.writeLogRaw("Current: ",T00352_A2022SiraRelRef[0]);
            }
            if ( GXutil.strcmp(Z1100SiraConCodigo, T00352_A1100SiraConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("siradig_codigos:[seudo value changed for attri]"+"SiraConCodigo");
               GXutil.writeLogRaw("Old: ",Z1100SiraConCodigo);
               GXutil.writeLogRaw("Current: ",T00352_A1100SiraConCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"siradig_codigos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert35123( )
   {
      beforeValidate35123( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable35123( ) ;
      }
      if ( AnyError == 0 )
      {
         zm35123( 0) ;
         checkOptimisticConcurrency35123( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm35123( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert35123( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003510 */
                  pr_default.execute(8, new Object[] {A1101SiraTipo, A1102SiraCodigo, A1103SiraPropor, Boolean.valueOf(n2006SiraRelSec), Integer.valueOf(A2006SiraRelSec), Boolean.valueOf(n2007SiraRelSecCli), Integer.valueOf(A2007SiraRelSecCli), Boolean.valueOf(n2008SiraTipoPadre), A2008SiraTipoPadre, Boolean.valueOf(n2009SiraCodPadre), A2009SiraCodPadre, Boolean.valueOf(n2022SiraRelRef), A2022SiraRelRef, Boolean.valueOf(n2026SiraOld), A2026SiraOld, Integer.valueOf(A3CliCod), A1100SiraConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
                        resetCaption350( ) ;
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
            load35123( ) ;
         }
         endLevel35123( ) ;
      }
      closeExtendedTableCursors35123( ) ;
   }

   public void update35123( )
   {
      beforeValidate35123( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable35123( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency35123( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm35123( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate35123( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003511 */
                  pr_default.execute(9, new Object[] {A1103SiraPropor, Boolean.valueOf(n2006SiraRelSec), Integer.valueOf(A2006SiraRelSec), Boolean.valueOf(n2007SiraRelSecCli), Integer.valueOf(A2007SiraRelSecCli), Boolean.valueOf(n2008SiraTipoPadre), A2008SiraTipoPadre, Boolean.valueOf(n2009SiraCodPadre), A2009SiraCodPadre, Boolean.valueOf(n2022SiraRelRef), A2022SiraRelRef, Boolean.valueOf(n2026SiraOld), A2026SiraOld, A1100SiraConCodigo, Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"siradig_codigos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate35123( ) ;
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
         endLevel35123( ) ;
      }
      closeExtendedTableCursors35123( ) ;
   }

   public void deferredUpdate35123( )
   {
   }

   public void delete( )
   {
      beforeValidate35123( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency35123( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls35123( ) ;
         afterConfirm35123( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete35123( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003512 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
      sMode123 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel35123( ) ;
      Gx_mode = sMode123 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls35123( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV25aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2006SiraRelSec, GXv_boolean5) ;
            siradig_codigos_impl.this.AV25aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
         }
         AV26Pgmname = "siradig_codigos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) )
         {
            divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean4 = false ;
            GXv_boolean5[0] = GXt_boolean4 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
            siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
            if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) )
            {
               divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel35123( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete35123( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "siradig_codigos");
         if ( AnyError == 0 )
         {
            confirmValues350( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "siradig_codigos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart35123( )
   {
      /* Scan By routine */
      /* Using cursor T003513 */
      pr_default.execute(11);
      RcdFound123 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound123 = (short)(1) ;
         A3CliCod = T003513_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1101SiraTipo = T003513_A1101SiraTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
         A1102SiraCodigo = T003513_A1102SiraCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext35123( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound123 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound123 = (short)(1) ;
         A3CliCod = T003513_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1101SiraTipo = T003513_A1101SiraTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
         A1102SiraCodigo = T003513_A1102SiraCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
      }
   }

   public void scanEnd35123( )
   {
      pr_default.close(11);
   }

   public void afterConfirm35123( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV25aplicadoHay ) && ! (0==A2006SiraRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "SiraRelSec", 1, "SIRARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSiraRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert35123( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate35123( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete35123( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete35123( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate35123( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes35123( )
   {
      cmbSiraTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSiraTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSiraTipo.getEnabled(), 5, 0), true);
      edtSiraCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSiraCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraCodigo_Enabled), 5, 0), true);
      edtSiraConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSiraConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraConCodigo_Enabled), 5, 0), true);
      edtSiraPropor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSiraPropor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSiraPropor_Enabled), 5, 0), true);
      dynSiraRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynSiraRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynSiraRelSec.getEnabled(), 5, 0), true);
      edtavCombosiraconcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosiraconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosiraconcodigo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes35123( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues350( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.siradig_codigos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8SiraTipo)),GXutil.URLEncode(GXutil.rtrim(AV9SiraCodigo))}, new String[] {"Gx_mode","CliCod","SiraTipo","SiraCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"siradig_codigos");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SiraRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A2007SiraRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("SiraTipoPadre", GXutil.rtrim( localUtil.format( A2008SiraTipoPadre, "")));
      forbiddenHiddens.add("SiraCodPadre", GXutil.rtrim( localUtil.format( A2009SiraCodPadre, "")));
      forbiddenHiddens.add("SiraRelRef", GXutil.rtrim( localUtil.format( A2022SiraRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("siradig_codigos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1101SiraTipo", GXutil.rtrim( Z1101SiraTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1102SiraCodigo", GXutil.rtrim( Z1102SiraCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1103SiraPropor", GXutil.ltrim( localUtil.ntoc( Z1103SiraPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2006SiraRelSec", GXutil.ltrim( localUtil.ntoc( Z2006SiraRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2007SiraRelSecCli", GXutil.ltrim( localUtil.ntoc( Z2007SiraRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2008SiraTipoPadre", GXutil.rtrim( Z2008SiraTipoPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2009SiraCodPadre", GXutil.rtrim( Z2009SiraCodPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2022SiraRelRef", Z2022SiraRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1100SiraConCodigo", GXutil.rtrim( Z1100SiraConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "O1103SiraPropor", GXutil.ltrim( localUtil.ntoc( O1103SiraPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1100SiraConCodigo", GXutil.rtrim( O1100SiraConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "O1102SiraCodigo", GXutil.rtrim( O1102SiraCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "O1101SiraTipo", GXutil.rtrim( O1101SiraTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1100SiraConCodigo", GXutil.rtrim( A1100SiraConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSIRACONCODIGO_DATA", AV17SiraConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSIRACONCODIGO_DATA", AV17SiraConCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSIRATIPO", GXutil.rtrim( AV8SiraTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSIRATIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8SiraTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vSIRACODIGO", GXutil.rtrim( AV9SiraCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSIRACODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9SiraCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SIRACONCODIGO", GXutil.rtrim( AV15Insert_SiraConCodigo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV25aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "SIRARELSECCLI", GXutil.ltrim( localUtil.ntoc( A2007SiraRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SIRATIPOPADRE", GXutil.rtrim( A2008SiraTipoPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "SIRACODPADRE", GXutil.rtrim( A2009SiraCodPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "SIRARELREF", A2022SiraRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "SIRAOLD", A2026SiraOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Objectcall", GXutil.rtrim( Combo_siraconcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Cls", GXutil.rtrim( Combo_siraconcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_siraconcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Selectedtext_set", GXutil.rtrim( Combo_siraconcodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Enabled", GXutil.booltostr( Combo_siraconcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Datalistproc", GXutil.rtrim( Combo_siraconcodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_siraconcodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SIRACONCODIGO_Emptyitem", GXutil.booltostr( Combo_siraconcodigo_Emptyitem));
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
      return formatLink("web.siradig_codigos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8SiraTipo)),GXutil.URLEncode(GXutil.rtrim(AV9SiraCodigo))}, new String[] {"Gx_mode","CliCod","SiraTipo","SiraCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "siradig_codigos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Códigos Siradig", "") ;
   }

   public void initializeNonKey35123( )
   {
      A1100SiraConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
      AV25aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      A1103SiraPropor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
      A2006SiraRelSec = 0 ;
      n2006SiraRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2006SiraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2006SiraRelSec), 6, 0));
      n2006SiraRelSec = ((0==A2006SiraRelSec) ? true : false) ;
      A2007SiraRelSecCli = 0 ;
      n2007SiraRelSecCli = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2007SiraRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2007SiraRelSecCli), 6, 0));
      A2008SiraTipoPadre = "" ;
      n2008SiraTipoPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2008SiraTipoPadre", A2008SiraTipoPadre);
      A2009SiraCodPadre = "" ;
      n2009SiraCodPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2009SiraCodPadre", A2009SiraCodPadre);
      A2022SiraRelRef = "" ;
      n2022SiraRelRef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2022SiraRelRef", A2022SiraRelRef);
      A2026SiraOld = "" ;
      n2026SiraOld = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2026SiraOld", A2026SiraOld);
      O1103SiraPropor = A1103SiraPropor ;
      httpContext.ajax_rsp_assign_attri("", false, "A1103SiraPropor", GXutil.ltrimstr( A1103SiraPropor, 6, 4));
      O1100SiraConCodigo = A1100SiraConCodigo ;
      httpContext.ajax_rsp_assign_attri("", false, "A1100SiraConCodigo", A1100SiraConCodigo);
      Z1103SiraPropor = DecimalUtil.ZERO ;
      Z2006SiraRelSec = 0 ;
      Z2007SiraRelSecCli = 0 ;
      Z2008SiraTipoPadre = "" ;
      Z2009SiraCodPadre = "" ;
      Z2022SiraRelRef = "" ;
      Z1100SiraConCodigo = "" ;
   }

   public void initAll35123( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1101SiraTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
      A1102SiraCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1102SiraCodigo", A1102SiraCodigo);
      initializeNonKey35123( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181775468", true, true);
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
      httpContext.AddJavascriptSource("siradig_codigos.js", "?2025181775469", false, true);
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
      cmbSiraTipo.setInternalname( "SIRATIPO" );
      edtSiraCodigo_Internalname = "SIRACODIGO" ;
      lblTextblocksiraconcodigo_Internalname = "TEXTBLOCKSIRACONCODIGO" ;
      Combo_siraconcodigo_Internalname = "COMBO_SIRACONCODIGO" ;
      edtSiraConCodigo_Internalname = "SIRACONCODIGO" ;
      divTablesplittedsiraconcodigo_Internalname = "TABLESPLITTEDSIRACONCODIGO" ;
      edtSiraPropor_Internalname = "SIRAPROPOR" ;
      dynSiraRelSec.setInternalname( "SIRARELSEC" );
      divSirarelsec_cell_Internalname = "SIRARELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombosiraconcodigo_Internalname = "vCOMBOSIRACONCODIGO" ;
      divSectionattribute_siraconcodigo_Internalname = "SECTIONATTRIBUTE_SIRACONCODIGO" ;
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
      Form.setCaption( httpContext.getMessage( "Códigos Siradig", "") );
      Combo_siraconcodigo_Datalistprocparametersprefix = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombosiraconcodigo_Jsonclick = "" ;
      edtavCombosiraconcodigo_Enabled = 0 ;
      edtavCombosiraconcodigo_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynSiraRelSec.setJsonclick( "" );
      dynSiraRelSec.setEnabled( 1 );
      dynSiraRelSec.setVisible( 1 );
      divSirarelsec_cell_Class = "col-xs-12" ;
      edtSiraPropor_Jsonclick = "" ;
      edtSiraPropor_Enabled = 1 ;
      edtSiraConCodigo_Jsonclick = "" ;
      edtSiraConCodigo_Enabled = 1 ;
      edtSiraConCodigo_Visible = 1 ;
      Combo_siraconcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_siraconcodigo_Datalistproc = "siradig_codigosLoadDVCombo" ;
      Combo_siraconcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_siraconcodigo_Caption = "" ;
      Combo_siraconcodigo_Enabled = GXutil.toBoolean( -1) ;
      edtSiraCodigo_Jsonclick = "" ;
      edtSiraCodigo_Enabled = 1 ;
      cmbSiraTipo.setJsonclick( "" );
      cmbSiraTipo.setEnabled( 1 );
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

   public void gxdlasirarelsec35123( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasirarelsec_data35123( AV7CliCod) ;
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

   public void gxasirarelsec_html35123( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlasirarelsec_data35123( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSiraRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynSiraRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasirarelsec_data35123( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003514 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003514_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003514_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx4asaclicod35123( int AV7CliCod )
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
            siradig_codigos_impl.this.GXt_int10 = GXv_int11[0] ;
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

   public void gxasa200635123( int AV7CliCod )
   {
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynSiraRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynSiraRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynSiraRelSec.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_20_35123( String Gx_mode ,
                            int AV7CliCod ,
                            int A2006SiraRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2006SiraRelSec, GXv_boolean5) ;
         AV25aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV25aplicadoHay))+"\"") ;
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
      cmbSiraTipo.setName( "SIRATIPO" );
      cmbSiraTipo.setWebtags( "" );
      cmbSiraTipo.addItem("DED", httpContext.getMessage( "Deduccion", ""), (short)(0));
      cmbSiraTipo.addItem("OTR", httpContext.getMessage( "Otros empleos", ""), (short)(0));
      cmbSiraTipo.addItem("PAG", httpContext.getMessage( "Pagos a Cuenta", ""), (short)(0));
      cmbSiraTipo.addItem("RTO", httpContext.getMessage( "Reintegro con comprobante", ""), (short)(0));
      if ( cmbSiraTipo.getItemCount() > 0 )
      {
         A1101SiraTipo = cmbSiraTipo.getValidValue(A1101SiraTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1101SiraTipo", A1101SiraTipo);
      }
      dynSiraRelSec.setName( "SIRARELSEC" );
      dynSiraRelSec.setWebtags( "" );
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

   public void valid_Siraconcodigo( )
   {
      n2006SiraRelSec = false ;
      A2006SiraRelSec = (int)(GXutil.lval( dynSiraRelSec.getValue())) ;
      n2006SiraRelSec = false ;
      /* Using cursor T003515 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A1100SiraConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Codigo Siradig Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SIRACONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      if ( cmbSiraTipo.getItemCount() > 0 )
      {
         A1101SiraTipo = cmbSiraTipo.getValidValue(A1101SiraTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSiraTipo.setValue( GXutil.rtrim( A1101SiraTipo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Sirapropor( )
   {
      A1101SiraTipo = cmbSiraTipo.getValue() ;
      n2006SiraRelSec = false ;
      A2006SiraRelSec = (int)(GXutil.lval( dynSiraRelSec.getValue())) ;
      n2006SiraRelSec = false ;
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) )
      {
         divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         siradig_codigos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) )
         {
            divSirarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      dynload_actions( ) ;
      if ( cmbSiraTipo.getItemCount() > 0 )
      {
         A1101SiraTipo = cmbSiraTipo.getValidValue(A1101SiraTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSiraTipo.setValue( GXutil.rtrim( A1101SiraTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divSirarelsec_cell_Internalname, "Class", divSirarelsec_cell_Class, true);
   }

   public void valid_Sirarelsec( )
   {
      A1101SiraTipo = cmbSiraTipo.getValue() ;
      n2006SiraRelSec = false ;
      A2006SiraRelSec = (int)(GXutil.lval( dynSiraRelSec.getValue())) ;
      n2006SiraRelSec = false ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A1101SiraTipo, O1101SiraTipo) != 0 ) || ( GXutil.strcmp(A1102SiraCodigo, O1102SiraCodigo) != 0 ) || ( GXutil.strcmp(A1100SiraConCodigo, O1100SiraConCodigo) != 0 ) || ( DecimalUtil.compareTo(A1103SiraPropor, O1103SiraPropor) != 0 ) ) ) && (0==A2006SiraRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "SIRARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSiraRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2006SiraRelSec, GXv_boolean5) ;
         siradig_codigos_impl.this.AV25aplicadoHay = GXv_boolean5[0] ;
         AV25aplicadoHay = this.AV25aplicadoHay ;
      }
      dynload_actions( ) ;
      if ( cmbSiraTipo.getItemCount() > 0 )
      {
         A1101SiraTipo = cmbSiraTipo.getValidValue(A1101SiraTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSiraTipo.setValue( GXutil.rtrim( A1101SiraTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8SiraTipo',fld:'vSIRATIPO',pic:'',hsh:true},{av:'AV9SiraCodigo',fld:'vSIRACODIGO',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8SiraTipo',fld:'vSIRATIPO',pic:'',hsh:true},{av:'AV9SiraCodigo',fld:'vSIRACODIGO',pic:'',hsh:true},{av:'A2007SiraRelSecCli',fld:'SIRARELSECCLI',pic:'ZZZZZ9'},{av:'A2008SiraTipoPadre',fld:'SIRATIPOPADRE',pic:''},{av:'A2009SiraCodPadre',fld:'SIRACODPADRE',pic:''},{av:'A2022SiraRelRef',fld:'SIRARELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12352',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'cmbSiraTipo'},{av:'A1101SiraTipo',fld:'SIRATIPO',pic:''},{av:'A1102SiraCodigo',fld:'SIRACODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_SIRATIPO","{handler:'valid_Siratipo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_SIRATIPO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_SIRACODIGO","{handler:'valid_Siracodigo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_SIRACODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_SIRACONCODIGO","{handler:'valid_Siraconcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1100SiraConCodigo',fld:'SIRACONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_SIRACONCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_SIRAPROPOR","{handler:'valid_Sirapropor',iparms:[{av:'O1103SiraPropor'},{av:'O1100SiraConCodigo'},{av:'O1102SiraCodigo'},{av:'O1101SiraTipo'},{av:'cmbSiraTipo'},{av:'A1101SiraTipo',fld:'SIRATIPO',pic:''},{av:'A1102SiraCodigo',fld:'SIRACODIGO',pic:''},{av:'A1100SiraConCodigo',fld:'SIRACONCODIGO',pic:''},{av:'A1103SiraPropor',fld:'SIRAPROPOR',pic:'9.9999'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_SIRAPROPOR",",oparms:[{av:'divSirarelsec_cell_Class',ctrl:'SIRARELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_SIRARELSEC","{handler:'valid_Sirarelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1103SiraPropor'},{av:'O1100SiraConCodigo'},{av:'O1102SiraCodigo'},{av:'O1101SiraTipo'},{av:'cmbSiraTipo'},{av:'A1101SiraTipo',fld:'SIRATIPO',pic:''},{av:'A1102SiraCodigo',fld:'SIRACODIGO',pic:''},{av:'A1100SiraConCodigo',fld:'SIRACONCODIGO',pic:''},{av:'A1103SiraPropor',fld:'SIRAPROPOR',pic:'9.9999'},{av:'AV25aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_SIRARELSEC",",oparms:[{av:'AV25aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOSIRACONCODIGO","{handler:'validv_Combosiraconcodigo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOSIRACONCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSiraRelSec'},{av:'A2006SiraRelSec',fld:'SIRARELSEC',pic:'ZZZZZ9'}]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8SiraTipo = "" ;
      wcpOAV9SiraCodigo = "" ;
      Z1101SiraTipo = "" ;
      Z1102SiraCodigo = "" ;
      Z1103SiraPropor = DecimalUtil.ZERO ;
      Z2008SiraTipoPadre = "" ;
      Z2009SiraCodPadre = "" ;
      Z2022SiraRelRef = "" ;
      Z1100SiraConCodigo = "" ;
      O1103SiraPropor = DecimalUtil.ZERO ;
      O1100SiraConCodigo = "" ;
      O1102SiraCodigo = "" ;
      O1101SiraTipo = "" ;
      N1100SiraConCodigo = "" ;
      Combo_siraconcodigo_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1100SiraConCodigo = "" ;
      AV8SiraTipo = "" ;
      AV9SiraCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1101SiraTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1102SiraCodigo = "" ;
      lblTextblocksiraconcodigo_Jsonclick = "" ;
      ucCombo_siraconcodigo = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17SiraConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1103SiraPropor = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboSiraConCodigo = "" ;
      A2008SiraTipoPadre = "" ;
      A2009SiraCodPadre = "" ;
      A2022SiraRelRef = "" ;
      AV15Insert_SiraConCodigo = "" ;
      A2026SiraOld = "" ;
      AV26Pgmname = "" ;
      Combo_siraconcodigo_Objectcall = "" ;
      Combo_siraconcodigo_Class = "" ;
      Combo_siraconcodigo_Icontype = "" ;
      Combo_siraconcodigo_Icon = "" ;
      Combo_siraconcodigo_Tooltip = "" ;
      Combo_siraconcodigo_Selectedvalue_set = "" ;
      Combo_siraconcodigo_Selectedtext_set = "" ;
      Combo_siraconcodigo_Selectedtext_get = "" ;
      Combo_siraconcodigo_Gamoauthtoken = "" ;
      Combo_siraconcodigo_Ddointernalname = "" ;
      Combo_siraconcodigo_Titlecontrolalign = "" ;
      Combo_siraconcodigo_Dropdownoptionstype = "" ;
      Combo_siraconcodigo_Titlecontrolidtoreplace = "" ;
      Combo_siraconcodigo_Datalisttype = "" ;
      Combo_siraconcodigo_Datalistfixedvalues = "" ;
      Combo_siraconcodigo_Remoteservicesparameters = "" ;
      Combo_siraconcodigo_Htmltemplate = "" ;
      Combo_siraconcodigo_Multiplevaluestype = "" ;
      Combo_siraconcodigo_Loadingdata = "" ;
      Combo_siraconcodigo_Noresultsfound = "" ;
      Combo_siraconcodigo_Emptyitemtext = "" ;
      Combo_siraconcodigo_Onlyselectedvalues = "" ;
      Combo_siraconcodigo_Selectalltext = "" ;
      Combo_siraconcodigo_Multiplevaluesseparator = "" ;
      Combo_siraconcodigo_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode123 = "" ;
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
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z2026SiraOld = "" ;
      T00355_A1101SiraTipo = new String[] {""} ;
      T00355_A1102SiraCodigo = new String[] {""} ;
      T00355_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00355_A2006SiraRelSec = new int[1] ;
      T00355_n2006SiraRelSec = new boolean[] {false} ;
      T00355_A2007SiraRelSecCli = new int[1] ;
      T00355_n2007SiraRelSecCli = new boolean[] {false} ;
      T00355_A2008SiraTipoPadre = new String[] {""} ;
      T00355_n2008SiraTipoPadre = new boolean[] {false} ;
      T00355_A2009SiraCodPadre = new String[] {""} ;
      T00355_n2009SiraCodPadre = new boolean[] {false} ;
      T00355_A2022SiraRelRef = new String[] {""} ;
      T00355_n2022SiraRelRef = new boolean[] {false} ;
      T00355_A2026SiraOld = new String[] {""} ;
      T00355_n2026SiraOld = new boolean[] {false} ;
      T00355_A3CliCod = new int[1] ;
      T00355_A1100SiraConCodigo = new String[] {""} ;
      T00354_A3CliCod = new int[1] ;
      T00356_A3CliCod = new int[1] ;
      T00357_A3CliCod = new int[1] ;
      T00357_A1101SiraTipo = new String[] {""} ;
      T00357_A1102SiraCodigo = new String[] {""} ;
      T00353_A1101SiraTipo = new String[] {""} ;
      T00353_A1102SiraCodigo = new String[] {""} ;
      T00353_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00353_A2006SiraRelSec = new int[1] ;
      T00353_n2006SiraRelSec = new boolean[] {false} ;
      T00353_A2007SiraRelSecCli = new int[1] ;
      T00353_n2007SiraRelSecCli = new boolean[] {false} ;
      T00353_A2008SiraTipoPadre = new String[] {""} ;
      T00353_n2008SiraTipoPadre = new boolean[] {false} ;
      T00353_A2009SiraCodPadre = new String[] {""} ;
      T00353_n2009SiraCodPadre = new boolean[] {false} ;
      T00353_A2022SiraRelRef = new String[] {""} ;
      T00353_n2022SiraRelRef = new boolean[] {false} ;
      T00353_A2026SiraOld = new String[] {""} ;
      T00353_n2026SiraOld = new boolean[] {false} ;
      T00353_A3CliCod = new int[1] ;
      T00353_A1100SiraConCodigo = new String[] {""} ;
      T00358_A3CliCod = new int[1] ;
      T00358_A1101SiraTipo = new String[] {""} ;
      T00358_A1102SiraCodigo = new String[] {""} ;
      T00359_A3CliCod = new int[1] ;
      T00359_A1101SiraTipo = new String[] {""} ;
      T00359_A1102SiraCodigo = new String[] {""} ;
      T00352_A1101SiraTipo = new String[] {""} ;
      T00352_A1102SiraCodigo = new String[] {""} ;
      T00352_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00352_A2006SiraRelSec = new int[1] ;
      T00352_n2006SiraRelSec = new boolean[] {false} ;
      T00352_A2007SiraRelSecCli = new int[1] ;
      T00352_n2007SiraRelSecCli = new boolean[] {false} ;
      T00352_A2008SiraTipoPadre = new String[] {""} ;
      T00352_n2008SiraTipoPadre = new boolean[] {false} ;
      T00352_A2009SiraCodPadre = new String[] {""} ;
      T00352_n2009SiraCodPadre = new boolean[] {false} ;
      T00352_A2022SiraRelRef = new String[] {""} ;
      T00352_n2022SiraRelRef = new boolean[] {false} ;
      T00352_A2026SiraOld = new String[] {""} ;
      T00352_n2026SiraOld = new boolean[] {false} ;
      T00352_A3CliCod = new int[1] ;
      T00352_A1100SiraConCodigo = new String[] {""} ;
      T003513_A3CliCod = new int[1] ;
      T003513_A1101SiraTipo = new String[] {""} ;
      T003513_A1102SiraCodigo = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003514_A3CliCod = new int[1] ;
      T003514_A1885CliRelSec = new int[1] ;
      T003514_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T003515_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradig_codigos__default(),
         new Object[] {
             new Object[] {
            T00352_A1101SiraTipo, T00352_A1102SiraCodigo, T00352_A1103SiraPropor, T00352_A2006SiraRelSec, T00352_n2006SiraRelSec, T00352_A2007SiraRelSecCli, T00352_n2007SiraRelSecCli, T00352_A2008SiraTipoPadre, T00352_n2008SiraTipoPadre, T00352_A2009SiraCodPadre,
            T00352_n2009SiraCodPadre, T00352_A2022SiraRelRef, T00352_n2022SiraRelRef, T00352_A2026SiraOld, T00352_n2026SiraOld, T00352_A3CliCod, T00352_A1100SiraConCodigo
            }
            , new Object[] {
            T00353_A1101SiraTipo, T00353_A1102SiraCodigo, T00353_A1103SiraPropor, T00353_A2006SiraRelSec, T00353_n2006SiraRelSec, T00353_A2007SiraRelSecCli, T00353_n2007SiraRelSecCli, T00353_A2008SiraTipoPadre, T00353_n2008SiraTipoPadre, T00353_A2009SiraCodPadre,
            T00353_n2009SiraCodPadre, T00353_A2022SiraRelRef, T00353_n2022SiraRelRef, T00353_A2026SiraOld, T00353_n2026SiraOld, T00353_A3CliCod, T00353_A1100SiraConCodigo
            }
            , new Object[] {
            T00354_A3CliCod
            }
            , new Object[] {
            T00355_A1101SiraTipo, T00355_A1102SiraCodigo, T00355_A1103SiraPropor, T00355_A2006SiraRelSec, T00355_n2006SiraRelSec, T00355_A2007SiraRelSecCli, T00355_n2007SiraRelSecCli, T00355_A2008SiraTipoPadre, T00355_n2008SiraTipoPadre, T00355_A2009SiraCodPadre,
            T00355_n2009SiraCodPadre, T00355_A2022SiraRelRef, T00355_n2022SiraRelRef, T00355_A2026SiraOld, T00355_n2026SiraOld, T00355_A3CliCod, T00355_A1100SiraConCodigo
            }
            , new Object[] {
            T00356_A3CliCod
            }
            , new Object[] {
            T00357_A3CliCod, T00357_A1101SiraTipo, T00357_A1102SiraCodigo
            }
            , new Object[] {
            T00358_A3CliCod, T00358_A1101SiraTipo, T00358_A1102SiraCodigo
            }
            , new Object[] {
            T00359_A3CliCod, T00359_A1101SiraTipo, T00359_A1102SiraCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003513_A3CliCod, T003513_A1101SiraTipo, T003513_A1102SiraCodigo
            }
            , new Object[] {
            T003514_A3CliCod, T003514_A1885CliRelSec, T003514_A1880CliReDTChar
            }
            , new Object[] {
            T003515_A3CliCod
            }
         }
      );
      AV26Pgmname = "siradig_codigos" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound123 ;
   private short nIsDirty_123 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2006SiraRelSec ;
   private int Z2007SiraRelSecCli ;
   private int AV7CliCod ;
   private int A2006SiraRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtSiraCodigo_Enabled ;
   private int edtSiraConCodigo_Visible ;
   private int edtSiraConCodigo_Enabled ;
   private int edtSiraPropor_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombosiraconcodigo_Visible ;
   private int edtavCombosiraconcodigo_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A2007SiraRelSecCli ;
   private int Combo_siraconcodigo_Datalistupdateminimumcharacters ;
   private int Combo_siraconcodigo_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV27GXV1 ;
   private int AV24Insert_CliCod ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z1103SiraPropor ;
   private java.math.BigDecimal O1103SiraPropor ;
   private java.math.BigDecimal A1103SiraPropor ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8SiraTipo ;
   private String wcpOAV9SiraCodigo ;
   private String Z1101SiraTipo ;
   private String Z1102SiraCodigo ;
   private String Z2008SiraTipoPadre ;
   private String Z2009SiraCodPadre ;
   private String Z1100SiraConCodigo ;
   private String O1100SiraConCodigo ;
   private String O1102SiraCodigo ;
   private String O1101SiraTipo ;
   private String N1100SiraConCodigo ;
   private String Combo_siraconcodigo_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1100SiraConCodigo ;
   private String AV8SiraTipo ;
   private String AV9SiraCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A1101SiraTipo ;
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
   private String edtSiraCodigo_Internalname ;
   private String A1102SiraCodigo ;
   private String edtSiraCodigo_Jsonclick ;
   private String divTablesplittedsiraconcodigo_Internalname ;
   private String lblTextblocksiraconcodigo_Internalname ;
   private String lblTextblocksiraconcodigo_Jsonclick ;
   private String Combo_siraconcodigo_Caption ;
   private String Combo_siraconcodigo_Cls ;
   private String Combo_siraconcodigo_Datalistproc ;
   private String Combo_siraconcodigo_Internalname ;
   private String edtSiraConCodigo_Internalname ;
   private String edtSiraConCodigo_Jsonclick ;
   private String edtSiraPropor_Internalname ;
   private String edtSiraPropor_Jsonclick ;
   private String divSirarelsec_cell_Internalname ;
   private String divSirarelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_siraconcodigo_Internalname ;
   private String edtavCombosiraconcodigo_Internalname ;
   private String AV22ComboSiraConCodigo ;
   private String edtavCombosiraconcodigo_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A2008SiraTipoPadre ;
   private String A2009SiraCodPadre ;
   private String AV15Insert_SiraConCodigo ;
   private String AV26Pgmname ;
   private String Combo_siraconcodigo_Objectcall ;
   private String Combo_siraconcodigo_Class ;
   private String Combo_siraconcodigo_Icontype ;
   private String Combo_siraconcodigo_Icon ;
   private String Combo_siraconcodigo_Tooltip ;
   private String Combo_siraconcodigo_Selectedvalue_set ;
   private String Combo_siraconcodigo_Selectedtext_set ;
   private String Combo_siraconcodigo_Selectedtext_get ;
   private String Combo_siraconcodigo_Gamoauthtoken ;
   private String Combo_siraconcodigo_Ddointernalname ;
   private String Combo_siraconcodigo_Titlecontrolalign ;
   private String Combo_siraconcodigo_Dropdownoptionstype ;
   private String Combo_siraconcodigo_Titlecontrolidtoreplace ;
   private String Combo_siraconcodigo_Datalisttype ;
   private String Combo_siraconcodigo_Datalistfixedvalues ;
   private String Combo_siraconcodigo_Datalistprocparametersprefix ;
   private String Combo_siraconcodigo_Remoteservicesparameters ;
   private String Combo_siraconcodigo_Htmltemplate ;
   private String Combo_siraconcodigo_Multiplevaluestype ;
   private String Combo_siraconcodigo_Loadingdata ;
   private String Combo_siraconcodigo_Noresultsfound ;
   private String Combo_siraconcodigo_Emptyitemtext ;
   private String Combo_siraconcodigo_Onlyselectedvalues ;
   private String Combo_siraconcodigo_Selectalltext ;
   private String Combo_siraconcodigo_Multiplevaluesseparator ;
   private String Combo_siraconcodigo_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode123 ;
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
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n2006SiraRelSec ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_siraconcodigo_Emptyitem ;
   private boolean n2007SiraRelSecCli ;
   private boolean n2008SiraTipoPadre ;
   private boolean n2009SiraCodPadre ;
   private boolean n2022SiraRelRef ;
   private boolean AV25aplicadoHay ;
   private boolean n2026SiraOld ;
   private boolean Combo_siraconcodigo_Enabled ;
   private boolean Combo_siraconcodigo_Visible ;
   private boolean Combo_siraconcodigo_Allowmultipleselection ;
   private boolean Combo_siraconcodigo_Isgriditem ;
   private boolean Combo_siraconcodigo_Hasdescription ;
   private boolean Combo_siraconcodigo_Includeonlyselectedoption ;
   private boolean Combo_siraconcodigo_Includeselectalloption ;
   private boolean Combo_siraconcodigo_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean ZV25aplicadoHay ;
   private String A2026SiraOld ;
   private String AV21Combo_DataJson ;
   private String Z2026SiraOld ;
   private String Z2022SiraRelRef ;
   private String A2022SiraRelRef ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_siraconcodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSiraTipo ;
   private HTMLChoice dynSiraRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T00355_A1101SiraTipo ;
   private String[] T00355_A1102SiraCodigo ;
   private java.math.BigDecimal[] T00355_A1103SiraPropor ;
   private int[] T00355_A2006SiraRelSec ;
   private boolean[] T00355_n2006SiraRelSec ;
   private int[] T00355_A2007SiraRelSecCli ;
   private boolean[] T00355_n2007SiraRelSecCli ;
   private String[] T00355_A2008SiraTipoPadre ;
   private boolean[] T00355_n2008SiraTipoPadre ;
   private String[] T00355_A2009SiraCodPadre ;
   private boolean[] T00355_n2009SiraCodPadre ;
   private String[] T00355_A2022SiraRelRef ;
   private boolean[] T00355_n2022SiraRelRef ;
   private String[] T00355_A2026SiraOld ;
   private boolean[] T00355_n2026SiraOld ;
   private int[] T00355_A3CliCod ;
   private String[] T00355_A1100SiraConCodigo ;
   private int[] T00354_A3CliCod ;
   private int[] T00356_A3CliCod ;
   private int[] T00357_A3CliCod ;
   private String[] T00357_A1101SiraTipo ;
   private String[] T00357_A1102SiraCodigo ;
   private String[] T00353_A1101SiraTipo ;
   private String[] T00353_A1102SiraCodigo ;
   private java.math.BigDecimal[] T00353_A1103SiraPropor ;
   private int[] T00353_A2006SiraRelSec ;
   private boolean[] T00353_n2006SiraRelSec ;
   private int[] T00353_A2007SiraRelSecCli ;
   private boolean[] T00353_n2007SiraRelSecCli ;
   private String[] T00353_A2008SiraTipoPadre ;
   private boolean[] T00353_n2008SiraTipoPadre ;
   private String[] T00353_A2009SiraCodPadre ;
   private boolean[] T00353_n2009SiraCodPadre ;
   private String[] T00353_A2022SiraRelRef ;
   private boolean[] T00353_n2022SiraRelRef ;
   private String[] T00353_A2026SiraOld ;
   private boolean[] T00353_n2026SiraOld ;
   private int[] T00353_A3CliCod ;
   private String[] T00353_A1100SiraConCodigo ;
   private int[] T00358_A3CliCod ;
   private String[] T00358_A1101SiraTipo ;
   private String[] T00358_A1102SiraCodigo ;
   private int[] T00359_A3CliCod ;
   private String[] T00359_A1101SiraTipo ;
   private String[] T00359_A1102SiraCodigo ;
   private String[] T00352_A1101SiraTipo ;
   private String[] T00352_A1102SiraCodigo ;
   private java.math.BigDecimal[] T00352_A1103SiraPropor ;
   private int[] T00352_A2006SiraRelSec ;
   private boolean[] T00352_n2006SiraRelSec ;
   private int[] T00352_A2007SiraRelSecCli ;
   private boolean[] T00352_n2007SiraRelSecCli ;
   private String[] T00352_A2008SiraTipoPadre ;
   private boolean[] T00352_n2008SiraTipoPadre ;
   private String[] T00352_A2009SiraCodPadre ;
   private boolean[] T00352_n2009SiraCodPadre ;
   private String[] T00352_A2022SiraRelRef ;
   private boolean[] T00352_n2022SiraRelRef ;
   private String[] T00352_A2026SiraOld ;
   private boolean[] T00352_n2026SiraOld ;
   private int[] T00352_A3CliCod ;
   private String[] T00352_A1100SiraConCodigo ;
   private int[] T003513_A3CliCod ;
   private String[] T003513_A1101SiraTipo ;
   private String[] T003513_A1102SiraCodigo ;
   private int[] T003514_A3CliCod ;
   private int[] T003514_A1885CliRelSec ;
   private String[] T003514_A1880CliReDTChar ;
   private int[] T003515_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17SiraConCodigo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class siradig_codigos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00352", "SELECT SiraTipo, SiraCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld, CliCod, SiraConCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ?  FOR UPDATE OF siradig_codigos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00353", "SELECT SiraTipo, SiraCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld, CliCod, SiraConCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00354", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00355", "SELECT TM1.SiraTipo, TM1.SiraCodigo, TM1.SiraPropor, TM1.SiraRelSec, TM1.SiraRelSecCli, TM1.SiraTipoPadre, TM1.SiraCodPadre, TM1.SiraRelRef, TM1.SiraOld, TM1.CliCod, TM1.SiraConCodigo AS SiraConCodigo FROM siradig_codigos TM1 WHERE TM1.CliCod = ? and TM1.SiraTipo = ( ?) and TM1.SiraCodigo = ( ?) ORDER BY TM1.CliCod, TM1.SiraTipo, TM1.SiraCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00356", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00357", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00358", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE ( CliCod > ? or CliCod = ? and SiraTipo > ( ?) or SiraTipo = ( ?) and CliCod = ? and SiraCodigo > ( ?)) ORDER BY CliCod, SiraTipo, SiraCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00359", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE ( CliCod < ? or CliCod = ? and SiraTipo < ( ?) or SiraTipo = ( ?) and CliCod = ? and SiraCodigo < ( ?)) ORDER BY CliCod DESC, SiraTipo DESC, SiraCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003510", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(SiraTipo, SiraCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld, CliCod, SiraConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003511", "SAVEPOINT gxupdate;UPDATE siradig_codigos SET SiraPropor=?, SiraRelSec=?, SiraRelSecCli=?, SiraTipoPadre=?, SiraCodPadre=?, SiraRelRef=?, SiraOld=?, SiraConCodigo=?  WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003512", "SAVEPOINT gxupdate;DELETE FROM siradig_codigos  WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003513", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos ORDER BY CliCod, SiraTipo, SiraCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003514", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003515", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 3);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 3);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 3);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 3);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 3);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 3);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 13 :
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
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 3);
               stmt.setString(4, (String)parms[3], 3);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 3);
               stmt.setString(4, (String)parms[3], 3);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 3);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[6]).intValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[8], 3);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[12], 40);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(9, (String)parms[14]);
               }
               stmt.setInt(10, ((Number) parms[15]).intValue());
               stmt.setString(11, (String)parms[16], 10);
               return;
            case 9 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[2]).intValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[4]).intValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[6], 3);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[8], 20);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[10], 40);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[12]);
               }
               stmt.setString(8, (String)parms[13], 10);
               stmt.setInt(9, ((Number) parms[14]).intValue());
               stmt.setString(10, (String)parms[15], 3);
               stmt.setString(11, (String)parms[16], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

