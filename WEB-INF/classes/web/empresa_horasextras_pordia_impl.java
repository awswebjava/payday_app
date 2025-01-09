package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresa_horasextras_pordia_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPHSPDIATIPTRA") == 0 )
      {
         AV26PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaemphspdiatiptra5O165( AV26PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"CLICOD") == 0 )
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
         gx6asaclicod5O165( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel10"+"_"+"EMPHSEXSEC") == 0 )
      {
         AV9EmpHsExSec = (short)(GXutil.lval( httpContext.GetPar( "EmpHsExSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpHsExSec), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpHsExSec), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx10asaemphsexsec5O165( AV9EmpHsExSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"EMPHSEXSEC") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx11asaemphsexsec5O165( AV7CliCod, AV8EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1339EmpHsPDiaTipTra = httpContext.GetPar( "EmpHsPDiaTipTra") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A3CliCod, A1EmpCod, A1339EmpHsPDiaTipTra) ;
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
            AV9EmpHsExSec = (short)(GXutil.lval( httpContext.GetPar( "EmpHsExSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpHsExSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpHsExSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Empresa_horasextras_por Dia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public empresa_horasextras_pordia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresa_horasextras_pordia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_horasextras_pordia_impl.class ));
   }

   public empresa_horasextras_pordia_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynEmpHsPDiaTipTra = new HTMLChoice();
      cmbEmpHsPDiaDia = new HTMLChoice();
      cmbEmpTarifaPDCri = new HTMLChoice();
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
      if ( dynEmpHsPDiaTipTra.getItemCount() > 0 )
      {
         A1339EmpHsPDiaTipTra = dynEmpHsPDiaTipTra.getValidValue(A1339EmpHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpHsPDiaTipTra.setValue( GXutil.rtrim( A1339EmpHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpHsPDiaTipTra.getInternalname(), "Values", dynEmpHsPDiaTipTra.ToJavascriptSource(), true);
      }
      if ( cmbEmpHsPDiaDia.getItemCount() > 0 )
      {
         A1341EmpHsPDiaDia = (byte)(GXutil.lval( cmbEmpHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1341EmpHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1341EmpHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpHsPDiaDia.getInternalname(), "Values", cmbEmpHsPDiaDia.ToJavascriptSource(), true);
      }
      if ( cmbEmpTarifaPDCri.getItemCount() > 0 )
      {
         A2433EmpTarifaPDCri = cmbEmpTarifaPDCri.getValidValue(A2433EmpTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpTarifaPDCri.setValue( GXutil.rtrim( A2433EmpTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpTarifaPDCri.getInternalname(), "Values", cmbEmpTarifaPDCri.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynEmpHsPDiaTipTra.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynEmpHsPDiaTipTra.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynEmpHsPDiaTipTra, dynEmpHsPDiaTipTra.getInternalname(), GXutil.rtrim( A1339EmpHsPDiaTipTra), 1, dynEmpHsPDiaTipTra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynEmpHsPDiaTipTra.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Empresa_horasextras_porDia.htm");
      dynEmpHsPDiaTipTra.setValue( GXutil.rtrim( A1339EmpHsPDiaTipTra) );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpHsPDiaTipTra.getInternalname(), "Values", dynEmpHsPDiaTipTra.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpHsPDiaDia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpHsPDiaDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpHsPDiaDia, cmbEmpHsPDiaDia.getInternalname(), GXutil.trim( GXutil.str( A1341EmpHsPDiaDia, 1, 0)), 1, cmbEmpHsPDiaDia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbEmpHsPDiaDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Empresa_horasextras_porDia.htm");
      cmbEmpHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1341EmpHsPDiaDia, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpHsPDiaDia.getInternalname(), "Values", cmbEmpHsPDiaDia.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpHsPDiaDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpHsPDiaDesde_Internalname, httpContext.getMessage( "Hora desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsPDiaDesde_Internalname, GXutil.rtrim( A1342EmpHsPDiaDesde), GXutil.rtrim( localUtil.format( A1342EmpHsPDiaDesde, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsPDiaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpHsPDiaDesde_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Empresa_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpTarifaPDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpTarifaPDia_Internalname, httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpTarifaPDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1343EmpTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpTarifaPDia_Enabled!=0) ? localUtil.format( A1343EmpTarifaPDia, "9.9999") : localUtil.format( A1343EmpTarifaPDia, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpTarifaPDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpTarifaPDia_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Empresa_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpTarfaPDRec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpTarfaPDRec_Internalname, httpContext.getMessage( "Recargo a hora normal diurna", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpTarfaPDRec_Internalname, GXutil.ltrim( localUtil.ntoc( A1351EmpTarfaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpTarfaPDRec_Enabled!=0) ? localUtil.format( A1351EmpTarfaPDRec, "9.9999") : localUtil.format( A1351EmpTarfaPDRec, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpTarfaPDRec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpTarfaPDRec_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Empresa_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpTarifaPDCri.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpTarifaPDCri.getInternalname(), httpContext.getMessage( "Criterio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpTarifaPDCri, cmbEmpTarifaPDCri.getInternalname(), GXutil.rtrim( A2433EmpTarifaPDCri), 1, cmbEmpTarifaPDCri.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpTarifaPDCri.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_Empresa_horasextras_porDia.htm");
      cmbEmpTarifaPDCri.setValue( GXutil.rtrim( A2433EmpTarifaPDCri) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpTarifaPDCri.getInternalname(), "Values", cmbEmpTarifaPDCri.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresa_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresa_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresa_horasextras_porDia.htm");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_horasextras_porDia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Empresa_horasextras_porDia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpHsExSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1340EmpHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1340EmpHsExSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpHsExSec_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpHsExSec_Visible, edtEmpHsExSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_horasextras_porDia.htm");
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
      e115O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1340EmpHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1340EmpHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1341EmpHsPDiaDia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1341EmpHsPDiaDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1342EmpHsPDiaDesde = httpContext.cgiGet( "Z1342EmpHsPDiaDesde") ;
            n1342EmpHsPDiaDesde = ((GXutil.strcmp("", A1342EmpHsPDiaDesde)==0) ? true : false) ;
            Z1343EmpTarifaPDia = localUtil.ctond( httpContext.cgiGet( "Z1343EmpTarifaPDia")) ;
            Z1351EmpTarfaPDRec = localUtil.ctond( httpContext.cgiGet( "Z1351EmpTarfaPDRec")) ;
            Z2433EmpTarifaPDCri = httpContext.cgiGet( "Z2433EmpTarifaPDCri") ;
            Z2004EmpHsPDiaRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2004EmpHsPDiaRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1339EmpHsPDiaTipTra = httpContext.cgiGet( "Z1339EmpHsPDiaTipTra") ;
            A2004EmpHsPDiaRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2004EmpHsPDiaRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1339EmpHsPDiaTipTra = httpContext.cgiGet( "N1339EmpHsPDiaTipTra") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9EmpHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPHSEXSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV15Insert_EmpHsPDiaTipTra = httpContext.cgiGet( "vINSERT_EMPHSPDIATIPTRA") ;
            AV26PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2004EmpHsPDiaRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "EMPHSPDIARELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV27Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynEmpHsPDiaTipTra.setValue( httpContext.cgiGet( dynEmpHsPDiaTipTra.getInternalname()) );
            A1339EmpHsPDiaTipTra = httpContext.cgiGet( dynEmpHsPDiaTipTra.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
            cmbEmpHsPDiaDia.setValue( httpContext.cgiGet( cmbEmpHsPDiaDia.getInternalname()) );
            A1341EmpHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpHsPDiaDia.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
            A1342EmpHsPDiaDesde = httpContext.cgiGet( edtEmpHsPDiaDesde_Internalname) ;
            n1342EmpHsPDiaDesde = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1342EmpHsPDiaDesde", A1342EmpHsPDiaDesde);
            n1342EmpHsPDiaDesde = ((GXutil.strcmp("", A1342EmpHsPDiaDesde)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpTarifaPDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpTarifaPDia_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPTARIFAPDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpTarifaPDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1343EmpTarifaPDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1343EmpTarifaPDia", GXutil.ltrimstr( A1343EmpTarifaPDia, 6, 4));
            }
            else
            {
               A1343EmpTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtEmpTarifaPDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1343EmpTarifaPDia", GXutil.ltrimstr( A1343EmpTarifaPDia, 6, 4));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpTarfaPDRec_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpTarfaPDRec_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPTARFAPDREC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpTarfaPDRec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1351EmpTarfaPDRec", GXutil.ltrimstr( A1351EmpTarfaPDRec, 6, 4));
            }
            else
            {
               A1351EmpTarfaPDRec = localUtil.ctond( httpContext.cgiGet( edtEmpTarfaPDRec_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1351EmpTarfaPDRec", GXutil.ltrimstr( A1351EmpTarfaPDRec, 6, 4));
            }
            cmbEmpTarifaPDCri.setValue( httpContext.cgiGet( cmbEmpTarifaPDCri.getInternalname()) );
            A2433EmpTarifaPDCri = httpContext.cgiGet( cmbEmpTarifaPDCri.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPHSEXSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1340EmpHsExSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
            }
            else
            {
               A1340EmpHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Empresa_horasextras_porDia");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("EmpHsPDiaRelSec", localUtil.format( DecimalUtil.doubleToDec(A2004EmpHsPDiaRelSec), "ZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1340EmpHsExSec != Z1340EmpHsExSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("empresa_horasextras_pordia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1340EmpHsExSec = (short)(GXutil.lval( httpContext.GetPar( "EmpHsExSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
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
                  sMode165 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode165 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound165 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5O0( ) ;
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
                        e115O2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125O2 ();
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
         e125O2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5O165( ) ;
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
         disableAttributes5O165( ) ;
      }
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

   public void confirm_5O0( )
   {
      beforeValidate5O165( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5O165( ) ;
         }
         else
         {
            checkExtendedTable5O165( ) ;
            closeExtendedTableCursors5O165( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5O0( )
   {
   }

   public void e115O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_horasextras_porDia_Insert", GXv_boolean3) ;
         empresa_horasextras_pordia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_horasextras_porDia_Update", GXv_boolean3) ;
         empresa_horasextras_pordia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_horasextras_porDia_Delete", GXv_boolean3) ;
         empresa_horasextras_pordia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV13TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV27Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV28GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         while ( AV28GXV1 <= AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV28GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpHsPDiaTipTra") == 0 )
            {
               AV15Insert_EmpHsPDiaTipTra = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_EmpHsPDiaTipTra", AV15Insert_EmpHsPDiaTipTra);
            }
            AV28GXV1 = (int)(AV28GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtEmpHsExSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsExSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsExSec_Visible), 5, 0), true);
      GXt_int4 = AV26PaiCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.empresagetpais(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_int5) ;
      empresa_horasextras_pordia_impl.this.GXt_int4 = GXv_int5[0] ;
      AV26PaiCod = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26PaiCod), 4, 0));
   }

   public void e125O2( )
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

   public void zm5O165( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1341EmpHsPDiaDia = T005O3_A1341EmpHsPDiaDia[0] ;
            Z1342EmpHsPDiaDesde = T005O3_A1342EmpHsPDiaDesde[0] ;
            Z1343EmpTarifaPDia = T005O3_A1343EmpTarifaPDia[0] ;
            Z1351EmpTarfaPDRec = T005O3_A1351EmpTarfaPDRec[0] ;
            Z2433EmpTarifaPDCri = T005O3_A2433EmpTarifaPDCri[0] ;
            Z2004EmpHsPDiaRelSec = T005O3_A2004EmpHsPDiaRelSec[0] ;
            Z1339EmpHsPDiaTipTra = T005O3_A1339EmpHsPDiaTipTra[0] ;
         }
         else
         {
            Z1341EmpHsPDiaDia = A1341EmpHsPDiaDia ;
            Z1342EmpHsPDiaDesde = A1342EmpHsPDiaDesde ;
            Z1343EmpTarifaPDia = A1343EmpTarifaPDia ;
            Z1351EmpTarfaPDRec = A1351EmpTarfaPDRec ;
            Z2433EmpTarifaPDCri = A2433EmpTarifaPDCri ;
            Z2004EmpHsPDiaRelSec = A2004EmpHsPDiaRelSec ;
            Z1339EmpHsPDiaTipTra = A1339EmpHsPDiaTipTra ;
         }
      }
      if ( GX_JID == -20 )
      {
         Z1340EmpHsExSec = A1340EmpHsExSec ;
         Z1341EmpHsPDiaDia = A1341EmpHsPDiaDia ;
         Z1342EmpHsPDiaDesde = A1342EmpHsPDiaDesde ;
         Z1343EmpTarifaPDia = A1343EmpTarifaPDia ;
         Z1351EmpTarfaPDRec = A1351EmpTarfaPDRec ;
         Z2433EmpTarifaPDCri = A2433EmpTarifaPDCri ;
         Z2004EmpHsPDiaRelSec = A2004EmpHsPDiaRelSec ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1339EmpHsPDiaTipTra = A1339EmpHsPDiaTipTra ;
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
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            empresa_horasextras_pordia_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
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
      if ( ! (0==AV9EmpHsExSec) )
      {
         A1340EmpHsExSec = AV9EmpHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      }
      if ( ! (0==AV9EmpHsExSec) )
      {
         edtEmpHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsExSec_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpHsExSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsExSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9EmpHsExSec) )
      {
         edtEmpHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsExSec_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_EmpHsPDiaTipTra)==0) )
      {
         dynEmpHsPDiaTipTra.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
      else
      {
         dynEmpHsPDiaTipTra.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
      gxaemphspdiatiptra_html5O165( AV26PaiCod) ;
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_EmpHsPDiaTipTra)==0) )
      {
         A1339EmpHsPDiaTipTra = AV15Insert_EmpHsPDiaTipTra ;
         httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
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
         AV27Pgmname = "Empresa_horasextras_porDia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      }
   }

   public void load5O165( )
   {
      /* Using cursor T005O5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1341EmpHsPDiaDia = T005O5_A1341EmpHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
         A1342EmpHsPDiaDesde = T005O5_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = T005O5_n1342EmpHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1342EmpHsPDiaDesde", A1342EmpHsPDiaDesde);
         A1343EmpTarifaPDia = T005O5_A1343EmpTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1343EmpTarifaPDia", GXutil.ltrimstr( A1343EmpTarifaPDia, 6, 4));
         A1351EmpTarfaPDRec = T005O5_A1351EmpTarfaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1351EmpTarfaPDRec", GXutil.ltrimstr( A1351EmpTarfaPDRec, 6, 4));
         A2433EmpTarifaPDCri = T005O5_A2433EmpTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
         A2004EmpHsPDiaRelSec = T005O5_A2004EmpHsPDiaRelSec[0] ;
         A1339EmpHsPDiaTipTra = T005O5_A1339EmpHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
         zm5O165( -20) ;
      }
      pr_default.close(3);
      onLoadActions5O165( ) ;
   }

   public void onLoadActions5O165( )
   {
      AV27Pgmname = "Empresa_horasextras_porDia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
   }

   public void checkExtendedTable5O165( )
   {
      nIsDirty_165 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV27Pgmname = "Empresa_horasextras_porDia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      /* Using cursor T005O4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "horasextras_por Limite", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1341EmpHsPDiaDia == 1 ) || ( A1341EmpHsPDiaDia == 2 ) || ( A1341EmpHsPDiaDia == 3 ) || ( A1341EmpHsPDiaDia == 4 ) || ( A1341EmpHsPDiaDia == 5 ) || ( A1341EmpHsPDiaDia == 6 ) || ( A1341EmpHsPDiaDia == 7 ) || ( A1341EmpHsPDiaDia == 8 ) || ( A1341EmpHsPDiaDia == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Día", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPHSPDIADIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEmpHsPDiaDia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2433EmpTarifaPDCri, "exceso") == 0 ) || ( GXutil.strcmp(A2433EmpTarifaPDCri, "horario") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Criterio de aplicación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPTARIFAPDCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEmpTarifaPDCri.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5O165( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_21( int A3CliCod ,
                          short A1EmpCod ,
                          String A1339EmpHsPDiaTipTra )
   {
      /* Using cursor T005O6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "horasextras_por Limite", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPHSPDIATIPTRA");
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

   public void getKey5O165( )
   {
      /* Using cursor T005O7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound165 = (short)(1) ;
      }
      else
      {
         RcdFound165 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005O3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5O165( 20) ;
         RcdFound165 = (short)(1) ;
         A1340EmpHsExSec = T005O3_A1340EmpHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
         A1341EmpHsPDiaDia = T005O3_A1341EmpHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
         A1342EmpHsPDiaDesde = T005O3_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = T005O3_n1342EmpHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1342EmpHsPDiaDesde", A1342EmpHsPDiaDesde);
         A1343EmpTarifaPDia = T005O3_A1343EmpTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1343EmpTarifaPDia", GXutil.ltrimstr( A1343EmpTarifaPDia, 6, 4));
         A1351EmpTarfaPDRec = T005O3_A1351EmpTarfaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1351EmpTarfaPDRec", GXutil.ltrimstr( A1351EmpTarfaPDRec, 6, 4));
         A2433EmpTarifaPDCri = T005O3_A2433EmpTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
         A2004EmpHsPDiaRelSec = T005O3_A2004EmpHsPDiaRelSec[0] ;
         A3CliCod = T005O3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005O3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1339EmpHsPDiaTipTra = T005O3_A1339EmpHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1340EmpHsExSec = A1340EmpHsExSec ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5O165( ) ;
         if ( AnyError == 1 )
         {
            RcdFound165 = (short)(0) ;
            initializeNonKey5O165( ) ;
         }
         Gx_mode = sMode165 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound165 = (short)(0) ;
         initializeNonKey5O165( ) ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode165 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5O165( ) ;
      if ( RcdFound165 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound165 = (short)(0) ;
      /* Using cursor T005O8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1340EmpHsExSec), Short.valueOf(A1340EmpHsExSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1340EmpHsExSec), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T005O8_A1340EmpHsExSec[0] < A1340EmpHsExSec ) || ( T005O8_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O8_A3CliCod[0] < A3CliCod ) || ( T005O8_A3CliCod[0] == A3CliCod ) && ( T005O8_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O8_A1EmpCod[0] < A1EmpCod ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T005O8_A1340EmpHsExSec[0] > A1340EmpHsExSec ) || ( T005O8_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O8_A3CliCod[0] > A3CliCod ) || ( T005O8_A3CliCod[0] == A3CliCod ) && ( T005O8_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O8_A1EmpCod[0] > A1EmpCod ) ) )
         {
            A1340EmpHsExSec = T005O8_A1340EmpHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
            A3CliCod = T005O8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005O8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            RcdFound165 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound165 = (short)(0) ;
      /* Using cursor T005O9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A1340EmpHsExSec), Short.valueOf(A1340EmpHsExSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1340EmpHsExSec), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005O9_A1340EmpHsExSec[0] > A1340EmpHsExSec ) || ( T005O9_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O9_A3CliCod[0] > A3CliCod ) || ( T005O9_A3CliCod[0] == A3CliCod ) && ( T005O9_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O9_A1EmpCod[0] > A1EmpCod ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005O9_A1340EmpHsExSec[0] < A1340EmpHsExSec ) || ( T005O9_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O9_A3CliCod[0] < A3CliCod ) || ( T005O9_A3CliCod[0] == A3CliCod ) && ( T005O9_A1340EmpHsExSec[0] == A1340EmpHsExSec ) && ( T005O9_A1EmpCod[0] < A1EmpCod ) ) )
         {
            A1340EmpHsExSec = T005O9_A1340EmpHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
            A3CliCod = T005O9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005O9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            RcdFound165 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5O165( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5O165( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound165 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1340EmpHsExSec != Z1340EmpHsExSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1340EmpHsExSec = Z1340EmpHsExSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5O165( ) ;
               GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1340EmpHsExSec != Z1340EmpHsExSec ) )
            {
               /* Insert record */
               GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5O165( ) ;
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
                  GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5O165( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1340EmpHsExSec != Z1340EmpHsExSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1340EmpHsExSec = Z1340EmpHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5O165( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005O2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1341EmpHsPDiaDia != T005O2_A1341EmpHsPDiaDia[0] ) || ( GXutil.strcmp(Z1342EmpHsPDiaDesde, T005O2_A1342EmpHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1343EmpTarifaPDia, T005O2_A1343EmpTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1351EmpTarfaPDRec, T005O2_A1351EmpTarfaPDRec[0]) != 0 ) || ( GXutil.strcmp(Z2433EmpTarifaPDCri, T005O2_A2433EmpTarifaPDCri[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2004EmpHsPDiaRelSec != T005O2_A2004EmpHsPDiaRelSec[0] ) || ( GXutil.strcmp(Z1339EmpHsPDiaTipTra, T005O2_A1339EmpHsPDiaTipTra[0]) != 0 ) )
         {
            if ( Z1341EmpHsPDiaDia != T005O2_A1341EmpHsPDiaDia[0] )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpHsPDiaDia");
               GXutil.writeLogRaw("Old: ",Z1341EmpHsPDiaDia);
               GXutil.writeLogRaw("Current: ",T005O2_A1341EmpHsPDiaDia[0]);
            }
            if ( GXutil.strcmp(Z1342EmpHsPDiaDesde, T005O2_A1342EmpHsPDiaDesde[0]) != 0 )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpHsPDiaDesde");
               GXutil.writeLogRaw("Old: ",Z1342EmpHsPDiaDesde);
               GXutil.writeLogRaw("Current: ",T005O2_A1342EmpHsPDiaDesde[0]);
            }
            if ( DecimalUtil.compareTo(Z1343EmpTarifaPDia, T005O2_A1343EmpTarifaPDia[0]) != 0 )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpTarifaPDia");
               GXutil.writeLogRaw("Old: ",Z1343EmpTarifaPDia);
               GXutil.writeLogRaw("Current: ",T005O2_A1343EmpTarifaPDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1351EmpTarfaPDRec, T005O2_A1351EmpTarfaPDRec[0]) != 0 )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpTarfaPDRec");
               GXutil.writeLogRaw("Old: ",Z1351EmpTarfaPDRec);
               GXutil.writeLogRaw("Current: ",T005O2_A1351EmpTarfaPDRec[0]);
            }
            if ( GXutil.strcmp(Z2433EmpTarifaPDCri, T005O2_A2433EmpTarifaPDCri[0]) != 0 )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpTarifaPDCri");
               GXutil.writeLogRaw("Old: ",Z2433EmpTarifaPDCri);
               GXutil.writeLogRaw("Current: ",T005O2_A2433EmpTarifaPDCri[0]);
            }
            if ( Z2004EmpHsPDiaRelSec != T005O2_A2004EmpHsPDiaRelSec[0] )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpHsPDiaRelSec");
               GXutil.writeLogRaw("Old: ",Z2004EmpHsPDiaRelSec);
               GXutil.writeLogRaw("Current: ",T005O2_A2004EmpHsPDiaRelSec[0]);
            }
            if ( GXutil.strcmp(Z1339EmpHsPDiaTipTra, T005O2_A1339EmpHsPDiaTipTra[0]) != 0 )
            {
               GXutil.writeLogln("empresa_horasextras_pordia:[seudo value changed for attri]"+"EmpHsPDiaTipTra");
               GXutil.writeLogRaw("Old: ",Z1339EmpHsPDiaTipTra);
               GXutil.writeLogRaw("Current: ",T005O2_A1339EmpHsPDiaTipTra[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresahorasextras_pordia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5O165( )
   {
      beforeValidate5O165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5O165( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5O165( 0) ;
         checkOptimisticConcurrency5O165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5O165( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5O165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005O10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1340EmpHsExSec), Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri, Integer.valueOf(A2004EmpHsPDiaRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
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
                        resetCaption5O0( ) ;
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
            load5O165( ) ;
         }
         endLevel5O165( ) ;
      }
      closeExtendedTableCursors5O165( ) ;
   }

   public void update5O165( )
   {
      beforeValidate5O165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5O165( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5O165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5O165( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5O165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005O11 */
                  pr_default.execute(9, new Object[] {Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri, Integer.valueOf(A2004EmpHsPDiaRelSec), A1339EmpHsPDiaTipTra, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5O165( ) ;
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
         endLevel5O165( ) ;
      }
      closeExtendedTableCursors5O165( ) ;
   }

   public void deferredUpdate5O165( )
   {
   }

   public void delete( )
   {
      beforeValidate5O165( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5O165( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5O165( ) ;
         afterConfirm5O165( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5O165( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005O12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
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
      sMode165 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5O165( ) ;
      Gx_mode = sMode165 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5O165( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "Empresa_horasextras_porDia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      }
   }

   public void endLevel5O165( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5O165( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresa_horasextras_pordia");
         if ( AnyError == 0 )
         {
            confirmValues5O0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "empresa_horasextras_pordia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5O165( )
   {
      /* Scan By routine */
      /* Using cursor T005O13 */
      pr_default.execute(11);
      RcdFound165 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A3CliCod = T005O13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005O13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1340EmpHsExSec = T005O13_A1340EmpHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5O165( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound165 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A3CliCod = T005O13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005O13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1340EmpHsExSec = T005O13_A1340EmpHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      }
   }

   public void scanEnd5O165( )
   {
      pr_default.close(11);
   }

   public void afterConfirm5O165( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5O165( )
   {
      /* Before Insert Rules */
      GXt_int4 = A1340EmpHsExSec ;
      GXv_int5[0] = GXt_int4 ;
      new web.getnextsechorasextraordinaria(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_int5) ;
      empresa_horasextras_pordia_impl.this.GXt_int4 = GXv_int5[0] ;
      A1340EmpHsExSec = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
   }

   public void beforeUpdate5O165( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5O165( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5O165( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5O165( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5O165( )
   {
      dynEmpHsPDiaTipTra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpHsPDiaTipTra.getEnabled(), 5, 0), true);
      cmbEmpHsPDiaDia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpHsPDiaDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpHsPDiaDia.getEnabled(), 5, 0), true);
      edtEmpHsPDiaDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsPDiaDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsPDiaDesde_Enabled), 5, 0), true);
      edtEmpTarifaPDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpTarifaPDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpTarifaPDia_Enabled), 5, 0), true);
      edtEmpTarfaPDRec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpTarfaPDRec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpTarfaPDRec_Enabled), 5, 0), true);
      cmbEmpTarifaPDCri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpTarifaPDCri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpTarifaPDCri.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtEmpHsExSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpHsExSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5O165( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5O0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresa_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpHsExSec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpHsExSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Empresa_horasextras_porDia");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("EmpHsPDiaRelSec", localUtil.format( DecimalUtil.doubleToDec(A2004EmpHsPDiaRelSec), "ZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("empresa_horasextras_pordia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1340EmpHsExSec", GXutil.ltrim( localUtil.ntoc( Z1340EmpHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1341EmpHsPDiaDia", GXutil.ltrim( localUtil.ntoc( Z1341EmpHsPDiaDia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1342EmpHsPDiaDesde", GXutil.rtrim( Z1342EmpHsPDiaDesde));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1343EmpTarifaPDia", GXutil.ltrim( localUtil.ntoc( Z1343EmpTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1351EmpTarfaPDRec", GXutil.ltrim( localUtil.ntoc( Z1351EmpTarfaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2433EmpTarifaPDCri", GXutil.rtrim( Z2433EmpTarifaPDCri));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2004EmpHsPDiaRelSec", GXutil.ltrim( localUtil.ntoc( Z2004EmpHsPDiaRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1339EmpHsPDiaTipTra", GXutil.rtrim( Z1339EmpHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1339EmpHsPDiaTipTra", GXutil.rtrim( A1339EmpHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPHSEXSEC", GXutil.ltrim( localUtil.ntoc( AV9EmpHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpHsExSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_EMPHSPDIATIPTRA", GXutil.rtrim( AV15Insert_EmpHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV26PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPHSPDIARELSEC", GXutil.ltrim( localUtil.ntoc( A2004EmpHsPDiaRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV27Pgmname));
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
      return formatLink("web.empresa_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpHsExSec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpHsExSec"})  ;
   }

   public String getPgmname( )
   {
      return "Empresa_horasextras_porDia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresa_horasextras_por Dia", "") ;
   }

   public void initializeNonKey5O165( )
   {
      A1294PaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      A1339EmpHsPDiaTipTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1339EmpHsPDiaTipTra", A1339EmpHsPDiaTipTra);
      A1341EmpHsPDiaDia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
      A1342EmpHsPDiaDesde = "" ;
      n1342EmpHsPDiaDesde = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1342EmpHsPDiaDesde", A1342EmpHsPDiaDesde);
      n1342EmpHsPDiaDesde = ((GXutil.strcmp("", A1342EmpHsPDiaDesde)==0) ? true : false) ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1343EmpTarifaPDia", GXutil.ltrimstr( A1343EmpTarifaPDia, 6, 4));
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1351EmpTarfaPDRec", GXutil.ltrimstr( A1351EmpTarfaPDRec, 6, 4));
      A2433EmpTarifaPDCri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
      A2004EmpHsPDiaRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2004EmpHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2004EmpHsPDiaRelSec), 6, 0));
      Z1341EmpHsPDiaDia = (byte)(0) ;
      Z1342EmpHsPDiaDesde = "" ;
      Z1343EmpTarifaPDia = DecimalUtil.ZERO ;
      Z1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z2433EmpTarifaPDCri = "" ;
      Z2004EmpHsPDiaRelSec = 0 ;
      Z1339EmpHsPDiaTipTra = "" ;
   }

   public void initAll5O165( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1340EmpHsExSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      initializeNonKey5O165( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818312668", true, true);
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
      httpContext.AddJavascriptSource("empresa_horasextras_pordia.js", "?20251818312668", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynEmpHsPDiaTipTra.setInternalname( "EMPHSPDIATIPTRA" );
      cmbEmpHsPDiaDia.setInternalname( "EMPHSPDIADIA" );
      edtEmpHsPDiaDesde_Internalname = "EMPHSPDIADESDE" ;
      edtEmpTarifaPDia_Internalname = "EMPTARIFAPDIA" ;
      edtEmpTarfaPDRec_Internalname = "EMPTARFAPDREC" ;
      cmbEmpTarifaPDCri.setInternalname( "EMPTARIFAPDCRI" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtEmpHsExSec_Internalname = "EMPHSEXSEC" ;
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
      Form.setCaption( httpContext.getMessage( "Empresa_horasextras_por Dia", "") );
      edtEmpHsExSec_Jsonclick = "" ;
      edtEmpHsExSec_Enabled = 1 ;
      edtEmpHsExSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbEmpTarifaPDCri.setJsonclick( "" );
      cmbEmpTarifaPDCri.setEnabled( 1 );
      edtEmpTarfaPDRec_Jsonclick = "" ;
      edtEmpTarfaPDRec_Enabled = 1 ;
      edtEmpTarifaPDia_Jsonclick = "" ;
      edtEmpTarifaPDia_Enabled = 1 ;
      edtEmpHsPDiaDesde_Jsonclick = "" ;
      edtEmpHsPDiaDesde_Enabled = 1 ;
      cmbEmpHsPDiaDia.setJsonclick( "" );
      cmbEmpHsPDiaDia.setEnabled( 1 );
      dynEmpHsPDiaTipTra.setJsonclick( "" );
      dynEmpHsPDiaTipTra.setEnabled( 1 );
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

   public void gxdlaemphspdiatiptra5O165( short AV26PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaemphspdiatiptra_data5O165( AV26PaiCod) ;
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

   public void gxaemphspdiatiptra_html5O165( short AV26PaiCod )
   {
      String gxdynajaxvalue;
      gxdlaemphspdiatiptra_data5O165( AV26PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynEmpHsPDiaTipTra.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynEmpHsPDiaTipTra.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaemphspdiatiptra_data5O165( short AV26PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005O14 */
      pr_default.execute(12, new Object[] {Short.valueOf(AV26PaiCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005O14_A1294PaiTipoTraId[0]));
         gxdynajaxctrldescr.add(GXutil.rtrim( T005O14_A1294PaiTipoTraId[0]));
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx6asaclicod5O165( int AV7CliCod )
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
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            empresa_horasextras_pordia_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
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

   public void gx10asaemphsexsec5O165( short AV9EmpHsExSec )
   {
      if ( ! (0==AV9EmpHsExSec) )
      {
         A1340EmpHsExSec = AV9EmpHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1340EmpHsExSec, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx11asaemphsexsec5O165( int AV7CliCod ,
                                       short AV8EmpCod )
   {
      GXt_int4 = A1340EmpHsExSec ;
      GXv_int5[0] = GXt_int4 ;
      new web.getnextsechorasextraordinaria(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_int5) ;
      empresa_horasextras_pordia_impl.this.GXt_int4 = GXv_int5[0] ;
      A1340EmpHsExSec = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1340EmpHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1340EmpHsExSec), 4, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1340EmpHsExSec, (byte)(4), (byte)(0), ".", "")))+"\"") ;
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
      dynEmpHsPDiaTipTra.setName( "EMPHSPDIATIPTRA" );
      dynEmpHsPDiaTipTra.setWebtags( "" );
      cmbEmpHsPDiaDia.setName( "EMPHSPDIADIA" );
      cmbEmpHsPDiaDia.setWebtags( "" );
      cmbEmpHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbEmpHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbEmpHsPDiaDia.getItemCount() > 0 )
      {
         A1341EmpHsPDiaDia = (byte)(GXutil.lval( cmbEmpHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1341EmpHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1341EmpHsPDiaDia", GXutil.str( A1341EmpHsPDiaDia, 1, 0));
      }
      cmbEmpTarifaPDCri.setName( "EMPTARIFAPDCRI" );
      cmbEmpTarifaPDCri.setWebtags( "" );
      cmbEmpTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbEmpTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbEmpTarifaPDCri.getItemCount() > 0 )
      {
         A2433EmpTarifaPDCri = cmbEmpTarifaPDCri.getValidValue(A2433EmpTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2433EmpTarifaPDCri", A2433EmpTarifaPDCri);
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

   public void valid_Emphspdiatiptra( )
   {
      A1339EmpHsPDiaTipTra = dynEmpHsPDiaTipTra.getValue() ;
      /* Using cursor T005O15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "horasextras_por Limite", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      if ( ! ( ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynEmpHsPDiaTipTra.getInternalname() ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpHsExSec',fld:'vEMPHSEXSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpHsExSec',fld:'vEMPHSEXSEC',pic:'ZZZ9',hsh:true},{av:'A2004EmpHsPDiaRelSec',fld:'EMPHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e125O2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_EMPHSPDIATIPTRA","{handler:'valid_Emphspdiatiptra',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV26PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynEmpHsPDiaTipTra'},{av:'A1339EmpHsPDiaTipTra',fld:'EMPHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_EMPHSPDIATIPTRA",",oparms:[]}");
      setEventMetadata("VALID_EMPHSPDIADIA","{handler:'valid_Emphspdiadia',iparms:[]");
      setEventMetadata("VALID_EMPHSPDIADIA",",oparms:[]}");
      setEventMetadata("VALID_EMPTARIFAPDCRI","{handler:'valid_Emptarifapdcri',iparms:[]");
      setEventMetadata("VALID_EMPTARIFAPDCRI",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_EMPHSEXSEC","{handler:'valid_Emphsexsec',iparms:[]");
      setEventMetadata("VALID_EMPHSEXSEC",",oparms:[]}");
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
      Z1342EmpHsPDiaDesde = "" ;
      Z1343EmpTarifaPDia = DecimalUtil.ZERO ;
      Z1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z2433EmpTarifaPDCri = "" ;
      Z1339EmpHsPDiaTipTra = "" ;
      N1339EmpHsPDiaTipTra = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2433EmpTarifaPDCri = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1342EmpHsPDiaDesde = "" ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV15Insert_EmpHsPDiaTipTra = "" ;
      AV27Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode165 = "" ;
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
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      T005O5_A1340EmpHsExSec = new short[1] ;
      T005O5_A1341EmpHsPDiaDia = new byte[1] ;
      T005O5_A1342EmpHsPDiaDesde = new String[] {""} ;
      T005O5_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      T005O5_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O5_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O5_A2433EmpTarifaPDCri = new String[] {""} ;
      T005O5_A2004EmpHsPDiaRelSec = new int[1] ;
      T005O5_A3CliCod = new int[1] ;
      T005O5_A1EmpCod = new short[1] ;
      T005O5_A1339EmpHsPDiaTipTra = new String[] {""} ;
      T005O4_A1294PaiTipoTraId = new String[] {""} ;
      T005O6_A1294PaiTipoTraId = new String[] {""} ;
      T005O7_A3CliCod = new int[1] ;
      T005O7_A1EmpCod = new short[1] ;
      T005O7_A1340EmpHsExSec = new short[1] ;
      T005O3_A1340EmpHsExSec = new short[1] ;
      T005O3_A1341EmpHsPDiaDia = new byte[1] ;
      T005O3_A1342EmpHsPDiaDesde = new String[] {""} ;
      T005O3_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      T005O3_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O3_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O3_A2433EmpTarifaPDCri = new String[] {""} ;
      T005O3_A2004EmpHsPDiaRelSec = new int[1] ;
      T005O3_A3CliCod = new int[1] ;
      T005O3_A1EmpCod = new short[1] ;
      T005O3_A1339EmpHsPDiaTipTra = new String[] {""} ;
      T005O8_A1340EmpHsExSec = new short[1] ;
      T005O8_A3CliCod = new int[1] ;
      T005O8_A1EmpCod = new short[1] ;
      T005O9_A1340EmpHsExSec = new short[1] ;
      T005O9_A3CliCod = new int[1] ;
      T005O9_A1EmpCod = new short[1] ;
      T005O2_A1340EmpHsExSec = new short[1] ;
      T005O2_A1341EmpHsPDiaDia = new byte[1] ;
      T005O2_A1342EmpHsPDiaDesde = new String[] {""} ;
      T005O2_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      T005O2_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O2_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005O2_A2433EmpTarifaPDCri = new String[] {""} ;
      T005O2_A2004EmpHsPDiaRelSec = new int[1] ;
      T005O2_A3CliCod = new int[1] ;
      T005O2_A1EmpCod = new short[1] ;
      T005O2_A1339EmpHsPDiaTipTra = new String[] {""} ;
      T005O13_A3CliCod = new int[1] ;
      T005O13_A1EmpCod = new short[1] ;
      T005O13_A1340EmpHsExSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      A1294PaiTipoTraId = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005O14_A46PaiCod = new short[1] ;
      T005O14_A1294PaiTipoTraId = new String[] {""} ;
      GXv_int7 = new int[1] ;
      GXv_int5 = new short[1] ;
      T005O15_A1294PaiTipoTraId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_horasextras_pordia__default(),
         new Object[] {
             new Object[] {
            T005O2_A1340EmpHsExSec, T005O2_A1341EmpHsPDiaDia, T005O2_A1342EmpHsPDiaDesde, T005O2_n1342EmpHsPDiaDesde, T005O2_A1343EmpTarifaPDia, T005O2_A1351EmpTarfaPDRec, T005O2_A2433EmpTarifaPDCri, T005O2_A2004EmpHsPDiaRelSec, T005O2_A3CliCod, T005O2_A1EmpCod,
            T005O2_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            T005O3_A1340EmpHsExSec, T005O3_A1341EmpHsPDiaDia, T005O3_A1342EmpHsPDiaDesde, T005O3_n1342EmpHsPDiaDesde, T005O3_A1343EmpTarifaPDia, T005O3_A1351EmpTarfaPDRec, T005O3_A2433EmpTarifaPDCri, T005O3_A2004EmpHsPDiaRelSec, T005O3_A3CliCod, T005O3_A1EmpCod,
            T005O3_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            T005O4_A1294PaiTipoTraId
            }
            , new Object[] {
            T005O5_A1340EmpHsExSec, T005O5_A1341EmpHsPDiaDia, T005O5_A1342EmpHsPDiaDesde, T005O5_n1342EmpHsPDiaDesde, T005O5_A1343EmpTarifaPDia, T005O5_A1351EmpTarfaPDRec, T005O5_A2433EmpTarifaPDCri, T005O5_A2004EmpHsPDiaRelSec, T005O5_A3CliCod, T005O5_A1EmpCod,
            T005O5_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            T005O6_A1294PaiTipoTraId
            }
            , new Object[] {
            T005O7_A3CliCod, T005O7_A1EmpCod, T005O7_A1340EmpHsExSec
            }
            , new Object[] {
            T005O8_A1340EmpHsExSec, T005O8_A3CliCod, T005O8_A1EmpCod
            }
            , new Object[] {
            T005O9_A1340EmpHsExSec, T005O9_A3CliCod, T005O9_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005O13_A3CliCod, T005O13_A1EmpCod, T005O13_A1340EmpHsExSec
            }
            , new Object[] {
            T005O14_A46PaiCod, T005O14_A1294PaiTipoTraId
            }
            , new Object[] {
            T005O15_A1294PaiTipoTraId
            }
         }
      );
      AV27Pgmname = "Empresa_horasextras_porDia" ;
   }

   private byte Z1341EmpHsPDiaDia ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1341EmpHsPDiaDia ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV9EmpHsExSec ;
   private short Z1EmpCod ;
   private short Z1340EmpHsExSec ;
   private short AV26PaiCod ;
   private short AV9EmpHsExSec ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1340EmpHsExSec ;
   private short RcdFound165 ;
   private short nIsDirty_165 ;
   private short GXt_int4 ;
   private short GXv_int5[] ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2004EmpHsPDiaRelSec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtEmpHsPDiaDesde_Enabled ;
   private int edtEmpTarifaPDia_Enabled ;
   private int edtEmpTarfaPDRec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtEmpHsExSec_Visible ;
   private int edtEmpHsExSec_Enabled ;
   private int A2004EmpHsPDiaRelSec ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV28GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private java.math.BigDecimal Z1343EmpTarifaPDia ;
   private java.math.BigDecimal Z1351EmpTarfaPDRec ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1342EmpHsPDiaDesde ;
   private String Z2433EmpTarifaPDCri ;
   private String Z1339EmpHsPDiaTipTra ;
   private String N1339EmpHsPDiaTipTra ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1339EmpHsPDiaTipTra ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A2433EmpTarifaPDCri ;
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
   private String edtEmpHsPDiaDesde_Internalname ;
   private String A1342EmpHsPDiaDesde ;
   private String edtEmpHsPDiaDesde_Jsonclick ;
   private String edtEmpTarifaPDia_Internalname ;
   private String edtEmpTarifaPDia_Jsonclick ;
   private String edtEmpTarfaPDRec_Internalname ;
   private String edtEmpTarfaPDRec_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtEmpHsExSec_Internalname ;
   private String edtEmpHsExSec_Jsonclick ;
   private String AV15Insert_EmpHsPDiaTipTra ;
   private String AV27Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode165 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String A1294PaiTipoTraId ;
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
   private boolean n1342EmpHsPDiaDesde ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynEmpHsPDiaTipTra ;
   private HTMLChoice cmbEmpHsPDiaDia ;
   private HTMLChoice cmbEmpTarifaPDCri ;
   private IDataStoreProvider pr_default ;
   private short[] T005O5_A1340EmpHsExSec ;
   private byte[] T005O5_A1341EmpHsPDiaDia ;
   private String[] T005O5_A1342EmpHsPDiaDesde ;
   private boolean[] T005O5_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] T005O5_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] T005O5_A1351EmpTarfaPDRec ;
   private String[] T005O5_A2433EmpTarifaPDCri ;
   private int[] T005O5_A2004EmpHsPDiaRelSec ;
   private int[] T005O5_A3CliCod ;
   private short[] T005O5_A1EmpCod ;
   private String[] T005O5_A1339EmpHsPDiaTipTra ;
   private String[] T005O4_A1294PaiTipoTraId ;
   private String[] T005O6_A1294PaiTipoTraId ;
   private int[] T005O7_A3CliCod ;
   private short[] T005O7_A1EmpCod ;
   private short[] T005O7_A1340EmpHsExSec ;
   private short[] T005O3_A1340EmpHsExSec ;
   private byte[] T005O3_A1341EmpHsPDiaDia ;
   private String[] T005O3_A1342EmpHsPDiaDesde ;
   private boolean[] T005O3_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] T005O3_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] T005O3_A1351EmpTarfaPDRec ;
   private String[] T005O3_A2433EmpTarifaPDCri ;
   private int[] T005O3_A2004EmpHsPDiaRelSec ;
   private int[] T005O3_A3CliCod ;
   private short[] T005O3_A1EmpCod ;
   private String[] T005O3_A1339EmpHsPDiaTipTra ;
   private short[] T005O8_A1340EmpHsExSec ;
   private int[] T005O8_A3CliCod ;
   private short[] T005O8_A1EmpCod ;
   private short[] T005O9_A1340EmpHsExSec ;
   private int[] T005O9_A3CliCod ;
   private short[] T005O9_A1EmpCod ;
   private short[] T005O2_A1340EmpHsExSec ;
   private byte[] T005O2_A1341EmpHsPDiaDia ;
   private String[] T005O2_A1342EmpHsPDiaDesde ;
   private boolean[] T005O2_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] T005O2_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] T005O2_A1351EmpTarfaPDRec ;
   private String[] T005O2_A2433EmpTarifaPDCri ;
   private int[] T005O2_A2004EmpHsPDiaRelSec ;
   private int[] T005O2_A3CliCod ;
   private short[] T005O2_A1EmpCod ;
   private String[] T005O2_A1339EmpHsPDiaTipTra ;
   private int[] T005O13_A3CliCod ;
   private short[] T005O13_A1EmpCod ;
   private short[] T005O13_A1340EmpHsExSec ;
   private short[] T005O14_A46PaiCod ;
   private String[] T005O14_A1294PaiTipoTraId ;
   private String[] T005O15_A1294PaiTipoTraId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
}

final  class empresa_horasextras_pordia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005O2", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?  FOR UPDATE OF Empresahorasextras_pordia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O3", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O4", "SELECT PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O5", "SELECT TM1.EmpHsExSec, TM1.EmpHsPDiaDia, TM1.EmpHsPDiaDesde, TM1.EmpTarifaPDia, TM1.EmpTarfaPDRec, TM1.EmpTarifaPDCri, TM1.EmpHsPDiaRelSec, TM1.CliCod, TM1.EmpCod, TM1.EmpHsPDiaTipTra FROM Empresahorasextras_pordia TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpHsExSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O6", "SELECT PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O7", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O8", "SELECT EmpHsExSec, CliCod, EmpCod FROM Empresahorasextras_pordia WHERE ( EmpHsExSec > ? or EmpHsExSec = ? and CliCod > ? or CliCod = ? and EmpHsExSec = ? and EmpCod > ?) ORDER BY CliCod, EmpCod, EmpHsExSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005O9", "SELECT EmpHsExSec, CliCod, EmpCod FROM Empresahorasextras_pordia WHERE ( EmpHsExSec < ? or EmpHsExSec = ? and CliCod < ? or CliCod = ? and EmpHsExSec = ? and EmpCod < ?) ORDER BY CliCod DESC, EmpCod DESC, EmpHsExSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005O10", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec, CliCod, EmpCod, EmpHsPDiaTipTra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005O11", "SAVEPOINT gxupdate;UPDATE Empresahorasextras_pordia SET EmpHsPDiaDia=?, EmpHsPDiaDesde=?, EmpTarifaPDia=?, EmpTarfaPDRec=?, EmpTarifaPDCri=?, EmpHsPDiaRelSec=?, EmpHsPDiaTipTra=?  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005O12", "SAVEPOINT gxupdate;DELETE FROM Empresahorasextras_pordia  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005O13", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia ORDER BY CliCod, EmpCod, EmpHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O14", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? ORDER BY PaiTipoTraId ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005O15", "SELECT PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setString(6, (String)parms[6], 20);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setString(10, (String)parms[10], 20);
               return;
            case 9 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 5);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setString(5, (String)parms[5], 20);
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setShort(10, ((Number) parms[10]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

