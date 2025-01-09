package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_deducciones_impl extends GXDataArea
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
         gx4asaclicod2372( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel10"+"_"+"LEGDEDSEC") == 0 )
      {
         AV10LegDedSec = (int)(GXutil.lval( httpContext.GetPar( "LegDedSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegDedSec), 8, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGDEDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegDedSec), "ZZZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx10asalegdedsec2372( AV10LegDedSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"LEGDEDSEC") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx11asalegdedsec2372( AV7CliCod, AV8EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_31") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A84LegDedConCodigo = httpContext.GetPar( "LegDedConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_31( A3CliCod, A84LegDedConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_30") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_30( A3CliCod, A1EmpCod, A6LegNumero) ;
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
            AV9LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
            AV10LegDedSec = (int)(GXutil.lval( httpContext.GetPar( "LegDedSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegDedSec), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGDEDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegDedSec), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "legajo_deducciones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public legajo_deducciones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_deducciones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_deducciones_impl.class ));
   }

   public legajo_deducciones_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbLegDedTipo = new HTMLChoice();
      cmbLegDedConCodigo = new HTMLChoice();
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
      if ( cmbLegDedTipo.getItemCount() > 0 )
      {
         A1553LegDedTipo = cmbLegDedTipo.getValidValue(A1553LegDedTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegDedTipo.setValue( GXutil.rtrim( A1553LegDedTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegDedTipo.getInternalname(), "Values", cmbLegDedTipo.ToJavascriptSource(), true);
      }
      if ( cmbLegDedConCodigo.getItemCount() > 0 )
      {
         A84LegDedConCodigo = cmbLegDedConCodigo.getValidValue(A84LegDedConCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegDedConCodigo.setValue( GXutil.rtrim( A84LegDedConCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegDedConCodigo.getInternalname(), "Values", cmbLegDedConCodigo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegDedTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbLegDedTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegDedTipo, cmbLegDedTipo.getInternalname(), GXutil.rtrim( A1553LegDedTipo), 1, cmbLegDedTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLegDedTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_legajo_deducciones.htm");
      cmbLegDedTipo.setValue( GXutil.rtrim( A1553LegDedTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedTipo.getInternalname(), "Values", cmbLegDedTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblocklegnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
      ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
      ucCombo_legnumero.setProperty("DataListProc", Combo_legnumero_Datalistproc);
      ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
      ucCombo_legnumero.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_legnumero.setProperty("DropDownOptionsData", AV18LegNumero_Data);
      ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, "COMBO_LEGNUMEROContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLegDedConCodigo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbLegDedConCodigo.getInternalname(), httpContext.getMessage( "Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegDedConCodigo, cmbLegDedConCodigo.getInternalname(), GXutil.rtrim( A84LegDedConCodigo), 1, cmbLegDedConCodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLegDedConCodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_legajo_deducciones.htm");
      cmbLegDedConCodigo.setValue( GXutil.rtrim( A84LegDedConCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedConCodigo.getInternalname(), "Values", cmbLegDedConCodigo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedFchDes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedFchDes_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegDedFchDes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedFchDes_Internalname, localUtil.format(A556LegDedFchDes, "99/99/99"), localUtil.format( A556LegDedFchDes, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedFchDes_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegDedFchDes_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegDedFchDes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegDedFchDes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_deducciones.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedFchHas_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedFchHas_Internalname, httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegDedFchHas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedFchHas_Internalname, localUtil.format(A557LegDedFchHas, "99/99/99"), localUtil.format( A557LegDedFchHas, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedFchHas_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegDedFchHas_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegDedFchHas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegDedFchHas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_deducciones.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLegDedDescrip_Internalname, A568LegDedDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", (short)(0), 1, edtLegDedDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedImporte_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedImporte_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegDedImporte_Enabled!=0) ? localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegDedImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedFile_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedFile_Internalname, httpContext.getMessage( "Archivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      edtLegDedFile_Filetype = "tmp" ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "Filetype", edtLegDedFile_Filetype, true);
      if ( ! (GXutil.strcmp("", A1555LegDedFile)==0) )
      {
         gxblobfileaux.setSource( A1555LegDedFile );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtLegDedFile_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtLegDedFile_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A1555LegDedFile = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_attri("", false, "A1555LegDedFile", A1555LegDedFile);
            httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "URL", httpContext.getResourceRelative(A1555LegDedFile), true);
            edtLegDedFile_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "Filetype", edtLegDedFile_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "URL", httpContext.getResourceRelative(A1555LegDedFile), true);
      }
      web.GxWebStd.gx_blob_field( httpContext, edtLegDedFile_Internalname, GXutil.rtrim( A1555LegDedFile), httpContext.getResourceRelative(A1555LegDedFile), ((GXutil.strcmp("", edtLegDedFile_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtLegDedFile_Filetype)==0) ? A1555LegDedFile : edtLegDedFile_Filetype)) : edtLegDedFile_Contenttype), false, "", edtLegDedFile_Parameters, 0, edtLegDedFile_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtLegDedFile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", "", "HLP_legajo_deducciones.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_deducciones.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_legnumero_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombolegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombolegnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboLegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboLegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombolegnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombolegnumero_Visible, edtavCombolegnumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_deducciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_deducciones.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_legajo_deducciones.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedSec_Internalname, GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A83LegDedSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLegDedSec_Visible, edtLegDedSec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_deducciones.htm");
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
      e11232 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV18LegNumero_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z83LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z83LegDedSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z767LegDedMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z767LegDedMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z768LegDedAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z768LegDedAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z556LegDedFchDes = localUtil.ctod( httpContext.cgiGet( "Z556LegDedFchDes"), 0) ;
            Z557LegDedFchHas = localUtil.ctod( httpContext.cgiGet( "Z557LegDedFchHas"), 0) ;
            Z560LegDedImporte = localUtil.ctond( httpContext.cgiGet( "Z560LegDedImporte")) ;
            Z568LegDedDescrip = httpContext.cgiGet( "Z568LegDedDescrip") ;
            Z864LegDedCodSiradig = (byte)(localUtil.ctol( httpContext.cgiGet( "Z864LegDedCodSiradig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z870LegDedCodMot = httpContext.cgiGet( "Z870LegDedCodMot") ;
            Z1080LegDedUsado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1080LegDedUsado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1081LegDedNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( "Z1081LegDedNroLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1553LegDedTipo = httpContext.cgiGet( "Z1553LegDedTipo") ;
            Z1558LegDedFileNom = httpContext.cgiGet( "Z1558LegDedFileNom") ;
            Z1559LegDedFileExt = httpContext.cgiGet( "Z1559LegDedFileExt") ;
            Z84LegDedConCodigo = httpContext.cgiGet( "Z84LegDedConCodigo") ;
            A767LegDedMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z767LegDedMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A768LegDedAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z768LegDedAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A864LegDedCodSiradig = (byte)(localUtil.ctol( httpContext.cgiGet( "Z864LegDedCodSiradig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A870LegDedCodMot = httpContext.cgiGet( "Z870LegDedCodMot") ;
            A1080LegDedUsado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1080LegDedUsado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1081LegDedNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( "Z1081LegDedNroLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1558LegDedFileNom = httpContext.cgiGet( "Z1558LegDedFileNom") ;
            A1559LegDedFileExt = httpContext.cgiGet( "Z1559LegDedFileExt") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N84LegDedConCodigo = httpContext.cgiGet( "N84LegDedConCodigo") ;
            A559LegDedConDescrip = httpContext.cgiGet( "LEGDEDCONDESCRIP") ;
            A570LegDedConCodYDesc = httpContext.cgiGet( "LEGDEDCONCODYDESC") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGDEDSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV16Insert_LegDedConCodigo = httpContext.cgiGet( "vINSERT_LEGDEDCONCODIGO") ;
            A767LegDedMes = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGDEDMES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A768LegDedAnio = (short)(localUtil.ctol( httpContext.cgiGet( "LEGDEDANIO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A864LegDedCodSiradig = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGDEDCODSIRADIG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A870LegDedCodMot = httpContext.cgiGet( "LEGDEDCODMOT") ;
            A1080LegDedUsado = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGDEDUSADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1081LegDedNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( "LEGDEDNROLIQ"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1558LegDedFileNom = httpContext.cgiGet( "LEGDEDFILENOM") ;
            A1559LegDedFileExt = httpContext.cgiGet( "LEGDEDFILEEXT") ;
            A250LegIdNomApe = httpContext.cgiGet( "LEGIDNOMAPE") ;
            A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
            A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
            A93LegId = httpContext.cgiGet( "LEGID") ;
            n93LegId = false ;
            AV33Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_legnumero_Objectcall = httpContext.cgiGet( "COMBO_LEGNUMERO_Objectcall") ;
            Combo_legnumero_Class = httpContext.cgiGet( "COMBO_LEGNUMERO_Class") ;
            Combo_legnumero_Icontype = httpContext.cgiGet( "COMBO_LEGNUMERO_Icontype") ;
            Combo_legnumero_Icon = httpContext.cgiGet( "COMBO_LEGNUMERO_Icon") ;
            Combo_legnumero_Caption = httpContext.cgiGet( "COMBO_LEGNUMERO_Caption") ;
            Combo_legnumero_Tooltip = httpContext.cgiGet( "COMBO_LEGNUMERO_Tooltip") ;
            Combo_legnumero_Cls = httpContext.cgiGet( "COMBO_LEGNUMERO_Cls") ;
            Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_set") ;
            Combo_legnumero_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_get") ;
            Combo_legnumero_Selectedtext_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedtext_set") ;
            Combo_legnumero_Selectedtext_get = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedtext_get") ;
            Combo_legnumero_Gamoauthtoken = httpContext.cgiGet( "COMBO_LEGNUMERO_Gamoauthtoken") ;
            Combo_legnumero_Ddointernalname = httpContext.cgiGet( "COMBO_LEGNUMERO_Ddointernalname") ;
            Combo_legnumero_Titlecontrolalign = httpContext.cgiGet( "COMBO_LEGNUMERO_Titlecontrolalign") ;
            Combo_legnumero_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LEGNUMERO_Dropdownoptionstype") ;
            Combo_legnumero_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Enabled")) ;
            Combo_legnumero_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Visible")) ;
            Combo_legnumero_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LEGNUMERO_Titlecontrolidtoreplace") ;
            Combo_legnumero_Datalisttype = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalisttype") ;
            Combo_legnumero_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Allowmultipleselection")) ;
            Combo_legnumero_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistfixedvalues") ;
            Combo_legnumero_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Isgriditem")) ;
            Combo_legnumero_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Hasdescription")) ;
            Combo_legnumero_Datalistproc = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistproc") ;
            Combo_legnumero_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistprocparametersprefix") ;
            Combo_legnumero_Remoteservicesparameters = httpContext.cgiGet( "COMBO_LEGNUMERO_Remoteservicesparameters") ;
            Combo_legnumero_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_legnumero_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeonlyselectedoption")) ;
            Combo_legnumero_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeselectalloption")) ;
            Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitem")) ;
            Combo_legnumero_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeaddnewoption")) ;
            Combo_legnumero_Htmltemplate = httpContext.cgiGet( "COMBO_LEGNUMERO_Htmltemplate") ;
            Combo_legnumero_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluestype") ;
            Combo_legnumero_Loadingdata = httpContext.cgiGet( "COMBO_LEGNUMERO_Loadingdata") ;
            Combo_legnumero_Noresultsfound = httpContext.cgiGet( "COMBO_LEGNUMERO_Noresultsfound") ;
            Combo_legnumero_Emptyitemtext = httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitemtext") ;
            Combo_legnumero_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LEGNUMERO_Onlyselectedvalues") ;
            Combo_legnumero_Selectalltext = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectalltext") ;
            Combo_legnumero_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluesseparator") ;
            Combo_legnumero_Addnewoptiontext = httpContext.cgiGet( "COMBO_LEGNUMERO_Addnewoptiontext") ;
            Combo_legnumero_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGNUMERO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            edtLegDedFile_Filename = httpContext.cgiGet( "LEGDEDFILE_Filename") ;
            edtLegDedFile_Filetype = httpContext.cgiGet( "LEGDEDFILE_Filetype") ;
            /* Read variables values. */
            cmbLegDedTipo.setValue( httpContext.cgiGet( cmbLegDedTipo.getInternalname()) );
            A1553LegDedTipo = httpContext.cgiGet( cmbLegDedTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6LegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            else
            {
               A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            cmbLegDedConCodigo.setValue( httpContext.cgiGet( cmbLegDedConCodigo.getInternalname()) );
            A84LegDedConCodigo = httpContext.cgiGet( cmbLegDedConCodigo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegDedFchDes_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGDEDFCHDES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegDedFchDes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A556LegDedFchDes = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
            }
            else
            {
               A556LegDedFchDes = localUtil.ctod( httpContext.cgiGet( edtLegDedFchDes_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegDedFchHas_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGDEDFCHHAS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegDedFchHas_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A557LegDedFchHas = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
            }
            else
            {
               A557LegDedFchHas = localUtil.ctod( httpContext.cgiGet( edtLegDedFchHas_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
            }
            A568LegDedDescrip = httpContext.cgiGet( edtLegDedDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLegDedImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLegDedImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGDEDIMPORTE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegDedImporte_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A560LegDedImporte = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
            }
            else
            {
               A560LegDedImporte = localUtil.ctond( httpContext.cgiGet( edtLegDedImporte_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
            }
            A1555LegDedFile = httpContext.cgiGet( edtLegDedFile_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1555LegDedFile", A1555LegDedFile);
            AV23ComboLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombolegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegDedSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegDedSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGDEDSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegDedSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A83LegDedSec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            }
            else
            {
               A83LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLegDedSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            if ( ! (GXutil.strcmp("", A1555LegDedFile)==0) )
            {
               edtLegDedFile_Filename = httpContext.cgiGetFileName( edtLegDedFile_Internalname) ;
               edtLegDedFile_Filetype = httpContext.cgiGetFileType( edtLegDedFile_Internalname) ;
            }
            if ( (GXutil.strcmp("", A1555LegDedFile)==0) )
            {
               GXCCtlgxBlob = "LEGDEDFILE" + "_gxBlob" ;
               A1555LegDedFile = httpContext.cgiGet( GXCCtlgxBlob) ;
            }
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"legajo_deducciones");
            A1553LegDedTipo = httpContext.cgiGet( cmbLegDedTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
            forbiddenHiddens.add("LegDedTipo", GXutil.rtrim( localUtil.format( A1553LegDedTipo, "")));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LegDedCodSiradig", localUtil.format( DecimalUtil.doubleToDec(A864LegDedCodSiradig), "Z9"));
            forbiddenHiddens.add("LegDedCodMot", GXutil.rtrim( localUtil.format( A870LegDedCodMot, "")));
            forbiddenHiddens.add("LegDedUsado", localUtil.format( DecimalUtil.doubleToDec(A1080LegDedUsado), "9"));
            forbiddenHiddens.add("LegDedNroLiq", localUtil.format( DecimalUtil.doubleToDec(A1081LegDedNroLiq), "ZZZZZZZ9"));
            forbiddenHiddens.add("LegDedFileNom", GXutil.rtrim( localUtil.format( A1558LegDedFileNom, "")));
            forbiddenHiddens.add("LegDedFileExt", GXutil.rtrim( localUtil.format( A1559LegDedFileExt, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("legajo_deducciones:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A83LegDedSec = (int)(GXutil.lval( httpContext.GetPar( "LegDedSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
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
                  sMode72 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode72 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound72 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_230( ) ;
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
                        e11232 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12232 ();
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
         e12232 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2372( ) ;
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
         disableAttributes2372( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Enabled), 5, 0), true);
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

   public void confirm_230( )
   {
      beforeValidate2372( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2372( ) ;
         }
         else
         {
            checkExtendedTable2372( ) ;
            closeExtendedTableCursors2372( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption230( )
   {
   }

   public void e11232( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      AV23ComboLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
      edtavCombolegnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Insert", GXv_boolean5) ;
         legajo_deducciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Update", GXv_boolean5) ;
         legajo_deducciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Delete", GXv_boolean5) ;
         legajo_deducciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV33Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV33Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV34GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34GXV1), 8, 0));
         while ( AV34GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV34GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegDedConCodigo") == 0 )
            {
               AV16Insert_LegDedConCodigo = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_LegDedConCodigo", AV16Insert_LegDedConCodigo);
            }
            AV34GXV1 = (int)(AV34GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLegDedSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Visible), 5, 0), true);
      GXv_objcol_char6[0] = AV29reintegrosConcodigo ;
      new web.getconceptosreintegros(remoteHandle, context).execute( AV7CliCod, GXv_objcol_char6) ;
      AV29reintegrosConcodigo = GXv_objcol_char6[0] ;
      AV30i = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30i), 4, 0));
      while ( AV30i <= AV29reintegrosConcodigo.size() )
      {
         GXv_char7[0] = AV31ConDescrip ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV7CliCod, (String)AV29reintegrosConcodigo.elementAt(-1+AV30i), GXv_char7) ;
         legajo_deducciones_impl.this.AV31ConDescrip = GXv_char7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31ConDescrip", AV31ConDescrip);
         cmbLegDedConCodigo.addItem((String)AV29reintegrosConcodigo.elementAt(-1+AV30i), AV31ConDescrip, (short)(0));
         AV30i = (short)(AV30i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30i), 4, 0));
      }
   }

   public void e12232( )
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
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      Combo_legnumero_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"LegNumero\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0, \"LegNumero\": 0, \"LegDedSec\": 0, \"Cond_CliCod\": \"#%1#\", \"Cond_EmpCod\": \"#%2#\"", edtCliCod_Internalname, edtEmpCod_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "DataListProcParametersPrefix", Combo_legnumero_Datalistprocparametersprefix);
      GXt_char8 = AV22Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char9[0] = AV21ComboSelectedText ;
      GXv_char10[0] = GXt_char8 ;
      new web.legajo_deduccionesloaddvcombo(remoteHandle, context).execute( "LegNumero", Gx_mode, false, AV7CliCod, AV8EmpCod, AV9LegNumero, AV10LegDedSec, A3CliCod, A1EmpCod, "", GXv_char7, GXv_char9, GXv_char10) ;
      legajo_deducciones_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      legajo_deducciones_impl.this.AV21ComboSelectedText = GXv_char9[0] ;
      legajo_deducciones_impl.this.GXt_char8 = GXv_char10[0] ;
      AV22Combo_DataJson = GXt_char8 ;
      Combo_legnumero_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
      Combo_legnumero_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedText_set", Combo_legnumero_Selectedtext_set);
      AV23ComboLegNumero = (int)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV9LegNumero) )
      {
         Combo_legnumero_Enabled = false ;
         ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      }
   }

   public void zm2372( int GX_JID )
   {
      if ( ( GX_JID == 29 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z767LegDedMes = T00233_A767LegDedMes[0] ;
            Z768LegDedAnio = T00233_A768LegDedAnio[0] ;
            Z556LegDedFchDes = T00233_A556LegDedFchDes[0] ;
            Z557LegDedFchHas = T00233_A557LegDedFchHas[0] ;
            Z560LegDedImporte = T00233_A560LegDedImporte[0] ;
            Z568LegDedDescrip = T00233_A568LegDedDescrip[0] ;
            Z864LegDedCodSiradig = T00233_A864LegDedCodSiradig[0] ;
            Z870LegDedCodMot = T00233_A870LegDedCodMot[0] ;
            Z1080LegDedUsado = T00233_A1080LegDedUsado[0] ;
            Z1081LegDedNroLiq = T00233_A1081LegDedNroLiq[0] ;
            Z1553LegDedTipo = T00233_A1553LegDedTipo[0] ;
            Z1558LegDedFileNom = T00233_A1558LegDedFileNom[0] ;
            Z1559LegDedFileExt = T00233_A1559LegDedFileExt[0] ;
            Z84LegDedConCodigo = T00233_A84LegDedConCodigo[0] ;
         }
         else
         {
            Z767LegDedMes = A767LegDedMes ;
            Z768LegDedAnio = A768LegDedAnio ;
            Z556LegDedFchDes = A556LegDedFchDes ;
            Z557LegDedFchHas = A557LegDedFchHas ;
            Z560LegDedImporte = A560LegDedImporte ;
            Z568LegDedDescrip = A568LegDedDescrip ;
            Z864LegDedCodSiradig = A864LegDedCodSiradig ;
            Z870LegDedCodMot = A870LegDedCodMot ;
            Z1080LegDedUsado = A1080LegDedUsado ;
            Z1081LegDedNroLiq = A1081LegDedNroLiq ;
            Z1553LegDedTipo = A1553LegDedTipo ;
            Z1558LegDedFileNom = A1558LegDedFileNom ;
            Z1559LegDedFileExt = A1559LegDedFileExt ;
            Z84LegDedConCodigo = A84LegDedConCodigo ;
         }
      }
      if ( GX_JID == -29 )
      {
         Z83LegDedSec = A83LegDedSec ;
         Z767LegDedMes = A767LegDedMes ;
         Z768LegDedAnio = A768LegDedAnio ;
         Z556LegDedFchDes = A556LegDedFchDes ;
         Z557LegDedFchHas = A557LegDedFchHas ;
         Z560LegDedImporte = A560LegDedImporte ;
         Z568LegDedDescrip = A568LegDedDescrip ;
         Z864LegDedCodSiradig = A864LegDedCodSiradig ;
         Z870LegDedCodMot = A870LegDedCodMot ;
         Z1080LegDedUsado = A1080LegDedUsado ;
         Z1081LegDedNroLiq = A1081LegDedNroLiq ;
         Z1553LegDedTipo = A1553LegDedTipo ;
         Z1555LegDedFile = A1555LegDedFile ;
         Z1558LegDedFileNom = A1558LegDedFileNom ;
         Z1559LegDedFileExt = A1559LegDedFileExt ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z84LegDedConCodigo = A84LegDedConCodigo ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z559LegDedConDescrip = A559LegDedConDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      cmbLegDedTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedTipo.getEnabled(), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      cmbLegDedTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedTipo.getEnabled(), 5, 0), true);
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
            GXt_int11 = A3CliCod ;
            GXv_int12[0] = GXt_int11 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int12) ;
            legajo_deducciones_impl.this.GXt_int11 = GXv_int12[0] ;
            A3CliCod = GXt_int11 ;
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
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegDedSec) )
      {
         A83LegDedSec = AV10LegDedSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
      if ( ! (0==AV10LegDedSec) )
      {
         edtLegDedSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Enabled), 5, 0), true);
      }
      else
      {
         edtLegDedSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegDedSec) )
      {
         edtLegDedSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      else
      {
         A6LegNumero = AV23ComboLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_LegDedConCodigo)==0) )
      {
         cmbLegDedConCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegDedConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedConCodigo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbLegDedConCodigo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegDedConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedConCodigo.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_LegDedConCodigo)==0) )
      {
         A84LegDedConCodigo = AV16Insert_LegDedConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
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
      if ( isIns( )  && (GXutil.strcmp("", A1553LegDedTipo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1553LegDedTipo = "reintegro" ;
         httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV33Pgmname = "legajo_deducciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
         /* Using cursor T00234 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T00234_A250LegIdNomApe[0] ;
         A251LegNombre = T00234_A251LegNombre[0] ;
         A251LegNombre = T00234_A251LegNombre[0] ;
         A230LegApellido = T00234_A230LegApellido[0] ;
         A230LegApellido = T00234_A230LegApellido[0] ;
         A93LegId = T00234_A93LegId[0] ;
         n93LegId = T00234_n93LegId[0] ;
         A93LegId = T00234_A93LegId[0] ;
         n93LegId = T00234_n93LegId[0] ;
         pr_default.close(2);
         /* Using cursor T00235 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
         A559LegDedConDescrip = T00235_A559LegDedConDescrip[0] ;
         pr_default.close(3);
         A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      }
   }

   public void load2372( )
   {
      /* Using cursor T00236 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A250LegIdNomApe = T00236_A250LegIdNomApe[0] ;
         A767LegDedMes = T00236_A767LegDedMes[0] ;
         A768LegDedAnio = T00236_A768LegDedAnio[0] ;
         A556LegDedFchDes = T00236_A556LegDedFchDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
         A557LegDedFchHas = T00236_A557LegDedFchHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
         A559LegDedConDescrip = T00236_A559LegDedConDescrip[0] ;
         A560LegDedImporte = T00236_A560LegDedImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
         A568LegDedDescrip = T00236_A568LegDedDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
         A864LegDedCodSiradig = T00236_A864LegDedCodSiradig[0] ;
         A870LegDedCodMot = T00236_A870LegDedCodMot[0] ;
         A1080LegDedUsado = T00236_A1080LegDedUsado[0] ;
         A1081LegDedNroLiq = T00236_A1081LegDedNroLiq[0] ;
         A1553LegDedTipo = T00236_A1553LegDedTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
         A1555LegDedFile = T00236_A1555LegDedFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1555LegDedFile", A1555LegDedFile);
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "URL", httpContext.getResourceRelative(A1555LegDedFile), true);
         A1558LegDedFileNom = T00236_A1558LegDedFileNom[0] ;
         A1559LegDedFileExt = T00236_A1559LegDedFileExt[0] ;
         A251LegNombre = T00236_A251LegNombre[0] ;
         A230LegApellido = T00236_A230LegApellido[0] ;
         A93LegId = T00236_A93LegId[0] ;
         n93LegId = T00236_n93LegId[0] ;
         A84LegDedConCodigo = T00236_A84LegDedConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
         zm2372( -29) ;
      }
      pr_default.close(4);
      onLoadActions2372( ) ;
   }

   public void onLoadActions2372( )
   {
      AV33Pgmname = "legajo_deducciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      if ( isIns( )  )
      {
         A767LegDedMes = (byte)(GXutil.month( A556LegDedFchDes)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A767LegDedMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A767LegDedMes), 2, 0));
      }
      if ( isIns( )  )
      {
         A768LegDedAnio = (short)(GXutil.year( A556LegDedFchDes)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A768LegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A768LegDedAnio), 4, 0));
      }
   }

   public void checkExtendedTable2372( )
   {
      nIsDirty_72 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV33Pgmname = "legajo_deducciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      /* Using cursor T00235 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A559LegDedConDescrip = T00235_A559LegDedConDescrip[0] ;
      pr_default.close(3);
      nIsDirty_72 = (short)(1) ;
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      /* Using cursor T00234 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T00234_A250LegIdNomApe[0] ;
      A251LegNombre = T00234_A251LegNombre[0] ;
      A251LegNombre = T00234_A251LegNombre[0] ;
      A230LegApellido = T00234_A230LegApellido[0] ;
      A230LegApellido = T00234_A230LegApellido[0] ;
      A93LegId = T00234_A93LegId[0] ;
      n93LegId = T00234_n93LegId[0] ;
      A93LegId = T00234_A93LegId[0] ;
      n93LegId = T00234_n93LegId[0] ;
      pr_default.close(2);
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isIns( )  )
      {
         nIsDirty_72 = (short)(1) ;
         A767LegDedMes = (byte)(GXutil.month( A556LegDedFchDes)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A767LegDedMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A767LegDedMes), 2, 0));
      }
      if ( isIns( )  )
      {
         nIsDirty_72 = (short)(1) ;
         A768LegDedAnio = (short)(GXutil.year( A556LegDedFchDes)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A768LegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A768LegDedAnio), 4, 0));
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A556LegDedFchDes)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Desde", ""), "", "", "", "", "", "", "", ""), 1, "LEGDEDFCHDES");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegDedFchDes_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A557LegDedFchHas)) && GXutil.resetTime(A556LegDedFchDes).after( GXutil.resetTime( A557LegDedFchHas )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 1, "LEGDEDFCHDES");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegDedFchDes_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A84LegDedConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLegDedConCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A560LegDedImporte)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Importe", ""), "", "", "", "", "", "", "", ""), 1, "LEGDEDIMPORTE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegDedImporte_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2372( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_31( int A3CliCod ,
                          String A84LegDedConCodigo )
   {
      /* Using cursor T00237 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A559LegDedConDescrip = T00237_A559LegDedConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A559LegDedConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_30( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T00238 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T00238_A250LegIdNomApe[0] ;
      A251LegNombre = T00238_A251LegNombre[0] ;
      A251LegNombre = T00238_A251LegNombre[0] ;
      A230LegApellido = T00238_A230LegApellido[0] ;
      A230LegApellido = T00238_A230LegApellido[0] ;
      A93LegId = T00238_A93LegId[0] ;
      n93LegId = T00238_n93LegId[0] ;
      A93LegId = T00238_A93LegId[0] ;
      n93LegId = T00238_n93LegId[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A250LegIdNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey2372( )
   {
      /* Using cursor T00239 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound72 = (short)(1) ;
      }
      else
      {
         RcdFound72 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00233 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2372( 29) ;
         RcdFound72 = (short)(1) ;
         A83LegDedSec = T00233_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
         A767LegDedMes = T00233_A767LegDedMes[0] ;
         A768LegDedAnio = T00233_A768LegDedAnio[0] ;
         A556LegDedFchDes = T00233_A556LegDedFchDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
         A557LegDedFchHas = T00233_A557LegDedFchHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
         A560LegDedImporte = T00233_A560LegDedImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
         A568LegDedDescrip = T00233_A568LegDedDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
         A864LegDedCodSiradig = T00233_A864LegDedCodSiradig[0] ;
         A870LegDedCodMot = T00233_A870LegDedCodMot[0] ;
         A1080LegDedUsado = T00233_A1080LegDedUsado[0] ;
         A1081LegDedNroLiq = T00233_A1081LegDedNroLiq[0] ;
         A1553LegDedTipo = T00233_A1553LegDedTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
         A1555LegDedFile = T00233_A1555LegDedFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1555LegDedFile", A1555LegDedFile);
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "URL", httpContext.getResourceRelative(A1555LegDedFile), true);
         A1558LegDedFileNom = T00233_A1558LegDedFileNom[0] ;
         A1559LegDedFileExt = T00233_A1559LegDedFileExt[0] ;
         A3CliCod = T00233_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00233_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T00233_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A84LegDedConCodigo = T00233_A84LegDedConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z83LegDedSec = A83LegDedSec ;
         sMode72 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2372( ) ;
         if ( AnyError == 1 )
         {
            RcdFound72 = (short)(0) ;
            initializeNonKey2372( ) ;
         }
         Gx_mode = sMode72 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound72 = (short)(0) ;
         initializeNonKey2372( ) ;
         sMode72 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode72 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2372( ) ;
      if ( RcdFound72 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound72 = (short)(0) ;
      /* Using cursor T002310 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002310_A83LegDedSec[0] < A83LegDedSec ) || ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A3CliCod[0] < A3CliCod ) || ( T002310_A3CliCod[0] == A3CliCod ) && ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A1EmpCod[0] < A1EmpCod ) || ( T002310_A1EmpCod[0] == A1EmpCod ) && ( T002310_A3CliCod[0] == A3CliCod ) && ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002310_A83LegDedSec[0] > A83LegDedSec ) || ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A3CliCod[0] > A3CliCod ) || ( T002310_A3CliCod[0] == A3CliCod ) && ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A1EmpCod[0] > A1EmpCod ) || ( T002310_A1EmpCod[0] == A1EmpCod ) && ( T002310_A3CliCod[0] == A3CliCod ) && ( T002310_A83LegDedSec[0] == A83LegDedSec ) && ( T002310_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A83LegDedSec = T002310_A83LegDedSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            A3CliCod = T002310_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002310_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002310_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound72 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound72 = (short)(0) ;
      /* Using cursor T002311 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002311_A83LegDedSec[0] > A83LegDedSec ) || ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A3CliCod[0] > A3CliCod ) || ( T002311_A3CliCod[0] == A3CliCod ) && ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A1EmpCod[0] > A1EmpCod ) || ( T002311_A1EmpCod[0] == A1EmpCod ) && ( T002311_A3CliCod[0] == A3CliCod ) && ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002311_A83LegDedSec[0] < A83LegDedSec ) || ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A3CliCod[0] < A3CliCod ) || ( T002311_A3CliCod[0] == A3CliCod ) && ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A1EmpCod[0] < A1EmpCod ) || ( T002311_A1EmpCod[0] == A1EmpCod ) && ( T002311_A3CliCod[0] == A3CliCod ) && ( T002311_A83LegDedSec[0] == A83LegDedSec ) && ( T002311_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A83LegDedSec = T002311_A83LegDedSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            A3CliCod = T002311_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002311_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002311_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound72 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2372( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2372( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound72 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A83LegDedSec = Z83LegDedSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2372( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2372( ) ;
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
                  GX_FocusControl = edtLegNumero_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2372( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A83LegDedSec = Z83LegDedSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2372( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00232 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z767LegDedMes != T00232_A767LegDedMes[0] ) || ( Z768LegDedAnio != T00232_A768LegDedAnio[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z556LegDedFchDes), GXutil.resetTime(T00232_A556LegDedFchDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z557LegDedFchHas), GXutil.resetTime(T00232_A557LegDedFchHas[0])) ) || ( DecimalUtil.compareTo(Z560LegDedImporte, T00232_A560LegDedImporte[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z568LegDedDescrip, T00232_A568LegDedDescrip[0]) != 0 ) || ( Z864LegDedCodSiradig != T00232_A864LegDedCodSiradig[0] ) || ( GXutil.strcmp(Z870LegDedCodMot, T00232_A870LegDedCodMot[0]) != 0 ) || ( Z1080LegDedUsado != T00232_A1080LegDedUsado[0] ) || ( Z1081LegDedNroLiq != T00232_A1081LegDedNroLiq[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1553LegDedTipo, T00232_A1553LegDedTipo[0]) != 0 ) || ( GXutil.strcmp(Z1558LegDedFileNom, T00232_A1558LegDedFileNom[0]) != 0 ) || ( GXutil.strcmp(Z1559LegDedFileExt, T00232_A1559LegDedFileExt[0]) != 0 ) || ( GXutil.strcmp(Z84LegDedConCodigo, T00232_A84LegDedConCodigo[0]) != 0 ) )
         {
            if ( Z767LegDedMes != T00232_A767LegDedMes[0] )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedMes");
               GXutil.writeLogRaw("Old: ",Z767LegDedMes);
               GXutil.writeLogRaw("Current: ",T00232_A767LegDedMes[0]);
            }
            if ( Z768LegDedAnio != T00232_A768LegDedAnio[0] )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedAnio");
               GXutil.writeLogRaw("Old: ",Z768LegDedAnio);
               GXutil.writeLogRaw("Current: ",T00232_A768LegDedAnio[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z556LegDedFchDes), GXutil.resetTime(T00232_A556LegDedFchDes[0])) ) )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedFchDes");
               GXutil.writeLogRaw("Old: ",Z556LegDedFchDes);
               GXutil.writeLogRaw("Current: ",T00232_A556LegDedFchDes[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z557LegDedFchHas), GXutil.resetTime(T00232_A557LegDedFchHas[0])) ) )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedFchHas");
               GXutil.writeLogRaw("Old: ",Z557LegDedFchHas);
               GXutil.writeLogRaw("Current: ",T00232_A557LegDedFchHas[0]);
            }
            if ( DecimalUtil.compareTo(Z560LegDedImporte, T00232_A560LegDedImporte[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedImporte");
               GXutil.writeLogRaw("Old: ",Z560LegDedImporte);
               GXutil.writeLogRaw("Current: ",T00232_A560LegDedImporte[0]);
            }
            if ( GXutil.strcmp(Z568LegDedDescrip, T00232_A568LegDedDescrip[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedDescrip");
               GXutil.writeLogRaw("Old: ",Z568LegDedDescrip);
               GXutil.writeLogRaw("Current: ",T00232_A568LegDedDescrip[0]);
            }
            if ( Z864LegDedCodSiradig != T00232_A864LegDedCodSiradig[0] )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedCodSiradig");
               GXutil.writeLogRaw("Old: ",Z864LegDedCodSiradig);
               GXutil.writeLogRaw("Current: ",T00232_A864LegDedCodSiradig[0]);
            }
            if ( GXutil.strcmp(Z870LegDedCodMot, T00232_A870LegDedCodMot[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedCodMot");
               GXutil.writeLogRaw("Old: ",Z870LegDedCodMot);
               GXutil.writeLogRaw("Current: ",T00232_A870LegDedCodMot[0]);
            }
            if ( Z1080LegDedUsado != T00232_A1080LegDedUsado[0] )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedUsado");
               GXutil.writeLogRaw("Old: ",Z1080LegDedUsado);
               GXutil.writeLogRaw("Current: ",T00232_A1080LegDedUsado[0]);
            }
            if ( Z1081LegDedNroLiq != T00232_A1081LegDedNroLiq[0] )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedNroLiq");
               GXutil.writeLogRaw("Old: ",Z1081LegDedNroLiq);
               GXutil.writeLogRaw("Current: ",T00232_A1081LegDedNroLiq[0]);
            }
            if ( GXutil.strcmp(Z1553LegDedTipo, T00232_A1553LegDedTipo[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedTipo");
               GXutil.writeLogRaw("Old: ",Z1553LegDedTipo);
               GXutil.writeLogRaw("Current: ",T00232_A1553LegDedTipo[0]);
            }
            if ( GXutil.strcmp(Z1558LegDedFileNom, T00232_A1558LegDedFileNom[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedFileNom");
               GXutil.writeLogRaw("Old: ",Z1558LegDedFileNom);
               GXutil.writeLogRaw("Current: ",T00232_A1558LegDedFileNom[0]);
            }
            if ( GXutil.strcmp(Z1559LegDedFileExt, T00232_A1559LegDedFileExt[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedFileExt");
               GXutil.writeLogRaw("Old: ",Z1559LegDedFileExt);
               GXutil.writeLogRaw("Current: ",T00232_A1559LegDedFileExt[0]);
            }
            if ( GXutil.strcmp(Z84LegDedConCodigo, T00232_A84LegDedConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajo_deducciones:[seudo value changed for attri]"+"LegDedConCodigo");
               GXutil.writeLogRaw("Old: ",Z84LegDedConCodigo);
               GXutil.writeLogRaw("Current: ",T00232_A84LegDedConCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_deducciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2372( )
   {
      beforeValidate2372( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2372( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2372( 0) ;
         checkOptimisticConcurrency2372( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2372( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2372( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002312 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A83LegDedSec), Byte.valueOf(A767LegDedMes), Short.valueOf(A768LegDedAnio), A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, Byte.valueOf(A864LegDedCodSiradig), A870LegDedCodMot, Byte.valueOf(A1080LegDedUsado), Integer.valueOf(A1081LegDedNroLiq), A1553LegDedTipo, A1555LegDedFile, A1558LegDedFileNom, A1559LegDedFileExt, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A84LegDedConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
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
                        resetCaption230( ) ;
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
            load2372( ) ;
         }
         endLevel2372( ) ;
      }
      closeExtendedTableCursors2372( ) ;
   }

   public void update2372( )
   {
      beforeValidate2372( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2372( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2372( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2372( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2372( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002313 */
                  pr_default.execute(11, new Object[] {Byte.valueOf(A767LegDedMes), Short.valueOf(A768LegDedAnio), A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, Byte.valueOf(A864LegDedCodSiradig), A870LegDedCodMot, Byte.valueOf(A1080LegDedUsado), Integer.valueOf(A1081LegDedNroLiq), A1553LegDedTipo, A1558LegDedFileNom, A1559LegDedFileExt, A84LegDedConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2372( ) ;
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
         endLevel2372( ) ;
      }
      closeExtendedTableCursors2372( ) ;
   }

   public void deferredUpdate2372( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T002314 */
         pr_default.execute(12, new Object[] {A1555LegDedFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
      }
   }

   public void delete( )
   {
      beforeValidate2372( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2372( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2372( ) ;
         afterConfirm2372( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2372( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002315 */
               pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
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
      sMode72 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2372( ) ;
      Gx_mode = sMode72 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2372( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV33Pgmname = "legajo_deducciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
         /* Using cursor T002316 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T002316_A250LegIdNomApe[0] ;
         A251LegNombre = T002316_A251LegNombre[0] ;
         A251LegNombre = T002316_A251LegNombre[0] ;
         A230LegApellido = T002316_A230LegApellido[0] ;
         A230LegApellido = T002316_A230LegApellido[0] ;
         A93LegId = T002316_A93LegId[0] ;
         n93LegId = T002316_n93LegId[0] ;
         A93LegId = T002316_A93LegId[0] ;
         n93LegId = T002316_n93LegId[0] ;
         pr_default.close(14);
         /* Using cursor T002317 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
         A559LegDedConDescrip = T002317_A559LegDedConDescrip[0] ;
         pr_default.close(15);
         A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      }
   }

   public void endLevel2372( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2372( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "legajo_deducciones");
         if ( AnyError == 0 )
         {
            confirmValues230( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "legajo_deducciones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2372( )
   {
      /* Scan By routine */
      /* Using cursor T002318 */
      pr_default.execute(16);
      RcdFound72 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A3CliCod = T002318_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002318_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002318_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A83LegDedSec = T002318_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2372( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound72 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A3CliCod = T002318_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002318_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002318_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A83LegDedSec = T002318_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
   }

   public void scanEnd2372( )
   {
      pr_default.close(16);
   }

   public void afterConfirm2372( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2372( )
   {
      /* Before Insert Rules */
      GXt_int11 = A83LegDedSec ;
      GXv_int12[0] = GXt_int11 ;
      new web.getnextdedsec(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int12) ;
      legajo_deducciones_impl.this.GXt_int11 = GXv_int12[0] ;
      A83LegDedSec = GXt_int11 ;
      httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
   }

   public void beforeUpdate2372( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2372( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2372( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2372( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2372( )
   {
      cmbLegDedTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedTipo.getEnabled(), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      cmbLegDedConCodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegDedConCodigo.getEnabled(), 5, 0), true);
      edtLegDedFchDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFchDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedFchDes_Enabled), 5, 0), true);
      edtLegDedFchHas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFchHas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedFchHas_Enabled), 5, 0), true);
      edtLegDedDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedDescrip_Enabled), 5, 0), true);
      edtLegDedImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedImporte_Enabled), 5, 0), true);
      edtLegDedFile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedFile_Enabled), 5, 0), true);
      edtavCombolegnumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegDedSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2372( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues230( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_deducciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegDedSec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegDedSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"legajo_deducciones");
      forbiddenHiddens.add("LegDedTipo", GXutil.rtrim( localUtil.format( A1553LegDedTipo, "")));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LegDedCodSiradig", localUtil.format( DecimalUtil.doubleToDec(A864LegDedCodSiradig), "Z9"));
      forbiddenHiddens.add("LegDedCodMot", GXutil.rtrim( localUtil.format( A870LegDedCodMot, "")));
      forbiddenHiddens.add("LegDedUsado", localUtil.format( DecimalUtil.doubleToDec(A1080LegDedUsado), "9"));
      forbiddenHiddens.add("LegDedNroLiq", localUtil.format( DecimalUtil.doubleToDec(A1081LegDedNroLiq), "ZZZZZZZ9"));
      forbiddenHiddens.add("LegDedFileNom", GXutil.rtrim( localUtil.format( A1558LegDedFileNom, "")));
      forbiddenHiddens.add("LegDedFileExt", GXutil.rtrim( localUtil.format( A1559LegDedFileExt, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("legajo_deducciones:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z83LegDedSec", GXutil.ltrim( localUtil.ntoc( Z83LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z767LegDedMes", GXutil.ltrim( localUtil.ntoc( Z767LegDedMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z768LegDedAnio", GXutil.ltrim( localUtil.ntoc( Z768LegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z556LegDedFchDes", localUtil.dtoc( Z556LegDedFchDes, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z557LegDedFchHas", localUtil.dtoc( Z557LegDedFchHas, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z560LegDedImporte", GXutil.ltrim( localUtil.ntoc( Z560LegDedImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z568LegDedDescrip", Z568LegDedDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z864LegDedCodSiradig", GXutil.ltrim( localUtil.ntoc( Z864LegDedCodSiradig, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z870LegDedCodMot", GXutil.rtrim( Z870LegDedCodMot));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1080LegDedUsado", GXutil.ltrim( localUtil.ntoc( Z1080LegDedUsado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1081LegDedNroLiq", GXutil.ltrim( localUtil.ntoc( Z1081LegDedNroLiq, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1553LegDedTipo", GXutil.rtrim( Z1553LegDedTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1558LegDedFileNom", Z1558LegDedFileNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1559LegDedFileExt", Z1559LegDedFileExt);
      web.GxWebStd.gx_hidden_field( httpContext, "Z84LegDedConCodigo", GXutil.rtrim( Z84LegDedConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N84LegDedConCodigo", GXutil.rtrim( A84LegDedConCodigo));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV18LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV18LegNumero_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDCONDESCRIP", A559LegDedConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDCONCODYDESC", A570LegDedConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGDEDSEC", GXutil.ltrim( localUtil.ntoc( AV10LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGDEDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegDedSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LEGDEDCONCODIGO", GXutil.rtrim( AV16Insert_LegDedConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDMES", GXutil.ltrim( localUtil.ntoc( A767LegDedMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDANIO", GXutil.ltrim( localUtil.ntoc( A768LegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDCODSIRADIG", GXutil.ltrim( localUtil.ntoc( A864LegDedCodSiradig, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDCODMOT", GXutil.rtrim( A870LegDedCodMot));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDUSADO", GXutil.ltrim( localUtil.ntoc( A1080LegDedUsado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDNROLIQ", GXutil.ltrim( localUtil.ntoc( A1081LegDedNroLiq, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDFILENOM", A1558LegDedFileNom);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDFILEEXT", A1559LegDedFileExt);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV33Pgmname));
      GXCCtlgxBlob = "LEGDEDFILE" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A1555LegDedFile);
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Objectcall", GXutil.rtrim( Combo_legnumero_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedtext_set", GXutil.rtrim( Combo_legnumero_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Datalistproc", GXutil.rtrim( Combo_legnumero_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Datalistprocparametersprefix", GXutil.rtrim( Combo_legnumero_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
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
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDFILE_Filename", GXutil.rtrim( edtLegDedFile_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGDEDFILE_Filetype", GXutil.rtrim( edtLegDedFile_Filetype));
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
      return formatLink("web.legajo_deducciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegDedSec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegDedSec"})  ;
   }

   public String getPgmname( )
   {
      return "legajo_deducciones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "legajo_deducciones", "") ;
   }

   public void initializeNonKey2372( )
   {
      A84LegDedConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
      A767LegDedMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A767LegDedMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A767LegDedMes), 2, 0));
      A768LegDedAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A768LegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A768LegDedAnio), 4, 0));
      A556LegDedFchDes = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
      A557LegDedFchHas = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
      A559LegDedConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A559LegDedConDescrip", A559LegDedConDescrip);
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A560LegDedImporte = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
      A568LegDedDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
      A570LegDedConCodYDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      A864LegDedCodSiradig = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A864LegDedCodSiradig", GXutil.ltrimstr( DecimalUtil.doubleToDec(A864LegDedCodSiradig), 2, 0));
      A870LegDedCodMot = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A870LegDedCodMot", A870LegDedCodMot);
      A1080LegDedUsado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1080LegDedUsado", GXutil.str( A1080LegDedUsado, 1, 0));
      A1081LegDedNroLiq = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1081LegDedNroLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1081LegDedNroLiq), 8, 0));
      A1555LegDedFile = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1555LegDedFile", A1555LegDedFile);
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFile_Internalname, "URL", httpContext.getResourceRelative(A1555LegDedFile), true);
      A1558LegDedFileNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1558LegDedFileNom", A1558LegDedFileNom);
      A1559LegDedFileExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1559LegDedFileExt", A1559LegDedFileExt);
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A1553LegDedTipo = "reintegro" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
      Z767LegDedMes = (byte)(0) ;
      Z768LegDedAnio = (short)(0) ;
      Z556LegDedFchDes = GXutil.nullDate() ;
      Z557LegDedFchHas = GXutil.nullDate() ;
      Z560LegDedImporte = DecimalUtil.ZERO ;
      Z568LegDedDescrip = "" ;
      Z864LegDedCodSiradig = (byte)(0) ;
      Z870LegDedCodMot = "" ;
      Z1080LegDedUsado = (byte)(0) ;
      Z1081LegDedNroLiq = 0 ;
      Z1553LegDedTipo = "" ;
      Z1558LegDedFileNom = "" ;
      Z1559LegDedFileExt = "" ;
      Z84LegDedConCodigo = "" ;
   }

   public void initAll2372( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A83LegDedSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      initializeNonKey2372( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1553LegDedTipo = i1553LegDedTipo ;
      httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713493513", true, true);
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
      httpContext.AddJavascriptSource("legajo_deducciones.js", "?20251713493513", false, true);
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
      cmbLegDedTipo.setInternalname( "LEGDEDTIPO" );
      lblTextblocklegnumero_Internalname = "TEXTBLOCKLEGNUMERO" ;
      Combo_legnumero_Internalname = "COMBO_LEGNUMERO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = "TABLESPLITTEDLEGNUMERO" ;
      cmbLegDedConCodigo.setInternalname( "LEGDEDCONCODIGO" );
      edtLegDedFchDes_Internalname = "LEGDEDFCHDES" ;
      edtLegDedFchHas_Internalname = "LEGDEDFCHHAS" ;
      edtLegDedDescrip_Internalname = "LEGDEDDESCRIP" ;
      edtLegDedImporte_Internalname = "LEGDEDIMPORTE" ;
      edtLegDedFile_Internalname = "LEGDEDFILE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombolegnumero_Internalname = "vCOMBOLEGNUMERO" ;
      divSectionattribute_legnumero_Internalname = "SECTIONATTRIBUTE_LEGNUMERO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegDedSec_Internalname = "LEGDEDSEC" ;
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
      edtLegDedFile_Filename = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "legajo_deducciones", "") );
      Combo_legnumero_Datalistprocparametersprefix = "" ;
      edtLegDedSec_Jsonclick = "" ;
      edtLegDedSec_Enabled = 1 ;
      edtLegDedSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombolegnumero_Jsonclick = "" ;
      edtavCombolegnumero_Enabled = 0 ;
      edtavCombolegnumero_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLegDedFile_Jsonclick = "" ;
      edtLegDedFile_Parameters = "" ;
      edtLegDedFile_Contenttype = "" ;
      edtLegDedFile_Filetype = "" ;
      edtLegDedFile_Enabled = 1 ;
      edtLegDedImporte_Jsonclick = "" ;
      edtLegDedImporte_Enabled = 1 ;
      edtLegDedDescrip_Enabled = 1 ;
      edtLegDedFchHas_Jsonclick = "" ;
      edtLegDedFchHas_Enabled = 1 ;
      edtLegDedFchDes_Jsonclick = "" ;
      edtLegDedFchDes_Enabled = 1 ;
      cmbLegDedConCodigo.setJsonclick( "" );
      cmbLegDedConCodigo.setEnabled( 1 );
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLegNumero_Visible = 1 ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Datalistproc = "legajo_deduccionesLoadDVCombo" ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Combo_legnumero_Caption = "" ;
      Combo_legnumero_Enabled = GXutil.toBoolean( -1) ;
      cmbLegDedTipo.setJsonclick( "" );
      cmbLegDedTipo.setEnabled( 0 );
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

   public void gx4asaclicod2372( int AV7CliCod )
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
            GXt_int11 = A3CliCod ;
            GXv_int12[0] = GXt_int11 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int12) ;
            legajo_deducciones_impl.this.GXt_int11 = GXv_int12[0] ;
            A3CliCod = GXt_int11 ;
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

   public void gx10asalegdedsec2372( int AV10LegDedSec )
   {
      if ( ! (0==AV10LegDedSec) )
      {
         A83LegDedSec = AV10LegDedSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx11asalegdedsec2372( int AV7CliCod ,
                                     short AV8EmpCod ,
                                     int A6LegNumero )
   {
      GXt_int11 = A83LegDedSec ;
      GXv_int12[0] = GXt_int11 ;
      new web.getnextdedsec(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int12) ;
      legajo_deducciones_impl.this.GXt_int11 = GXv_int12[0] ;
      A83LegDedSec = GXt_int11 ;
      httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), ".", "")))+"\"") ;
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
      cmbLegDedTipo.setName( "LEGDEDTIPO" );
      cmbLegDedTipo.setWebtags( "" );
      cmbLegDedTipo.addItem("siradig", httpContext.getMessage( "Deducción o pago a cuenta ingresado por SIRADIG", ""), (short)(0));
      cmbLegDedTipo.addItem("reintegro", httpContext.getMessage( "Comprobante o factura para reintegro", ""), (short)(0));
      if ( cmbLegDedTipo.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A1553LegDedTipo)==0) )
         {
            A1553LegDedTipo = "reintegro" ;
            httpContext.ajax_rsp_assign_attri("", false, "A1553LegDedTipo", A1553LegDedTipo);
         }
      }
      cmbLegDedConCodigo.setName( "LEGDEDCONCODIGO" );
      cmbLegDedConCodigo.setWebtags( "" );
      if ( cmbLegDedConCodigo.getItemCount() > 0 )
      {
         A84LegDedConCodigo = cmbLegDedConCodigo.getValidValue(A84LegDedConCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
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

   public void valid_Empcod( )
   {
      n93LegId = false ;
      /* Using cursor T002316 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T002316_A250LegIdNomApe[0] ;
      A251LegNombre = T002316_A251LegNombre[0] ;
      A251LegNombre = T002316_A251LegNombre[0] ;
      A230LegApellido = T002316_A230LegApellido[0] ;
      A230LegApellido = T002316_A230LegApellido[0] ;
      A93LegId = T002316_A93LegId[0] ;
      n93LegId = T002316_n93LegId[0] ;
      A93LegId = T002316_A93LegId[0] ;
      n93LegId = T002316_n93LegId[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
   }

   public void valid_Legdedconcodigo( )
   {
      A84LegDedConCodigo = cmbLegDedConCodigo.getValue() ;
      /* Using cursor T002317 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A559LegDedConDescrip = T002317_A559LegDedConDescrip[0] ;
      pr_default.close(15);
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      if ( (GXutil.strcmp("", A84LegDedConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLegDedConCodigo.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A559LegDedConDescrip", A559LegDedConDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegDedSec',fld:'vLEGDEDSEC',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegDedSec',fld:'vLEGDEDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'cmbLegDedTipo'},{av:'A1553LegDedTipo',fld:'LEGDEDTIPO',pic:''},{av:'A864LegDedCodSiradig',fld:'LEGDEDCODSIRADIG',pic:'Z9'},{av:'A870LegDedCodMot',fld:'LEGDEDCODMOT',pic:''},{av:'A1080LegDedUsado',fld:'LEGDEDUSADO',pic:'9'},{av:'A1081LegDedNroLiq',fld:'LEGDEDNROLIQ',pic:'ZZZZZZZ9'},{av:'A1558LegDedFileNom',fld:'LEGDEDFILENOM',pic:''},{av:'A1559LegDedFileExt',fld:'LEGDEDFILEEXT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12232',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDCONCODIGO","{handler:'valid_Legdedconcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'cmbLegDedConCodigo'},{av:'A84LegDedConCodigo',fld:'LEGDEDCONCODIGO',pic:''},{av:'A559LegDedConDescrip',fld:'LEGDEDCONDESCRIP',pic:''},{av:'A570LegDedConCodYDesc',fld:'LEGDEDCONCODYDESC',pic:''}]");
      setEventMetadata("VALID_LEGDEDCONCODIGO",",oparms:[{av:'A559LegDedConDescrip',fld:'LEGDEDCONDESCRIP',pic:''},{av:'A570LegDedConCodYDesc',fld:'LEGDEDCONCODYDESC',pic:''}]}");
      setEventMetadata("VALID_LEGDEDFCHDES","{handler:'valid_Legdedfchdes',iparms:[]");
      setEventMetadata("VALID_LEGDEDFCHDES",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDFCHHAS","{handler:'valid_Legdedfchhas',iparms:[]");
      setEventMetadata("VALID_LEGDEDFCHHAS",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDIMPORTE","{handler:'valid_Legdedimporte',iparms:[]");
      setEventMetadata("VALID_LEGDEDIMPORTE",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOLEGNUMERO","{handler:'validv_Combolegnumero',iparms:[]");
      setEventMetadata("VALIDV_COMBOLEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''}]}");
      setEventMetadata("VALID_LEGDEDSEC","{handler:'valid_Legdedsec',iparms:[]");
      setEventMetadata("VALID_LEGDEDSEC",",oparms:[]}");
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
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z556LegDedFchDes = GXutil.nullDate() ;
      Z557LegDedFchHas = GXutil.nullDate() ;
      Z560LegDedImporte = DecimalUtil.ZERO ;
      Z568LegDedDescrip = "" ;
      Z870LegDedCodMot = "" ;
      Z1553LegDedTipo = "" ;
      Z1558LegDedFileNom = "" ;
      Z1559LegDedFileExt = "" ;
      Z84LegDedConCodigo = "" ;
      N84LegDedConCodigo = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A84LegDedConCodigo = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1553LegDedTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocklegnumero_Jsonclick = "" ;
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      AV19DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV18LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      A568LegDedDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A1555LegDedFile = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A870LegDedCodMot = "" ;
      A1558LegDedFileNom = "" ;
      A1559LegDedFileExt = "" ;
      A559LegDedConDescrip = "" ;
      A570LegDedConCodYDesc = "" ;
      AV16Insert_LegDedConCodigo = "" ;
      A250LegIdNomApe = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      AV33Pgmname = "" ;
      Combo_legnumero_Objectcall = "" ;
      Combo_legnumero_Class = "" ;
      Combo_legnumero_Icontype = "" ;
      Combo_legnumero_Icon = "" ;
      Combo_legnumero_Tooltip = "" ;
      Combo_legnumero_Selectedvalue_set = "" ;
      Combo_legnumero_Selectedtext_set = "" ;
      Combo_legnumero_Selectedtext_get = "" ;
      Combo_legnumero_Gamoauthtoken = "" ;
      Combo_legnumero_Ddointernalname = "" ;
      Combo_legnumero_Titlecontrolalign = "" ;
      Combo_legnumero_Dropdownoptionstype = "" ;
      Combo_legnumero_Titlecontrolidtoreplace = "" ;
      Combo_legnumero_Datalisttype = "" ;
      Combo_legnumero_Datalistfixedvalues = "" ;
      Combo_legnumero_Remoteservicesparameters = "" ;
      Combo_legnumero_Htmltemplate = "" ;
      Combo_legnumero_Multiplevaluestype = "" ;
      Combo_legnumero_Loadingdata = "" ;
      Combo_legnumero_Noresultsfound = "" ;
      Combo_legnumero_Emptyitemtext = "" ;
      Combo_legnumero_Onlyselectedvalues = "" ;
      Combo_legnumero_Selectalltext = "" ;
      Combo_legnumero_Multiplevaluesseparator = "" ;
      Combo_legnumero_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode72 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV29reintegrosConcodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char6 = new GXSimpleCollection[1] ;
      AV31ConDescrip = "" ;
      AV22Combo_DataJson = "" ;
      GXt_char8 = "" ;
      AV20ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV21ComboSelectedText = "" ;
      GXv_char9 = new String[1] ;
      GXv_char10 = new String[1] ;
      Z1555LegDedFile = "" ;
      Z250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      Z230LegApellido = "" ;
      Z93LegId = "" ;
      Z559LegDedConDescrip = "" ;
      T00234_A250LegIdNomApe = new String[] {""} ;
      T00234_A251LegNombre = new String[] {""} ;
      T00234_A230LegApellido = new String[] {""} ;
      T00234_A93LegId = new String[] {""} ;
      T00234_n93LegId = new boolean[] {false} ;
      T00235_A559LegDedConDescrip = new String[] {""} ;
      T00236_A250LegIdNomApe = new String[] {""} ;
      T00236_A83LegDedSec = new int[1] ;
      T00236_A767LegDedMes = new byte[1] ;
      T00236_A768LegDedAnio = new short[1] ;
      T00236_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00236_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00236_A559LegDedConDescrip = new String[] {""} ;
      T00236_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00236_A568LegDedDescrip = new String[] {""} ;
      T00236_A864LegDedCodSiradig = new byte[1] ;
      T00236_A870LegDedCodMot = new String[] {""} ;
      T00236_A1080LegDedUsado = new byte[1] ;
      T00236_A1081LegDedNroLiq = new int[1] ;
      T00236_A1553LegDedTipo = new String[] {""} ;
      T00236_A1555LegDedFile = new String[] {""} ;
      T00236_A1558LegDedFileNom = new String[] {""} ;
      T00236_A1559LegDedFileExt = new String[] {""} ;
      T00236_A251LegNombre = new String[] {""} ;
      T00236_A230LegApellido = new String[] {""} ;
      T00236_A93LegId = new String[] {""} ;
      T00236_n93LegId = new boolean[] {false} ;
      T00236_A3CliCod = new int[1] ;
      T00236_A1EmpCod = new short[1] ;
      T00236_A6LegNumero = new int[1] ;
      T00236_A84LegDedConCodigo = new String[] {""} ;
      T00237_A559LegDedConDescrip = new String[] {""} ;
      T00238_A250LegIdNomApe = new String[] {""} ;
      T00238_A251LegNombre = new String[] {""} ;
      T00238_A230LegApellido = new String[] {""} ;
      T00238_A93LegId = new String[] {""} ;
      T00238_n93LegId = new boolean[] {false} ;
      T00239_A3CliCod = new int[1] ;
      T00239_A1EmpCod = new short[1] ;
      T00239_A6LegNumero = new int[1] ;
      T00239_A83LegDedSec = new int[1] ;
      T00233_A83LegDedSec = new int[1] ;
      T00233_A767LegDedMes = new byte[1] ;
      T00233_A768LegDedAnio = new short[1] ;
      T00233_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00233_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00233_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00233_A568LegDedDescrip = new String[] {""} ;
      T00233_A864LegDedCodSiradig = new byte[1] ;
      T00233_A870LegDedCodMot = new String[] {""} ;
      T00233_A1080LegDedUsado = new byte[1] ;
      T00233_A1081LegDedNroLiq = new int[1] ;
      T00233_A1553LegDedTipo = new String[] {""} ;
      T00233_A1555LegDedFile = new String[] {""} ;
      T00233_A1558LegDedFileNom = new String[] {""} ;
      T00233_A1559LegDedFileExt = new String[] {""} ;
      T00233_A3CliCod = new int[1] ;
      T00233_A1EmpCod = new short[1] ;
      T00233_A6LegNumero = new int[1] ;
      T00233_A84LegDedConCodigo = new String[] {""} ;
      T002310_A83LegDedSec = new int[1] ;
      T002310_A3CliCod = new int[1] ;
      T002310_A1EmpCod = new short[1] ;
      T002310_A6LegNumero = new int[1] ;
      T002311_A83LegDedSec = new int[1] ;
      T002311_A3CliCod = new int[1] ;
      T002311_A1EmpCod = new short[1] ;
      T002311_A6LegNumero = new int[1] ;
      T00232_A83LegDedSec = new int[1] ;
      T00232_A767LegDedMes = new byte[1] ;
      T00232_A768LegDedAnio = new short[1] ;
      T00232_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00232_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00232_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00232_A568LegDedDescrip = new String[] {""} ;
      T00232_A864LegDedCodSiradig = new byte[1] ;
      T00232_A870LegDedCodMot = new String[] {""} ;
      T00232_A1080LegDedUsado = new byte[1] ;
      T00232_A1081LegDedNroLiq = new int[1] ;
      T00232_A1553LegDedTipo = new String[] {""} ;
      T00232_A1555LegDedFile = new String[] {""} ;
      T00232_A1558LegDedFileNom = new String[] {""} ;
      T00232_A1559LegDedFileExt = new String[] {""} ;
      T00232_A3CliCod = new int[1] ;
      T00232_A1EmpCod = new short[1] ;
      T00232_A6LegNumero = new int[1] ;
      T00232_A84LegDedConCodigo = new String[] {""} ;
      T002316_A250LegIdNomApe = new String[] {""} ;
      T002316_A251LegNombre = new String[] {""} ;
      T002316_A230LegApellido = new String[] {""} ;
      T002316_A93LegId = new String[] {""} ;
      T002316_n93LegId = new boolean[] {false} ;
      T002317_A559LegDedConDescrip = new String[] {""} ;
      T002318_A3CliCod = new int[1] ;
      T002318_A1EmpCod = new short[1] ;
      T002318_A6LegNumero = new int[1] ;
      T002318_A83LegDedSec = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i1553LegDedTipo = "" ;
      GXv_int12 = new int[1] ;
      Z570LegDedConCodYDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_deducciones__default(),
         new Object[] {
             new Object[] {
            T00232_A83LegDedSec, T00232_A767LegDedMes, T00232_A768LegDedAnio, T00232_A556LegDedFchDes, T00232_A557LegDedFchHas, T00232_A560LegDedImporte, T00232_A568LegDedDescrip, T00232_A864LegDedCodSiradig, T00232_A870LegDedCodMot, T00232_A1080LegDedUsado,
            T00232_A1081LegDedNroLiq, T00232_A1553LegDedTipo, T00232_A1555LegDedFile, T00232_A1558LegDedFileNom, T00232_A1559LegDedFileExt, T00232_A3CliCod, T00232_A1EmpCod, T00232_A6LegNumero, T00232_A84LegDedConCodigo
            }
            , new Object[] {
            T00233_A83LegDedSec, T00233_A767LegDedMes, T00233_A768LegDedAnio, T00233_A556LegDedFchDes, T00233_A557LegDedFchHas, T00233_A560LegDedImporte, T00233_A568LegDedDescrip, T00233_A864LegDedCodSiradig, T00233_A870LegDedCodMot, T00233_A1080LegDedUsado,
            T00233_A1081LegDedNroLiq, T00233_A1553LegDedTipo, T00233_A1555LegDedFile, T00233_A1558LegDedFileNom, T00233_A1559LegDedFileExt, T00233_A3CliCod, T00233_A1EmpCod, T00233_A6LegNumero, T00233_A84LegDedConCodigo
            }
            , new Object[] {
            T00234_A250LegIdNomApe, T00234_A251LegNombre, T00234_A230LegApellido, T00234_A93LegId, T00234_n93LegId
            }
            , new Object[] {
            T00235_A559LegDedConDescrip
            }
            , new Object[] {
            T00236_A250LegIdNomApe, T00236_A83LegDedSec, T00236_A767LegDedMes, T00236_A768LegDedAnio, T00236_A556LegDedFchDes, T00236_A557LegDedFchHas, T00236_A559LegDedConDescrip, T00236_A560LegDedImporte, T00236_A568LegDedDescrip, T00236_A864LegDedCodSiradig,
            T00236_A870LegDedCodMot, T00236_A1080LegDedUsado, T00236_A1081LegDedNroLiq, T00236_A1553LegDedTipo, T00236_A1555LegDedFile, T00236_A1558LegDedFileNom, T00236_A1559LegDedFileExt, T00236_A251LegNombre, T00236_A230LegApellido, T00236_A93LegId,
            T00236_n93LegId, T00236_A3CliCod, T00236_A1EmpCod, T00236_A6LegNumero, T00236_A84LegDedConCodigo
            }
            , new Object[] {
            T00237_A559LegDedConDescrip
            }
            , new Object[] {
            T00238_A250LegIdNomApe, T00238_A251LegNombre, T00238_A230LegApellido, T00238_A93LegId, T00238_n93LegId
            }
            , new Object[] {
            T00239_A3CliCod, T00239_A1EmpCod, T00239_A6LegNumero, T00239_A83LegDedSec
            }
            , new Object[] {
            T002310_A83LegDedSec, T002310_A3CliCod, T002310_A1EmpCod, T002310_A6LegNumero
            }
            , new Object[] {
            T002311_A83LegDedSec, T002311_A3CliCod, T002311_A1EmpCod, T002311_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002316_A250LegIdNomApe, T002316_A251LegNombre, T002316_A230LegApellido, T002316_A93LegId, T002316_n93LegId
            }
            , new Object[] {
            T002317_A559LegDedConDescrip
            }
            , new Object[] {
            T002318_A3CliCod, T002318_A1EmpCod, T002318_A6LegNumero, T002318_A83LegDedSec
            }
         }
      );
      AV33Pgmname = "legajo_deducciones" ;
      Z1553LegDedTipo = "reintegro" ;
      A1553LegDedTipo = "reintegro" ;
      i1553LegDedTipo = "reintegro" ;
   }

   private byte Z767LegDedMes ;
   private byte Z864LegDedCodSiradig ;
   private byte Z1080LegDedUsado ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A767LegDedMes ;
   private byte A864LegDedCodSiradig ;
   private byte A1080LegDedUsado ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z768LegDedAnio ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A768LegDedAnio ;
   private short RcdFound72 ;
   private short AV30i ;
   private short nIsDirty_72 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int wcpOAV10LegDedSec ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z83LegDedSec ;
   private int Z1081LegDedNroLiq ;
   private int AV7CliCod ;
   private int AV10LegDedSec ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV9LegNumero ;
   private int trnEnded ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int edtLegDedFchDes_Enabled ;
   private int edtLegDedFchHas_Enabled ;
   private int edtLegDedDescrip_Enabled ;
   private int edtLegDedImporte_Enabled ;
   private int edtLegDedFile_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV23ComboLegNumero ;
   private int edtavCombolegnumero_Enabled ;
   private int edtavCombolegnumero_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int A83LegDedSec ;
   private int edtLegDedSec_Visible ;
   private int edtLegDedSec_Enabled ;
   private int A1081LegDedNroLiq ;
   private int Combo_legnumero_Datalistupdateminimumcharacters ;
   private int Combo_legnumero_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV34GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int11 ;
   private int GXv_int12[] ;
   private java.math.BigDecimal Z560LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z870LegDedCodMot ;
   private String Z1553LegDedTipo ;
   private String Z84LegDedConCodigo ;
   private String N84LegDedConCodigo ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A84LegDedConCodigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLegNumero_Internalname ;
   private String A1553LegDedTipo ;
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
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblocklegnumero_Internalname ;
   private String lblTextblocklegnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Datalistproc ;
   private String Combo_legnumero_Internalname ;
   private String TempTags ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegDedFchDes_Internalname ;
   private String edtLegDedFchDes_Jsonclick ;
   private String edtLegDedFchHas_Internalname ;
   private String edtLegDedFchHas_Jsonclick ;
   private String edtLegDedDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtLegDedImporte_Internalname ;
   private String edtLegDedImporte_Jsonclick ;
   private String edtLegDedFile_Internalname ;
   private String edtLegDedFile_Filetype ;
   private String edtLegDedFile_Contenttype ;
   private String edtLegDedFile_Parameters ;
   private String edtLegDedFile_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_legnumero_Internalname ;
   private String edtavCombolegnumero_Internalname ;
   private String edtavCombolegnumero_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegDedSec_Internalname ;
   private String edtLegDedSec_Jsonclick ;
   private String A870LegDedCodMot ;
   private String AV16Insert_LegDedConCodigo ;
   private String A93LegId ;
   private String AV33Pgmname ;
   private String Combo_legnumero_Objectcall ;
   private String Combo_legnumero_Class ;
   private String Combo_legnumero_Icontype ;
   private String Combo_legnumero_Icon ;
   private String Combo_legnumero_Tooltip ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_legnumero_Selectedtext_set ;
   private String Combo_legnumero_Selectedtext_get ;
   private String Combo_legnumero_Gamoauthtoken ;
   private String Combo_legnumero_Ddointernalname ;
   private String Combo_legnumero_Titlecontrolalign ;
   private String Combo_legnumero_Dropdownoptionstype ;
   private String Combo_legnumero_Titlecontrolidtoreplace ;
   private String Combo_legnumero_Datalisttype ;
   private String Combo_legnumero_Datalistfixedvalues ;
   private String Combo_legnumero_Datalistprocparametersprefix ;
   private String Combo_legnumero_Remoteservicesparameters ;
   private String Combo_legnumero_Htmltemplate ;
   private String Combo_legnumero_Multiplevaluestype ;
   private String Combo_legnumero_Loadingdata ;
   private String Combo_legnumero_Noresultsfound ;
   private String Combo_legnumero_Emptyitemtext ;
   private String Combo_legnumero_Onlyselectedvalues ;
   private String Combo_legnumero_Selectalltext ;
   private String Combo_legnumero_Multiplevaluesseparator ;
   private String Combo_legnumero_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String edtLegDedFile_Filename ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sMode72 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char8 ;
   private String GXv_char7[] ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String Z93LegId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i1553LegDedTipo ;
   private java.util.Date Z556LegDedFchDes ;
   private java.util.Date Z557LegDedFchHas ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date A557LegDedFchHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean n93LegId ;
   private boolean Combo_legnumero_Enabled ;
   private boolean Combo_legnumero_Visible ;
   private boolean Combo_legnumero_Allowmultipleselection ;
   private boolean Combo_legnumero_Isgriditem ;
   private boolean Combo_legnumero_Hasdescription ;
   private boolean Combo_legnumero_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Includeselectalloption ;
   private boolean Combo_legnumero_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV22Combo_DataJson ;
   private String A1555LegDedFile ;
   private String Z1555LegDedFile ;
   private String Z568LegDedDescrip ;
   private String Z1558LegDedFileNom ;
   private String Z1559LegDedFileExt ;
   private String A568LegDedDescrip ;
   private String A1558LegDedFileNom ;
   private String A1559LegDedFileExt ;
   private String A559LegDedConDescrip ;
   private String A570LegDedConCodYDesc ;
   private String A250LegIdNomApe ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String AV31ConDescrip ;
   private String AV20ComboSelectedValue ;
   private String AV21ComboSelectedText ;
   private String Z250LegIdNomApe ;
   private String Z251LegNombre ;
   private String Z230LegApellido ;
   private String Z559LegDedConDescrip ;
   private String Z570LegDedConCodYDesc ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbLegDedTipo ;
   private HTMLChoice cmbLegDedConCodigo ;
   private IDataStoreProvider pr_default ;
   private String[] T00234_A250LegIdNomApe ;
   private String[] T00234_A251LegNombre ;
   private String[] T00234_A230LegApellido ;
   private String[] T00234_A93LegId ;
   private boolean[] T00234_n93LegId ;
   private String[] T00235_A559LegDedConDescrip ;
   private String[] T00236_A250LegIdNomApe ;
   private int[] T00236_A83LegDedSec ;
   private byte[] T00236_A767LegDedMes ;
   private short[] T00236_A768LegDedAnio ;
   private java.util.Date[] T00236_A556LegDedFchDes ;
   private java.util.Date[] T00236_A557LegDedFchHas ;
   private String[] T00236_A559LegDedConDescrip ;
   private java.math.BigDecimal[] T00236_A560LegDedImporte ;
   private String[] T00236_A568LegDedDescrip ;
   private byte[] T00236_A864LegDedCodSiradig ;
   private String[] T00236_A870LegDedCodMot ;
   private byte[] T00236_A1080LegDedUsado ;
   private int[] T00236_A1081LegDedNroLiq ;
   private String[] T00236_A1553LegDedTipo ;
   private String[] T00236_A1555LegDedFile ;
   private String[] T00236_A1558LegDedFileNom ;
   private String[] T00236_A1559LegDedFileExt ;
   private String[] T00236_A251LegNombre ;
   private String[] T00236_A230LegApellido ;
   private String[] T00236_A93LegId ;
   private boolean[] T00236_n93LegId ;
   private int[] T00236_A3CliCod ;
   private short[] T00236_A1EmpCod ;
   private int[] T00236_A6LegNumero ;
   private String[] T00236_A84LegDedConCodigo ;
   private String[] T00237_A559LegDedConDescrip ;
   private String[] T00238_A250LegIdNomApe ;
   private String[] T00238_A251LegNombre ;
   private String[] T00238_A230LegApellido ;
   private String[] T00238_A93LegId ;
   private boolean[] T00238_n93LegId ;
   private int[] T00239_A3CliCod ;
   private short[] T00239_A1EmpCod ;
   private int[] T00239_A6LegNumero ;
   private int[] T00239_A83LegDedSec ;
   private int[] T00233_A83LegDedSec ;
   private byte[] T00233_A767LegDedMes ;
   private short[] T00233_A768LegDedAnio ;
   private java.util.Date[] T00233_A556LegDedFchDes ;
   private java.util.Date[] T00233_A557LegDedFchHas ;
   private java.math.BigDecimal[] T00233_A560LegDedImporte ;
   private String[] T00233_A568LegDedDescrip ;
   private byte[] T00233_A864LegDedCodSiradig ;
   private String[] T00233_A870LegDedCodMot ;
   private byte[] T00233_A1080LegDedUsado ;
   private int[] T00233_A1081LegDedNroLiq ;
   private String[] T00233_A1553LegDedTipo ;
   private String[] T00233_A1555LegDedFile ;
   private String[] T00233_A1558LegDedFileNom ;
   private String[] T00233_A1559LegDedFileExt ;
   private int[] T00233_A3CliCod ;
   private short[] T00233_A1EmpCod ;
   private int[] T00233_A6LegNumero ;
   private String[] T00233_A84LegDedConCodigo ;
   private int[] T002310_A83LegDedSec ;
   private int[] T002310_A3CliCod ;
   private short[] T002310_A1EmpCod ;
   private int[] T002310_A6LegNumero ;
   private int[] T002311_A83LegDedSec ;
   private int[] T002311_A3CliCod ;
   private short[] T002311_A1EmpCod ;
   private int[] T002311_A6LegNumero ;
   private int[] T00232_A83LegDedSec ;
   private byte[] T00232_A767LegDedMes ;
   private short[] T00232_A768LegDedAnio ;
   private java.util.Date[] T00232_A556LegDedFchDes ;
   private java.util.Date[] T00232_A557LegDedFchHas ;
   private java.math.BigDecimal[] T00232_A560LegDedImporte ;
   private String[] T00232_A568LegDedDescrip ;
   private byte[] T00232_A864LegDedCodSiradig ;
   private String[] T00232_A870LegDedCodMot ;
   private byte[] T00232_A1080LegDedUsado ;
   private int[] T00232_A1081LegDedNroLiq ;
   private String[] T00232_A1553LegDedTipo ;
   private String[] T00232_A1555LegDedFile ;
   private String[] T00232_A1558LegDedFileNom ;
   private String[] T00232_A1559LegDedFileExt ;
   private int[] T00232_A3CliCod ;
   private short[] T00232_A1EmpCod ;
   private int[] T00232_A6LegNumero ;
   private String[] T00232_A84LegDedConCodigo ;
   private String[] T002316_A250LegIdNomApe ;
   private String[] T002316_A251LegNombre ;
   private String[] T002316_A230LegApellido ;
   private String[] T002316_A93LegId ;
   private boolean[] T002316_n93LegId ;
   private String[] T002317_A559LegDedConDescrip ;
   private int[] T002318_A3CliCod ;
   private short[] T002318_A1EmpCod ;
   private int[] T002318_A6LegNumero ;
   private int[] T002318_A83LegDedSec ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV29reintegrosConcodigo ;
   private GXSimpleCollection<String> GXv_objcol_char6[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18LegNumero_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class legajo_deducciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00232", "SELECT LegDedSec, LegDedMes, LegDedAnio, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?  FOR UPDATE OF legajo_deducciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00233", "SELECT LegDedSec, LegDedMes, LegDedAnio, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00234", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00235", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00236", "SELECT T2.LegIdNomApe, TM1.LegDedSec, TM1.LegDedMes, TM1.LegDedAnio, TM1.LegDedFchDes, TM1.LegDedFchHas, T3.ConDescrip AS LegDedConDescrip, TM1.LegDedImporte, TM1.LegDedDescrip, TM1.LegDedCodSiradig, TM1.LegDedCodMot, TM1.LegDedUsado, TM1.LegDedNroLiq, TM1.LegDedTipo, TM1.LegDedFile, TM1.LegDedFileNom, TM1.LegDedFileExt, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedConCodigo AS LegDedConCodigo FROM ((legajo_deducciones TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = TM1.CliCod AND T3.ConCodigo = TM1.LegDedConCodigo) WHERE TM1.LegDedSec = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00237", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00238", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00239", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002310", "SELECT LegDedSec, CliCod, EmpCod, LegNumero FROM legajo_deducciones WHERE ( LegDedSec > ? or LegDedSec = ? and CliCod > ? or CliCod = ? and LegDedSec = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegDedSec = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, LegDedSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002311", "SELECT LegDedSec, CliCod, EmpCod, LegNumero FROM legajo_deducciones WHERE ( LegDedSec < ? or LegDedSec = ? and CliCod < ? or CliCod = ? and LegDedSec = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegDedSec = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegDedSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002312", "SAVEPOINT gxupdate;INSERT INTO legajo_deducciones(LegDedSec, LegDedMes, LegDedAnio, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt, CliCod, EmpCod, LegNumero, LegDedConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002313", "SAVEPOINT gxupdate;UPDATE legajo_deducciones SET LegDedMes=?, LegDedAnio=?, LegDedFchDes=?, LegDedFchHas=?, LegDedImporte=?, LegDedDescrip=?, LegDedCodSiradig=?, LegDedCodMot=?, LegDedUsado=?, LegDedNroLiq=?, LegDedTipo=?, LegDedFileNom=?, LegDedFileExt=?, LegDedConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002314", "SAVEPOINT gxupdate;UPDATE legajo_deducciones SET LegDedFile=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002315", "SAVEPOINT gxupdate;DELETE FROM legajo_deducciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002316", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002317", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002318", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones ORDER BY CliCod, EmpCod, LegNumero, LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 2);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getBLOBFile(13, "tmp", "");
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 2);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getBLOBFile(13, "tmp", "");
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 2);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 20);
               ((String[]) buf[14])[0] = rslt.getBLOBFile(15, "tmp", "");
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((String[]) buf[24])[0] = rslt.getString(24, 10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setString(9, (String)parms[8], 2);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setBLOBFile(13, (String)parms[12]);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 40, false);
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setString(19, (String)parms[18], 10);
               return;
            case 11 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setString(8, (String)parms[7], 2);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setString(11, (String)parms[10], 20);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setVarchar(13, (String)parms[12], 40, false);
               stmt.setString(14, (String)parms[13], 10);
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               return;
            case 12 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

