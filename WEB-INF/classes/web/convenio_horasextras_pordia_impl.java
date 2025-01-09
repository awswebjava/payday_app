package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_horasextras_pordia_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action26") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A2066ConveHsPDiaRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveHsPDiaRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_26_3V215( Gx_mode, AV7CliCod, A2066ConveHsPDiaRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEHSPDIARELSEC") == 0 )
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
         gxdlaconvehspdiarelsec3V215( AV7CliCod) ;
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
         gx6asaclicod3V215( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2430ConveHSPDiaConcepto = httpContext.GetPar( "ConveHSPDiaConcepto") ;
         n2430ConveHSPDiaConcepto = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2430ConveHSPDiaConcepto", A2430ConveHSPDiaConcepto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A3CliCod, A2430ConveHSPDiaConcepto) ;
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
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10ConveHsExSec = (short)(GXutil.lval( httpContext.GetPar( "ConveHsExSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ConveHsExSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ConveHsExSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio_horasextras_por Dia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConveHsExSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public convenio_horasextras_pordia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_horasextras_pordia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_horasextras_pordia_impl.class ));
   }

   public convenio_horasextras_pordia_impl( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConvHsPDiaTipTra = new HTMLChoice();
      cmbConveHsPDiaDia = new HTMLChoice();
      cmbConveTarifaPDCri = new HTMLChoice();
      dynConveHsPDiaRelSec = new HTMLChoice();
      cmbavComboconvhspdiatiptra = new HTMLChoice();
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
      if ( cmbConvHsPDiaTipTra.getItemCount() > 0 )
      {
         A1326ConvHsPDiaTipTra = cmbConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConvHsPDiaTipTra.setValue( GXutil.rtrim( A1326ConvHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Values", cmbConvHsPDiaTipTra.ToJavascriptSource(), true);
      }
      if ( cmbConveHsPDiaDia.getItemCount() > 0 )
      {
         A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveHsPDiaDia.getInternalname(), "Values", cmbConveHsPDiaDia.ToJavascriptSource(), true);
      }
      if ( cmbConveTarifaPDCri.getItemCount() > 0 )
      {
         A2432ConveTarifaPDCri = cmbConveTarifaPDCri.getValidValue(A2432ConveTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveTarifaPDCri.setValue( GXutil.rtrim( A2432ConveTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveTarifaPDCri.getInternalname(), "Values", cmbConveTarifaPDCri.ToJavascriptSource(), true);
      }
      if ( dynConveHsPDiaRelSec.getItemCount() > 0 )
      {
         A2066ConveHsPDiaRelSec = (int)(GXutil.lval( dynConveHsPDiaRelSec.getValidValue(GXutil.trim( GXutil.str( A2066ConveHsPDiaRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveHsPDiaRelSec.setValue( GXutil.trim( GXutil.str( A2066ConveHsPDiaRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveHsPDiaRelSec.getInternalname(), "Values", dynConveHsPDiaRelSec.ToJavascriptSource(), true);
      }
      if ( cmbavComboconvhspdiatiptra.getItemCount() > 0 )
      {
         AV23ComboConvHsPDiaTipTra = cmbavComboconvhspdiatiptra.getValidValue(AV23ComboConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavComboconvhspdiatiptra.setValue( GXutil.rtrim( AV23ComboConvHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavComboconvhspdiatiptra.getInternalname(), "Values", cmbavComboconvhspdiatiptra.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsExSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsExSec_Internalname, httpContext.getMessage( "Secuencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsExSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1327ConveHsExSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsExSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsExSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconvhspdiatiptra_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconvhspdiatiptra_Internalname, httpContext.getMessage( "Tipo de trabajo", ""), "", "", lblTextblockconvhspdiatiptra_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_convhspdiatiptra.setProperty("Caption", Combo_convhspdiatiptra_Caption);
      ucCombo_convhspdiatiptra.setProperty("Cls", Combo_convhspdiatiptra_Cls);
      ucCombo_convhspdiatiptra.setProperty("DataListProc", Combo_convhspdiatiptra_Datalistproc);
      ucCombo_convhspdiatiptra.setProperty("EmptyItem", Combo_convhspdiatiptra_Emptyitem);
      ucCombo_convhspdiatiptra.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_convhspdiatiptra.setProperty("DropDownOptionsData", AV18ConvHsPDiaTipTra_Data);
      ucCombo_convhspdiatiptra.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_convhspdiatiptra_Internalname, "COMBO_CONVHSPDIATIPTRAContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConvHsPDiaTipTra.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConvHsPDiaTipTra, cmbConvHsPDiaTipTra.getInternalname(), GXutil.rtrim( A1326ConvHsPDiaTipTra), 1, cmbConvHsPDiaTipTra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbConvHsPDiaTipTra.getVisible(), cmbConvHsPDiaTipTra.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "", true, (byte)(0), "HLP_Convenio_horasextras_porDia.htm");
      cmbConvHsPDiaTipTra.setValue( GXutil.rtrim( A1326ConvHsPDiaTipTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Values", cmbConvHsPDiaTipTra.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveHsPDiaDia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveHsPDiaDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveHsPDiaDia, cmbConveHsPDiaDia.getInternalname(), GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)), 1, cmbConveHsPDiaDia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConveHsPDiaDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_Convenio_horasextras_porDia.htm");
      cmbConveHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveHsPDiaDia.getInternalname(), "Values", cmbConveHsPDiaDia.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsPDiaDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsPDiaDesde_Internalname, httpContext.getMessage( "Hora desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsPDiaDesde_Internalname, GXutil.rtrim( A1329ConveHsPDiaDesde), GXutil.rtrim( localUtil.format( A1329ConveHsPDiaDesde, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsPDiaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsPDiaDesde_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveTarifaPDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveTarifaPDia_Internalname, httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveTarifaPDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1330ConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveTarifaPDia_Enabled!=0) ? localUtil.format( A1330ConveTarifaPDia, "9.9999") : localUtil.format( A1330ConveTarifaPDia, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveTarifaPDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveTarifaPDia_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveTarifaPDRec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveTarifaPDRec_Internalname, httpContext.getMessage( "Recargo a hora normal diurna", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveTarifaPDRec_Internalname, GXutil.ltrim( localUtil.ntoc( A1350ConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveTarifaPDRec_Enabled!=0) ? localUtil.format( A1350ConveTarifaPDRec, "9.9999") : localUtil.format( A1350ConveTarifaPDRec, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveTarifaPDRec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveTarifaPDRec_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveTarifaPDCri.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveTarifaPDCri.getInternalname(), httpContext.getMessage( "Criterio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveTarifaPDCri, cmbConveTarifaPDCri.getInternalname(), GXutil.rtrim( A2432ConveTarifaPDCri), 1, cmbConveTarifaPDCri.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveTarifaPDCri.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(0), "HLP_Convenio_horasextras_porDia.htm");
      cmbConveTarifaPDCri.setValue( GXutil.rtrim( A2432ConveTarifaPDCri) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveTarifaPDCri.getInternalname(), "Values", cmbConveTarifaPDCri.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvehspdiarelsec_cell_Internalname, 1, 0, "px", 0, "px", divConvehspdiarelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveHsPDiaRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveHsPDiaRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveHsPDiaRelSec, dynConveHsPDiaRelSec.getInternalname(), GXutil.trim( GXutil.str( A2066ConveHsPDiaRelSec, 6, 0)), 1, dynConveHsPDiaRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveHsPDiaRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_Convenio_horasextras_porDia.htm");
      dynConveHsPDiaRelSec.setValue( GXutil.trim( GXutil.str( A2066ConveHsPDiaRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveHsPDiaRelSec.getInternalname(), "Values", dynConveHsPDiaRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_horasextras_porDia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_horasextras_porDia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_convhspdiatiptra_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavComboconvhspdiatiptra, cmbavComboconvhspdiatiptra.getInternalname(), GXutil.rtrim( AV23ComboConvHsPDiaTipTra), 1, cmbavComboconvhspdiatiptra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavComboconvhspdiatiptra.getVisible(), cmbavComboconvhspdiatiptra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Convenio_horasextras_porDia.htm");
      cmbavComboconvhspdiatiptra.setValue( GXutil.rtrim( AV23ComboConvHsPDiaTipTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconvhspdiatiptra.getInternalname(), "Values", cmbavComboconvhspdiatiptra.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_horasextras_porDia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Convenio_horasextras_porDia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_horasextras_porDia.htm");
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
      e113V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONVHSPDIATIPTRA_DATA"), AV18ConvHsPDiaTipTra_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1327ConveHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1326ConvHsPDiaTipTra = httpContext.cgiGet( "Z1326ConvHsPDiaTipTra") ;
            Z1328ConveHsPDiaDia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1328ConveHsPDiaDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1329ConveHsPDiaDesde = httpContext.cgiGet( "Z1329ConveHsPDiaDesde") ;
            n1329ConveHsPDiaDesde = ((GXutil.strcmp("", A1329ConveHsPDiaDesde)==0) ? true : false) ;
            Z1330ConveTarifaPDia = localUtil.ctond( httpContext.cgiGet( "Z1330ConveTarifaPDia")) ;
            Z1350ConveTarifaPDRec = localUtil.ctond( httpContext.cgiGet( "Z1350ConveTarifaPDRec")) ;
            Z2432ConveTarifaPDCri = httpContext.cgiGet( "Z2432ConveTarifaPDCri") ;
            Z2066ConveHsPDiaRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2066ConveHsPDiaRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2067ConveHsPdiaRelRef = httpContext.cgiGet( "Z2067ConveHsPdiaRelRef") ;
            Z2430ConveHSPDiaConcepto = httpContext.cgiGet( "Z2430ConveHSPDiaConcepto") ;
            n2430ConveHSPDiaConcepto = ((GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ? true : false) ;
            A2067ConveHsPdiaRelRef = httpContext.cgiGet( "Z2067ConveHsPdiaRelRef") ;
            A2430ConveHSPDiaConcepto = httpContext.cgiGet( "Z2430ConveHSPDiaConcepto") ;
            n2430ConveHSPDiaConcepto = false ;
            n2430ConveHSPDiaConcepto = ((GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ? true : false) ;
            O1350ConveTarifaPDRec = localUtil.ctond( httpContext.cgiGet( "O1350ConveTarifaPDRec")) ;
            O1330ConveTarifaPDia = localUtil.ctond( httpContext.cgiGet( "O1330ConveTarifaPDia")) ;
            O1329ConveHsPDiaDesde = httpContext.cgiGet( "O1329ConveHsPDiaDesde") ;
            n1329ConveHsPDiaDesde = ((GXutil.strcmp("", A1329ConveHsPDiaDesde)==0) ? true : false) ;
            O1328ConveHsPDiaDia = (byte)(localUtil.ctol( httpContext.cgiGet( "O1328ConveHsPDiaDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1326ConvHsPDiaTipTra = httpContext.cgiGet( "N1326ConvHsPDiaTipTra") ;
            N2430ConveHSPDiaConcepto = httpContext.cgiGet( "N2430ConveHSPDiaConcepto") ;
            n2430ConveHSPDiaConcepto = ((GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ? true : false) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "vCONVEHSEXSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV16Insert_ConvHsPDiaTipTra = httpContext.cgiGet( "vINSERT_CONVHSPDIATIPTRA") ;
            AV29Insert_ConveHSPDiaConcepto = httpContext.cgiGet( "vINSERT_CONVEHSPDIACONCEPTO") ;
            A2430ConveHSPDiaConcepto = httpContext.cgiGet( "CONVEHSPDIACONCEPTO") ;
            n2430ConveHSPDiaConcepto = ((GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ? true : false) ;
            AV26aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2067ConveHsPdiaRelRef = httpContext.cgiGet( "CONVEHSPDIARELREF") ;
            A2068ConveHsPDiaOld = httpContext.cgiGet( "CONVEHSPDIAOLD") ;
            AV30Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_convhspdiatiptra_Objectcall = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Objectcall") ;
            Combo_convhspdiatiptra_Class = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Class") ;
            Combo_convhspdiatiptra_Icontype = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Icontype") ;
            Combo_convhspdiatiptra_Icon = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Icon") ;
            Combo_convhspdiatiptra_Caption = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Caption") ;
            Combo_convhspdiatiptra_Tooltip = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Tooltip") ;
            Combo_convhspdiatiptra_Cls = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Cls") ;
            Combo_convhspdiatiptra_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Selectedvalue_set") ;
            Combo_convhspdiatiptra_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Selectedvalue_get") ;
            Combo_convhspdiatiptra_Selectedtext_set = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Selectedtext_set") ;
            Combo_convhspdiatiptra_Selectedtext_get = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Selectedtext_get") ;
            Combo_convhspdiatiptra_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Gamoauthtoken") ;
            Combo_convhspdiatiptra_Ddointernalname = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Ddointernalname") ;
            Combo_convhspdiatiptra_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Titlecontrolalign") ;
            Combo_convhspdiatiptra_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Dropdownoptionstype") ;
            Combo_convhspdiatiptra_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Enabled")) ;
            Combo_convhspdiatiptra_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Visible")) ;
            Combo_convhspdiatiptra_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Titlecontrolidtoreplace") ;
            Combo_convhspdiatiptra_Datalisttype = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Datalisttype") ;
            Combo_convhspdiatiptra_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Allowmultipleselection")) ;
            Combo_convhspdiatiptra_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Datalistfixedvalues") ;
            Combo_convhspdiatiptra_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Isgriditem")) ;
            Combo_convhspdiatiptra_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Hasdescription")) ;
            Combo_convhspdiatiptra_Datalistproc = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Datalistproc") ;
            Combo_convhspdiatiptra_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Datalistprocparametersprefix") ;
            Combo_convhspdiatiptra_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Remoteservicesparameters") ;
            Combo_convhspdiatiptra_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_convhspdiatiptra_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Includeonlyselectedoption")) ;
            Combo_convhspdiatiptra_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Includeselectalloption")) ;
            Combo_convhspdiatiptra_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Emptyitem")) ;
            Combo_convhspdiatiptra_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Includeaddnewoption")) ;
            Combo_convhspdiatiptra_Htmltemplate = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Htmltemplate") ;
            Combo_convhspdiatiptra_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Multiplevaluestype") ;
            Combo_convhspdiatiptra_Loadingdata = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Loadingdata") ;
            Combo_convhspdiatiptra_Noresultsfound = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Noresultsfound") ;
            Combo_convhspdiatiptra_Emptyitemtext = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Emptyitemtext") ;
            Combo_convhspdiatiptra_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Onlyselectedvalues") ;
            Combo_convhspdiatiptra_Selectalltext = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Selectalltext") ;
            Combo_convhspdiatiptra_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Multiplevaluesseparator") ;
            Combo_convhspdiatiptra_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Addnewoptiontext") ;
            Combo_convhspdiatiptra_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVHSPDIATIPTRA_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSEXSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1327ConveHsExSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
            }
            else
            {
               A1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( edtConveHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
            }
            cmbConvHsPDiaTipTra.setValue( httpContext.cgiGet( cmbConvHsPDiaTipTra.getInternalname()) );
            A1326ConvHsPDiaTipTra = httpContext.cgiGet( cmbConvHsPDiaTipTra.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
            cmbConveHsPDiaDia.setValue( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()) );
            A1328ConveHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
            A1329ConveHsPDiaDesde = httpContext.cgiGet( edtConveHsPDiaDesde_Internalname) ;
            n1329ConveHsPDiaDesde = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
            n1329ConveHsPDiaDesde = ((GXutil.strcmp("", A1329ConveHsPDiaDesde)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDia_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVETARIFAPDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveTarifaPDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1330ConveTarifaPDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
            }
            else
            {
               A1330ConveTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDRec_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDRec_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVETARIFAPDREC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveTarifaPDRec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
            }
            else
            {
               A1350ConveTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDRec_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
            }
            cmbConveTarifaPDCri.setValue( httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) );
            A2432ConveTarifaPDCri = httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
            dynConveHsPDiaRelSec.setValue( httpContext.cgiGet( dynConveHsPDiaRelSec.getInternalname()) );
            A2066ConveHsPDiaRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveHsPDiaRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
            cmbavComboconvhspdiatiptra.setValue( httpContext.cgiGet( cmbavComboconvhspdiatiptra.getInternalname()) );
            AV23ComboConvHsPDiaTipTra = httpContext.cgiGet( cmbavComboconvhspdiatiptra.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_horasextras_porDia");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveHsPdiaRelRef", GXutil.rtrim( localUtil.format( A2067ConveHsPdiaRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1327ConveHsExSec != Z1327ConveHsExSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio_horasextras_pordia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1327ConveHsExSec = (short)(GXutil.lval( httpContext.GetPar( "ConveHsExSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
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
                  sMode215 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode215 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound215 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3V0( ) ;
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
                        e113V2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123V2 ();
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
         e123V2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3V215( ) ;
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
         disableAttributes3V215( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconvhspdiatiptra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavComboconvhspdiatiptra.getEnabled(), 5, 0), true);
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

   public void confirm_3V0( )
   {
      beforeValidate3V215( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3V215( ) ;
         }
         else
         {
            checkExtendedTable3V215( ) ;
            closeExtendedTableCursors3V215( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3V0( )
   {
   }

   public void e113V2( )
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
      cmbConvHsPDiaTipTra.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbConvHsPDiaTipTra.getVisible(), 5, 0), true);
      AV23ComboConvHsPDiaTipTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
      cmbavComboconvhspdiatiptra.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconvhspdiatiptra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavComboconvhspdiatiptra.getVisible(), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONVHSPDIATIPTRA' */
      S112 ();
      if ( returnInSub )
      {
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Insert", GXv_boolean5) ;
         convenio_horasextras_pordia_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Update", GXv_boolean5) ;
         convenio_horasextras_pordia_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Delete", GXv_boolean5) ;
         convenio_horasextras_pordia_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV30Pgmname))}, new String[] {"GxObject"}) );
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
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV30Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV31GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GXV1), 8, 0));
         while ( AV31GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV31GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConvHsPDiaTipTra") == 0 )
            {
               AV16Insert_ConvHsPDiaTipTra = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_ConvHsPDiaTipTra", AV16Insert_ConvHsPDiaTipTra);
               if ( ! (GXutil.strcmp("", AV16Insert_ConvHsPDiaTipTra)==0) )
               {
                  AV23ComboConvHsPDiaTipTra = AV16Insert_ConvHsPDiaTipTra ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
                  Combo_convhspdiatiptra_Selectedvalue_set = AV23ComboConvHsPDiaTipTra ;
                  ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "SelectedValue_set", Combo_convhspdiatiptra_Selectedvalue_set);
                  GXt_char6 = AV22Combo_DataJson ;
                  GXv_char7[0] = AV20ComboSelectedValue ;
                  GXv_char8[0] = AV21ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.convenio_horasextras_pordialoaddvcombo(remoteHandle, context).execute( "ConvHsPDiaTipTra", "GET", false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10ConveHsExSec, AV27Insert_CliCod, AV28Insert_CliPaiConve, AV25Insert_CliConvenio, AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  convenio_horasextras_pordia_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
                  convenio_horasextras_pordia_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
                  convenio_horasextras_pordia_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
                  AV22Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
                  Combo_convhspdiatiptra_Selectedtext_set = AV21ComboSelectedText ;
                  ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "SelectedText_set", Combo_convhspdiatiptra_Selectedtext_set);
                  Combo_convhspdiatiptra_Enabled = false ;
                  ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "Enabled", GXutil.booltostr( Combo_convhspdiatiptra_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConveHSPDiaConcepto") == 0 )
            {
               AV29Insert_ConveHSPDiaConcepto = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29Insert_ConveHSPDiaConcepto", AV29Insert_ConveHSPDiaConcepto);
            }
            AV31GXV1 = (int)(AV31GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
   }

   public void e123V2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.convenio_hsextpordiagrabarrelref(remoteHandle, context).execute( AV7CliCod) ;
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
      divConvehspdiarelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCONVHSPDIATIPTRA' Routine */
      returnInSub = false ;
      Combo_convhspdiatiptra_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ConvHsPDiaTipTra\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"ConveHsExSec\": 0, \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\", \"Cond_CliConvenio\": \"#%3#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, edtCliConvenio_Internalname, "", "", "", "", "", "") ;
      ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "DataListProcParametersPrefix", Combo_convhspdiatiptra_Datalistprocparametersprefix);
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.convenio_horasextras_pordialoaddvcombo(remoteHandle, context).execute( "ConvHsPDiaTipTra", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10ConveHsExSec, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char9, GXv_char8, GXv_char7) ;
      convenio_horasextras_pordia_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      convenio_horasextras_pordia_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      convenio_horasextras_pordia_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
      AV22Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
      Combo_convhspdiatiptra_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "SelectedValue_set", Combo_convhspdiatiptra_Selectedvalue_set);
      Combo_convhspdiatiptra_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "SelectedText_set", Combo_convhspdiatiptra_Selectedtext_set);
      AV23ComboConvHsPDiaTipTra = AV20ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_convhspdiatiptra_Enabled = false ;
         ucCombo_convhspdiatiptra.sendProperty(context, "", false, Combo_convhspdiatiptra_Internalname, "Enabled", GXutil.booltostr( Combo_convhspdiatiptra_Enabled));
      }
   }

   public void zm3V215( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1326ConvHsPDiaTipTra = T003V3_A1326ConvHsPDiaTipTra[0] ;
            Z1328ConveHsPDiaDia = T003V3_A1328ConveHsPDiaDia[0] ;
            Z1329ConveHsPDiaDesde = T003V3_A1329ConveHsPDiaDesde[0] ;
            Z1330ConveTarifaPDia = T003V3_A1330ConveTarifaPDia[0] ;
            Z1350ConveTarifaPDRec = T003V3_A1350ConveTarifaPDRec[0] ;
            Z2432ConveTarifaPDCri = T003V3_A2432ConveTarifaPDCri[0] ;
            Z2066ConveHsPDiaRelSec = T003V3_A2066ConveHsPDiaRelSec[0] ;
            Z2067ConveHsPdiaRelRef = T003V3_A2067ConveHsPdiaRelRef[0] ;
            Z2430ConveHSPDiaConcepto = T003V3_A2430ConveHSPDiaConcepto[0] ;
         }
         else
         {
            Z1326ConvHsPDiaTipTra = A1326ConvHsPDiaTipTra ;
            Z1328ConveHsPDiaDia = A1328ConveHsPDiaDia ;
            Z1329ConveHsPDiaDesde = A1329ConveHsPDiaDesde ;
            Z1330ConveTarifaPDia = A1330ConveTarifaPDia ;
            Z1350ConveTarifaPDRec = A1350ConveTarifaPDRec ;
            Z2432ConveTarifaPDCri = A2432ConveTarifaPDCri ;
            Z2066ConveHsPDiaRelSec = A2066ConveHsPDiaRelSec ;
            Z2067ConveHsPdiaRelRef = A2067ConveHsPdiaRelRef ;
            Z2430ConveHSPDiaConcepto = A2430ConveHSPDiaConcepto ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z1327ConveHsExSec = A1327ConveHsExSec ;
         Z1326ConvHsPDiaTipTra = A1326ConvHsPDiaTipTra ;
         Z1328ConveHsPDiaDia = A1328ConveHsPDiaDia ;
         Z1329ConveHsPDiaDesde = A1329ConveHsPDiaDesde ;
         Z1330ConveTarifaPDia = A1330ConveTarifaPDia ;
         Z1350ConveTarifaPDRec = A1350ConveTarifaPDRec ;
         Z2432ConveTarifaPDCri = A2432ConveTarifaPDCri ;
         Z2066ConveHsPDiaRelSec = A2066ConveHsPDiaRelSec ;
         Z2067ConveHsPdiaRelRef = A2067ConveHsPdiaRelRef ;
         Z2068ConveHsPDiaOld = A2068ConveHsPDiaOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z2430ConveHSPDiaConcepto = A2430ConveHSPDiaConcepto ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconvehspdiarelsec_html3V215( AV7CliCod) ;
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
            convenio_horasextras_pordia_impl.this.GXt_int10 = GXv_int11[0] ;
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
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10ConveHsExSec) )
      {
         A1327ConveHsExSec = AV10ConveHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      }
      if ( ! (0==AV10ConveHsExSec) )
      {
         edtConveHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Enabled), 5, 0), true);
      }
      else
      {
         edtConveHsExSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10ConveHsExSec) )
      {
         edtConveHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_ConvHsPDiaTipTra)==0) )
      {
         cmbConvHsPDiaTipTra.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConvHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConvHsPDiaTipTra.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConvHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV29Insert_ConveHSPDiaConcepto)==0) )
      {
         A2430ConveHSPDiaConcepto = AV29Insert_ConveHSPDiaConcepto ;
         n2430ConveHSPDiaConcepto = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2430ConveHSPDiaConcepto", A2430ConveHSPDiaConcepto);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_ConvHsPDiaTipTra)==0) )
      {
         A1326ConvHsPDiaTipTra = AV16Insert_ConvHsPDiaTipTra ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      }
      else
      {
         A1326ConvHsPDiaTipTra = AV23ComboConvHsPDiaTipTra ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
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
         AV30Pgmname = "Convenio_horasextras_porDia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      }
   }

   public void load3V215( )
   {
      /* Using cursor T003V5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound215 = (short)(1) ;
         A1326ConvHsPDiaTipTra = T003V5_A1326ConvHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
         A1328ConveHsPDiaDia = T003V5_A1328ConveHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
         A1329ConveHsPDiaDesde = T003V5_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = T003V5_n1329ConveHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
         A1330ConveTarifaPDia = T003V5_A1330ConveTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
         A1350ConveTarifaPDRec = T003V5_A1350ConveTarifaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
         A2432ConveTarifaPDCri = T003V5_A2432ConveTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
         A2066ConveHsPDiaRelSec = T003V5_A2066ConveHsPDiaRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
         A2067ConveHsPdiaRelRef = T003V5_A2067ConveHsPdiaRelRef[0] ;
         A2068ConveHsPDiaOld = T003V5_A2068ConveHsPDiaOld[0] ;
         A2430ConveHSPDiaConcepto = T003V5_A2430ConveHSPDiaConcepto[0] ;
         n2430ConveHSPDiaConcepto = T003V5_n2430ConveHSPDiaConcepto[0] ;
         zm3V215( -28) ;
      }
      pr_default.close(3);
      onLoadActions3V215( ) ;
   }

   public void onLoadActions3V215( )
   {
      AV30Pgmname = "Convenio_horasextras_porDia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      if ( ! ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) ) )
      {
         divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
      }
      else
      {
         if ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) )
         {
            divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable3V215( )
   {
      nIsDirty_215 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV30Pgmname = "Convenio_horasextras_porDia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2066ConveHsPDiaRelSec, GXv_boolean5) ;
         convenio_horasextras_pordia_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
      }
      /* Using cursor T003V4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2430ConveHSPDiaConcepto), A2430ConveHSPDiaConcepto});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Hora Extra Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEHSPDIACONCEPTO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1326ConvHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1326ConvHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1326ConvHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConvHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1328ConveHsPDiaDia == 1 ) || ( A1328ConveHsPDiaDia == 2 ) || ( A1328ConveHsPDiaDia == 3 ) || ( A1328ConveHsPDiaDia == 4 ) || ( A1328ConveHsPDiaDia == 5 ) || ( A1328ConveHsPDiaDia == 6 ) || ( A1328ConveHsPDiaDia == 7 ) || ( A1328ConveHsPDiaDia == 8 ) || ( A1328ConveHsPDiaDia == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Día", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEHSPDIADIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveHsPDiaDia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) ) )
      {
         divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
      }
      else
      {
         if ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) )
         {
            divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
         }
      }
      if ( ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) ) && (0==A2066ConveHsPDiaRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEHSPDIADIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveHsPDiaDia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2432ConveTarifaPDCri, "exceso") == 0 ) || ( GXutil.strcmp(A2432ConveTarifaPDCri, "horario") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Criterio de aplicación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVETARIFAPDCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveTarifaPDCri.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors3V215( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_29( int A3CliCod ,
                          String A2430ConveHSPDiaConcepto )
   {
      /* Using cursor T003V6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2430ConveHSPDiaConcepto), A2430ConveHSPDiaConcepto});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A2430ConveHSPDiaConcepto)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Hora Extra Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEHSPDIACONCEPTO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
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

   public void getKey3V215( )
   {
      /* Using cursor T003V7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound215 = (short)(1) ;
      }
      else
      {
         RcdFound215 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003V3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3V215( 28) ;
         RcdFound215 = (short)(1) ;
         A1327ConveHsExSec = T003V3_A1327ConveHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
         A1326ConvHsPDiaTipTra = T003V3_A1326ConvHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
         A1328ConveHsPDiaDia = T003V3_A1328ConveHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
         A1329ConveHsPDiaDesde = T003V3_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = T003V3_n1329ConveHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
         A1330ConveTarifaPDia = T003V3_A1330ConveTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
         A1350ConveTarifaPDRec = T003V3_A1350ConveTarifaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
         A2432ConveTarifaPDCri = T003V3_A2432ConveTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
         A2066ConveHsPDiaRelSec = T003V3_A2066ConveHsPDiaRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
         A2067ConveHsPdiaRelRef = T003V3_A2067ConveHsPdiaRelRef[0] ;
         A2068ConveHsPDiaOld = T003V3_A2068ConveHsPDiaOld[0] ;
         A3CliCod = T003V3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T003V3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T003V3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A2430ConveHSPDiaConcepto = T003V3_A2430ConveHSPDiaConcepto[0] ;
         n2430ConveHSPDiaConcepto = T003V3_n2430ConveHSPDiaConcepto[0] ;
         O1350ConveTarifaPDRec = A1350ConveTarifaPDRec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
         O1330ConveTarifaPDia = A1330ConveTarifaPDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
         O1329ConveHsPDiaDesde = A1329ConveHsPDiaDesde ;
         n1329ConveHsPDiaDesde = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
         O1328ConveHsPDiaDia = A1328ConveHsPDiaDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1327ConveHsExSec = A1327ConveHsExSec ;
         sMode215 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3V215( ) ;
         if ( AnyError == 1 )
         {
            RcdFound215 = (short)(0) ;
            initializeNonKey3V215( ) ;
         }
         Gx_mode = sMode215 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound215 = (short)(0) ;
         initializeNonKey3V215( ) ;
         sMode215 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode215 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3V215( ) ;
      if ( RcdFound215 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound215 = (short)(0) ;
      /* Using cursor T003V8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Short.valueOf(A1327ConveHsExSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T003V8_A3CliCod[0] < A3CliCod ) || ( T003V8_A3CliCod[0] == A3CliCod ) && ( T003V8_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T003V8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003V8_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T003V8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T003V8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V8_A3CliCod[0] == A3CliCod ) && ( T003V8_A1327ConveHsExSec[0] < A1327ConveHsExSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T003V8_A3CliCod[0] > A3CliCod ) || ( T003V8_A3CliCod[0] == A3CliCod ) && ( T003V8_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T003V8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003V8_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T003V8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T003V8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V8_A3CliCod[0] == A3CliCod ) && ( T003V8_A1327ConveHsExSec[0] > A1327ConveHsExSec ) ) )
         {
            A3CliCod = T003V8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T003V8_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T003V8_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1327ConveHsExSec = T003V8_A1327ConveHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
            RcdFound215 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound215 = (short)(0) ;
      /* Using cursor T003V9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Short.valueOf(A1327ConveHsExSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T003V9_A3CliCod[0] > A3CliCod ) || ( T003V9_A3CliCod[0] == A3CliCod ) && ( T003V9_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T003V9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003V9_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T003V9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T003V9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V9_A3CliCod[0] == A3CliCod ) && ( T003V9_A1327ConveHsExSec[0] > A1327ConveHsExSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T003V9_A3CliCod[0] < A3CliCod ) || ( T003V9_A3CliCod[0] == A3CliCod ) && ( T003V9_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T003V9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003V9_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T003V9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T003V9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T003V9_A3CliCod[0] == A3CliCod ) && ( T003V9_A1327ConveHsExSec[0] < A1327ConveHsExSec ) ) )
         {
            A3CliCod = T003V9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T003V9_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T003V9_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1327ConveHsExSec = T003V9_A1327ConveHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
            RcdFound215 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3V215( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConveHsExSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3V215( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound215 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1327ConveHsExSec != Z1327ConveHsExSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1327ConveHsExSec = Z1327ConveHsExSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConveHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3V215( ) ;
               GX_FocusControl = edtConveHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1327ConveHsExSec != Z1327ConveHsExSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtConveHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3V215( ) ;
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
                  GX_FocusControl = edtConveHsExSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3V215( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1327ConveHsExSec != Z1327ConveHsExSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1327ConveHsExSec = Z1327ConveHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConveHsExSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3V215( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003V2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio_horasextras_porDia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1326ConvHsPDiaTipTra, T003V2_A1326ConvHsPDiaTipTra[0]) != 0 ) || ( Z1328ConveHsPDiaDia != T003V2_A1328ConveHsPDiaDia[0] ) || ( GXutil.strcmp(Z1329ConveHsPDiaDesde, T003V2_A1329ConveHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1330ConveTarifaPDia, T003V2_A1330ConveTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1350ConveTarifaPDRec, T003V2_A1350ConveTarifaPDRec[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2432ConveTarifaPDCri, T003V2_A2432ConveTarifaPDCri[0]) != 0 ) || ( Z2066ConveHsPDiaRelSec != T003V2_A2066ConveHsPDiaRelSec[0] ) || ( GXutil.strcmp(Z2067ConveHsPdiaRelRef, T003V2_A2067ConveHsPdiaRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2430ConveHSPDiaConcepto, T003V2_A2430ConveHSPDiaConcepto[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1326ConvHsPDiaTipTra, T003V2_A1326ConvHsPDiaTipTra[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConvHsPDiaTipTra");
               GXutil.writeLogRaw("Old: ",Z1326ConvHsPDiaTipTra);
               GXutil.writeLogRaw("Current: ",T003V2_A1326ConvHsPDiaTipTra[0]);
            }
            if ( Z1328ConveHsPDiaDia != T003V2_A1328ConveHsPDiaDia[0] )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveHsPDiaDia");
               GXutil.writeLogRaw("Old: ",Z1328ConveHsPDiaDia);
               GXutil.writeLogRaw("Current: ",T003V2_A1328ConveHsPDiaDia[0]);
            }
            if ( GXutil.strcmp(Z1329ConveHsPDiaDesde, T003V2_A1329ConveHsPDiaDesde[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveHsPDiaDesde");
               GXutil.writeLogRaw("Old: ",Z1329ConveHsPDiaDesde);
               GXutil.writeLogRaw("Current: ",T003V2_A1329ConveHsPDiaDesde[0]);
            }
            if ( DecimalUtil.compareTo(Z1330ConveTarifaPDia, T003V2_A1330ConveTarifaPDia[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveTarifaPDia");
               GXutil.writeLogRaw("Old: ",Z1330ConveTarifaPDia);
               GXutil.writeLogRaw("Current: ",T003V2_A1330ConveTarifaPDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1350ConveTarifaPDRec, T003V2_A1350ConveTarifaPDRec[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveTarifaPDRec");
               GXutil.writeLogRaw("Old: ",Z1350ConveTarifaPDRec);
               GXutil.writeLogRaw("Current: ",T003V2_A1350ConveTarifaPDRec[0]);
            }
            if ( GXutil.strcmp(Z2432ConveTarifaPDCri, T003V2_A2432ConveTarifaPDCri[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveTarifaPDCri");
               GXutil.writeLogRaw("Old: ",Z2432ConveTarifaPDCri);
               GXutil.writeLogRaw("Current: ",T003V2_A2432ConveTarifaPDCri[0]);
            }
            if ( Z2066ConveHsPDiaRelSec != T003V2_A2066ConveHsPDiaRelSec[0] )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveHsPDiaRelSec");
               GXutil.writeLogRaw("Old: ",Z2066ConveHsPDiaRelSec);
               GXutil.writeLogRaw("Current: ",T003V2_A2066ConveHsPDiaRelSec[0]);
            }
            if ( GXutil.strcmp(Z2067ConveHsPdiaRelRef, T003V2_A2067ConveHsPdiaRelRef[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveHsPdiaRelRef");
               GXutil.writeLogRaw("Old: ",Z2067ConveHsPdiaRelRef);
               GXutil.writeLogRaw("Current: ",T003V2_A2067ConveHsPdiaRelRef[0]);
            }
            if ( GXutil.strcmp(Z2430ConveHSPDiaConcepto, T003V2_A2430ConveHSPDiaConcepto[0]) != 0 )
            {
               GXutil.writeLogln("convenio_horasextras_pordia:[seudo value changed for attri]"+"ConveHSPDiaConcepto");
               GXutil.writeLogRaw("Old: ",Z2430ConveHSPDiaConcepto);
               GXutil.writeLogRaw("Current: ",T003V2_A2430ConveHSPDiaConcepto[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Convenio_horasextras_porDia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3V215( )
   {
      beforeValidate3V215( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3V215( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3V215( 0) ;
         checkOptimisticConcurrency3V215( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3V215( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3V215( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003V10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1327ConveHsExSec), A1326ConvHsPDiaTipTra, Byte.valueOf(A1328ConveHsPDiaDia), Boolean.valueOf(n1329ConveHsPDiaDesde), A1329ConveHsPDiaDesde, A1330ConveTarifaPDia, A1350ConveTarifaPDRec, A2432ConveTarifaPDCri, Integer.valueOf(A2066ConveHsPDiaRelSec), A2067ConveHsPdiaRelRef, A2068ConveHsPDiaOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Boolean.valueOf(n2430ConveHSPDiaConcepto), A2430ConveHSPDiaConcepto});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
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
                        resetCaption3V0( ) ;
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
            load3V215( ) ;
         }
         endLevel3V215( ) ;
      }
      closeExtendedTableCursors3V215( ) ;
   }

   public void update3V215( )
   {
      beforeValidate3V215( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3V215( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3V215( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3V215( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3V215( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003V11 */
                  pr_default.execute(9, new Object[] {A1326ConvHsPDiaTipTra, Byte.valueOf(A1328ConveHsPDiaDia), Boolean.valueOf(n1329ConveHsPDiaDesde), A1329ConveHsPDiaDesde, A1330ConveTarifaPDia, A1350ConveTarifaPDRec, A2432ConveTarifaPDCri, Integer.valueOf(A2066ConveHsPDiaRelSec), A2067ConveHsPdiaRelRef, A2068ConveHsPDiaOld, Boolean.valueOf(n2430ConveHSPDiaConcepto), A2430ConveHSPDiaConcepto, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio_horasextras_porDia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3V215( ) ;
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
         endLevel3V215( ) ;
      }
      closeExtendedTableCursors3V215( ) ;
   }

   public void deferredUpdate3V215( )
   {
   }

   public void delete( )
   {
      beforeValidate3V215( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3V215( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3V215( ) ;
         afterConfirm3V215( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3V215( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003V12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
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
      sMode215 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3V215( ) ;
      Gx_mode = sMode215 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3V215( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV26aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2066ConveHsPDiaRelSec, GXv_boolean5) ;
            convenio_horasextras_pordia_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
         }
         AV30Pgmname = "Convenio_horasextras_porDia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         if ( ! ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) ) )
         {
            divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
         }
         else
         {
            if ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) )
            {
               divConvehspdiarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConvehspdiarelsec_cell_Internalname, "Class", divConvehspdiarelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel3V215( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3V215( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio_horasextras_pordia");
         if ( AnyError == 0 )
         {
            confirmValues3V0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_horasextras_pordia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3V215( )
   {
      /* Scan By routine */
      /* Using cursor T003V13 */
      pr_default.execute(11);
      RcdFound215 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound215 = (short)(1) ;
         A3CliCod = T003V13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T003V13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T003V13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1327ConveHsExSec = T003V13_A1327ConveHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3V215( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound215 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound215 = (short)(1) ;
         A3CliCod = T003V13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T003V13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T003V13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1327ConveHsExSec = T003V13_A1327ConveHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      }
   }

   public void scanEnd3V215( )
   {
      pr_default.close(11);
   }

   public void afterConfirm3V215( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV26aplicadoHay ) && ! (0==A2066ConveHsPDiaRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveHsPDiaRelSec", 1, "CONVEHSPDIARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveHsPDiaRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert3V215( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3V215( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3V215( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3V215( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3V215( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3V215( )
   {
      edtConveHsExSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Enabled), 5, 0), true);
      cmbConvHsPDiaTipTra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConvHsPDiaTipTra.getEnabled(), 5, 0), true);
      cmbConveHsPDiaDia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveHsPDiaDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveHsPDiaDia.getEnabled(), 5, 0), true);
      edtConveHsPDiaDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsPDiaDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsPDiaDesde_Enabled), 5, 0), true);
      edtConveTarifaPDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveTarifaPDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveTarifaPDia_Enabled), 5, 0), true);
      edtConveTarifaPDRec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveTarifaPDRec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveTarifaPDRec_Enabled), 5, 0), true);
      cmbConveTarifaPDCri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveTarifaPDCri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveTarifaPDCri.getEnabled(), 5, 0), true);
      dynConveHsPDiaRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveHsPDiaRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveHsPDiaRelSec.getEnabled(), 5, 0), true);
      cmbavComboconvhspdiatiptra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconvhspdiatiptra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavComboconvhspdiatiptra.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3V215( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3V0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(AV10ConveHsExSec,4,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveHsExSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_horasextras_porDia");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveHsPdiaRelRef", GXutil.rtrim( localUtil.format( A2067ConveHsPdiaRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio_horasextras_pordia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1327ConveHsExSec", GXutil.ltrim( localUtil.ntoc( Z1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1326ConvHsPDiaTipTra", GXutil.rtrim( Z1326ConvHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1328ConveHsPDiaDia", GXutil.ltrim( localUtil.ntoc( Z1328ConveHsPDiaDia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1329ConveHsPDiaDesde", GXutil.rtrim( Z1329ConveHsPDiaDesde));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1330ConveTarifaPDia", GXutil.ltrim( localUtil.ntoc( Z1330ConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1350ConveTarifaPDRec", GXutil.ltrim( localUtil.ntoc( Z1350ConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2432ConveTarifaPDCri", GXutil.rtrim( Z2432ConveTarifaPDCri));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2066ConveHsPDiaRelSec", GXutil.ltrim( localUtil.ntoc( Z2066ConveHsPDiaRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2067ConveHsPdiaRelRef", Z2067ConveHsPdiaRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2430ConveHSPDiaConcepto", GXutil.rtrim( Z2430ConveHSPDiaConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "O1350ConveTarifaPDRec", GXutil.ltrim( localUtil.ntoc( O1350ConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1330ConveTarifaPDia", GXutil.ltrim( localUtil.ntoc( O1330ConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1329ConveHsPDiaDesde", GXutil.rtrim( O1329ConveHsPDiaDesde));
      web.GxWebStd.gx_hidden_field( httpContext, "O1328ConveHsPDiaDia", GXutil.ltrim( localUtil.ntoc( O1328ConveHsPDiaDia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1326ConvHsPDiaTipTra", GXutil.rtrim( A1326ConvHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "N2430ConveHSPDiaConcepto", GXutil.rtrim( A2430ConveHSPDiaConcepto));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONVHSPDIATIPTRA_DATA", AV18ConvHsPDiaTipTra_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONVHSPDIATIPTRA_DATA", AV18ConvHsPDiaTipTra_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEHSEXSEC", GXutil.ltrim( localUtil.ntoc( AV10ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ConveHsExSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONVHSPDIATIPTRA", GXutil.rtrim( AV16Insert_ConvHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONVEHSPDIACONCEPTO", GXutil.rtrim( AV29Insert_ConveHSPDiaConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEHSPDIACONCEPTO", GXutil.rtrim( A2430ConveHSPDiaConcepto));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV26aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEHSPDIARELREF", A2067ConveHsPdiaRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEHSPDIAOLD", A2068ConveHsPDiaOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV30Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Objectcall", GXutil.rtrim( Combo_convhspdiatiptra_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Cls", GXutil.rtrim( Combo_convhspdiatiptra_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Selectedvalue_set", GXutil.rtrim( Combo_convhspdiatiptra_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Selectedtext_set", GXutil.rtrim( Combo_convhspdiatiptra_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Enabled", GXutil.booltostr( Combo_convhspdiatiptra_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Datalistproc", GXutil.rtrim( Combo_convhspdiatiptra_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Datalistprocparametersprefix", GXutil.rtrim( Combo_convhspdiatiptra_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVHSPDIATIPTRA_Emptyitem", GXutil.booltostr( Combo_convhspdiatiptra_Emptyitem));
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
      return formatLink("web.convenio_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(AV10ConveHsExSec,4,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveHsExSec"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio_horasextras_porDia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio_horasextras_por Dia", "") ;
   }

   public void initializeNonKey3V215( )
   {
      A1326ConvHsPDiaTipTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      A2430ConveHSPDiaConcepto = "" ;
      n2430ConveHSPDiaConcepto = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2430ConveHSPDiaConcepto", A2430ConveHSPDiaConcepto);
      AV26aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
      A1328ConveHsPDiaDia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
      A1329ConveHsPDiaDesde = "" ;
      n1329ConveHsPDiaDesde = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
      n1329ConveHsPDiaDesde = ((GXutil.strcmp("", A1329ConveHsPDiaDesde)==0) ? true : false) ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
      A2432ConveTarifaPDCri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
      A2066ConveHsPDiaRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2066ConveHsPDiaRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2066ConveHsPDiaRelSec), 6, 0));
      A2067ConveHsPdiaRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2067ConveHsPdiaRelRef", A2067ConveHsPdiaRelRef);
      A2068ConveHsPDiaOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2068ConveHsPDiaOld", A2068ConveHsPDiaOld);
      O1350ConveTarifaPDRec = A1350ConveTarifaPDRec ;
      httpContext.ajax_rsp_assign_attri("", false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
      O1330ConveTarifaPDia = A1330ConveTarifaPDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
      O1329ConveHsPDiaDesde = A1329ConveHsPDiaDesde ;
      n1329ConveHsPDiaDesde = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
      O1328ConveHsPDiaDia = A1328ConveHsPDiaDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
      Z1326ConvHsPDiaTipTra = "" ;
      Z1328ConveHsPDiaDia = (byte)(0) ;
      Z1329ConveHsPDiaDesde = "" ;
      Z1330ConveTarifaPDia = DecimalUtil.ZERO ;
      Z1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      Z2432ConveTarifaPDCri = "" ;
      Z2066ConveHsPDiaRelSec = 0 ;
      Z2067ConveHsPdiaRelRef = "" ;
      Z2430ConveHSPDiaConcepto = "" ;
   }

   public void initAll3V215( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1327ConveHsExSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      initializeNonKey3V215( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818311363", true, true);
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
      httpContext.AddJavascriptSource("convenio_horasextras_pordia.js", "?20251818311363", false, true);
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
      edtConveHsExSec_Internalname = "CONVEHSEXSEC" ;
      lblTextblockconvhspdiatiptra_Internalname = "TEXTBLOCKCONVHSPDIATIPTRA" ;
      Combo_convhspdiatiptra_Internalname = "COMBO_CONVHSPDIATIPTRA" ;
      cmbConvHsPDiaTipTra.setInternalname( "CONVHSPDIATIPTRA" );
      divTablesplittedconvhspdiatiptra_Internalname = "TABLESPLITTEDCONVHSPDIATIPTRA" ;
      cmbConveHsPDiaDia.setInternalname( "CONVEHSPDIADIA" );
      edtConveHsPDiaDesde_Internalname = "CONVEHSPDIADESDE" ;
      edtConveTarifaPDia_Internalname = "CONVETARIFAPDIA" ;
      edtConveTarifaPDRec_Internalname = "CONVETARIFAPDREC" ;
      cmbConveTarifaPDCri.setInternalname( "CONVETARIFAPDCRI" );
      dynConveHsPDiaRelSec.setInternalname( "CONVEHSPDIARELSEC" );
      divConvehspdiarelsec_cell_Internalname = "CONVEHSPDIARELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      cmbavComboconvhspdiatiptra.setInternalname( "vCOMBOCONVHSPDIATIPTRA" );
      divSectionattribute_convhspdiatiptra_Internalname = "SECTIONATTRIBUTE_CONVHSPDIATIPTRA" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
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
      Form.setCaption( httpContext.getMessage( "Convenio_horasextras_por Dia", "") );
      Combo_convhspdiatiptra_Datalistprocparametersprefix = "" ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      cmbavComboconvhspdiatiptra.setJsonclick( "" );
      cmbavComboconvhspdiatiptra.setVisible( 1 );
      cmbavComboconvhspdiatiptra.setEnabled( 0 );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynConveHsPDiaRelSec.setJsonclick( "" );
      dynConveHsPDiaRelSec.setEnabled( 1 );
      divConvehspdiarelsec_cell_Class = "col-xs-12" ;
      cmbConveTarifaPDCri.setJsonclick( "" );
      cmbConveTarifaPDCri.setEnabled( 1 );
      edtConveTarifaPDRec_Jsonclick = "" ;
      edtConveTarifaPDRec_Enabled = 1 ;
      edtConveTarifaPDia_Jsonclick = "" ;
      edtConveTarifaPDia_Enabled = 1 ;
      edtConveHsPDiaDesde_Jsonclick = "" ;
      edtConveHsPDiaDesde_Enabled = 1 ;
      cmbConveHsPDiaDia.setJsonclick( "" );
      cmbConveHsPDiaDia.setEnabled( 1 );
      cmbConvHsPDiaTipTra.setJsonclick( "" );
      cmbConvHsPDiaTipTra.setVisible( 1 );
      cmbConvHsPDiaTipTra.setEnabled( 1 );
      Combo_convhspdiatiptra_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_convhspdiatiptra_Datalistproc = "Convenio_horasextras_porDiaLoadDVCombo" ;
      Combo_convhspdiatiptra_Cls = "ExtendedCombo Attribute" ;
      Combo_convhspdiatiptra_Caption = "" ;
      Combo_convhspdiatiptra_Enabled = GXutil.toBoolean( -1) ;
      edtConveHsExSec_Jsonclick = "" ;
      edtConveHsExSec_Enabled = 1 ;
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

   public void gxdlaconvehspdiarelsec3V215( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvehspdiarelsec_data3V215( AV7CliCod) ;
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

   public void gxaconvehspdiarelsec_html3V215( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconvehspdiarelsec_data3V215( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveHsPDiaRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveHsPDiaRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvehspdiarelsec_data3V215( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003V14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003V14_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003V14_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx6asaclicod3V215( int AV7CliCod )
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
            convenio_horasextras_pordia_impl.this.GXt_int10 = GXv_int11[0] ;
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

   public void xc_26_3V215( String Gx_mode ,
                            int AV7CliCod ,
                            int A2066ConveHsPDiaRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2066ConveHsPDiaRelSec, GXv_boolean5) ;
         AV26aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV26aplicadoHay))+"\"") ;
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
      cmbConvHsPDiaTipTra.setName( "CONVHSPDIATIPTRA" );
      cmbConvHsPDiaTipTra.setWebtags( "" );
      cmbConvHsPDiaTipTra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbConvHsPDiaTipTra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbConvHsPDiaTipTra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbConvHsPDiaTipTra.getItemCount() > 0 )
      {
         A1326ConvHsPDiaTipTra = cmbConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      }
      cmbConveHsPDiaDia.setName( "CONVEHSPDIADIA" );
      cmbConveHsPDiaDia.setWebtags( "" );
      cmbConveHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbConveHsPDiaDia.getItemCount() > 0 )
      {
         A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
      }
      cmbConveTarifaPDCri.setName( "CONVETARIFAPDCRI" );
      cmbConveTarifaPDCri.setWebtags( "" );
      cmbConveTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbConveTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbConveTarifaPDCri.getItemCount() > 0 )
      {
         A2432ConveTarifaPDCri = cmbConveTarifaPDCri.getValidValue(A2432ConveTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
      }
      dynConveHsPDiaRelSec.setName( "CONVEHSPDIARELSEC" );
      dynConveHsPDiaRelSec.setWebtags( "" );
      cmbavComboconvhspdiatiptra.setName( "vCOMBOCONVHSPDIATIPTRA" );
      cmbavComboconvhspdiatiptra.setWebtags( "" );
      cmbavComboconvhspdiatiptra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbavComboconvhspdiatiptra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbavComboconvhspdiatiptra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbavComboconvhspdiatiptra.getItemCount() > 0 )
      {
         AV23ComboConvHsPDiaTipTra = cmbavComboconvhspdiatiptra.getValidValue(AV23ComboConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ComboConvHsPDiaTipTra", AV23ComboConvHsPDiaTipTra);
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

   public void valid_Convehspdiarelsec( )
   {
      A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValue())) ;
      n1329ConveHsPDiaDesde = false ;
      A2066ConveHsPDiaRelSec = (int)(GXutil.lval( dynConveHsPDiaRelSec.getValue())) ;
      if ( ( ( A1328ConveHsPDiaDia != O1328ConveHsPDiaDia ) || ( GXutil.strcmp(A1329ConveHsPDiaDesde, O1329ConveHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1330ConveTarifaPDia, O1330ConveTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1350ConveTarifaPDRec, O1350ConveTarifaPDRec) != 0 ) ) && (0==A2066ConveHsPDiaRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEHSPDIARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveHsPDiaRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2066ConveHsPDiaRelSec, GXv_boolean5) ;
         convenio_horasextras_pordia_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
         AV26aplicadoHay = this.AV26aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveHsExSec',fld:'vCONVEHSEXSEC',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveHsExSec',fld:'vCONVEHSEXSEC',pic:'ZZZ9',hsh:true},{av:'A2067ConveHsPdiaRelRef',fld:'CONVEHSPDIARELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e123V2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEHSEXSEC","{handler:'valid_Convehsexsec',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEHSEXSEC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVHSPDIATIPTRA","{handler:'valid_Convhspdiatiptra',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVHSPDIATIPTRA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEHSPDIADIA","{handler:'valid_Convehspdiadia',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEHSPDIADIA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEHSPDIADESDE","{handler:'valid_Convehspdiadesde',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEHSPDIADESDE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVETARIFAPDIA","{handler:'valid_Convetarifapdia',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVETARIFAPDIA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVETARIFAPDREC","{handler:'valid_Convetarifapdrec',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVETARIFAPDREC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVETARIFAPDCRI","{handler:'valid_Convetarifapdcri',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVETARIFAPDCRI",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEHSPDIARELSEC","{handler:'valid_Convehspdiarelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1350ConveTarifaPDRec'},{av:'O1330ConveTarifaPDia'},{av:'O1329ConveHsPDiaDesde'},{av:'O1328ConveHsPDiaDia'},{av:'cmbConveHsPDiaDia'},{av:'A1328ConveHsPDiaDia',fld:'CONVEHSPDIADIA',pic:'9'},{av:'A1329ConveHsPDiaDesde',fld:'CONVEHSPDIADESDE',pic:''},{av:'A1330ConveTarifaPDia',fld:'CONVETARIFAPDIA',pic:'9.9999'},{av:'A1350ConveTarifaPDRec',fld:'CONVETARIFAPDREC',pic:'9.9999'},{av:'AV26aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEHSPDIARELSEC",",oparms:[{av:'AV26aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOCONVHSPDIATIPTRA","{handler:'validv_Comboconvhspdiatiptra',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOCONVHSPDIATIPTRA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveHsPDiaRelSec'},{av:'A2066ConveHsPDiaRelSec',fld:'CONVEHSPDIARELSEC',pic:'ZZZZZ9'}]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      Z1565CliConvenio = "" ;
      Z1326ConvHsPDiaTipTra = "" ;
      Z1329ConveHsPDiaDesde = "" ;
      Z1330ConveTarifaPDia = DecimalUtil.ZERO ;
      Z1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      Z2432ConveTarifaPDCri = "" ;
      Z2067ConveHsPdiaRelRef = "" ;
      Z2430ConveHSPDiaConcepto = "" ;
      O1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      O1330ConveTarifaPDia = DecimalUtil.ZERO ;
      O1329ConveHsPDiaDesde = "" ;
      N1326ConvHsPDiaTipTra = "" ;
      N2430ConveHSPDiaConcepto = "" ;
      Combo_convhspdiatiptra_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A2430ConveHSPDiaConcepto = "" ;
      AV9CliConvenio = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A2432ConveTarifaPDCri = "" ;
      AV23ComboConvHsPDiaTipTra = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      lblTextblockconvhspdiatiptra_Jsonclick = "" ;
      ucCombo_convhspdiatiptra = new com.genexus.webpanels.GXUserControl();
      AV19DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV18ConvHsPDiaTipTra_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1565CliConvenio = "" ;
      A2067ConveHsPdiaRelRef = "" ;
      AV16Insert_ConvHsPDiaTipTra = "" ;
      AV29Insert_ConveHSPDiaConcepto = "" ;
      A2068ConveHsPDiaOld = "" ;
      AV30Pgmname = "" ;
      Combo_convhspdiatiptra_Objectcall = "" ;
      Combo_convhspdiatiptra_Class = "" ;
      Combo_convhspdiatiptra_Icontype = "" ;
      Combo_convhspdiatiptra_Icon = "" ;
      Combo_convhspdiatiptra_Tooltip = "" ;
      Combo_convhspdiatiptra_Selectedvalue_set = "" ;
      Combo_convhspdiatiptra_Selectedtext_set = "" ;
      Combo_convhspdiatiptra_Selectedtext_get = "" ;
      Combo_convhspdiatiptra_Gamoauthtoken = "" ;
      Combo_convhspdiatiptra_Ddointernalname = "" ;
      Combo_convhspdiatiptra_Titlecontrolalign = "" ;
      Combo_convhspdiatiptra_Dropdownoptionstype = "" ;
      Combo_convhspdiatiptra_Titlecontrolidtoreplace = "" ;
      Combo_convhspdiatiptra_Datalisttype = "" ;
      Combo_convhspdiatiptra_Datalistfixedvalues = "" ;
      Combo_convhspdiatiptra_Remoteservicesparameters = "" ;
      Combo_convhspdiatiptra_Htmltemplate = "" ;
      Combo_convhspdiatiptra_Multiplevaluestype = "" ;
      Combo_convhspdiatiptra_Loadingdata = "" ;
      Combo_convhspdiatiptra_Noresultsfound = "" ;
      Combo_convhspdiatiptra_Emptyitemtext = "" ;
      Combo_convhspdiatiptra_Onlyselectedvalues = "" ;
      Combo_convhspdiatiptra_Selectalltext = "" ;
      Combo_convhspdiatiptra_Multiplevaluesseparator = "" ;
      Combo_convhspdiatiptra_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode215 = "" ;
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
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV22Combo_DataJson = "" ;
      AV25Insert_CliConvenio = "" ;
      AV20ComboSelectedValue = "" ;
      AV21ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z2068ConveHsPDiaOld = "" ;
      T003V5_A1327ConveHsExSec = new short[1] ;
      T003V5_A1326ConvHsPDiaTipTra = new String[] {""} ;
      T003V5_A1328ConveHsPDiaDia = new byte[1] ;
      T003V5_A1329ConveHsPDiaDesde = new String[] {""} ;
      T003V5_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      T003V5_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V5_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V5_A2432ConveTarifaPDCri = new String[] {""} ;
      T003V5_A2066ConveHsPDiaRelSec = new int[1] ;
      T003V5_A2067ConveHsPdiaRelRef = new String[] {""} ;
      T003V5_A2068ConveHsPDiaOld = new String[] {""} ;
      T003V5_A3CliCod = new int[1] ;
      T003V5_A1564CliPaiConve = new short[1] ;
      T003V5_A1565CliConvenio = new String[] {""} ;
      T003V5_A2430ConveHSPDiaConcepto = new String[] {""} ;
      T003V5_n2430ConveHSPDiaConcepto = new boolean[] {false} ;
      T003V4_A3CliCod = new int[1] ;
      T003V6_A3CliCod = new int[1] ;
      T003V7_A3CliCod = new int[1] ;
      T003V7_A1564CliPaiConve = new short[1] ;
      T003V7_A1565CliConvenio = new String[] {""} ;
      T003V7_A1327ConveHsExSec = new short[1] ;
      T003V3_A1327ConveHsExSec = new short[1] ;
      T003V3_A1326ConvHsPDiaTipTra = new String[] {""} ;
      T003V3_A1328ConveHsPDiaDia = new byte[1] ;
      T003V3_A1329ConveHsPDiaDesde = new String[] {""} ;
      T003V3_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      T003V3_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V3_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V3_A2432ConveTarifaPDCri = new String[] {""} ;
      T003V3_A2066ConveHsPDiaRelSec = new int[1] ;
      T003V3_A2067ConveHsPdiaRelRef = new String[] {""} ;
      T003V3_A2068ConveHsPDiaOld = new String[] {""} ;
      T003V3_A3CliCod = new int[1] ;
      T003V3_A1564CliPaiConve = new short[1] ;
      T003V3_A1565CliConvenio = new String[] {""} ;
      T003V3_A2430ConveHSPDiaConcepto = new String[] {""} ;
      T003V3_n2430ConveHSPDiaConcepto = new boolean[] {false} ;
      T003V8_A3CliCod = new int[1] ;
      T003V8_A1564CliPaiConve = new short[1] ;
      T003V8_A1565CliConvenio = new String[] {""} ;
      T003V8_A1327ConveHsExSec = new short[1] ;
      T003V9_A3CliCod = new int[1] ;
      T003V9_A1564CliPaiConve = new short[1] ;
      T003V9_A1565CliConvenio = new String[] {""} ;
      T003V9_A1327ConveHsExSec = new short[1] ;
      T003V2_A1327ConveHsExSec = new short[1] ;
      T003V2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      T003V2_A1328ConveHsPDiaDia = new byte[1] ;
      T003V2_A1329ConveHsPDiaDesde = new String[] {""} ;
      T003V2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      T003V2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003V2_A2432ConveTarifaPDCri = new String[] {""} ;
      T003V2_A2066ConveHsPDiaRelSec = new int[1] ;
      T003V2_A2067ConveHsPdiaRelRef = new String[] {""} ;
      T003V2_A2068ConveHsPDiaOld = new String[] {""} ;
      T003V2_A3CliCod = new int[1] ;
      T003V2_A1564CliPaiConve = new short[1] ;
      T003V2_A1565CliConvenio = new String[] {""} ;
      T003V2_A2430ConveHSPDiaConcepto = new String[] {""} ;
      T003V2_n2430ConveHSPDiaConcepto = new boolean[] {false} ;
      T003V13_A3CliCod = new int[1] ;
      T003V13_A1564CliPaiConve = new short[1] ;
      T003V13_A1565CliConvenio = new String[] {""} ;
      T003V13_A1327ConveHsExSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003V14_A3CliCod = new int[1] ;
      T003V14_A1885CliRelSec = new int[1] ;
      T003V14_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_horasextras_pordia__default(),
         new Object[] {
             new Object[] {
            T003V2_A1327ConveHsExSec, T003V2_A1326ConvHsPDiaTipTra, T003V2_A1328ConveHsPDiaDia, T003V2_A1329ConveHsPDiaDesde, T003V2_n1329ConveHsPDiaDesde, T003V2_A1330ConveTarifaPDia, T003V2_A1350ConveTarifaPDRec, T003V2_A2432ConveTarifaPDCri, T003V2_A2066ConveHsPDiaRelSec, T003V2_A2067ConveHsPdiaRelRef,
            T003V2_A2068ConveHsPDiaOld, T003V2_A3CliCod, T003V2_A1564CliPaiConve, T003V2_A1565CliConvenio, T003V2_A2430ConveHSPDiaConcepto, T003V2_n2430ConveHSPDiaConcepto
            }
            , new Object[] {
            T003V3_A1327ConveHsExSec, T003V3_A1326ConvHsPDiaTipTra, T003V3_A1328ConveHsPDiaDia, T003V3_A1329ConveHsPDiaDesde, T003V3_n1329ConveHsPDiaDesde, T003V3_A1330ConveTarifaPDia, T003V3_A1350ConveTarifaPDRec, T003V3_A2432ConveTarifaPDCri, T003V3_A2066ConveHsPDiaRelSec, T003V3_A2067ConveHsPdiaRelRef,
            T003V3_A2068ConveHsPDiaOld, T003V3_A3CliCod, T003V3_A1564CliPaiConve, T003V3_A1565CliConvenio, T003V3_A2430ConveHSPDiaConcepto, T003V3_n2430ConveHSPDiaConcepto
            }
            , new Object[] {
            T003V4_A3CliCod
            }
            , new Object[] {
            T003V5_A1327ConveHsExSec, T003V5_A1326ConvHsPDiaTipTra, T003V5_A1328ConveHsPDiaDia, T003V5_A1329ConveHsPDiaDesde, T003V5_n1329ConveHsPDiaDesde, T003V5_A1330ConveTarifaPDia, T003V5_A1350ConveTarifaPDRec, T003V5_A2432ConveTarifaPDCri, T003V5_A2066ConveHsPDiaRelSec, T003V5_A2067ConveHsPdiaRelRef,
            T003V5_A2068ConveHsPDiaOld, T003V5_A3CliCod, T003V5_A1564CliPaiConve, T003V5_A1565CliConvenio, T003V5_A2430ConveHSPDiaConcepto, T003V5_n2430ConveHSPDiaConcepto
            }
            , new Object[] {
            T003V6_A3CliCod
            }
            , new Object[] {
            T003V7_A3CliCod, T003V7_A1564CliPaiConve, T003V7_A1565CliConvenio, T003V7_A1327ConveHsExSec
            }
            , new Object[] {
            T003V8_A3CliCod, T003V8_A1564CliPaiConve, T003V8_A1565CliConvenio, T003V8_A1327ConveHsExSec
            }
            , new Object[] {
            T003V9_A3CliCod, T003V9_A1564CliPaiConve, T003V9_A1565CliConvenio, T003V9_A1327ConveHsExSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003V13_A3CliCod, T003V13_A1564CliPaiConve, T003V13_A1565CliConvenio, T003V13_A1327ConveHsExSec
            }
            , new Object[] {
            T003V14_A3CliCod, T003V14_A1885CliRelSec, T003V14_A1880CliReDTChar
            }
         }
      );
      AV30Pgmname = "Convenio_horasextras_porDia" ;
   }

   private byte Z1328ConveHsPDiaDia ;
   private byte O1328ConveHsPDiaDia ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1328ConveHsPDiaDia ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short wcpOAV10ConveHsExSec ;
   private short Z1564CliPaiConve ;
   private short Z1327ConveHsExSec ;
   private short AV8CliPaiConve ;
   private short AV10ConveHsExSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1327ConveHsExSec ;
   private short A1564CliPaiConve ;
   private short RcdFound215 ;
   private short AV28Insert_CliPaiConve ;
   private short nIsDirty_215 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2066ConveHsPDiaRelSec ;
   private int AV7CliCod ;
   private int A2066ConveHsPDiaRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveHsExSec_Enabled ;
   private int edtConveHsPDiaDesde_Enabled ;
   private int edtConveTarifaPDia_Enabled ;
   private int edtConveTarifaPDRec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int Combo_convhspdiatiptra_Datalistupdateminimumcharacters ;
   private int Combo_convhspdiatiptra_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV31GXV1 ;
   private int AV27Insert_CliCod ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z1330ConveTarifaPDia ;
   private java.math.BigDecimal Z1350ConveTarifaPDRec ;
   private java.math.BigDecimal O1350ConveTarifaPDRec ;
   private java.math.BigDecimal O1330ConveTarifaPDia ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String Z1565CliConvenio ;
   private String Z1326ConvHsPDiaTipTra ;
   private String Z1329ConveHsPDiaDesde ;
   private String Z2432ConveTarifaPDCri ;
   private String Z2430ConveHSPDiaConcepto ;
   private String O1329ConveHsPDiaDesde ;
   private String N1326ConvHsPDiaTipTra ;
   private String N2430ConveHSPDiaConcepto ;
   private String Combo_convhspdiatiptra_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A2430ConveHSPDiaConcepto ;
   private String AV9CliConvenio ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtConveHsExSec_Internalname ;
   private String A1326ConvHsPDiaTipTra ;
   private String A2432ConveTarifaPDCri ;
   private String AV23ComboConvHsPDiaTipTra ;
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
   private String edtConveHsExSec_Jsonclick ;
   private String divTablesplittedconvhspdiatiptra_Internalname ;
   private String lblTextblockconvhspdiatiptra_Internalname ;
   private String lblTextblockconvhspdiatiptra_Jsonclick ;
   private String Combo_convhspdiatiptra_Caption ;
   private String Combo_convhspdiatiptra_Cls ;
   private String Combo_convhspdiatiptra_Datalistproc ;
   private String Combo_convhspdiatiptra_Internalname ;
   private String edtConveHsPDiaDesde_Internalname ;
   private String A1329ConveHsPDiaDesde ;
   private String edtConveHsPDiaDesde_Jsonclick ;
   private String edtConveTarifaPDia_Internalname ;
   private String edtConveTarifaPDia_Jsonclick ;
   private String edtConveTarifaPDRec_Internalname ;
   private String edtConveTarifaPDRec_Jsonclick ;
   private String divConvehspdiarelsec_cell_Internalname ;
   private String divConvehspdiarelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_convhspdiatiptra_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String A1565CliConvenio ;
   private String edtCliConvenio_Jsonclick ;
   private String AV16Insert_ConvHsPDiaTipTra ;
   private String AV29Insert_ConveHSPDiaConcepto ;
   private String AV30Pgmname ;
   private String Combo_convhspdiatiptra_Objectcall ;
   private String Combo_convhspdiatiptra_Class ;
   private String Combo_convhspdiatiptra_Icontype ;
   private String Combo_convhspdiatiptra_Icon ;
   private String Combo_convhspdiatiptra_Tooltip ;
   private String Combo_convhspdiatiptra_Selectedvalue_set ;
   private String Combo_convhspdiatiptra_Selectedtext_set ;
   private String Combo_convhspdiatiptra_Selectedtext_get ;
   private String Combo_convhspdiatiptra_Gamoauthtoken ;
   private String Combo_convhspdiatiptra_Ddointernalname ;
   private String Combo_convhspdiatiptra_Titlecontrolalign ;
   private String Combo_convhspdiatiptra_Dropdownoptionstype ;
   private String Combo_convhspdiatiptra_Titlecontrolidtoreplace ;
   private String Combo_convhspdiatiptra_Datalisttype ;
   private String Combo_convhspdiatiptra_Datalistfixedvalues ;
   private String Combo_convhspdiatiptra_Datalistprocparametersprefix ;
   private String Combo_convhspdiatiptra_Remoteservicesparameters ;
   private String Combo_convhspdiatiptra_Htmltemplate ;
   private String Combo_convhspdiatiptra_Multiplevaluestype ;
   private String Combo_convhspdiatiptra_Loadingdata ;
   private String Combo_convhspdiatiptra_Noresultsfound ;
   private String Combo_convhspdiatiptra_Emptyitemtext ;
   private String Combo_convhspdiatiptra_Onlyselectedvalues ;
   private String Combo_convhspdiatiptra_Selectalltext ;
   private String Combo_convhspdiatiptra_Multiplevaluesseparator ;
   private String Combo_convhspdiatiptra_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode215 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV25Insert_CliConvenio ;
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
   private boolean n2430ConveHSPDiaConcepto ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_convhspdiatiptra_Emptyitem ;
   private boolean n1329ConveHsPDiaDesde ;
   private boolean AV26aplicadoHay ;
   private boolean Combo_convhspdiatiptra_Enabled ;
   private boolean Combo_convhspdiatiptra_Visible ;
   private boolean Combo_convhspdiatiptra_Allowmultipleselection ;
   private boolean Combo_convhspdiatiptra_Isgriditem ;
   private boolean Combo_convhspdiatiptra_Hasdescription ;
   private boolean Combo_convhspdiatiptra_Includeonlyselectedoption ;
   private boolean Combo_convhspdiatiptra_Includeselectalloption ;
   private boolean Combo_convhspdiatiptra_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV26aplicadoHay ;
   private String A2068ConveHsPDiaOld ;
   private String AV22Combo_DataJson ;
   private String Z2068ConveHsPDiaOld ;
   private String Z2067ConveHsPdiaRelRef ;
   private String A2067ConveHsPdiaRelRef ;
   private String AV20ComboSelectedValue ;
   private String AV21ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_convhspdiatiptra ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConvHsPDiaTipTra ;
   private HTMLChoice cmbConveHsPDiaDia ;
   private HTMLChoice cmbConveTarifaPDCri ;
   private HTMLChoice dynConveHsPDiaRelSec ;
   private HTMLChoice cmbavComboconvhspdiatiptra ;
   private IDataStoreProvider pr_default ;
   private short[] T003V5_A1327ConveHsExSec ;
   private String[] T003V5_A1326ConvHsPDiaTipTra ;
   private byte[] T003V5_A1328ConveHsPDiaDia ;
   private String[] T003V5_A1329ConveHsPDiaDesde ;
   private boolean[] T003V5_n1329ConveHsPDiaDesde ;
   private java.math.BigDecimal[] T003V5_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] T003V5_A1350ConveTarifaPDRec ;
   private String[] T003V5_A2432ConveTarifaPDCri ;
   private int[] T003V5_A2066ConveHsPDiaRelSec ;
   private String[] T003V5_A2067ConveHsPdiaRelRef ;
   private String[] T003V5_A2068ConveHsPDiaOld ;
   private int[] T003V5_A3CliCod ;
   private short[] T003V5_A1564CliPaiConve ;
   private String[] T003V5_A1565CliConvenio ;
   private String[] T003V5_A2430ConveHSPDiaConcepto ;
   private boolean[] T003V5_n2430ConveHSPDiaConcepto ;
   private int[] T003V4_A3CliCod ;
   private int[] T003V6_A3CliCod ;
   private int[] T003V7_A3CliCod ;
   private short[] T003V7_A1564CliPaiConve ;
   private String[] T003V7_A1565CliConvenio ;
   private short[] T003V7_A1327ConveHsExSec ;
   private short[] T003V3_A1327ConveHsExSec ;
   private String[] T003V3_A1326ConvHsPDiaTipTra ;
   private byte[] T003V3_A1328ConveHsPDiaDia ;
   private String[] T003V3_A1329ConveHsPDiaDesde ;
   private boolean[] T003V3_n1329ConveHsPDiaDesde ;
   private java.math.BigDecimal[] T003V3_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] T003V3_A1350ConveTarifaPDRec ;
   private String[] T003V3_A2432ConveTarifaPDCri ;
   private int[] T003V3_A2066ConveHsPDiaRelSec ;
   private String[] T003V3_A2067ConveHsPdiaRelRef ;
   private String[] T003V3_A2068ConveHsPDiaOld ;
   private int[] T003V3_A3CliCod ;
   private short[] T003V3_A1564CliPaiConve ;
   private String[] T003V3_A1565CliConvenio ;
   private String[] T003V3_A2430ConveHSPDiaConcepto ;
   private boolean[] T003V3_n2430ConveHSPDiaConcepto ;
   private int[] T003V8_A3CliCod ;
   private short[] T003V8_A1564CliPaiConve ;
   private String[] T003V8_A1565CliConvenio ;
   private short[] T003V8_A1327ConveHsExSec ;
   private int[] T003V9_A3CliCod ;
   private short[] T003V9_A1564CliPaiConve ;
   private String[] T003V9_A1565CliConvenio ;
   private short[] T003V9_A1327ConveHsExSec ;
   private short[] T003V2_A1327ConveHsExSec ;
   private String[] T003V2_A1326ConvHsPDiaTipTra ;
   private byte[] T003V2_A1328ConveHsPDiaDia ;
   private String[] T003V2_A1329ConveHsPDiaDesde ;
   private boolean[] T003V2_n1329ConveHsPDiaDesde ;
   private java.math.BigDecimal[] T003V2_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] T003V2_A1350ConveTarifaPDRec ;
   private String[] T003V2_A2432ConveTarifaPDCri ;
   private int[] T003V2_A2066ConveHsPDiaRelSec ;
   private String[] T003V2_A2067ConveHsPdiaRelRef ;
   private String[] T003V2_A2068ConveHsPDiaOld ;
   private int[] T003V2_A3CliCod ;
   private short[] T003V2_A1564CliPaiConve ;
   private String[] T003V2_A1565CliConvenio ;
   private String[] T003V2_A2430ConveHSPDiaConcepto ;
   private boolean[] T003V2_n2430ConveHSPDiaConcepto ;
   private int[] T003V13_A3CliCod ;
   private short[] T003V13_A1564CliPaiConve ;
   private String[] T003V13_A1565CliConvenio ;
   private short[] T003V13_A1327ConveHsExSec ;
   private int[] T003V14_A3CliCod ;
   private int[] T003V14_A1885CliRelSec ;
   private String[] T003V14_A1880CliReDTChar ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18ConvHsPDiaTipTra_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class convenio_horasextras_pordia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003V2", "SELECT ConveHsExSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec, ConveTarifaPDCri, ConveHsPDiaRelSec, ConveHsPdiaRelRef, ConveHsPDiaOld, CliCod, CliPaiConve, CliConvenio, ConveHSPDiaConcepto FROM Convenio_horasextras_porDia WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ?  FOR UPDATE OF Convenio_horasextras_porDia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V3", "SELECT ConveHsExSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec, ConveTarifaPDCri, ConveHsPDiaRelSec, ConveHsPdiaRelRef, ConveHsPDiaOld, CliCod, CliPaiConve, CliConvenio, ConveHSPDiaConcepto FROM Convenio_horasextras_porDia WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V4", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V5", "SELECT TM1.ConveHsExSec, TM1.ConvHsPDiaTipTra, TM1.ConveHsPDiaDia, TM1.ConveHsPDiaDesde, TM1.ConveTarifaPDia, TM1.ConveTarifaPDRec, TM1.ConveTarifaPDCri, TM1.ConveHsPDiaRelSec, TM1.ConveHsPdiaRelRef, TM1.ConveHsPDiaOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveHSPDiaConcepto AS ConveHSPDiaConcepto FROM Convenio_horasextras_porDia TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveHsExSec = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V6", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V7", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V8", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveHsExSec > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003V9", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveHsExSec < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveHsExSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003V10", "SAVEPOINT gxupdate;INSERT INTO Convenio_horasextras_porDia(ConveHsExSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec, ConveTarifaPDCri, ConveHsPDiaRelSec, ConveHsPdiaRelRef, ConveHsPDiaOld, CliCod, CliPaiConve, CliConvenio, ConveHSPDiaConcepto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003V11", "SAVEPOINT gxupdate;UPDATE Convenio_horasextras_porDia SET ConvHsPDiaTipTra=?, ConveHsPDiaDia=?, ConveHsPDiaDesde=?, ConveTarifaPDia=?, ConveTarifaPDRec=?, ConveTarifaPDCri=?, ConveHsPDiaRelSec=?, ConveHsPdiaRelRef=?, ConveHsPDiaOld=?, ConveHSPDiaConcepto=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003V12", "SAVEPOINT gxupdate;DELETE FROM Convenio_horasextras_porDia  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003V13", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003V14", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 5);
               }
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setVarchar(9, (String)parms[9], 40, false);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               stmt.setInt(11, ((Number) parms[11]).intValue());
               stmt.setShort(12, ((Number) parms[12]).shortValue());
               stmt.setString(13, (String)parms[13], 20);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 10);
               }
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[11], 10);
               }
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setString(13, (String)parms[14], 20);
               stmt.setShort(14, ((Number) parms[15]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

